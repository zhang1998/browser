package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Pair;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;

/* compiled from: ProGuard */
public final class k extends UCSubSetupTask<k, k> {
    public static float a = 0.0f;
    private static boolean b = false;
    private Context c = null;

    public final void run() {
        float freeSpace;
        float freeSpace2;
        String valueOf;
        Throwable th;
        float f = 0.0f;
        this.c = (Context) getOption(UCCore.OPTION_CONTEXT);
        if (!a(this.c, (File) UCMPackageInfo.invoke(10003, this.c), 100000)) {
            String str = SettingsConst.FALSE;
            String valueOf2;
            try {
                UCElapseTime uCElapseTime;
                Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
                File dir = context.getDir("core_ucmobile", 0);
                File file = new File(dir, "cache");
                freeSpace = (float) (dir.getFreeSpace() / 1024);
                try {
                    uCElapseTime = new UCElapseTime();
                    if (a(new File(file, "httpcache"))) {
                        new File(d(context) + "/httpcache").renameTo(new File(String.format(d(context) + "/httpcache_bad_%s", new Object[]{Long.valueOf(SystemClock.uptimeMillis())})));
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(file, "httpcache_bad");
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(new File(d(context) + "/httpcache"));
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(new File(d(context)), "httpcache_bad");
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(new File(dir, "Local Storage"));
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(dir, "Local Storage_bad");
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(new File(Environment.getExternalStorageDirectory().getPath() + "/UCDownloads/video/.apolloCache"));
                    }
                    if (!a(this.c, dir, 100000)) {
                        a(new File(Environment.getExternalStorageDirectory().getPath() + "/UCDownloads/video"), ".apolloCache_bad");
                    }
                    freeSpace2 = (float) (dir.getFreeSpace() / 1024);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        valueOf2 = String.valueOf(freeSpace);
                        callbackStat(new Pair(IWaStat.SEVENZIP_CLEARHTTPCACHE, new UCHashMap().set("cnt", SettingsConst.TRUE).set("cost", str).set(IWaStat.KEY_FREE_DISK_SPACE_BEFORE, valueOf2).set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                        Log.e("CheckSpace", "After clean disk space: " + f);
                    } catch (Throwable th3) {
                    }
                    throw th;
                }
                try {
                    valueOf = String.valueOf(uCElapseTime.getMilis());
                    try {
                        valueOf2 = String.valueOf(freeSpace);
                        callbackStat(new Pair(IWaStat.SEVENZIP_CLEARHTTPCACHE, new UCHashMap().set("cnt", SettingsConst.TRUE).set("cost", valueOf).set(IWaStat.KEY_FREE_DISK_SPACE_BEFORE, valueOf2).set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace2))));
                        Log.e("CheckSpace", "After clean disk space: " + freeSpace2);
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    f = freeSpace2;
                    th = th6;
                    valueOf2 = String.valueOf(freeSpace);
                    callbackStat(new Pair(IWaStat.SEVENZIP_CLEARHTTPCACHE, new UCHashMap().set("cnt", SettingsConst.TRUE).set("cost", str).set(IWaStat.KEY_FREE_DISK_SPACE_BEFORE, valueOf2).set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                    Log.e("CheckSpace", "After clean disk space: " + f);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                freeSpace = 0.0f;
                valueOf2 = String.valueOf(freeSpace);
                callbackStat(new Pair(IWaStat.SEVENZIP_CLEARHTTPCACHE, new UCHashMap().set("cnt", SettingsConst.TRUE).set("cost", str).set(IWaStat.KEY_FREE_DISK_SPACE_BEFORE, valueOf2).set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                Log.e("CheckSpace", "After clean disk space: " + f);
                throw th;
            }
        }
        c(this.c);
    }

    public static boolean a(Context context) {
        if (!b) {
            c(context);
        }
        return b;
    }

    private static void c(Context context) {
        File file = (File) UCMPackageInfo.invoke(10003, context);
        if (a(context, file, 41000)) {
            b = false;
            return;
        }
        b = true;
        a = (float) (file.getFreeSpace() / 1024);
    }

    private static boolean a(Context context, File file, int i) {
        if (((float) (file.getFreeSpace() / 1024)) < ((float) i)) {
            return false;
        }
        try {
            File dir = context.getDir("test_dir", 0);
            if (!dir.exists() && !dir.mkdirs()) {
                return false;
            }
            dir.delete();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean a(File file) {
        File file2 = new File(file.getAbsolutePath() + String.format("_bad_%s", new Object[]{Long.valueOf(SystemClock.uptimeMillis())}));
        file.renameTo(file2);
        File[] listFiles = file2.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            UCElapseTime uCElapseTime = new UCElapseTime();
            for (File recursiveDelete : listFiles) {
                UCCyclone.recursiveDelete(recursiveDelete, false, null);
                if (uCElapseTime.getMilisCpu() > 2000) {
                    if (a(this.c, file2, 100000)) {
                        return true;
                    }
                    uCElapseTime.reset();
                }
            }
        }
        return false;
    }

    private void a(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory() && file2.getName().startsWith(str)) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        UCElapseTime uCElapseTime = new UCElapseTime();
                        for (File recursiveDelete : listFiles2) {
                            UCCyclone.recursiveDelete(recursiveDelete, false, null);
                            if (uCElapseTime.getMilisCpu() > 2000) {
                                if (a(this.c, file, 100000)) {
                                    break;
                                }
                                uCElapseTime.reset();
                            }
                        }
                    }
                }
            }
        }
    }

    private static String d(Context context) {
        if (VERSION.SDK_INT >= 8) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
        }
        return Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache");
    }

    public static void b(Context context) {
        b(new File(context.getDir("core_ucmobile", 0), "cache"), "httpcache_bad");
        b(new File(d(context)), "httpcache_bad");
        b(context.getDir("core_ucmobile", 0), "Local Storage_bad");
        b(new File(Environment.getExternalStorageDirectory().getPath() + "/UCDownloads/video"), ".apolloCache_bad");
    }

    private static void b(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory() && file2.getName().startsWith(str) && file2.exists()) {
                    try {
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null) {
                            for (File recursiveDelete : listFiles2) {
                                UCCyclone.recursiveDelete(recursiveDelete, false, null);
                            }
                        }
                        file2.delete();
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }
}
