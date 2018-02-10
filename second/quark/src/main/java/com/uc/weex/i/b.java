package com.uc.weex.i;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class b extends e {
    private static final String b = d.a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(android.content.Context r18, com.uc.weex.i.d r19) throws java.io.IOException {
        /*
        r17 = this;
        r2 = com.uc.weex.i.n.b(r18);
        r3 = 1;
        r0 = r17;
        r1 = r19;
        r0.<init>(r2, r3, r1);
        r2 = 0;
        r9 = new java.util.jar.JarFile;	 Catch:{ Throwable -> 0x012c, all -> 0x0117 }
        r3 = r18.getApplicationInfo();	 Catch:{ Throwable -> 0x012c, all -> 0x0117 }
        r3 = r3.publicSourceDir;	 Catch:{ Throwable -> 0x012c, all -> 0x0117 }
        r9.<init>(r3);	 Catch:{ Throwable -> 0x012c, all -> 0x0117 }
        r0 = r17;
        r10 = r0.a;	 Catch:{ Throwable -> 0x010d, all -> 0x012a }
        r5 = a(r9);	 Catch:{ Throwable -> 0x010d, all -> 0x012a }
        r2 = 0;
        r8 = com.uc.weex.i.n.a(r18);	 Catch:{ Throwable -> 0x0130, all -> 0x0104 }
        r6 = r10.listFiles();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = 0;
        r4 = r2;
    L_0x002b:
        r2 = r6.length;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r4 >= r2) goto L_0x0070;
    L_0x002e:
        r7 = r6[r4];	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r11 = r7.getName();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = r5.get(r11);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = (com.uc.weex.i.a) r2;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 == 0) goto L_0x0058;
    L_0x003c:
        r3 = r2.b;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r12 = r3.getSize();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r14 = r7.length();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r3 != 0) goto L_0x0058;
    L_0x004a:
        r3 = r2.b;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r12 = r3.getTime();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r14 = r7.lastModified();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r3 == 0) goto L_0x006c;
    L_0x0058:
        r3 = 1;
    L_0x0059:
        if (r2 == 0) goto L_0x006e;
    L_0x005b:
        if (r3 != 0) goto L_0x006e;
    L_0x005d:
        r2 = 1;
    L_0x005e:
        if (r3 == 0) goto L_0x0063;
    L_0x0060:
        com.uc.weex.i.n.a(r7);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
    L_0x0063:
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r5.remove(r11);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
    L_0x0068:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x002b;
    L_0x006c:
        r3 = 0;
        goto L_0x0059;
    L_0x006e:
        r2 = 0;
        goto L_0x005e;
    L_0x0070:
        r2 = r5.values();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r11 = r2.iterator();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
    L_0x0078:
        r2 = r11.hasNext();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 == 0) goto L_0x00fc;
    L_0x007e:
        r2 = r11.next();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r0 = r2;
        r0 = (com.uc.weex.i.a) r0;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r4 = r0;
        r2 = r4.a;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = r2.toLowerCase();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r3 = "v8uc";
        r2 = r2.contains(r3);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 != 0) goto L_0x00b2;
    L_0x0094:
        r2 = r4.a;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = r2.toLowerCase();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r3 = "v9uc";
        r2 = r2.contains(r3);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 != 0) goto L_0x00b2;
    L_0x00a2:
        r2 = r4.a;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = r2.toLowerCase();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r3 = com.taobao.weex.m.b();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = r2.contains(r3);	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 == 0) goto L_0x0078;
    L_0x00b2:
        r6 = r4.b;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        r2 = 0;
        r2 = r9.getInputStream(r6);	 Catch:{ Throwable -> 0x00d6, all -> 0x00e2 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        r4 = r4.a;	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        r3.<init>(r10, r4);	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        r4 = r6.getSize();	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        r6 = r6.getTime();	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        com.uc.weex.i.n.a(r2, r3, r4, r6);	 Catch:{ Throwable -> 0x00d6, all -> 0x0132 }
        com.uc.weex.i.n.a();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 == 0) goto L_0x0078;
    L_0x00d0:
        r2.close();	 Catch:{ Throwable -> 0x00d4, all -> 0x012e }
        goto L_0x0078;
    L_0x00d4:
        r2 = move-exception;
        goto L_0x0078;
    L_0x00d6:
        r3 = move-exception;
        com.uc.weex.i.n.a();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r2 == 0) goto L_0x0078;
    L_0x00dc:
        r2.close();	 Catch:{ Throwable -> 0x00e0, all -> 0x012e }
        goto L_0x0078;
    L_0x00e0:
        r2 = move-exception;
        goto L_0x0078;
    L_0x00e2:
        r3 = move-exception;
        r16 = r3;
        r3 = r2;
        r2 = r16;
    L_0x00e8:
        com.uc.weex.i.n.a();	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
        if (r3 == 0) goto L_0x00f0;
    L_0x00ed:
        r3.close();	 Catch:{ Throwable -> 0x0120, all -> 0x012e }
    L_0x00f0:
        throw r2;	 Catch:{ Throwable -> 0x00f1, all -> 0x012e }
    L_0x00f1:
        r2 = move-exception;
        r2 = r8;
    L_0x00f3:
        if (r2 == 0) goto L_0x00f8;
    L_0x00f5:
        r2.close();	 Catch:{ Throwable -> 0x0122, all -> 0x012a }
    L_0x00f8:
        r9.close();	 Catch:{ Throwable -> 0x0126 }
    L_0x00fb:
        return;
    L_0x00fc:
        if (r8 == 0) goto L_0x00f8;
    L_0x00fe:
        r8.close();	 Catch:{ Throwable -> 0x0102, all -> 0x012a }
        goto L_0x00f8;
    L_0x0102:
        r2 = move-exception;
        goto L_0x00f8;
    L_0x0104:
        r3 = move-exception;
        r8 = r2;
        r2 = r3;
    L_0x0107:
        if (r8 == 0) goto L_0x010c;
    L_0x0109:
        r8.close();	 Catch:{ Throwable -> 0x0124, all -> 0x012a }
    L_0x010c:
        throw r2;	 Catch:{ Throwable -> 0x010d, all -> 0x012a }
    L_0x010d:
        r2 = move-exception;
        r2 = r9;
    L_0x010f:
        if (r2 == 0) goto L_0x00fb;
    L_0x0111:
        r2.close();	 Catch:{ Throwable -> 0x0115 }
        goto L_0x00fb;
    L_0x0115:
        r2 = move-exception;
        goto L_0x00fb;
    L_0x0117:
        r3 = move-exception;
        r9 = r2;
        r2 = r3;
    L_0x011a:
        if (r9 == 0) goto L_0x011f;
    L_0x011c:
        r9.close();	 Catch:{ Throwable -> 0x0128 }
    L_0x011f:
        throw r2;
    L_0x0120:
        r3 = move-exception;
        goto L_0x00f0;
    L_0x0122:
        r2 = move-exception;
        goto L_0x00f8;
    L_0x0124:
        r3 = move-exception;
        goto L_0x010c;
    L_0x0126:
        r2 = move-exception;
        goto L_0x00fb;
    L_0x0128:
        r3 = move-exception;
        goto L_0x011f;
    L_0x012a:
        r2 = move-exception;
        goto L_0x011a;
    L_0x012c:
        r3 = move-exception;
        goto L_0x010f;
    L_0x012e:
        r2 = move-exception;
        goto L_0x0107;
    L_0x0130:
        r3 = move-exception;
        goto L_0x00f3;
    L_0x0132:
        r3 = move-exception;
        r16 = r3;
        r3 = r2;
        r2 = r16;
        goto L_0x00e8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.weex.i.b.<init>(android.content.Context, com.uc.weex.i.d):void");
    }

    private static Map<String, a> a(JarFile jarFile) {
        Pattern compile = Pattern.compile("^lib/([^/]+)/([^/]+\\.so)$");
        Map hashMap = new HashMap();
        String[] b = n.b();
        Enumeration entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) entries.nextElement();
            Matcher matcher = compile.matcher(jarEntry.getName());
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                int a = n.a(b, group);
                if (a >= 0) {
                    a aVar = (a) hashMap.get(group2);
                    if (aVar == null || a < aVar.c) {
                        hashMap.put(group2, new a(group2, jarEntry, a));
                    }
                }
            }
        }
        return hashMap;
    }
}
