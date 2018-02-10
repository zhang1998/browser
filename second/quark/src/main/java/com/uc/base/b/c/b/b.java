package com.uc.base.b.c.b;

import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.base.b.c.c.a;
import com.uc.base.b.c.e;
import com.uc.base.b.c.k;
import com.uc.base.b.c.m;
import com.uc.webview.export.extension.UCCore;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: ProGuard */
public final class b {
    private static ThreadLocal<byte[]> a = new a();

    protected static byte[] a(m mVar) {
        Closeable kVar;
        IOException e;
        Throwable th;
        try {
            byte[] bArr = new byte[b(mVar)];
            kVar = new k(bArr);
            try {
                a((k) kVar, mVar);
                a.a(kVar);
                return bArr;
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("statCreateSyncData()>>").append(e.toString());
                    a.a(kVar);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a.a(kVar);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            kVar = null;
            new StringBuilder("statCreateSyncData()>>").append(e.toString());
            a.a(kVar);
            return null;
        } catch (Throwable th3) {
            th = th3;
            kVar = null;
            a.a(kVar);
            throw th;
        }
    }

    private static void a(k kVar, m mVar) throws IOException {
        int q = mVar.q();
        for (int i = 0; i < q; i++) {
            e h = mVar.h(i);
            if (h != null && h.o()) {
                int i2 = h.a;
                int d;
                long e;
                switch (h.b) {
                    case 1:
                        d = h.d();
                        a(i2, 0, kVar);
                        a(d, kVar);
                        break;
                    case 2:
                        d = h.d();
                        a(i2, 0, kVar);
                        a(d, kVar);
                        break;
                    case 3:
                        d = h.d();
                        a(i2, 0, kVar);
                        a(a(d), kVar);
                        break;
                    case 4:
                    case 5:
                        b(i2, h.d(), kVar);
                        break;
                    case 6:
                        e = h.e();
                        a(i2, 0, kVar);
                        a(e, kVar);
                        break;
                    case 7:
                        e = h.e();
                        a(i2, 0, kVar);
                        a(e, kVar);
                        break;
                    case 8:
                        e = h.e();
                        a(i2, 0, kVar);
                        a(a(e), kVar);
                        break;
                    case 9:
                    case 10:
                        a(i2, h.e(), kVar);
                        break;
                    case 11:
                        boolean j = h.j();
                        a(i2, 0, kVar);
                        a(j ? 1 : 0, kVar);
                        break;
                    case 12:
                        a(i2, h.m(), kVar);
                        break;
                    case 13:
                        a(i2, h.m(), kVar);
                        break;
                    case 14:
                        a(i2, Double.doubleToRawLongBits(h.f()), kVar);
                        break;
                    case 15:
                        b(i2, Float.floatToRawIntBits(h.h()), kVar);
                        break;
                    case 50:
                        m mVar2 = (m) h;
                        if (!mVar2.b()) {
                            int b = b(mVar2);
                            a(i2, 2, kVar);
                            a(b, kVar);
                            a(kVar, mVar2);
                            break;
                        }
                        a(kVar, mVar2);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static int a(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private static long a(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private static void a(long j, k kVar) throws IOException {
        while ((-128 & j) != 0) {
            kVar.write((((int) j) & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) | 128);
            j >>>= 7;
        }
        kVar.write((int) j);
    }

    private static void b(int i, int i2, k kVar) throws IOException {
        a(i, 5, kVar);
        kVar.writeByte(i2 & 255);
        kVar.writeByte((i2 >> 8) & 255);
        kVar.writeByte((i2 >> 16) & 255);
        kVar.writeByte((i2 >> 24) & 255);
    }

    private static void a(int i, long j, k kVar) throws IOException {
        a(i, 1, kVar);
        kVar.write(((int) j) & 255);
        kVar.write(((int) (j >> 8)) & 255);
        kVar.write(((int) (j >> 16)) & 255);
        kVar.write(((int) (j >> 24)) & 255);
        kVar.write(((int) (j >> 32)) & 255);
        kVar.write(((int) (j >> 40)) & 255);
        kVar.write(((int) (j >> 48)) & 255);
        kVar.write(((int) (j >> 56)) & 255);
    }

    private static void a(int i, byte[] bArr, k kVar) throws IOException {
        if (bArr != null) {
            a(i, 2, kVar);
            a(bArr.length, kVar);
            kVar.write(bArr, 0, bArr.length);
        }
    }

    private static int b(m mVar) throws IOException {
        int q = mVar.q();
        int i = 0;
        int i2 = 0;
        while (i < q) {
            int d;
            e h = mVar.h(i);
            if (h != null && h.o()) {
                int i3;
                switch (h.b) {
                    case 1:
                        i3 = h.a;
                        d = h.d();
                        i3 = b(i3 << 3);
                        if (d < 0) {
                            d = 5;
                        } else {
                            d = b(d);
                        }
                        d = (d + i3) + i2;
                        continue;
                    case 2:
                        i3 = h.a;
                        d = h.d();
                        d = (b(d) + b(i3 << 3)) + i2;
                        continue;
                    case 3:
                        i3 = h.a;
                        d = h.d();
                        d = (b(a(d)) + b(i3 << 3)) + i2;
                        continue;
                    case 4:
                    case 5:
                    case 15:
                        d = (b(h.a << 3) + i2) + 4;
                        continue;
                    case 6:
                        d = (b(h.a << 3) + b(h.e())) + i2;
                        continue;
                    case 7:
                        d = (b(h.a << 3) + b(h.e())) + i2;
                        continue;
                    case 8:
                        d = (b(h.a << 3) + b(a(h.e()))) + i2;
                        continue;
                    case 9:
                    case 10:
                    case 14:
                        d = (b(h.a << 3) + i2) + 8;
                        continue;
                    case 11:
                        d = (b(h.a << 3) + i2) + 1;
                        continue;
                    case 12:
                    case 13:
                        i3 = h.a;
                        byte[] m = h.m();
                        if (m == null) {
                            d = 0;
                        } else {
                            d = m.length;
                            d += b(i3 << 3) + b(d);
                        }
                        d += i2;
                        continue;
                    case 50:
                        int i4 = h.a;
                        m mVar2 = (m) h;
                        i3 = b(mVar2);
                        if (mVar2.b()) {
                            d = i3;
                        } else {
                            d = (b(i4 << 3) + b(i3)) + i3;
                        }
                        d += i2;
                        continue;
                }
            }
            d = i2;
            i++;
            i2 = d;
        }
        return i2;
    }

    private static int b(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((SectionHeader.SHF_MASKPROC & i) == 0) {
            return 4;
        }
        return 5;
    }

    private static int b(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    private static void a(int i, k kVar) throws IOException {
        int i2 = 4;
        if ((SectionHeader.SHT_LOUSER & i) == 0) {
            byte[] bArr = (byte[]) a.get();
            bArr[0] = (byte) (i | 128);
            if (i >= 128) {
                bArr[1] = (byte) ((i >> 7) | 128);
                if (i >= 16384) {
                    bArr[2] = (byte) ((i >> 14) | 128);
                    if (i >= 2097152) {
                        bArr[3] = (byte) ((i >> 21) | 128);
                        if (i >= MediaPlayer.MEDIA_ERROR_UNKNOWN) {
                            bArr[4] = (byte) (i >> 28);
                            i2 = 5;
                        } else {
                            bArr[3] = (byte) (bArr[3] & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK);
                        }
                    } else {
                        bArr[2] = (byte) (bArr[2] & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK);
                        i2 = 3;
                    }
                } else {
                    bArr[1] = (byte) (bArr[1] & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK);
                    i2 = 2;
                }
            } else {
                bArr[0] = (byte) (bArr[0] & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK);
                i2 = 1;
            }
            kVar.write(bArr, 0, i2);
            return;
        }
        while ((((long) i) & -128) != 0) {
            kVar.write((i & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) | 128);
            i >>>= 7;
        }
        kVar.write(i);
    }

    private static void a(int i, int i2, k kVar) throws IOException {
        a((i << 3) | i2, kVar);
    }
}
