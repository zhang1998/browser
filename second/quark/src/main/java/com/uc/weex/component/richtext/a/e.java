package com.uc.weex.component.richtext.a;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.io.PushbackReader;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* compiled from: ProGuard */
public final class e implements j, Locator {
    private static int[] f = new int[]{1, 47, 5, 22, 1, 61, 4, 3, 1, 62, 6, 28, 1, 0, 27, 1, 1, -1, 6, 21, 1, 32, 4, 24, 1, 10, 4, 24, 1, 9, 4, 24, 2, 39, 7, 34, 2, 0, 27, 2, 2, -1, 8, 21, 2, 32, 29, 2, 2, 10, 29, 2, 2, 9, 29, 2, 3, 39, 28, 2, 3, 34, 28, 31, 3, 62, 8, 28, 3, 0, 27, 32, 3, -1, 8, 21, 3, 32, 28, 3, 3, 10, 28, 3, 3, 9, 28, 3, 4, 67, 28, 5, 4, 0, 28, 19, 4, -1, 28, 21, 5, 68, 28, 6, 5, 0, 28, 19, 5, -1, 28, 21, 6, 65, 28, 7, 6, 0, 28, 19, 6, -1, 28, 21, 7, 84, 28, 8, 7, 0, 28, 19, 7, -1, 28, 21, 8, 65, 28, 9, 8, 0, 28, 19, 8, -1, 28, 21, 9, 91, 28, 12, 9, 0, 28, 19, 9, -1, 28, 21, 10, 60, 27, 11, 10, 0, 27, 10, 10, -1, 23, 21, 11, 47, 32, 25, 11, 0, 27, 10, 11, -1, 32, 21, 12, 93, 27, 13, 12, 0, 27, 12, 12, -1, 28, 21, 13, 93, 27, 14, 13, 0, 27, 12, 13, -1, 28, 21, 14, 62, 9, 28, 14, 0, 27, 12, 14, -1, 28, 21, 15, 45, 28, 16, 15, 0, 27, 16, 15, -1, 10, 21, 16, 45, 28, 17, 16, 0, 27, 16, 16, -1, 10, 21, 17, 45, 28, 18, 17, 0, 20, 16, 17, -1, 10, 21, 18, 45, 22, 18, 18, 62, 10, 28, 18, 0, 21, 16, 18, -1, 10, 21, 19, 45, 28, 15, 19, 91, 28, 4, 19, 62, 28, 28, 19, 0, 27, 20, 19, -1, 28, 21, 20, 62, 11, 28, 20, 0, 27, 20, 20, -1, 28, 21, 22, 62, 12, 28, 22, 0, 27, 1, 22, 32, 28, 34, 22, 10, 28, 34, 22, 9, 28, 34, 23, 0, 13, 23, 23, -1, 13, 21, 24, 61, 28, 3, 24, 62, 3, 28, 24, 0, 2, 1, 24, -1, 3, 21, 24, 32, 28, 24, 24, 10, 28, 24, 24, 9, 28, 24, 25, 62, 15, 28, 25, 0, 27, 25, 25, -1, 15, 21, 25, 32, 28, 25, 25, 10, 28, 25, 25, 9, 28, 25, 26, 47, 28, 22, 26, 62, 17, 28, 26, 0, 27, 26, 26, -1, 28, 21, 26, 32, 16, 34, 26, 10, 16, 34, 26, 9, 16, 34, 27, 0, 13, 27, 27, -1, 13, 21, 28, 38, 14, 23, 28, 60, 23, 33, 28, 0, 27, 28, 28, -1, 23, 21, 29, 62, 24, 28, 29, 0, 27, 29, 29, -1, 24, 21, 30, 62, 26, 28, 30, 0, 27, 30, 30, -1, 26, 21, 30, 32, 25, 29, 30, 10, 25, 29, 30, 9, 25, 29, 31, 34, 7, 34, 31, 0, 27, 31, 31, -1, 8, 21, 31, 32, 29, 31, 31, 10, 29, 31, 31, 9, 29, 31, 32, 62, 8, 28, 32, 0, 27, 32, 32, -1, 8, 21, 32, 32, 7, 34, 32, 10, 7, 34, 32, 9, 7, 34, 33, 33, 28, 19, 33, 63, 28, 30, 33, 47, 28, 25, 33, 60, 27, 33, 33, 0, 27, 26, 33, -1, 19, 21, 33, 32, 18, 28, 33, 10, 18, 28, 33, 9, 18, 28, 34, 47, 28, 22, 34, 62, 30, 28, 34, 0, 27, 1, 34, -1, 30, 21, 34, 32, 28, 34, 34, 10, 28, 34, 34, 9, 28, 34, 35, 0, 13, 35, 35, -1, 13, 21};
    private static final String[] g = new String[]{"", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};
    private static final String[] h = new String[]{"", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};
    int a;
    int b;
    char[] c = new char[200];
    int d;
    int[] e = new int[]{8364, 65533, 8218, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376};
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;
    private int n;

