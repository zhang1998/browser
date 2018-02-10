package com.loc;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import java.util.HashMap;
import java.util.Map;

@ad(a = "file")
/* compiled from: ProGuard */
public class aq {
    @ae(a = "fname", b = 6)
    String a;
    @ae(a = "md", b = 6)
    String b;
    @ae(a = "version", b = 6)
    String c;
    @ae(a = "dversion", b = 6)
    String d;
    @ae(a = "status", b = 6)
    String e;
    @ae(a = "sname", b = 6)
    private String f;

    private aq() {
    }

    public aq(ap apVar) {
        this.a = apVar.a;
        this.b = apVar.b;
        this.f = apVar.c;
        this.c = apVar.d;
        this.d = apVar.e;
        this.e = apVar.f;
    }

    public static String a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        return n.a(hashMap);
    }

    public static String a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return n.a(hashMap);
    }

    public static String a(String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put("version", str3);
        return n.a(hashMap);
    }

    public static String b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        return n.a(hashMap);
    }

    public static String b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put(INoCaptchaComponent.status, str2);
        return n.a(hashMap);
    }
}
