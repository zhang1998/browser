package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: ProGuard */
final class ac extends EpicenterCallback {
    final /* synthetic */ Rect a;

    ac(Rect rect) {
        this.a = rect;
    }

    public final Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
