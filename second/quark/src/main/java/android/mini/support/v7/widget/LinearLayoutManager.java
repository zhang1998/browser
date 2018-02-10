package android.mini.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.a.ak;
import android.mini.support.v4.view.a.e;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.mini.support.v7.widget.RecyclerView.State;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.util.List;

/* compiled from: ProGuard */
public class LinearLayoutManager extends LayoutManager {
    private y a;
    private boolean b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f;
    public int i;
    af j;
    boolean k = false;
    public int l = -1;
    public int m = SectionHeader.SHT_LOUSER;
    public SavedState n = null;
    final w o = new w(this);

    /* compiled from: ProGuard */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new z();
        public int a;
        int b;
        boolean c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        final boolean a() {
            return this.a >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i) {
                this.i = i;
                this.j = null;
                l();
            }
            a(null);
            if (this.c) {
                this.c = false;
                l();
            }
            this.u = true;
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public LayoutParams b() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, ax axVar) {
        super.a(recyclerView, axVar);
        if (this.f) {
            c(axVar);
            axVar.a();
        }
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (n() > 0) {
            ak a = e.a(accessibilityEvent);
            a.b(j());
            a.c(k());
        }
    }

    public final Parcelable d() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        Parcelable savedState = new SavedState();
        if (n() > 0) {
            h();
            boolean z = this.b ^ this.k;
            savedState.c = z;
            View x;
            if (z) {
                x = x();
                savedState.b = this.j.a() - this.j.c(x);
                savedState.a = LayoutManager.a(x);
                return savedState;
            }
            x = w();
            savedState.a = LayoutManager.a(x);
            savedState.b = this.j.d(x) - this.j.c();
            return savedState;
        }
        savedState.a = -1;
        return savedState;
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            l();
        }
    }

    public final boolean e() {
        return this.i == 0;
    }

    public final boolean f() {
        return this.i == 1;
    }

    private void u() {
        boolean z = true;
        if (this.i == 1 || !g()) {
            z = this.c;
        } else if (this.c) {
            z = false;
        }
        this.k = z;
    }

    public final View a(int i) {
        int n = n();
        if (n == 0) {
            return null;
        }
        int a = i - LayoutManager.a(e(0));
        if (a >= 0 && a < n) {
            View e = e(a);
            if (LayoutManager.a(e) == i) {
                return e;
            }
        }
        return super.a(i);
    }

    private int h(State state) {
        int i;
        if (state.a != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.j.d();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        bc vVar = new v(this, recyclerView.getContext());
        vVar.g = i;
        a(vVar);
    }

    public final PointF b(int i) {
        int i2 = 1;
        boolean z = false;
        if (n() == 0) {
            return null;
        }
        if (i < LayoutManager.a(e(0))) {
            z = true;
        }
        if (z != this.k) {
            i2 = -1;
        }
        if (this.i == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(ax axVar, State state) {
        if (!(this.n == null && this.l == -1) && state.a() == 0) {
            c(axVar);
            return;
        }
        int c;
        int a;
        int c2;
        int min;
        int a2;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        h();
        this.a.a = false;
        u();
        if (!(this.o.d && this.l == -1 && this.n == null)) {
            Object obj;
            View a3;
            this.o.a();
            this.o.c = this.k ^ this.d;
            w wVar = this.o;
            if (state.g || this.l == -1) {
                obj = null;
            } else if (this.l < 0 || this.l >= state.a()) {
                this.l = -1;
                this.m = SectionHeader.SHT_LOUSER;
                obj = null;
            } else {
                wVar.a = this.l;
                if (this.n == null || !this.n.a()) {
                    if (this.m == SectionHeader.SHT_LOUSER) {
                        a3 = a(this.l);
                        if (a3 == null) {
                            if (n() > 0) {
                                wVar.c = (this.l < LayoutManager.a(e(0))) == this.k;
                            }
                            wVar.b();
                        } else if (this.j.a(a3) > this.j.d()) {
                            wVar.b();
                        } else if (this.j.d(a3) - this.j.c() < 0) {
                            wVar.b = this.j.c();
                            wVar.c = false;
                        } else if (this.j.a() - this.j.c(a3) < 0) {
                            wVar.b = this.j.a();
                            wVar.c = true;
                        } else {
                            if (wVar.c) {
                                c = this.j.c(a3) + this.j.h();
                            } else {
                                c = this.j.d(a3);
                            }
                            wVar.b = c;
                        }
                        obj = 1;
                    } else {
                        wVar.c = this.k;
                        if (this.k) {
                            wVar.b = this.j.a() - this.m;
                        } else {
                            wVar.b = this.j.c() + this.m;
                        }
                    }
                    obj = 1;
                } else {
                    wVar.c = this.n.c;
                    if (wVar.c) {
                        wVar.b = this.j.a() - this.n.b;
                    } else {
                        wVar.b = this.j.c() + this.n.b;
                    }
                    obj = 1;
                }
            }
            if (obj == null) {
                if (n() != 0) {
                    View view;
                    if (this.q == null) {
                        view = null;
                    } else {
                        a3 = this.q.getFocusedChild();
                        view = (a3 == null || this.p.d(a3)) ? null : a3;
                    }
                    if (view != null) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams.c.m() || layoutParams.c.c() < 0 || layoutParams.c.c() >= state.a()) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            c = wVar.e.j.h();
                            if (c >= 0) {
                                wVar.a(view);
                            } else {
                                wVar.a = LayoutManager.a(view);
                                if (wVar.c) {
                                    c = (wVar.e.j.a() - c) - wVar.e.j.c(view);
                                    wVar.b = wVar.e.j.a() - c;
                                    if (c > 0) {
                                        a = wVar.b - wVar.e.j.a(view);
                                        c2 = wVar.e.j.c();
                                        min = a - (Math.min(wVar.e.j.d(view) - c2, 0) + c2);
                                        if (min < 0) {
                                            wVar.b = Math.min(c, -min) + wVar.b;
                                        }
                                    }
                                } else {
                                    a = wVar.e.j.d(view);
                                    c2 = a - wVar.e.j.c();
                                    wVar.b = a;
                                    if (c2 > 0) {
                                        c = (wVar.e.j.a() - Math.min(0, (wVar.e.j.a() - c) - wVar.e.j.c(view))) - (a + wVar.e.j.a(view));
                                        if (c < 0) {
                                            wVar.b -= Math.min(c2, -c);
                                        }
                                    }
                                }
                            }
                            obj = 1;
                            if (obj == null) {
                                wVar.b();
                                if (this.d) {
                                    c = state.a() - 1;
                                } else {
                                    c = 0;
                                }
                                wVar.a = c;
                            }
                        }
                    }
                    if (this.b == this.d) {
                        if (wVar.c) {
                            a3 = d(axVar, state);
                        } else {
                            a3 = e(axVar, state);
                        }
                        if (a3 != null) {
                            wVar.a(a3);
                            if (!state.g && c()) {
                                obj = (this.j.d(a3) >= this.j.a() || this.j.c(a3) < this.j.c()) ? 1 : null;
                                if (obj != null) {
                                    if (wVar.c) {
                                        c = this.j.a();
                                    } else {
                                        c = this.j.c();
                                    }
                                    wVar.b = c;
                                }
                            }
                            obj = 1;
                            if (obj == null) {
                                wVar.b();
                                if (this.d) {
                                    c = 0;
                                } else {
                                    c = state.a() - 1;
                                }
                                wVar.a = c;
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    wVar.b();
                    if (this.d) {
                        c = state.a() - 1;
                    } else {
                        c = 0;
                    }
                    wVar.a = c;
                }
            }
            this.o.d = true;
        }
        c = h(state);
        if (this.a.j >= 0) {
            min = 0;
        } else {
            min = c;
            c = 0;
        }
        min += this.j.c();
        c += this.j.e();
        if (!(!state.g || this.l == -1 || this.m == SectionHeader.SHT_LOUSER)) {
            View a4 = a(this.l);
            if (a4 != null) {
                if (this.k) {
                    a2 = (this.j.a() - this.j.c(a4)) - this.m;
                } else {
                    a2 = this.m - (this.j.d(a4) - this.j.c());
                }
                if (a2 > 0) {
                    min += a2;
                } else {
                    c -= a2;
                }
            }
        }
        a2 = this.o.c ? this.k ? 1 : -1 : this.k ? -1 : 1;
        a(axVar, state, this.o, a2);
        a(axVar);
        this.a.l = v();
        this.a.i = state.g;
        if (this.o.c) {
            b(this.o);
            this.a.h = min;
            a(axVar, this.a, state, false);
            min = this.a.b;
            a = this.a.d;
            if (this.a.c > 0) {
                c += this.a.c;
            }
            a(this.o);
            this.a.h = c;
            y yVar = this.a;
            yVar.d += this.a.e;
            a(axVar, this.a, state, false);
            a2 = this.a.b;
            if (this.a.c > 0) {
                c = this.a.c;
                j(a, min);
                this.a.h = c;
                a(axVar, this.a, state, false);
                c = this.a.b;
            } else {
                c = min;
            }
            min = c;
            c = a2;
        } else {
            a(this.o);
            this.a.h = c;
            a(axVar, this.a, state, false);
            c = this.a.b;
            a2 = this.a.d;
            if (this.a.c > 0) {
                min += this.a.c;
            }
            b(this.o);
            this.a.h = min;
            y yVar2 = this.a;
            yVar2.d += this.a.e;
            a(axVar, this.a, state, false);
            min = this.a.b;
            if (this.a.c > 0) {
                a = this.a.c;
                i(a2, c);
                this.a.h = a;
                a(axVar, this.a, state, false);
                c = this.a.b;
            }
        }
        if (n() <= 0) {
            a2 = min;
            min = c;
        } else if ((this.k ^ this.d) != 0) {
            a2 = a(c, axVar, state, true);
            min += a2;
            c += a2;
            a2 = b(min, axVar, state, false);
            c += a2;
            a2 = min + a2;
            min = c;
        } else {
            a2 = b(min, axVar, state, true);
            min += a2;
            c += a2;
            a2 = a(c, axVar, state, false);
            c += a2;
            a2 = min + a2;
            min = c;
        }
        if (state.i && n() != 0 && !state.g && c()) {
            int i = 0;
            c2 = 0;
            List list = axVar.d;
            int size = list.size();
            int a5 = LayoutManager.a(e(0));
            int i2 = 0;
            while (i2 < size) {
                bf bfVar = (bf) list.get(i2);
                if (bfVar.m()) {
                    c = c2;
                    a = i;
                } else {
                    if (((bfVar.c() < a5) != this.k ? -1 : 1) == -1) {
                        a = this.j.a(bfVar.a) + i;
                        c = c2;
                    } else {
                        c = this.j.a(bfVar.a) + c2;
                        a = i;
                    }
                }
                i = a;
                i2++;
                c2 = c;
            }
            this.a.k = list;
            if (i > 0) {
                j(LayoutManager.a(w()), a2);
                this.a.h = i;
                this.a.c = 0;
                this.a.a(null);
                a(axVar, this.a, state, false);
            }
            if (c2 > 0) {
                i(LayoutManager.a(x()), min);
                this.a.h = c2;
                this.a.c = 0;
                this.a.a(null);
                a(axVar, this.a, state, false);
            }
            this.a.k = null;
        }
        if (state.g) {
            this.o.a();
        } else {
            af afVar = this.j;
            afVar.b = afVar.d();
        }
        this.b = this.d;
    }

    public void a(State state) {
        super.a(state);
        this.n = null;
        this.l = -1;
        this.m = SectionHeader.SHT_LOUSER;
        this.o.a();
    }

    void a(ax axVar, State state, w wVar, int i) {
    }

    private int a(int i, ax axVar, State state, boolean z) {
        int a = this.j.a() - i;
        if (a <= 0) {
            return 0;
        }
        a = -c(-a, axVar, state);
        int i2 = i + a;
        if (!z) {
            return a;
        }
        i2 = this.j.a() - i2;
        if (i2 <= 0) {
            return a;
        }
        this.j.a(i2);
        return a + i2;
    }

    private int b(int i, ax axVar, State state, boolean z) {
        int c = i - this.j.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, axVar, state);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.j.c();
        if (i2 <= 0) {
            return c;
        }
        this.j.a(-i2);
        return c - i2;
    }

    private void a(w wVar) {
        i(wVar.a, wVar.b);
    }

    private void i(int i, int i2) {
        this.a.c = this.j.a() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = SectionHeader.SHT_LOUSER;
    }

    private void b(w wVar) {
        j(wVar.a, wVar.b);
    }

    private void j(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = SectionHeader.SHT_LOUSER;
    }

    protected final boolean g() {
        return ViewCompat.h(this.q) == 1;
    }

    final void h() {
        if (this.a == null) {
            this.a = new y();
        }
        if (this.j == null) {
            this.j = af.a(this, this.i);
        }
    }

    public final void c(int i) {
        this.l = i;
        this.m = SectionHeader.SHT_LOUSER;
        if (this.n != null) {
            this.n.a = -1;
        }
        l();
    }

    public int a(int i, ax axVar, State state) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, axVar, state);
    }

    public int b(int i, ax axVar, State state) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, axVar, state);
    }

    public final int b(State state) {
        return i(state);
    }

    public final int c(State state) {
        return i(state);
    }

    public final int d(State state) {
        return j(state);
    }

    public final int e(State state) {
        return j(state);
    }

    public final int f(State state) {
        return k(state);
    }

    public final int g(State state) {
        return k(state);
    }

    private int i(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        h();
        af afVar = this.j;
        View a = a(!this.e);
        if (this.e) {
            z = false;
        }
        return bi.a(state, afVar, a, b(z), this, this.e, this.k);
    }

    private int j(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        h();
        af afVar = this.j;
        View a = a(!this.e);
        if (this.e) {
            z = false;
        }
        return bi.a(state, afVar, a, b(z), this, this.e);
    }

    private int k(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        h();
        af afVar = this.j;
        View a = a(!this.e);
        if (this.e) {
            z = false;
        }
        return bi.b(state, afVar, a, b(z), this, this.e);
    }

    private void a(int i, int i2, boolean z, State state) {
        int i3 = -1;
        int i4 = 1;
        this.a.l = v();
        this.a.h = h(state);
        this.a.f = i;
        View x;
        y yVar;
        if (i == 1) {
            y yVar2 = this.a;
            yVar2.h += this.j.e();
            x = x();
            yVar = this.a;
            if (!this.k) {
                i3 = 1;
            }
            yVar.e = i3;
            this.a.d = LayoutManager.a(x) + this.a.e;
            this.a.b = this.j.c(x);
            i3 = this.j.c(x) - this.j.a();
        } else {
            x = w();
            yVar = this.a;
            yVar.h += this.j.c();
            yVar = this.a;
            if (!this.k) {
                i4 = -1;
            }
            yVar.e = i4;
            this.a.d = LayoutManager.a(x) + this.a.e;
            this.a.b = this.j.d(x);
            i3 = (-this.j.d(x)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            y yVar3 = this.a;
            yVar3.c -= i3;
        }
        this.a.g = i3;
    }

    private boolean v() {
        return this.j.f() == 0 && this.j.b() == 0;
    }

    private int c(int i, ax axVar, State state) {
        if (n() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        int a = this.a.g + a(axVar, this.a, state, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    public final void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(ax axVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, axVar);
                }
                return;
            }
            while (i > i2) {
                a(i, axVar);
                i--;
            }
        }
    }

    private void a(ax axVar, y yVar) {
        if (yVar.a && !yVar.l) {
            int i;
            int n;
            int b;
            View e;
            View e2;
            if (yVar.f == -1) {
                i = yVar.g;
                n = n();
                if (i >= 0) {
                    b = this.j.b() - i;
                    if (this.k) {
                        for (i = 0; i < n; i++) {
                            e = e(i);
                            if (this.j.d(e) < b || this.j.f(e) < b) {
                                a(axVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = n - 1; i >= 0; i--) {
                        e2 = e(i);
                        if (this.j.d(e2) < b || this.j.f(e2) < b) {
                            a(axVar, n - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            n = yVar.g;
            if (n >= 0) {
                b = n();
                if (this.k) {
                    for (i = b - 1; i >= 0; i--) {
                        e2 = e(i);
                        if (this.j.c(e2) > n || this.j.e(e2) > n) {
                            a(axVar, b - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < b; i++) {
                    e = e(i);
                    if (this.j.c(e) > n || this.j.e(e) > n) {
                        a(axVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(ax axVar, y yVar, State state, boolean z) {
        int i = yVar.c;
        if (yVar.g != SectionHeader.SHT_LOUSER) {
            if (yVar.c < 0) {
                yVar.g += yVar.c;
            }
            a(axVar, yVar);
        }
        int i2 = yVar.c + yVar.h;
        x xVar = new x();
        while (true) {
            if ((!yVar.l && i2 <= 0) || !yVar.a(state)) {
                break;
            }
            xVar.a = 0;
            xVar.b = false;
            xVar.c = false;
            xVar.d = false;
            a(axVar, state, yVar, xVar);
            if (!xVar.b) {
                yVar.b += xVar.a * yVar.f;
                if (!(xVar.c && this.a.k == null && state.g)) {
                    yVar.c -= xVar.a;
                    i2 -= xVar.a;
                }
                if (yVar.g != SectionHeader.SHT_LOUSER) {
                    yVar.g += xVar.a;
                    if (yVar.c < 0) {
                        yVar.g += yVar.c;
                    }
                    a(axVar, yVar);
                }
                if (z && xVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - yVar.c;
    }

    void a(ax axVar, State state, y yVar, x xVar) {
        View a = yVar.a(axVar);
        if (a == null) {
            xVar.b = true;
            return;
        }
        int q;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        boolean z;
        boolean z2;
        if (yVar.k == null) {
            z = this.k;
            if (yVar.f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                super.a(a, -1, false);
            } else {
                super.a(a, 0, false);
            }
        } else {
            z = this.k;
            if (yVar.f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                super.a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect e = this.q.e(a);
        int i2 = (e.left + e.right) + 0;
        int i3 = (e.bottom + e.top) + 0;
        i2 = LayoutManager.a(this.y, this.w, i2 + (((o() + q()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, e());
        i3 = LayoutManager.a(this.z, this.x, i3 + (((p() + r()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, f());
        if (a(a, i2, i3, layoutParams2)) {
            a.measure(i2, i3);
        }
        xVar.a = this.j.a(a);
        if (this.i == 1) {
            if (g()) {
                q = this.y - q();
                i3 = q - this.j.b(a);
            } else {
                i3 = o();
                q = this.j.b(a) + i3;
            }
            if (yVar.f == -1) {
                int i4 = yVar.b;
                i2 = yVar.b - xVar.a;
                i = i3;
                i3 = q;
                q = i4;
            } else {
                i2 = yVar.b;
                i = i3;
                i3 = q;
                q = yVar.b + xVar.a;
            }
        } else {
            i2 = p();
            q = this.j.b(a) + i2;
            if (yVar.f == -1) {
                i3 = yVar.b;
                i = yVar.b - xVar.a;
            } else {
                i = yVar.b;
                i3 = yVar.b + xVar.a;
            }
        }
        LayoutManager.a(a, i, i2, i3, q);
        if (layoutParams.c.m() || layoutParams.c.s()) {
            xVar.c = true;
        }
        xVar.d = a.isFocusable();
    }

    final boolean i() {
        if (!(this.x == UCCore.VERIFY_POLICY_QUICK || this.w == UCCore.VERIFY_POLICY_QUICK)) {
            boolean z;
            int n = n();
            for (int i = 0; i < n; i++) {
                ViewGroup.LayoutParams layoutParams = e(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final int d(int i) {
        switch (i) {
            case 1:
                if (this.i == 1 || !g()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.i == 1) {
                    return 1;
                }
                if (g()) {
                    return -1;
                }
                return 1;
            case 17:
                return this.i != 0 ? SectionHeader.SHT_LOUSER : -1;
            case 33:
                return this.i != 1 ? SectionHeader.SHT_LOUSER : -1;
            case 66:
                return this.i == 0 ? 1 : SectionHeader.SHT_LOUSER;
            case 130:
                return this.i == 1 ? 1 : SectionHeader.SHT_LOUSER;
            default:
                return SectionHeader.SHT_LOUSER;
        }
    }

    private View w() {
        return e(this.k ? n() - 1 : 0);
    }

    private View x() {
        return e(this.k ? 0 : n() - 1);
    }

    private View a(boolean z) {
        if (this.k) {
            return a(n() - 1, -1, z);
        }
        return a(0, n(), z);
    }

    private View b(boolean z) {
        if (this.k) {
            return a(0, n(), z);
        }
        return a(n() - 1, -1, z);
    }

    private View d(ax axVar, State state) {
        if (this.k) {
            return f(axVar, state);
        }
        return g(axVar, state);
    }

    private View e(ax axVar, State state) {
        if (this.k) {
            return g(axVar, state);
        }
        return f(axVar, state);
    }

    private View f(ax axVar, State state) {
        return a(axVar, state, 0, n(), state.a());
    }

    private View g(ax axVar, State state) {
        return a(axVar, state, n() - 1, -1, state.a());
    }

    View a(ax axVar, State state, int i, int i2, int i3) {
        View view = null;
        h();
        int c = this.j.c();
        int a = this.j.a();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View e = e(i);
            int a2 = LayoutManager.a(e);
            if (a2 >= 0 && a2 < i3) {
                if (((LayoutParams) e.getLayoutParams()).c.m()) {
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

    public final int j() {
        View a = a(0, n(), false);
        return a == null ? -1 : LayoutManager.a(a);
    }

    public final int k() {
        View a = a(n() - 1, -1, false);
        if (a == null) {
            return -1;
        }
        return LayoutManager.a(a);
    }

    private View a(int i, int i2, boolean z) {
        h();
        int c = this.j.c();
        int a = this.j.a();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View e = e(i);
            int d = this.j.d(e);
            int c2 = this.j.c(e);
            if (d < a && c2 > c) {
                if (!z) {
                    return e;
                }
                if (d >= c && c2 <= a) {
                    return e;
                }
                if (view == null) {
                    i += i3;
                    view = e;
                }
            }
            e = view;
            i += i3;
            view = e;
        }
        return view;
    }

    public View a(View view, int i, ax axVar, State state) {
        u();
        if (n() == 0) {
            return null;
        }
        int d = d(i);
        if (d == SectionHeader.SHT_LOUSER) {
            return null;
        }
        View e;
        h();
        if (d == -1) {
            e = e(axVar, state);
        } else {
            e = d(axVar, state);
        }
        if (e == null) {
            return null;
        }
        View w;
        h();
        a(d, (int) (0.33333334f * ((float) this.j.d())), false, state);
        this.a.g = SectionHeader.SHT_LOUSER;
        this.a.a = false;
        a(axVar, this.a, state, true);
        if (d == -1) {
            w = w();
        } else {
            w = x();
        }
        if (w == e || !w.isFocusable()) {
            return null;
        }
        return w;
    }

    public boolean c() {
        return this.n == null && this.b == this.d;
    }
}
