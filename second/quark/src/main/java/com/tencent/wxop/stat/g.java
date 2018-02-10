package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.n;
import java.util.Timer;
import java.util.TimerTask;

public class g {
    private static volatile g b = null;
    private Timer a = null;
    private Context c = null;

    private g(Context context) {
        this.c = context.getApplicationContext();
        this.a = new Timer(false);
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    public final void a() {
        if (i.a() == o.PERIOD) {
            long l = (long) ((i.l() * 60) * 1000);
            if (i.b()) {
                n.c().a("setupPeriodTimer delay:" + l);
            }
            TimerTask fVar = new f(this);
            if (this.a != null) {
                if (i.b()) {
                    n.c().a("setupPeriodTimer schedule delay:" + l);
                }
                this.a.schedule(fVar, l);
            } else if (i.b()) {
                n.c().c("setupPeriodTimer schedule timer == null");
            }
        }
    }
}
