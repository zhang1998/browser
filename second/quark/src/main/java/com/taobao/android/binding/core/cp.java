package com.taobao.android.binding.core;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.taobao.weex.utils.WXLogUtils;
import java.util.List;

/* compiled from: ProGuard */
final class cp implements co {
    private final SensorManager a;

    cp(SensorManager sensorManager) {
        this.a = sensorManager;
    }

    public final boolean a(SensorEventListener sensorEventListener, int i, int i2, Handler handler) {
        List sensorList = this.a.getSensorList(i);
        if (sensorList.isEmpty()) {
            return false;
        }
        return this.a.registerListener(sensorEventListener, (Sensor) sensorList.get(0), 1, handler);
    }

    public final void a(SensorEventListener sensorEventListener, int i) {
        List sensorList = this.a.getSensorList(i);
        if (!sensorList.isEmpty()) {
            try {
                this.a.unregisterListener(sensorEventListener, (Sensor) sensorList.get(0));
            } catch (Throwable th) {
                WXLogUtils.w("ExpressionBinding", "Failed to unregister device sensor " + ((Sensor) sensorList.get(0)).getName());
            }
        }
    }
}
