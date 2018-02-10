package com.ucpro.ui.widget.a;

import android.view.View;

/* compiled from: ProGuard */
public final class j {
    private int a;

    public final boolean a(View view, float f, float f2) {
        View findViewById = view.findViewById(this.a);
        if (findViewById == null) {
            return false;
        }
        boolean z;
        if (((float) findViewById.getLeft()) > f || ((float) findViewById.getRight()) < f) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (((float) findViewById.getTop()) > f2 || ((float) findViewById.getBottom()) < f2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
