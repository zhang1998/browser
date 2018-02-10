package android.support.v7.widget;

import android.support.annotation.VisibleForTesting;
import android.support.v4.d.b;
import android.support.v4.d.e;

/* compiled from: ProGuard */
final class au {
    @VisibleForTesting
    final b<bh, a> a = new b();
    @VisibleForTesting
    final e<bh> b = new e();

    au() {
    }

    final void a() {
        this.a.clear();
        e eVar = this.b;
        int i = eVar.e;
        Object[] objArr = eVar.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        eVar.e = 0;
        eVar.b = false;
    }

    final void a(bh bhVar, m mVar) {
        a aVar = (a) this.a.get(bhVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(bhVar, aVar);
        }
        aVar.b = mVar;
        aVar.a |= 4;
    }

    final boolean a(bh bhVar) {
        a aVar = (a) this.a.get(bhVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    final m a(bh bhVar, int i) {
        m mVar = null;
        int a = this.a.a((Object) bhVar);
        if (a >= 0) {
            a aVar = (a) this.a.c(a);
            if (!(aVar == null || (aVar.a & i) == 0)) {
                aVar.a &= i ^ -1;
                if (i == 4) {
                    mVar = aVar.b;
                } else if (i == 8) {
                    mVar = aVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.a & 12) == 0) {
                    this.a.d(a);
                    a.a(aVar);
                }
            }
        }
        return mVar;
    }

    final void a(long j, bh bhVar) {
        this.b.a(j, bhVar);
    }

    final void b(bh bhVar, m mVar) {
        a aVar = (a) this.a.get(bhVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(bhVar, aVar);
        }
        aVar.c = mVar;
        aVar.a |= 8;
    }

    final void b(bh bhVar) {
        a aVar = (a) this.a.get(bhVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(bhVar, aVar);
        }
        r0.a |= 1;
    }

    final void c(bh bhVar) {
        a aVar = (a) this.a.get(bhVar);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    final void a(p pVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            bh bhVar = (bh) this.a.b(size);
            a aVar = (a) this.a.d(size);
            if ((aVar.a & 3) == 3) {
                pVar.a(bhVar);
            } else if ((aVar.a & 1) != 0) {
                if (aVar.b == null) {
                    pVar.a(bhVar);
                } else {
                    pVar.a(bhVar, aVar.b, aVar.c);
                }
            } else if ((aVar.a & 14) == 14) {
                pVar.b(bhVar, aVar.b, aVar.c);
            } else if ((aVar.a & 12) == 12) {
                pVar.c(bhVar, aVar.b, aVar.c);
            } else if ((aVar.a & 4) != 0) {
                pVar.a(bhVar, aVar.b, null);
            } else if ((aVar.a & 8) != 0) {
                pVar.b(bhVar, aVar.b, aVar.c);
            } else {
                int i = aVar.a;
            }
            a.a(aVar);
        }
    }

    final void d(bh bhVar) {
        a aVar;
        for (int a = this.b.a() - 1; a >= 0; a--) {
            if (bhVar == this.b.b(a)) {
                e eVar = this.b;
                if (eVar.d[a] != e.a) {
                    eVar.d[a] = e.a;
                    eVar.b = true;
                }
                aVar = (a) this.a.remove(bhVar);
                if (aVar != null) {
                    a.a(aVar);
                }
            }
        }
        aVar = (a) this.a.remove(bhVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
