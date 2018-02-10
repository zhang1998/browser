package com.uc.qrcode;

/* compiled from: ProGuard */
public final class l implements Runnable {
    final /* synthetic */ n a;

    public l(n nVar) {
        this.a = nVar;
    }

    public final void run() {
        if (this.a.a != null) {
            if (this.a.c != null) {
                this.a.c.a(this.a.a.getText());
            }
        } else if (this.a.c != null) {
            this.a.c.a();
        }
    }
}
