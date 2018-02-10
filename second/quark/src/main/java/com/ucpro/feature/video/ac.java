package com.ucpro.feature.video;

import com.ucpro.feature.video.player.a.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class ac {
    private static ac b;
    public List<g> a = new ArrayList();

    private ac() {
    }

    public static ac a() {
        if (b == null) {
            b = new ac();
        }
        return b;
    }
}
