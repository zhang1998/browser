package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.ad;
import android.support.v4.view.b.l;
import android.support.v4.view.b.s;
import android.support.v4.view.b.w;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.Properties;
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
public class StaggeredGridLayoutManager extends LayoutManager {
    private boolean A;
    private SavedState B;
    private int C;
    private final Rect D = new Rect();
    private final bc E = new bc();
    private boolean F = false;
    private boolean G = true;
    private final Runnable H = new bj(this);
    @NonNull
    bo l;
    @NonNull
    bo m;
    boolean n = false;
    int o = -1;
    int p = SectionHeader.SHT_LOUSER;
    LazySpanLookup q = new LazySpanLookup();
    private int r = -1;
    private aq[] s;
    private int t;
    private int u;
    @NonNull
    private final as v;
    private boolean w = false;
    private BitSet x;
    private int y = 2;
    private boolean z;

    /* compiled from: ProGuard */
    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        aq a;
        boolean b;

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
            public static final Creator<FullSpanItem> CREATOR = new bb();
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
        public static final Creator<SavedState> CREATOR = new ak();
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

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        Properties a = LayoutManager.a(context, attributeSet, i, i2);
        int i3 = a.a;
        if (i3 == 0 || i3 == 1) {
            a(null);
            if (i3 != this.t) {
                this.t = i3;
                bo boVar = this.l;
                this.l = this.m;
                this.m = boVar;
                a();
            }
            g(a.b);
            a(a.c);
            if (this.y == 0) {
                z = false;
            }
            this.f = z;
            this.v = new as();
            p();
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.t = i2;
        g(i);
        if (this.y == 0) {
            z = false;
        }
        this.f = z;
        this.v = new as();
        p();
    }

    private void p() {
        this.l = bo.a(this, this.t);
        this.m = bo.a(this, 1 - this.t);
    }

    private boolean q() {
        if (g() == 0 || this.y == 0 || !this.e) {
            return false;
        }
        int u;
        int v;
        if (this.n) {
            u = u();
            v = v();
        } else {
            u = v();
            v = u();
        }
        if (u == 0 && r() != null) {
            this.q.a();
            this.d = true;
            a();
            return true;
        } else if (!this.F) {
            return false;
        } else {
            int i = this.n ? -1 : 1;
            FullSpanItem a = this.q.a(u, v + 1, i);
            if (a == null) {
                this.F = false;
                this.q.a(v + 1);
                return false;
            }
            FullSpanItem a2 = this.q.a(u, a.a, i * -1);
            if (a2 == null) {
                this.q.a(a.a);
            } else {
                this.q.a(a2.a + 1);
            }
            this.d = true;
            a();
            return true;
        }
    }

    public final void f(int i) {
        if (i == 0) {
            q();
        }
    }

    public final void b(RecyclerView recyclerView, az azVar) {
        a(this.H);
        for (int i = 0; i < this.r; i++) {
            this.s[i].c();
        }
    }

