package com.uc.apollo.media.b;

import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class d extends Exception {
    private byte[] a;
    private String b;
    private int c;

    public d(String str, int i, String str2) {
        super(str2);
        this.b = str;
        this.c = i;
    }

    public d(byte[] bArr, Throwable th) {
        super(th);
        this.a = bArr;
    }

    public d(byte[] bArr) {
        this.a = bArr;
    }

    public final byte[] a() {
        return this.a;
    }

    final void a(byte[] bArr) {
        this.a = bArr;
    }

    public final String getMessage() {
        if (this.a != null) {
            return "not m3u8 format, start data: " + new String(this.a, Charset.forName("UTF-8"));
        }
        return "Error at line " + this.c + ": " + this.b + "\n" + super.getMessage();
    }
}
