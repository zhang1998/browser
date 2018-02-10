package com.ucpro.services.e;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ucweb.common.util.e;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class a {
    long a;
    long b;
    public boolean c;
    WeakReference<Context> d;
    public f e;
    String f;
    String g;
    public String h;
    String i;
    public Runnable j = new g(this);
    private Handler k;

    public a(f fVar, Context context) {
        this.d = new WeakReference(context);
        this.e = fVar;
        this.h = this.e.c();
        if (this.d != null && this.d.get() != null) {
            ClipboardManager clipboardManager = (ClipboardManager) ((Context) this.d.get()).getApplicationContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                try {
                    clipboardManager.addPrimaryClipChangedListener(new d(this));
                } catch (Exception e) {
                }
            }
        }
    }

    public final Handler a() {
        if (this.k == null) {
            this.k = new e(getClass().getName(), Looper.getMainLooper());
        }
        return this.k;
    }

    public final void b() {
        this.c = false;
        String b = this.e.b();
        if (b != null) {
            if (this.g != null && this.a > this.b) {
                b = this.g;
            }
            this.e.b(b);
            this.f = b;
            this.i = null;
        }
    }
}
