package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
public final class m {
    public int a;
    public int b;
    public int c;
    public int d;

    public final m a(bh bhVar) {
        View view = bhVar.a;
        this.a = view.getLeft();
        this.b = view.getTop();
        this.c = view.getRight();
        this.d = view.getBottom();
        return this;
    }
}
