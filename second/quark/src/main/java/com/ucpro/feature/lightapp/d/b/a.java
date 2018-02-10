package com.ucpro.feature.lightapp.d.b;

import com.uc.encrypt.f;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ucpro.feature.lightapp.d.b.h a(java.lang.String r4, android.content.Context r5) {
        /*
        r1 = 0;
        r0 = r5.getAssets();	 Catch:{ IOException -> 0x0023, all -> 0x0029 }
        r2 = r0.open(r4);	 Catch:{ IOException -> 0x0023, all -> 0x0029 }
        if (r2 == 0) goto L_0x0038;
    L_0x000b:
        r0 = com.ucweb.common.util.o.a.b(r2);	 Catch:{ IOException -> 0x0031, all -> 0x002f }
        r3 = com.uc.encrypt.a.b;	 Catch:{ IOException -> 0x0031, all -> 0x002f }
        r3 = com.uc.encrypt.f.b(r0, r3);	 Catch:{ IOException -> 0x0031, all -> 0x002f }
        if (r3 == 0) goto L_0x0038;
    L_0x0017:
        r0 = new com.ucpro.feature.lightapp.d.b.h;	 Catch:{ IOException -> 0x0031, all -> 0x002f }
        r0.<init>();	 Catch:{ IOException -> 0x0031, all -> 0x002f }
        r0.a(r3);	 Catch:{ IOException -> 0x0035, all -> 0x002f }
    L_0x001f:
        com.ucweb.common.util.o.a.a(r2);
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = move-exception;
        r0 = r1;
    L_0x0025:
        com.ucweb.common.util.o.a.a(r1);
        goto L_0x0022;
    L_0x0029:
        r0 = move-exception;
        r2 = r1;
    L_0x002b:
        com.ucweb.common.util.o.a.a(r2);
        throw r0;
    L_0x002f:
        r0 = move-exception;
        goto L_0x002b;
    L_0x0031:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0025;
    L_0x0035:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0025;
    L_0x0038:
        r0 = r1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.lightapp.d.b.a.a(java.lang.String, android.content.Context):com.ucpro.feature.lightapp.d.b.h");
    }

    public static void a(h hVar, String str) {
        if (hVar != null) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                byte[] l_ = hVar.l_();
                if (l_ != null) {
                    l_ = f.a(l_, com.uc.encrypt.a.b);
                    if (l_ != null) {
                        com.ucweb.common.util.k.a.a(file, l_);
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
