package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.mini.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.taobao.weex.ui.component.bt;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class t extends View implements a<bt>, c {
    public WeakReference<bt> a;
    private b b;
    private Layout c;
    private boolean d = false;

    public t(Context context) {
        super(context);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Layout textLayout = getTextLayout();
        if (textLayout != null) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            textLayout.draw(canvas);
        }
        canvas.restore();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.b != null) {
            return onTouchEvent | this.b.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public final CharSequence getText() {
        return this.c.getText();
    }

    public final Layout getTextLayout() {
        return this.c;
    }

    public final void setTextLayout(Layout layout) {
        this.c = layout;
        if (!(layout == null || this.d)) {
            setContentDescription(layout.getText());
        }
        if (this.a != null) {
            bt btVar = (bt) this.a.get();
            if (btVar != null) {
                btVar.readyToRender();
            }
        }
    }

    public final void setAriaLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d = false;
            if (this.c != null) {
                setContentDescription(this.c.getText());
                return;
            }
            return;
        }
        this.d = true;
        setContentDescription(str);
    }

    @Nullable
    public final bt getComponent() {
        return this.a != null ? (bt) this.a.get() : null;
    }
}
