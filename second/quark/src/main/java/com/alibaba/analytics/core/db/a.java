package com.alibaba.analytics.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class a {
    private HashMap<String, Boolean> a = new HashMap();
    private c b;
    private String c;
    private HashMap<Class<?>, List<Field>> d = new HashMap();
    private HashMap<Field, String> e = new HashMap();
    private HashMap<Class<?>, String> f = new HashMap();
    private String g = null;

    public a(Context context, String str) {
        this.b = new c(context, str);
        this.c = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<? extends com.alibaba.analytics.core.db.g> a(java.lang.Class<? extends com.alibaba.analytics.core.db.g> r15, java.lang.String r16, java.lang.String r17, int r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r2 = java.util.Collections.EMPTY_LIST;	 Catch:{ all -> 0x001f }
        if (r15 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r14);
        return r2;
    L_0x0007:
        r3 = r14.a(r15);	 Catch:{ all -> 0x001f }
        r8 = r14.a(r15, r3);	 Catch:{ all -> 0x001f }
        if (r8 != 0) goto L_0x0022;
    L_0x0011:
        r3 = "DBMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001f }
        r5 = 0;
        r6 = "db is null";
        r4[r5] = r6;	 Catch:{ all -> 0x001f }
        com.alibaba.analytics.a.af.a(r3, r4);	 Catch:{ all -> 0x001f }
        goto L_0x0005;
    L_0x001f:
        r2 = move-exception;
        monitor-exit(r14);
        throw r2;
    L_0x0022:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001f }
        r5 = "SELECT * FROM ";
        r4.<init>(r5);	 Catch:{ all -> 0x001f }
        r4 = r4.append(r3);	 Catch:{ all -> 0x001f }
        r3 = android.text.TextUtils.isEmpty(r16);	 Catch:{ all -> 0x001f }
        if (r3 == 0) goto L_0x00b4;
    L_0x0033:
        r3 = "";
    L_0x0035:
        r4 = r4.append(r3);	 Catch:{ all -> 0x001f }
        r3 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x001f }
        if (r3 == 0) goto L_0x00c7;
    L_0x003f:
        r3 = "";
    L_0x0041:
        r4 = r4.append(r3);	 Catch:{ all -> 0x001f }
        if (r18 > 0) goto L_0x00da;
    L_0x0047:
        r3 = "";
    L_0x0049:
        r3 = r4.append(r3);	 Catch:{ all -> 0x001f }
        r3 = r3.toString();	 Catch:{ all -> 0x001f }
        r4 = "DBMgr";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x001f }
        r6 = 0;
        r7 = "sql";
        r5[r6] = r7;	 Catch:{ all -> 0x001f }
        r6 = 1;
        r5[r6] = r3;	 Catch:{ all -> 0x001f }
        com.alibaba.analytics.a.af.a(r4, r5);	 Catch:{ all -> 0x001f }
        r4 = 0;
        r5 = 0;
        r5 = r8.rawQuery(r3, r5);	 Catch:{ Throwable -> 0x0170, all -> 0x016a }
        r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0172, all -> 0x0152 }
        r4.<init>();	 Catch:{ Throwable -> 0x0172, all -> 0x0152 }
        r9 = r14.e(r15);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
    L_0x0070:
        if (r5 == 0) goto L_0x015c;
    L_0x0072:
        r2 = r5.moveToNext();	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        if (r2 == 0) goto L_0x015c;
    L_0x0078:
        r2 = r15.newInstance();	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r0 = r2;
        r0 = (com.alibaba.analytics.core.db.g) r0;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r3 = r0;
        r2 = 0;
        r7 = r2;
    L_0x0082:
        r2 = r9.size();	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        if (r7 >= r2) goto L_0x014d;
    L_0x0088:
        r2 = r9.get(r7);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r2 = (java.lang.reflect.Field) r2;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r6 = r2.getType();	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r10 = r14.a(r2);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r11 = r5.getColumnIndex(r10);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r12 = -1;
        if (r11 == r12) goto L_0x0114;
    L_0x009d:
        r10 = java.lang.Long.class;
        if (r6 == r10) goto L_0x00a5;
    L_0x00a1:
        r10 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        if (r6 != r10) goto L_0x00ed;
    L_0x00a5:
        r10 = r5.getLong(r11);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r6 = java.lang.Long.valueOf(r10);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
    L_0x00ad:
        r2.set(r3, r6);	 Catch:{ Exception -> 0x0167 }
    L_0x00b0:
        r2 = r7 + 1;
        r7 = r2;
        goto L_0x0082;
    L_0x00b4:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001f }
        r5 = " WHERE ";
        r3.<init>(r5);	 Catch:{ all -> 0x001f }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ all -> 0x001f }
        r3 = r3.toString();	 Catch:{ all -> 0x001f }
        goto L_0x0035;
    L_0x00c7:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001f }
        r5 = " ORDER BY ";
        r3.<init>(r5);	 Catch:{ all -> 0x001f }
        r0 = r17;
        r3 = r3.append(r0);	 Catch:{ all -> 0x001f }
        r3 = r3.toString();	 Catch:{ all -> 0x001f }
        goto L_0x0041;
    L_0x00da:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001f }
        r5 = " LIMIT ";
        r3.<init>(r5);	 Catch:{ all -> 0x001f }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ all -> 0x001f }
        r3 = r3.toString();	 Catch:{ all -> 0x001f }
        goto L_0x0049;
    L_0x00ed:
        r10 = java.lang.Integer.class;
        if (r6 == r10) goto L_0x00f5;
    L_0x00f1:
        r10 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        if (r6 != r10) goto L_0x00fe;
    L_0x00f5:
        r6 = r5.getInt(r11);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        goto L_0x00ad;
    L_0x00fe:
        r10 = java.lang.Double.TYPE;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        if (r6 == r10) goto L_0x0106;
    L_0x0102:
        r10 = java.lang.Double.class;
        if (r6 != r10) goto L_0x010f;
    L_0x0106:
        r10 = r5.getDouble(r11);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r6 = java.lang.Double.valueOf(r10);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        goto L_0x00ad;
    L_0x010f:
        r6 = r5.getString(r11);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        goto L_0x00ad;
    L_0x0114:
        r2 = "DBMgr";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r11 = 0;
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r13 = "can not get field: ";
        r12.<init>(r13);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r10 = r12.append(r10);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        r6[r11] = r10;	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        com.alibaba.analytics.a.af.c(r2, r6);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        goto L_0x00b0;
    L_0x012f:
        r2 = move-exception;
        r3 = r2;
        r2 = r4;
        r4 = r5;
    L_0x0133:
        r5 = "DBMgr";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x016d }
        r7 = 0;
        r9 = "[get]";
        r6[r7] = r9;	 Catch:{ all -> 0x016d }
        r7 = 1;
        r6[r7] = r3;	 Catch:{ all -> 0x016d }
        com.alibaba.analytics.a.af.c(r5, r6);	 Catch:{ all -> 0x016d }
        com.alibaba.analytics.core.db.c.a(r4);	 Catch:{ all -> 0x001f }
        r3 = r14.b;	 Catch:{ all -> 0x001f }
        r3.a(r8);	 Catch:{ all -> 0x001f }
        goto L_0x0005;
    L_0x014d:
        r4.add(r3);	 Catch:{ Throwable -> 0x012f, all -> 0x0152 }
        goto L_0x0070;
    L_0x0152:
        r2 = move-exception;
    L_0x0153:
        com.alibaba.analytics.core.db.c.a(r5);	 Catch:{ all -> 0x001f }
        r3 = r14.b;	 Catch:{ all -> 0x001f }
        r3.a(r8);	 Catch:{ all -> 0x001f }
        throw r2;	 Catch:{ all -> 0x001f }
    L_0x015c:
        com.alibaba.analytics.core.db.c.a(r5);	 Catch:{ all -> 0x001f }
        r2 = r14.b;	 Catch:{ all -> 0x001f }
        r2.a(r8);	 Catch:{ all -> 0x001f }
        r2 = r4;
        goto L_0x0005;
    L_0x0167:
        r2 = move-exception;
        goto L_0x00b0;
    L_0x016a:
        r2 = move-exception;
        r5 = r4;
        goto L_0x0153;
    L_0x016d:
        r2 = move-exception;
        r5 = r4;
        goto L_0x0153;
    L_0x0170:
        r3 = move-exception;
        goto L_0x0133;
    L_0x0172:
        r3 = move-exception;
        r4 = r5;
        goto L_0x0133;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.db.a.a(java.lang.Class, java.lang.String, java.lang.String, int):java.util.List<? extends com.alibaba.analytics.core.db.g>");
    }

    public final synchronized void a(List<? extends g> list) {
        if (!(list == null || list.size() == 0)) {
            String a = a(((g) list.get(0)).getClass());
            SQLiteDatabase a2 = a(((g) list.get(0)).getClass(), a);
            if (a2 == null) {
                af.c("DBMgr", "can not get available db");
            } else {
                List e = e(((g) list.get(0)).getClass());
                ContentValues contentValues = new ContentValues();
                a2.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    g gVar = (g) list.get(i);
                    for (int i2 = 0; i2 < e.size(); i2++) {
                        Field field = (Field) e.get(i2);
                        String a3 = a(field);
                        try {
                            Object obj = field.get(gVar);
                            if (obj != null) {
                                contentValues.put(a3, String.valueOf(obj));
                            } else {
                                contentValues.put(a3, "");
                            }
                        } catch (Exception e2) {
                            af.c("DBMgr", "get field failed", e2);
                        } catch (Throwable th) {
                            try {
                                this.g = th.getLocalizedMessage();
                                try {
                                    a2.endTransaction();
                                } catch (Exception e3) {
                                }
                                this.b.a(a2);
                            } finally {
                                try {
                                    a2.setTransactionSuccessful();
                                } catch (Exception e4) {
                                }
                                try {
                                    a2.endTransaction();
                                } catch (Exception e5) {
                                }
                                this.b.a(a2);
                            }
                        }
                    }
                    if (gVar.j == -1) {
                        contentValues.remove("_id");
                        long insert = a2.insert(a, null, contentValues);
                        if (insert != -1) {
                            gVar.j = insert;
                            af.a("DBMgr", "mDbName", this.c, "tablename", a, "insert:success", gVar);
                        } else {
                            af.c("DBMgr", "mDbName", this.c, "tablename", a, "insert:error", gVar);
                        }
                    } else {
                        long update = (long) a2.update(a, contentValues, "_id=?", new String[]{String.valueOf(gVar.j)});
                        af.c("DBMgr", "db update :" + update);
                    }
                    contentValues.clear();
                }
                try {
                    a2.setTransactionSuccessful();
                } catch (Exception e6) {
                }
                try {
                    a2.endTransaction();
                } catch (Exception e7) {
                }
                this.b.a(a2);
            }
        }
    }

    public final synchronized int b(List<? extends g> list) {
        int i;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase a;
            if (list != null) {
                if (list.size() != 0) {
                    String a2 = a(((g) list.get(0)).getClass());
                    a = a(((g) list.get(0)).getClass(), a2);
                    if (a == null) {
                        af.a("DBMgr", "db is null");
                        i = 0;
                    } else {
                        try {
                            a.beginTransaction();
                            while (i2 < list.size()) {
                                if (((long) a.delete(a2, "_id=?", new String[]{((g) list.get(i2)).j})) <= 0) {
                                    af.c("DBMgr", "db", this.c, "tableName", a2, " delete failed ", Long.valueOf(((g) list.get(i2)).j));
                                } else {
                                    af.a("DBMgr", "db ", this.c, "tableName", a2, "delete success ", Long.valueOf(((g) list.get(i2)).j));
                                    ((g) list.get(i2)).j = -1;
                                }
                                i2++;
                            }
                            try {
                                a.setTransactionSuccessful();
                            } catch (Throwable th) {
                            }
                            try {
                                a.endTransaction();
                            } catch (Throwable th2) {
                            }
                            this.b.a(a);
                        } catch (Throwable th3) {
                        }
                        i = list.size();
                    }
                }
            }
            i = 0;
        }
        return i;
        a.endTransaction();
        this.b.a(a);
        i = list.size();
        return i;
        a.endTransaction();
        this.b.a(a);
        this.b.a(a);
        i = list.size();
        return i;
        this.b.a(a);
    }

    public final synchronized void c(List<? extends g> list) {
        if (list.size() != 0) {
            String a = a(((g) list.get(0)).getClass());
            SQLiteDatabase a2 = a(((g) list.get(0)).getClass(), a);
            if (a2 == null) {
                af.c("DBMgr", "[update] db is null");
            } else {
                try {
                    a2.beginTransaction();
                    List e = e(((g) list.get(0)).getClass());
                    for (int i = 0; i < list.size(); i++) {
                        ContentValues contentValues = new ContentValues();
                        for (int i2 = 0; i2 < e.size(); i2++) {
                            Field field = (Field) e.get(i2);
                            try {
                                field.setAccessible(true);
                                contentValues.put(a(field), field.get(list.get(i)));
                            } catch (Exception e2) {
                            } catch (Exception e3) {
                                af.c("DBMgr", "setTransactionSuccessful", e3);
                            } catch (Throwable th) {
                                try {
                                    a2.setTransactionSuccessful();
                                } catch (Exception e4) {
                                    af.c("DBMgr", "setTransactionSuccessful", e4);
                                }
                                try {
                                    a2.endTransaction();
                                } catch (Exception e42) {
                                    af.c("DBMgr", "endTransaction", e42);
                                }
                                this.b.a(a2);
                            }
                        }
                        a2.update(a, contentValues, "_id=?", new String[]{((g) list.get(i)).j});
                    }
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (Exception e32) {
                        af.c("DBMgr", "endTransaction", e32);
                    }
                    this.b.a(a2);
                } catch (Exception e5) {
                    try {
                        a2.setTransactionSuccessful();
                    } catch (Exception e322) {
                        af.c("DBMgr", "setTransactionSuccessful", e322);
                    }
                    try {
                        a2.endTransaction();
                    } catch (Exception e3222) {
                        af.c("DBMgr", "endTransaction", e3222);
                    }
                    this.b.a(a2);
                } catch (Throwable th2) {
                    try {
                        a2.setTransactionSuccessful();
                    } catch (Exception e422) {
                        af.c("DBMgr", "setTransactionSuccessful", e422);
                    }
                    try {
                        a2.endTransaction();
                    } catch (Exception e4222) {
                        af.c("DBMgr", "endTransaction", e4222);
                    }
                    this.b.a(a2);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(java.util.List<? extends com.alibaba.analytics.core.db.g> r15) {
        /*
        r14 = this;
        r2 = 0;
        monitor-enter(r14);
        if (r15 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r15.size();	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r14);
        return;
    L_0x000c:
        r0 = 0;
        r0 = r15.get(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.alibaba.analytics.core.db.g) r0;	 Catch:{ all -> 0x003a }
        r0 = r0.getClass();	 Catch:{ all -> 0x003a }
        r4 = r14.a(r0);	 Catch:{ all -> 0x003a }
        r0 = 0;
        r0 = r15.get(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.alibaba.analytics.core.db.g) r0;	 Catch:{ all -> 0x003a }
        r0 = r0.getClass();	 Catch:{ all -> 0x003a }
        r5 = r14.a(r0, r4);	 Catch:{ all -> 0x003a }
        if (r5 != 0) goto L_0x003d;
    L_0x002c:
        r0 = "DBMgr";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x003a }
        r2 = 0;
        r3 = "[update] db is null";
        r1[r2] = r3;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r0, r1);	 Catch:{ all -> 0x003a }
        goto L_0x000a;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r14);
        throw r0;
    L_0x003d:
        r5.beginTransaction();	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r0 = 0;
        r0 = r15.get(r0);	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r0 = (com.alibaba.analytics.core.db.g) r0;	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r0 = r0.getClass();	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r6 = r14.e(r0);	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r3 = r2;
    L_0x0050:
        r0 = r15.size();	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        if (r3 >= r0) goto L_0x00bb;
    L_0x0056:
        r7 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r7.<init>();	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r1 = r2;
    L_0x005c:
        r0 = r6.size();	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        if (r1 >= r0) goto L_0x00b2;
    L_0x0062:
        r0 = r6.get(r1);	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r0 = (java.lang.reflect.Field) r0;	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        r8 = r14.a(r0);	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        if (r8 == 0) goto L_0x00b7;
    L_0x006e:
        r9 = "priority";
        r9 = r8.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x00ec, all -> 0x011e }
        if (r9 == 0) goto L_0x00b7;
    L_0x0076:
        r9 = 1;
        r0.setAccessible(r9);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r9.<init>();	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r10 = r15.get(r3);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r0.get(r10);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r9.append(r0);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r7.put(r8, r0);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r8 = "_id=?";
        r0 = 1;
        r9 = new java.lang.String[r0];	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r10 = 0;
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r11.<init>();	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r15.get(r3);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = (com.alibaba.analytics.core.db.g) r0;	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r12 = r0.j;	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r11.append(r12);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r9[r10] = r0;	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
        r5.update(r4, r7, r8, r9);	 Catch:{ Exception -> 0x00b6, all -> 0x011e }
    L_0x00b2:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0050;
    L_0x00b6:
        r0 = move-exception;
    L_0x00b7:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x005c;
    L_0x00bb:
        r5.setTransactionSuccessful();	 Catch:{ Exception -> 0x00c8 }
    L_0x00be:
        r5.endTransaction();	 Catch:{ Exception -> 0x00da }
    L_0x00c1:
        r0 = r14.b;	 Catch:{ all -> 0x003a }
        r0.a(r5);	 Catch:{ all -> 0x003a }
        goto L_0x000a;
    L_0x00c8:
        r0 = move-exception;
        r1 = "DBMgr";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x003a }
        r3 = 0;
        r4 = "setTransactionSuccessful";
        r2[r3] = r4;	 Catch:{ all -> 0x003a }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r1, r2);	 Catch:{ all -> 0x003a }
        goto L_0x00be;
    L_0x00da:
        r0 = move-exception;
        r1 = "DBMgr";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x003a }
        r3 = 0;
        r4 = "endTransaction";
        r2[r3] = r4;	 Catch:{ all -> 0x003a }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r1, r2);	 Catch:{ all -> 0x003a }
        goto L_0x00c1;
    L_0x00ec:
        r0 = move-exception;
        r5.setTransactionSuccessful();	 Catch:{ Exception -> 0x00fa }
    L_0x00f0:
        r5.endTransaction();	 Catch:{ Exception -> 0x010c }
    L_0x00f3:
        r0 = r14.b;	 Catch:{ all -> 0x003a }
        r0.a(r5);	 Catch:{ all -> 0x003a }
        goto L_0x000a;
    L_0x00fa:
        r0 = move-exception;
        r1 = "DBMgr";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x003a }
        r3 = 0;
        r4 = "setTransactionSuccessful";
        r2[r3] = r4;	 Catch:{ all -> 0x003a }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r1, r2);	 Catch:{ all -> 0x003a }
        goto L_0x00f0;
    L_0x010c:
        r0 = move-exception;
        r1 = "DBMgr";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x003a }
        r3 = 0;
        r4 = "endTransaction";
        r2[r3] = r4;	 Catch:{ all -> 0x003a }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r1, r2);	 Catch:{ all -> 0x003a }
        goto L_0x00f3;
    L_0x011e:
        r0 = move-exception;
        r5.setTransactionSuccessful();	 Catch:{ Exception -> 0x012b }
    L_0x0122:
        r5.endTransaction();	 Catch:{ Exception -> 0x013d }
    L_0x0125:
        r1 = r14.b;	 Catch:{ all -> 0x003a }
        r1.a(r5);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x012b:
        r1 = move-exception;
        r2 = "DBMgr";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x003a }
        r4 = 0;
        r6 = "setTransactionSuccessful";
        r3[r4] = r6;	 Catch:{ all -> 0x003a }
        r4 = 1;
        r3[r4] = r1;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r2, r3);	 Catch:{ all -> 0x003a }
        goto L_0x0122;
    L_0x013d:
        r1 = move-exception;
        r2 = "DBMgr";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x003a }
        r4 = 0;
        r6 = "endTransaction";
        r3[r4] = r6;	 Catch:{ all -> 0x003a }
        r4 = 1;
        r3[r4] = r1;	 Catch:{ all -> 0x003a }
        com.alibaba.analytics.a.af.c(r2, r3);	 Catch:{ all -> 0x003a }
        goto L_0x0125;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.db.a.d(java.util.List):void");
    }

    public final synchronized int a(Class<? extends g> cls, String str, String[] strArr) {
        int i = 0;
        synchronized (this) {
            af.a(null, "whereArgs", strArr, "", "whereArgs", strArr);
            if (cls != null) {
                SQLiteDatabase a = a(cls, a((Class) cls));
                if (a != null) {
                    try {
                        i = a.delete(a((Class) cls), str, strArr);
                    } catch (Throwable th) {
                        af.a("DBMgr", th, new Object[0]);
                    } finally {
                        this.b.a(a);
                    }
                }
            }
        }
        return i;
    }

    public final String a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (this.f.containsKey(cls)) {
            return (String) this.f.get(cls);
        }
        String replace;
        TableName tableName = (TableName) cls.getAnnotation(TableName.class);
        if (tableName == null || TextUtils.isEmpty(tableName.value())) {
            replace = cls.getName().replace(".", "_");
        } else {
            replace = tableName.value();
        }
        this.f.put(cls, replace);
        return replace;
    }

    private SQLiteDatabase a(Class<? extends g> cls, String str) {
        int i = 0;
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        Boolean valueOf = Boolean.valueOf(true);
        Boolean valueOf2;
        if (this.a.get(str) == null || !((Boolean) this.a.get(str)).booleanValue()) {
            valueOf2 = Boolean.valueOf(false);
        } else {
            valueOf2 = valueOf;
        }
        if (!(cls == null || r0.booleanValue() || writableDatabase == null)) {
            boolean z;
            List e = e(cls);
            ArrayList arrayList = new ArrayList();
            String str2 = " SELECT * FROM " + str + " LIMIT 0";
            if (e != null) {
                Cursor rawQuery;
                try {
                    rawQuery = writableDatabase.rawQuery(str2, null);
                } catch (Exception e2) {
                    af.a("DBMgr", "has not create talbe:", str);
                    rawQuery = null;
                }
                if (rawQuery == null) {
                    z = true;
                } else {
                    z = false;
                }
                while (i < e.size()) {
                    Field field = (Field) e.get(i);
                    if (!"_id".equalsIgnoreCase(a(field)) && (r1 || (rawQuery != null && rawQuery.getColumnIndex(a(field)) == -1))) {
                        arrayList.add(field);
                    }
                    i++;
                }
                c.a(rawQuery);
            } else {
                z = false;
            }
            if (z) {
                b(writableDatabase, str, arrayList);
            } else if (arrayList.size() > 0) {
                a(writableDatabase, str, arrayList);
            }
            this.a.put(str, Boolean.valueOf(true));
        }
        return writableDatabase;
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        String str2 = "ALTER TABLE " + str + " ADD COLUMN ";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(str2);
            stringBuilder.append(a((Field) arrayList.get(i))).append(" ").append(d(((Field) arrayList.get(i)).getType()));
            String stringBuilder2 = stringBuilder.toString();
            try {
                sQLiteDatabase.execSQL(stringBuilder2);
            } catch (Exception e) {
                af.c("DBMgr", "update db error...", e);
            }
            stringBuilder.delete(0, stringBuilder2.length());
            af.a("DBMgr", null, "excute sql:", stringBuilder2);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                String str2;
                if (i != 0) {
                    stringBuilder.append(",");
                }
                Class type = ((Field) arrayList.get(i)).getType();
                StringBuilder append = stringBuilder.append(" ").append(a((Field) arrayList.get(i))).append(" ").append(d(type)).append(" ");
                if (type == Long.TYPE || type == Integer.TYPE || type == Long.class) {
                    str2 = "default 0";
                } else {
                    str2 = "default \"\"";
                }
                append.append(str2);
            }
        }
        stringBuilder.append(" );");
        af.a("DBMgr", "excute sql:", stringBuilder.toString());
        try {
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (Exception e) {
            af.c("DBMgr", "create db error", e);
        }
    }

    private static String d(Class<?> cls) {
        if (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) {
            return "INTEGER";
        }
        return "TEXT";
    }

    public final synchronized int b(Class<? extends g> cls) {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            if (cls != null) {
                String a = a((Class) cls);
                SQLiteDatabase a2 = a(cls, a);
                if (a2 != null) {
                    try {
                        cursor = a2.rawQuery("SELECT count(*) FROM " + a, null);
                        if (cursor != null) {
                            cursor.moveToFirst();
                            i = cursor.getInt(0);
                        }
                    } catch (Throwable th) {
                    } finally {
                        c.a(cursor);
                        this.b.a(a2);
                    }
                } else {
                    af.a("DBMgr", "db is null");
                }
            }
        }
        return i;
    }

    public final synchronized void c(Class<? extends g> cls) {
        if (cls != null) {
            a(a((Class) cls));
        }
    }

    private synchronized void a(String str) {
        if (str != null) {
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete(str, null, null);
                    this.b.a(writableDatabase);
                }
            } catch (Throwable e) {
                af.b("delete db data", e, new Object[0]);
            }
        }
    }

    private List<Field> e(Class cls) {
        if (this.d.containsKey(cls)) {
            return (List) this.d.get(cls);
        }
        List<Field> emptyList = Collections.emptyList();
        if (cls == null) {
            return emptyList;
        }
        List<Field> arrayList = new ArrayList();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Ingore.class) == null && !field.isSynthetic()) {
                field.setAccessible(true);
                arrayList.add(field);
            }
        }
        if (!(cls.getSuperclass() == null || cls.getSuperclass() == Object.class)) {
            arrayList.addAll(e(cls.getSuperclass()));
        }
        this.d.put(cls, arrayList);
        return arrayList;
    }

    private String a(Field field) {
        if (this.e.containsKey(field)) {
            return (String) this.e.get(field);
        }
        String name;
        Column column = (Column) field.getAnnotation(Column.class);
        if (column == null || TextUtils.isEmpty(column.value())) {
            name = field.getName();
        } else {
            name = column.value();
        }
        this.e.put(field, name);
        return name;
    }
}
