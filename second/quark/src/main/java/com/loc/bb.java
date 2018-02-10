package com.loc;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: ProGuard */
final class bb {
    final String a;
    final long[] b;
    boolean c;
    az d;
    long e;
    final /* synthetic */ bc f;

    private bb(bc bcVar, String str) {
        this.f = bcVar;
        this.a = str;
        this.b = new long[bcVar.j];
    }

    private static IOException a(String[] strArr) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public final File a(int i) {
        return new File(this.f.d, this.a + "." + i);
    }

    public final String a() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.b) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public final File b(int i) {
        return new File(this.f.d, this.a + "." + i + ".tmp");
    }

    static /* synthetic */ void a(bb bbVar, String[] strArr) throws IOException {
        if (strArr.length != bbVar.f.j) {
            throw a(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                bbVar.b[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw a(strArr);
            }
        }
    }
}
