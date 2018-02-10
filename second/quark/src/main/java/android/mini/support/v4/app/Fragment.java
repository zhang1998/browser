package android.mini.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.mini.support.annotation.CallSuper;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.d;
import android.mini.support.v4.d.q;
import android.mini.support.v4.view.x;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* compiled from: ProGuard */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final q<String, Class<?>> a = new q();
    static final Object j = new Object();
    int A;
    ab B;
    t C;
    ab D;
    ac E;
    Fragment F;
    int G;
    int H;
    String I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O = true;
    boolean P;
    int Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    boolean V = true;
    ap W;
    boolean X;
    boolean Y;
    Object Z = null;
    Object aa = j;
    Object ab = null;
    Object ac = j;
    Object ad = null;
    Object ae = j;
    Boolean af;
    Boolean ag;
    ar ah = null;
    ar ai = null;
    int k = 0;
    View l;
    int m;
    Bundle n;
    SparseArray<Parcelable> o;
    int p = -1;
    String q;
    Bundle r;
    Fragment s;
    int t = -1;
    int u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    /* compiled from: ProGuard */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new n();
        final Bundle a;

        SavedState(Parcel parcel) {
            this.a = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }
    }

    public static Fragment a(Context context, String str) {
        return a(context, str, null);
    }

    public static Fragment a(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean b(Context context, String str) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void a(int i, Fragment fragment) {
        this.p = i;
        if (fragment != null) {
            this.q = fragment.q + ":" + this.p;
        } else {
            this.q = "android:fragment:" + this.p;
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        d.a(this, stringBuilder);
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.G));
        }
        if (this.I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final FragmentActivity e() {
        if (this.C == null) {
            return null;
        }
        return (FragmentActivity) this.C.b;
    }

    public final boolean f() {
        return this.C != null && this.v;
    }

    public static void g() {
    }

    public static void h() {
    }

    public static void i() {
    }

    public LayoutInflater b(Bundle bundle) {
        LayoutInflater c = this.C.c();
        if (this.D == null) {
            r();
            if (this.k >= 5) {
                this.D.j();
            } else if (this.k >= 4) {
                this.D.i();
            } else if (this.k >= 2) {
                this.D.h();
            } else if (this.k > 0) {
                this.D.g();
            }
        }
        x.a(c, this.D);
        return c;
    }

    @CallSuper
    public final void j() {
        Activity activity;
        this.P = true;
        if (this.C == null) {
            activity = null;
        } else {
            activity = this.C.b;
        }
        if (activity != null) {
            this.P = false;
            this.P = true;
        }
    }

    public static void k() {
    }

    @CallSuper
    public void a(Context context) {
        Activity activity;
        this.P = true;
        if (this.C == null) {
            activity = null;
        } else {
            activity = this.C.b;
        }
        if (activity != null) {
            this.P = false;
            this.P = true;
        }
    }

    public static Animation l() {
        return null;
    }

    @CallSuper
    public void a(@Nullable Bundle bundle) {
        boolean z = true;
        this.P = true;
        e(bundle);
        if (this.D != null) {
            if (this.D.n <= 0) {
                z = false;
            }
            if (!z) {
                this.D.g();
            }
        }
    }

    final void e(@Nullable Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.D == null) {
                    r();
                }
                this.D.a(parcelable, this.E);
                this.E = null;
                this.D.g();
            }
        }
    }

    public static void m() {
    }

    @CallSuper
    public void c(@Nullable Bundle bundle) {
        this.P = true;
    }

    @CallSuper
    public void b() {
        this.P = true;
        if (!this.X) {
            this.X = true;
            if (!this.Y) {
                this.Y = true;
                this.W = this.C.b(this.q);
            }
            if (this.W != null) {
                this.W.b();
            }
        }
    }

    public void d(Bundle bundle) {
    }

    @CallSuper
    public void onConfigurationChanged(Configuration configuration) {
        this.P = true;
    }

    @CallSuper
    public void c() {
        this.P = true;
    }

    @CallSuper
    public void onLowMemory() {
        this.P = true;
    }

    @CallSuper
    public void d() {
        this.P = true;
    }

    @CallSuper
    public void a() {
        this.P = true;
    }

    public static void n() {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        e().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    private void r() {
        this.D = new ab();
        this.D.a(this.C, new l(this), this);
    }

    final View o() {
        if (this.D != null) {
            this.D.t = false;
        }
        return null;
    }

    final void f(Bundle bundle) {
        d(bundle);
        if (this.D != null) {
            Parcelable f = this.D.f();
            if (f != null) {
                bundle.putParcelable("android:support:fragments", f);
            }
        }
    }

    final void p() {
        if (this.D != null) {
            this.D.b(2);
        }
        this.k = 2;
        if (this.X) {
            this.X = false;
            if (!this.Y) {
                this.Y = true;
                this.W = this.C.b(this.q);
            }
            if (this.W == null) {
                return;
            }
            if (this.C.h) {
                this.W.d();
            } else {
                this.W.c();
            }
        }
    }

    final void q() {
        if (this.D != null) {
            this.D.l();
        }
        this.k = 0;
        this.P = false;
        this.P = true;
        if (!this.Y) {
            this.Y = true;
            this.W = this.C.b(this.q);
        }
        if (this.W != null) {
            this.W.g();
        }
        if (this.P) {
            this.D = null;
            return;
        }
        throw new as("Fragment " + this + " did not call through to super.onDestroy()");
    }
}
