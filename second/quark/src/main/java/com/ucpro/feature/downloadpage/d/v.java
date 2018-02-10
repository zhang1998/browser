package com.ucpro.feature.downloadpage.d;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;
import hugo.weaving.DebugLog;
import java.util.List;

/* compiled from: ProGuard */
public final class v implements q {
    List<b> a = null;
    Runnable b = new h(this);
    ValueCallback c = null;
    boolean d = false;
    private f e;
    private m f;
    private Runnable g = new j(this);

    public v(f fVar, m mVar) {
        c.a((Object) fVar);
        c.a((Object) mVar);
        this.e = fVar;
        this.f = mVar;
    }

    public final void a(ValueCallback valueCallback, boolean z) {
        if (valueCallback != null) {
            this.c = valueCallback;
            this.d = z;
            com.ucweb.common.util.h.m.c(this.g);
            if (this.d) {
                com.ucweb.common.util.h.m.a(1, this.g, 50);
            } else {
                com.ucweb.common.util.h.m.a(1, this.g);
            }
        }
    }

    public final void a(b bVar, boolean z) {
        com.ucweb.common.util.h.m.a(0, new i(this, bVar, z));
    }

    @DebugLog
    public final void a(b bVar) {
        e.a().a(a.d((int) R.string.video_download_task_restarting), 0);
        new Thread(new o(this, bVar)).start();
    }

    public final void a(boolean z) {
        this.f.a(z);
    }

    public final g a(g gVar) {
        return this.f.b(gVar);
    }

    public final void a() {
        com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.v);
    }

    public final void b(b bVar) {
        e.a().a(a.d((int) R.string.video_download_task_playing), 0);
        new Thread(new x(this, bVar)).start();
    }

    @DebugLog
    public final void c(b bVar) {
        e.a().a(a.d((int) R.string.video_download_task_pausing), 0);
        new Thread(new a(this, bVar)).start();
    }
}
