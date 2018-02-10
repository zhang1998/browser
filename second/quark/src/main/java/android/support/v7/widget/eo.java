package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ProGuard */
final class eo implements OnTouchListener {
    final /* synthetic */ ListPopupWindow a;

    private eo(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.a.a != null && this.a.a.isShowing() && x >= 0 && x < this.a.a.getWidth() && y >= 0 && y < this.a.a.getHeight()) {
            this.a.C.postDelayed(this.a.x, 250);
        } else if (action == 1) {
            this.a.C.removeCallbacks(this.a.x);
        }
        return false;
    }
}
