package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.g;

/* compiled from: ProGuard */
final class s extends d<MediaItem> {
    final /* synthetic */ ResultReceiver d;
    final /* synthetic */ MediaBrowserServiceCompat e;

    s(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        this.e = mediaBrowserServiceCompat;
        this.d = resultReceiver;
        super(obj);
    }

    final /* synthetic */ void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", null);
        ResultReceiver resultReceiver = this.d;
        if (resultReceiver.a) {
            if (resultReceiver.b != null) {
                resultReceiver.b.post(new g(resultReceiver, 0, bundle));
            } else {
                resultReceiver.a(0, bundle);
            }
        } else if (resultReceiver.c != null) {
            try {
                resultReceiver.c.a(0, bundle);
            } catch (RemoteException e) {
            }
        }
    }
}
