package com.ucpro.feature.navigation;

import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.feature.navigation.a.a;

/* compiled from: ProGuard */
public final class g {
    public static Object[][] a;

    static {
        r0 = new Object[4][];
        r0[0] = new Object[]{"ext:navifunc:qrcode", Integer.valueOf(e.bD)};
        r0[1] = new Object[]{"ext:navifunc:privacymode", Integer.valueOf(e.cx)};
        r0[2] = new Object[]{"ext:navifunc:allinonenavi", Integer.valueOf(e.bQ)};
        r0[3] = new Object[]{"ext:navifunc:lightapp", Integer.valueOf(e.bH)};
        a = r0;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("ext:navifunc:privacymode")) {
                com.ucpro.ui.b.e.a().a((int) R.string.privacymode_offline_tip, 0);
                return;
            }
            int intValue;
            for (Object[] objArr : a) {
                if (str.startsWith((String) objArr[0]) && (objArr[1] instanceof Integer)) {
                    intValue = ((Integer) objArr[1]).intValue();
                    if (!a.a(str)) {
                        str = null;
                    }
                    com.ucpro.base.a.g.a().a(intValue, r7);
                    return;
                }
            }
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str) && a.b(str)) {
            com.ucpro.base.a.g.a().a(e.bQ, 1);
        }
    }
}
