package com.taobao.weex.ui.view.border;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.taobao.weex.c.b.o;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: ProGuard */
public final class b extends Drawable {
    private static final e e = e.SOLID;
    @Nullable
    public SparseArray<Float> a;
    @Nullable
    public SparseArray<Float> b;
    public int c = 0;
    public Shader d = null;
    private final Paint f = new Paint(1);
    @Nullable
    private SparseArray<Float> g;
    @Nullable
    private SparseIntArray h;
    @Nullable
    private SparseIntArray i;
    @Nullable
    private Path j;
    private boolean k = false;
    private int l = 255;

    public final void draw(@NonNull Canvas canvas) {
        canvas.save();
        a();
        this.f.setAlpha(255);
        if (this.j != null) {
            int a = WXViewUtils.a(this.c, this.l);
            if (this.d != null) {
                this.f.setShader(this.d);
                this.f.setStyle(Style.FILL);
                canvas.drawPath(this.j, this.f);
                this.f.setShader(null);
            } else if ((a >>> 24) != 0) {
                this.f.setColor(a);
                this.f.setStyle(Style.FILL);
                canvas.drawPath(this.j, this.f);
                this.f.setShader(null);
            }
        }
        this.f.setStyle(Style.STROKE);
        this.f.setStrokeJoin(Join.ROUND);
        RectF rectF = new RectF(getBounds());
        a iVar = new i(a(this.b, 0), b(0), b(1), rectF);
        a jVar = new j(a(this.b, 1), b(1), b(2), rectF);
        a hVar = new h(a(this.b, 2), b(2), b(3), rectF);
        a gVar = new g(a(this.b, 3), b(3), b(0), rectF);
        a(canvas, new c(iVar, jVar, 1, b(1)));
        a(canvas, new c(jVar, hVar, 2, b(2)));
        a(canvas, new c(hVar, gVar, 3, b(3)));
        a(canvas, new c(gVar, iVar, 0, b(0)));
        this.f.setShader(null);
        canvas.restore();
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.k = true;
    }

