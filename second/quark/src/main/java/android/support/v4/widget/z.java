package android.support.v4.widget;

import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
final class z implements Runnable {
    final /* synthetic */ ae a;

    z(ae aeVar) {
        this.a = aeVar;
    }

    public final void run() {
        View view;
        int i;
        int i2 = 0;
        ae aeVar = this.a;
        int i3 = aeVar.b.h;
        boolean z = aeVar.a == 3;
        int i4;
        if (z) {
            View a = aeVar.c.a(3);
            if (a != null) {
                i4 = -a.getWidth();
            } else {
                i4 = 0;
            }
            i4 += i3;
            view = a;
            i = i4;
        } else {
            i4 = aeVar.c.getWidth() - i3;
            view = aeVar.c.a(5);
            i = i4;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && aeVar.c.a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            aeVar.b.a(view, i, view.getTop());
            layoutParams.c = true;
            aeVar.c.invalidate();
            aeVar.b();
            DrawerLayout drawerLayout = aeVar.c;
            if (!drawerLayout.d) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                i = drawerLayout.getChildCount();
                while (i2 < i) {
                    drawerLayout.getChildAt(i2).dispatchTouchEvent(obtain);
                    i2++;
                }
                obtain.recycle();
                drawerLayout.d = true;
            }
        }
    }
}
