package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.b;
import android.support.v4.view.g;
import android.view.View;

/* compiled from: ProGuard */
final class p implements b {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    p(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final g a(View view, g gVar) {
        int b = gVar.b();
        int b2 = AppCompatDelegateImplV7.b(this.a, b);
        if (b != b2) {
            gVar = gVar.a(gVar.a(), b2, gVar.c(), gVar.d());
        }
        return ViewCompat.a(view, gVar);
    }
}
