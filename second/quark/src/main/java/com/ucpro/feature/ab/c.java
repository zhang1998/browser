package com.ucpro.feature.ab;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.uc.qrcode.k;
import com.uc.qrcode.l;
import com.uc.qrcode.n;
import com.ucpro.base.a.e;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.i.g;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class c {
    public static void a(String str, ValueCallback<String> valueCallback, boolean z) {
        if (a.b(str)) {
            n nVar = new n();
            nVar.c = new j(valueCallback, z, str);
            if (str != null) {
                m.a(0, new k(nVar, str), new l(nVar));
            } else if (nVar.c != null) {
                nVar.c.a();
            }
        }
    }

    public static void a(String str) {
        Object ajVar = new aj();
        int j = f.j(str);
        if (j == g.b) {
            ajVar.s = aj.e;
            ajVar.p = str;
        } else if (j == g.a) {
            ajVar.o = str;
        }
        com.ucpro.base.a.g.a().a(e.k, ajVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.net.Uri r8, android.app.Activity r9) {
        /*
        r0 = 1;
        r1 = 0;
        r6 = 0;
        r7 = "";
        r2 = new java.lang.String[r0];
        r0 = "_data";
        r2[r1] = r0;
        r0 = r9.getContentResolver();	 Catch:{ Exception -> 0x0117, all -> 0x0120 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r8;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0117, all -> 0x0120 }
        if (r1 == 0) goto L_0x0131;
    L_0x0019:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x012a, all -> 0x0128 }
        if (r0 == 0) goto L_0x0131;
    L_0x001f:
        r0 = "_data";
        r0 = r1.getColumnIndexOrThrow(r0);	 Catch:{ Exception -> 0x012a, all -> 0x0128 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x012a, all -> 0x0128 }
        if (r0 != 0) goto L_0x0076;
    L_0x002b:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = 19;
        if (r2 < r3) goto L_0x00ee;
    L_0x0031:
        r2 = android.provider.DocumentsContract.isDocumentUri(r9, r8);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x00ee;
    L_0x0037:
        r2 = "com.android.externalstorage.documents";
        r3 = r8.getAuthority();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x007c;
    L_0x0043:
        r2 = android.provider.DocumentsContract.getDocumentId(r8);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = ":";
        r2 = r2.split(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = 0;
        r3 = r2[r3];	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = "primary";
        r3 = r4.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r3 == 0) goto L_0x0114;
    L_0x0058:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3.<init>();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = "/";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = 1;
        r2 = r2[r4];	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r0 = r2.toString();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.close();
    L_0x007b:
        return r0;
    L_0x007c:
        r2 = "com.android.providers.downloads.documents";
        r3 = r8.getAuthority();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x00a5;
    L_0x0088:
        r2 = android.provider.DocumentsContract.getDocumentId(r8);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = "content://downloads/public_downloads";
        r3 = android.net.Uri.parse(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = r2.longValue();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = android.content.ContentUris.withAppendedId(r3, r4);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = 0;
        r4 = 0;
        r0 = a(r9, r2, r3, r4);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x0076;
    L_0x00a5:
        r2 = "com.android.providers.media.documents";
        r3 = r8.getAuthority();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x0114;
    L_0x00b1:
        r2 = android.provider.DocumentsContract.getDocumentId(r8);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = ":";
        r2 = r2.split(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3 = 0;
        r3 = r2[r3];	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = "image";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r4 == 0) goto L_0x00d8;
    L_0x00c6:
        r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
    L_0x00c8:
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r4 = 0;
        r5 = 1;
        r2 = r2[r5];	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r3[r4] = r2;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = "_id=?";
        r0 = a(r9, r6, r2, r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x0076;
    L_0x00d8:
        r4 = "video";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r4 == 0) goto L_0x00e3;
    L_0x00e0:
        r6 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x00c8;
    L_0x00e3:
        r4 = "audio";
        r3 = r4.equals(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r3 == 0) goto L_0x00c8;
    L_0x00eb:
        r6 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x00c8;
    L_0x00ee:
        r2 = "content";
        r3 = r8.getScheme();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x0102;
    L_0x00fa:
        r2 = 0;
        r3 = 0;
        r0 = a(r9, r8, r2, r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x0076;
    L_0x0102:
        r2 = "file";
        r3 = r8.getScheme();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        if (r2 == 0) goto L_0x0114;
    L_0x010e:
        r0 = r8.getPath();	 Catch:{ Exception -> 0x012e, all -> 0x0128 }
        goto L_0x0076;
    L_0x0114:
        r0 = r6;
        goto L_0x0076;
    L_0x0117:
        r0 = move-exception;
        r0 = r7;
    L_0x0119:
        if (r6 == 0) goto L_0x007b;
    L_0x011b:
        r6.close();
        goto L_0x007b;
    L_0x0120:
        r0 = move-exception;
        r1 = r6;
    L_0x0122:
        if (r1 == 0) goto L_0x0127;
    L_0x0124:
        r1.close();
    L_0x0127:
        throw r0;
    L_0x0128:
        r0 = move-exception;
        goto L_0x0122;
    L_0x012a:
        r0 = move-exception;
        r6 = r1;
        r0 = r7;
        goto L_0x0119;
    L_0x012e:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0119;
    L_0x0131:
        r0 = r7;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.ab.c.a(android.net.Uri, android.app.Activity):java.lang.String");
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
