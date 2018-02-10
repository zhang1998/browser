package com.ucpro.base.weex.component;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.e.b.b;
import com.e.b.c.d;
import com.e.b.g;
import com.e.b.j;
import com.e.b.l;
import com.e.b.r;
import com.taobao.b.c;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.browser.interfaces.IWebResources;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class a extends com.uc.weex.g.a {
    @JSMethod
    @Deprecated
    public void commit(String str, String str2, String str3, Map<String, String> map) {
        commitut(str, -1, str2, str3, "", "", "", map);
    }

    @JSMethod
    public void commitut(String str, int i, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        if (this.b != null && this.b.b() != null) {
            if ("click".equals(str)) {
                if (!TextUtils.isEmpty(str3)) {
                    r rVar;
                    if (TextUtils.isEmpty(str2)) {
                        rVar = new r(str3);
                    } else {
                        rVar = new r(str2, str3);
                    }
                    rVar.a(map);
                    b.a().d().a(rVar.a());
                }
            } else if ("expose".equals(str)) {
                int i2;
                if (i < 0) {
                    i2 = 2201;
                } else {
                    i2 = i;
                }
                b.a().d().a(new d(str2, i2, str4, str5, str6, map).a());
            } else if ("enter".equals(str)) {
                b.a().d();
                l.a(this.b.b(), str2);
                b.a().d();
                l.a(this.b.b(), (Map) map);
                if (!TextUtils.isEmpty(str3)) {
                    b.a().d();
                    l.a(this.b.b(), Uri.parse(str3));
                }
            } else if (IWebResources.TEXT_OTHER.equals(str)) {
                a(str2, str4, map);
            } else if ("updateNextProp".equals(str)) {
                b.a().d();
                l.b((Map) map);
            } else if ("clickWithPageName".equals(str) && str2 != null && str3 != null && map != null) {
                try {
                    String str7;
                    String str8;
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Entry entry : map.entrySet()) {
                        stringBuffer.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(",");
                    }
                    c cVar = c.Button;
                    String[] strArr = new String[]{stringBuffer.toString()};
                    if (str2 == null) {
                        str7 = g.a().e;
                        if (!(str7 == null || str7.startsWith("Page_"))) {
                            str7 = "Page_" + str7;
                        }
                        str8 = str7;
                    } else {
                        if (!(str2 == null || str2.startsWith("Page_"))) {
                            str2 = "Page_" + str2;
                        }
                        str8 = str2;
                    }
                    if (!TextUtils.isEmpty(str8)) {
                        CharSequence charSequence;
                        if (str8 == null || str3 == null) {
                            charSequence = null;
                        } else {
                            if (str8.startsWith("Page_")) {
                                str7 = str8;
                            } else {
                                str7 = "Page_" + str8;
                            }
                            charSequence = str7 + "_" + cVar.toString() + "-" + str3;
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            String a = com.taobao.b.b.a(strArr);
                            Map hashMap = new HashMap();
                            hashMap.put(LogField.PAGE.toString(), str8);
                            hashMap.put(LogField.EVENTID.toString(), "2101");
                            hashMap.put(LogField.ARG1.toString(), charSequence);
                            hashMap.put("_bmbu", "yes");
                            if (a != null) {
                                hashMap.put(LogField.ARGS.toString(), a);
                            }
                            b.a().d().a(hashMap);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    @JSMethod
    @Deprecated
    public void commitEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        a(str, str2, map);
    }

    @JSMethod
    public void customAdvance(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        b.a().d().a(new d(str, i, str2, str3, str4, map).a());
    }

    private static void a(String str, String str2, Map<String, String> map) {
        j jVar = new j(str2);
        jVar.a(str);
        jVar.a(map);
        b.a().d().a(jVar.a());
    }

    @JSMethod
    public void pageAppear() {
        b.a().d();
        l.b(this.b.b());
    }

    @JSMethod
    public void pageDisAppear() {
        b.a().d().c(this.b.b());
    }

    @JSMethod
    public void updateNextPageUtparam(String str) {
        b.a().d();
        l.a(str);
    }

    @JSMethod
    public void updatePageUtparam(String str) {
        b.a().d();
        l.b(this.b.b(), str);
    }

    @JSMethod
    public void skipPage() {
        b.a().d();
        l.d(this.b.b());
    }
}
