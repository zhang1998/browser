package com.a.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class bs {
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (b(sQLiteDatabase, str) >= 0) {
                sQLiteDatabase.execSQL("delete from " + str);
            }
            return true;
        } catch (SQLException e) {
            fw.d("cleanTableData faild!" + e.toString());
            return false;
        }
    }

    public static int b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from " + str, null);
            i = cursor.getCount();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            fw.d("count error " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, Collection<cn> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            if (b(sQLiteDatabase, "aggregated_cache") > 0) {
                a(sQLiteDatabase, "aggregated_cache");
            }
            for (cn a : collection) {
                sQLiteDatabase.insert("aggregated_cache", null, a(a));
            }
            sQLiteDatabase.setTransactionSuccessful();
            return true;
        } catch (SQLException e) {
            fw.d("insert to Aggregated cache table faild!");
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(cl clVar, SQLiteDatabase sQLiteDatabase, Collection<cn> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            for (cn a : collection) {
                sQLiteDatabase.insert("aggregated", null, a(a));
            }
            sQLiteDatabase.setTransactionSuccessful();
            a(sQLiteDatabase, "aggregated_cache");
            clVar.a("success");
            return true;
        } catch (SQLException e) {
            fw.d("insert to Aggregated cache table faild!");
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private static ContentValues a(cn cnVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", TextUtils.join("!", cnVar.a));
        contentValues.put("label", TextUtils.join("!", cnVar.b));
        contentValues.put("count", Long.valueOf(cnVar.e));
        contentValues.put("value", Long.valueOf(cnVar.d));
        contentValues.put("totalTimestamp", Long.valueOf(cnVar.c));
        contentValues.put("timeWindowNum", cnVar.f);
        return contentValues;
    }

    public static JSONObject a(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        SQLException e;
        Throwable th;
        try {
            if (b(sQLiteDatabase, "aggregated") > 0) {
                rawQuery = sQLiteDatabase.rawQuery("select * from aggregated", null);
                try {
                    JSONObject jSONObject = new JSONObject();
                    while (rawQuery.moveToNext()) {
                        try {
                            JSONArray jSONArray;
                            String string = rawQuery.getString(rawQuery.getColumnIndex("key"));
                            if (jSONObject.has(string)) {
                                jSONArray = jSONObject.getJSONArray(string);
                                jSONObject.remove(string);
                            } else {
                                jSONArray = new JSONArray();
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("v_sum", rawQuery.getLong(rawQuery.getColumnIndex("value")));
                            jSONObject2.put("ts_sum", rawQuery.getLong(rawQuery.getColumnIndex("totalTimestamp")));
                            jSONObject2.put("tw_num", Integer.parseInt(rawQuery.getString(rawQuery.getColumnIndex("timeWindowNum"))));
                            jSONObject2.put("count", rawQuery.getInt(rawQuery.getColumnIndex("count")));
                            jSONObject2.put("labels", bo.a(rawQuery.getString(rawQuery.getColumnIndex("label"))));
                            jSONArray.put(jSONObject2);
                            jSONObject.put(string, jSONArray);
                        } catch (Exception e2) {
                        }
                    }
                    if (rawQuery == null) {
                        return jSONObject;
                    }
                    rawQuery.close();
                    return jSONObject;
                } catch (SQLException e3) {
                    e = e3;
                    try {
                        fw.d("readAllAggregatedDataForUpload error " + e.toString());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (SQLException e4) {
            e = e4;
            rawQuery = null;
            fw.d("readAllAggregatedDataForUpload error " + e.toString());
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return null;
    }

    public static JSONObject a(cl clVar, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        SQLException sQLException;
        Throwable th;
        try {
            Cursor rawQuery;
            JSONObject jSONObject = new JSONObject();
            if (b(sQLiteDatabase, "system") > 0) {
                rawQuery = sQLiteDatabase.rawQuery("select * from system", null);
                while (rawQuery.moveToNext()) {
                    try {
                        try {
                            JSONArray jSONArray;
                            String string = rawQuery.getString(rawQuery.getColumnIndex("key"));
                            if (jSONObject.has(string)) {
                                jSONArray = jSONObject.getJSONArray(string);
                                jSONObject.remove(string);
                            } else {
                                jSONArray = new JSONArray();
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("value", rawQuery.getInt(rawQuery.getColumnIndex("count")));
                            jSONObject2.put("ts", rawQuery.getLong(rawQuery.getColumnIndex("timeStamp")));
                            jSONArray.put(jSONObject2);
                            jSONObject.put(string, jSONArray);
                        } catch (Exception e) {
                        }
                    } catch (SQLException e2) {
                        SQLException sQLException2 = e2;
                        cursor = rawQuery;
                        sQLException = sQLException2;
                    } catch (Throwable th2) {
                        cursor = rawQuery;
                        th = th2;
                    }
                }
            } else {
                rawQuery = null;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return jSONObject;
        } catch (SQLException e3) {
            sQLException = e3;
            cursor = null;
            try {
                clVar.a("faild");
                fw.d("readAllSystemDataForUpload error " + sQLException.toString());
                if (cursor == null) {
                    return null;
                }
                cursor.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
