package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.d.s;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

/* compiled from: ProGuard */
public abstract class bm<E> extends cp {
    final Activity a;
    final Context b;
    final Handler c;
    final int d;
    public final ah e;
    s<String, cr> f;
    boolean g;
    cs h;
    boolean i;
    boolean j;

    bm(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.a);
    }

    private bm(Activity activity, Context context, Handler handler) {
        this.e = new ah();
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean b() {
        return true;
    }

    public LayoutInflater c() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return this.d;
    }

    @Nullable
    public View a(int i) {
        return null;
    }

    public boolean a() {
        return true;
    }

    void g() {
    }

    final cs a(String str) {
        if (this.f == null) {
            this.f = new s();
        }
        cs csVar = (cs) this.f.get(str);
        if (csVar != null) {
            csVar.g = this;
        }
        return csVar;
    }
}
