package android.support.v4.app;

import android.support.v4.d.b;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class bi implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ cb d;
    final /* synthetic */ boolean e;
    final /* synthetic */ Fragment f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ an h;

    bi(an anVar, View view, Object obj, ArrayList arrayList, cb cbVar, boolean z, Fragment fragment, Fragment fragment2) {
        this.h = anVar;
        this.a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = cbVar;
        this.e = z;
        this.f = fragment;
        this.g = fragment2;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            ab.a(this.b, this.c);
            this.c.clear();
            b a = an.a(this.h, this.d, this.e, this.f);
            ab.a(this.b, this.d.d, a, this.c);
            an.a(this.h, a, this.d);
            an.a(this.f, this.g, this.e, a);
        }
        return true;
    }
}
