package com.uc.apollo.preload;

import android.os.RemoteException;
import com.UCMobile.Apollo.MediaPreload.IStatisticUploadListener;
import java.util.HashMap;

/* compiled from: ProGuard */
final class g implements IStatisticUploadListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final boolean onUpload(HashMap<String, String> hashMap) {
        try {
            return this.a.a(hashMap);
        } catch (RemoteException e) {
            return false;
        }
    }
}
