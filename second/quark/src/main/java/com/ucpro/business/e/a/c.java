package com.ucpro.business.e.a;

import com.ucpro.business.e.d.g;
import com.ucpro.feature.video.cache.c.a;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class c {
    private static boolean a = false;

    @DebugLog
    public static void a() {
        if (!a) {
            a a = a.a();
            a.a("cp_set_param", new d());
            a.a("sl_uc_param", g.a());
            a.a("video_download_black_list", new a());
            a = true;
        }
    }
}
