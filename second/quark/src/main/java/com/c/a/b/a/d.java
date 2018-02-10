package com.c.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.c.a.ac;
import com.c.a.e.b;
import com.c.a.e.f;

/* compiled from: ProGuard */
public class d extends l implements SensorEventListener {
    private int b;
    private float[] c = new float[16];
    private float[] d = new float[16];
    private boolean e = false;
    private Boolean f = null;
    private final Object g = new Object();
    private Activity h;
    private Runnable i = new g(this);

    public d(a aVar) {
        super(aVar);
    }

    public final void a(Context context) {
        if (!this.e) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(11);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                Log.e("MotionStrategy", "TYPE_ROTATION_VECTOR sensor not support!");
                return;
            }
            sensorManager.registerListener(this, defaultSensor, this.a.a, b.a);
            sensorManager.registerListener(this, defaultSensor2, 3);
            this.e = true;
        }
    }

    public final void b(Context context) {
        c(context);
    }

    public boolean a(int i, int i2) {
        return false;
    }

    public final void a(Activity activity) {
        this.h = activity;
        this.b = activity.getWindowManager().getDefaultDisplay().getRotation();
        for (ac b : a()) {
            b.b();
        }
    }

    public final void b(Activity activity) {
        c((Context) activity);
    }

    public final boolean c(Activity activity) {
        if (this.f == null) {
            this.f = Boolean.valueOf(((SensorManager) activity.getSystemService("sensor")).getDefaultSensor(11) != null);
        }
        return this.f.booleanValue();
    }

    private void c(Context context) {
        if (this.e) {
            ((SensorManager) context.getSystemService("sensor")).unregisterListener(this);
            this.e = false;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.a.b != null) {
            this.a.b.onSensorChanged(sensorEvent);
        }
        switch (sensorEvent.sensor.getType()) {
            case 11:
                if (this.h != null) {
                    this.b = this.h.getWindowManager().getDefaultDisplay().getRotation();
                }
                f.a(sensorEvent, this.b, this.c);
                synchronized (this.g) {
                    System.arraycopy(this.c, 0, this.d, 0, 16);
                }
                this.a.d.a(this.i);
                return;
            default:
                return;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if (this.a.b != null) {
            this.a.b.onAccuracyChanged(sensor, i);
        }
    }
}
