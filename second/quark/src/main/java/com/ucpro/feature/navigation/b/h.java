package com.ucpro.feature.navigation.b;

import com.quark.browser.R;
import com.ucpro.b.a.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class h {
    private static String[] a;
    private static String[] b;

    public static String[] a() {
        if (b == null) {
            b = d.c().getStringArray(a.a() ? R.array.hardcode_navigation_urls : R.array.hardcode_navigation_urls_cn);
        }
        return b;
    }

    public static String[] b() {
        if (a == null) {
            a = d.c().getStringArray(a.a() ? R.array.hardcode_navigation_titles : R.array.hardcode_navigation_titles_cn);
        }
        return a;
    }
}
