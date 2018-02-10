package com.uc.aerie.loader.stable;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.TinkerDexLoader;
import com.tencent.tinker.loader.TinkerResourceLoader;
import com.tencent.tinker.loader.TinkerSoLoader;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareLoadPatchResult;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: ProGuard */
class AerieLoader {
    private static final String LOADER_SAFE_COUNT = "loader_safe_count";
    private static final String TAG = "AerieLoader";
    private Application application;
    private String baseLineId;
    private String cpuAbi;
    private boolean enableBackup = AerieLoaderConfig.isEnableBackup();
    private File patchDirectoryFile;
    private String updaterType = AerieLoaderConfig.getUpdaterType();

    /* compiled from: ProGuard */
    class PatchToLoadInfo {
        public int loadVersionType;
        public String version;
        public String versionFileName;

        public PatchToLoadInfo(int i, String str, String str2) {
            this.loadVersionType = i;
            this.version = str;
            this.versionFileName = str2;
        }
    }

    AerieLoader(Application application, String str, String str2) {
        this.application = application;
        this.baseLineId = str;
        this.cpuAbi = str2;
        this.patchDirectoryFile = new File(SharePatchFileUtil.getRootDirectory(application));
    }

    void tryLoad(boolean z, Intent intent) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(this.application);
        SharedPreferences sharedPreferences = this.application.getSharedPreferences(ShareConstants.BASE_LINE_ID_SP, 4);
        Object string = sharedPreferences.getString(ShareConstants.BASE_LINE_ID, "");
        if (TextUtils.equals(this.baseLineId, string)) {
            if (isInMainProcess) {
                int readSafeCount = readSafeCount() + 1;
                if (readSafeCount < 3) {
                    writeSafeCount(readSafeCount);
                    tryLoadInternal(z, intent, true);
                } else {
                    SharePatchFileUtil.deleteDir(this.patchDirectoryFile);
                    intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -2);
                }
                writeSafeCount(0);
            } else {
                tryLoadInternal(z, intent, false);
            }
            if (intent.getIntExtra(ShareIntentUtil.INTENT_RETURN_CODE, ShareConstants.ERROR_LOAD_UNDEFINE) != 0) {
                intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_LOADED, this.baseLineId);
            }
        } else {
            new StringBuilder("base line id change, app id : ").append(this.baseLineId).append(", save id : ").append(string);
            if (isInMainProcess) {
                SharePatchFileUtil.deleteDir(this.patchDirectoryFile);
                sharedPreferences.edit().putString(ShareConstants.BASE_LINE_ID, this.baseLineId).commit();
                writeSafeCount(0);
            }
            intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_LOADED, this.baseLineId);
            intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -1);
        }
        intent.putExtra(ShareIntentUtil.INTENT_LOAD_TOTAL_COST, SystemClock.elapsedRealtime() - elapsedRealtime);
    }

    private void tryLoadInternal(boolean z, Intent intent, boolean z2) {
        if (this.patchDirectoryFile.exists()) {
            File file = new File(this.patchDirectoryFile, ShareConstants.PATCH_INFO_NAME);
            if (file.exists()) {
                file = new File(this.patchDirectoryFile, ShareConstants.PATCH_INFO_LOCK_NAME);
                SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(file, file);
                if (readAndCheckPropertyWithLock == null || (TextUtils.isEmpty(readAndCheckPropertyWithLock.updateVersion) && TextUtils.isEmpty(readAndCheckPropertyWithLock.currentVersion))) {
                    Log.e(TAG, "patchInfo is corrupted.");
                    intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -5);
                    if (z2) {
                        SharePatchFileUtil.deleteDir(this.patchDirectoryFile);
                        ShareTinkerInternals.killAllOtherProcess(this.application);
                        return;
                    }
                    return;
                }
                String str;
                boolean z3 = ShareTinkerInternals.isVmArt() && ShareTinkerInternals.isSystemOTA(readAndCheckPropertyWithLock.fingerPrint);
                if (z3) {
                    readAndCheckPropertyWithLock.fingerPrint = Build.FINGERPRINT;
                }
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, z3);
                ShareLoadPatchResult shareLoadPatchResult;
                if (z2) {
                    Object obj;
                    Object obj2;
                    boolean z4;
                    int i;
                    ShareLoadPatchResult shareLoadPatchResult2;
                    String str2;
                    File file2 = new File(this.patchDirectoryFile, ShareConstants.ROLLBACK_PREVIOUS_FLAG_FILE);
                    File file3 = new File(this.patchDirectoryFile, ShareConstants.ROLLBACK_TO_BASE_FLAG_FILE);
                    File file4 = new File(this.application.getApplicationInfo().dataDir, ShareConstants.AERIE_TOP_DIR);
                    boolean z5 = false;
                    if (file3.exists()) {
                        z5 = true;
                        SharePatchFileUtil.deleteDir(file3);
                    }
                    boolean z6 = false;
                    if (file2.exists()) {
                        z6 = true;
                        SharePatchFileUtil.deleteDir(file2);
                    }
                    if (!TextUtils.equals(AerieLoaderConfig.UPDATER_TYPE_STANDARD, this.updaterType) || (file4.exists() && file4.isDirectory())) {
                        obj = null;
                    } else {
                        z5 = true;
                        obj = 1;
                    }
                    boolean z7 = !TextUtils.isEmpty(readAndCheckPropertyWithLock.updateVersion);
                    if (z7) {
                        intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_EXPECT_VERSION, readAndCheckPropertyWithLock.updateVersion);
                    } else {
                        intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_EXPECT_VERSION, readAndCheckPropertyWithLock.currentVersion);
                    }
                    if (z3) {
                        obj2 = 1;
                        z4 = true;
                    } else {
                        obj2 = null;
                        z4 = z5;
                    }
                    new StringBuilder("rollbackToBase:").append(z4).append(", rollbackToPrevious:").append(z6).append(", update:").append(z7);
                    List<PatchToLoadInfo> arrayList = new ArrayList(4);
                    if (z4) {
                        i = 3;
                    } else if (!z6) {
                        if (z7) {
                            arrayList.add(new PatchToLoadInfo(1, readAndCheckPropertyWithLock.updateVersion, readAndCheckPropertyWithLock.updateVersionFileName));
                            if (!TextUtils.isEmpty(readAndCheckPropertyWithLock.currentVersion)) {
                                arrayList.add(new PatchToLoadInfo(0, readAndCheckPropertyWithLock.currentVersion, readAndCheckPropertyWithLock.currentVersionFileName));
                            }
                            if (!TextUtils.isEmpty(readAndCheckPropertyWithLock.previousVersion)) {
                                arrayList.add(new PatchToLoadInfo(2, readAndCheckPropertyWithLock.previousVersion, readAndCheckPropertyWithLock.previousVersionFileName));
                                i = 0;
                            }
                        } else {
                            arrayList.add(new PatchToLoadInfo(0, readAndCheckPropertyWithLock.currentVersion, readAndCheckPropertyWithLock.currentVersionFileName));
                            if (!TextUtils.isEmpty(readAndCheckPropertyWithLock.previousVersion)) {
                                arrayList.add(new PatchToLoadInfo(2, readAndCheckPropertyWithLock.previousVersion, readAndCheckPropertyWithLock.previousVersionFileName));
                            }
                        }
                        i = 0;
                    } else if (TextUtils.isEmpty(readAndCheckPropertyWithLock.previousVersion)) {
                        i = 3;
                    } else {
                        arrayList.add(new PatchToLoadInfo(2, readAndCheckPropertyWithLock.previousVersion, readAndCheckPropertyWithLock.previousVersionFileName));
                        i = 0;
                    }
                    List arrayList2 = new ArrayList();
                    String str3 = "";
                    if (3 != i) {
                        ShareLoadPatchResult shareLoadPatchResult3;
                        Object obj3;
                        String str4;
                        HashSet hashSet = new HashSet();
                        for (PatchToLoadInfo patchToLoadInfo : arrayList) {
                            String.format("try load loadVersionType:%d, version:%s, versionFileName:%s", new Object[]{Integer.valueOf(patchToLoadInfo.loadVersionType), patchToLoadInfo.version, patchToLoadInfo.versionFileName});
                            shareLoadPatchResult = new ShareLoadPatchResult(patchToLoadInfo.version);
                            if (hashSet.contains(patchToLoadInfo.versionFileName)) {
                                shareLoadPatchResult3 = (ShareLoadPatchResult) arrayList2.get(arrayList2.size() - 1);
                                shareLoadPatchResult.set(patchToLoadInfo.version, shareLoadPatchResult3.errorCode, shareLoadPatchResult3.throwable);
                                arrayList2.add(shareLoadPatchResult);
                            } else if (TextUtils.isEmpty(patchToLoadInfo.versionFileName)) {
                                i = patchToLoadInfo.loadVersionType;
                                obj3 = 1;
                                str4 = str3;
                                shareLoadPatchResult3 = null;
                                break;
                            } else {
                                loadPatchInternal(this.application, new File(this.patchDirectoryFile, patchToLoadInfo.versionFileName), z, z3, shareLoadPatchResult);
                                if (shareLoadPatchResult.errorCode == 0) {
                                    i = patchToLoadInfo.loadVersionType;
                                    int i2 = 1;
                                    str4 = this.patchDirectoryFile.getAbsolutePath() + File.separator + patchToLoadInfo.versionFileName;
                                    shareLoadPatchResult3 = shareLoadPatchResult;
                                    break;
                                }
                                arrayList2.add(shareLoadPatchResult);
                                hashSet.add(patchToLoadInfo.versionFileName);
                            }
                        }
                        obj3 = null;
                        shareLoadPatchResult3 = null;
                        str4 = str3;
                        ShareLoadPatchResult shareLoadPatchResult4;
                        if (obj3 == null) {
                            i = 3;
                            shareLoadPatchResult4 = shareLoadPatchResult3;
                            str = str4;
                            shareLoadPatchResult2 = shareLoadPatchResult4;
                        } else {
                            shareLoadPatchResult4 = shareLoadPatchResult3;
                            str = str4;
                            shareLoadPatchResult2 = shareLoadPatchResult4;
                        }
                    } else {
                        shareLoadPatchResult2 = null;
                        str = str3;
                    }
                    intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_FILE_DIR, str);
                    List<File> arrayList3 = new ArrayList(4);
                    if (3 == i) {
                        str2 = this.baseLineId;
                        arrayList3.add(this.patchDirectoryFile);
                    } else if (2 == i) {
                        str2 = readAndCheckPropertyWithLock.previousVersion;
                        if (!(TextUtils.isEmpty(readAndCheckPropertyWithLock.currentVersionFileName) || TextUtils.equals(readAndCheckPropertyWithLock.previousVersionFileName, readAndCheckPropertyWithLock.currentVersionFileName))) {
                            arrayList3.add(new File(this.patchDirectoryFile, readAndCheckPropertyWithLock.currentVersionFileName));
                        }
                        if (!(TextUtils.isEmpty(readAndCheckPropertyWithLock.updateVersionFileName) || TextUtils.equals(readAndCheckPropertyWithLock.previousVersionFileName, readAndCheckPropertyWithLock.updateVersionFileName))) {
                            arrayList3.add(new File(this.patchDirectoryFile, readAndCheckPropertyWithLock.updateVersionFileName));
                        }
                    } else if (1 == i) {
                        str2 = readAndCheckPropertyWithLock.updateVersion;
                        if (!(TextUtils.isEmpty(readAndCheckPropertyWithLock.previousVersionFileName) || TextUtils.equals(readAndCheckPropertyWithLock.currentVersionFileName, readAndCheckPropertyWithLock.previousVersionFileName))) {
                            arrayList3.add(new File(this.patchDirectoryFile, readAndCheckPropertyWithLock.previousVersionFileName));
                        }
                        if (!(this.enableBackup || TextUtils.isEmpty(readAndCheckPropertyWithLock.currentVersionFileName))) {
                            arrayList3.add(new File(this.patchDirectoryFile, readAndCheckPropertyWithLock.currentVersionFileName));
                        }
                    } else {
                        str2 = readAndCheckPropertyWithLock.currentVersion;
                    }
                    if (i != 0 || z3) {
                        if (i != 1) {
                            if (!z4) {
                                intent.putExtra(ShareIntentUtil.INTENT_ROLLBACK_TYPE, 2);
                            } else if (obj != null) {
                                intent.putExtra(ShareIntentUtil.INTENT_ROLLBACK_TYPE, 1);
                            } else if (obj2 != null) {
                                intent.putExtra(ShareIntentUtil.INTENT_ROLLBACK_TYPE, 3);
                            } else {
                                intent.putExtra(ShareIntentUtil.INTENT_ROLLBACK_TYPE, 0);
                            }
                        }
                        readAndCheckPropertyWithLock.refreshByVersionChanged(i, this.enableBackup);
                        if (!SharePatchInfo.rewritePatchInfoFileWithLock(file, readAndCheckPropertyWithLock, file)) {
                            SharePatchFileUtil.deleteDir(this.patchDirectoryFile);
                            ShareTinkerInternals.killAllOtherProcess(this.application);
                            Process.killProcess(Process.myPid());
                        }
                        ShareTinkerInternals.killAllOtherProcess(this.application);
                    }
                    if (!arrayList2.isEmpty()) {
                        new StringBuilder("fail load patch size:").append(arrayList2.size());
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_LOAD_FAIL_RECORDS, (Serializable) arrayList2);
                    }
                    if (shareLoadPatchResult2 != null) {
                        new StringBuilder("load patch success:").append(shareLoadPatchResult2.version);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEX_COST, shareLoadPatchResult2.loadDexCost);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_RES_COST, shareLoadPatchResult2.loadResCost);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_SO_COST, shareLoadPatchResult2.loadSoCost);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_INTERNAL_COST, shareLoadPatchResult2.patchInternalCost);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_RES_PATH, shareLoadPatchResult2.resPath);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEX_PATH, shareLoadPatchResult2.dexFileDir);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_ODEX_PATH, shareLoadPatchResult2.oDexFileDir);
                    }
                    for (File file5 : arrayList3) {
                        new StringBuilder("clearFiles:").append(file5.getAbsolutePath());
                        SharePatchFileUtil.deleteDir(file5);
                    }
                    intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, 0);
                    str = str2;
                } else {
                    CharSequence charSequence = readAndCheckPropertyWithLock.currentVersion;
                    if (TextUtils.isEmpty(charSequence)) {
                        str = this.baseLineId;
                        intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -3);
                    } else {
                        if (!TextUtils.isEmpty(readAndCheckPropertyWithLock.currentVersionFileName)) {
                            if (z3) {
                                Log.w(TAG, "systemOTA, not main process, kill self.");
                                Process.killProcess(Process.myPid());
                            }
                            shareLoadPatchResult = new ShareLoadPatchResult(readAndCheckPropertyWithLock.currentVersion);
                            loadPatchInternal(this.application, new File(this.patchDirectoryFile, readAndCheckPropertyWithLock.currentVersionFileName), z, false, shareLoadPatchResult);
                            if (shareLoadPatchResult.errorCode != 0) {
                                String.format("load current version:%s fail, kill self.", new Object[]{charSequence});
                                Process.killProcess(Process.myPid());
                            }
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEX_COST, shareLoadPatchResult.loadDexCost);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_RES_COST, shareLoadPatchResult.loadResCost);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_SO_COST, shareLoadPatchResult.loadSoCost);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_INTERNAL_COST, shareLoadPatchResult.patchInternalCost);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_RES_PATH, shareLoadPatchResult.resPath);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEX_PATH, shareLoadPatchResult.dexFileDir);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_ODEX_PATH, shareLoadPatchResult.oDexFileDir);
                        }
                        intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_FILE_DIR, this.patchDirectoryFile + File.separator + readAndCheckPropertyWithLock.currentVersionFileName);
                        intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, 0);
                        CharSequence charSequence2 = charSequence;
                    }
                }
                intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_LOADED, str);
                return;
            }
            Log.w(TAG, "tryLoadPatchFiles:patch info not exist:" + file.getAbsolutePath());
            intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -4);
            if (z2) {
                SharePatchFileUtil.deleteDir(this.patchDirectoryFile);
                ShareTinkerInternals.killAllOtherProcess(this.application);
                return;
            }
            return;
        }
        intent.putExtra(ShareIntentUtil.INTENT_RETURN_CODE, -3);
        Log.w(TAG, "tryLoadPatchFiles:patchDirectory isn't exist.");
    }

    private void loadPatchInternal(Application application, File file, boolean z, boolean z2, ShareLoadPatchResult shareLoadPatchResult) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!file.exists()) {
            Log.w(TAG, "tryLoadPatchFiles:onPatchVersionDirectoryNotFound");
            shareLoadPatchResult.errorCode = -6;
        } else if (SharePatchFileUtil.isLegalFile(new File(file.getAbsolutePath(), file.getName() + ShareConstants.PATCH_SUFFIX))) {
            File file2 = new File(file, ShareConstants.META_FILES_DIR);
            if (file2.exists()) {
                HashMap hashMap = new HashMap();
                if (SharePatchFileUtil.getExtractMetaInfo(file2, hashMap)) {
                    String str = (String) hashMap.get(ShareConstants.EXTRACT_DEX_META);
                    String str2 = ShareConstants.DEFAULT_DEX_OPTIMIZE_PATH;
                    TinkerDexLoader tinkerDexLoader = new TinkerDexLoader(AerieLoaderConfig.isClassesNEnable(), AerieLoaderConfig.getMultidexIndex());
                    if (TextUtils.isEmpty(str) || tinkerDexLoader.checkComplete(file, str2, str, shareLoadPatchResult)) {
                        str = (String) hashMap.get(ShareConstants.EXTRACT_SO_META);
                        TinkerSoLoader tinkerSoLoader = new TinkerSoLoader(application);
                        if (!TextUtils.isEmpty(str)) {
                            if (!tinkerSoLoader.checkComplete(file, str, this.cpuAbi, shareLoadPatchResult)) {
                                Log.w(TAG, "tryLoadPatchFiles:native lib check fail");
                                return;
                            }
                        }
                        str = (String) hashMap.get(ShareConstants.EXTRACT_RES_META);
                        TinkerResourceLoader tinkerResourceLoader = new TinkerResourceLoader();
                        if (TextUtils.isEmpty(str) || tinkerResourceLoader.checkComplete(application, file, str, shareLoadPatchResult)) {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            if (tinkerDexLoader.loadTinkerJars(application, z, file.getAbsolutePath(), str2, false, shareLoadPatchResult)) {
                                shareLoadPatchResult.loadDexCost = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                shareLoadPatchResult.dexFileDir = tinkerDexLoader.getDexFileDir();
                                shareLoadPatchResult.oDexFileDir = tinkerDexLoader.getOdexFileDir();
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                if (tinkerSoLoader.loadTinkerSo(shareLoadPatchResult)) {
                                    shareLoadPatchResult.loadSoCost = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                    elapsedRealtime3 = SystemClock.elapsedRealtime();
                                    if (tinkerResourceLoader.loadTinkerResources(application, z, file.getAbsolutePath(), shareLoadPatchResult)) {
                                        shareLoadPatchResult.resPath = tinkerResourceLoader.getResourcePath();
                                        shareLoadPatchResult.loadResCost = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                        shareLoadPatchResult.patchInternalCost = SystemClock.elapsedRealtime() - elapsedRealtime;
                                        shareLoadPatchResult.errorCode = 0;
                                        return;
                                    }
                                    Log.e(TAG, "tryLoadPatchFiles:onPatchLoadResourcesFail");
                                    try {
                                        tinkerDexLoader.unLoadTinkerJars(application);
                                    } catch (Throwable th) {
                                        Log.e(TAG, "uninstallPatchDex failed", th);
                                    }
                                    try {
                                        tinkerSoLoader.unLoadTinkerSo(application);
                                        return;
                                    } catch (Throwable th2) {
                                        Log.e(TAG, "uninstallPatchSo fail", th2);
                                        return;
                                    }
                                }
                                Log.e(TAG, "tinker load so fail.");
                                try {
                                    tinkerDexLoader.unLoadTinkerJars(application);
                                    return;
                                } catch (Throwable th22) {
                                    Log.e(TAG, "uninstallPatchDex failed", th22);
                                    return;
                                }
                            }
                            Log.w(TAG, "tryLoadPatchFiles:onPatchLoadDexesFail");
                            return;
                        }
                        Log.w(TAG, "tryLoadPatchFiles:resource check fail");
                        return;
                    }
                    Log.w(TAG, "tryLoadPatchFiles:dex check fail, oatDir:" + str2);
                    return;
                }
                Log.w(TAG, "tryLoadPatchFiles:read meta files fail.");
                shareLoadPatchResult.errorCode = -8;
                return;
            }
            Log.w(TAG, "tryLoadPatchFiles:metaDir not exists.");
            shareLoadPatchResult.errorCode = -23;
        } else {
            Log.w(TAG, "tryLoadPatchFiles:onPatchVersionFileNotFound");
            shareLoadPatchResult.errorCode = -7;
        }
    }

    private void writeSafeCount(int i) {
        Closeable fileWriter;
        Closeable bufferedWriter;
        Throwable e;
        Closeable closeable = null;
        File file = new File(this.application.getFilesDir(), "loader_safe_count");
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs() || parentFile.exists()) {
                fileWriter = new FileWriter(file);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter.write(String.valueOf(i));
                        bufferedWriter.flush();
                        SharePatchFileUtil.closeQuietly(bufferedWriter);
                        SharePatchFileUtil.closeQuietly(fileWriter);
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        closeable = bufferedWriter;
                        bufferedWriter = fileWriter;
                        try {
                            Log.e(TAG, "write simple line fail.", e);
                            SharePatchFileUtil.closeQuietly(closeable);
                            SharePatchFileUtil.closeQuietly(bufferedWriter);
                        } catch (Throwable th) {
                            e = th;
                            fileWriter = bufferedWriter;
                            SharePatchFileUtil.closeQuietly(closeable);
                            SharePatchFileUtil.closeQuietly(fileWriter);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        closeable = bufferedWriter;
                        SharePatchFileUtil.closeQuietly(closeable);
                        SharePatchFileUtil.closeQuietly(fileWriter);
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = fileWriter;
                    Log.e(TAG, "write simple line fail.", e);
                    SharePatchFileUtil.closeQuietly(closeable);
                    SharePatchFileUtil.closeQuietly(bufferedWriter);
                } catch (Throwable th3) {
                    e = th3;
                    SharePatchFileUtil.closeQuietly(closeable);
                    SharePatchFileUtil.closeQuietly(fileWriter);
                    throw e;
                }
            }
            SharePatchFileUtil.closeQuietly(null);
            SharePatchFileUtil.closeQuietly(null);
        } catch (Exception e4) {
            e = e4;
            bufferedWriter = null;
            Log.e(TAG, "write simple line fail.", e);
            SharePatchFileUtil.closeQuietly(closeable);
            SharePatchFileUtil.closeQuietly(bufferedWriter);
        } catch (Throwable th4) {
            e = th4;
            fileWriter = null;
            SharePatchFileUtil.closeQuietly(closeable);
            SharePatchFileUtil.closeQuietly(fileWriter);
            throw e;
        }
    }

    private int readSafeCount() {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        Closeable closeable = null;
        int i = 4;
        File file = new File(this.application.getFilesDir(), "loader_safe_count");
        if (!file.exists()) {
            return 0;
        }
        Closeable fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                closeable = fileReader;
                try {
                    Log.e(TAG, "read safe count exception.", e);
                    SharePatchFileUtil.closeQuietly(bufferedReader);
                    SharePatchFileUtil.closeQuietly(closeable);
                    return 4;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader = closeable;
                    SharePatchFileUtil.closeQuietly(bufferedReader);
                    SharePatchFileUtil.closeQuietly(fileReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                SharePatchFileUtil.closeQuietly(bufferedReader);
                SharePatchFileUtil.closeQuietly(fileReader);
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    i = 0;
                } else if (SharePatchFileUtil.isDigit(readLine)) {
                    i = Integer.valueOf(readLine).intValue();
                }
                SharePatchFileUtil.closeQuietly(bufferedReader);
                SharePatchFileUtil.closeQuietly(fileReader);
                return i;
            } catch (Exception e3) {
                e = e3;
                closeable = fileReader;
                Log.e(TAG, "read safe count exception.", e);
                SharePatchFileUtil.closeQuietly(bufferedReader);
                SharePatchFileUtil.closeQuietly(closeable);
                return 4;
            } catch (Throwable th4) {
                th = th4;
                SharePatchFileUtil.closeQuietly(bufferedReader);
                SharePatchFileUtil.closeQuietly(fileReader);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            Log.e(TAG, "read safe count exception.", e);
            SharePatchFileUtil.closeQuietly(bufferedReader);
            SharePatchFileUtil.closeQuietly(closeable);
            return 4;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileReader = null;
            SharePatchFileUtil.closeQuietly(bufferedReader);
            SharePatchFileUtil.closeQuietly(fileReader);
            throw th;
        }
    }
}
