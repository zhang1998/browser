package com.uc.apollo.media;

import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.base.WndPos;

@KeepForRuntime
/* compiled from: ProGuard */
public interface LittleWindowController {
    void close();

    WndPos getWinPosition();

    void maximize();

    void moveTo(int i, int i2, int i3, int i4);

    void pause();

    void play();

    void seekTo(int i);
}
