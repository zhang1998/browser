package com.uc.quark.filedownloader;

/* compiled from: ProGuard */
final class k implements Runnable {
    private final an a;
    private boolean b = false;

    k(an anVar) {
        this.a = anVar;
    }

    public final void run() {
        if (!this.b) {
            this.a.n();
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj) || obj == this.a;
    }
}
