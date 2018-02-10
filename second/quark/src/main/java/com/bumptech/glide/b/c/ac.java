package com.bumptech.glide.b.c;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.j;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: ProGuard */
public class ac implements i {
    @Nullable
    public URL b;
    private final ae c;
    @Nullable
    private final URL d;
    @Nullable
    private final String e;
    @Nullable
    private String f;
    @Nullable
    private volatile byte[] g;
    private int h;

    public ac(URL url) {
        this(url, ae.b);
    }

    public ac(String str) {
        this(str, ae.b);
    }

    private ac(URL url, ae aeVar) {
        this.d = (URL) j.a((Object) url, "Argument must not be null");
        this.e = null;
        this.c = (ae) j.a((Object) aeVar, "Argument must not be null");
    }

    private ac(String str, ae aeVar) {
        this.d = null;
        this.e = j.a(str);
        this.c = (ae) j.a((Object) aeVar, "Argument must not be null");
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f)) {
            String str = this.e;
            if (TextUtils.isEmpty(str)) {
                str = this.d.toString();
            }
            this.f = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f;
    }

    public final Map<String, String> b() {
        return this.c.a();
    }

    private String c() {
        return this.e != null ? this.e : this.d.toString();
    }

    public String toString() {
        return c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        if (c().equals(acVar.c()) && this.c.equals(acVar.c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.h == 0) {
            this.h = c().hashCode();
            this.h = (this.h * 31) + this.c.hashCode();
        }
        return this.h;
    }

    public final void a(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(a);
        }
        messageDigest.update(this.g);
    }
}
