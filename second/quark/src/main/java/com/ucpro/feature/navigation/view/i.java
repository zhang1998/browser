package com.ucpro.feature.navigation.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
public final class i extends View {
    private View a;
    private Drawable b;
    private Paint c = new Paint();
    private Rect d = new Rect();
    private Rect e = new Rect();
    private Rect f;
    private boolean g = true;
    private int h = 255;
    private int i = 0;
    private int j = 0;

    public i(Context context) {
        super(context);
        this.c.setAntiAlias(true);
        this.c.setFilterBitmap(true);
    }

    public final void setUseBitmap(boolean z) {
        this.g = z;
    }

    public final void setAlpha(int i) {
        this.h = i;
    }

    public final void setSourceView(View view) {
        this.a = view;
        if (this.g) {
            Bitmap a = a(this.a, this.a.getWidth(), this.a.getHeight());
            if (a != null) {
                this.d.set(0, 0, a.getWidth(), a.getHeight());
                this.b = new BitmapDrawable(getContext().getResources(), a);
            }
        }
    }

    public final void setClipRect(Rect rect) {
        this.f = rect;
    }

    private static Bitmap a(View view, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                if (view instanceof u) {
                    u uVar = (u) view;
                    uVar.getTitleView().invalidate();
                    uVar.getIconView().invalidate();
                }
                view.draw(canvas);
                return createBitmap;
            } catch (Throwable th) {
                return createBitmap;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
        int i = 0;
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (!this.g && this.a == null) {
            return;
        }
        if (!this.g || this.b != null) {
            int i2;
            int i3;
            int i4;
            if (layoutParams instanceof ab) {
                ab abVar = (ab) layoutParams;
                i2 = abVar.a;
                i3 = abVar.b;
                i = abVar.width;
                i4 = abVar.height;
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            canvas.save();
            if (this.f != null) {
                canvas.clipRect(this.f);
                canvas.clipRect(this.f.left - this.i, this.f.top - this.j, this.f.right - this.i, this.f.bottom - this.j);
            }
            canvas.translate((float) this.i, (float) this.j);
            if (!this.g) {
                canvas.save();
                canvas.translate((float) (i2 - this.a.getScrollX()), (float) (i3 - this.a.getScrollY()));
                this.a.draw(canvas);
                canvas.restore();
            } else if (this.b != null) {
                this.c.setAlpha(this.h);
                if (this.f != null) {
                    canvas.save();
                    canvas.clipRect(this.f);
                }
                this.e.set(i2, i3, i + i2, i4 + i3);
                canvas.save();
                canvas.clipRect(this.e);
                this.b.setBounds(this.e);
                this.b.draw(canvas);
                canvas.restore();
                if (this.f != null) {
                    canvas.restore();
                }
            }
            canvas.restore();
        }
    }

    public final void setSourceDrawableRes(Drawable drawable) {
        if (drawable != null) {
            this.b = drawable;
            if (this.b != null) {
                this.d.set(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
            }
        }
    }
}
