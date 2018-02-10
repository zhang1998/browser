package com.ucweb.login.b;

import android.util.Log;
import android.widget.Toast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendAuth.Req;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.ucweb.login.a.a;

/* compiled from: ProGuard */
public final class b implements a {
    private final a a = new a();

    public final void a() {
        if (com.ucweb.c.c.c.b.a()) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null);
            if (createWXAPI != null) {
                String str = com.ucweb.login.b.WEIXIN.d;
                createWXAPI.registerApp(str);
                BaseReq req = new Req();
                req.scope = "snsapi_userinfo";
                req.state = "wechat_sdk_state";
                createWXAPI.sendReq(req);
                Log.e("hjw-synv", "app id:" + str);
                return;
            }
            return;
        }
        Toast.makeText(com.ucweb.c.c.b.a(), com.ucweb.c.b.not_install_app, 0).show();
    }
}
