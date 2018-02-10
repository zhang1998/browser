package com.g.b.a.b.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.g.b.a.b.a;
import com.g.b.a.b.d;

/* compiled from: ProGuard */
public final class c {
    public a a;
    public b b;
    public Activity c;
    int d;
    public String e;
    ServiceConnection f = new a(this);
    private d g;

    public c(Activity activity, d dVar) {
        this.c = activity;
        this.g = dVar;
    }

    public final void a(a aVar) {
        boolean z;
        String str = null;
        this.d = 32973;
        this.a = aVar;
        Context applicationContext = this.c.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.trim().equals("")) {
            str = "com.sina.weibo";
        }
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        intent.setPackage(str);
        if (applicationContext.bindService(intent, this.f, 1)) {
            z = true;
        } else {
            z = applicationContext.bindService(new Intent("com.sina.weibo.remotessoservice"), this.f, 1);
        }
        if (!z) {
            this.a.a(new com.g.b.a.c.a("SSO failed--Bind Service failed"));
        }
    }

    final boolean a(String str, String str2, int i) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.g.a.a);
        intent.putExtra("_weibo_command_type", 3);
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (!com.g.b.a.d.c.a(this.c, intent)) {
            return false;
        }
        if (32974 == i) {
            try {
                intent.putExtra("com.sina.weibo.intent.extra.REQUEST_CODE", 32974);
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
        this.c.startActivityForResult(intent, this.d);
        return true;
    }
}
