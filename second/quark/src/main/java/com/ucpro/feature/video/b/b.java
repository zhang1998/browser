package com.ucpro.feature.video.b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Binder;
import android.os.Build.VERSION;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.k;
import com.ucweb.common.util.d;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public final class b {
    public static boolean a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        if (context == null) {
            context = d.a();
        }
        if (new ContextWrapper(context).checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
            boolean c;
            if (VERSION.SDK_INT >= 19) {
                c = c(context);
            } else if (!f.e()) {
                c = true;
            } else if ((134217728 & context.getApplicationInfo().flags) == 0) {
                c = false;
            } else {
                c = true;
            }
            if (c) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    private static boolean c(Context context) {
        if (VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                if (((Integer) AppOpsManager.class.getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName()})).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static void b(Context context) {
        String d;
        if (context == null) {
            context = d.a();
        }
        k kVar = new k(context);
        kVar.a(a.d((int) R.string.system_alert_window_permission_dialog_title));
        if (VERSION.SDK_INT >= 23) {
            kVar.b(a.d((int) R.string.system_alert_window_permission_dialog_content_for_23));
        } else if (f.g()) {
            kVar.b(a.d((int) R.string.system_alert_window_permission_dialog_content_for_huawei));
        } else {
            kVar.b(a.d((int) R.string.system_alert_window_permission_dialog_content));
        }
        h h = kVar.h();
        if (f.g()) {
            d = a.d((int) R.string.system_alert_window_permission_dialog_yes_button_ok);
        } else {
            d = a.d((int) R.string.system_alert_window_permission_dialog_yes_button);
        }
        h.b(d, a.d((int) R.string.system_alert_window_permission_dialog_no_button));
        kVar.a(new d());
        kVar.show();
    }
}
