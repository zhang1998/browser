package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;

/* compiled from: ProGuard */
public enum y implements b {
    Idle,
    Requesting,
    RequestFail,
    RequestSuccess;
    
    public static final int f = 0;
    public final int e;

    static {
        f = (1 << (r.class.getFields().length - 1)) - 1;
    }

    public final int a() {
        return this.e;
    }
}
