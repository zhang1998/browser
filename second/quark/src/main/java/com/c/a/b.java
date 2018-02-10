package com.c.a;

import android.view.MotionEvent;
import com.c.a.e.f;

/* compiled from: ProGuard */
final class b implements x {
    final /* synthetic */ r a;

    b(r rVar) {
        this.a = rVar;
    }

    public final void a(MotionEvent motionEvent) {
        r rVar = this.a;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int a = rVar.b.a();
        if (a != 0) {
            int i = ((ac) rVar.c.b.get(0)).f;
            int i2 = (int) (x / ((float) i));
            if (i2 < a) {
                rVar.a(f.a(x - ((float) (i * i2)), y, (ac) rVar.c.b.get(i2)), 2);
            }
        }
    }
}
