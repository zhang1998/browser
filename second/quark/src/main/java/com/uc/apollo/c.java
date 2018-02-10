package com.uc.apollo;

import com.uc.apollo.Statistic.IVideoViewStatistic;
import com.uc.apollo.media.base.Statistic;
import com.uc.apollo.media.base.Statistic.Outputter;
import com.uc.apollo.util.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class c implements Outputter {
    private static c a;
    private IVideoViewStatistic b;

    private c() {
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public final void a(IVideoViewStatistic iVideoViewStatistic) {
        if (!(this.b == null || this.b.equals(iVideoViewStatistic))) {
            Statistic.removeOutputter((Outputter) this);
        }
        this.b = iVideoViewStatistic;
        if (this.b != null) {
            Statistic.addOutputter((Outputter) this);
        }
    }

    public final void write(int i, Map<String, String> map) {
        if (this.b != null) {
            f.a((Map) map);
            this.b.upload((HashMap) map);
        }
    }
}
