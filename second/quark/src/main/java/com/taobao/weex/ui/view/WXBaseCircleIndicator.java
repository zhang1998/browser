package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.mini.support.v4.view.bx;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class WXBaseCircleIndicator extends FrameLayout implements bx, c {
    private final Paint a = new Paint();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private b d;
    private WXCircleViewPager e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private bx k;

    public WXBaseCircleIndicator(Context context) {
        super(context);
        getAttrs$faab20d();
        a();
    }

    private void getAttrs$faab20d() {
        this.f = (float) WXViewUtils.f(5.0f);
        this.g = (float) WXViewUtils.f(5.0f);
        this.h = Color.parseColor("#ffffff");
        this.i = Color.parseColor("#ffd545");
    }

    private void a() {
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.STROKE);
        this.c.setStyle(Style.FILL);
        this.c.setAntiAlias(true);
        this.a.setAntiAlias(true);
        this.a.setColor(this.h);
        this.c.setStyle(Style.FILL);
        this.c.setColor(this.i);
        setWillNotDraw(false);
    }

    public WXBaseCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getAttrs$faab20d();
        a();
    }

    public void setOnPageChangeListener(bx bxVar) {
        this.k = bxVar;
    }

    public WXCircleViewPager getCircleViewPager() {
        return this.e;
    }

    public void setCircleViewPager(WXCircleViewPager wXCircleViewPager) {
        this.e = wXCircleViewPager;
        if (this.e != null) {
            this.e.setOnPageChangeListener(this);
        }
        requestLayout();
    }

    public final void a(int i, float f, int i2) {
        if (this.k != null) {
            this.k.a(i, f, i2);
        }
    }

    public final void a(int i) {
        this.j = this.e.getRealCurrentItem();
        invalidate();
        if (this.k != null) {
            this.k.a(i);
        }
    }

    public final void b(int i) {
        if (this.k != null) {
            this.k.b(i);
        }
    }

    public float getRadius() {
        return this.f;
    }

    public void setRadius(float f) {
        this.f = f;
    }

    public float getCirclePadding() {
        return this.g;
    }

    public void setCirclePadding(float f) {
        this.g = f;
    }

    public int getFillColor() {
        return this.i;
    }

    public void setFillColor(int i) {
        this.i = i;
        this.c.setColor(i);
    }

    public void setPageColor(int i) {
        this.h = i;
        this.a.setColor(i);
    }

    public int getRealCurrentItem() {
        return this.j;
    }

    public void setRealCurrentItem(int i) {
        this.j = i;
    }

    public final void a(b bVar) {
        this.d = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.d != null) {
            return onTouchEvent | this.d.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = ((float) ((getWidth() / 2) + getPaddingLeft())) - ((((float) getCount()) / 2.0f) * (this.f + this.g));
        float height = (float) ((getHeight() / 2) + getPaddingTop());
        for (int i = 0; i < getCount(); i++) {
            float f = ((this.g * ((float) i)) + width) + ((this.f * 2.0f) * ((float) i));
            if (this.b.getStrokeWidth() > 0.0f) {
                canvas.drawCircle(f, height, this.f, this.b);
            }
            if (this.a.getAlpha() > 0) {
                canvas.drawCircle(f, height, this.f, this.a);
            }
        }
        canvas.drawCircle(((((float) this.j) * this.g) + width) + ((this.f * 2.0f) * ((float) this.j)), height, this.f, this.c);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != UCCore.VERIFY_POLICY_QUICK) {
            size = ((int) (((((float) getPaddingLeft()) + ((this.f * 2.0f) * ((float) getCount()))) + (this.g * ((float) (getCount() - 1)))) + ((float) getPaddingRight()))) + 1;
        }
        if (mode2 != UCCore.VERIFY_POLICY_QUICK) {
            size2 = ((int) ((((float) getPaddingTop()) + (this.f * 2.0f)) + ((float) getPaddingBottom()))) + 1;
        }
        setMeasuredDimension(size, size2);
    }

    public int getCount() {
        if (this.e == null || this.e.getAdapter() == null) {
            return 0;
        }
        return this.e.getRealCount();
    }
}
