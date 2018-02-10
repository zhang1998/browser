package com.ucpro.feature.video.player.c;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class j implements Runnable {
    j() {
    }

    public final void run() {
        i e = i.e();
        if (!e.a) {
            m.a(0, new f(e));
            e.a = true;
        }
    }
}
