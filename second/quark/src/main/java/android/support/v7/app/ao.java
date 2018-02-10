package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v4.view.l;
import android.support.v4.view.p;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.view.d;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bt;
import android.support.v7.widget.cl;
import android.support.v7.widget.fu;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class ao extends ActionBar implements cl {
    static final /* synthetic */ boolean h = (!ao.class.desiredAssertionStatus());
    private static final Interpolator i = new AccelerateInterpolator();
    private static final Interpolator j = new DecelerateInterpolator();
    private static final boolean k;
    private boolean A;
    private int B = 0;
    private boolean C = true;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G = true;
    private f H;
    private boolean I;
    ag a;
    h b;
    d c;
    boolean d;
    final l e = new h(this);
    final l f = new l(this);
    final p g = new ai(this);
    private Context l;
    private Context m;
    private Activity n;
    private Dialog o;
    private ActionBarOverlayLayout p;
    private ActionBarContainer q;
    private bt r;
    private ActionBarContextView s;
    private View t;
    private fu u;
    private ArrayList<Object> v = new ArrayList();
    private int w = -1;
    private boolean x;
    private boolean y;
    private ArrayList<Object> z = new ArrayList();

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        k = z;
    }

    public ao(Activity activity, boolean z) {
        this.n = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.t = decorView.findViewById(16908290);
        }
    }

    public ao(Dialog dialog) {
        this.o = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        bt btVar;
        this.p = (ActionBarOverlayLayout) view.findViewById(j.decor_content_parent);
        if (this.p != null) {
            this.p.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(j.action_bar);
        if (findViewById instanceof bt) {
            btVar = (bt) findViewById;
        } else if (findViewById instanceof Toolbar) {
            btVar = ((Toolbar) findViewById).getWrapper();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.r = btVar;
        this.s = (ActionBarContextView) view.findViewById(j.action_context_bar);
        this.q = (ActionBarContainer) view.findViewById(j.action_bar_container);
        if (this.r == null || this.s == null || this.q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.l = this.r.b();
        if ((this.r.m() & 4) != 0) {
            this.x = true;
        }
        g a = g.a(this.l);
        int i = a.a.getApplicationInfo().targetSdkVersion;
        f(a.a());
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(null, android.support.v7.c.h.ActionBar, k.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(android.support.v7.c.h.ActionBar_hideOnContentScroll, false)) {
            if (this.p.a) {
                this.d = true;
                this.p.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.h.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ViewCompat.f(this.q, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void a(Configuration configuration) {
        f(g.a(this.l).a());
    }

    private void f(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.A = z;
        if (this.A) {
            this.q.setTabContainer(null);
            this.r.a(this.u);
        } else {
            this.r.a(null);
            this.q.setTabContainer(this.u);
        }
        if (this.r.n() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.u != null) {
            if (z2) {
                this.u.setVisibility(0);
                if (this.p != null) {
                    ViewCompat.u(this.p);
                }
            } else {
                this.u.setVisibility(8);
            }
        }
        bt btVar = this.r;
        if (this.A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        btVar.a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.p;
        if (this.A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void b(boolean z) {
        this.I = z;
        if (!z && this.H != null) {
            this.H.b();
        }
    }

    public final void c(boolean z) {
        if (z != this.y) {
            this.y = z;
            int size = this.z.size();
            for (int i = 0; i < size; i++) {
                this.z.get(i);
            }
        }
    }

    public final void a(CharSequence charSequence) {
        this.r.a(charSequence);
    }

    public final boolean f() {
        ViewGroup a = this.r.a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public final int a() {
        return this.r.m();
    }

    public final h a(d dVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.p.setHideOnContentScrollEnabled(false);
        this.s.a();
        h agVar = new ag(this, this.s.getContext(), dVar);
        if (!agVar.i()) {
            return null;
        }
        agVar.b();
        this.s.a(agVar);
        e(true);
        this.s.sendAccessibilityEvent(32);
        this.a = agVar;
        return agVar;
    }

    public final void d(boolean z) {
        this.C = z;
    }

    public final void h() {
        if (this.E) {
            this.E = false;
            g(true);
        }
    }

    public final void i() {
        if (!this.E) {
            this.E = true;
            g(true);
        }
    }

    private static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void g(boolean z) {
        float f;
        f fVar;
        bo c;
        if (a(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                if (this.H != null) {
                    this.H.b();
                }
                this.q.setVisibility(0);
                if (this.B == 0 && k && (this.I || z)) {
                    ViewCompat.b(this.q, 0.0f);
                    f = (float) (-this.q.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.q.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    ViewCompat.b(this.q, f);
                    fVar = new f();
                    c = ViewCompat.q(this.q).c(0.0f);
                    c.a(this.g);
                    fVar.a(c);
                    if (this.C && this.t != null) {
                        ViewCompat.b(this.t, f);
                        fVar.a(ViewCompat.q(this.t).c(0.0f));
                    }
                    fVar.a(j);
                    fVar.c();
                    fVar.a(this.f);
                    this.H = fVar;
                    fVar.a();
                } else {
                    ViewCompat.c(this.q, (float) IPictureView.DEFAULT_MIN_SCALE);
                    ViewCompat.b(this.q, 0.0f);
                    if (this.C && this.t != null) {
                        ViewCompat.b(this.t, 0.0f);
                    }
                    this.f.b(null);
                }
                if (this.p != null) {
                    ViewCompat.u(this.p);
                }
            }
        } else if (this.G) {
            this.G = false;
            if (this.H != null) {
                this.H.b();
            }
            if (this.B == 0 && k && (this.I || z)) {
                ViewCompat.c(this.q, (float) IPictureView.DEFAULT_MIN_SCALE);
                this.q.setTransitioning(true);
                fVar = new f();
                f = (float) (-this.q.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.q.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                c = ViewCompat.q(this.q).c(f);
                c.a(this.g);
                fVar.a(c);
                if (this.C && this.t != null) {
                    fVar.a(ViewCompat.q(this.t).c(f));
                }
                fVar.a(i);
                fVar.c();
                fVar.a(this.e);
                this.H = fVar;
                fVar.a();
                return;
            }
            this.e.b(null);
        }
    }

    public final void e(boolean z) {
        bo a;
        bo a2;
        long a3;
        if (z) {
            if (!this.F) {
                this.F = true;
                if (this.p != null) {
                    this.p.setShowingForActionMode(true);
                }
                g(false);
            }
        } else if (this.F) {
            this.F = false;
            if (this.p != null) {
                this.p.setShowingForActionMode(false);
            }
            g(false);
        }
        if (z) {
            a = this.r.a(4, 100);
            a2 = this.s.a(0, 200);
        } else {
            a2 = this.r.a(0, 200);
            a = this.s.a(8, 100);
        }
        f fVar = new f();
        fVar.a.add(a);
        View view = (View) a.a.get();
        if (view != null) {
            a3 = bo.b.a(view);
        } else {
            a3 = 0;
        }
        view = (View) a2.a.get();
        if (view != null) {
            bo.b.b(view, a3);
        }
        fVar.a.add(a2);
        fVar.a();
    }

    public final Context c() {
        if (this.m == null) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(k.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.m = new ContextThemeWrapper(this.l, i);
            } else {
                this.m = this.l;
            }
        }
        return this.m;
    }

    public final void j() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }

    public final boolean e() {
        if (this.r == null || !this.r.c()) {
            return false;
        }
        this.r.d();
        return true;
    }

    public final void a(boolean z) {
        if (!this.x) {
            int i;
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            int m = this.r.m();
            this.x = true;
            this.r.c((i & 4) | (m & -5));
        }
    }

    public final boolean b() {
        int height = this.q.getHeight();
        return this.G && (height == 0 || this.p.getActionBarHideOffset() < height);
    }
}
