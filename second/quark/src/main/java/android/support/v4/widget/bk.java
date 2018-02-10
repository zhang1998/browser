package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: ProGuard */
class bk implements bp {
    bk() {
    }

    public final boolean a(Object obj, float f) {
        return d.a(obj, f);
    }

    public boolean a(Object obj, float f, float f2) {
        return d.a(obj, f);
    }

    public final Object a(Context context) {
        return new EdgeEffect(context);
    }

    public final void a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public final boolean a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public final void b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public final boolean c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public final boolean a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public final boolean a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
