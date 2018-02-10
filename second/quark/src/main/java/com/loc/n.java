package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class n {
    private static Map<Class<? extends m>, m> d = new HashMap();
    private r a;
    private SQLiteDatabase b;
    private m c;

    public n(Context context, m mVar) {
        try {
            this.a = new r(context.getApplicationContext(), mVar.a(), mVar);
        } catch (Throwable th) {
        }
        this.c = mVar;
    }

    public n(Context context, m mVar, String str) {
        try {
            boolean equals = "mounted".equals(Environment.getExternalStorageState());
            if (!TextUtils.isEmpty(str) && equals) {
                context = new q(context.getApplicationContext(), str);
            }
            this.a = new r(context, mVar.a(), mVar);
        } catch (Throwable th) {
        }
        this.c = mVar;
    }

    private static ContentValues a(Object obj, ad adVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), adVar.b())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ae.class);
            if (annotation != null) {
                ae aeVar = (ae) annotation;
                switch (aeVar.b()) {
                    case 1:
                        contentValues.put(aeVar.a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        try {
                            contentValues.put(aeVar.a(), Integer.valueOf(field.getInt(obj)));
                            break;
                        } catch (IllegalAccessException e) {
                            break;
                        }
                    case 3:
                        contentValues.put(aeVar.a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(aeVar.a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(aeVar.a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(aeVar.a(), (String) field.get(obj));
                        break;
                    case 7:
                        contentValues.put(aeVar.a(), (byte[]) field.get(obj));
                        break;
                    default:
                        break;
                }
            }
        }
        return contentValues;
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            es.a(th, "DBOperation", "getWriteDatabase");
        }
        return this.b;
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                es.a(th, "DBOperation", "getReadAbleDataBase");
            }
        }
        return this.b;
    }

    public static synchronized m a(Class<? extends m> cls) throws IllegalAccessException, InstantiationException {
        m mVar;
        synchronized (n.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            mVar = (m) d.get(cls);
        }
        return mVar;
    }

    private static <T> T a(Cursor cursor, Class<T> cls, ad adVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a = a((Class) cls, adVar.b());
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ae.class);
            if (annotation != null) {
                ae aeVar = (ae) annotation;
                int b = aeVar.b();
                int columnIndex = cursor.getColumnIndex(aeVar.a());
                switch (b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                    default:
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> String a(ad adVar) {
        return adVar == null ? null : adVar.a();
    }

    public static String a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : map.keySet()) {
            if (obj != null) {
                stringBuilder.append(str).append(" = '").append((String) map.get(str)).append("'");
                obj = null;
            } else {
                stringBuilder.append(" and ").append(str).append(" = '").append((String) map.get(str)).append("'");
            }
        }
        return stringBuilder.toString();
    }

    private static Field[] a(Class<?> cls, boolean z) {
        return cls == null ? null : z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private static <T> ad b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(ad.class);
        return (annotation != null ? 1 : null) == null ? null : (ad) annotation;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> a(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
        r12 = this;
        r9 = 0;
        r10 = r12.c;
        monitor-enter(r10);
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x0094 }
        r8.<init>();	 Catch:{ all -> 0x0094 }
        r11 = b(r14);	 Catch:{ all -> 0x0094 }
        r1 = a(r11);	 Catch:{ all -> 0x0094 }
        r0 = r12.b;	 Catch:{ all -> 0x0094 }
        if (r0 != 0) goto L_0x001b;
    L_0x0015:
        r0 = r12.a(r15);	 Catch:{ all -> 0x0094 }
        r12.b = r0;	 Catch:{ all -> 0x0094 }
    L_0x001b:
        r0 = r12.b;	 Catch:{ all -> 0x0094 }
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0094 }
        if (r0 != 0) goto L_0x0027;
    L_0x0025:
        if (r13 != 0) goto L_0x002a;
    L_0x0027:
        monitor-exit(r10);	 Catch:{ all -> 0x0094 }
        r0 = r8;
    L_0x0029:
        return r0;
    L_0x002a:
        r0 = r12.b;	 Catch:{ Throwable -> 0x0106, all -> 0x0080 }
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r13;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0106, all -> 0x0080 }
        if (r1 != 0) goto L_0x0054;
    L_0x0038:
        r0 = r12.b;	 Catch:{ Throwable -> 0x0062 }
        r0.close();	 Catch:{ Throwable -> 0x0062 }
        r0 = 0;
        r12.b = r0;	 Catch:{ Throwable -> 0x0062 }
        if (r1 == 0) goto L_0x0045;
    L_0x0042:
        r1.close();	 Catch:{ Throwable -> 0x00c3 }
    L_0x0045:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00cf }
        if (r0 == 0) goto L_0x0051;
    L_0x0049:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00cf }
        r0.close();	 Catch:{ Throwable -> 0x00cf }
        r0 = 0;
        r12.b = r0;	 Catch:{ Throwable -> 0x00cf }
    L_0x0051:
        monitor-exit(r10);	 Catch:{ all -> 0x0094 }
        r0 = r8;
        goto L_0x0029;
    L_0x0054:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0062 }
        if (r0 == 0) goto L_0x00db;
    L_0x005a:
        r0 = a(r1, r14, r11);	 Catch:{ Throwable -> 0x0062 }
        r8.add(r0);	 Catch:{ Throwable -> 0x0062 }
        goto L_0x0054;
    L_0x0062:
        r0 = move-exception;
    L_0x0063:
        if (r15 != 0) goto L_0x006c;
    L_0x0065:
        r2 = "DataBase";
        r3 = "searchListData";
        com.loc.es.a(r0, r2, r3);	 Catch:{ all -> 0x0103 }
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();	 Catch:{ Throwable -> 0x00ad }
    L_0x0071:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00b8 }
        if (r0 == 0) goto L_0x007d;
    L_0x0075:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00b8 }
        r0.close();	 Catch:{ Throwable -> 0x00b8 }
        r0 = 0;
        r12.b = r0;	 Catch:{ Throwable -> 0x00b8 }
    L_0x007d:
        monitor-exit(r10);	 Catch:{ all -> 0x0094 }
        r0 = r8;
        goto L_0x0029;
    L_0x0080:
        r0 = move-exception;
        r1 = r9;
    L_0x0082:
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r1.close();	 Catch:{ Throwable -> 0x0097 }
    L_0x0087:
        r1 = r12.b;	 Catch:{ Throwable -> 0x00a2 }
        if (r1 == 0) goto L_0x0093;
    L_0x008b:
        r1 = r12.b;	 Catch:{ Throwable -> 0x00a2 }
        r1.close();	 Catch:{ Throwable -> 0x00a2 }
        r1 = 0;
        r12.b = r1;	 Catch:{ Throwable -> 0x00a2 }
    L_0x0093:
        throw r0;	 Catch:{ all -> 0x0094 }
    L_0x0094:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0094 }
        throw r0;
    L_0x0097:
        r1 = move-exception;
        if (r15 != 0) goto L_0x0087;
    L_0x009a:
        r2 = "DataBase";
        r3 = "searchListData";
        com.loc.es.a(r1, r2, r3);	 Catch:{ all -> 0x0094 }
        goto L_0x0087;
    L_0x00a2:
        r1 = move-exception;
        if (r15 != 0) goto L_0x0093;
    L_0x00a5:
        r2 = "DataBase";
        r3 = "searchListData";
        com.loc.es.a(r1, r2, r3);	 Catch:{ all -> 0x0094 }
        goto L_0x0093;
    L_0x00ad:
        r0 = move-exception;
        if (r15 != 0) goto L_0x0071;
    L_0x00b0:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x0071;
    L_0x00b8:
        r0 = move-exception;
        if (r15 != 0) goto L_0x007d;
    L_0x00bb:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x007d;
    L_0x00c3:
        r0 = move-exception;
        if (r15 != 0) goto L_0x0045;
    L_0x00c6:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x0045;
    L_0x00cf:
        r0 = move-exception;
        if (r15 != 0) goto L_0x0051;
    L_0x00d2:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x0051;
    L_0x00db:
        if (r1 == 0) goto L_0x00e0;
    L_0x00dd:
        r1.close();	 Catch:{ Throwable -> 0x00f8 }
    L_0x00e0:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00ed }
        if (r0 == 0) goto L_0x007d;
    L_0x00e4:
        r0 = r12.b;	 Catch:{ Throwable -> 0x00ed }
        r0.close();	 Catch:{ Throwable -> 0x00ed }
        r0 = 0;
        r12.b = r0;	 Catch:{ Throwable -> 0x00ed }
        goto L_0x007d;
    L_0x00ed:
        r0 = move-exception;
        if (r15 != 0) goto L_0x007d;
    L_0x00f0:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x007d;
    L_0x00f8:
        r0 = move-exception;
        if (r15 != 0) goto L_0x00e0;
    L_0x00fb:
        r1 = "DataBase";
        r2 = "searchListData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x0094 }
        goto L_0x00e0;
    L_0x0103:
        r0 = move-exception;
        goto L_0x0082;
    L_0x0106:
        r0 = move-exception;
        r1 = r9;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.n.a(java.lang.String, java.lang.Class, boolean):java.util.List<T>");
    }

    public final <T> void a(T t) {
        synchronized (this.c) {
            this.b = a();
            if (this.b == null) {
                return;
            }
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                ad b = b(t.getClass());
                Object a = a(b);
                if (!(TextUtils.isEmpty(a) || t == null || sQLiteDatabase == null)) {
                    sQLiteDatabase.insert(a, null, a((Object) t, b));
                }
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            } catch (Throwable th) {
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            }
        }
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            if (a(str, obj.getClass(), false).size() == 0) {
                a(obj);
            } else {
                a(str, obj, false);
            }
        }
    }

    public final <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            Object a = a(b(cls));
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.b = a();
            if (this.b == null) {
                return;
            }
            try {
                this.b.delete(a, str, null);
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            } catch (Throwable th) {
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            }
        }
    }

    public final <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            ad b = b(obj.getClass());
            Object a = a(b);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            ContentValues a2 = a(obj, b);
            this.b = a();
            if (this.b == null) {
                return;
            }
            try {
                this.b.update(a, a2, str, null);
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            } catch (Throwable th) {
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            }
        }
    }
}
