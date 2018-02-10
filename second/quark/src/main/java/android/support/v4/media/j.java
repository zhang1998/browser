package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class j implements n {
    final Messenger a;
    final /* synthetic */ MediaBrowserServiceCompat b;

    j(MediaBrowserServiceCompat mediaBrowserServiceCompat, Messenger messenger) {
        this.b = mediaBrowserServiceCompat;
        this.a = messenger;
    }

    public final IBinder a() {
        return this.a.getBinder();
    }

    public final void a(String str, Token token, Bundle bundle) throws RemoteException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 1);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putParcelable("data_media_session_token", token);
        bundle2.putBundle("data_root_hints", bundle);
        a(1, bundle2);
    }

    public final void b() throws RemoteException {
        a(2, null);
    }

    public final void a(String str, List<MediaItem> list, Bundle bundle) throws RemoteException {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putBundle("data_options", bundle);
        if (list != null) {
            String str2 = "data_media_item_list";
            if (list instanceof ArrayList) {
                list = (ArrayList) list;
            } else {
                Object arrayList = new ArrayList(list);
            }
            bundle2.putParcelableArrayList(str2, list);
        }
        a(3, bundle2);
    }

    private void a(int i, Bundle bundle) throws RemoteException {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        this.a.send(obtain);
    }
}
