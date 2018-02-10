package com.uc.apollo.media;

import android.net.Uri;
import android.util.SparseArray;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.base.Config;
import com.uc.apollo.media.base.g;
import com.uc.apollo.media.impl.MediaPlayerClient;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public class MediaPlayer extends MediaPlayerClient {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_CACHED_POSITIONS = 91;
    public static final int MEDIA_INFO_PLAY_PAUSE = 81;
    public static final int MEDIA_INFO_PLAY_START = 80;
    public static final int MEDIA_INFO_PLAY_STOP = 82;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_WHOLE_FILE_BUFFERING_UPDATE = 607;
    private b mInnerListener;

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnExtraInfoListener {
        boolean onExtraInfo(MediaPlayer mediaPlayer, int i, int i2, Object obj);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer, int i, int i2, int i3);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* compiled from: ProGuard */
    final class a {
        private static HashSet<String> a;

        static {
            HashSet hashSet = new HashSet();
            a = hashSet;
            hashSet.add("webm");
            a.add("flac");
            a.add("au");
            a.add("midi");
            a.add("ape");
        }
    }

    /* compiled from: ProGuard */
    final class b implements MediaPlayerListener {
        private WeakReference<MediaPlayer> a;
        private Object b;
        private OnCompletionListener c;
        private OnVideoSizeChangedListener d;
        private OnPreparedListener e;
        private OnErrorListener f;
        private OnBufferingUpdateListener g;
        private c h;
        private OnSeekCompleteListener i;
        private OnInfoListener j;
        private OnExtraInfoListener k;

        b(MediaPlayer mediaPlayer) {
            this.a = new WeakReference(mediaPlayer);
        }

        public final void onVideoSizeChanged(int i, int i2) {
            if (this.d != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null) {
                    this.d.onVideoSizeChanged(mediaPlayer, i, i2);
                }
            }
        }

        public final void onSeekComplete() {
            if (this.i != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null) {
                    this.i.onSeekComplete(mediaPlayer);
                }
            }
        }

        public final void onPrepared(int i, int i2, int i3) {
            if (this.e != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null) {
                    this.e.onPrepared(mediaPlayer, i, i2, i3);
                }
            }
        }

        public final void onDurationChanged(int i) {
            if (this.e != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null) {
                    this.e.onPrepared(mediaPlayer, i, 0, 0);
                }
            }
        }

        public final void onError(int i, int i2) {
            if (this.f != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null) {
                    this.f.onError(mediaPlayer, i, i2);
                }
            }
        }

        public final void onInfo(int i, int i2) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (this.j != null && mediaPlayer != null) {
                this.j.onInfo(mediaPlayer, i, i2);
            }
        }

        public final void onPrepareBegin() {
        }

        public final void onStop() {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (this.k != null && mediaPlayer != null) {
                this.k.onExtraInfo(mediaPlayer, 82, 0, Integer.valueOf(0));
            }
        }

        public final void onRelease() {
        }

        public final void onReset() {
        }

        public final void onSeekTo(int i) {
        }

        public final void onCompletion() {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (mediaPlayer != null && this.c != null) {
                this.c.onCompletion(mediaPlayer);
            }
        }

        public final void onMessage(int i, int i2, Object obj) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (mediaPlayer != null) {
                if (this.g != null && i == 54) {
                    this.g.onBufferingUpdate(mediaPlayer, i2);
                }
                switch (i) {
                    case 52:
                        if (this.j != null) {
                            this.j.onInfo(mediaPlayer, 701, i2);
                            return;
                        }
                        return;
                    case 53:
                        if (this.j != null) {
                            this.j.onInfo(mediaPlayer, 702, i2);
                            return;
                        }
                        return;
                    case 63:
                        if (this.k != null) {
                            this.k.onExtraInfo(mediaPlayer, 91, i2, obj);
                            return;
                        }
                        return;
                    case 65:
                        if (this.j != null) {
                            this.j.onInfo(mediaPlayer, 901, i2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final Object getSibling() {
            return this.b;
        }

        public final void setSibling(Object obj) {
            this.b = obj;
        }

        public final void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
        }

        public final void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        }

        public final void onStart() {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (mediaPlayer != null && this.k != null) {
                this.k.onExtraInfo(mediaPlayer, 80, 0, Integer.valueOf(0));
            }
        }

        public final void onPause() {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (mediaPlayer != null && this.k != null) {
                this.k.onExtraInfo(mediaPlayer, 81, 0, Integer.valueOf(0));
            }
        }

        public final void onEnterFullScreen(boolean z) {
        }
    }

    /* compiled from: ProGuard */
    public interface c {
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.c = onCompletionListener;
        }
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.d = onVideoSizeChangedListener;
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.e = onPreparedListener;
        }
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.f = onErrorListener;
        }
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.g = onBufferingUpdateListener;
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.j = onInfoListener;
        }
    }

    public void setOnExtraInfoListener(OnExtraInfoListener onExtraInfoListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.k = onExtraInfoListener;
        }
    }

    public void setOnMessageListener(c cVar) {
        if (this.mInnerListener != null) {
            this.mInnerListener.h = cVar;
        }
        if (cVar != null) {
            hadAttachedToLittleWindow();
            getBuddyCount();
        }
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        if (this.mInnerListener != null) {
            this.mInnerListener.i = onSeekCompleteListener;
        }
    }

    public MediaPlayer() {
        this(false);
    }

    public MediaPlayer(boolean z) {
        super(z, g.a());
        this.mInnerListener = new b(this);
        setListener(this.mInnerListener);
    }

    public static MediaPlayer create(boolean z, int i) {
        return new MediaPlayer(z, i);
    }

    private MediaPlayer(boolean z, int i) {
        super(z, i);
        initOptions();
    }

    public boolean release() {
        setListener(null);
        setController(null);
        return super.release();
    }

    public void destroy() {
        setListener(null);
        setController(null);
        super.destroy();
    }

    public void wantToStart() {
        if (getHolder() != null) {
            getHolder().m();
        }
    }

    public boolean isInPlaybackState() {
        return isPlaying();
    }

    private void initOptions() {
        SparseArray instanceSettings = Settings.getInstanceSettings();
        for (int i = 0; i < instanceSettings.size(); i++) {
            int keyAt = instanceSettings.keyAt(i);
            setOption(keyAt, (String) instanceSettings.get(keyAt));
        }
    }

    public boolean setOption(int i, String str) {
        if (str == null) {
            return false;
        }
        String str2;
        switch (i) {
            case 1001:
                str2 = "rw.instance.business_unit";
                str = "as_" + str;
                break;
            case 1002:
                str2 = "rw.instance.stat_level";
                break;
            case 1003:
                str2 = "rw.instance.cache_in_cellular";
                break;
            case 1007:
                str2 = "rw.instance.mute";
                break;
            case 1008:
                str2 = "rw.instance.ext_info";
                break;
            case 1009:
                str2 = "rw.instance.pause_preload";
                break;
            case 1010:
                str2 = "rw.instance.http_proxy";
                break;
            case 1011:
                str2 = "rw.instance.backup_dnsrecord";
                break;
            case 1012:
                str2 = "rw.instance.public_parameter";
                break;
            case 2001:
                str2 = "rw.global.prune_cache_expired";
                break;
            case 2002:
                str2 = "rw.global.cache_dir";
                break;
            default:
                return false;
        }
        return setOption(str2, str);
    }

    public static void beforeCreateMediaPlayer(Uri uri) {
        if (uri != null) {
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(".");
            if (lastIndexOf != -1 && lastIndexOf < path.length() - 1) {
                if (a.a.contains(path.substring(lastIndexOf + 1))) {
                    Config.set(3, true);
                }
            }
        }
    }

    public static void afterCreateMediaPlayer() {
        Config.set(3, false);
    }
}
