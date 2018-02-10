package com.uc.weex.component.h;

import android.graphics.Path;
import android.graphics.RectF;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.v;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import java.util.ArrayList;
import java.util.regex.Matcher;

/* compiled from: ProGuard */
public class q extends b {
    private int n;

    public q(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "d")
    public void setShapePath(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (this.n != hashCode) {
                try {
                    j oVar = new o();
                    if (str != null) {
                        Matcher matcher = j.a.matcher(str);
                        ArrayList arrayList = new ArrayList();
                        while (matcher.find()) {
                            arrayList.add(matcher.group());
                        }
                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                        char c = '\u0000';
                        int i = 1;
                        char charAt = strArr[0].charAt(0);
                        while (true) {
                            int i2;
                            int i3;
                            int i4;
                            int i5;
                            int i6;
                            int i7;
                            double a;
                            double a2;
                            double doubleValue;
                            double doubleValue2;
                            switch (charAt) {
                                case 'A':
                                    oVar.a(v.a(strArr[i + 5]), v.a(strArr[i + 6]), v.a(strArr[i]), v.a(strArr[i + 1]), j.b(strArr[i + 3]), !j.b(strArr[i + 4]), strArr[i + 2]);
                                    i += 7;
                                    break;
                                case 'C':
                                    i2 = i + 1;
                                    i3 = i2 + 1;
                                    i4 = i3 + 1;
                                    i5 = i4 + 1;
                                    i6 = i5 + 1;
                                    i = i6 + 1;
                                    oVar.b(v.a(strArr[i]), v.a(strArr[i2]), j.a(strArr[i3]), j.a(strArr[i4]), j.a(strArr[i5]), j.a(strArr[i6]));
                                    break;
                                case 'H':
                                    i7 = i + 1;
                                    oVar.b(v.a(strArr[i]), oVar.c);
                                    i = i7;
                                    break;
                                case 'L':
                                    i7 = i + 1;
                                    i = i7 + 1;
                                    oVar.b(v.a(strArr[i]), v.a(strArr[i7]));
                                    break;
                                case 'M':
                                    i7 = i + 1;
                                    a = v.a(strArr[i]);
                                    i = i7 + 1;
                                    a2 = v.a(strArr[i7]);
                                    oVar.b = a;
                                    oVar.d = a;
                                    oVar.c = a2;
                                    oVar.e = a2;
                                    oVar.c(a, a2);
                                    break;
                                case 'Q':
                                    i2 = i + 1;
                                    i3 = i2 + 1;
                                    i4 = i3 + 1;
                                    i = i4 + 1;
                                    oVar.b(v.a(strArr[i]), v.a(strArr[i2]), j.a(strArr[i3]), j.a(strArr[i4]), null, null);
                                    break;
                                case 'S':
                                    i2 = i + 1;
                                    i5 = i2 + 1;
                                    i6 = i5 + 1;
                                    i = i6 + 1;
                                    oVar.b(v.a(strArr[i]), v.a(strArr[i2]), null, null, j.a(strArr[i5]), j.a(strArr[i6]));
                                    break;
                                case 'T':
                                    i2 = i + 1;
                                    i = i2 + 1;
                                    oVar.b(v.a(strArr[i]), v.a(strArr[i2]), null, null, null, null);
                                    break;
                                case 'V':
                                    i7 = i + 1;
                                    oVar.b(oVar.b, v.a(strArr[i]));
                                    i = i7;
                                    break;
                                case 'Z':
                                case 'z':
                                    if (oVar.f != null) {
                                        a2 = oVar.b;
                                        a = oVar.c;
                                        doubleValue = oVar.f.doubleValue();
                                        oVar.b = doubleValue;
                                        doubleValue2 = oVar.g.doubleValue();
                                        oVar.c = doubleValue2;
                                        oVar.b(a2, a, doubleValue, doubleValue2);
                                        oVar.f = null;
                                        break;
                                    }
                                    break;
                                case 'a':
                                    boolean z;
                                    a2 = v.a(strArr[i + 5]);
                                    a = v.a(strArr[i + 6]);
                                    doubleValue = v.a(strArr[i]);
                                    doubleValue2 = v.a(strArr[i + 1]);
                                    boolean b = j.b(strArr[i + 3]);
                                    if (j.b(strArr[i + 4])) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    oVar.a(a2 + oVar.b, a + oVar.c, doubleValue, doubleValue2, b, z, strArr[i + 2]);
                                    i += 7;
                                    break;
                                case 'c':
                                    i2 = i + 1;
                                    i3 = i2 + 1;
                                    i4 = i3 + 1;
                                    i5 = i4 + 1;
                                    i6 = i5 + 1;
                                    i = i6 + 1;
                                    oVar.a(v.a(strArr[i]), v.a(strArr[i2]), j.a(strArr[i3]), j.a(strArr[i4]), j.a(strArr[i5]), j.a(strArr[i6]));
                                    break;
                                case 'h':
                                    i7 = i + 1;
                                    oVar.a(v.a(strArr[i]), 0.0d);
                                    i = i7;
                                    break;
                                case 'l':
                                    i7 = i + 1;
                                    i = i7 + 1;
                                    oVar.a(v.a(strArr[i]), v.a(strArr[i7]));
                                    break;
                                case 'm':
                                    i7 = i + 1;
                                    a = v.a(strArr[i]);
                                    i = i7 + 1;
                                    a2 = v.a(strArr[i7]);
                                    a += oVar.b;
                                    oVar.b = a;
                                    oVar.d = a;
                                    a2 += oVar.c;
                                    oVar.c = a2;
                                    oVar.e = a2;
                                    oVar.c(a, a2);
                                    break;
                                case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
                                    i2 = i + 1;
                                    i3 = i2 + 1;
                                    i4 = i3 + 1;
                                    i = i4 + 1;
                                    oVar.a(v.a(strArr[i]), v.a(strArr[i2]), j.a(strArr[i3]), j.a(strArr[i4]), null, null);
                                    break;
                                case 's':
                                    i2 = i + 1;
                                    i5 = i2 + 1;
                                    i6 = i5 + 1;
                                    i = i6 + 1;
                                    oVar.a(v.a(strArr[i]), v.a(strArr[i2]), null, null, j.a(strArr[i5]), j.a(strArr[i6]));
                                    break;
                                case 't':
                                    i2 = i + 1;
                                    i = i2 + 1;
                                    oVar.a(v.a(strArr[i]), v.a(strArr[i2]), null, null, null, null);
                                    break;
                                case 'v':
                                    i7 = i + 1;
                                    oVar.a(0.0d, v.a(strArr[i]));
                                    i = i7;
                                    break;
                                default:
                                    i--;
                                    charAt = c;
                                    continue;
                            }
                            if (i < strArr.length) {
                                if (charAt == 'm') {
                                    c = 'l';
                                } else if (charAt == 'M') {
                                    c = 'L';
                                } else {
                                    c = charAt;
                                }
                                i++;
                                charAt = strArr[i].charAt(0);
                            }
                        }
                    }
                    n nVar = oVar.h;
                    int i8 = nVar.a;
                    Object obj = new float[i8];
                    System.arraycopy(nVar.b, 0, obj, 0, i8);
                    this.l = a(obj);
                    this.n = hashCode;
                } catch (Exception e) {
                }
            }
        }
    }

    private Path a(float[] fArr) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f = this.b.b;
        int i = 0;
        while (i < fArr.length) {
            int i2 = i + 1;
            int i3;
            switch ((int) fArr[i]) {
                case 0:
                    i3 = i2 + 1;
                    i = i3 + 1;
                    path.moveTo(fArr[i2] * f, fArr[i3] * f);
                    continue;
                case 1:
                    path.close();
                    i = i2;
                    continue;
                case 2:
                    i3 = i2 + 1;
                    i = i3 + 1;
                    path.lineTo(fArr[i2] * f, fArr[i3] * f);
                    continue;
                case 3:
                    i3 = i2 + 1;
                    int i4 = i3 + 1;
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    path.cubicTo(fArr[i2] * f, fArr[i3] * f, fArr[i4] * f, fArr[i5] * f, fArr[i6] * f, fArr[i7] * f);
                    i = i8;
                    continue;
                case 4:
                    i = i2 + 1;
                    float f2 = fArr[i2] * f;
                    i2 = i + 1;
                    float f3 = fArr[i] * f;
                    i = i2 + 1;
                    float f4 = fArr[i2] * f;
                    i2 = i + 1;
                    float toDegrees = (float) Math.toDegrees((double) fArr[i]);
                    i3 = i2 + 1;
                    float toDegrees2 = (float) Math.toDegrees((double) fArr[i2]);
                    i2 = i3 + 1;
                    if ((fArr[i3] == 0.0f ? 1 : null) == null) {
                        toDegrees2 = 360.0f - toDegrees2;
                    }
                    path.addArc(new RectF(f2 - f4, f3 - f4, f2 + f4, f3 + f4), toDegrees, toDegrees - toDegrees2);
                    break;
            }
            i = i2;
        }
        return path;
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        String a = v.a(getDomObject().i());
        if (a != null) {
            Object obj2;
            if (getDomObject().i().get("d") != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                setShapePath(a);
            }
        }
    }
}
