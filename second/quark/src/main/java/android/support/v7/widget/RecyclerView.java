package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.e;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.ad;
import android.support.v4.view.b.l;
import android.support.v4.view.b.s;
import android.support.v4.view.b.w;
import android.support.v4.view.bf;
import android.support.v4.view.ch;
import android.support.v4.view.cx;
import android.support.v4.view.eb;
import android.support.v4.view.eh;
import android.support.v4.widget.bx;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class RecyclerView extends ViewGroup implements ch, eb {
    static final boolean a;
    private static final Interpolator aq = new bq();
    private static final int[] s = new int[]{16843830};
    private static final boolean t;
    private static final Class<?>[] u = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private bd A;
    private be B;
    private final ArrayList<h> C;
    private final ArrayList<bn> D;
    private bn E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private final boolean M;
    private final AccessibilityManager N;
    private List<Object> O;
    private int P;
    private int Q;
    private int R;
    private VelocityTracker S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int aa;
    private final int ab;
    private final int ac;
    private float ad;
    private bf ae;
    private List<bf> af;
    private ax ag;
    private boolean ah;
    private ag ai;
    private y aj;
    private final int[] ak;
    private bf al;
    private final int[] am;
    private final int[] an;
    private final int[] ao;
    private Runnable ap;
    private final p ar;
    final az b;
    an c;
    n d;
    final au e;
    @VisibleForTesting
    LayoutManager f;
    boolean g;
    boolean h;
    boolean i;
    bx j;
    bx k;
    bx l;
    bx m;
    ItemAnimator n;
    final aj o;
    final v p;
    boolean q;
    boolean r;
    private final bl v;
    private SavedState w;
    private boolean x;
    private final Runnable y;
    private final Rect z;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        bh c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: ProGuard */
    public abstract class LayoutManager {
        n a;
        RecyclerView b;
        @Nullable
        af c;
        boolean d = false;
        boolean e = false;
        boolean f = false;
        boolean g = true;
        int h;
        int i;
        int j;
        int k;

        /* compiled from: ProGuard */
        public class Properties {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public abstract LayoutParams c();

        final void a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                this.j = 0;
                this.k = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.d;
                this.j = recyclerView.getWidth();
                this.k = recyclerView.getHeight();
            }
            this.h = UCCore.VERIFY_POLICY_QUICK;
            this.i = UCCore.VERIFY_POLICY_QUICK;
        }

        final void a(int i, int i2) {
            this.j = MeasureSpec.getSize(i);
            this.h = MeasureSpec.getMode(i);
            if (this.h == 0 && !RecyclerView.a) {
                this.j = 0;
            }
            this.k = MeasureSpec.getSize(i2);
            this.i = MeasureSpec.getMode(i2);
            if (this.i == 0 && !RecyclerView.a) {
                this.k = 0;
            }
        }

        final void b(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = SectionHeader.SHT_LOUSER;
            int g = g();
            if (g == 0) {
                this.b.a(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = SectionHeader.SHT_LOUSER;
            int i7 = Integer.MAX_VALUE;
            while (i5 < g) {
                View c = c(i5);
                LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
                int e = e(c) - layoutParams.leftMargin;
                int g2 = layoutParams.rightMargin + g(c);
                int f = f(c) - layoutParams.topMargin;
                int h = layoutParams.bottomMargin + h(c);
                if (e >= i7) {
                    e = i7;
                }
                if (g2 <= i6) {
                    g2 = i6;
                }
                if (f >= i3) {
                    f = i3;
                }
                if (h <= i4) {
                    h = i4;
                }
                i5++;
                i6 = g2;
                i3 = f;
                i7 = e;
                i4 = h;
            }
            this.b.z.set(i7, i3, i6, i4);
            a(this.b.z, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            h(a(i, (rect.width() + h()) + j(), ViewCompat.o(this.b)), a(i2, (rect.height() + i()) + k(), ViewCompat.p(this.b)));
        }

        public final void a() {
            if (this.b != null) {
                this.b.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case SectionHeader.SHT_LOUSER /*-2147483648*/:
                    return Math.min(size, Math.max(i2, i3));
                case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void a(String str) {
            if (this.b != null) {
                this.b.a(str);
            }
        }

        public boolean b() {
            return false;
        }

        final void a(RecyclerView recyclerView, az azVar) {
            this.e = false;
            b(recyclerView, azVar);
        }

        public final boolean a(Runnable runnable) {
            if (this.b != null) {
                return this.b.removeCallbacks(runnable);
            }
            return false;
        }

        @CallSuper
        public void b(RecyclerView recyclerView, az azVar) {
        }

        public void a(az azVar, v vVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int a(int i, az azVar, v vVar) {
            return 0;
        }

        public int b(int i, az azVar, v vVar) {
            return 0;
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public void a(int i) {
        }

        public final boolean f() {
            return this.c != null && this.c.c;
        }

        final void a(View view, int i, boolean z) {
            bh b = RecyclerView.b(view);
            if (z || b.m()) {
                this.b.e.b(b);
            } else {
                this.b.e.c(b);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (b.g() || b.e()) {
                if (b.e()) {
                    b.f();
                } else {
                    b.h();
                }
                this.a.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int c = this.a.c(view);
                if (i == -1) {
                    i = this.a.a();
                }
                if (c == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view));
                } else if (c != i) {
                    LayoutManager layoutManager = this.b.f;
                    View c2 = layoutManager.c(c);
                    if (c2 == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + c);
                    }
                    layoutManager.h(c);
                    LayoutParams layoutParams2 = (LayoutParams) c2.getLayoutParams();
                    bh b2 = RecyclerView.b(c2);
                    if (b2.m()) {
                        layoutManager.b.e.b(b2);
                    } else {
                        layoutManager.b.e.c(b2);
                    }
                    layoutManager.a.a(c2, i, layoutParams2, b2.m());
                }
            } else {
                this.a.a(view, i, false);
                layoutParams.e = true;
                if (this.c != null && this.c.c) {
                    af afVar = this.c;
                    if (RecyclerView.c(view) == afVar.a) {
                        afVar.d = view;
                    }
                }
            }
            if (layoutParams.f) {
                b.a.invalidate();
                layoutParams.f = false;
            }
        }

        private void g(int i) {
            if (c(i) != null) {
                n nVar = this.a;
                int a = nVar.a(i);
                View b = nVar.a.b(a);
                if (b != null) {
                    if (nVar.b.d(a)) {
                        nVar.b(b);
                    }
                    nVar.a.a(a);
                }
            }
        }

        public static int a(View view) {
            return ((LayoutParams) view.getLayoutParams()).c.c();
        }

        @Nullable
        public final View b(View view) {
            if (this.b == null) {
                return null;
            }
            ViewParent viewParent = this.b;
            ViewParent parent = view.getParent();
            View view2 = view;
            while (parent != null && parent != viewParent && (parent instanceof View)) {
                View view3 = (View) parent;
                view2 = view3;
                parent = view3.getParent();
            }
            if (parent == viewParent) {
                view3 = view2;
            } else {
                view3 = null;
            }
            if (view3 == null) {
                return null;
            }
            if (this.a.d(view3)) {
                return null;
            }
            return view3;
        }

        public View b(int i) {
            int g = g();
            for (int i2 = 0; i2 < g; i2++) {
                View c = c(i2);
                bh b = RecyclerView.b(c);
                if (b != null && b.c() == i && !b.b() && (this.b.p.g || !b.m())) {
                    return c;
                }
            }
            return null;
        }

        private void h(int i) {
            c(i);
            this.a.d(i);
        }

        public final void a(int i, az azVar) {
            View c = c(i);
            g(i);
            azVar.a(c);
        }

        public final int g() {
            return this.a != null ? this.a.a() : 0;
        }

        public final View c(int i) {
            return this.a != null ? this.a.b(i) : null;
        }

        public final int h() {
            return this.b != null ? this.b.getPaddingLeft() : 0;
        }

        public final int i() {
            return this.b != null ? this.b.getPaddingTop() : 0;
        }

        public final int j() {
            return this.b != null ? this.b.getPaddingRight() : 0;
        }

        public final int k() {
            return this.b != null ? this.b.getPaddingBottom() : 0;
        }

        public void d(int i) {
            if (this.b != null) {
                RecyclerView recyclerView = this.b;
                int a = recyclerView.d.a();
                for (int i2 = 0; i2 < a; i2++) {
                    recyclerView.d.b(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void e(int i) {
            if (this.b != null) {
                RecyclerView recyclerView = this.b;
                int a = recyclerView.d.a();
                for (int i2 = 0; i2 < a; i2++) {
                    recyclerView.d.b(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void a(az azVar) {
            for (int g = g() - 1; g >= 0; g--) {
                View c = c(g);
                bh b = RecyclerView.b(c);
                if (!b.b()) {
                    if (!b.j() || b.m() || this.b.A.b) {
                        h(g);
                        azVar.c(c);
                        this.b.e.c(b);
                    } else {
                        g(g);
                        azVar.a(b);
                    }
                }
            }
        }

        final void b(az azVar) {
            int size = azVar.a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((bh) azVar.a.get(i)).a;
                bh b = RecyclerView.b(view);
                if (!b.b()) {
                    b.a(false);
                    if (b.n()) {
                        this.b.removeDetachedView(view, false);
                    }
                    if (this.b.n != null) {
                        this.b.n.f(b);
                    }
                    b.a(true);
                    azVar.b(view);
                }
            }
            azVar.a.clear();
            if (azVar.b != null) {
                azVar.b.clear();
            }
            if (size > 0) {
                this.b.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.g && b(view.getWidth(), i, layoutParams.width) && b(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        static boolean b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case SectionHeader.SHT_LOUSER /*-2147483648*/:
                    if (size >= i) {
                        return true;
                    }
                    return false;
                case 0:
                    return true;
                case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                    if (size == i) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = UCCore.VERIFY_POLICY_QUICK;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case SectionHeader.SHT_LOUSER /*-2147483648*/:
                        case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                            i5 = i2;
                            break;
                        default:
                            max = 0;
                            break;
                    }
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = UCCore.VERIFY_POLICY_QUICK;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == SectionHeader.SHT_LOUSER || i2 == UCCore.VERIFY_POLICY_QUICK) {
                        i5 = SectionHeader.SHT_LOUSER;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static int c(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int d(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public static void a(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public static int e(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).d.left;
        }

        public static int f(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).d.top;
        }

        public static int g(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.right + view.getRight();
        }

        public static int h(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.bottom + view.getBottom();
        }

        public final void a(View view, Rect rect) {
            if (this.b == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.b.d(view));
            }
        }

        @Nullable
        public View a(View view, int i, az azVar, v vVar) {
            return null;
        }

        public void l() {
        }

        public void c(int i, int i2) {
        }

        public void d(int i, int i2) {
        }

        public void e(int i, int i2) {
        }

        public void f(int i, int i2) {
        }

        public int a(v vVar) {
            return 0;
        }

        public int b(v vVar) {
            return 0;
        }

        public int c(v vVar) {
            return 0;
        }

        public int d(v vVar) {
            return 0;
        }

        public int e(v vVar) {
            return 0;
        }

        public int f(v vVar) {
            return 0;
        }

        public final void g(int i, int i2) {
            this.b.a(i, i2);
        }

        public final void h(int i, int i2) {
            this.b.setMeasuredDimension(i, i2);
        }

        public Parcelable m() {
            return null;
        }

        public void a(Parcelable parcelable) {
        }

        final void n() {
            if (this.c != null) {
                this.c.a();
            }
        }

        public void f(int i) {
        }

        public final void c(az azVar) {
            for (int g = g() - 1; g >= 0; g--) {
                if (!RecyclerView.b(c(g)).b()) {
                    a(g, azVar);
                }
            }
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            az azVar = this.b.b;
            v vVar = this.b.p;
            ad a = w.a(accessibilityEvent);
            if (this.b != null) {
                if (!(ViewCompat.b(this.b, 1) || ViewCompat.b(this.b, -1) || ViewCompat.a(this.b, -1) || ViewCompat.a(this.b, 1))) {
                    z = false;
                }
                a.a(z);
                if (this.b.A != null) {
                    a.a(this.b.A.a());
                }
            }
        }

        final void a(View view, s sVar) {
            bh b = RecyclerView.b(view);
            if (b != null && !b.m() && !this.a.d(b.a)) {
                a(this.b.b, this.b.p, view, sVar);
            }
        }

        public void a(az azVar, v vVar, View view, s sVar) {
            int a;
            int a2 = e() ? a(view) : 0;
            if (d()) {
                a = a(view);
            } else {
                a = 0;
            }
            sVar.a(l.a(a2, 1, a, 1, false));
        }

        public int b(az azVar, v vVar) {
            if (this.b == null || this.b.A == null || !e()) {
                return 1;
            }
            return this.b.A.a();
        }

        public int c(az azVar, v vVar) {
            if (this.b == null || this.b.A == null || !d()) {
                return 1;
            }
            return this.b.A.a();
        }

        public static Properties a(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RecyclerView, i, i2);
            properties.a = obtainStyledAttributes.getInt(b.RecyclerView_android_orientation, 1);
            properties.b = obtainStyledAttributes.getInt(b.RecyclerView_spanCount, 1);
            properties.c = obtainStyledAttributes.getBoolean(b.RecyclerView_reverseLayout, false);
            properties.d = obtainStyledAttributes.getBoolean(b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        final void b(RecyclerView recyclerView) {
            a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), UCCore.VERIFY_POLICY_QUICK));
        }

        boolean o() {
            return false;
        }

        public final void a(View view, az azVar) {
            n nVar = this.a;
            int a = nVar.a.a(view);
            if (a >= 0) {
                if (nVar.b.d(a)) {
                    nVar.b(view);
                }
                nVar.a.a(a);
            }
            azVar.a(view);
        }

        static /* synthetic */ void a(LayoutManager layoutManager, af afVar) {
            if (layoutManager.c == afVar) {
                layoutManager.c = null;
            }
        }
    }

    /* compiled from: ProGuard */
    public abstract class ItemAnimator {
        private ArrayList<Object> a = new ArrayList();
        ax b = null;
        long c = 120;
        long d = 120;
        long e = 250;
        long f = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: ProGuard */
        public @interface AdapterChanges {
        }

        public abstract void a();

        public abstract boolean a(@NonNull bh bhVar, @NonNull bh bhVar2, @NonNull m mVar, @NonNull m mVar2);

        public abstract boolean a(@NonNull bh bhVar, @NonNull m mVar, @Nullable m mVar2);

        public abstract void b();

        public abstract boolean b(@NonNull bh bhVar, @Nullable m mVar, @NonNull m mVar2);

        public abstract boolean c();

        public abstract boolean c(@NonNull bh bhVar, @NonNull m mVar, @NonNull m mVar2);

        public abstract void f(bh bhVar);

        static int e(bh bhVar) {
            int h = bhVar.l & 14;
            if (bhVar.j()) {
                return 4;
            }
            if ((h & 4) != 0) {
                return h;
            }
            int i = bhVar.c;
            int d = bhVar.d();
            if (i == -1 || d == -1 || i == d) {
                return h;
            }
            return h | 2048;
        }

        public final void g(bh bhVar) {
            if (this.b != null) {
                this.b.a(bhVar);
            }
        }

        public boolean a(@NonNull bh bhVar) {
            return true;
        }

        public boolean a(@NonNull bh bhVar, @NonNull List<Object> list) {
            return a(bhVar);
        }

        public final void d() {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i);
            }
            this.a.clear();
        }

        @NonNull
        public static m d(bh bhVar) {
            return new m().a(bhVar);
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ap();
        Parcelable a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(LayoutManager.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.a();
        n nVar = recyclerView.d;
        int a = nVar.a.a(view);
        if (a == -1) {
            nVar.b(view);
            z = true;
        } else if (nVar.b.c(a)) {
            nVar.b.d(a);
            nVar.b(view);
            nVar.a.a(a);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bh b = b(view);
            recyclerView.b.b(b);
            recyclerView.b.a(b);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.a(z2);
        return z;
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.i) {
            int i;
            recyclerView.i = true;
            int b = recyclerView.d.b();
            for (i = 0; i < b; i++) {
                bh b2 = b(recyclerView.d.c(i));
                if (!(b2 == null || b2.b())) {
                    b2.b(512);
                }
            }
            az azVar = recyclerView.b;
            int size = azVar.c.size();
            for (i = 0; i < size; i++) {
                bh bhVar = (bh) azVar.c.get(i);
                if (bhVar != null) {
                    bhVar.b(512);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        t = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        a = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.v = new bl();
        this.b = new az(this);
        this.e = new au();
        this.y = new e(this);
        this.z = new Rect();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.H = 0;
        this.i = false;
        this.P = 0;
        this.n = new ab();
        this.Q = 0;
        this.R = -1;
        this.ad = Float.MIN_VALUE;
        this.o = new aj(this);
        this.p = new v();
        this.q = false;
        this.r = false;
        this.ag = new aw();
        this.ah = false;
        this.ak = new int[2];
        this.am = new int[2];
        this.an = new int[2];
        this.ao = new int[2];
        this.ap = new c(this);
        this.ar = new k(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.M = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.aa = viewConfiguration.getScaledTouchSlop();
        this.ab = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ac = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ViewCompat.a((View) this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.n.b = this.ag;
        this.c = new an(new ad(this));
        this.d = new n(new ac(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.c((View) this, 1);
        }
        this.N = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ag(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(b.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    if (trim.charAt(0) == '.') {
                        string = context.getPackageName() + trim;
                    } else if (trim.contains(".")) {
                        string = trim;
                    } else {
                        string = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    try {
                        ClassLoader classLoader;
                        Object[] objArr;
                        Constructor constructor;
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class asSubclass = classLoader.loadClass(string).asSubclass(LayoutManager.class);
                        try {
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                            constructor = asSubclass.getConstructor(u);
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public ag getCompatAccessibilityDelegate() {
        return this.ai;
    }

    public void setAccessibilityDelegateCompat(ag agVar) {
        this.ai = agVar;
        ViewCompat.a((View) this, this.ai);
    }

    public void setHasFixedSize(boolean z) {
        this.G = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.x) {
            m();
        }
        this.x = z;
        super.setClipToPadding(z);
        if (this.g) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.aa = eh.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.aa = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(bd bdVar) {
        bd bdVar2;
        setLayoutFrozen(false);
        if (this.A != null) {
            bdVar2 = this.A;
            bdVar2.a.unregisterObserver(this.v);
        }
        if (this.n != null) {
            this.n.b();
        }
        if (this.f != null) {
            this.f.c(this.b);
            this.f.b(this.b);
        }
        this.b.a();
        this.c.a();
        bdVar2 = this.A;
        this.A = bdVar;
        if (bdVar != null) {
            bdVar.a.registerObserver(this.v);
        }
        az azVar = this.b;
        bd bdVar3 = this.A;
        azVar.a();
        b c = azVar.c();
        if (bdVar2 != null) {
            c.b();
        }
        if (c.c == 0) {
            c.a.clear();
        }
        if (bdVar3 != null) {
            c.a();
        }
        this.p.f = true;
        A();
        requestLayout();
    }

    public bd getAdapter() {
        return this.A;
    }

    public void setRecyclerListener(be beVar) {
        this.B = beVar;
    }

    public int getBaseline() {
        if (this.f != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.f) {
            k();
            if (this.f != null) {
                if (this.F) {
                    this.f.a(this, this.b);
                }
                this.f.a(null);
            }
            this.b.a();
            n nVar = this.d;
            w wVar = nVar.b;
            while (true) {
                wVar.a = 0;
                if (wVar.b == null) {
                    break;
                }
                wVar = wVar.b;
            }
            for (int size = nVar.c.size() - 1; size >= 0; size--) {
                nVar.a.d((View) nVar.c.get(size));
                nVar.c.remove(size);
            }
            nVar.a.b();
            this.f = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.b != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.b);
                }
                this.f.a(this);
                if (this.F) {
                    this.f.e = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.w != null) {
            savedState.a = this.w.a;
        } else if (this.f != null) {
            savedState.a = this.f.m();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.w = (SavedState) parcelable;
            super.onRestoreInstanceState(this.w.getSuperState());
            if (this.f != null && this.w.a != null) {
                this.f.a(this.w.a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void a(bh bhVar) {
        View view = bhVar.a;
        boolean z = view.getParent() == this;
        this.b.b(a(view));
        if (bhVar.n()) {
            this.d.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            n nVar = this.d;
            int a = nVar.a.a(view);
            if (a < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            nVar.b.a(a);
            nVar.a(view);
        } else {
            this.d.a(view, -1, true);
        }
    }

    public LayoutManager getLayoutManager() {
        return this.f;
    }

    public b getRecycledViewPool() {
        return this.b.c();
    }

    public void setRecycledViewPool(b bVar) {
        az azVar = this.b;
        if (azVar.f != null) {
            azVar.f.b();
        }
        azVar.f = bVar;
        if (bVar != null) {
            b bVar2 = azVar.f;
            azVar.h.getAdapter();
            bVar2.a();
        }
    }

    public void setViewCacheExtension(bi biVar) {
        this.b.g = biVar;
    }

    public void setItemViewCacheSize(int i) {
        az azVar = this.b;
        azVar.e = i;
        for (int size = azVar.c.size() - 1; size >= 0 && azVar.c.size() > i; size--) {
            azVar.c(size);
        }
    }

    public int getScrollState() {
        return this.Q;
    }

    private void setScrollState(int i) {
        if (i != this.Q) {
            this.Q = i;
            if (i != 2) {
                l();
            }
            if (this.f != null) {
                this.f.f(i);
            }
            if (this.af != null) {
                for (int size = this.af.size() - 1; size >= 0; size--) {
                    this.af.get(size);
                }
            }
        }
    }

    public void setChildDrawingOrderCallback(y yVar) {
        if (yVar != this.aj) {
            this.aj = yVar;
            setChildrenDrawingOrderEnabled(this.aj != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(bf bfVar) {
        this.ae = bfVar;
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.h) {
            boolean d = this.f.d();
            boolean e = this.f.e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void j() {
        boolean z = false;
        if (!this.g) {
            return;
        }
        if (this.i) {
            e.a("RV FullInvalidate");
            v();
            e.a();
        } else if (!this.c.d()) {
        } else {
            if (this.c.a(4) && !this.c.a(11)) {
                e.a("RV PartialInvalidate");
                a();
                this.c.b();
                if (!this.I) {
                    int a = this.d.a();
                    for (int i = 0; i < a; i++) {
                        bh b = b(this.d.b(i));
                        if (b != null && !b.b() && b.s()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        v();
                    } else {
                        this.c.c();
                    }
                }
                a(true);
                e.a();
            } else if (this.c.d()) {
                e.a("RV FullInvalidate");
                v();
                e.a();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        j();
        if (this.A != null) {
            a();
            p();
            e.a("RV Scroll");
            if (i != 0) {
                i5 = this.f.a(i, this.b, this.p);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.f.b(i2, this.b, this.p);
                i4 = i2 - i6;
            }
            e.a();
            B();
            q();
            a(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.C.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.am)) {
            this.V -= this.am[0];
            this.W -= this.am[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.am[0], (float) this.am[1]);
            }
            int[] iArr = this.ao;
            iArr[0] = iArr[0] + this.am[0];
            iArr = this.ao;
            iArr[1] = iArr[1] + this.am[1];
        } else if (ViewCompat.a((View) this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    b();
                    if (this.j.a((-f) / ((float) getWidth()), IPictureView.DEFAULT_MIN_SCALE - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    c();
                    if (this.l.a(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    d();
                    if (this.k.a((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    e();
                    if (this.m.a(f2 / ((float) getHeight()), IPictureView.DEFAULT_MIN_SCALE - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    ViewCompat.d(this);
                }
            }
            b(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            g();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f != null && this.f.d()) {
            return this.f.b(this.p);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f != null && this.f.d()) {
            return this.f.a(this.p);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f != null && this.f.d()) {
            return this.f.c(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f != null && this.f.e()) {
            return this.f.e(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f != null && this.f.e()) {
            return this.f.d(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f != null && this.f.e()) {
            return this.f.f(this.p);
        }
        return 0;
    }

    final void a() {
        this.H++;
        if (this.H == 1 && !this.h) {
            this.I = false;
        }
    }

    final void a(boolean z) {
        if (this.H <= 0) {
            this.H = 1;
        }
        if (!z) {
            this.I = false;
        }
        if (this.H == 1) {
            if (!(!z || !this.I || this.h || this.f == null || this.A == null)) {
                v();
            }
            if (!this.h) {
                this.I = false;
            }
        }
        this.H--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.h) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.h = true;
                this.J = true;
                k();
                return;
            }
            this.h = false;
            if (!(!this.I || this.f == null || this.A == null)) {
                requestLayout();
            }
            this.I = false;
        }
    }

    private void k() {
        setScrollState(0);
        l();
    }

    private void l() {
        this.o.b();
        if (this.f != null) {
            this.f.n();
        }
    }

    public int getMinFlingVelocity() {
        return this.ab;
    }

    public int getMaxFlingVelocity() {
        return this.ac;
    }

    private void b(int i, int i2) {
        int i3 = 0;
        if (!(this.j == null || this.j.a() || i <= 0)) {
            i3 = this.j.c();
        }
        if (!(this.l == null || this.l.a() || i >= 0)) {
            i3 |= this.l.c();
        }
        if (!(this.k == null || this.k.a() || i2 <= 0)) {
            i3 |= this.k.c();
        }
        if (!(this.m == null || this.m.a() || i2 >= 0)) {
            i3 |= this.m.c();
        }
        if (i3 != 0) {
            ViewCompat.d(this);
        }
    }

    final void b() {
        if (this.j == null) {
            this.j = new bx(getContext());
            if (this.x) {
                this.j.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.j.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void c() {
        if (this.l == null) {
            this.l = new bx(getContext());
            if (this.x) {
                this.l.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.l.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void d() {
        if (this.k == null) {
            this.k = new bx(getContext());
            if (this.x) {
                this.k.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.k.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void e() {
        if (this.m == null) {
            this.m = new bx(getContext());
            if (this.x) {
                this.m.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.m.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void m() {
        this.m = null;
        this.k = null;
        this.l = null;
        this.j = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.A == null || this.f == null || r() || this.h)) {
            a();
            findNextFocus = this.f.a(view, i, this.b, this.p);
            a(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i;
        if (this.f.f() || r()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 && view2 != null) {
            this.z.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.e) {
                    Rect rect = layoutParams2.d;
                    Rect rect2 = this.z;
                    rect2.left -= rect.left;
                    rect2 = this.z;
                    rect2.right += rect.right;
                    rect2 = this.z;
                    rect2.top -= rect.top;
                    rect2 = this.z;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.z);
            offsetRectIntoDescendantCoords(view, this.z);
            requestChildRectangleOnScreen(view, this.z, !this.g);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        LayoutManager layoutManager = this.f;
        int h = layoutManager.h();
        int i = layoutManager.i();
        int j = layoutManager.j - layoutManager.j();
        int k = layoutManager.k - layoutManager.k();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - h);
        int min2 = Math.min(0, top - i);
        int max = Math.max(0, width - j);
        k = Math.max(0, height - k);
        if (ViewCompat.h(layoutManager.b) != 1) {
            max = min != 0 ? min : Math.min(left - h, max);
        } else if (max == 0) {
            max = Math.max(min, width - j);
        }
        if (min2 != 0) {
            min = min2;
        } else {
            min = Math.min(top - i, k);
        }
        if (max == 0 && min == 0) {
            return false;
        }
        if (z) {
            scrollBy(max, min);
        } else if (this.f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.h) {
            if (!this.f.d()) {
                max = 0;
            }
            if (!this.f.e()) {
                min = 0;
            }
            if (!(max == 0 && min == 0)) {
                this.o.a(max, min);
            }
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.P = 0;
        this.F = true;
        this.g = false;
        if (this.f != null) {
            this.f.e = true;
        }
        this.ah = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.n != null) {
            this.n.b();
        }
        this.g = false;
        k();
        this.F = false;
        if (this.f != null) {
            this.f.a(this, this.b);
        }
        removeCallbacks(this.ap);
        a.b();
    }

    public boolean isAttachedToWindow() {
        return this.F;
    }

    final void a(String str) {
        if (!r()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.h) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.E = null;
        }
        int size = this.D.size();
        for (i2 = 0; i2 < size; i2++) {
            bn bnVar = (bn) this.D.get(i2);
            if (bnVar.a() && action != 3) {
                this.E = bnVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            o();
            return true;
        } else if (this.f == null) {
            return false;
        } else {
            z = this.f.d();
            boolean e = this.f.e();
            if (this.S == null) {
                this.S = VelocityTracker.obtain();
            }
            this.S.addMovement(motionEvent);
            action = cx.a(motionEvent);
            size = cx.b(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.J) {
                        this.J = false;
                    }
                    this.R = cx.b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.V = i;
                    this.T = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.W = i;
                    this.U = i;
                    if (this.Q == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.ao;
                    this.ao[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (e) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.S.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = cx.a(motionEvent, this.R);
                    if (action >= 0) {
                        size = (int) (cx.c(motionEvent, action) + 0.5f);
                        action = (int) (cx.d(motionEvent, action) + 0.5f);
                        if (this.Q != 1) {
                            size -= this.T;
                            action -= this.U;
                            if (!z || Math.abs(size) <= this.aa) {
                                z = false;
                            } else {
                                this.V = ((size < 0 ? -1 : 1) * this.aa) + this.T;
                                z = true;
                            }
                            if (e && Math.abs(action) > this.aa) {
                                i3 = this.U;
                                i2 = this.aa;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.W = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.R + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    o();
                    break;
                case 5:
                    this.R = cx.b(motionEvent, size);
                    i3 = (int) (cx.c(motionEvent, size) + 0.5f);
                    this.V = i3;
                    this.T = i3;
                    i3 = (int) (cx.d(motionEvent, size) + 0.5f);
                    this.W = i3;
                    this.U = i3;
                    break;
                case 6:
                    a(motionEvent);
                    break;
            }
            if (this.Q != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.D.size();
        for (int i = 0; i < size; i++) {
            this.D.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
        r12 = this;
        r5 = 0;
        r1 = 0;
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r3 = 1;
        r2 = 0;
        r0 = r12.h;
        if (r0 != 0) goto L_0x000e;
    L_0x000a:
        r0 = r12.J;
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return r2;
    L_0x000f:
        r0 = r13.getAction();
        r4 = r12.E;
        if (r4 == 0) goto L_0x001b;
    L_0x0017:
        if (r0 != 0) goto L_0x003e;
    L_0x0019:
        r12.E = r5;
    L_0x001b:
        if (r0 == 0) goto L_0x004b;
    L_0x001d:
        r0 = r12.D;
        r5 = r0.size();
        r4 = r2;
    L_0x0024:
        if (r4 >= r5) goto L_0x004b;
    L_0x0026:
        r0 = r12.D;
        r0 = r0.get(r4);
        r0 = (android.support.v7.widget.bn) r0;
        r6 = r0.a();
        if (r6 == 0) goto L_0x0047;
    L_0x0034:
        r12.E = r0;
        r0 = r3;
    L_0x0037:
        if (r0 == 0) goto L_0x004d;
    L_0x0039:
        r12.o();
        r2 = r3;
        goto L_0x000e;
    L_0x003e:
        r4 = 3;
        if (r0 == r4) goto L_0x0043;
    L_0x0041:
        if (r0 != r3) goto L_0x0045;
    L_0x0043:
        r12.E = r5;
    L_0x0045:
        r0 = r3;
        goto L_0x0037;
    L_0x0047:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0024;
    L_0x004b:
        r0 = r2;
        goto L_0x0037;
    L_0x004d:
        r0 = r12.f;
        if (r0 == 0) goto L_0x000e;
    L_0x0051:
        r0 = r12.f;
        r5 = r0.d();
        r0 = r12.f;
        r6 = r0.e();
        r0 = r12.S;
        if (r0 != 0) goto L_0x0067;
    L_0x0061:
        r0 = android.view.VelocityTracker.obtain();
        r12.S = r0;
    L_0x0067:
        r7 = android.view.MotionEvent.obtain(r13);
        r0 = android.support.v4.view.cx.a(r13);
        r4 = android.support.v4.view.cx.b(r13);
        if (r0 != 0) goto L_0x007d;
    L_0x0075:
        r8 = r12.ao;
        r9 = r12.ao;
        r9[r3] = r2;
        r8[r2] = r2;
    L_0x007d:
        r8 = r12.ao;
        r8 = r8[r2];
        r8 = (float) r8;
        r9 = r12.ao;
        r9 = r9[r3];
        r9 = (float) r9;
        r7.offsetLocation(r8, r9);
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01ab;
            case 2: goto L_0x00da;
            case 3: goto L_0x026c;
            case 4: goto L_0x008d;
            case 5: goto L_0x00bf;
            case 6: goto L_0x01a6;
            default: goto L_0x008d;
        };
    L_0x008d:
        if (r2 != 0) goto L_0x0094;
    L_0x008f:
        r0 = r12.S;
        r0.addMovement(r7);
    L_0x0094:
        r7.recycle();
        r2 = r3;
        goto L_0x000e;
    L_0x009a:
        r0 = android.support.v4.view.cx.b(r13, r2);
        r12.R = r0;
        r0 = r13.getX();
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.V = r0;
        r12.T = r0;
        r0 = r13.getY();
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.W = r0;
        r12.U = r0;
        if (r5 == 0) goto L_0x0278;
    L_0x00b6:
        r0 = r3;
    L_0x00b7:
        if (r6 == 0) goto L_0x00bb;
    L_0x00b9:
        r0 = r0 | 2;
    L_0x00bb:
        r12.startNestedScroll(r0);
        goto L_0x008d;
    L_0x00bf:
        r0 = android.support.v4.view.cx.b(r13, r4);
        r12.R = r0;
        r0 = android.support.v4.view.cx.c(r13, r4);
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.V = r0;
        r12.T = r0;
        r0 = android.support.v4.view.cx.d(r13, r4);
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.W = r0;
        r12.U = r0;
        goto L_0x008d;
    L_0x00da:
        r0 = r12.R;
        r0 = android.support.v4.view.cx.a(r13, r0);
        if (r0 >= 0) goto L_0x0100;
    L_0x00e2:
        r0 = "RecyclerView";
        r1 = new java.lang.StringBuilder;
        r3 = "Error processing scroll; pointer index for id ";
        r1.<init>(r3);
        r3 = r12.R;
        r1 = r1.append(r3);
        r3 = " not found. Did any MotionEvents get skipped?";
        r1 = r1.append(r3);
        r1 = r1.toString();
        android.util.Log.e(r0, r1);
        goto L_0x000e;
    L_0x0100:
        r1 = android.support.v4.view.cx.c(r13, r0);
        r1 = r1 + r10;
        r8 = (int) r1;
        r0 = android.support.v4.view.cx.d(r13, r0);
        r0 = r0 + r10;
        r9 = (int) r0;
        r0 = r12.V;
        r1 = r0 - r8;
        r0 = r12.W;
        r0 = r0 - r9;
        r4 = r12.an;
        r10 = r12.am;
        r4 = r12.dispatchNestedPreScroll(r1, r0, r4, r10);
        if (r4 == 0) goto L_0x014a;
    L_0x011d:
        r4 = r12.an;
        r4 = r4[r2];
        r1 = r1 - r4;
        r4 = r12.an;
        r4 = r4[r3];
        r0 = r0 - r4;
        r4 = r12.am;
        r4 = r4[r2];
        r4 = (float) r4;
        r10 = r12.am;
        r10 = r10[r3];
        r10 = (float) r10;
        r7.offsetLocation(r4, r10);
        r4 = r12.ao;
        r10 = r4[r2];
        r11 = r12.am;
        r11 = r11[r2];
        r10 = r10 + r11;
        r4[r2] = r10;
        r4 = r12.ao;
        r10 = r4[r3];
        r11 = r12.am;
        r11 = r11[r3];
        r10 = r10 + r11;
        r4[r3] = r10;
    L_0x014a:
        r4 = r12.Q;
        if (r4 == r3) goto L_0x0173;
    L_0x014e:
        if (r5 == 0) goto L_0x0275;
    L_0x0150:
        r4 = java.lang.Math.abs(r1);
        r10 = r12.aa;
        if (r4 <= r10) goto L_0x0275;
    L_0x0158:
        if (r1 <= 0) goto L_0x019a;
    L_0x015a:
        r4 = r12.aa;
        r1 = r1 - r4;
    L_0x015d:
        r4 = r3;
    L_0x015e:
        if (r6 == 0) goto L_0x016e;
    L_0x0160:
        r10 = java.lang.Math.abs(r0);
        r11 = r12.aa;
        if (r10 <= r11) goto L_0x016e;
    L_0x0168:
        if (r0 <= 0) goto L_0x019e;
    L_0x016a:
        r4 = r12.aa;
        r0 = r0 - r4;
    L_0x016d:
        r4 = r3;
    L_0x016e:
        if (r4 == 0) goto L_0x0173;
    L_0x0170:
        r12.setScrollState(r3);
    L_0x0173:
        r4 = r12.Q;
        if (r4 != r3) goto L_0x008d;
    L_0x0177:
        r4 = r12.am;
        r4 = r4[r2];
        r4 = r8 - r4;
        r12.V = r4;
        r4 = r12.am;
        r4 = r4[r3];
        r4 = r9 - r4;
        r12.W = r4;
        if (r5 == 0) goto L_0x01a2;
    L_0x0189:
        if (r6 == 0) goto L_0x01a4;
    L_0x018b:
        r0 = r12.a(r1, r0, r7);
        if (r0 == 0) goto L_0x008d;
    L_0x0191:
        r0 = r12.getParent();
        r0.requestDisallowInterceptTouchEvent(r3);
        goto L_0x008d;
    L_0x019a:
        r4 = r12.aa;
        r1 = r1 + r4;
        goto L_0x015d;
    L_0x019e:
        r4 = r12.aa;
        r0 = r0 + r4;
        goto L_0x016d;
    L_0x01a2:
        r1 = r2;
        goto L_0x0189;
    L_0x01a4:
        r0 = r2;
        goto L_0x018b;
    L_0x01a6:
        r12.a(r13);
        goto L_0x008d;
    L_0x01ab:
        r0 = r12.S;
        r0.addMovement(r7);
        r0 = r12.S;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r12.ac;
        r8 = (float) r8;
        r0.computeCurrentVelocity(r4, r8);
        if (r5 == 0) goto L_0x01f2;
    L_0x01bc:
        r0 = r12.S;
        r4 = r12.R;
        r0 = android.support.v4.view.ao.a(r0, r4);
        r0 = -r0;
        r4 = r0;
    L_0x01c6:
        if (r6 == 0) goto L_0x01f4;
    L_0x01c8:
        r0 = r12.S;
        r5 = r12.R;
        r0 = android.support.v4.view.ao.b(r0, r5);
        r0 = -r0;
    L_0x01d1:
        r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x01d9;
    L_0x01d5:
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x01e9;
    L_0x01d9:
        r1 = (int) r4;
        r0 = (int) r0;
        r4 = r12.f;
        if (r4 != 0) goto L_0x01f6;
    L_0x01df:
        r0 = "RecyclerView";
        r1 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.";
        android.util.Log.e(r0, r1);
    L_0x01e6:
        r0 = r2;
    L_0x01e7:
        if (r0 != 0) goto L_0x01ec;
    L_0x01e9:
        r12.setScrollState(r2);
    L_0x01ec:
        r12.n();
        r2 = r3;
        goto L_0x008d;
    L_0x01f2:
        r4 = r1;
        goto L_0x01c6;
    L_0x01f4:
        r0 = r1;
        goto L_0x01d1;
    L_0x01f6:
        r4 = r12.h;
        if (r4 != 0) goto L_0x01e6;
    L_0x01fa:
        r4 = r12.f;
        r5 = r4.d();
        r4 = r12.f;
        r6 = r4.e();
        if (r5 == 0) goto L_0x0210;
    L_0x0208:
        r4 = java.lang.Math.abs(r1);
        r8 = r12.ab;
        if (r4 >= r8) goto L_0x0273;
    L_0x0210:
        r4 = r2;
    L_0x0211:
        if (r6 == 0) goto L_0x021b;
    L_0x0213:
        r1 = java.lang.Math.abs(r0);
        r8 = r12.ab;
        if (r1 >= r8) goto L_0x0271;
    L_0x021b:
        r1 = r2;
    L_0x021c:
        if (r4 != 0) goto L_0x0220;
    L_0x021e:
        if (r1 == 0) goto L_0x01e6;
    L_0x0220:
        r0 = (float) r4;
        r8 = (float) r1;
        r0 = r12.dispatchNestedPreFling(r0, r8);
        if (r0 != 0) goto L_0x01e6;
    L_0x0228:
        if (r5 != 0) goto L_0x022c;
    L_0x022a:
        if (r6 == 0) goto L_0x026a;
    L_0x022c:
        r0 = r3;
    L_0x022d:
        r5 = (float) r4;
        r6 = (float) r1;
        r12.dispatchNestedFling(r5, r6, r0);
        if (r0 == 0) goto L_0x01e6;
    L_0x0234:
        r0 = r12.ac;
        r0 = -r0;
        r5 = r12.ac;
        r4 = java.lang.Math.min(r4, r5);
        r0 = java.lang.Math.max(r0, r4);
        r4 = r12.ac;
        r4 = -r4;
        r5 = r12.ac;
        r1 = java.lang.Math.min(r1, r5);
        r1 = java.lang.Math.max(r4, r1);
        r4 = r12.o;
        r5 = r4.d;
        r6 = 2;
        r5.setScrollState(r6);
        r4.b = r2;
        r4.a = r2;
        r5 = r4.c;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r5.a(r0, r1, r6, r8);
        r4.a();
        r0 = r3;
        goto L_0x01e7;
    L_0x026a:
        r0 = r2;
        goto L_0x022d;
    L_0x026c:
        r12.o();
        goto L_0x008d;
    L_0x0271:
        r1 = r0;
        goto L_0x021c;
    L_0x0273:
        r4 = r1;
        goto L_0x0211;
    L_0x0275:
        r4 = r2;
        goto L_0x015e;
    L_0x0278:
        r0 = r2;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void n() {
        if (this.S != null) {
            this.S.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.j != null) {
            i = this.j.c();
        }
        if (this.k != null) {
            i |= this.k.c();
        }
        if (this.l != null) {
            i |= this.l.c();
        }
        if (this.m != null) {
            i |= this.m.c();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    private void o() {
        n();
        setScrollState(0);
    }

    private void a(MotionEvent motionEvent) {
        int b = cx.b(motionEvent);
        if (cx.b(motionEvent, b) == this.R) {
            b = b == 0 ? 1 : 0;
            this.R = cx.b(motionEvent, b);
            int c = (int) (cx.c(motionEvent, b) + 0.5f);
            this.V = c;
            this.T = c;
            b = (int) (cx.d(motionEvent, b) + 0.5f);
            this.W = b;
            this.U = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f == null || this.h || (cx.d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f.e()) {
                f = -cx.e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f.d()) {
                e = cx.e(motionEvent, 10);
            } else {
                e = 0.0f;
            }
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.ad == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ad = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ad;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f == null) {
            a(i, i2);
        } else if (this.f.f) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == UCCore.VERIFY_POLICY_QUICK && mode2 == UCCore.VERIFY_POLICY_QUICK) {
                z = true;
            }
            this.f.g(i, i2);
            if (!z && this.A != null) {
                if (this.p.b == 1) {
                    w();
                }
                this.f.a(i, i2);
                this.p.k = true;
                x();
                this.f.b(i, i2);
                if (this.f.o()) {
                    this.f.a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
                    this.p.k = true;
                    x();
                    this.f.b(i, i2);
                }
            }
        } else if (this.G) {
            this.f.g(i, i2);
        } else {
            if (this.L) {
                a();
                u();
                if (this.p.i) {
                    this.p.g = true;
                } else {
                    this.c.e();
                    this.p.g = false;
                }
                this.L = false;
                a(false);
            }
            if (this.A != null) {
                this.p.c = this.A.a();
            } else {
                this.p.c = 0;
            }
            a();
            this.f.g(i, i2);
            a(false);
            this.p.g = false;
        }
    }

    final void a(int i, int i2) {
        setMeasuredDimension(LayoutManager.a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.o(this)), LayoutManager.a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.p(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.n != null) {
            this.n.b();
            this.n.b = null;
        }
        this.n = itemAnimator;
        if (this.n != null) {
            this.n.b = this.ag;
        }
    }

    private void p() {
        this.P++;
    }

    private void q() {
        this.P--;
        if (this.P <= 0) {
            this.P = 0;
            int i = this.K;
            this.K = 0;
            if (i != 0 && f()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                w.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean f() {
        return this.N != null && this.N.isEnabled();
    }

    private boolean r() {
        return this.P > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (r()) {
            int b;
            if (accessibilityEvent != null) {
                b = w.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.K = i | this.K;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.n;
    }

    private void s() {
        if (!this.ah && this.F) {
            ViewCompat.a((View) this, this.ap);
            this.ah = true;
        }
    }

    private boolean t() {
        return this.n != null && this.f.b();
    }

    private void u() {
        boolean z;
        boolean z2 = true;
        if (this.i) {
            this.c.a();
            A();
            this.f.l();
        }
        if (t()) {
            this.c.b();
        } else {
            this.c.e();
        }
        boolean z3;
        if (this.q || this.r) {
            z3 = true;
        } else {
            z3 = false;
        }
        v vVar = this.p;
        if (!this.g || this.n == null || (!(this.i || r0 || this.f.d) || (this.i && !this.A.b))) {
            z = false;
        } else {
            z = true;
        }
        vVar.h = z;
        v vVar2 = this.p;
        if (!(this.p.h && r0 && !this.i && t())) {
            z2 = false;
        }
        vVar2.i = z2;
    }

    private void v() {
        if (this.A == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            boolean z;
            int i;
            int i2;
            this.p.k = false;
            if (this.p.b == 1) {
                w();
                this.f.b(this);
                x();
            } else {
                an anVar = this.c;
                if (anVar.b.isEmpty() || anVar.a.isEmpty()) {
                    z = false;
                } else {
                    i = 1;
                }
                if (i == 0 && this.f.j == getWidth() && this.f.k == getHeight()) {
                    this.f.b(this);
                } else {
                    this.f.b(this);
                    x();
                }
            }
            this.p.a(4);
            a();
            p();
            this.p.b = 1;
            if (this.p.h) {
                for (int a = this.d.a() - 1; a >= 0; a--) {
                    bh b = b(this.d.b(a));
                    if (!b.b()) {
                        long b2 = b(b);
                        m a2 = new m().a(b);
                        bh bhVar = (bh) this.e.b.a(b2);
                        if (!(bhVar == null || bhVar.b())) {
                            boolean a3 = this.e.a(bhVar);
                            boolean a4 = this.e.a(b);
                            if (!(a3 && bhVar == b)) {
                                m a5 = this.e.a(bhVar, 4);
                                this.e.b(b, a2);
                                a2 = this.e.a(b, 8);
                                if (a5 == null) {
                                    int a6 = this.d.a();
                                    i2 = 0;
                                    while (i2 < a6) {
                                        bh b3 = b(this.d.b(i2));
                                        if (b3 == b || b(b3) != b2) {
                                            i2++;
                                        } else if (this.A == null || !this.A.b) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + b3 + " \n View Holder 2:" + b);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + b3 + " \n View Holder 2:" + b);
                                        }
                                    }
                                    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + bhVar + " cannot be found but it is necessary for " + b);
                                } else {
                                    bhVar.a(false);
                                    if (a3) {
                                        a(bhVar);
                                    }
                                    if (bhVar != b) {
                                        if (a4) {
                                            a(b);
                                        }
                                        bhVar.g = b;
                                        a(bhVar);
                                        this.b.b(bhVar);
                                        b.a(false);
                                        b.h = bhVar;
                                    }
                                    if (this.n.a(bhVar, b, a5, a2)) {
                                        s();
                                    }
                                }
                            }
                        }
                        this.e.b(b, a2);
                    }
                }
                this.e.a(this.ar);
            }
            this.f.b(this.b);
            this.p.d = this.p.c;
            this.i = false;
            this.p.h = false;
            this.p.i = false;
            this.f.d = false;
            if (this.b.b != null) {
                this.b.b.clear();
            }
            q();
            a(false);
            this.e.a();
            i = this.ak[0];
            i2 = this.ak[1];
            if (this.d.a() == 0) {
                z = (i == 0 && i2 == 0) ? false : true;
            } else {
                a(this.ak);
                z = (this.ak[0] == i && this.ak[1] == i2) ? false : true;
            }
            if (z) {
                g();
            }
        }
    }

    private void w() {
        boolean z;
        int a;
        int i;
        bh b;
        this.p.a(1);
        this.p.k = false;
        a();
        this.e.a();
        p();
        u();
        v vVar = this.p;
        if (this.p.h && this.r) {
            z = true;
        } else {
            z = false;
        }
        vVar.j = z;
        this.r = false;
        this.q = false;
        this.p.g = this.p.i;
        this.p.c = this.A.a();
        a(this.ak);
        if (this.p.h) {
            a = this.d.a();
            for (i = 0; i < a; i++) {
                b = b(this.d.b(i));
                if (!b.b() && (!b.j() || this.A.b)) {
                    ItemAnimator.e(b);
                    b.p();
                    this.e.a(b, ItemAnimator.d(b));
                    if (!(!this.p.j || !b.s() || b.m() || b.b() || b.j())) {
                        this.e.a(b(b), b);
                    }
                }
            }
        }
        if (this.p.i) {
            a = this.d.b();
            for (i = 0; i < a; i++) {
                b = b(this.d.c(i));
                if (!b.b() && b.c == -1) {
                    b.c = b.b;
                }
            }
            z = this.p.f;
            this.p.f = false;
            this.f.a(this.b, this.p);
            this.p.f = z;
            for (a = 0; a < this.d.a(); a++) {
                b = b(this.d.b(a));
                if (!b.b()) {
                    a aVar = (a) this.e.a.get(b);
                    if (aVar == null || (aVar.a & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        ItemAnimator.e(b);
                        z = b.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                        b.p();
                        m d = ItemAnimator.d(b);
                        if (z) {
                            a(b, d);
                        } else {
                            au auVar = this.e;
                            aVar = (a) auVar.a.get(b);
                            if (aVar == null) {
                                aVar = a.a();
                                auVar.a.put(b, aVar);
                            }
                            aVar.a |= 2;
                            aVar.b = d;
                        }
                    }
                }
            }
            z();
        } else {
            z();
        }
        q();
        a(false);
        this.p.b = 2;
    }

    private void x() {
        boolean z;
        a();
        p();
        this.p.a(6);
        this.c.e();
        this.p.c = this.A.a();
        this.p.e = 0;
        this.p.g = false;
        this.f.a(this.b, this.p);
        this.p.f = false;
        this.w = null;
        v vVar = this.p;
        if (!this.p.h || this.n == null) {
            z = false;
        } else {
            z = true;
        }
        vVar.h = z;
        this.p.b = 4;
        q();
        a(false);
    }

    private void a(bh bhVar, m mVar) {
        bhVar.a(0, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        if (this.p.j && bhVar.s() && !bhVar.m() && !bhVar.b()) {
            this.e.a(b(bhVar), bhVar);
        }
        this.e.a(bhVar, mVar);
    }

    private void a(int[] iArr) {
        int a = this.d.a();
        if (a == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = SectionHeader.SHT_LOUSER;
        int i3 = 0;
        while (i3 < a) {
            int c;
            bh b = b(this.d.b(i3));
            if (!b.b()) {
                c = b.c();
                if (c < i) {
                    i = c;
                }
                if (c > i2) {
                    i2 = i;
                    i3++;
                    i = i2;
                    i2 = c;
                }
            }
            c = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = c;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        bh b = b(view);
        if (b != null) {
            if (b.n()) {
                b.i();
            } else if (!b.b()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + b);
            }
        }
        e(view);
        super.removeDetachedView(view, z);
    }

    private long b(bh bhVar) {
        if (this.A.b) {
            return bhVar.d;
        }
        return (long) bhVar.b;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e.a("RV OnLayout");
        v();
        e.a();
        this.g = true;
    }

    public void requestLayout() {
        if (this.H != 0 || this.h) {
            this.I = true;
        } else {
            super.requestLayout();
        }
    }

    private void y() {
        int i = 0;
        int b = this.d.b();
        for (int i2 = 0; i2 < b; i2++) {
            ((LayoutParams) this.d.c(i2).getLayoutParams()).e = true;
        }
        az azVar = this.b;
        b = azVar.c.size();
        while (i < b) {
            LayoutParams layoutParams = (LayoutParams) ((bh) azVar.c.get(i)).a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.e = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.draw(canvas);
        int size = this.C.size();
        for (i = 0; i < size; i++) {
            this.C.get(i);
        }
        if (this.j == null || this.j.a()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.x ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i + (-getHeight())), 0.0f);
            if (this.j == null || !this.j.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            canvas.restoreToCount(size);
        }
        if (!(this.k == null || this.k.a())) {
            int save = canvas.save();
            if (this.x) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.k == null || !this.k.a(canvas)) {
                size = 0;
            } else {
                size = 1;
            }
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.l == null || this.l.a())) {
            save = canvas.save();
            int width = getWidth();
            if (this.x) {
                size = getPaddingTop();
            } else {
                size = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-size), (float) (-width));
            if (this.l == null || !this.l.a(canvas)) {
                size = 0;
            } else {
                size = 1;
            }
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.m == null || this.m.a())) {
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.x) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.m != null && this.m.a(canvas)) {
                i3 = 1;
            }
            i |= i3;
            canvas.restoreToCount(size);
        }
        if (i != 0 || this.n == null || this.C.size() <= 0 || !this.n.c()) {
            i2 = i;
        }
        if (i2 != 0) {
            ViewCompat.d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((h) this.C.get(i)).a(canvas, this);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f.a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f != null) {
            return this.f.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f != null) {
            return this.f.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.f != null) {
            return this.f.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void z() {
        int i = 0;
        int b = this.d.b();
        for (int i2 = 0; i2 < b; i2++) {
            bh b2 = b(this.d.c(i2));
            if (!b2.b()) {
                b2.a();
            }
        }
        az azVar = this.b;
        int size = azVar.c.size();
        for (b = 0; b < size; b++) {
            ((bh) azVar.c.get(b)).a();
        }
        size = azVar.a.size();
        for (b = 0; b < size; b++) {
            ((bh) azVar.a.get(b)).a();
        }
        if (azVar.b != null) {
            b = azVar.b.size();
            while (i < b) {
                ((bh) azVar.b.get(i)).a();
                i++;
            }
        }
    }

    final void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int b = this.d.b();
        for (int i4 = 0; i4 < b; i4++) {
            bh b2 = b(this.d.c(i4));
            if (!(b2 == null || b2.b())) {
                if (b2.b >= i3) {
                    b2.a(-i2, z);
                    this.p.f = true;
                } else if (b2.b >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    b2.b(8);
                    b2.a(i6, z);
                    b2.b = i5;
                    this.p.f = true;
                }
            }
        }
        az azVar = this.b;
        int i7 = i + i2;
        for (i3 = azVar.c.size() - 1; i3 >= 0; i3--) {
            bh bhVar = (bh) azVar.c.get(i3);
            if (bhVar != null) {
                if (bhVar.b >= i7) {
                    bhVar.a(-i2, z);
                } else if (bhVar.b >= i) {
                    bhVar.b(8);
                    azVar.c(i3);
                }
            }
        }
        requestLayout();
    }

    private void A() {
        int i;
        int b = this.d.b();
        for (i = 0; i < b; i++) {
            bh b2 = b(this.d.c(i));
            if (!(b2 == null || b2.b())) {
                b2.b(6);
            }
        }
        y();
        az azVar = this.b;
        if (azVar.h.A == null || !azVar.h.A.b) {
            azVar.b();
            return;
        }
        int size = azVar.c.size();
        for (i = 0; i < size; i++) {
            bh bhVar = (bh) azVar.c.get(i);
            if (bhVar != null) {
                bhVar.b(6);
                bhVar.a(null);
            }
        }
    }

    public final bh a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public static bh b(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).c;
    }

    public static int c(View view) {
        bh b = b(view);
        return b != null ? b.c() : -1;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.e) {
            return layoutParams.d;
        }
        Rect rect = layoutParams.d;
        rect.set(0, 0, 0, 0);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.z.set(0, 0, 0, 0);
            ((h) this.C.get(i)).a(this.z, view);
            rect.left += this.z.left;
            rect.top += this.z.top;
            rect.right += this.z.right;
            rect.bottom += this.z.bottom;
        }
        layoutParams.e = false;
        return rect;
    }

    final void g() {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.af != null) {
            for (scrollX = this.af.size() - 1; scrollX >= 0; scrollX--) {
                this.af.get(scrollX);
            }
        }
    }

    private void B() {
        int a = this.d.a();
        for (int i = 0; i < a; i++) {
            View b = this.d.b(i);
            bh a2 = a(b);
            if (!(a2 == null || a2.h == null)) {
                View view = a2.h.a;
                int left = b.getLeft();
                int top = b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void e(View view) {
        b(view);
        if (this.O != null) {
            for (int size = this.O.size() - 1; size >= 0; size--) {
                this.O.get(size);
            }
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().a(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().b();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aj == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.aj.a();
    }

    private bf getScrollingChildHelper() {
        if (this.al == null) {
            this.al = new bf(this);
        }
        return this.al;
    }

    public final void a(h hVar) {
        if (this.f != null) {
            this.f.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.C.isEmpty()) {
            setWillNotDraw(false);
        }
        this.C.add(hVar);
        y();
        requestLayout();
    }

    static /* synthetic */ void a(RecyclerView recyclerView, bh bhVar, m mVar, m mVar2) {
        recyclerView.a(bhVar);
        bhVar.a(false);
        if (recyclerView.n.a(bhVar, mVar, mVar2)) {
            recyclerView.s();
        }
    }

    static /* synthetic */ void b(RecyclerView recyclerView, bh bhVar, m mVar, m mVar2) {
        bhVar.a(false);
        if (recyclerView.n.b(bhVar, mVar, mVar2)) {
            recyclerView.s();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        b(view);
        if (recyclerView.O != null) {
            for (int size = recyclerView.O.size() - 1; size >= 0; size--) {
                recyclerView.O.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, bh bhVar) {
        return recyclerView.n == null || recyclerView.n.a(bhVar, bhVar.p());
    }

    static /* synthetic */ int b(RecyclerView recyclerView, bh bhVar) {
        if (bhVar.a(524) || !bhVar.l()) {
            return -1;
        }
        an anVar = recyclerView.c;
        int i = bhVar.b;
        int size = anVar.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ai aiVar = (ai) anVar.a.get(i2);
            switch (aiVar.a) {
                case 1:
                    if (aiVar.b > i) {
                        break;
                    }
                    i += aiVar.d;
                    break;
                case 2:
                    if (aiVar.b <= i) {
                        if (aiVar.b + aiVar.d <= i) {
                            i -= aiVar.d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (aiVar.b != i) {
                        if (aiVar.b < i) {
                            i--;
                        }
                        if (aiVar.d > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = aiVar.d;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int i) {
        if (recyclerView.f != null) {
            recyclerView.f.a(i);
            recyclerView.awakenScrollBars();
        }
    }
}
