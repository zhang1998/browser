package com.uc.quark.filedownloader;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class ab implements Callback {
    private ab() {
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ((h) message.obj).b();
        } else if (message.what == 2) {
            ArrayList arrayList = (ArrayList) message.obj;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((h) it.next()).b();
            }
            arrayList.clear();
            ao.a().b();
        }
        return true;
    }
}
