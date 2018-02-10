package com.uc.base.wa.e;

import com.uc.base.wa.t;
import com.uc.base.wa.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class g implements u {
    private int[] a;
    private int[] b;

    private g() {
        this.a = new int[]{0};
        this.b = new int[]{0};
    }

    public final void a(int i, t tVar) {
        if (i == 1) {
            this.a[0] = 0;
            this.b[0] = 0;
            i.a(i.b(), e.a(), this.a, this.b);
        } else if (i != 2 || !tVar.a()) {
        } else {
            if (this.a[0] != 0 || this.b[0] != 0) {
                String valueOf = String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
                Map hashMap = new HashMap();
                hashMap.put("tm", valueOf);
                hashMap.put("sv_lostsec", String.valueOf(this.a[0]));
                hashMap.put("sv_lostses", String.valueOf(this.b[0]));
                tVar.a(hashMap);
            }
        }
    }
}
