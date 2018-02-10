package com.taobao.android.binding.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Handler;
import android.os.HandlerThread;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: ProGuard */
final class cl implements SensorEventListener {
    private static cl j;
    private static final Object k = new Object();
    private static final Set<Integer> l = dz.a(Integer.valueOf(15));
    private static final Set<Integer> m = dz.a(Integer.valueOf(11));
    private static final Set<Integer> n = dz.a(Integer.valueOf(1), Integer.valueOf(2));
    ArrayList<ck> a = new ArrayList();
    private HandlerThread b;
    private Handler c;
    private final Context d;
    private float[] e;
    private float[] f;
    private float[] g;
    private double[] h;
    private co i;
    private final Set<Integer> o = new HashSet();
    private final List<Set<Integer>> p;
    private Set<Integer> q;
    private boolean r;
    private boolean s;
    private boolean t;

    private cl(@NonNull Context context) {
        this.d = context.getApplicationContext();
        Set[] setArr = new Set[]{l, m, n};
        Object arrayList = new ArrayList(3);
        Collections.addAll(arrayList, setArr);
        this.p = arrayList;
    }

    static cl a(Context context) {
        cl clVar;
        synchronized (k) {
            if (j == null) {
                j = new cl(context);
            }
            clVar = j;
        }
        return clVar;
    }

    final boolean a(@Nullable ck ckVar) {
        if (this.a == null) {
            return false;
        }
        if (ckVar != null) {
            return this.a.remove(ckVar);
        }
        this.a.clear();
        return true;
    }

    private String c() {
        if (this.t) {
            return "NOT_AVAILABLE";
        }
        if (this.q == l) {
            return "GAME_ROTATION_VECTOR";
        }
        if (this.q == m) {
            return "ROTATION_VECTOR";
        }
        if (this.q == n) {
            return "ACCELEROMETER_MAGNETIC";
        }
        return "NOT_AVAILABLE";
    }

    public final boolean a() {
        boolean z;
        if (i.c()) {
            WXLogUtils.d("ExpressionBinding", "[OrientationDetector] sensor started");
        }
        if (this.t) {
            z = false;
        } else if (this.q != null) {
            if (i.c()) {
                WXLogUtils.d("ExpressionBinding", "[OrientationDetector] register sensor:" + c());
            }
            z = a(this.q);
        } else {
            if (this.g == null) {
                this.g = new float[9];
            }
            if (this.h == null) {
                this.h = new double[3];
            }
            if (this.f == null) {
                this.f = new float[4];
            }
            for (Set set : this.p) {
                this.q = set;
                if (a(this.q)) {
                    if (i.c()) {
                        WXLogUtils.d("ExpressionBinding", "[OrientationDetector] register sensor:" + c());
                    }
                    z = true;
                }
            }
            this.t = true;
            this.q = null;
            this.g = null;
            this.h = null;
            z = false;
        }
        if (z) {
            a(true);
        }
        return z;
    }

