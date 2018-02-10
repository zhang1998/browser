package com.ucweb.c.c.d;

import android.widget.Toast;
import com.ucweb.c.c.d.a.b;

/* compiled from: ProGuard */
public final class a implements com.ucweb.c.a.a {
    private b a = new b(com.ucweb.c.c.b.a());

    public final void a(com.ucweb.c.b.b bVar) {
        boolean a;
        b bVar2 = this.a;
        if (bVar2.b != null) {
            a = bVar2.b.a();
        } else {
            a = false;
        }
        if (a) {
            this.a.b();
        } else {
            Toast.makeText(com.ucweb.c.c.b.a(), com.ucweb.c.b.not_install_app, 0).show();
        }
    }
}
