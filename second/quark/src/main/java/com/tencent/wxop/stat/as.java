package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.p;
import com.tencent.wxop.stat.a.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class as {
    static p d = n.c();
    private static Context i = null;
    private static as j = null;
    d a = null;
    volatile int b = 0;
    a c = null;
    private aq e = null;
    private aq f = null;
    private String g = "";
    private String h = "";
    private int k = 0;
    private ConcurrentHashMap<com.tencent.wxop.stat.b.d, String> l = null;
    private boolean m = false;
    private HashMap<String, String> n = new HashMap();

    private as(Context context) {
        try {
            this.a = new d();
            i = context.getApplicationContext();
            this.l = new ConcurrentHashMap();
            this.g = n.p(context);
            this.h = "pri_" + n.p(context);
            this.e = new aq(i, this.g);
            this.f = new aq(i, this.h);
            a(true);
            a(false);
            c();
            b(i);
            g();
            h();
        } catch (Throwable th) {
            d.b(th);
        }
    }

    public static as a() {
        return j;
    }

    public static as a(Context context) {
        if (j == null) {
            synchronized (as.class) {
                if (j == null) {
                    j = new as(context);
                }
            }
        }
        return j;
    }

    private static String a(List<ar> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (ar arVar : list) {
            stringBuilder.append(arVar.a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private synchronized void a(int i, boolean z) {
        try {
            if (this.b > 0 && i > 0 && !ah.a()) {
                if (i.b()) {
                    d.a("Load " + this.b + " unsent events");
                }
                List arrayList = new ArrayList(i);
                b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (i.b()) {
                        d.a("Peek " + arrayList.size() + " unsent events.");
                    }
                    a(arrayList, 2, z);
                    n.b(i).a(arrayList, new ao(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            d.b(th);
        }
    }

    private synchronized void a(h hVar) {
        Cursor query;
        Throwable th;
        try {
            Object obj;
            long update;
            String jSONObject = hVar.b.toString();
            String a = n.a(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", hVar.b.toString());
            contentValues.put("md5sum", a);
            hVar.c = a;
            contentValues.put("version", Integer.valueOf(hVar.d));
            query = this.e.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != hVar.a);
            obj = 1;
            this.e.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.e.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(hVar.a)});
            } else {
                contentValues.put("type", Integer.valueOf(hVar.a));
                update = this.e.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                d.e("Failed to store cfg:" + jSONObject);
            } else {
                d.g("Sucessed to store cfg:" + jSONObject);
            }
            this.e.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.e.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.e.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    private synchronized void a(List<ar> list, int i, boolean z) {
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int g = !z ? i.g() : i.e();
                SQLiteDatabase b;
                try {
                    String str2;
                    b = b(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + a((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                d.b(th);
                                if (b != null) {
                                    try {
                                        b.endTransaction();
                                    } catch (Throwable th3) {
                                        d.b(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (b != null) {
                                    try {
                                        b.endTransaction();
                                    } catch (Throwable th5) {
                                        d.b(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    String str3 = "update events set status=" + i + " where " + a((List) list);
                    if (this.k % 3 == 0) {
                        str = "delete from events where send_count>" + g;
                    }
                    this.k++;
                    str2 = str3;
                    if (i.b()) {
                        d.a("update sql:" + str2);
                    }
                    b.beginTransaction();
                    b.execSQL(str2);
                    if (str != null) {
                        d.a("update for delete sql:" + str);
                        b.execSQL(str);
                        c();
                    }
                    b.setTransactionSuccessful();
                    if (b != null) {
                        try {
                            b.endTransaction();
                        } catch (Throwable th32) {
                            d.b(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    b = null;
                    if (b != null) {
                        b.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private synchronized void a(java.util.List<com.tencent.wxop.stat.ar> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.as.a(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.i.b();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = d;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.a(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.wxop.stat.ar) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.a;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.b(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.wxop.stat.i.b();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = d;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.a(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.b;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.b = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.c();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = d;	 Catch:{ all -> 0x00ce }
        r1.b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = d;	 Catch:{ all -> 0x00e6 }
        r2.b(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = d;	 Catch:{ all -> 0x00ce }
        r1.b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = d;	 Catch:{ all -> 0x00ce }
        r2.b(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.as.a(java.util.List, boolean):void");
    }

    private void a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = b(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (i.b()) {
                d.a("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    d.b(th);
                }
            }
        } catch (Throwable th2) {
            d.b(th2);
        }
    }

    private SQLiteDatabase b(boolean z) {
        return !z ? this.e.getWritableDatabase() : this.f.getWritableDatabase();
    }

    private synchronized void b(com.tencent.wxop.stat.b.d r7, com.tencent.wxop.stat.k r8, boolean r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.as.b(com.tencent.wxop.stat.b.d, com.tencent.wxop.stat.k, boolean, boolean):void. bs: [B:20:0x0092, B:51:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = com.tencent.wxop.stat.i.j();	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0008:
        r0 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x0010;
    L_0x000c:
        if (r9 != 0) goto L_0x0010;
    L_0x000e:
        if (r10 == 0) goto L_0x0110;
    L_0x0010:
        r1 = r6.b(r9);	 Catch:{ Throwable -> 0x00cf }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00cf }
        if (r9 != 0) goto L_0x003c;	 Catch:{ Throwable -> 0x00cf }
    L_0x0019:
        r0 = r6.b;	 Catch:{ Throwable -> 0x00cf }
        r2 = com.tencent.wxop.stat.i.j();	 Catch:{ Throwable -> 0x00cf }
        if (r0 <= r2) goto L_0x003c;	 Catch:{ Throwable -> 0x00cf }
    L_0x0021:
        r0 = d;	 Catch:{ Throwable -> 0x00cf }
        r2 = "Too many events stored in db.";	 Catch:{ Throwable -> 0x00cf }
        r0.b(r2);	 Catch:{ Throwable -> 0x00cf }
        r0 = r6.b;	 Catch:{ Throwable -> 0x00cf }
        r2 = r6.e;	 Catch:{ Throwable -> 0x00cf }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00cf }
        r3 = "events";	 Catch:{ Throwable -> 0x00cf }
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";	 Catch:{ Throwable -> 0x00cf }
        r5 = 0;	 Catch:{ Throwable -> 0x00cf }
        r2 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x00cf }
        r0 = r0 - r2;	 Catch:{ Throwable -> 0x00cf }
        r6.b = r0;	 Catch:{ Throwable -> 0x00cf }
    L_0x003c:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00cf }
        r0.<init>();	 Catch:{ Throwable -> 0x00cf }
        r2 = r7.f();	 Catch:{ Throwable -> 0x00cf }
        r3 = com.tencent.wxop.stat.i.b();	 Catch:{ Throwable -> 0x00cf }
        if (r3 == 0) goto L_0x005f;	 Catch:{ Throwable -> 0x00cf }
    L_0x004b:
        r3 = d;	 Catch:{ Throwable -> 0x00cf }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cf }
        r5 = "insert 1 event, content:";	 Catch:{ Throwable -> 0x00cf }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00cf }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x00cf }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00cf }
        r3.a(r4);	 Catch:{ Throwable -> 0x00cf }
    L_0x005f:
        r2 = com.tencent.wxop.stat.a.s.b(r2);	 Catch:{ Throwable -> 0x00cf }
        r3 = "content";	 Catch:{ Throwable -> 0x00cf }
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x00cf }
        r2 = "send_count";	 Catch:{ Throwable -> 0x00cf }
        r3 = "0";	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "status";	 Catch:{ Throwable -> 0x00cf }
        r3 = 1;	 Catch:{ Throwable -> 0x00cf }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "timestamp";	 Catch:{ Throwable -> 0x00cf }
        r4 = r7.c();	 Catch:{ Throwable -> 0x00cf }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "events";	 Catch:{ Throwable -> 0x00cf }
        r3 = 0;	 Catch:{ Throwable -> 0x00cf }
        r2 = r1.insert(r2, r3, r0);	 Catch:{ Throwable -> 0x00cf }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00cf }
        if (r1 == 0) goto L_0x018a;
    L_0x0092:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c7 }
        r0 = r2;
    L_0x0096:
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00f7;
    L_0x009c:
        r0 = r6.b;	 Catch:{ all -> 0x00ed }
        r0 = r0 + 1;	 Catch:{ all -> 0x00ed }
        r6.b = r0;	 Catch:{ all -> 0x00ed }
        r0 = com.tencent.wxop.stat.i.b();	 Catch:{ all -> 0x00ed }
        if (r0 == 0) goto L_0x00c0;	 Catch:{ all -> 0x00ed }
    L_0x00a8:
        r0 = d;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "directStoreEvent insert event to db, event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.f();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.g(r1);	 Catch:{ all -> 0x00ed }
    L_0x00c0:
        if (r8 == 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x00c2:
        r8.a();	 Catch:{ all -> 0x00ed }
    L_0x00c5:
        monitor-exit(r6);
        return;
    L_0x00c7:
        r0 = move-exception;
        r1 = d;	 Catch:{ all -> 0x00ed }
        r1.b(r0);	 Catch:{ all -> 0x00ed }
        r0 = r2;
        goto L_0x0096;
    L_0x00cf:
        r0 = move-exception;
        r2 = -1;
        r4 = d;	 Catch:{ all -> 0x00e6 }
        r4.b(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x018a;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        r0 = r2;
        goto L_0x0096;
    L_0x00de:
        r0 = move-exception;
        r1 = d;	 Catch:{ all -> 0x00ed }
        r1.b(r0);	 Catch:{ all -> 0x00ed }
        r0 = r2;
        goto L_0x0096;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00f0 }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ed }
    L_0x00ed:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x00f0:
        r1 = move-exception;
        r2 = d;	 Catch:{ all -> 0x00ed }
        r2.b(r1);	 Catch:{ all -> 0x00ed }
        goto L_0x00ec;	 Catch:{ all -> 0x00ed }
    L_0x00f7:
        r0 = d;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "Failed to store event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.f();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.d(r1);	 Catch:{ all -> 0x00ed }
        goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0110:
        r0 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0114:
        r0 = com.tencent.wxop.stat.i.b();	 Catch:{ all -> 0x00ed }
        if (r0 == 0) goto L_0x0164;	 Catch:{ all -> 0x00ed }
    L_0x011a:
        r0 = d;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "cacheEventsInMemory.size():";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r6.l;	 Catch:{ all -> 0x00ed }
        r2 = r2.size();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = ",numStoredEvents:";	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = r6.b;	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.a(r1);	 Catch:{ all -> 0x00ed }
        r0 = d;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "cache event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.f();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.a(r1);	 Catch:{ all -> 0x00ed }
    L_0x0164:
        r0 = r6.l;	 Catch:{ all -> 0x00ed }
        r1 = "";	 Catch:{ all -> 0x00ed }
        r0.put(r7, r1);	 Catch:{ all -> 0x00ed }
        r0 = r6.l;	 Catch:{ all -> 0x00ed }
        r0 = r0.size();	 Catch:{ all -> 0x00ed }
        r1 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x00ed }
        if (r0 < r1) goto L_0x0178;	 Catch:{ all -> 0x00ed }
    L_0x0175:
        r6.f();	 Catch:{ all -> 0x00ed }
    L_0x0178:
        if (r8 == 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x017a:
        r0 = r6.l;	 Catch:{ all -> 0x00ed }
        r0 = r0.size();	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x0185;	 Catch:{ all -> 0x00ed }
    L_0x0182:
        r6.f();	 Catch:{ all -> 0x00ed }
    L_0x0185:
        r8.a();	 Catch:{ all -> 0x00ed }
        goto L_0x00c5;
    L_0x018a:
        r0 = r2;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.as.b(com.tencent.wxop.stat.b.d, com.tencent.wxop.stat.k, boolean, boolean):void");
    }

    private void b(List<ar> list, int i, boolean z) {
        SQLiteDatabase readableDatabase;
        Throwable th;
        Cursor cursor;
        if (z) {
            readableDatabase = this.f.getReadableDatabase();
        } else {
            try {
                readableDatabase = this.e.getReadableDatabase();
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        cursor = readableDatabase.query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
        while (cursor.moveToNext()) {
            try {
                long j = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!i.g) {
                    string = s.a(string);
                }
                int i2 = cursor.getInt(2);
                int i3 = cursor.getInt(3);
                ar arVar = new ar(j, string, i2, i3);
                if (i.b()) {
                    d.a("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursor.getLong(4));
                }
                list.add(arVar);
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    private void c() {
        this.b = d() + e();
    }

    private int d() {
        return (int) DatabaseUtils.queryNumEntries(this.e.getReadableDatabase(), "events");
    }

    private int e() {
        return (int) DatabaseUtils.queryNumEntries(this.f.getReadableDatabase(), "events");
    }

    private void f() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.as.f():void. bs: [B:42:0x011b, B:53:0x0133]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.l;
        monitor-enter(r2);
        r0 = r9.l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.i.b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = d;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.b;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.a(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.e;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.l;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.tencent.wxop.stat.b.d) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.f();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.tencent.wxop.stat.i.b();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = d;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.a(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.tencent.wxop.stat.a.s.b(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.c();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = d;	 Catch:{ all -> 0x0130 }
        r3.b(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.c();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.i.b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = d;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.i.n;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.b;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.a(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.c();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = d;	 Catch:{ all -> 0x0013 }
        r1.b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = d;	 Catch:{ all -> 0x0013 }
        r1.b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.c();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = d;	 Catch:{ all -> 0x0013 }
        r3.b(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.as.f():void");
    }

    private void g() {
        Throwable th;
        Cursor query;
        try {
            query = this.e.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    h hVar = new h(i);
                    hVar.a = i;
                    hVar.b = new JSONObject(string);
                    hVar.c = string2;
                    hVar.d = i2;
                    i.a(i, hVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void h() {
        Throwable th;
        Cursor query;
        try {
            query = this.e.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.n.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    final void a(int i) {
        this.a.a(new ap(this, i));
    }

    final void a(com.tencent.wxop.stat.b.d dVar, k kVar, boolean z, boolean z2) {
        if (this.a != null) {
            this.a.a(new am(this, dVar, kVar, z, z2));
        }
    }

    public final synchronized a b(Context context) {
        a aVar;
        Throwable th;
        Cursor cursor;
        if (this.c != null) {
            aVar = this.c;
        } else {
            Cursor query;
            try {
                this.e.getWritableDatabase().beginTransaction();
                if (i.b()) {
                    d.a((Object) "try to load user info from db.");
                }
                query = this.e.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = s.a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || n.a(query.getLong(3) * 1000).equals(n.a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(n.m(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = n.b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = s.a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = n.c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.c = new a(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", s.b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", n.m(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.e.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.e.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = n.b(context);
                        b = n.c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String m = n.m(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", s.b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", m);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.e.getWritableDatabase().insert("user", null, contentValues2);
                        this.c = new a(string, b, 0);
                    }
                    this.e.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            d.b(th2);
                        }
                    }
                    this.e.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.e.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.e.getWritableDatabase().endTransaction();
                throw th2;
            }
            aVar = this.c;
        }
        return aVar;
    }

    static /* synthetic */ void a(as asVar, int i, boolean z) {
        int d = i == -1 ? !z ? asVar.d() : asVar.e() : i;
        if (d > 0) {
            int l = (i.l() * 60) * i.h();
            if (d > l && l > 0) {
                d = l;
            }
            int i2 = i.i();
            int i3 = d / i2;
            int i4 = d % i2;
            if (i.b()) {
                d.a("sentStoreEventsByDb sendNumbers=" + d + ",important=" + z + ",maxSendNumPerFor1Period=" + l + ",maxCount=" + i3 + ",restNumbers=" + i4);
            }
            for (d = 0; d < i3; d++) {
                asVar.a(i2, z);
            }
            if (i4 > 0) {
                asVar.a(i4, z);
            }
        }
    }
}
