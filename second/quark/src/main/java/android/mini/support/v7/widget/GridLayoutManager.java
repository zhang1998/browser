package android.mini.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.a.q;
import android.mini.support.v4.view.a.r;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    t g = new s();
    final Rect h = new Rect();

    /* compiled from: ProGuard */
    public class LayoutParams extends android.mini.support.v7.widget.RecyclerView.LayoutParams {
        int a = -1;
        int b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(int i, int i2) {
        super(i2);
        if (i != this.b) {
            this.a = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.b = i;
            this.g.a.clear();
            l();
        }
    }

    public final int a(ax axVar, State state) {
        if (this.i == 0) {
            return this.b;
        }
        if (state.a() <= 0) {
            return 0;
        }
        return a(axVar, state, state.a() - 1) + 1;
    }

    public final int b(ax axVar, State state) {
        if (this.i == 1) {
            return this.b;
        }
        if (state.a() <= 0) {
            return 0;
        }
        return a(axVar, state, state.a() - 1) + 1;
    }

    public final void a(ax axVar, State state, View view, r rVar) {
        boolean z = false;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(axVar, state, layoutParams2.c.c());
            int i;
            int i2;
            if (this.i == 0) {
                boolean z2;
                i = layoutParams2.a;
                i2 = layoutParams2.b;
                if (this.b <= 1 || layoutParams2.b != this.b) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                rVar.a(q.a(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.a;
            i2 = layoutParams2.b;
            if (this.b > 1 && layoutParams2.b == this.b) {
                z = true;
            }
            rVar.a(q.a(a, 1, i, i2, z));
            return;
        }
        super.a(view, rVar);
    }

    public final void a(State state) {
        super.a(state);
        this.a = false;
    }

    public final void a(int i, int i2) {
        this.g.a.clear();
    }

    public final void a() {
        this.g.a.clear();
    }

    public final void b(int i, int i2) {
        this.g.a.clear();
    }

    public final void c(int i, int i2) {
        this.g.a.clear();
    }

    public final void d(int i, int i2) {
        this.g.a.clear();
    }

    public final android.mini.support.v7.widget.RecyclerView.LayoutParams b() {
        if (this.i == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.mini.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.mini.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.mini.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int q = q() + o();
        int p = p() + r();
        if (this.i == 1) {
            p = LayoutManager.a(i2, p + rect.height(), ViewCompat.m(this.q));
            q = LayoutManager.a(i, q + this.c[this.c.length - 1], ViewCompat.l(this.q));
        } else {
            q = LayoutManager.a(i, q + rect.width(), ViewCompat.l(this.q));
            p = LayoutManager.a(i2, p + this.c[this.c.length - 1], ViewCompat.m(this.q));
        }
        h(q, p);
    }

    private void i(int i) {
        int i2 = 0;
        int[] iArr = this.c;
        int i3 = this.b;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        iArr[0] = 0;
        int i4 = i / i3;
        int i5 = i % i3;
        int i6 = 0;
        for (int i7 = 1; i7 <= i3; i7++) {
            int i8;
            i2 += i5;
            if (i2 <= 0 || i3 - i2 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i2 -= i3;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        this.c = iArr;
    }

    final void a(ax axVar, State state, w wVar, int i) {
        Object obj = 1;
        super.a(axVar, state, wVar, i);
        u();
        if (state.a() > 0 && !state.g) {
            if (i != 1) {
                obj = null;
            }
            int b = b(axVar, state, wVar.a);
            if (obj != null) {
                while (b > 0 && wVar.a > 0) {
                    wVar.a--;
                    b = b(axVar, state, wVar.a);
                }
            } else {
                int a = state.a() - 1;
                int i2 = wVar.a;
                while (i2 < a) {
                    int b2 = b(axVar, state, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                wVar.a = i2;
            }
        }
        v();
    }

    private void v() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    public final int a(int i, ax axVar, State state) {
        u();
        v();
        return super.a(i, axVar, state);
    }

    public final int b(int i, ax axVar, State state) {
        u();
        v();
        return super.b(i, axVar, state);
    }

    final View a(ax axVar, State state, int i, int i2, int i3) {
        int i4;
        View view = null;
        h();
        int c = this.j.c();
        int a = this.j.a();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View e = e(i);
            int a2 = LayoutManager.a(e);
            if (a2 >= 0 && a2 < i3 && b(axVar, state, a2) == 0) {
                if (((android.mini.support.v7.widget.RecyclerView.LayoutParams) e.getLayoutParams()).c.m()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = e;
                    }
                } else if (this.j.d(e) < a && this.j.c(e) >= c) {
                    return e;
                } else {
                    if (view == null) {
                        view3 = e;
                        e = view2;
                        i += i4;
                        view = view3;
                        view2 = e;
                    }
                }
            }
            view3 = view;
            e = view2;
            i += i4;
            view = view3;
            view2 = e;
        }
        return view != null ? view : view2;
    }

    private int b(ax axVar, State state, int i) {
        if (!state.g) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = axVar.a(i);
        if (i2 != -1) {
            return this.g.b(i2, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int c(ax axVar, State state, int i) {
        if (!state.g) {
            return 1;
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (axVar.a(i) != -1) {
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    final void a(ax axVar, State state, y yVar, x xVar) {
        boolean z;
        int i;
        View a;
        int g = this.j.g();
        Object obj = g != 1073741824 ? 1 : null;
        int i2 = n() > 0 ? this.c[this.b] : 0;
        if (obj != null) {
            u();
        }
        if (yVar.e == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.b;
        if (z) {
            i = 0;
        } else {
            i3 = b(axVar, state, yVar.d) + c(axVar, state, yVar.d);
            i = 0;
        }
        while (i < this.b && yVar.a(state) && i3 > 0) {
            int i4 = yVar.d;
            int c = c(axVar, state, i4);
            if (c <= this.b) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = yVar.a(axVar);
                if (a == null) {
                    break;
                }
                this.d[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.b + " spans.");
            }
        }
        if (i == 0) {
            xVar.b = true;
            return;
        }
        int a2;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(axVar, state, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.d[i8];
            if (yVar.k == null) {
                if (z) {
                    super.a(a, -1, false);
                } else {
                    super.a(a, 0, false);
                }
            } else if (z) {
                super.a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            c = LayoutManager.a(this.c[layoutParams.a + layoutParams.b] - this.c[layoutParams.a], g, 0, this.i == 0 ? layoutParams.height : layoutParams.width, false);
            a2 = LayoutManager.a(this.j.d(), this.j.f(), 0, this.i == 1 ? layoutParams.height : layoutParams.width, true);
            if (this.i == 1) {
                a(a, c, a2, layoutParams.height == -1, false);
            } else {
                a(a, a2, c, layoutParams.width == -1, false);
            }
            i3 = this.j.a(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float b = (((float) this.j.b(a)) * IPictureView.DEFAULT_MIN_SCALE) / ((float) layoutParams.b);
            if (b <= f) {
                b = f;
            }
            i8++;
            f = b;
            i7 = i3;
        }
        if (obj != null) {
            i(Math.max(Math.round(((float) this.b) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.d[i6];
                LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = LayoutManager.a(this.c[layoutParams2.a + layoutParams2.b] - this.c[layoutParams2.a], (int) UCCore.VERIFY_POLICY_QUICK, 0, this.i == 0 ? layoutParams2.height : layoutParams2.width, false);
                a2 = LayoutManager.a(this.j.d(), this.j.f(), 0, this.i == 1 ? layoutParams2.height : layoutParams2.width, true);
                if (this.i == 1) {
                    a(a, c, a2, false, true);
                } else {
                    a(a, a2, c, false, true);
                }
                i3 = this.j.a(a);
                if (i3 <= i5) {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            i5 = i7;
        }
        a2 = MeasureSpec.makeMeasureSpec(i5, UCCore.VERIFY_POLICY_QUICK);
        for (i6 = 0; i6 < i; i6++) {
            a = this.d[i6];
            if (this.j.a(a) != i5) {
                layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = LayoutManager.a(this.c[layoutParams2.a + layoutParams2.b] - this.c[layoutParams2.a], (int) UCCore.VERIFY_POLICY_QUICK, 0, this.i == 0 ? layoutParams2.height : layoutParams2.width, false);
                if (this.i == 1) {
                    a(a, c, a2, true, true);
                } else {
                    a(a, a2, c, true, true);
                }
            }
        }
        xVar.a = i5;
        a2 = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.i == 1) {
            if (yVar.f == -1) {
                i3 = yVar.b;
                i4 = i3 - i5;
            } else {
                i4 = yVar.b;
                i3 = i4 + i5;
            }
        } else if (yVar.f == -1) {
            c = yVar.b;
            a2 = c - i5;
        } else {
            a2 = yVar.b;
            c = a2 + i5;
        }
        int i9 = a2;
        a2 = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.d[i10];
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (this.i != 1) {
                c = this.c[layoutParams2.a] + p();
                i4 = this.j.b(view) + c;
            } else if (g()) {
                a2 = o() + this.c[layoutParams2.a + layoutParams2.b];
                i9 = a2 - this.j.b(view);
            } else {
                i9 = this.c[layoutParams2.a] + o();
                a2 = this.j.b(view) + i9;
            }
            LayoutManager.a(view, i9, c, a2, i4);
            if (layoutParams2.c.m() || layoutParams2.c.s()) {
                xVar.c = true;
            }
            xVar.d |= view.isFocusable();
        }
        Arrays.fill(this.d, null);
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        b(view, this.h);
        android.mini.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.mini.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.i == 1) {
            i = c(i, layoutParams.leftMargin + this.h.left, layoutParams.rightMargin + this.h.right);
        }
        if (z || this.i == 0) {
            i2 = c(i2, layoutParams.topMargin + this.h.top, layoutParams.bottomMargin + this.h.bottom);
        }
        if (!z2) {
            a = a(view, i, i2, layoutParams);
        } else if (this.v && LayoutManager.b(view.getMeasuredWidth(), i, layoutParams.width) && LayoutManager.b(view.getMeasuredHeight(), i2, layoutParams.height)) {
            a = false;
        } else {
            a = true;
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private static int c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == SectionHeader.SHT_LOUSER || mode == UCCore.VERIFY_POLICY_QUICK) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void a(ax axVar, State state, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.i == 1 && g()) {
            i4 = -1;
            i5 = this.b - 1;
            i6 = i3;
        } else {
            i4 = 1;
            i5 = 0;
            i6 = i3;
        }
        while (i6 != i) {
            View view = this.d[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.b = c(axVar, state, LayoutManager.a(view));
            if (i4 != -1 || layoutParams.b <= 1) {
                layoutParams.a = i5;
            } else {
                layoutParams.a = i5 - (layoutParams.b - 1);
            }
            i5 += layoutParams.b * i4;
            i6 += i2;
        }
    }

    public final View a(View view, int i, ax axVar, State state) {
        View b = b(view);
        if (b == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
        int a = layoutParams.a;
        int a2 = layoutParams.a + layoutParams.b;
        if (super.a(view, i, axVar, state) == null) {
            return null;
        }
        int n;
        int i2;
        int i3;
        if (((d(i) == 1) != this.k ? 1 : null) != null) {
            n = n() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            n = 0;
            i2 = 1;
            i3 = n();
        }
        Object obj = (this.i == 1 && g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = n;
        while (i6 != i3) {
            View e = e(i6);
            if (e == b) {
                break;
            }
            View view3;
            if (e.isFocusable()) {
                layoutParams = (LayoutParams) e.getLayoutParams();
                int a3 = layoutParams.a;
                int a4 = layoutParams.a + layoutParams.b;
                if (a3 == a && a4 == a2) {
                    return e;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = layoutParams.a;
                    n = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = e;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = n;
                }
            }
            n = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = n;
        }
        return view2;
    }

    public final boolean c() {
        return this.n == null && !this.a;
    }

    public final void c(ax axVar, State state) {
        if (state.g) {
            int n = n();
            for (int i = 0; i < n; i++) {
                LayoutParams layoutParams = (LayoutParams) e(i).getLayoutParams();
                int c = layoutParams.c.c();
                this.e.put(c, layoutParams.b);
                this.f.put(c, layoutParams.a);
            }
        }
        super.c(axVar, state);
        this.e.clear();
        this.f.clear();
    }

    private void u() {
        int q;
        if (this.i == 1) {
            q = (this.y - q()) - o();
        } else {
            q = (this.z - r()) - p();
        }
        i(q);
    }

    private int a(ax axVar, State state, int i) {
        if (!state.g) {
            return t.c(i, this.b);
        }
        int a = axVar.a(i);
        if (a != -1) {
            return t.c(a, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }
}
