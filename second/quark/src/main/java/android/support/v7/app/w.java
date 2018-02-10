package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.i;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: ProGuard */
abstract class w extends AppCompatDelegate {
    final Context i;
    final Window j;
    final Callback k = this.j.getCallback();
    final Callback l;
    final ac m;
    ActionBar n;
    MenuInflater o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    CharSequence u;
    boolean v;

    abstract void a(CharSequence charSequence);

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    abstract void b();

    abstract void d(int i);

    abstract boolean e(int i);

    w(Context context, Window window, ac acVar) {
        this.i = context;
        this.j = window;
        this.m = acVar;
        if (this.k instanceof m) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.l = a(this.k);
        this.j.setCallback(this.l);
    }

    Callback a(Callback callback) {
        return new m(this, callback);
    }

    public final ActionBar j() {
        b();
        return this.n;
    }

    public final MenuInflater k() {
        if (this.o == null) {
            b();
            this.o = new i(this.n != null ? this.n.c() : this.i);
        }
        return this.o;
    }

    final Context m() {
        Context context = null;
        ActionBar j = j();
        if (j != null) {
            context = j.c();
        }
        if (context == null) {
            return this.i;
        }
        return context;
    }

    public void e() {
        this.v = true;
    }

    public boolean i() {
        return false;
    }

    public final void b(CharSequence charSequence) {
        this.u = charSequence;
        a(charSequence);
    }

    public void b(Bundle bundle) {
    }
}
