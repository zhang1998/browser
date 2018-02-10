package com.ucweb.login.weibo;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.ucweb.login.b;

/* compiled from: ProGuard */
public final class a implements com.ucweb.login.a.a {
    private Activity a;

    public a(Activity activity) {
        this.a = activity;
    }

    public final void a() {
        if (com.g.b.a.a.a.a(this.a, b.WEIBO.d).a()) {
            this.a.startActivity(new Intent(this.a, LoginWeiboHelper.class));
            return;
        }
        Toast.makeText(this.a, com.ucweb.c.b.not_install_app, 0).show();
    }
}
