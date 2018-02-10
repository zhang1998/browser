package com.uc.quark.filedownloader.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.UCMobile.Apollo.Global;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.apollo.impl.SettingsConst;
import com.uc.quark.filedownloader.as;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.model.b;

/* compiled from: ProGuard */
public final class a {
    private static String[] a = new String[]{"_id", INoCaptchaComponent.status, "sofar", "total", "url", "path"};
    private static Context b;

    public static void a(Context context) {
        b = context;
    }

    public static long a(int i) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        f();
        try {
            Cursor query = b.getContentResolver().query(Uri.parse(e.a), null, "_id=?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        long j = query.getLong(query.getColumnIndex("sofar"));
                        if (query == null) {
                            return j;
                        }
                        query.close();
                        return j;
                    }
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
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
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return 0;
    }

    public static long b(int i) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        f();
        try {
            Cursor query = b.getContentResolver().query(Uri.parse(e.a), null, "_id=?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        long j = query.getLong(query.getColumnIndex("total"));
                        if (query == null) {
                            return j;
                        }
                        query.close();
                        return j;
                    }
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
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
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return 0;
    }

    public static int c(int i) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        f();
        try {
            Cursor query = b.getContentResolver().query(Uri.parse(e.a), null, "_id=?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i2 = (byte) query.getShort(query.getColumnIndex(INoCaptchaComponent.status));
                        as.a();
                        if (!(as.f() || i2 == -3 || i2 == -1)) {
                            i2 = -2;
                        }
                        if (query == null) {
                            return i2;
                        }
                        query.close();
                        return i2;
                    }
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
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
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return 0;
    }

    private static void f() {
        if (b == null) {
            throw new RuntimeException("FileStatusUtils Context is null,please invoke FileStatusUtils.init!");
        }
    }

    public static void d(int i) {
        f();
        try {
            b.getContentResolver().delete(Uri.parse(e.a), "_id = ?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
        }
    }

    public static String[] e(int i) {
        Cursor cursor;
        Throwable th;
        f();
        Cursor query;
        try {
            query = b.getContentResolver().query(Uri.parse(e.a), null, "_id=?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("url"));
                        String string2 = query.getString(query.getColumnIndex("path"));
                        String[] strArr = new String[]{string, string2};
                        if (query == null) {
                            return strArr;
                        }
                        query.close();
                        return strArr;
                    }
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
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
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
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
        return null;
    }

    public static void a(int i, long j, long j2, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -3));
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("path", str);
        e.a().getContentResolver().insert(Uri.parse(e.a), b.a(contentValues));
    }

    public static boolean f(int i) {
        Throwable th;
        Cursor cursor = null;
        f();
        Cursor query;
        try {
            query = b.getContentResolver().query(Uri.parse(e.a), null, "_id=?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        query.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return false;
    }

    public static int a() {
        Object e;
        Throwable th;
        f();
        Cursor query;
        try {
            query = e.a().getContentResolver().query(Uri.parse(e.b), null, "id=?", new String[]{SettingsConst.FALSE}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("thread_num"));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (j.a) {
                            Log.e("vanda", "getSettingThreadNum Ex = " + e);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            if (j.a) {
                Log.e("vanda", "getSettingThreadNum Ex = " + e);
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return 0;
    }

    public static void g(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", SettingsConst.FALSE);
            contentValues.put("thread_num", String.valueOf(i));
            e.a().getContentResolver().insert(Uri.parse(e.b), contentValues);
            e.a().getContentResolver().update(Uri.parse(e.b), contentValues, "id = ? ", new String[]{SettingsConst.FALSE});
        } catch (Exception e) {
        }
    }

    public static int b() {
        Object e;
        Throwable th;
        f();
        Cursor query;
        try {
            query = e.a().getContentResolver().query(Uri.parse(e.b), null, "id=?", new String[]{SettingsConst.TRUE}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("thread_num"));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (j.a) {
                            Log.e("vanda", "getSettingThreadNum Ex = " + e);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            if (j.a) {
                Log.e("vanda", "getSettingThreadNum Ex = " + e);
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return 0;
    }

    public static void h(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", SettingsConst.TRUE);
            contentValues.put("thread_num", String.valueOf(i));
            e.a().getContentResolver().insert(Uri.parse(e.b), contentValues);
            e.a().getContentResolver().update(Uri.parse(e.b), contentValues, "id = ? ", new String[]{SettingsConst.TRUE});
        } catch (Exception e) {
        }
    }

    public static int c() {
        Object e;
        Throwable th;
        f();
        Cursor query;
        try {
            query = e.a().getContentResolver().query(Uri.parse(e.b), null, "id=?", new String[]{Global.APOLLO_SERIES}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("thread_num"));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (j.a) {
                            Log.e("vanda", "getSettingThreadNum Ex = " + e);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            if (j.a) {
                Log.e("vanda", "getSettingThreadNum Ex = " + e);
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return 0;
    }

    public static void i(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Global.APOLLO_SERIES);
            contentValues.put("thread_num", String.valueOf(i));
            e.a().getContentResolver().insert(Uri.parse(e.b), contentValues);
            e.a().getContentResolver().update(Uri.parse(e.b), contentValues, "id = ? ", new String[]{Global.APOLLO_SERIES});
        } catch (Exception e) {
        }
    }

    public static int d() {
        Object e;
        Throwable th;
        f();
        Cursor query;
        try {
            query = e.a().getContentResolver().query(Uri.parse(e.b), null, "id=?", new String[]{"3"}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("thread_num"));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (j.a) {
                            Log.e("vanda", "getSettingThreadNum Ex = " + e);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            if (j.a) {
                Log.e("vanda", "getSettingThreadNum Ex = " + e);
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return 0;
    }

    public static boolean e() {
        Cursor query;
        Object e;
        Throwable th;
        f();
        try {
            query = e.a().getContentResolver().query(Uri.parse(e.b), null, "id=?", new String[]{"4"}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        boolean z = query.getInt(query.getColumnIndex("thread_num")) == 1;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (j.a) {
                            Log.e("vanda", "getSettingThreadNum Ex = " + e);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            if (j.a) {
                Log.e("vanda", "getSettingThreadNum Ex = " + e);
            }
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return false;
    }

    public static void a(boolean z) {
        int i = 1;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", "4");
            String str = "thread_num";
            StringBuilder stringBuilder = new StringBuilder();
            if (!z) {
                i = 0;
            }
            contentValues.put(str, stringBuilder.append(i).toString());
            e.a().getContentResolver().insert(Uri.parse(e.b), contentValues);
            e.a().getContentResolver().update(Uri.parse(e.b), contentValues, "id = ? ", new String[]{"4"});
        } catch (Exception e) {
        }
    }
}
