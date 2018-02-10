package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;

/* compiled from: ProGuard */
public enum s implements b {
    HoverOn,
    HoverOff;
    
    public static final int d = 0;
    public final int c;

    static {
        d = (1 << (s.class.getFields().length - 1)) - 1;
    }

    public final int a() {
        return this.c;
    }
}
