package com.loc;

import android.os.Messenger;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class a implements Callable<Messenger> {
    final /* synthetic */ j a;

    a(j jVar) {
        this.a = jVar;
    }

    private Messenger a() {
        while (this.a.i == null) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return this.a.i;
    }

    public final /* synthetic */ Object call() throws Exception {
        return a();
    }
}
