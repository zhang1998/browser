package com.uc.base.wa;

import android.util.Log;
import com.uc.base.wa.a.c;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b implements d {
    private static b a = new b(1);
    private static b b = new b(2);
    private int c;

    public b() {
        this(1);
    }

    private b(int i) {
        this.c = i;
    }

    static d a() {
        return a;
    }

    public final String a(String str) {
        return null;
    }

    public final void a(a aVar, HashMap<String, String> hashMap, String str) {
        if (str != null) {
            aVar.a(hashMap, str);
        } else if (this.c == 1) {
            aVar.a(hashMap);
        } else if (this.c == 2) {
            aVar.c(hashMap);
        } else {
            Log.e("gzm_wa_WaEvent", "re-write genProtocolBodyData or re-use super.genProtocolBodyData", new Throwable());
            c.a().b("");
        }
    }

    public final void a(HashMap<String, Integer> hashMap) {
    }

    public final void b(HashMap<String, Integer> hashMap) {
    }
}
