package com.taobao.weex.b.d;

import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.p;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public class f extends p {
    private b a;
    private c d;
    private c e;
    private c f;
    private c g;
    private a h = new e(this);

    @JSMethod
    public void WebSocket(String str, String str2) {
        if (this.a != null) {
            int i = d.CLOSE_GOING_AWAY.o;
            d.CLOSE_GOING_AWAY.name();
        }
        this.a = ac.f();
        d();
    }

    @JSMethod
    public void send(String str) {
        d();
    }

    @JSMethod
    public void close(String str, String str2) {
        if (!d()) {
            int i = d.CLOSE_NORMAL.o;
            if (str != null) {
                try {
                    Integer.parseInt(str);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    @JSMethod
    public void onopen(c cVar) {
        this.d = cVar;
    }

    @JSMethod
    public void onmessage(c cVar) {
        this.e = cVar;
    }

    @JSMethod
    public void onclose(c cVar) {
        this.f = cVar;
    }

    @JSMethod
    public void onerror(c cVar) {
        this.g = cVar;
    }

    public final void a() {
        this.h = null;
    }

    private boolean d() {
        if (this.a != null) {
            return false;
        }
        if (this.h != null) {
            this.h.a("No implementation found for IWebSocketAdapter");
        }
        WXLogUtils.e("WebSocketModule", "No implementation found for IWebSocketAdapter");
        return true;
    }
}
