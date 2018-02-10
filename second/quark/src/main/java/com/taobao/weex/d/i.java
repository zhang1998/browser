package com.taobao.weex.d;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.s;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class i implements com.taobao.weex.a.i {
    private h a;
    private c b;
    private Map<String, Object> c;
    private Map<String, String> d;

    private i(h hVar, c cVar) {
        this.c = new HashMap();
        this.a = hVar;
        this.b = cVar;
    }

    public final void a() {
        if (this.b != null) {
            this.c.put("readyState", Integer.valueOf(1));
            this.c.put("length", Integer.valueOf(0));
            this.b.b(this.c);
        }
    }

    public final void a(int i, Map<String, List<String>> map) {
        this.c.put("readyState", Integer.valueOf(2));
        this.c.put(INoCaptchaComponent.status, Integer.valueOf(i));
        Map hashMap = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (((List) entry.getValue()).size() > 0) {
                    Object obj;
                    if (entry.getKey() == null) {
                        obj = "_";
                    } else {
                        String str = (String) entry.getKey();
                    }
                    hashMap.put(obj, ((List) entry.getValue()).get(0));
                }
            }
        }
        this.c.put("headers", hashMap);
        this.d = hashMap;
        if (this.b != null) {
            this.b.b(this.c);
        }
    }

    public final void a(int i) {
        this.c.put("length", Integer.valueOf(i));
        if (this.b != null) {
            this.b.b(this.c);
        }
    }

    public final void a(s sVar) {
        if (this.a != null) {
            this.a.a(sVar, this.d);
        }
        if (com.taobao.weex.i.c()) {
            WXLogUtils.d("WXStreamModule", sVar.b != null ? new String(sVar.b) : "response data is NUll!");
        }
    }
}
