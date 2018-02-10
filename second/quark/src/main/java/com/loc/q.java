package com.loc;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class q extends ContextWrapper {
    private String a;
    private Context b;

    public q(Context context, String str) {
        super(context);
        this.a = str;
        this.b = context;
    }

    public final File getDatabasePath(String str) {
        try {
            String str2 = this.a + "/" + str;
            File file = new File(this.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean z = false;
            file = new File(str2);
            if (file.exists()) {
                z = true;
            } else {
                try {
                    z = file.createNewFile();
                } catch (IOException e) {
                }
            }
            return z ? file : null;
        } catch (Throwable th) {
            return null;
        }
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        if (getDatabasePath(str) != null) {
            SQLiteDatabase openOrCreateDatabase;
            try {
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
            } catch (Throwable th) {
                openOrCreateDatabase = null;
            }
            if (openOrCreateDatabase != null) {
                return openOrCreateDatabase;
            }
        }
        return SQLiteDatabase.openOrCreateDatabase(this.b.getDatabasePath(str), null);
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (getDatabasePath(str) != null) {
            SQLiteDatabase openOrCreateDatabase;
            try {
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
            } catch (Throwable th) {
                openOrCreateDatabase = null;
            }
            if (openOrCreateDatabase != null) {
                return openOrCreateDatabase;
            }
        }
        return SQLiteDatabase.openOrCreateDatabase(this.b.getDatabasePath(str), null);
    }
}
