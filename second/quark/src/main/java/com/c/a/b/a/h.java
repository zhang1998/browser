package com.c.a.b.a;

import android.content.res.Resources;
import android.hardware.SensorEvent;

/* compiled from: ProGuard */
public final class h {
    public static final float a = Resources.getSystem().getDisplayMetrics().density;
    protected boolean b = false;
    protected boolean c = false;

    public final void a(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i = -1;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                i = 90 - Math.round(((float) Math.atan2((double) (-f2), (double) f)) * 57.29578f);
                while (i >= 360) {
                    i -= 360;
                }
                while (i < 0) {
                    i += 360;
                }
            }
            if (i > 45 && i < 135) {
                this.b = false;
                this.c = false;
            } else if (i > 134 && i < 226) {
                this.b = true;
                this.c = false;
            } else if (i > 225 && i < 315) {
                this.b = false;
                this.c = true;
            } else if ((i > 315 && i < 360) || (i > 0 && i < 45)) {
                this.b = true;
                this.c = true;
            }
        }
    }

    public final int a(int i, int i2) {
        if (!this.b) {
            return !this.c ? -i : i;
        } else {
            if (this.c) {
                return -i2;
            }
            return i2;
        }
    }
}
