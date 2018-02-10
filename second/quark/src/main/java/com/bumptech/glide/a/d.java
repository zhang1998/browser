package com.bumptech.glide.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: ProGuard */
final class d {
    final String a;
    final long[] b;
    File[] c;
    File[] d;
    boolean e;
    c f;
    long g;
    final /* synthetic */ f h;

    private d(f fVar, String str) {
        this.h = fVar;
        this.a = str;
        this.b = new long[fVar.h];
        this.c = new File[fVar.h];
        this.d = new File[fVar.h];
        StringBuilder append = new StringBuilder(str).append('.');
        int length = append.length();
        for (int i = 0; i < fVar.h; i++) {
            append.append(i);
            this.c[i] = new File(fVar.b, append.toString());
            append.append(".tmp");
            this.d[i] = new File(fVar.b, append.toString());
            append.setLength(length);
        }
    }

    public final String a() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.b) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    private static IOException a(String[] strArr) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    static /* synthetic */ void a(d dVar, String[] strArr) throws IOException {
        if (strArr.length != dVar.h.h) {
            throw a(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                dVar.b[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw a(strArr);
            }
        }
    }
}
