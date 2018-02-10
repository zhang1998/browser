package com.ucpro.feature.bookmarkhis.a.a;

import android.os.Message;
import android.text.TextUtils;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ d b;

    c(d dVar, Message message) {
        this.b = dVar;
        this.a = message;
    }

    public final void run() {
        if (this.a != null) {
            switch (this.a.what) {
                case 0:
                    h a = this.b.c;
                    try {
                        a.a = new i();
                        a.b = a.a.getWritableDatabase();
                        break;
                    } catch (Throwable th) {
                        h.a(th, "open");
                        break;
                    }
                case 2:
                    this.b.b = this.b.c.b();
                    if (!(this.b.a == null || this.b.a.get() == null)) {
                        ((e) this.b.a.get()).a();
                    }
                    m.a(2, new j(this.b));
                    break;
                case 3:
                    if (this.a.obj instanceof f) {
                        this.b.c.b((f) this.a.obj);
                        break;
                    }
                    break;
                case 4:
                    if (this.a.obj instanceof String) {
                        String str = (String) this.a.obj;
                        if (!TextUtils.isEmpty(str)) {
                            h a2 = this.b.c;
                            if (!TextUtils.isEmpty(str)) {
                                a2.a(String.format("%s = (select min(%s) from %s where %s = '%s')", new Object[]{"id", "id", "history", "url", str}));
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    this.b.c.a(null);
                    break;
                case 6:
                    if (!(this.a.obj instanceof String[])) {
                        if (this.a.obj instanceof f) {
                            this.b.c.c((f) this.a.obj);
                            break;
                        }
                    }
                    String[] strArr = (String[]) this.a.obj;
                    if (strArr.length >= 3) {
                        this.b.c.a(strArr[0], strArr[1], strArr[2]);
                        break;
                    }
                    return;
                    break;
                case 7:
                    if (this.a.obj instanceof f) {
                        this.b.c.a((f) this.a.obj);
                        break;
                    }
                    break;
            }
            this.a.recycle();
        }
    }
}
