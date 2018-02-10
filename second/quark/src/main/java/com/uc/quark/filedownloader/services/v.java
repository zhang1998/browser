package com.uc.quark.filedownloader.services;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.model.b;
import com.uc.quark.filedownloader.model.f;

/* compiled from: ProGuard */
final class v implements i {
    final Object a;
    final SQLiteDatabase b;
    final SparseArray<b> c;

    private v() {
        this.a = new Object();
        this.c = new SparseArray();
        this.b = new s(e.a()).getWritableDatabase();
        b.a.a(new k(this));
    }

    public final b a(int i) {
        b bVar;
        synchronized (this.a) {
            bVar = (b) this.c.get(i);
        }
        return bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.uc.quark.filedownloader.model.b r9) {
        /*
        r8 = this;
        r1 = r8.a;
        monitor-enter(r1);
        if (r9 != 0) goto L_0x000f;
    L_0x0005:
        r0 = "update but model == null!";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x004c }
        com.uc.quark.filedownloader.e.j.e(r8, r0, r2);	 Catch:{ all -> 0x004c }
        monitor-exit(r1);	 Catch:{ all -> 0x004c }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r9.a;	 Catch:{ all -> 0x004c }
        r0 = r8.a(r0);	 Catch:{ all -> 0x004c }
        if (r0 == 0) goto L_0x004f;
    L_0x0017:
        r0 = r8.c;	 Catch:{ all -> 0x004c }
        r2 = r9.a;	 Catch:{ all -> 0x004c }
        r0.remove(r2);	 Catch:{ all -> 0x004c }
        r0 = r8.c;	 Catch:{ all -> 0x004c }
        r2 = r9.a;	 Catch:{ all -> 0x004c }
        r0.put(r2, r9);	 Catch:{ all -> 0x004c }
        r0 = r9.c();	 Catch:{ all -> 0x004c }
        r2 = r8.b;	 Catch:{ all -> 0x004c }
        r3 = "filedownloader";
        r4 = "_id = ? ";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x004c }
        r6 = 0;
        r7 = r9.a;	 Catch:{ all -> 0x004c }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x004c }
        r5[r6] = r7;	 Catch:{ all -> 0x004c }
        r2.update(r3, r0, r4, r5);	 Catch:{ all -> 0x004c }
        r0 = com.uc.quark.filedownloader.services.b.a;	 Catch:{ all -> 0x004c }
        r2 = new com.uc.quark.filedownloader.services.f;	 Catch:{ all -> 0x004c }
        r2.<init>(r8, r9);	 Catch:{ all -> 0x004c }
        r0.a(r2);	 Catch:{ all -> 0x004c }
    L_0x004a:
        monitor-exit(r1);	 Catch:{ all -> 0x004c }
        goto L_0x000e;
    L_0x004c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004c }
        throw r0;
    L_0x004f:
        r2 = r8.a;	 Catch:{ all -> 0x004c }
        monitor-enter(r2);	 Catch:{ all -> 0x004c }
        r0 = r8.c;	 Catch:{ all -> 0x0073 }
        r3 = r9.a;	 Catch:{ all -> 0x0073 }
        r0.put(r3, r9);	 Catch:{ all -> 0x0073 }
        r0 = r8.b;	 Catch:{ all -> 0x0073 }
        r3 = "filedownloader";
        r4 = 0;
        r5 = r9.c();	 Catch:{ all -> 0x0073 }
        r0.insert(r3, r4, r5);	 Catch:{ all -> 0x0073 }
        r0 = com.uc.quark.filedownloader.services.b.a;	 Catch:{ all -> 0x0073 }
        r3 = new com.uc.quark.filedownloader.services.r;	 Catch:{ all -> 0x0073 }
        r3.<init>(r8, r9);	 Catch:{ all -> 0x0073 }
        r0.a(r3);	 Catch:{ all -> 0x0073 }
        monitor-exit(r2);	 Catch:{ all -> 0x0073 }
        goto L_0x004a;
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0073 }
        throw r0;	 Catch:{ all -> 0x004c }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.v.a(com.uc.quark.filedownloader.model.b):void");
    }

    public final boolean b(int i) {
        synchronized (this.a) {
            this.c.remove(i);
            b.a.a(new a(this, i));
        }
        return true;
    }

    public final void a(b bVar, long j, String str, String str2) {
        synchronized (this.a) {
            b a = a(bVar.a);
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) 2));
            if (a != null) {
                a.f = (byte) 2;
                bVar.f = (byte) 2;
                if (a.h != j) {
                    a.a(j);
                    contentValues.put("total", Long.valueOf(j));
                }
                String str3 = bVar.j;
                if (!(TextUtils.isEmpty(str) || str.equals(str3))) {
                    a.a(str);
                    bVar.a(str);
                    contentValues.put("etag", str);
                }
                if (a.d && a.e == null && str2 != null) {
                    a.e = str2;
                    bVar.e = str2;
                    contentValues.put("filename", str2);
                }
            }
            a(bVar.a, contentValues);
        }
    }

    public final void a(b bVar, long j) {
        synchronized (this.a) {
            b a = a(bVar.a);
            if (a != null) {
                a.f = (byte) 3;
                a.g = j;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) 3));
            contentValues.put("sofar", Long.valueOf(j));
            contentValues.put("total", Long.valueOf(bVar.h));
            a(bVar.a, contentValues);
        }
    }

    public final void a(b bVar, Throwable th, long j) {
        synchronized (this.a) {
            String th2 = th.toString();
            b a = a(bVar.a);
            if (a != null) {
                a.f = (byte) -1;
                a.g = j;
                a.a(bVar.h);
            }
            bVar.f = (byte) -1;
            bVar.i = th2;
            bVar.g = j;
            ContentValues contentValues = new ContentValues();
            contentValues.put("errMsg", th2);
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -1));
            contentValues.put("sofar", Long.valueOf(j));
            contentValues.put("total", Long.valueOf(bVar.h));
            a(bVar.a, contentValues);
        }
    }

    public final void a(b bVar, Throwable th) {
        synchronized (this.a) {
            String th2 = th.toString();
            bVar.f = (byte) 5;
            bVar.i = th2;
            ContentValues contentValues = new ContentValues();
            contentValues.put("errMsg", th2);
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) 5));
            a(bVar.a, contentValues);
        }
    }

    public final void b(b bVar, long j) {
        synchronized (this.a) {
            bVar.f = (byte) -3;
            bVar.g = j;
            bVar.a(j);
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -3));
            contentValues.put("total", Long.valueOf(j));
            contentValues.put("sofar", Long.valueOf(j));
            a(bVar.a, contentValues);
        }
    }

    public final void c(b bVar, long j) {
        synchronized (this.a) {
            b a = a(bVar.a);
            if (a != null) {
                a.f = (byte) -2;
                a.g = j;
                a.a(bVar.h);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -2));
            contentValues.put("sofar", Long.valueOf(j));
            a(bVar.a, contentValues);
        }
    }

    public final void b(b bVar) {
        synchronized (this.a) {
            b a = a(bVar.a);
            if (a != null) {
                a.f = (byte) 1;
                a.g = bVar.g;
                a.a(bVar.h);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) 1));
            contentValues.put("sofar", Long.valueOf(bVar.g));
            contentValues.put("total", Long.valueOf(bVar.h));
            a(bVar.a, contentValues);
        }
    }

    public final void c(b bVar) {
        synchronized (this.a) {
            b a = a(bVar.a);
            if (a != null) {
                a.f = bVar.f;
                a.g = bVar.g;
                a.a(bVar.h);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf(bVar.f));
            contentValues.put("sofar", Long.valueOf(bVar.g));
            contentValues.put("total", Long.valueOf(bVar.h));
            a(bVar.a, contentValues);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.uc.quark.filedownloader.model.f> c(int r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = 0;
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00a6 }
        r1.<init>();	 Catch:{ all -> 0x00a6 }
        r2 = r8.b;	 Catch:{ Exception -> 0x0098, all -> 0x00a9 }
        r3 = "select * from threadids where downloadfile_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0098, all -> 0x00a9 }
        r5 = 0;
        r6 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0098, all -> 0x00a9 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0098, all -> 0x00a9 }
        r0 = r2.rawQuery(r3, r4);	 Catch:{ Exception -> 0x0098, all -> 0x00a9 }
    L_0x0019:
        if (r0 == 0) goto L_0x00a0;
    L_0x001b:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        if (r2 == 0) goto L_0x00a0;
    L_0x0021:
        r2 = new com.uc.quark.filedownloader.model.f;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.<init>();	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "id";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.a = r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "url";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.b = r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "sofar";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r4 = r0.getLong(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.d = r4;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "download_length";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r4 = r0.getLong(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.c = r4;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "thread_id";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.e = r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "downloadfile_id";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r4 = (long) r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.f = r4;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "status";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = r0.getShort(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.g = r3;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "normal_size";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r4 = r0.getLong(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.h = r4;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r3 = "ext_size";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r4 = r0.getLong(r3);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r2.i = r4;	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        r1.add(r2);	 Catch:{ Exception -> 0x0098, all -> 0x00b3 }
        goto L_0x0019;
    L_0x0098:
        r2 = move-exception;
        if (r0 == 0) goto L_0x009e;
    L_0x009b:
        r0.close();	 Catch:{ all -> 0x00a6 }
    L_0x009e:
        monitor-exit(r8);
        return r1;
    L_0x00a0:
        if (r0 == 0) goto L_0x009e;
    L_0x00a2:
        r0.close();	 Catch:{ all -> 0x00a6 }
        goto L_0x009e;
    L_0x00a6:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00a9:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x00ad:
        if (r1 == 0) goto L_0x00b2;
    L_0x00af:
        r1.close();	 Catch:{ all -> 0x00a6 }
    L_0x00b2:
        throw r0;	 Catch:{ all -> 0x00a6 }
    L_0x00b3:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.v.c(int):java.util.List<com.uc.quark.filedownloader.model.f>");
    }

    public final synchronized void a(f fVar) {
        this.b.insert("threadids", null, fVar.a());
    }

    public final synchronized void b(f fVar) {
        if (fVar != null) {
            this.b.update("threadids", fVar.a(), "thread_id = ? and downloadfile_id = ?", new String[]{String.valueOf(fVar.e), String.valueOf(fVar.f)});
        }
    }

    public final synchronized void c(f fVar) {
        if (fVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -1));
            contentValues.put("sofar", Long.valueOf(fVar.d));
            this.b.update("threadids", contentValues, "thread_id = ? and downloadfile_id = ?", new String[]{String.valueOf(fVar.e), String.valueOf(fVar.f)});
        }
    }

    public final synchronized void d(f fVar) {
        if (fVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -2));
            contentValues.put("sofar", Long.valueOf(fVar.d));
            this.b.update("threadids", contentValues, "thread_id = ? and downloadfile_id = ?", new String[]{String.valueOf(fVar.e), String.valueOf(fVar.f)});
        }
    }

    public final void d(int i) {
        synchronized (this.a) {
            this.c.remove(i);
            try {
                this.b.delete("threadids", "downloadfile_id = ?", new String[]{String.valueOf(i)});
            } catch (Exception e) {
            }
        }
    }

    private void a(int i, ContentValues contentValues) {
        b.a.a(new y(this, contentValues, i));
    }
}
