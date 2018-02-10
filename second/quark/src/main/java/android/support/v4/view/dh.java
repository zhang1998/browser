package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

/* compiled from: ProGuard */
class dh extends dd {
    dh() {
    }

    public final void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public final int y(View view) {
        return view.getLayoutDirection();
    }

    public final void b(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public final int E(View view) {
        return view.getWindowSystemUiVisibility();
    }
}
