package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;

/* compiled from: ProGuard */
public enum r implements b {
    Prepare,
    Paused,
    Playing,
    Completed;
    
    public static final int f = 0;
    public final int e;

    static {
        f = (1 << (r.class.getFields().length - 1)) - 1;
    }

    public final int a() {
        return this.e;
    }
}
