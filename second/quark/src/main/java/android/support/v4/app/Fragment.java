package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.d.f;
import android.support.v4.d.s;
import android.support.v4.view.dt;
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
    private static final s<String, Class<?>> a = new s();
    static final Object e = new Object();
    int A;
    int B;
    String C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I = true;
    boolean J;
    int K;
    ViewGroup L;
    View M;
    View N;
    boolean O;
    boolean P = true;
    cs Q;
    boolean R;
    boolean S;
    Object T = null;
    Object U = e;
    Object V = null;
    Object W = e;
    Object X = null;
    Object Y = e;
    Boolean Z;
    Boolean aa;
    bk ab = null;
    bk ac = null;
    int f = 0;
    View g;
    int h;
    Bundle i;
    SparseArray<Parcelable> j;
    int k = -1;
    String l;
    Bundle m;
    Fragment n;
    int o = -1;
    int p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    int v;
    ah w;
    bm x;
    ah y;
    public Fragment z;

    /* compiled from: ProGuard */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new bp();
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
                fragment.m = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new bv("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new bv("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new bv("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
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
        this.k = i;
        if (fragment != null) {
            this.l = fragment.l + ":" + this.k;
        } else {
            this.l = "android:fragment:" + this.k;
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
        f.a(this, stringBuilder);
        if (this.k >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.k);
        }
        if (this.A != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.A));
        }
        if (this.C != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.C);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final FragmentActivity e() {
        if (this.x == null) {
            return null;
        }
        return (FragmentActivity) this.x.a;
    }

    public final boolean f() {
        return this.x != null && this.q;
    }

    public static void g() {
    }

    public static void h() {
    }

    public static void i() {
    }

    public final LayoutInflater j() {
        LayoutInflater c = this.x.c();
        if (this.y == null) {
            o();
            if (this.f >= 5) {
                this.y.k();
            } else if (this.f >= 4) {
                this.y.j();
            } else if (this.f >= 2) {
                this.y.i();
            } else if (this.f > 0) {
                this.y.h();
            }
        }
        dt.a(c, this.y);
        return c;
    }

    public final void k() {
        Activity activity;
        this.J = true;
        if (this.x == null) {
            activity = null;
        } else {
            activity = this.x.a;
        }
        if (activity != null) {
            this.J = false;
            this.J = true;
        }
    }

    public void a(Context context) {
        Activity activity;
        this.J = true;
        if (this.x == null) {
            activity = null;
        } else {
            activity = this.x.a;
        }
        if (activity != null) {
            this.J = false;
            this.J = true;
        }
    }

    public static Animation l() {
        return null;
    }

    public static void m() {
    }

    public void b() {
        this.J = true;
        if (!this.R) {
            this.R = true;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.a(this.l);
            }
            if (this.Q != null) {
                this.Q.b();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.J = true;
    }

    public void c() {
        this.J = true;
    }

    public void onLowMemory() {
        this.J = true;
    }

    public void d() {
        this.J = true;
        if (!this.S) {
            this.S = true;
            this.Q = this.x.a(this.l);
        }
        if (this.Q != null) {
            this.Q.g();
        }
    }

    public void a() {
        this.J = true;
    }

    public static void n() {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        e().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    final void o() {
        this.y = new ah();
        this.y.a(this.x, new bg(this), this);
    }

    final View p() {
        if (this.y != null) {
            this.y.t = false;
        }
        return null;
    }
}
