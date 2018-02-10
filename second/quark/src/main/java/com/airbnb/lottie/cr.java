package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.uc.imagecodec.export.IPictureView;
import java.util.List;

/* compiled from: ProGuard */
final class cr implements bo, bq {
    private final Path a = new Path();
    private final cu b;
    private final b c;
    private final bl<?, Float> d;
    private final bl<?, PointF> e;
    private final bl<?, Float> f;
    @Nullable
    private final bl<?, Float> g;
    private final bl<?, Float> h;
    @Nullable
    private final bl<?, Float> i;
    private final bl<?, Float> j;
    @Nullable
    private bu k;
    private boolean l;

    cr(cu cuVar, cz czVar, ce ceVar) {
        this.b = cuVar;
        this.c = ceVar.a;
        this.d = ceVar.b.b();
        this.e = ceVar.c.a();
        this.f = ceVar.d.b();
        this.h = ceVar.f.b();
        this.j = ceVar.h.b();
        if (this.c == b.Star) {
            this.g = ceVar.e.b();
            this.i = ceVar.g.b();
        } else {
            this.g = null;
            this.i = null;
        }
        czVar.a(this.d);
        czVar.a(this.e);
        czVar.a(this.f);
        czVar.a(this.h);
        czVar.a(this.j);
        if (this.c == b.Star) {
            czVar.a(this.g);
            czVar.a(this.i);
        }
        this.d.a((bq) this);
        this.e.a((bq) this);
        this.f.a((bq) this);
        this.h.a((bq) this);
        this.j.a((bq) this);
        if (this.c == b.Star) {
            this.h.a((bq) this);
            this.j.a((bq) this);
        }
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < list.size(); i++) {
            de deVar = (de) list.get(i);
            if ((deVar instanceof bu) && ((bu) deVar).a == o.a) {
                this.k = (bu) deVar;
                this.k.a(this);
            }
        }
    }

    public final Path b() {
        if (this.l) {
            return this.a;
        }
        this.a.reset();
        float floatValue;
        double d;
        float floatValue2;
        float f;
        float f2;
        float cos;
        float sin;
        float f3;
        float cos2;
        float f4;
        PointF pointF;
        switch (d.a[this.c.ordinal()]) {
            case 1:
                double d2;
                float floatValue3;
                float f5;
                floatValue = ((Float) this.d.a()).floatValue();
                if (this.f == null) {
                    d = 0.0d;
                } else {
                    d = (double) ((Float) this.f.a()).floatValue();
                }
                d = Math.toRadians(d - 90.0d);
                float f6 = (float) (6.283185307179586d / ((double) floatValue));
                float f7 = f6 / 2.0f;
                float f8 = floatValue - ((float) ((int) floatValue));
                if (f8 != 0.0f) {
                    d2 = d + ((double) ((IPictureView.DEFAULT_MIN_SCALE - f8) * f7));
                } else {
                    d2 = d;
                }
                float floatValue4 = ((Float) this.h.a()).floatValue();
                floatValue2 = ((Float) this.g.a()).floatValue();
                if (this.i != null) {
                    floatValue3 = ((Float) this.i.a()).floatValue() / 100.0f;
                } else {
                    floatValue3 = 0.0f;
                }
                f = 0.0f;
                if (this.j != null) {
                    f = ((Float) this.j.a()).floatValue() / 100.0f;
                }
                if (f8 != 0.0f) {
                    f2 = ((floatValue4 - floatValue2) * f8) + floatValue2;
                    cos = (float) (((double) f2) * Math.cos(d2));
                    sin = (float) (((double) f2) * Math.sin(d2));
                    this.a.moveTo(cos, sin);
                    d2 += (double) ((f6 * f8) / 2.0f);
                    f5 = f2;
                    f2 = sin;
                    sin = cos;
                } else {
                    cos = (float) (((double) floatValue4) * Math.cos(d2));
                    sin = (float) (((double) floatValue4) * Math.sin(d2));
                    this.a.moveTo(cos, sin);
                    d2 += (double) f7;
                    f5 = 0.0f;
                    f2 = sin;
                    sin = cos;
                }
                double ceil = Math.ceil((double) floatValue) * 2.0d;
                int i = 0;
                Object obj = null;
                float f9 = f2;
                float f10 = sin;
                double d3 = d2;
                while (((double) i) < ceil) {
                    Object obj2;
                    if (obj != null) {
                        f2 = floatValue4;
                    } else {
                        f2 = floatValue2;
                    }
                    if (f5 == 0.0f || ((double) i) != ceil - 2.0d) {
                        f3 = f7;
                    } else {
                        f3 = (f6 * f8) / 2.0f;
                    }
                    if (f5 != 0.0f && ((double) i) == ceil - 1.0d) {
                        f2 = f5;
                    }
                    cos2 = (float) (((double) f2) * Math.cos(d3));
                    floatValue = (float) (((double) f2) * Math.sin(d3));
                    if (floatValue3 == 0.0f && f == 0.0f) {
                        this.a.lineTo(cos2, floatValue);
                    } else {
                        f2 = (float) (Math.atan2((double) f9, (double) f10) - 1.5707963267948966d);
                        sin = (float) Math.cos((double) f2);
                        float sin2 = (float) Math.sin((double) f2);
                        f2 = (float) (Math.atan2((double) floatValue, (double) cos2) - 1.5707963267948966d);
                        float cos3 = (float) Math.cos((double) f2);
                        float sin3 = (float) Math.sin((double) f2);
                        float f11 = obj != null ? floatValue3 : f;
                        if (obj != null) {
                            cos = f;
                        } else {
                            cos = floatValue3;
                        }
                        if (obj != null) {
                            f2 = floatValue2;
                        } else {
                            f2 = floatValue4;
                        }
                        if (obj != null) {
                            f4 = floatValue4;
                        } else {
                            f4 = floatValue2;
                        }
                        sin *= (f2 * f11) * 0.47829f;
                        f11 = ((f2 * f11) * 0.47829f) * sin2;
                        f2 = ((f4 * cos) * 0.47829f) * cos3;
                        f4 = ((f4 * cos) * 0.47829f) * sin3;
                        if (f8 != 0.0f) {
                            if (i == 0) {
                                sin *= f8;
                                cos = f4;
                                f4 = f11 * f8;
                                f11 = f2;
                            } else if (((double) i) == ceil - 1.0d) {
                                cos = f4 * f8;
                                f4 = f11;
                                f11 = f2 * f8;
                            }
                            this.a.cubicTo(f10 - sin, f9 - f4, f11 + cos2, cos + floatValue, cos2, floatValue);
                        }
                        cos = f4;
                        f4 = f11;
                        f11 = f2;
                        this.a.cubicTo(f10 - sin, f9 - f4, f11 + cos2, cos + floatValue, cos2, floatValue);
                    }
                    d2 = d3 + ((double) f3);
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    i++;
                    obj = obj2;
                    f9 = floatValue;
                    f10 = cos2;
                    d3 = d2;
                }
                pointF = (PointF) this.e.a();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                break;
            case 2:
                int floor = (int) Math.floor((double) ((Float) this.d.a()).floatValue());
                if (this.f == null) {
                    d = 0.0d;
                } else {
                    d = (double) ((Float) this.f.a()).floatValue();
                }
                double toRadians = Math.toRadians(d - 90.0d);
                floatValue2 = (float) (6.283185307179586d / ((double) floor));
                f = ((Float) this.j.a()).floatValue() / 100.0f;
                f3 = ((Float) this.h.a()).floatValue();
                cos2 = (float) (((double) f3) * Math.cos(toRadians));
                floatValue = (float) (((double) f3) * Math.sin(toRadians));
                this.a.moveTo(cos2, floatValue);
                d = ((double) floatValue2) + toRadians;
                double ceil2 = Math.ceil((double) floor);
                toRadians = d;
                int i2 = 0;
                f4 = floatValue;
                sin = cos2;
                while (((double) i2) < ceil2) {
                    cos2 = (float) (((double) f3) * Math.cos(toRadians));
                    floatValue = (float) (((double) f3) * Math.sin(toRadians));
                    if (f != 0.0f) {
                        f2 = (float) (Math.atan2((double) f4, (double) sin) - 1.5707963267948966d);
                        cos = (float) (Math.atan2((double) floatValue, (double) cos2) - 1.5707963267948966d);
                        this.a.cubicTo(sin - (((float) Math.cos((double) f2)) * ((f3 * f) * 0.25f)), f4 - (((f3 * f) * 0.25f) * ((float) Math.sin((double) f2))), cos2 + (((float) Math.cos((double) cos)) * ((f3 * f) * 0.25f)), (((float) Math.sin((double) cos)) * ((f3 * f) * 0.25f)) + floatValue, cos2, floatValue);
                    } else {
                        this.a.lineTo(cos2, floatValue);
                    }
                    toRadians = ((double) floatValue2) + toRadians;
                    i2++;
                    f4 = floatValue;
                    sin = cos2;
                }
                pointF = (PointF) this.e.a();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                break;
        }
        this.a.close();
        dn.a(this.a, this.k);
        this.l = true;
        return this.a;
    }

    public final void a() {
        this.l = false;
        this.b.invalidateSelf();
    }
}
