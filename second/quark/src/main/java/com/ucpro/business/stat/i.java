package com.ucpro.business.stat;

import com.ucweb.common.util.g.a;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class i implements Runnable {
    public final void run() {
        boolean b = a.b("com.tencent.mtt");
        boolean b2 = a.b("com.UCMobile");
        boolean b3 = a.b("com.UCMobile.intl");
        boolean b4 = a.b("mark.via");
        boolean b5 = a.b("com.qihoo.browser");
        boolean b6 = a.b("com.baidu.browser.apps");
        boolean b7 = a.b("com.android.chrome");
        HashMap hashMap = new HashMap();
        hashMap.put("mtt", String.valueOf(b));
        hashMap.put("uc", String.valueOf(b2));
        hashMap.put("ucintl", String.valueOf(b3));
        hashMap.put("via", String.valueOf(b4));
        hashMap.put("qihoo", String.valueOf(b5));
        hashMap.put("baidu", String.valueOf(b6));
        hashMap.put("chrome", String.valueOf(b7));
        m.a("app", "other_browser_step_status", hashMap);
    }
}
