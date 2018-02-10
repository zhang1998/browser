package com.uc.base.wa.e;

import android.util.Log;
import com.uc.base.wa.e;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
public final class f implements Runnable {
    final /* synthetic */ Callable a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ String g;
    final /* synthetic */ List h;
    final /* synthetic */ String i;
    final /* synthetic */ e j;
    final /* synthetic */ i k;

    public f(i iVar, Callable callable, String str, int i, String str2, int i2, int i3, String str3, List list, String str4, e eVar) {
        this.k = iVar;
        this.a = callable;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = i2;
        this.f = i3;
        this.g = str3;
        this.h = list;
        this.i = str4;
        this.j = eVar;
    }

    public final void run() {
        HashMap hashMap;
        try {
            HashMap hashMap2;
            if (this.a != null) {
                hashMap2 = (HashMap) this.a.call();
            } else {
                hashMap2 = null;
            }
            hashMap = hashMap2;
        } catch (Throwable e) {
            Log.e("gzm_SessionService", "", e);
            hashMap = null;
        }
        this.k.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, hashMap, this.i, this.j);
    }
}
