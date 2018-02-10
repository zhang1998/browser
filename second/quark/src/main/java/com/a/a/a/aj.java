package com.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class aj {
    private static Context a = null;
    private static String b = null;
    private List<String> c;

    private aj() {
        this.c = new ArrayList();
        if (a != null) {
            b();
            this.c.clear();
        }
    }

    public static final aj a(Context context) {
        a = context;
        return ak.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.json.JSONArray r7) {
        /*
        r0 = 0;
        r1 = a;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0, all -> 0x00b0 }
        r1 = com.a.a.a.al.a(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0, all -> 0x00b0 }
        r0 = r1.a();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0, all -> 0x00b0 }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0 }
        r1 = 0;
        r2 = r1;
    L_0x0010:
        r1 = r7.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0 }
        if (r2 >= r1) goto L_0x0079;
    L_0x0016:
        r3 = r7.getJSONObject(r2);	 Catch:{ Exception -> 0x00d0 }
        r4 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00d0 }
        r4.<init>();	 Catch:{ Exception -> 0x00d0 }
        r1 = "__i";
        r1 = r3.optString(r1);	 Catch:{ Exception -> 0x00d0 }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00d0 }
        if (r5 == 0) goto L_0x0039;
    L_0x002b:
        r1 = a;	 Catch:{ Exception -> 0x00d0 }
        r1 = com.a.a.a.em.d(r1);	 Catch:{ Exception -> 0x00d0 }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00d0 }
        if (r5 == 0) goto L_0x0039;
    L_0x0037:
        r1 = "";
    L_0x0039:
        r5 = "__i";
        r4.put(r5, r1);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__e";
        r5 = "id";
        r5 = r3.optString(r5);	 Catch:{ Exception -> 0x00d0 }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__t";
        r5 = "__t";
        r5 = r3.optInt(r5);	 Catch:{ Exception -> 0x00d0 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00d0 }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__i";
        r3.remove(r1);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__t";
        r3.remove(r1);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__s";
        r3 = r3.toString();	 Catch:{ Exception -> 0x00d0 }
        r3 = a(r3);	 Catch:{ Exception -> 0x00d0 }
        r4.put(r1, r3);	 Catch:{ Exception -> 0x00d0 }
        r1 = "__et";
        r3 = 0;
        r0.insert(r1, r3, r4);	 Catch:{ Exception -> 0x00d0 }
    L_0x0075:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0010;
    L_0x0079:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008b, Throwable -> 0x00a0 }
        if (r0 == 0) goto L_0x0081;
    L_0x007e:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c3 }
    L_0x0081:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
    L_0x008a:
        return;
    L_0x008b:
        r1 = move-exception;
        r1 = a;	 Catch:{ all -> 0x00cb }
        com.a.a.a.ap.a(r1);	 Catch:{ all -> 0x00cb }
        if (r0 == 0) goto L_0x0096;
    L_0x0093:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c5 }
    L_0x0096:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x008a;
    L_0x00a0:
        r1 = move-exception;
        if (r0 == 0) goto L_0x00a6;
    L_0x00a3:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c7 }
    L_0x00a6:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x008a;
    L_0x00b0:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00b4:
        if (r1 == 0) goto L_0x00b9;
    L_0x00b6:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c9 }
    L_0x00b9:
        r1 = a;
        r1 = com.a.a.a.al.a(r1);
        r1.b();
        throw r0;
    L_0x00c3:
        r0 = move-exception;
        goto L_0x0081;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00c7:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x00c9:
        r1 = move-exception;
        goto L_0x00b9;
    L_0x00cb:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00b4;
    L_0x00d0:
        r1 = move-exception;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.aj.a(org.json.JSONArray):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r5, java.lang.String r6) {
        /*
        r0 = 0;
        r1 = a;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f, all -> 0x006f }
        r1 = com.a.a.a.al.a(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f, all -> 0x006f }
        r0 = r1.a();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f, all -> 0x006f }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r1 = new android.content.ContentValues;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r1.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r2 = "__i";
        r1.put(r2, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r2 = a(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        if (r3 != 0) goto L_0x0037;
    L_0x0022:
        r3 = "__a";
        r1.put(r3, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r2 = "__t";
        r3 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r1.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        r2 = "__er";
        r3 = 0;
        r0.insert(r2, r3, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
    L_0x0037:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x005f }
        if (r0 == 0) goto L_0x003f;
    L_0x003c:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0082 }
    L_0x003f:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
    L_0x0048:
        r0 = 0;
        return r0;
    L_0x004a:
        r1 = move-exception;
        r1 = a;	 Catch:{ all -> 0x008a }
        com.a.a.a.ap.a(r1);	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0055;
    L_0x0052:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0084 }
    L_0x0055:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x0048;
    L_0x005f:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0065;
    L_0x0062:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0086 }
    L_0x0065:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x0048;
    L_0x006f:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0073:
        if (r1 == 0) goto L_0x0078;
    L_0x0075:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0088 }
    L_0x0078:
        r1 = a;
        r1 = com.a.a.a.al.a(r1);
        r1.b();
        throw r0;
    L_0x0082:
        r0 = move-exception;
        goto L_0x003f;
    L_0x0084:
        r0 = move-exception;
        goto L_0x0055;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0065;
    L_0x0088:
        r1 = move-exception;
        goto L_0x0078;
    L_0x008a:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0073;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.aj.a(java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(String str, JSONObject jSONObject, int i) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Throwable th2;
        Cursor cursor = null;
        if (jSONObject != null) {
            SQLiteDatabase a;
            Cursor cursor2;
            try {
                a = al.a(a).a();
                try {
                    a.beginTransaction();
                    if (i == aq.c) {
                        long longValue = ((Long) jSONObject.get("__e")).longValue();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", String.valueOf(longValue));
                        a.insert("__sd", null, contentValues);
                        cursor2 = null;
                    } else if (i == aq.d) {
                        a.execSQL("update __sd set __f=\"" + ((Long) jSONObject.get("__f")).longValue() + "\" where __ii=\"" + str + "\"");
                        cursor2 = null;
                    } else if (i == aq.b) {
                        a(str, jSONObject, a, "__a");
                        cursor2 = null;
                    } else if (i == aq.a) {
                        a(str, jSONObject, a, "__b");
                        cursor2 = null;
                    } else if (i == aq.e) {
                        Object jSONObject2;
                        Object obj;
                        Object a2;
                        try {
                            jSONObject2 = jSONObject.getJSONObject("__d");
                        } catch (Exception e) {
                            jSONObject2 = null;
                        }
                        if (jSONObject2 != null) {
                            cursor2 = a.rawQuery("select __d from __sd where __ii=\"" + str + "\"", null);
                            if (cursor2 != null) {
                                while (cursor2.moveToNext()) {
                                    try {
                                        cursor = b(cursor2.getString(cursor2.getColumnIndex("__d")));
                                    } catch (SQLiteDatabaseCorruptException e2) {
                                        sQLiteDatabase = a;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = cursor2;
                                        th2 = th;
                                    }
                                }
                                obj = cursor;
                            } else {
                                obj = null;
                            }
                        } else {
                            obj = null;
                            cursor2 = null;
                        }
                        if (jSONObject2 != null) {
                            try {
                                JSONArray jSONArray = new JSONArray();
                                if (!TextUtils.isEmpty(obj)) {
                                    jSONArray = new JSONArray(obj);
                                }
                                jSONArray.put(jSONObject2);
                                a2 = a(jSONArray.toString());
                                if (!TextUtils.isEmpty(a2)) {
                                    a.execSQL("update  __sd set __d=\"" + a2 + "\" where __ii=\"" + str + "\"");
                                }
                            } catch (Exception e3) {
                            }
                        }
                        try {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("__c");
                            if (jSONObject3 != null) {
                                a2 = a(jSONObject3.toString());
                                if (!TextUtils.isEmpty(a2)) {
                                    a.execSQL("update  __sd set __c=\"" + a2 + "\" where __ii=\"" + str + "\"");
                                }
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            a.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.getLong("__f")) + "\" where __ii=\"" + str + "\"");
                        } catch (Exception e5) {
                        }
                    } else {
                        cursor2 = null;
                    }
                    a.setTransactionSuccessful();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th4) {
                        }
                    }
                    al.a(a).b();
                } catch (SQLiteDatabaseCorruptException e6) {
                    cursor2 = null;
                    sQLiteDatabase = a;
                    try {
                        ap.a(a);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable th5) {
                            }
                        }
                        al.a(a).b();
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                        a = sQLiteDatabase;
                        cursor = cursor2;
                        th2 = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a != null) {
                            try {
                                a.endTransaction();
                            } catch (Throwable th7) {
                            }
                        }
                        al.a(a).b();
                        throw th2;
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a != null) {
                        a.endTransaction();
                    }
                    al.a(a).b();
                    throw th2;
                }
            } catch (SQLiteDatabaseCorruptException e7) {
                cursor2 = null;
                ap.a(a);
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                al.a(a).b();
                return false;
            } catch (Throwable th9) {
                th2 = th9;
                a = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a != null) {
                    a.endTransaction();
                }
                al.a(a).b();
                throw th2;
            }
        }
        return false;
    }

    private static void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        Throwable th;
        Cursor cursor = null;
        Cursor rawQuery;
        try {
            Object obj;
            rawQuery = sQLiteDatabase.rawQuery("select " + str2 + " from __sd where __ii=\"" + str + "\"", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    try {
                        cursor = b(rawQuery.getString(rawQuery.getColumnIndex(str2)));
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        cursor = rawQuery;
                        th = th3;
                    }
                }
                obj = cursor;
            } else {
                obj = null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(obj)) {
                jSONArray = new JSONArray(obj);
            }
            jSONArray.put(jSONObject);
            Object a = a(jSONArray.toString());
            if (!TextUtils.isEmpty(a)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + a + "\" where __ii=\"" + str + "\"");
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        c(jSONObject2);
        b(jSONObject2);
        a(jSONObject2);
        try {
            if (jSONObject2.length() > 0) {
                jSONObject.put("body", jSONObject2);
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject) {
        SQLiteDatabase a;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Throwable th2;
        Cursor cursor = null;
        Cursor rawQuery;
        try {
            a = al.a(a).a();
            try {
                a.beginTransaction();
                rawQuery = a.rawQuery("select *  from __et", null);
                if (rawQuery != null) {
                    try {
                        String string;
                        JSONObject jSONObject2;
                        JSONArray jSONArray;
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        while (rawQuery.moveToNext()) {
                            String a2;
                            int i = rawQuery.getInt(rawQuery.getColumnIndex("__t"));
                            string = rawQuery.getString(rawQuery.getColumnIndex("__i"));
                            String string2 = rawQuery.getString(rawQuery.getColumnIndex("__s"));
                            if ("".equals(string)) {
                                a2 = em.a();
                            } else {
                                a2 = string;
                            }
                            JSONArray optJSONArray;
                            switch (i) {
                                case 2049:
                                    if (!TextUtils.isEmpty(string2)) {
                                        jSONObject2 = new JSONObject(b(string2));
                                        if (jSONObject3.has(a2)) {
                                            optJSONArray = jSONObject3.optJSONArray(a2);
                                        } else {
                                            optJSONArray = new JSONArray();
                                        }
                                        optJSONArray.put(jSONObject2);
                                        jSONObject3.put(a2, optJSONArray);
                                        break;
                                    }
                                    continue;
                                case 2050:
                                    if (!TextUtils.isEmpty(string2)) {
                                        jSONObject2 = new JSONObject(b(string2));
                                        if (jSONObject4.has(a2)) {
                                            optJSONArray = jSONObject4.optJSONArray(a2);
                                        } else {
                                            optJSONArray = new JSONArray();
                                        }
                                        optJSONArray.put(jSONObject2);
                                        jSONObject4.put(a2, optJSONArray);
                                        break;
                                    }
                                    continue;
                                default:
                                    break;
                            }
                        }
                        if (jSONObject3.length() > 0) {
                            jSONArray = new JSONArray();
                            Iterator keys = jSONObject3.keys();
                            while (keys.hasNext()) {
                                JSONObject jSONObject5 = new JSONObject();
                                string = (String) keys.next();
                                jSONObject5.put(string, new JSONArray(jSONObject3.optString(string)));
                                if (jSONObject5.length() > 0) {
                                    jSONArray.put(jSONObject5);
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put("ekv", jSONArray);
                            }
                        }
                        if (jSONObject4.length() > 0) {
                            jSONArray = new JSONArray();
                            Iterator keys2 = jSONObject4.keys();
                            while (keys2.hasNext()) {
                                jSONObject2 = new JSONObject();
                                string = (String) keys2.next();
                                jSONObject2.put(string, new JSONArray(jSONObject4.optString(string)));
                                if (jSONObject2.length() > 0) {
                                    jSONArray.put(jSONObject2);
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put("gkv", jSONArray);
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException e) {
                        cursor = rawQuery;
                        sQLiteDatabase = a;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                a.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (a != null) {
                    try {
                        a.endTransaction();
                    } catch (Throwable th4) {
                    }
                }
                al.a(a).b();
            } catch (SQLiteDatabaseCorruptException e2) {
                sQLiteDatabase = a;
                try {
                    ap.a(a);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th5) {
                        }
                    }
                    al.a(a).b();
                } catch (Throwable th6) {
                    th2 = th6;
                    a = sQLiteDatabase;
                    rawQuery = cursor;
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th7) {
                        }
                    }
                    al.a(a).b();
                    throw th;
                }
            } catch (Throwable th8) {
                th2 = th8;
                rawQuery = null;
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (a != null) {
                    a.endTransaction();
                }
                al.a(a).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException e3) {
            sQLiteDatabase = null;
            ap.a(a);
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            al.a(a).b();
        } catch (Throwable th82) {
            a = null;
            th = th82;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (a != null) {
                a.endTransaction();
            }
            al.a(a).b();
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(org.json.JSONObject r6) {
        /*
        r0 = 0;
        r1 = a;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c0, Throwable -> 0x007b, all -> 0x0091 }
        r1 = com.a.a.a.al.a(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c0, Throwable -> 0x007b, all -> 0x0091 }
        r1 = r1.a();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c0, Throwable -> 0x007b, all -> 0x0091 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be, all -> 0x00b2 }
        r2 = "select *  from __er";
        r3 = 0;
        r0 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be, all -> 0x00b2 }
        if (r0 == 0) goto L_0x0064;
    L_0x0017:
        r2 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
    L_0x001c:
        r3 = r0.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        if (r3 == 0) goto L_0x0059;
    L_0x0022:
        r3 = "__a";
        r3 = r0.getColumnIndex(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r3 = r0.getString(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        if (r4 != 0) goto L_0x001c;
    L_0x0032:
        r4 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r3 = b(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r4.<init>(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        r2.put(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        goto L_0x001c;
    L_0x003f:
        r2 = move-exception;
    L_0x0040:
        r2 = a;	 Catch:{ all -> 0x00b8 }
        com.a.a.a.ap.a(r2);	 Catch:{ all -> 0x00b8 }
        if (r0 == 0) goto L_0x004a;
    L_0x0047:
        r0.close();
    L_0x004a:
        if (r1 == 0) goto L_0x004f;
    L_0x004c:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ac }
    L_0x004f:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
    L_0x0058:
        return;
    L_0x0059:
        r3 = r2.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        if (r3 <= 0) goto L_0x0064;
    L_0x005f:
        r3 = "error";
        r6.put(r3, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
    L_0x0064:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x003f, Throwable -> 0x00be }
        if (r0 == 0) goto L_0x006c;
    L_0x0069:
        r0.close();
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00aa }
    L_0x0071:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x0058;
    L_0x007b:
        r1 = move-exception;
        r1 = r0;
    L_0x007d:
        if (r0 == 0) goto L_0x0082;
    L_0x007f:
        r0.close();
    L_0x0082:
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ae }
    L_0x0087:
        r0 = a;
        r0 = com.a.a.a.al.a(r0);
        r0.b();
        goto L_0x0058;
    L_0x0091:
        r1 = move-exception;
        r2 = r0;
        r5 = r0;
        r0 = r1;
        r1 = r5;
    L_0x0096:
        if (r1 == 0) goto L_0x009b;
    L_0x0098:
        r1.close();
    L_0x009b:
        if (r2 == 0) goto L_0x00a0;
    L_0x009d:
        r2.endTransaction();	 Catch:{ Throwable -> 0x00b0 }
    L_0x00a0:
        r1 = a;
        r1 = com.a.a.a.al.a(r1);
        r1.b();
        throw r0;
    L_0x00aa:
        r0 = move-exception;
        goto L_0x0071;
    L_0x00ac:
        r0 = move-exception;
        goto L_0x004f;
    L_0x00ae:
        r0 = move-exception;
        goto L_0x0087;
    L_0x00b0:
        r1 = move-exception;
        goto L_0x00a0;
    L_0x00b2:
        r2 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0096;
    L_0x00b8:
        r2 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0096;
    L_0x00be:
        r2 = move-exception;
        goto L_0x007d;
    L_0x00c0:
        r1 = move-exception;
        r1 = r0;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.aj.b(org.json.JSONObject):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(org.json.JSONObject r18) {
        /*
        r17 = this;
        r3 = 0;
        r2 = 0;
        r4 = a;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e, all -> 0x0163 }
        r4 = com.a.a.a.al.a(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e, all -> 0x0163 }
        r3 = r4.a();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e, all -> 0x0163 }
        r3.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e, all -> 0x0186 }
        r4 = "select *  from __sd";
        r5 = 0;
        r2 = r3.rawQuery(r4, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e, all -> 0x0186 }
        if (r2 == 0) goto L_0x0137;
    L_0x0018:
        r4 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r4.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r0 = r17;
        r5 = r0.c;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.clear();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x0024:
        r5 = r2.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r5 == 0) goto L_0x012a;
    L_0x002a:
        r5 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r6 = "__f";
        r6 = r2.getColumnIndex(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r6 = r2.getString(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7 = "__e";
        r7 = r2.getColumnIndex(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7 = r2.getString(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r8 != 0) goto L_0x0024;
    L_0x0049:
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r8 != 0) goto L_0x0024;
    L_0x004f:
        r8 = java.lang.Long.parseLong(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r10 = java.lang.Long.parseLong(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = r8 - r10;
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x0024;
    L_0x005e:
        r8 = "__a";
        r8 = r2.getColumnIndex(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = r2.getString(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r9 = "__b";
        r9 = r2.getColumnIndex(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r9 = r2.getString(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r10 = "__c";
        r10 = r2.getColumnIndex(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r10 = r2.getString(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r11 = "__d";
        r11 = r2.getColumnIndex(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r11 = r2.getString(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r12 = "__ii";
        r12 = r2.getColumnIndex(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r12 = r2.getString(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r0 = r17;
        r13 = r0.c;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r13.add(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r13 = "id";
        r5.put(r13, r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r12 = "start_time";
        r5.put(r12, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r12 = "end_time";
        r5.put(r12, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r12 = "duration";
        r14 = java.lang.Long.parseLong(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r6 = java.lang.Long.parseLong(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r6 = r14 - r6;
        r5.put(r12, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r6 = android.text.TextUtils.isEmpty(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r6 != 0) goto L_0x00c9;
    L_0x00bb:
        r6 = "pages";
        r7 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = b(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7.<init>(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x00c9:
        r6 = android.text.TextUtils.isEmpty(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r6 != 0) goto L_0x00dd;
    L_0x00cf:
        r6 = "autopages";
        r7 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = b(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7.<init>(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x00dd:
        r6 = android.text.TextUtils.isEmpty(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r6 != 0) goto L_0x00f1;
    L_0x00e3:
        r6 = "traffic";
        r7 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = b(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7.<init>(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x00f1:
        r6 = android.text.TextUtils.isEmpty(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r6 != 0) goto L_0x0105;
    L_0x00f7:
        r6 = "locations";
        r7 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r8 = b(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r7.<init>(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        r5.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x0105:
        r6 = r5.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r6 <= 0) goto L_0x0024;
    L_0x010b:
        r4.put(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        goto L_0x0024;
    L_0x0110:
        r4 = move-exception;
        r4 = a;	 Catch:{ all -> 0x018e }
        com.a.a.a.ap.a(r4);	 Catch:{ all -> 0x018e }
        if (r2 == 0) goto L_0x011b;
    L_0x0118:
        r2.close();
    L_0x011b:
        if (r3 == 0) goto L_0x0120;
    L_0x011d:
        r3.endTransaction();	 Catch:{ Throwable -> 0x0180 }
    L_0x0120:
        r2 = a;
        r2 = com.a.a.a.al.a(r2);
        r2.b();
    L_0x0129:
        return;
    L_0x012a:
        r5 = r4.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r5 <= 0) goto L_0x0137;
    L_0x0130:
        r5 = "sessions";
        r0 = r18;
        r0.put(r5, r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
    L_0x0137:
        r3.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0110, Throwable -> 0x014e }
        if (r2 == 0) goto L_0x013f;
    L_0x013c:
        r2.close();
    L_0x013f:
        if (r3 == 0) goto L_0x0144;
    L_0x0141:
        r3.endTransaction();	 Catch:{ Throwable -> 0x017e }
    L_0x0144:
        r2 = a;
        r2 = com.a.a.a.al.a(r2);
        r2.b();
        goto L_0x0129;
    L_0x014e:
        r4 = move-exception;
        if (r2 == 0) goto L_0x0154;
    L_0x0151:
        r2.close();
    L_0x0154:
        if (r3 == 0) goto L_0x0159;
    L_0x0156:
        r3.endTransaction();	 Catch:{ Throwable -> 0x0182 }
    L_0x0159:
        r2 = a;
        r2 = com.a.a.a.al.a(r2);
        r2.b();
        goto L_0x0129;
    L_0x0163:
        r4 = move-exception;
        r16 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r16;
    L_0x016a:
        if (r3 == 0) goto L_0x016f;
    L_0x016c:
        r3.close();
    L_0x016f:
        if (r4 == 0) goto L_0x0174;
    L_0x0171:
        r4.endTransaction();	 Catch:{ Throwable -> 0x0184 }
    L_0x0174:
        r3 = a;
        r3 = com.a.a.a.al.a(r3);
        r3.b();
        throw r2;
    L_0x017e:
        r2 = move-exception;
        goto L_0x0144;
    L_0x0180:
        r2 = move-exception;
        goto L_0x0120;
    L_0x0182:
        r2 = move-exception;
        goto L_0x0159;
    L_0x0184:
        r3 = move-exception;
        goto L_0x0174;
    L_0x0186:
        r4 = move-exception;
        r16 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r16;
        goto L_0x016a;
    L_0x018e:
        r4 = move-exception;
        r16 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r16;
        goto L_0x016a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.aj.c(org.json.JSONObject):void");
    }

    public final void a(boolean z, boolean z2) {
        SQLiteDatabase a;
        Throwable th;
        Throwable th2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a = al.a(a).a();
            try {
                a.beginTransaction();
                a.execSQL("delete from __er");
                a.execSQL("delete from __et");
                if (!z2) {
                    if (this.c.size() > 0) {
                        for (int i = 0; i < this.c.size(); i++) {
                            a.execSQL("delete from __sd where __ii=\"" + ((String) this.c.get(i)) + "\"");
                        }
                    }
                    this.c.clear();
                } else if (z) {
                    a.execSQL("delete from __sd");
                }
                a.setTransactionSuccessful();
                if (a != null) {
                    try {
                        a.endTransaction();
                    } catch (Throwable th3) {
                    }
                }
                al.a(a).b();
            } catch (SQLiteDatabaseCorruptException e) {
                sQLiteDatabase = a;
                try {
                    ap.a(a);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th4) {
                        }
                    }
                    al.a(a).b();
                } catch (Throwable th5) {
                    th = th5;
                    a = sQLiteDatabase;
                    th2 = th;
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th6) {
                        }
                    }
                    al.a(a).b();
                    throw th2;
                }
            } catch (Throwable th7) {
                th2 = th7;
                if (a != null) {
                    a.endTransaction();
                }
                al.a(a).b();
                throw th2;
            }
        } catch (SQLiteDatabaseCorruptException e2) {
            ap.a(a);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            al.a(a).b();
        } catch (Throwable th52) {
            th = th52;
            a = null;
            th2 = th;
            if (a != null) {
                a.endTransaction();
            }
            al.a(a).b();
            throw th2;
        }
    }

    private void b() {
        try {
            if (TextUtils.isEmpty(b)) {
                SharedPreferences sharedPreferences = a.getSharedPreferences("umeng_general_config", 0);
                Object string = sharedPreferences.getString("ek__id", null);
                if (TextUtils.isEmpty(string)) {
                    string = ey.t(a);
                    if (!TextUtils.isEmpty(string)) {
                        sharedPreferences.edit().putString("ek__id", string).commit();
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    String substring = string.substring(1, 9);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!Character.isDigit(charAt)) {
                            stringBuilder.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            stringBuilder.append(0);
                        } else {
                            stringBuilder.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    b = stringBuilder.toString();
                }
                if (!TextUtils.isEmpty(b)) {
                    b += new StringBuilder(b).reverse().toString();
                    String string2 = sharedPreferences.getString("ek_key", null);
                    if (TextUtils.isEmpty(string2)) {
                        sharedPreferences.edit().putString("ek_key", a("umeng+")).commit();
                    } else if (!"umeng+".equals(b(string2))) {
                        a(true, false);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(b)) {
                return str;
            }
            return Base64.encodeToString(fg.a(str.getBytes(), b.getBytes()), 0);
        } catch (Exception e) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            if (TextUtils.isEmpty(b)) {
                return str;
            }
            return new String(fg.b(Base64.decode(str.getBytes(), 0), b.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }
}
