package com.uc.a.d;

import com.uc.a.b.h;
import com.uc.a.n;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.c.a;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ n b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ m e;

    r(m mVar, byte[] bArr, n nVar, int i, int i2) {
        this.e = mVar;
        this.a = bArr;
        this.b = nVar;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        h hVar;
        int i = 0;
        Object obj = this.a;
        if (obj == null || obj.length == 0) {
            hVar = null;
        } else {
            if (obj.length >= 16) {
                if (obj.length == 16) {
                    hVar = new h();
                } else {
                    int i2;
                    byte b;
                    c hVar2;
                    Object obj2;
                    int i3;
                    byte[] bArr;
                    int i4;
                    Object obj3;
                    c cVar;
                    d dVar = new d(new byte[][]{new byte[]{(byte) 0, (byte) 92}});
                    if (obj != null && obj.length >= 16 && dVar.c != null) {
                        i2 = 0;
                        while (i2 < dVar.c.length) {
                            byte b2 = dVar.c[i2][0];
                            b = dVar.c[i2][1];
                            if (b2 < (byte) 0 || b2 >= (byte) 16) {
                                i2 = 0;
                                break;
                            } else if (obj[b2] == b) {
                                i2++;
                            }
                        }
                        i2 = 1;
                        if (i2 != 0) {
                            hVar2 = new h();
                            if (!(obj == null || obj.length == 0)) {
                                if (obj.length <= 16) {
                                    if (obj != null || obj.length <= dVar.a) {
                                        b = (byte) 0;
                                    } else {
                                        b = obj[dVar.a];
                                    }
                                    if (obj != null || obj.length <= dVar.b) {
                                        i2 = 0;
                                    } else if (obj[dVar.b] == (byte) 1) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    obj2 = new byte[(obj.length - 16)];
                                    System.arraycopy(obj, 16, obj2, 0, obj2.length);
                                    i3 = i2;
                                    bArr = obj2;
                                    i4 = i3;
                                } else {
                                    i4 = 0;
                                    b = (byte) 0;
                                    obj3 = obj;
                                }
                                if (bArr != null || bArr.length == 0) {
                                    bArr = null;
                                } else {
                                    if (b != (byte) 0) {
                                        switch (b) {
                                            case (byte) 1:
                                            case (byte) 11:
                                                bArr = com.uc.a.c.a(bArr, (byte) 2);
                                                break;
                                            case (byte) 31:
                                                bArr = com.uc.a.c.a(bArr, (byte) 10);
                                                break;
                                        }
                                        if (bArr == null) {
                                            bArr = null;
                                        }
                                    }
                                    if (i4 != 0) {
                                        bArr = a.a(bArr);
                                    }
                                }
                                if (bArr != null) {
                                    i = hVar2.a(bArr);
                                }
                            }
                            if (i != 0) {
                                cVar = hVar2;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        hVar2 = new h();
                        if (obj.length <= 16) {
                            i4 = 0;
                            b = (byte) 0;
                            obj3 = obj;
                        } else {
                            if (obj != null) {
                            }
                            b = (byte) 0;
                            if (obj != null) {
                            }
                            i2 = 0;
                            obj2 = new byte[(obj.length - 16)];
                            System.arraycopy(obj, 16, obj2, 0, obj2.length);
                            i3 = i2;
                            bArr = obj2;
                            i4 = i3;
                        }
                        if (bArr != null) {
                        }
                        bArr = null;
                        if (bArr != null) {
                            i = hVar2.a(bArr);
                        }
                        if (i != 0) {
                            cVar = hVar2;
                        }
                    }
                }
            }
            hVar = null;
        }
        h.b(new ab(this, hVar));
    }
}
