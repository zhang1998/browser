package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.b.b;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public final class ab {
    public static int a(a aVar) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            int a = aVar.a() & 255;
            i3 |= (a & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << (i * 7);
            i2 <<= 7;
            i++;
            if ((a & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((a & 128) == 128) {
            throw new v("invalid LEB128 sequence");
        } else if (((i2 >> 1) & i3) != 0) {
            return i3 | i2;
        } else {
            return i3;
        }
    }

    public static int b(a aVar) {
        int i = 0;
        int i2 = 0;
        do {
            int a = aVar.a() & 255;
            i2 |= (a & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << (i * 7);
            i++;
            if ((a & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((a & 128) != 128) {
            return i2;
        }
        throw new v("invalid LEB128 sequence");
    }

    public static int c(a aVar) {
        return b(aVar) - 1;
    }

    public static int a(b bVar, int i) {
        int i2 = 0;
        for (int i3 = i >>> 7; i3 != 0; i3 >>>= 7) {
            bVar.a((byte) ((i & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) | 128));
            i2++;
            i = i3;
        }
        bVar.a((byte) (i & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK));
        return i2 + 1;
    }

    public static int b(b bVar, int i) {
        return a(bVar, i + 1);
    }

    public static int c(b bVar, int i) {
        int i2 = i >> 7;
        int i3 = (SectionHeader.SHT_LOUSER & i) == 0 ? 0 : -1;
        int i4 = 0;
        Object obj = 1;
        int i5 = i2;
        while (obj != null) {
            if (i5 == i3 && (i5 & 1) == ((i >> 6) & 1)) {
                obj = null;
            } else {
                obj = 1;
            }
            int i6 = i & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK;
            if (obj != null) {
                i2 = 128;
            } else {
                i2 = 0;
            }
            bVar.a((byte) (i2 | i6));
            i = i5;
            i5 >>= 7;
            i4++;
        }
        return i4;
    }
}
