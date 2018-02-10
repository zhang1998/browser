package com.bumptech.glide.b.c;

import android.support.v4.d.q;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
final class aw<Model, Data> implements aq<Model, Data> {
    private final List<aq<Model, Data>> a;
    private final q<List<Exception>> b;

    aw(List<aq<Model, Data>> list, q<List<Exception>> qVar) {
        this.a = list;
        this.b = qVar;
    }

    public final ap<Data> a(Model model, int i, int i2, m mVar) {
        int size = this.a.size();
        List arrayList = new ArrayList(size);
        int i3 = 0;
        i iVar = null;
        while (i3 < size) {
            i iVar2;
            aq aqVar = (aq) this.a.get(i3);
            if (aqVar.a(model)) {
                ap a = aqVar.a(model, i, i2, mVar);
                if (a != null) {
                    iVar2 = a.a;
                    arrayList.add(a.c);
                    i3++;
                    iVar = iVar2;
                }
            }
            iVar2 = iVar;
            i3++;
            iVar = iVar2;
        }
        return !arrayList.isEmpty() ? new ap(iVar, new av(arrayList, this.b)) : null;
    }

    public final boolean a(Model model) {
        for (aq a : this.a) {
            if (a.a(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray(new aq[this.a.size()])) + '}';
    }
}
