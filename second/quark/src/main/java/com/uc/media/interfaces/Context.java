package com.uc.media.interfaces;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface Context {
    int curPositionRegulate(int i);

    int durationRegulate(int i);

    int getBackwardPosition(int i, int i2);

    int getForwardPosition(int i, int i2);

    boolean isLive();

    int onSeek(int i);

    void onSeekToComplete();

    void reset();
}
