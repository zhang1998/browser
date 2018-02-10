package com.taobao.weex.bridge;

import android.text.TextUtils;
import com.taobao.weex.common.n;
import com.taobao.weex.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class w {
    private static Map<String, n> a = new HashMap();

    public static void a() {
        for (String str : a.keySet()) {
            String str2;
            n nVar = (n) a.get(str2);
            String str3 = nVar.a;
            Object obj = nVar.b;
            Map map = nVar.c;
            if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(obj))) {
                String str4 = "register: global.registerService, unregister: global.unregisterService";
                str2 = "serviceName: \"" + str3 + "\"";
                String str5 = str2;
                for (String str22 : map.keySet()) {
                    str5 = str5 + ", " + str22 + ": \"" + ((String) map.get(str22)) + "\"";
                }
                str22 = String.format(";(function(service, options){ ;%s; })({ %s }, { %s });", new Object[]{obj, str4, str5});
                if (i.c()) {
                    n nVar2 = new n();
                    nVar2.a = str3;
                    nVar2.b = obj;
                    nVar2.c = map;
                    a.put(str3, nVar2);
                }
                s a = s.a();
                a.a(new p(a, str22));
            }
        }
    }
}
