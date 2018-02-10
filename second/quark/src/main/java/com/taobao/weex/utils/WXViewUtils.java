package com.taobao.weex.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.b.o;
import com.taobao.weex.common.t;
import com.taobao.weex.i;
import com.taobao.weex.ui.view.border.b;
import com.uc.imagecodec.export.IPictureView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class WXViewUtils {
    public static boolean a = true;
    private static final AtomicInteger b = new AtomicInteger(1);
    private static int c;
    private static int d;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface Opacity {
    }

    @SuppressLint({"NewApi"})
    public static int a() {
        if (VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        int i;
        int i2;
        do {
            i = b.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!b.compareAndSet(i, i2));
        return i;
    }

    public static int a(String str) {
        ac b = ad.a().b(str);
        if (b == null) {
            return -3;
        }
        int c = b.c();
        if (c >= 0 || c == -2) {
            return c;
        }
        return c(i.e);
    }

    public static int b(String str) {
        ac b = ad.a().b(str);
        if (b == null) {
            return -3;
        }
        int i;
        if (b.f == null) {
            i = 0;
        } else {
            i = b.f.getWidth();
        }
        if (i >= 0 || i == -2) {
            return i;
        }
        return b(i.e);
    }

    @Deprecated
    public static int b() {
        return b(i.e);
    }

    public static float a(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDisplayMetrics().density;
            } catch (Exception e) {
                WXLogUtils.e("getScreenDensityDpi exception:" + e.getMessage());
            }
        }
        return IPictureView.DEFAULT_MAX_SCALE;
    }

    public static int b(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            c = resources.getDisplayMetrics().widthPixels;
            if (i.k) {
                int i = resources.getDisplayMetrics().heightPixels;
                d = i;
                c = i > c ? c : d;
            }
        } else if (i.c()) {
            throw new t("Error Context is null When getScreenHeight");
        }
        return c;
    }

    public static int c(Context context) {
        if (context != null) {
            d = context.getResources().getDisplayMetrics().heightPixels;
        } else if (i.c()) {
            throw new t("Error Context is null When getScreenHeight");
        }
        return d;
    }

    @Deprecated
    public static float a(float f) {
        return a(f, 750);
    }

    public static float a(float f, int i) {
        if (Float.isNaN(f)) {
            return f;
        }
        if (a) {
            return d(f);
        }
        float b = (((float) b(i.e)) * f) / ((float) i);
        return (((double) b) <= 0.005d || b >= IPictureView.DEFAULT_MIN_SCALE) ? (float) Math.rint((double) b) : IPictureView.DEFAULT_MIN_SCALE;
    }

    public static double a(double d, int i) {
        if (Double.isNaN(d)) {
            return d;
        }
        if (a) {
            return d * ((double) i.e().getResources().getDisplayMetrics().density);
        }
        double b = (((double) b(i.e)) * d) / ((double) i);
        return (b <= 0.005d || b >= 1.0d) ? (double) ((float) Math.rint(b)) : 1.0d;
    }

    public static float b(float f, int i) {
        if (Float.isNaN(f)) {
            return f;
        }
        if (a) {
            return d(f);
        }
        f = (((float) b(i.e)) * f) / ((float) i);
        return (((double) f) <= 0.005d || f >= IPictureView.DEFAULT_MIN_SCALE) ? f : IPictureView.DEFAULT_MIN_SCALE;
    }

    @Deprecated
    public static float c(float f) {
        return c(f, 750);
    }

    public static float c(float f, int i) {
        if (((double) f) < -1.9999d && ((double) f) > -2.005d) {
            return Float.NaN;
        }
        if (a) {
            return e(f);
        }
        float b = (((float) i) * f) / ((float) b(i.e));
        if (((double) b) <= 0.005d || b >= IPictureView.DEFAULT_MIN_SCALE) {
            return b;
        }
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public static double b(double d, int i) {
        if (d < -1.9999d && d > -2.005d) {
            return Double.NaN;
        }
        if (a) {
            return d / ((double) i.e().getResources().getDisplayMetrics().density);
        }
        double b = (((double) i) * d) / ((double) b(i.e));
        if (b <= 0.005d || b >= 1.0d) {
            return b;
        }
        return 1.0d;
    }

    public static float d(float f) {
        return i.e().getResources().getDisplayMetrics().density * f;
    }

    public static float e(float f) {
        return f / i.e().getResources().getDisplayMetrics().density;
    }

    public static int f(float f) {
        float f2;
        try {
            f2 = i.e().getResources().getDisplayMetrics().density;
        } catch (Throwable e) {
            WXLogUtils.e("[WXViewUtils] dip2px:", e);
            f2 = 2.0f;
        }
        f2 = (f2 * f) + 0.5f;
        return (f2 <= 0.0f || f2 >= IPictureView.DEFAULT_MIN_SCALE) ? (int) f2 : 1;
    }

    public static boolean a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        LayoutParams layoutParams = view.getLayoutParams();
        int i;
        if (layoutParams != null) {
            i = layoutParams.height;
        } else {
            i = view.getHeight();
        }
        if ((iArr[1] <= 0 || iArr[1] - c(i.e) >= 0) && (r0 + iArr[1] <= 0 || iArr[1] > 0)) {
            return false;
        }
        return true;
    }

    public static int a(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (((((i2 >> 7) + i2) * (i >>> 24)) >> 8) << 24) | (i & 16777215);
    }

    public static int a(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        if (i2 == 0) {
            return -2;
        }
        return -3;
    }

    public static void a(View view, Drawable drawable) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @Nullable
    public static b b(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof b) {
            return (b) background;
        }
        if ((background instanceof LayerDrawable) && ((LayerDrawable) background).getNumberOfLayers() > 1) {
            background = ((LayerDrawable) background).getDrawable(0);
            if (background instanceof b) {
                return (b) background;
            }
        }
        return null;
    }

    public static void a(View view, Canvas canvas) {
        int i;
        if (VERSION.SDK_INT >= 18 || !canvas.isHardwareAccelerated()) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            if (VERSION.SDK_INT != 24) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                Drawable background = view.getBackground();
                if (background instanceof b) {
                    int i2;
                    b bVar = (b) background;
                    if (bVar.a == null || (o.a(b.a(bVar.a, 0), 0.0f) && o.a(b.a(bVar.a, 1), 0.0f) && o.a(b.a(bVar.a, 2), 0.0f) && o.a(b.a(bVar.a, 3), 0.0f))) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int childCount = viewGroup.getChildCount();
                            for (int i3 = 0; i3 < childCount; i3++) {
                                View childAt = viewGroup.getChildAt(i3);
                                if (childAt.getBackground() instanceof b) {
                                    int i4;
                                    if (((b) childAt.getBackground()).d != null) {
                                        i4 = 1;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (i4 != 0 && VERSION.SDK_INT < 21) {
                                        i2 = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        i2 = 1;
                        if (i2 != 0) {
                            RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
                            Path path = new Path();
                            bVar.a(rectF, path);
                            canvas.clipPath(path);
                        }
                    }
                }
            }
        }
    }

    @Deprecated
    public static float b(float f) {
        int i = 1;
        float d;
        if (a) {
            d = d(f);
            if (((double) d) <= 0.005d || d >= IPictureView.DEFAULT_MIN_SCALE) {
                i = ((int) d) - 1;
            }
        } else {
            d = (((float) b(i.e)) * f) / 750.0f;
            if (((double) d) <= 0.005d || d >= IPictureView.DEFAULT_MIN_SCALE) {
                i = ((int) d) - 1;
            }
        }
        return (float) i;
    }
}
