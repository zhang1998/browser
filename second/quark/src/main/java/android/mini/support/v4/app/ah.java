package android.mini.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: ProGuard */
final class ah extends EpicenterCallback {
    final /* synthetic */ aj a;
    private Rect b;

    ah(aj ajVar) {
        this.a = ajVar;
    }

    public final Rect onGetEpicenter(Transition transition) {
        if (this.b == null && this.a.a != null) {
            this.b = al.a(this.a.a);
        }
        return this.b;
    }
}
