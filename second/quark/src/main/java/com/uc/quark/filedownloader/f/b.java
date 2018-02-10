package com.uc.quark.filedownloader.f;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
final class b implements a {
    final /* synthetic */ p a;
    final /* synthetic */ OutputStream b;

    b(p pVar, OutputStream outputStream) {
        this.a = pVar;
        this.b = outputStream;
    }

    public final void a(o oVar, long j) throws IOException {
        e.a(oVar.b, 0, j);
        while (j > 0) {
            this.a.a();
            n nVar = oVar.a;
            int min = (int) Math.min(j, (long) (nVar.c - nVar.b));
            this.b.write(nVar.a, nVar.b, min);
            nVar.b += min;
            j -= (long) min;
            oVar.b -= (long) min;
            if (nVar.b == nVar.c) {
                oVar.a = nVar.a();
                k.a(nVar);
            }
        }
    }

    public final void flush() throws IOException {
        this.b.flush();
    }

    public final void close() throws IOException {
        this.b.close();
    }

    public final String toString() {
        return "sink(" + this.b + ")";
    }
}
