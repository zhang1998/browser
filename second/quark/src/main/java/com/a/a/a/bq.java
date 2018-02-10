package com.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: ProGuard */
public final class bq extends ContextWrapper {
    private String a;

    public bq(Context context, String str) {
        super(context);
        this.a = str;
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory);
    }

    public final File getDatabasePath(String str) {
        File file = new File(this.a + str);
        if (!(file.getParentFile().exists() || file.getParentFile().isDirectory())) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
