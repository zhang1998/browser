package com.uc.weex.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.taobao.weex.bridge.c;
import java.util.HashMap;

/* compiled from: ProGuard */
final class k implements SensorEventListener {
    final /* synthetic */ l a;
    private float[] b = new float[3];
    private float[] c = new float[3];
    private float[] d = new float[3];
    private c e;
    private int f;
    private double g;
    private long h;

    k(l lVar, c cVar, int i, double d) {
        this.a = lVar;
        lVar.j.add(this);
        this.e = cVar;
        this.f = i;
        this.g = d;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            System.arraycopy(sensorEvent.values, 0, this.d, 0, this.d.length);
        } else if (sensorEvent.sensor.getType() == 2) {
            System.arraycopy(sensorEvent.values, 0, this.c, 0, this.c.length);
        } else if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.b, 0, this.b.length);
        }
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (((double) (currentTimeMillis - this.h)) >= this.g) {
                this.h = currentTimeMillis;
                float[] fArr = new float[3];
                float[] fArr2 = new float[9];
                SensorManager.getRotationMatrix(fArr2, null, this.b, this.c);
                SensorManager.getOrientation(fArr2, fArr);
                SensorManager.getOrientation(fArr2, fArr);
                double d = -Math.toDegrees((double) fArr[0]);
                while (d < 0.0d) {
                    d = 360.0d + d;
                }
                double toDegrees = Math.toDegrees((double) fArr[2]);
                if (toDegrees > 90.0d) {
                    toDegrees -= 180.0d;
                } else if (toDegrees < -90.0d) {
                    toDegrees += 180.0d;
                }
                if (d != 0.0d || toDegrees != 0.0d) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("alpha", Double.valueOf(d));
                    hashMap.put("beta", Float.valueOf(-this.d[1]));
                    hashMap.put("gamma", Double.valueOf(toDegrees));
                    this.e.b(hashMap);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
