package com.taobao.weex.d;

import android.net.Uri;
import com.UCMobile.Apollo.ApolloMetaData;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.o;
import com.taobao.weex.common.r;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public class j extends o {
    static final Pattern d = Pattern.compile("charset=([a-z0-9-]+)");
    final com.taobao.weex.a.j a;

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        this.a = null;
    }

    @JSMethod(uiThread = false)
    @Deprecated
    public void sendHttp(String str, String str2) {
        byte[] bArr;
        e b = a.b(str);
        String h = b.h("method");
        String h2 = b.h("url");
        e d = b.d(ApolloMetaData.KEY_HEADER);
        String h3 = b.h("body");
        int g = b.g("timeout");
        if (h != null) {
            h = h.toUpperCase();
        }
        a aVar = new a();
        if (!(SpdyRequest.GET_METHOD.equals(h) || SpdyRequest.POST_METHOD.equals(h) || "PUT".equals(h) || "DELETE".equals(h) || "HEAD".equals(h) || "PATCH".equals(h))) {
            h = SpdyRequest.GET_METHOD;
        }
        aVar.a = h;
        aVar.b = h2;
        if (h3 == null) {
            bArr = null;
        } else {
            bArr = h3.getBytes();
        }
        aVar.c = bArr;
        aVar.e = g;
        a(d, aVar);
        a(aVar.a(), new f(this, str2), null);
    }

    @JSMethod(uiThread = false)
    public void fetch(String str, c cVar, c cVar2) {
        e b;
        boolean z;
        try {
            b = a.b(str);
        } catch (Throwable e) {
            WXLogUtils.e("", e);
            b = null;
        }
        if (b == null || b.h("url") == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte[] bArr;
            String h = b.h("method");
            String h2 = b.h("url");
            e d = b.d("headers");
            String h3 = b.h("body");
            String h4 = b.h("type");
            int g = b.g("timeout");
            if (h != null) {
                h = h.toUpperCase();
            }
            a aVar = new a();
            if (!(SpdyRequest.GET_METHOD.equals(h) || SpdyRequest.POST_METHOD.equals(h) || "PUT".equals(h) || "DELETE".equals(h) || "HEAD".equals(h) || "PATCH".equals(h))) {
                h = SpdyRequest.GET_METHOD;
            }
            aVar.a = h;
            aVar.b = h2;
            if (h3 == null) {
                bArr = null;
            } else {
                bArr = h3.getBytes();
            }
            aVar.c = bArr;
            if (b.json.name().equals(h4)) {
                aVar.d = b.json;
            } else if (b.jsonp.name().equals(h4)) {
                aVar.d = b.jsonp;
            } else {
                aVar.d = b.text;
            }
            aVar.e = g;
            a(d, aVar);
            c a = aVar.a();
            a(a, new g(this, cVar, d, a), cVar2);
        } else if (cVar != null) {
            Map hashMap = new HashMap();
            hashMap.put("ok", Boolean.valueOf(false));
            hashMap.put("statusText", "ERR_INVALID_REQUEST");
            cVar.a(hashMap);
        }
    }

    static Object a(String str, b bVar) throws d {
        if (bVar == b.json) {
            return a.a(str);
        }
        if (bVar != b.jsonp) {
            return str;
        }
        if (str == null || str.isEmpty()) {
            return new e();
        }
        int indexOf = str.indexOf("(") + 1;
        int lastIndexOf = str.lastIndexOf(")");
        if (indexOf == 0 || indexOf >= lastIndexOf || lastIndexOf <= 0) {
            return new e();
        }
        return a.a(str.substring(indexOf, lastIndexOf));
    }

    static String a(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        if (map.containsKey(str)) {
            return (String) map.get(str);
        }
        return (String) map.get(str.toLowerCase());
    }

    static String a(byte[] bArr, String str) {
        String group;
        String str2 = "utf-8";
        if (str != null) {
            Matcher matcher = d.matcher(str.toLowerCase());
            if (matcher.find()) {
                group = matcher.group(1);
                return new String(bArr, group);
            }
        }
        group = str2;
        try {
            return new String(bArr, group);
        } catch (Throwable e) {
            WXLogUtils.e("", e);
            return new String(bArr);
        }
    }

    private static void a(e eVar, a aVar) {
        String str;
        String a = e.a(i.e(), i.a());
        if (eVar != null) {
            str = a;
            for (String a2 : eVar.keySet()) {
                if (a2.equals("user-agent")) {
                    str = eVar.h(a2);
                } else {
                    aVar.a(a2, eVar.h(a2));
                }
            }
        } else {
            str = a2;
        }
        aVar.a("user-agent", str);
    }

    private void a(c cVar, h hVar, c cVar2) {
        r rVar = new r();
        rVar.c = cVar.a;
        rVar.b = this.b.a(Uri.parse(cVar.b)).toString();
        rVar.d = cVar.d;
        rVar.e = cVar.f;
        if (cVar.c != null) {
            if (rVar.a == null) {
                rVar.a = cVar.c;
            } else {
                rVar.a.putAll(cVar.c);
            }
        }
        com.taobao.weex.a.j e = (this.a != null || this.b == null) ? this.a : ac.e();
        if (e != null) {
            e.a(rVar, new i(hVar, cVar2));
        } else {
            WXLogUtils.e("WXStreamModule", "No HttpAdapter found,request failed.");
        }
    }
}
