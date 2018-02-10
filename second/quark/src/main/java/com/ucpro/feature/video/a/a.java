package com.ucpro.feature.video.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uc.apollo.android.GuideDialog;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class a {
    private static String[] b = new String[]{"id", "video_type", "page_url", "video_uri", GuideDialog.TITLE, "current_pos", "duration", "visit_time", "quality"};
    final SQLiteDatabase a;

    private a() {
        this.a = new c(d.a()).getWritableDatabase();
        m.a(0, new f(this));
    }

    public static a a() {
        return d.a;
    }

    public final b a(b bVar) {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = this.a.query("video_history", b, "page_url=? and title=? and video_type=?", new String[]{bVar.c, bVar.e, String.valueOf(bVar.b)}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        do {
                            if (query.moveToNext()) {
                            } else {
                                if (query != null) {
                                    query.close();
                                }
                                return null;
                            }
                        } while (Math.abs(bVar.g - query.getLong(query.getColumnIndex("duration"))) > 2000);
                        b bVar2 = new b();
                        bVar2.a = query.getInt(query.getColumnIndex("id"));
                        bVar2.b = query.getInt(query.getColumnIndex("video_type"));
                        bVar2.c = query.getString(query.getColumnIndex("page_url"));
                        bVar2.d = query.getString(query.getColumnIndex("video_uri"));
                        bVar2.e = query.getString(query.getColumnIndex(GuideDialog.TITLE));
                        bVar2.f = query.getInt(query.getColumnIndex("current_pos"));
                        bVar2.g = query.getLong(query.getColumnIndex("duration"));
                        bVar2.h = query.getLong(query.getColumnIndex("visit_time"));
                        bVar2.i = query.getString(query.getColumnIndex("quality"));
                        if (query == null) {
                            return bVar2;
                        }
                        query.close();
                        return bVar2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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
