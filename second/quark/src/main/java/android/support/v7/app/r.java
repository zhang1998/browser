package android.support.v7.app;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.fb;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* compiled from: ProGuard */
final class r extends ContentFrameLayout {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    public r(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
        this.a = appCompatDelegateImplV7;
        super(context);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.a.a(this.a.f(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(fb.a().a(getContext(), i, false));
    }
}
