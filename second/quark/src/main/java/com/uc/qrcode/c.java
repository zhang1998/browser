package com.uc.qrcode;

import com.uc.qrcode.a.a.b;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ f a;

    c(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        try {
            com.uc.qrcode.a.c a = this.a.c;
            synchronized (a.b) {
                b bVar = a.d;
                if (!(bVar == null || a.h)) {
                    bVar.a.startPreview();
                    a.h = true;
                }
            }
        } catch (Exception e) {
        }
    }
}
