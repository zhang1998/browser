package com.ucpro.feature.navigation.view;

import android.os.Build.VERSION;
import android.widget.AbsListView;

/* compiled from: ProGuard */
public final class ai {
    public static int a = 1;
    public static int b = 2;
    public b c = new b(this);
    boolean d;
    AbsListView e;

    public ai(AbsListView absListView) {
        this.e = absListView;
    }

    static /* synthetic */ void a(ai aiVar, int i) {
        if (VERSION.SDK_INT >= 19) {
            aiVar.e.scrollListBy(i);
        } else {
            aiVar.e.smoothScrollBy(i, 0);
        }
    }
}
