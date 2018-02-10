package com.uc.media.interfaces;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface IMediaControllerListener {
    void onComplete();

    void onEnterFullScreen();

    void onEnterFullScreenFromLittleWin();

    void onEnterLittleWin(boolean z);

    void onError(String str);

    void onExitFullScreen();

    void onPause();

    void onPrepared(int i, int i2, int i3);

    void onSeekTo(int i);

    void onStart();

    void onTimeUpdate(int i);
}
