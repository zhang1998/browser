package android.mini.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.mini.support.annotation.CallSuper;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.annotation.VisibleForTesting;
import android.mini.support.v4.c.c;
import android.mini.support.v4.c.f;
import android.mini.support.v4.e.e;
import android.mini.support.v4.view.AbsSavedState;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.a.q;
import android.mini.support.v4.view.a.r;
import android.mini.support.v4.view.aj;
import android.mini.support.v4.view.ak;
import android.mini.support.v4.view.al;
import android.mini.support.v4.view.ap;
import android.mini.support.v4.view.bq;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
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
public class RecyclerView extends ViewGroup implements ak, ap {
    static final boolean a;
    private static final Interpolator au = new ai();
    private static final int[] t = new int[]{16843830};
    private static final int[] u = new int[]{16842987};
    private static final boolean v;
    private static final Class<?>[] w = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private final Runnable A;
    private final Rect B;
    private final Rect C;
    private final RectF D;
    private am E;
    private ay F;
    private final ArrayList<au> G;
    private au H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private int N;
    private boolean O;
    private final boolean P;
    private final AccessibilityManager Q;
    private List<Object> R;
    private int S;
    private int T;
    private int U;
    private VelocityTracker V;
    private int W;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private final int ae;
    private final int af;
    private float ag;
    private boolean ah;
    private final be ai;
    private av aj;
    private aq ak;
    private boolean al;
    private bh am;
    private ap an;
    private final int[] ao;
    private al ap;
    private final int[] aq;
    private final int[] ar;
    private final int[] as;
    private Runnable at;
    private final br av;
    final ax b;
    c c;
    f d;
    final bs e;
    @VisibleForTesting
    public LayoutManager f;
    public final ArrayList<at> g;
    @VisibleForTesting
    boolean h;
    public boolean i;
    boolean j;
    e k;
    e l;
    e m;
    e n;
    ItemAnimator o;
    final State p;
    public List<av> q;
    boolean r;
    boolean s;
    private final az x;
    private SavedState y;
    private boolean z;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        bf c;
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
        f p;
        RecyclerView q;
        @Nullable
        bc r;
        boolean s = false;
        boolean t = false;
        boolean u = false;
        boolean v = true;
        int w;
        int x;
        int y;
        int z;

        /* compiled from: ProGuard */
        public class Properties {
        }

        public abstract LayoutParams b();

