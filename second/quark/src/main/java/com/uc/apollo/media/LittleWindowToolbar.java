package com.uc.apollo.media;

import android.view.View;
import com.uc.apollo.annotation.KeepForRuntime;

@KeepForRuntime
/* compiled from: ProGuard */
public interface LittleWindowToolbar {
    View asView();

    void onCompletion();

    void onDurationChanged(int i);

    void onFloating();

    void onNormal();

    void onPause();

    void onPlay();

    void onPositionChanged(int i);

    void onPrepared(int i, int i2, int i3);

    void onPreparing();

    void onSourceChanged(String str, String str2, String str3);

    void onVideoSizeChanged(int i, int i2);

    void reset();

    void setVisibility(int i);
}
