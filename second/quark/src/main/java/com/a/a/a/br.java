package com.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class br {
    private static br c;
    private static SQLiteOpenHelper d;
    private AtomicInteger a = new AtomicInteger();
    private AtomicInteger b = new AtomicInteger();
    private SQLiteDatabase e;

    private static synchronized void b(Context context) {
        synchronized (br.class) {
            if (c == null) {
                c = new br();
                d = bp.a(context);
            }
        }
    }

    public static synchronized br a(Context context) {
        br brVar;
        synchronized (br.class) {
            if (c == null) {
                b(context);
            }
            brVar = c;
        }
        return brVar;
    }

    public final synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.e = d.getReadableDatabase();
        }
        return this.e;
    }

    public final synchronized SQLiteDatabase b() {
        if (this.a.incrementAndGet() == 1) {
            this.e = d.getWritableDatabase();
        }
        return this.e;
    }

    public final synchronized void c() {
        if (this.a.decrementAndGet() == 0) {
            this.e.close();
        }
        if (this.b.decrementAndGet() == 0) {
            this.e.close();
        }
    }
}
