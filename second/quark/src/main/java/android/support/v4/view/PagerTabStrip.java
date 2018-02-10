package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class PagerTabStrip extends PagerTitleStrip {
    private int f = this.e;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final Paint l = new Paint();
    private final Rect m = new Rect();
    private int n = 255;
    private boolean o = false;
    private boolean p = false;
    private int q;
    private boolean r;
    private float s;
    private float t;
    private int u;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l.setColor(this.f);
        float f = context.getResources().getDisplayMetrics().density;
        this.g = (int) ((IPictureView.DEFAULT_MAX_SCALE * f) + 0.5f);
        this.h = (int) ((6.0f * f) + 0.5f);
        this.i = (int) (64.0f * f);
        this.k = (int) ((16.0f * f) + 0.5f);
        this.q = (int) ((IPictureView.DEFAULT_MIN_SCALE * f) + 0.5f);
        this.j = (int) ((f * 32.0f) + 0.5f);
        this.u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new ei(this));
        this.d.setFocusable(true);
        this.d.setOnClickListener(new bj(this));
        if (getBackground() == null) {
            this.o = true;
        }
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.f = i;
        this.l.setColor(this.f);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.h) {
            i4 = this.h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.i) {
            i = this.i;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.p) {
            this.o = drawable == null;
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.p) {
            this.o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.p) {
            this.o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.o = z;
        this.p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.o;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.s = x;
                this.t = y;
                this.r = false;
                break;
            case 1:
                if (x >= ((float) (this.c.getLeft() - this.k))) {
                    if (x > ((float) (this.c.getRight() + this.k))) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                }
                this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.s) > ((float) this.u) || Math.abs(y - this.t) > ((float) this.u)) {
                    this.r = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.k;
        int right = this.c.getRight() + this.k;
        int i = height - this.g;
        this.l.setColor((this.n << 24) | (this.f & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.l);
        if (this.o) {
            this.l.setColor(-16777216 | (this.f & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.q), (float) (getWidth() - getPaddingRight()), (float) height, this.l);
        }
    }

    final void a(int i, float f, boolean z) {
        Rect rect = this.m;
        int height = getHeight();
        int i2 = height - this.g;
        rect.set(this.c.getLeft() - this.k, i2, this.c.getRight() + this.k, height);
        super.a(i, f, z);
        this.n = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.k, i2, this.c.getRight() + this.k, height);
        invalidate(rect);
    }
}
