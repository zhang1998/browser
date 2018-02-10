package com.ucpro.feature.video.player.c;

import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.ucweb.common.util.d;
import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ l e;

    o(l lVar, String str, String str2, String str3, int i) {
        this.e = lVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public final void run() {
        if (this.e.a(this.a, this.b, ContextUtils.getDataDir(d.a()) + "VitamioTemp/", this.c)) {
            this.e.f.post(new n(this));
        } else {
            try {
                File file = new File(this.b);
                if (file.exists()) {
                    a.b(file);
                }
            } catch (Exception e) {
            }
            this.e.f.post(new p(this));
        }
        a.c(this.a);
        l.a();
    }
}
