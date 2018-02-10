package com.ucpro;

import android.content.Intent;
import android.os.Bundle;
import com.ucpro.d.b;
import com.ucpro.d.e;
import com.ucpro.d.f;
import com.ucweb.common.util.d.d;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public class MainActivity extends BaseActivity {
    @DebugLog
    protected void onCreate(Bundle bundle) {
        Object obj;
        e.c();
        e.a("bmc0");
        super.onCreate(bundle);
        e.a("bmc1");
        b a = f.a;
        Intent intent = getIntent();
        if (a.a == null || a.a.get() == null || isTaskRoot() || !"android.intent.action.MAIN".equals(intent.getAction())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            Intent intent2;
            if (intent != null) {
                intent2 = new Intent(intent);
                intent2.setClass(this, BrowserActivity.class);
            } else {
                intent2 = new Intent(this, BrowserActivity.class);
            }
            startActivity(intent2);
        }
        e.a("bmc2");
        if (d.b()) {
            m.a(2, new a(this), 300);
        } else {
            finish();
        }
        e.a("bmc3");
    }
}
