package com.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class bx {
    static Context c;
    cm a;
    cd b;
    List<String> d;
    cf e;
    private ca f;
    private boolean g;
    private boolean h;
    private long i;
    private final String j;
    private final String k;
    private final Thread l;

    private bx() {
        this.a = null;
        this.f = null;
        this.b = null;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.j = "main_fest_mode";
        this.k = "main_fest_timestamp";
        this.d = new ArrayList();
        this.e = null;
        this.l = new Thread(new ck(this));
        if (c != null) {
            if (this.a == null) {
                this.a = new cm();
            }
            if (this.f == null) {
                ca.a = c;
                this.f = cb.a;
            }
            if (this.b == null) {
                this.b = new cd();
            }
        }
        this.l.start();
    }

    public final JSONObject a() {
        JSONObject a = ca.a();
        JSONObject jSONObject = new JSONObject();
        if (a == null || a.length() <= 0) {
            return null;
        }
        for (String str : this.d) {
            if (a.has(str)) {
                try {
                    jSONObject.put(str, a.opt(str));
                } catch (Exception e) {
                }
            }
        }
        return jSONObject;
    }

    public final JSONObject b() {
        if (this.b.a.size() > 0) {
            ca.a(new bu(this), this.b.a);
        }
        return ca.a(new cl());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
        r8 = this;
        r6 = 0;
        r1 = 0;
        r0 = r8.h;
        if (r0 == 0) goto L_0x00a9;
    L_0x0007:
        r2 = r8.i;
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x0025;
    L_0x000d:
        r0 = c;
        r2 = "umeng_general_config";
        r0 = r0.getSharedPreferences(r2, r1);
        r2 = "main_fest_mode";
        r2 = r0.getBoolean(r2, r1);
        r8.h = r2;
        r2 = "main_fest_timestamp";
        r2 = r0.getLong(r2, r6);
        r8.i = r2;
    L_0x0025:
        r2 = java.lang.System.currentTimeMillis();
        r4 = r8.i;
        r0 = com.a.a.a.ce.a(r2);
        r2 = com.a.a.a.ce.a(r4);
        if (r0 != r2) goto L_0x008c;
    L_0x0035:
        r0 = 1;
    L_0x0036:
        if (r0 != 0) goto L_0x0058;
    L_0x0038:
        r2 = c;
        r3 = "umeng_general_config";
        r2 = r2.getSharedPreferences(r3, r1);
        r2 = r2.edit();
        r3 = "main_fest_mode";
        r2.putBoolean(r3, r1);
        r3 = "main_fest_timestamp";
        r2.putLong(r3, r6);
        r2.commit();
        r8.h = r1;
        r1 = r8.d;
        r1.clear();
    L_0x0058:
        r1 = r8.b;
        r1.a();
        r1 = new com.a.a.a.bz;
        r1.<init>(r8);
        r2 = com.a.a.a.ca.a;	 Catch:{ Exception -> 0x008e }
        r2 = com.a.a.a.br.a(r2);	 Catch:{ Exception -> 0x008e }
        r2 = r2.b();	 Catch:{ Exception -> 0x008e }
        r3 = "system";
        com.a.a.a.bs.a(r2, r3);	 Catch:{ Exception -> 0x008e }
        r3 = "aggregated";
        com.a.a.a.bs.a(r2, r3);	 Catch:{ Exception -> 0x008e }
        if (r0 != 0) goto L_0x0082;
    L_0x0078:
        r0 = "limitedck";
        com.a.a.a.bs.a(r2, r0);	 Catch:{ Exception -> 0x008e }
        r0 = "success";
        r1.a(r0);	 Catch:{ Exception -> 0x008e }
    L_0x0082:
        r0 = com.a.a.a.ca.a;
        r0 = com.a.a.a.br.a(r0);
        r0.c();
    L_0x008b:
        return;
    L_0x008c:
        r0 = r1;
        goto L_0x0036;
    L_0x008e:
        r0 = move-exception;
        r0 = "notifyUploadSuccess error";
        com.a.a.a.fw.d(r0);	 Catch:{ all -> 0x009e }
        r0 = com.a.a.a.ca.a;
        r0 = com.a.a.a.br.a(r0);
        r0.c();
        goto L_0x008b;
    L_0x009e:
        r0 = move-exception;
        r1 = com.a.a.a.ca.a;
        r1 = com.a.a.a.br.a(r1);
        r1.c();
        throw r0;
    L_0x00a9:
        r0 = r1;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.bx.c():void");
    }

    public final void a(long j, long j2, String str) {
        cl bwVar = new bw(this);
        try {
            SQLiteDatabase b = br.a(ca.a).b();
            try {
                int b2 = bs.b(b, "system");
                cg.a;
                ContentValues contentValues;
                if (b2 < 128) {
                    contentValues = new ContentValues();
                    contentValues.put("key", str);
                    contentValues.put("timeStamp", Long.valueOf(j2));
                    contentValues.put("count", Long.valueOf(j));
                    b.insert("system", null, contentValues);
                } else if (b2 == 128) {
                    contentValues = new ContentValues();
                    contentValues.put("key", "__meta_ve_of");
                    contentValues.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("count", Integer.valueOf(1));
                    b.insert("system", null, contentValues);
                } else {
                    String str2 = "__meta_ve_of";
                    b.beginTransaction();
                    b.execSQL("update system set count=count+1 where key like '" + str2 + "'");
                    b.setTransactionSuccessful();
                    if (b != null) {
                        b.endTransaction();
                    }
                }
            } catch (SQLException e) {
                if (b != null) {
                    b.endTransaction();
                }
            } catch (SQLException e2) {
            } catch (Throwable th) {
                if (b != null) {
                    b.endTransaction();
                }
            }
            bwVar.a("success");
        } catch (Exception e3) {
            fw.d("package size to big or envelopeOverflowPackageCount exception");
        } finally {
            br.a(ca.a).c();
        }
    }
}
