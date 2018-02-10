package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: ProGuard */
public final class ec implements eu {
    public int a;
    public int b;
    public long c;
    long d = 0;
    long e = 0;
    Context f;
    private final int g = 3600000;
    private int h;

    public ec(Context context) {
        this.f = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        this.a = sharedPreferences.getInt("successful_request", 0);
        this.b = sharedPreferences.getInt("failed_requests ", 0);
        this.h = sharedPreferences.getInt("last_request_spent_ms", 0);
        this.c = sharedPreferences.getLong("last_request_time", 0);
        this.d = sharedPreferences.getLong("last_req", 0);
    }

    public final boolean a() {
        boolean z;
        if (this.c == 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (fi.a(this.f).e()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    public final void b() {
        this.f.getSharedPreferences("umeng_general_config", 0).edit().putInt("successful_request", this.a).putInt("failed_requests ", this.b).putInt("last_request_spent_ms", this.h).putLong("last_request_time", this.c).putLong("last_req", this.d).commit();
    }

    public final void c() {
        this.d = System.currentTimeMillis();
    }

    public final void d() {
        this.h = (int) (System.currentTimeMillis() - this.d);
    }

    public final void e() {
        this.a++;
        this.c = this.d;
    }

    public final void f() {
        this.b++;
    }
}
