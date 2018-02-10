package com.bumptech.glide.b.b;

import android.util.Log;
import com.bumptech.glide.b.a.e;
import com.bumptech.glide.b.d.f.d;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class q<DataType, ResourceType, Transcode> {
    final d<ResourceType, Transcode> a;
    private final Class<DataType> b;
    private final List<? extends n<DataType, ResourceType>> c;
    private final android.support.v4.d.q<List<Exception>> d;
    private final String e;

    public q(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends n<DataType, ResourceType>> list, d<ResourceType, Transcode> dVar, android.support.v4.d.q<List<Exception>> qVar) {
        this.b = cls;
        this.c = list;
        this.a = dVar;
        this.d = qVar;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    final au<ResourceType> a(e<DataType> eVar, int i, int i2, m mVar) throws ap {
        List list = (List) this.d.a();
        try {
            au<ResourceType> a = a(eVar, i, i2, mVar, list);
            return a;
        } finally {
            this.d.a(list);
        }
    }

    private au<ResourceType> a(e<DataType> eVar, int i, int i2, m mVar, List<Exception> list) throws ap {
        au<ResourceType> auVar = null;
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) this.c.get(i3);
            try {
                au<ResourceType> a;
                if (nVar.a(eVar.a(), mVar)) {
                    a = nVar.a(eVar.a(), i, i2, mVar);
                } else {
                    a = auVar;
                }
                auVar = a;
            } catch (IOException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    new StringBuilder("Failed to decode data for ").append(nVar);
                }
                list.add(e);
            }
            if (auVar != null) {
                break;
            }
        }
        if (auVar != null) {
            return auVar;
        }
        throw new ap(this.e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.b + ", decoders=" + this.c + ", transcoder=" + this.a + '}';
    }
}
