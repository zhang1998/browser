package com.ucpro.feature.privacymode.c;

import com.uc.browser.b;

/* compiled from: ProGuard */
public final class a {
    private static b b() {
        try {
            return (b) b.a("privacy_password", "privacy_password_table", b.class);
        } catch (com.uc.browser.a e) {
            return null;
        }
    }

    public static String a() {
        b b = b();
        if (b == null || !com.ucweb.common.util.n.a.b(b.b)) {
            return "";
        }
        return b.b;
    }
}
