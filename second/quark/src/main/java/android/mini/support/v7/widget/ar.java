package android.mini.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
public final class ar {
    public int a;
    public int b;
    public int c;
    public int d;

    public final ar a(bf bfVar) {
        View view = bfVar.a;
        this.a = view.getLeft();
        this.b = view.getTop();
        this.c = view.getRight();
        this.d = view.getBottom();
        return this;
    }
}
