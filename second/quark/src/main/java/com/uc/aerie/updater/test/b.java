package com.uc.aerie.updater.test;

import android.util.Log;
import com.uc.aerie.updater.a;
import java.io.File;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ AerieUpdaterTestActivity b;

    b(AerieUpdaterTestActivity aerieUpdaterTestActivity, String str) {
        this.b = aerieUpdaterTestActivity;
        this.a = str;
    }

    public final void run() {
        try {
            this.b.a.sendMessage(this.b.a.obtainMessage(1, 0, 0, a.a().a(new File(this.a))));
        } catch (Throwable e) {
            Log.e("aerie_update_test", "install package exception", e);
            this.b.a.sendMessage(this.b.a.obtainMessage(1, 1, 0, e));
        }
    }
}
