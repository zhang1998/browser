package com.f.a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ProGuard */
final class e implements XmlSerializer {
    private static final String[] a = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    private final char[] b = new char[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
    private int c;
    private Writer d;
    private OutputStream e;
    private CharsetEncoder f;
    private ByteBuffer g = ByteBuffer.allocate(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    private boolean h;

    e() {
    }

    private void a(char c) throws IOException {
        int i = this.c;
        if (i >= 8191) {
            flush();
            i = this.c;
        }
        this.b[i] = c;
        this.c = i + 1;
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
                a(str, i, i4 < i3 ? SpdyProtocol.SLIGHTSSL_1_RTT_MODE : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.c;
        if (i5 + i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            flush();
            i5 = this.c;
        }
        str.getChars(i, i + i2, this.b, i5);
        this.c = i5 + i2;
    }

    private void a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
                a(cArr, i, i4 < i3 ? SpdyProtocol.SLIGHTSSL_1_RTT_MODE : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.c;
        if (i5 + i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            flush();
            i5 = this.c;
        }
        System.arraycopy(cArr, i, this.b, i5, i2);
        this.c = i5 + i2;
    }

    private void a(String str) throws IOException {
        a(str, 0, str.length());
    }

    private void b(String str) throws IOException {
        int i = 0;
        int length = str.length();
        char length2 = (char) a.length;
        String[] strArr = a;
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2) {
                String str2 = strArr[charAt];
                if (str2 != null) {
                    if (i < i2) {
                        a(str, i, i2 - i);
                    }
                    i = i2 + 1;
                    a(str2);
                }
            }
            i2++;
        }
        if (i < i2) {
            a(str, i, i2 - i);
        }
    }

    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        a(' ');
        if (str != null) {
            a(str);
            a(':');
        }
        a(str2);
        a("=\"");
        b(str3);
        a('\"');
        return this;
    }

    public final void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.h) {
            a(" />\n");
        } else {
            a("</");
            if (str != null) {
                a(str);
                a(':');
            }
            a(str2);
            a(">\n");
        }
        this.h = false;
        return this;
    }

    public final void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void a() throws IOException {
        int position = this.g.position();
        if (position > 0) {
            this.g.flip();
            this.e.write(this.g.array(), 0, position);
            this.g.clear();
        }
    }

    public final void flush() throws IOException {
        if (this.c > 0) {
            if (this.e != null) {
                CharBuffer wrap = CharBuffer.wrap(this.b, 0, this.c);
                CoderResult encode = this.f.encode(wrap, this.g, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f.encode(wrap, this.g, true);
                    } else {
                        a();
                        this.e.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.d.write(this.b, 0, this.c);
            this.d.flush();
            this.c = 0;
        }
    }

    public final int getDepth() {
        throw new UnsupportedOperationException();
    }

    public final boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public final String getName() {
        throw new UnsupportedOperationException();
    }

    public final String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public final String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public final Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public final void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f = Charset.forName(str).newEncoder();
            this.e = outputStream;
        } catch (Throwable e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (Throwable e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    public final void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.d = writer;
    }

    public final void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        a("<?xml version='1.0' encoding='utf-8' standalone='" + (bool.booleanValue() ? "yes" : "no") + "' ?>\n");
    }

    public final XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.h) {
            a(">\n");
        }
        a('<');
        if (str != null) {
            a(str);
            a(':');
        }
        a(str2);
        this.h = true;
        return this;
    }

    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.h) {
            a(">");
            this.h = false;
        }
        char length = (char) a.length;
        String[] strArr = a;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length) {
                String str = strArr[c];
                if (str != null) {
                    if (i4 < i) {
                        a(cArr, i4, i - i4);
                    }
                    i4 = i + 1;
                    a(str);
                }
            }
            i++;
        }
        if (i4 < i) {
            a(cArr, i4, i - i4);
        }
        return this;
    }

    public final XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.h) {
            a(">");
            this.h = false;
        }
        b(str);
        return this;
    }
}
