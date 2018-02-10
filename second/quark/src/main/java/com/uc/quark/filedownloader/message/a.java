package com.uc.quark.filedownloader.message;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ MessageSnapshot a;
    final /* synthetic */ f b;

    a(f fVar, MessageSnapshot messageSnapshot) {
        this.b = fVar;
        this.a = messageSnapshot;
    }

    public final void run() {
        if (this.b.b.b != null) {
            this.b.b.b.a(this.a);
        }
        try {
            this.b.a.remove(Integer.valueOf(this.a.a));
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