    final void b() {
        if (i.c()) {
            WXLogUtils.d("ExpressionBinding", "[OrientationDetector] sensor stopped");
        }
        a(new HashSet(this.o));
        a(false);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        Object obj = sensorEvent.values;
        switch (type) {
            case 1:
                if (this.s) {
                    float[] fArr = this.e;
                    if (obj != null && fArr != null && SensorManager.getRotationMatrix(this.g, null, obj, fArr)) {
                        a(this.g, this.h);
                        a(Math.toDegrees(this.h[0]), Math.toDegrees(this.h[1]), Math.toDegrees(this.h[2]));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (this.s) {
                    if (this.e == null) {
                        this.e = new float[3];
                    }
                    System.arraycopy(obj, 0, this.e, 0, this.e.length);
                    return;
                }
                return;
            case 11:
                if (this.r && this.q == m) {
                    b(obj, this.h);
                    a(this.h[0], this.h[1], this.h[2]);
                    return;
                }
                return;
            case 15:
                if (this.r) {
                    b(obj, this.h);
                    a(this.h[0], this.h[1], this.h[2]);
                    return;
                }
                return;
            default:
                WXLogUtils.e("ExpressionBinding", "unexpected sensor type:" + type);
                return;
        }
    }

    private static double[] a(float[] fArr, double[] dArr) {
        if (fArr.length == 9) {
            if (fArr[8] > 0.0f) {
                dArr[0] = Math.atan2((double) (-fArr[1]), (double) fArr[4]);
                dArr[1] = Math.asin((double) fArr[7]);
                dArr[2] = Math.atan2((double) (-fArr[6]), (double) fArr[8]);
            } else if (fArr[8] < 0.0f) {
                dArr[0] = Math.atan2((double) fArr[1], (double) (-fArr[4]));
                dArr[1] = -Math.asin((double) fArr[7]);
                dArr[1] = (dArr[1] >= 0.0d ? -3.141592653589793d : 3.141592653589793d) + dArr[1];
                dArr[2] = Math.atan2((double) fArr[6], (double) (-fArr[8]));
            } else if (fArr[6] > 0.0f) {
                dArr[0] = Math.atan2((double) (-fArr[1]), (double) fArr[4]);
                dArr[1] = Math.asin((double) fArr[7]);
                dArr[2] = -1.5707963267948966d;
            } else if (fArr[6] < 0.0f) {
                dArr[0] = Math.atan2((double) fArr[1], (double) (-fArr[4]));
                dArr[1] = -Math.asin((double) fArr[7]);
                dArr[1] = (dArr[1] >= 0.0d ? -3.141592653589793d : 3.141592653589793d) + dArr[1];
                dArr[2] = -1.5707963267948966d;
            } else {
                dArr[0] = Math.atan2((double) fArr[3], (double) fArr[0]);
                dArr[1] = fArr[7] > 0.0f ? 1.5707963267948966d : -1.5707963267948966d;
                dArr[2] = 0.0d;
            }
            if (dArr[0] < 0.0d) {
                dArr[0] = dArr[0] + 6.283185307179586d;
            }
        }
        return dArr;
    }

    private void b(float[] fArr, double[] dArr) {
        int i = 0;
        if (fArr.length > 4) {
            System.arraycopy(fArr, 0, this.f, 0, 4);
            SensorManager.getRotationMatrixFromVector(this.g, this.f);
        } else {
            SensorManager.getRotationMatrixFromVector(this.g, fArr);
        }
        a(this.g, dArr);
        while (i < 3) {
            dArr[i] = Math.toDegrees(dArr[i]);
            i++;
        }
    }

    private co d() {
        if (this.i != null) {
            return this.i;
        }
        SensorManager sensorManager = (SensorManager) this.d.getSystemService("sensor");
        if (sensorManager != null) {
            this.i = new cp(sensorManager);
        }
        return this.i;
    }

    private void a(boolean z) {
        this.r = z;
        boolean z2 = z && this.q == n;
        this.s = z2;
    }

    private boolean a(Set<Integer> set) {
        Iterable<Integer> hashSet = new HashSet(set);
        hashSet.removeAll(this.o);
        if (hashSet.isEmpty()) {
            return true;
        }
        boolean z = false;
        for (Integer num : hashSet) {
            boolean z2;
            int intValue = num.intValue();
            co d = d();
            if (d == null) {
                z2 = false;
            } else {
                if (this.c == null) {
                    this.b = new HandlerThread("DeviceOrientation");
                    this.b.start();
                    this.c = new Handler(this.b.getLooper());
                }
                z2 = d.a(this, intValue, 1, this.c);
            }
            if (z2) {
                boolean z3;
                if (z2) {
                    this.o.add(num);
                    z3 = true;
                } else {
                    z3 = z;
                }
                z = z3;
            } else {
                a((Iterable) hashSet);
                return false;
            }
        }
        return z;
    }

    private void a(Iterable<Integer> iterable) {
        for (Integer num : iterable) {
            if (this.o.contains(num)) {
                d().a(this, num.intValue());
                this.o.remove(num);
            }
        }
    }

    private void a(double d, double d2, double d3) {
        if (this.a != null) {
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((ck) it.next()).a(d, d2, d3);
                }
            } catch (Throwable th) {
                WXLogUtils.e("ExpressionBinding", "[OrientationDetector] " + th.getMessage());
            }
        }
    }
}
