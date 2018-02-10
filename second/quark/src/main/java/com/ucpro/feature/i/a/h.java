package com.ucpro.feature.i.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: ProGuard */
public final class h {
    static final k a;

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new d();
        } else if (VERSION.SDK_INT >= 21 && !a()) {
            a = new n();
        } else if (VERSION.SDK_INT >= 19) {
            a = new l();
        } else {
            a = new m();
        }
    }

    private static boolean a() {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return properties.containsKey("ro.build.hw_emui_api_level");
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream2 = fileInputStream;
                th = th3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return properties.containsKey("ro.build.hw_emui_api_level");
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return properties.containsKey("ro.build.hw_emui_api_level");
    }

    @TargetApi(14)
    static void a(Window window) {
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
    }

    public static void a(Activity activity, @ColorInt int i) {
        try {
            boolean z;
            int blue = Color.blue(i);
            if ((((blue * 15) + ((Color.green(i) * 75) + (Color.red(i) * 38))) >> 7) > 225) {
                z = true;
            } else {
                z = false;
            }
            Window window = activity.getWindow();
            if ((window.getAttributes().flags & 1024) <= 0 && !c.a) {
                a.a(window, i);
                j.a(window, z);
            }
        } catch (Exception e) {
        }
    }
}
