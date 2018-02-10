package com.ucpro.feature.bookmarkhis.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ucpro.c.b;
import com.ucweb.common.util.n.a;
import java.util.List;

/* compiled from: ProGuard */
final class h {
    private static final h c = new h();
    i a;
    SQLiteDatabase b;

    private h() {
    }

    public static h a() {
        return c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.ucpro.feature.bookmarkhis.a.a.f r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        if (r7 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r6.b;
        if (r2 == 0) goto L_0x0004;
    L_0x0009:
        r2 = r6.b;	 Catch:{ Exception -> 0x004d }
        r2.beginTransaction();	 Catch:{ Exception -> 0x004d }
        r2 = d(r7);	 Catch:{ Exception -> 0x004d }
        r3 = r6.b;	 Catch:{ Exception -> 0x004d }
        r4 = "history";
        r5 = 0;
        r3.insert(r4, r5, r2);	 Catch:{ Exception -> 0x004d }
        r2 = "%s = (select min(%s) from %s)";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x004d }
        r4 = 0;
        r5 = "visited_time";
        r3[r4] = r5;	 Catch:{ Exception -> 0x004d }
        r4 = 1;
        r5 = "visited_time";
        r3[r4] = r5;	 Catch:{ Exception -> 0x004d }
        r4 = 2;
        r5 = "history";
        r3[r4] = r5;	 Catch:{ Exception -> 0x004d }
        r2 = java.lang.String.format(r2, r3);	 Catch:{ Exception -> 0x004d }
        r3 = r6.b;	 Catch:{ Exception -> 0x004d }
        r4 = "history";
        r5 = 0;
        r3.delete(r4, r2, r5);	 Catch:{ Exception -> 0x004d }
        r2 = r6.b;	 Catch:{ Exception -> 0x004d }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x004d }
        r0 = r6.b;	 Catch:{ Exception -> 0x0046 }
        r0.endTransaction();	 Catch:{ Exception -> 0x0046 }
    L_0x0044:
        r0 = r1;
        goto L_0x0004;
    L_0x0046:
        r0 = move-exception;
        r2 = "addHistory";
        a(r0, r2);
        goto L_0x0044;
    L_0x004d:
        r1 = move-exception;
        r2 = "addNewAndDeleteOld";
        a(r1, r2);	 Catch:{ all -> 0x0060 }
        r1 = r6.b;	 Catch:{ Exception -> 0x0059 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0059 }
        goto L_0x0004;
    L_0x0059:
        r1 = move-exception;
        r2 = "addHistory";
        a(r1, r2);
        goto L_0x0004;
    L_0x0060:
        r0 = move-exception;
        r1 = r6.b;	 Catch:{ Exception -> 0x0067 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0067 }
    L_0x0066:
        throw r0;
    L_0x0067:
        r1 = move-exception;
        r2 = "addHistory";
        a(r1, r2);
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.bookmarkhis.a.a.h.a(com.ucpro.feature.bookmarkhis.a.a.f):boolean");
    }

    public final boolean b(f fVar) {
        if (fVar == null || this.b == null) {
            return false;
        }
        try {
            this.b.insert("history", null, d(fVar));
            return true;
        } catch (Throwable e) {
            a(e, "addHistory");
            return false;
        }
    }

    final boolean a(String str) {
        if (this.b == null) {
            return false;
        }
        try {
            this.b.delete("history", str, null);
            return true;
        } catch (Throwable e) {
            a(e, "deleteHistory");
            return false;
        }
    }

    final g b() {
        Cursor query;
        Throwable e;
        g gVar = new g();
        if (this.b == null) {
            return gVar;
        }
        try {
            query = this.b.query("history", i.a, null, null, null, null, "visited_time ASC " + "LIMIT 200");
            if (query == null) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable e2) {
                        a(e2, "queryHistoryData");
                    }
                }
                return gVar;
            }
            try {
                List a = gVar.a();
                while (query.moveToNext()) {
                    f fVar = new f();
                    fVar.b = query.getString(query.getColumnIndexOrThrow("name"));
                    fVar.b(query.getString(query.getColumnIndexOrThrow("url")));
                    fVar.a(query.getString(query.getColumnIndexOrThrow("original_url")));
                    fVar.a = query.getLong(query.getColumnIndexOrThrow("visited_time"));
                    fVar.f = query.getInt(query.getColumnIndexOrThrow("visited_count"));
                    fVar.j = query.getInt(query.getColumnIndexOrThrow("state"));
                    fVar.h = query.getInt(query.getColumnIndexOrThrow("media_type"));
                    fVar.g = query.getInt(query.getColumnIndexOrThrow("from_type"));
                    fVar.l = query.getString(query.getColumnIndexOrThrow("source"));
                    fVar.m = query.getInt(query.getColumnIndexOrThrow("daoliu_type"));
                    fVar.n = query.getString(query.getColumnIndexOrThrow("article_id"));
                    fVar.o = (long) query.getInt(query.getColumnIndexOrThrow("channel_id"));
                    fVar.k = query.getString(query.getColumnIndexOrThrow("icon_url"));
                    a.add(fVar);
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable e22) {
                        a(e22, "queryHistoryData");
                    }
                }
            } catch (Throwable th) {
                e22 = th;
                try {
                    a(e22, "queryHistoryData");
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable e222) {
                            a(e222, "queryHistoryData");
                        }
                    }
                    return gVar;
                } catch (Throwable th2) {
                    e222 = th2;
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable e3) {
                            a(e3, "queryHistoryData");
                        }
                    }
                    throw e222;
                }
            }
            return gVar;
        } catch (Throwable th3) {
            e222 = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e222;
        }
    }

    public final boolean c(f fVar) {
        if (fVar == null || this.b == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", fVar.c);
            contentValues.put("visited_time", Long.valueOf(fVar.a));
            contentValues.put("host", fVar.e);
            contentValues.put("visited_count", Integer.valueOf(fVar.f));
            contentValues.put("state", Integer.valueOf(fVar.j));
            contentValues.put("media_type", Integer.valueOf(fVar.h));
            contentValues.put("name", fVar.b);
            contentValues.put("from_type", Integer.valueOf(fVar.g));
            contentValues.put("source", fVar.l);
            contentValues.put("daoliu_type", Integer.valueOf(fVar.m));
            contentValues.put("article_id", fVar.n);
            contentValues.put("channel_id", Long.valueOf(fVar.o));
            contentValues.put("icon_url", fVar.k);
            this.b.update("history", contentValues, String.format("%s=? or %s=?", new Object[]{"url", "url"}), new String[]{fVar.d, fVar.c});
            return true;
        } catch (Throwable e) {
            a(e, "updateHistoryData");
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3) {
        if (this.b == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("url", str2);
            contentValues.put("visited_time", Long.valueOf(System.currentTimeMillis()));
            this.b.update("history", contentValues, String.format("%s=? or %s=?", new Object[]{"url", "url"}), new String[]{str3, str2});
            return true;
        } catch (Throwable e) {
            a(e, "updateHistoryUrl");
            return false;
        }
    }

    static void a(Throwable th, String str) {
        if (b.b()) {
            String.format("Database failure, Method:%s, Throwable:%s", new Object[]{str, th.getMessage()});
        }
    }

    private static ContentValues d(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", a.d(fVar.b));
        contentValues.put("url", a.d(fVar.c));
        contentValues.put("original_url", a.d(fVar.d));
        contentValues.put("visited_time", String.valueOf(fVar.a));
        contentValues.put("host", a.d(fVar.e));
        contentValues.put("visited_count", String.valueOf(fVar.f));
        contentValues.put("state", String.valueOf(fVar.j));
        contentValues.put("media_type", String.valueOf(fVar.h));
        contentValues.put("from_type", String.valueOf(fVar.g));
        contentValues.put("source", a.d(fVar.l));
        contentValues.put("daoliu_type", String.valueOf(fVar.m));
        contentValues.put("article_id", a.d(fVar.n));
        contentValues.put("channel_id", String.valueOf(fVar.o));
        contentValues.put("icon_url", String.valueOf(fVar.k));
        contentValues.put("temp_1", "");
        contentValues.put("temp_2", "");
        contentValues.put("temp_3", "");
        return contentValues;
    }
}
