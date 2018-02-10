package com.taobao.weex.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.mini.support.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: ProGuard */
public final class k extends SQLiteOpenHelper {
    static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private long b = 52428800;
    private Context c;
    private SQLiteDatabase d;

    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r8, int r9, int r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:22:? in {14, 16, 18, 19, 20, 21, 23, 24} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r0 = 1;
        if (r9 == r10) goto L_0x00cb;
    L_0x0003:
        r1 = 2;
        if (r10 != r1) goto L_0x0103;
    L_0x0006:
        if (r9 != r0) goto L_0x0103;
    L_0x0008:
        r1 = "weex_storage";
        r2 = new java.lang.StringBuilder;
        r3 = "storage is updating from version ";
        r2.<init>(r3);
        r2 = r2.append(r9);
        r3 = " to version ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        com.taobao.weex.utils.WXLogUtils.d(r1, r2);
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.beginTransaction();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = "ALTER TABLE default_wx_storage ADD COLUMN timestamp TEXT;";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = "weex_storage";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r6 = "exec sql : ";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        com.taobao.weex.utils.WXLogUtils.d(r4, r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.execSQL(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = "ALTER TABLE default_wx_storage ADD COLUMN persistent INTEGER;";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = "weex_storage";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r6 = "exec sql : ";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        com.taobao.weex.utils.WXLogUtils.d(r4, r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.execSQL(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = "UPDATE default_wx_storage SET timestamp = '";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = a;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = new java.util.Date;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5.<init>();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = r4.format(r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = "' , persistent = 0";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = "weex_storage";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r6 = "exec sql : ";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        com.taobao.weex.utils.WXLogUtils.d(r4, r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.execSQL(r1);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.setTransactionSuccessful();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r4 - r2;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r1 = "weex_storage";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r5 = "storage updated success (";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r3 = "ms)";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        com.taobao.weex.utils.WXLogUtils.d(r1, r2);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r8.endTransaction();
    L_0x00bc:
        if (r0 != 0) goto L_0x00cb;
    L_0x00be:
        r0 = "weex_storage";
        r1 = "storage is rollback,all data will be removed";
        com.taobao.weex.utils.WXLogUtils.d(r0, r1);
        r7.d();
        r7.onCreate(r8);
    L_0x00cb:
        return;
    L_0x00cc:
        r0 = move-exception;
        r1 = "weex_storage";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r3 = "storage updated failed from version ";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r3 = " to version ";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.append(r10);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r3 = ",";	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        com.taobao.weex.utils.WXLogUtils.d(r1, r0);	 Catch:{ Exception -> 0x00cc, all -> 0x00fe }
        r0 = 0;
        r8.endTransaction();
        goto L_0x00bc;
    L_0x00fe:
        r0 = move-exception;
        r8.endTransaction();
        throw r0;
    L_0x0103:
        r7.d();
        r7.onCreate(r8);
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.b.c.k.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public k(Context context) {
        super(context, "WXStorage", null, 2);
        this.c = context;
    }

    @Nullable
    public final SQLiteDatabase a() {
        c();
        return this.d;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL,persistent INTEGER DEFAULT 0)");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c() {
        /*
        r5 = this;
        r0 = 0;
        monitor-enter(r5);
        r1 = r5.d;	 Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x0010;
    L_0x0006:
        r1 = r5.d;	 Catch:{ all -> 0x0041 }
        r1 = r1.isOpen();	 Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r5);
        return;
    L_0x0010:
        r1 = 0;
    L_0x0011:
        r2 = 2;
        if (r1 >= r2) goto L_0x001f;
    L_0x0014:
        if (r1 <= 0) goto L_0x0019;
    L_0x0016:
        r5.d();	 Catch:{ SQLiteException -> 0x0044 }
    L_0x0019:
        r2 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0044 }
        r5.d = r2;	 Catch:{ SQLiteException -> 0x0044 }
    L_0x001f:
        r1 = r5.d;	 Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x000e;
    L_0x0023:
        r1 = r5.d;	 Catch:{ all -> 0x0041 }
        r2 = "SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'default_wx_storage'";
        r3 = 0;
        r0 = r1.rawQuery(r2, r3);	 Catch:{ Exception -> 0x0061, all -> 0x0068 }
        if (r0 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.getCount();	 Catch:{ Exception -> 0x0061, all -> 0x0072 }
        if (r2 <= 0) goto L_0x0056;
    L_0x0034:
        if (r0 == 0) goto L_0x0039;
    L_0x0036:
        r0.close();	 Catch:{ all -> 0x0041 }
    L_0x0039:
        r0 = r5.d;	 Catch:{ all -> 0x0041 }
        r2 = r5.b;	 Catch:{ all -> 0x0041 }
        r0.setMaximumSize(r2);	 Catch:{ all -> 0x0041 }
        goto L_0x000e;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0044:
        r2 = move-exception;
        r2 = 30;
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x004d }
    L_0x004a:
        r1 = r1 + 1;
        goto L_0x0011;
    L_0x004d:
        r2 = move-exception;
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0041 }
        r2.interrupt();	 Catch:{ all -> 0x0041 }
        goto L_0x004a;
    L_0x0056:
        r2 = "CREATE TABLE IF NOT EXISTS default_wx_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL,timestamp TEXT NOT NULL,persistent INTEGER DEFAULT 0)";
        r1.execSQL(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0072 }
        if (r0 == 0) goto L_0x0039;
    L_0x005d:
        r0.close();	 Catch:{ all -> 0x0041 }
        goto L_0x0039;
    L_0x0061:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0039;
    L_0x0064:
        r0.close();	 Catch:{ all -> 0x0041 }
        goto L_0x0039;
    L_0x0068:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();	 Catch:{ all -> 0x0041 }
    L_0x0071:
        throw r0;	 Catch:{ all -> 0x0041 }
    L_0x0072:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.b.c.k.c():void");
    }

    private boolean d() {
        b();
        return this.c.deleteDatabase("WXStorage");
    }

    public final void b() {
        if (this.d != null && this.d.isOpen()) {
            this.d.close();
            this.d = null;
        }
    }
}
