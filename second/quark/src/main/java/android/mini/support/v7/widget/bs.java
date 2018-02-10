package android.mini.support.v7.widget;

import android.mini.support.annotation.VisibleForTesting;
import android.mini.support.v4.d.b;
import android.mini.support.v4.d.c;
import android.mini.support.v4.d.f;

/* compiled from: ProGuard */
final class bs {
    @VisibleForTesting
    final b<bf, bq> a = new b();
    @VisibleForTesting
    final f<bf> b = new f();

    bs() {
    }

    final void a() {
        this.a.clear();
        f fVar = this.b;
        int i = fVar.e;
        Object[] objArr = fVar.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        fVar.e = 0;
        fVar.b = false;
    }

    final void a(bf bfVar, ar arVar) {
        bq bqVar = (bq) this.a.get(bfVar);
        if (bqVar == null) {
            bqVar = bq.a();
            this.a.put(bfVar, bqVar);
        }
        bqVar.b = arVar;
        bqVar.a |= 4;
    }

    final boolean a(bf bfVar) {
        bq bqVar = (bq) this.a.get(bfVar);
        return (bqVar == null || (bqVar.a & 1) == 0) ? false : true;
    }

    final ar a(bf bfVar, int i) {
        ar arVar = null;
        int a = this.a.a((Object) bfVar);
        if (a >= 0) {
            bq bqVar = (bq) this.a.c(a);
            if (!(bqVar == null || (bqVar.a & i) == 0)) {
                bqVar.a &= i ^ -1;
                if (i == 4) {
                    arVar = bqVar.b;
                } else if (i == 8) {
                    arVar = bqVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((bqVar.a & 12) == 0) {
                    this.a.d(a);
                    bq.a(bqVar);
                }
            }
        }
        return arVar;
    }

    final void a(long j, bf bfVar) {
        f fVar = this.b;
        int a = c.a(fVar.c, fVar.e, j);
        if (a >= 0) {
            fVar.d[a] = bfVar;
            return;
        }
        a ^= -1;
        if (a >= fVar.e || fVar.d[a] != f.a) {
            if (fVar.b && fVar.e >= fVar.c.length) {
                fVar.a();
                a = c.a(fVar.c, fVar.e, j) ^ -1;
            }
            if (fVar.e >= fVar.c.length) {
                int b = c.b(fVar.e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(fVar.c, 0, obj, 0, fVar.c.length);
                System.arraycopy(fVar.d, 0, obj2, 0, fVar.d.length);
                fVar.c = obj;
                fVar.d = obj2;
            }
            if (fVar.e - a != 0) {
                System.arraycopy(fVar.c, a, fVar.c, a + 1, fVar.e - a);
                System.arraycopy(fVar.d, a, fVar.d, a + 1, fVar.e - a);
            }
            fVar.c[a] = j;
            fVar.d[a] = bfVar;
            fVar.e++;
            return;
        }
        fVar.c[a] = j;
        fVar.d[a] = bfVar;
    }

    final void b(bf bfVar, ar arVar) {
        bq bqVar = (bq) this.a.get(bfVar);
        if (bqVar == null) {
            bqVar = bq.a();
            this.a.put(bfVar, bqVar);
        }
        bqVar.c = arVar;
        bqVar.a |= 8;
    }

    final void b(bf bfVar) {
        bq bqVar = (bq) this.a.get(bfVar);
        if (bqVar == null) {
            bqVar = bq.a();
            this.a.put(bfVar, bqVar);
        }
        r0.a |= 1;
    }

    final void c(bf bfVar) {
        bq bqVar = (bq) this.a.get(bfVar);
        if (bqVar != null) {
            bqVar.a &= -2;
        }
    }

    final void a(br brVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            bf bfVar = (bf) this.a.b(size);
            bq bqVar = (bq) this.a.d(size);
            if ((bqVar.a & 3) == 3) {
                brVar.a(bfVar);
            } else if ((bqVar.a & 1) != 0) {
                if (bqVar.b == null) {
                    brVar.a(bfVar);
                } else {
                    brVar.a(bfVar, bqVar.b, bqVar.c);
                }
            } else if ((bqVar.a & 14) == 14) {
                brVar.b(bfVar, bqVar.b, bqVar.c);
            } else if ((bqVar.a & 12) == 12) {
                brVar.c(bfVar, bqVar.b, bqVar.c);
            } else if ((bqVar.a & 4) != 0) {
                brVar.a(bfVar, bqVar.b, null);
            } else if ((bqVar.a & 8) != 0) {
                brVar.b(bfVar, bqVar.b, bqVar.c);
            } else {
                int i = bqVar.a;
            }
            bq.a(bqVar);
        }
    }

    final void d(bf bfVar) {
        bq bqVar;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            if (bfVar == this.b.a(b)) {
                f fVar = this.b;
                if (fVar.d[b] != f.a) {
                    fVar.d[b] = f.a;
                    fVar.b = true;
                }
                bqVar = (bq) this.a.remove(bfVar);
                if (bqVar != null) {
                    bq.a(bqVar);
                }
            }
        }
        bqVar = (bq) this.a.remove(bfVar);
        if (bqVar != null) {
            bq.a(bqVar);
        }
    }
}
