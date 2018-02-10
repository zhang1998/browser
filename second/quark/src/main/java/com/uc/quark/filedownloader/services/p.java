package com.uc.quark.filedownloader.services;

import android.text.TextUtils;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.j;
import java.util.List;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ long b;
    final /* synthetic */ v c;

    p(v vVar, List list, long j) {
        this.c = vVar;
        this.a = list;
        this.b = j;
    }

    public final void run() {
        if (this.a.size() > 0) {
            String join = TextUtils.join(", ", this.a);
            if (j.a) {
                j.d(this, "delete %s", join);
            }
            this.c.b.execSQL(b.a("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", join));
            this.c.b.execSQL(b.a("DELETE FROM %s WHERE %s IN (%s);", "threadids", "downloadfile_id", join));
        }
        if (j.a) {
            j.d(this, "refresh data %d , will delete: %d consume %d", Integer.valueOf(this.c.c.size()), Integer.valueOf(this.a.size()), Long.valueOf(System.currentTimeMillis() - this.b));
        }
    }
}
