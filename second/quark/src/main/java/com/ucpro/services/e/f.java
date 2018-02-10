package com.ucpro.services.e;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.ucweb.common.util.d;
import com.ucweb.common.util.j.a;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class f {
    static boolean a;
    private static boolean g;
    public WeakReference<Context> b;
    public a c;
    boolean d;
    Runnable e;
    public Runnable f;

    public static boolean a() {
        if (g) {
            return a;
        }
        g = true;
        boolean b = a.b(d.a(), "29076939917A5F78", "89DA0C8B436AFF56", true);
        a = b;
        return b;
    }

    private f() {
        this.e = new c(this);
        this.f = new b(this);
    }

    public final String b() {
        if (!a() || this.c == null) {
            return c();
        }
        return this.c.i;
    }

    public final void a(String str) {
        this.d = true;
        if (!a() || this.c == null) {
            b(str);
            return;
        }
        a aVar = this.c;
        if (str != null) {
            aVar.i = str;
            aVar.b = System.currentTimeMillis();
        }
    }

    public final String c() {
        String str = "";
        try {
            if (!(this.b == null || this.b.get() == null)) {
                ClipboardManager clipboardManager = (ClipboardManager) ((Context) this.b.get()).getSystemService("clipboard");
                if (clipboardManager != null && clipboardManager.hasText()) {
                    return str + clipboardManager.getText();
                }
            }
        } catch (Exception e) {
        }
        return str;
    }

    final void b(String str) {
        if (this.b != null && this.b.get() != null) {
            ClipboardManager clipboardManager = (ClipboardManager) ((Context) this.b.get()).getSystemService("clipboard");
            if (clipboardManager != null) {
                try {
                    clipboardManager.setText(str);
                } catch (Exception e) {
                }
            }
        }
    }

    public final void d() {
        if (a()) {
            a aVar = this.c;
            String b = aVar.e.b();
            String c = aVar.e.c();
            if (b != null) {
                if (!TextUtils.isEmpty(c)) {
                    CharSequence charSequence = aVar.f;
                    if (!TextUtils.isEmpty(charSequence) && !c.equals(charSequence)) {
                        aVar.f = c;
                    } else if (!(TextUtils.isEmpty(aVar.h) || c.equals(aVar.h))) {
                        aVar.h = null;
                        aVar.f = c;
                        if (!b.equals(c)) {
                            c = b;
                        }
                    }
                }
                c = b;
            }
            aVar.e.a(c);
        }
    }
}
