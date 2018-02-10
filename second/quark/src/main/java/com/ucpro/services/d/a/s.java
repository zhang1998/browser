package com.ucpro.services.d.a;

import android.util.Log;
import com.ucpro.c.b;
import com.ucpro.c.c;
import com.ucweb.common.util.n.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class s implements j {
    static final boolean a = b.b();
    h b;
    private Map<String, k> c;

    public static s a() {
        return r.a;
    }

    private s() {
        this.b = new c(this);
        this.c = new HashMap();
    }

    public final void a(String str, k kVar) {
        if (a) {
            new StringBuilder("==registerListener, resCode: ").append(str).append(" listener: ").append(kVar);
        }
        if (kVar != null && !a.a(str) && ((k) this.c.get(str)) == null) {
            this.c.put(str, kVar);
            com.ucpro.business.e.a.a.a().a(str, this.b);
        }
    }

    public static String b() {
        return c.a().getAbsolutePath() + "/cms/";
    }

    public final void a(int i, String str, String str2) {
        if (a) {
            new StringBuilder("==onResReady, updateType: ").append(i).append(" resCode: ").append(str).append(" jsonData: ").append(str2);
        }
        k kVar = (k) this.c.get(str);
        if (kVar != null) {
            kVar.a(i, str, str2);
        } else if (a) {
            Log.w("CmsService", "Has no ICmsListener for resCode: " + str);
        }
    }
}