    private View r() {
        int i;
        int i2;
        int g = g() - 1;
        BitSet bitSet = new BitSet(this.r);
        bitSet.set(0, this.r, true);
        boolean z = (this.t == 1 && t()) ? true : true;
        if (this.n) {
            i = -1;
        } else {
            i = g + 1;
            g = 0;
        }
        if (g < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = g;
        while (i3 != i) {
            boolean z2;
            View c = c(i3);
            LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
            if (bitSet.get(layoutParams.a.e)) {
                aq aqVar = layoutParams.a;
                if (this.n) {
                    if (aqVar.b() < this.l.a()) {
                        z2 = !((LayoutParams) ((View) aqVar.a.get(aqVar.a.size() + -1)).getLayoutParams()).b;
                    }
                    z2 = false;
                } else {
                    if (aqVar.a() > this.l.c()) {
                        z2 = !((LayoutParams) ((View) aqVar.a.get(0)).getLayoutParams()).b;
                    }
                    z2 = false;
                }
                if (z2) {
                    return c;
                }
                bitSet.clear(layoutParams.a.e);
            }
            if (!(layoutParams.b || i3 + i2 == i)) {
                View c2 = c(i3 + i2);
                int c3;
                if (this.n) {
                    g = this.l.c(c);
                    c3 = this.l.c(c2);
                    if (g < c3) {
                        return c;
                    }
                    if (g == c3) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    g = this.l.d(c);
                    c3 = this.l.d(c2);
                    if (g > c3) {
                        return c;
                    }
                    if (g == c3) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.a.e - ((LayoutParams) c2.getLayoutParams()).a.e < 0) {
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
                        return c;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private void g(int i) {
        a(null);
        if (i != this.r) {
            this.q.a();
            a();
            this.r = i;
            this.x = new BitSet(this.r);
            this.s = new aq[this.r];
            for (int i2 = 0; i2 < this.r; i2++) {
                this.s[i2] = new aq(this, i2);
            }
            a();
        }
    }

    private void a(boolean z) {
        a(null);
        if (!(this.B == null || this.B.h == z)) {
            this.B.h = z;
        }
        this.w = z;
        a();
    }

    public final void a(String str) {
        if (this.B == null) {
            super.a(str);
        }
    }

    private void s() {
        boolean z = true;
        if (this.t == 1 || !t()) {
            z = this.w;
        } else if (this.w) {
            z = false;
        }
        this.n = z;
    }

    private boolean t() {
        return ViewCompat.h(this.b) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int j = j() + h();
        int i3 = i() + k();
        if (this.t == 1) {
            i3 = LayoutManager.a(i2, i3 + rect.height(), ViewCompat.p(this.b));
            j = LayoutManager.a(i, j + (this.u * this.r), ViewCompat.o(this.b));
        } else {
            j = LayoutManager.a(i, j + rect.width(), ViewCompat.o(this.b));
            i3 = LayoutManager.a(i2, i3 + (this.u * this.r), ViewCompat.p(this.b));
        }
        h(j, i3);
    }

    public final void a(az azVar, v vVar) {
        Object obj = 1;
        while (true) {
            bc bcVar = this.E;
            bcVar.a = -1;
            bcVar.b = SectionHeader.SHT_LOUSER;
            bcVar.c = false;
            bcVar.d = false;
            if (!(this.B == null && this.o == -1) && vVar.a() == 0) {
                c(azVar);
                return;
            }
            int i;
            int i2;
            Object obj2;
            int g;
            int i3;
            if (this.B != null) {
                if (this.B.c > 0) {
                    if (this.B.c == this.r) {
                        for (i = 0; i < this.r; i++) {
                            this.s[i].c();
                            i2 = this.B.d[i];
                            if (i2 != SectionHeader.SHT_LOUSER) {
                                if (this.B.i) {
                                    i2 += this.l.a();
                                } else {
                                    i2 += this.l.c();
                                }
                            }
                            this.s[i].c(i2);
                        }
                    } else {
                        SavedState savedState = this.B;
                        savedState.d = null;
                        savedState.c = 0;
                        savedState.e = 0;
                        savedState.f = null;
                        savedState.g = null;
                        this.B.a = this.B.b;
                    }
                }
                this.A = this.B.j;
                a(this.B.h);
                s();
                if (this.B.a != -1) {
                    this.o = this.B.a;
                    bcVar.c = this.B.i;
                } else {
                    bcVar.c = this.n;
                }
                if (this.B.e > 1) {
                    this.q.a = this.B.f;
                    this.q.b = this.B.g;
                }
            } else {
                s();
                bcVar.c = this.n;
            }
            if (vVar.g || this.o == -1) {
                obj2 = null;
            } else if (this.o < 0 || this.o >= vVar.a()) {
                this.o = -1;
                this.p = SectionHeader.SHT_LOUSER;
                obj2 = null;
            } else {
                if (this.B == null || this.B.a == -1 || this.B.c <= 0) {
                    View b = b(this.o);
                    if (b != null) {
                        bcVar.a = this.n ? u() : v();
                        if (this.p != SectionHeader.SHT_LOUSER) {
                            if (bcVar.c) {
                                bcVar.b = (this.l.a() - this.p) - this.l.c(b);
                            } else {
                                bcVar.b = (this.l.c() + this.p) - this.l.d(b);
                            }
                            obj2 = 1;
                        } else if (this.l.a(b) > this.l.d()) {
                            if (bcVar.c) {
                                i = this.l.a();
                            } else {
                                i = this.l.c();
                            }
                            bcVar.b = i;
                        } else {
                            i = this.l.d(b) - this.l.c();
                            if (i < 0) {
                                bcVar.b = -i;
                            } else {
                                i = this.l.a() - this.l.c(b);
                                if (i < 0) {
                                    bcVar.b = i;
                                } else {
                                    bcVar.b = SectionHeader.SHT_LOUSER;
                                }
                            }
                        }
                    } else {
                        bcVar.a = this.o;
                        if (this.p == SectionHeader.SHT_LOUSER) {
                            boolean z;
                            i = bcVar.a;
                            if (g() == 0) {
                                if (!this.n) {
                                    i = -1;
                                }
                                i = 1;
                            } else {
                                if ((i < v()) != this.n) {
                                    i = -1;
                                }
                                i = 1;
                            }
                            if (i == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bcVar.c = z;
                            if (bcVar.c) {
                                i = bcVar.e.l.a();
                            } else {
                                i = bcVar.e.l.c();
                            }
                            bcVar.b = i;
                        } else {
                            i = this.p;
                            if (bcVar.c) {
                                bcVar.b = bcVar.e.l.a() - i;
                            } else {
                                bcVar.b = i + bcVar.e.l.c();
                            }
                        }
                        bcVar.d = true;
                    }
                } else {
                    bcVar.b = SectionHeader.SHT_LOUSER;
                    bcVar.a = this.o;
                }
                obj2 = 1;
            }
            if (obj2 == null) {
                int a;
                if (this.z) {
                    a = vVar.a();
                    for (i2 = g() - 1; i2 >= 0; i2--) {
                        i = LayoutManager.a(c(i2));
                        if (i >= 0 && i < a) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    a = vVar.a();
                    g = g();
                    for (i2 = 0; i2 < g; i2++) {
                        i = LayoutManager.a(c(i2));
                        if (i >= 0 && i < a) {
                            break;
                        }
                    }
                    i = 0;
                }
                bcVar.a = i;
                bcVar.b = SectionHeader.SHT_LOUSER;
            }
            if (this.B == null && !(bcVar.c == this.z && t() == this.A)) {
                this.q.a();
                bcVar.d = true;
            }
            if (g() > 0 && (this.B == null || this.B.c <= 0)) {
                if (bcVar.d) {
                    for (i = 0; i < this.r; i++) {
                        this.s[i].c();
                        if (bcVar.b != SectionHeader.SHT_LOUSER) {
                            this.s[i].c(bcVar.b);
                        }
                    }
                } else {
                    for (i2 = 0; i2 < this.r; i2++) {
                        aq aqVar = this.s[i2];
                        boolean z2 = this.n;
                        i3 = bcVar.b;
                        if (z2) {
                            i = aqVar.b((int) SectionHeader.SHT_LOUSER);
                        } else {
                            i = aqVar.a((int) SectionHeader.SHT_LOUSER);
                        }
                        aqVar.c();
                        if (i != SectionHeader.SHT_LOUSER && ((!z2 || i >= aqVar.f.l.a()) && (z2 || i <= aqVar.f.l.c()))) {
                            if (i3 != SectionHeader.SHT_LOUSER) {
                                i += i3;
                            }
                            aqVar.c = i;
                            aqVar.b = i;
                        }
                    }
                }
            }
            a(azVar);
            this.v.a = false;
            this.F = false;
            h(this.m.d());
            a(bcVar.a, vVar);
            if (bcVar.c) {
                i(-1);
                a(azVar, this.v, vVar);
                i(1);
                this.v.c = bcVar.a + this.v.d;
                a(azVar, this.v, vVar);
            } else {
                i(1);
                a(azVar, this.v, vVar);
                i(-1);
                this.v.c = bcVar.a + this.v.d;
                a(azVar, this.v, vVar);
            }
            if (this.m.f() != UCCore.VERIFY_POLICY_QUICK) {
                float f = 0.0f;
                i3 = g();
                g = 0;
                while (g < i3) {
                    float f2;
                    View c = c(g);
                    float a2 = (float) this.m.a(c);
                    if (a2 >= f) {
                        if (((LayoutParams) c.getLayoutParams()).b) {
                            f2 = (IPictureView.DEFAULT_MIN_SCALE * a2) / ((float) this.r);
                        } else {
                            f2 = a2;
                        }
                        f2 = Math.max(f, f2);
                    } else {
                        f2 = f;
                    }
                    g++;
                    f = f2;
                }
                g = this.u;
                i = Math.round(((float) this.r) * f);
                if (this.m.f() == SectionHeader.SHT_LOUSER) {
                    i = Math.min(i, this.m.d());
                }
                h(i);
                if (this.u != g) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View c2 = c(i2);
                        LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                        if (!layoutParams.b) {
                            if (t() && this.t == 1) {
                                c2.offsetLeftAndRight(((-((this.r - 1) - layoutParams.a.e)) * this.u) - ((-((this.r - 1) - layoutParams.a.e)) * g));
                            } else {
                                int i4 = layoutParams.a.e * this.u;
                                i = layoutParams.a.e * g;
                                if (this.t == 1) {
                                    c2.offsetLeftAndRight(i4 - i);
                                } else {
                                    c2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (g() > 0) {
                if (this.n) {
                    a(azVar, vVar, true);
                    b(azVar, vVar, false);
                } else {
                    b(azVar, vVar, true);
                    a(azVar, vVar, false);
                }
            }
            obj2 = null;
            if (!(obj == null || vVar.g)) {
                obj = (this.y == 0 || g() <= 0 || (!this.F && r() == null)) ? null : 1;
                if (obj != null) {
                    a(this.H);
                    if (q()) {
                        obj2 = 1;
                    }
                }
                this.o = -1;
                this.p = SectionHeader.SHT_LOUSER;
            }
            this.z = bcVar.c;
            this.A = t();
            this.B = null;
            if (obj2 != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    private void h(int i) {
        this.u = i / this.r;
        this.C = MeasureSpec.makeMeasureSpec(i, this.m.f());
    }

    public final boolean b() {
        return this.B == null;
    }

    public final int b(v vVar) {
        return g(vVar);
    }

    private int g(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        bo boVar = this.l;
        View b = b(!this.G);
        if (this.G) {
            z = false;
        }
        return av.a(vVar, boVar, b, c(z), this, this.G, this.n);
    }

    public final int e(v vVar) {
        return g(vVar);
    }

    public final int a(v vVar) {
        return h(vVar);
    }

    private int h(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        bo boVar = this.l;
        View b = b(!this.G);
        if (this.G) {
            z = false;
        }
        return av.a(vVar, boVar, b, c(z), this, this.G);
    }

    public final int d(v vVar) {
        return h(vVar);
    }

    public final int c(v vVar) {
        return i(vVar);
    }

    private int i(v vVar) {
        boolean z = true;
        if (g() == 0) {
            return 0;
        }
        bo boVar = this.l;
        View b = b(!this.G);
        if (this.G) {
            z = false;
        }
        return av.b(vVar, boVar, b, c(z), this, this.G);
    }

    public final int f(v vVar) {
        return i(vVar);
    }

    private void a(View view, int i, int i2) {
        a(view, this.D);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int c = c(i, layoutParams.leftMargin + this.D.left, layoutParams.rightMargin + this.D.right);
        int c2 = c(i2, layoutParams.topMargin + this.D.top, layoutParams.bottomMargin + this.D.bottom);
        if (a(view, c, c2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
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
            this.B = (SavedState) parcelable;
            a();
        }
    }

    public final Parcelable m() {
        if (this.B != null) {
            return new SavedState(this.B);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.w;
        savedState.i = this.z;
        savedState.j = this.A;
        if (this.q == null || this.q.a == null) {
            savedState.e = 0;
        } else {
            savedState.f = this.q.a;
            savedState.e = savedState.f.length;
            savedState.g = this.q.b;
        }
        if (g() > 0) {
            int u;
            if (this.z) {
                u = u();
            } else {
                u = v();
            }
            savedState.a = u;
            View c = this.n ? c(true) : b(true);
            if (c == null) {
                u = -1;
            } else {
                u = LayoutManager.a(c);
            }
            savedState.b = u;
            savedState.c = this.r;
            savedState.d = new int[this.r];
            for (u = 0; u < this.r; u++) {
                int b;
                if (this.z) {
                    b = this.s[u].b((int) SectionHeader.SHT_LOUSER);
                    if (b != SectionHeader.SHT_LOUSER) {
                        b -= this.l.a();
                    }
                } else {
                    b = this.s[u].a((int) SectionHeader.SHT_LOUSER);
                    if (b != SectionHeader.SHT_LOUSER) {
                        b -= this.l.c();
                    }
                }
                savedState.d[u] = b;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    public final void a(az azVar, v vVar, View view, s sVar) {
        int i = 1;
        int i2 = -1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int a;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.t == 0) {
                a = layoutParams2.a();
                if (layoutParams2.b) {
                    i = this.r;
                }
                i3 = a;
                a = i;
                i = -1;
            } else {
                a = layoutParams2.a();
                if (layoutParams2.b) {
                    i = this.r;
                    i3 = -1;
                    i2 = a;
                    a = -1;
                } else {
                    i3 = -1;
                    i2 = a;
                    a = -1;
                }
            }
            sVar.a(l.a(i3, a, i2, i, layoutParams2.b));
            return;
        }
        super.a(view, sVar);
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (g() > 0) {
            ad a = w.a(accessibilityEvent);
            View b = b(false);
            View c = c(false);
            if (b != null && c != null) {
                int a2 = LayoutManager.a(b);
                int a3 = LayoutManager.a(c);
                if (a2 < a3) {
                    a.b(a2);
                    a.c(a3);
                    return;
                }
                a.b(a3);
                a.c(a2);
            }
        }
    }

    public final int b(az azVar, v vVar) {
        if (this.t == 0) {
            return this.r;
        }
        return super.b(azVar, vVar);
    }

    public final int c(az azVar, v vVar) {
        if (this.t == 1) {
            return this.r;
        }
        return super.c(azVar, vVar);
    }

    private View b(boolean z) {
        int c = this.l.c();
        int a = this.l.a();
        int g = g();
        View view = null;
        int i = 0;
        while (i < g) {
            View c2 = c(i);
            int d = this.l.d(c2);
            if (this.l.c(c2) > c && d < a) {
                if (d >= c || !z) {
                    return c2;
                }
                if (view == null) {
                    i++;
                    view = c2;
                }
            }
            c2 = view;
            i++;
            view = c2;
        }
        return view;
    }

    private View c(boolean z) {
        int c = this.l.c();
        int a = this.l.a();
        View view = null;
        int g = g() - 1;
        while (g >= 0) {
            View c2 = c(g);
            int d = this.l.d(c2);
            int c3 = this.l.c(c2);
            if (c3 > c && d < a) {
                if (c3 <= a || !z) {
                    return c2;
                }
                if (view == null) {
                    g--;
                    view = c2;
                }
            }
            c2 = view;
            g--;
            view = c2;
        }
        return view;
    }

    private void a(az azVar, v vVar, boolean z) {
        int k = k(SectionHeader.SHT_LOUSER);
        if (k != SectionHeader.SHT_LOUSER) {
            k = this.l.a() - k;
            if (k > 0) {
                k -= -c(-k, azVar, vVar);
                if (z && k > 0) {
                    this.l.a(k);
                }
            }
        }
    }

    private void b(az azVar, v vVar, boolean z) {
        int j = j(Integer.MAX_VALUE);
        if (j != Integer.MAX_VALUE) {
            j -= this.l.c();
            if (j > 0) {
                j -= c(j, azVar, vVar);
                if (z && j > 0) {
                    this.l.a(-j);
                }
            }
        }
    }

    private void a(int i, v vVar) {
        int i2;
        int i3;
        boolean z;
        as asVar;
        boolean z2 = false;
        this.v.b = 0;
        this.v.c = i;
        if (f()) {
            i2 = vVar.a;
            if (i2 != -1) {
                if (this.n == (i2 < i)) {
                    i2 = this.l.d();
                    i3 = 0;
                } else {
                    i3 = this.l.d();
                    i2 = 0;
                }
                if (this.b == null && this.b.x) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.v.g = i2 + this.l.b();
                    this.v.f = -i3;
                } else {
                    this.v.f = this.l.c() - i3;
                    this.v.g = i2 + this.l.a();
                }
                this.v.h = false;
                this.v.a = true;
                asVar = this.v;
                if (this.l.f() == 0 && this.l.b() == 0) {
                    z2 = true;
                }
                asVar.i = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.b == null) {
        }
        z = false;
        if (z) {
            this.v.g = i2 + this.l.b();
            this.v.f = -i3;
        } else {
            this.v.f = this.l.c() - i3;
            this.v.g = i2 + this.l.a();
        }
        this.v.h = false;
        this.v.a = true;
        asVar = this.v;
        z2 = true;
        asVar.i = z2;
    }

    private void i(int i) {
        int i2 = 1;
        this.v.e = i;
        as asVar = this.v;
        if (this.n != (i == -1)) {
            i2 = -1;
        }
        asVar.d = i2;
    }

    public final void d(int i) {
        super.d(i);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.s[i2].d(i);
        }
    }

    public final void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.s[i2].d(i);
        }
    }

    public final void d(int i, int i2) {
        d(i, i2, 2);
    }

    public final void c(int i, int i2) {
        d(i, i2, 1);
    }

    public final void l() {
        this.q.a();
        a();
    }

    public final void f(int i, int i2) {
        d(i, i2, 8);
    }

    public final void e(int i, int i2) {
        d(i, i2, 4);
    }

    private void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int u = this.n ? u() : v();
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
        this.q.b(i5);
        switch (i3) {
            case 1:
                this.q.b(i, i2);
                break;
            case 2:
                this.q.a(i, i2);
                break;
            case 8:
                this.q.a(i, 1);
                this.q.b(i2, 1);
                break;
        }
        if (i4 > u) {
            if (i5 <= (this.n ? v() : u())) {
                a();
            }
        }
    }

    private int a(az azVar, as asVar, v vVar) {
        int i;
        int a;
        int c;
        this.x.set(0, this.r, true);
        if (this.v.i) {
            i = asVar.e == 1 ? Integer.MAX_VALUE : SectionHeader.SHT_LOUSER;
        } else if (asVar.e == 1) {
            i = asVar.g + asVar.b;
        } else {
            i = asVar.f - asVar.b;
        }
        i(asVar.e, i);
        if (this.n) {
            a = this.l.a();
        } else {
            a = this.l.c();
        }
        Object obj = null;
        while (true) {
            Object obj2;
            if (asVar.c < 0 || asVar.c >= vVar.a()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null && (this.v.i || !this.x.isEmpty())) {
                Object obj3;
                aq aqVar;
                int i2;
                int i3;
                int b;
                View b2 = azVar.b(asVar.c);
                asVar.c += asVar.d;
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                int c2 = layoutParams.c.c();
                LazySpanLookup lazySpanLookup = this.q;
                int i4 = (lazySpanLookup.a == null || c2 >= lazySpanLookup.a.length) ? -1 : lazySpanLookup.a[c2];
                if (i4 == -1) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    if (layoutParams.b) {
                        aqVar = this.s[0];
                    } else {
                        if (l(asVar.e)) {
                            i4 = this.r - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.r;
                            i3 = 1;
                        }
                        int i5;
                        int c3;
                        int i6;
                        aq aqVar2;
                        int i7;
                        if (asVar.e == 1) {
                            aqVar = null;
                            i5 = Integer.MAX_VALUE;
                            c3 = this.l.c();
                            i6 = i4;
                            while (i6 != i2) {
                                aqVar2 = this.s[i6];
                                b = aqVar2.b(c3);
                                if (b < i5) {
                                    i7 = b;
                                } else {
                                    aqVar2 = aqVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                aqVar = aqVar2;
                            }
                        } else {
                            aqVar = null;
                            i5 = SectionHeader.SHT_LOUSER;
                            c3 = this.l.a();
                            i6 = i4;
                            while (i6 != i2) {
                                aqVar2 = this.s[i6];
                                b = aqVar2.a(c3);
                                if (b > i5) {
                                    i7 = b;
                                } else {
                                    aqVar2 = aqVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                aqVar = aqVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.q;
                    lazySpanLookup.c(c2);
                    lazySpanLookup.a[c2] = aqVar.e;
                } else {
                    aqVar = this.s[i4];
                }
                layoutParams.a = aqVar;
                if (asVar.e == 1) {
                    a(b2, -1, false);
                } else {
                    super.a(b2, 0, false);
                }
                if (layoutParams.b) {
                    if (this.t == 1) {
                        a(b2, this.C, LayoutManager.a(this.k, this.i, 0, layoutParams.height, true));
                    } else {
                        a(b2, LayoutManager.a(this.j, this.h, 0, layoutParams.width, true), this.C);
                    }
                } else if (this.t == 1) {
                    a(b2, LayoutManager.a(this.u, this.h, 0, layoutParams.width, false), LayoutManager.a(this.k, this.i, 0, layoutParams.height, true));
                } else {
                    a(b2, LayoutManager.a(this.j, this.h, 0, layoutParams.width, true), LayoutManager.a(this.u, this.i, 0, layoutParams.height, false));
                }
                FullSpanItem fullSpanItem;
                if (asVar.e == 1) {
                    i3 = layoutParams.b ? k(a) : aqVar.b(a);
                    i2 = i3 + this.l.a(b2);
                    if (obj3 == null || !layoutParams.b) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.r];
                        for (i4 = 0; i4 < this.r; i4++) {
                            fullSpanItem.c[i4] = i3 - this.s[i4].b(i3);
                        }
                        fullSpanItem.b = -1;
                        fullSpanItem.a = c2;
                        this.q.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    i3 = layoutParams.b ? j(a) : aqVar.a(a);
                    i2 = i3 - this.l.a(b2);
                    if (obj3 != null && layoutParams.b) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.r];
                        for (i4 = 0; i4 < this.r; i4++) {
                            fullSpanItem.c[i4] = this.s[i4].a(i3) - i3;
                        }
                        fullSpanItem.b = 1;
                        fullSpanItem.a = c2;
                        this.q.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (layoutParams.b && asVar.d == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (asVar.e == 1) {
                            b = this.s[0].b((int) SectionHeader.SHT_LOUSER);
                            for (i2 = 1; i2 < this.r; i2++) {
                                if (this.s[i2].b((int) SectionHeader.SHT_LOUSER) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            b = this.s[0].a((int) SectionHeader.SHT_LOUSER);
                            for (i2 = 1; i2 < this.r; i2++) {
                                if (this.s[i2].a((int) SectionHeader.SHT_LOUSER) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem d = this.q.d(c2);
                            if (d != null) {
                                d.d = true;
                            }
                        }
                    }
                    this.F = true;
                }
                if (asVar.e == 1) {
                    if (layoutParams.b) {
                        for (i2 = this.r - 1; i2 >= 0; i2--) {
                            this.s[i2].b(b2);
                        }
                    } else {
                        layoutParams.a.b(b2);
                    }
                } else if (layoutParams.b) {
                    for (i2 = this.r - 1; i2 >= 0; i2--) {
                        this.s[i2].a(b2);
                    }
                } else {
                    layoutParams.a.a(b2);
                }
                if (t() && this.t == 1) {
                    i2 = layoutParams.b ? this.m.a() : this.m.a() - (((this.r - 1) - aqVar.e) * this.u);
                    b = i2;
                    i2 -= this.m.a(b2);
                } else {
                    i2 = layoutParams.b ? this.m.c() : (aqVar.e * this.u) + this.m.c();
                    b = this.m.a(b2) + i2;
                }
                if (this.t == 1) {
                    b(b2, i2, i4, b, i3);
                } else {
                    b(b2, i4, i2, i3, b);
                }
                if (layoutParams.b) {
                    i(this.v.e, i);
                } else {
                    a(aqVar, this.v.e, i);
                }
                a(azVar, this.v);
                if (this.v.h && b2.isFocusable()) {
                    if (layoutParams.b) {
                        this.x.clear();
                    } else {
                        this.x.set(aqVar.e, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(azVar, this.v);
            }
        }
        if (obj == null) {
            a(azVar, this.v);
        }
        if (this.v.e == -1) {
            c = this.l.c() - j(this.l.c());
        } else {
            c = k(this.l.a()) - this.l.a();
        }
        return c > 0 ? Math.min(asVar.b, c) : 0;
    }

    private void a(az azVar, as asVar) {
        int i = 1;
        if (asVar.a && !asVar.i) {
            if (asVar.b == 0) {
                if (asVar.e == -1) {
                    b(azVar, asVar.g);
                } else {
                    a(azVar, asVar.f);
                }
            } else if (asVar.e == -1) {
                r3 = asVar.f;
                int i2 = asVar.f;
                r1 = this.s[0].a(i2);
                while (i < this.r) {
                    r2 = this.s[i].a(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                if (i < 0) {
                    i = asVar.g;
                } else {
                    i = asVar.g - Math.min(i, asVar.b);
                }
                b(azVar, i);
            } else {
                r3 = asVar.g;
                r1 = this.s[0].b(r3);
                while (i < this.r) {
                    r2 = this.s[i].b(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - asVar.g;
                if (i < 0) {
                    i = asVar.f;
                } else {
                    i = Math.min(i, asVar.b) + asVar.f;
                }
                a(azVar, i);
            }
        }
    }

    private static void b(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutManager.a(view, layoutParams.leftMargin + i, layoutParams.topMargin + i2, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void i(int i, int i2) {
        for (int i3 = 0; i3 < this.r; i3++) {
            if (!this.s[i3].a.isEmpty()) {
                a(this.s[i3], i, i2);
            }
        }
    }

    private void a(aq aqVar, int i, int i2) {
        int i3 = aqVar.d;
        if (i == -1) {
            if (i3 + aqVar.a() <= i2) {
                this.x.set(aqVar.e, false);
            }
        } else if (aqVar.b() - i3 >= i2) {
            this.x.set(aqVar.e, false);
        }
    }

    private int j(int i) {
        int a = this.s[0].a(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int a2 = this.s[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int k(int i) {
        int b = this.s[0].b(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int b2 = this.s[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void a(az azVar, int i) {
        while (g() > 0) {
            View c = c(0);
            if (this.l.c(c) <= i) {
                LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.r) {
                        if (this.s[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.r; i2++) {
                        this.s[i2].e();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.e();
                } else {
                    return;
                }
                a(c, azVar);
            } else {
                return;
            }
        }
    }

    private void b(az azVar, int i) {
        int g = g() - 1;
        while (g >= 0) {
            View c = c(g);
            if (this.l.d(c) >= i) {
                LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.r) {
                        if (this.s[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.r; i2++) {
                        this.s[i2].d();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.d();
                } else {
                    return;
                }
                a(c, azVar);
                g--;
            } else {
                return;
            }
        }
    }

    private boolean l(int i) {
        if (this.t == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.n) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.n) != t()) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        return this.t == 1;
    }

    public final boolean d() {
        return this.t == 0;
    }

    public final int a(int i, az azVar, v vVar) {
        return c(i, azVar, vVar);
    }

    public final int b(int i, az azVar, v vVar) {
        return c(i, azVar, vVar);
    }

    public final void a(int i) {
        if (!(this.B == null || this.B.a == i)) {
            SavedState savedState = this.B;
            savedState.d = null;
            savedState.c = 0;
            savedState.a = -1;
            savedState.b = -1;
        }
        this.o = i;
        this.p = SectionHeader.SHT_LOUSER;
        a();
    }

    private int c(int i, az azVar, v vVar) {
        int u;
        int i2;
        if (i > 0) {
            u = u();
            i2 = 1;
        } else {
            i2 = -1;
            u = v();
        }
        this.v.a = true;
        a(u, vVar);
        i(i2);
        this.v.c = this.v.d + u;
        int abs = Math.abs(i);
        this.v.b = abs;
        i2 = a(azVar, this.v, vVar);
        if (abs >= i2) {
            if (i < 0) {
                i = -i2;
            } else {
                i = i2;
            }
        }
        this.l.a(-i);
        this.z = this.n;
        return i;
    }

    private int u() {
        int g = g();
        return g == 0 ? 0 : LayoutManager.a(c(g - 1));
    }

    private int v() {
        if (g() == 0) {
            return 0;
        }
        return LayoutManager.a(c(0));
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams c() {
        if (this.t == 0) {
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

    @Nullable
    public final View a(View view, int i, az azVar, v vVar) {
        int i2 = 0;
        if (g() == 0) {
            return null;
        }
        View b = b(view);
        if (b == null) {
            return null;
        }
        int i3;
        s();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.t != 0) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.t != 1) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.t != 0) {
                    i3 = SectionHeader.SHT_LOUSER;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.t != 1) {
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
        aq aqVar = layoutParams.a;
        if (i3 == 1) {
            u = u();
        } else {
            u = v();
        }
        a(u, vVar);
        i(i3);
        this.v.c = this.v.d + u;
        this.v.b = (int) (0.33333334f * ((float) this.l.d()));
        this.v.h = true;
        this.v.a = false;
        a(azVar, this.v, vVar);
        this.z = this.n;
        if (!z) {
            a = aqVar.a(u, i3);
            if (!(a == null || a == b)) {
                return a;
            }
        }
        if (l(i3)) {
            for (int i4 = this.r - 1; i4 >= 0; i4--) {
                View a2 = this.s[i4].a(u, i3);
                if (a2 != null && a2 != b) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.r) {
                a = this.s[i2].a(u, i3);
                if (a != null && a != b) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }
}
