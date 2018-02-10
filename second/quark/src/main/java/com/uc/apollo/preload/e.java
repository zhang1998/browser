package com.uc.apollo.preload;

import android.os.RemoteException;
import com.UCMobile.Apollo.MediaPreload.IPreloadListener;

/* compiled from: ProGuard */
final class e implements IPreloadListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onInfo(String str, int i, int i2) {
        try {
            this.a.a(str, i, i2);
        } catch (RemoteException e) {
        }
    }
}
