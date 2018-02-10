package com.uc.base.wa.component;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.uc.base.wa.f.e;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ProGuard */
public final class h {
    public g a;
    ReentrantLock b;
    private ReentrantLock c;
    private LinkedList<b> d;

    private h() {
        this.a = null;
        this.b = new ReentrantLock();
        this.c = new ReentrantLock();
        this.d = new LinkedList();
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase, f fVar) {
        ContentValues contentValues = null;
        if (!(sQLiteDatabase == null || fVar == null || fVar.a == null || fVar.a.length() <= 0)) {
            String str;
            ContentValues contentValues2 = new ContentValues();
            switch (fVar.c) {
                case 1:
                    contentValues2.put("value", (Integer) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_int";
                    break;
                case 3:
                    contentValues2.put("value", (String) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_str";
                    break;
                case 4:
                    contentValues2.put("value", (Long) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_long";
                    break;
                default:
                    Log.e("WaSettingProvider", "insert '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                    str = null;
                    break;
            }
            if (contentValues != null) {
                contentValues.put("key", fVar.a);
                try {
                    sQLiteDatabase.insertOrThrow(str, null, contentValues);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean b(SQLiteDatabase sQLiteDatabase, f fVar) {
        ContentValues contentValues = null;
        if (!(sQLiteDatabase == null || fVar == null || fVar.a == null || fVar.a.length() <= 0)) {
            String str;
            ContentValues contentValues2 = new ContentValues();
            switch (fVar.c) {
                case 1:
                    contentValues2.put("value", (Integer) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_int";
                    break;
                case 3:
                    contentValues2.put("value", (String) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_str";
                    break;
                case 4:
                    contentValues2.put("value", (Long) fVar.b);
                    contentValues = contentValues2;
                    str = "tb_long";
                    break;
                default:
                    Log.e("WaSettingProvider", "update '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                    str = null;
                    break;
            }
            if (contentValues != null) {
                try {
                    sQLiteDatabase.update(str, contentValues, "key=?", new String[]{"'" + fVar.a + "'"});
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase, f fVar) {
        if (!(sQLiteDatabase == null || fVar == null || fVar.a == null || fVar.a.length() <= 0)) {
            long intValue;
            String str = null;
            switch (fVar.c) {
                case 1:
                    intValue = (long) ((Integer) fVar.b).intValue();
                    str = "tb_int";
                    break;
                case 4:
                    intValue = ((Long) fVar.b).longValue();
                    str = "tb_long";
                    break;
                default:
                    Log.e("WaSettingProvider", "increase '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                    intValue = 0;
                    break;
            }
            if (!(0 == intValue || str == null)) {
                try {
                    sQLiteDatabase.execSQL("update " + str + " set value=(select case when value is null then 0 else value end from " + str + " where key='" + fVar.a + "' limit 0,1)" + (intValue >= 0 ? "+" + intValue : Long.valueOf(intValue)) + " where key='" + fVar.a + "';");
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    private static f d(SQLiteDatabase sQLiteDatabase, f fVar) {
        Cursor cursor;
        Throwable th;
        if (!(sQLiteDatabase == null || fVar.a == null || fVar.a.length() <= 0)) {
            String str;
            switch (fVar.c) {
                case 1:
                    str = "tb_int";
                    break;
                case 3:
                    str = "tb_str";
                    break;
                case 4:
                    str = "tb_long";
                    break;
                default:
                    Log.e("WaSettingProvider", "query '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                    str = null;
                    break;
            }
            if (str != null) {
                Cursor query;
                try {
                    f fVar2;
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                    query = sQLiteDatabase2.query(str, new String[]{"key", "value"}, "key=?", new String[]{fVar.a}, null, null, null, "0, 1");
                    if (query != null) {
                        try {
                            if (query.getCount() > 0 && query.moveToFirst()) {
                                int columnIndex = query.getColumnIndex("value");
                                if (-1 != columnIndex) {
                                    switch (fVar.c) {
                                        case 1:
                                            fVar.b = Integer.valueOf(query.getInt(columnIndex));
                                            fVar2 = fVar;
                                            break;
                                        case 3:
                                            fVar.b = query.getString(columnIndex);
                                            fVar2 = fVar;
                                            break;
                                        case 4:
                                            fVar.b = Long.valueOf(query.getLong(columnIndex));
                                            fVar2 = fVar;
                                            break;
                                        default:
                                            Log.e("WaSettingProvider", "query '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                                            break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                                return null;
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                    fVar2 = null;
                    if (query == null) {
                        return fVar2;
                    }
                    query.close();
                    return fVar2;
                } catch (Exception e2) {
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    private static boolean e(SQLiteDatabase sQLiteDatabase, f fVar) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        boolean z = false;
        if (!(sQLiteDatabase == null || fVar == null || fVar.a == null || fVar.a.length() <= 0)) {
            String str;
            switch (fVar.c) {
                case 1:
                    str = "tb_int";
                    break;
                case 3:
                    str = "tb_str";
                    break;
                case 4:
                    str = "tb_long";
                    break;
                default:
                    Log.e("WaSettingProvider", "query '" + fVar.a + "' unknown dataType(" + fVar.c + ")");
                    str = null;
                    break;
            }
            if (str != null) {
                try {
                    Cursor query = sQLiteDatabase.query(str, new String[]{"key"}, "key=?", new String[]{fVar.a}, null, null, null, "0, 1");
                    if (query != null) {
                        try {
                            z = query.getCount() > 0;
                        } catch (Exception e) {
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        }
        return z;
    }

    private b a(b bVar) {
        this.c.lock();
        try {
            int indexOf = this.d.indexOf(bVar);
            if (-1 != indexOf) {
                b bVar2 = (b) this.d.remove(indexOf);
                if (bVar2 == null || !bVar2.equals(bVar)) {
                    bVar2 = null;
                } else {
                    Object obj;
                    switch (bVar.b) {
                        case 1:
                            if (bVar.a.c != 1) {
                                if (bVar.a.c != 4) {
                                    obj = bVar.a.b;
                                    break;
                                }
                                obj = Long.valueOf(((Long) bVar2.a.b).longValue() + ((Long) bVar.a.b).longValue());
                                break;
                            }
                            obj = Integer.valueOf(((Integer) bVar.a.b).intValue() + ((Integer) bVar2.a.b).intValue());
                            break;
                        default:
                            obj = bVar.a.b;
                            break;
                    }
                    bVar.d.addAll(bVar2.d);
                    bVar2 = new b(bVar.a.a, obj, bVar.a.c, bVar.b, bVar.d);
                }
                bVar = bVar2;
            }
            this.d.add(bVar);
            return bVar;
        } finally {
            this.c.unlock();
        }
    }

    final LinkedList<b> a() {
        this.c.lock();
        try {
            LinkedList<b> linkedList = this.d;
            this.d = new LinkedList();
            return linkedList;
        } finally {
            this.c.unlock();
        }
    }

    final boolean a(f fVar) {
        Throwable e;
        Throwable th;
        boolean z = false;
        SQLiteDatabase writableDatabase;
        boolean z2;
        try {
            writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.beginTransaction();
                    z2 = true;
                    try {
                        boolean b;
                        if (e(writableDatabase, fVar)) {
                            b = b(writableDatabase, fVar);
                        } else {
                            b = a(writableDatabase, fVar);
                        }
                        writableDatabase.setTransactionSuccessful();
                        z = b;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Log.e("WaSettingProvider", "upsertEx Failed!!!", e);
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception e3) {
                            }
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception e4) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    z2 = false;
                    Log.e("WaSettingProvider", "upsertEx Failed!!!", e);
                    writableDatabase.endTransaction();
                    return z;
                } catch (Throwable e6) {
                    z2 = false;
                    th = e6;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            z2 = false;
            if (writableDatabase != null && r2) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception e7) {
                }
            }
        } catch (Exception e8) {
            e6 = e8;
            writableDatabase = null;
            z2 = false;
            Log.e("WaSettingProvider", "upsertEx Failed!!!", e6);
            if (writableDatabase != null && r2) {
                writableDatabase.endTransaction();
            }
            return z;
        } catch (Throwable e62) {
            writableDatabase = null;
            z2 = false;
            th = e62;
            if (writableDatabase != null && r2) {
                writableDatabase.endTransaction();
            }
            throw th;
        }
        return z;
    }

    public final void a(boolean z) {
        Runnable aVar = new a(this);
        if (z) {
            aVar.run();
        } else {
            e.a(4, aVar);
        }
    }

    final boolean b(f fVar) {
        SQLiteDatabase writableDatabase;
        boolean z;
        Throwable e;
        Throwable th;
        boolean z2 = false;
        try {
            writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.beginTransaction();
                    z = true;
                    try {
                        boolean c;
                        if (e(writableDatabase, fVar)) {
                            c = c(writableDatabase, fVar);
                        } else {
                            c = a(writableDatabase, fVar);
                        }
                        writableDatabase.setTransactionSuccessful();
                        z2 = c;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Log.e("lzx_test", "increaseValueEx Failed!!", e);
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception e3) {
                            }
                            return z2;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception e4) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    z = false;
                    Log.e("lzx_test", "increaseValueEx Failed!!", e);
                    writableDatabase.endTransaction();
                    return z2;
                } catch (Throwable e6) {
                    z = false;
                    th = e6;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            z = false;
            if (writableDatabase != null && r2) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception e7) {
                }
            }
        } catch (Exception e8) {
            e6 = e8;
            writableDatabase = null;
            z = false;
            Log.e("lzx_test", "increaseValueEx Failed!!", e6);
            if (writableDatabase != null && r2) {
                writableDatabase.endTransaction();
            }
            return z2;
        } catch (Throwable e62) {
            writableDatabase = null;
            z = false;
            th = e62;
            if (writableDatabase != null && r2) {
                writableDatabase.endTransaction();
            }
            throw th;
        }
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object b(java.lang.String r5) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x002b;
    L_0x0003:
        r1 = r5.length();
        if (r1 <= 0) goto L_0x002b;
    L_0x0009:
        r1 = r4.b;
        r1.lock();
        r1 = r4.a;	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r1 = r1.getReadableDatabase();	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r2 = new com.uc.base.wa.component.f;	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r2.<init>();	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r2.a = r5;	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r3 = 4;
        r2.c = r3;	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        r1 = d(r1, r2);	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
        if (r1 == 0) goto L_0x0026;
    L_0x0024:
        r0 = r1.b;	 Catch:{ Exception -> 0x002c, all -> 0x0033 }
    L_0x0026:
        r1 = r4.b;
        r1.unlock();
    L_0x002b:
        return r0;
    L_0x002c:
        r1 = move-exception;
        r1 = r4.b;
        r1.unlock();
        goto L_0x002b;
    L_0x0033:
        r0 = move-exception;
        r1 = r4.b;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.component.h.b(java.lang.String):java.lang.Object");
    }

    public final long a(String str) {
        Object b = b(str);
        if (b == null) {
            return 0;
        }
        return ((Long) b).longValue();
    }

    public final void a(String str, long j) {
        a(new b(str, Long.valueOf(j)));
        a(false);
    }
}
