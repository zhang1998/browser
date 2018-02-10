package com.uc.weex.component.h;

import com.taobao.weex.ui.component.ab;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class v {
    public static double a(String str) {
        double d = 0.0d;
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (Exception e) {
            }
        }
        return d;
    }

    public static float b(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = Float.parseFloat(str);
            } catch (Exception e) {
            }
        }
        return f;
    }

    static float[] a(float f, float f2, float f3, float f4, float f5, float f6, float f7, String str) {
        x xVar = new x();
        x a = xVar.a(IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
        a.c += f;
        a.f += f2;
        a.a(f5, f6, f7).a(f3, f4);
        xVar = new p(xVar, str).a;
        return new float[]{xVar.a, xVar.b, xVar.d, xVar.e, xVar.c, xVar.f};
    }

    public static boolean a(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            if (Double.isNaN(d) && Double.isNaN(d2)) {
                return true;
            }
            return false;
        } else if (Math.abs(d2 - d) >= 9.999999747378752E-6d) {
            return false;
        } else {
            return true;
        }
    }

    protected static r a(ab abVar) {
        ab parent = abVar.getParent();
        while (!(parent instanceof r)) {
            if (parent == null) {
                return null;
            }
            parent = parent.getParent();
        }
        return (r) parent;
    }
}
