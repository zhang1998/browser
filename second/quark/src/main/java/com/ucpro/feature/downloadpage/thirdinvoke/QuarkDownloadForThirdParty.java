package com.ucpro.feature.downloadpage.thirdinvoke;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.uc.framework.resources.r;
import com.ucpro.feature.downloadpage.a.l;
import com.ucpro.services.download.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.i.f;
import java.util.List;

/* compiled from: ProGuard */
public class QuarkDownloadForThirdParty extends Activity {
    protected void onCreate(@Nullable Bundle bundle) {
        Object obj = null;
        super.onCreate(bundle);
        e.b();
        e.a((Context) this);
        r.a(getApplicationContext());
        Intent intent = getIntent();
        Object action = intent == null ? null : intent.getAction();
        if (intent != null) {
            obj = intent.getType();
        }
        if ("android.intent.action.SEND".equals(action) && r0 != null && "text/plain".equals(r0)) {
            List l = f.l(intent.getStringExtra("android.intent.extra.TEXT"));
            if (l.size() > 0) {
                String str = (String) l.get(0);
                if (!TextUtils.isEmpty(str)) {
                    l cVar = new c(this, this, new a(this, str), b.c(), b.b());
                    cVar.setOnDismissListener(new b(this));
                    cVar.show();
                }
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        e.b();
    }
}