    public final void setAlpha(int i) {
        if (i != this.l) {
            this.l = i;
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        return this.l;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        if (this.d != null) {
            return -1;
        }
        return WXViewUtils.a(WXViewUtils.a(this.c, this.l));
    }

    public final void getOutline(@NonNull Outline outline) {
        if (VERSION.SDK_INT >= 21) {
            if (this.j == null) {
                this.k = true;
            }
            a();
            outline.setConvexPath(this.j);
        }
    }

    public final void a(int i, float f) {
        if (this.g == null) {
            this.g = new SparseArray(5);
            this.g.put(8, Float.valueOf(0.0f));
        }
        if (!o.a(b(i), f)) {
            f.a(this.g, i, Float.valueOf(f), false);
            this.g.put(i, Float.valueOf(f));
            this.k = true;
            invalidateSelf();
        }
    }

    private float b(int i) {
        return ((Float) f.a(this.g, i, Float.valueOf(0.0f))).floatValue();
    }

    public final void b(int i, float f) {
        if (this.a == null) {
            this.a = new SparseArray(5);
            this.a.put(8, Float.valueOf(0.0f));
        }
        if (!o.a(a(this.a, i), f)) {
            f.a(this.a, i, Float.valueOf(f), true);
            this.k = true;
            invalidateSelf();
        }
    }

    public final void a(int i, int i2) {
        if (this.h == null) {
            this.h = new SparseIntArray(5);
            this.h.put(8, -16777216);
        }
        if (c(i) != i2) {
            f.b(this.h, i, i2);
            invalidateSelf();
        }
    }

    private int c(int i) {
        return f.a(this.h, i, -16777216);
    }

    public final void a(int i, @NonNull String str) {
        if (this.i == null) {
            this.i = new SparseIntArray(5);
            this.i.put(8, e.ordinal());
        }
        try {
            int ordinal = e.valueOf(str.toUpperCase(Locale.US)).ordinal();
            if (d(i) != ordinal) {
                f.b(this.i, i, ordinal);
                invalidateSelf();
            }
        } catch (Throwable e) {
            WXLogUtils.e("Border", WXLogUtils.getStackTrace(e));
        }
    }

    private int d(int i) {
        return f.a(this.i, i, e.SOLID.ordinal());
    }

    public final void a(int i) {
        this.c = i;
        invalidateSelf();
    }

    public final void a(Shader shader) {
        this.d = shader;
        invalidateSelf();
    }

    public static float a(@Nullable SparseArray<Float> sparseArray, int i) {
        return ((Float) f.a((SparseArray) sparseArray, i, Float.valueOf(0.0f))).floatValue();
    }

    private void a() {
        if (this.k) {
            this.k = false;
            if (this.j == null) {
                this.j = new Path();
            }
            this.j.reset();
            a(new RectF(getBounds()), this.j);
        }
    }

    public final void a(RectF rectF, Path path) {
        if (this.a != null) {
            a(rectF);
            float a = a(this.b, 0);
            float a2 = a(this.b, 1);
            float a3 = a(this.b, 2);
            float a4 = a(this.b, 3);
            path.addRoundRect(rectF, new float[]{a - 0.0f, a - 0.0f, a2 - 0.0f, a2 - 0.0f, a3 - 0.0f, a3 - 0.0f, a4 - 0.0f, a4 - 0.0f}, Direction.CW);
            return;
        }
        path.addRect(rectF, Direction.CW);
    }

    public final void a(@NonNull RectF rectF) {
        if (this.a != null) {
            float a = a(this.a, 0) + a(this.a, 1);
            float a2 = a(this.a, 1) + a(this.a, 2);
            float a3 = a(this.a, 2) + a(this.a, 3);
            float a4 = a(this.a, 3) + a(this.a, 0);
            Collection arrayList = new ArrayList(4);
            a(arrayList, rectF.width(), a);
            a(arrayList, rectF.height(), a2);
            a(arrayList, rectF.width(), a3);
            a(arrayList, rectF.height(), a4);
            if (arrayList.isEmpty()) {
                a = Float.NaN;
            } else {
                a = ((Float) Collections.min(arrayList)).floatValue();
            }
            if (this.b == null) {
                this.b = new SparseArray(5);
                this.b.put(8, Float.valueOf(0.0f));
            }
            if (Float.isNaN(a) || a >= IPictureView.DEFAULT_MIN_SCALE) {
                this.b.put(0, Float.valueOf(a(this.a, 0)));
                this.b.put(1, Float.valueOf(a(this.a, 1)));
                this.b.put(2, Float.valueOf(a(this.a, 2)));
                this.b.put(3, Float.valueOf(a(this.a, 3)));
                return;
            }
            this.b.put(0, Float.valueOf(a(this.a, 0) * a));
            this.b.put(1, Float.valueOf(a(this.a, 1) * a));
            this.b.put(2, Float.valueOf(a(this.a, 2) * a));
            this.b.put(3, Float.valueOf(a * a(this.a, 3)));
        }
    }

    private static void a(@NonNull List<Float> list, float f, float f2) {
        if (!o.a(f2, 0.0f)) {
            list.add(Float.valueOf(f / f2));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Canvas r11, @android.mini.support.annotation.NonNull com.taobao.weex.ui.view.border.c r12) {
        /*
        r10 = this;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = 1;
        r7 = 0;
        r6 = 2;
        r1 = 0;
        r0 = r12.a;
        r0 = r10.b(r0);
        r0 = com.taobao.weex.c.b.o.a(r1, r0);
        if (r0 != 0) goto L_0x004e;
    L_0x0012:
        r0 = r12.a;
        r2 = r10.b(r0);
        r3 = r10.c(r0);
        r4 = r10.l;
        r8 = com.taobao.weex.utils.WXViewUtils.a(r3, r4);
        r3 = com.taobao.weex.ui.view.border.e.values();
        r4 = r10.d(r0);
        r3 = r3[r4];
        r4 = com.taobao.weex.ui.view.border.d.a;
        r3 = r3.ordinal();
        r3 = r4[r3];
        switch(r3) {
            case 1: goto L_0x004f;
            case 2: goto L_0x0086;
            default: goto L_0x0037;
        };
    L_0x0037:
        r0 = 0;
    L_0x0038:
        r1 = r10.f;
        r1.setShader(r0);
        r0 = r10.f;
        r0.setColor(r8);
        r0 = r10.f;
        r1 = android.graphics.Paint.Cap.ROUND;
        r0.setStrokeCap(r1);
        r0 = r10.f;
        r12.a(r11, r0);
    L_0x004e:
        return;
    L_0x004f:
        if (r0 == 0) goto L_0x0053;
    L_0x0051:
        if (r0 != r6) goto L_0x006a;
    L_0x0053:
        r0 = new android.graphics.LinearGradient;
        r4 = r2 * r5;
        r5 = new int[r6];
        r5[r7] = r8;
        r5[r9] = r7;
        r6 = new float[r6];
        r6 = {1056964608, 1056964608};
        r7 = android.graphics.Shader.TileMode.REPEAT;
        r2 = r1;
        r3 = r1;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0038;
    L_0x006a:
        if (r0 == r9) goto L_0x006f;
    L_0x006c:
        r3 = 3;
        if (r0 != r3) goto L_0x0086;
    L_0x006f:
        r0 = new android.graphics.LinearGradient;
        r3 = r2 * r5;
        r5 = new int[r6];
        r5[r7] = r8;
        r5[r9] = r7;
        r6 = new float[r6];
        r6 = {1056964608, 1056964608};
        r7 = android.graphics.Shader.TileMode.REPEAT;
        r2 = r1;
        r4 = r1;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0038;
    L_0x0086:
        if (r0 == 0) goto L_0x008a;
    L_0x0088:
        if (r0 != r6) goto L_0x00a3;
    L_0x008a:
        r0 = new android.graphics.LinearGradient;
        r3 = 1086324736; // 0x40c00000 float:6.0 double:5.367157323E-315;
        r4 = r2 * r3;
        r5 = new int[r6];
        r5[r7] = r8;
        r5[r9] = r7;
        r6 = new float[r6];
        r6 = {1056964608, 1056964608};
        r7 = android.graphics.Shader.TileMode.REPEAT;
        r2 = r1;
        r3 = r1;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0038;
    L_0x00a3:
        if (r0 == r9) goto L_0x00a8;
    L_0x00a5:
        r3 = 3;
        if (r0 != r3) goto L_0x0037;
    L_0x00a8:
        r0 = new android.graphics.LinearGradient;
        r3 = 1086324736; // 0x40c00000 float:6.0 double:5.367157323E-315;
        r3 = r3 * r2;
        r5 = new int[r6];
        r5[r7] = r8;
        r5[r9] = r7;
        r6 = new float[r6];
        r6 = {1056964608, 1056964608};
        r7 = android.graphics.Shader.TileMode.REPEAT;
        r2 = r1;
        r4 = r1;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.view.border.b.a(android.graphics.Canvas, com.taobao.weex.ui.view.border.c):void");
    }
}
