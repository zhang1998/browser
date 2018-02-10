package com.tencent.a.b;

import android.os.Bundle;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class a extends Thread {
    final /* synthetic */ b a;
    private final /* synthetic */ Bundle b;

    a(b bVar, Bundle bundle) {
        this.a = bVar;
        this.b = bundle;
    }

    public final void run() {
        try {
            b.a(this.a, p.c(k.a(this.a.d, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", SpdyRequest.GET_METHOD, this.b).a));
        } catch (Exception e) {
        }
        this.a.g = 0;
    }
}
