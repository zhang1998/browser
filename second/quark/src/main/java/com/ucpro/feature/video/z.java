package com.ucpro.feature.video;

import com.UCMobile.Apollo.MediaPlayer;
import com.ucpro.c.c;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
final class z implements Runnable {
    z() {
    }

    public final void run() {
        try {
            MediaPlayer.globalInitialization(d.a());
            MediaPlayer.setGlobalOption("rw.global.cache_dir", c.f());
        } catch (Exception e) {
        }
    }
}
