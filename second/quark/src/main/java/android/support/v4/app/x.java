package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class x implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ View c;
    final /* synthetic */ w d;
    final /* synthetic */ Map e;
    final /* synthetic */ Map f;
    final /* synthetic */ ArrayList g;

    x(View view, Transition transition, View view2, w wVar, Map map, Map map2, ArrayList arrayList) {
        this.a = view;
        this.b = transition;
        this.c = view2;
        this.d = wVar;
        this.e = map;
        this.f = map2;
        this.g = arrayList;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            this.b.removeTarget(this.c);
        }
        View a = this.d.a();
        if (a != null) {
            if (!this.e.isEmpty()) {
                ab.a(this.f, a);
                this.f.keySet().retainAll(this.e.values());
                for (Entry entry : this.e.entrySet()) {
                    View view = (View) this.f.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.b != null) {
                ab.a(this.g, a);
                this.g.removeAll(this.f.values());
                this.g.add(this.c);
                ab.b(this.b, this.g);
            }
        }
        return true;
    }
}
