package com.alibaba.analytics.core.h;

import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.g;
import com.taobao.orange.OrangeConfig;

/* compiled from: ProGuard */
public final class c extends i {
    public static final g a = new g();
    private static final String[] c = new String[]{"ut_sample", "ut_stream", "ut_bussiness", "utap_system", "ap_alarm", "ap_counter", "ap_stat"};

    public final void a() {
        try {
            OrangeConfig.getInstance().init(b.a().b);
            i.a();
            i.a(new g(this));
            OrangeConfig.getInstance().registerListener(c, new f(this));
        } catch (Throwable th) {
        }
    }
}
