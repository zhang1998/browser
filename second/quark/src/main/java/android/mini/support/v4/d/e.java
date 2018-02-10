package android.mini.support.v4.d;

import java.io.Writer;

/* compiled from: ProGuard */
public final class e extends Writer {
    private final String a;
    private StringBuilder b = new StringBuilder(128);

    public e(String str) {
        this.a = str;
    }

    public final void close() {
        a();
    }

    public final void flush() {
        a();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }

    private void a() {
        if (this.b.length() > 0) {
            this.b.delete(0, this.b.length());
        }
    }
}
