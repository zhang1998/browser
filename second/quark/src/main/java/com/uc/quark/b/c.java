package com.uc.quark.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "download.db", null, 6);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS task" + String.format("(%s INTEGER PRIMARY KEY, %s INTEGER, %s VARCHAR, %s VARCHAR, %s VARCHAR, %s VARCHAR, %s VARCHAR, %s INTEGER DEFAULT 0, %s INTEGER DEFAULT 0, %s INTEGER DEFAULT 0, %s VARCHAR, %s VARCHAR)", new Object[]{"id", "create_time", GuideDialog.TITLE, "url", "path", "mimetype", "refurl", "flag_silent", "flag_is_video_cache", "flag_is_verif_file", "verif_file_info", "post_body"}));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r3, int r4, int r5) {
        /*
        r2 = this;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0005;
            case 2: goto L_0x000a;
            case 3: goto L_0x000f;
            case 4: goto L_0x0014;
            case 5: goto L_0x001e;
            default: goto L_0x0004;
        };
    L_0x0004:
        return;
    L_0x0005:
        r0 = "task";
        r3.delete(r0, r1, r1);
    L_0x000a:
        r0 = "ALTER TABLE task ADD COLUMN flag_silent INTEGER DEFAULT 0";
        r3.execSQL(r0);
    L_0x000f:
        r0 = "ALTER TABLE task ADD COLUMN flag_is_video_cache INTEGER DEFAULT 0";
        r3.execSQL(r0);
    L_0x0014:
        r0 = "ALTER TABLE task ADD COLUMN flag_is_verif_file INTEGER DEFAULT 0";
        r3.execSQL(r0);
        r0 = "ALTER TABLE task ADD COLUMN verif_file_info VARCHAR";
        r3.execSQL(r0);
    L_0x001e:
        r0 = "ALTER TABLE task ADD COLUMN post_body VARCHAR";
        r3.execSQL(r0);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.b.c.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
