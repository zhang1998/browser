package com.uc.apollo.rebound;

import com.uc.apollo.annotation.KeepForRuntime;

/* compiled from: ProGuard */
public class SpringConfig {
    public static SpringConfig c = fromOrigamiTensionAndFriction(40.0d, 7.0d);
    public double a;
    public double b;

    private SpringConfig(double d, double d2) {
        this.b = d;
        this.a = d2;
    }

    @KeepForRuntime
    public static SpringConfig fromOrigamiTensionAndFriction(double d, double d2) {
        double d3 = 0.0d;
        double d4 = d == 0.0d ? 0.0d : ((d - 30.0d) * 3.62d) + 194.0d;
        if (d2 != 0.0d) {
            d3 = ((d2 - 8.0d) * 3.0d) + 25.0d;
        }
        return new SpringConfig(d4, d3);
    }
}
