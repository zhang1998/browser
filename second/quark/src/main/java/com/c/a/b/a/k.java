package com.c.a.b.a;

import android.hardware.SensorEvent;
import com.c.a.ac;

/* compiled from: ProGuard */
public final class k extends d {
    private h b = new h();

    public k(a aVar) {
        super(aVar);
    }

    public final boolean a(int i, int i2) {
        int a = this.b.a(i, i2);
        for (ac acVar : a()) {
            acVar.a(acVar.h - ((((float) a) / h.a) * 0.2f));
        }
        return false;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.b.a(sensorEvent);
        super.onSensorChanged(sensorEvent);
    }
}
