package com.ucpro.model;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.business.stat.f;
import com.ucpro.c.a;
import com.ucweb.common.util.d.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r9) {
        /*
        r2 = 0;
        r0 = android.text.TextUtils.isEmpty(r9);
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r9;
    L_0x0008:
        r0 = "uc_param_str=";
        r3 = r9.indexOf(r0);
        if (r3 < 0) goto L_0x0007;
    L_0x0010:
        r4 = b(r9);
        if (r4 == 0) goto L_0x0007;
    L_0x0016:
        r0 = com.ucweb.common.util.i.f.d(r9);
        r1 = "https";
        r0 = com.ucweb.common.util.n.a.d(r0, r1);
        if (r0 == 0) goto L_0x00dc;
    L_0x0022:
        r0 = 1;
        r1 = r0;
    L_0x0024:
        r0 = r9.substring(r3);
        r3 = com.ucweb.common.util.n.a.a(r0);
        if (r3 != 0) goto L_0x00c4;
    L_0x002e:
        r0 = c(r0);
        if (r0 == 0) goto L_0x003a;
    L_0x0034:
        r3 = r0.size();
        if (r3 != 0) goto L_0x007d;
    L_0x003a:
        r0 = "";
    L_0x003c:
        r1 = com.ucweb.common.util.n.a.a(r0);
        if (r1 != 0) goto L_0x0007;
    L_0x0042:
        r1 = "uc_param_str=";
        r1 = r9.indexOf(r1);
        r1 = r1 + 13;
        r3 = r9.substring(r1);
        r1 = com.ucweb.common.util.n.a.a(r3);
        if (r1 != 0) goto L_0x0007;
    L_0x0054:
        r1 = "&";
        r1 = r3.contains(r1);
        if (r1 == 0) goto L_0x00c8;
    L_0x005c:
        r1 = "&";
        r1 = r3.indexOf(r1);
    L_0x0062:
        r1 = r3.substring(r2, r1);
        r2 = new java.lang.StringBuilder;
        r2.<init>(r9);
        r3 = r2.indexOf(r1);
        r1 = r1.length();
        r1 = r1 + r3;
        r0 = r2.insert(r1, r0);
        r9 = r0.toString();
        goto L_0x0007;
    L_0x007d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = new java.util.HashSet;
        r5.<init>();
        r6 = r0.iterator();
    L_0x008b:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x00ba;
    L_0x0091:
        r0 = r6.next();
        r0 = (java.lang.String) r0;
        r7 = new java.lang.StringBuilder;
        r8 = "&";
        r7.<init>(r8);
        r7 = r7.append(r0);
        r8 = "=";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r7 = r3.indexOf(r7);
        if (r7 >= 0) goto L_0x008b;
    L_0x00b2:
        r0 = a(r0, r4, r1, r5);
        r3.append(r0);
        goto L_0x008b;
    L_0x00ba:
        r0 = r3.toString();
        r1 = com.ucweb.common.util.n.a.a(r0);
        if (r1 == 0) goto L_0x003c;
    L_0x00c4:
        r0 = "";
        goto L_0x003c;
    L_0x00c8:
        r1 = "#";
        r1 = r3.contains(r1);
        if (r1 == 0) goto L_0x00d7;
    L_0x00d0:
        r1 = "#";
        r1 = r3.indexOf(r1);
        goto L_0x0062;
    L_0x00d7:
        r1 = r3.length();
        goto L_0x0062;
    L_0x00dc:
        r1 = r2;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.model.b.a(java.lang.String):java.lang.String");
    }

    private static String a(String str, boolean z, boolean z2, Set<String> set) {
        String str2;
        if (z2) {
            str2 = "&" + str + "=" + a(str, z, true);
        } else if (str.equals("ei") || str.equals("si") || str.equals("gs") || str.equals("ls") || str.equals("sn") || str.equals("fi") || str.equals("fi") || str.equals("dd")) {
            return "";
        } else {
            if (str.equals("gi")) {
                str = "gp";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("li")) {
                str = "lb";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("cp")) {
                str = "pc";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("ds")) {
                str = "ut";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("ud")) {
                str = "ai";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("ni")) {
                str = "nn";
                str2 = "&" + str + "=" + a(str, z, true);
            } else if (str.equals("wi")) {
                str = "wf";
                str2 = "&" + str + "=" + a(str, z, true);
            } else {
                str2 = "&" + str + "=" + a(str, z, true);
            }
        }
        if (str2 != null && set.contains(str)) {
            return "";
        }
        if (str2 == null) {
            return str2;
        }
        set.add(str);
        return str2;
    }

    private static String a(String str, boolean z, boolean z2) {
        String str2 = null;
        if (str.equalsIgnoreCase("dn")) {
            str2 = com.ucpro.business.e.e.b.b().c();
        } else if (str.equalsIgnoreCase("fr")) {
            str2 = "android";
        } else if (z && str.equalsIgnoreCase("bi")) {
            str2 = a.a();
        } else if (str.equalsIgnoreCase("ve")) {
            str2 = "2.4.1.985";
        } else if (z && str.equalsIgnoreCase("cp")) {
            str2 = a.d(SettingKeys.UBICpParam);
            if (!TextUtils.isEmpty(str2)) {
                str2 = Uri.encode(str2).replaceAll("%3A", ":").replaceAll("%3B", ";");
            }
        } else if (str.equalsIgnoreCase("mi")) {
            try {
                str2 = URLEncoder.encode(Build.MODEL, "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        } else if (str.equalsIgnoreCase("nt")) {
            str2 = String.valueOf(com.ucpro.base.system.b.a.n());
        } else if (!((z && str.equalsIgnoreCase("gi")) || (z && str.equalsIgnoreCase("wi")))) {
            if (z && str.equalsIgnoreCase("ni")) {
                String d = a.d(SettingKeys.UBIEnSn);
                if (com.ucweb.common.util.n.a.a(d)) {
                    try {
                        str2 = com.ucpro.business.e.e.b.b().d();
                    } catch (Throwable th) {
                    }
                    if (com.ucweb.common.util.n.a.a(str2)) {
                        str2 = "";
                    } else {
                        str2 = com.ucpro.base.system.b.a.h(str2);
                        a.a(SettingKeys.UBIEnSn, str2);
                    }
                } else {
                    str2 = d;
                }
            } else if (z && str.equalsIgnoreCase("ei")) {
                str2 = a.d(SettingKeys.UBIMiEnImei);
                if (com.ucweb.common.util.n.a.a(str2)) {
                    str2 = e.d();
                    if (com.ucweb.common.util.n.a.a(str2)) {
                        str2 = "";
                    } else {
                        str2 = com.ucpro.base.system.b.a.h(str2);
                        a.a(SettingKeys.UBIMiEnImei, str2);
                    }
                }
            } else if (str.equalsIgnoreCase("ch")) {
                str2 = "";
            } else if (str.equalsIgnoreCase("sv")) {
                str2 = "release";
            } else if ("ds".equalsIgnoreCase(str)) {
                str2 = a.d(SettingKeys.UBIEnUtdId);
            } else if ("ud".equalsIgnoreCase(str)) {
                str2 = a.d(SettingKeys.UBIEnAid);
            } else if ("pf".equals(str)) {
                str2 = "3300";
            } else if ("pr".equals(str)) {
                str2 = "ucpro";
            } else if ("la".equals(str)) {
                str2 = Locale.getDefault().getLanguage();
            } else if ("bt".equals(str)) {
                str2 = "";
            } else if ("bm".equals(str)) {
                str2 = "";
            } else if ("pv".equals(str)) {
                str2 = "3.1";
            } else if ("ss".equals(str)) {
                str2 = com.ucpro.base.system.b.a.f() + "x" + com.ucpro.base.system.b.a.g();
            } else if ("kt".equals(str)) {
                str2 = "4";
            } else if ("nw".equals(str)) {
                str2 = com.ucpro.base.system.b.a.I();
            } else if (!"li".equals(str)) {
                if ("si".equals(str)) {
                    str2 = e.e();
                } else if ("os".equals(str)) {
                    str2 = VERSION.RELEASE;
                } else if ("di".equals(str)) {
                    str2 = e.a();
                } else if ("ad".equals(str)) {
                    str2 = a.d(SettingKeys.UBIEnAddr);
                } else if (!((z && "me".equalsIgnoreCase(str)) || ((z && "ms".equalsIgnoreCase(str)) || ((z && "lb".equalsIgnoreCase(str)) || ((z && "ls".equalsIgnoreCase(str)) || ((z && "gp".equalsIgnoreCase(str)) || ((z && "gs".equalsIgnoreCase(str)) || ((z && "wf".equalsIgnoreCase(str)) || ((z && "fi".equalsIgnoreCase(str)) || (z && "nn".equalsIgnoreCase(str))))))))))) {
                    if (z && "sn".equalsIgnoreCase(str)) {
                        str2 = com.ucpro.business.e.e.b.b().d();
                    } else if (!((z && "pc".equalsIgnoreCase(str)) || "td".equalsIgnoreCase(str))) {
                        if ("ut".equalsIgnoreCase(str)) {
                            try {
                                str2 = URLEncoder.encode(f.c(), "UTF-8");
                            } catch (UnsupportedEncodingException e2) {
                            }
                        } else if (!("dd".equalsIgnoreCase(str) || "ai".equalsIgnoreCase(str))) {
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    private static boolean b(String str) {
        String g = com.ucweb.common.util.i.f.g(str);
        if (com.ucweb.common.util.n.a.a(g)) {
            return false;
        }
        Object obj = new com.uc.base.net.a.a(g).b;
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        String toLowerCase = obj.toLowerCase();
        List arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add("shuqiread.com");
        arrayList.add("shuqi.com");
        arrayList.add("pp.cn");
        if (arrayList.contains(toLowerCase)) {
            return true;
        }
        List<String> arrayList2 = new ArrayList();
        arrayList2.clear();
        arrayList2.add(".uc.cn");
        arrayList2.add(".sm.cn");
        arrayList2.add(".jiaoyimall.com");
        arrayList2.add(".jiaoyimao.com");
        arrayList2.add(".yisou.com");
        arrayList2.add(".ucweb.com");
        arrayList2.add(".uc123.com");
        arrayList2.add(".9game.cn");
        arrayList2.add(".9game.com");
        arrayList2.add(".9apps.mobi");
        arrayList2.add(".9apps.com");
        arrayList2.add(".shuqi.com");
        arrayList2.add(".shuqiread.com");
        arrayList2.add(".pp.cn");
        arrayList2.add(".waptw.com");
        arrayList2.add(".9gamevn.com");
        arrayList2.add(".uodoo.com");
        arrayList2.add(".cricuc.com");
        arrayList2.add(".uczzd.cn");
        arrayList2.add(".uczzd.com");
        arrayList2.add(".uczzd.com.cn");
        arrayList2.add(".uczzd.net");
        for (String g2 : arrayList2) {
            if (toLowerCase.endsWith(g2)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> c(String str) {
        int i = 0;
        if (com.ucweb.common.util.n.a.a(str)) {
            return null;
        }
        int indexOf = str.indexOf("uc_param_str");
        if (indexOf < 0) {
            return null;
        }
        String substring = str.substring((indexOf + 12) + 1);
        if (substring.indexOf("&") > 0) {
            substring = substring.substring(0, substring.indexOf("&"));
        }
        int length = substring.length();
        if (length % 2 != 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        while (i < length / 2) {
            arrayList.add(substring.substring(i * 2, (i * 2) + 2));
            i++;
        }
        return arrayList;
    }

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        boolean b = b(str2);
        ArrayList c = c("uc_param_str=" + str);
        if (c == null || c.size() == 0) {
            return jSONObject;
        }
        Iterator it = c.iterator();
        while (it.hasNext()) {
            try {
                String a = a((String) it.next(), b, false, new HashSet());
                if (a.startsWith("&")) {
                    String[] split = a.substring(1).split("=");
                    if (split.length == 2) {
                        jSONObject.put(split[0], split[1]);
                    }
                }
            } catch (JSONException e) {
                return jSONObject;
            }
        }
        return jSONObject;
    }
}
