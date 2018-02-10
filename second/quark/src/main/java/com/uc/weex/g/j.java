package com.uc.weex.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.taobao.weex.bridge.c;
import java.util.HashMap;

/* compiled from: ProGuard */
final class j implements SensorEventListener {
    final /* synthetic */ l a;
    private float[] b = new float[]{0.0f, 0.0f, 0.0f};
    private float[] c = new float[]{0.0f, 0.0f, 0.0f};
    private float[] d = new float[]{0.0f, 0.0f, 0.0f};
    private c e;
    private int f;
    private double g;
    private long h;

    j(l lVar, c cVar, int i, double d) {
        this.a = lVar;
        lVar.k.add(this);
        this.e = cVar;
        this.f = i;
        this.g = d;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 1:
                a(sensorEvent.values, this.b);
                break;
            case 4:
                a(sensorEvent.values, this.d);
                break;
            case 10:
                a(sensorEvent.values, this.c);
                break;
        }
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (((double) (currentTimeMillis - this.h)) >= this.g) {
                this.h = currentTimeMillis;
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("alpha", Float.valueOf(this.c[0]));
                hashMap2.put("beta", Float.valueOf(this.c[1]));
                hashMap2.put("gamma", Float.valueOf(this.c[2]));
                hashMap.put("acceleration", hashMap2);
                hashMap2 = new HashMap();
                hashMap2.put("alpha", Float.valueOf(this.b[0]));
                hashMap2.put("beta", Float.valueOf(this.b[1]));
                hashMap2.put("gamma", Float.valueOf(this.b[2]));
                hashMap.put("accelerationIncludingGravity", hashMap2);
                hashMap2 = new HashMap();
                hashMap2.put("alpha", Float.valueOf(this.d[0]));
                hashMap2.put("beta", Float.valueOf(this.d[1]));
                hashMap2.put("gamma", Float.valueOf(this.d[2]));
                hashMap.put("rotationRate", hashMap2);
                this.e.b(hashMap);
            }
        }
    }

    private static void a(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr, 0, fArr2, 0, 3);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
