package android.mini.support.v4.view;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class av implements bh {
    WeakHashMap<View, cs> a = null;

    av() {
    }

    public boolean a(View view, int i) {
        if (view instanceof ap) {
            boolean z;
            ap apVar = (ap) view;
            int computeHorizontalScrollOffset = apVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = apVar.computeHorizontalScrollRange() - apVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange != 0) {
                if (i < 0) {
                    z = computeHorizontalScrollOffset > 0;
                } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public boolean b(View view, int i) {
        if (view instanceof ap) {
            boolean z;
            ap apVar = (ap) view;
            int computeVerticalScrollOffset = apVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = apVar.computeVerticalScrollRange() - apVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange != 0) {
                if (i < 0) {
                    z = computeVerticalScrollOffset > 0;
                } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public int a(View view) {
        return 2;
    }

    public void a(View view, h hVar) {
    }

    public boolean b(View view) {
        return false;
    }

    public boolean c(View view) {
        return false;
    }

    public void d(View view) {
        view.invalidate();
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    long a() {
        return 10;
    }

    public int e(View view) {
        return 0;
    }

    public void c(View view, int i) {
    }

    public float f(View view) {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public void a(View view, int i, Paint paint) {
    }

    public int g(View view) {
        return 0;
    }

    public int h(View view) {
        return 0;
    }

    public boolean i(View view) {
        return true;
    }

    public float j(View view) {
        return 0.0f;
    }

    public float k(View view) {
        return 0.0f;
    }

    public Matrix l(View view) {
        return null;
    }

    public int m(View view) {
        return bi.a(view);
    }

    public int n(View view) {
        return bi.b(view);
    }

    public cs o(View view) {
        return new cs(view);
    }

    public void a(View view, float f) {
    }

    public void b(View view, float f) {
    }

    public void c(View view, float f) {
    }

    public void d(View view, float f) {
    }

    public void a(View view, an anVar) {
    }

    public cy a(View view, cy cyVar) {
        return cyVar;
    }

    public cy b(View view, cy cyVar) {
        return cyVar;
    }

    public void p(View view) {
    }

    public void q(View view) {
        if (view instanceof ak) {
            ((ak) view).stopNestedScroll();
        }
    }

    public boolean r(View view) {
        return view.getWindowToken() != null;
    }
}
