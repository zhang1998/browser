package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.util.Log;
import java.util.List;

/* compiled from: ProGuard */
final class l extends d<List<MediaItem>> {
    final /* synthetic */ f d;
    final /* synthetic */ String e;
    final /* synthetic */ Bundle f;
    final /* synthetic */ MediaBrowserServiceCompat g;

    l(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, f fVar, String str, Bundle bundle) {
        this.g = mediaBrowserServiceCompat;
        this.d = fVar;
        this.e = str;
        this.f = bundle;
        super(obj);
    }

    final /* synthetic */ void a(int i) {
        List list = null;
        if (this.g.b.get(this.d.c.a()) == this.d) {
            List list2;
            if ((i & 1) != 0) {
                Bundle bundle = this.f;
                int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (!(i2 == -1 && i3 == -1)) {
                    int i4 = i3 * (i2 - 1);
                    int i5 = i4 + i3;
                    if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                        list2 = list;
                        this.d.c.a(this.e, list2, this.f);
                    }
                    if (i5 > list.size()) {
                        i5 = list.size();
                    }
                    list2 = list.subList(i4, i5);
                    this.d.c.a(this.e, list2, this.f);
                }
            }
            list2 = list;
            try {
                this.d.c.a(this.e, list2, this.f);
            } catch (RemoteException e) {
                Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + this.e + " package=" + this.d.a);
            }
        }
    }
}
