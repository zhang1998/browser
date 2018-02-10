package com.ucweb.common.util.l;

import com.ucweb.common.util.n.a;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: ProGuard */
public final class c {
    static boolean a(b bVar, String str) {
        String[] split = str.split("\\?=\\s=\\?");
        if (split == null || split.length == 0) {
            return true;
        }
        split[0] = a.e(split[0]);
        split[0] = split[0].substring(2);
        int length = split.length - 1;
        split[length] = a.e(split[length]);
        split[length] = split[length].substring(0, split[length].length() - 2);
        for (String e : split) {
            String e2 = a.e(e2);
            if (!a.a(e2)) {
                a aVar;
                String e3 = a.e(e2);
                if (a.a(e3)) {
                    aVar = null;
                } else {
                    int lastIndexOf = e3.lastIndexOf(63);
                    if (lastIndexOf == -1) {
                        aVar = null;
                    } else {
                        int indexOf = e3.indexOf(42);
                        if (indexOf == -1) {
                            indexOf = e3.indexOf(63);
                        } else if (indexOf > lastIndexOf) {
                            aVar = null;
                        }
                        a aVar2 = new a();
                        if (indexOf == -1 || indexOf == lastIndexOf) {
                            aVar2.a = e3.substring(0, lastIndexOf);
                        } else {
                            aVar2.a = e3.substring(0, indexOf);
                            if (indexOf + 1 < lastIndexOf) {
                                aVar2.b = e3.substring(indexOf + 1, lastIndexOf);
                            }
                        }
                        if (lastIndexOf + 1 < e3.length()) {
                            aVar2.c = a.e(e3.substring(lastIndexOf + 1));
                        }
                        aVar = aVar2;
                    }
                }
                if (aVar == null) {
                    return false;
                }
                bVar.a(aVar);
            }
        }
        return true;
    }

    private static String a(String str) {
        if (a.a(str)) {
            return str;
        }
        try {
            String decode = URLDecoder.decode(str, "ISO_8859_1");
            String encode = URLEncoder.encode(decode, "ISO_8859_1");
            if (str.equalsIgnoreCase(encode)) {
                return decode;
            }
            if (str.replace("!", "%21").replace("'", "%27").replace("(", "%28").replace(")", "%29").replace("~", "%7E").equalsIgnoreCase(encode.replace("+", "%20"))) {
                return decode;
            }
            return str;
        } catch (Exception e) {
            com.ucweb.common.util.c.a(e.toString());
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
        r1 = "";
        r0 = com.ucweb.common.util.n.a.a(r6);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "B";
        r0 = r0.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x003f;
    L_0x0011:
        r0 = com.ucweb.common.util.e.a.a(r6);	 Catch:{ Exception -> 0x005d }
        r5 = r0;
    L_0x0016:
        r4 = 0;
        if (r5 == 0) goto L_0x0008;
    L_0x0019:
        r2 = 0;
        r0 = com.ucweb.common.util.n.a.b(r7);	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x0053;
    L_0x0020:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x004b }
        r3.<init>(r5, r7);	 Catch:{ Exception -> 0x004b }
        r0 = 1;
        r2 = r0;
        r0 = r3;
    L_0x0028:
        if (r2 != 0) goto L_0x0037;
    L_0x002a:
        r0 = com.ucweb.common.util.e.a.a(r5);	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x0055;
    L_0x0030:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x005d }
        r2 = "UTF-8";
        r0.<init>(r5, r2);	 Catch:{ Exception -> 0x005d }
    L_0x0037:
        r2 = com.ucweb.common.util.n.a.b(r0);	 Catch:{ Exception -> 0x005d }
        if (r2 == 0) goto L_0x0065;
    L_0x003d:
        r1 = r0;
        goto L_0x0008;
    L_0x003f:
        r0 = a(r6);	 Catch:{ Exception -> 0x005d }
        r2 = "ISO_8859_1";
        r0 = r0.getBytes(r2);	 Catch:{ Exception -> 0x005d }
        r5 = r0;
        goto L_0x0016;
    L_0x004b:
        r0 = move-exception;
        r0 = r0.toString();	 Catch:{ Exception -> 0x005d }
        com.ucweb.common.util.c.a(r0);	 Catch:{ Exception -> 0x005d }
    L_0x0053:
        r0 = r4;
        goto L_0x0028;
    L_0x0055:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x005d }
        r2 = "GBK";
        r0.<init>(r5, r2);	 Catch:{ Exception -> 0x005d }
        goto L_0x0037;
    L_0x005d:
        r0 = move-exception;
        r0 = r0.toString();
        com.ucweb.common.util.c.a(r0);
    L_0x0065:
        r0 = r1;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.common.util.l.c.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
