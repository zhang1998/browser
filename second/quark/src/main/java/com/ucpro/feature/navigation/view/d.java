package com.ucpro.feature.navigation.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ucpro.base.d.b;
import com.ucpro.feature.navigation.l;

/* compiled from: ProGuard */
public final class d extends FrameLayout implements l {
    private com.ucpro.feature.navigation.d a;
    private Rect b;

    public d(Context context) {
        super(context);
        setOnClickListener(new f(this));
    }

    public final void setPresenter(b bVar) {
        this.a = (com.ucpro.feature.navigation.d) bVar;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        this.a.a();
        return true;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            boolean contains;
            if (this.b != null) {
                contains = this.b.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                contains = false;
            }
            if (contains) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void a(View view) {
        this.b = new Rect();
        this.b.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
