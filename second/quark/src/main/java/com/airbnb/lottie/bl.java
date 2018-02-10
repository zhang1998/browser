package com.airbnb.lottie;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
abstract class bl<K, A> {
    final List<bq> a = new ArrayList();
    boolean b = false;
    float c = 0.0f;
    private final List<? extends p<K>> d;
    @Nullable
    private p<K> e;

    abstract A a(p<K> pVar, float f);

    bl(List<? extends p<K>> list) {
        this.d = list;
    }

    final void a(bq bqVar) {
        this.a.add(bqVar);
    }

    void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f2;
        if (this.d.isEmpty()) {
            f2 = 0.0f;
        } else {
            f2 = ((p) this.d.get(0)).a();
        }
        if (f < f2) {
            f = 0.0f;
        } else {
            if (f > (this.d.isEmpty() ? IPictureView.DEFAULT_MIN_SCALE : ((p) this.d.get(this.d.size() - 1)).b())) {
                f = IPictureView.DEFAULT_MIN_SCALE;
            }
        }
        if (f != this.c) {
            this.c = f;
            for (int i = 0; i < this.a.size(); i++) {
                ((bq) this.a.get(i)).a();
            }
        }
    }

    private p<K> b() {
        int i = 0;
        if (this.d.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        } else if (this.e != null && this.e.a(this.c)) {
            return this.e;
        } else {
            p<K> pVar = (p) this.d.get(0);
            if (this.c < pVar.a()) {
                this.e = pVar;
                return pVar;
            }
            while (!pVar.a(this.c) && i < this.d.size()) {
                pVar = (p) this.d.get(i);
                i++;
            }
            this.e = pVar;
            return pVar;
        }
    }

    public A a() {
        float f = 0.0f;
        p b = b();
        if (!this.b) {
            Object obj;
            p b2 = b();
            if (b2.c == null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                f = b2.c.getInterpolation((this.c - b2.a()) / (b2.b() - b2.a()));
            }
        }
        return a(b, f);
    }
}
