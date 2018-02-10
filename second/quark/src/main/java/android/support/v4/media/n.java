package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.List;

/* compiled from: ProGuard */
interface n {
    IBinder a();

    void a(String str, Token token, Bundle bundle) throws RemoteException;

    void a(String str, List<MediaItem> list, Bundle bundle) throws RemoteException;

    void b() throws RemoteException;
}
