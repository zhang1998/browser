package com.uc.quark.filedownloader;

import android.os.RemoteException;
import com.uc.quark.filedownloader.c.f;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import com.uc.quark.filedownloader.message.b;

/* compiled from: ProGuard */
public final class af extends f {
    protected af() {
    }

    public final void a(MessageSnapshot messageSnapshot) throws RemoteException {
        b.a.a(messageSnapshot, false);
    }
}
