package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.ab;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.b.b;
import com.tencent.tinker.c.a.l;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
public final class h extends i<l> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        l lVar = (l) comparable;
        int[] iArr = lVar.b;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = fVar.a(iArr[i]);
        }
        byte[] bArr = lVar.c;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        a aVar = new com.tencent.tinker.b.a.c.a(fVar, byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        b bVar = new com.tencent.tinker.b.a.c.b(fVar, byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new l(lVar.i, lVar.a, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    ab.a(bVar, ab.b(aVar));
                    break;
                case 2:
                    ab.c(bVar, ab.a(aVar));
                    break;
                case 3:
                case 4:
                    ab.a(bVar, ab.b(aVar));
                    ab.b(bVar, fVar.a(ab.c(aVar)));
                    ab.b(bVar, fVar.b(ab.c(aVar)));
                    if (read != 4) {
                        break;
                    }
                    ab.b(bVar, fVar.a(ab.c(aVar)));
                    break;
                case 5:
                case 6:
                    ab.a(bVar, ab.b(aVar));
                    break;
                case 9:
                    ab.b(bVar, fVar.a(ab.c(aVar)));
                    break;
                default:
                    break;
            }
        }
    }

    public h(com.tencent.tinker.b.a.b.a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.o;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.m.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.o;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.A.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.a.b bVar) {
        return bVar.i();
    }
}
