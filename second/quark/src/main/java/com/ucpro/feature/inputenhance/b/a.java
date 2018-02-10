package com.ucpro.feature.inputenhance.b;

import android.graphics.drawable.Drawable;
import com.ucpro.feature.inputenhance.s;
import com.ucpro.ui.widget.Button;

/* compiled from: ProGuard */
public final class a extends e {
    private static final int[] r = new int[0];
    private boolean p;
    private boolean q;

    public a(s sVar) {
        super(sVar);
    }

    public final void a(int i) {
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        a();
        this.a.getCallback().d(this.a.getInputEnhanceHeight());
    }

    private void a() {
        this.d.setClickable(true);
        this.d.setEnabled(true);
        this.e.setClickable(true);
        this.e.setEnabled(true);
        this.b.setClickable(this.p);
        this.b.setEnabled(this.p);
        if (!this.p) {
            a(this.b);
        }
        this.c.setClickable(this.q);
        this.c.setEnabled(this.q);
        if (!this.q) {
            a(this.c);
        }
    }

    private static void a(Button button) {
        Drawable background = button.getBackground();
        if (background != null) {
            background.setState(r);
        }
    }

    public final void a(boolean z, boolean z2) {
        this.p = z;
        this.q = z2;
        if (this.a.getCurrentState() == this) {
            a();
        }
    }
}
