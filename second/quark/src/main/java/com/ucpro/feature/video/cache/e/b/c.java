package com.ucpro.feature.video.cache.e.b;

/* compiled from: ProGuard */
public final class c extends Exception {
    private final String a;
    private final int b;

    public c(String str, int i, Throwable th) {
        super(th);
        this.a = str;
        this.b = i;
    }

    public c(String str, int i, String str2) {
        super(str2);
        this.a = str;
        this.b = i;
    }

    public final String getMessage() {
        return "Error at line " + this.b + ": " + this.a + "\n" + super.getMessage();
    }
}
