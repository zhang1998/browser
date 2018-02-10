package com.ucpro.services.location.a;

/* compiled from: ProGuard */
public final class b implements Runnable {
    String a;
    String b;
    c c;

    public b(String str, String str2, c cVar) {
        this.a = str;
        this.b = str2;
        this.c = cVar;
    }

    public final void run() {
        try {
            Class.forName(this.b);
            this.c.a();
        } catch (ClassNotFoundException e) {
            this.c.b();
        }
    }
}
