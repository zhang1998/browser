package com.UCMobile.Apollo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.UCMobile.Apollo.annotations.Keep;
import com.UCMobile.Apollo.download.f;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.apollo.impl.SettingsConst;
import com.uc.imagecodec.export.IPictureView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class MediaPlayer {
    public static final boolean ENABLE_NETWORKINFO = true;
    public static boolean ENABLE_PLAYINGDOWNLOADER = false;
    public static final int MEDIA_ERROR_CANNOT_PAUSE = 4;
    public static final int MEDIA_ERROR_CANNOT_START = 2;
    public static final int MEDIA_ERROR_CANNOT_STOP = 3;
    public static final int MEDIA_ERROR_INVALID_STATE = 5;
    public static final int MEDIA_ERROR_PREPARE_FAILED = 1;
    public static final int MEDIA_ERROR_SEEK_FAILED = 6;
    public static final int MEDIA_ERROR_UNKNOWN = 268435456;
    public static final int MEDIA_INFO_DOWNLOAD_RATE_CHANGE = 901;
    public static final int MEDIA_INFO_RETRY = 601;
    public static final int MEDIA_INFO_T3 = 602;
    public static final int MEDIA_INFO_T3_END_HIGH = 605;
    public static final int MEDIA_INFO_T3_END_LOW = 606;
    public static final int MEDIA_INFO_T3_START_HIGH = 603;
    public static final int MEDIA_INFO_T3_START_LOW = 604;
    private static boolean a = false;
    private static int b = 0;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean j = false;
    private static boolean k = true;
    private static String l = null;
    private OnPreparedListener A = null;
    private OnSeekCompleteListener B = null;
    private OnVideoSizeChangedListener C = null;
    private OnCompletionListener D = null;
    private OnTimedTextListener E = null;
    private OnBufferingUpdateListener F = null;
    private IRequestExternalValueListener G = null;
    private OnCachedPositionsListener H = null;
    private boolean I = false;
    private boolean J = false;
    private long K;
    private OnClickListener L = new OnClickListener(this) {
        final /* synthetic */ MediaPlayer a;

        {
            this.a = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            MediaPlayer._nativeButtonClickHandler(this.a.K);
        }
    };
    private ApolloMetaData M;
    @Keep
    private IVideoStatistic _VideoStatistic = null;
    private boolean c = false;
    private int d = 0;
    private boolean e = false;
    private WakeLock f = null;
    private int i = 0;
    private Context m;
    private a n = null;
    private f o = null;
    private boolean p = false;
    private ConnectivityManager q;
    private NetworkInfo r;
    private b s = new b(this, this);
    private d t = d.IDLE;
    private Surface u = null;
    private SurfaceHolder v = null;
    private String w = null;
    private Map<String, String> x = null;
    private OnInfoListener y = null;
    private OnErrorListener z = null;

    /* compiled from: ProGuard */
    public interface IRequestExternalValueListener {
        float getFloatValue(int i, String str);

        int getIntValue(int i, String str);

        String getStringValue(int i, String str);
    }

    /* compiled from: ProGuard */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnCachedPositionsListener {
        void onCachedPositions(MediaPlayer mediaPlayer, Map map);
    }

    /* compiled from: ProGuard */
    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    /* compiled from: ProGuard */
    public interface OnTimedTextListener {
        void onTimedText(MediaPlayer mediaPlayer, TimedText timedText);
    }

    @Keep
    /* compiled from: ProGuard */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* compiled from: ProGuard */
    public class TrackInfo implements Parcelable {
        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    /* compiled from: ProGuard */
    final class a extends Handler {
        private WeakReference<MediaPlayer> a = null;

        public a(MediaPlayer mediaPlayer, Looper looper) {
            super(looper);
            this.a = new WeakReference(mediaPlayer);
        }

        public final void handleMessage(Message message) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
            if (mediaPlayer != null) {
                int i = message.what;
                int i2 = message.arg1;
                int i3 = message.arg2;
                switch (i) {
                    case 0:
                        if (i2 == 701) {
                            new StringBuilder("MediaPlayer onInfo : buffering start, isBuffering ").append(mediaPlayer.c);
                            if (!mediaPlayer.c) {
                                mediaPlayer.c = true;
                                mediaPlayer.d = 1;
                                MediaPlayer.b(mediaPlayer);
                                if (mediaPlayer.y != null) {
                                    mediaPlayer.y.onInfo(mediaPlayer, i2, i3);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (i2 == 702) {
                            new StringBuilder("MediaPlayer onInfo : buffering end, isBuffering ").append(mediaPlayer.c);
                            if (mediaPlayer.c) {
                                mediaPlayer.c = false;
                                mediaPlayer.d = 1;
                                MediaPlayer.d(mediaPlayer);
                                if (mediaPlayer.y != null) {
                                    mediaPlayer.y.onInfo(mediaPlayer, i2, i3);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            if (i2 == 3 && i3 == 0) {
                                i3 = (int) System.currentTimeMillis();
                            }
                            new StringBuilder("MediaPlayer onInfo: ").append(i2).append(", ").append(i3);
                            if (mediaPlayer.y != null) {
                                mediaPlayer.y.onInfo(mediaPlayer, i2, i3);
                                return;
                            }
                            return;
                        }
                    case 1:
                        new StringBuilder("MediaPlayer onError ").append(i2).append(" ").append(i3);
                        if (mediaPlayer.z != null && !mediaPlayer.z.onError(mediaPlayer, i2, i3) && mediaPlayer.D != null) {
                            mediaPlayer.D.onCompletion(mediaPlayer);
                            return;
                        }
                        return;
                    case 2:
                        new StringBuilder("MediaPlayer onPrepared mp ").append(mediaPlayer).append(", _state ").append(mediaPlayer.t);
                        Bundle bundle = null;
                        try {
                            bundle = MediaPlayer._nativeGetMetaData(mediaPlayer.K);
                        } catch (UnsatisfiedLinkError e) {
                        }
                        mediaPlayer.M.update(bundle);
                        if (mediaPlayer.A != null) {
                            mediaPlayer.A.onPrepared(mediaPlayer);
                            return;
                        }
                        return;
                    case 3:
                        if (mediaPlayer.B != null) {
                            mediaPlayer.B.onSeekComplete(mediaPlayer);
                            return;
                        }
                        return;
                    case 4:
                        if (mediaPlayer.C != null) {
                            mediaPlayer.C.onVideoSizeChanged(mediaPlayer, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        if (mediaPlayer.D != null) {
                            mediaPlayer.D.onCompletion(mediaPlayer);
                            return;
                        }
                        return;
                    case 6:
                        if (mediaPlayer.c) {
                            if (i2 > 0 && i2 <= 100 && i2 > mediaPlayer.d) {
                                mediaPlayer.d = i2;
                            }
                            if (mediaPlayer.F != null) {
                                mediaPlayer.F.onBufferingUpdate(mediaPlayer, mediaPlayer.d);
                                return;
                            }
                            return;
                        }
                        return;
                    case 8:
                        if (mediaPlayer.H != null) {
                            mediaPlayer.H.onCachedPositions(mediaPlayer, (Map) message.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends BroadcastReceiver {
        WeakReference<MediaPlayer> a;
        final /* synthetic */ MediaPlayer b;

        public b(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
            this.b = mediaPlayer;
            this.a = new WeakReference(mediaPlayer2);
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                MediaPlayer mediaPlayer = (MediaPlayer) this.a.get();
                if (mediaPlayer != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (intent.getBooleanExtra("noConnectivity", false)) {
                        mediaPlayer.setOption("rw.global.connectivity_network_type", "-1");
                        return;
                    }
                    mediaPlayer.q = (ConnectivityManager) context.getSystemService("connectivity");
                    mediaPlayer.r = mediaPlayer.q.getActiveNetworkInfo();
                    if (mediaPlayer.r != null) {
                        mediaPlayer.setOption("rw.global.connectivity_network_type", String.valueOf(mediaPlayer.r.getType()));
                        mediaPlayer.setOption("rw.global.connectivity_network_subtype", String.valueOf(mediaPlayer.r.getSubtype()));
                    }
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class c {
        private HashMap<String, String> a;

        public c(String str) {
            if (str != null) {
                this.a = new HashMap();
                str.trim();
                int i = 0;
                int i2 = 0;
                while (i == 0) {
                    int indexOf = str.indexOf("&", i2);
                    if (indexOf < 0) {
                        indexOf = str.length();
                        i = 1;
                    }
                    String substring = str.substring(i2, indexOf);
                    if (substring.length() > 0) {
                        int indexOf2 = substring.indexOf("=");
                        if (indexOf2 > 0) {
                            this.a.put(substring.substring(0, indexOf2), substring.substring(indexOf2 + 1));
                        }
                    }
                    i2 = indexOf + 1;
                }
            }
        }

        final boolean a() {
            String str = "ap_stat_level";
            if (this.a == null) {
                str = null;
            } else {
                str = (String) this.a.get(str);
            }
            if (str == null) {
                return true;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            if (parseInt == 0 || (parseInt & 1) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: ProGuard */
    enum d {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACK_COMPLETED,
        ERROR,
        END
    }

    private static native void _nativeButtonClickHandler(long j);

    private native long _nativeCreateInstance(Context context);

    public static native String _nativeGetAllApolloSetting(long j);

    public static native int _nativeGetApiVersion();

    public static native String _nativeGetApolloSetting(String str, long j);

    private static native int _nativeGetAudioTrackIndex(long j);

    private static native String[] _nativeGetAudioTrackTitles(long j);

    private static native float _nativeGetAverageFPS(long j);

    private native int _nativeGetCurrentPosition(long j);

    private static native void _nativeGetCurrentVideoFrame(long j, Bitmap bitmap);

    public static native String _nativeGetDefaultApolloSetting(String str, long j);

    private native int _nativeGetDuration(long j);

    private static native float _nativeGetFPS(long j);

    private static native String _nativeGetGlobalOption(String str);

    private static native Map<String, String> _nativeGetGlobalOptions();

    @Keep
    private static native Bundle _nativeGetMetaData(long j);

    private static native Map<String, String> _nativeGetOptions(long j);

    private native int _nativeGetPlayableDuration(long j);

    public static native String _nativeGetVersionString();

    private native int _nativeGetVideoHeight(long j);

    private native int _nativeGetVideoWidth(long j);

    public static native int _nativeInitGlobalApolloSetting(String str, long j);

    private static native void _nativeInitialize();

    private native boolean _nativeIsPlaying(long j);

    private native boolean _nativePause(long j);

    private native boolean _nativePlay(long j);

    private native boolean _nativePrepare(long j, String str, Map<String, String> map, Surface surface, boolean z);

    private native void _nativeRelease(long j);

    public static native int _nativeRemoveAllApolloSetting(long j);

    public static native int _nativeRemoveApolloSetting(String str, long j);

    private native void _nativeReset(long j);

    private native boolean _nativeSeekTo(long j, int i);

    public static native int _nativeSetApolloSetting(String str, String str2, long j);

    public static native int _nativeSetApolloSettings(String str, long j);

    private static native boolean _nativeSetAudioTrackIndex(long j, int i);

    public static native void _nativeSetContextAndFilesPath(Context context, String str);

    private static native int _nativeSetGlobalOption(String str, String str2);

    private native void _nativeSetInitPlaybackTime(long j, int i);

    private native void _nativeSetSurface(long j, Surface surface);

    private native void _nativeSetVideoScalingMode(long j, int i);

    private native void _nativeSetVolume(long j, float f, float f2);

    private native boolean _nativeStart(long j);

    private native boolean _nativeStop(long j);

    public static native void testFileDescriptor(FileDescriptor fileDescriptor);

    public static void initWithContext(Context context) {
        String path = new ContextWrapper(context).getFilesDir().getPath();
        try {
            _nativeSetContextAndFilesPath(context, path);
            _nativeSetGlobalOption("rw.global.private_files_dir", path);
        } catch (UnsatisfiedLinkError e) {
            new StringBuilder("_nativeSetContextAndFilesPath method not found.").append(e);
        }
    }

    public static synchronized boolean globalInitialization(Context context) {
        boolean z = false;
        synchronized (MediaPlayer.class) {
            if (!a) {
                if (com.UCMobile.Apollo.a.b.a(context)) {
                    initWithContext(context);
                    try {
                        _nativeInitialize();
                        a = true;
                        if (b != 0) {
                            b = 0;
                        }
                    } catch (UnsatisfiedLinkError e) {
                        b++;
                        l = e.getMessage() + ";" + e.getCause();
                    }
                } else {
                    l = com.UCMobile.Apollo.a.b.a();
                    b++;
                }
            }
            z = true;
        }
        return z;
    }

    public static String globalInitializationFailDesc() {
        return l;
    }

    @Keep
    public MediaPlayer(Context context) {
        this.m = context;
        printStackTrace();
        globalInitialization(context);
        if (a) {
            this.t = d.IDLE;
            this.c = false;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = Looper.getMainLooper();
            }
            this.K = _nativeCreateInstance(context);
            if (this.K == 0) {
                throw new InstantiationError("Create MediaPlayer failed.");
            }
            this.n = new a(this, myLooper);
            new StringBuilder("_callbackHandler created ").append(this.n);
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
            if (activeNetworkInfo != null) {
                setOption("rw.global.connectivity_network_type", String.valueOf(activeNetworkInfo.getType()));
                setOption("rw.global.connectivity_network_subtype", String.valueOf(activeNetworkInfo.getSubtype()));
            } else {
                setOption("rw.global.connectivity_network_type", "-1");
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this.s, intentFilter);
            this.p = true;
            this.M = new ApolloMetaData();
            return;
        }
        this.i = 1;
    }

    @Keep
    public static MediaPlayer create(Context context, String str, SurfaceHolder surfaceHolder) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer(context);
            mediaPlayer.setDataSource(str);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Exception e) {
            return null;
        }
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer(context);
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Exception e) {
            return null;
        }
    }

    public void release() {
        printStackTrace();
        if (a) {
            switch (this.t) {
                case STARTED:
                case PAUSED:
                case PLAYBACK_COMPLETED:
                    stop();
                    break;
            }
            if (this.m != null) {
                if (this.p) {
                    try {
                        this.m.unregisterReceiver(this.s);
                    } catch (Exception e) {
                    }
                    this.p = false;
                }
                this.m = null;
            }
            b();
            _nativeRelease(this.K);
            this.K = 0;
        }
    }

    public void setDataSource(String str) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(str, null);
    }

    private static boolean a() {
        int parseInt;
        String versionString = getVersionString();
        if (versionString.length() > 0) {
            String[] split = versionString.split("\\.");
            if (split.length >= 4) {
                try {
                    parseInt = Integer.parseInt(split[2]) + ((Integer.parseInt(split[0]) * 10000) + (Integer.parseInt(split[1]) * 100));
                    new StringBuilder("isNativeLibrarySupportPlayingDownload()  getVersionString=").append(versionString).append(", verInt=").append(parseInt);
                    if (parseInt < 21311) {
                        return true;
                    }
                    return false;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        parseInt = 0;
        new StringBuilder("isNativeLibrarySupportPlayingDownload()  getVersionString=").append(versionString).append(", verInt=").append(parseInt);
        if (parseInt < 21311) {
            return false;
        }
        return true;
    }

    public void setDataSource(String str, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        printStackTrace();
        if (!a) {
            return;
        }
        if (this.t != d.IDLE) {
            throw new IllegalStateException("IDLE state expected but current is " + this.t);
        }
        String b = e.b(str);
        this.w = b;
        this.x = map;
        if (this.w != null) {
            this.t = d.INITIALIZED;
        }
        if (a() && ENABLE_PLAYINGDOWNLOADER) {
            Object obj;
            String option = getOption("ap_playing_download");
            if (option == null || !option.equals(SettingsConst.FALSE)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                this.o = f.a(this.m, b, map);
            }
        }
    }

    public void setDataSource(Context context, Uri uri) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(uri.toString());
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(uri.toString(), (Map) map);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        printStackTrace();
        if (a) {
            this.u = null;
            this.v = surfaceHolder;
            if (this.v != null) {
                _nativeSetSurface(this.K, this.v.getSurface());
            } else {
                _nativeSetSurface(this.K, null);
            }
        }
    }

    public void setSurface(Surface surface) {
        printStackTrace();
        if (a) {
            this.v = null;
            this.u = surface;
            _nativeSetSurface(this.K, surface);
        }
    }

    public void setVideoScalingMode(int i) {
        printStackTrace();
        if (a) {
            _nativeSetVideoScalingMode(this.K, i);
        }
    }

    public void setInitPlaybackTime(int i) {
        printStackTrace();
        if (a) {
            try {
                _nativeSetInitPlaybackTime(this.K, i);
            } catch (UnsatisfiedLinkError e) {
            }
        }
    }

    public void prepare() throws IllegalStateException, IOException {
        printStackTrace();
        if (!a) {
            return;
        }
        if (this.t != d.INITIALIZED) {
            throw new IllegalStateException("State must be INITIALIZED when calling prepare(). Current state is " + this.t);
        }
        this.t = d.PREPARING;
        new StringBuilder("prepare. Will call nativePrepare() with header ").append(this.x);
        if (_nativePrepare(this.K, this.w, this.x, this.v == null ? null : this.v.getSurface(), false)) {
            this.t = d.PREPARED;
        } else {
            a(1);
        }
    }

    public void prepareAsync() throws IllegalStateException {
        printStackTrace();
        if (!a) {
            return;
        }
        if (this.t != d.INITIALIZED) {
            throw new IllegalStateException("State must be INITIALIZED when calling prepare(). Current state is " + this.t);
        }
        this.t = d.PREPARING;
        new StringBuilder("prepareAsync. Will call nativePrepare() with header ").append(this.x);
        if (!_nativePrepare(this.K, this.w, this.x, this.v == null ? null : this.v.getSurface(), true)) {
            a(1);
        }
    }

    public void reset() {
        printStackTrace();
        if (a) {
            d dVar = d.PREPARING;
            b();
        }
    }

    private void b() {
        printStackTrace();
        _nativeReset(this.K);
        if (this.n != null) {
            this.n.removeMessages(0);
            this.n.removeMessages(1);
            this.n.removeMessages(2);
            this.n.removeMessages(5);
            this.n.removeMessages(3);
            this.n.removeMessages(4);
            this.n.removeMessages(6);
        }
        this.t = d.IDLE;
        this.e = false;
        this.I = false;
        this.J = false;
        c();
        this.v = null;
        this.w = null;
        if (this.o != null) {
            this.o.stop();
        }
    }

    public void start() {
        int i = 0;
        printStackTrace();
        if (!a || this.t == d.STARTED) {
            return;
        }
        if (this.t == d.PREPARED || this.t == d.PAUSED || this.t == d.PLAYBACK_COMPLETED) {
            if (this.t == d.PREPARED) {
                printStackTrace();
                if (_nativeStart(this.K) && _nativePlay(this.K)) {
                    i = 1;
                }
            } else {
                if (this.t == d.PAUSED) {
                    printStackTrace();
                } else if (this.t == d.PLAYBACK_COMPLETED) {
                    printStackTrace();
                    new StringBuilder("getCurrentPosition. getDuration ").append(getCurrentPosition()).append(" & ").append(getDuration());
                    if (getDuration() - getCurrentPosition() < SecExceptionCode.SEC_ERROR_DYN_STORE) {
                        _nativeSeekTo(this.K, 0);
                    }
                }
                i = _nativePlay(this.K);
            }
            if (i != 0) {
                this.t = d.STARTED;
                this.J = true;
                c();
                return;
            } else if (this.t != d.PAUSED || !_nativeIsPlaying(this.K)) {
                a(2);
                return;
            } else {
                return;
            }
        }
        new StringBuilder("call start() in error state:").append(this.t);
    }

    public void stop() {
        printStackTrace();
        if (!a || this.t == d.STOPPED) {
            return;
        }
        if (this.t == d.STARTED || this.t == d.PAUSED || this.t == d.PREPARED || this.t == d.PLAYBACK_COMPLETED) {
            boolean _nativeStop = _nativeStop(this.K);
            this.J = false;
            c();
            if (_nativeStop) {
                this.t = d.STOPPED;
            }
            if (this.o != null) {
                this.o.stop();
                return;
            }
            return;
        }
        new StringBuilder("call stop() in error state:").append(this.t);
    }

    public void pause() {
        printStackTrace();
        if (!a) {
            return;
        }
        if (this.t != d.STARTED) {
            new StringBuilder("call pause() in error state:").append(this.t);
            return;
        }
        boolean _nativePause = _nativePause(this.K);
        if (_nativePause || (!_nativePause && this.c)) {
            this.t = d.PAUSED;
            this.J = false;
            c();
        }
    }

    public boolean isNearlyEndedSeek(int i) {
        int duration = getDuration();
        if (duration > 60000 && duration - i <= SettingsConst.GLOBAL_SETTINGS) {
            return true;
        }
        return false;
    }

    public void seekTo(int i) {
        printStackTrace();
        if (!a) {
            return;
        }
        if (this.t != d.PREPARED && this.t != d.STARTED && this.t != d.PAUSED && this.t != d.PLAYBACK_COMPLETED) {
            new StringBuilder("call seekto() in error state:").append(this.t);
        } else if (isNearlyEndedSeek(i)) {
            this.e = true;
            pause();
            this.t = d.PLAYBACK_COMPLETED;
            if (this.B != null) {
                this.B.onSeekComplete(this);
            }
            if (this.D != null) {
                this.D.onCompletion(this);
            }
        } else {
            this.e = false;
            if (!_nativeSeekTo(this.K, i)) {
                a(6);
            }
        }
    }

    public TrackInfo[] getTrackInfo() throws IllegalStateException {
        return null;
    }

    public boolean isPlaying() {
        if (a && this.t != d.ERROR) {
            return _nativeIsPlaying(this.K);
        }
        return false;
    }

    public int getCurrentPosition() {
        if (!a || this.t == d.ERROR || this.t == d.IDLE) {
            return 0;
        }
        if (!this.e) {
            return _nativeGetCurrentPosition(this.K);
        }
        getDuration();
        return getDuration();
    }

    public int getDuration() {
        if (!a || this.t == d.ERROR || this.t == d.IDLE || this.t == d.INITIALIZED) {
            return 0;
        }
        int _nativeGetDuration = _nativeGetDuration(this.K);
        if (_nativeGetDuration >= 1000) {
            return _nativeGetDuration;
        }
        return 0;
    }

    public int getPlayableDuration() {
        int i = 0;
        if (!(!a || this.t == d.ERROR || this.t == d.IDLE || this.t == d.INITIALIZED)) {
            try {
                i = _nativeGetPlayableDuration(this.K);
            } catch (UnsatisfiedLinkError e) {
            }
        }
        return i;
    }

    public int getVideoHeight() {
        if (a && this.t != d.ERROR) {
            return _nativeGetVideoHeight(this.K);
        }
        return 0;
    }

    public int getVideoWidth() {
        if (a && this.t != d.ERROR) {
            return _nativeGetVideoWidth(this.K);
        }
        return 0;
    }

    public String[] getAudioTrackTitles() {
        if (!a) {
            return null;
        }
        if (this.t == d.PREPARED || this.t == d.STARTED || this.t == d.PAUSED || this.t == d.PLAYBACK_COMPLETED) {
            return _nativeGetAudioTrackTitles(this.K);
        }
        new StringBuilder("call getAudioTrackTitles() in error state:").append(this.t);
        return new String[0];
    }

    public boolean setAudioTrack(int i) {
        if (!a) {
            return false;
        }
        if (this.t == d.PREPARED || this.t == d.STARTED || this.t == d.PAUSED || this.t == d.PLAYBACK_COMPLETED) {
            return _nativeSetAudioTrackIndex(this.K, i);
        }
        new StringBuilder("call setAudioTrack() in error state:").append(this.t);
        return false;
    }

    public int getAudioTrackIndex() {
        if (!a) {
            return 0;
        }
        if (this.t == d.PREPARED || this.t == d.STARTED || this.t == d.PAUSED || this.t == d.PLAYBACK_COMPLETED) {
            return _nativeGetAudioTrackIndex(this.K);
        }
        new StringBuilder("call getAudioTrackIndex() in error state:").append(this.t);
        return 0;
    }

    public Bitmap getCurrentVideoFrame(int i, int i2) {
        if (!k) {
            new StringBuilder("getCurrentVideoFrame error: _enableCaptureVideoFrame = ").append(k);
            return null;
        } else if (!a) {
            new StringBuilder("getCurrentVideoFrame error: _initialized = ").append(a);
            return null;
        } else if (this.t == d.STARTED || this.t == d.PAUSED || this.t == d.PLAYBACK_COMPLETED) {
            if (i == 0) {
                i = getVideoWidth();
            }
            if (i2 == 0) {
                i2 = getVideoHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            _nativeGetCurrentVideoFrame(this.K, createBitmap);
            return createBitmap;
        } else {
            new StringBuilder("call getCurrentVideoFrame() in error state:").append(this.t);
            return null;
        }
    }

    public Bitmap getCurrentFrame() {
        return getCurrentVideoFrame(0, 0);
    }

    public float getFPS() {
        if (a) {
            return _nativeGetFPS(this.K);
        }
        return 0.0f;
    }

    public float getAverageFPS() {
        if (a) {
            return _nativeGetAverageFPS(this.K);
        }
        return 0.0f;
    }

    public void setVolume(float f, float f2) {
        if (a) {
            try {
                _nativeSetVolume(this.K, f, f2);
            } catch (UnsatisfiedLinkError e) {
            } catch (UnsupportedOperationException e2) {
            }
        }
    }

    public void setWakeMode(Context context, int i) {
        if (a) {
            boolean z;
            if (this.f != null) {
                boolean z2;
                if (this.f.isHeld()) {
                    z2 = true;
                    this.f.release();
                } else {
                    z2 = false;
                }
                this.f = null;
                z = z2;
            } else {
                z = false;
            }
            this.f = ((PowerManager) context.getSystemService("power")).newWakeLock(536870912 | i, MediaPlayer.class.getName());
            this.f.setReferenceCounted(false);
            if (z) {
                this.f.acquire();
            }
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (a && z != this.I) {
            this.I = z;
            if (this.v != null) {
                c();
            }
        }
    }

    private void c() {
        if (this.v != null) {
            SurfaceHolder surfaceHolder = this.v;
            boolean z = this.I && this.J;
            surfaceHolder.setKeepScreenOn(z);
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.y = onInfoListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.z = onErrorListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.A = onPreparedListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.B = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.C = onVideoSizeChangedListener;
    }

    public void setOnCachedPositionsListener(OnCachedPositionsListener onCachedPositionsListener) {
        this.H = onCachedPositionsListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.D = onCompletionListener;
    }

    public void setOnTimedTextListener(OnTimedTextListener onTimedTextListener) {
        this.E = onTimedTextListener;
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.F = onBufferingUpdateListener;
    }

    public void setExternalValueListener(IRequestExternalValueListener iRequestExternalValueListener) {
        this.G = iRequestExternalValueListener;
        uploadApolloInitFailStatIfNeed();
    }

    private void a(int i) {
        printStackTrace();
        this.t = d.ERROR;
        if (this.z != null && !this.z.onError(this, 0, i)) {
            nativeCallback(5, 0, i);
        }
    }

    @Keep
    private void nativeCallback(int i, int i2, int i3) {
        if (i == 1) {
            this.t = d.ERROR;
        } else if (i == 2) {
            this.t = d.PREPARED;
        } else if (i == 5) {
            this.t = d.PLAYBACK_COMPLETED;
        }
        if (i == 0 && ((i2 == 701 || i2 == 702 || i2 == 3) && (i3 == 0 || i3 == 1))) {
            i3 = (int) System.currentTimeMillis();
        }
        this.n.sendMessage(this.n.obtainMessage(i, i2, i3));
    }

    @Keep
    private void nativeCallbackObject(int i, Object obj) {
        this.n.sendMessage(this.n.obtainMessage(i, obj));
    }

    @Keep
    private int nativeGetIntExtValue(int i, String str) {
        new StringBuilder("_extListener ").append(this.G);
        if (this.G != null) {
            return this.G.getIntValue(i, str);
        }
        return 0;
    }

    @Keep
    private float nativeGetFloatExtValue(int i, String str) {
        if (this.G != null) {
            return this.G.getFloatValue(i, str);
        }
        return 0.0f;
    }

    @Keep
    private String nativeGetStringExtValue(int i, String str) {
        if (this.G != null) {
            return this.G.getStringValue(i, str);
        }
        return null;
    }

    public static String getVersionString() {
        if (!a) {
            return "";
        }
        try {
            return _nativeGetVersionString();
        } catch (UnsatisfiedLinkError e) {
            return "";
        }
    }

    public static String getVersionString(Context context) {
        if (!globalInitialization(context)) {
            return "";
        }
        try {
            return _nativeGetVersionString();
        } catch (UnsatisfiedLinkError e) {
            return "";
        }
    }

    public static int getApiVersion() {
        if (a) {
            return _nativeGetApiVersion();
        }
        return -1;
    }

    public static int getApiVersion(Context context) {
        if (globalInitialization(context)) {
            return _nativeGetApiVersion();
        }
        return -1;
    }

    public static int setGlobalOption(String str, String str2) {
        try {
            return _nativeSetGlobalOption(str, str2);
        } catch (UnsatisfiedLinkError e) {
            return -1;
        }
    }

    public static int setGlobalOption(Context context, String str, String str2) {
        if (!a) {
            globalInitialization(context);
        }
        return setGlobalOption(str, str2);
    }

    public static String getGlobalOption(String str) {
        try {
            return _nativeGetGlobalOption(str);
        } catch (UnsatisfiedLinkError e) {
            return null;
        }
    }

    public static String getGlobalOption(Context context, String str) {
        if (!a) {
            globalInitialization(context);
        }
        return getGlobalOption(str);
    }

    public static int setGlobalOptions(Map<String, String> map) {
        int i = 1;
        try {
            for (Entry entry : map.entrySet()) {
                int i2;
                if (setGlobalOption((String) entry.getKey(), (String) entry.getValue()) < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i != 0) {
                return 0;
            }
            return -1;
        } catch (UnsatisfiedLinkError e) {
            return -1;
        }
    }

    public static Map<String, String> getGlobalOptions() {
        try {
            return _nativeGetGlobalOptions();
        } catch (UnsatisfiedLinkError e) {
            return null;
        }
    }

    public static Map<String, String> getGlobalOptions(Context context) {
        if (!a) {
            globalInitialization(context);
        }
        return getGlobalOptions();
    }

    public int setApolloSetting(String str, String str2) {
        return setOption(str, str2);
    }

    public String getApolloSetting(String str) {
        return getOption(str);
    }

    public int setApolloSettings(String str) {
        return -1;
    }

    public String getAllApolloSetting() {
        return "{}";
    }

    public int removeApolloSetting(String str) {
        return -1;
    }

    public String getDefaultApolloSetting(String str) {
        return null;
    }

    public int removeAllApolloSetting() {
        return -1;
    }

    public int setOption(String str, String str2) {
        int i = -1;
        if (this.K != 0) {
            try {
                i = _nativeSetApolloSetting(str, str2, this.K);
            } catch (UnsatisfiedLinkError e) {
            }
        }
        return i;
    }

    public String getOption(String str) {
        if (this.K == 0) {
            return "";
        }
        try {
            return _nativeGetApolloSetting(str, this.K);
        } catch (UnsatisfiedLinkError e) {
            return "";
        }
    }

    public int setOptions(Map<String, String> map) {
        if (this.K == 0) {
            return -1;
        }
        int i = 1;
        try {
            for (Entry entry : map.entrySet()) {
                int i2;
                if (setOption((String) entry.getKey(), (String) entry.getValue()) < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i == 0) {
                return -1;
            }
            return 0;
        } catch (UnsatisfiedLinkError e) {
            return -1;
        }
    }

    public Map<String, String> getOptions() {
        Map<String, String> map = null;
        if (this.K != 0) {
            try {
                map = _nativeGetOptions(this.K);
            } catch (UnsatisfiedLinkError e) {
            }
        }
        return map;
    }

    public Object setGeneralOption(String str, Object obj) {
        if (str.equals("rw.instance.setvolume")) {
            Map map = (Map) obj;
            if (map == null || map.size() != 2) {
                return null;
            }
            new StringBuilder("m.size() ").append(map.size());
            Float f = (Float) map.get(Style.LEFT);
            Float f2 = (Float) map.get(Style.RIGHT);
            new StringBuilder("rw.instance.setvolume left ").append(f).append(" right ").append(f2);
            setVolume(f.floatValue(), f2.floatValue());
            return Boolean.valueOf(true);
        } else if (str.equals("rw.instance.mute")) {
            setVolume(0.0f, 0.0f);
            return Boolean.valueOf(true);
        } else if (!str.equals("rw.instance.unmute")) {
            return null;
        } else {
            setVolume(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE);
            return Boolean.valueOf(true);
        }
    }

    public Object getGeneralOption(Object obj) {
        return null;
    }

    public static boolean isInitSuccess() {
        return a;
    }

    public void setStatisticHelper(IVideoStatistic iVideoStatistic) {
        new StringBuilder(">>> setStatisticHelper ").append(iVideoStatistic);
        this._VideoStatistic = iVideoStatistic;
        uploadApolloInitFailStatIfNeed();
    }

    public void uploadApolloInitFailStatIfNeed() {
        if (this.i == 1 && this._VideoStatistic != null && this.G != null) {
            if (new c(nativeGetStringExtValue(1, Global.EXT_KEY_APOLLO_STR)).a()) {
                HashMap hashMap = new HashMap();
                String a = com.UCMobile.Apollo.a.b.a();
                if (!(e.a(a) || g)) {
                    hashMap.put("a_load_err", a);
                    g = true;
                }
                if (!a) {
                    hashMap.put("a_player_type", SettingsConst.FALSE);
                }
                if (!h) {
                    hashMap.put("a_brand", Build.BRAND);
                    hashMap.put("a_model", Build.MODEL);
                    hashMap.put("a_sys", SettingsConst.TRUE);
                    a = getVersionString();
                    if (!e.a(a)) {
                        hashMap.put("a_version", a);
                    }
                    h = true;
                }
                if (!hashMap.isEmpty()) {
                    this._VideoStatistic.upload(hashMap);
                }
            }
            this.i = 2;
        }
    }

    public static void printStackTrace() {
        if (j) {
            try {
                throw new Exception();
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.NetworkInfo getActiveNetworkInfo(android.content.Context r4) {
        /*
        r1 = 0;
        r0 = "connectivity";
        r0 = r4.getSystemService(r0);	 Catch:{ Exception -> 0x0037 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x0037 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0037 }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r2 = r1.isConnected();	 Catch:{ Exception -> 0x003a }
        if (r2 != 0) goto L_0x0035;
    L_0x0019:
        r2 = r0.getAllNetworkInfo();	 Catch:{ Exception -> 0x003a }
        if (r2 == 0) goto L_0x0035;
    L_0x001f:
        r0 = 0;
    L_0x0020:
        r3 = r2.length;	 Catch:{ Exception -> 0x003a }
        if (r0 >= r3) goto L_0x0035;
    L_0x0023:
        r3 = r2[r0];	 Catch:{ Exception -> 0x003a }
        if (r3 == 0) goto L_0x0032;
    L_0x0027:
        r3 = r2[r0];	 Catch:{ Exception -> 0x003a }
        r3 = r3.isConnected();	 Catch:{ Exception -> 0x003a }
        if (r3 == 0) goto L_0x0032;
    L_0x002f:
        r0 = r2[r0];	 Catch:{ Exception -> 0x003a }
        goto L_0x000c;
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x0020;
    L_0x0035:
        r0 = r1;
        goto L_0x000c;
    L_0x0037:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000c;
    L_0x003a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.UCMobile.Apollo.MediaPlayer.getActiveNetworkInfo(android.content.Context):android.net.NetworkInfo");
    }

    public ApolloMetaData getApolloMetaData() {
        return this.M;
    }

    static /* synthetic */ void b(MediaPlayer mediaPlayer) {
        printStackTrace();
        if (mediaPlayer.t != d.STARTED) {
            new StringBuilder("call _pauseToBuffering in error state:").append(mediaPlayer.t);
        } else {
            mediaPlayer._nativePause(mediaPlayer.K);
        }
    }

    static /* synthetic */ void d(MediaPlayer mediaPlayer) {
        printStackTrace();
        if (mediaPlayer.t != d.STARTED) {
            new StringBuilder("call _playFromBuffering in error state ").append(mediaPlayer.t);
        } else if (mediaPlayer._nativePlay(mediaPlayer.K)) {
            mediaPlayer.J = true;
            mediaPlayer.c();
        }
    }
}
