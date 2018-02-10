package com.ucweb.login.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.connect.b.g;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.ucweb.b.a;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class LoginQQHelper extends Activity implements b {
    private d a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = d.a(com.ucweb.login.b.QQ.d, (Context) this);
        g gVar = this.a.a;
        new StringBuilder("isSessionValid(), result = ").append(gVar.a.a() ? "true" : "false");
        if (!gVar.a.a()) {
            d dVar = this.a;
            String str = ShareConstants.IGNORE_ALL_SYMBOLIC;
            g gVar2 = dVar.a;
            new StringBuilder("-->login activity: ").append(this);
            gVar2.a(this, str, this);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        StringBuilder append = new StringBuilder("onActivityResultData() reqcode = ").append(i).append(", resultcode = ").append(i2).append(", data = null ? ").append(intent == null).append(", listener = null ? ");
        if (this != null) {
            z = false;
        }
        append.append(z);
        com.tencent.connect.common.d.a().a(i, i2, intent, this);
    }

    public final void a(Object obj) {
        String str = "";
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            str2 = jSONObject.getString("openid");
            str = jSONObject.getString("access_token");
        } catch (Exception e) {
        }
        new StringBuilder("access_token:").append(str).append("|openid:").append(str2);
        a aVar = com.ucweb.b.b.a;
        if (aVar != null) {
            aVar.a(com.ucweb.login.b.QQ.d, com.ucweb.login.b.QQ.e, str, str2);
        }
        finish();
    }

    public final void a(com.tencent.tauth.a aVar) {
        a aVar2 = com.ucweb.b.b.a;
        if (aVar2 != null) {
            aVar2.a(aVar.a, aVar.b, aVar.c);
        }
        finish();
    }

    public final void a() {
        a aVar = com.ucweb.b.b.a;
        if (aVar != null) {
            aVar.a();
        }
        finish();
    }
}
