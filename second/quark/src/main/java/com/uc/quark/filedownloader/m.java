package com.uc.quark.filedownloader;

import android.os.Handler;
import android.os.Looper;
import com.uc.quark.filedownloader.message.MessageSnapshot;

/* compiled from: ProGuard */
public abstract class m {
    private Handler a = new Handler(Looper.getMainLooper());
    private final Runnable b = new aq(this);

    public abstract void a(aa aaVar);

    public abstract void a(aa aaVar, int i);

    public abstract void a(aa aaVar, Throwable th);

    public abstract void b(aa aaVar);

    public boolean a(MessageSnapshot messageSnapshot) {
        aa aaVar;
        switch (messageSnapshot.i()) {
            case (byte) -5:
                aaVar = messageSnapshot.f;
                messageSnapshot.d();
                messageSnapshot.e();
                a();
                break;
            case (byte) -4:
                b(messageSnapshot.f);
                break;
            case (byte) -3:
                a(messageSnapshot.f);
                a();
                break;
            case (byte) -2:
                aaVar = messageSnapshot.f;
                messageSnapshot.d();
                messageSnapshot.e();
                a();
                break;
            case (byte) -1:
                a(messageSnapshot.f, messageSnapshot.f());
                a();
                break;
            case (byte) 1:
                aaVar = messageSnapshot.f;
                messageSnapshot.d();
                messageSnapshot.e();
                break;
            case (byte) 2:
                aaVar = messageSnapshot.f;
                messageSnapshot.l();
                messageSnapshot.k();
                aaVar = messageSnapshot.f;
                messageSnapshot.e();
                break;
            case (byte) 3:
                aaVar = messageSnapshot.f;
                messageSnapshot.d();
                aaVar = messageSnapshot.f;
                break;
            case (byte) 4:
                aaVar = messageSnapshot.f;
                break;
            case (byte) 5:
                aaVar = messageSnapshot.f;
                messageSnapshot.f();
                messageSnapshot.h();
                messageSnapshot.d();
                break;
            case (byte) 6:
                aaVar = messageSnapshot.f;
                messageSnapshot.d();
                messageSnapshot.e();
                break;
            case (byte) 7:
                a(messageSnapshot.f, messageSnapshot.g());
                break;
        }
        return false;
    }

    protected final void a() {
        this.a.removeCallbacks(this.b);
        this.a.postDelayed(this.b, 29800);
    }
}
