package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ax;
import android.support.v4.os.d;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v4.view.bo;
import android.support.v4.view.dt;
import android.support.v4.view.eh;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.c.l;
import android.support.v7.view.h;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.bx;
import android.support.v7.widget.co;
import android.support.v7.widget.ds;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* compiled from: ProGuard */
class AppCompatDelegateImplV7 extends w implements a, z {
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private PanelFeatureState[] E;
    private PanelFeatureState F;
    private boolean G;
    private boolean H;
    private int I;
    private final Runnable J = new aq(this);
    private boolean K;
    private Rect L;
    private Rect M;
    private t N;
    h a;
    ActionBarContextView b;
    PopupWindow c;
    Runnable d;
    bo e = null;
    ViewGroup f;
    private ds g;
    private j w;
    private n x;
    private boolean y;
    private TextView z;

    /* compiled from: ProGuard */
    final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        u j;
        b k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        /* compiled from: ProGuard */
        class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = d.a(new ak());
            int a;
            boolean b;
            Bundle c;

            private SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }

            static /* synthetic */ SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.b = z;
                if (savedState.b) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }

        PanelFeatureState(int i) {
            this.a = i;
        }

        final void a(u uVar) {
            if (uVar != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = uVar;
                if (uVar != null && this.k != null) {
                    uVar.a(this.k);
                }
            }
        }
    }

    static /* synthetic */ void a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState f = appCompatDelegateImplV7.f(i);
        if (f.j != null) {
            Bundle bundle = new Bundle();
            f.j.a(bundle);
            if (bundle.size() > 0) {
                f.s = bundle;
            }
            f.j.e();
            f.j.clear();
        }
        f.r = true;
        f.q = true;
        if ((i == 108 || i == 0) && appCompatDelegateImplV7.g != null) {
            f = appCompatDelegateImplV7.f(0);
            if (f != null) {
                f.m = false;
                appCompatDelegateImplV7.b(f, null);
            }
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, ac acVar) {
        super(context, window, acVar);
    }

    public void a(Bundle bundle) {
        if ((this.k instanceof Activity) && ax.b((Activity) this.k) != null) {
            ActionBar actionBar = this.n;
            if (actionBar == null) {
                this.K = true;
            } else {
                actionBar.a(true);
            }
        }
    }

    public final void a() {
        n();
    }

    public final void b() {
        n();
        if (this.p && this.n == null) {
            if (this.k instanceof Activity) {
                this.n = new ao((Activity) this.k, this.q);
            } else if (this.k instanceof Dialog) {
                this.n = new ao((Dialog) this.k);
            }
            if (this.n != null) {
                this.n.a(this.K);
            }
        }
    }

    @Nullable
    public final View a(@IdRes int i) {
        n();
        return this.j.findViewById(i);
    }

    public final void a(Configuration configuration) {
        if (this.p && this.y) {
            ActionBar j = j();
            if (j != null) {
                j.a(configuration);
            }
        }
        i();
    }

    public final void c() {
        ActionBar j = j();
        if (j != null) {
            j.b(false);
        }
    }

    public final void d() {
        ActionBar j = j();
        if (j != null) {
            j.b(true);
        }
    }

    public final void a(View view) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.f.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.k.onContentChanged();
    }

    public final void b(int i) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.f.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.i).inflate(i, viewGroup);
        this.k.onContentChanged();
    }

    public final void a(View view, LayoutParams layoutParams) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.f.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.k.onContentChanged();
    }

    public final void b(View view, LayoutParams layoutParams) {
        n();
        ((ViewGroup) this.f.findViewById(16908290)).addView(view, layoutParams);
        this.k.onContentChanged();
    }

    public final void e() {
        super.e();
        if (this.n != null) {
            this.n.g();
        }
    }

    private void n() {
        if (!this.y) {
            TypedArray obtainStyledAttributes = this.i.obtainStyledAttributes(android.support.v7.c.h.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(android.support.v7.c.h.AppCompatTheme_windowActionBar)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(android.support.v7.c.h.AppCompatTheme_windowNoTitle, false)) {
                    c(1);
                } else if (obtainStyledAttributes.getBoolean(android.support.v7.c.h.AppCompatTheme_windowActionBar, false)) {
                    c(108);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.c.h.AppCompatTheme_windowActionBarOverlay, false)) {
                    c(109);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.c.h.AppCompatTheme_windowActionModeOverlay, false)) {
                    c(10);
                }
                this.s = obtainStyledAttributes.getBoolean(android.support.v7.c.h.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                this.j.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.i);
                if (this.t) {
                    if (this.r) {
                        view = (ViewGroup) from.inflate(l.abc_screen_simple_overlay_action_mode, null);
                    } else {
                        view = (ViewGroup) from.inflate(l.abc_screen_simple, null);
                    }
                    if (VERSION.SDK_INT >= 21) {
                        ViewCompat.a(view, new p(this));
                        view2 = view;
                    } else {
                        ((bx) view).setOnFitSystemWindowsListener(new ah(this));
                        view2 = view;
                    }
                } else if (this.s) {
                    r0 = (ViewGroup) from.inflate(l.abc_dialog_title_material, null);
                    this.q = false;
                    this.p = false;
                    view2 = r0;
                } else if (this.p) {
                    Context aVar;
                    TypedValue typedValue = new TypedValue();
                    this.i.getTheme().resolveAttribute(k.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        aVar = new android.support.v7.view.a(this.i, typedValue.resourceId);
                    } else {
                        aVar = this.i;
                    }
                    r0 = (ViewGroup) LayoutInflater.from(aVar).inflate(l.abc_screen_toolbar, null);
                    this.g = (ds) r0.findViewById(j.decor_content_parent);
                    this.g.setWindowCallback(this.j.getCallback());
                    if (this.q) {
                        this.g.a(109);
                    }
                    if (this.B) {
                        this.g.a(2);
                    }
                    if (this.C) {
                        this.g.a(5);
                    }
                    view2 = r0;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.p + ", windowActionBarOverlay: " + this.q + ", android:windowIsFloating: " + this.s + ", windowActionModeOverlay: " + this.r + ", windowNoTitle: " + this.t + " }");
                }
                CharSequence title;
                if (this.g == null) {
                    this.z = (TextView) view2.findViewById(j.title);
                }
                co.b(view2);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(j.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.j.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.j.setContentView(view2);
                contentFrameLayout.setAttachListener(new a(this));
                this.f = view2;
                if (this.k instanceof Activity) {
                    title = ((Activity) this.k).getTitle();
                } else {
                    title = this.u;
                }
                if (!TextUtils.isEmpty(title)) {
                    a(title);
                }
                contentFrameLayout = (ContentFrameLayout) this.f.findViewById(16908290);
                view = this.j.getDecorView();
                contentFrameLayout.b.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (ViewCompat.D(contentFrameLayout)) {
                    contentFrameLayout.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.i.obtainStyledAttributes(android.support.v7.c.h.AppCompatTheme);
                obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
                obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
                if (obtainStyledAttributes2.hasValue(android.support.v7.c.h.AppCompatTheme_windowFixedWidthMajor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.c.h.AppCompatTheme_windowFixedWidthMinor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.c.h.AppCompatTheme_windowFixedHeightMajor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.c.h.AppCompatTheme_windowFixedHeightMinor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.c.h.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout.requestLayout();
                this.y = true;
                PanelFeatureState f = f(0);
                if (!this.v) {
                    if (f == null || f.j == null) {
                        g(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean c(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.t && i == 108) {
            return false;
        }
        if (this.p && i == 1) {
            this.p = false;
        }
        switch (i) {
            case 1:
                o();
                this.t = true;
                return true;
            case 2:
                o();
                this.B = true;
                return true;
            case 5:
                o();
                this.C = true;
                return true;
            case 10:
                o();
                this.r = true;
                return true;
            case 108:
                o();
                this.p = true;
                return true;
            case 109:
                o();
                this.q = true;
                return true;
            default:
                return this.j.requestFeature(i);
        }
    }

    final void a(CharSequence charSequence) {
        if (this.g != null) {
            this.g.setWindowTitle(charSequence);
        } else if (this.n != null) {
            this.n.a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    final void d(int i) {
        if (i == 108) {
            ActionBar j = j();
            if (j != null) {
                j.c(false);
            }
        } else if (i == 0) {
            PanelFeatureState f = f(i);
            if (f.o) {
                a(f, false);
            }
        }
    }

    final boolean e(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar j = j();
        if (j == null) {
            return true;
        }
        j.c(true);
        return true;
    }

    public final void a(u uVar) {
        if (this.g == null || !this.g.a() || (eh.b(ViewConfiguration.get(this.i)) && !this.g.c())) {
            PanelFeatureState f = f(0);
            f.q = true;
            a(f, false);
            a(f, null);
            return;
        }
        Callback callback = this.j.getCallback();
        if (this.g.b()) {
            this.g.e();
            if (!this.v) {
                callback.onPanelClosed(108, f(0).j);
            }
        } else if (callback != null && !this.v) {
            if (this.H && (this.I & 1) != 0) {
                this.j.getDecorView().removeCallbacks(this.J);
                this.J.run();
            }
            PanelFeatureState f2 = f(0);
            if (f2.j != null && !f2.r && callback.onPreparePanel(0, f2.i, f2.j)) {
                callback.onMenuOpened(108, f2.j);
                this.g.d();
            }
        }
    }

    public final void f() {
        ActionBar j = j();
        if (j == null || !j.d()) {
            g(0);
        }
    }

    final void g() {
        if (this.e != null) {
            this.e.a();
        }
    }

    final boolean a(int i, KeyEvent keyEvent) {
        ActionBar j = j();
        if (j != null && j.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent)) {
            if (this.F == null) {
                PanelFeatureState f = f(0);
                b(f, keyEvent);
                boolean a = a(f, keyEvent.getKeyCode(), keyEvent);
                f.m = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.F == null) {
            return true;
        } else {
            this.F.n = true;
            return true;
        }
    }

    final boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.k.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.G = (keyEvent.getFlags() & 128) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState f = f(0);
                    if (f.o) {
                        return true;
                    }
                    b(f, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                a(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState f2;
        switch (keyCode) {
            case 4:
                z = this.G;
                this.G = false;
                f2 = f(0);
                if (f2 == null || !f2.o) {
                    if (this.a != null) {
                        this.a.c();
                        z = true;
                    } else {
                        ActionBar j = j();
                        if (j == null || !j.e()) {
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(f2, true);
                    return true;
                }
                break;
            case 82:
                if (this.a != null) {
                    return true;
                }
                f2 = f(0);
                if (this.g == null || !this.g.a() || eh.b(ViewConfiguration.get(this.i))) {
                    if (f2.o || f2.n) {
                        z = f2.o;
                        a(f2, true);
                    } else {
                        if (f2.m) {
                            if (f2.r) {
                                f2.m = false;
                                z = b(f2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(f2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.g.b()) {
                    z = this.g.e();
                } else {
                    if (!this.v && b(f2, keyEvent)) {
                        z = this.g.d();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.i.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
        }
        return false;
    }

    public final void h() {
        LayoutInflater from = LayoutInflater.from(this.i);
        if (from.getFactory() == null) {
            dt.a(from, this);
        } else {
            dt.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
        r7 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7.a(r9, r10, r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0059;
    L_0x000f:
        r2 = r3;
    L_0x0010:
        r0 = r7.N;
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new android.support.v7.app.t;
        r0.<init>();
        r7.N = r0;
    L_0x001b:
        if (r2 == 0) goto L_0x007c;
    L_0x001d:
        r0 = r8;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x005b;
    L_0x0022:
        r0 = r4;
    L_0x0023:
        if (r0 == 0) goto L_0x007c;
    L_0x0025:
        r0 = r3;
    L_0x0026:
        r5 = r7.N;
        r1 = android.support.v7.widget.ga.a();
        if (r0 == 0) goto L_0x0168;
    L_0x002e:
        if (r8 == 0) goto L_0x0168;
    L_0x0030:
        r0 = r8.getContext();
    L_0x0034:
        r0 = android.support.v7.app.t.a(r0, r11, r2);
        if (r1 == 0) goto L_0x003e;
    L_0x003a:
        r0 = android.support.v7.widget.fw.a(r0);
    L_0x003e:
        r1 = 0;
        r2 = -1;
        r6 = r9.hashCode();
        switch(r6) {
            case -1946472170: goto L_0x00f2;
            case -1455429095: goto L_0x00ce;
            case -1346021293: goto L_0x00e6;
            case -938935918: goto L_0x007e;
            case -937446323: goto L_0x00af;
            case -658531749: goto L_0x00fe;
            case -339785223: goto L_0x00a5;
            case 776382189: goto L_0x00c3;
            case 1125864064: goto L_0x0087;
            case 1413872058: goto L_0x00da;
            case 1601505219: goto L_0x00b9;
            case 1666676343: goto L_0x009b;
            case 2001146706: goto L_0x0091;
            default: goto L_0x0047;
        };
    L_0x0047:
        r4 = r2;
    L_0x0048:
        switch(r4) {
            case 0: goto L_0x010a;
            case 1: goto L_0x0111;
            case 2: goto L_0x0118;
            case 3: goto L_0x011f;
            case 4: goto L_0x0126;
            case 5: goto L_0x012d;
            case 6: goto L_0x0134;
            case 7: goto L_0x013b;
            case 8: goto L_0x0142;
            case 9: goto L_0x0149;
            case 10: goto L_0x0150;
            case 11: goto L_0x0157;
            case 12: goto L_0x015e;
            default: goto L_0x004b;
        };
    L_0x004b:
        if (r1 != 0) goto L_0x0165;
    L_0x004d:
        if (r10 == r0) goto L_0x0165;
    L_0x004f:
        r0 = r5.a(r0, r9, r11);
    L_0x0053:
        if (r0 == 0) goto L_0x0008;
    L_0x0055:
        android.support.v7.app.t.a(r0, r11);
        goto L_0x0008;
    L_0x0059:
        r2 = r4;
        goto L_0x0010;
    L_0x005b:
        r1 = r7.j;
        r5 = r1.getDecorView();
        r1 = r0;
    L_0x0062:
        if (r1 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r3;
        goto L_0x0023;
    L_0x0066:
        if (r1 == r5) goto L_0x0075;
    L_0x0068:
        r0 = r1 instanceof android.view.View;
        if (r0 == 0) goto L_0x0075;
    L_0x006c:
        r0 = r1;
        r0 = (android.view.View) r0;
        r0 = android.support.v4.view.ViewCompat.E(r0);
        if (r0 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r4;
        goto L_0x0023;
    L_0x0077:
        r1 = r1.getParent();
        goto L_0x0062;
    L_0x007c:
        r0 = r4;
        goto L_0x0026;
    L_0x007e:
        r3 = "TextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0086:
        goto L_0x0048;
    L_0x0087:
        r4 = "ImageView";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x0047;
    L_0x008f:
        r4 = r3;
        goto L_0x0048;
    L_0x0091:
        r3 = "Button";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0099:
        r4 = 2;
        goto L_0x0048;
    L_0x009b:
        r3 = "EditText";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00a3:
        r4 = 3;
        goto L_0x0048;
    L_0x00a5:
        r3 = "Spinner";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00ad:
        r4 = 4;
        goto L_0x0048;
    L_0x00af:
        r3 = "ImageButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00b7:
        r4 = 5;
        goto L_0x0048;
    L_0x00b9:
        r3 = "CheckBox";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00c1:
        r4 = 6;
        goto L_0x0048;
    L_0x00c3:
        r3 = "RadioButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00cb:
        r4 = 7;
        goto L_0x0048;
    L_0x00ce:
        r3 = "CheckedTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00d6:
        r4 = 8;
        goto L_0x0048;
    L_0x00da:
        r3 = "AutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00e2:
        r4 = 9;
        goto L_0x0048;
    L_0x00e6:
        r3 = "MultiAutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00ee:
        r4 = 10;
        goto L_0x0048;
    L_0x00f2:
        r3 = "RatingBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00fa:
        r4 = 11;
        goto L_0x0048;
    L_0x00fe:
        r3 = "SeekBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0106:
        r4 = 12;
        goto L_0x0048;
    L_0x010a:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0111:
        r1 = new android.support.v7.widget.AppCompatImageView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0118:
        r1 = new android.support.v7.widget.AppCompatButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x011f:
        r1 = new android.support.v7.widget.AppCompatEditText;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0126:
        r1 = new android.support.v7.widget.AppCompatSpinner;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x012d:
        r1 = new android.support.v7.widget.AppCompatImageButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0134:
        r1 = new android.support.v7.widget.AppCompatCheckBox;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x013b:
        r1 = new android.support.v7.widget.AppCompatRadioButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0142:
        r1 = new android.support.v7.widget.AppCompatCheckedTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0149:
        r1 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0150:
        r1 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0157:
        r1 = new android.support.v7.widget.AppCompatRatingBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x015e:
        r1 = new android.support.v7.widget.AppCompatSeekBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0165:
        r0 = r1;
        goto L_0x0053;
    L_0x0168:
        r0 = r10;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.k instanceof Factory) {
            View onCreateView = ((Factory) this.k).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.o;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.v;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.a;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.i;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.j;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.a;
        r5 = r11.j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.i;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x0059:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x005f:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.q;
        if (r0 == 0) goto L_0x01e3;
    L_0x0067:
        r0 = r11.g;
        if (r0 != 0) goto L_0x0152;
    L_0x006b:
        r0 = r10.m();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.c.k.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0091;
    L_0x008c:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0091:
        r5 = android.support.v7.c.k.panelMenuListTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014b;
    L_0x009a:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x009f:
        r1 = new android.support.v7.view.a;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.l = r1;
        r0 = android.support.v7.c.h.AppCompatTheme;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.c.h.AppCompatTheme_panelBackground;
        r1 = r0.getResourceId(r1, r3);
        r11.b = r1;
        r1 = android.support.v7.c.h.AppCompatTheme_android_windowAnimationStyle;
        r1 = r0.getResourceId(r1, r3);
        r11.f = r1;
        r0.recycle();
        r0 = new android.support.v7.app.r;
        r1 = r11.l;
        r0.<init>(r10, r1);
        r11.g = r0;
        r0 = 81;
        r11.c = r0;
        r0 = r11.g;
        if (r0 == 0) goto L_0x000c;
    L_0x00d7:
        r0 = r11.i;
        if (r0 == 0) goto L_0x0165;
    L_0x00db:
        r0 = r11.i;
        r11.h = r0;
        r0 = r9;
    L_0x00e0:
        if (r0 == 0) goto L_0x000c;
    L_0x00e2:
        r0 = r11.h;
        if (r0 == 0) goto L_0x01e0;
    L_0x00e6:
        r0 = r11.i;
        if (r0 == 0) goto L_0x01d1;
    L_0x00ea:
        r0 = r9;
    L_0x00eb:
        if (r0 == 0) goto L_0x000c;
    L_0x00ed:
        r0 = r11.h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01f6;
    L_0x00f5:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fb:
        r0 = r11.b;
        r4 = r11.g;
        r4.setBackgroundResource(r0);
        r0 = r11.h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0115;
    L_0x010a:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0115;
    L_0x010e:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.h;
        r0.removeView(r4);
    L_0x0115:
        r0 = r11.g;
        r4 = r11.h;
        r0.addView(r4, r1);
        r0 = r11.h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x0129;
    L_0x0124:
        r0 = r11.h;
        r0.requestFocus();
    L_0x0129:
        r1 = r2;
    L_0x012a:
        r11.n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.d;
        r4 = r11.e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.c;
        r0.gravity = r1;
        r1 = r11.f;
        r0.windowAnimations = r1;
        r1 = r11.g;
        r8.addView(r1, r0);
        r11.o = r9;
        goto L_0x000c;
    L_0x014b:
        r1 = android.support.v7.c.b.Theme_AppCompat_CompactMenu;
        r4.applyStyle(r1, r9);
        goto L_0x009f;
    L_0x0152:
        r0 = r11.q;
        if (r0 == 0) goto L_0x00d7;
    L_0x0156:
        r0 = r11.g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d7;
    L_0x015e:
        r0 = r11.g;
        r0.removeAllViews();
        goto L_0x00d7;
    L_0x0165:
        r0 = r11.j;
        if (r0 == 0) goto L_0x01ce;
    L_0x0169:
        r0 = r10.x;
        if (r0 != 0) goto L_0x0174;
    L_0x016d:
        r0 = new android.support.v7.app.n;
        r0.<init>(r10);
        r10.x = r0;
    L_0x0174:
        r0 = r10.x;
        r1 = r11.j;
        if (r1 != 0) goto L_0x0186;
    L_0x017a:
        r0 = 0;
    L_0x017b:
        r0 = (android.view.View) r0;
        r11.h = r0;
        r0 = r11.h;
        if (r0 == 0) goto L_0x01ce;
    L_0x0183:
        r0 = r9;
        goto L_0x00e0;
    L_0x0186:
        r1 = r11.k;
        if (r1 != 0) goto L_0x01a0;
    L_0x018a:
        r1 = new android.support.v7.view.menu.b;
        r4 = r11.l;
        r5 = android.support.v7.c.l.abc_list_menu_item_layout;
        r1.<init>(r4, r5);
        r11.k = r1;
        r1 = r11.k;
        r1.g = r0;
        r0 = r11.j;
        r1 = r11.k;
        r0.a(r1);
    L_0x01a0:
        r1 = r11.k;
        r0 = r11.g;
        r4 = r1.d;
        if (r4 != 0) goto L_0x01cb;
    L_0x01a8:
        r4 = r1.b;
        r5 = android.support.v7.c.l.abc_expanded_menu_layout;
        r0 = r4.inflate(r5, r0, r3);
        r0 = (android.support.v7.view.menu.ExpandedMenuView) r0;
        r1.d = r0;
        r0 = r1.h;
        if (r0 != 0) goto L_0x01bf;
    L_0x01b8:
        r0 = new android.support.v7.view.menu.x;
        r0.<init>(r1);
        r1.h = r0;
    L_0x01bf:
        r0 = r1.d;
        r4 = r1.h;
        r0.setAdapter(r4);
        r0 = r1.d;
        r0.setOnItemClickListener(r1);
    L_0x01cb:
        r0 = r1.d;
        goto L_0x017b;
    L_0x01ce:
        r0 = r3;
        goto L_0x00e0;
    L_0x01d1:
        r0 = r11.k;
        r0 = r0.a();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01e0;
    L_0x01dd:
        r0 = r9;
        goto L_0x00eb;
    L_0x01e0:
        r0 = r3;
        goto L_0x00eb;
    L_0x01e3:
        r0 = r11.i;
        if (r0 == 0) goto L_0x01f3;
    L_0x01e7:
        r0 = r11.i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01f3;
    L_0x01ef:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012a;
    L_0x01f3:
        r1 = r2;
        goto L_0x012a;
    L_0x01f6:
        r1 = r0;
        goto L_0x00fb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.v) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        if (!(this.F == null || this.F == panelFeatureState)) {
            a(this.F, false);
        }
        Callback callback = this.j.getCallback();
        if (callback != null) {
            panelFeatureState.i = callback.onCreatePanelView(panelFeatureState.a);
        }
        boolean z = panelFeatureState.a == 0 || panelFeatureState.a == 108;
        if (z && this.g != null) {
            this.g.f();
        }
        if (panelFeatureState.i == null && !(z && (this.n instanceof an))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null) {
                    Context aVar;
                    u uVar;
                    Context context = this.i;
                    if ((panelFeatureState.a == 0 || panelFeatureState.a == 108) && this.g != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(k.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(k.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(k.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            aVar = new android.support.v7.view.a(context, 0);
                            aVar.getTheme().setTo(theme2);
                            uVar = new u(aVar);
                            uVar.a((z) this);
                            panelFeatureState.a(uVar);
                            if (panelFeatureState.j == null) {
                                return false;
                            }
                        }
                    }
                    aVar = context;
                    uVar = new u(aVar);
                    uVar.a((z) this);
                    panelFeatureState.a(uVar);
                    if (panelFeatureState.j == null) {
                        return false;
                    }
                }
                if (z && this.g != null) {
                    if (this.w == null) {
                        this.w = new j();
                    }
                    this.g.a(panelFeatureState.j, this.w);
                }
                panelFeatureState.j.e();
                if (callback.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.r = false;
                } else {
                    panelFeatureState.a(null);
                    if (!z || this.g == null) {
                        return false;
                    }
                    this.g.a(null, this.w);
                    return false;
                }
            }
            panelFeatureState.j.e();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.b(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.p = z2;
                panelFeatureState.j.setQwertyMode(panelFeatureState.p);
                panelFeatureState.j.f();
            } else {
                if (z && this.g != null) {
                    this.g.a(null, this.w);
                }
                panelFeatureState.j.f();
                return false;
            }
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.F = panelFeatureState;
        return true;
    }

    private void b(u uVar) {
        if (!this.D) {
            this.D = true;
            this.g.g();
            Callback callback = this.j.getCallback();
            if (!(callback == null || this.v)) {
                callback.onPanelClosed(108, uVar);
            }
            this.D = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.a == 0 && this.g != null && this.g.b()) {
            b(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.o || panelFeatureState.g == null)) {
            windowManager.removeView(panelFeatureState.g);
            if (z) {
                a(panelFeatureState.a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.F == panelFeatureState) {
            this.F = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.E.length) {
                panelFeatureState = this.E[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.v) {
            this.k.onPanelClosed(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.E;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState f(int i) {
        Object obj = this.E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.E = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            return panelFeatureState.j.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void g(int i) {
        this.I |= 1 << i;
        if (!this.H) {
            ViewCompat.a(this.j.getDecorView(), this.J);
            this.H = true;
        }
    }

    private void o() {
        if (this.y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final boolean a(u uVar, MenuItem menuItem) {
        Callback callback = this.j.getCallback();
        if (!(callback == null || this.v)) {
            PanelFeatureState a = a(uVar.c());
            if (a != null) {
                return callback.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    static /* synthetic */ int b(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.b == null || !(appCompatDelegateImplV7.b.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.b.getLayoutParams();
            if (appCompatDelegateImplV7.b.isShown()) {
                if (appCompatDelegateImplV7.L == null) {
                    appCompatDelegateImplV7.L = new Rect();
                    appCompatDelegateImplV7.M = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.L;
                Rect rect2 = appCompatDelegateImplV7.M;
                rect.set(0, i, 0, 0);
                co.a(appCompatDelegateImplV7.f, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.A == null) {
                        appCompatDelegateImplV7.A = new View(appCompatDelegateImplV7.i);
                        appCompatDelegateImplV7.A.setBackgroundColor(appCompatDelegateImplV7.i.getResources().getColor(android.support.v7.c.a.abc_input_method_navigation_guard));
                        appCompatDelegateImplV7.f.addView(appCompatDelegateImplV7.A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.A == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.r || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.b.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.A != null) {
            View view = appCompatDelegateImplV7.A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    static /* synthetic */ void d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        if (appCompatDelegateImplV7.g != null) {
            appCompatDelegateImplV7.g.g();
        }
        if (appCompatDelegateImplV7.c != null) {
            appCompatDelegateImplV7.j.getDecorView().removeCallbacks(appCompatDelegateImplV7.d);
            if (appCompatDelegateImplV7.c.isShowing()) {
                try {
                    appCompatDelegateImplV7.c.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            appCompatDelegateImplV7.c = null;
        }
        appCompatDelegateImplV7.g();
        PanelFeatureState f = appCompatDelegateImplV7.f(0);
        if (f != null && f.j != null) {
            f.j.close();
        }
    }
}
