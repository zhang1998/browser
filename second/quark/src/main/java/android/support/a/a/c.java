package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.b.a.q;
import android.support.v4.content.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import java.io.IOException;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* compiled from: ProGuard */
public final class c extends j {
    static final Mode a = Mode.SRC_IN;
    d b;
    boolean c;
    private PorterDuffColorFilter e;
    private ColorFilter f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private c() {
        this.c = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = new d();
    }

    private c(@NonNull d dVar) {
        this.c = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = dVar;
        this.e = a(dVar.c, dVar.d);
    }

    public final Drawable mutate() {
        if (this.d != null) {
            this.d.mutate();
        } else if (!this.g && super.mutate() == this) {
            this.b = new d(this.b);
            this.g = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.d != null) {
            return new l(this.d.getConstantState());
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
        r11 = this;
        r10 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = 0;
        r4 = 1;
        r5 = 0;
        r0 = r11.d;
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r11.d;
        r0.draw(r12);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r11.k;
        r11.copyBounds(r0);
        r0 = r11.k;
        r0 = r0.width();
        if (r0 <= 0) goto L_0x0010;
    L_0x001e:
        r0 = r11.k;
        r0 = r0.height();
        if (r0 <= 0) goto L_0x0010;
    L_0x0026:
        r0 = r11.f;
        if (r0 != 0) goto L_0x00e0;
    L_0x002a:
        r0 = r11.e;
    L_0x002c:
        r1 = r11.j;
        r12.getMatrix(r1);
        r1 = r11.j;
        r3 = r11.i;
        r1.getValues(r3);
        r1 = r11.i;
        r1 = r1[r5];
        r3 = java.lang.Math.abs(r1);
        r1 = r11.i;
        r6 = 4;
        r1 = r1[r6];
        r1 = java.lang.Math.abs(r1);
        r6 = r11.i;
        r6 = r6[r4];
        r6 = java.lang.Math.abs(r6);
        r7 = r11.i;
        r8 = 3;
        r7 = r7[r8];
        r7 = java.lang.Math.abs(r7);
        r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
        if (r6 != 0) goto L_0x0062;
    L_0x005e:
        r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r6 == 0) goto L_0x014a;
    L_0x0062:
        r1 = r2;
    L_0x0063:
        r3 = r11.k;
        r3 = r3.width();
        r3 = (float) r3;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r11.k;
        r3 = r3.height();
        r3 = (float) r3;
        r1 = r1 * r3;
        r1 = (int) r1;
        r2 = java.lang.Math.min(r10, r2);
        r3 = java.lang.Math.min(r10, r1);
        if (r2 <= 0) goto L_0x0010;
    L_0x007f:
        if (r3 <= 0) goto L_0x0010;
    L_0x0081:
        r6 = r12.save();
        r1 = r11.k;
        r1 = r1.left;
        r1 = (float) r1;
        r7 = r11.k;
        r7 = r7.top;
        r7 = (float) r7;
        r12.translate(r1, r7);
        r1 = r11.k;
        r1.offsetTo(r5, r5);
        r7 = r11.b;
        r1 = r7.f;
        if (r1 == 0) goto L_0x00b0;
    L_0x009d:
        r1 = r7.f;
        r1 = r1.getWidth();
        if (r2 != r1) goto L_0x00e4;
    L_0x00a5:
        r1 = r7.f;
        r1 = r1.getHeight();
        if (r3 != r1) goto L_0x00e4;
    L_0x00ad:
        r1 = r4;
    L_0x00ae:
        if (r1 != 0) goto L_0x00ba;
    L_0x00b0:
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r1 = android.graphics.Bitmap.createBitmap(r2, r3, r1);
        r7.f = r1;
        r7.k = r4;
    L_0x00ba:
        r1 = r11.c;
        if (r1 != 0) goto L_0x00e6;
    L_0x00be:
        r1 = r11.b;
        r1.a(r2, r3);
    L_0x00c3:
        r2 = r11.b;
        r3 = r11.k;
        r1 = r2.b;
        r1 = r1.g;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r1 >= r7) goto L_0x0127;
    L_0x00cf:
        r1 = r4;
    L_0x00d0:
        if (r1 != 0) goto L_0x0129;
    L_0x00d2:
        if (r0 != 0) goto L_0x0129;
    L_0x00d4:
        r0 = 0;
    L_0x00d5:
        r1 = r2.f;
        r2 = 0;
        r12.drawBitmap(r1, r2, r3, r0);
        r12.restoreToCount(r6);
        goto L_0x0010;
    L_0x00e0:
        r0 = r11.f;
        goto L_0x002c;
    L_0x00e4:
        r1 = r5;
        goto L_0x00ae;
    L_0x00e6:
        r1 = r11.b;
        r7 = r1.k;
        if (r7 != 0) goto L_0x0125;
    L_0x00ec:
        r7 = r1.g;
        r8 = r1.c;
        if (r7 != r8) goto L_0x0125;
    L_0x00f2:
        r7 = r1.h;
        r8 = r1.d;
        if (r7 != r8) goto L_0x0125;
    L_0x00f8:
        r7 = r1.j;
        r8 = r1.e;
        if (r7 != r8) goto L_0x0125;
    L_0x00fe:
        r7 = r1.i;
        r1 = r1.b;
        r1 = r1.g;
        if (r7 != r1) goto L_0x0125;
    L_0x0106:
        r1 = r4;
    L_0x0107:
        if (r1 != 0) goto L_0x00c3;
    L_0x0109:
        r1 = r11.b;
        r1.a(r2, r3);
        r1 = r11.b;
        r2 = r1.c;
        r1.g = r2;
        r2 = r1.d;
        r1.h = r2;
        r2 = r1.b;
        r2 = r2.g;
        r1.i = r2;
        r2 = r1.e;
        r1.j = r2;
        r1.k = r5;
        goto L_0x00c3;
    L_0x0125:
        r1 = r5;
        goto L_0x0107;
    L_0x0127:
        r1 = r5;
        goto L_0x00d0;
    L_0x0129:
        r1 = r2.l;
        if (r1 != 0) goto L_0x0139;
    L_0x012d:
        r1 = new android.graphics.Paint;
        r1.<init>();
        r2.l = r1;
        r1 = r2.l;
        r1.setFilterBitmap(r4);
    L_0x0139:
        r1 = r2.l;
        r4 = r2.b;
        r4 = r4.g;
        r1.setAlpha(r4);
        r1 = r2.l;
        r1.setColorFilter(r0);
        r0 = r2.l;
        goto L_0x00d5;
    L_0x014a:
        r2 = r3;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.c.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.d != null) {
            return q.c(this.d);
        }
        return this.b.b.g;
    }

    public final void setAlpha(int i) {
        if (this.d != null) {
            this.d.setAlpha(i);
        } else if (this.b.b.g != i) {
            this.b.b.g = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.d != null) {
            this.d.setColorFilter(colorFilter);
            return;
        }
        this.f = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.d != null) {
            q.a(this.d, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.d != null) {
            q.a(this.d, colorStateList);
            return;
        }
        d dVar = this.b;
        if (dVar.c != colorStateList) {
            dVar.c = colorStateList;
            this.e = a(colorStateList, dVar.d);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.d != null) {
            q.a(this.d, mode);
            return;
        }
        d dVar = this.b;
        if (dVar.d != mode) {
            dVar.d = mode;
            this.e = a(dVar.c, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.d != null) {
            return this.d.isStateful();
        }
        return super.isStateful() || !(this.b == null || this.b.c == null || !this.b.c.isStateful());
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.d != null) {
            return this.d.setState(iArr);
        }
        d dVar = this.b;
        if (dVar.c == null || dVar.d == null) {
            return false;
        }
        this.e = a(dVar.c, dVar.d);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.d != null) {
            return this.d.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.d != null) {
            return this.d.getIntrinsicWidth();
        }
        return (int) this.b.b.c;
    }

    public final int getIntrinsicHeight() {
        if (this.d != null) {
            return this.d.getIntrinsicHeight();
        }
        return (int) this.b.b.d;
    }

    public final boolean canApplyTheme() {
        if (this.d != null) {
            q.d(this.d);
        }
        return false;
    }

    @Nullable
    public static c a(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            c cVar = new c();
            cVar.d = a.a(resources, i, theme);
            cVar.h = new l(cVar.d.getConstantState());
            return cVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static c a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c();
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.d != null) {
            this.d.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.d != null) {
            q.a(this.d, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        d dVar = this.b;
        dVar.b = new e();
        TypedArray a = j.a(resources, theme, attributeSet, n.a);
        d dVar2 = this.b;
        e eVar = dVar2.b;
        int a2 = i.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        dVar2.d = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            dVar2.c = colorStateList;
        }
        boolean z = dVar2.e;
        if (i.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        dVar2.e = z;
        eVar.e = i.a(a, xmlPullParser, "viewportWidth", 7, eVar.e);
        eVar.f = i.a(a, xmlPullParser, "viewportHeight", 8, eVar.f);
        if (eVar.e <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.f <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.c = a.getDimension(3, eVar.c);
            eVar.d = a.getDimension(2, eVar.d);
            if (eVar.c <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.d <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.g = (int) (i.a(a, xmlPullParser, "alpha", 4, ((float) eVar.g) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.h = string;
                    eVar.i.put(string, eVar);
                }
                a.recycle();
                dVar.a = getChangingConfigurations();
                dVar.k = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.e = a(dVar.c, dVar.d);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        d dVar = this.b;
        e eVar = dVar.b;
        Object obj = 1;
        Stack stack = new Stack();
        stack.push(eVar.b);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                g gVar = (g) stack.peek();
                if ("path".equals(name)) {
                    k fVar = new f();
                    TypedArray a = j.a(resources, theme, attributeSet, n.c);
                    fVar.a(a, xmlPullParser);
                    a.recycle();
                    gVar.b.add(fVar);
                    if (fVar.n != null) {
                        eVar.i.put(fVar.n, fVar);
                    }
                    obj2 = null;
                    dVar.a = fVar.o | dVar.a;
                } else if ("clip-path".equals(name)) {
                    k mVar = new m();
                    if (i.a(xmlPullParser, "pathData")) {
                        r8 = j.a(resources, theme, attributeSet, n.d);
                        mVar.a(r8);
                        r8.recycle();
                    }
                    gVar.b.add(mVar);
                    if (mVar.n != null) {
                        eVar.i.put(mVar.n, mVar);
                    }
                    dVar.a |= mVar.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        g gVar2 = new g();
                        r8 = j.a(resources, theme, attributeSet, n.b);
                        gVar2.l = null;
                        gVar2.c = i.a(r8, xmlPullParser, "rotation", 5, gVar2.c);
                        gVar2.d = r8.getFloat(1, gVar2.d);
                        gVar2.e = r8.getFloat(2, gVar2.e);
                        gVar2.f = i.a(r8, xmlPullParser, Style.WX_SCALE_X, 3, gVar2.f);
                        gVar2.g = i.a(r8, xmlPullParser, Style.WX_SCALE_Y, 4, gVar2.g);
                        gVar2.h = i.a(r8, xmlPullParser, Style.WX_TRANSLATE_X, 6, gVar2.h);
                        gVar2.i = i.a(r8, xmlPullParser, Style.WX_TRANSLATE_Y, 7, gVar2.i);
                        String string = r8.getString(0);
                        if (string != null) {
                            gVar2.m = string;
                        }
                        gVar2.j.reset();
                        gVar2.j.postTranslate(-gVar2.d, -gVar2.e);
                        gVar2.j.postScale(gVar2.f, gVar2.g);
                        gVar2.j.postRotate(gVar2.c, 0.0f, 0.0f);
                        gVar2.j.postTranslate(gVar2.h + gVar2.d, gVar2.i + gVar2.e);
                        r8.recycle();
                        gVar.b.add(gVar2);
                        stack.push(gVar2);
                        if (gVar2.m != null) {
                            eVar.i.put(gVar2.m, gVar2);
                        }
                        dVar.a |= gVar2.k;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                obj2 = obj;
            }
            obj = obj2;
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.d != null) {
            return this.d.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.d != null) {
            this.d.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.d != null) {
            this.d.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.d != null) {
            return this.d.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.d != null) {
            this.d.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
