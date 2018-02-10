package com.loc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class az {
    final bb a;
    final boolean[] b;
    boolean c;
    final /* synthetic */ bc d;
    private boolean e;

    private az(bc bcVar, bb bbVar) {
        this.d = bcVar;
        this.a = bbVar;
        this.b = bbVar.c ? null : new boolean[bcVar.j];
    }

    public final OutputStream a() throws IOException {
        if (this.d.j <= 0) {
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.j);
        }
        OutputStream c;
        synchronized (this.d) {
            File b;
            OutputStream fileOutputStream;
            if (this.a.d != this) {
                throw new IllegalStateException();
            }
            if (!this.a.c) {
                this.b[0] = true;
            }
            b = this.a.b(0);
            try {
                fileOutputStream = new FileOutputStream(b);
            } catch (FileNotFoundException e) {
                this.d.d.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e2) {
                    c = bc.q;
                }
            }
            c = new ay(this, fileOutputStream);
        }
        return c;
    }

    public final void b() throws IOException {
        if (this.c) {
            this.d.a(this, false);
            this.d.c(this.a.a);
        } else {
            this.d.a(this, true);
        }
        this.e = true;
    }

    public final void c() throws IOException {
        this.d.a(this, false);
    }
}
