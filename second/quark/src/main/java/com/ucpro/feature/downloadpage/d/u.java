package com.ucpro.feature.downloadpage.d;

import android.os.Message;
import android.util.Log;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.ui.widget.j;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class u extends e {
    private l c;

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.y) {
            a(true);
        } else if (i != com.ucpro.base.a.e.z && i == com.ucpro.base.a.e.A && this.c != null) {
            this.c.a(false);
        }
    }

    public final void b(int i, Message message) {
    }

    @DebugLog
    public final void a(b bVar) {
        super.a(bVar);
    }

    public final j a(boolean z) {
        if (com.ucpro.c.b.b()) {
            Log.e("hjw-m3u8", "showM3u8Page");
        }
        if (this.c == null || !z) {
            this.c = new l(this.b);
            this.c.setPresenter(new v(this.c, s_()));
            this.c.d(z);
            this.c.setEnableSwipeGesture(z);
        }
        this.c.a(true);
        if (z) {
            s_().a(this.c, true);
        } else {
            this.c.f();
        }
        return this.c;
    }

    @DebugLog
    public final void d() {
        if (this.c != null) {
            l lVar = this.c;
            if (lVar.g != null) {
                com.ucpro.feature.video.cache.db.b.b().b(lVar.g);
                lVar.g = null;
            }
            this.c = null;
        }
    }
}
