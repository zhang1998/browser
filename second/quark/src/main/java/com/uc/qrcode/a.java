package com.uc.qrcode;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.uc.qrcode.a.c;

/* compiled from: ProGuard */
final class a implements SensorEventListener {
    final Context a;
    c b;
    Sensor c;

    a(Context context) {
        this.a = context;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.b == null) {
            return;
        }
        if (f <= 45.0f) {
            this.b.a(true);
        } else if (f >= 450.0f) {
            this.b.a(false);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
