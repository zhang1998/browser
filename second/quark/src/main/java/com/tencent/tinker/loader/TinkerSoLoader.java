package com.tencent.tinker.loader;

import android.app.Application;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareLoadPatchResult;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class TinkerSoLoader {
    protected static final String SO_MEAT_FILE = "assets/so_meta.txt";
    protected static final String SO_PATH = "lib";
    private static final String TAG = "Tinker.TinkerSoLoader";
    private Application application = null;
    private File libDirFile = null;

    /* compiled from: ProGuard */
    final class V14 {
        private V14() {
        }

        private static void install(ClassLoader classLoader, File file) throws Throwable {
            ShareReflectUtil.expandFieldArray(ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }

        private static void uninstall(ClassLoader classLoader) throws Throwable {
            ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", 1);
        }
    }

    /* compiled from: ProGuard */
    final class V23 {
        private V23() {
        }

        private static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            new ArrayList(list).addAll(list2);
            Method findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList = new ArrayList();
            Object[] objArr = (Object[]) findMethod.invoke(obj, new Object[]{r3, null, arrayList});
            Field findField = ShareReflectUtil.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, objArr);
        }

        private static void uninstall(ClassLoader classLoader) throws Throwable {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ((List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj)).remove(0);
            ShareReflectUtil.reduceFieldArray(obj, "nativeLibraryPathElements", 1);
        }
    }

    /* compiled from: ProGuard */
    final class V25 {
        private V25() {
        }

        private static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            new ArrayList(list).addAll(list2);
            Object[] objArr = (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class).invoke(obj, new Object[]{r3});
            Field findField = ShareReflectUtil.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, objArr);
        }
    }

    public TinkerSoLoader(Application application) {
        this.application = application;
    }

    public boolean checkComplete(File file, String str, String str2, ShareLoadPatchResult shareLoadPatchResult) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
            if (ShareBsDiffPatchInfo.checkDiffPatchInfo(shareBsDiffPatchInfo)) {
                hashMap.put(shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5);
            } else {
                shareLoadPatchResult.errorCode = -8;
                return false;
            }
        }
        for (String file2 : hashMap.keySet()) {
            if (!SharePatchFileUtil.isLegalFile(new File(file, file2))) {
                shareLoadPatchResult.errorCode = -18;
                return false;
            }
        }
        if (TextUtils.equals(str2, ShareConstants.INVALID_CPU_ABI)) {
            shareLoadPatchResult.errorCode = -26;
            return false;
        }
        File file3 = new File(file + "/lib", str2);
        if (file3.exists() && file3.isDirectory() && file3.listFiles().length > 0 && !arrayList2.contains(ShareConstants.IGNORE_ALL_SYMBOLIC)) {
            List<String> arrayList3 = new ArrayList();
            for (File file4 : new File(this.application.getApplicationInfo().nativeLibraryDir).listFiles()) {
                if (!arrayList2.contains(file4.getName())) {
                    arrayList3.add(file4.getName());
                }
            }
            if (!arrayList3.isEmpty()) {
                for (String file22 : arrayList3) {
                    if (!new File(file3, file22).exists()) {
                        Log.wtf(TAG, "link so not found:" + file22);
                        shareLoadPatchResult.errorCode = -25;
                        return false;
                    }
                }
            }
            this.libDirFile = file3;
        }
        return true;
    }

    public boolean loadTinkerSo(ShareLoadPatchResult shareLoadPatchResult) {
        if (this.libDirFile == null) {
            return true;
        }
        try {
            if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
                V25.install(this.application.getClassLoader(), this.libDirFile);
                return true;
            } else if (VERSION.SDK_INT >= 23) {
                try {
                    V23.install(this.application.getClassLoader(), this.libDirFile);
                    return true;
                } catch (Throwable th) {
                    Log.e(TAG, String.format("installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", new Object[]{Integer.valueOf(VERSION.SDK_INT), th.getMessage()}));
                    V14.install(this.application.getClassLoader(), this.libDirFile);
                    return true;
                }
            } else if (VERSION.SDK_INT < 14) {
                return true;
            } else {
                V14.install(this.application.getClassLoader(), this.libDirFile);
                return true;
            }
        } catch (Throwable th2) {
            shareLoadPatchResult.throwable = th2;
            shareLoadPatchResult.errorCode = -24;
            return false;
        }
    }

    public void unLoadTinkerSo(Application application) {
        if (this.libDirFile != null) {
            try {
                if (VERSION.SDK_INT >= 23) {
                    V23.uninstall(application.getClassLoader());
                } else if (VERSION.SDK_INT >= 14) {
                    V14.uninstall(application.getClassLoader());
                }
            } catch (Throwable th) {
                Log.e(TAG, "remove so element fail.");
            }
        }
    }
}
