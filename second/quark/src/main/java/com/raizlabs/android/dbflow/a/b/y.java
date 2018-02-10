package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.a.a;
import com.raizlabs.android.dbflow.a.b.a.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class y extends a {
    private final List<b> e = new ArrayList();
    private List<String> f = new ArrayList();
    private final b g;

    @NonNull
    public static y a(b... bVarArr) {
        return new y("COUNT", bVarArr);
    }

    private y(String str, b... bVarArr) {
        super(null, null);
        this.g = new a(i.a(str).a());
        if (bVarArr.length == 0) {
            this.e.add(a.a);
            return;
        }
        for (Object obj : bVarArr) {
            String str2 = ",";
            if (this.e.size() == 1 && this.e.get(0) == a.a) {
                this.e.remove(0);
            }
            this.e.add(obj);
            this.f.add(str2);
        }
    }

    @NonNull
    public final i b() {
        if (this.d == null) {
            String a = this.g.a();
            if (a == null) {
                a = "";
            }
            String str = a + "(";
            List list = this.e;
            for (int i = 0; i < list.size(); i++) {
                b bVar = (b) list.get(i);
                if (i > 0) {
                    str = str + ((String) this.f.get(i)) + " ";
                }
                str = str + bVar.toString();
            }
            this.d = i.a(str + ")").a();
        }
        return this.d;
    }
}
