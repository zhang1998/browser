package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class ad implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ Transition d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ Transition f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Map h;
    final /* synthetic */ ArrayList i;
    final /* synthetic */ Transition j;
    final /* synthetic */ View k;

    ad(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.a = view;
        this.b = transition;
        this.c = arrayList;
        this.d = transition2;
        this.e = arrayList2;
        this.f = transition3;
        this.g = arrayList3;
        this.h = map;
        this.i = arrayList4;
        this.j = transition4;
        this.k = view2;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            ab.a(this.b, this.c);
        }
        if (this.d != null) {
            ab.a(this.d, this.e);
        }
        if (this.f != null) {
            ab.a(this.f, this.g);
        }
        for (Entry entry : this.h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            this.j.excludeTarget((View) this.i.get(i), false);
        }
        this.j.excludeTarget(this.k, false);
        return true;
    }
}
