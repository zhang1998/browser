package android.mini.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
final class b implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ e d;
    final /* synthetic */ Object e;
    final /* synthetic */ Object f;
    final /* synthetic */ boolean g;
    final /* synthetic */ Fragment h;
    final /* synthetic */ Fragment i;
    final /* synthetic */ f j;

    b(f fVar, View view, Object obj, ArrayList arrayList, e eVar, Object obj2, Object obj3, boolean z, Fragment fragment, Fragment fragment2) {
        this.j = fVar;
        this.a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = eVar;
        this.e = obj2;
        this.f = obj3;
        this.g = z;
        this.h = fragment;
        this.i = fragment2;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        al.a(this.b, this.c);
        this.c.remove(this.d.d);
        al.a(this.e, this.f, this.b, this.c, false);
        this.c.clear();
        android.mini.support.v4.d.b a = f.a(this.j, this.d, this.g, this.h);
        al.a(this.b, this.d.d, (Map) a, this.c);
        f.a(this.j, a, this.d);
        f.a(this.h, this.i, this.g, a);
        al.a(this.e, this.f, this.b, this.c, true);
        return true;
    }
}
