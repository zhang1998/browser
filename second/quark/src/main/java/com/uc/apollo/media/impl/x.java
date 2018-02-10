package com.uc.apollo.media.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class x extends Handler {
    final /* synthetic */ v a;

    x(v vVar, Looper looper) {
        this.a = vVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int[] iArr = (int[]) message.obj;
                this.a.l = iArr[0];
                this.a.o = iArr[1];
                this.a.p = iArr[2];
                this.a.A = ((this.a.p - 96) / 24) - 1;
                if (this.a.A < 2) {
                    this.a.A = 2;
                }
                if (this.a.u != null) {
                    this.a.u.a(this.a.o, this.a.p);
                }
                this.a.r.a(this.a.j, this.a.o, this.a.p);
                this.a.b("onPD d/w/h " + f.b(this.a.l) + "/" + this.a.o + "/" + this.a.p);
                this.a.r.a(this.a.j, this.a.l, this.a.o, this.a.p);
                return;
            case 3:
                this.a.q = message.arg1;
                this.a.r.a(this.a.j);
                this.a.L();
                return;
            case 4:
                this.a.b("onError " + d.a(3, message.arg1, message.arg2));
                this.a.r.b(this.a.j, message.arg1, message.arg2);
                return;
            case 10:
                v vVar = this.a;
                vVar.q += SecExceptionCode.SEC_ERROR_SIGNATRUE;
                if (this.a.q >= this.a.l) {
                    this.a.b("onCompletion");
                    this.a.q = this.a.l;
                    this.a.r.b(this.a.j);
                    this.a.s = b.b;
                    return;
                }
                this.a.L();
                this.a.x.sendEmptyMessageDelayed(10, 600);
                return;
            default:
                return;
        }
    }
}
