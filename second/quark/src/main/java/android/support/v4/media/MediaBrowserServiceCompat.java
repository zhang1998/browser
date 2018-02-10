package android.support.v4.media;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.d.b;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public abstract class MediaBrowserServiceCompat extends Service {
    Token a;
    private final b<IBinder, f> b = new b();
    private final a c = new a();

    @Nullable
    public abstract c a();

    static /* synthetic */ boolean a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, f fVar, Bundle bundle) {
        List list = (List) fVar.e.get(str);
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (Bundle a : r1) {
            if (u.a(bundle, a)) {
                return;
            }
        }
        r1.add(bundle);
        fVar.e.put(str, r1);
        d lVar = new l(mediaBrowserServiceCompat, str, fVar, str, bundle);
        if (bundle != null) {
            lVar.c = 1;
        }
        if (!lVar.a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.a + " id=" + str);
        }
    }

    static /* synthetic */ boolean a(String str, f fVar, Bundle bundle) {
        List<Bundle> list = (List) fVar.e.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (u.a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        fVar.e.remove(str);
        return z;
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, ResultReceiver resultReceiver) {
        d sVar = new s(mediaBrowserServiceCompat, str, resultReceiver);
        if (sVar.b) {
            throw new IllegalStateException("sendResult() called twice for: " + sVar.a);
        }
        sVar.b = true;
        sVar.a(sVar.c);
        if (!sVar.a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }
}
