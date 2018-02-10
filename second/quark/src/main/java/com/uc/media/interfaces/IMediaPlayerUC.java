package com.uc.media.interfaces;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface IMediaPlayerUC {
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 601;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_DOWNLOAD_RATE_CHANGED = 901;
    public static final int MEDIA_INFO_FLOAT_VIDEO_ENTER = 1002;
    public static final int MEDIA_INFO_FLOAT_VIDEO_EXIT = 1003;

    /* compiled from: ProGuard */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayerUC iMediaPlayerUC, int i);
    }

    /* compiled from: ProGuard */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayerUC iMediaPlayerUC);
    }

    /* compiled from: ProGuard */
    public interface OnDurationUpdateListener {
        void onDurationUpdate(IMediaPlayerUC iMediaPlayerUC, int i);
    }

    /* compiled from: ProGuard */
    public interface OnErrorListener {
        boolean onError(IMediaPlayerUC iMediaPlayerUC, int i, int i2);
    }

    /* compiled from: ProGuard */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayerUC iMediaPlayerUC, int i, int i2);
    }

    /* compiled from: ProGuard */
    public interface OnPreloadListener {
        void onPreloadFinish(IMediaPlayerUC iMediaPlayerUC);
    }

    /* compiled from: ProGuard */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayerUC iMediaPlayerUC);
    }

    /* compiled from: ProGuard */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayerUC iMediaPlayerUC);
    }

    int getDuration();

    Object getRealPlayer();

    int getVideoHeight();

    int getVideoWidth();

    void release();

    void reset();

    void seekTo(int i);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setPlaybackSpeed(float f);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(Surface surface);

    void setVolume(float f);

    void setWakeMode(Context context, int i);
}
