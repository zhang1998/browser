package com.alibaba.analytics.core.db;

import android.content.Context;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.model.b;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ File b;

    e(Context context, File file) {
        this.a = context;
        this.b = file;
    }

    public final void run() {
        a aVar = new a(this.a, f.a);
        while (true) {
            List a = aVar.a(b.class, null, "time", 100);
            if (a.size() == 0) {
                af.a("OldDBTransferMgr", "delete old db file:", this.b.getAbsoluteFile());
                this.b.delete();
                return;
            }
            aVar.b(a);
            com.alibaba.analytics.core.b.a().n.a(a);
        }
    }
}
