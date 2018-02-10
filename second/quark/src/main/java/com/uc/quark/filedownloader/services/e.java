package com.uc.quark.filedownloader.services;

import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.quark.ad;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.h;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.n;

/* compiled from: ProGuard */
class e implements f {
    private volatile Object a = new Object();
    private final i b;
    private final ad c;
    private final l d;

    public e(int i) {
        u a = n.a.a();
        this.b = ac.a;
        this.c = a.a();
        this.d = new l(h.a().e, i);
    }

    public synchronized void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, boolean z4, String str3) {
        int a = b.a(str, str2, z);
        com.uc.quark.filedownloader.model.b a2 = this.b.a(a);
        if (!z && a2 == null) {
            a2 = this.b.a(b.a(str, b.i(str2), true));
            if (a2 != null) {
                if (str2.equals(a2.a()) && j.a) {
                    j.d(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(a), Integer.valueOf(r3));
                }
            }
        }
        if (!com.uc.quark.filedownloader.e.e.a(a, a2, this, true, z4)) {
            String a3;
            if (a2 != null) {
                a3 = a2.a();
            } else {
                a3 = b.a(str2, z, null);
            }
            if (!com.uc.quark.filedownloader.e.e.a(a, a3, z2, true, z4, true)) {
                com.uc.quark.filedownloader.model.b bVar;
                Object obj;
                if (a2 == null || !(a2.f == (byte) -2 || a2.f == (byte) -1)) {
                    if (a2 == null) {
                        bVar = new com.uc.quark.filedownloader.model.b();
                    } else {
                        bVar = a2;
                    }
                    bVar.b = str;
                    bVar.a(str2, z);
                    bVar.k = str3;
                    bVar.a = a;
                    bVar.g = 0;
                    bVar.a(0);
                    bVar.f = (byte) 1;
                    obj = 1;
                } else if (a2.a != a) {
                    this.b.b(a2.a);
                    a2.a = a;
                    a2.a(str2, z);
                    obj = 1;
                    bVar = a2;
                } else {
                    obj = null;
                    bVar = a2;
                }
                if (obj != null) {
                    this.b.a(bVar);
                }
                l lVar = this.d;
                Runnable adVar = new ad(this.c, this, bVar, this.b, i3, fileDownloadHeader, i2, i, z2, z3, z4);
                if (j.a) {
                    j.d(adVar, "On resume %d", Integer.valueOf(adVar.e));
                }
                adVar.b = true;
                adVar.c.b(adVar.a);
                adVar.a(adVar.a.f);
                synchronized (lVar.a) {
                    lVar.b.put(adVar.e, adVar);
                }
                lVar.c.execute(adVar);
                if (lVar.d >= SecExceptionCode.SEC_ERROR_SIGNATRUE) {
                    lVar.a();
                    lVar.d = 0;
                } else {
                    lVar.d++;
                }
            } else if (j.a) {
                j.d(this, "has already completed downloading %d", Integer.valueOf(a));
            }
        } else if (j.a) {
            j.d(this, "has already started download %d", Integer.valueOf(a));
        }
    }

    public boolean a(int i) {
        return a(this.b.a(i));
    }

    public boolean b(int i) {
        if (this.b.a(i) == null) {
            return false;
        }
        if (j.a) {
            j.d(this, "paused %d", Integer.valueOf(i));
        }
        l lVar = this.d;
        lVar.a();
        synchronized (lVar.a) {
            ad adVar = (ad) lVar.b.get(i);
            if (adVar != null) {
                adVar.d = true;
                adVar.g();
                boolean remove = lVar.c.remove(adVar);
                if (j.a) {
                    j.d(lVar, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            lVar.b.remove(i);
        }
        return true;
    }

    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.d.b() <= 0;
        }
        return z;
    }

    public boolean a(com.uc.quark.filedownloader.model.b bVar) {
        boolean z = false;
        synchronized (this.a) {
            if (bVar == null) {
            } else {
                boolean z2;
                boolean a = this.d.a(bVar.a);
                if (bVar.f < (byte) 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (a) {
                        z = true;
                    }
                } else if (a) {
                    z = true;
                } else {
                    j.b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(bVar.a), Byte.valueOf(bVar.f));
                }
            }
        }
        return z;
    }

    public boolean c(int i) {
        if (i == 0 || a(i)) {
            return false;
        }
        this.b.b(i);
        return true;
    }
}
