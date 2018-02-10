package com.ucpro.feature.z.b;

import android.os.SystemClock;
import android.text.Layout;
import android.view.MotionEvent;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucweb.common.util.h.a;
import com.ui.edittext.u;

/* compiled from: ProGuard */
final class e extends a {
    final /* synthetic */ int a;
    final /* synthetic */ float b;
    final /* synthetic */ b c;

    e(b bVar, int i, float f) {
        this.c = bVar;
        this.a = i;
        this.b = f;
    }

    public final void run() {
        int i = 0;
        if (this.a % 2 == 0) {
            this.c.d.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, this.b, (float) (this.c.d.getHeight() / 2), 0));
        } else {
            this.c.d.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, this.b, (float) (this.c.d.getHeight() / 2), 0));
        }
        if (this.a == 3) {
            this.c.d.a(this.c.a, this.c.b);
            Layout layout = this.c.d.getLayout();
            if (layout != null) {
                if (this.c.c == 0) {
                    i = this.c.a;
                } else if (this.c.c == 1) {
                    i = this.c.b;
                }
                layout.getPrimaryHorizontal(i);
                this.c.d.getScrollX();
                CustomEditText customEditText = this.c.d;
                this.c.d.getHeight();
                customEditText.a(u.SELECTION_HANDLE_TAP);
                if (this.c.c == 0) {
                    this.c.d.getViewTreeObserver().addOnPreDrawListener(new j(this, this.c.a));
                }
                this.c.a = -1;
                this.c.b = -1;
                this.c.c = -1;
            }
        }
    }
}
