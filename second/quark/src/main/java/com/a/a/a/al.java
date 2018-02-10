package com.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
final class al {
    private static al c;
    private static SQLiteOpenHelper d;
    private AtomicInteger a = new AtomicInteger();
    private AtomicInteger b = new AtomicInteger();
    private SQLiteDatabase e;

    al() {
    }

    private static synchronized void b(Context context) {
        synchronized (al.class) {
            if (c == null) {
                c = new al();
                d = an.a(context);
            }
        }
    }

    public static synchronized al a(Context context) {
        al alVar;
        synchronized (al.class) {
            if (c == null) {
                b(context);
            }
            alVar = c;
        }
        return alVar;
    }

    public final synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.e = d.getWritableDatabase();
        }
        return this.e;
    }

    public final synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.e.close();
            }
            if (this.b.decrementAndGet() == 0) {
                this.e.close();
            }
        } catch (Throwable th) {
        }
    }
}
