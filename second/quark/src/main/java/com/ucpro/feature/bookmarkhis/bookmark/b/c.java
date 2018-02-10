package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
public final class c extends View {
    private int a;
    private Drawable b;
    private Drawable c;
    private Drawable d;
    private boolean e;

    public c(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public final void setDisplayWithIntrinsicSize(boolean z) {
        this.e = z;
    }

    public final void setNormalImage(Drawable drawable) {
        this.b = drawable;
    }

    public final void setPressedImage(Drawable drawable) {
        this.d = drawable;
    }

    public final void setSelectedImage(Drawable drawable) {
        this.c = drawable;
    }

    public final void setImageSize(int i) {
        this.a = i;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension((this.a + getPaddingLeft()) + getPaddingRight(), (this.a + getPaddingTop()) + getPaddingBottom());
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a(this.b);
        a(this.c);
        a(this.d);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (action) {
            case 0:
                setPressed(true);
                invalidate();
                break;
            case 1:
            case 3:
            case 4:
                setPressed(false);
                invalidate();
                break;
        }
        return onTouchEvent;
    }

    private void a(Drawable drawable) {
        if (drawable != null) {
            int i = this.a;
            int i2 = this.a;
            if (this.e) {
                i = drawable.getIntrinsicWidth();
                i2 = drawable.getIntrinsicHeight();
            }
            int paddingLeft = getPaddingLeft();
            int height = (getHeight() - i2) / 2;
            drawable.setBounds(paddingLeft, height, i + paddingLeft, i2 + height);
        }
    }

    protected final void onDraw(Canvas canvas) {
        if (!isSelected() || this.c == null) {
            if (isPressed() && this.d != null) {
                this.d.draw(canvas);
            } else if (this.b != null) {
                this.b.draw(canvas);
            }
        } else if (this.c != null) {
            this.c.draw(canvas);
        }
    }
}
