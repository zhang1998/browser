package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.util.Log;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareLoadPatchResult;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.uc.apollo.impl.SettingsConst;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ProGuard */
public class TinkerDexLoader {
    private static final String DEFAULT_DEX_OPTIMIZE_PATH = "odex";
    private static final String DEX_MEAT_FILE = "assets/dex_meta.txt";
    private static final String DEX_PATH = "dex";
    private static final String INTERPRET_DEX_OPTIMIZE_PATH = "interpret";
    private static final String TAG = "Tinker.TinkerDexLoader";
    private static final boolean isVmArt = ShareTinkerInternals.isVmArt();
    private SystemClassLoaderAdder classLoaderAdder;
    private HashSet<ShareDexDiffPatchInfo> classNDexInfo = new HashSet();
    private String dexFileDir = null;
    private ArrayList<ShareDexDiffPatchInfo> dexList = new ArrayList();
    private boolean enableClassN;
    private int multiDexIndex;
    private String oDexFileDir = null;
    private int patchDexCount = 0;
    private File testOptDexFile = null;

    public TinkerDexLoader(boolean z, int i) {
        this.enableClassN = z;
        this.multiDexIndex = i;
        this.classLoaderAdder = new SystemClassLoaderAdder();
    }

    @TargetApi(14)
    public boolean loadTinkerJars(Application application, boolean z, String str, String str2, boolean z2, ShareLoadPatchResult shareLoadPatchResult) {
        if (this.dexList.isEmpty() && this.classNDexInfo.isEmpty()) {
            Log.w(TAG, "there is no dex to load");
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerDexLoader.class.getClassLoader();
        if (pathClassLoader != null) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo;
            new StringBuilder("classloader: ").append(pathClassLoader.toString());
            String str3 = str + "/dex/";
            Object arrayList = new ArrayList();
            ShareTinkerInternals.isVmArt();
            Iterator it = this.dexList.iterator();
            while (it.hasNext()) {
                shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                if (!isJustArtSupportDex(shareDexDiffPatchInfo)) {
                    File file = new File(str3 + shareDexDiffPatchInfo.realName);
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SharePatchFileUtil.verifyDexFileMd5(file, getInfoMd5(shareDexDiffPatchInfo))) {
                            new StringBuilder("verify dex file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
                        } else {
                            shareLoadPatchResult.errorCode = -13;
                            return false;
                        }
                    }
                    arrayList.add(file);
                }
            }
            if (isVmArt && !this.classNDexInfo.isEmpty()) {
                File file2 = new File(str3 + ShareConstants.CLASS_N_APK_NAME);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (z) {
                    Iterator it2 = this.classNDexInfo.iterator();
                    while (it2.hasNext()) {
                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it2.next();
                        if (!SharePatchFileUtil.verifyDexFileMd5(file2, shareDexDiffPatchInfo.rawName, shareDexDiffPatchInfo.destMd5InArt)) {
                            shareLoadPatchResult.errorCode = -27;
                            return false;
                        }
                    }
                }
                new StringBuilder("verify dex file:").append(file2.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis2);
                arrayList.add(file2);
            }
            File file3 = new File(str + "/" + str2);
            if (z2) {
                final boolean[] zArr = new boolean[]{true};
                final Throwable[] thArr = new Throwable[1];
                try {
                    String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                    deleteOutOfDateOATFile(str);
                    Log.w(TAG, "systemOTA, try parallel oat dexes, targetISA:" + currentInstructionSet);
                    file3 = new File(str + "/interpret");
                    TinkerDexOptimizer.optimizeAll(arrayList, file3, true, currentInstructionSet, new ResultCallback() {
                        long start;

                        public void onStart(File file, File file2) {
                            this.start = System.currentTimeMillis();
                            new StringBuilder("start to optimize dex:").append(file.getPath());
                        }

                        public void onSuccess(File file, File file2, File file3) {
                            new StringBuilder("success to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }

                        public void onFailed(File file, File file2, Throwable th) {
                            zArr[0] = false;
                            thArr[0] = th;
                            new StringBuilder("fail to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }
                    });
                    if (!zArr[0]) {
                        Log.e(TAG, "parallel oat dexes failed");
                        shareLoadPatchResult.errorCode = -15;
                        return false;
                    }
                } catch (Throwable th) {
                    Log.e(TAG, "getCurrentInstructionSet fail:" + th);
                    deleteOutOfDateOATFile(str);
                    shareLoadPatchResult.throwable = th;
                    shareLoadPatchResult.errorCode = -28;
                    return false;
                }
            }
            try {
                this.patchDexCount = this.classLoaderAdder.installDexes(application, pathClassLoader, file3, arrayList);
                return true;
            } catch (Throwable th2) {
                Log.e(TAG, "install dexes failed");
                shareLoadPatchResult.throwable = th2;
                shareLoadPatchResult.errorCode = -16;
                this.patchDexCount = 0;
                return false;
            }
        }
        Log.e(TAG, "classloader is null");
        shareLoadPatchResult.errorCode = -12;
        return false;
    }

    public void unLoadTinkerJars(Application application) {
        if (this.patchDexCount > 0) {
            try {
                this.classLoaderAdder.uninstallPatchDex(application.getClassLoader(), this.patchDexCount);
            } catch (Throwable th) {
                Log.e(TAG, "uninstall patch dex exception");
            }
        }
    }

    public boolean checkComplete(File file, String str, String str2, ShareLoadPatchResult shareLoadPatchResult) {
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        this.classNDexInfo.clear();
        this.dexList.clear();
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!isJustArtSupportDex(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.checkDexDiffPatchInfo(shareDexDiffPatchInfo2)) {
                    shareLoadPatchResult.errorCode = -8;
                    return false;
                } else if (!isVmArt) {
                    hashMap.put(shareDexDiffPatchInfo2.realName, getInfoMd5(shareDexDiffPatchInfo2));
                    if (!this.enableClassN) {
                        this.dexList.add(shareDexDiffPatchInfo2);
                    } else if (shareDexDiffPatchInfo2.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                        this.dexList.add(shareDexDiffPatchInfo2);
                    } else if (ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo2.realName).matches()) {
                        int indexOf = shareDexDiffPatchInfo2.realName.indexOf(46);
                        if (indexOf <= 7) {
                            this.dexList.add(shareDexDiffPatchInfo2);
                        } else if (Integer.parseInt(shareDexDiffPatchInfo2.realName.substring(7, indexOf)) <= this.multiDexIndex) {
                            this.dexList.add(shareDexDiffPatchInfo2);
                        }
                    }
                } else if (shareDexDiffPatchInfo2.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo2.realName).matches()) {
                    this.classNDexInfo.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (isVmArt && !(shareDexDiffPatchInfo == null && this.classNDexInfo.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                this.classNDexInfo.add(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, this.classNDexInfo.size() + 1));
            }
            hashMap.put(ShareConstants.CLASS_N_APK_NAME, "");
        }
        File file2 = new File(file, "dex");
        if (file2.exists() && file2.isDirectory()) {
            File file3 = new File(file, str);
            for (String file4 : hashMap.keySet()) {
                File file5 = new File(file2, file4);
                if (SharePatchFileUtil.isLegalFile(file5)) {
                    File file6 = new File(SharePatchFileUtil.optimizedPathFor(file5, file3));
                    if (SharePatchFileUtil.isLegalFile(file6)) {
                        if (this.dexFileDir == null) {
                            this.dexFileDir = file5.getParent();
                        }
                        if (this.oDexFileDir == null) {
                            this.oDexFileDir = file6.getParent();
                        }
                    } else {
                        shareLoadPatchResult.errorCode = -11;
                        return false;
                    }
                }
                shareLoadPatchResult.errorCode = -10;
                return false;
            }
            return true;
        }
        shareLoadPatchResult.errorCode = -9;
        return false;
    }

    private static void deleteOutOfDateOATFile(String str) {
        SharePatchFileUtil.deleteDir(str + "/odex/");
    }

    private static String getInfoMd5(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
    }

    private static boolean isJustArtSupportDex(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (!ShareTinkerInternals.isVmArt() && shareDexDiffPatchInfo.destMd5InDvm.equals(SettingsConst.FALSE)) {
            return true;
        }
        return false;
    }

    public String getDexFileDir() {
        return this.dexFileDir;
    }

    public String getOdexFileDir() {
        return this.oDexFileDir;
    }
}
