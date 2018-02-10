package com.c.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class c implements OnTouchListener {
    final /* synthetic */ f a;

    c(f fVar) {
        this.a = fVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        q qVar = this.a.f;
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            qVar.d = 0;
        } else if (action == 6) {
            if (qVar.d == 1 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    qVar.a(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    qVar.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 5) {
            qVar.d = 1;
            qVar.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && qVar.d == 1 && motionEvent.getPointerCount() > 1) {
            float b = q.b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
            if (qVar.f) {
                h hVar = qVar.e;
                if (hVar.e == 0.0f) {
                    hVar.e = b;
                }
                hVar.g = (((b / hVar.e) - IPictureView.DEFAULT_MIN_SCALE) * hVar.h.i) + hVar.f;
                hVar.g = Math.max(hVar.g, hVar.h.g);
                hVar.g = Math.min(hVar.g, hVar.h.h);
                qVar.a(hVar.g);
            }
        }
        qVar.c.onTouchEvent(motionEvent);
        return true;
    }
}
