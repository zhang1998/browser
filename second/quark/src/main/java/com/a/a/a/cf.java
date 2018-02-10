package com.a.a.a;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class cf extends Handler {
    private final WeakReference<bx> a;

    public cf(bx bxVar) {
        this.a = new WeakReference(bxVar);
    }

    public final void handleMessage(Message message) {
        if (this.a != null) {
            bx a;
            switch (message.what) {
                case 48:
                    sendEmptyMessageDelayed(48, ce.a(System.currentTimeMillis(), 1001));
                    a = bv.a;
                    try {
                        if (a.a.a.size() > 0) {
                            cl cjVar = new cj(a);
                            bs.a(br.a(ca.a).b(), a.a.a.values());
                            cjVar.a("success");
                            br.a(ca.a).c();
                        }
                    } catch (Exception e) {
                        fw.d("save agg data error");
                        br.a(ca.a).c();
                    } catch (Throwable th) {
                        fw.a("convertMemoryToCacheTable happen error: " + th.toString());
                        return;
                    }
                    if (a.b.a.size() > 0) {
                        ca.a(new ch(a), a.b.a);
                    }
                    if (a.d.size() > 0) {
                        ca.a(new cl(), a.d);
                        return;
                    }
                    return;
                case 49:
                    sendEmptyMessageDelayed(49, ce.a(System.currentTimeMillis(), 1002));
                    a = bv.a;
                    try {
                        if (a.a.a.size() > 0) {
                            bs.a(new by(a), br.a(ca.a).b(), a.a.a.values());
                            br.a(ca.a).c();
                        }
                    } catch (Exception e2) {
                        fw.d("cacheToData error");
                        br.a(ca.a).c();
                    } catch (Throwable th2) {
                        fw.a("converyMemoryToDataTable happen error: " + th2.toString());
                        return;
                    }
                    if (a.b.a.size() > 0) {
                        ca.a(new cc(a), a.b.a);
                    }
                    if (a.d.size() > 0) {
                        ca.a(new cl(), a.d);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
