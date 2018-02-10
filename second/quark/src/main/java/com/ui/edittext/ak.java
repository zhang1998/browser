package com.ui.edittext;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ProGuard */
final class ak implements OnPreDrawListener {
    int a;
    int b;
    boolean c;
    final /* synthetic */ TextView d;
    private final int e;
    private av[] f;
    private boolean[] g;
    private boolean h;
    private int i;

    private ak(TextView textView) {
        this.d = textView;
        this.e = 6;
        this.f = new av[6];
        this.g = new boolean[6];
        this.h = true;
    }

    public final void a(av avVar, boolean z) {
        if (this.i == 0) {
            a();
            this.d.getViewTreeObserver().addOnPreDrawListener(this);
        }
        int i = -1;
        int i2 = 0;
        while (i2 < 6) {
            av avVar2 = this.f[i2];
            if (avVar2 != avVar) {
                if (i < 0 && avVar2 == null) {
                    i = i2;
                }
                i2++;
            } else {
                return;
            }
        }
        this.f[i] = avVar;
        this.g[i] = z;
        this.i++;
    }

    public final void a(av avVar) {
        for (int i = 0; i < 6; i++) {
            if (this.f[i] == avVar) {
                this.f[i] = null;
                this.i--;
                break;
            }
        }
        if (this.i == 0) {
            this.d.getViewTreeObserver().removeOnPreDrawListener(this);
        }
    }

    public final boolean onPreDraw() {
        a();
        int i = 0;
        while (i < 6) {
            if (this.h || this.c || this.g[i]) {
                av avVar = this.f[i];
                if (avVar != null) {
                    avVar.a(this.a, this.b, this.h, this.c);
                }
            }
            i++;
        }
        this.c = false;
        return true;
    }

    private void a() {
        boolean z;
        this.d.getLocationInWindow(this.d.a);
        if (this.d.a[0] == this.a && this.d.a[1] == this.b) {
            z = false;
        } else {
            z = true;
        }
        this.h = z;
        this.a = this.d.a[0];
        this.b = this.d.a[1];
    }
}
