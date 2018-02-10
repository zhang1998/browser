package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;

/* compiled from: ProGuard */
public enum l implements b {
    Idle,
    LightChange,
    VolumeChange,
    SeekChange;
    
    public static final int f = 0;
    public final int e;

    static {
        f = (1 << (r.class.getFields().length - 1)) - 1;
    }

    public final int a() {
        return this.e;
    }
}
