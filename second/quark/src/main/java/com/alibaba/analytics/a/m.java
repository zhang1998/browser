package com.alibaba.analytics.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.model.LogField;
import com.e.b.d.a.c;
import com.e.b.d.a.d;
import com.uc.apollo.impl.SettingsConst;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public class m {
    private static final String a = m.class.getSimpleName();

    public static String a(String str, Map<String, Object> map) throws Exception {
        String str2 = "";
        if (map != null && map.size() > 0) {
            Set keySet = map.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            String str3 = str2;
            for (String str4 : n.a().a(strArr)) {
                str3 = str3 + str4 + ab.b((byte[]) map.get(str4));
            }
            str2 = str3;
        }
        try {
            str2 = a(str, str2);
        } catch (Throwable th) {
            str2 = a(b.a().k(), str2);
        }
        Object g = b.a().g();
        if (TextUtils.isEmpty(g)) {
            return str2;
        }
        return str2 + "&dk=" + URLEncoder.encode(g, "UTF-8");
    }

    private static String a(String str, String str2) throws Exception {
        String str3;
        String d;
        String str4;
        Object obj;
        Context context = b.a().b;
        String b = r.b();
        String a = r.a();
        if (a == null) {
            str3 = "";
        } else {
            str3 = a;
        }
        a = (String) j.a(context).get(LogField.APPVERSION.toString());
        if (b.a().d() != null) {
            d = b.a().d();
        } else {
            d = a;
        }
        a = (String) j.a(context).get(LogField.OS.toString());
        a.a();
        String b2 = a.b();
        String str5 = (String) j.a(context).get(LogField.UTDID.toString());
        String str6 = "3.0";
        String valueOf = String.valueOf(System.currentTimeMillis());
        c cVar = b.a().e;
        String str7 = SettingsConst.FALSE;
        String str8 = SettingsConst.FALSE;
        if ((cVar instanceof d) || (cVar instanceof com.e.b.d.a.b)) {
            str4 = SettingsConst.TRUE;
            obj = str7;
        } else if ((cVar instanceof com.e.b.d.a.a) && ((com.e.b.d.a.a) cVar).a) {
            String str9 = str8;
            str8 = SettingsConst.TRUE;
            str4 = str9;
        } else {
            str4 = str8;
            str8 = str7;
        }
        StringBuilder append = new StringBuilder().append(b).append(str3).append(d).append(a).append(b2).append(str5).append(valueOf).append(str6).append(str4);
        if (str2 == null) {
            str2 = "";
        }
        str7 = cVar.a(ab.b(append.append(str2).toString().getBytes()));
        String str10 = "";
        if (!TextUtils.isEmpty(null)) {
            str10 = null + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", new Object[]{str, str10, a(b), a(d), a(str3), a(str6), a(str7), a(str5), b2, a, valueOf, "", str4, obj});
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }
}
