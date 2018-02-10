package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AssistActivity extends Activity {
    protected Handler a = new b(this);
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    protected void onCreate(Bundle bundle) {
        int i;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(3);
        if (getIntent() == null) {
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra("openSDK_LOG.AssistActivity.ExtraIntent");
        if (intent == null) {
            i = 0;
        } else {
            i = intent.getIntExtra("key_request_code", 0);
        }
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.b = bundle.getBoolean("RESTART_FLAG");
        }
        if (!this.b && bundleExtra == null) {
            if (intent == null) {
                finish();
            } else if (intent.getComponent() != null) {
                this.c = false;
                startActivityForResult(intent, i);
            } else {
                this.c = true;
                this.d = false;
                startActivity(intent);
            }
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!(intent.getBooleanExtra("is_qq_mobile_share", false) || !this.b || isFinishing())) {
                finish();
            }
            if (this.c && this.d) {
                this.a.sendMessageDelayed(this.a.obtainMessage(0), 200);
            }
        }
    }

    protected void onPause() {
        if (this.c) {
            if (this.d) {
                this.a.removeMessages(0);
            } else {
                this.d = true;
            }
        }
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("key_action", "action_share");
        setResult(-1, intent);
        if (!isFinishing()) {
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("RESTART_FLAG", true);
        super.onSaveInstanceState(bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        new StringBuilder("--onActivityResult--requestCode: ").append(i).append(" | resultCode: ").append(i2).append("data = null ? ").append(intent == null);
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra("key_action", "action_login");
            }
            if (intent == null) {
                setResult(0, intent);
            } else {
                try {
                    Object stringExtra = intent.getStringExtra("key_response");
                    if (TextUtils.isEmpty(stringExtra)) {
                        setResult(-1, intent);
                    } else {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        CharSequence optString = jSONObject.optString("openid");
                        CharSequence optString2 = jSONObject.optString("access_token");
                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                            setResult(0, intent);
                        } else {
                            setResult(-1, intent);
                        }
                    }
                } catch (Exception e) {
                }
            }
            finish();
        }
    }
}
