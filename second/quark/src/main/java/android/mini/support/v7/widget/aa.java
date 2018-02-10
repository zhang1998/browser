package android.mini.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: ProGuard */
public abstract class aa extends bc {
    private final float a;
    protected final LinearInterpolator b = new LinearInterpolator();
    protected final DecelerateInterpolator c = new DecelerateInterpolator();
    protected PointF d;
    protected int e = 0;
    protected int f = 0;

    public abstract PointF a(int i);

    public aa(Context context) {
        this.a = 25.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
    }

    protected final void a(View view, bb bbVar) {
        int i = 0;
        int i2 = (this.d == null || this.d.x == 0.0f) ? 0 : this.d.x > 0.0f ? 1 : -1;
        LayoutManager layoutManager = this.i;
        if (layoutManager == null || !layoutManager.e()) {
            i2 = 0;
        } else {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i2 = a(LayoutManager.e(view) - layoutParams.leftMargin, layoutParams.rightMargin + LayoutManager.g(view), layoutManager.o(), layoutManager.y - layoutManager.q(), i2);
        }
        int b = b();
        LayoutManager layoutManager2 = this.i;
        if (layoutManager2 != null && layoutManager2.f()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i = a(LayoutManager.f(view) - layoutParams.topMargin, layoutParams.bottomMargin + LayoutManager.h(view), layoutManager2.p(), layoutManager2.z - layoutManager2.r(), b);
        }
        int ceil = (int) Math.ceil(((double) b((int) Math.sqrt((double) ((i2 * i2) + (i * i))))) / 0.3356d);
        if (ceil > 0) {
            bbVar.a(-i2, -i, ceil, this.c);
        }
    }

    protected final void a(int i, int i2, bb bbVar) {
        if (this.h.f.n() == 0) {
            c();
            return;
        }
        this.e = a(this.e, i);
        this.f = a(this.f, i2);
        if (this.e == 0 && this.f == 0) {
            PointF a = a(this.g);
            if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
                Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
                bbVar.a = this.g;
                c();
                return;
            }
            double sqrt = Math.sqrt((double) ((a.x * a.x) + (a.y * a.y)));
            a.x = (float) (((double) a.x) / sqrt);
            a.y = (float) (((double) a.y) / sqrt);
            this.d = a;
            this.e = (int) (a.x * 10000.0f);
            this.f = (int) (a.y * 10000.0f);
            bbVar.a((int) (((float) this.e) * 1.2f), (int) (((float) this.f) * 1.2f), (int) (((float) b(10000)) * 1.2f), this.b);
        }
    }

    protected final void a() {
        this.f = 0;
        this.e = 0;
        this.d = null;
    }

    private int b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.a));
    }

    public int b() {
        if (this.d == null || this.d.y == 0.0f) {
            return 0;
        }
        return this.d.y > 0.0f ? 1 : -1;
    }

    private static int a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }
}
