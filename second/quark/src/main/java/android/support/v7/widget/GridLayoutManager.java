package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.l;
import android.support.v4.view.b.s;
import android.support.v7.widget.RecyclerView.LayoutManager;
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
public class GridLayoutManager extends LinearLayoutManager {
    boolean s = false;
    int t = -1;
    int[] u;
    View[] v;
    final SparseIntArray w = new SparseIntArray();
    final SparseIntArray x = new SparseIntArray();
    o y = new x();
    final Rect z = new Rect();

    /* compiled from: ProGuard */
    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
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

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        j(LayoutManager.a(context, attributeSet, i, i2).b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        j(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        j(i);
    }

    public final void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public final int b(az azVar, v vVar) {
        if (this.l == 0) {
            return this.t;
        }
        if (vVar.a() <= 0) {
            return 0;
        }
        return a(azVar, vVar, vVar.a() - 1) + 1;
    }

    public final int c(az azVar, v vVar) {
        if (this.l == 1) {
            return this.t;
        }
        if (vVar.a() <= 0) {
            return 0;
        }
        return a(azVar, vVar, vVar.a() - 1) + 1;
    }

    public final void a(az azVar, v vVar, View view, s sVar) {
        boolean z = false;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(azVar, vVar, layoutParams2.c.c());
            int i;
            int i2;
            if (this.l == 0) {
                i = layoutParams2.a;
                i2 = layoutParams2.b;
                boolean z2 = this.t > 1 && layoutParams2.b == this.t;
                sVar.a(l.a(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.a;
            i2 = layoutParams2.b;
            if (this.t > 1 && layoutParams2.b == this.t) {
                z = true;
            }
            sVar.a(l.a(a, 1, i, i2, z));
            return;
        }
        super.a(view, sVar);
    }

    public final void a(az azVar, v vVar) {
        if (vVar.g) {
            int g = g();
            for (int i = 0; i < g; i++) {
                LayoutParams layoutParams = (LayoutParams) c(i).getLayoutParams();
                int c = layoutParams.c.c();
                this.w.put(c, layoutParams.b);
                this.x.put(c, layoutParams.a);
            }
        }
        super.a(azVar, vVar);
        this.w.clear();
        this.x.clear();
        if (!vVar.g) {
            this.s = false;
        }
    }

    public final void c(int i, int i2) {
        this.y.a.clear();
    }

    public final void l() {
        this.y.a.clear();
    }

    public final void d(int i, int i2) {
        this.y.a.clear();
    }

    public final void e(int i, int i2) {
        this.y.a.clear();
    }

    public final void f(int i, int i2) {
        this.y.a.clear();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams c() {
        if (this.l == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.u == null) {
            super.a(rect, i, i2);
        }
        int j = j() + h();
        int i3 = i() + k();
        if (this.l == 1) {
            i3 = LayoutManager.a(i2, i3 + rect.height(), ViewCompat.p(this.b));
            j = LayoutManager.a(i, j + this.u[this.u.length - 1], ViewCompat.o(this.b));
        } else {
            j = LayoutManager.a(i, j + rect.width(), ViewCompat.o(this.b));
            i3 = LayoutManager.a(i2, i3 + this.u[this.u.length - 1], ViewCompat.p(this.b));
        }
        h(j, i3);
    }

    private void i(int i) {
        int i2 = 0;
        int[] iArr = this.u;
        int i3 = this.t;
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
        this.u = iArr;
    }

    final void a(az azVar, v vVar, bp bpVar, int i) {
        Object obj = 1;
        super.a(azVar, vVar, bpVar, i);
        r();
        if (vVar.a() > 0 && !vVar.g) {
            if (i != 1) {
                obj = null;
            }
            int b = b(azVar, vVar, bpVar.a);
            if (obj != null) {
                while (b > 0 && bpVar.a > 0) {
                    bpVar.a--;
                    b = b(azVar, vVar, bpVar.a);
                }
            } else {
                int a = vVar.a() - 1;
                int i2 = bpVar.a;
                while (i2 < a) {
                    int b2 = b(azVar, vVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                bpVar.a = i2;
            }
        }
        s();
    }

    private void s() {
        if (this.v == null || this.v.length != this.t) {
            this.v = new View[this.t];
        }
    }

    public final int a(int i, az azVar, v vVar) {
        r();
        s();
        return super.a(i, azVar, vVar);
    }

    public final int b(int i, az azVar, v vVar) {
        r();
        s();
        return super.b(i, azVar, vVar);
    }

    final View a(az azVar, v vVar, int i, int i2, int i3) {
        int i4;
        View view = null;
        q();
        int c = this.m.c();
        int a = this.m.a();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View c2 = c(i);
            int a2 = LayoutManager.a(c2);
            if (a2 >= 0 && a2 < i3 && b(azVar, vVar, a2) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) c2.getLayoutParams()).c.m()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = c2;
                    }
                } else if (this.m.d(c2) < a && this.m.c(c2) >= c) {
                    return c2;
                } else {
                    if (view == null) {
                        view3 = c2;
                        c2 = view2;
                        i += i4;
                        view = view3;
                        view2 = c2;
                    }
                }
            }
            view3 = view;
            c2 = view2;
            i += i4;
            view = view3;
            view2 = c2;
        }
        return view != null ? view : view2;
    }

    private int b(az azVar, v vVar, int i) {
        if (!vVar.g) {
            return this.y.a(i, this.t);
        }
        int i2 = this.x.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = azVar.a(i);
        if (i2 != -1) {
            return this.y.a(i2, this.t);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int c(az azVar, v vVar, int i) {
        if (!vVar.g) {
            return 1;
        }
        int i2 = this.w.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (azVar.a(i) != -1) {
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    final void a(az azVar, v vVar, aa aaVar, f fVar) {
        boolean z;
        int i;
        int g = this.m.g();
        Object obj = g != 1073741824 ? 1 : null;
        int i2 = g() > 0 ? this.u[this.t] : 0;
        if (obj != null) {
            r();
        }
        if (aaVar.e == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.t;
        if (z) {
            i = 0;
        } else {
            i3 = b(azVar, vVar, aaVar.d) + c(azVar, vVar, aaVar.d);
            i = 0;
        }
        while (i < this.t && aaVar.a(vVar) && i3 > 0) {
            View a;
            int i4 = aaVar.d;
            int c = c(azVar, vVar, i4);
            if (c <= this.t) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = aaVar.a(azVar);
                if (a == null) {
                    break;
                }
                this.v[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.t + " spans.");
            }
        }
        if (i == 0) {
            fVar.b = true;
            return;
        }
        int a2;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(azVar, vVar, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.v[i8];
            if (aaVar.k == null) {
                if (z) {
                    a(a, -1, false);
                } else {
                    super.a(a, 0, false);
                }
            } else if (z) {
                a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            c = LayoutManager.a(this.u[layoutParams.a + layoutParams.b] - this.u[layoutParams.a], g, 0, this.l == 0 ? layoutParams.height : layoutParams.width, false);
            a2 = LayoutManager.a(this.m.d(), this.m.f(), 0, this.l == 1 ? layoutParams.height : layoutParams.width, true);
            if (this.l == 1) {
                a(a, c, a2, layoutParams.height == -1, false);
            } else {
                a(a, a2, c, layoutParams.width == -1, false);
            }
            i3 = this.m.a(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float b = (((float) this.m.b(a)) * IPictureView.DEFAULT_MIN_SCALE) / ((float) layoutParams.b);
            if (b <= f) {
                b = f;
            }
            i8++;
            f = b;
            i7 = i3;
        }
        if (obj != null) {
            i(Math.max(Math.round(((float) this.t) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.v[i6];
                LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = LayoutManager.a(this.u[layoutParams2.a + layoutParams2.b] - this.u[layoutParams2.a], (int) UCCore.VERIFY_POLICY_QUICK, 0, this.l == 0 ? layoutParams2.height : layoutParams2.width, false);
                a2 = LayoutManager.a(this.m.d(), this.m.f(), 0, this.l == 1 ? layoutParams2.height : layoutParams2.width, true);
                if (this.l == 1) {
                    a(a, c, a2, false, true);
                } else {
                    a(a, a2, c, false, true);
                }
                i3 = this.m.a(a);
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
            a = this.v[i6];
            if (this.m.a(a) != i5) {
                layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = LayoutManager.a(this.u[layoutParams2.a + layoutParams2.b] - this.u[layoutParams2.a], (int) UCCore.VERIFY_POLICY_QUICK, 0, this.l == 0 ? layoutParams2.height : layoutParams2.width, false);
                if (this.l == 1) {
                    a(a, c, a2, true, true);
                } else {
                    a(a, a2, c, true, true);
                }
            }
        }
        fVar.a = i5;
        a2 = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.l == 1) {
            if (aaVar.f == -1) {
                i3 = aaVar.b;
                i4 = i3 - i5;
            } else {
                i4 = aaVar.b;
                i3 = i4 + i5;
            }
        } else if (aaVar.f == -1) {
            c = aaVar.b;
            a2 = c - i5;
        } else {
            a2 = aaVar.b;
            c = a2 + i5;
        }
        int i9 = a2;
        a2 = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.v[i10];
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (this.l != 1) {
                c = this.u[layoutParams2.a] + i();
                i4 = this.m.b(view) + c;
            } else if (p()) {
                a2 = h() + this.u[layoutParams2.a + layoutParams2.b];
                i9 = a2 - this.m.b(view);
            } else {
                i9 = this.u[layoutParams2.a] + h();
                a2 = this.m.b(view) + i9;
            }
            LayoutManager.a(view, layoutParams2.leftMargin + i9, layoutParams2.topMargin + c, a2 - layoutParams2.rightMargin, i4 - layoutParams2.bottomMargin);
            if (layoutParams2.c.m() || layoutParams2.c.s()) {
                fVar.c = true;
            }
            fVar.d |= view.isFocusable();
        }
        Arrays.fill(this.v, null);
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        a(view, this.z);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.l == 1) {
            i = c(i, layoutParams.leftMargin + this.z.left, layoutParams.rightMargin + this.z.right);
        }
        if (z || this.l == 0) {
            i2 = c(i2, layoutParams.topMargin + this.z.top, layoutParams.bottomMargin + this.z.bottom);
        }
        if (!z2) {
            a = a(view, i, i2, layoutParams);
        } else if (this.g && LayoutManager.b(view.getMeasuredWidth(), i, layoutParams.width) && LayoutManager.b(view.getMeasuredHeight(), i2, layoutParams.height)) {
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

    private void a(az azVar, v vVar, int i, boolean z) {
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
        if (this.l == 1 && p()) {
            i4 = -1;
            i5 = this.t - 1;
            i6 = i3;
        } else {
            i4 = 1;
            i5 = 0;
            i6 = i3;
        }
        while (i6 != i) {
            View view = this.v[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.b = c(azVar, vVar, LayoutManager.a(view));
            if (i4 != -1 || layoutParams.b <= 1) {
                layoutParams.a = i5;
            } else {
                layoutParams.a = i5 - (layoutParams.b - 1);
            }
            i5 += layoutParams.b * i4;
            i6 += i2;
        }
    }

    private void j(int i) {
        if (i != this.t) {
            this.s = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.t = i;
            this.y.a.clear();
        }
    }

    public final View a(View view, int i, az azVar, v vVar) {
        View b = b(view);
        if (b == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
        int a = layoutParams.a;
        int a2 = layoutParams.a + layoutParams.b;
        if (super.a(view, i, azVar, vVar) == null) {
            return null;
        }
        int g;
        int i2;
        int i3;
        if (((h(i) == 1) != this.n ? 1 : null) != null) {
            g = g() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            g = 0;
            i2 = 1;
            i3 = g();
        }
        Object obj = (this.l == 1 && p()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = g;
        while (i6 != i3) {
            View c = c(i6);
            if (c == b) {
                break;
            }
            View view3;
            if (c.isFocusable()) {
                layoutParams = (LayoutParams) c.getLayoutParams();
                int a3 = layoutParams.a;
                int a4 = layoutParams.a + layoutParams.b;
                if (a3 == a && a4 == a2) {
                    return c;
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
                    g = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = c;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = g;
                }
            }
            g = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = g;
        }
        return view2;
    }

    public final boolean b() {
        return this.q == null && !this.s;
    }

    private void r() {
        int j;
        if (this.l == 1) {
            j = (this.j - j()) - h();
        } else {
            j = (this.k - k()) - i();
        }
        i(j);
    }

    private int a(az azVar, v vVar, int i) {
        if (!vVar.g) {
            return o.c(i, this.t);
        }
        int a = azVar.a(i);
        if (a != -1) {
            return o.c(a, this.t);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }
}
