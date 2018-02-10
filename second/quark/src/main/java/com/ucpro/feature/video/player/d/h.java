package com.ucpro.feature.video.player.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ucpro.services.networkstate.b;

/* compiled from: ProGuard */
final class h extends FrameLayout {
    final /* synthetic */ p a;

    h(p pVar, Context context) {
        this.a = pVar;
        super(context);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.a.p.a(10000, null, null);
        }
        return true;
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this.a.a) {
            if (i == 0) {
                p.a(this.a);
                this.a.b.setTitle(this.a.r.f().q);
                b.a.a(this.a);
                return;
            }
            p pVar = this.a;
            pVar.h.removeCallbacks(pVar.i);
            b.a.b(this.a);
        }
    }
}
