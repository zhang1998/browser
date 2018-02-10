package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.e.b;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class h<T> {
    public j<T> a = new j();
    public Map<Class<?>, Integer> b = new HashMap();

    public final boolean a(List<Class<?>> list) {
        if (list.size() <= 0) {
            return false;
        }
        this.b.clear();
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Class) list.get(i)).getFields().length - 1;
            this.b.put(list.get(i), Integer.valueOf(i));
        }
        j jVar = this.a;
        if (10 < r6) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 <= 0) {
                return false;
            }
            x xVar = new x();
            xVar.a = -1;
            xVar.b = -1;
            int[] iArr2 = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr2[i3] = 1 << i3;
            }
            xVar.c = iArr2;
            jVar.d.add(xVar);
        }
        jVar.g = true;
        return true;
    }

    public final boolean a(b... bVarArr) {
        if (bVarArr.length <= 0) {
            return false;
        }
        int length = bVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bVarArr[i].a();
        }
        j jVar = this.a;
        if (!jVar.g) {
            return false;
        }
        if (iArr.length != jVar.d.size()) {
            throw new IllegalArgumentException("funciton setState(...) must request " + jVar.d.size() + " args");
        }
        for (length = 0; length < iArr.length; length++) {
            int i2 = iArr[length];
            if (i2 < 0 || !j.a(i2)) {
                return false;
            }
            ((x) jVar.d.get(length)).a = i2;
        }
        return true;
    }

    public final h<T> a(int... iArr) {
        j jVar = this.a;
        jVar.e = iArr;
        if (jVar.c == null) {
            jVar.c = new ArrayList();
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!jVar.c.contains(Integer.valueOf(iArr[i]))) {
                jVar.c.add(Integer.valueOf(iArr[i]));
            }
        }
        return this;
    }

    public final h<T> b(int... iArr) {
        j jVar = this.a;
        if (iArr.length != jVar.d.size()) {
            throw new IllegalArgumentException("function condition(...) must request " + jVar.d.size() + " args");
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                ((x) jVar.d.get(i)).b = jVar.b(i);
            } else {
                ((x) jVar.d.get(i)).b = iArr[i];
            }
        }
        return this;
    }

    public final h<T> a(T t) {
        j jVar = this.a;
        for (int i : jVar.e) {
            jVar.f = null;
            while (true) {
                int[] iArr;
                int[] iArr2;
                int length;
                if (jVar.f == null) {
                    jVar.f = new int[jVar.d.size()];
                    Arrays.fill(jVar.f, 0);
                    iArr = jVar.f;
                } else {
                    iArr2 = jVar.f;
                    if (iArr2.length != jVar.d.size()) {
                        throw new IllegalArgumentException("function increase(...) must request " + jVar.d.size() + " args");
                    }
                    int length2;
                    length = iArr2.length - 1;
                    while (length >= 0) {
                        int i2 = iArr2[length] + 1;
                        length2 = ((x) jVar.d.get(length)).c.length;
                        iArr2[length] = i2 % length2;
                        if (i2 < length2) {
                            break;
                        }
                        length--;
                    }
                    if (length >= 0) {
                        length2 = 1;
                    } else {
                        length2 = 0;
                    }
                    if (length2 != 0) {
                        iArr = jVar.f;
                    } else {
                        iArr = null;
                    }
                }
                if (iArr == null) {
                    break;
                }
                int i3 = 1;
                for (length = 0; length < iArr.length; length++) {
                    x xVar = (x) jVar.d.get(length);
                    i3 &= (xVar.b & xVar.c[iArr[length]]) != 0 ? 1 : 0;
                }
                if (i3 != 0) {
                    iArr2 = new int[iArr.length];
                    for (length = 0; length < iArr2.length; length++) {
                        iArr2[length] = ((x) jVar.d.get(length)).c[iArr[length]];
                    }
                    long a = jVar.a(i, iArr2);
                    if (jVar.a.containsKey(Long.valueOf(a))) {
                        c.a("the key has already exist, please check!!!");
                    }
                    jVar.a.put(Long.valueOf(a), t);
                }
            }
        }
        return this;
    }

    public final void a(v<T> vVar) {
        this.a.b = vVar;
    }
}
