package com.uc.webview.export.internal;

import android.content.Context;
import com.uc.webview.export.extension.BreakpadConfig;
import com.uc.webview.export.internal.interfaces.IBreakpad;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public final class a {
    private static boolean a = false;
    private static boolean b = false;
    private static IBreakpad c;

    private static IBreakpad b() {
        if (b && c == null) {
            c = (IBreakpad) ReflectionUtil.newInstanceNoThrow("com.uc.webview.browser.internal.breakpad.BreakpadImpl");
        }
        return c;
    }

    public static void a(Context context, String str, BreakpadConfig breakpadConfig) {
        Class cls = null;
        if (!a) {
            a = true;
            Class[] clsArr = new Class[]{Context.class, String.class, String.class, String.class};
            Object[] objArr = new Object[]{context, str, breakpadConfig.mCrashDir, breakpadConfig.mUploadUrl};
            try {
                Field declaredField;
                cls = Class.forName("com.uc.webview.browser.internal.breakpad.BreakpadImpl", true, SDKFactory.c);
                if (breakpadConfig.mCrashLogPrefix != null && breakpadConfig.mCrashLogPrefix.trim().length() > 0) {
                    declaredField = cls.getDeclaredField("sCrashLogPrefix");
                    declaredField.setAccessible(true);
                    declaredField.set(null, breakpadConfig.mCrashLogPrefix.trim());
                }
                declaredField = cls.getDeclaredField("sEnableEncryptLog");
                declaredField.setAccessible(true);
                declaredField.set(null, Boolean.valueOf(breakpadConfig.mEnableEncryptLog));
                declaredField = cls.getDeclaredField("sZiptLog");
                declaredField.setAccessible(true);
                declaredField.set(null, Boolean.valueOf(breakpadConfig.mZipLog));
            } catch (Throwable th) {
            }
            try {
                ReflectionUtil.invoke(cls, "loadBreakpadLibrary", clsArr, objArr);
                b = true;
            } catch (Throwable th2) {
            }
            if (b() != null) {
                b().setCrashLogFileName(breakpadConfig.mCrashLogFileName);
                try {
                    if (!breakpadConfig.mEnableJavaLog) {
                        ReflectionUtil.invoke(b(), "disableLog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(16)});
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static void a() {
        if (b() != null) {
            b().uploadCrashLogs();
        }
    }
}
