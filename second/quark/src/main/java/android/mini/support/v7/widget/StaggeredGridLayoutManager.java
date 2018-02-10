package android.mini.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.a.ak;
import android.mini.support.v4.view.a.e;
import android.mini.support.v4.view.a.q;
import android.mini.support.v4.view.a.r;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: ProGuard */
public final class StaggeredGridLayoutManager extends LayoutManager {
    private boolean A;
    private boolean B;
    private int C;
    private final Rect D = new Rect();
    private final bm E = new bm(this);
    private boolean F = false;
    private boolean G = true;
    private final Runnable H = new bk(this);
    public int a = -1;
    public bp[] b;
    @NonNull
    af c;
    @NonNull
    af d;
    public int e;
    boolean f = false;
    public int g = -1;
    public int h = SectionHeader.SHT_LOUSER;
    LazySpanLookup i = new LazySpanLookup();
    public SavedState j;
    private int k;
    @NonNull
    private final u l;
    private boolean m = false;
    private BitSet n;
    private int o = 2;

    /* compiled from: ProGuard */
    public class LayoutParams extends android.mini.support.v7.widget.RecyclerView.LayoutParams {
        bp a;
        public boolean b;

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

        public final int a() {
            if (this.a == null) {
                return -1;
            }
            return this.a.e;
        }
    }

    /* compiled from: ProGuard */
    final class LazySpanLookup {
        int[] a;
        List<FullSpanItem> b;

