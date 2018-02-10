package com.tencent.wxop.stat;

public enum o {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int h;

    private o(int i) {
        this.h = i;
    }

    public static o a(int i) {
        for (o oVar : values()) {
            if (i == oVar.h) {
                return oVar;
            }
        }
        return null;
    }
}
