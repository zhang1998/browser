package com.ucweb.login.qq;

import android.content.Intent;
import android.widget.Toast;
import com.ucweb.c.c.b;
import com.ucweb.c.c.b.a.c;

/* compiled from: ProGuard */
public final class a implements com.ucweb.login.a.a {
    public final void a() {
        if (c.a()) {
            b.a().startActivity(new Intent(b.a(), LoginQQHelper.class));
            return;
        }
        Toast.makeText(b.a(), com.ucweb.c.b.not_install_app, 0).show();
    }
}
