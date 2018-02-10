package com.ucpro.feature.lightapp.d.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.ucpro.c.c;
import java.io.File;

/* compiled from: ProGuard */
public final class j extends SQLiteOpenHelper {
    public static final String[] e = new String[]{"id", "info", "visited_time"};
    public static final String[] f = new String[]{"id", "list", "visited_time"};
    String a = (c.a("light_app") + File.separator + "lightappcache");
    String b = "lightapp/lightappcache";
    Context c;
    SQLiteDatabase d;

    public j(Context context) {
        super(context, "lightappcache", null, 1);
        this.c = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final synchronized void close() {
        if (this.d != null) {
            this.d.close();
        }
        super.close();
    }

    final boolean a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(this.a, null, 1);
        } catch (SQLiteException e) {
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        if (sQLiteDatabase != null) {
            return true;
        }
        return false;
    }
}
