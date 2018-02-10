package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.ad;
import android.support.v4.view.b.w;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.Properties;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.util.List;

/* compiled from: ProGuard */
public class LinearLayoutManager extends LayoutManager {
    int l;
    bo m;
    boolean n;
    int o;
    int p;
    SavedState q;
    final bp r;
    private aa s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    /* compiled from: ProGuard */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new j();
        int a;
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

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.u = false;
        this.n = false;
        this.v = false;
        this.w = true;
        this.o = -1;
        this.p = SectionHeader.SHT_LOUSER;
        this.q = null;
        this.r = new bp(this);
        g(i);
        b(z);
        this.f = true;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.u = false;
        this.n = false;
        this.v = false;
        this.w = true;
        this.o = -1;
        this.p = SectionHeader.SHT_LOUSER;
        this.q = null;
        this.r = new bp(this);
        Properties a = LayoutManager.a(context, attributeSet, i, i2);
        g(a.a);
        b(a.c);
        a(a.d);
        this.f = true;
    }

    public LayoutParams c() {
        return new LayoutParams(-2, -2);
    }

    public final void b(RecyclerView recyclerView, az azVar) {
        super.b(recyclerView, azVar);
        if (this.x) {
            c(azVar);
            azVar.a();
        }
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        int i = -1;
        super.a(accessibilityEvent);
        if (g() > 0) {
            int i2;
            ad a = w.a(accessibilityEvent);
            View a2 = a(0, g(), false);
            if (a2 == null) {
                i2 = -1;
            } else {
                i2 = LayoutManager.a(a2);
            }
            a.b(i2);
            a2 = a(g() - 1, -1, false);
            if (a2 != null) {
                i = LayoutManager.a(a2);
            }
            a.c(i);
        }
    }

    public final Parcelable m() {
        if (this.q != null) {
            return new SavedState(this.q);
        }
        Parcelable savedState = new SavedState();
        if (g() > 0) {
            q();
            boolean z = this.t ^ this.n;
            savedState.c = z;
            View u;
            if (z) {
                u = u();
                savedState.b = this.m.a() - this.m.c(u);
                savedState.a = LayoutManager.a(u);
                return savedState;
            }
            u = t();
            savedState.a = LayoutManager.a(u);
            savedState.b = this.m.d(u) - this.m.c();
            return savedState;
        }
        savedState.a = -1;
        return savedState;
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            a();
        }
    }

    public final boolean d() {
        return this.l == 0;
    }

    public final boolean e() {
        return this.l == 1;
    }

    public void a(boolean z) {
        a(null);
        if (this.v != z) {
            this.v = z;
            a();
        }
    }

    public final void g(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.l) {
                this.l = i;
                this.m = null;
                a();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void r() {
        boolean z = true;
        if (this.l == 1 || !p()) {
            z = this.u;
        } else if (this.u) {
            z = false;
        }
        this.n = z;
    }

    private void b(boolean z) {
        a(null);
        if (z != this.u) {
            this.u = z;
            a();
        }
    }

    public final View b(int i) {
        int g = g();
        if (g == 0) {
            return null;
        }
        int a = i - LayoutManager.a(c(0));
        if (a >= 0 && a < g) {
            View c = c(a);
            if (LayoutManager.a(c) == i) {
                return c;
            }
        }
        return super.b(i);
    }

    private int g(v vVar) {
        int i;
        if (vVar.a != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.m.d();
        }
        return 0;
    }

    public void a(az azVar, v vVar) {
        if (!(this.q == null && this.o == -1) && vVar.a() == 0) {
            c(azVar);
            return;
        }
        Object obj;
        View b;
        int c;
        int a;
        int c2;
        int min;
        int a2;
        if (this.q != null && this.q.a()) {
            this.o = this.q.a;
        }
        q();
        this.s.a = false;
        r();
        bp bpVar = this.r;
        bpVar.a = -1;
        bpVar.b = SectionHeader.SHT_LOUSER;
        bpVar.c = false;
        this.r.c = this.n ^ this.v;
        bp bpVar2 = this.r;
        if (vVar.g || this.o == -1) {
            obj = null;
        } else if (this.o < 0 || this.o >= vVar.a()) {
            this.o = -1;
            this.p = SectionHeader.SHT_LOUSER;
            obj = null;
        } else {
            bpVar2.a = this.o;
            if (this.q == null || !this.q.a()) {
                if (this.p == SectionHeader.SHT_LOUSER) {
                    b = b(this.o);
                    if (b == null) {
                        if (g() > 0) {
                            bpVar2.c = (this.o < LayoutManager.a(c(0))) == this.n;
                        }
                        bpVar2.a();
                    } else if (this.m.a(b) > this.m.d()) {
                        bpVar2.a();
                    } else if (this.m.d(b) - this.m.c() < 0) {
                        bpVar2.b = this.m.c();
                        bpVar2.c = false;
                    } else if (this.m.a() - this.m.c(b) < 0) {
                        bpVar2.b = this.m.a();
                        bpVar2.c = true;
                    } else {
                        if (bpVar2.c) {
                            c = this.m.c(b) + this.m.h();
                        } else {
                            c = this.m.d(b);
                        }
                        bpVar2.b = c;
                    }
                    obj = 1;
                } else {
                    bpVar2.c = this.n;
                    if (this.n) {
                        bpVar2.b = this.m.a() - this.p;
                    } else {
                        bpVar2.b = this.m.c() + this.p;
                    }
                }
                obj = 1;
            } else {
                bpVar2.c = this.q.c;
                if (bpVar2.c) {
                    bpVar2.b = this.m.a() - this.q.b;
                } else {
                    bpVar2.b = this.m.c() + this.q.b;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (g() != 0) {
                View view;
                if (this.b == null) {
                    view = null;
                } else {
                    b = this.b.getFocusedChild();
                    view = (b == null || this.a.d(b)) ? null : b;
                }
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.c.m() || layoutParams.c.c() < 0 || layoutParams.c.c() >= vVar.a()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        c = bpVar2.d.m.h();
                        if (c >= 0) {
                            bpVar2.a(view);
                        } else {
                            bpVar2.a = LayoutManager.a(view);
                            if (bpVar2.c) {
                                c = (bpVar2.d.m.a() - c) - bpVar2.d.m.c(view);
                                bpVar2.b = bpVar2.d.m.a() - c;
                                if (c > 0) {
                                    a = bpVar2.b - bpVar2.d.m.a(view);
                                    c2 = bpVar2.d.m.c();
                                    min = a - (Math.min(bpVar2.d.m.d(view) - c2, 0) + c2);
                                    if (min < 0) {
                                        bpVar2.b = Math.min(c, -min) + bpVar2.b;
                                    }
                                }
                            } else {
                                a = bpVar2.d.m.d(view);
                                c2 = a - bpVar2.d.m.c();
                                bpVar2.b = a;
                                if (c2 > 0) {
                                    c = (bpVar2.d.m.a() - Math.min(0, (bpVar2.d.m.a() - c) - bpVar2.d.m.c(view))) - (a + bpVar2.d.m.a(view));
                                    if (c < 0) {
                                        bpVar2.b -= Math.min(c2, -c);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            bpVar2.a();
                            if (this.v) {
                                c = vVar.a() - 1;
                            } else {
                                c = 0;
                            }
                            bpVar2.a = c;
                        }
                    }
                }
                if (this.t == this.v) {
                    b = bpVar2.c ? d(azVar, vVar) : e(azVar, vVar);
                    if (b != null) {
                        bpVar2.a(b);
                        if (!vVar.g && b()) {
                            obj = (this.m.d(b) >= this.m.a() || this.m.c(b) < this.m.c()) ? 1 : null;
                            if (obj != null) {
                                bpVar2.b = bpVar2.c ? this.m.a() : this.m.c();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            bpVar2.a();
                            if (this.v) {
                                c = 0;
                            } else {
                                c = vVar.a() - 1;
                            }
                            bpVar2.a = c;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                bpVar2.a();
                if (this.v) {
                    c = vVar.a() - 1;
                } else {
                    c = 0;
                }
                bpVar2.a = c;
            }
        }
        c = g(vVar);
        if (this.s.j >= 0) {
            min = 0;
        } else {
            min = c;
            c = 0;
        }
        min += this.m.c();
        c += this.m.e();
        if (!(!vVar.g || this.o == -1 || this.p == SectionHeader.SHT_LOUSER)) {
            View b2 = b(this.o);
            if (b2 != null) {
                if (this.n) {
                    a2 = (this.m.a() - this.m.c(b2)) - this.p;
                } else {
                    a2 = this.p - (this.m.d(b2) - this.m.c());
                }
                if (a2 > 0) {
                    min += a2;
                } else {
                    c -= a2;
                }
            }
        }
        a2 = this.r.c ? this.n ? 1 : -1 : this.n ? -1 : 1;
        a(azVar, vVar, this.r, a2);
        a(azVar);
        this.s.l = s();
        this.s.i = vVar.g;
        if (this.r.c) {
            b(this.r);
            this.s.h = min;
            a(azVar, this.s, vVar, false);
            min = this.s.b;
            a = this.s.d;
            if (this.s.c > 0) {
                c += this.s.c;
            }
            a(this.r);
            this.s.h = c;
            aa aaVar = this.s;
            aaVar.d += this.s.e;
            a(azVar, this.s, vVar, false);
            a2 = this.s.b;
            if (this.s.c > 0) {
                c = this.s.c;
                j(a, min);
                this.s.h = c;
                a(azVar, this.s, vVar, false);
                c = this.s.b;
            } else {
                c = min;
            }
            min = c;
            c = a2;
        } else {
            a(this.r);
            this.s.h = c;
            a(azVar, this.s, vVar, false);
            c = this.s.b;
            a2 = this.s.d;
            if (this.s.c > 0) {
                min += this.s.c;
            }
            b(this.r);
            this.s.h = min;
            aa aaVar2 = this.s;
            aaVar2.d += this.s.e;
            a(azVar, this.s, vVar, false);
            min = this.s.b;
            if (this.s.c > 0) {
                a = this.s.c;
                i(a2, c);
                this.s.h = a;
                a(azVar, this.s, vVar, false);
                c = this.s.b;
            }
        }
        if (g() <= 0) {
            a2 = min;
            min = c;
        } else if ((this.n ^ this.v) != 0) {
            a2 = a(c, azVar, vVar, true);
            min += a2;
            c += a2;
            a2 = b(min, azVar, vVar, false);
            c += a2;
            a2 = min + a2;
            min = c;
        } else {
            a2 = b(min, azVar, vVar, true);
            min += a2;
            c += a2;
            a2 = a(c, azVar, vVar, false);
            c += a2;
            a2 = min + a2;
            min = c;
        }
        if (vVar.i && g() != 0 && !vVar.g && b()) {
            int i = 0;
            c2 = 0;
            List list = azVar.d;
            int size = list.size();
            int a3 = LayoutManager.a(c(0));
            int i2 = 0;
            while (i2 < size) {
                bh bhVar = (bh) list.get(i2);
                if (bhVar.m()) {
                    c = c2;
                    a = i;
                } else {
                    if (((bhVar.c() < a3) != this.n ? -1 : 1) == -1) {
                        a = this.m.a(bhVar.a) + i;
                        c = c2;
                    } else {
                        c = this.m.a(bhVar.a) + c2;
                        a = i;
                    }
                }
                i = a;
                i2++;
                c2 = c;
            }
            this.s.k = list;
            if (i > 0) {
                j(LayoutManager.a(t()), a2);
                this.s.h = i;
                this.s.c = 0;
                this.s.a(null);
                a(azVar, this.s, vVar, false);
            }
            if (c2 > 0) {
                i(LayoutManager.a(u()), min);
                this.s.h = c2;
                this.s.c = 0;
                this.s.a(null);
                a(azVar, this.s, vVar, false);
            }
            this.s.k = null;
        }
        if (!vVar.g) {
            this.o = -1;
            this.p = SectionHeader.SHT_LOUSER;
            bo boVar = this.m;
            boVar.b = boVar.d();
        }
        this.t = this.v;
        this.q = null;
    }

    void a(az azVar, v vVar, bp bpVar, int i) {
    }

    private int a(int i, az azVar, v vVar, boolean z) {
        int a = this.m.a() - i;
        if (a <= 0) {
            return 0;
        }
        a = -c(-a, azVar, vVar);
        int i2 = i + a;
        if (!z) {
            return a;
        }
        i2 = this.m.a() - i2;
        if (i2 <= 0) {
            return a;
        }
        this.m.a(i2);
        return a + i2;
    }

    private int b(int i, az azVar, v vVar, boolean z) {
        int c = i - this.m.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, azVar, vVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.m.c();
        if (i2 <= 0) {
            return c;
        }
        this.m.a(-i2);
        return c - i2;
    }

    private void a(bp bpVar) {
        i(bpVar.a, bpVar.b);
    }

    private void i(int i, int i2) {
        this.s.c = this.m.a() - i2;
        this.s.e = this.n ? -1 : 1;
        this.s.d = i;
        this.s.f = 1;
        this.s.b = i2;
        this.s.g = SectionHeader.SHT_LOUSER;
    }

    private void b(bp bpVar) {
        j(bpVar.a, bpVar.b);
    }

    private void j(int i, int i2) {
        this.s.c = i2 - this.m.c();
        this.s.d = i;
        this.s.e = this.n ? 1 : -1;
        this.s.f = -1;
        this.s.b = i2;
        this.s.g = SectionHeader.SHT_LOUSER;
    }

    protected final boolean p() {
        return ViewCompat.h(this.b) == 1;
    }

    final void q() {
        if (this.s == null) {
            this.s = new aa();
        }
        if (this.m == null) {
            this.m = bo.a(this, this.l);
        }
    }

    public final void a(int i) {
        this.o = i;
        this.p = SectionHeader.SHT_LOUSER;
        if (this.q != null) {
            this.q.a = -1;
        }
        a();
    }

    public int a(int i, az azVar, v vVar) {
        if (this.l == 1) {
            return 0;
        }
        return c(i, azVar, vVar);
    }

    public int b(int i, az azVar, v vVar) {
        if (this.l == 0) {
            return 0;
        }
        return c(i, azVar, vVar);
    }

    public final int b(v vVar) {
        return h(vVar);
    }

    public final int e(v vVar) {
        return h(vVar);
    }

    public final int a(v vVar) {
        return i(vVar);
    }

    public final int d(v vVar) {
        return i(vVar);
    }

    public final int c(v vVar) {
        return j(vVar);
    }

    public final int f(v vVar) {
        return j(vVar);
    }

    private int h(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        q();
        bo boVar = this.m;
        View c = c(!this.w);
        if (this.w) {
            z = false;
        }
        return av.a(vVar, boVar, c, d(z), this, this.w, this.n);
    }

    private int i(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        q();
        bo boVar = this.m;
        View c = c(!this.w);
        if (this.w) {
            z = false;
        }
        return av.a(vVar, boVar, c, d(z), this, this.w);
    }

    private int j(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        q();
        bo boVar = this.m;
        View c = c(!this.w);
        if (this.w) {
            z = false;
        }
        return av.b(vVar, boVar, c, d(z), this, this.w);
    }

    private void a(int i, int i2, boolean z, v vVar) {
        int i3 = -1;
        int i4 = 1;
        this.s.l = s();
        this.s.h = g(vVar);
        this.s.f = i;
        View u;
        aa aaVar;
        if (i == 1) {
            aa aaVar2 = this.s;
            aaVar2.h += this.m.e();
            u = u();
            aaVar = this.s;
            if (!this.n) {
                i3 = 1;
            }
            aaVar.e = i3;
            this.s.d = LayoutManager.a(u) + this.s.e;
            this.s.b = this.m.c(u);
            i3 = this.m.c(u) - this.m.a();
        } else {
            u = t();
            aaVar = this.s;
            aaVar.h += this.m.c();
            aaVar = this.s;
            if (!this.n) {
                i4 = -1;
            }
            aaVar.e = i4;
            this.s.d = LayoutManager.a(u) + this.s.e;
            this.s.b = this.m.d(u);
            i3 = (-this.m.d(u)) + this.m.c();
        }
        this.s.c = i2;
        if (z) {
            aa aaVar3 = this.s;
            aaVar3.c -= i3;
        }
        this.s.g = i3;
    }

    private boolean s() {
        return this.m.f() == 0 && this.m.b() == 0;
    }

    private int c(int i, az azVar, v vVar) {
        if (g() == 0 || i == 0) {
            return 0;
        }
        this.s.a = true;
        q();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, vVar);
        int a = this.s.g + a(azVar, this.s, vVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.m.a(-i);
        this.s.j = i;
        return i;
    }

    public final void a(String str) {
        if (this.q == null) {
            super.a(str);
        }
    }

    private void a(az azVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, azVar);
                }
                return;
            }
            while (i > i2) {
                a(i, azVar);
                i--;
            }
        }
    }

    private void a(az azVar, aa aaVar) {
        if (aaVar.a && !aaVar.l) {
            int i;
            int g;
            int b;
            if (aaVar.f == -1) {
                i = aaVar.g;
                g = g();
                if (i >= 0) {
                    b = this.m.b() - i;
                    if (this.n) {
                        for (i = 0; i < g; i++) {
                            if (this.m.d(c(i)) < b) {
                                a(azVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = g - 1; i >= 0; i--) {
                        if (this.m.d(c(i)) < b) {
                            a(azVar, g - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            g = aaVar.g;
            if (g >= 0) {
                b = g();
                if (this.n) {
                    for (i = b - 1; i >= 0; i--) {
                        if (this.m.c(c(i)) > g) {
                            a(azVar, b - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < b; i++) {
                    if (this.m.c(c(i)) > g) {
                        a(azVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(az azVar, aa aaVar, v vVar, boolean z) {
        int i = aaVar.c;
        if (aaVar.g != SectionHeader.SHT_LOUSER) {
            if (aaVar.c < 0) {
                aaVar.g += aaVar.c;
            }
            a(azVar, aaVar);
        }
        int i2 = aaVar.c + aaVar.h;
        f fVar = new f();
        while (true) {
            if ((!aaVar.l && i2 <= 0) || !aaVar.a(vVar)) {
                break;
            }
            fVar.a = 0;
            fVar.b = false;
            fVar.c = false;
            fVar.d = false;
            a(azVar, vVar, aaVar, fVar);
            if (!fVar.b) {
                aaVar.b += fVar.a * aaVar.f;
                if (!(fVar.c && this.s.k == null && vVar.g)) {
                    aaVar.c -= fVar.a;
                    i2 -= fVar.a;
                }
                if (aaVar.g != SectionHeader.SHT_LOUSER) {
                    aaVar.g += fVar.a;
                    if (aaVar.c < 0) {
                        aaVar.g += aaVar.c;
                    }
                    a(azVar, aaVar);
                }
                if (z && fVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - aaVar.c;
    }

    void a(az azVar, v vVar, aa aaVar, f fVar) {
        View a = aaVar.a(azVar);
        if (a == null) {
            fVar.b = true;
            return;
        }
        int j;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        boolean z;
        boolean z2;
        if (aaVar.k == null) {
            z = this.n;
            if (aaVar.f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                a(a, -1, false);
            } else {
                super.a(a, 0, false);
            }
        } else {
            z = this.n;
            if (aaVar.f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect d = this.b.d(a);
        int i2 = (d.left + d.right) + 0;
        int i3 = (d.bottom + d.top) + 0;
        i2 = LayoutManager.a(this.j, this.h, i2 + (((h() + j()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, d());
        i3 = LayoutManager.a(this.k, this.i, i3 + (((i() + k()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, e());
        if (a(a, i2, i3, layoutParams2)) {
            a.measure(i2, i3);
        }
        fVar.a = this.m.a(a);
        if (this.l == 1) {
            if (p()) {
                j = this.j - j();
                i3 = j - this.m.b(a);
            } else {
                i3 = h();
                j = this.m.b(a) + i3;
            }
            if (aaVar.f == -1) {
                int i4 = aaVar.b;
                i2 = aaVar.b - fVar.a;
                i = i3;
                i3 = j;
                j = i4;
            } else {
                i2 = aaVar.b;
                i = i3;
                i3 = j;
                j = aaVar.b + fVar.a;
            }
        } else {
            i2 = i();
            j = this.m.b(a) + i2;
            if (aaVar.f == -1) {
                i3 = aaVar.b;
                i = aaVar.b - fVar.a;
            } else {
                i = aaVar.b;
                i3 = aaVar.b + fVar.a;
            }
        }
        LayoutManager.a(a, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, j - layoutParams.bottomMargin);
        if (layoutParams.c.m() || layoutParams.c.s()) {
            fVar.c = true;
        }
        fVar.d = a.isFocusable();
    }

    final boolean o() {
        if (!(this.i == UCCore.VERIFY_POLICY_QUICK || this.h == UCCore.VERIFY_POLICY_QUICK)) {
            boolean z;
            int g = g();
            for (int i = 0; i < g; i++) {
                ViewGroup.LayoutParams layoutParams = c(i).getLayoutParams();
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

    final int h(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.l != 0 ? SectionHeader.SHT_LOUSER : -1;
            case 33:
                return this.l != 1 ? SectionHeader.SHT_LOUSER : -1;
            case 66:
                return this.l == 0 ? 1 : SectionHeader.SHT_LOUSER;
            case 130:
                return this.l == 1 ? 1 : SectionHeader.SHT_LOUSER;
            default:
                return SectionHeader.SHT_LOUSER;
        }
    }

    private View t() {
        return c(this.n ? g() - 1 : 0);
    }

    private View u() {
        return c(this.n ? 0 : g() - 1);
    }

    private View c(boolean z) {
        if (this.n) {
            return a(g() - 1, -1, z);
        }
        return a(0, g(), z);
    }

    private View d(boolean z) {
        if (this.n) {
            return a(0, g(), z);
        }
        return a(g() - 1, -1, z);
    }

    private View d(az azVar, v vVar) {
        return this.n ? f(azVar, vVar) : g(azVar, vVar);
    }

    private View e(az azVar, v vVar) {
        return this.n ? g(azVar, vVar) : f(azVar, vVar);
    }

    private View f(az azVar, v vVar) {
        return a(azVar, vVar, 0, g(), vVar.a());
    }

    private View g(az azVar, v vVar) {
        return a(azVar, vVar, g() - 1, -1, vVar.a());
    }

    View a(az azVar, v vVar, int i, int i2, int i3) {
        View view = null;
        q();
        int c = this.m.c();
        int a = this.m.a();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View c2 = c(i);
            int a2 = LayoutManager.a(c2);
            if (a2 >= 0 && a2 < i3) {
                if (((LayoutParams) c2.getLayoutParams()).c.m()) {
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

    private View a(int i, int i2, boolean z) {
        q();
        int c = this.m.c();
        int a = this.m.a();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View c2 = c(i);
            int d = this.m.d(c2);
            int c3 = this.m.c(c2);
            if (d < a && c3 > c) {
                if (!z) {
                    return c2;
                }
                if (d >= c && c3 <= a) {
                    return c2;
                }
                if (view == null) {
                    i += i3;
                    view = c2;
                }
            }
            c2 = view;
            i += i3;
            view = c2;
        }
        return view;
    }

    public View a(View view, int i, az azVar, v vVar) {
        r();
        if (g() == 0) {
            return null;
        }
        int h = h(i);
        if (h == SectionHeader.SHT_LOUSER) {
            return null;
        }
        View e;
        q();
        if (h == -1) {
            e = e(azVar, vVar);
        } else {
            e = d(azVar, vVar);
        }
        if (e == null) {
            return null;
        }
        View t;
        q();
        a(h, (int) (0.33333334f * ((float) this.m.d())), false, vVar);
        this.s.g = SectionHeader.SHT_LOUSER;
        this.s.a = false;
        a(azVar, this.s, vVar, true);
        if (h == -1) {
            t = t();
        } else {
            t = u();
        }
        if (t == e || !t.isFocusable()) {
            return null;
        }
        return t;
    }

    public boolean b() {
        return this.q == null && this.t == this.v;
    }
}
