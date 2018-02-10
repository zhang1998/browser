package com.e.b.b.c;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ b a;

    private a(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        this.a.d = false;
        synchronized (this.a.b) {
            for (int i = 0; i < this.a.a.size(); i++) {
                ((d) this.a.a.get(i)).c();
            }
        }
    }
}
