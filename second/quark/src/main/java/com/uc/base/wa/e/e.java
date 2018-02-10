package com.uc.base.wa.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.a.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class e {
    private static volatile e a;
    private a b;
    private SQLiteDatabase c;

    final boolean a(com.uc.base.wa.e.c r13) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00d7 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r0 = r12.f();
        if (r0 != 0) goto L_0x0011;
    L_0x0006:
        r0 = com.uc.base.wa.a.c.a();
        r1 = "db is null";
        r0.b(r1);
        r0 = 0;
    L_0x0010:
        return r0;
    L_0x0011:
        if (r13 != 0) goto L_0x001e;
    L_0x0013:
        r0 = com.uc.base.wa.a.c.a();
        r1 = "sessionStruct is null";
        r0.b(r1);
        r0 = 0;
        goto L_0x0010;
    L_0x001e:
        r8 = new java.util.ArrayList;
        r8.<init>();
        r0.beginTransaction();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = r13.a;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = -1;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        if (r1 != 0) goto L_0x00da;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x002e:
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.<init>();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "_id";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.putNull(r2);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "name";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = r13.b;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "token";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = r13.c;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "status";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = 1;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "config";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = r13.e;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = "tb_session";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = 0;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = r0.insertOrThrow(r2, r3, r1);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x0062:
        r1 = r13.f;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r4 = r1.iterator();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x0068:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        if (r1 == 0) goto L_0x0101;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x006e:
        r1 = r4.next();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = (com.uc.base.wa.e.b) r1;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = r1.a;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r10 = -1;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        if (r5 != 0) goto L_0x0068;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x007c:
        r5 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.<init>();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "_id";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.putNull(r6);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "sid";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "value";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = r1.c;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "step";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = r1.d;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "time_start";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = r1.e;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = "time_duration";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = r1.f;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5.put(r6, r1);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = "tb_session_step";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = 0;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r6 = r0.insertOrThrow(r1, r6, r5);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r8.add(r1);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        goto L_0x0068;
    L_0x00c6:
        r1 = move-exception;
        r2 = "SessionDao";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = "";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        android.util.Log.e(r2, r3, r1);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = r0.inTransaction();
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r0.endTransaction();
    L_0x00d7:
        r0 = 0;
        goto L_0x0010;
    L_0x00da:
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2.<init>();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = "status";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = r13.d;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2.put(r1, r3);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = "tb_session";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r3 = "_id is ?";	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r4 = 1;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5 = 0;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r10 = r13.a;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r4[r5] = r9;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r5 = 0;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r0.updateWithOnConflict(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r2 = r6;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        goto L_0x0062;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
    L_0x0101:
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r13.a = r2;	 Catch:{ Exception -> 0x00c6, all -> 0x013c }
        r1 = r0.inTransaction();	 Catch:{ Exception -> 0x0155 }
        if (r1 == 0) goto L_0x010f;	 Catch:{ Exception -> 0x0155 }
    L_0x010c:
        r0.endTransaction();	 Catch:{ Exception -> 0x0155 }
    L_0x010f:
        r3 = r13.f;
        r0 = 0;
        r2 = r0;
    L_0x0113:
        r0 = r3.size();
        if (r2 >= r0) goto L_0x014e;
    L_0x0119:
        r0 = r3.get(r2);
        r0 = (com.uc.base.wa.e.b) r0;
        r4 = r0.a;
        r6 = -1;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x0138;
    L_0x0127:
        r1 = r8.get(r2);
        r1 = (java.lang.Long) r1;
        if (r1 != 0) goto L_0x0147;
    L_0x012f:
        r0 = com.uc.base.wa.a.c.a();
        r1 = "index is null";
        r0.b(r1);
    L_0x0138:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0113;
    L_0x013c:
        r1 = move-exception;
        r2 = r0.inTransaction();	 Catch:{ Exception -> 0x0151 }
        if (r2 == 0) goto L_0x0146;	 Catch:{ Exception -> 0x0151 }
    L_0x0143:
        r0.endTransaction();	 Catch:{ Exception -> 0x0151 }
    L_0x0146:
        throw r1;
    L_0x0147:
        r4 = r1.longValue();
        r0.a = r4;
        goto L_0x0138;
    L_0x014e:
        r0 = 1;
        goto L_0x0010;
    L_0x0151:
        r0 = move-exception;
        goto L_0x0146;
    L_0x0153:
        r0 = move-exception;
        goto L_0x00d7;
    L_0x0155:
        r0 = move-exception;
        goto L_0x010f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.e.e.a(com.uc.base.wa.e.c):boolean");
    }

    final boolean a(java.util.List<com.uc.base.wa.e.c> r17) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00ec in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r16 = this;
        r2 = r16.f();
        if (r2 != 0) goto L_0x0011;
    L_0x0006:
        r2 = com.uc.base.wa.a.c.a();
        r3 = "db is null";
        r2.b(r3);
        r2 = 0;
    L_0x0010:
        return r2;
    L_0x0011:
        if (r17 != 0) goto L_0x001e;
    L_0x0013:
        r2 = com.uc.base.wa.a.c.a();
        r3 = "sessionStructs is null";
        r2.b(r3);
        r2 = 0;
        goto L_0x0010;
    L_0x001e:
        r4 = -1;
        r9 = new java.util.ArrayList;
        r9.<init>();
        r2.beginTransaction();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r12 = r17.iterator();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r6 = r4;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x002d:
        r3 = r12.hasNext();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        if (r3 == 0) goto L_0x0119;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0033:
        r3 = r12.next();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r0 = r3;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r0 = (com.uc.base.wa.e.c) r0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = r0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r8.a;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = -1;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        if (r3 != 0) goto L_0x00ef;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0043:
        r3 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.<init>();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "_id";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.putNull(r4);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "name";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = r8.b;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "token";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = r8.c;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "status";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = 1;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "config";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = r8.e;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = "tb_session";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = r2.insertOrThrow(r4, r5, r3);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0077:
        r3 = r8.f;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r6 = r3.iterator();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x007d:
        r3 = r6.hasNext();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        if (r3 == 0) goto L_0x0116;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0083:
        r3 = r6.next();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = (com.uc.base.wa.e.b) r3;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r3.a;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r14 = -1;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        if (r7 != 0) goto L_0x007d;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0091:
        r7 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.<init>();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "_id";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.putNull(r8);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "sid";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.put(r8, r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "value";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r3.c;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.put(r8, r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "step";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r3.d;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.put(r8, r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "time_start";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r3.e;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.put(r8, r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = "time_duration";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = r3.f;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7.put(r8, r3);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = "tb_session_step";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r8 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r10 = r2.insertOrThrow(r3, r8, r7);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r9.add(r3);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        goto L_0x007d;
    L_0x00db:
        r3 = move-exception;
        r4 = "SessionDao";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = "";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        android.util.Log.e(r4, r5, r3);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = r2.inTransaction();
        if (r3 == 0) goto L_0x00ec;
    L_0x00e9:
        r2.endTransaction();
    L_0x00ec:
        r2 = 0;
        goto L_0x0010;
    L_0x00ef:
        r4 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4.<init>();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = "status";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = r8.d;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4.put(r3, r5);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = "tb_session";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r5 = "_id is ?";	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r6 = 1;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r6 = new java.lang.String[r6];	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r14 = r8.a;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r13 = java.lang.String.valueOf(r14);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r6[r7] = r13;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r7 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r2.updateWithOnConflict(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r4 = r10;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        goto L_0x0077;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0116:
        r6 = r4;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        goto L_0x002d;	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
    L_0x0119:
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x00db, all -> 0x0165 }
        r3 = r2.inTransaction();	 Catch:{ Exception -> 0x017f }
        if (r3 == 0) goto L_0x0125;	 Catch:{ Exception -> 0x017f }
    L_0x0122:
        r2.endTransaction();	 Catch:{ Exception -> 0x017f }
    L_0x0125:
        r5 = r17.iterator();
    L_0x0129:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0177;
    L_0x012f:
        r2 = r5.next();
        r2 = (com.uc.base.wa.e.c) r2;
        r2.a = r6;
        r8 = r2.f;
        r2 = 0;
        r4 = r2;
    L_0x013b:
        r2 = r8.size();
        if (r4 >= r2) goto L_0x0129;
    L_0x0141:
        r2 = r8.get(r4);
        r3 = r2;
        r3 = (com.uc.base.wa.e.b) r3;
        r10 = r3.a;
        r12 = -1;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x0161;
    L_0x0150:
        r2 = r9.get(r4);
        r2 = (java.lang.Long) r2;
        if (r2 != 0) goto L_0x0170;
    L_0x0158:
        r2 = com.uc.base.wa.a.c.a();
        r3 = "index is null";
        r2.b(r3);
    L_0x0161:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x013b;
    L_0x0165:
        r3 = move-exception;
        r4 = r2.inTransaction();	 Catch:{ Exception -> 0x017a }
        if (r4 == 0) goto L_0x016f;	 Catch:{ Exception -> 0x017a }
    L_0x016c:
        r2.endTransaction();	 Catch:{ Exception -> 0x017a }
    L_0x016f:
        throw r3;
    L_0x0170:
        r10 = r2.longValue();
        r3.a = r10;
        goto L_0x0161;
    L_0x0177:
        r2 = 1;
        goto L_0x0010;
    L_0x017a:
        r2 = move-exception;
        goto L_0x016f;
    L_0x017c:
        r2 = move-exception;
        goto L_0x00ec;
    L_0x017f:
        r2 = move-exception;
        goto L_0x0125;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.e.e.a(java.util.List):boolean");
    }

    private e(Context context) {
        this.b = new a(context);
    }

    private SQLiteDatabase f() {
        try {
            if (this.c == null) {
                this.c = this.b.getWritableDatabase();
            }
        } catch (SQLiteException e) {
        }
        return this.c;
    }

    static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(c.b());
                }
            }
        }
        return a;
    }

    final boolean b() {
        return this.b.getWritableDatabase().inTransaction();
    }

    final void c() {
        this.b.getWritableDatabase().beginTransaction();
    }

    final void d() {
        this.b.getWritableDatabase().setTransactionSuccessful();
    }

    final void e() {
        this.b.getWritableDatabase().endTransaction();
    }

    final boolean a(b bVar) {
        SQLiteDatabase f = f();
        if (f == null) {
            c.a().b("db is null");
            return false;
        } else if (bVar.a != -1) {
            c.a().b("sessionItem is inited");
            return false;
        } else {
            c cVar = bVar.b;
            if (cVar == null) {
                c.a().b("sessionStruct is null");
                return false;
            }
            try {
                f.beginTransaction();
                long j = cVar.a;
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.putNull("_id");
                    contentValues.put("name", cVar.b);
                    contentValues.put(INoCaptchaComponent.token, cVar.c);
                    contentValues.put(INoCaptchaComponent.status, Integer.valueOf(1));
                    contentValues.put("config", Integer.valueOf(cVar.e));
                    j = f.insertOrThrow("tb_session", null, contentValues);
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.putNull("_id");
                contentValues2.put("sid", Long.valueOf(j));
                contentValues2.put("value", bVar.c);
                contentValues2.put("step", Integer.valueOf(bVar.d));
                contentValues2.put("time_start", Integer.valueOf(bVar.e));
                contentValues2.put("time_duration", Integer.valueOf(bVar.f));
                long insertOrThrow = f.insertOrThrow("tb_session_step", null, contentValues2);
                f.setTransactionSuccessful();
                cVar.a = j;
                bVar.a = insertOrThrow;
                try {
                    if (f.inTransaction()) {
                        f.endTransaction();
                    }
                } catch (Exception e) {
                }
                return true;
            } catch (Throwable e2) {
                Log.e("SessionDao", "", e2);
                try {
                    if (!f.inTransaction()) {
                        return false;
                    }
                    f.endTransaction();
                    return false;
                } catch (Exception e3) {
                    return false;
                }
            } catch (Throwable th) {
                try {
                    if (f.inTransaction()) {
                        f.endTransaction();
                    }
                } catch (Exception e4) {
                }
            }
        }
    }

    final boolean b(List<c> list) {
        SQLiteDatabase f = f();
        if (f == null) {
            c.a().b("db is null");
            return false;
        } else if (list == null) {
            c.a().b("sessionStruct is null");
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (c cVar : list) {
                long j = cVar.a;
                if (j == -1) {
                    c.a().b("sessionStruct is un-inited");
                } else if (z) {
                    stringBuilder.append("," + j);
                } else {
                    stringBuilder.append(j);
                    z = true;
                }
            }
            try {
                f.beginTransaction();
                f.delete("tb_session", "_id in (" + stringBuilder.toString() + ")", null);
                f.delete("tb_session_step", "sid in (" + stringBuilder.toString() + ")", null);
                f.setTransactionSuccessful();
                try {
                    if (f.inTransaction()) {
                        f.endTransaction();
                    }
                } catch (Exception e) {
                }
                return true;
            } catch (Throwable e2) {
                Log.e("SessionDao", "", e2);
                try {
                    if (!f.inTransaction()) {
                        return false;
                    }
                    f.endTransaction();
                    return false;
                } catch (Exception e3) {
                    return false;
                }
            } catch (Throwable th) {
                try {
                    if (f.inTransaction()) {
                        f.endTransaction();
                    }
                } catch (Exception e4) {
                }
            }
        }
    }

    final c a(String str, String str2) {
        Cursor cursor = null;
        SQLiteDatabase f = f();
        if (f == null) {
            c.a().b("db is null");
            return null;
        }
        String[] strArr = new String[]{"_id", "name", INoCaptchaComponent.token, INoCaptchaComponent.status, "config"};
        if (str2 == null) {
            try {
                Cursor query = f.query("tb_session", strArr, "name is ?", new String[]{str}, null, null, "_id desc", SettingsConst.TRUE);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        query = f.query("tb_session", strArr, "name is ? and " + str2, new String[]{str}, null, null, "_id desc", SettingsConst.TRUE);
        try {
            int columnIndex = query.getColumnIndex("_id");
            int columnIndex2 = query.getColumnIndex(INoCaptchaComponent.token);
            int columnIndex3 = query.getColumnIndex(INoCaptchaComponent.status);
            int columnIndex4 = query.getColumnIndex("config");
            if (query.moveToFirst()) {
                long j = (long) query.getInt(columnIndex);
                c cVar = new c(str, query.getString(columnIndex2), query.getInt(columnIndex3), query.getInt(columnIndex4));
                cVar.a = j;
                if (query == null) {
                    return cVar;
                }
                query.close();
                return cVar;
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th2 = th3;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    final List<c> a(String str, int i) {
        Throwable th;
        Cursor cursor;
        SQLiteDatabase f = f();
        if (f == null) {
            c.a().b("db is null");
            return null;
        }
        List<c> arrayList = new ArrayList();
        try {
            Cursor query = f.query("tb_session", new String[]{"_id", "name", INoCaptchaComponent.token, INoCaptchaComponent.status, "config"}, str, null, null, null, null);
            int columnIndex = query.getColumnIndex("_id");
            int columnIndex2 = query.getColumnIndex("name");
            int columnIndex3 = query.getColumnIndex(INoCaptchaComponent.token);
            int columnIndex4 = query.getColumnIndex(INoCaptchaComponent.status);
            int columnIndex5 = query.getColumnIndex("config");
            while (query.moveToNext()) {
                long j = (long) query.getInt(columnIndex);
                String string = query.getString(columnIndex2);
                String string2 = query.getString(columnIndex3);
                int i2 = query.getInt(columnIndex4);
                int i3 = query.getInt(columnIndex5);
                c cVar;
                if ((i & 1) == 0) {
                    cVar = new c(string, string2, i2, i3);
                    cVar.a = j;
                    arrayList.add(cVar);
                } else {
                    try {
                        Cursor query2;
                        String[] strArr = new String[]{"_id", "value", "step", "time_start", "time_duration"};
                        if ((i & 2) != 0) {
                            query2 = f.query("tb_session_step", strArr, "sid is ?", new String[]{String.valueOf(j)}, null, null, null);
                        } else {
                            try {
                                query2 = f.query("tb_session_step", strArr, "sid is ?", new String[]{String.valueOf(j)}, null, null, "_id desc", SettingsConst.TRUE);
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = null;
                            }
                        }
                        try {
                            cVar = new c(string, string2, i2, query2.getCount());
                            cVar.a = j;
                            int columnIndex6 = query2.getColumnIndex("_id");
                            int columnIndex7 = query2.getColumnIndex("value");
                            int columnIndex8 = query2.getColumnIndex("step");
                            int columnIndex9 = query2.getColumnIndex("time_start");
                            int columnIndex10 = query2.getColumnIndex("time_duration");
                            while (query2.moveToNext()) {
                                int i4 = query2.getInt(columnIndex6);
                                b bVar = new b(cVar, query2.getBlob(columnIndex7), query2.getInt(columnIndex8), query2.getInt(columnIndex9), query2.getInt(columnIndex10));
                                bVar.a = (long) i4;
                                cVar.f.add(bVar);
                            }
                            arrayList.add(cVar);
                            if (query2 != null) {
                                query2.close();
                            } else {
                                continue;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = query2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = query;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }
}
