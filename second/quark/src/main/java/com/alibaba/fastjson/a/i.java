package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.media.MediaDefines;
import com.uc.crashsdk.export.LogType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class i {
    protected static final int[] s = new int[103];
    public static final char[] t = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    static final int[] u;
    public static final boolean[] v = new boolean[LogType.UNEXP];
    public static final boolean[] w = new boolean[LogType.UNEXP];
    private static boolean x;
    private static final ThreadLocal<char[]> y = new ThreadLocal();
    protected int a;
    protected int b;
    public int c;
    protected char d;
    protected int e;
    protected int f;
    protected char[] g;
    protected int h;
    protected int i;
    protected boolean j;
    public TimeZone k;
    public Locale l;
    protected Calendar m;
    public int n;
    protected final String o;
    protected final int p;
    protected String q;
    public boolean r;

    static {
        boolean z;
        int i = 0;
        int i2 = -1;
        try {
            i2 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception e) {
        }
        if (i2 >= 23) {
            z = true;
        } else {
            z = false;
        }
        x = z;
        for (i2 = 48; i2 <= 57; i2++) {
            s[i2] = i2 - 48;
        }
        for (i2 = 97; i2 <= 102; i2++) {
            s[i2] = (i2 - 97) + 10;
        }
        for (i2 = 65; i2 <= 70; i2++) {
            s[i2] = (i2 - 65) + 10;
        }
        int[] iArr = new int[LogType.UNEXP];
        u = iArr;
        Arrays.fill(iArr, -1);
        int length = t.length;
        for (i2 = 0; i2 < length; i2++) {
            u[t[i2]] = i2;
        }
        u[61] = 0;
        i2 = 0;
        while (i2 < v.length) {
            if (i2 >= 65 && i2 <= 90) {
                v[i2] = true;
            } else if (i2 >= 97 && i2 <= 122) {
                v[i2] = true;
            } else if (i2 == 95) {
                v[i2] = true;
            }
            i2 = (char) (i2 + 1);
        }
        while (i < w.length) {
            if (i >= 65 && i <= 90) {
                w[i] = true;
            } else if (i >= 97 && i <= 122) {
                w[i] = true;
            } else if (i == 95) {
                w[i] = true;
            } else if (i >= 48 && i <= 57) {
                w[i] = true;
            }
            i = (char) (i + 1);
        }
    }

    public i(String str) {
        this(str, a.c);
    }

    public i(String str, int i) {
        char c;
        String str2;
        boolean z;
        this.c = a.c;
        this.k = a.a;
        this.l = a.b;
        this.m = null;
        this.n = 0;
        this.g = (char[]) y.get();
        if (this.g == null) {
            this.g = new char[512];
        }
        this.c = i;
        this.o = str;
        this.p = this.o.length();
        this.e = -1;
        int i2 = this.e + 1;
        this.e = i2;
        if (i2 >= this.p) {
            c = '\u001a';
        } else {
            c = this.o.charAt(i2);
        }
        this.d = c;
        if (this.d == '﻿') {
            c();
        }
        if ((e.InitStringFieldAsEmpty.q & i) != 0) {
            str2 = "";
        } else {
            str2 = null;
        }
        this.q = str2;
        if ((e.DisableCircularReferenceDetect.q & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.r = z;
    }

    public final int a() {
        return this.a;
    }

    public final void b() {
        if (this.g.length <= 8196) {
            y.set(this.g);
        }
        this.g = null;
    }

    public final char c() {
        char c;
        int i = this.e + 1;
        this.e = i;
        if (i >= this.p) {
            c = '\u001a';
        } else {
            c = this.o.charAt(i);
        }
        this.d = c;
        return c;
    }

    public final boolean a(e eVar) {
        return (this.c & eVar.q) != 0;
    }

    public final void d() {
        char c;
        this.h = 0;
        while (this.d != ':') {
            if (this.d == ' ' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\f' || this.d == '\b') {
                c();
            } else {
                throw new d("not match : - " + this.d);
            }
        }
        int i = this.e + 1;
        this.e = i;
        if (i >= this.p) {
            c = '\u001a';
        } else {
            c = this.o.charAt(i);
        }
        this.d = c;
        g();
    }

    public final boolean e() {
        return this.h == 4 && this.o.startsWith("$ref", this.i + 1);
    }

    public final String f() {
        char charAt = this.o.charAt((this.i + this.h) - 1);
        int i = this.h;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return a(this.i, i);
    }

    private char b(int i) {
        if (i >= this.p) {
            return '\u001a';
        }
        return this.o.charAt(i);
    }

    public final void g() {
        char c = '\u001a';
        this.h = 0;
        while (true) {
            this.b = this.e;
            if (this.d == '/') {
                y();
            } else if (this.d == '\"') {
                k();
                return;
            } else if ((this.d >= '0' && this.d <= '9') || this.d == '-') {
                s();
                return;
            } else if (this.d == ',') {
                c();
                this.a = 16;
                return;
            } else {
                int i;
                switch (this.d) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        c();
                        break;
                    case '\'':
                        if ((this.c & e.AllowSingleQuotes.q) == 0) {
                            throw new d("Feature.AllowSingleQuotes is false");
                        }
                        k();
                        return;
                    case '(':
                        c();
                        this.a = 10;
                        return;
                    case ')':
                        c();
                        this.a = 11;
                        return;
                    case ':':
                        c();
                        this.a = 17;
                        return;
                    case 'S':
                    case 'T':
                    case 'u':
                        z();
                        return;
                    case '[':
                        i = this.e + 1;
                        this.e = i;
                        if (i < this.p) {
                            c = this.o.charAt(i);
                        }
                        this.d = c;
                        this.a = 14;
                        return;
                    case ']':
                        c();
                        this.a = 15;
                        return;
                    case 'f':
                        if (this.o.startsWith("false", this.e)) {
                            this.e += 5;
                            this.d = b(this.e);
                            if (this.d == ' ' || this.d == ',' || this.d == '}' || this.d == ']' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\u001a' || this.d == '\f' || this.d == '\b' || this.d == ':') {
                                this.a = 7;
                                return;
                            }
                        }
                        throw new d("scan false error");
                    case 'n':
                        i = 0;
                        if (this.o.startsWith("null", this.e)) {
                            this.e += 4;
                            i = 8;
                        } else if (this.o.startsWith("new", this.e)) {
                            this.e += 3;
                            i = 9;
                        }
                        if (i != 0) {
                            this.d = b(this.e);
                            if (this.d == ' ' || this.d == ',' || this.d == '}' || this.d == ']' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\u001a' || this.d == '\f' || this.d == '\b') {
                                this.a = i;
                                return;
                            }
                        }
                        throw new d("scan null/new error");
                    case 't':
                        if (this.o.startsWith("true", this.e)) {
                            this.e += 4;
                            this.d = b(this.e);
                            if (this.d == ' ' || this.d == ',' || this.d == '}' || this.d == ']' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\u001a' || this.d == '\f' || this.d == '\b' || this.d == ':') {
                                this.a = 6;
                                return;
                            }
                        }
                        throw new d("scan true error");
                    case '{':
                        i = this.e + 1;
                        this.e = i;
                        if (i < this.p) {
                            c = this.o.charAt(i);
                        }
                        this.d = c;
                        this.a = 12;
                        return;
                    case '}':
                        i = this.e + 1;
                        this.e = i;
                        if (i < this.p) {
                            c = this.o.charAt(i);
                        }
                        this.d = c;
                        this.a = 13;
                        return;
                    default:
                        Object obj = (this.e == this.p || (this.d == '\u001a' && this.e + 1 == this.p)) ? 1 : null;
                        if (obj != null) {
                            if (this.a == 20) {
                                throw new d("EOF error");
                            }
                            this.a = 20;
                            int i2 = this.f;
                            this.e = i2;
                            this.b = i2;
                            return;
                        } else if (this.d <= '\u001f' || this.d == '') {
                            c();
                            break;
                        } else {
                            this.a = 1;
                            c();
                            return;
                        }
                }
            }
        }
    }

    public final void a(int i) {
        char c = '\u001a';
        this.h = 0;
        while (true) {
            int i2;
            switch (i) {
                case 2:
                    if (this.d >= '0' && this.d <= '9') {
                        this.b = this.e;
                        s();
                        return;
                    } else if (this.d == '\"') {
                        this.b = this.e;
                        k();
                        return;
                    } else if (this.d == '[') {
                        this.a = 14;
                        c();
                        return;
                    } else if (this.d == '{') {
                        this.a = 12;
                        c();
                        return;
                    }
                    break;
                case 4:
                    if (this.d == '\"') {
                        this.b = this.e;
                        k();
                        return;
                    } else if (this.d >= '0' && this.d <= '9') {
                        this.b = this.e;
                        s();
                        return;
                    } else if (this.d == '{') {
                        this.a = 12;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    }
                    break;
                case 12:
                    if (this.d == '{') {
                        this.a = 12;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    } else if (this.d == '[') {
                        this.a = 14;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    }
                    break;
                case 14:
                    if (this.d == '[') {
                        this.a = 14;
                        c();
                        return;
                    } else if (this.d == '{') {
                        this.a = 12;
                        c();
                        return;
                    }
                    break;
                case 15:
                    if (this.d == ']') {
                        this.a = 15;
                        c();
                        return;
                    }
                    break;
                case 16:
                    if (this.d == ',') {
                        this.a = 16;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    } else if (this.d == '}') {
                        this.a = 13;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    } else if (this.d == ']') {
                        this.a = 15;
                        i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < this.p) {
                            c = this.o.charAt(i2);
                        }
                        this.d = c;
                        return;
                    } else if (this.d == '\u001a') {
                        this.a = 20;
                        return;
                    }
                    break;
                case 18:
                    while (true) {
                        Object obj = (this.d > ' ' || !(this.d == ' ' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\f' || this.d == '\b')) ? null : 1;
                        if (obj != null) {
                            c();
                        } else if (this.d == '_' || Character.isLetter(this.d)) {
                            z();
                            return;
                        } else {
                            g();
                            return;
                        }
                    }
                    break;
                case 20:
                    break;
            }
            if (this.d == '\u001a') {
                this.a = 20;
                return;
            }
            if (this.d == ' ' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\f' || this.d == '\b') {
                c();
            } else {
                g();
                return;
            }
        }
    }

    public final String h() {
        return j.a(this.a);
    }

    public final Number i() throws NumberFormatException {
        Object obj;
        long j;
        int i;
        int i2;
        long j2 = 0;
        int i3 = this.i;
        int i4 = this.h + this.i;
        int i5 = 32;
        switch (b(i4 - 1)) {
            case 'B':
                i4--;
                i5 = 66;
                break;
            case 'L':
                i4--;
                i5 = 76;
                break;
            case 'S':
                i4--;
                i5 = 83;
                break;
        }
        int i6;
        if (b(this.i) == '-') {
            obj = 1;
            i6 = i3 + 1;
            j = Long.MIN_VALUE;
            i = i6;
        } else {
            obj = null;
            i6 = i3;
            j = -9223372036854775807L;
            i = i6;
        }
        if (i < i4) {
            i2 = i + 1;
            j2 = (long) (-(b(i) - 48));
        } else {
            i2 = i;
        }
        while (i2 < i4) {
            i = i2 + 1;
            i2 = b(i2) - 48;
            if (j2 < -922337203685477580L) {
                return new BigInteger(f());
            }
            j2 *= 10;
            if (j2 < ((long) i2) + j) {
                return new BigInteger(f());
            }
            j2 -= (long) i2;
            i2 = i;
        }
        if (obj == null) {
            long j3 = -j2;
            if (j3 > 2147483647L || i5 == 76) {
                return Long.valueOf(j3);
            }
            if (i5 == 83) {
                return Short.valueOf((short) ((int) j3));
            }
            if (i5 == 66) {
                return Byte.valueOf((byte) ((int) j3));
            }
            return Integer.valueOf((int) j3);
        } else if (i2 <= this.i + 1) {
            throw new NumberFormatException(f());
        } else if (j2 < -2147483648L || i5 == 76) {
            return Long.valueOf(j2);
        } else {
            if (i5 == 83) {
                return Short.valueOf((short) ((int) j2));
            }
            if (i5 == 66) {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public final String a(q qVar) {
        while (true) {
            if (this.d != ' ' && this.d != '\n' && this.d != '\r' && this.d != '\t' && this.d != '\f' && this.d != '\b') {
                break;
            }
            c();
        }
        if (this.d == '\"') {
            return a(qVar, '\"');
        }
        if (this.d == '\'') {
            if ((this.c & e.AllowSingleQuotes.q) != 0) {
                return a(qVar, '\'');
            }
            throw new d("syntax error");
        } else if (this.d == '}') {
            c();
            this.a = 13;
            return null;
        } else if (this.d == ',') {
            c();
            this.a = 16;
            return null;
        } else if (this.d == '\u001a') {
            this.a = 20;
            return null;
        } else if ((this.c & e.AllowUnQuotedFieldNames.q) != 0) {
            return b(qVar);
        } else {
            throw new d("syntax error");
        }
    }

    public final String a(q qVar, char c) {
        int i = this.e + 1;
        int indexOf = this.o.indexOf(c, i);
        if (indexOf == -1) {
            throw new d("unclosed str, " + j());
        }
        String a;
        char c2;
        i = indexOf - i;
        Object b = b(this.e + 1, i);
        int i2 = indexOf;
        int i3 = i;
        indexOf = 0;
        while (i3 > 0 && b[i3 - 1] == '\\') {
            i = i3 - 2;
            int i4 = 1;
            while (i >= 0 && b[i] == '\\') {
                i4++;
                i--;
            }
            if (i4 % 2 == 0) {
                break;
            }
            Object obj;
            i4 = this.o.indexOf(c, i2 + 1);
            i = i3 + (i4 - i2);
            if (i >= b.length) {
                indexOf = (b.length * 3) / 2;
                if (indexOf < i) {
                    indexOf = i;
                }
                obj = new char[indexOf];
                System.arraycopy(b, 0, obj, 0, b.length);
            } else {
                obj = b;
            }
            this.o.getChars(i2, i4, obj, i3);
            b = obj;
            i2 = i4;
            i3 = i;
            indexOf = 1;
        }
        if (indexOf == 0) {
            i4 = 0;
            for (i = 0; i < i3; i++) {
                char c3 = b[i];
                i4 = (i4 * 31) + c3;
                if (c3 == '\\') {
                    indexOf = 1;
                }
            }
            a = indexOf != 0 ? a((char[]) b, i3) : i3 < 20 ? qVar.a((char[]) b, i3, i4) : new String(b, 0, i3);
        } else {
            a = a((char[]) b, i3);
        }
        this.e = i2 + 1;
        i = this.e;
        if (i >= this.p) {
            c2 = '\u001a';
        } else {
            c2 = this.o.charAt(i);
        }
        this.d = c2;
        return a;
    }

    private static String a(char[] cArr, int i) {
        char[] cArr2 = new char[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4;
            char c = cArr[i2];
            if (c != '\\') {
                i4 = i3 + 1;
                cArr2[i3] = c;
            } else {
                i2++;
                switch (cArr[i2]) {
                    case '\"':
                        i4 = i3 + 1;
                        cArr2[i3] = '\"';
                        break;
                    case '\'':
                        i4 = i3 + 1;
                        cArr2[i3] = '\'';
                        break;
                    case '/':
                        i4 = i3 + 1;
                        cArr2[i3] = '/';
                        break;
                    case '0':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0000';
                        break;
                    case '1':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0001';
                        break;
                    case '2':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0002';
                        break;
                    case '3':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0003';
                        break;
                    case '4':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0004';
                        break;
                    case '5':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0005';
                        break;
                    case '6':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0006';
                        break;
                    case '7':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u0007';
                        break;
                    case 'F':
                    case 'f':
                        i4 = i3 + 1;
                        cArr2[i3] = '\f';
                        break;
                    case '\\':
                        i4 = i3 + 1;
                        cArr2[i3] = '\\';
                        break;
                    case 'b':
                        i4 = i3 + 1;
                        cArr2[i3] = '\b';
                        break;
                    case 'n':
                        i4 = i3 + 1;
                        cArr2[i3] = '\n';
                        break;
                    case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                        i4 = i3 + 1;
                        cArr2[i3] = '\r';
                        break;
                    case 't':
                        i4 = i3 + 1;
                        cArr2[i3] = '\t';
                        break;
                    case 'u':
                        i4 = i3 + 1;
                        r6 = new char[4];
                        i2++;
                        r6[0] = cArr[i2];
                        i2++;
                        r6[1] = cArr[i2];
                        i2++;
                        r6[2] = cArr[i2];
                        i2++;
                        r6[3] = cArr[i2];
                        cArr2[i3] = (char) Integer.parseInt(new String(r6), 16);
                        break;
                    case 'v':
                        i4 = i3 + 1;
                        cArr2[i3] = '\u000b';
                        break;
                    case MediaDefines.MSG_ENABLE_VR_MODE /*120*/:
                        i4 = i3 + 1;
                        i2++;
                        i2++;
                        cArr2[i3] = (char) ((s[cArr[i2]] * 16) + s[cArr[i2]]);
                        break;
                    default:
                        throw new d("unclosed.str.lit");
                }
            }
            i2++;
            i3 = i4;
        }
        return new String(cArr2, 0, i3);
    }

    public final String j() {
        String str;
        StringBuilder append = new StringBuilder("pos ").append(this.e).append(", json : ");
        if (this.o.length() < 65536) {
            str = this.o;
        } else {
            str = this.o.substring(0, 65536);
        }
        return append.append(str).toString();
    }

    private void y() {
        c();
        if (this.d == '/') {
            do {
                c();
            } while (this.d != '\n');
            c();
        } else if (this.d == '*') {
            c();
            while (this.d != '\u001a') {
                if (this.d == '*') {
                    c();
                    if (this.d == '/') {
                        c();
                        return;
                    }
                } else {
                    c();
                }
            }
        } else {
            throw new d("invalid comment");
        }
    }

    public final String b(q qVar) {
        int i = this.d;
        int i2 = (this.d >= v.length || v[i]) ? 1 : 0;
        if (i2 == 0) {
            throw new d("illegal identifier : " + this.d + ", " + j());
        }
        this.i = this.e;
        this.h = 1;
        while (true) {
            char c = c();
            if (c < w.length && !w[c]) {
                break;
            }
            i = (i * 31) + c;
            this.h++;
        }
        this.d = b(this.e);
        this.a = 18;
        if (this.h == 4 && this.o.startsWith("null", this.i)) {
            return null;
        }
        return qVar.a(this.o, this.i, this.h, i);
    }

    public final void k() {
        char c = this.d;
        int i = this.e + 1;
        int indexOf = this.o.indexOf(c, i);
        if (indexOf == -1) {
            throw new d("unclosed str, " + j());
        }
        char c2;
        i = indexOf - i;
        Object b = b(this.e + 1, i);
        int i2 = indexOf;
        int i3 = i;
        boolean z = false;
        while (i3 > 0 && b[i3 - 1] == '\\') {
            i = i3 - 2;
            int i4 = 1;
            while (i >= 0 && b[i] == '\\') {
                i4++;
                i--;
            }
            if (i4 % 2 == 0) {
                break;
            }
            Object obj;
            i4 = this.o.indexOf(c, i2 + 1);
            i = i3 + (i4 - i2);
            if (i >= b.length) {
                indexOf = (b.length * 3) / 2;
                if (indexOf < i) {
                    indexOf = i;
                }
                obj = new char[indexOf];
                System.arraycopy(b, 0, obj, 0, b.length);
            } else {
                obj = b;
            }
            this.o.getChars(i2, i4, obj, i3);
            b = obj;
            i2 = i4;
            i3 = i;
            z = true;
        }
        if (!z) {
            for (i = 0; i < i3; i++) {
                if (b[i] == '\\') {
                    z = true;
                }
            }
        }
        this.g = b;
        this.h = i3;
        this.i = this.e;
        this.j = z;
        this.e = i2 + 1;
        indexOf = this.e;
        if (indexOf >= this.p) {
            c2 = '\u001a';
        } else {
            c2 = this.o.charAt(indexOf);
        }
        this.d = c2;
        this.a = 4;
    }

    public final String l() {
        int i = this.e + 1;
        int indexOf = this.o.indexOf(34, i);
        if (indexOf == -1) {
            throw new d("unclosed str, " + j());
        }
        String substring;
        char c;
        if (x) {
            substring = this.o.substring(i, indexOf);
        } else {
            int i2 = indexOf - i;
            substring = new String(b(this.e + 1, i2), 0, i2);
        }
        if (substring.indexOf(92) != -1) {
            int i3 = indexOf;
            while (true) {
                i2 = i3 - 1;
                indexOf = 0;
                while (i2 >= 0 && this.o.charAt(i2) == '\\') {
                    indexOf++;
                    i2--;
                }
                if (indexOf % 2 == 0) {
                    break;
                }
                i3 = this.o.indexOf(34, i3 + 1);
            }
            indexOf = i3 - i;
            String a = a(b(this.e + 1, indexOf), indexOf);
            indexOf = i3;
            substring = a;
        }
        this.e = indexOf + 1;
        indexOf = this.e;
        if (indexOf >= this.p) {
            c = '\u001a';
        } else {
            c = this.o.charAt(indexOf);
        }
        this.d = c;
        return substring;
    }

    public final Calendar m() {
        return this.m;
    }

    public final int n() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = this.i;
        int i6 = this.i + this.h;
        if (b(this.i) == '-') {
            i = 1;
            i2 = SectionHeader.SHT_LOUSER;
            i3 = i5 + 1;
        } else {
            i2 = -2147483647;
            i = 0;
            i3 = i5;
        }
        if (i3 < i6) {
            i5 = i3 + 1;
            i4 = -(b(i3) - 48);
        } else {
            i5 = i3;
        }
        while (i5 < i6) {
            i3 = i5 + 1;
            char b = b(i5);
            if (b == 'L' || b == 'S' || b == 'B') {
                break;
            }
            i5 = b - 48;
            if (i4 < -214748364) {
                throw new NumberFormatException(f());
            }
            i4 *= 10;
            if (i4 < i2 + i5) {
                throw new NumberFormatException(f());
            }
            i4 -= i5;
            i5 = i3;
        }
        i3 = i5;
        if (i == 0) {
            return -i4;
        }
        if (i3 > this.i + 1) {
            return i4;
        }
        throw new NumberFormatException(f());
    }

    public final byte[] o() {
        int i = 0;
        String str = this.o;
        int i2 = this.i + 1;
        int i3 = this.h;
        if (i3 == 0) {
            return new byte[0];
        }
        int i4 = (i2 + i3) - 1;
        while (i2 < i4 && u[str.charAt(i2)] < 0) {
            i2++;
        }
        int i5 = i4;
        while (i5 > 0 && u[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i2) + 1;
        if (i3 > 76) {
            if (str.charAt(76) == '\r') {
                i4 = i7 / 78;
            } else {
                i4 = 0;
            }
            i4 <<= 1;
        } else {
            i4 = 0;
        }
        int i8 = (((i7 - i4) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        i3 = 0;
        int i10 = 0;
        while (i10 < i9) {
            int i11 = i2 + 1;
            int i12 = i11 + 1;
            i2 = (u[str.charAt(i2)] << 18) | (u[str.charAt(i11)] << 12);
            i11 = i12 + 1;
            int i13 = (u[str.charAt(i12)] << 6) | i2;
            i2 = i11 + 1;
            i13 |= u[str.charAt(i11)];
            i11 = i10 + 1;
            bArr[i10] = (byte) (i13 >> 16);
            i12 = i11 + 1;
            bArr[i11] = (byte) (i13 >> 8);
            i10 = i12 + 1;
            bArr[i12] = (byte) i13;
            if (i4 > 0) {
                i3++;
                if (i3 == 19) {
                    i2 += 2;
                    i3 = 0;
                }
            }
        }
        if (i10 < i8) {
            i2 = 0;
            for (i4 = i2; i4 <= i5 - i6; i4++) {
                i++;
                i2 = (u[str.charAt(i4)] << (18 - (i * 6))) | i2;
            }
            i4 = 16;
            i = i10;
            while (i < i8) {
                i3 = i + 1;
                bArr[i] = (byte) (i2 >> i4);
                i4 -= 8;
                i = i3;
            }
        }
        return bArr;
    }

    private void z() {
        this.i = this.e - 1;
        this.j = false;
        do {
            this.h++;
            c();
        } while (Character.isLetterOrDigit(this.d));
        String p = p();
        if (p.equals("null")) {
            this.a = 8;
        } else if (p.equals("true")) {
            this.a = 6;
        } else if (p.equals("false")) {
            this.a = 7;
        } else if (p.equals("new")) {
            this.a = 9;
        } else if (p.equals("undefined")) {
            this.a = 23;
        } else if (p.equals("Set")) {
            this.a = 21;
        } else if (p.equals("TreeSet")) {
            this.a = 22;
        } else {
            this.a = 18;
        }
    }

    public final String p() {
        if (this.j) {
            return a(this.g, this.h);
        }
        return a(this.i + 1, this.h);
    }

    private final String a(int i, int i2) {
        if (i2 < this.g.length) {
            this.o.getChars(i, i + i2, this.g, 0);
            return new String(this.g, 0, i2);
        }
        char[] cArr = new char[i2];
        this.o.getChars(i, i + i2, cArr, 0);
        return new String(cArr);
    }

    private char[] b(int i, int i2) {
        if (i2 < this.g.length) {
            this.o.getChars(i, i + i2, this.g, 0);
            return this.g;
        }
        char[] cArr = new char[i2];
        this.g = cArr;
        this.o.getChars(i, i + i2, cArr, 0);
        return cArr;
    }

    public final boolean q() {
        int i = 0;
        while (true) {
            char b = b(i);
            if (b == '\u001a') {
                return true;
            }
            boolean z = b <= ' ' && (b == ' ' || b == '\n' || b == '\r' || b == '\t' || b == '\f' || b == '\b');
            if (!z) {
                return false;
            }
            i++;
        }
    }

    final void r() {
        while (this.d <= '/') {
            if (this.d == ' ' || this.d == '\r' || this.d == '\n' || this.d == '\t' || this.d == '\f' || this.d == '\b') {
                c();
            } else if (this.d == '/') {
                y();
            } else {
                return;
            }
        }
    }

    public final void s() {
        char c;
        this.i = this.e;
        if (this.d == '-') {
            int i;
            this.h++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                c = '\u001a';
            } else {
                c = this.o.charAt(i);
            }
            this.d = c;
        }
        while (this.d >= '0' && this.d <= '9') {
            this.h++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                c = '\u001a';
            } else {
                c = this.o.charAt(i);
            }
            this.d = c;
        }
        Object obj = null;
        if (this.d == '.') {
            this.h++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                c = '\u001a';
            } else {
                c = this.o.charAt(i);
            }
            this.d = c;
            while (this.d >= '0' && this.d <= '9') {
                this.h++;
                i = this.e + 1;
                this.e = i;
                if (i >= this.p) {
                    c = '\u001a';
                } else {
                    c = this.o.charAt(i);
                }
                this.d = c;
            }
            obj = 1;
        }
        if (this.d == 'L') {
            this.h++;
            c();
        } else if (this.d == 'S') {
            this.h++;
            c();
        } else if (this.d == 'B') {
            this.h++;
            c();
        } else {
            if (this.d == 'F') {
                this.h++;
                c();
            } else if (this.d == 'D') {
                this.h++;
                c();
            } else if (this.d == 'e' || this.d == 'E') {
                this.h++;
                i = this.e + 1;
                this.e = i;
                if (i >= this.p) {
                    c = '\u001a';
                } else {
                    c = this.o.charAt(i);
                }
                this.d = c;
                if (this.d == '+' || this.d == '-') {
                    this.h++;
                    i = this.e + 1;
                    this.e = i;
                    if (i >= this.p) {
                        c = '\u001a';
                    } else {
                        c = this.o.charAt(i);
                    }
                    this.d = c;
                }
                while (this.d >= '0' && this.d <= '9') {
                    this.h++;
                    i = this.e + 1;
                    this.e = i;
                    if (i >= this.p) {
                        c = '\u001a';
                    } else {
                        c = this.o.charAt(i);
                    }
                    this.d = c;
                }
                if (this.d == 'D' || this.d == 'F') {
                    this.h++;
                    c();
                }
            }
            i = 1;
        }
        if (obj != null) {
            this.a = 3;
        } else {
            this.a = 2;
        }
    }

    public final boolean t() {
        boolean z = false;
        int i = 1;
        if (this.o.startsWith("false", this.e)) {
            i = 5;
        } else if (this.o.startsWith("true", this.e)) {
            i = 4;
            z = true;
        } else if (this.d == '1') {
            z = true;
        } else if (this.d != '0') {
            this.n = -1;
            return z;
        }
        this.e = i + this.e;
        this.d = b(this.e);
        return z;
    }

    public final Number u() {
        int i;
        Object obj;
        long j;
        char c;
        Number valueOf;
        int i2 = this.e;
        this.i = 0;
        if (this.d == '-') {
            char c2;
            this.i++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                c2 = '\u001a';
            } else {
                c2 = this.o.charAt(i);
            }
            this.d = c2;
            obj = 1;
            j = Long.MIN_VALUE;
        } else {
            obj = null;
            j = -9223372036854775807L;
        }
        long j2 = 0;
        Object obj2 = null;
        while (this.d >= '0' && this.d <= '9') {
            int i3 = this.d - 48;
            if (j2 < -922337203685477580L) {
                obj2 = 1;
            }
            j2 *= 10;
            if (j2 < ((long) i3) + j) {
                obj2 = 1;
            }
            j2 -= (long) i3;
            this.i++;
            i3 = this.e + 1;
            this.e = i3;
            if (i3 >= this.p) {
                c = '\u001a';
            } else {
                c = this.o.charAt(i3);
            }
            this.d = c;
        }
        if (obj == null) {
            j2 = -j2;
        }
        if (this.d == 'L') {
            this.i++;
            c();
            valueOf = Long.valueOf(j2);
        } else if (this.d == 'S') {
            this.i++;
            c();
            valueOf = Short.valueOf((short) ((int) j2));
        } else if (this.d == 'B') {
            this.i++;
            c();
            valueOf = Byte.valueOf((byte) ((int) j2));
        } else if (this.d == 'F') {
            this.i++;
            c();
            valueOf = Float.valueOf((float) j2);
        } else if (this.d == 'D') {
            this.i++;
            c();
            valueOf = Double.valueOf((double) j2);
        } else {
            valueOf = null;
        }
        Object obj3 = null;
        if (this.d == '.') {
            char c3;
            this.i++;
            int i4 = this.e + 1;
            this.e = i4;
            if (i4 >= this.p) {
                c3 = '\u001a';
            } else {
                c3 = this.o.charAt(i4);
            }
            this.d = c3;
            while (this.d >= '0' && this.d <= '9') {
                this.i++;
                i4 = this.e + 1;
                this.e = i4;
                if (i4 >= this.p) {
                    c3 = '\u001a';
                } else {
                    c3 = this.o.charAt(i4);
                }
                this.d = c3;
            }
            obj3 = 1;
        }
        c = '\u0000';
        if (this.d == 'e' || this.d == 'E') {
            char c4;
            this.i++;
            int i5 = this.e + 1;
            this.e = i5;
            if (i5 >= this.p) {
                c4 = '\u001a';
            } else {
                c4 = this.o.charAt(i5);
            }
            this.d = c4;
            if (this.d == '+' || this.d == '-') {
                this.i++;
                i5 = this.e + 1;
                this.e = i5;
                if (i5 >= this.p) {
                    c4 = '\u001a';
                } else {
                    c4 = this.o.charAt(i5);
                }
                this.d = c4;
            }
            while (this.d >= '0' && this.d <= '9') {
                this.i++;
                i5 = this.e + 1;
                this.e = i5;
                if (i5 >= this.p) {
                    c4 = '\u001a';
                } else {
                    c4 = this.o.charAt(i5);
                }
                this.d = c4;
            }
            if (this.d == 'D' || this.d == 'F') {
                this.i++;
                c4 = this.d;
                c();
            } else {
                c4 = '\u0000';
            }
            char c5 = c4;
            obj = 1;
            c = c5;
        } else {
            obj = null;
        }
        if (obj3 == null && obj == null) {
            if (obj2 != null) {
                char[] cArr = new char[(this.e - i2)];
                this.o.getChars(i2, this.e, cArr, 0);
                valueOf = new BigInteger(new String(cArr));
            }
            if (valueOf != null) {
                return valueOf;
            }
            if (j2 <= -2147483648L || j2 >= 2147483647L) {
                return Long.valueOf(j2);
            }
            return Integer.valueOf((int) j2);
        }
        i = this.e - i2;
        if (c != '\u0000') {
            i--;
        }
        char[] cArr2 = new char[i];
        this.o.getChars(i2, i + i2, cArr2, 0);
        if (obj == null && (this.c & e.UseBigDecimal.q) != 0) {
            return new BigDecimal(cArr2);
        }
        String str = new String(cArr2);
        if (c != 'F') {
            return Double.valueOf(Double.parseDouble(str));
        }
        try {
            return Float.valueOf(str);
        } catch (Throwable e) {
            throw new d(e.getMessage() + ", " + j(), e);
        }
    }

    public final long v() {
        long j;
        int i;
        int i2 = 0;
        this.i = 0;
        if (this.d == '-') {
            i2 = 1;
            j = Long.MIN_VALUE;
            this.i++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                throw new d("syntax error, " + j());
            }
            this.d = this.o.charAt(i);
        } else {
            j = -9223372036854775807L;
        }
        long j2 = 0;
        while (this.d >= '0' && this.d <= '9') {
            i = this.d - 48;
            if (j2 < -922337203685477580L) {
                throw new d("error long value, " + j2 + ", " + j());
            }
            j2 *= 10;
            if (j2 < ((long) i) + j) {
                throw new d("error long value, " + j2 + ", " + j());
            }
            char c;
            j2 -= (long) i;
            this.i++;
            i = this.e + 1;
            this.e = i;
            if (i >= this.p) {
                c = '\u001a';
            } else {
                c = this.o.charAt(i);
            }
            this.d = c;
        }
        if (i2 == 0) {
            return -j2;
        }
        return j2;
    }

    public final long w() throws NumberFormatException {
        Object obj;
        long j;
        int i;
        int i2;
        long j2 = 0;
        int i3 = this.i;
        int i4 = this.i + this.h;
        int i5;
        if (b(this.i) == '-') {
            obj = 1;
            i5 = i3 + 1;
            j = Long.MIN_VALUE;
            i = i5;
        } else {
            obj = null;
            i5 = i3;
            j = -9223372036854775807L;
            i = i5;
        }
        if (i < i4) {
            i2 = i + 1;
            j2 = (long) (-(b(i) - 48));
        } else {
            i2 = i;
        }
        while (i2 < i4) {
            i = i2 + 1;
            if (i2 >= this.p) {
                i2 = 26;
            } else {
                i2 = this.o.charAt(i2);
            }
            if (i2 == 76 || i2 == 83 || i2 == 66) {
                break;
            }
            i2 -= 48;
            if (j2 < -922337203685477580L) {
                throw new NumberFormatException(f());
            }
            j2 *= 10;
            if (j2 < ((long) i2) + j) {
                throw new NumberFormatException(f());
            }
            j2 -= (long) i2;
            i2 = i;
        }
        i = i2;
        if (obj == null) {
            return -j2;
        }
        if (i > this.i + 1) {
            return j2;
        }
        throw new NumberFormatException(f());
    }

    public final Number a(boolean z) {
        char b = b((this.i + this.h) - 1);
        if (b == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(f()));
            } catch (NumberFormatException e) {
                throw new d(e.getMessage() + ", " + j());
            }
        } else if (b == 'D') {
            return Double.valueOf(Double.parseDouble(f()));
        } else {
            if (z) {
                return x();
            }
            return Double.valueOf(Double.parseDouble(f()));
        }
    }

    public final BigDecimal x() {
        return new BigDecimal(f());
    }

    public final boolean a(char[] cArr) {
        char c = '\u001a';
        if (!h(cArr)) {
            return false;
        }
        this.e += cArr.length;
        if (this.e >= this.p) {
            throw new d("unclosed str, " + j());
        }
        this.d = this.o.charAt(this.e);
        int i;
        if (this.d == '{') {
            i = this.e + 1;
            this.e = i;
            if (i < this.p) {
                c = this.o.charAt(i);
            }
            this.d = c;
            this.a = 12;
        } else if (this.d == '[') {
            i = this.e + 1;
            this.e = i;
            if (i < this.p) {
                c = this.o.charAt(i);
            }
            this.d = c;
            this.a = 14;
        } else {
            g();
        }
        return true;
    }

    private boolean h(char[] cArr) {
        int length = cArr.length;
        if (this.e + length > this.p) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (cArr[i] != this.o.charAt(this.e + i)) {
                return false;
            }
        }
        return true;
    }

    public final int b(char[] cArr) {
        char c = '\u001a';
        this.n = 0;
        if (h(cArr)) {
            int i;
            int i2;
            int length = cArr.length;
            int i3 = length + 1;
            length = b(length + this.e);
            if (length == 34) {
                i = i3 + 1;
                length = this.e + i3;
                if (length >= this.p) {
                    length = 26;
                } else {
                    length = this.o.charAt(length);
                }
                i3 = 1;
                i2 = i;
            } else {
                i2 = i3;
                i3 = 0;
            }
            if (length < 48 || length > 57) {
                this.n = -1;
                return 0;
            }
            char b;
            length -= 48;
            while (true) {
                i = i2 + 1;
                b = b(i2 + this.e);
                if (b >= '0' && b <= '9') {
                    length = (length * 10) + (b - 48);
                    i2 = i;
                }
            }
            if (b == '.') {
                this.n = -1;
                return 0;
            }
            if (b == '\"') {
                if (i3 == 0) {
                    this.n = -1;
                    return 0;
                }
                i3 = i + 1;
                i2 = this.e + i;
                if (i2 >= this.p) {
                    b = '\u001a';
                } else {
                    b = this.o.charAt(i2);
                }
                i = i3;
            }
            if (length < 0) {
                this.n = -1;
                return 0;
            } else if (b == ',') {
                this.e += i - 1;
                i2 = this.e + 1;
                this.e = i2;
                if (i2 < this.p) {
                    c = this.o.charAt(i2);
                }
                this.d = c;
                this.n = 3;
                this.a = 16;
                return length;
            } else if (b == '}') {
                i3 = i + 1;
                b = b(this.e + i);
                if (b == ',') {
                    this.a = 16;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == ']') {
                    this.a = 15;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == '}') {
                    this.a = 13;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == '\u001a') {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0;
                }
                this.n = 4;
                return length;
            } else {
                this.n = -1;
                return 0;
            }
        }
        this.n = -2;
        return 0;
    }

    public final long c(char[] cArr) {
        char c = '\u001a';
        this.n = 0;
        if (h(cArr)) {
            int i;
            char c2;
            int i2;
            int length = cArr.length;
            int i3 = length + 1;
            length += this.e;
            if (length >= this.p) {
                length = 26;
            } else {
                length = this.o.charAt(length);
            }
            if (length == 34) {
                int i4 = i3 + 1;
                i = this.e + i3;
                if (i >= this.p) {
                    c2 = '\u001a';
                } else {
                    c2 = this.o.charAt(i);
                }
                i2 = 1;
                length = c2;
                i = i4;
            } else {
                i2 = 0;
                i = i3;
            }
            if (length < 48 || length > 57) {
                this.n = -1;
                return 0;
            }
            long j = (long) (length - 48);
            while (true) {
                i3 = i + 1;
                i += this.e;
                if (i >= this.p) {
                    i = 26;
                } else {
                    i = this.o.charAt(i);
                }
                if (i >= 48 && i <= 57) {
                    j = (j * 10) + ((long) (i - 48));
                    i = i3;
                }
            }
            if (i == 46) {
                this.n = -1;
                return 0;
            }
            if (i == 34) {
                if (i2 == 0) {
                    this.n = -1;
                    return 0;
                }
                i2 = i3 + 1;
                i = this.e + i3;
                if (i >= this.p) {
                    i = 26;
                } else {
                    i = this.o.charAt(i);
                }
                i3 = i2;
            }
            if (j < 0) {
                this.n = -1;
                return 0;
            } else if (i == 44) {
                this.e += i3 - 1;
                i = this.e + 1;
                this.e = i;
                if (i < this.p) {
                    c = this.o.charAt(i);
                }
                this.d = c;
                this.n = 3;
                this.a = 16;
                return j;
            } else if (i == 125) {
                i2 = i3 + 1;
                c2 = b(this.e + i3);
                if (c2 == ',') {
                    this.a = 16;
                    this.e += i2 - 1;
                    i = this.e + 1;
                    this.e = i;
                    if (i < this.p) {
                        c = this.o.charAt(i);
                    }
                    this.d = c;
                } else if (c2 == ']') {
                    this.a = 15;
                    this.e += i2 - 1;
                    i = this.e + 1;
                    this.e = i;
                    if (i < this.p) {
                        c = this.o.charAt(i);
                    }
                    this.d = c;
                } else if (c2 == '}') {
                    this.a = 13;
                    this.e += i2 - 1;
                    i = this.e + 1;
                    this.e = i;
                    if (i < this.p) {
                        c = this.o.charAt(i);
                    }
                    this.d = c;
                } else if (c2 == '\u001a') {
                    this.a = 20;
                    this.e += i2 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0;
                }
                this.n = 4;
                return j;
            } else {
                this.n = -1;
                return 0;
            }
        }
        this.n = -2;
        return 0;
    }

    public final String d(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i = length + 1;
            length += this.e;
            if (length >= this.p) {
                throw new d("unclosed str, " + j());
            } else if (this.o.charAt(length) != '\"') {
                this.n = -1;
                return this.q;
            } else {
                int i2 = this.e + i;
                int indexOf = this.o.indexOf(34, i2);
                if (indexOf == -1) {
                    throw new d("unclosed str, " + j());
                }
                String substring;
                int i3;
                char c;
                if (x) {
                    substring = this.o.substring(i2, indexOf);
                } else {
                    i3 = indexOf - i2;
                    substring = new String(b(this.e + i, i3), 0, i3);
                }
                if (substring.indexOf(92) != -1) {
                    length = indexOf;
                    indexOf = 0;
                    while (true) {
                        i3 = length - 1;
                        int i4 = 0;
                        while (i3 >= 0 && this.o.charAt(i3) == '\\') {
                            i4++;
                            i3--;
                            indexOf = 1;
                        }
                        if (i4 % 2 == 0) {
                            break;
                        }
                        length = this.o.indexOf(34, length + 1);
                    }
                    i3 = length - i2;
                    char[] b = b(this.e + i, i3);
                    if (indexOf != 0) {
                        indexOf = length;
                        substring = a(b, i3);
                    } else {
                        String str = new String(b, 0, i3);
                        if (str.indexOf(92) != -1) {
                            indexOf = length;
                            substring = a(b, i3);
                        } else {
                            String str2 = str;
                            indexOf = length;
                            substring = str2;
                        }
                    }
                }
                int i5 = indexOf + 1;
                if (i5 >= this.p) {
                    c = '\u001a';
                } else {
                    c = this.o.charAt(i5);
                }
                if (c == ',') {
                    this.e = i5;
                    indexOf = this.e + 1;
                    this.e = indexOf;
                    if (indexOf >= this.p) {
                        c = '\u001a';
                    } else {
                        c = this.o.charAt(indexOf);
                    }
                    this.d = c;
                    this.n = 3;
                    this.a = 16;
                    return substring;
                } else if (c == '}') {
                    indexOf = i5 + 1;
                    char b2 = b(indexOf);
                    if (b2 == ',') {
                        this.a = 16;
                        this.e = indexOf;
                        c();
                    } else if (b2 == ']') {
                        this.a = 15;
                        this.e = indexOf;
                        c();
                    } else if (b2 == '}') {
                        this.a = 13;
                        this.e = indexOf;
                        c();
                    } else if (b2 == '\u001a') {
                        this.a = 20;
                        this.e = indexOf;
                        this.d = '\u001a';
                    } else {
                        this.n = -1;
                        return this.q;
                    }
                    this.n = 4;
                    return substring;
                } else {
                    this.n = -1;
                    return this.q;
                }
            }
        }
        this.n = -2;
        return this.q;
    }

    public final boolean e(char[] cArr) {
        boolean z = true;
        char c = '\u001a';
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            if (this.o.startsWith("false", this.e + length)) {
                length += 5;
                z = false;
            } else if (this.o.startsWith("true", this.e + length)) {
                length += 4;
            } else if (this.o.startsWith("\"false\"", this.e + length)) {
                length += 7;
                z = false;
            } else if (this.o.startsWith("\"true\"", this.e + length)) {
                length += 6;
            } else {
                this.n = -1;
                return false;
            }
            int i = length + 1;
            char b = b(length + this.e);
            int i2;
            if (b == ',') {
                char c2;
                this.e += i - 1;
                i2 = this.e + 1;
                this.e = i2;
                if (i2 >= this.p) {
                    c2 = '\u001a';
                } else {
                    c2 = this.o.charAt(i2);
                }
                this.d = c2;
                this.n = 3;
                this.a = 16;
                return z;
            } else if (b == '}') {
                int i3 = i + 1;
                b = b(this.e + i);
                if (b == ',') {
                    this.a = 16;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == ']') {
                    this.a = 15;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == '}') {
                    this.a = 13;
                    this.e += i3 - 1;
                    i2 = this.e + 1;
                    this.e = i2;
                    if (i2 < this.p) {
                        c = this.o.charAt(i2);
                    }
                    this.d = c;
                } else if (b == '\u001a') {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return false;
                }
                this.n = 4;
                return z;
            } else {
                this.n = -1;
                return false;
            }
        }
        this.n = -2;
        return false;
    }

    public final float f(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i = length + 1;
            char b = b(length + this.e);
            if (b < '0' || b > '9') {
                this.n = -1;
                return 0.0f;
            }
            char b2;
            while (true) {
                length = i + 1;
                b2 = b(i + this.e);
                if (b2 >= '0' && b2 <= '9') {
                    i = length;
                }
            }
            if (b2 == '.') {
                i = length + 1;
                b = b(length + this.e);
                if (b >= '0' && b <= '9') {
                    while (true) {
                        length = i + 1;
                        b2 = b(i + this.e);
                        if (b2 < '0' || b2 > '9') {
                            break;
                        }
                        i = length;
                    }
                } else {
                    this.n = -1;
                    return 0.0f;
                }
            }
            int length2 = this.e + cArr.length;
            float parseFloat = Float.parseFloat(a(length2, ((this.e + length) - length2) - 1));
            if (b2 == ',') {
                this.e += length - 1;
                c();
                this.n = 3;
                this.a = 16;
                return parseFloat;
            } else if (b2 == '}') {
                int i2 = length + 1;
                b2 = b(this.e + length);
                if (b2 == ',') {
                    this.a = 16;
                    this.e += i2 - 1;
                    c();
                } else if (b2 == ']') {
                    this.a = 15;
                    this.e += i2 - 1;
                    c();
                } else if (b2 == '}') {
                    this.a = 13;
                    this.e += i2 - 1;
                    c();
                } else if (b2 == '\u001a') {
                    this.e += i2 - 1;
                    this.a = 20;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0.0f;
                }
                this.n = 4;
                return parseFloat;
            } else {
                this.n = -1;
                return 0.0f;
            }
        }
        this.n = -2;
        return 0.0f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double g(char[] r11) {
        /*
        r10 = this;
        r8 = 16;
        r7 = -1;
        r6 = 57;
        r5 = 48;
        r2 = 0;
        r0 = 0;
        r10.n = r0;
        r0 = r10.h(r11);
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        r0 = -2;
        r10.n = r0;
        r0 = r2;
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = r11.length;
        r4 = r10.e;
        r0 = r1 + 1;
        r1 = r1 + r4;
        r1 = r10.b(r1);
        if (r1 < r5) goto L_0x00a8;
    L_0x0023:
        if (r1 > r6) goto L_0x00a8;
    L_0x0025:
        r4 = r10.e;
        r1 = r0 + 1;
        r0 = r0 + r4;
        r0 = r10.b(r0);
        if (r0 < r5) goto L_0x0032;
    L_0x0030:
        if (r0 <= r6) goto L_0x0114;
    L_0x0032:
        r4 = 46;
        if (r0 != r4) goto L_0x0056;
    L_0x0036:
        r4 = r10.e;
        r0 = r1 + 1;
        r1 = r1 + r4;
        r1 = r10.b(r1);
        if (r1 < r5) goto L_0x0052;
    L_0x0041:
        if (r1 > r6) goto L_0x0052;
    L_0x0043:
        r4 = r10.e;
        r1 = r0 + 1;
        r0 = r0 + r4;
        r0 = r10.b(r0);
        if (r0 < r5) goto L_0x0056;
    L_0x004e:
        if (r0 > r6) goto L_0x0056;
    L_0x0050:
        r0 = r1;
        goto L_0x0043;
    L_0x0052:
        r10.n = r7;
        r0 = r2;
        goto L_0x0016;
    L_0x0056:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r0 == r4) goto L_0x005e;
    L_0x005a:
        r4 = 69;
        if (r0 != r4) goto L_0x0080;
    L_0x005e:
        r4 = r10.e;
        r0 = r1 + 1;
        r1 = r1 + r4;
        r1 = r10.b(r1);
        r4 = 43;
        if (r1 == r4) goto L_0x006f;
    L_0x006b:
        r4 = 45;
        if (r1 != r4) goto L_0x0079;
    L_0x006f:
        r1 = r10.e;
        r4 = r0 + 1;
        r0 = r0 + r1;
        r1 = r10.b(r0);
        r0 = r4;
    L_0x0079:
        if (r1 < r5) goto L_0x007d;
    L_0x007b:
        if (r1 <= r6) goto L_0x006f;
    L_0x007d:
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0080:
        r4 = r10.e;
        r5 = r11.length;
        r4 = r4 + r5;
        r5 = r10.e;
        r5 = r5 + r1;
        r5 = r5 - r4;
        r5 = r5 + -1;
        r4 = r10.a(r4, r5);
        r4 = java.lang.Double.parseDouble(r4);
        r6 = 44;
        if (r0 != r6) goto L_0x00ad;
    L_0x0096:
        r0 = r10.e;
        r1 = r1 + -1;
        r0 = r0 + r1;
        r10.e = r0;
        r10.c();
        r0 = 3;
        r10.n = r0;
        r10.a = r8;
        r0 = r4;
        goto L_0x0016;
    L_0x00a8:
        r10.n = r7;
        r0 = r2;
        goto L_0x0016;
    L_0x00ad:
        r6 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r0 != r6) goto L_0x010f;
    L_0x00b1:
        r0 = r10.e;
        r6 = r1 + 1;
        r0 = r0 + r1;
        r0 = r10.b(r0);
        r1 = 44;
        if (r0 != r1) goto L_0x00d0;
    L_0x00be:
        r10.a = r8;
        r0 = r10.e;
        r1 = r6 + -1;
        r0 = r0 + r1;
        r10.e = r0;
        r10.c();
    L_0x00ca:
        r0 = 4;
        r10.n = r0;
        r0 = r4;
        goto L_0x0016;
    L_0x00d0:
        r1 = 93;
        if (r0 != r1) goto L_0x00e3;
    L_0x00d4:
        r0 = 15;
        r10.a = r0;
        r0 = r10.e;
        r1 = r6 + -1;
        r0 = r0 + r1;
        r10.e = r0;
        r10.c();
        goto L_0x00ca;
    L_0x00e3:
        r1 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r0 != r1) goto L_0x00f6;
    L_0x00e7:
        r0 = 13;
        r10.a = r0;
        r0 = r10.e;
        r1 = r6 + -1;
        r0 = r0 + r1;
        r10.e = r0;
        r10.c();
        goto L_0x00ca;
    L_0x00f6:
        r1 = 26;
        if (r0 != r1) goto L_0x010a;
    L_0x00fa:
        r0 = 20;
        r10.a = r0;
        r0 = r10.e;
        r1 = r6 + -1;
        r0 = r0 + r1;
        r10.e = r0;
        r0 = 26;
        r10.d = r0;
        goto L_0x00ca;
    L_0x010a:
        r10.n = r7;
        r0 = r2;
        goto L_0x0016;
    L_0x010f:
        r10.n = r7;
        r0 = r2;
        goto L_0x0016;
    L_0x0114:
        r0 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.i.g(char[]):double");
    }

    public final String a(char[] cArr, q qVar) {
        int i = 0;
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i2 = length + 1;
            if (b(length + this.e) != '\"') {
                this.n = -1;
                return null;
            }
            while (true) {
                length = i2 + 1;
                char b = b(i2 + this.e);
                if (b == '\"') {
                    break;
                }
                i = (i * 31) + b;
                if (b == '\\') {
                    this.n = -1;
                    return null;
                }
                i2 = length;
            }
            i2 = (this.e + cArr.length) + 1;
            String a = qVar.a(this.o, i2, ((this.e + length) - i2) - 1, i);
            int i3 = length + 1;
            char b2 = b(this.e + length);
            if (b2 == ',') {
                this.e += i3 - 1;
                i = this.e + 1;
                this.e = i;
                if (i >= this.p) {
                    b2 = '\u001a';
                } else {
                    b2 = this.o.charAt(i);
                }
                this.d = b2;
                this.n = 3;
                return a;
            } else if (b2 == '}') {
                length = i3 + 1;
                b2 = b(this.e + i3);
                if (b2 == ',') {
                    this.a = 16;
                    this.e += length - 1;
                    c();
                } else if (b2 == ']') {
                    this.a = 15;
                    this.e += length - 1;
                    c();
                } else if (b2 == '}') {
                    this.a = 13;
                    this.e += length - 1;
                    c();
                } else if (b2 == '\u001a') {
                    this.a = 20;
                    this.e += length - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return null;
                }
                this.n = 4;
                return a;
            } else {
                this.n = -1;
                return null;
            }
        }
        this.n = -2;
        return null;
    }

    public final boolean b(boolean z) {
        int length = this.o.length() - this.e;
        int i;
        int i2;
        char b;
        if (!z && length > 13 && this.o.startsWith("/Date(", this.e) && b((this.e + length) - 1) == '/' && b((this.e + length) - 2) == ')') {
            i = -1;
            for (i2 = 6; i2 < length; i2++) {
                b = b(this.e + i2);
                if (b != '+') {
                    if (b < '0' || b > '9') {
                        break;
                    }
                } else {
                    i = i2;
                }
            }
            if (i == -1) {
                return false;
            }
            i2 = this.e + 6;
            long parseLong = Long.parseLong(a(i2, i - i2));
            this.m = Calendar.getInstance(this.k, this.l);
            this.m.setTimeInMillis(parseLong);
            this.a = 5;
            return true;
        } else if (length == 8 || length == 14 || length == 17) {
            if (z) {
                return false;
            }
            r2 = b(this.e);
            r3 = b(this.e + 1);
            b = b(this.e + 2);
            r5 = b(this.e + 3);
            r6 = b(this.e + 4);
            r7 = b(this.e + 5);
            r8 = b(this.e + 6);
            r9 = b(this.e + 7);
            if (!a(r2, r3, b, r5, r6, r7, (int) r8, (int) r9)) {
                return false;
            }
            int i3;
            a(r2, r3, b, r5, r6, r7, r8, r9);
            if (length != 8) {
                r2 = b(this.e + 8);
                r3 = b(this.e + 9);
                b = b(this.e + 10);
                r5 = b(this.e + 11);
                r6 = b(this.e + 12);
                r7 = b(this.e + 13);
                if (!a(r2, r3, b, r5, r6, r7)) {
                    return false;
                }
                if (length == 17) {
                    r8 = b(this.e + 14);
                    r9 = b(this.e + 15);
                    char b2 = b(this.e + 16);
                    if (r8 < '0' || r8 > '9') {
                        return false;
                    }
                    if (r9 < '0' || r9 > '9') {
                        return false;
                    }
                    if (b2 < '0' || b2 > '9') {
                        return false;
                    }
                    i3 = (((r8 - 48) * 100) + ((r9 - 48) * 10)) + (b2 - 48);
                } else {
                    i3 = 0;
                }
                i2 = (r3 - 48) + ((r2 - 48) * 10);
                r4 = (r5 - 48) + ((b - 48) * 10);
                i = ((r6 - 48) * 10) + (r7 - 48);
            } else {
                i3 = 0;
                i = 0;
                i2 = 0;
                r4 = 0;
            }
            this.m.set(11, i2);
            this.m.set(12, r4);
            this.m.set(13, i);
            this.m.set(14, i3);
            this.a = 5;
            return true;
        } else if (length < 10) {
            return false;
        } else {
            if (b(this.e + 4) != '-') {
                return false;
            }
            if (b(this.e + 7) != '-') {
                return false;
            }
            r2 = b(this.e);
            r3 = b(this.e + 1);
            b = b(this.e + 2);
            r5 = b(this.e + 3);
            r6 = b(this.e + 5);
            r7 = b(this.e + 6);
            r8 = b(this.e + 8);
            r9 = b(this.e + 9);
            if (!a(r2, r3, b, r5, r6, r7, (int) r8, (int) r9)) {
                return false;
            }
            a(r2, r3, b, r5, r6, r7, r8, r9);
            r2 = b(this.e + 10);
            if (r2 == 'T' || (r2 == ' ' && !z)) {
                if (length < 19) {
                    return false;
                }
                if (b(this.e + 13) != ':') {
                    return false;
                }
                if (b(this.e + 16) != ':') {
                    return false;
                }
                r2 = b(this.e + 11);
                r3 = b(this.e + 12);
                b = b(this.e + 14);
                r5 = b(this.e + 15);
                r6 = b(this.e + 17);
                r7 = b(this.e + 18);
                if (!a(r2, r3, b, r5, r6, r7)) {
                    return false;
                }
                i = ((r2 - 48) * 10) + (r3 - 48);
                i2 = ((b - 48) * 10) + (r5 - 48);
                r4 = ((r6 - 48) * 10) + (r7 - 48);
                this.m.set(11, i);
                this.m.set(12, i2);
                this.m.set(13, r4);
                r2 = b(this.e + 19);
                if (r2 != '.') {
                    this.m.set(14, 0);
                    i2 = this.e + 19;
                    this.e = i2;
                    this.d = b(i2);
                    this.a = 5;
                    if (r2 == 'Z' && this.m.getTimeZone().getRawOffset() != 0) {
                        String[] availableIDs = TimeZone.getAvailableIDs(0);
                        if (availableIDs.length > 0) {
                            this.m.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                        }
                    }
                    return true;
                } else if (length < 23) {
                    return false;
                } else {
                    r2 = b(this.e + 20);
                    if (r2 < '0' || r2 > '9') {
                        return false;
                    }
                    i = s[r2];
                    i2 = 1;
                    b = b(this.e + 21);
                    if (b >= '0' && b <= '9') {
                        i = (i * 10) + s[b];
                        i2 = 2;
                    }
                    if (i2 == 2) {
                        b = b(this.e + 22);
                        if (b >= '0' && b <= '9') {
                            i = (i * 10) + s[b];
                            i2 = 3;
                        }
                    }
                    this.m.set(14, i);
                    i = 0;
                    r5 = b((this.e + 20) + i2);
                    String[] availableIDs2;
                    if (r5 == '+' || r5 == '-') {
                        b = b(((this.e + 20) + i2) + 1);
                        if (b < '0' || b > '1') {
                            return false;
                        }
                        r6 = b(((this.e + 20) + i2) + 2);
                        if (r6 < '0' || r6 > '9') {
                            return false;
                        }
                        r2 = b(((this.e + 20) + i2) + 3);
                        if (r2 == ':') {
                            if (b(((this.e + 20) + i2) + 4) != '0') {
                                return false;
                            }
                            if (b(((this.e + 20) + i2) + 5) != '0') {
                                return false;
                            }
                            i = 6;
                        } else if (r2 != '0') {
                            i = 3;
                        } else if (b(((this.e + 20) + i2) + 4) != '0') {
                            return false;
                        } else {
                            i = 5;
                        }
                        r4 = (((s[b] * 10) + s[r6]) * 3600) * 1000;
                        if (r5 == '-') {
                            r4 = -r4;
                        }
                        if (this.m.getTimeZone().getRawOffset() != r4) {
                            availableIDs2 = TimeZone.getAvailableIDs(r4);
                            if (availableIDs2.length > 0) {
                                this.m.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                            }
                        }
                    } else if (r5 == 'Z') {
                        i = 1;
                        if (this.m.getTimeZone().getRawOffset() != 0) {
                            availableIDs2 = TimeZone.getAvailableIDs(0);
                            if (availableIDs2.length > 0) {
                                this.m.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                            }
                        }
                    }
                    b = b(this.e + ((i2 + 20) + i));
                    if (b != '\u001a' && b != '\"') {
                        return false;
                    }
                    i = (i + (i2 + 20)) + this.e;
                    this.e = i;
                    this.d = b(i);
                    this.a = 5;
                    return true;
                }
            } else if (r2 != '\"' && r2 != '\u001a') {
                return false;
            } else {
                this.m.set(11, 0);
                this.m.set(12, 0);
                this.m.set(13, 0);
                this.m.set(14, 0);
                i = this.e + 10;
                this.e = i;
                this.d = b(i);
                this.a = 5;
                return true;
            }
        }
    }

    private static boolean a(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c == '1') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '2' || c2 < '0') {
            return false;
        } else {
            if (c2 > '4') {
                return false;
            }
        }
        if (c3 < '0' || c3 > '5') {
            if (c3 != '6') {
                return false;
            }
            if (c4 != '0') {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 < '0' || c5 > '5') {
            if (c5 != '6') {
                return false;
            }
            if (c6 != '0') {
                return false;
            }
        } else if (c6 < '0' || c6 > '9') {
            return false;
        }
        return true;
    }

    private void a(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.m = Calendar.getInstance(this.k, this.l);
        int i = (((c5 - 48) * 10) + (c6 - 48)) - 1;
        int i2 = ((c7 - 48) * 10) + (c8 - 48);
        this.m.set(1, ((((c - 48) * 1000) + ((c2 - 48) * 100)) + ((c3 - 48) * 10)) + (c4 - 48));
        this.m.set(2, i);
        this.m.set(5, i2);
    }

    private static boolean a(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c != '1' && c != '2') || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 == '0') {
            if (c6 < '1' || c6 > '9') {
                return false;
            }
        } else if (c5 != '1') {
            return false;
        } else {
            if (!(c6 == '0' || c6 == '1' || c6 == '2')) {
                return false;
            }
        }
        if (i == 48) {
            if (i2 < 49 || i2 > 57) {
                return false;
            }
        } else if (i == 49 || i == 50) {
            if (i2 < 48) {
                return false;
            }
            if (i2 > 57) {
                return false;
            }
        } else if (i != 51) {
            return false;
        } else {
            if (!(i2 == 48 || i2 == 49)) {
                return false;
            }
        }
        return true;
    }

    public static final byte[] a(String str) {
        int i = 0;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && u[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && u[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        int i5 = str.charAt(i4) == '=' ? str.charAt(i4 + -1) == '=' ? 2 : 1 : 0;
        int i6 = (i4 - i3) + 1;
        if (length > 76) {
            if (str.charAt(76) == '\r') {
                i2 = i6 / 78;
            } else {
                i2 = 0;
            }
            i2 <<= 1;
        } else {
            i2 = 0;
        }
        int i7 = (((i6 - i2) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        length = 0;
        int i9 = 0;
        while (i9 < i8) {
            int i10 = i3 + 1;
            int i11 = i10 + 1;
            i3 = (u[str.charAt(i3)] << 18) | (u[str.charAt(i10)] << 12);
            i10 = i11 + 1;
            int i12 = (u[str.charAt(i11)] << 6) | i3;
            i3 = i10 + 1;
            i12 |= u[str.charAt(i10)];
            i10 = i9 + 1;
            bArr[i9] = (byte) (i12 >> 16);
            i11 = i10 + 1;
            bArr[i10] = (byte) (i12 >> 8);
            i9 = i11 + 1;
            bArr[i11] = (byte) i12;
            if (i2 > 0) {
                length++;
                if (length == 19) {
                    i3 += 2;
                    length = 0;
                }
            }
        }
        if (i9 < i7) {
            i3 = 0;
            for (i2 = i3; i2 <= i4 - i5; i2++) {
                i++;
                i3 = (u[str.charAt(i2)] << (18 - (i * 6))) | i3;
            }
            i2 = 16;
            i = i9;
            while (i < i7) {
                length = i + 1;
                bArr[i] = (byte) (i3 >> i2);
                i2 -= 8;
                i = length;
            }
        }
        return bArr;
    }
}
