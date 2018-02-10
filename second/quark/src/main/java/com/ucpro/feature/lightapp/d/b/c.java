package com.ucpro.feature.lightapp.d.b;

import android.webkit.ValueCallback;
import com.uc.encrypt.f;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
public final class c implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ b b;

    public c(b bVar, ValueCallback valueCallback) {
        this.b = bVar;
        this.a = valueCallback;
    }

    public final void run() {
        boolean z = true;
        synchronized (b.b) {
            if (this.b.a != null) {
                this.a.onReceiveValue(this.b.a.b);
            } else if (a.h(b.d())) {
                r2 = null;
                File file = new File(b.d());
                if (file.exists()) {
                    byte[] e = a.e(file);
                    if (e != null) {
                        r2 = new h();
                        r2.a(f.b(e, com.uc.encrypt.a.b));
                    }
                }
                r4 = new StringBuilder("UserToken file is exist in user data dir\nstart to read\nUserTolen path in user data dir is: ").append(b.d()).append("\nSuccess: ");
                if (r2 == null) {
                    z = false;
                }
                r4.append(String.valueOf(z));
                if (r2 != null) {
                    this.b.a = r2;
                    m.a(2, new g(this));
                } else {
                    m.a(2, new e(this));
                    a.c(b.d());
                }
            } else {
                new StringBuilder("UserToken file is not exist in user data dir\nget UserToken from assets\nUserToken path in assets is: ").append("lightapp/dXNlcnRva2V1");
                r2 = a.a("lightapp/dXNlcnRva2V1", this.b.c);
                r4 = new StringBuilder("UserToken file is not exist in user data dir\nget UserToken from assets\nSuccess: ");
                if (r2 == null) {
                    z = false;
                }
                r4.append(String.valueOf(z));
                if (r2 != null) {
                    this.b.a = r2;
                    new StringBuilder("UserToken is: ").append(this.b.a.b);
                    m.a(2, new d(this));
                    a.a(this.b.a, b.d());
                } else {
                    m.a(2, new f(this));
                }
            }
        }
    }
}
