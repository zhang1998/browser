package com.ucpro.feature.video;

import android.content.Context;
import com.uc.apollo.impl.SettingsConst;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.uc.media.interfaces.IApolloHelper.Global;
import com.ucpro.business.stat.m;
import com.ucpro.feature.video.b.c;
import com.ucpro.feature.video.f.a;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public final class e {
    public static void a() {
        String a = com.ucpro.feature.video.b.e.a(a.APOLLO);
        m.a("apolloso", "so_use_v", SettingsConst.FALSE, a);
    }

    public static void a(Context context) {
        String a = com.ucpro.feature.video.b.e.a(a.APOLLO);
        if (f.d() && a.equals("2.11.0.250")) {
            com.ucweb.common.util.h.m.a(0, new aq());
            c.c = 0;
            Global.setApolloSoPath(ContextUtils.getDataDir(context.getApplicationContext()) + Global.getLibsPath(0));
            com.ucpro.model.a.a("last_check_video_so_second", -1);
        }
    }
}
