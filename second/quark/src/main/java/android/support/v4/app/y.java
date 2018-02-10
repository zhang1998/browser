package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: ProGuard */
final class y extends EpicenterCallback {
    final /* synthetic */ v a;
    private Rect b;

    y(v vVar) {
        this.a = vVar;
    }

    public final Rect onGetEpicenter(Transition transition) {
        if (this.b == null && this.a.a != null) {
            this.b = ab.a(this.a.a);
        }
        return this.b;
    }
}