        final void a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.y = 0;
                this.z = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.d;
                this.y = recyclerView.getWidth();
                this.z = recyclerView.getHeight();
            }
            this.w = UCCore.VERIFY_POLICY_QUICK;
            this.x = UCCore.VERIFY_POLICY_QUICK;
        }

        final void e(int i, int i2) {
            this.y = MeasureSpec.getSize(i);
            this.w = MeasureSpec.getMode(i);
            if (this.w == 0 && !RecyclerView.a) {
                this.y = 0;
            }
            this.z = MeasureSpec.getSize(i2);
            this.x = MeasureSpec.getMode(i2);
            if (this.x == 0 && !RecyclerView.a) {
                this.z = 0;
            }
        }

        final void f(int i, int i2) {
            int n = n();
            if (n == 0) {
                this.q.b(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = SectionHeader.SHT_LOUSER;
            int i6 = SectionHeader.SHT_LOUSER;
            int i7 = 0;
            while (i7 < n) {
                int i8;
                View e = e(i7);
                e.getLayoutParams();
                Rect u = this.q.B;
                LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
                Rect rect = layoutParams.d;
                u.set((e.getLeft() - rect.left) - layoutParams.leftMargin, (e.getTop() - rect.top) - layoutParams.topMargin, (e.getRight() + rect.right) + layoutParams.rightMargin, layoutParams.bottomMargin + (e.getBottom() + rect.bottom));
                if (u.left < i3) {
                    i8 = u.left;
                } else {
                    i8 = i3;
                }
                if (u.right > i5) {
                    i3 = u.right;
                } else {
                    i3 = i5;
                }
                if (u.top < i4) {
                    i5 = u.top;
                } else {
                    i5 = i4;
                }
                if (u.bottom > i6) {
                    i4 = u.bottom;
                } else {
                    i4 = i6;
                }
                i7++;
                i6 = i4;
                i4 = i5;
                i5 = i3;
                i3 = i8;
            }
            this.q.B.set(i3, i4, i5, i6);
            a(this.q.B, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            h(a(i, (rect.width() + o()) + q(), ViewCompat.l(this.q)), a(i2, (rect.height() + p()) + r(), ViewCompat.m(this.q)));
        }

        public final void l() {
            if (this.q != null) {
                this.q.requestLayout();
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
            if (this.q != null) {
                this.q.a(str);
            }
        }

        public boolean c() {
            return false;
        }

        final void b(RecyclerView recyclerView, ax axVar) {
            this.t = false;
            a(recyclerView, axVar);
        }

        public final boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        @CallSuper
        public void a(RecyclerView recyclerView, ax axVar) {
        }

        public void c(ax axVar, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void a(State state) {
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

        public int a(int i, ax axVar, State state) {
            return 0;
        }

        public int b(int i, ax axVar, State state) {
            return 0;
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void c(int i) {
        }

        public void a(RecyclerView recyclerView, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final void a(bc bcVar) {
            if (!(this.r == null || bcVar == this.r || !this.r.k)) {
                this.r.c();
            }
            this.r = bcVar;
            bc bcVar2 = this.r;
            bcVar2.h = this.q;
            bcVar2.i = this;
            if (bcVar2.g == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            bcVar2.h.p.a = bcVar2.g;
            bcVar2.k = true;
            bcVar2.j = true;
            bcVar2.l = bcVar2.h.f.a(bcVar2.g);
            bcVar2.h.ai.a();
        }

        public final boolean m() {
            return this.r != null && this.r.k;
        }

        final void a(View view, int i, boolean z) {
            bf c = RecyclerView.c(view);
            if (z || c.m()) {
                this.q.e.b(c);
            } else {
                this.q.e.c(c);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (c.g() || c.e()) {
                if (c.e()) {
                    c.f();
                } else {
                    c.h();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int c2 = this.p.c(view);
                if (i == -1) {
                    i = this.p.a();
                }
                if (c2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view));
                } else if (c2 != i) {
                    LayoutManager layoutManager = this.q.f;
                    View e = layoutManager.e(c2);
                    if (e == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + c2);
                    }
                    layoutManager.d(c2);
                    LayoutParams layoutParams2 = (LayoutParams) e.getLayoutParams();
                    bf c3 = RecyclerView.c(e);
                    if (c3.m()) {
                        layoutManager.q.e.b(c3);
                    } else {
                        layoutManager.q.e.c(c3);
                    }
                    layoutManager.p.a(e, i, layoutParams2, c3.m());
                }
            } else {
                this.p.a(view, i, false);
                layoutParams.e = true;
                if (this.r != null && this.r.k) {
                    bc bcVar = this.r;
                    if (RecyclerView.d(view) == bcVar.g) {
                        bcVar.l = view;
                    }
                }
            }
            if (layoutParams.f) {
                c.a.invalidate();
                layoutParams.f = false;
            }
        }

        private void b(int i) {
            if (e(i) != null) {
                f fVar = this.p;
                int a = fVar.a(i);
                View b = fVar.a.b(a);
                if (b != null) {
                    if (fVar.b.d(a)) {
                        fVar.b(b);
                    }
                    fVar.a.a(a);
                }
            }
        }

        public static int a(View view) {
            return ((LayoutParams) view.getLayoutParams()).c.c();
        }

        @Nullable
        public final View b(View view) {
            if (this.q == null) {
                return null;
            }
            View b = this.q.b(view);
            if (b == null || this.p.d(b)) {
                return null;
            }
            return b;
        }

        public View a(int i) {
            int n = n();
            for (int i2 = 0; i2 < n; i2++) {
                View e = e(i2);
                bf c = RecyclerView.c(e);
                if (c != null && c.c() == i && !c.b() && (this.q.p.g || !c.m())) {
                    return e;
                }
            }
            return null;
        }

        private void d(int i) {
            e(i);
            this.p.d(i);
        }

        public final void a(int i, ax axVar) {
            View e = e(i);
            b(i);
            axVar.a(e);
        }

        public final int n() {
            return this.p != null ? this.p.a() : 0;
        }

        public final View e(int i) {
            return this.p != null ? this.p.b(i) : null;
        }

        public final int o() {
            return this.q != null ? this.q.getPaddingLeft() : 0;
        }

        public final int p() {
            return this.q != null ? this.q.getPaddingTop() : 0;
        }

        public final int q() {
            return this.q != null ? this.q.getPaddingRight() : 0;
        }

        public final int r() {
            return this.q != null ? this.q.getPaddingBottom() : 0;
        }

        public final int s() {
            am adapter = this.q != null ? this.q.getAdapter() : null;
            return adapter != null ? adapter.a() : 0;
        }

        public void f(int i) {
            if (this.q != null) {
                RecyclerView recyclerView = this.q;
                int a = recyclerView.d.a();
                for (int i2 = 0; i2 < a; i2++) {
                    recyclerView.d.b(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void g(int i) {
            if (this.q != null) {
                RecyclerView recyclerView = this.q;
                int a = recyclerView.d.a();
                for (int i2 = 0; i2 < a; i2++) {
                    recyclerView.d.b(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void a(ax axVar) {
            for (int n = n() - 1; n >= 0; n--) {
                View e = e(n);
                bf c = RecyclerView.c(e);
                if (!c.b()) {
                    if (!c.j() || c.m() || this.q.E.b) {
                        d(n);
                        axVar.c(e);
                        this.q.e.c(c);
                    } else {
                        b(n);
                        axVar.a(c);
                    }
                }
            }
        }

        final void b(ax axVar) {
            int size = axVar.a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((bf) axVar.a.get(i)).a;
                bf c = RecyclerView.c(view);
                if (!c.b()) {
                    c.a(false);
                    if (c.n()) {
                        this.q.removeDetachedView(view, false);
                    }
                    if (this.q.o != null) {
                        this.q.o.c(c);
                    }
                    c.a(true);
                    axVar.b(view);
                }
            }
            axVar.a.clear();
            if (axVar.b != null) {
                axVar.b.clear();
            }
            if (size > 0) {
                this.q.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.v && b(view.getWidth(), i, layoutParams.width) && b(view.getHeight(), i2, layoutParams.height)) ? false : true;
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
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.d;
            view.layout((rect.left + i) + layoutParams.leftMargin, (rect.top + i2) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public final void a(View view, Rect rect) {
            Rect rect2 = ((LayoutParams) view.getLayoutParams()).d;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            if (this.q != null) {
                Matrix k = ViewCompat.k(view);
                if (!(k == null || k.isIdentity())) {
                    RectF w = this.q.D;
                    w.set(rect);
                    k.mapRect(w);
                    rect.set((int) Math.floor((double) w.left), (int) Math.floor((double) w.top), (int) Math.ceil((double) w.right), (int) Math.ceil((double) w.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
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

        public final void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.e(view));
            }
        }

        @Nullable
        public View a(View view, int i, ax axVar, State state) {
            return null;
        }

        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2) {
        }

        public void d(int i, int i2) {
        }

        public int d(State state) {
            return 0;
        }

        public int b(State state) {
            return 0;
        }

        public int f(State state) {
            return 0;
        }

        public int e(State state) {
            return 0;
        }

        public int c(State state) {
            return 0;
        }

        public int g(State state) {
            return 0;
        }

        public final void g(int i, int i2) {
            this.q.b(i, i2);
        }

        public final void h(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public Parcelable d() {
            return null;
        }

        public void a(Parcelable parcelable) {
        }

        final void t() {
            if (this.r != null) {
                this.r.c();
            }
        }

        public void h(int i) {
        }

        public final void c(ax axVar) {
            for (int n = n() - 1; n >= 0; n--) {
                if (!RecyclerView.c(e(n)).b()) {
                    a(n, axVar);
                }
            }
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            ax axVar = this.q.b;
            State state = this.q.p;
            android.mini.support.v4.view.a.ak a = android.mini.support.v4.view.a.e.a(accessibilityEvent);
            if (this.q != null) {
                if (!(ViewCompat.b(this.q, 1) || ViewCompat.b(this.q, -1) || ViewCompat.a(this.q, -1) || ViewCompat.a(this.q, 1))) {
                    z = false;
                }
                a.a(z);
                if (this.q.E != null) {
                    a.a(this.q.E.a());
                }
            }
        }

        final void a(View view, r rVar) {
            bf c = RecyclerView.c(view);
            if (c != null && !c.m() && !this.p.d(c.a)) {
                a(this.q.b, this.q.p, view, rVar);
            }
        }

        public void a(ax axVar, State state, View view, r rVar) {
            int a;
            int a2 = f() ? a(view) : 0;
            if (e()) {
                a = a(view);
            } else {
                a = 0;
            }
            rVar.a(q.a(a2, 1, a, 1, false));
        }

        public int a(ax axVar, State state) {
            if (this.q == null || this.q.E == null || !f()) {
                return 1;
            }
            return this.q.E.a();
        }

        public int b(ax axVar, State state) {
            if (this.q == null || this.q.E == null || !e()) {
                return 1;
            }
            return this.q.E.a();
        }

        final void b(RecyclerView recyclerView) {
            e(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), UCCore.VERIFY_POLICY_QUICK));
        }

        boolean i() {
            return false;
        }

        public final void a(View view, ax axVar) {
            f fVar = this.p;
            int a = fVar.a.a(view);
            if (a >= 0) {
                if (fVar.b.d(a)) {
                    fVar.b(view);
                }
                fVar.a.a(a);
            }
            axVar.a(view);
        }

        static /* synthetic */ void a(LayoutManager layoutManager, bc bcVar) {
            if (layoutManager.r == bcVar) {
                layoutManager.r = null;
            }
        }
    }

    /* compiled from: ProGuard */
    public abstract class ItemAnimator {
        private ArrayList<Object> a = new ArrayList();
        aq h = null;
        long i = 120;
        long j = 120;
        long k = 250;
        long l = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: ProGuard */
        public @interface AdapterChanges {
        }

        public abstract void a();

        public abstract boolean a(@NonNull bf bfVar, @NonNull ar arVar, @Nullable ar arVar2);

        public abstract boolean a(@NonNull bf bfVar, @NonNull bf bfVar2, @NonNull ar arVar, @NonNull ar arVar2);

        public abstract boolean b();

        public abstract boolean b(@NonNull bf bfVar, @Nullable ar arVar, @NonNull ar arVar2);

        public abstract void c(bf bfVar);

        public abstract boolean c(@NonNull bf bfVar, @NonNull ar arVar, @NonNull ar arVar2);

        public abstract void d();

        static int e(bf bfVar) {
            int h = bfVar.l & 14;
            if (bfVar.j()) {
                return 4;
            }
            if ((h & 4) != 0) {
                return h;
            }
            int i = bfVar.c;
            int d = bfVar.d();
            if (i == -1 || d == -1 || i == d) {
                return h;
            }
            return h | 2048;
        }

        public final void f(bf bfVar) {
            if (this.h != null) {
                this.h.a(bfVar);
            }
        }

        public boolean g(@NonNull bf bfVar) {
            return true;
        }

        public boolean a(@NonNull bf bfVar, @NonNull List<Object> list) {
            return g(bfVar);
        }

        public final void e() {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i);
            }
            this.a.clear();
        }

        @NonNull
        public static ar d(bf bfVar) {
            return new ar().a(bfVar);
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = c.a(new ba());
        Parcelable c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = LayoutManager.class.getClassLoader();
            }
            this.c = parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.c, 0);
        }
    }

    /* compiled from: ProGuard */
    public final class State {
        int a = -1;
        int b = 1;
        int c = 0;
        int d = 0;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        private SparseArray<Object> o;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: ProGuard */
        @interface LayoutState {
        }

        final void a(int i) {
            if ((this.b & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.b));
            }
        }

        public final int a() {
            return this.g ? this.d - this.e : this.c;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.o + ", mItemCount=" + this.c + ", mPreviousLayoutItemCount=" + this.d + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.e + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.h + ", mRunPredictiveAnimations=" + this.i + '}';
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.a();
        f fVar = recyclerView.d;
        int a = fVar.a.a(view);
        if (a == -1) {
            fVar.b(view);
            z = true;
        } else if (fVar.b.c(a)) {
            fVar.b.d(a);
            fVar.b(view);
            fVar.a.a(a);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bf c = c(view);
            recyclerView.b.b(c);
            recyclerView.b.a(c);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.a(z2);
        return z;
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.j) {
            int i;
            recyclerView.j = true;
            int b = recyclerView.d.b();
            for (i = 0; i < b; i++) {
                bf c = c(recyclerView.d.c(i));
                if (!(c == null || c.b())) {
                    c.b(512);
                }
            }
            ax axVar = recyclerView.b;
            int size = axVar.c.size();
            for (i = 0; i < size; i++) {
                bf bfVar = (bf) axVar.c.get(i);
                if (bfVar != null) {
                    bfVar.b(512);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        v = z;
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
        this.x = new az();
        this.b = new ax(this);
        this.e = new bs();
        this.A = new ag(this);
        this.B = new Rect();
        this.C = new Rect();
        this.D = new RectF();
        this.g = new ArrayList();
        this.G = new ArrayList();
        this.K = 0;
        this.j = false;
        this.S = 0;
        this.o = new r();
        this.T = 0;
        this.U = -1;
        this.ag = Float.MIN_VALUE;
        this.ah = true;
        this.ai = new be(this);
        this.p = new State();
        this.r = false;
        this.s = false;
        this.ak = new as();
        this.al = false;
        this.ao = new int[2];
        this.aq = new int[2];
        this.ar = new int[2];
        this.as = new int[2];
        this.at = new ah(this);
        this.av = new aj(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u, i, 0);
            this.z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.z = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        this.P = z;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ad = viewConfiguration.getScaledTouchSlop();
        this.ae = viewConfiguration.getScaledMinimumFlingVelocity();
        this.af = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ViewCompat.a(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.o.h = this.ak;
        this.c = new c(new al(this));
        this.d = new f(new ak(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.c((View) this, 1);
        }
        this.Q = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new bh(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.taobao.c.c.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(com.taobao.c.c.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(com.taobao.c.c.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
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
                            constructor = asSubclass.getConstructor(w);
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
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public bh getCompatAccessibilityDelegate() {
        return this.am;
    }

    public void setAccessibilityDelegateCompat(bh bhVar) {
        this.am = bhVar;
        ViewCompat.a((View) this, this.am);
    }

    public void setHasFixedSize(boolean z) {
        this.J = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.z) {
            m();
        }
        this.z = z;
        super.setClipToPadding(z);
        if (this.h) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.ad = bq.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.ad = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(am amVar) {
        am amVar2;
        setLayoutFrozen(false);
        if (this.E != null) {
            amVar2 = this.E;
            amVar2.a.unregisterObserver(this.x);
        }
        if (this.o != null) {
            this.o.d();
        }
        if (this.f != null) {
            this.f.c(this.b);
            this.f.b(this.b);
        }
        this.b.a();
        this.c.a();
        amVar2 = this.E;
        this.E = amVar;
        if (amVar != null) {
            amVar.a.registerObserver(this.x);
        }
        ax axVar = this.b;
        am amVar3 = this.E;
        axVar.a();
        aw c = axVar.c();
        if (amVar2 != null) {
            c.b();
        }
        if (c.c == 0) {
            c.a.clear();
        }
        if (amVar3 != null) {
            c.a();
        }
        this.p.f = true;
        A();
        requestLayout();
    }

    public am getAdapter() {
        return this.E;
    }

    public void setRecyclerListener(ay ayVar) {
        this.F = ayVar;
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
                if (this.I) {
                    this.f.b(this, this.b);
                }
                this.f.a(null);
            }
            this.b.a();
            f fVar = this.d;
            d dVar = fVar.b;
            while (true) {
                dVar.a = 0;
                if (dVar.b == null) {
                    break;
                }
                dVar = dVar.b;
            }
            for (int size = fVar.c.size() - 1; size >= 0; size--) {
                fVar.a.d((View) fVar.c.get(size));
                fVar.c.remove(size);
            }
            fVar.a.b();
            this.f = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.q != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.q);
                }
                this.f.a(this);
                if (this.I) {
                    this.f.t = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.y != null) {
            savedState.c = this.y.c;
        } else if (this.f != null) {
            savedState.c = this.f.d();
        } else {
            savedState.c = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.y = (SavedState) parcelable;
            super.onRestoreInstanceState(this.y.b);
            if (this.f != null && this.y.c != null) {
                this.f.a(this.y.c);
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

    private void a(bf bfVar) {
        View view = bfVar.a;
        boolean z = view.getParent() == this;
        this.b.b(a(view));
        if (bfVar.n()) {
            this.d.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            f fVar = this.d;
            int a = fVar.a.a(view);
            if (a < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            fVar.b.a(a);
            fVar.a(view);
        } else {
            this.d.a(view, -1, true);
        }
    }

    public LayoutManager getLayoutManager() {
        return this.f;
    }

    public aw getRecycledViewPool() {
        return this.b.c();
    }

    public void setRecycledViewPool(aw awVar) {
        ax axVar = this.b;
        if (axVar.f != null) {
            axVar.f.b();
        }
        axVar.f = awVar;
        if (awVar != null) {
            aw awVar2 = axVar.f;
            axVar.h.getAdapter();
            awVar2.a();
        }
    }

    public void setViewCacheExtension(bd bdVar) {
        this.b.g = bdVar;
    }

    public void setItemViewCacheSize(int i) {
        ax axVar = this.b;
        axVar.e = i;
        for (int size = axVar.c.size() - 1; size >= 0 && axVar.c.size() > i; size--) {
            axVar.c(size);
        }
    }

    public int getScrollState() {
        return this.T;
    }

    private void setScrollState(int i) {
        if (i != this.T) {
            this.T = i;
            if (i != 2) {
                l();
            }
            if (this.f != null) {
                this.f.h(i);
            }
            if (this.aj != null) {
                this.aj.a(this, i);
            }
            if (this.q != null) {
                for (int size = this.q.size() - 1; size >= 0; size--) {
                    ((av) this.q.get(size)).a(this, i);
                }
            }
        }
    }

    public void setChildDrawingOrderCallback(ap apVar) {
        if (apVar != this.an) {
            this.an = apVar;
            setChildrenDrawingOrderEnabled(this.an != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(av avVar) {
        this.aj = avVar;
    }

    public final void a(av avVar) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(avVar);
    }

    public final void b(av avVar) {
        if (this.q != null) {
            this.q.remove(avVar);
        }
    }

    public final void a(int i) {
        if (!this.i) {
            k();
            if (this.f == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.f.c(i);
            awakenScrollBars();
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.i) {
            boolean e = this.f.e();
            boolean f = this.f.f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void j() {
        boolean z = false;
        if (!this.h || this.j) {
            f.a("RV FullInvalidate");
            v();
            f.a();
        } else if (!this.c.d()) {
        } else {
            if (this.c.a(4) && !this.c.a(11)) {
                f.a("RV PartialInvalidate");
                a();
                this.c.b();
                if (!this.L) {
                    int a = this.d.a();
                    for (int i = 0; i < a; i++) {
                        bf c = c(this.d.b(i));
                        if (c != null && !c.b() && c.s()) {
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
                f.a();
            } else if (this.c.d()) {
                f.a("RV FullInvalidate");
                v();
                f.a();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        j();
        if (this.E != null) {
            a();
            p();
            f.a("RV Scroll");
            if (i != 0) {
                i5 = this.f.a(i, this.b, this.p);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.f.b(i2, this.b, this.p);
                i4 = i2 - i6;
            }
            f.a();
            B();
            q();
            a(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.g.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.aq)) {
            this.ab -= this.aq[0];
            this.ac -= this.aq[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aq[0], (float) this.aq[1]);
            }
            int[] iArr = this.as;
            iArr[0] = iArr[0] + this.aq[0];
            iArr = this.as;
            iArr[1] = iArr[1] + this.aq[1];
        } else if (ViewCompat.a(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    b();
                    if (this.k.a((-f) / ((float) getWidth()), IPictureView.DEFAULT_MIN_SCALE - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    c();
                    if (this.m.a(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    d();
                    if (this.l.a((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    e();
                    if (this.n.a(f2 / ((float) getHeight()), IPictureView.DEFAULT_MIN_SCALE - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    ViewCompat.d(this);
                }
            }
            d(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            c(i4, i5);
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
        if (this.f != null && this.f.e()) {
            return this.f.b(this.p);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f != null && this.f.e()) {
            return this.f.d(this.p);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f != null && this.f.e()) {
            return this.f.f(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f != null && this.f.f()) {
            return this.f.c(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f != null && this.f.f()) {
            return this.f.e(this.p);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f != null && this.f.f()) {
            return this.f.g(this.p);
        }
        return 0;
    }

    final void a() {
        this.K++;
        if (this.K == 1 && !this.i) {
            this.L = false;
        }
    }

    final void a(boolean z) {
        if (this.K <= 0) {
            this.K = 1;
        }
        if (!z) {
            this.L = false;
        }
        if (this.K == 1) {
            if (!(!z || !this.L || this.i || this.f == null || this.E == null)) {
                v();
            }
            if (!this.i) {
                this.L = false;
            }
        }
        this.K--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.i) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.i = true;
                this.M = true;
                k();
                return;
            }
            this.i = false;
            if (!(!this.L || this.f == null || this.E == null)) {
                requestLayout();
            }
            this.L = false;
        }
    }

    public final void a(int i, int i2) {
        int i3 = 0;
        if (this.f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.i) {
            if (!this.f.e()) {
                i = 0;
            }
            if (this.f.f()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ai.a(i, i3);
            }
        }
    }

    private void k() {
        setScrollState(0);
        l();
    }

    private void l() {
        this.ai.b();
        if (this.f != null) {
            this.f.t();
        }
    }

    public int getMinFlingVelocity() {
        return this.ae;
    }

    public int getMaxFlingVelocity() {
        return this.af;
    }

    private void d(int i, int i2) {
        int i3 = 0;
        if (!(this.k == null || this.k.a() || i <= 0)) {
            i3 = this.k.c();
        }
        if (!(this.m == null || this.m.a() || i >= 0)) {
            i3 |= this.m.c();
        }
        if (!(this.l == null || this.l.a() || i2 <= 0)) {
            i3 |= this.l.c();
        }
        if (!(this.n == null || this.n.a() || i2 >= 0)) {
            i3 |= this.n.c();
        }
        if (i3 != 0) {
            ViewCompat.d(this);
        }
    }

    final void b() {
        if (this.k == null) {
            this.k = new e(getContext());
            if (this.z) {
                this.k.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.k.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void c() {
        if (this.m == null) {
            this.m = new e(getContext());
            if (this.z) {
                this.m.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.m.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void d() {
        if (this.l == null) {
            this.l = new e(getContext());
            if (this.z) {
                this.l.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.l.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void e() {
        if (this.n == null) {
            this.n = new e(getContext());
            if (this.z) {
                this.n.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.n.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void m() {
        this.n = null;
        this.l = null;
        this.m = null;
        this.k = null;
    }

    public View focusSearch(View view, int i) {
        int i2;
        View findNextFocus;
        int i3 = 17;
        int i4 = 0;
        boolean z = true;
        boolean z2 = (this.E == null || this.f == null || r() || this.i) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            int i5;
            if (this.f.f()) {
                if (i == 2) {
                    i5 = 130;
                } else {
                    i5 = 33;
                }
                if (instance.findNextFocus(this, view, i5) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f.e()) {
                if (ViewCompat.h(this.f.q) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i == 2) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                if (instance.findNextFocus(this, view, (i5 ^ i2) != 0 ? 66 : 17) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                j();
                if (b(view) == null) {
                    return null;
                }
                a();
                this.f.a(view, i, this.b, this.p);
                a(false);
            }
            findNextFocus = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus2 = instance.findNextFocus(this, view, i);
            if (findNextFocus2 == null && z2) {
                j();
                if (b(view) == null) {
                    return null;
                }
                a();
                findNextFocus = this.f.a(view, i, this.b, this.p);
                a(false);
            } else {
                findNextFocus = findNextFocus2;
            }
        }
        if (findNextFocus == null || findNextFocus == this) {
            z = false;
        } else if (view != null) {
            if (i == 2 || i == 1) {
                i2 = ViewCompat.h(this.f.q) == 1 ? 1 : 0;
                if (i == 2) {
                    i4 = 1;
                }
                if ((i4 ^ i2) != 0) {
                    i3 = 66;
                }
                if (!a(view, findNextFocus, i3)) {
                    z = i == 2 ? a(view, findNextFocus, 130) : a(view, findNextFocus, 33);
                }
            } else {
                z = a(view, findNextFocus, i);
            }
        }
        if (z) {
            return findNextFocus;
        }
        return super.focusSearch(view, i);
    }

    private boolean a(View view, View view2, int i) {
        this.B.set(0, 0, view.getWidth(), view.getHeight());
        this.C.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.B);
        offsetDescendantRectToMyCoords(view2, this.C);
        switch (i) {
            case 17:
                if ((this.B.right > this.C.right || this.B.left >= this.C.right) && this.B.left > this.C.left) {
                    return true;
                }
                return false;
            case 33:
                if ((this.B.bottom > this.C.bottom || this.B.top >= this.C.bottom) && this.B.top > this.C.top) {
                    return true;
                }
                return false;
            case 66:
                if ((this.B.left < this.C.left || this.B.right <= this.C.left) && this.B.right < this.C.right) {
                    return true;
                }
                return false;
            case 130:
                if ((this.B.top < this.C.top || this.B.bottom <= this.C.top) && this.B.bottom < this.C.bottom) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    public void requestChildFocus(View view, View view2) {
        int i;
        if (this.f.m() || r()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 && view2 != null) {
            this.B.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.e) {
                    Rect rect = layoutParams2.d;
                    Rect rect2 = this.B;
                    rect2.left -= rect.left;
                    rect2 = this.B;
                    rect2.right += rect.right;
                    rect2 = this.B;
                    rect2.top -= rect.top;
                    rect2 = this.B;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.B);
            offsetRectIntoDescendantCoords(view, this.B);
            requestChildRectangleOnScreen(view, this.B, !this.h);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        LayoutManager layoutManager = this.f;
        int o = layoutManager.o();
        int p = layoutManager.p();
        int q = layoutManager.y - layoutManager.q();
        int r = layoutManager.z - layoutManager.r();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - o);
        int min2 = Math.min(0, top - p);
        int max = Math.max(0, width - q);
        r = Math.max(0, height - r);
        if (ViewCompat.h(layoutManager.q) == 1) {
            if (max == 0) {
                max = Math.max(min, width - q);
            }
            min = max;
        } else {
            if (min != 0) {
                max = min;
            } else {
                max = Math.min(left - o, max);
            }
            min = max;
        }
        if (min2 != 0) {
            max = min2;
        } else {
            max = Math.min(top - p, r);
        }
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            scrollBy(min, max);
        } else {
            a(min, max);
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (r()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = 0;
        this.I = true;
        boolean z = this.h && !isLayoutRequested();
        this.h = z;
        if (this.f != null) {
            this.f.t = true;
        }
        this.al = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.o != null) {
            this.o.d();
        }
        k();
        this.I = false;
        if (this.f != null) {
            this.f.b(this, this.b);
        }
        removeCallbacks(this.at);
        bq.b();
    }

    public boolean isAttachedToWindow() {
        return this.I;
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
        if (this.i) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.H = null;
        }
        int size = this.G.size();
        for (i2 = 0; i2 < size; i2++) {
            au auVar = (au) this.G.get(i2);
            if (auVar.a() && action != 3) {
                this.H = auVar;
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
            z = this.f.e();
            boolean f = this.f.f();
            if (this.V == null) {
                this.V = VelocityTracker.obtain();
            }
            this.V.addMovement(motionEvent);
            action = aj.a(motionEvent);
            size = aj.b(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.M) {
                        this.M = false;
                    }
                    this.U = aj.b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.ab = i;
                    this.W = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.ac = i;
                    this.aa = i;
                    if (this.T == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.as;
                    this.as[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (f) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.V.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = aj.a(motionEvent, this.U);
                    if (action >= 0) {
                        size = (int) (aj.c(motionEvent, action) + 0.5f);
                        action = (int) (aj.d(motionEvent, action) + 0.5f);
                        if (this.T != 1) {
                            size -= this.W;
                            action -= this.aa;
                            if (!z || Math.abs(size) <= this.ad) {
                                z = false;
                            } else {
                                this.ab = ((size < 0 ? -1 : 1) * this.ad) + this.W;
                                z = true;
                            }
                            if (f && Math.abs(action) > this.ad) {
                                i3 = this.aa;
                                i2 = this.ad;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.ac = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.U + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    o();
                    break;
                case 5:
                    this.U = aj.b(motionEvent, size);
                    i3 = (int) (aj.c(motionEvent, size) + 0.5f);
                    this.ab = i3;
                    this.W = i3;
                    i3 = (int) (aj.d(motionEvent, size) + 0.5f);
                    this.ac = i3;
                    this.aa = i3;
                    break;
                case 6:
                    a(motionEvent);
                    break;
            }
            if (this.T != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.G.size();
        for (int i = 0; i < size; i++) {
            this.G.get(i);
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
        r0 = r12.i;
        if (r0 != 0) goto L_0x000e;
    L_0x000a:
        r0 = r12.M;
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return r2;
    L_0x000f:
        r0 = r13.getAction();
        r4 = r12.H;
        if (r4 == 0) goto L_0x001b;
    L_0x0017:
        if (r0 != 0) goto L_0x003e;
    L_0x0019:
        r12.H = r5;
    L_0x001b:
        if (r0 == 0) goto L_0x004b;
    L_0x001d:
        r0 = r12.G;
        r5 = r0.size();
        r4 = r2;
    L_0x0024:
        if (r4 >= r5) goto L_0x004b;
    L_0x0026:
        r0 = r12.G;
        r0 = r0.get(r4);
        r0 = (android.mini.support.v7.widget.au) r0;
        r6 = r0.a();
        if (r6 == 0) goto L_0x0047;
    L_0x0034:
        r12.H = r0;
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
        r12.H = r5;
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
        r5 = r0.e();
        r0 = r12.f;
        r6 = r0.f();
        r0 = r12.V;
        if (r0 != 0) goto L_0x0067;
    L_0x0061:
        r0 = android.view.VelocityTracker.obtain();
        r12.V = r0;
    L_0x0067:
        r7 = android.view.MotionEvent.obtain(r13);
        r0 = android.mini.support.v4.view.aj.a(r13);
        r4 = android.mini.support.v4.view.aj.b(r13);
        if (r0 != 0) goto L_0x007d;
    L_0x0075:
        r8 = r12.as;
        r9 = r12.as;
        r9[r3] = r2;
        r8[r2] = r2;
    L_0x007d:
        r8 = r12.as;
        r8 = r8[r2];
        r8 = (float) r8;
        r9 = r12.as;
        r9 = r9[r3];
        r9 = (float) r9;
        r7.offsetLocation(r8, r9);
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01ab;
            case 2: goto L_0x00da;
            case 3: goto L_0x026a;
            case 4: goto L_0x008d;
            case 5: goto L_0x00bf;
            case 6: goto L_0x01a6;
            default: goto L_0x008d;
        };
    L_0x008d:
        if (r2 != 0) goto L_0x0094;
    L_0x008f:
        r0 = r12.V;
        r0.addMovement(r7);
    L_0x0094:
        r7.recycle();
        r2 = r3;
        goto L_0x000e;
    L_0x009a:
        r0 = android.mini.support.v4.view.aj.b(r13, r2);
        r12.U = r0;
        r0 = r13.getX();
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.ab = r0;
        r12.W = r0;
        r0 = r13.getY();
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.ac = r0;
        r12.aa = r0;
        if (r5 == 0) goto L_0x0276;
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
        r0 = android.mini.support.v4.view.aj.b(r13, r4);
        r12.U = r0;
        r0 = android.mini.support.v4.view.aj.c(r13, r4);
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.ab = r0;
        r12.W = r0;
        r0 = android.mini.support.v4.view.aj.d(r13, r4);
        r0 = r0 + r10;
        r0 = (int) r0;
        r12.ac = r0;
        r12.aa = r0;
        goto L_0x008d;
    L_0x00da:
        r0 = r12.U;
        r0 = android.mini.support.v4.view.aj.a(r13, r0);
        if (r0 >= 0) goto L_0x0100;
    L_0x00e2:
        r0 = "RecyclerView";
        r1 = new java.lang.StringBuilder;
        r3 = "Error processing scroll; pointer index for id ";
        r1.<init>(r3);
        r3 = r12.U;
        r1 = r1.append(r3);
        r3 = " not found. Did any MotionEvents get skipped?";
        r1 = r1.append(r3);
        r1 = r1.toString();
        android.util.Log.e(r0, r1);
        goto L_0x000e;
    L_0x0100:
        r1 = android.mini.support.v4.view.aj.c(r13, r0);
        r1 = r1 + r10;
        r8 = (int) r1;
        r0 = android.mini.support.v4.view.aj.d(r13, r0);
        r0 = r0 + r10;
        r9 = (int) r0;
        r0 = r12.ab;
        r1 = r0 - r8;
        r0 = r12.ac;
        r0 = r0 - r9;
        r4 = r12.ar;
        r10 = r12.aq;
        r4 = r12.dispatchNestedPreScroll(r1, r0, r4, r10);
        if (r4 == 0) goto L_0x014a;
    L_0x011d:
        r4 = r12.ar;
        r4 = r4[r2];
        r1 = r1 - r4;
        r4 = r12.ar;
        r4 = r4[r3];
        r0 = r0 - r4;
        r4 = r12.aq;
        r4 = r4[r2];
        r4 = (float) r4;
        r10 = r12.aq;
        r10 = r10[r3];
        r10 = (float) r10;
        r7.offsetLocation(r4, r10);
        r4 = r12.as;
        r10 = r4[r2];
        r11 = r12.aq;
        r11 = r11[r2];
        r10 = r10 + r11;
        r4[r2] = r10;
        r4 = r12.as;
        r10 = r4[r3];
        r11 = r12.aq;
        r11 = r11[r3];
        r10 = r10 + r11;
        r4[r3] = r10;
    L_0x014a:
        r4 = r12.T;
        if (r4 == r3) goto L_0x0173;
    L_0x014e:
        if (r5 == 0) goto L_0x0273;
    L_0x0150:
        r4 = java.lang.Math.abs(r1);
        r10 = r12.ad;
        if (r4 <= r10) goto L_0x0273;
    L_0x0158:
        if (r1 <= 0) goto L_0x019a;
    L_0x015a:
        r4 = r12.ad;
        r1 = r1 - r4;
    L_0x015d:
        r4 = r3;
    L_0x015e:
        if (r6 == 0) goto L_0x016e;
    L_0x0160:
        r10 = java.lang.Math.abs(r0);
        r11 = r12.ad;
        if (r10 <= r11) goto L_0x016e;
    L_0x0168:
        if (r0 <= 0) goto L_0x019e;
    L_0x016a:
        r4 = r12.ad;
        r0 = r0 - r4;
    L_0x016d:
        r4 = r3;
    L_0x016e:
        if (r4 == 0) goto L_0x0173;
    L_0x0170:
        r12.setScrollState(r3);
    L_0x0173:
        r4 = r12.T;
        if (r4 != r3) goto L_0x008d;
    L_0x0177:
        r4 = r12.aq;
        r4 = r4[r2];
        r4 = r8 - r4;
        r12.ab = r4;
        r4 = r12.aq;
        r4 = r4[r3];
        r4 = r9 - r4;
        r12.ac = r4;
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
        r4 = r12.ad;
        r1 = r1 + r4;
        goto L_0x015d;
    L_0x019e:
        r4 = r12.ad;
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
        r0 = r12.V;
        r0.addMovement(r7);
        r0 = r12.V;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r12.af;
        r8 = (float) r8;
        r0.computeCurrentVelocity(r4, r8);
        if (r5 == 0) goto L_0x01f2;
    L_0x01bc:
        r0 = r12.V;
        r4 = r12.U;
        r0 = android.mini.support.v4.view.at.a(r0, r4);
        r0 = -r0;
        r4 = r0;
    L_0x01c6:
        if (r6 == 0) goto L_0x01f4;
    L_0x01c8:
        r0 = r12.V;
        r5 = r12.U;
        r0 = android.mini.support.v4.view.at.b(r0, r5);
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
        r4 = r12.i;
        if (r4 != 0) goto L_0x01e6;
    L_0x01fa:
        r4 = r12.f;
        r5 = r4.e();
        r4 = r12.f;
        r6 = r4.f();
        if (r5 == 0) goto L_0x0210;
    L_0x0208:
        r4 = java.lang.Math.abs(r1);
        r8 = r12.ae;
        if (r4 >= r8) goto L_0x0271;
    L_0x0210:
        r4 = r2;
    L_0x0211:
        if (r6 == 0) goto L_0x021b;
    L_0x0213:
        r1 = java.lang.Math.abs(r0);
        r8 = r12.ae;
        if (r1 >= r8) goto L_0x026f;
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
        if (r6 == 0) goto L_0x0268;
    L_0x022c:
        r0 = r3;
    L_0x022d:
        r5 = (float) r4;
        r6 = (float) r1;
        r12.dispatchNestedFling(r5, r6, r0);
        if (r0 == 0) goto L_0x01e6;
    L_0x0234:
        r0 = r12.af;
        r0 = -r0;
        r5 = r12.af;
        r4 = java.lang.Math.min(r4, r5);
        r0 = java.lang.Math.max(r0, r4);
        r4 = r12.af;
        r4 = -r4;
        r5 = r12.af;
        r1 = java.lang.Math.min(r1, r5);
        r1 = java.lang.Math.max(r4, r1);
        r4 = r12.ai;
        r5 = r4.d;
        r6 = 2;
        r5.setScrollState(r6);
        r4.b = r2;
        r4.a = r2;
        r5 = r4.c;
        r6 = r5.b;
        r5 = r5.a;
        r6.a(r5, r0, r1);
        r4.a();
        r0 = r3;
        goto L_0x01e7;
    L_0x0268:
        r0 = r2;
        goto L_0x022d;
    L_0x026a:
        r12.o();
        goto L_0x008d;
    L_0x026f:
        r1 = r0;
        goto L_0x021c;
    L_0x0271:
        r4 = r1;
        goto L_0x0211;
    L_0x0273:
        r4 = r2;
        goto L_0x015e;
    L_0x0276:
        r0 = r2;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void n() {
        if (this.V != null) {
            this.V.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.k != null) {
            i = this.k.c();
        }
        if (this.l != null) {
            i |= this.l.c();
        }
        if (this.m != null) {
            i |= this.m.c();
        }
        if (this.n != null) {
            i |= this.n.c();
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
        int b = aj.b(motionEvent);
        if (aj.b(motionEvent, b) == this.U) {
            b = b == 0 ? 1 : 0;
            this.U = aj.b(motionEvent, b);
            int c = (int) (aj.c(motionEvent, b) + 0.5f);
            this.ab = c;
            this.W = c;
            b = (int) (aj.d(motionEvent, b) + 0.5f);
            this.ac = b;
            this.aa = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f == null || this.i || (aj.c(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f.f()) {
                f = -aj.e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f.e()) {
                e = aj.e(motionEvent, 10);
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
        if (this.ag == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ag = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ag;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f == null) {
            b(i, i2);
        } else if (this.f.u) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == UCCore.VERIFY_POLICY_QUICK && mode2 == UCCore.VERIFY_POLICY_QUICK) {
                z = true;
            }
            this.f.g(i, i2);
            if (!z && this.E != null) {
                if (this.p.b == 1) {
                    x();
                }
                this.f.e(i, i2);
                this.p.k = true;
                y();
                this.f.f(i, i2);
                if (this.f.i()) {
                    this.f.e(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
                    this.p.k = true;
                    y();
                    this.f.f(i, i2);
                }
            }
        } else if (this.J) {
            this.f.g(i, i2);
        } else {
            if (this.O) {
                a();
                u();
                if (this.p.i) {
                    this.p.g = true;
                } else {
                    this.c.e();
                    this.p.g = false;
                }
                this.O = false;
                a(false);
            }
            if (this.E != null) {
                this.p.c = this.E.a();
            } else {
                this.p.c = 0;
            }
            a();
            this.f.g(i, i2);
            a(false);
            this.p.g = false;
        }
    }

    final void b(int i, int i2) {
        setMeasuredDimension(LayoutManager.a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.l(this)), LayoutManager.a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.m(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.o != null) {
            this.o.d();
            this.o.h = null;
        }
        this.o = itemAnimator;
        if (this.o != null) {
            this.o.h = this.ak;
        }
    }

    private void p() {
        this.S++;
    }

    private void q() {
        this.S--;
        if (this.S <= 0) {
            this.S = 0;
            int i = this.N;
            this.N = 0;
            if (i != 0 && f()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.mini.support.v4.view.a.e.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean f() {
        return this.Q != null && this.Q.isEnabled();
    }

    private boolean r() {
        return this.S > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (r()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.mini.support.v4.view.a.e.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.N = i | this.N;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.o;
    }

    private void s() {
        if (!this.al && this.I) {
            ViewCompat.a((View) this, this.at);
            this.al = true;
        }
    }

    private boolean t() {
        return this.o != null && this.f.c();
    }

    private void u() {
        boolean z;
        boolean z2 = true;
        if (this.j) {
            this.c.a();
            A();
            this.f.a();
        }
        if (t()) {
            this.c.b();
        } else {
            this.c.e();
        }
        boolean z3;
        if (this.r || this.s) {
            z3 = true;
        } else {
            z3 = false;
        }
        State state = this.p;
        if (!this.h || this.o == null || (!(this.j || r0 || this.f.s) || (this.j && !this.E.b))) {
            z = false;
        } else {
            z = true;
        }
        state.h = z;
        State state2 = this.p;
        if (!(this.p.h && r0 && !this.j && t())) {
            z2 = false;
        }
        state2.i = z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
        r10 = this;
        r0 = r10.E;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = "RecyclerView";
        r1 = "No adapter attached; skipping layout";
        android.util.Log.e(r0, r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r10.f;
        if (r0 != 0) goto L_0x0018;
    L_0x0010:
        r0 = "RecyclerView";
        r1 = "No layout manager attached; skipping layout";
        android.util.Log.e(r0, r1);
        goto L_0x000b;
    L_0x0018:
        r0 = r10.p;
        r1 = 0;
        r0.k = r1;
        r0 = r10.p;
        r0 = r0.b;
        r1 = 1;
        if (r0 != r1) goto L_0x00fb;
    L_0x0024:
        r10.x();
        r0 = r10.f;
        r0.b(r10);
        r10.y();
    L_0x002f:
        r0 = r10.p;
        r1 = 4;
        r0.a(r1);
        r10.a();
        r10.p();
        r0 = r10.p;
        r1 = 1;
        r0.b = r1;
        r0 = r10.p;
        r0 = r0.h;
        if (r0 == 0) goto L_0x01bc;
    L_0x0046:
        r0 = r10.d;
        r0 = r0.a();
        r0 = r0 + -1;
        r2 = r0;
    L_0x004f:
        if (r2 < 0) goto L_0x01b5;
    L_0x0051:
        r0 = r10.d;
        r0 = r0.b(r2);
        r3 = c(r0);
        r0 = r3.b();
        if (r0 != 0) goto L_0x017e;
    L_0x0061:
        r4 = r10.b(r3);
        r0 = new android.mini.support.v7.widget.ar;
        r0.<init>();
        r1 = r0.a(r3);
        r0 = r10.e;
        r0 = r0.b;
        r6 = r0.c;
        r7 = r0.e;
        r6 = android.mini.support.v4.d.c.a(r6, r7, r4);
        if (r6 < 0) goto L_0x0084;
    L_0x007c:
        r7 = r0.d;
        r7 = r7[r6];
        r8 = android.mini.support.v4.d.f.a;
        if (r7 != r8) goto L_0x0137;
    L_0x0084:
        r0 = 0;
    L_0x0085:
        r0 = (android.mini.support.v7.widget.bf) r0;
        if (r0 == 0) goto L_0x01af;
    L_0x0089:
        r6 = r0.b();
        if (r6 != 0) goto L_0x01af;
    L_0x008f:
        r6 = r10.e;
        r6 = r6.a(r0);
        r7 = r10.e;
        r7 = r7.a(r3);
        if (r6 == 0) goto L_0x009f;
    L_0x009d:
        if (r0 == r3) goto L_0x01af;
    L_0x009f:
        r8 = r10.e;
        r9 = 4;
        r8 = r8.a(r0, r9);
        r9 = r10.e;
        r9.b(r3, r1);
        r1 = r10.e;
        r9 = 8;
        r1 = r1.a(r3, r9);
        if (r8 != 0) goto L_0x0183;
    L_0x00b5:
        r1 = r10.d;
        r6 = r1.a();
        r1 = 0;
    L_0x00bc:
        if (r1 >= r6) goto L_0x0160;
    L_0x00be:
        r7 = r10.d;
        r7 = r7.b(r1);
        r7 = c(r7);
        if (r7 == r3) goto L_0x015c;
    L_0x00ca:
        r8 = r10.b(r7);
        r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r8 != 0) goto L_0x015c;
    L_0x00d2:
        r0 = r10.E;
        if (r0 == 0) goto L_0x013d;
    L_0x00d6:
        r0 = r10.E;
        r0 = r0.b;
        if (r0 == 0) goto L_0x013d;
    L_0x00dc:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r2 = " \n View Holder 2:";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00fb:
        r0 = r10.c;
        r1 = r0.b;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x012e;
    L_0x0105:
        r0 = r0.a;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x012e;
    L_0x010d:
        r0 = 1;
    L_0x010e:
        if (r0 != 0) goto L_0x0124;
    L_0x0110:
        r0 = r10.f;
        r0 = r0.y;
        r1 = r10.getWidth();
        if (r0 != r1) goto L_0x0124;
    L_0x011a:
        r0 = r10.f;
        r0 = r0.z;
        r1 = r10.getHeight();
        if (r0 == r1) goto L_0x0130;
    L_0x0124:
        r0 = r10.f;
        r0.b(r10);
        r10.y();
        goto L_0x002f;
    L_0x012e:
        r0 = 0;
        goto L_0x010e;
    L_0x0130:
        r0 = r10.f;
        r0.b(r10);
        goto L_0x002f;
    L_0x0137:
        r0 = r0.d;
        r0 = r0[r6];
        goto L_0x0085;
    L_0x013d:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r2 = " \n View Holder 2:";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x015c:
        r1 = r1 + 1;
        goto L_0x00bc;
    L_0x0160:
        r1 = "RecyclerView";
        r4 = new java.lang.StringBuilder;
        r5 = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder ";
        r4.<init>(r5);
        r0 = r4.append(r0);
        r4 = " cannot be found but it is necessary for ";
        r0 = r0.append(r4);
        r0 = r0.append(r3);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
    L_0x017e:
        r0 = r2 + -1;
        r2 = r0;
        goto L_0x004f;
    L_0x0183:
        r4 = 0;
        r0.a(r4);
        if (r6 == 0) goto L_0x018c;
    L_0x0189:
        r10.a(r0);
    L_0x018c:
        if (r0 == r3) goto L_0x01a3;
    L_0x018e:
        if (r7 == 0) goto L_0x0193;
    L_0x0190:
        r10.a(r3);
    L_0x0193:
        r0.g = r3;
        r10.a(r0);
        r4 = r10.b;
        r4.b(r0);
        r4 = 0;
        r3.a(r4);
        r3.h = r0;
    L_0x01a3:
        r4 = r10.o;
        r0 = r4.a(r0, r3, r8, r1);
        if (r0 == 0) goto L_0x017e;
    L_0x01ab:
        r10.s();
        goto L_0x017e;
    L_0x01af:
        r0 = r10.e;
        r0.b(r3, r1);
        goto L_0x017e;
    L_0x01b5:
        r0 = r10.e;
        r1 = r10.av;
        r0.a(r1);
    L_0x01bc:
        r0 = r10.f;
        r1 = r10.b;
        r0.b(r1);
        r0 = r10.p;
        r1 = r10.p;
        r1 = r1.c;
        r0.d = r1;
        r0 = 0;
        r10.j = r0;
        r0 = r10.p;
        r1 = 0;
        r0.h = r1;
        r0 = r10.p;
        r1 = 0;
        r0.i = r1;
        r0 = r10.f;
        r0.s = false;
        r0 = r10.b;
        r0 = r0.b;
        if (r0 == 0) goto L_0x01ea;
    L_0x01e3:
        r0 = r10.b;
        r0 = r0.b;
        r0.clear();
    L_0x01ea:
        r0 = r10.f;
        r1 = r10.p;
        r0.a(r1);
        r10.q();
        r0 = 0;
        r10.a(r0);
        r0 = r10.e;
        r0.a();
        r0 = r10.ao;
        r1 = 0;
        r0 = r0[r1];
        r1 = r10.ao;
        r2 = 1;
        r1 = r1[r2];
        r2 = r10.d;
        r2 = r2.a();
        if (r2 != 0) goto L_0x0230;
    L_0x020f:
        if (r0 != 0) goto L_0x0213;
    L_0x0211:
        if (r1 == 0) goto L_0x022e;
    L_0x0213:
        r0 = 1;
    L_0x0214:
        if (r0 == 0) goto L_0x021b;
    L_0x0216:
        r0 = 0;
        r1 = 0;
        r10.c(r0, r1);
    L_0x021b:
        r0 = r10.ah;
        if (r0 == 0) goto L_0x0229;
    L_0x021f:
        r0 = r10.E;
        if (r0 == 0) goto L_0x0229;
    L_0x0223:
        r0 = r10.hasFocus();
        if (r0 != 0) goto L_0x0247;
    L_0x0229:
        r10.w();
        goto L_0x000b;
    L_0x022e:
        r0 = 0;
        goto L_0x0214;
    L_0x0230:
        r2 = r10.ao;
        r10.a(r2);
        r2 = r10.ao;
        r3 = 0;
        r2 = r2[r3];
        if (r2 != r0) goto L_0x0243;
    L_0x023c:
        r0 = r10.ao;
        r2 = 1;
        r0 = r0[r2];
        if (r0 == r1) goto L_0x0245;
    L_0x0243:
        r0 = 1;
        goto L_0x0214;
    L_0x0245:
        r0 = 0;
        goto L_0x0214;
    L_0x0247:
        r0 = r10.isFocused();
        if (r0 != 0) goto L_0x025b;
    L_0x024d:
        r0 = r10.getFocusedChild();
        if (r0 == 0) goto L_0x0229;
    L_0x0253:
        r1 = r10.d;
        r0 = r1.d(r0);
        if (r0 == 0) goto L_0x0229;
    L_0x025b:
        r0 = 0;
        r1 = r10.p;
        r1 = r1.l;
        r2 = -1;
        if (r1 == r2) goto L_0x026b;
    L_0x0263:
        r0 = r10.p;
        r0 = r0.l;
        r0 = r10.b(r0);
    L_0x026b:
        if (r0 != 0) goto L_0x0285;
    L_0x026d:
        r1 = r10.p;
        r2 = r1.m;
        r4 = -1;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x0285;
    L_0x0277:
        r1 = r10.E;
        r1 = r1.b;
        if (r1 == 0) goto L_0x0285;
    L_0x027d:
        r0 = r10.p;
        r0 = r0.m;
        r0 = r10.a(r0);
    L_0x0285:
        if (r0 == 0) goto L_0x0229;
    L_0x0287:
        r1 = r0.a;
        r1 = r1.hasFocus();
        if (r1 != 0) goto L_0x0229;
    L_0x028f:
        r1 = r0.a;
        r1 = r1.hasFocusable();
        if (r1 == 0) goto L_0x0229;
    L_0x0297:
        r1 = r0.a;
        r2 = r10.p;
        r2 = r2.n;
        r2 = (long) r2;
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x02bb;
    L_0x02a4:
        r0 = r0.a;
        r2 = r10.p;
        r2 = r2.n;
        r0 = r0.findViewById(r2);
        if (r0 == 0) goto L_0x02bb;
    L_0x02b0:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x02bb;
    L_0x02b6:
        r0.requestFocus();
        goto L_0x0229;
    L_0x02bb:
        r0 = r1;
        goto L_0x02b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v7.widget.RecyclerView.v():void");
    }

    private void w() {
        this.p.m = -1;
        this.p.l = -1;
        this.p.n = -1;
    }

    private void x() {
        View focusedChild;
        bf bfVar;
        State state;
        int i;
        int id;
        boolean z;
        this.p.a(1);
        this.p.k = false;
        a();
        this.e.a();
        p();
        if (this.ah && hasFocus() && this.E != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        if (focusedChild == null) {
            bfVar = null;
        } else {
            focusedChild = b(focusedChild);
            bfVar = focusedChild == null ? null : a(focusedChild);
        }
        if (bfVar == null) {
            w();
        } else {
            long j;
            State state2 = this.p;
            if (this.E.b) {
                j = bfVar.d;
            } else {
                j = -1;
            }
            state2.m = j;
            state = this.p;
            if (this.j) {
                i = -1;
            } else {
                i = bfVar.d();
            }
            state.l = i;
            state2 = this.p;
            View view = bfVar.a;
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            state2.n = id;
        }
        u();
        state = this.p;
        if (this.p.h && this.s) {
            z = true;
        } else {
            z = false;
        }
        state.j = z;
        this.s = false;
        this.r = false;
        this.p.g = this.p.i;
        this.p.c = this.E.a();
        a(this.ao);
        if (this.p.h) {
            id = this.d.a();
            for (i = 0; i < id; i++) {
                bfVar = c(this.d.b(i));
                if (!bfVar.b() && (!bfVar.j() || this.E.b)) {
                    ItemAnimator.e(bfVar);
                    bfVar.p();
                    this.e.a(bfVar, ItemAnimator.d(bfVar));
                    if (!(!this.p.j || !bfVar.s() || bfVar.m() || bfVar.b() || bfVar.j())) {
                        this.e.a(b(bfVar), bfVar);
                    }
                }
            }
        }
        if (this.p.i) {
            id = this.d.b();
            for (i = 0; i < id; i++) {
                bfVar = c(this.d.c(i));
                if (!bfVar.b() && bfVar.c == -1) {
                    bfVar.c = bfVar.b;
                }
            }
            z = this.p.f;
            this.p.f = false;
            this.f.c(this.b, this.p);
            this.p.f = z;
            for (id = 0; id < this.d.a(); id++) {
                bf c = c(this.d.b(id));
                if (!c.b()) {
                    bq bqVar = (bq) this.e.a.get(c);
                    if (bqVar == null || (bqVar.a & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        ItemAnimator.e(c);
                        z = c.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                        c.p();
                        ar d = ItemAnimator.d(c);
                        if (z) {
                            a(c, d);
                        } else {
                            bs bsVar = this.e;
                            bqVar = (bq) bsVar.a.get(c);
                            if (bqVar == null) {
                                bqVar = bq.a();
                                bsVar.a.put(c, bqVar);
                            }
                            bqVar.a |= 2;
                            bqVar.b = d;
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

    private void y() {
        boolean z;
        a();
        p();
        this.p.a(6);
        this.c.e();
        this.p.c = this.E.a();
        this.p.e = 0;
        this.p.g = false;
        this.f.c(this.b, this.p);
        this.p.f = false;
        this.y = null;
        State state = this.p;
        if (!this.p.h || this.o == null) {
            z = false;
        } else {
            z = true;
        }
        state.h = z;
        this.p.b = 4;
        q();
        a(false);
    }

    private void a(bf bfVar, ar arVar) {
        bfVar.a(0, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        if (this.p.j && bfVar.s() && !bfVar.m() && !bfVar.b()) {
            this.e.a(b(bfVar), bfVar);
        }
        this.e.a(bfVar, arVar);
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
            bf c2 = c(this.d.b(i3));
            if (!c2.b()) {
                c = c2.c();
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
        bf c = c(view);
        if (c != null) {
            if (c.n()) {
                c.i();
            } else if (!c.b()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c);
            }
        }
        f(view);
        super.removeDetachedView(view, z);
    }

    private long b(bf bfVar) {
        if (this.E.b) {
            return bfVar.d;
        }
        return (long) bfVar.b;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        f.a("RV OnLayout");
        v();
        f.a();
        this.h = true;
    }

    public void requestLayout() {
        if (this.K != 0 || this.i) {
            this.L = true;
        } else {
            super.requestLayout();
        }
    }

    public final void g() {
        int i = 0;
        int b = this.d.b();
        for (int i2 = 0; i2 < b; i2++) {
            ((LayoutParams) this.d.c(i2).getLayoutParams()).e = true;
        }
        ax axVar = this.b;
        b = axVar.c.size();
        while (i < b) {
            LayoutParams layoutParams = (LayoutParams) ((bf) axVar.c.get(i)).a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.e = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.g.size();
        for (i = 0; i < size; i++) {
            ((at) this.g.get(i)).a(canvas, this, this.p);
        }
        if (this.k == null || this.k.a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.z ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.k == null || !this.k.a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.l == null || this.l.a())) {
            size = canvas.save();
            if (this.z) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.l == null || !this.l.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.m == null || this.m.a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.z) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.m == null || !this.m.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.n == null || this.n.a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.z) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.n != null && this.n.a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.o == null || this.g.size() <= 0 || !this.o.b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ViewCompat.d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f.a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f != null) {
            return this.f.b();
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
            bf c = c(this.d.c(i2));
            if (!c.b()) {
                c.a();
            }
        }
        ax axVar = this.b;
        int size = axVar.c.size();
        for (b = 0; b < size; b++) {
            ((bf) axVar.c.get(b)).a();
        }
        size = axVar.a.size();
        for (b = 0; b < size; b++) {
            ((bf) axVar.a.get(b)).a();
        }
        if (axVar.b != null) {
            b = axVar.b.size();
            while (i < b) {
                ((bf) axVar.b.get(i)).a();
                i++;
            }
        }
    }

    final void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int b = this.d.b();
        for (int i4 = 0; i4 < b; i4++) {
            bf c = c(this.d.c(i4));
            if (!(c == null || c.b())) {
                if (c.b >= i3) {
                    c.a(-i2, z);
                    this.p.f = true;
                } else if (c.b >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    c.b(8);
                    c.a(i6, z);
                    c.b = i5;
                    this.p.f = true;
                }
            }
        }
        ax axVar = this.b;
        int i7 = i + i2;
        for (i3 = axVar.c.size() - 1; i3 >= 0; i3--) {
            bf bfVar = (bf) axVar.c.get(i3);
            if (bfVar != null) {
                if (bfVar.b >= i7) {
                    bfVar.a(-i2, z);
                } else if (bfVar.b >= i) {
                    bfVar.b(8);
                    axVar.c(i3);
                }
            }
        }
        requestLayout();
    }

    private void A() {
        int i;
        int b = this.d.b();
        for (i = 0; i < b; i++) {
            bf c = c(this.d.c(i));
            if (!(c == null || c.b())) {
                c.b(6);
            }
        }
        g();
        ax axVar = this.b;
        if (axVar.h.E == null || !axVar.h.E.b) {
            axVar.b();
            return;
        }
        int size = axVar.c.size();
        for (i = 0; i < size; i++) {
            bf bfVar = (bf) axVar.c.get(i);
            if (bfVar != null) {
                bfVar.b(6);
                bfVar.a(null);
            }
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ah;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ah = z;
    }

    public final bf a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Nullable
    public final View b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    static bf c(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).c;
    }

    public static int d(View view) {
        bf c = c(view);
        return c != null ? c.c() : -1;
    }

    private bf b(int i) {
        if (this.j) {
            return null;
        }
        int b = this.d.b();
        int i2 = 0;
        bf bfVar = null;
        while (i2 < b) {
            bf c = c(this.d.c(i2));
            if (c == null || c.m() || c(c) != i) {
                c = bfVar;
            } else if (!this.d.d(c.a)) {
                return c;
            }
            i2++;
            bfVar = c;
        }
        return bfVar;
    }

    private bf a(long j) {
        if (this.E == null || !this.E.b) {
            return null;
        }
        int b = this.d.b();
        int i = 0;
        bf bfVar = null;
        while (i < b) {
            bf c = c(this.d.c(i));
            if (c == null || c.m() || c.d != j) {
                c = bfVar;
            } else if (!this.d.d(c.a)) {
                return c;
            }
            i++;
            bfVar = c;
        }
        return bfVar;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.e) {
            return layoutParams.d;
        }
        Rect rect = layoutParams.d;
        rect.set(0, 0, 0, 0);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.B.set(0, 0, 0, 0);
            this.g.get(i);
            Rect rect2 = this.B;
            ((LayoutParams) view.getLayoutParams()).c.c();
            rect2.set(0, 0, 0, 0);
            rect.left += this.B.left;
            rect.top += this.B.top;
            rect.right += this.B.right;
            rect.bottom += this.B.bottom;
        }
        layoutParams.e = false;
        return rect;
    }

    final void c(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.aj != null) {
            this.aj.a(this, i, i2);
        }
        if (this.q != null) {
            for (scrollY = this.q.size() - 1; scrollY >= 0; scrollY--) {
                ((av) this.q.get(scrollY)).a(this, i, i2);
            }
        }
    }

    private void B() {
        int a = this.d.a();
        for (int i = 0; i < a; i++) {
            View b = this.d.b(i);
            bf a2 = a(b);
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

    private void f(View view) {
        c(view);
        if (this.R != null) {
            for (int size = this.R.size() - 1; size >= 0; size--) {
                this.R.get(size);
            }
        }
    }

    private int c(bf bfVar) {
        if (bfVar.a(524) || !bfVar.l()) {
            return -1;
        }
        c cVar = this.c;
        int i = bfVar.b;
        int size = cVar.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) cVar.a.get(i2);
            switch (bVar.a) {
                case 1:
                    if (bVar.b > i) {
                        break;
                    }
                    i += bVar.d;
                    break;
                case 2:
                    if (bVar.b <= i) {
                        if (bVar.b + bVar.d <= i) {
                            i -= bVar.d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.b != i) {
                        if (bVar.b < i) {
                            i--;
                        }
                        if (bVar.d > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.d;
                    break;
                default:
                    break;
            }
        }
        return i;
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
        if (this.an == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.an.a();
    }

    private al getScrollingChildHelper() {
        if (this.ap == null) {
            this.ap = new al(this);
        }
        return this.ap;
    }

    static /* synthetic */ void a(RecyclerView recyclerView, bf bfVar, ar arVar, ar arVar2) {
        recyclerView.a(bfVar);
        bfVar.a(false);
        if (recyclerView.o.a(bfVar, arVar, arVar2)) {
            recyclerView.s();
        }
    }

    static /* synthetic */ void b(RecyclerView recyclerView, bf bfVar, ar arVar, ar arVar2) {
        bfVar.a(false);
        if (recyclerView.o.b(bfVar, arVar, arVar2)) {
            recyclerView.s();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        bf c = c(view);
        if (!(recyclerView.E == null || c == null)) {
            recyclerView.E.c(c);
        }
        if (recyclerView.R != null) {
            for (int size = recyclerView.R.size() - 1; size >= 0; size--) {
                recyclerView.R.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, bf bfVar) {
        return recyclerView.o == null || recyclerView.o.a(bfVar, bfVar.p());
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int i) {
        if (recyclerView.f != null) {
            recyclerView.f.c(i);
            recyclerView.awakenScrollBars();
        }
    }
}
