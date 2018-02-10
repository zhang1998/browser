package com.uc.qrcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.zxing.R;
import com.uc.qrcode.a.c;

/* compiled from: ProGuard */
public final class ViewfinderView extends View {
    String a;
    public c b;
    final Paint c = new Paint(1);
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    private final int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r = false;
    private int s;
    private int t;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.l = resources.getColor(R.color.viewfinder_mask);
        this.f = (int) getContext().getResources().getDimension(R.dimen.qrcode_area_scan_text_size);
        this.e = resources.getColor(R.color.viewfinder_text_color);
        this.g = (int) getContext().getResources().getDimension(R.dimen.qrcode_area_scan_text_size_margin_top);
        this.n = resources.getColor(R.color.viewfinder_scan_line_color);
        this.o = SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE;
        this.q = resources.getColor(R.color.viewfinder_scan_bg_color);
        this.p = 51;
        this.d = getContext().getResources().getDimensionPixelSize(R.dimen.qrcode_area_scan_line_height);
        this.i = resources.getColor(R.color.viewfinder_scan_inner_corner_color);
        this.j = getContext().getResources().getDimensionPixelSize(R.dimen.qrcode_area_corner_width);
        this.k = getContext().getResources().getDimensionPixelSize(R.dimen.qrcode_area_corner_height);
    }

    public final void setmCameraManager(c cVar) {
        this.b = cVar;
    }

    public final void setText(String str) {
        this.a = str;
        if (!TextUtils.isEmpty(str)) {
            this.c.setTextSize((float) this.f);
            this.h = ((int) this.c.measureText(str)) + 1;
        }
    }

    public final void setTextSize(int i) {
        this.f = i;
        if (!TextUtils.isEmpty(this.a)) {
            this.c.setTextSize((float) this.f);
            this.h = ((int) this.c.measureText(this.a)) + 1;
        }
    }

    public final void setTextColor(int i) {
        this.e = i;
    }

    public final void setTextMarginScanTop(int i) {
        this.g = i;
    }

    public final void setLineHeight(int i) {
        this.d = i;
    }

    public final void setInnerCornerLenght(int i) {
        this.j = i;
    }

    public final void setInnerCornerWidth(int i) {
        this.k = i;
    }

    public final void setInnerCornerColor(int i) {
        this.i = i;
    }

    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        if (this.b != null) {
            Rect c = this.b.c();
            Rect d = this.b.d();
            if (c != null && d != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.c.setColor(this.l);
                canvas.drawRect(0.0f, 0.0f, (float) width, (float) c.top, this.c);
                canvas.drawRect(0.0f, (float) c.top, (float) c.left, (float) (c.bottom + 1), this.c);
                canvas.drawRect((float) (c.right + 1), (float) c.top, (float) width, (float) (c.bottom + 1), this.c);
                canvas.drawRect(0.0f, (float) (c.bottom + 1), (float) width, (float) height, this.c);
                this.c.setColor(this.i);
                this.c.setStyle(Style.FILL);
                int i = this.k;
                int i2 = this.j;
                canvas.drawRect((float) (c.left - i), (float) (c.top - i), (float) c.left, (float) (c.top + i2), this.c);
                canvas.drawRect((float) (c.left - i), (float) (c.top - i), (float) (c.left + i2), (float) c.top, this.c);
                canvas.drawRect((float) c.right, (float) (c.top - i), (float) (c.right + i), (float) (c.top + i2), this.c);
                canvas.drawRect((float) (c.right - i2), (float) (c.top - i), (float) (c.right + i), (float) c.top, this.c);
                canvas.drawRect((float) (c.left - i), (float) (c.bottom - i2), (float) c.left, (float) (c.bottom + i), this.c);
                canvas.drawRect((float) (c.left - i), (float) c.bottom, (float) (c.left + i2), (float) (c.bottom + i), this.c);
                canvas.drawRect((float) c.right, (float) (c.bottom - i2), (float) (c.right + i), (float) (c.bottom + i), this.c);
                canvas.drawRect((float) (c.right - i2), (float) c.bottom, (float) (c.right + i), (float) (c.bottom + i), this.c);
                if (this.m == 0) {
                    this.m = c.top;
                }
                if (this.r || this.m < c.bottom - this.d) {
                    this.m += 15;
                    int i3 = c.bottom - this.d;
                    if (this.m >= i3) {
                        this.m = i3;
                        this.r = true;
                    }
                } else {
                    this.m = c.top;
                }
                this.c.setColor(this.q);
                this.s = this.r ? this.s - 1 : this.p;
                this.c.setAlpha(this.s);
                this.c.setStyle(Style.FILL);
                canvas.drawRect((float) c.left, (float) c.top, (float) c.right, (float) this.m, this.c);
                this.c.setColor(this.n);
                this.t = this.r ? this.t - 4 : this.o;
                this.c.setAlpha(this.t);
                canvas.drawRect((float) c.left, (float) this.m, (float) c.right, (float) (this.m + this.d), this.c);
                if (!TextUtils.isEmpty(this.a)) {
                    this.c.setColor(this.e);
                    this.c.setTextSize((float) this.f);
                    canvas.drawText(this.a, (float) ((c.left + ((c.right - c.left) / 2)) - (this.h / 2)), (float) (c.bottom + this.g), this.c);
                }
                if (this.s <= 0 || this.t <= 0) {
                    this.r = false;
                }
                postInvalidateDelayed(10, c.left - 6, c.top - 6, c.right + 6, c.bottom + 6);
            }
        }
    }

    public static void a() {
    }
}
