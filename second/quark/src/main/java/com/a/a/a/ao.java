package com.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: ProGuard */
final class ao extends ContextWrapper {
    private String a;

    public ao(Context context, String str) {
        super(context);
        this.a = str;
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    public final File getDatabasePath(String str) {
        File file = new File(this.a + str);
        if (!(file.getParentFile().exists() || file.getParentFile().isDirectory())) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
