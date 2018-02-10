package com.taobao.weex.b.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.mini.support.annotation.Nullable;
import com.taobao.weex.common.w;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProGuard */
public final class g implements i {
    private k a;
    private ExecutorService b;

    private boolean a(java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        r2 = r7.a;
        r3 = r2.a();
        if (r3 != 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = "weex_storage";
        r4 = new java.lang.StringBuilder;
        r5 = "set k-v to storage(key:";
        r4.<init>(r5);
        r4 = r4.append(r8);
        r5 = ",value:";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = ",isPersistent:";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r5 = ",allowRetry:";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = ")";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.taobao.weex.utils.WXLogUtils.d(r2, r4);
        r4 = "INSERT OR REPLACE INTO default_wx_storage VALUES (?,?,?,?);";
        r2 = 0;
        r5 = com.taobao.weex.b.c.k.a;
        r6 = new java.util.Date;
        r6.<init>();
        r5 = r5.format(r6);
        r2 = r3.compileStatement(r4);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r2.clearBindings();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = 1;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r2.bindString(r3, r8);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = 2;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r2.bindString(r3, r9);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = 3;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r2.bindString(r3, r5);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = 4;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        if (r10 == 0) goto L_0x0076;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
    L_0x0067:
        r4 = 1;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
    L_0x0069:
        r2.bindLong(r3, r4);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r2.execute();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        if (r2 == 0) goto L_0x0074;
    L_0x0071:
        r2.close();
    L_0x0074:
        r0 = r1;
        goto L_0x000a;
    L_0x0076:
        r4 = 0;
        goto L_0x0069;
    L_0x0079:
        r1 = move-exception;
        r3 = "weex_storage";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r5 = "DefaultWXStorage occurred an exception when execute setItem :";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r5 = r1.getMessage();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        com.taobao.weex.utils.WXLogUtils.e(r3, r4);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1 instanceof android.database.sqlite.SQLiteFullException;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        if (r1 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
    L_0x0096:
        if (r11 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
    L_0x0098:
        r1 = r7.d();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        if (r1 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
    L_0x009e:
        r0 = "weex_storage";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = "retry set k-v to storage(key:";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = ",value:";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r3 = ")";	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        com.taobao.weex.utils.WXLogUtils.d(r0, r1);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r0 = 0;	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        r0 = r7.a(r8, r9, r10, r0);	 Catch:{ Exception -> 0x0079, all -> 0x00d5 }
        if (r2 == 0) goto L_0x000a;
    L_0x00c9:
        r2.close();
        goto L_0x000a;
    L_0x00ce:
        if (r2 == 0) goto L_0x000a;
    L_0x00d0:
        r2.close();
        goto L_0x000a;
    L_0x00d5:
        r0 = move-exception;
        if (r2 == 0) goto L_0x00db;
    L_0x00d8:
        r2.close();
    L_0x00db:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.b.c.g.a(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    private void a(@Nullable Runnable runnable) {
        if (this.b == null) {
            this.b = Executors.newSingleThreadExecutor();
        }
        this.b.execute(w.a(runnable));
    }

    public g(Context context) {
        this.a = new k(context);
    }

    public final void a(String str, String str2, h hVar) {
        a(new a(this, str, str2, hVar));
    }

    public final void a(String str, h hVar) {
        a(new b(this, str, hVar));
    }

    public final void b(String str, h hVar) {
        a(new c(this, str, hVar));
    }

    public final void a(h hVar) {
        a(new d(this, hVar));
    }

    public final void b(h hVar) {
        a(new e(this, hVar));
    }

    public final void b(String str, String str2, h hVar) {
        a(new f(this, str, str2, hVar));
    }

    public final void a() {
        try {
            this.a.b();
            if (this.b != null) {
                this.b.shutdown();
                this.b = null;
            }
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", e.getMessage());
        }
    }

    private boolean d() {
        Exception exception;
        SQLiteDatabase a = this.a.a();
        if (a == null) {
            return false;
        }
        int i;
        List<String> arrayList = new ArrayList();
        Cursor query = a.query("default_wx_storage", new String[]{"key", "persistent"}, null, null, null, null, "timestamp ASC");
        try {
            int count = query.getCount() / 10;
            int i2 = 0;
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("key"));
                    if ((query.getInt(query.getColumnIndex("persistent")) == 1 ? 1 : 0) == 0 && string != null) {
                        i2++;
                        arrayList.add(string);
                        if (i2 == count) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    i = i2;
                    exception = exception2;
                }
            }
            query.close();
            i = i2;
        } catch (Exception e2) {
            exception = e2;
            i = 0;
            try {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute trimToSize:" + exception.getMessage());
                if (i <= 0) {
                    return false;
                }
                for (String b : arrayList) {
                    b(b);
                }
                WXLogUtils.e("weex_storage", "remove " + i + " items by lru");
                return true;
            } finally {
                query.close();
            }
        }
        if (i <= 0) {
            return false;
        }
        while (r2.hasNext()) {
            b(b);
        }
        WXLogUtils.e("weex_storage", "remove " + i + " items by lru");
        return true;
    }

    final String a(String str) {
        String str2 = null;
        SQLiteDatabase a = this.a.a();
        if (a != null) {
            Cursor query = a.query("default_wx_storage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("timestamp", k.a.format(new Date()));
                    WXLogUtils.d("weex_storage", "update timestamp " + (this.a.a().update("default_wx_storage", contentValues, "key= ?", new String[]{str}) == 1 ? "success" : "failed") + " for operation [getItem(key = " + str + ")]");
                    str2 = query.getString(query.getColumnIndex("value"));
                } else {
                    query.close();
                }
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getItem:" + e.getMessage());
            } finally {
                query.close();
            }
        }
        return str2;
    }

    final boolean b(String str) {
        SQLiteDatabase a = this.a.a();
        if (a == null) {
            return false;
        }
        try {
            if (a.delete("default_wx_storage", "key=?", new String[]{str}) == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute removeItem:" + e.getMessage());
            return false;
        }
    }

    final long b() {
        long j = 0;
        SQLiteDatabase a = this.a.a();
        if (a != null) {
            SQLiteStatement sQLiteStatement = null;
            try {
                sQLiteStatement = a.compileStatement("SELECT count(key) FROM default_wx_storage");
                j = sQLiteStatement.simpleQueryForLong();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getLength:" + e.getMessage());
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
            }
        }
        return j;
    }

    final List<String> c() {
        SQLiteDatabase a = this.a.a();
        if (a == null) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        Cursor query = a.query("default_wx_storage", new String[]{"key"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(query.getColumnIndex("key")));
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getAllKeys:" + e.getMessage());
                return arrayList;
            } finally {
                query.close();
            }
        }
        return arrayList;
    }
}
