package com.bumptech.glide.b.b;

import android.os.Handler.Callback;
import android.os.Message;
import com.bumptech.glide.f.h;

/* compiled from: ProGuard */
final class ah implements Callback {
    ah() {
    }

    public final boolean handleMessage(Message message) {
        ai aiVar = (ai) message.obj;
        switch (message.what) {
            case 1:
                aiVar.b.a();
                if (!aiVar.o) {
                    if (!aiVar.a.isEmpty()) {
                        if (!aiVar.j) {
                            aiVar.m = new an(aiVar.h, aiVar.f);
                            aiVar.j = true;
                            aiVar.m.e();
                            aiVar.c.a(aiVar.e, aiVar.m);
                            for (h hVar : aiVar.a) {
                                if (!aiVar.b(hVar)) {
                                    aiVar.m.e();
                                    hVar.a(aiVar.m, aiVar.i);
                                }
                            }
                            aiVar.m.f();
                            aiVar.c();
                            break;
                        }
                        throw new IllegalStateException("Already have resource");
                    }
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                aiVar.h.d();
                aiVar.c();
                break;
            case 2:
                aiVar.d();
                break;
            case 3:
                aiVar.b.a();
                if (aiVar.o) {
                    aiVar.c.a(aiVar, aiVar.e);
                    aiVar.c();
                    break;
                }
                throw new IllegalStateException("Not cancelled");
            default:
                throw new IllegalStateException("Unrecognized message: " + message.what);
        }
        return true;
    }
}
