package android.mini.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.q;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

/* compiled from: ProGuard */
public abstract class t<E> extends r {
    final Activity b;
    final Context c;
    final Handler d;
    final int e;
    final ab f;
    q<String, an> g;
    boolean h;
    ap i;
    boolean j;
    boolean k;

    t(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.c);
    }

    private t(Activity activity, Context context, Handler handler) {
        this.f = new ab();
        this.b = activity;
        this.c = context;
        this.d = handler;
        this.e = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean b() {
        return true;
    }

    public LayoutInflater c() {
        return (LayoutInflater) this.c.getSystemService("layout_inflater");
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return this.e;
    }

    @Nullable
    public View a(int i) {
        return null;
    }

    public boolean a() {
        return true;
    }

    final void a(String str) {
        if (this.g != null) {
            ap apVar = (ap) this.g.get(str);
            if (apVar != null && !apVar.f) {
                apVar.g();
                this.g.remove(str);
            }
        }
    }

    void g() {
    }

    final ap b(String str) {
        if (this.g == null) {
            this.g = new q();
        }
        ap apVar = (ap) this.g.get(str);
        if (apVar != null) {
            apVar.g = this;
        }
        return apVar;
    }
}
