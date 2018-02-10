package com.ucpro.ui.widget.ripple;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.uc.imagecodec.export.IPictureView;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class h extends d {
    private static int[] A = new int[]{16842919};
    Ripple[] c;
    int d;
    private final Rect e;
    private final Rect f;
    private final Rect g;
    private final Rect h;
    private l i;
    private Drawable j;
    private RippleBackground k;
    private Bitmap l;
    private BitmapShader m;
    private Canvas n;
    private Matrix o;
    private PorterDuffColorFilter p;
    private boolean q;
    private boolean r;
    private Ripple s;
    private boolean t;
    private float u;
    private float v;
    private boolean w;
    private Paint x;
    private float y;
    private boolean z;

    h() {
        this(new l(null, null, null), null);
    }

    public h(ColorStateList colorStateList, Drawable drawable) {
        int length;
        this(new l(null, null, null), null);
        i iVar = new i();
        iVar.g = 0;
        iVar.b = null;
        iVar.a = drawable;
        iVar.c = 0;
        iVar.d = 0;
        iVar.e = 0;
        iVar.f = 0;
        c cVar = this.a;
        if (cVar.b != null) {
            length = cVar.b.length;
        } else {
            length = 0;
        }
        int i = cVar.a;
        if (d.b || cVar.b != null) {
            if (i >= length) {
                Object obj = new i[(length + 10)];
                if (i > 0) {
                    System.arraycopy(cVar.b, 0, obj, 0, i);
                }
                cVar.b = obj;
            }
            cVar.b[i] = iVar;
            cVar.a++;
            cVar.f = false;
            cVar.h = false;
            c cVar2 = this.a;
            cVar2.e |= drawable.getChangingConfigurations();
            drawable.setCallback(this);
            this.i.k = colorStateList;
            invalidateSelf();
            a();
            return;
        }
        throw new AssertionError();
    }

    public final void jumpToCurrentState() {
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    protected final boolean onStateChange(int[] iArr) {
        boolean z;
        boolean z2 = false;
        boolean onStateChange = super.onStateChange(iArr);
        int length = iArr.length;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (i < length) {
            int i2 = iArr[i];
            if (i2 == 16842910) {
                z5 = true;
            }
            if (i2 == 16842908) {
                z = true;
            } else {
                z = z3;
            }
            if (i2 == 16842919) {
                z4 = true;
            }
            i++;
            z3 = z;
        }
        if (z5 && r0) {
            z = true;
        } else {
            z = false;
        }
        if (this.t != z) {
            this.t = z;
            if (z) {
                b();
            } else if (this.s != null) {
                if (this.c == null) {
                    this.c = new Ripple[10];
                }
                Ripple[] rippleArr = this.c;
                i = this.d;
                this.d = i + 1;
                rippleArr[i] = this.s;
                this.s.exit();
                this.s = null;
            }
        }
        if (z3 || (z5 && r0)) {
            z2 = true;
        }
        if (this.r != z2) {
            this.r = z2;
            if (z2) {
                a(z3);
            } else if (this.k != null) {
                this.k.exit();
            }
        }
        return onStateChange;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!this.z) {
            this.f.set(rect);
            c();
        }
        invalidateSelf();
    }

    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            if (this.s != null) {
                this.s.cancel();
                this.s = null;
                this.t = false;
            }
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
                this.r = false;
            }
            int i = this.d;
            Ripple[] rippleArr = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                rippleArr[i2].cancel();
            }
            if (rippleArr != null) {
                Arrays.fill(rippleArr, 0, i, null);
            }
            this.d = 0;
            invalidateSelf();
        } else if (visible) {
            if (this.t) {
                b();
            }
            if (this.r) {
                a(false);
            }
            jumpToCurrentState();
        }
        return visible;
    }

    public final boolean isStateful() {
        return true;
    }

    public final void a(int i) {
        super.a(i);
    }

    public final void applyTheme(Theme theme) {
        super.applyTheme(theme);
        l lVar = this.i;
        if (lVar != null && lVar.j != null) {
        }
    }

    public final void setHotspot(float f, float f2) {
        if (this.s == null || this.k == null) {
            this.u = f;
            this.v = f2;
            this.w = true;
        }
        if (this.s != null) {
            this.s.move(f, f2);
        }
    }

    private void a(boolean z) {
        if (this.k == null) {
            this.k = new RippleBackground(this, this.f);
        }
        this.k.setup(this.i.l, this.y);
        this.k.enter(z);
    }

    private void b() {
        if (this.d < 10) {
            if (this.s == null) {
                float f;
                float f2;
                if (this.w) {
                    this.w = false;
                    f = this.u;
                    f2 = this.v;
                } else {
                    f = this.f.exactCenterX();
                    f2 = this.f.exactCenterY();
                }
                this.s = new Ripple(this, this.f, f, f2);
            }
            this.s.setup(this.i.l, this.y);
            this.s.enter();
        }
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.z = true;
        this.f.set(i, i2, i3, i4);
        c();
    }

    public final void getHotspotBounds(Rect rect) {
        rect.set(this.f);
    }

    private void c() {
        int i = this.d;
        Ripple[] rippleArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            rippleArr[i2].onHotspotBoundsChanged();
        }
        if (this.s != null) {
            this.s.onHotspotBoundsChanged();
        }
        if (this.k != null) {
            this.k.onHotspotBoundsChanged();
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save(2);
        canvas.clipRect(bounds);
        a(canvas);
        Ripple ripple = this.s;
        RippleBackground rippleBackground = this.k;
        int i = this.d;
        if (ripple != null || i > 0 || (rippleBackground != null && rippleBackground.shouldDraw())) {
            int i2;
            float exactCenterX = this.f.exactCenterX();
            float exactCenterY = this.f.exactCenterY();
            canvas.translate(exactCenterX, exactCenterY);
            if (!this.q) {
                if (this.s != null || this.d > 0 || (this.k != null && this.k.shouldDraw())) {
                    if (this.j == null) {
                        i[] iVarArr = this.a.b;
                        int i3 = this.a.a;
                        for (i2 = 0; i2 < i3; i2++) {
                            if (iVarArr[i2].a.getOpacity() != -1) {
                                i2 = 1;
                                break;
                            }
                        }
                    } else if (this.j.getOpacity() != -1) {
                        i2 = 2;
                    }
                    i2 = 0;
                } else {
                    i2 = -1;
                }
                if (i2 != -1) {
                    this.q = true;
                    Rect bounds2 = getBounds();
                    if (i2 == 0 || bounds2.isEmpty()) {
                        if (this.l != null) {
                            this.l.recycle();
                            this.l = null;
                            this.m = null;
                            this.n = null;
                        }
                        this.o = null;
                        this.p = null;
                    } else {
                        if (this.l != null && this.l.getWidth() == bounds2.width() && this.l.getHeight() == bounds2.height()) {
                            this.l.eraseColor(0);
                        } else {
                            if (this.l != null) {
                                this.l.recycle();
                            }
                            this.l = Bitmap.createBitmap(bounds2.width(), bounds2.height(), Config.ALPHA_8);
                            this.m = new BitmapShader(this.l, TileMode.CLAMP, TileMode.CLAMP);
                            this.n = new Canvas(this.l);
                        }
                        if (this.o == null) {
                            this.o = new Matrix();
                        } else {
                            this.o.reset();
                        }
                        if (this.p == null) {
                            this.p = new PorterDuffColorFilter(0, Mode.SRC_IN);
                        }
                        if (i2 == 2) {
                            this.j.draw(this.n);
                        } else if (i2 == 1) {
                            a(this.n);
                        }
                    }
                }
            }
            if (this.m != null) {
                this.o.setTranslate(-exactCenterX, -exactCenterY);
                this.m.setLocalMatrix(this.o);
            }
            i2 = this.i.k.getColorForState(getState(), -16777216);
            if (i > 0) {
                i2 = this.i.k.getColorForState(A, -16777216);
            }
            int round = Math.round(((float) Color.alpha(i2)) / 1.5f) << 24;
            if (this.x == null) {
                this.x = new Paint();
                this.x.setAntiAlias(true);
                this.x.setStyle(Style.FILL);
            }
            Paint paint = this.x;
            paint.setColor((i2 & 16777215) | round);
            paint.setColorFilter(null);
            paint.setShader(null);
            if (rippleBackground != null && rippleBackground.shouldDraw()) {
                rippleBackground.draw(canvas, paint);
            }
            if (i > 0) {
                Ripple[] rippleArr = this.c;
                for (i2 = 0; i2 < i; i2++) {
                    rippleArr[i2].draw(canvas, paint);
                }
            } else if (ripple != null) {
                ripple.draw(canvas, paint);
            }
            canvas.translate(-exactCenterX, -exactCenterY);
        }
        canvas.restoreToCount(save);
    }

    public final void invalidateSelf() {
        super.invalidateSelf();
        this.q = false;
    }

    private void a(Canvas canvas) {
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        for (int i2 = 0; i2 < i; i2++) {
            iVarArr[i2].a.draw(canvas);
        }
    }

    public final ConstantState getConstantState() {
        return this.i;
    }

    public final Drawable mutate() {
        super.mutate();
        this.i = (l) this.a;
        return this;
    }

    private h(l lVar, Resources resources) {
        this.e = new Rect();
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.d = 0;
        this.y = IPictureView.DEFAULT_MIN_SCALE;
        this.i = new l(lVar, this, resources);
        this.a = this.i;
        if (this.i.a > 0) {
            a();
        }
        if (resources != null) {
            this.y = resources.getDisplayMetrics().density;
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        super.a(1);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (this.y != displayMetrics.density) {
            this.y = displayMetrics.density;
            invalidateSelf();
        }
    }

    final /* synthetic */ c a(c cVar, Resources resources) {
        return new l(cVar, this, resources);
    }
}
