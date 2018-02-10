package com.uc.quark.filedownloader.networkstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class FileDownloadNetworkStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            List arrayList = new ArrayList(a.a.a);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                WeakReference weakReference = (WeakReference) arrayList.get(i);
                if (weakReference != null) {
                    c cVar = (c) weakReference.get();
                    if (cVar != null) {
                        cVar.h();
                    }
                }
            }
        }
    }
}
