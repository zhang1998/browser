package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
class au implements bo, bq, cx {
    private static final String a = au.class.getSimpleName();
    private final Matrix b = new Matrix();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final List<de> e = new ArrayList();
    private final cu f;
    @Nullable
    private List<bo> g;
    @Nullable
    private cj h;

    au(cu cuVar, cz czVar, db dbVar) {
        this.f = cuVar;
        List list = dbVar.a;
        if (!list.isEmpty()) {
            Object obj = list.get(list.size() - 1);
            if (obj instanceof du) {
                this.h = ((du) obj).a();
                this.h.a(czVar);
                this.h.a((bq) this);
            }
            for (int i = 0; i < list.size(); i++) {
                obj = list.get(i);
                if (obj instanceof av) {
                    this.e.add(new y(cuVar, czVar, (av) obj));
                } else if (obj instanceof az) {
                    this.e.add(new dl(cuVar, czVar, (az) obj));
                } else if (obj instanceof bj) {
                    this.e.add(new cm(cuVar, czVar, (bj) obj));
                } else if (obj instanceof bw) {
                    this.e.add(new bt(cuVar, czVar, (bw) obj));
                } else if (obj instanceof db) {
                    this.e.add(new au(cuVar, czVar, (db) obj));
                } else if (obj instanceof u) {
                    this.e.add(new v(cuVar, czVar, (u) obj));
                } else if (obj instanceof dp) {
                    this.e.add(new cf(cuVar, czVar, (dp) obj));
                } else if (obj instanceof cw) {
                    this.e.add(new f(cuVar, czVar, (cw) obj));
                } else if (obj instanceof ce) {
                    this.e.add(new cr(cuVar, czVar, (ce) obj));
                } else if (obj instanceof dm) {
                    this.e.add(new bu(czVar, (dm) obj));
                } else if (obj instanceof ak) {
                    if (cuVar.m) {
                        this.e.add(new l((ak) obj));
                    } else {
                        Log.w(a, "Animation contains merge paths but they are disabled.");
                    }
                }
            }
            List arrayList = new ArrayList();
            l lVar = null;
            int size = this.e.size() - 1;
            while (size >= 0) {
                de deVar;
                de deVar2 = (de) this.e.get(size);
                if (deVar2 instanceof l) {
                    deVar = (l) deVar2;
                } else {
                    Object obj2 = lVar;
                }
                if (!(deVar == null || deVar2 == deVar)) {
                    if (deVar2 instanceof bo) {
                        deVar.a.add((bo) deVar2);
                    }
                    arrayList.add(deVar2);
                }
                size--;
                de deVar3 = deVar;
            }
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                if (arrayList.contains((de) it.next())) {
                    it.remove();
                }
            }
        }
    }

    public final void a() {
        this.f.invalidateSelf();
    }

    public final void a(List<de> list, List<de> list2) {
        List arrayList = new ArrayList(list.size() + this.e.size());
        arrayList.addAll(list);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            de deVar = (de) this.e.get(size);
            deVar.a(arrayList, this.e.subList(0, size));
            arrayList.add(deVar);
        }
    }

    final List<bo> c() {
        if (this.g == null) {
            this.g = new ArrayList();
            for (int i = 0; i < this.e.size(); i++) {
                de deVar = (de) this.e.get(i);
                if (deVar instanceof bo) {
                    this.g.add((bo) deVar);
                }
            }
        }
        return this.g;
    }

    final Matrix d() {
        if (this.h != null) {
            return this.h.a();
        }
        this.b.reset();
        return this.b;
    }

    public final Path b() {
        this.b.reset();
        if (this.h != null) {
            this.b.set(this.h.a());
        }
        this.c.reset();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            de deVar = (de) this.e.get(size);
            if (deVar instanceof bo) {
                this.c.addPath(((bo) deVar).b(), this.b);
            }
        }
        return this.c;
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.b.set(matrix);
        if (this.h != null) {
            this.b.preConcat(this.h.a());
            i = (int) ((((((float) ((Integer) this.h.a.a()).intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Object obj = this.e.get(size);
            if (obj instanceof cx) {
                ((cx) obj).a(canvas, this.b, i);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.b.set(matrix);
        if (this.h != null) {
            this.b.preConcat(this.h.a());
        }
        this.d.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            de deVar = (de) this.e.get(size);
            if (deVar instanceof cx) {
                ((cx) deVar).a(this.d, this.b);
                if (rectF.isEmpty()) {
                    rectF.set(this.d);
                } else {
                    rectF.set(Math.min(rectF.left, this.d.left), Math.min(rectF.top, this.d.top), Math.max(rectF.right, this.d.right), Math.max(rectF.bottom, this.d.bottom));
                }
            }
        }
    }
}
