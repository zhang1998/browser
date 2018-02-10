package com.ucpro.feature.downloadpage.e;

import com.ucpro.ui.b.e;
import java.io.IOException;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ IOException a;
    final /* synthetic */ aa b;

    u(aa aaVar, IOException iOException) {
        this.b = aaVar;
        this.a = iOException;
    }

    public final void run() {
        e.a().a(this.a, 0);
        if (this.b.a != null) {
            this.b.a.onReceiveValue(null);
        }
    }
}
