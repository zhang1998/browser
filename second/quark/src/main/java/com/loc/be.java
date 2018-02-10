package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ProGuard */
final class be extends ByteArrayOutputStream {
    final /* synthetic */ bf a;

    be(bf bfVar, int i) {
        this.a = bfVar;
        super(i);
    }

    public final String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.a.a.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
