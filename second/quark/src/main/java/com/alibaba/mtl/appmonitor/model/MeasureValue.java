package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class MeasureValue implements Parcelable, a {
    public static final Creator<MeasureValue> CREATOR = new a();
    public boolean a;
    public Double b;
    public double c;
    private List<g> d;

    public final synchronized void a(MeasureValue measureValue) {
        if (measureValue != null) {
            try {
                this.c += measureValue.c;
                if (measureValue.b != null) {
                    if (this.b == null) {
                        this.b = Double.valueOf(0.0d);
                    }
                    this.b = Double.valueOf(this.b.doubleValue() + measureValue.b.doubleValue());
                }
                g a = a(measureValue.c);
                if (a != null) {
                    a.a();
                }
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void a() {
        this.c = 0.0d;
        this.b = null;
        this.a = false;
        this.d = null;
    }

    public final synchronized void a(Object... objArr) {
        if (objArr != null) {
            if (objArr.length > 0) {
                this.c = ((Double) objArr[0]).doubleValue();
            }
            if (objArr.length > 1) {
                this.b = (Double) objArr[1];
                this.a = false;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.a ? 1 : 0);
            parcel.writeDouble(this.b == null ? 0.0d : this.b.doubleValue());
            parcel.writeDouble(this.c);
        } catch (Throwable th) {
        }
    }

    static MeasureValue a(Parcel parcel) {
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            MeasureValue measureValue = (MeasureValue) b.a().a(MeasureValue.class, new Object[0]);
            try {
                measureValue.a = z;
                measureValue.b = valueOf;
                measureValue.c = readDouble;
                return measureValue;
            } catch (Throwable th) {
                return measureValue;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public final synchronized Map<String, Double> b() {
        Map<String, Double> map;
        if (this.d == null) {
            map = null;
        } else {
            Map<String, Double> hashMap = new HashMap();
            for (g gVar : this.d) {
                if (gVar.c > 0) {
                    Object obj;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (gVar.a == null) {
                        obj = "-∞";
                    } else {
                        obj = gVar.a;
                    }
                    stringBuilder = stringBuilder.append(obj).append(",");
                    if (gVar.b == null) {
                        obj = "∞";
                    } else {
                        obj = gVar.b;
                    }
                    hashMap.put(stringBuilder.append(obj).toString(), Long.valueOf(gVar.c));
                }
            }
            map = hashMap;
        }
        return map;
    }

    protected final synchronized void a(Measure measure) {
        List list = measure.c;
        if (list != null && list.size() >= 2) {
            if (this.d == null) {
                this.d = new ArrayList();
                for (int i = 0; i + 1 < list.size(); i++) {
                    this.d.add(new g(this, (Double) list.get(i), (Double) list.get(i + 1)));
                }
                g a = a(this.c);
                if (a != null) {
                    a.a();
                }
            }
        }
    }

    private g a(double d) {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                Object obj;
                g gVar = (g) this.d.get(i);
                Double valueOf = Double.valueOf(d);
                if (valueOf != null) {
                    Double d2 = gVar.a;
                    Double d3 = gVar.b;
                    if (d2 == null) {
                        d2 = Double.valueOf(Double.MIN_VALUE);
                    }
                    if (d3 == null) {
                        d3 = Double.valueOf(Double.MAX_VALUE);
                    }
                    if (valueOf.doubleValue() >= d2.doubleValue() && valueOf.doubleValue() < r0.doubleValue()) {
                        obj = 1;
                        if (obj != null) {
                            return (g) this.d.get(i);
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    return (g) this.d.get(i);
                }
            }
        }
        return null;
    }
}
