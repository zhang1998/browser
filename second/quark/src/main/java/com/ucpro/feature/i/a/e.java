package com.ucpro.feature.i.a;

import android.os.Environment;
import android.view.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/* compiled from: ProGuard */
final class e implements b {
    private e() {
    }

    static boolean a() {
        FileInputStream fileInputStream;
        Throwable th;
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (!(properties.getProperty("ro.miui.ui.version.code") == null && properties.getProperty("ro.miui.ui.version.name") == null && properties.getProperty("ro.miui.internal.storage") == null)) {
                    z = true;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return z;
    }

    public final void a(Window window, boolean z) {
        int i = 0;
        Class cls = window.getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Object[] objArr = new Object[2];
            if (z) {
                i = i2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception e) {
        }
    }
}
