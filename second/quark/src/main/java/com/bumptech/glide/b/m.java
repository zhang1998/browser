package com.bumptech.glide.b;

import android.support.v4.d.b;
import android.support.v4.d.s;
import java.security.MessageDigest;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class m implements i {
    public final b<l<?>, Object> b = new b();

    public final void a(m mVar) {
        int i = 0;
        s sVar = this.b;
        s sVar2 = mVar.b;
        int i2 = sVar2.h;
        sVar.a(sVar.h + i2);
        if (sVar.h != 0) {
            while (i < i2) {
                sVar.put(sVar2.b(i), sVar2.c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(sVar2.f, 0, sVar.f, 0, i2);
            System.arraycopy(sVar2.g, 0, sVar.g, 0, i2 << 1);
            sVar.h = i2;
        }
    }

    public final <T> T a(l<T> lVar) {
        return this.b.containsKey(lVar) ? this.b.get(lVar) : lVar.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        return this.b.equals(((m) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        for (Entry entry : this.b.entrySet()) {
            l lVar = (l) entry.getKey();
            Object value = entry.getValue();
            k kVar = lVar.b;
            if (lVar.d == null) {
                lVar.d = lVar.c.getBytes(i.a);
            }
            kVar.a(lVar.d, value, messageDigest);
        }
    }

    public final String toString() {
        return "Options{values=" + this.b + '}';
    }
}
