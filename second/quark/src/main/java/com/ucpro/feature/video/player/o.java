package com.ucpro.feature.video.player;

import com.uc.apollo.widget.MediaController.MediaControllerFactory;
import com.uc.apollo.widget.VideoView;

/* compiled from: ProGuard */
final class o {
    static k a;

    static {
        a = null;
        MediaControllerFactory kVar = new k();
        a = kVar;
        VideoView.setMediaControllerFactory(kVar);
    }
}
