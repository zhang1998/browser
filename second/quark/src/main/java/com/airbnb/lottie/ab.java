package com.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class ab<T> {
    @Nullable
    private final JSONObject a;
    private final float b;
    private final k c;
    private final ay<T> d;

    private ab(@Nullable JSONObject jSONObject, float f, k kVar, ay<T> ayVar) {
        this.a = jSONObject;
        this.b = f;
        this.c = kVar;
        this.d = ayVar;
    }

    static <T> ab<T> a(@Nullable JSONObject jSONObject, float f, k kVar, ay<T> ayVar) {
        return new ab(jSONObject, f, kVar, ayVar);
    }

    final ao<T> a() {
        Object opt;
        List list;
        if (this.a != null) {
            int i;
            JSONArray jSONArray;
            k kVar;
            float f;
            ay ayVar;
            int length;
            List arrayList;
            int i2;
            Object opt2 = this.a.opt("k");
            if (opt2 instanceof JSONArray) {
                opt = ((JSONArray) opt2).opt(0);
                if ((opt instanceof JSONObject) && ((JSONObject) opt).has("t")) {
                    i = 1;
                    if (i == 0) {
                        jSONArray = (JSONArray) opt2;
                        kVar = this.c;
                        f = this.b;
                        ayVar = this.d;
                        length = jSONArray.length();
                        if (length != 0) {
                            arrayList = new ArrayList();
                            for (i2 = 0; i2 < length; i2++) {
                                arrayList.add(bh.a(jSONArray.optJSONObject(i2), kVar, f, ayVar));
                            }
                            p.a(arrayList);
                            list = arrayList;
                        }
                    } else {
                        list = Collections.emptyList();
                    }
                    if (this.a != null) {
                        opt = null;
                    } else if (list.isEmpty()) {
                        opt = this.d.a(this.a.opt("k"), this.b);
                    } else {
                        opt = ((p) list.get(0)).a;
                    }
                    return new ao(list, opt);
                }
            }
            i = 0;
            if (i == 0) {
                list = Collections.emptyList();
            } else {
                jSONArray = (JSONArray) opt2;
                kVar = this.c;
                f = this.b;
                ayVar = this.d;
                length = jSONArray.length();
                if (length != 0) {
                    arrayList = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        arrayList.add(bh.a(jSONArray.optJSONObject(i2), kVar, f, ayVar));
                    }
                    p.a(arrayList);
                    list = arrayList;
                }
            }
            if (this.a != null) {
                opt = null;
            } else if (list.isEmpty()) {
                opt = this.d.a(this.a.opt("k"), this.b);
            } else {
                opt = ((p) list.get(0)).a;
            }
            return new ao(list, opt);
        }
        list = Collections.emptyList();
        if (this.a != null) {
            opt = null;
        } else if (list.isEmpty()) {
            opt = ((p) list.get(0)).a;
        } else {
            opt = this.d.a(this.a.opt("k"), this.b);
        }
        return new ao(list, opt);
    }
}
