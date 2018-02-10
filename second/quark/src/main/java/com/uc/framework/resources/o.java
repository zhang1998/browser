package com.uc.framework.resources;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PathEffect;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class o extends Drawable {
    private static /* synthetic */ int[] o;
    m a;
    final Paint b;
    boolean c;
    Path d;
    private Rect e;
    private Paint f;
    private ColorFilter g;
    private int h;
    private boolean i;
    private final Path j;
    private final RectF k;
    private Paint l;
    private boolean m;
    private boolean n;

    private static /* synthetic */ int[] a() {
        int[] iArr = o;
        if (iArr == null) {
            iArr = new int[n.values().length];
            try {
                iArr[n.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[n.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[n.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[n.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[n.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[n.TL_BR.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[n.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[n.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            o = iArr;
        }
        return iArr;
    }

    public o() {
        this(new m(n.TOP_BOTTOM));
    }

    public final boolean getPadding(Rect rect) {
        if (this.e == null) {
            return super.getPadding(rect);
        }
        rect.set(this.e);
        return true;
    }

    public final void a(int i, int i2, float f, float f2) {
        m mVar = this.a;
        mVar.k = i;
        mVar.l = i2;
        mVar.m = f;
        mVar.n = f2;
        if (this.f == null) {
            this.f = new Paint(1);
            this.f.setStyle(Style.STROKE);
        }
        this.f.setStrokeWidth((float) i);
        this.f.setColor(i2);
        PathEffect pathEffect = null;
        if (f > 0.0f) {
            pathEffect = new DashPathEffect(new float[]{f, f2}, 0.0f);
        }
        this.f.setPathEffect(pathEffect);
    }

    private int a(int i) {
        return ((this.h + (this.h >> 7)) * i) >> 8;
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.a;
    }

    public final void setAlpha(int i) {
        this.h = i;
    }

    public final void setDither(boolean z) {
        this.i = z;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.g = colorFilter;
    }

    public final int getOpacity() {
        return -3;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d = null;
        this.n = true;
        this.c = true;
    }

    protected final boolean onLevelChange(int i) {
        super.onLevelChange(i);
        this.c = true;
        this.n = true;
        invalidateSelf();
        return true;
    }

    public final int getIntrinsicWidth() {
        return this.a.r;
    }

    public final int getIntrinsicHeight() {
        return this.a.s;
    }

    public final ConstantState getConstantState() {
        this.a.a = super.getChangingConfigurations();
        return this.a;
    }

    public final Drawable mutate() {
        if (!this.m && super.mutate() == this) {
            this.a = new m(this.a);
            a(this.a);
            this.m = true;
        }
        return this;
    }

    private o(m mVar) {
        this.b = new Paint(1);
        this.h = 255;
        this.j = new Path();
        this.k = new RectF();
        this.a = mVar;
        a(mVar);
        this.c = true;
    }

    private void a(m mVar) {
        if (mVar.i) {
            this.b.setColor(mVar.j);
        }
        this.e = mVar.q;
        if (mVar.k >= 0) {
            this.f = new Paint(1);
            this.f.setStyle(Style.STROKE);
            this.f.setStrokeWidth((float) mVar.k);
            this.f.setColor(mVar.l);
            if (mVar.m != 0.0f) {
                this.f.setPathEffect(new DashPathEffect(new float[]{mVar.m, mVar.n}, 0.0f));
            }
        }
    }

    public final void draw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        int length;
        float f5;
        int i;
        if (this.c) {
            this.c = false;
            Rect bounds = getBounds();
            f = 0.0f;
            if (this.f != null) {
                f = this.f.getStrokeWidth() * 0.5f;
            }
            m mVar = this.a;
            this.k.set(((float) bounds.left) + f, ((float) bounds.top) + f, ((float) bounds.right) - f, ((float) bounds.bottom) - f);
            Object obj = mVar.e;
            if (obj != null) {
                RectF rectF = this.k;
                float f6;
                if (mVar.c == 0) {
                    f = mVar.A ? ((float) getLevel()) / 10000.0f : IPictureView.DEFAULT_MIN_SCALE;
                    switch (a()[mVar.d.ordinal()]) {
                        case 1:
                            f2 = rectF.left;
                            f3 = rectF.top;
                            f4 = f * rectF.bottom;
                            f6 = f2;
                            break;
                        case 2:
                            f2 = rectF.right;
                            f3 = rectF.top;
                            f6 = rectF.left * f;
                            f4 = rectF.bottom * f;
                            break;
                        case 3:
                            f2 = rectF.right;
                            f4 = rectF.top;
                            f6 = f * rectF.left;
                            f3 = f4;
                            break;
                        case 4:
                            f2 = rectF.right;
                            f3 = rectF.bottom;
                            f6 = rectF.left * f;
                            f4 = rectF.top * f;
                            break;
                        case 5:
                            f2 = rectF.left;
                            f3 = rectF.bottom;
                            f4 = f * rectF.top;
                            f6 = f2;
                            break;
                        case 6:
                            f2 = rectF.left;
                            f3 = rectF.bottom;
                            f6 = rectF.right * f;
                            f4 = rectF.top * f;
                            break;
                        case 7:
                            f2 = rectF.left;
                            f4 = rectF.top;
                            f6 = f * rectF.right;
                            f3 = f4;
                            break;
                        default:
                            f2 = rectF.left;
                            f3 = rectF.top;
                            f6 = rectF.right * f;
                            f4 = rectF.bottom * f;
                            break;
                    }
                    this.b.setShader(new LinearGradient(f2, f3, f6, f4, obj, mVar.h, TileMode.CLAMP));
                } else if (mVar.c == 1) {
                    this.b.setShader(new RadialGradient(rectF.left + ((rectF.right - rectF.left) * mVar.x), rectF.top + ((rectF.bottom - rectF.top) * mVar.y), mVar.z * (mVar.A ? ((float) getLevel()) / 10000.0f : IPictureView.DEFAULT_MIN_SCALE), obj, null, TileMode.CLAMP));
                } else if (mVar.c == 2) {
                    int[] iArr;
                    f6 = rectF.left + ((rectF.right - rectF.left) * mVar.x);
                    f4 = rectF.top + ((rectF.bottom - rectF.top) * mVar.y);
                    float[] fArr = null;
                    if (mVar.A) {
                        iArr = mVar.f;
                        length = obj.length;
                        if (iArr == null || iArr.length != length + 1) {
                            iArr = new int[(length + 1)];
                            mVar.f = iArr;
                        }
                        System.arraycopy(obj, 0, iArr, 0, length);
                        iArr[length] = obj[length - 1];
                        fArr = mVar.g;
                        f5 = IPictureView.DEFAULT_MIN_SCALE / ((float) (length - 1));
                        if (fArr == null || fArr.length != length + 1) {
                            fArr = new float[(length + 1)];
                            mVar.g = fArr;
                        }
                        float level = ((float) getLevel()) / 10000.0f;
                        for (i = 0; i < length; i++) {
                            fArr[i] = (((float) i) * f5) * level;
                        }
                        fArr[length] = IPictureView.DEFAULT_MIN_SCALE;
                    } else {
                        Object obj2 = obj;
                    }
                    this.b.setShader(new SweepGradient(f6, f4, iArr, fArr));
                }
            }
        }
        if (this.k.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            Object obj3;
            int alpha = this.b.getAlpha();
            length = this.f != null ? this.f.getAlpha() : 0;
            int a = a(alpha);
            i = a(length);
            Object obj4 = (i <= 0 || this.f.getStrokeWidth() <= 0.0f) ? null : 1;
            obj2 = a > 0 ? 1 : null;
            m mVar2 = this.a;
            if (obj4 == null || obj2 == null || mVar2.b == 2 || i >= 255) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setDither(this.i);
                this.l.setAlpha(this.h);
                this.l.setColorFilter(this.g);
                f = this.f.getStrokeWidth();
                canvas.saveLayer(this.k.left - f, this.k.top - f, this.k.right + f, this.k.bottom + f, this.l, 4);
                this.b.setColorFilter(null);
                this.f.setColorFilter(null);
            } else {
                this.b.setAlpha(a);
                this.b.setDither(this.i);
                this.b.setColorFilter(this.g);
                if (obj4 != null) {
                    this.f.setAlpha(i);
                    this.f.setDither(this.i);
                    this.f.setColorFilter(this.g);
                }
            }
            switch (mVar2.b) {
                case 0:
                    if (mVar2.p == null) {
                        f = mVar2.o;
                        canvas.drawRoundRect(this.k, f, f, this.b);
                        if (obj4 != null) {
                            canvas.drawRoundRect(this.k, f, f, this.f);
                            break;
                        }
                    }
                    this.j.reset();
                    this.j.addRoundRect(this.k, mVar2.p, Direction.CW);
                    canvas.drawPath(this.j, this.b);
                    if (obj4 != null) {
                        canvas.drawPath(this.j, this.f);
                        break;
                    }
                    break;
                case 1:
                    canvas.drawOval(this.k, this.b);
                    if (obj4 != null) {
                        canvas.drawOval(this.k, this.f);
                        break;
                    }
                    break;
                case 2:
                    RectF rectF2 = this.k;
                    f3 = rectF2.centerY();
                    canvas.drawLine(rectF2.left, f3, rectF2.right, f3, this.f);
                    break;
                case 3:
                    Path path;
                    if (this.d == null || (mVar2.B && this.n)) {
                        this.n = false;
                        f = mVar2.B ? (360.0f * ((float) getLevel())) / 10000.0f : 360.0f;
                        RectF rectF3 = new RectF(this.k);
                        f4 = rectF3.width() / 2.0f;
                        f5 = rectF3.height() / 2.0f;
                        f2 = mVar2.w != -1 ? (float) mVar2.w : rectF3.width() / mVar2.u;
                        if (mVar2.v != -1) {
                            f3 = (float) mVar2.v;
                        } else {
                            f3 = rectF3.width() / mVar2.t;
                        }
                        RectF rectF4 = new RectF(rectF3);
                        rectF4.inset(f4 - f3, f5 - f3);
                        RectF rectF5 = new RectF(rectF4);
                        rectF5.inset(-f2, -f2);
                        if (this.d == null) {
                            this.d = new Path();
                        } else {
                            this.d.reset();
                        }
                        Path path2 = this.d;
                        if (f >= 360.0f || f <= -360.0f) {
                            path2.addOval(rectF5, Direction.CW);
                            path2.addOval(rectF4, Direction.CCW);
                        } else {
                            path2.setFillType(FillType.EVEN_ODD);
                            path2.moveTo(f4 + f3, f5);
                            path2.lineTo(f2 + (f3 + f4), f5);
                            path2.arcTo(rectF5, 0.0f, f, false);
                            path2.arcTo(rectF4, f, -f, false);
                            path2.close();
                        }
                        path = path2;
                    } else {
                        path = this.d;
                    }
                    canvas.drawPath(path, this.b);
                    if (obj4 != null) {
                        canvas.drawPath(path, this.f);
                        break;
                    }
                    break;
            }
            if (obj3 != null) {
                canvas.restore();
                return;
            }
            this.b.setAlpha(alpha);
            if (obj4 != null) {
                this.f.setAlpha(length);
            }
        }
    }
}
