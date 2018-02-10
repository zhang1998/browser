package com.ucpro.c;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.ucweb.common.util.d;
import com.ucweb.common.util.n.a;
import hugo.weaving.DebugLog;
import java.io.File;

/* compiled from: ProGuard */
public final class c {
    private static File a;

    public static File a() {
        File file = new File(d.a().getApplicationInfo().dataDir, "main");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static File h() {
        return new File(d.a().getApplicationInfo().dataDir, "app_core_ucmobile");
    }

    public static File b() {
        if (h().exists()) {
            return new File(h(), "cache" + File.separator + "httpcache");
        }
        return null;
    }

    public static String a(String str) {
        Object obj;
        com.ucweb.common.util.c.a((CharSequence) str);
        if (TextUtils.isEmpty(str)) {
            obj = null;
        } else {
            obj = new File(a(), str);
            if (!obj.exists()) {
                obj.mkdir();
            } else if (obj.isFile()) {
                obj.delete();
                obj.mkdir();
                Log.e("Path", obj.getAbsolutePath() + " is a file already");
            }
        }
        com.ucweb.common.util.c.a(obj);
        if (obj != null) {
            return obj.getAbsolutePath();
        }
        return null;
    }

    public static File c() {
        if (a == null) {
            a = Environment.getExternalStorageDirectory();
        }
        return a;
    }

    public static File d() {
        File file = new File(c(), "Quark");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File b(String str) {
        com.ucweb.common.util.c.a((CharSequence) str);
        File file = new File(d(), str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static String c(String str) {
        File file = new File(str);
        try {
            if (!(a.d(str, c().getPath()) || file.canWrite())) {
                str = c().getPath();
            }
        } catch (Exception e) {
            str = c().getPath();
        }
        file = new File(str, "Quark");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "Download");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.getAbsolutePath();
    }

    public static String f() {
        File file = new File(d().getAbsolutePath(), ".apolloCache");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String g() {
        File file = new File(d().getAbsolutePath(), ".snapshot");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    @DebugLog
    public static synchronized String e() {
        String a;
        synchronized (c.class) {
            String path = c().getPath();
            a = com.ucpro.model.a.a.a.a("setting_download_store_path", path);
            if (a.d(a, path)) {
                a = c(a);
            } else {
                Object obj = "Quark/Download";
                if (a.contains(obj)) {
                    a = c(a.substring(0, a.indexOf(obj)));
                    if (a.d(a, path)) {
                        com.ucpro.model.a.a.a.b("setting_download_store_path", a);
                    }
                } else {
                    try {
                        if (!new File(a).canWrite()) {
                            a = c().getPath();
                        }
                    } catch (Exception e) {
                        a = c().getPath();
                    }
                }
            }
        }
        return a;
    }
}
