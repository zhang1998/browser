package com.uc.quark;

import android.text.TextUtils;
import com.uc.quark.a.e;
import com.uc.quark.filedownloader.e.b;
import java.io.File;
import java.util.Map;

/* compiled from: ProGuard */
public final class n {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g = true;
    public boolean h;
    public boolean i;
    public String j = "";
    public String k = "";
    public boolean l = false;
    public boolean m = false;
    Map<String, String> n;
    public int o = 0;
    public long p = -1;

    public final y a() {
        byte b;
        if (TextUtils.isEmpty(this.a)) {
            b = (byte) 0;
        } else {
            if (TextUtils.isEmpty(this.d)) {
                this.d = e.a(this.a, this.c);
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = b.d() + File.separator + this.d;
            }
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            return null;
        }
        return new y();
    }
}
