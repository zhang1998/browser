package com.tencent.tinker.c.a;

import com.alibaba.wireless.security.SecExceptionCode;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class ah implements Comparable<ah> {
    public final short a;
    public boolean b;
    public int c = 0;
    public int d = -1;
    public int e = 0;

    public final /* synthetic */ int compareTo(Object obj) {
        ah ahVar = (ah) obj;
        if (this.d == ahVar.d) {
            int a = a(this.a);
            int a2 = a(ahVar.a);
            if (a == a2) {
                return 0;
            }
            if (a >= a2) {
                return 1;
            }
            return -1;
        } else if (this.d < ahVar.d) {
            return -1;
        } else {
            return 1;
        }
    }

    public ah(int i, boolean z) {
        this.a = (short) i;
        this.b = z;
        if (i == 0) {
            this.d = 0;
            this.c = 1;
            this.e = SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        } else if (i == SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
            this.c = 1;
        }
    }

    public final boolean a() {
        return this.c > 0;
    }

    private static int a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                return 17;
            case 4097:
                return 8;
            case 4098:
                return 11;
            case 4099:
                return 10;
            case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                return 15;
            case 8193:
                return 14;
            case 8194:
                return 7;
            case 8195:
                return 13;
            case 8196:
                return 9;
            case 8197:
                return 16;
            case 8198:
                return 12;
            default:
                throw new IllegalArgumentException("unknown section type: " + i);
        }
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.a), Integer.valueOf(this.d), Integer.valueOf(this.c)});
    }
}
