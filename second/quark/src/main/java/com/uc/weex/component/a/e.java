package com.uc.weex.component.a;

import android.content.Context;
import android.view.MotionEvent;
import com.taobao.weex.ad;
import com.taobao.weex.ui.view.l;

/* compiled from: ProGuard */
public final class e extends l {
    private c b;
    private d c;
    private d d;

    public e(Context context, c cVar) {
        super(context);
        this.b = cVar;
        setClickable(true);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                if (this.d != null) {
                    this.d.a = true;
                    this.d = null;
                }
                if (this.c != null) {
                    this.c.a = true;
                }
                this.c = new d(this, true);
                ad.a().a(this.c, 100);
                break;
            case 1:
            case 6:
                if (this.c != null) {
                    if (this.c.b) {
                        this.b.a(false);
                    } else {
                        this.b.a(true);
                        this.d = new d(this, false);
                        ad.a().a(this.d, 100);
                    }
                    this.c.a = true;
                    this.c = null;
                    break;
                }
                this.b.a(false);
                break;
            case 3:
                if (this.c != null) {
                    this.c.a = true;
                    this.c = null;
                }
                this.b.a(false);
                break;
        }
        return onTouchEvent;
    }
}
