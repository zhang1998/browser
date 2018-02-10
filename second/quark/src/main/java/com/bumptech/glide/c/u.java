package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.bumptech.glide.c;
import java.util.HashSet;

/* compiled from: ProGuard */
public final class u extends Fragment {
    final a a;
    private final HashSet<u> ad;
    @Nullable
    private u ae;
    final r b;
    @Nullable
    com.bumptech.glide.u c;
    @Nullable
    Fragment d;

    public u() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    private u(a aVar) {
        this.b = new t(this);
        this.ad = new HashSet();
        this.a = aVar;
    }

    private void q() {
        if (this.ae != null) {
            this.ae.ad.remove(this);
            this.ae = null;
        }
    }

    public final void a(Context context) {
        super.a(context);
        try {
            Context e = e();
            q();
            this.ae = c.a(e).f.a(e.b.a.e);
            if (this.ae != this) {
                this.ae.ad.add(this);
            }
        } catch (Throwable e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public final void a() {
        super.a();
        this.d = null;
        q();
    }

    public final void b() {
        super.b();
        this.a.a();
    }

    public final void c() {
        super.c();
        this.a.b();
    }

    public final void d() {
        super.d();
        this.a.c();
        q();
    }

    public final void onLowMemory() {
        super.onLowMemory();
        if (this.c != null) {
            this.c.d();
        }
    }

    public final String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        Object obj = this.z;
        if (obj == null) {
            obj = this.d;
        }
        return append.append(obj).append("}").toString();
    }
}
