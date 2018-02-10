package com.raizlabs.android.dbflow.structure.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
public final class j implements b {
    final SQLiteDatabase a;

    public static j a(@NonNull SQLiteDatabase sQLiteDatabase) {
        return new j(sQLiteDatabase);
    }

    private j(@NonNull SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    public final void a(@NonNull String str) {
        this.a.execSQL(str);
    }

    public final void a() {
        this.a.beginTransaction();
    }

    public final void b() {
        this.a.setTransactionSuccessful();
    }

    public final void c() {
        this.a.endTransaction();
    }

    public final int d() {
        return this.a.getVersion();
    }

    @NonNull
    public final a b(@NonNull String str) {
        return new k(this.a.compileStatement(str), this.a);
    }

    @NonNull
    public final c c(@NonNull String str) {
        return c.a(this.a.rawQuery(str, null));
    }
}
