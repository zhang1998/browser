package com.airbnb.lottie;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
/* compiled from: ProGuard */
final class l implements bo {
    final List<bo> a = new ArrayList();
    private final Path b = new Path();
    private final Path c = new Path();
    private final Path d = new Path();
    private final ak e;

    l(ak akVar) {
        if (VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.e = akVar;
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < this.a.size(); i++) {
            ((bo) this.a.get(i)).a(list, list2);
        }
    }

    public final Path b() {
        this.d.reset();
        switch (dq.a[this.e.a.ordinal()]) {
            case 1:
                for (int i = 0; i < this.a.size(); i++) {
                    this.d.addPath(((bo) this.a.get(i)).b());
                }
                break;
            case 2:
                a(Op.UNION);
                break;
            case 3:
                a(Op.REVERSE_DIFFERENCE);
                break;
            case 4:
                a(Op.INTERSECT);
                break;
            case 5:
                a(Op.XOR);
                break;
        }
        return this.d;
    }

    @TargetApi(19)
    private void a(Op op) {
        bo boVar;
        int i = 0;
        this.c.reset();
        this.b.reset();
        for (int size = this.a.size() - 1; size > 0; size--) {
            boVar = (bo) this.a.get(size);
            if (boVar instanceof au) {
                List c = ((au) boVar).c();
                for (int size2 = c.size() - 1; size2 >= 0; size2--) {
                    Path b = ((bo) c.get(size2)).b();
                    b.transform(((au) boVar).d());
                    this.c.addPath(b);
                }
            } else {
                this.c.addPath(boVar.b());
            }
        }
        boVar = (bo) this.a.get(0);
        if (boVar instanceof au) {
            List c2 = ((au) boVar).c();
            while (i < c2.size()) {
                Path b2 = ((bo) c2.get(i)).b();
                b2.transform(((au) boVar).d());
                this.b.addPath(b2);
                i++;
            }
        } else {
            this.b.set(boVar.b());
        }
        this.d.op(this.b, this.c, op);
    }
}
