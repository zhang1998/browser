package com.alibaba.analytics.core.b;

import android.text.TextUtils;
import com.alibaba.analytics.a.ad;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.f;
import com.alibaba.analytics.a.z;
import com.alibaba.analytics.core.b;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class c implements Runnable {
    final /* synthetic */ h a;

    public c(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        String a = this.a.e;
        String a2 = z.a(b.a().b, "time_adjust_host");
        if (TextUtils.isEmpty(a2)) {
            a2 = a;
        }
        ad a3 = f.a(1, this.a.d + a2 + this.a.f, null);
        af.a("TimeStampAdjustMgr", "url", a2, "response", a3);
        if (a3.b != null) {
            try {
                JSONObject optJSONObject = new JSONObject(new String(a3.b, 0, a3.b.length)).optJSONObject("data");
                if (optJSONObject != null) {
                    Object optString = optJSONObject.optString("t");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            this.a.a = Long.parseLong(optString) - currentTimeMillis;
                            this.a.b = true;
                            af.a("TimeStampAdjustMgr", "t", optString, "now", Long.valueOf(currentTimeMillis), "diff", Long.valueOf(this.a.a));
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }
}
