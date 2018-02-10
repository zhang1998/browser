package com.taobao.weex.ui.component.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ProGuard */
public final class c implements OnTouchListener {
    private a a;
    private boolean b;

    public c(a aVar, boolean z) {
        this.a = aVar;
        this.b = z;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.a != null) {
            if (action == 0 || action == 5) {
                this.a.updateActivePseudo(true);
            } else if (action == 3 || action == 1 || action == 6) {
                this.a.updateActivePseudo(false);
            }
        }
        return this.b;
    }
}
