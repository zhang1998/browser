package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.view.h;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: ProGuard */
final class d implements android.support.v7.view.d {
    final /* synthetic */ AppCompatDelegateImplV7 a;
    private android.support.v7.view.d b;

    public d(AppCompatDelegateImplV7 appCompatDelegateImplV7, android.support.v7.view.d dVar) {
        this.a = appCompatDelegateImplV7;
        this.b = dVar;
    }

    public final boolean a(h hVar, Menu menu) {
        return this.b.a(hVar, menu);
    }

    public final boolean b(h hVar, Menu menu) {
        return this.b.b(hVar, menu);
    }

    public final boolean a(h hVar, MenuItem menuItem) {
        return this.b.a(hVar, menuItem);
    }

    public final void a(h hVar) {
        this.b.a(hVar);
        if (this.a.c != null) {
            this.a.j.getDecorView().removeCallbacks(this.a.d);
        }
        if (this.a.b != null) {
            this.a.g();
            this.a.e = ViewCompat.q(this.a.b).a(0.0f);
            this.a.e.a(new y(this));
        }
        this.a.a = null;
    }
}
