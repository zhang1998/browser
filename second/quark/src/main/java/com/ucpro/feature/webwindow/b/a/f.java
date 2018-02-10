package com.ucpro.feature.webwindow.b.a;

import com.uc.pictureviewer.interfaces.PictureViewerListener.Orientation;
import com.ucpro.feature.webwindow.b.a.a.e;

/* compiled from: ProGuard */
public final class f extends e {
    public l a;
    private e b;
    private int c;
    private int d;

    public f(e eVar) {
        this.b = eVar;
    }

    public final void onTabCountChanged(int i) {
        this.d = i;
        this.a.a(this.c, this.d);
        new StringBuilder("onTabCountChanged: ").append(String.valueOf(this.d));
    }

    public final void onTabChanged(int i, int i2) {
        this.c = i + 1;
        this.a.a(this.c, this.d);
        new StringBuilder("onTabChanged: ").append(String.valueOf(this.c)).append("/").append(String.valueOf(this.d));
    }

    public final boolean onViewMovedOut(Orientation orientation) {
        this.b.a(false);
        return false;
    }
}
