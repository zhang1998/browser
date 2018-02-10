package com.ucpro.feature.t;

import com.quark.browser.R;

/* compiled from: ProGuard */
public final class a {
    public static int[] a(int i, int i2, boolean z) {
        int c;
        int[] iArr = new int[2];
        int c2 = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_margin_top);
        if (z) {
            c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_margin_bottom);
        } else {
            c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_margin_bottom_without_padding);
        }
        int c3 = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_icon_width);
        int c4 = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_header_margin_top);
        int c5 = com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_toolbar_height);
        int c6 = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_horizontal_space);
        c2 = ((i2 - (c2 * 2)) - c) - ((c3 + c4) * 2);
        if (z) {
            c = c5;
        } else {
            c = 0;
        }
        c = (c2 - c) / 2;
        iArr[0] = ((i - (c6 * 2)) - com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_minus_width)) / 2;
        iArr[1] = c;
        return iArr;
    }
}