    private static void a(PushbackReader pushbackReader, int i) throws IOException {
        if (i != -1) {
            pushbackReader.unread(i);
        }
    }

    public final int getLineNumber() {
        return this.k;
    }

    public final int getColumnNumber() {
        return this.l;
    }

    public final String getPublicId() {
        return this.i;
    }

    public final String getSystemId() {
        return this.j;
    }

    public final void a(String str, String str2) {
        this.i = str;
        this.j = str2;
        this.n = 0;
        this.m = 0;
        this.l = 0;
        this.k = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.io.Reader r11, com.uc.weex.component.richtext.a.i r12) throws java.io.IOException, org.xml.sax.SAXException {
        /*
        r10 = this;
        r9 = 35;
        r8 = 27;
        r4 = 10;
        r7 = 32;
        r1 = 0;
        r0 = 28;
        r10.a = r0;
        r0 = r11 instanceof java.io.PushbackReader;
        if (r0 == 0) goto L_0x0083;
    L_0x0011:
        r11 = (java.io.PushbackReader) r11;
    L_0x0013:
        r0 = r11.read();
        r2 = 65279; // 0xfeff float:9.1475E-41 double:3.2252E-319;
        if (r0 == r2) goto L_0x001f;
    L_0x001c:
        a(r11, r0);
    L_0x001f:
        r0 = r10.a;
        r2 = 21;
        if (r0 == r2) goto L_0x0348;
    L_0x0025:
        r0 = r11.read();
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r0 < r2) goto L_0x0037;
    L_0x002d:
        r2 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        if (r0 > r2) goto L_0x0037;
    L_0x0031:
        r2 = r10.e;
        r0 = r0 + -128;
        r0 = r2[r0];
    L_0x0037:
        r2 = 13;
        if (r0 != r2) goto L_0x034c;
    L_0x003b:
        r0 = r11.read();
        if (r0 == r4) goto L_0x034c;
    L_0x0041:
        a(r11, r0);
        r3 = r4;
    L_0x0045:
        if (r3 != r4) goto L_0x009d;
    L_0x0047:
        r0 = r10.m;
        r0 = r0 + 1;
        r10.m = r0;
        r10.n = r1;
    L_0x004f:
        if (r3 >= r7) goto L_0x005a;
    L_0x0051:
        if (r3 == r4) goto L_0x005a;
    L_0x0053:
        r0 = 9;
        if (r3 == r0) goto L_0x005a;
    L_0x0057:
        r0 = -1;
        if (r3 != r0) goto L_0x001f;
    L_0x005a:
        r0 = r1;
        r2 = r1;
    L_0x005c:
        r5 = f;
        r5 = r5.length;
        if (r0 >= r5) goto L_0x006b;
    L_0x0061:
        r5 = r10.a;
        r6 = f;
        r6 = r6[r0];
        if (r5 == r6) goto L_0x00a4;
    L_0x0069:
        if (r2 == 0) goto L_0x00ba;
    L_0x006b:
        switch(r2) {
            case 0: goto L_0x00d4;
            case 1: goto L_0x00fd;
            case 2: goto L_0x0108;
            case 3: goto L_0x0111;
            case 4: goto L_0x011e;
            case 5: goto L_0x0128;
            case 6: goto L_0x0135;
            case 7: goto L_0x0149;
            case 8: goto L_0x0153;
            case 9: goto L_0x0164;
            case 10: goto L_0x02a5;
            case 11: goto L_0x024f;
            case 12: goto L_0x030f;
            case 13: goto L_0x018a;
            case 14: goto L_0x017c;
            case 15: goto L_0x0244;
            case 16: goto L_0x025a;
            case 17: goto L_0x0265;
            case 18: goto L_0x0277;
            case 19: goto L_0x0284;
            case 20: goto L_0x02c5;
            case 21: goto L_0x02bd;
            case 22: goto L_0x02b3;
            case 23: goto L_0x0297;
            case 24: goto L_0x02cf;
            case 25: goto L_0x02dd;
            case 26: goto L_0x02e8;
            case 27: goto L_0x02fa;
            case 28: goto L_0x0102;
            case 29: goto L_0x02ff;
            case 30: goto L_0x0304;
            case 31: goto L_0x0328;
            case 32: goto L_0x0333;
            default: goto L_0x006e;
        };
    L_0x006e:
        r0 = new java.lang.Error;
        r1 = new java.lang.StringBuilder;
        r3 = "Can't process state ";
        r1.<init>(r3);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0083:
        r0 = r11 instanceof java.io.BufferedReader;
        if (r0 == 0) goto L_0x008e;
    L_0x0087:
        r0 = new java.io.PushbackReader;
        r0.<init>(r11);
        r11 = r0;
        goto L_0x0013;
    L_0x008e:
        r0 = new java.io.PushbackReader;
        r2 = new java.io.BufferedReader;
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2.<init>(r11, r3);
        r0.<init>(r2);
        r11 = r0;
        goto L_0x0013;
    L_0x009d:
        r0 = r10.n;
        r0 = r0 + 1;
        r10.n = r0;
        goto L_0x004f;
    L_0x00a4:
        r5 = f;
        r6 = r0 + 1;
        r5 = r5[r6];
        if (r5 != 0) goto L_0x00bd;
    L_0x00ac:
        r2 = f;
        r5 = r0 + 2;
        r2 = r2[r5];
        r5 = f;
        r6 = r0 + 3;
        r5 = r5[r6];
        r10.b = r5;
    L_0x00ba:
        r0 = r0 + 4;
        goto L_0x005c;
    L_0x00bd:
        r5 = f;
        r6 = r0 + 1;
        r5 = r5[r6];
        if (r5 != r3) goto L_0x00ba;
    L_0x00c5:
        r2 = f;
        r5 = r0 + 2;
        r2 = r2[r5];
        r5 = f;
        r0 = r0 + 3;
        r0 = r5[r0];
        r10.b = r0;
        goto L_0x006b;
    L_0x00d4:
        r0 = new java.lang.Error;
        r1 = new java.lang.StringBuilder;
        r2 = "HTMLScanner can't cope with ";
        r1.<init>(r2);
        r2 = java.lang.Integer.toString(r3);
        r1 = r1.append(r2);
        r2 = " in state ";
        r1 = r1.append(r2);
        r2 = r10.a;
        r2 = java.lang.Integer.toString(r2);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00fd:
        r12.a();
        r10.d = r1;
    L_0x0102:
        r0 = r10.b;
        r10.a = r0;
        goto L_0x001f;
    L_0x0108:
        r12.a();
        r10.d = r1;
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x0111:
        r12.a();
        r10.d = r1;
        r0 = r10.c;
        r2 = r10.d;
        r12.j(r0, r2);
        goto L_0x0102;
    L_0x011e:
        r0 = r10.c;
        r2 = r10.d;
        r12.a(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x0128:
        r0 = r10.c;
        r2 = r10.d;
        r12.a(r0, r2);
        r10.d = r1;
        r12.a();
        goto L_0x0102;
    L_0x0135:
        r0 = r10.c;
        r2 = r10.d;
        r12.a(r0, r2);
        r10.d = r1;
        r12.a();
        r0 = r10.c;
        r2 = r10.d;
        r12.j(r0, r2);
        goto L_0x0102;
    L_0x0149:
        r0 = r10.c;
        r2 = r10.d;
        r12.b(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x0153:
        r0 = r10.c;
        r2 = r10.d;
        r12.b(r0, r2);
        r10.d = r1;
        r0 = r10.c;
        r2 = r10.d;
        r12.j(r0, r2);
        goto L_0x0102;
    L_0x0164:
        r10.b();
        r0 = r10.d;
        r2 = 1;
        if (r0 <= r2) goto L_0x0172;
    L_0x016c:
        r0 = r10.d;
        r0 = r0 + -2;
        r10.d = r0;
    L_0x0172:
        r0 = r10.c;
        r2 = r10.d;
        r12.g(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x017c:
        r0 = r10.c;
        r2 = r10.d;
        r12.g(r0, r2);
        r10.d = r1;
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x018a:
        r10.b();
        r0 = (char) r3;
        r2 = r10.a;
        r5 = 23;
        if (r2 != r5) goto L_0x019d;
    L_0x0194:
        if (r0 != r9) goto L_0x019d;
    L_0x0196:
        r10.b = r8;
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x019d:
        r2 = r10.a;
        if (r2 != r8) goto L_0x01b0;
    L_0x01a1:
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r0 == r2) goto L_0x01a9;
    L_0x01a5:
        r2 = 88;
        if (r0 != r2) goto L_0x01b0;
    L_0x01a9:
        r10.b = r9;
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x01b0:
        r2 = r10.a;
        r5 = 23;
        if (r2 != r5) goto L_0x01c1;
    L_0x01b6:
        r2 = java.lang.Character.isLetterOrDigit(r0);
        if (r2 == 0) goto L_0x01c1;
    L_0x01bc:
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x01c1:
        r2 = r10.a;
        if (r2 != r8) goto L_0x01d0;
    L_0x01c5:
        r2 = java.lang.Character.isDigit(r0);
        if (r2 == 0) goto L_0x01d0;
    L_0x01cb:
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x01d0:
        r2 = r10.a;
        if (r2 != r9) goto L_0x01e8;
    L_0x01d4:
        r2 = java.lang.Character.isDigit(r0);
        if (r2 != 0) goto L_0x01e3;
    L_0x01da:
        r2 = "abcdefABCDEF";
        r0 = r2.indexOf(r0);
        r2 = -1;
        if (r0 == r2) goto L_0x01e8;
    L_0x01e3:
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x01e8:
        r0 = r10.c;
        r2 = r10.d;
        r2 = r2 + -1;
        r12.c(r0, r2);
        r0 = r12.c();
        if (r0 == 0) goto L_0x021f;
    L_0x01f7:
        r10.d = r1;
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r0 < r2) goto L_0x0207;
    L_0x01fd:
        r2 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        if (r0 > r2) goto L_0x0207;
    L_0x0201:
        r2 = r10.e;
        r0 = r0 + -128;
        r0 = r2[r0];
    L_0x0207:
        if (r0 < r7) goto L_0x021b;
    L_0x0209:
        r2 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r0 < r2) goto L_0x0213;
    L_0x020e:
        r2 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r0 <= r2) goto L_0x021b;
    L_0x0213:
        r2 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r0 > r2) goto L_0x022e;
    L_0x0218:
        r10.a(r0, r12);
    L_0x021b:
        r0 = 59;
        if (r3 == r0) goto L_0x0228;
    L_0x021f:
        a(r11, r3);
        r0 = r10.n;
        r0 = r0 + -1;
        r10.n = r0;
    L_0x0228:
        r0 = 28;
        r10.b = r0;
        goto L_0x0102;
    L_0x022e:
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0 - r2;
        r2 = r0 >> 10;
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r2 = r2 + r5;
        r10.a(r2, r12);
        r0 = r0 & 1023;
        r2 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r0 = r0 + r2;
        r10.a(r0, r12);
        goto L_0x021b;
    L_0x0244:
        r0 = r10.c;
        r2 = r10.d;
        r12.d(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x024f:
        r0 = r10.c;
        r2 = r10.d;
        r12.e(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x025a:
        r0 = r10.c;
        r2 = r10.d;
        r12.f(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x0265:
        r0 = r10.c;
        r2 = r10.d;
        r12.f(r0, r2);
        r10.d = r1;
        r0 = r10.c;
        r2 = r10.d;
        r12.j(r0, r2);
        goto L_0x0102;
    L_0x0277:
        r10.b();
        r0 = 60;
        r10.a(r0, r12);
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x0284:
        r10.b();
        r0 = 60;
        r10.a(r0, r12);
        r0 = r10.c;
        r2 = r10.d;
        r12.g(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x0297:
        r10.b();
        r0 = r10.c;
        r2 = r10.d;
        r12.g(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x02a5:
        r10.b();
        r0 = r10.c;
        r2 = r10.d;
        r12.l(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x02b3:
        r0 = 45;
        r10.a(r0, r12);
        r10.a(r7, r12);
        goto L_0x0102;
    L_0x02bd:
        r0 = 45;
        r10.a(r0, r12);
        r10.a(r7, r12);
    L_0x02c5:
        r0 = 45;
        r10.a(r0, r12);
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x02cf:
        r10.b();
        r0 = r10.c;
        r2 = r10.d;
        r12.i(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x02dd:
        r0 = r10.c;
        r2 = r10.d;
        r12.h(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x02e8:
        r0 = r10.c;
        r2 = r10.d;
        r12.h(r0, r2);
        r10.d = r1;
        r0 = r10.c;
        r2 = r10.d;
        r12.i(r0, r2);
        goto L_0x0102;
    L_0x02fa:
        r10.a(r3, r12);
        goto L_0x0102;
    L_0x02ff:
        r10.a(r7, r12);
        goto L_0x0102;
    L_0x0304:
        r0 = r10.c;
        r2 = r10.d;
        r12.j(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x030f:
        r10.b();
        r0 = r10.d;
        if (r0 <= 0) goto L_0x031d;
    L_0x0316:
        r0 = r10.c;
        r2 = r10.d;
        r12.f(r0, r2);
    L_0x031d:
        r10.d = r1;
        r0 = r10.c;
        r2 = r10.d;
        r12.k(r0, r2);
        goto L_0x0102;
    L_0x0328:
        a(r11, r3);
        r0 = r10.n;
        r0 = r0 + -1;
        r10.n = r0;
        goto L_0x0102;
    L_0x0333:
        r0 = r10.d;
        if (r0 <= 0) goto L_0x033d;
    L_0x0337:
        r0 = r10.d;
        r0 = r0 + -1;
        r10.d = r0;
    L_0x033d:
        r0 = r10.c;
        r2 = r10.d;
        r12.g(r0, r2);
        r10.d = r1;
        goto L_0x0102;
    L_0x0348:
        r12.b();
        return;
    L_0x034c:
        r3 = r0;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.weex.component.richtext.a.e.a(java.io.Reader, com.uc.weex.component.richtext.a.i):void");
    }

    private void b() {
        this.l = this.n;
        this.k = this.m;
    }

    public final void a() {
        this.b = 10;
    }

    private void a(int i, i iVar) throws IOException, SAXException {
        if (this.d >= this.c.length - 20) {
            if (this.a == 28 || this.a == 10) {
                iVar.g(this.c, this.d);
                this.d = 0;
            } else {
                Object obj = new char[(this.c.length * 2)];
                System.arraycopy(this.c, 0, obj, 0, this.d + 1);
                this.c = obj;
            }
        }
        char[] cArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        cArr[i2] = (char) i;
    }
}
