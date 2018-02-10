package com.alibaba.analytics.core.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class c extends SQLiteOpenHelper {
    private static boolean e = false;
    private static DatabaseErrorHandler f = new b();
    private AtomicInteger a = new AtomicInteger();
    private SQLiteDatabase b;
    private d c = new d(this);
    private Future<?> d;

    public c(Context context, String str) {
        super(context, str, null, 2, f);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        Cursor cursor = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable th) {
            rawQuery = th;
        } finally {
            a(
/*
Method generation error in method: com.alibaba.analytics.core.db.c.onOpen(android.database.sqlite.SQLiteDatabase):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  (wrap: android.database.Cursor
  ?: MERGE  (r2_1 android.database.Cursor) = (r2_0 'cursor' android.database.Cursor), (r0_4 'rawQuery' android.database.Cursor)) com.alibaba.analytics.core.db.c.a(android.database.Cursor):void type: STATIC in method: com.alibaba.analytics.core.db.c.onOpen(android.database.sqlite.SQLiteDatabase):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_1 android.database.Cursor) = (r2_0 'cursor' android.database.Cursor), (r0_4 'rawQuery' android.database.Cursor) in method: com.alibaba.analytics.core.db.c.onOpen(android.database.sqlite.SQLiteDatabase):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:679)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:649)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 20 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 25 more

*/

            public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            }

            public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            }

            public final synchronized SQLiteDatabase getWritableDatabase() {
                SQLiteDatabase sQLiteDatabase;
                try {
                    if (this.b == null) {
                        if (e) {
                            sQLiteDatabase = null;
                        } else {
                            this.b = super.getWritableDatabase();
                        }
                    }
                    this.a.incrementAndGet();
                } catch (Throwable th) {
                    af.c("TAG", "e", th);
                }
                sQLiteDatabase = this.b;
                return sQLiteDatabase;
            }

            public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
                if (sQLiteDatabase != null) {
                    try {
                        if (this.a.decrementAndGet() == 0) {
                            if (this.d != null) {
                                this.d.cancel(false);
                            }
                            i.a();
                            this.d = i.a(null, this.c, 30000);
                        }
                    } catch (Throwable th) {
                    }
                }
            }

            public static void a(Cursor cursor) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th) {
                    }
                }
            }
        }
