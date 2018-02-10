package com.alibaba.fastjson.b;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
final class c implements u {
    private final Class<?> a;
    private final u b;

    c(Class<?> cls, u uVar) {
        this.a = cls;
        this.b = uVar;
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        int i = 0;
        aa aaVar = oVar.b;
        if (obj == null) {
            if ((aaVar.c & z.WriteNullListAsEmpty.x) != 0) {
                aaVar.write("[]");
            } else {
                aaVar.write("null");
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            aaVar.write(91);
            for (r0 = 0; r0 < zArr.length; r0++) {
                String str;
                if (r0 != 0) {
                    aaVar.write(44);
                }
                if (zArr[r0]) {
                    str = "true";
                } else {
                    str = "false";
                }
                aaVar.write(str);
            }
            aaVar.write(93);
        } else if (obj instanceof byte[]) {
            aaVar.a((byte[]) obj);
        } else if (obj instanceof char[]) {
            aaVar.a(new String((char[]) obj));
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            r0 = dArr.length - 1;
            if (r0 == -1) {
                aaVar.a((CharSequence) "[]");
                return;
            }
            aaVar.write(91);
            while (i < r0) {
                double d = dArr[i];
                if (Double.isNaN(d)) {
                    aaVar.write("null");
                } else {
                    aaVar.a(Double.toString(d));
                }
                aaVar.write(44);
                i++;
            }
            double d2 = dArr[r0];
            if (Double.isNaN(d2)) {
                aaVar.write("null");
            } else {
                aaVar.a(Double.toString(d2));
            }
            aaVar.write(93);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            r0 = fArr.length - 1;
            if (r0 == -1) {
                aaVar.a((CharSequence) "[]");
                return;
            }
            aaVar.write(91);
            while (i < r0) {
                float f = fArr[i];
                if (Float.isNaN(f)) {
                    aaVar.write("null");
                } else {
                    aaVar.a(Float.toString(f));
                }
                aaVar.write(44);
                i++;
            }
            float f2 = fArr[r0];
            if (Float.isNaN(f2)) {
                aaVar.write("null");
            } else {
                aaVar.a(Float.toString(f2));
            }
            aaVar.write(93);
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            aaVar.write(91);
            while (i < iArr.length) {
                if (i != 0) {
                    aaVar.write(44);
                }
                aaVar.b(iArr[i]);
                i++;
            }
            aaVar.write(93);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            aaVar.write(91);
            while (i < jArr.length) {
                if (i != 0) {
                    aaVar.write(44);
                }
                aaVar.a(jArr[i]);
                i++;
            }
            aaVar.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            aaVar.write(91);
            while (i < sArr.length) {
                if (i != 0) {
                    aaVar.write(44);
                }
                aaVar.b(sArr[i]);
                i++;
            }
            aaVar.write(93);
        } else {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            x xVar = oVar.j;
            oVar.a(xVar, obj, obj2);
            try {
                aaVar.write(91);
                while (i < length) {
                    if (i != 0) {
                        aaVar.write(44);
                    }
                    Object obj3 = objArr[i];
                    if (obj3 == null) {
                        aaVar.a((CharSequence) "null");
                    } else if (obj3.getClass() == this.a) {
                        this.b.a(oVar, obj3, Integer.valueOf(i), null);
                    } else {
                        oVar.a.a(obj3.getClass()).a(oVar, obj3, Integer.valueOf(i), null);
                    }
                    i++;
                }
                aaVar.write(93);
            } finally {
                oVar.j = xVar;
            }
        }
    }
}
