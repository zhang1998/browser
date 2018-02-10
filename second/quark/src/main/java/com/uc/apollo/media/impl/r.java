package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnCachedPositionsListener;
import java.util.Map;

/* compiled from: ProGuard */
final class r implements OnCachedPositionsListener {
    final /* synthetic */ h a;

    r(h hVar) {
        this.a = hVar;
    }

    public final void onCachedPositions(MediaPlayer mediaPlayer, Map map) {
        this.a.r.a(this.a.j, 63, 0, (Object) map);
    }
}
