package com.uc.apollo.widget;

import android.net.Uri;
import com.uc.apollo.Settings;
import com.uc.apollo.media.MediaDefines;
import com.uc.apollo.media.MediaPlayer.OnBufferingUpdateListener;
import com.uc.apollo.media.MediaPlayer.OnCompletionListener;
import com.uc.apollo.media.MediaPlayer.OnErrorListener;
import com.uc.apollo.media.MediaPlayer.OnPreparedListener;
import com.uc.apollo.media.MediaPlayer.OnSeekCompleteListener;
import com.uc.apollo.media.MediaPlayerListener;
import com.uc.apollo.media.d;
import com.uc.apollo.widget.VideoView.OnExtraInfoListener;
import com.uc.apollo.widget.VideoView.OnInfoListener;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
final class f implements MediaPlayerListener {
    final /* synthetic */ VideoView a;
    private Object b;
    private Uri c;

    f(VideoView videoView) {
        this.a = videoView;
    }

    public final void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
        int i = !uri.equals(this.c) ? 1 : 0;
        this.c = uri;
        Iterator it = this.a.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), VideoView.VIDEO_INFO_ON_SET_PAGEURL, 0, str2);
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), VideoView.VIDEO_INFO_ON_SET_TITLE, 0, str);
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1011, 0, uri);
            }
        }
        if (i != 0 && this.a.mMediaView != null && this.a.mMediaView.getMediaPlayer() != null && this.a.mMediaView.getMediaPlayer().prepared()) {
            this.a.mMediaView.clear();
        }
    }

    public final void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
    }

    public final void onStart() {
        String str = this.a.mLogTag;
        if (this.a.mMediaController != null) {
            this.a.mMediaController.show();
        }
        Iterator it = this.a.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1003, 0, null);
            }
        }
    }

    public final void onPause() {
        String str = this.a.mLogTag;
        if (this.a.mMediaController != null) {
            this.a.mMediaController.show(0);
        }
        Iterator it = this.a.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1004, 0, null);
            }
        }
    }

    public final void onEnterFullScreen(boolean z) {
        Iterator it = this.a.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1001, z ? 1 : 0, null);
            }
        }
    }

    public final void onVideoSizeChanged(int i, int i2) {
        if (this.a.mPreloadStates != 1) {
        }
    }

    public final void onPrepared(int i, int i2, int i3) {
        if (i <= 0) {
            this.a.mCanSeekBack = false;
            this.a.mCanSeekForward = false;
        } else {
            this.a.mCanSeekBack = true;
            this.a.mCanSeekForward = true;
        }
        if (this.a.mPreloadStates == 1) {
            this.a.mPreloadStates = 2;
            return;
        }
        if (this.a.mMediaController != null) {
            this.a.mMediaController.setEnabled(true);
        }
        Iterator it = this.a.mOnPreparedListener.iterator();
        while (it.hasNext()) {
            OnPreparedListener onPreparedListener = (OnPreparedListener) it.next();
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(this.a.mMediaView.getMediaPlayer(), i, i2, i3);
            }
        }
    }

    public final void onSeekComplete() {
        String str = this.a.mLogTag;
        Iterator it = this.a.mOnSeekCompleteListener.iterator();
        while (it.hasNext()) {
            OnSeekCompleteListener onSeekCompleteListener = (OnSeekCompleteListener) it.next();
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(this.a.mMediaView.getMediaPlayer());
            }
        }
    }

    public final void onCompletion() {
        String str = this.a.mLogTag;
        Iterator it = this.a.mOnCompletionListener.iterator();
        while (it.hasNext()) {
            OnCompletionListener onCompletionListener = (OnCompletionListener) it.next();
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.a.mMediaView.getMediaPlayer());
            }
        }
    }

    public final void onError(int i, int i2) {
        if (this.a.mPreloadStates == 1) {
            this.a.mPreloadStates = 3;
            this.a.mPreloadErrorWhat = i;
            this.a.mPreloadErrorExtra = i2;
            return;
        }
        if (this.a.mMediaController != null) {
            this.a.mMediaController.hide();
        }
        Iterator it = this.a.mOnErrorListener.iterator();
        while (it.hasNext()) {
            OnErrorListener onErrorListener = (OnErrorListener) it.next();
            if (onErrorListener != null) {
                onErrorListener.onError(this.a.mMediaView.getMediaPlayer(), i, i2);
            }
        }
    }

    public final void onInfo(int i, int i2) {
        Iterator it = this.a.mOnInfoListener.iterator();
        while (it.hasNext()) {
            OnInfoListener onInfoListener = (OnInfoListener) it.next();
            if (onInfoListener != null) {
                onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), i, i2);
            }
        }
    }

    public final void onPrepareBegin() {
    }

    public final void onStop() {
    }

    public final void onRelease() {
    }

    public final void onReset() {
    }

    public final void onSeekTo(int i) {
        Iterator it = this.a.mOnExtraInfoListener.iterator();
        while (it.hasNext()) {
            OnExtraInfoListener onExtraInfoListener = (OnExtraInfoListener) it.next();
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1006, i, null);
            }
        }
    }

    public final void onMessage(int i, int i2, Object obj) {
        boolean z = true;
        Iterator it;
        OnExtraInfoListener onExtraInfoListener;
        Iterator it2;
        OnInfoListener onInfoListener;
        switch (i) {
            case 51:
                int mediaPlayerClientCount = this.a.mMediaView.getMediaPlayerClientCount();
                if (i2 != 1) {
                    z = false;
                }
                it = this.a.mOnExtraInfoListener.iterator();
                while (it.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1007, mediaPlayerClientCount, Boolean.valueOf(z));
                    }
                }
                return;
            case 52:
                if (this.a.mPreloadStates == 0) {
                    it2 = this.a.mOnInfoListener.iterator();
                    while (it2.hasNext()) {
                        onInfoListener = (OnInfoListener) it2.next();
                        if (onInfoListener != null) {
                            onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), 701, i2);
                        }
                    }
                    return;
                }
                return;
            case 53:
                if (this.a.mPreloadStates == 0) {
                    it2 = this.a.mOnInfoListener.iterator();
                    while (it2.hasNext()) {
                        onInfoListener = (OnInfoListener) it2.next();
                        if (onInfoListener != null) {
                            onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), 702, i2);
                        }
                    }
                    return;
                }
                return;
            case 54:
                if (this.a.mPreloadStates == 0) {
                    it2 = this.a.mOnBufferingUpdateListener.iterator();
                    while (it2.hasNext()) {
                        OnBufferingUpdateListener onBufferingUpdateListener = (OnBufferingUpdateListener) it2.next();
                        if (onBufferingUpdateListener != null) {
                            onBufferingUpdateListener.onBufferingUpdate(this.a.mMediaView.getMediaPlayer(), i2);
                        }
                    }
                    return;
                }
                return;
            case 60:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1003, i, Integer.valueOf(i2));
                    }
                }
                return;
            case 61:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1004, i, Integer.valueOf(i2));
                    }
                }
                return;
            case 62:
                it2 = this.a.mOnCompletionListener.iterator();
                while (it2.hasNext()) {
                    OnCompletionListener onCompletionListener = (OnCompletionListener) it2.next();
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(this.a.mMediaView.getMediaPlayer());
                    }
                }
                return;
            case 63:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1012, 0, obj);
                    }
                }
                return;
            case 65:
                it2 = this.a.mOnInfoListener.iterator();
                while (it2.hasNext()) {
                    onInfoListener = (OnInfoListener) it2.next();
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), 901, i2);
                    }
                }
                return;
            case 71:
                if (i2 == 5) {
                    String str = (String) obj;
                    if (!(str == null || str.equals(Settings.getSoVersion()))) {
                        Settings.setSoVersion(str);
                    }
                }
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1010, 0, d.b(i2));
                    }
                }
                return;
            case 73:
                it = this.a.mOnExtraInfoListener.iterator();
                while (it.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1002, 1, null);
                    }
                }
                return;
            case 74:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1002, 0, null);
                    }
                }
                return;
            case 80:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1008, i, Integer.valueOf(i2));
                    }
                }
                return;
            case 81:
                it2 = this.a.mOnExtraInfoListener.iterator();
                while (it2.hasNext()) {
                    onExtraInfoListener = (OnExtraInfoListener) it2.next();
                    if (onExtraInfoListener != null) {
                        onExtraInfoListener.onExtraInfo(this.a.mMediaView.getMediaPlayer(), 1009, i, Integer.valueOf(i2));
                    }
                }
                return;
            case MediaDefines.MSG_ENABLE_VR_MODE /*120*/:
                it2 = this.a.mOnInfoListener.iterator();
                while (it2.hasNext()) {
                    onInfoListener = (OnInfoListener) it2.next();
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), 1001, i2);
                    }
                }
                return;
            case MediaDefines.MSG_DISABLE_VR_SENSOR /*121*/:
                it2 = this.a.mOnInfoListener.iterator();
                while (it2.hasNext()) {
                    onInfoListener = (OnInfoListener) it2.next();
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(this.a.mMediaView.getMediaPlayer(), 1002, i2);
                    }
                }
                return;
            default:
                return;
        }
    }

    public final Object getSibling() {
        return this.b;
    }

    public final void setSibling(Object obj) {
        this.b = obj;
    }

    public final void onDurationChanged(int i) {
    }
}
