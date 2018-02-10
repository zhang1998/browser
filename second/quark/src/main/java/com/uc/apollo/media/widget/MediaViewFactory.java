package com.uc.apollo.media.widget;

import android.content.Context;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.base.e;
import com.uc.apollo.media.base.g;
import com.uc.apollo.media.impl.B;
import com.uc.apollo.media.impl.D;
import com.uc.apollo.media.widget.MediaView.b;

@KeepForRuntime
/* compiled from: ProGuard */
public class MediaViewFactory {
    @Deprecated
    public static MediaView create(Context context) {
        return create(context, -1);
    }

    public static MediaView create(Context context, int i) {
        if (g.a(i)) {
            i = g.a();
        }
        boolean b = e.b();
        MediaView mediaView = null;
        if (n.a()) {
            mediaView = new h(context, i, b);
        }
        if (mediaView == null) {
            mediaView = new b(context, i, b);
        }
        B a = D.a(i);
        if (a != null) {
            int z = a.z();
            int y = a.y();
            if (z > 0 && y > 0) {
                mediaView.setVideoSize(z, y);
            }
        }
        return mediaView;
    }
}
