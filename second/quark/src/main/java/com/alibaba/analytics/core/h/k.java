package com.alibaba.analytics.core.h;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.b;
import com.alibaba.analytics.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class k {
    private static k b = null;
    private String[] a = new String[]{"B01N16"};
    private List<u> c = new LinkedList();
    private Map<String, String> d = new HashMap();
    private String e = null;

    private k() {
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (b == null) {
                b = new k();
            }
            kVar = b;
        }
        return kVar;
    }

    private static String a(String str, Uri uri, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("${url|") && str.length() > 7) {
            Object substring = str.substring(6, str.length() - 1);
            if (!(TextUtils.isEmpty(substring) || uri == null)) {
                return uri.getQueryParameter(substring);
            }
        } else if (str.startsWith("${ut|") && str.length() > 6) {
            CharSequence substring2 = str.substring(5, str.length() - 1);
            if (!(TextUtils.isEmpty(substring2) || map == null)) {
                return (String) map.get(substring2);
            }
        } else if (!str.startsWith("${") || str.length() <= 3) {
            return str;
        } else {
            Object substring3 = str.substring(2, str.length() - 1);
            if (!TextUtils.isEmpty(substring3)) {
                if (map != null) {
                    String str2 = (String) map.get(substring3);
                    if (str2 != null) {
                        return str2;
                    }
                }
                if (uri != null) {
                    return uri.getQueryParameter(substring3);
                }
            }
        }
        return null;
    }

    public final synchronized String a(Uri uri, Map<String, String> map) {
        String optString;
        String c = c.c("tpk_md5");
        if (!(c == null || c.equals(this.e))) {
            String c2 = c.c("tpk_string");
            if (c2 != null) {
                af.a("UTMCTPKBiz", "", "pConfName", null, "pConfContent", c2);
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(c2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (!(optJSONObject == null || !optJSONObject.has("kn") || optJSONObject.isNull("kn"))) {
                                String string = optJSONObject.getString("kn");
                                if (!"a".equals(string)) {
                                    u uVar = new u();
                                    optString = optJSONObject.optString("v");
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = "${" + string + "}";
                                    }
                                    String optString2 = optJSONObject.optString("ty", "far");
                                    uVar.a = string;
                                    uVar.b = optString;
                                    uVar.c = optString2;
                                    this.c.add(uVar);
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.e = c2.hashCode();
            }
        }
        for (u uVar2 : this.c) {
            CharSequence charSequence = uVar2.a;
            String str = uVar2.c;
            optString2 = uVar2.b;
            if (TextUtils.isEmpty(charSequence)) {
                optString = null;
                break;
            } else if (TextUtils.isEmpty((String) this.d.get(charSequence))) {
                r0 = a(optString2, uri, map);
                if (!TextUtils.isEmpty(r0)) {
                    this.d.put(charSequence, r0);
                }
            } else if (!"far".equals(str)) {
                r0 = a(optString2, uri, map);
                if (!TextUtils.isEmpty(r0)) {
                    this.d.put(charSequence, r0);
                }
            }
        }
        if (!(this.d.containsKey("ttid") || TextUtils.isEmpty(com.alibaba.analytics.core.c.a().e))) {
            this.d.put("ttid", com.alibaba.analytics.core.c.a().e);
        }
        optString = this.d.size() > 0 ? "{" + b.a(this.d) + "}" : null;
        return optString;
    }

    public final synchronized void b() {
        this.d.clear();
    }
}
