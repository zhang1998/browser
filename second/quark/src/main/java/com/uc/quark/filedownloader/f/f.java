package com.uc.quark.filedownloader.f;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class f implements c {
    final /* synthetic */ p a;
    final /* synthetic */ InputStream b;

    f(p pVar, InputStream inputStream) {
        this.a = pVar;
        this.b = inputStream;
    }

    public final long b(o oVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            try {
                n nVar;
                this.a.a();
                if (oVar.a == null) {
                    oVar.a = k.a();
                    n nVar2 = oVar.a;
                    n nVar3 = oVar.a;
                    nVar = oVar.a;
                    nVar3.g = nVar;
                    nVar2.f = nVar;
                } else {
                    nVar = oVar.a.g;
                    if (nVar.c + 1 > 2097152 || !nVar.e) {
                        nVar = nVar.a(k.a());
                    }
                }
                int read = this.b.read(nVar.a, nVar.c, (int) Math.min(j, (long) (2097152 - nVar.c)));
                if (read == -1) {
                    return -1;
                }
                nVar.c += read;
                oVar.b += (long) read;
                return (long) read;
            } catch (AssertionError e) {
                if (i.a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
    }

    public final void close() throws IOException {
        this.b.close();
    }

    public final String toString() {
        return "source(" + this.b + ")";
    }
}
