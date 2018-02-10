package com.ucpro.feature.video;

import com.ucpro.feature.video.player.a.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class h {
    private static Map<String, b> a = new HashMap();

    public static void a(String str, b bVar) {
        a.put(str, bVar);
    }

    public static b a(String str) {
        return (b) a.get(str);
    }
}
