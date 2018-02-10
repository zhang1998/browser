package com.bumptech.glide.b.b;

import android.support.v4.d.q;
import com.bumptech.glide.b.a.e;
import com.bumptech.glide.b.m;
import com.bumptech.glide.util.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* compiled from: ProGuard */
public final class ar<Data, ResourceType, Transcode> {
    private final Class<Data> a;
    private final q<List<Exception>> b;
    private final List<? extends q<Data, ResourceType, Transcode>> c;
    private final String d;

    public ar(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<q<Data, ResourceType, Transcode>> list, q<List<Exception>> qVar) {
        this.a = cls;
        this.b = qVar;
        this.c = (List) j.a((Collection) list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final au<Transcode> a(e<Data> eVar, m mVar, int i, int i2, p<ResourceType> pVar) throws ap {
        List list = (List) this.b.a();
        try {
            au<Transcode> a = a(eVar, mVar, i, i2, pVar, list);
            return a;
        } finally {
            this.b.a(list);
        }
    }

    private au<Transcode> a(e<Data> eVar, m mVar, int i, int i2, p<ResourceType> pVar, List<Exception> list) throws ap {
        au<Transcode> a;
        int size = this.c.size();
        au<Transcode> auVar = null;
        int i3 = 0;
        while (i3 < size) {
            q qVar = (q) this.c.get(i3);
            try {
                a = qVar.a.a(pVar.a(qVar.a(eVar, i, i2, mVar)));
            } catch (ap e) {
                list.add(e);
                a = auVar;
            }
            if (a != null) {
                break;
            }
            i3++;
            auVar = a;
        }
        a = auVar;
        if (a != null) {
            return a;
        }
        throw new ap(this.d, new ArrayList(list));
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray(new q[this.c.size()])) + '}';
    }
}
