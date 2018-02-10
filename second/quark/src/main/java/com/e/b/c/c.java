package com.e.b.c;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.analytics.a.af;
import com.e.b.b.c.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class c implements d {
    static int a = 0;

    public final void c() {
    }

    public final void d() {
    }

    public final void a(Activity activity) {
        if (a == 0) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    String scheme = data.getScheme();
                    if (scheme != null && scheme.startsWith("ut.")) {
                        String queryParameter = data.getQueryParameter("debugkey");
                        String queryParameter2 = data.getQueryParameter("from");
                        if (scheme == null || !scheme.startsWith("ut.")) {
                            af.c(null, "scheme", scheme);
                            return;
                        }
                        Map hashMap = new HashMap();
                        hashMap.put("debug_api_url", "http://muvp.alibaba-inc.com/online/UploadRecords.do");
                        hashMap.put("debug_key", queryParameter);
                        hashMap.put("from", queryParameter2);
                        hashMap.put("debug_sampling_option", "true");
                        a.a();
                        a.a(hashMap);
                        return;
                    }
                    return;
                }
                af.c(null, "uri", data);
                return;
            }
            af.c(null, "i ", intent);
        }
    }

    public final void b(Activity activity) {
    }

    public final void c(Activity activity) {
        a--;
    }

    public final void d(Activity activity) {
        a++;
    }
}