        /* compiled from: ProGuard */
        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new bn();
            int a;
            int b;
            int[] c;
            boolean d;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            final int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }
        }

        LazySpanLookup() {
        }

        final int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        final int b(int i) {
            if (this.a == null) {
                return -1;
            }
            if (i >= this.a.length) {
                return -1;
            }
            int i2;
            if (this.b != null) {
                FullSpanItem d = d(i);
                if (d != null) {
                    this.b.remove(d);
                }
                int size = this.b.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((FullSpanItem) this.b.get(i3)).a >= i) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    d = (FullSpanItem) this.b.get(i3);
                    this.b.remove(i3);
                    i2 = d.a;
                    if (i2 != -1) {
                        Arrays.fill(this.a, i, this.a.length, -1);
                        return this.a.length;
                    }
                    Arrays.fill(this.a, i, i2 + 1, -1);
                    return i2 + 1;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                Arrays.fill(this.a, i, i2 + 1, -1);
                return i2 + 1;
            }
            Arrays.fill(this.a, i, this.a.length, -1);
            return this.a.length;
        }

        final void c(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                int length = this.a.length;
                while (length <= i) {
                    length *= 2;
                }
                this.a = new int[length];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        final void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        final void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                c(i + i2);
                System.arraycopy(this.a, i + i2, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                if (this.b != null) {
                    int i3 = i + i2;
                    for (int size = this.b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                        if (fullSpanItem.a >= i) {
                            if (fullSpanItem.a < i3) {
                                this.b.remove(size);
                            } else {
                                fullSpanItem.a -= i2;
                            }
                        }
                    }
                }
            }
        }

        final void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                c(i + i2);
                System.arraycopy(this.a, i, this.a, i + i2, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i + i2, -1);
                if (this.b != null) {
                    for (int size = this.b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                        if (fullSpanItem.a >= i) {
                            fullSpanItem.a += i2;
                        }
                    }
                }
            }
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        public final FullSpanItem d(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem a(int i, int i2, int i3) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i && (i3 == 0 || fullSpanItem.b == i3 || fullSpanItem.d)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    /* compiled from: ProGuard */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new bo();
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.j = z2;
            this.g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        public final void a() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            if (this.h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.g);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.e = i2;
        b(i);
        if (this.o == 0) {
            z = false;
        }
        this.u = z;
        this.l = new u();
        this.c = af.a(this, this.e);
        this.d = af.a(this, 1 - this.e);
    }

    private boolean g() {
        if (n() == 0 || this.o == 0 || !this.t) {
            return false;
        }
        int u;
        int v;
        if (this.f) {
            u = u();
            v = v();
        } else {
            u = v();
            v = u();
        }
        if (u == 0 && h() != null) {
            this.i.a();
            this.s = true;
            l();
            return true;
        } else if (!this.F) {
            return false;
        } else {
            int i = this.f ? -1 : 1;
            FullSpanItem a = this.i.a(u, v + 1, i);
            if (a == null) {
                this.F = false;
                this.i.a(v + 1);
                return false;
            }
            FullSpanItem a2 = this.i.a(u, a.a, i * -1);
            if (a2 == null) {
                this.i.a(a.a);
            } else {
                this.i.a(a2.a + 1);
            }
            this.s = true;
            l();
            return true;
        }
    }

    public final void h(int i) {
        if (i == 0) {
            g();
        }
    }

    public final void a(RecyclerView recyclerView, ax axVar) {
        a(this.H);
        for (int i = 0; i < this.a; i++) {
            this.b[i].c();
        }
        recyclerView.requestLayout();
    }

    private View h() {
        int i;
        int i2;
        int n = n() - 1;
        BitSet bitSet = new BitSet(this.a);
        bitSet.set(0, this.a, true);
        boolean z = (this.e == 1 && k()) ? true : true;
        if (this.f) {
            i = -1;
        } else {
            i = n + 1;
            n = 0;
        }
        if (n < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = n;
        while (i3 != i) {
            boolean z2;
            View e = e(i3);
            LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
            if (bitSet.get(layoutParams.a.e)) {
                bp bpVar = layoutParams.a;
                if (this.f) {
                    if (bpVar.b() < this.c.a()) {
                        z2 = !((LayoutParams) ((View) bpVar.a.get(bpVar.a.size() + -1)).getLayoutParams()).b;
                    }
                    z2 = false;
                } else {
                    if (bpVar.a() > this.c.c()) {
                        z2 = !((LayoutParams) ((View) bpVar.a.get(0)).getLayoutParams()).b;
                    }
                    z2 = false;
                }
                if (z2) {
                    return e;
                }
                bitSet.clear(layoutParams.a.e);
            }
            if (!(layoutParams.b || i3 + i2 == i)) {
                View e2 = e(i3 + i2);
                int c;
                if (this.f) {
                    n = this.c.c(e);
                    c = this.c.c(e2);
                    if (n < c) {
                        return e;
                    }
                    if (n == c) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    n = this.c.d(e);
                    c = this.c.d(e2);
                    if (n > c) {
                        return e;
                    }
                    if (n == c) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.a.e - ((LayoutParams) e2.getLayoutParams()).a.e < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return e;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private void b(int i) {
        a(null);
        if (i != this.a) {
            this.i.a();
            l();
            this.a = i;
            this.n = new BitSet(this.a);
            this.b = new bp[this.a];
            for (int i2 = 0; i2 < this.a; i2++) {
                this.b[i2] = new bp(this, i2);
            }
            l();
        }
    }

    public final void a(String str) {
        if (this.j == null) {
            super.a(str);
        }
    }

    private void j() {
        boolean z = true;
        if (this.e == 1 || !k()) {
            z = this.m;
        } else if (this.m) {
            z = false;
        }
        this.f = z;
    }

    private boolean k() {
        return ViewCompat.h(this.q) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int q = q() + o();
        int p = p() + r();
        if (this.e == 1) {
            p = LayoutManager.a(i2, p + rect.height(), ViewCompat.m(this.q));
            q = LayoutManager.a(i, q + (this.k * this.a), ViewCompat.l(this.q));
        } else {
            q = LayoutManager.a(i, q + rect.width(), ViewCompat.l(this.q));
            p = LayoutManager.a(i2, p + (this.k * this.a), ViewCompat.m(this.q));
        }
        h(q, p);
    }

    public final void c(ax axVar, State state) {
        Object obj = 1;
        while (true) {
            bm bmVar = this.E;
            if (!(this.j == null && this.g == -1) && state.a() == 0) {
                c(axVar);
                bmVar.a();
                return;
            }
            int i;
            int i2;
            Object obj2;
            int n;
            int i3;
            if (!(bmVar.e && this.g == -1 && this.j == null)) {
                boolean z;
                bmVar.a();
                if (this.j != null) {
                    if (this.j.c > 0) {
                        if (this.j.c == this.a) {
                            for (i = 0; i < this.a; i++) {
                                this.b[i].c();
                                i2 = this.j.d[i];
                                if (i2 != SectionHeader.SHT_LOUSER) {
                                    if (this.j.i) {
                                        i2 += this.c.a();
                                    } else {
                                        i2 += this.c.c();
                                    }
                                }
                                this.b[i].c(i2);
                            }
                        } else {
                            SavedState savedState = this.j;
                            savedState.d = null;
                            savedState.c = 0;
                            savedState.e = 0;
                            savedState.f = null;
                            savedState.g = null;
                            this.j.a = this.j.b;
                        }
                    }
                    this.B = this.j.j;
                    z = this.j.h;
                    a(null);
                    if (!(this.j == null || this.j.h == z)) {
                        this.j.h = z;
                    }
                    this.m = z;
                    l();
                    j();
                    if (this.j.a != -1) {
                        this.g = this.j.a;
                        bmVar.c = this.j.i;
                    } else {
                        bmVar.c = this.f;
                    }
                    if (this.j.e > 1) {
                        this.i.a = this.j.f;
                        this.i.b = this.j.g;
                    }
                } else {
                    j();
                    bmVar.c = this.f;
                }
                if (state.g || this.g == -1) {
                    obj2 = null;
                } else if (this.g < 0 || this.g >= state.a()) {
                    this.g = -1;
                    this.h = SectionHeader.SHT_LOUSER;
                    obj2 = null;
                } else {
                    if (this.j == null || this.j.a == -1 || this.j.c <= 0) {
                        View a = a(this.g);
                        if (a != null) {
                            if (this.f) {
                                i = u();
                            } else {
                                i = v();
                            }
                            bmVar.a = i;
                            if (this.h != SectionHeader.SHT_LOUSER) {
                                if (bmVar.c) {
                                    bmVar.b = (this.c.a() - this.h) - this.c.c(a);
                                } else {
                                    bmVar.b = (this.c.c() + this.h) - this.c.d(a);
                                }
                                obj2 = 1;
                            } else if (this.c.a(a) > this.c.d()) {
                                if (bmVar.c) {
                                    i = this.c.a();
                                } else {
                                    i = this.c.c();
                                }
                                bmVar.b = i;
                            } else {
                                i = this.c.d(a) - this.c.c();
                                if (i < 0) {
                                    bmVar.b = -i;
                                } else {
                                    i = this.c.a() - this.c.c(a);
                                    if (i < 0) {
                                        bmVar.b = i;
                                    } else {
                                        bmVar.b = SectionHeader.SHT_LOUSER;
                                    }
                                }
                            }
                        } else {
                            bmVar.a = this.g;
                            if (this.h == SectionHeader.SHT_LOUSER) {
                                if (m(bmVar.a) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                bmVar.c = z;
                                if (bmVar.c) {
                                    i = bmVar.f.c.a();
                                } else {
                                    i = bmVar.f.c.c();
                                }
                                bmVar.b = i;
                            } else {
                                i = this.h;
                                if (bmVar.c) {
                                    bmVar.b = bmVar.f.c.a() - i;
                                } else {
                                    bmVar.b = i + bmVar.f.c.c();
                                }
                            }
                            bmVar.d = true;
                        }
                    } else {
                        bmVar.b = SectionHeader.SHT_LOUSER;
                        bmVar.a = this.g;
                    }
                    obj2 = 1;
                }
                if (obj2 == null) {
                    int a2;
                    if (this.A) {
                        a2 = state.a();
                        for (i2 = n() - 1; i2 >= 0; i2--) {
                            i = LayoutManager.a(e(i2));
                            if (i >= 0 && i < a2) {
                                break;
                            }
                        }
                        i = 0;
                    } else {
                        a2 = state.a();
                        n = n();
                        for (i2 = 0; i2 < n; i2++) {
                            i = LayoutManager.a(e(i2));
                            if (i >= 0 && i < a2) {
                                break;
                            }
                        }
                        i = 0;
                    }
                    bmVar.a = i;
                    bmVar.b = SectionHeader.SHT_LOUSER;
                }
                bmVar.e = true;
            }
            if (this.j == null && this.g == -1 && !(bmVar.c == this.A && k() == this.B)) {
                this.i.a();
                bmVar.d = true;
            }
            if (n() > 0 && (this.j == null || this.j.c <= 0)) {
                if (bmVar.d) {
                    for (i = 0; i < this.a; i++) {
                        this.b[i].c();
                        if (bmVar.b != SectionHeader.SHT_LOUSER) {
                            this.b[i].c(bmVar.b);
                        }
                    }
                } else {
                    for (i = 0; i < this.a; i++) {
                        bp bpVar = this.b[i];
                        boolean z2 = this.f;
                        i3 = bmVar.b;
                        if (z2) {
                            i2 = bpVar.b((int) SectionHeader.SHT_LOUSER);
                        } else {
                            i2 = bpVar.a((int) SectionHeader.SHT_LOUSER);
                        }
                        bpVar.c();
                        if (i2 != SectionHeader.SHT_LOUSER && ((!z2 || i2 >= bpVar.f.c.a()) && (z2 || i2 <= bpVar.f.c.c()))) {
                            if (i3 != SectionHeader.SHT_LOUSER) {
                                i2 += i3;
                            }
                            bpVar.c = i2;
                            bpVar.b = i2;
                        }
                    }
                }
            }
            a(axVar);
            this.l.a = false;
            this.F = false;
            d(this.d.d());
            a(bmVar.a, state);
            if (bmVar.c) {
                i(-1);
                a(axVar, this.l, state);
                i(1);
                this.l.c = bmVar.a + this.l.d;
                a(axVar, this.l, state);
            } else {
                i(1);
                a(axVar, this.l, state);
                i(-1);
                this.l.c = bmVar.a + this.l.d;
                a(axVar, this.l, state);
            }
            if (this.d.f() != UCCore.VERIFY_POLICY_QUICK) {
                float f = 0.0f;
                i3 = n();
                n = 0;
                while (n < i3) {
                    float f2;
                    View e = e(n);
                    float a3 = (float) this.d.a(e);
                    if (a3 >= f) {
                        if (((LayoutParams) e.getLayoutParams()).b) {
                            f2 = (IPictureView.DEFAULT_MIN_SCALE * a3) / ((float) this.a);
                        } else {
                            f2 = a3;
                        }
                        f2 = Math.max(f, f2);
                    } else {
                        f2 = f;
                    }
                    n++;
                    f = f2;
                }
                n = this.k;
                i = Math.round(((float) this.a) * f);
                if (this.d.f() == SectionHeader.SHT_LOUSER) {
                    i = Math.min(i, this.d.d());
                }
                d(i);
                if (this.k != n) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View e2 = e(i2);
                        LayoutParams layoutParams = (LayoutParams) e2.getLayoutParams();
                        if (!layoutParams.b) {
                            if (k() && this.e == 1) {
                                e2.offsetLeftAndRight(((-((this.a - 1) - layoutParams.a.e)) * this.k) - ((-((this.a - 1) - layoutParams.a.e)) * n));
                            } else {
                                int i4 = layoutParams.a.e * this.k;
                                i = layoutParams.a.e * n;
                                if (this.e == 1) {
                                    e2.offsetLeftAndRight(i4 - i);
                                } else {
                                    e2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (n() > 0) {
                if (this.f) {
                    a(axVar, state, true);
                    b(axVar, state, false);
                } else {
                    b(axVar, state, true);
                    a(axVar, state, false);
                }
            }
            obj2 = null;
            if (!(obj == null || state.g)) {
                obj = (this.o == 0 || n() <= 0 || (!this.F && h() == null)) ? null : 1;
                if (obj != null) {
                    a(this.H);
                    if (g()) {
                        obj2 = 1;
                    }
                }
            }
            if (state.g) {
                this.E.a();
            }
            this.A = bmVar.c;
            this.B = k();
            if (obj2 != null) {
                this.E.a();
                obj = null;
            } else {
                return;
            }
        }
    }

    public final void a(State state) {
        super.a(state);
        this.g = -1;
        this.h = SectionHeader.SHT_LOUSER;
        this.j = null;
        this.E.a();
    }

    private void d(int i) {
        this.k = i / this.a;
        this.C = MeasureSpec.makeMeasureSpec(i, this.d.f());
    }

    public final boolean c() {
        return this.j == null;
    }

    public final int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.a];
        } else if (iArr.length < this.a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.a; i++) {
            iArr[i] = this.b[i].f();
        }
        return iArr;
    }

    public final int b(State state) {
        return h(state);
    }

    private int h(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        af afVar = this.c;
        View a = a(!this.G);
        if (this.G) {
            z = false;
        }
        return bi.a(state, afVar, a, b(z), this, this.G, this.f);
    }

    public final int c(State state) {
        return h(state);
    }

    public final int d(State state) {
        return i(state);
    }

    private int i(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        af afVar = this.c;
        View a = a(!this.G);
        if (this.G) {
            z = false;
        }
        return bi.a(state, afVar, a, b(z), this, this.G);
    }

    public final int e(State state) {
        return i(state);
    }

    public final int f(State state) {
        return j(state);
    }

    private int j(State state) {
        boolean z = true;
        if (n() == 0) {
            return 0;
        }
        af afVar = this.c;
        View a = a(!this.G);
        if (this.G) {
            z = false;
        }
        return bi.b(state, afVar, a, b(z), this, this.G);
    }

    public final int g(State state) {
        return j(state);
    }

    private void a(View view, int i, int i2) {
        b(view, this.D);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int c = c(i, layoutParams.leftMargin + this.D.left, layoutParams.rightMargin + this.D.right);
        int c2 = c(i2, layoutParams.topMargin + this.D.top, layoutParams.bottomMargin + this.D.bottom);
        if (a(view, c, c2, (android.mini.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
            view.measure(c, c2);
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

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.j = (SavedState) parcelable;
            l();
        }
    }

    public final Parcelable d() {
        if (this.j != null) {
            return new SavedState(this.j);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.m;
        savedState.i = this.A;
        savedState.j = this.B;
        if (this.i == null || this.i.a == null) {
            savedState.e = 0;
        } else {
            savedState.f = this.i.a;
            savedState.e = savedState.f.length;
            savedState.g = this.i.b;
        }
        if (n() > 0) {
            int u;
            View b;
            if (this.A) {
                u = u();
            } else {
                u = v();
            }
            savedState.a = u;
            if (this.f) {
                b = b(true);
            } else {
                b = a(true);
            }
            if (b == null) {
                u = -1;
            } else {
                u = LayoutManager.a(b);
            }
            savedState.b = u;
            savedState.c = this.a;
            savedState.d = new int[this.a];
            for (u = 0; u < this.a; u++) {
                int b2;
                if (this.A) {
                    b2 = this.b[u].b((int) SectionHeader.SHT_LOUSER);
                    if (b2 != SectionHeader.SHT_LOUSER) {
                        b2 -= this.c.a();
                    }
                } else {
                    b2 = this.b[u].a((int) SectionHeader.SHT_LOUSER);
                    if (b2 != SectionHeader.SHT_LOUSER) {
                        b2 -= this.c.c();
                    }
                }
                savedState.d[u] = b2;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    public final void a(ax axVar, State state, View view, r rVar) {
        int i = 1;
        int i2 = -1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int a;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.e == 0) {
                a = layoutParams2.a();
                if (layoutParams2.b) {
                    i = this.a;
                }
                i3 = a;
                a = i;
                i = -1;
            } else {
                a = layoutParams2.a();
                if (layoutParams2.b) {
                    i = this.a;
                    i3 = -1;
                    i2 = a;
                    a = -1;
                } else {
                    i3 = -1;
                    i2 = a;
                    a = -1;
                }
            }
            rVar.a(q.a(i3, a, i2, i, layoutParams2.b));
            return;
        }
        super.a(view, rVar);
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (n() > 0) {
            ak a = e.a(accessibilityEvent);
            View a2 = a(false);
            View b = b(false);
            if (a2 != null && b != null) {
                int a3 = LayoutManager.a(a2);
                int a4 = LayoutManager.a(b);
                if (a3 < a4) {
                    a.b(a3);
                    a.c(a4);
                    return;
                }
                a.b(a4);
                a.c(a3);
            }
        }
    }

    public final int a(ax axVar, State state) {
        if (this.e == 0) {
            return this.a;
        }
        return super.a(axVar, state);
    }

    public final int b(ax axVar, State state) {
        if (this.e == 1) {
            return this.a;
        }
        return super.b(axVar, state);
    }

    private View a(boolean z) {
        int c = this.c.c();
        int a = this.c.a();
        int n = n();
        View view = null;
        int i = 0;
        while (i < n) {
            View e = e(i);
            int d = this.c.d(e);
            if (this.c.c(e) > c && d < a) {
                if (d >= c || !z) {
                    return e;
                }
                if (view == null) {
                    i++;
                    view = e;
                }
            }
            e = view;
            i++;
            view = e;
        }
        return view;
    }

    private View b(boolean z) {
        int c = this.c.c();
        int a = this.c.a();
        View view = null;
        int n = n() - 1;
        while (n >= 0) {
            View e = e(n);
            int d = this.c.d(e);
            int c2 = this.c.c(e);
            if (c2 > c && d < a) {
                if (c2 <= a || !z) {
                    return e;
                }
                if (view == null) {
                    n--;
                    view = e;
                }
            }
            e = view;
            n--;
            view = e;
        }
        return view;
    }

    private void a(ax axVar, State state, boolean z) {
        int k = k(SectionHeader.SHT_LOUSER);
        if (k != SectionHeader.SHT_LOUSER) {
            k = this.c.a() - k;
            if (k > 0) {
                k -= -c(-k, axVar, state);
                if (z && k > 0) {
                    this.c.a(k);
                }
            }
        }
    }

    private void b(ax axVar, State state, boolean z) {
        int j = j(Integer.MAX_VALUE);
        if (j != Integer.MAX_VALUE) {
            j -= this.c.c();
            if (j > 0) {
                j -= c(j, axVar, state);
                if (z && j > 0) {
                    this.c.a(-j);
                }
            }
        }
    }

    private void a(int i, State state) {
        int i2;
        int i3;
        boolean z;
        u uVar;
        boolean z2 = false;
        this.l.b = 0;
        this.l.c = i;
        if (m()) {
            i2 = state.a;
            if (i2 != -1) {
                if (this.f == (i2 < i)) {
                    i2 = this.c.d();
                    i3 = 0;
                } else {
                    i3 = this.c.d();
                    i2 = 0;
                }
                if (this.q == null && this.q.z) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.l.g = i2 + this.c.b();
                    this.l.f = -i3;
                } else {
                    this.l.f = this.c.c() - i3;
                    this.l.g = i2 + this.c.a();
                }
                this.l.h = false;
                this.l.a = true;
                uVar = this.l;
                if (this.c.f() == 0 && this.c.b() == 0) {
                    z2 = true;
                }
                uVar.i = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.q == null) {
        }
        z = false;
        if (z) {
            this.l.g = i2 + this.c.b();
            this.l.f = -i3;
        } else {
            this.l.f = this.c.c() - i3;
            this.l.g = i2 + this.c.a();
        }
        this.l.h = false;
        this.l.a = true;
        uVar = this.l;
        z2 = true;
        uVar.i = z2;
    }

    private void i(int i) {
        int i2 = 1;
        this.l.e = i;
        u uVar = this.l;
        if (this.f != (i == -1)) {
            i2 = -1;
        }
        uVar.d = i2;
    }

    public final void f(int i) {
        super.f(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2].d(i);
        }
    }

    public final void g(int i) {
        super.g(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2].d(i);
        }
    }

    public final void b(int i, int i2) {
        d(i, i2, 2);
    }

    public final void a(int i, int i2) {
        d(i, i2, 1);
    }

    public final void a() {
        this.i.a();
        l();
    }

    public final void d(int i, int i2) {
        d(i, i2, 8);
    }

    public final void c(int i, int i2) {
        d(i, i2, 4);
    }

    private void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int u = this.f ? u() : v();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.i.b(i5);
        switch (i3) {
            case 1:
                this.i.b(i, i2);
                break;
            case 2:
                this.i.a(i, i2);
                break;
            case 8:
                this.i.a(i, 1);
                this.i.b(i2, 1);
                break;
        }
        if (i4 > u) {
            if (i5 <= (this.f ? v() : u())) {
                l();
            }
        }
    }

    private int a(ax axVar, u uVar, State state) {
        int i;
        int a;
        int c;
        this.n.set(0, this.a, true);
        if (this.l.i) {
            i = uVar.e == 1 ? Integer.MAX_VALUE : SectionHeader.SHT_LOUSER;
        } else if (uVar.e == 1) {
            i = uVar.g + uVar.b;
        } else {
            i = uVar.f - uVar.b;
        }
        i(uVar.e, i);
        if (this.f) {
            a = this.c.a();
        } else {
            a = this.c.c();
        }
        Object obj = null;
        while (true) {
            Object obj2;
            if (uVar.c < 0 || uVar.c >= state.a()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null && (this.l.i || !this.n.isEmpty())) {
                Object obj3;
                bp bpVar;
                int i2;
                int i3;
                int b;
                View b2 = axVar.b(uVar.c);
                uVar.c += uVar.d;
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                int c2 = layoutParams.c.c();
                LazySpanLookup lazySpanLookup = this.i;
                int i4 = (lazySpanLookup.a == null || c2 >= lazySpanLookup.a.length) ? -1 : lazySpanLookup.a[c2];
                if (i4 == -1) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    if (layoutParams.b) {
                        bpVar = this.b[0];
                    } else {
                        if (l(uVar.e)) {
                            i4 = this.a - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.a;
                            i3 = 1;
                        }
                        int i5;
                        int c3;
                        int i6;
                        bp bpVar2;
                        int i7;
                        if (uVar.e == 1) {
                            bpVar = null;
                            i5 = Integer.MAX_VALUE;
                            c3 = this.c.c();
                            i6 = i4;
                            while (i6 != i2) {
                                bpVar2 = this.b[i6];
                                b = bpVar2.b(c3);
                                if (b < i5) {
                                    i7 = b;
                                } else {
                                    bpVar2 = bpVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bpVar = bpVar2;
                            }
                        } else {
                            bpVar = null;
                            i5 = SectionHeader.SHT_LOUSER;
                            c3 = this.c.a();
                            i6 = i4;
                            while (i6 != i2) {
                                bpVar2 = this.b[i6];
                                b = bpVar2.a(c3);
                                if (b > i5) {
                                    i7 = b;
                                } else {
                                    bpVar2 = bpVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bpVar = bpVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.i;
                    lazySpanLookup.c(c2);
                    lazySpanLookup.a[c2] = bpVar.e;
                } else {
                    bpVar = this.b[i4];
                }
                layoutParams.a = bpVar;
                if (uVar.e == 1) {
                    super.a(b2, -1, false);
                } else {
                    super.a(b2, 0, false);
                }
                if (layoutParams.b) {
                    if (this.e == 1) {
                        a(b2, this.C, LayoutManager.a(this.z, this.x, 0, layoutParams.height, true));
                    } else {
                        a(b2, LayoutManager.a(this.y, this.w, 0, layoutParams.width, true), this.C);
                    }
                } else if (this.e == 1) {
                    a(b2, LayoutManager.a(this.k, this.w, 0, layoutParams.width, false), LayoutManager.a(this.z, this.x, 0, layoutParams.height, true));
                } else {
                    a(b2, LayoutManager.a(this.y, this.w, 0, layoutParams.width, true), LayoutManager.a(this.k, this.x, 0, layoutParams.height, false));
                }
                FullSpanItem fullSpanItem;
                if (uVar.e == 1) {
                    if (layoutParams.b) {
                        i3 = k(a);
                    } else {
                        i3 = bpVar.b(a);
                    }
                    i2 = i3 + this.c.a(b2);
                    if (obj3 == null || !layoutParams.b) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.a];
                        for (i4 = 0; i4 < this.a; i4++) {
                            fullSpanItem.c[i4] = i3 - this.b[i4].b(i3);
                        }
                        fullSpanItem.b = -1;
                        fullSpanItem.a = c2;
                        this.i.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    if (layoutParams.b) {
                        i3 = j(a);
                    } else {
                        i3 = bpVar.a(a);
                    }
                    i2 = i3 - this.c.a(b2);
                    if (obj3 != null && layoutParams.b) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.a];
                        for (i4 = 0; i4 < this.a; i4++) {
                            fullSpanItem.c[i4] = this.b[i4].a(i3) - i3;
                        }
                        fullSpanItem.b = 1;
                        fullSpanItem.a = c2;
                        this.i.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (layoutParams.b && uVar.d == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (uVar.e == 1) {
                            b = this.b[0].b((int) SectionHeader.SHT_LOUSER);
                            for (i2 = 1; i2 < this.a; i2++) {
                                if (this.b[i2].b((int) SectionHeader.SHT_LOUSER) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            b = this.b[0].a((int) SectionHeader.SHT_LOUSER);
                            for (i2 = 1; i2 < this.a; i2++) {
                                if (this.b[i2].a((int) SectionHeader.SHT_LOUSER) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem d = this.i.d(c2);
                            if (d != null) {
                                d.d = true;
                            }
                        }
                    }
                    this.F = true;
                }
                if (uVar.e == 1) {
                    if (layoutParams.b) {
                        for (i2 = this.a - 1; i2 >= 0; i2--) {
                            this.b[i2].b(b2);
                        }
                    } else {
                        layoutParams.a.b(b2);
                    }
                } else if (layoutParams.b) {
                    for (i2 = this.a - 1; i2 >= 0; i2--) {
                        this.b[i2].a(b2);
                    }
                } else {
                    layoutParams.a.a(b2);
                }
                if (k() && this.e == 1) {
                    if (layoutParams.b) {
                        i2 = this.d.a();
                    } else {
                        i2 = this.d.a() - (((this.a - 1) - bpVar.e) * this.k);
                    }
                    b = i2;
                    i2 -= this.d.a(b2);
                } else {
                    if (layoutParams.b) {
                        i2 = this.d.c();
                    } else {
                        i2 = (bpVar.e * this.k) + this.d.c();
                    }
                    b = this.d.a(b2) + i2;
                }
                if (this.e == 1) {
                    LayoutManager.a(b2, i2, i4, b, i3);
                } else {
                    LayoutManager.a(b2, i4, i2, i3, b);
                }
                if (layoutParams.b) {
                    i(this.l.e, i);
                } else {
                    a(bpVar, this.l.e, i);
                }
                a(axVar, this.l);
                if (this.l.h && b2.isFocusable()) {
                    if (layoutParams.b) {
                        this.n.clear();
                    } else {
                        this.n.set(bpVar.e, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(axVar, this.l);
            }
        }
        if (obj == null) {
            a(axVar, this.l);
        }
        if (this.l.e == -1) {
            c = this.c.c() - j(this.c.c());
        } else {
            c = k(this.c.a()) - this.c.a();
        }
        return c > 0 ? Math.min(uVar.b, c) : 0;
    }

    private void a(ax axVar, u uVar) {
        int i = 1;
        if (uVar.a && !uVar.i) {
            if (uVar.b == 0) {
                if (uVar.e == -1) {
                    b(axVar, uVar.g);
                } else {
                    a(axVar, uVar.f);
                }
            } else if (uVar.e == -1) {
                r3 = uVar.f;
                int i2 = uVar.f;
                r1 = this.b[0].a(i2);
                while (i < this.a) {
                    r2 = this.b[i].a(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                if (i < 0) {
                    i = uVar.g;
                } else {
                    i = uVar.g - Math.min(i, uVar.b);
                }
                b(axVar, i);
            } else {
                r3 = uVar.g;
                r1 = this.b[0].b(r3);
                while (i < this.a) {
                    r2 = this.b[i].b(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - uVar.g;
                if (i < 0) {
                    i = uVar.f;
                } else {
                    i = Math.min(i, uVar.b) + uVar.f;
                }
                a(axVar, i);
            }
        }
    }

    private void i(int i, int i2) {
        for (int i3 = 0; i3 < this.a; i3++) {
            if (!this.b[i3].a.isEmpty()) {
                a(this.b[i3], i, i2);
            }
        }
    }

    private void a(bp bpVar, int i, int i2) {
        int i3 = bpVar.d;
        if (i == -1) {
            if (i3 + bpVar.a() <= i2) {
                this.n.set(bpVar.e, false);
            }
        } else if (bpVar.b() - i3 >= i2) {
            this.n.set(bpVar.e, false);
        }
    }

    private int j(int i) {
        int a = this.b[0].a(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int a2 = this.b[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int k(int i) {
        int b = this.b[0].b(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int b2 = this.b[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void a(ax axVar, int i) {
        while (n() > 0) {
            View e = e(0);
            if (this.c.c(e) <= i && this.c.e(e) <= i) {
                LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.a) {
                        if (this.b[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.a; i2++) {
                        this.b[i2].e();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.e();
                } else {
                    return;
                }
                a(e, axVar);
            } else {
                return;
            }
        }
    }

    private void b(ax axVar, int i) {
        int n = n() - 1;
        while (n >= 0) {
            View e = e(n);
            if (this.c.d(e) >= i && this.c.f(e) >= i) {
                LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.a) {
                        if (this.b[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.a; i2++) {
                        this.b[i2].d();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.d();
                } else {
                    return;
                }
                a(e, axVar);
                n--;
            } else {
                return;
            }
        }
    }

    private boolean l(int i) {
        if (this.e == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f) != k()) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        return this.e == 1;
    }

    public final boolean e() {
        return this.e == 0;
    }

    public final int a(int i, ax axVar, State state) {
        return c(i, axVar, state);
    }

    public final int b(int i, ax axVar, State state) {
        return c(i, axVar, state);
    }

    private int m(int i) {
        if (n() != 0) {
            if ((i < v()) != this.f) {
                return -1;
            }
            return 1;
        } else if (this.f) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        bc blVar = new bl(this, recyclerView.getContext());
        blVar.g = i;
        a(blVar);
    }

    public final void c(int i) {
        if (!(this.j == null || this.j.a == i)) {
            this.j.a();
        }
        this.g = i;
        this.h = SectionHeader.SHT_LOUSER;
        l();
    }

    private int c(int i, ax axVar, State state) {
        int u;
        int i2;
        if (i > 0) {
            u = u();
            i2 = 1;
        } else {
            i2 = -1;
            u = v();
        }
        this.l.a = true;
        a(u, state);
        i(i2);
        this.l.c = this.l.d + u;
        int abs = Math.abs(i);
        this.l.b = abs;
        i2 = a(axVar, this.l, state);
        if (abs >= i2) {
            if (i < 0) {
                i = -i2;
            } else {
                i = i2;
            }
        }
        this.c.a(-i);
        this.A = this.f;
        return i;
    }

    private int u() {
        int n = n();
        return n == 0 ? 0 : LayoutManager.a(e(n - 1));
    }

    private int v() {
        if (n() == 0) {
            return 0;
        }
        return LayoutManager.a(e(0));
    }

    public final android.mini.support.v7.widget.RecyclerView.LayoutParams b() {
        if (this.e == 0) {
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

    @Nullable
    public final View a(View view, int i, ax axVar, State state) {
        int i2 = 0;
        if (n() == 0) {
            return null;
        }
        View b = b(view);
        if (b == null) {
            return null;
        }
        int i3;
        j();
        switch (i) {
            case 1:
                if (this.e != 1) {
                    if (!k()) {
                        i3 = -1;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = -1;
                break;
            case 2:
                if (this.e != 1) {
                    if (!k()) {
                        i3 = 1;
                        break;
                    }
                    i3 = -1;
                    break;
                }
                i3 = 1;
                break;
            case 17:
                if (this.e != 0) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.e != 1) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.e != 0) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.e != 1) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = SectionHeader.SHT_LOUSER;
                break;
        }
        if (i3 == SectionHeader.SHT_LOUSER) {
            return null;
        }
        int u;
        View a;
        LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
        boolean z = layoutParams.b;
        bp bpVar = layoutParams.a;
        if (i3 == 1) {
            u = u();
        } else {
            u = v();
        }
        a(u, state);
        i(i3);
        this.l.c = this.l.d + u;
        this.l.b = (int) (0.33333334f * ((float) this.c.d()));
        this.l.h = true;
        this.l.a = false;
        a(axVar, this.l, state);
        this.A = this.f;
        if (!z) {
            a = bpVar.a(u, i3);
            if (!(a == null || a == b)) {
                return a;
            }
        }
        if (l(i3)) {
            for (int i4 = this.a - 1; i4 >= 0; i4--) {
                View a2 = this.b[i4].a(u, i3);
                if (a2 != null && a2 != b) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.a) {
                a = this.b[i2].a(u, i3);
                if (a != null && a != b) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }
}
