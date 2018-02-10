package com.uc.base.b.c;

import android.util.Log;
import com.uc.base.b.b.a;
import com.uc.crashsdk.export.LogType;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;

/* compiled from: ProGuard */
final class h {
    private final String a = "BeanParser";
    private int[] b = null;
    private byte c = (byte) 0;
    private int d = 0;
    private int e = 0;
    private m f = null;

    h() {
    }

    public final m a(byte[] bArr) {
        Closeable byteArrayInputStream = new ByteArrayInputStream(bArr);
        Closeable dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            m mVar = this.f;
            a((DataInputStream) dataInputStream);
            a(dataInputStream, mVar, false, true, dataInputStream.readByte());
            return this.f;
        } catch (Throwable e) {
            Log.e("BeanParser", "bean parseFrom exception", e);
            a.a("javamodel parseFrom exception " + e.toString());
            return null;
        } finally {
            com.uc.base.b.c.c.a.a(byteArrayInputStream);
            com.uc.base.b.c.c.a.a(dataInputStream);
        }
    }

    private void a(DataInputStream dataInputStream) throws Exception {
        int i = 0;
        int readInt = dataInputStream.readInt();
        this.b = new int[readInt];
        if (readInt <= LogType.UNEXP) {
            this.c = (byte) 1;
            while (i < readInt) {
                int read = dataInputStream.read() & 255;
                this.b[read] = dataInputStream.readInt();
                i++;
            }
        } else if (readInt <= 65535) {
            this.c = (byte) 2;
            while (i < readInt) {
                r2 = dataInputStream.readInt();
                this.b[((dataInputStream.read() << 8) & 65280) | ((dataInputStream.read() << 0) & 255)] = r2;
                i++;
            }
        } else if (readInt <= 16777216) {
            this.c = (byte) 3;
            while (i < readInt) {
                r2 = dataInputStream.readInt();
                this.b[(((dataInputStream.read() << 16) & 16711680) | ((dataInputStream.read() << 8) & 65280)) | ((dataInputStream.read() << 0) & 255)] = r2;
                i++;
            }
        } else {
            this.c = (byte) 4;
            while (i < readInt) {
                r2 = dataInputStream.readInt();
                this.b[dataInputStream.readInt()] = r2;
                i++;
            }
        }
    }

    private byte a(DataInputStream dataInputStream, m mVar) throws Exception {
        return a(dataInputStream, mVar, false, false, (byte) 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte a(java.io.DataInputStream r19, com.uc.base.b.c.m r20, boolean r21, boolean r22, byte r23) throws java.lang.Exception {
        /*
        r18 = this;
        r12 = 0;
        r8 = 0;
        r14 = 0;
        r13 = 0;
        r9 = r23;
        r10 = r22;
    L_0x0008:
        if (r12 != 0) goto L_0x020c;
    L_0x000a:
        if (r10 != 0) goto L_0x0010;
    L_0x000c:
        r9 = r19.readByte();
    L_0x0010:
        r10 = 0;
        switch(r9) {
            case 0: goto L_0x0015;
            case 1: goto L_0x011f;
            case 2: goto L_0x021e;
            case 3: goto L_0x0014;
            case 4: goto L_0x0220;
            case 5: goto L_0x01b8;
            case 6: goto L_0x0014;
            case 7: goto L_0x0014;
            case 8: goto L_0x01ef;
            case 9: goto L_0x0014;
            case 10: goto L_0x01a3;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0008;
    L_0x0015:
        r6 = r19.read();
        r2 = r20.b();
        r3 = 0;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r3 = r19.readShort();
    L_0x0024:
        r2 = 0;
        switch(r6) {
            case 1: goto L_0x00a7;
            case 2: goto L_0x00a7;
            case 3: goto L_0x00a7;
            case 4: goto L_0x00a7;
            case 5: goto L_0x00a7;
            case 6: goto L_0x0028;
            case 7: goto L_0x0028;
            case 8: goto L_0x0028;
            case 9: goto L_0x00c9;
            case 10: goto L_0x00c9;
            case 11: goto L_0x00b8;
            case 12: goto L_0x002e;
            case 13: goto L_0x007e;
            case 14: goto L_0x00da;
            case 15: goto L_0x00eb;
            case 16: goto L_0x00fc;
            case 17: goto L_0x010d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = r20;
        r0.a(r2);
        goto L_0x0008;
    L_0x002e:
        r5 = r19.readShort();
        r2 = 0;
        if (r5 != 0) goto L_0x004d;
    L_0x0035:
        r4 = r19.readShort();
        if (r4 == 0) goto L_0x0041;
    L_0x003b:
        r5 = 1;
        if (r4 != r5) goto L_0x0041;
    L_0x003e:
        r2 = 0;
        r2 = new char[r2];
    L_0x0041:
        r7 = r2;
    L_0x0042:
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        if (r7 != 0) goto L_0x0077;
    L_0x0048:
        r7 = 0;
    L_0x0049:
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x004d:
        r2 = new char[r5];
        r4 = r5 * 2;
        r7 = new byte[r4];
        r4 = 0;
        r11 = r7.length;
        r0 = r19;
        r0.readFully(r7, r4, r11);
        r4 = 0;
    L_0x005b:
        if (r4 >= r5) goto L_0x021b;
    L_0x005d:
        r11 = r4 * 2;
        r15 = r7[r11];
        r15 = r15 << 8;
        r16 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r15 = r15 & r16;
        r11 = r11 + 1;
        r11 = r7[r11];
        r11 = r11 << 0;
        r11 = r11 & 255;
        r11 = r11 | r15;
        r11 = (char) r11;
        r2[r4] = r11;
        r4 = r4 + 1;
        goto L_0x005b;
    L_0x0077:
        r11 = new java.lang.String;
        r11.<init>(r7);
        r7 = r11;
        goto L_0x0049;
    L_0x007e:
        r4 = r19.readInt();
        r2 = 0;
        if (r4 != 0) goto L_0x009e;
    L_0x0085:
        r4 = r19.readInt();
        if (r4 == 0) goto L_0x0091;
    L_0x008b:
        r5 = 1;
        if (r4 != r5) goto L_0x0091;
    L_0x008e:
        r2 = 0;
        r2 = new byte[r2];
    L_0x0091:
        r7 = r2;
    L_0x0092:
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = com.uc.base.b.c.c.a(r7);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x009e:
        r2 = new byte[r4];
        r0 = r19;
        r0.readFully(r2);
        r7 = r2;
        goto L_0x0092;
    L_0x00a7:
        r7 = r19.readInt();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Integer.valueOf(r7);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x00b8:
        r7 = r19.readBoolean();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x00c9:
        r16 = r19.readLong();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Long.valueOf(r16);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x00da:
        r16 = r19.readDouble();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Double.valueOf(r16);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x00eb:
        r7 = r19.readFloat();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Float.valueOf(r7);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x00fc:
        r7 = r19.readShort();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = java.lang.Short.valueOf(r7);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x010d:
        r11 = r19.readByte();
        r2 = new com.uc.base.b.c.e;
        r4 = 0;
        r5 = 1;
        r7 = new java.lang.Byte;
        r7.<init>(r11);
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x0028;
    L_0x011f:
        if (r21 == 0) goto L_0x0169;
    L_0x0121:
        if (r8 != 0) goto L_0x0218;
    L_0x0123:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r2;
    L_0x0129:
        r2 = 0;
        r0 = r18;
        r1 = r19;
        r6 = r0.a(r1, r2);
        r0 = r18;
        r2 = r0.e;
        r2 = r2 + 1;
        r0 = r18;
        r0.e = r2;
        r2 = 8;
        r0 = r18;
        r1 = r19;
        r4 = r0.a(r1, r6);
        if (r2 != r4) goto L_0x0222;
    L_0x0148:
        r2 = 8;
        r4 = 1;
        r5 = r4;
        r4 = r2;
    L_0x014d:
        r2 = r3.isEmpty();
        if (r2 != 0) goto L_0x0161;
    L_0x0153:
        r2 = r3.size();
        r2 = r2 + -1;
        r2 = r3.get(r2);
        r2 = (com.uc.base.b.c.m) r2;
        r6.g = r2;
    L_0x0161:
        r3.add(r6);
        r8 = r3;
        r9 = r4;
        r10 = r5;
        goto L_0x0008;
    L_0x0169:
        if (r20 != 0) goto L_0x019e;
    L_0x016b:
        r2 = 0;
    L_0x016c:
        r0 = r18;
        r1 = r19;
        r2 = r0.a(r1, r2);
        if (r20 == 0) goto L_0x017b;
    L_0x0176:
        r0 = r20;
        r0.a(r2);
    L_0x017b:
        r0 = r18;
        r3 = r0.e;
        r3 = r3 + 1;
        r0 = r18;
        r0.e = r3;
        r3 = 8;
        r0 = r18;
        r1 = r19;
        r2 = r0.a(r1, r2);
        if (r3 != r2) goto L_0x0194;
    L_0x0191:
        r9 = 8;
        r10 = 1;
    L_0x0194:
        r0 = r18;
        r2 = r0.e;
        if (r2 != 0) goto L_0x0216;
    L_0x019a:
        r2 = 1;
    L_0x019b:
        r12 = r2;
        goto L_0x0008;
    L_0x019e:
        r2 = r20.b();
        goto L_0x016c;
    L_0x01a3:
        r2 = 1;
    L_0x01a4:
        r0 = r18;
        r3 = r0.e;
        r3 = r3 + -1;
        r0 = r18;
        r0.e = r3;
        r0 = r20;
        r1 = r18;
        r1.f = r0;
        r12 = 1;
        r13 = r2;
        goto L_0x0008;
    L_0x01b8:
        r6 = 1;
    L_0x01b9:
        r0 = r18;
        r2 = r0.d;
        r2 = r2 + 1;
        r0 = r18;
        r0.d = r2;
        r11 = 8;
        r5 = 1;
        if (r6 == 0) goto L_0x01ed;
    L_0x01c8:
        r7 = 1;
    L_0x01c9:
        r2 = r18;
        r3 = r19;
        r4 = r20;
        r2 = r2.a(r3, r4, r5, r6, r7);
        if (r11 != r2) goto L_0x01d8;
    L_0x01d5:
        r9 = 8;
        r10 = 1;
    L_0x01d8:
        if (r20 == 0) goto L_0x01e3;
    L_0x01da:
        r0 = r18;
        r2 = r0.f;
        r0 = r20;
        r0.a(r2);
    L_0x01e3:
        r0 = r18;
        r2 = r0.d;
        if (r2 != 0) goto L_0x0213;
    L_0x01e9:
        r12 = 1;
        r14 = r6;
        goto L_0x0008;
    L_0x01ed:
        r7 = 0;
        goto L_0x01c9;
    L_0x01ef:
        r0 = r18;
        r2 = r0.d;
        r2 = r2 + -1;
        r0 = r18;
        r0.d = r2;
        r2 = r8.size();
        r2 = r2 + -1;
        r2 = r8.get(r2);
        r2 = (com.uc.base.b.c.m) r2;
        r0 = r18;
        r0.f = r2;
        r12 = 1;
        goto L_0x0008;
    L_0x020c:
        if (r13 == 0) goto L_0x0211;
    L_0x020e:
        r2 = 8;
    L_0x0210:
        return r2;
    L_0x0211:
        r2 = 0;
        goto L_0x0210;
    L_0x0213:
        r14 = r6;
        goto L_0x0008;
    L_0x0216:
        r2 = r12;
        goto L_0x019b;
    L_0x0218:
        r3 = r8;
        goto L_0x0129;
    L_0x021b:
        r7 = r2;
        goto L_0x0042;
    L_0x021e:
        r2 = r13;
        goto L_0x01a4;
    L_0x0220:
        r6 = r14;
        goto L_0x01b9;
    L_0x0222:
        r4 = r9;
        r5 = r10;
        goto L_0x014d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.b.c.h.a(java.io.DataInputStream, com.uc.base.b.c.m, boolean, boolean, byte):byte");
    }

    private m a(DataInputStream dataInputStream, boolean z) throws Exception {
        int read;
        int i = 0;
        switch (this.c) {
            case (byte) 1:
                read = dataInputStream.read();
                break;
            case (byte) 2:
                read = ((dataInputStream.read() << 8) & 65280) | ((dataInputStream.read() << 0) & 255);
                break;
            case (byte) 3:
                read = (((dataInputStream.read() << 16) & 16711680) | ((dataInputStream.read() << 8) & 65280)) | ((dataInputStream.read() << 0) & 255);
                break;
            case (byte) 4:
                read = dataInputStream.readInt();
                break;
            default:
                read = 0;
                break;
        }
        int i2 = this.b[read];
        if (!z) {
            i = dataInputStream.readShort();
        }
        if (i2 == 51) {
            return new m(i, null, 3, 51, dataInputStream.readInt());
        }
        return new m(i, null, 1, i2);
    }
}
