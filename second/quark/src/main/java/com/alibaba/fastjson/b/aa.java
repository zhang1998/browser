package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.d;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.io.IOException;
import java.io.Writer;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class aa extends Writer {
    static final int[] e = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] f = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] g = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] i = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final byte[] j = new byte[161];
    static final byte[] k = new byte[161];
    static final char[] l = new char[93];
    public static final char[] m = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final ThreadLocal<char[]> n = new ThreadLocal();
    protected char[] a;
    protected int b;
    protected int c;
    protected final Writer d;

    public final /* synthetic */ Writer append(CharSequence charSequence) throws IOException {
        return a(charSequence);
    }

    public final /* synthetic */ Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        return a(charSequence, i, i2);
    }

    public final /* synthetic */ Appendable m1append(CharSequence charSequence) throws IOException {
        return a(charSequence);
    }

    public final /* synthetic */ Appendable m2append(CharSequence charSequence, int i, int i2) throws IOException {
        return a(charSequence, i, i2);
    }

    static {
        int i;
        j[0] = (byte) 4;
        j[1] = (byte) 4;
        j[2] = (byte) 4;
        j[3] = (byte) 4;
        j[4] = (byte) 4;
        j[5] = (byte) 4;
        j[6] = (byte) 4;
        j[7] = (byte) 4;
        j[8] = (byte) 1;
        j[9] = (byte) 1;
        j[10] = (byte) 1;
        j[11] = (byte) 4;
        j[12] = (byte) 1;
        j[13] = (byte) 1;
        j[34] = (byte) 1;
        j[92] = (byte) 1;
        k[0] = (byte) 4;
        k[1] = (byte) 4;
        k[2] = (byte) 4;
        k[3] = (byte) 4;
        k[4] = (byte) 4;
        k[5] = (byte) 4;
        k[6] = (byte) 4;
        k[7] = (byte) 4;
        k[8] = (byte) 1;
        k[9] = (byte) 1;
        k[10] = (byte) 1;
        k[11] = (byte) 4;
        k[12] = (byte) 1;
        k[13] = (byte) 1;
        k[92] = (byte) 1;
        k[39] = (byte) 1;
        for (i = 14; i <= 31; i++) {
            j[i] = (byte) 4;
            k[i] = (byte) 4;
        }
        for (i = UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK; i <= 160; i++) {
            j[i] = (byte) 4;
            k[i] = (byte) 4;
        }
        l[0] = '0';
        l[1] = '1';
        l[2] = '2';
        l[3] = '3';
        l[4] = '4';
        l[5] = '5';
        l[6] = '6';
        l[7] = '7';
        l[8] = 'b';
        l[9] = 't';
        l[10] = 'n';
        l[11] = 'v';
        l[12] = 'f';
        l[13] = 'r';
        l[34] = '\"';
        l[39] = '\'';
        l[47] = '/';
        l[92] = '\\';
    }

    public aa() {
        this((byte) 0);
    }

    private aa(byte b) {
        this.d = null;
        this.c = a.e;
        this.a = (char[]) n.get();
        if (n != null) {
            n.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
    }

    public aa(int i, z[] zVarArr) {
        this.d = null;
        this.a = (char[]) n.get();
        if (this.a != null) {
            n.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
        for (z zVar : zVarArr) {
            i |= zVar.x;
        }
        this.c = i;
    }

    public final void a(z zVar) {
        this.c |= zVar.x;
    }

    public final void write(int i) {
        int i2 = this.b + 1;
        if (i2 > this.a.length) {
            if (this.d == null) {
                a(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.a[this.b] = (char) i;
        this.b = i2;
    }

    public final void write(char[] cArr, int i, int i2) {
        if (i < 0 || i > cArr.length || i2 < 0 || i + i2 > cArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i3 = this.b + i2;
            int i4;
            if (i3 <= this.a.length) {
                i4 = i3;
                i3 = i2;
                i2 = i4;
            } else if (this.d == null) {
                a(i3);
                i4 = i3;
                i3 = i2;
                i2 = i4;
            } else {
                do {
                    i3 = this.a.length - this.b;
                    System.arraycopy(cArr, i, this.a, this.b, i3);
                    this.b = this.a.length;
                    flush();
                    i2 -= i3;
                    i += i3;
                } while (i2 > this.a.length);
                i3 = i2;
            }
            System.arraycopy(cArr, i, this.a, this.b, i3);
            this.b = i2;
        }
    }

    protected final void a(int i) {
        int length = ((this.a.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        Object obj = new char[i];
        System.arraycopy(this.a, 0, obj, 0, this.b);
        this.a = obj;
    }

    public final void write(String str, int i, int i2) {
        int i3 = this.b + i2;
        int i4;
        if (i3 <= this.a.length) {
            i4 = i3;
            i3 = i2;
            i2 = i4;
        } else if (this.d == null) {
            a(i3);
            i4 = i3;
            i3 = i2;
            i2 = i4;
        } else {
            do {
                i3 = this.a.length - this.b;
                str.getChars(i, i + i3, this.a, this.b);
                this.b = this.a.length;
                flush();
                i2 -= i3;
                i += i3;
            } while (i2 > this.a.length);
            i3 = i2;
        }
        str.getChars(i, i3 + i, this.a, this.b);
        this.b = i2;
    }

    public final aa a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    private aa a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    public final void close() {
        if (this.d != null && this.b > 0) {
            flush();
        }
        if (this.a.length <= SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            n.set(this.a);
        }
        this.a = null;
    }

    public final void write(String str) {
        while (str == null) {
            str = "null";
        }
        write(str, 0, str.length());
    }

    public final void b(int i) {
        if (i == SectionHeader.SHT_LOUSER) {
            write("-2147483648");
            return;
        }
        int i2 = 0;
        while ((i < 0 ? -i : i) > e[i2]) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i < 0) {
            i3++;
        }
        i2 = this.b + i3;
        if (i2 > this.a.length) {
            if (this.d == null) {
                a(i2);
            } else {
                char[] cArr = new char[i3];
                a((long) i, i3, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        a((long) i, i2, this.a);
        this.b = i2;
    }

    public final void a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        int i2 = (this.c & z.UseSingleQuotes.x) != 0 ? 1 : 0;
        if (i2 != 0) {
            int i3 = '\'';
        } else {
            char c = '\"';
        }
        if (length == 0) {
            write(i2 != 0 ? "''" : "\"\"");
            return;
        }
        char[] cArr = i.t;
        int i4 = (length / 3) * 3;
        int i5 = (((length - 1) / 3) + 1) << 2;
        i2 = this.b;
        int i6 = (i5 + this.b) + 2;
        if (i6 > this.a.length) {
            if (this.d != null) {
                write(i3);
                i5 = 0;
                while (i5 < i4) {
                    i2 = i5 + 1;
                    i6 = i2 + 1;
                    i2 = ((bArr[i2] & 255) << 8) | ((bArr[i5] & 255) << 16);
                    i5 = i6 + 1;
                    i2 |= bArr[i6] & 255;
                    write(cArr[(i2 >>> 18) & 63]);
                    write(cArr[(i2 >>> 12) & 63]);
                    write(cArr[(i2 >>> 6) & 63]);
                    write(cArr[i2 & 63]);
                }
                i5 = length - i4;
                if (i5 > 0) {
                    i2 = (bArr[i4] & 255) << 10;
                    if (i5 == 2) {
                        i = (bArr[length - 1] & 255) << 2;
                    }
                    i |= i2;
                    write(cArr[i >> 12]);
                    write(cArr[(i >>> 6) & 63]);
                    if (i5 == 2) {
                        i = cArr[i & 63];
                    } else {
                        i = 61;
                    }
                    write(i);
                    write(61);
                }
                write(i3);
                return;
            }
            a(i6);
        }
        this.b = i6;
        i5 = i2 + 1;
        this.a[i2] = i3;
        i2 = i5;
        i5 = 0;
        while (i5 < i4) {
            int i7 = i5 + 1;
            int i8 = i7 + 1;
            i7 = ((bArr[i7] & 255) << 8) | ((bArr[i5] & 255) << 16);
            i5 = i8 + 1;
            i7 |= bArr[i8] & 255;
            int i9 = i2 + 1;
            this.a[i2] = cArr[(i7 >>> 18) & 63];
            i8 = i9 + 1;
            this.a[i9] = cArr[(i7 >>> 12) & 63];
            i9 = i8 + 1;
            this.a[i8] = cArr[(i7 >>> 6) & 63];
            i2 = i9 + 1;
            this.a[i9] = cArr[i7 & 63];
        }
        i5 = length - i4;
        if (i5 > 0) {
            char c2;
            i2 = (bArr[i4] & 255) << 10;
            if (i5 == 2) {
                i = (bArr[length - 1] & 255) << 2;
            }
            i |= i2;
            this.a[i6 - 5] = cArr[i >> 12];
            this.a[i6 - 4] = cArr[(i >>> 6) & 63];
            char[] cArr2 = this.a;
            length = i6 - 3;
            if (i5 == 2) {
                c2 = cArr[i & 63];
            } else {
                c2 = '=';
            }
            cArr2[length] = c2;
            this.a[i6 - 2] = '=';
        }
        this.a[i6 - 1] = i3;
    }

    public final void a(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int i;
        long j2 = j < 0 ? -j : j;
        int i2 = 1;
        long j3 = 10;
        while (i2 < 19) {
            if (j2 < j3) {
                i = i2;
                break;
            } else {
                j3 *= 10;
                i2++;
            }
        }
        i = 0;
        if (i == 0) {
            i = 19;
        }
        if (j < 0) {
            i++;
        }
        int i3 = this.b + i;
        if (i3 > this.a.length) {
            if (this.d == null) {
                a(i3);
            } else {
                char[] cArr = new char[i];
                a(j, i, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        a(j, i3, this.a);
        this.b = i3;
    }

    protected final void a(String str, char c, boolean z) {
        if (str == null) {
            write("null");
            if (c != '\u0000') {
                write((int) c);
                return;
            }
            return;
        }
        int length = str.length();
        int i = (this.b + length) + 2;
        if (c != '\u0000') {
            i++;
        }
        if (i > this.a.length) {
            if (this.d != null) {
                write(34);
                for (i = 0; i < str.length(); i++) {
                    length = str.charAt(i);
                    if ((this.c & z.BrowserCompatible.x) == 0) {
                        if ((length < j.length && j[length] != (byte) 0) || (length == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0)) {
                            write(92);
                            write(l[length]);
                        }
                        write(length);
                    } else if (length == '\b' || length == '\f' || length == '\n' || length == '\r' || length == '\t' || length == '\"' || length == '/' || length == '\\') {
                        write(92);
                        write(l[length]);
                    } else if (length < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        write(i[length * 2]);
                        write(i[(length * 2) + 1]);
                    } else {
                        if (length >= '') {
                            write(92);
                            write(117);
                            write(m[(length >>> 12) & 15]);
                            write(m[(length >>> 8) & 15]);
                            write(m[(length >>> 4) & 15]);
                            write(m[length & 15]);
                        }
                        write(length);
                    }
                }
                write(34);
                if (c != '\u0000') {
                    write((int) c);
                    return;
                }
                return;
            }
            a(i);
        }
        int i2 = this.b + 1;
        int i3 = i2 + length;
        this.a[this.b] = '\"';
        str.getChars(0, length, this.a, i2);
        this.b = i;
        int i4;
        char c2;
        char c3;
        if ((this.c & z.BrowserCompatible.x) != 0) {
            length = -1;
            for (i4 = i2; i4 < i3; i4++) {
                c2 = this.a[i4];
                if (c2 == '\"' || c2 == '/' || c2 == '\\') {
                    i++;
                    length = i4;
                } else if (c2 == '\b' || c2 == '\f' || c2 == '\n' || c2 == '\r' || c2 == '\t') {
                    i++;
                    length = i4;
                } else if (c2 < ' ') {
                    i += 5;
                    length = i4;
                } else if (c2 >= '') {
                    i += 5;
                    length = i4;
                }
            }
            if (i > this.a.length) {
                a(i);
            }
            this.b = i;
            i = i3;
            while (length >= i2) {
                c3 = this.a[length];
                if (c3 == '\b' || c3 == '\f' || c3 == '\n' || c3 == '\r' || c3 == '\t') {
                    System.arraycopy(this.a, length + 1, this.a, length + 2, (i - length) - 1);
                    this.a[length] = '\\';
                    this.a[length + 1] = l[c3];
                    i++;
                } else if (c3 == '\"' || c3 == '/' || c3 == '\\') {
                    System.arraycopy(this.a, length + 1, this.a, length + 2, (i - length) - 1);
                    this.a[length] = '\\';
                    this.a[length + 1] = c3;
                    i++;
                } else if (c3 < ' ') {
                    System.arraycopy(this.a, length + 1, this.a, length + 6, (i - length) - 1);
                    this.a[length] = '\\';
                    this.a[length + 1] = 'u';
                    this.a[length + 2] = '0';
                    this.a[length + 3] = '0';
                    this.a[length + 4] = i[c3 * 2];
                    this.a[length + 5] = i[(c3 * 2) + 1];
                    i += 5;
                } else if (c3 >= '') {
                    System.arraycopy(this.a, length + 1, this.a, length + 6, (i - length) - 1);
                    this.a[length] = '\\';
                    this.a[length + 1] = 'u';
                    this.a[length + 2] = m[(c3 >>> 12) & 15];
                    this.a[length + 3] = m[(c3 >>> 8) & 15];
                    this.a[length + 4] = m[(c3 >>> 4) & 15];
                    this.a[length + 5] = m[c3 & 15];
                    i += 5;
                }
                length--;
            }
            if (c != '\u0000') {
                this.a[this.b - 2] = '\"';
                this.a[this.b - 1] = c;
                return;
            }
            this.a[this.b - 1] = '\"';
            return;
        }
        int i5 = 0;
        int i6 = -1;
        c2 = '\u0000';
        if (z) {
            int i7 = i;
            length = i2;
            i = -1;
            while (length < i3) {
                int i8;
                char c4;
                c3 = this.a[length];
                int i9;
                if (c3 == ' ') {
                    i6 = i5 + 1;
                    i8 = i7 + 4;
                    if (i == -1) {
                        c4 = c3;
                        i7 = i6;
                        i6 = i8;
                        i4 = length;
                        i8 = length;
                    }
                    i7 = i6;
                    i6 = i8;
                    i8 = length;
                    i9 = i;
                    c4 = c3;
                    i4 = i9;
                } else {
                    if (c3 < ']') {
                        Object obj;
                        if (c3 != ' ') {
                            if (c3 == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0) {
                                obj = 1;
                                if (obj != null) {
                                    i6 = i5 + 1;
                                    if (c3 < j.length) {
                                    }
                                    i8 = i7;
                                    if (i == -1) {
                                        c4 = c3;
                                        i7 = i6;
                                        i6 = i8;
                                        i4 = length;
                                        i8 = length;
                                    }
                                    i7 = i6;
                                    i6 = i8;
                                    i8 = length;
                                    i9 = i;
                                    c4 = c3;
                                    i4 = i9;
                                }
                            } else if ((c3 <= '#' || c3 == '\\') && (c3 <= '\u001f' || c3 == '\\' || c3 == '\"')) {
                                obj = 1;
                                if (obj != null) {
                                    i6 = i5 + 1;
                                    if (c3 < j.length || j[c3] != (byte) 4) {
                                        i8 = i7;
                                    } else {
                                        i8 = i7 + 4;
                                    }
                                    if (i == -1) {
                                        c4 = c3;
                                        i7 = i6;
                                        i6 = i8;
                                        i4 = length;
                                        i8 = length;
                                    }
                                    i7 = i6;
                                    i6 = i8;
                                    i8 = length;
                                    i9 = i;
                                    c4 = c3;
                                    i4 = i9;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            i6 = i5 + 1;
                            if (c3 < j.length) {
                            }
                            i8 = i7;
                            if (i == -1) {
                                c4 = c3;
                                i7 = i6;
                                i6 = i8;
                                i4 = length;
                                i8 = length;
                            }
                            i7 = i6;
                            i6 = i8;
                            i8 = length;
                            i9 = i;
                            c4 = c3;
                            i4 = i9;
                        }
                    } else if (c3 >= '' && c3 <= ' ') {
                        if (i == -1) {
                            i = length;
                        }
                        i8 = i7 + 4;
                        i7 = i5 + 1;
                        i6 = i8;
                        i8 = length;
                        i9 = i;
                        c4 = c3;
                        i4 = i9;
                    }
                    i4 = i;
                    c4 = c2;
                    i8 = i6;
                    i6 = i7;
                    i7 = i5;
                }
                length++;
                i5 = i7;
                i7 = i6;
                i6 = i8;
                c2 = c4;
                i = i4;
            }
            if (i5 > 0) {
                length = i7 + i5;
                if (length > this.a.length) {
                    a(length);
                }
                this.b = length;
                if (i5 == 1) {
                    if (c2 == ' ') {
                        System.arraycopy(this.a, i6 + 1, this.a, i6 + 6, (i3 - i6) - 1);
                        this.a[i6] = '\\';
                        length = i6 + 1;
                        this.a[length] = 'u';
                        length++;
                        this.a[length] = '2';
                        length++;
                        this.a[length] = '0';
                        length++;
                        this.a[length] = '2';
                        this.a[length + 1] = '8';
                    } else if (c2 >= j.length || j[c2] != (byte) 4) {
                        System.arraycopy(this.a, i6 + 1, this.a, i6 + 2, (i3 - i6) - 1);
                        this.a[i6] = '\\';
                        this.a[i6 + 1] = l[c2];
                    } else {
                        System.arraycopy(this.a, i6 + 1, this.a, i6 + 6, (i3 - i6) - 1);
                        length = i6 + 1;
                        this.a[i6] = '\\';
                        i4 = length + 1;
                        this.a[length] = 'u';
                        length = i4 + 1;
                        this.a[i4] = m[(c2 >>> 12) & 15];
                        i4 = length + 1;
                        this.a[length] = m[(c2 >>> 8) & 15];
                        length = i4 + 1;
                        this.a[i4] = m[(c2 >>> 4) & 15];
                        this.a[length] = m[c2 & 15];
                    }
                } else if (i5 > 1) {
                    length = i;
                    for (i -= i2; i < str.length(); i++) {
                        c2 = str.charAt(i);
                        if ((c2 < j.length && j[c2] != (byte) 0) || (c2 == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0)) {
                            i6 = length + 1;
                            this.a[length] = '\\';
                            if (j[c2] == (byte) 4) {
                                i4 = i6 + 1;
                                this.a[i6] = 'u';
                                i6 = i4 + 1;
                                this.a[i4] = m[(c2 >>> 12) & 15];
                                i4 = i6 + 1;
                                this.a[i6] = m[(c2 >>> 8) & 15];
                                i6 = i4 + 1;
                                this.a[i4] = m[(c2 >>> 4) & 15];
                                length = i6 + 1;
                                this.a[i6] = m[c2 & 15];
                            } else {
                                length = i6 + 1;
                                this.a[i6] = l[c2];
                            }
                        } else if (c2 == ' ') {
                            i6 = length + 1;
                            this.a[length] = '\\';
                            i4 = i6 + 1;
                            this.a[i6] = 'u';
                            i6 = i4 + 1;
                            this.a[i4] = m[(c2 >>> 12) & 15];
                            i4 = i6 + 1;
                            this.a[i6] = m[(c2 >>> 8) & 15];
                            i6 = i4 + 1;
                            this.a[i4] = m[(c2 >>> 4) & 15];
                            length = i6 + 1;
                            this.a[i6] = m[c2 & 15];
                        } else {
                            i4 = length + 1;
                            this.a[length] = c2;
                            length = i4;
                        }
                    }
                }
            }
        }
        if (c != '\u0000') {
            this.a[this.b - 2] = '\"';
            this.a[this.b - 1] = c;
            return;
        }
        this.a[this.b - 1] = '\"';
    }

    public final void a(String str) {
        if ((this.c & z.UseSingleQuotes.x) != 0) {
            b(str);
        } else {
            a(str, '\u0000', true);
        }
    }

    protected final void b(String str) {
        int i;
        if (str == null) {
            i = this.b + 4;
            if (i > this.a.length) {
                a(i);
            }
            "null".getChars(0, 4, this.a, this.b);
            this.b = i;
            return;
        }
        int charAt;
        i = str.length();
        int i2 = (this.b + i) + 2;
        if (i2 > this.a.length) {
            if (this.d != null) {
                write(39);
                for (i = 0; i < str.length(); i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0)) {
                        write(92);
                        write(l[charAt]);
                    } else {
                        write(charAt);
                    }
                }
                write(39);
                return;
            }
            a(i2);
        }
        int i3 = this.b + 1;
        int i4 = i3 + i;
        this.a[this.b] = '\'';
        str.getChars(0, i, this.a, i3);
        this.b = i2;
        int i5 = 0;
        int i6 = -1;
        i = 0;
        int i7 = i3;
        while (i7 < i4) {
            char c = this.a[i7];
            if (c <= '\r' || c == '\\' || c == '\'' || (c == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0)) {
                i6 = i5 + 1;
                i = c;
                charAt = i7;
            } else {
                charAt = i6;
                i6 = i5;
            }
            i7++;
            i5 = i6;
            i6 = charAt;
        }
        charAt = i2 + i5;
        if (charAt > this.a.length) {
            a(charAt);
        }
        this.b = charAt;
        if (i5 == 1) {
            System.arraycopy(this.a, i6 + 1, this.a, i6 + 2, (i4 - i6) - 1);
            this.a[i6] = '\\';
            this.a[i6 + 1] = l[i];
        } else if (i5 > 1) {
            System.arraycopy(this.a, i6 + 1, this.a, i6 + 2, (i4 - i6) - 1);
            this.a[i6] = '\\';
            i6++;
            this.a[i6] = l[i];
            i = i4 + 1;
            for (charAt = i6 - 2; charAt >= i3; charAt--) {
                char c2 = this.a[charAt];
                if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && (this.c & z.WriteSlashAsSpecial.x) != 0)) {
                    System.arraycopy(this.a, charAt + 1, this.a, charAt + 2, (i - charAt) - 1);
                    this.a[charAt] = '\\';
                    this.a[charAt + 1] = l[c2];
                    i++;
                }
            }
        }
        this.a[this.b - 1] = '\'';
    }

    public final void a(String str, boolean z) {
        int length;
        int i;
        int i2;
        char charAt;
        Object obj;
        int i3;
        char[] cArr;
        int i4;
        Object obj2;
        char c;
        if ((this.c & z.UseSingleQuotes.x) != 0) {
            if ((this.c & z.QuoteFieldNames.x) != 0) {
                b(str);
                write(58);
                return;
            }
            length = str.length();
            i = (this.b + length) + 1;
            if (i > this.a.length) {
                if (this.d == null) {
                    a(i);
                } else if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                } else {
                    for (i2 = 0; i2 < length; i2++) {
                        charAt = str.charAt(i2);
                        if (charAt < k.length && k[charAt] != (byte) 0) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        write(39);
                    }
                    for (i3 = 0; i3 < length; i3++) {
                        i = str.charAt(i3);
                        if (i >= k.length || k[i] == (byte) 0) {
                            write(i);
                        } else {
                            write(92);
                            write(l[i]);
                        }
                    }
                    if (obj != null) {
                        write(39);
                    }
                    write(58);
                    return;
                }
            }
            if (length == 0) {
                if (this.b + 3 > this.a.length) {
                    a(this.b + 3);
                }
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = '\'';
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = '\'';
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = ':';
                return;
            }
            i4 = this.b;
            i2 = i4 + length;
            str.getChars(0, length, this.a, i4);
            this.b = i;
            obj2 = null;
            length = i4;
            while (length < i2) {
                c = this.a[length];
                if (c < k.length && k[c] != (byte) 0) {
                    if (obj2 == null) {
                        i += 3;
                        if (i > this.a.length) {
                            a(i);
                        }
                        this.b = i;
                        System.arraycopy(this.a, length + 1, this.a, length + 3, (i2 - length) - 1);
                        System.arraycopy(this.a, 0, this.a, 1, length);
                        this.a[i4] = '\'';
                        length++;
                        this.a[length] = '\\';
                        length++;
                        this.a[length] = l[c];
                        i2 += 2;
                        this.a[this.b - 2] = '\'';
                        obj2 = 1;
                    } else {
                        i++;
                        if (i > this.a.length) {
                            a(i);
                        }
                        this.b = i;
                        System.arraycopy(this.a, length + 1, this.a, length + 2, i2 - length);
                        this.a[length] = '\\';
                        length++;
                        this.a[length] = l[c];
                        i2++;
                    }
                }
                length++;
            }
            this.a[i - 1] = ':';
        } else if ((this.c & z.QuoteFieldNames.x) != 0) {
            a(str, ':', z);
        } else {
            length = str.length();
            i = (this.b + length) + 1;
            if (i > this.a.length) {
                if (this.d == null) {
                    a(i);
                } else if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                } else {
                    for (i2 = 0; i2 < length; i2++) {
                        charAt = str.charAt(i2);
                        if (charAt < j.length && j[charAt] != (byte) 0) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        write(34);
                    }
                    for (i3 = 0; i3 < length; i3++) {
                        i = str.charAt(i3);
                        if (i >= j.length || j[i] == (byte) 0) {
                            write(i);
                        } else {
                            write(92);
                            write(l[i]);
                        }
                    }
                    if (obj != null) {
                        write(34);
                    }
                    write(58);
                    return;
                }
            }
            if (length == 0) {
                if (this.b + 3 > this.a.length) {
                    a(this.b + 3);
                }
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = '\"';
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = '\"';
                cArr = this.a;
                i2 = this.b;
                this.b = i2 + 1;
                cArr[i2] = ':';
                return;
            }
            i4 = this.b;
            i2 = i4 + length;
            str.getChars(0, length, this.a, i4);
            this.b = i;
            obj2 = null;
            length = i4;
            while (length < i2) {
                c = this.a[length];
                if (c < j.length && j[c] != (byte) 0) {
                    if (obj2 == null) {
                        i += 3;
                        if (i > this.a.length) {
                            a(i);
                        }
                        this.b = i;
                        System.arraycopy(this.a, length + 1, this.a, length + 3, (i2 - length) - 1);
                        System.arraycopy(this.a, 0, this.a, 1, length);
                        this.a[i4] = '\"';
                        length++;
                        this.a[length] = '\\';
                        length++;
                        this.a[length] = l[c];
                        i2 += 2;
                        this.a[this.b - 2] = '\"';
                        obj2 = 1;
                    } else {
                        i++;
                        if (i > this.a.length) {
                            a(i);
                        }
                        this.b = i;
                        System.arraycopy(this.a, length + 1, this.a, length + 2, i2 - length);
                        this.a[length] = '\\';
                        length++;
                        this.a[length] = l[c];
                        i2++;
                    }
                }
                length++;
            }
            this.a[this.b - 1] = ':';
        }
    }

    public final void flush() {
        if (this.d != null) {
            try {
                this.d.write(this.a, 0, this.b);
                this.d.flush();
                this.b = 0;
            } catch (Throwable e) {
                throw new d(e.getMessage(), e);
            }
        }
    }

    protected static void a(long j, int i, char[] cArr) {
        char c;
        int i2;
        int i3;
        if (j < 0) {
            j = -j;
            c = '-';
            i2 = i;
        } else {
            c = '\u0000';
            i2 = i;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            i3 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            i2--;
            cArr[i2] = h[i3];
            i = i2 - 1;
            cArr[i] = g[i3];
            i2 = i;
            j = j2;
        }
        i3 = (int) j;
        while (i3 >= 65536) {
            int i4 = i3 / 100;
            i3 -= ((i4 << 6) + (i4 << 5)) + (i4 << 2);
            i2--;
            cArr[i2] = h[i3];
            i2--;
            cArr[i2] = g[i3];
            i3 = i4;
        }
        while (true) {
            i4 = (52429 * i3) >>> 19;
            i2--;
            cArr[i2] = f[i3 - ((i4 << 3) + (i4 << 1))];
            if (i4 == 0) {
                break;
            }
            i3 = i4;
        }
        if (c != '\u0000') {
            cArr[i2 - 1] = c;
        }
    }

    public final /* synthetic */ Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public final /* synthetic */ Appendable m0append(char c) throws IOException {
        write((int) c);
        return this;
    }
}
