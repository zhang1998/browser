package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* compiled from: ProGuard */
public final class t implements e, u {
    public static final t a = new t();
    private DecimalFormat b = null;

    private t() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if (obj == null) {
            if ((aaVar.c & z.WriteNullNumberAsZero.x) != 0) {
                aaVar.write(48);
            } else {
                aaVar.write("null");
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                aaVar.write("null");
            } else if (Float.isInfinite(floatValue)) {
                aaVar.write("null");
            } else {
                String f = Float.toString(floatValue);
                if (f.endsWith(".0")) {
                    f = f.substring(0, f.length() - 2);
                }
                aaVar.write(f);
                if ((aaVar.c & z.WriteClassName.x) != 0) {
                    aaVar.write(70);
                }
            }
        } else {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                aaVar.write("null");
            } else if (Double.isInfinite(doubleValue)) {
                aaVar.write("null");
            } else {
                CharSequence d;
                if (this.b == null) {
                    d = Double.toString(doubleValue);
                    if (d.endsWith(".0")) {
                        d = d.substring(0, d.length() - 2);
                    }
                } else {
                    d = this.b.format(doubleValue);
                }
                aaVar.a(d);
                if ((aaVar.c & z.WriteClassName.x) != 0) {
                    aaVar.write(68);
                }
            }
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        int a = iVar.a();
        String f;
        if (a == 2) {
            if (type == Double.TYPE || type == Double.class) {
                f = iVar.f();
                iVar.a(16);
                return Double.valueOf(Double.parseDouble(f));
            } else if (type == Float.TYPE || type == Float.class) {
                f = iVar.f();
                iVar.a(16);
                return Float.valueOf(Float.parseFloat(f));
            } else {
                long w = iVar.w();
                iVar.a(16);
                if (type == Short.TYPE || type == Short.class) {
                    return Short.valueOf((short) ((int) w));
                }
                if (type == Byte.TYPE || type == Byte.class) {
                    return Byte.valueOf((byte) ((int) w));
                }
                if (w < -2147483648L || w > 2147483647L) {
                    return Long.valueOf(w);
                }
                return Integer.valueOf((int) w);
            }
        } else if (a != 3) {
            Object a2 = cVar.a(null);
            if (a2 == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return com.alibaba.fastjson.c.e.h(a2);
            }
            if (type == Float.TYPE || type == Float.class) {
                return com.alibaba.fastjson.c.e.g(a2);
            }
            if (type == Short.TYPE || type == Short.class) {
                return com.alibaba.fastjson.c.e.d(a2);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return com.alibaba.fastjson.c.e.b(a2);
            }
            return com.alibaba.fastjson.c.e.e(a2);
        } else if (type == Double.TYPE || type == Double.class) {
            f = iVar.f();
            iVar.a(16);
            return Double.valueOf(Double.parseDouble(f));
        } else if (type == Float.TYPE || type == Float.class) {
            f = iVar.f();
            iVar.a(16);
            return Float.valueOf(Float.parseFloat(f));
        } else {
            T x = iVar.x();
            iVar.a(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf(x.shortValue());
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf(x.byteValue());
            }
            return x;
        }
    }
}
