package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.message.MessageSnapshot;

/* compiled from: ProGuard */
public abstract class t extends m {
    public abstract void a(aa aaVar);

    public abstract void a(aa aaVar, int i);

    public abstract void a(aa aaVar, long j, long j2);

    public abstract void a(aa aaVar, Throwable th);

    public abstract void b(aa aaVar);

    public abstract void b(aa aaVar, long j, long j2);

    public abstract void c(aa aaVar);

    public abstract void c(aa aaVar, long j, long j2);

    public abstract void d(aa aaVar);

    public final boolean a(MessageSnapshot messageSnapshot) {
        aa aaVar;
        switch (messageSnapshot.i()) {
            case (byte) -5:
                aaVar = messageSnapshot.f;
                messageSnapshot.b();
                messageSnapshot.a();
                c(aaVar);
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
                c(messageSnapshot.f, messageSnapshot.b(), messageSnapshot.a());
                a();
                break;
            case (byte) -1:
                a(messageSnapshot.f, messageSnapshot.f());
                a();
                break;
            case (byte) 1:
                a(messageSnapshot.f, messageSnapshot.b(), messageSnapshot.a());
                break;
            case (byte) 2:
                aaVar = messageSnapshot.f;
                messageSnapshot.l();
                messageSnapshot.k();
                messageSnapshot.f.o();
                messageSnapshot.a();
                break;
            case (byte) 3:
                b(messageSnapshot.f, messageSnapshot.b(), messageSnapshot.f.q());
                break;
            case (byte) 4:
                aaVar = messageSnapshot.f;
                break;
            case (byte) 5:
                aaVar = messageSnapshot.f;
                messageSnapshot.f();
                messageSnapshot.h();
                messageSnapshot.b();
                break;
            case (byte) 6:
                aaVar = messageSnapshot.f;
                messageSnapshot.b();
                messageSnapshot.a();
                d(aaVar);
                break;
            case (byte) 7:
                a(messageSnapshot.f, messageSnapshot.g());
                break;
        }
        return false;
    }
}
