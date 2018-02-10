package com.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ca {
    static Context a;

    private ca() {
    }

    public static JSONObject a() {
        JSONObject a;
        try {
            a = bs.a(br.a(a).a());
        } catch (Exception e) {
            fw.d("upload agg date error");
            return null;
        } finally {
            br.a(a).c();
        }
        return a;
    }

    public static JSONObject a(cl clVar) {
        JSONObject a;
        try {
            a = bs.a(clVar, br.a(a).a());
        } catch (Exception e) {
            return null;
        } finally {
            br.a(a).c();
        }
        return a;
    }

    public static void a(cl clVar, List<String> list) {
        try {
            SQLiteDatabase b = br.a(a).b();
            try {
                b.beginTransaction();
                if (bs.b(b, "limitedck") > 0) {
                    bs.a(b, "limitedck");
                }
                for (String str : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ck", str);
                    b.insert("limitedck", null, contentValues);
                }
                b.setTransactionSuccessful();
                clVar.a("success");
            } catch (SQLException e) {
                fw.d("insertToLimitCKTable error " + e.toString());
            } finally {
                b.endTransaction();
            }
            br.a(a).c();
            return;
        } catch (Exception e2) {
            fw.d("saveToLimitCKTable exception");
            return;
        } catch (Throwable th) {
        }
        br.a(a).c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.a.a.a.cl r14, java.util.Map<java.lang.String, com.a.a.a.co> r15) {
        /*
        r6 = 0;
        r1 = 0;
        r0 = a;	 Catch:{ Exception -> 0x008f }
        r0 = com.a.a.a.br.a(r0);	 Catch:{ Exception -> 0x008f }
        r8 = r0.b();	 Catch:{ Exception -> 0x008f }
        r0 = "__ag_of";
        r0 = r15.get(r0);	 Catch:{ SQLException -> 0x0072 }
        r0 = (com.a.a.a.co) r0;	 Catch:{ SQLException -> 0x0072 }
        if (r0 != 0) goto L_0x0021;
    L_0x0017:
        r0 = a;
        r0 = com.a.a.a.br.a(r0);
        r0.c();
    L_0x0020:
        return;
    L_0x0021:
        r5 = "system where key=\"__ag_of\"";
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0072 }
        r3 = "select * from ";
        r2.<init>(r3);	 Catch:{ SQLException -> 0x0072 }
        r2 = r2.append(r5);	 Catch:{ SQLException -> 0x0072 }
        r2 = r2.toString();	 Catch:{ SQLException -> 0x0072 }
        r3 = 0;
        r1 = r8.rawQuery(r2, r3);	 Catch:{ SQLException -> 0x0072 }
        r4 = 0;
        r1.moveToFirst();	 Catch:{ SQLException -> 0x0072 }
        r2 = r6;
    L_0x003c:
        r9 = r1.isAfterLast();	 Catch:{ SQLException -> 0x0072 }
        if (r9 != 0) goto L_0x009f;
    L_0x0042:
        r9 = r1.getCount();	 Catch:{ SQLException -> 0x0072 }
        if (r9 <= 0) goto L_0x006e;
    L_0x0048:
        r2 = "count";
        r2 = r1.getColumnIndex(r2);	 Catch:{ SQLException -> 0x0072 }
        r4 = r1.getInt(r2);	 Catch:{ SQLException -> 0x0072 }
        r2 = "timeStamp";
        r2 = r1.getColumnIndex(r2);	 Catch:{ SQLException -> 0x0072 }
        r2 = r1.getLong(r2);	 Catch:{ SQLException -> 0x0072 }
        r9 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0072 }
        r10 = "delete from ";
        r9.<init>(r10);	 Catch:{ SQLException -> 0x0072 }
        r9 = r9.append(r5);	 Catch:{ SQLException -> 0x0072 }
        r9 = r9.toString();	 Catch:{ SQLException -> 0x0072 }
        r8.execSQL(r9);	 Catch:{ SQLException -> 0x0072 }
    L_0x006e:
        r1.moveToNext();	 Catch:{ SQLException -> 0x0072 }
        goto L_0x003c;
    L_0x0072:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r3 = "save to system table error ";
        r2.<init>(r3);	 Catch:{ all -> 0x00e9 }
        r0 = r0.toString();	 Catch:{ all -> 0x00e9 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x00e9 }
        r0 = r0.toString();	 Catch:{ all -> 0x00e9 }
        com.a.a.a.fw.d(r0);	 Catch:{ all -> 0x00e9 }
        if (r1 == 0) goto L_0x0017;
    L_0x008b:
        r1.close();	 Catch:{ Exception -> 0x008f }
        goto L_0x0017;
    L_0x008f:
        r0 = move-exception;
        r0 = "arrgetated system buffer exception";
        com.a.a.a.fw.d(r0);	 Catch:{ all -> 0x00d9 }
        r0 = a;
        r0 = com.a.a.a.br.a(r0);
        r0.c();
        goto L_0x0020;
    L_0x009f:
        r9 = new android.content.ContentValues;	 Catch:{ SQLException -> 0x0072 }
        r9.<init>();	 Catch:{ SQLException -> 0x0072 }
        r5 = "key";
        r10 = r0.a;	 Catch:{ SQLException -> 0x0072 }
        r9.put(r5, r10);	 Catch:{ SQLException -> 0x0072 }
        r10 = "count";
        if (r4 != 0) goto L_0x00e4;
    L_0x00af:
        r4 = r0.c;	 Catch:{ SQLException -> 0x0072 }
    L_0x00b1:
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLException -> 0x0072 }
        r9.put(r10, r4);	 Catch:{ SQLException -> 0x0072 }
        r4 = "timeStamp";
        r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x00c0;
    L_0x00be:
        r2 = r0.b;	 Catch:{ SQLException -> 0x0072 }
    L_0x00c0:
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ SQLException -> 0x0072 }
        r9.put(r4, r0);	 Catch:{ SQLException -> 0x0072 }
        r0 = "system";
        r2 = 0;
        r8.insert(r0, r2, r9);	 Catch:{ SQLException -> 0x0072 }
        r0 = "success";
        r14.a(r0);	 Catch:{ SQLException -> 0x0072 }
        if (r1 == 0) goto L_0x0017;
    L_0x00d4:
        r1.close();	 Catch:{ Exception -> 0x008f }
        goto L_0x0017;
    L_0x00d9:
        r0 = move-exception;
        r1 = a;
        r1 = com.a.a.a.br.a(r1);
        r1.c();
        throw r0;
    L_0x00e4:
        r4 = (long) r4;
        r12 = r0.c;	 Catch:{ SQLException -> 0x0072 }
        r4 = r4 + r12;
        goto L_0x00b1;
    L_0x00e9:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ef;
    L_0x00ec:
        r1.close();	 Catch:{ Exception -> 0x008f }
    L_0x00ef:
        throw r0;	 Catch:{ Exception -> 0x008f }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.ca.a(com.a.a.a.cl, java.util.Map):void");
    }
}
