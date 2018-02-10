package com.raizlabs.android.dbflow.structure.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.c;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class l extends SQLiteOpenHelper implements d {
    private f a;
    private j b;

    public l(@NonNull c cVar, @NonNull e eVar) {
        super(FlowManager.b(), cVar.c(), null, cVar.d());
        this.a = new f(eVar, cVar);
    }

    public final void a() {
        g gVar = this.a;
        String c = gVar.a.c();
        String c2 = gVar.a.c();
        File databasePath = FlowManager.b().getDatabasePath(c);
        if (!databasePath.exists()) {
            databasePath.getParentFile().mkdirs();
            try {
                InputStream fileInputStream;
                File databasePath2 = FlowManager.b().getDatabasePath("temp-" + gVar.a.b() + ".db");
                if (databasePath2.exists()) {
                    fileInputStream = new FileInputStream(databasePath2);
                } else {
                    fileInputStream = FlowManager.b().getAssets().open(c2);
                }
                f.a(databasePath, fileInputStream);
            } catch (Throwable e) {
                t.a(s.d, "Failed to open file", e);
            }
        }
    }

    @NonNull
    public final b b() {
        if (this.b == null || !this.b.a.isOpen()) {
            this.b = j.a(getWritableDatabase());
        }
        return this.b;
    }

    public final void onCreate(@NonNull SQLiteDatabase sQLiteDatabase) {
        this.a.a(j.a(sQLiteDatabase));
    }

    public final void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(j.a(sQLiteDatabase), i, i2);
    }

    public final void onOpen(@NonNull SQLiteDatabase sQLiteDatabase) {
        j.a(sQLiteDatabase);
    }

    public final void onDowngrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        j.a(sQLiteDatabase);
    }
}
