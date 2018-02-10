package com.ucpro.feature.webwindow;

import android.content.Context;
import com.uc.base.jssdk.u;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.uc.media.interfaces.IApolloHelper.Global;
import com.ucpro.feature.video.b.c;
import com.ucpro.feature.video.e;
import com.ucpro.feature.webwindow.f.a.b;
import com.ucpro.model.a;
import java.io.File;

/* compiled from: ProGuard */
final class bq implements Runnable {
    final /* synthetic */ ax a;

    bq(ax axVar) {
        this.a = axVar;
    }

    public final void run() {
        Context a = this.a.b;
        c.c = a.e("567DE2436BE8422FCD6ED90184AC9F76");
        int e = a.e("2519247797BA400FFDE7E9EFE568F560");
        String dataDir = ContextUtils.getDataDir(a.getApplicationContext());
        if (c.c < 0) {
            c.c = 0;
            Global.setApolloSoPath(dataDir + Global.getLibsPath(0));
            e.a();
        } else if (c.c == e || e < 0) {
            Global.setApolloSoPath(dataDir + Global.getLibsPath(c.c));
            e.a(a);
            e.a();
        } else {
            String str = dataDir + Global.getLibsPath(e);
            try {
                if (new File(str).exists()) {
                    Global.setApolloSoPath(str);
                    c.c = e;
                    e.a(a);
                    e.a();
                } else {
                    Global.setApolloSoPath(dataDir + Global.getLibsPath(c.c));
                    e.a(a);
                    e.a();
                }
            } catch (Exception e2) {
            }
        }
        ax.b(this.a);
        u.a.a = com.ucpro.feature.webwindow.f.a.a.a;
        u.a.b = new b();
        com.ucpro.feature.webwindow.f.a.a.b.a();
    }
}
