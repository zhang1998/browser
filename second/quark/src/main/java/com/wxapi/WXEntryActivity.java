package com.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.ucweb.c.a.b;

/* compiled from: ProGuard */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = WXAPIFactory.createWXAPI(this, null);
        if (this.a != null) {
            this.a.registerApp(b.WECHAT_FRIENDS.i);
            this.a.handleIntent(getIntent(), this);
        }
        finish();
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.a != null) {
            this.a.handleIntent(intent, this);
        }
        finish();
    }

    public final void onReq(BaseReq baseReq) {
    }

    public final void onResp(BaseResp baseResp) {
        if (com.ucweb.e.b.a != null) {
            com.ucweb.e.b.a.a(baseResp);
        }
    }
}
