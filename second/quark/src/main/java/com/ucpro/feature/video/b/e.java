package com.ucpro.feature.video.b;

import com.uc.media.interfaces.IApolloHelper.Apollo;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.uc.media.interfaces.IApolloHelper.Global;
import com.ucpro.feature.video.f.a;
import com.ucweb.common.util.d;
import com.ucweb.common.util.i.f;
import java.io.File;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public final class e {
    public static String a(a aVar) {
        if (!a.APOLLO.equals(aVar)) {
            return null;
        }
        boolean isInitialized = Apollo.isInitialized(d.a());
        String version = Apollo.getVersion();
        if (!com.ucweb.common.util.n.a.a(version) && Apollo.compareVersion(Global.getApolloSeries(), version) && isInitialized) {
            return version;
        }
        return "0.0.0.0";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri a(android.net.Uri r6) {
        /*
        r1 = 0;
        if (r6 == 0) goto L_0x0089;
    L_0x0003:
        r0 = r6.getScheme();	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r2 = "content";
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        if (r0 == 0) goto L_0x0089;
    L_0x000f:
        r0 = com.ucweb.common.util.d.a();	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r2 = r0.getType(r6);	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r3 = com.ucweb.common.util.n.a.b(r2);	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        if (r3 == 0) goto L_0x0089;
    L_0x0021:
        r3 = "video";
        r2 = r2.startsWith(r3);	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        if (r2 == 0) goto L_0x0089;
    L_0x0029:
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r3 = 0;
        r4 = "_id";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r3 = 1;
        r4 = "title";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r3 = 2;
        r4 = "_data";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        r0 = android.provider.MediaStore.Video.query(r0, r6, r2);	 Catch:{ Exception -> 0x0067, all -> 0x006f }
        if (r0 == 0) goto L_0x0085;
    L_0x0041:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
        if (r2 == 0) goto L_0x005b;
    L_0x0047:
        r2 = 2;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
        r3 = com.ucweb.common.util.n.a.a(r2);	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
        if (r3 != 0) goto L_0x005b;
    L_0x0052:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
        r1 = android.net.Uri.fromFile(r3);	 Catch:{ Exception -> 0x007b, all -> 0x0076 }
    L_0x005b:
        r0.close();	 Catch:{ Exception -> 0x0080, all -> 0x0076 }
        r5 = r0;
        r0 = r1;
        r1 = r5;
    L_0x0061:
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();
    L_0x0066:
        return r0;
    L_0x0067:
        r0 = move-exception;
        r0 = r1;
    L_0x0069:
        if (r1 == 0) goto L_0x0066;
    L_0x006b:
        r1.close();
        goto L_0x0066;
    L_0x006f:
        r0 = move-exception;
    L_0x0070:
        if (r1 == 0) goto L_0x0075;
    L_0x0072:
        r1.close();
    L_0x0075:
        throw r0;
    L_0x0076:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0070;
    L_0x007b:
        r2 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0069;
    L_0x0080:
        r2 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0069;
    L_0x0085:
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0061;
    L_0x0089:
        r0 = r1;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.video.b.e.a(android.net.Uri):android.net.Uri");
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a() {
        String dataDir = ContextUtils.getDataDir(d.a());
        for (int i = 0; i < Global.getLibsPathLength(); i++) {
            com.ucweb.common.util.k.a.c(dataDir + Global.getLibsPath(i));
        }
    }

    public static void a(File file, long j) {
        try {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            a(file2, j);
                        } else if (file2.exists() && file2.lastModified() <= currentTimeMillis) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean b(String str) {
        if (com.ucpro.b.a.a.a() && com.ucpro.c.d.a() && c(str)) {
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        if (f.c(str).contains("youtube")) {
            return true;
        }
        return false;
    }
}
