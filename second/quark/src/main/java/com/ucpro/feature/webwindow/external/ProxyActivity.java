package com.ucpro.feature.webwindow.external;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public class ProxyActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || intent.getAction() == null) {
            finish();
        } else if ("com.uc.browser.action.CALL_PROXY_VIEW".equals(intent.getAction())) {
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    finish();
                    return;
                }
                intent = (Intent) extras.getParcelable("call_intent");
                if (intent != null) {
                    startActivity(intent);
                }
                finish();
            } catch (Throwable e) {
                c.a("fail", e);
            }
        } else {
            finish();
        }
    }
}
