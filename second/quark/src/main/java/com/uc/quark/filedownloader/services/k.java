package com.uc.quark.filedownloader.services;

import android.database.Cursor;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.quark.filedownloader.contentprovider.a;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.model.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ v a;

    k(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        v vVar = this.a;
        synchronized (vVar.a) {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor cursor = null;
            List arrayList = new ArrayList();
            try {
                cursor = vVar.b.rawQuery("SELECT * FROM filedownloader", null);
                while (cursor.moveToNext()) {
                    try {
                        boolean z;
                        b bVar = new b();
                        bVar.a = cursor.getInt(cursor.getColumnIndex("_id"));
                        bVar.b = cursor.getString(cursor.getColumnIndex("url"));
                        bVar.n = cursor.getString(cursor.getColumnIndex("updateUrl"));
                        bVar.a(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == (short) 1);
                        bVar.f = (byte) cursor.getShort(cursor.getColumnIndex(INoCaptchaComponent.status));
                        bVar.g = cursor.getLong(cursor.getColumnIndex("sofar"));
                        bVar.a(cursor.getLong(cursor.getColumnIndex("total")));
                        bVar.i = cursor.getString(cursor.getColumnIndex("errMsg"));
                        bVar.a(cursor.getString(cursor.getColumnIndex("etag")));
                        bVar.e = cursor.getString(cursor.getColumnIndex("filename"));
                        bVar.k = cursor.getString(cursor.getColumnIndex("postBody"));
                        if (cursor.getShort(cursor.getColumnIndex("fileContinue")) == (short) 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bVar.l = z;
                        if (cursor.getShort(cursor.getColumnIndex("isNeedRefer")) == (short) 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bVar.m = z;
                        if (bVar.f == (byte) 3 || bVar.f == (byte) 2 || (bVar.f == (byte) 1 && bVar.g > 0)) {
                            bVar.f = (byte) -2;
                        }
                        String a = bVar.a();
                        if (a == null) {
                            arrayList.add(Integer.valueOf(bVar.a));
                        } else {
                            File file = new File(a);
                            File file2 = new File(bVar.b());
                            if (bVar.f == (byte) -2 && com.uc.quark.filedownloader.e.b.a(bVar.a, bVar.c) && !file2.exists() && file.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                if (j.a) {
                                    j.d(vVar, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                }
                            }
                            if (!(file2.exists() || file.exists())) {
                                arrayList.add(Integer.valueOf(bVar.a));
                            }
                            if (bVar.f == (byte) 1 && bVar.g <= 0) {
                                arrayList.add(Integer.valueOf(bVar.a));
                            } else if (!com.uc.quark.filedownloader.e.b.a(bVar.a, bVar)) {
                                arrayList.add(Integer.valueOf(bVar.a));
                            } else if (file.exists()) {
                                arrayList.add(Integer.valueOf(bVar.a));
                            } else if (a.f(bVar.a)) {
                                vVar.c.put(bVar.a, bVar);
                            } else {
                                arrayList.add(Integer.valueOf(bVar.a));
                            }
                        }
                    } catch (Exception e) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        com.uc.quark.filedownloader.e.b.b(e.a());
                        b.a.a(new p(vVar, arrayList, currentTimeMillis));
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        r1 = cursor;
                        Throwable th3 = th2;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                com.uc.quark.filedownloader.e.b.b(e.a());
                b.a.a(new p(vVar, arrayList, currentTimeMillis));
            } catch (Exception e2) {
                if (cursor != null) {
                    cursor.close();
                }
                com.uc.quark.filedownloader.e.b.b(e.a());
                b.a.a(new p(vVar, arrayList, currentTimeMillis));
            } catch (Throwable th4) {
                th2 = th4;
                r1 = cursor;
                th3 = th2;
                Cursor cursor2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                com.uc.quark.filedownloader.e.b.b(e.a());
                b.a.a(new p(vVar, arrayList, currentTimeMillis));
                throw th3;
            }
        }
    }
}
