package com.uc.base.wa.a;

import com.uc.base.wa.d.l;
import com.uc.base.wa.x;
import java.util.TimerTask;

/* compiled from: ProGuard */
final class a extends TimerTask {
    private a() {
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - l.a();
        if (currentTimeMillis < 0) {
            c.g.schedule(new a(), c.f);
        } else if (currentTimeMillis >= c.f) {
            x.a(1);
            c.g.schedule(new a(), c.f);
        } else {
            c.g.schedule(new a(), (100 + c.f) - currentTimeMillis);
        }
    }
}
