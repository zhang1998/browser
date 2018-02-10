package com.ucpro.feature.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class p {
    public static void a(Activity activity, float f) {
        a(activity.getWindow(), (int) (255.0f * f));
    }

    private static boolean a(Window window, int i) {
        boolean z = true;
        if (window == null) {
            return false;
        }
        try {
            LayoutParams attributes = window.getAttributes();
            if (i < 0) {
                attributes.screenBrightness = -1.0f;
            } else {
                if (i <= 0) {
                    i = 1;
                }
                attributes.screenBrightness = ((float) i) / 255.0f;
            }
            window.setAttributes(attributes);
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    public static int a(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(3);
        } catch (Exception e) {
            return -1;
        }
    }

    public static int b(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            return -1;
        }
    }

    public static String a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    obj = null;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    obj = 1;
                    break;
                }
                break;
            case 109801339:
                if (str.equals("super")) {
                    obj = 2;
                    break;
                }
                break;
        }
        String d;
        switch (obj) {
            case null:
                d = a.d((int) R.string.video_quality_normal);
                if (z) {
                    return d + " HD";
                }
                return d;
            case 1:
                d = a.d((int) R.string.video_quality_high);
                if (z) {
                    return d + " 720";
                }
                return d;
            case 2:
                d = a.d((int) R.string.video_quality_super_high);
                if (z) {
                    return d + " 1080";
                }
                return d;
            default:
                return null;
        }
    }
}
