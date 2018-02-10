package com.c.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.b.a.a.a.a.a;
import com.c.a.ac;
import com.c.a.e.b;

/* compiled from: ProGuard */
public final class c extends l implements SensorEventListener {
    private int b;
    private float[] c = new float[16];
    private float[] d = new float[16];
    private float[] e = new float[16];
    private float[] f = new float[16];
    private boolean g = false;
    private Boolean h = null;
    private final com.b.a.a.a.a.c i = new com.b.a.a.a.a.c();
    private a j = new a();
    private long k;
    private final a l = new a();
    private final a m = new a();
    private h n = new h();
    private Activity o;
    private Runnable p = new b(this);

    public c(a aVar) {
        super(aVar);
    }

    public final void a(Context context) {
        if (!this.g) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
            if (defaultSensor == null && defaultSensor2 == null) {
                Log.e("CardboardMotionStrategy", "TYPE_ACCELEROMETER TYPE_GYROSCOPE sensor not support!");
                return;
            }
            sensorManager.registerListener(this, defaultSensor, this.a.a, b.a);
            sensorManager.registerListener(this, defaultSensor2, this.a.a, b.a);
            this.g = true;
        }
    }

    public final void b(Context context) {
        c(context);
    }

    public final boolean a(int i, int i2) {
        int a = this.n.a(i, i2);
        for (ac acVar : a()) {
            acVar.a(acVar.h - ((((float) a) / h.a) * 0.2f));
        }
        return false;
    }

    public final void a(Activity activity) {
        this.b = activity.getWindowManager().getDefaultDisplay().getRotation();
        this.o = activity;
        for (ac b : a()) {
            b.b();
        }
    }

    public final void b(Activity activity) {
        c((Context) activity);
    }

    public final boolean c(Activity activity) {
        if (this.h == null) {
            SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
            boolean z = (sensorManager.getDefaultSensor(1) == null && sensorManager.getDefaultSensor(4) == null) ? false : true;
            this.h = Boolean.valueOf(z);
        }
        return this.h.booleanValue();
    }

    private void c(Context context) {
        if (this.g) {
            ((SensorManager) context.getSystemService("sensor")).unregisterListener(this);
            this.g = false;
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.n.a(sensorEvent);
        if (this.a.b != null) {
            this.a.b.onSensorChanged(sensorEvent);
        }
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.o != null) {
                this.b = this.o.getWindowManager().getDefaultDisplay().getRotation();
            }
            synchronized (this.i) {
                this.j.a((double) sensorEvent.values[0], (double) sensorEvent.values[1], (double) sensorEvent.values[2]);
                com.b.a.a.a.a.c cVar = this.i;
                a aVar = this.j;
                long j = sensorEvent.timestamp;
                cVar.a(aVar);
            }
        } else if (type == 4) {
            synchronized (this.i) {
                this.k = System.nanoTime();
                this.m.a((double) sensorEvent.values[0], (double) sensorEvent.values[1], (double) sensorEvent.values[2]);
                a.a(this.m, this.l, this.m);
                this.i.a(this.m, sensorEvent.timestamp);
            }
        }
        this.a.d.a(this.p);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
        if (this.a.b != null) {
            this.a.b.onAccuracyChanged(sensor, i);
        }
    }
}
