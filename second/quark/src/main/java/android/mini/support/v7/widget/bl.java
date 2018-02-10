package android.mini.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

/* compiled from: ProGuard */
final class bl extends aa {
    final /* synthetic */ StaggeredGridLayoutManager a;

    bl(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
        this.a = staggeredGridLayoutManager;
        super(context);
    }

    public final PointF a(int i) {
        int a = this.a.m(i);
        if (a == 0) {
            return null;
        }
        if (this.a.e == 0) {
            return new PointF((float) a, 0.0f);
        }
        return new PointF(0.0f, (float) a);
    }
}
