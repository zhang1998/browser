package com.raizlabs.android.dbflow.structure.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
public final class k extends i {
    private final SQLiteStatement a;
    private final SQLiteDatabase b;

    public final long a() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r2 = 0;
        r0 = 0;
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 11;
        if (r3 < r4) goto L_0x0011;
    L_0x0009:
        r0 = r6.a;
        r0 = r0.executeUpdateDelete();
        r0 = (long) r0;
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = r6.a;
        r3.execute();
        r3 = r6.b;	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        r4 = "SELECT changes() AS affected_row_count";	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        r5 = 0;	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        r2 = r3.rawQuery(r4, r5);	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        if (r2 == 0) goto L_0x0037;	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
    L_0x0021:
        r3 = r2.getCount();	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        if (r3 <= 0) goto L_0x0037;	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
    L_0x0027:
        r3 = r2.moveToFirst();	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        if (r3 == 0) goto L_0x0037;	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
    L_0x002d:
        r3 = "affected_row_count";	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        r3 = r2.getColumnIndex(r3);	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
        r0 = r2.getLong(r3);	 Catch:{ SQLException -> 0x003d, all -> 0x0044 }
    L_0x0037:
        if (r2 == 0) goto L_0x0010;
    L_0x0039:
        r2.close();
        goto L_0x0010;
    L_0x003d:
        r3 = move-exception;
        if (r2 == 0) goto L_0x0010;
    L_0x0040:
        r2.close();
        goto L_0x0010;
    L_0x0044:
        r0 = move-exception;
        if (r2 == 0) goto L_0x004a;
    L_0x0047:
        r2.close();
    L_0x004a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.structure.database.k.a():long");
    }

    k(@NonNull SQLiteStatement sQLiteStatement, @NonNull SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteStatement;
        this.b = sQLiteDatabase;
    }

    public final void b() {
        this.a.close();
    }

    public final long c() {
        return this.a.simpleQueryForLong();
    }

    public final long d() {
        return this.a.executeInsert();
    }

    public final void a(int i, String str) {
        this.a.bindString(i, str);
    }

    public final void a(int i) {
        this.a.bindNull(i);
    }

    public final void a(int i, long j) {
        this.a.bindLong(i, j);
    }
}
