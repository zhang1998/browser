package android.mini.support.v4.app;

import android.annotation.TargetApi;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class ag implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ View c;
    final /* synthetic */ ak d;
    final /* synthetic */ Map e;
    final /* synthetic */ Map f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Transition h;

    ag(View view, Transition transition, View view2, ak akVar, Map map, Map map2, ArrayList arrayList, Transition transition2) {
        this.a = view;
        this.b = transition;
        this.c = view2;
        this.d = akVar;
        this.e = map;
        this.f = map2;
        this.g = arrayList;
        this.h = transition2;
    }

    @TargetApi(21)
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            this.b.removeTarget(this.c);
        }
        if (this.d != null) {
            View a = this.d.a();
            if (a != null) {
                if (!this.e.isEmpty()) {
                    al.a(this.f, a);
                    this.f.keySet().retainAll(this.e.values());
                    for (Entry entry : this.e.entrySet()) {
                        View view = (View) this.f.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.b != null) {
                    al.a(this.g, a);
                    this.g.removeAll(this.f.values());
                    this.g.add(this.c);
                    al.b(this.b, this.g);
                }
            }
        }
        al.a(this.h, this.b, this.g, true);
        return true;
    }
}
