package com.taobao.weex.ui.component;

import android.net.Uri;
import com.alibaba.fastjson.b;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.bridge.s;
import com.taobao.weex.c.o;
import com.taobao.weex.c.v;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class r implements z {
    final /* synthetic */ s a;

    r(s sVar) {
        this.a = sVar;
    }

    public final void a() {
        o domObject = this.a.getDomObject();
        if (domObject != null) {
            v i = domObject.i();
            if (i != null) {
                String str = (String) i.get("href");
                if (str != null) {
                    String instanceId = this.a.getInstanceId();
                    ac b = ad.a().b(instanceId);
                    if (b != null) {
                        str = b.a(Uri.parse(str)).toString();
                        b bVar = new b();
                        bVar.add(str);
                        s sVar = ad.a().b;
                        s.a(instanceId, "event", "openURL", bVar);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        WXLogUtils.d("WXA", "Property href is empty.");
    }
}
