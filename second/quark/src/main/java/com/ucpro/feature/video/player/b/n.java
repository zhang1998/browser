package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;

/* compiled from: ProGuard */
public enum n implements b {
    None,
    PlayList,
    ResolutionList,
    CacheResolutionList,
    MoreList;
    
    public static final int g = 0;
    public final int f;

    static {
        g = (1 << (n.class.getFields().length - 1)) - 1;
    }

    public final int a() {
        return this.f;
    }
}
