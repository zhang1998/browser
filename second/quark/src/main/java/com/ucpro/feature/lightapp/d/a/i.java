package com.ucpro.feature.lightapp.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public final class i {
    public j a;
    SQLiteDatabase b;
    Context c;

    public i(Context context) {
        this.c = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ucpro.feature.lightapp.d.a.d a(java.lang.String r11) {
        /*
        r10 = this;
        r1 = 1;
        r3 = 0;
        r8 = 0;
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0009:
        r0 = r10.b;
        if (r0 != 0) goto L_0x000d;
    L_0x000d:
        r0 = "%s=?";
        r1 = new java.lang.Object[r1];
        r2 = "id";
        r1[r3] = r2;
        r3 = java.lang.String.format(r0, r1);
        r0 = r10.b;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r1 = "category_info";
        r2 = com.ucpro.feature.lightapp.d.a.j.e;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        if (r1 != 0) goto L_0x002e;
    L_0x002e:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        if (r0 == 0) goto L_0x005d;
    L_0x0034:
        r2 = new com.ucpro.feature.lightapp.d.a.h;	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        r2.<init>();	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        r2.a(r11);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = "info";
        r0 = r1.getColumnIndexOrThrow(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r2.b(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = "visited_time";
        r0 = r1.getColumnIndexOrThrow(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r4 = r1.getLong(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r2.a(r4);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = r2;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();	 Catch:{ Exception -> 0x0089 }
    L_0x005c:
        return r0;
    L_0x005d:
        r0 = r8;
        goto L_0x0057;
    L_0x005f:
        r0 = move-exception;
        r1 = r0;
        r2 = r8;
        r0 = r8;
    L_0x0063:
        r3 = "cache_db_operate_error";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x008f }
        r5 = 0;
        r6 = "error_msg";
        r4[r5] = r6;	 Catch:{ all -> 0x008f }
        r5 = 1;
        r1 = r1.getMessage();	 Catch:{ all -> 0x008f }
        r4[r5] = r1;	 Catch:{ all -> 0x008f }
        r1 = "lightapp";
        com.ucpro.business.stat.m.a(r1, r3, r4);	 Catch:{ all -> 0x008f }
        if (r2 == 0) goto L_0x005c;
    L_0x007b:
        r2.close();	 Catch:{ Exception -> 0x007f }
        goto L_0x005c;
    L_0x007f:
        r1 = move-exception;
        goto L_0x005c;
    L_0x0081:
        r0 = move-exception;
        r1 = r8;
    L_0x0083:
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1.close();	 Catch:{ Exception -> 0x008b }
    L_0x0088:
        throw r0;
    L_0x0089:
        r1 = move-exception;
        goto L_0x005c;
    L_0x008b:
        r1 = move-exception;
        goto L_0x0088;
    L_0x008d:
        r0 = move-exception;
        goto L_0x0083;
    L_0x008f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0083;
    L_0x0092:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0063;
    L_0x0097:
        r0 = move-exception;
        r9 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.lightapp.d.a.i.a(java.lang.String):com.ucpro.feature.lightapp.d.a.d");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ucpro.feature.lightapp.d.a.d b(java.lang.String r11) {
        /*
        r10 = this;
        r1 = 1;
        r3 = 0;
        r8 = 0;
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0009:
        r0 = r10.b;
        if (r0 != 0) goto L_0x000d;
    L_0x000d:
        r0 = "%s=?";
        r1 = new java.lang.Object[r1];
        r2 = "id";
        r1[r3] = r2;
        r3 = java.lang.String.format(r0, r1);
        r0 = r10.b;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r1 = "article_list";
        r2 = com.ucpro.feature.lightapp.d.a.j.f;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x005f, all -> 0x0081 }
        if (r1 != 0) goto L_0x002e;
    L_0x002e:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        if (r0 == 0) goto L_0x005d;
    L_0x0034:
        r2 = new com.ucpro.feature.lightapp.d.a.f;	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        r2.<init>();	 Catch:{ Throwable -> 0x0092, all -> 0x008d }
        r2.a(r11);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = "list";
        r0 = r1.getColumnIndexOrThrow(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r2.b(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = "visited_time";
        r0 = r1.getColumnIndexOrThrow(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r4 = r1.getLong(r0);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r2.a(r4);	 Catch:{ Throwable -> 0x0097, all -> 0x008d }
        r0 = r2;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();	 Catch:{ Exception -> 0x0089 }
    L_0x005c:
        return r0;
    L_0x005d:
        r0 = r8;
        goto L_0x0057;
    L_0x005f:
        r0 = move-exception;
        r1 = r0;
        r2 = r8;
        r0 = r8;
    L_0x0063:
        r3 = "cache_db_operate_error";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x008f }
        r5 = 0;
        r6 = "error_msg";
        r4[r5] = r6;	 Catch:{ all -> 0x008f }
        r5 = 1;
        r1 = r1.getMessage();	 Catch:{ all -> 0x008f }
        r4[r5] = r1;	 Catch:{ all -> 0x008f }
        r1 = "lightapp";
        com.ucpro.business.stat.m.a(r1, r3, r4);	 Catch:{ all -> 0x008f }
        if (r2 == 0) goto L_0x005c;
    L_0x007b:
        r2.close();	 Catch:{ Exception -> 0x007f }
        goto L_0x005c;
    L_0x007f:
        r1 = move-exception;
        goto L_0x005c;
    L_0x0081:
        r0 = move-exception;
        r1 = r8;
    L_0x0083:
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1.close();	 Catch:{ Exception -> 0x008b }
    L_0x0088:
        throw r0;
    L_0x0089:
        r1 = move-exception;
        goto L_0x005c;
    L_0x008b:
        r1 = move-exception;
        goto L_0x0088;
    L_0x008d:
        r0 = move-exception;
        goto L_0x0083;
    L_0x008f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0083;
    L_0x0092:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0063;
    L_0x0097:
        r0 = move-exception;
        r9 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.lightapp.d.a.i.b(java.lang.String):com.ucpro.feature.lightapp.d.a.d");
    }

    public final boolean c(String str) {
        if (TextUtils.isEmpty(str) || this.b == null) {
            return false;
        }
        try {
            this.b.delete("category_info", String.format("%s = (select min(%s) from %s where %s = '%s')", new Object[]{"id", "id", "category_info", "id", str}), null);
            return true;
        } catch (Exception e) {
            String str2 = "lightapp";
            m.a(str2, "cache_db_operate_error", "error_msg", e.getMessage());
            return false;
        }
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str) || this.b == null) {
            return false;
        }
        try {
            this.b.delete("article_list", String.format("%s = (select min(%s) from %s where %s = '%s')", new Object[]{"id", "id", "article_list", "id", str}), null);
            return true;
        } catch (Exception e) {
            String str2 = "lightapp";
            m.a(str2, "cache_db_operate_error", "error_msg", e.getMessage());
            return false;
        }
    }

    public final boolean a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null || this.b == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", str);
            contentValues.put("list", dVar.a());
            contentValues.put("visited_time", Long.valueOf(dVar.b()));
            if (-1 == this.b.replace("article_list", null, contentValues)) {
                com.ucpro.feature.lightapp.m.a("cache_db_operate_error", "error_msg", "replace return -1");
            }
            return true;
        } catch (Exception e) {
            com.ucpro.feature.lightapp.m.a("cache_db_operate_error", "error_msg", e.getMessage());
            return false;
        }
    }

    public final boolean b(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null || this.b == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", str);
            contentValues.put("info", dVar.a());
            contentValues.put("visited_time", Long.valueOf(dVar.b()));
            if (-1 == this.b.replace("category_info", null, contentValues)) {
                com.ucpro.feature.lightapp.m.a("cache_db_operate_error", "error_msg", "replace return -1");
            }
            return true;
        } catch (Exception e) {
            com.ucpro.feature.lightapp.m.a("cache_db_operate_error", "error_msg", e.getMessage());
            return false;
        }
    }
}
