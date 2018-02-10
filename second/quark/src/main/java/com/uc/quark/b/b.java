package com.uc.quark.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uc.apollo.android.GuideDialog;
import com.uc.quark.c;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.y;
import com.uc.quark.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    private static String[] b = new String[]{"id", "create_time", "url", "path", "refurl", GuideDialog.TITLE, "mimetype", "flag_silent", "flag_is_video_cache", "flag_is_verif_file", "verif_file_info", "post_body"};
    private static String c = "create_time DESC";
    final SQLiteDatabase a = new c(c.a()).getWritableDatabase();

    final List<s> a(f fVar) {
        Cursor query = this.a.query("task", b, null, null, null, null, c);
        List<s> arrayList = new ArrayList();
        try {
            if (query.getCount() > 0 && query.moveToLast() && query.moveToFirst()) {
                do {
                    s zVar;
                    int i = query.getInt(query.getColumnIndex("id"));
                    String string = query.getString(query.getColumnIndex(GuideDialog.TITLE));
                    String string2 = query.getString(query.getColumnIndex("url"));
                    String string3 = query.getString(query.getColumnIndex("path"));
                    String string4 = query.getString(query.getColumnIndex("refurl"));
                    String string5 = query.getString(query.getColumnIndex("mimetype"));
                    long j = query.getLong(query.getColumnIndex("create_time"));
                    boolean z = query.getInt(query.getColumnIndex("flag_silent")) == 1;
                    boolean z2 = query.getInt(query.getColumnIndex("flag_is_video_cache")) == 1;
                    boolean z3 = query.getInt(query.getColumnIndex("flag_is_verif_file")) == 1;
                    String string6 = query.getString(query.getColumnIndex("verif_file_info"));
                    String string7 = query.getString(query.getColumnIndex("post_body"));
                    n nVar = new n();
                    nVar.a = string2;
                    nVar.d = string;
                    nVar.e = string3;
                    nVar.c = string5;
                    nVar.f = z;
                    nVar.h = z2;
                    nVar.b = string4;
                    nVar.i = z3;
                    nVar.j = string6;
                    nVar.k = string7;
                    y a = nVar.a();
                    if (a != null) {
                        zVar = new z(i, a, j);
                    } else {
                        zVar = null;
                    }
                    if (zVar != null && fVar.a(zVar)) {
                        arrayList.add(zVar);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Exception e) {
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
        }
    }

    public final boolean a(String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            Cursor query = this.a.query("task", null, "url=?", new String[]{str}, null, null, null, null);
            if (query != null) {
                try {
                    boolean z = query.getCount() > 0;
                    if (query != null) {
                        query.close();
                    }
                    return z;
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        return false;
                    }
                    cursor.close();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else if (query == null) {
                return false;
            } else {
                query.close();
                return false;
            }
        } catch (Exception e2) {
            cursor = null;
            if (cursor != null) {
                return false;
            }
            cursor.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final ArrayList<h> a() {
        Cursor query = this.a.query("task", b, null, null, null, null, c);
        ArrayList<h> arrayList = new ArrayList();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    if (query.getInt(query.getColumnIndex("flag_silent")) != 1) {
                        h hVar = new h();
                        hVar.a = query.getInt(query.getColumnIndex("id"));
                        hVar.b = query.getString(query.getColumnIndex("path"));
                        arrayList.add(hVar);
                    }
                } catch (Exception e) {
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } else if (query != null) {
            query.close();
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r8) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = 0;
        r3 = r7.a;	 Catch:{ Exception -> 0x0026, all -> 0x002e }
        r4 = "select * from task where title=?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x0026, all -> 0x002e }
        r6 = 0;
        r5[r6] = r8;	 Catch:{ Exception -> 0x0026, all -> 0x002e }
        r2 = r3.rawQuery(r4, r5);	 Catch:{ Exception -> 0x0026, all -> 0x002e }
        if (r2 == 0) goto L_0x001f;
    L_0x0013:
        r3 = r2.getCount();	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        if (r3 <= 0) goto L_0x001f;
    L_0x0019:
        if (r2 == 0) goto L_0x001e;
    L_0x001b:
        r2.close();
    L_0x001e:
        return r0;
    L_0x001f:
        if (r2 == 0) goto L_0x0024;
    L_0x0021:
        r2.close();
    L_0x0024:
        r0 = r1;
        goto L_0x001e;
    L_0x0026:
        r0 = move-exception;
        r0 = r2;
    L_0x0028:
        if (r0 == 0) goto L_0x0024;
    L_0x002a:
        r0.close();
        goto L_0x0024;
    L_0x002e:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0034;
    L_0x0031:
        r2.close();
    L_0x0034:
        throw r0;
    L_0x0035:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.b.b.b(java.lang.String):boolean");
    }
}
