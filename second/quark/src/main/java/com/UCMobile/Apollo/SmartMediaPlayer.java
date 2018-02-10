package com.UCMobile.Apollo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.UCMobile.Apollo.MediaPlayer.IRequestExternalValueListener;
import com.UCMobile.Apollo.annotations.Keep;
import com.UCMobile.Apollo.text.PlayerPositionProvider;
import com.UCMobile.Apollo.text.SubtitleHelper;
import java.io.IOException;
import java.util.Map;

/* compiled from: ProGuard */
public class SmartMediaPlayer {
    private SubtitleHelper a;
    private MediaPlayer b = null;
    private MediaPlayer c = null;
    private int d = c.a;
    private int e = c.a;
    private boolean f = false;
    private boolean g = false;
    private b h = new b(this);
    private a i = new a(this);
    private PlayerType j = PlayerType.NONE;
    private Context k = null;
    private String l = null;
    private Map<String, String> m = null;
    private OnInfoListener n = null;
    private OnErrorListener o = null;
    private OnBufferingUpdateListener p = null;
    private OnPreparedListener q = null;
    private OnSeekCompleteListener r = null;
    private OnVideoSizeChangedListener s = null;
    private OnCompletionListener t = null;
    private OnPlayerDeterminedListener u = null;
    private IRequestExternalValueListener v = null;
    private OnCachedPositionsListener w = null;

    /* compiled from: ProGuard */
    public interface OnErrorListener {
        boolean onError(SmartMediaPlayer smartMediaPlayer, int i, int i2);
    }

    /* compiled from: ProGuard */
    public interface OnPreparedListener {
        void onPrepared(SmartMediaPlayer smartMediaPlayer);
    }

    /* compiled from: ProGuard */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(SmartMediaPlayer smartMediaPlayer, int i);
    }

    /* compiled from: ProGuard */
    public interface OnCachedPositionsListener {
        void onCachedPositions(SmartMediaPlayer smartMediaPlayer, Map map);
    }

    /* compiled from: ProGuard */
    public interface OnCompletionListener {
        void onCompletion(SmartMediaPlayer smartMediaPlayer);
    }

    /* compiled from: ProGuard */
    public interface OnInfoListener {
        boolean onInfo(SmartMediaPlayer smartMediaPlayer, int i, int i2);
    }

    /* compiled from: ProGuard */
    public interface OnPlayerDeterminedListener {
        void onPlayerDetermined(PlayerType playerType);
    }

    /* compiled from: ProGuard */
    public interface OnPreloadListener {
        void onPreloadFinish(SmartMediaPlayer smartMediaPlayer);
    }

    /* compiled from: ProGuard */
    public interface OnSeekCompleteListener {
        void onSeekComplete(SmartMediaPlayer smartMediaPlayer);
    }

    /* compiled from: ProGuard */
    public interface OnTimedTextListener {
        void onTimedText(SmartMediaPlayer smartMediaPlayer, TimedText timedText);
    }

    /* compiled from: ProGuard */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(SmartMediaPlayer smartMediaPlayer, int i, int i2);
    }

    @Keep
    /* compiled from: ProGuard */
    public enum PlayerType {
        NONE,
        SYSTEM_PLAYER,
        R2_PLAYER
    }

    /* compiled from: ProGuard */
    final class a implements IRequestExternalValueListener, com.UCMobile.Apollo.MediaPlayer.OnBufferingUpdateListener, com.UCMobile.Apollo.MediaPlayer.OnCachedPositionsListener, com.UCMobile.Apollo.MediaPlayer.OnCompletionListener, com.UCMobile.Apollo.MediaPlayer.OnErrorListener, com.UCMobile.Apollo.MediaPlayer.OnInfoListener, com.UCMobile.Apollo.MediaPlayer.OnPreparedListener, com.UCMobile.Apollo.MediaPlayer.OnSeekCompleteListener, com.UCMobile.Apollo.MediaPlayer.OnVideoSizeChangedListener {
        final /* synthetic */ SmartMediaPlayer a;

        a(SmartMediaPlayer smartMediaPlayer) {
            this.a = smartMediaPlayer;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            if (this.a.t != null) {
                this.a.t.onCompletion(this.a);
            }
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.a.p != null) {
                this.a.p.onBufferingUpdate(this.a, i);
            }
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.a.o != null) {
                return this.a.o.onError(this.a, i, i2);
            }
            return false;
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.a.n != null) {
                return this.a.n.onInfo(this.a, i, i2);
            }
            return false;
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            this.a.e = c.c;
            if (this.a.u != null) {
                this.a.u.onPlayerDetermined(PlayerType.R2_PLAYER);
            }
            this.a.j = PlayerType.R2_PLAYER;
            if (this.a.q != null) {
                this.a.q.onPrepared(this.a);
            }
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.a.e == c.c && this.a.r != null) {
                this.a.r.onSeekComplete(this.a);
            }
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.a.e == c.c && this.a.s != null) {
                this.a.s.onVideoSizeChanged(this.a, i, i2);
            }
        }

        public final int getIntValue(int i, String str) {
            if (this.a.v != null) {
                return this.a.v.getIntValue(i, str);
            }
            return 0;
        }

        public final float getFloatValue(int i, String str) {
            if (this.a.v != null) {
                return this.a.v.getFloatValue(i, str);
            }
            return 0.0f;
        }

        public final String getStringValue(int i, String str) {
            if (this.a.v != null) {
                return this.a.v.getStringValue(i, str);
            }
            return null;
        }

        public final void onCachedPositions(MediaPlayer mediaPlayer, Map map) {
            if (this.a.w != null) {
                this.a.w.onCachedPositions(this.a, map);
            }
        }
    }

    /* compiled from: ProGuard */
    final class b implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnVideoSizeChangedListener {
        final /* synthetic */ SmartMediaPlayer a;

        b(SmartMediaPlayer smartMediaPlayer) {
            this.a = smartMediaPlayer;
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.a.p != null) {
                this.a.p.onBufferingUpdate(this.a, i);
            }
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            if (this.a.f) {
                this.a.f = false;
            }
            if (this.a.g) {
                this.a.g = false;
            }
            if (this.a.d == c.b) {
                try {
                    this.a.b.reset();
                } catch (Exception e) {
                    this.a.d = c.b;
                }
            }
            if (this.a.d == c.c && this.a.t != null) {
                this.a.t.onCompletion(this.a);
            }
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            this.a.d = c.b;
            this.a.g = false;
            try {
                this.a.b.reset();
            } catch (Exception e) {
                this.a.d = c.b;
            }
            if (this.a.o != null) {
                return this.a.o.onError(this.a, i, i2);
            }
            return false;
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.a.n != null) {
                return this.a.n.onInfo(this.a, i, i2);
            }
            return false;
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            this.a.d = c.c;
            if (this.a.u != null) {
                this.a.u.onPlayerDetermined(PlayerType.SYSTEM_PLAYER);
            }
            this.a.e = c.b;
            this.a.j = PlayerType.SYSTEM_PLAYER;
            try {
                if (this.a.q != null) {
                    this.a.q.onPrepared(this.a);
                }
            } catch (Exception e) {
            }
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.a.d == c.c && this.a.r != null) {
                this.a.r.onSeekComplete(this.a);
            }
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.a.d == c.c && this.a.s != null) {
                this.a.s.onVideoSizeChanged(this.a, i, i2);
            }
        }
    }

    /* compiled from: ProGuard */
    final class c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = new int[]{a, b, c};
    }

    public SmartMediaPlayer(Context context) {
        this.k = context;
        try {
            this.b = new MediaPlayer();
            if (this.b != null) {
                this.b.setOnBufferingUpdateListener(this.h);
                this.b.setOnCompletionListener(this.h);
                this.b.setOnErrorListener(this.h);
                this.b.setOnInfoListener(this.h);
                this.b.setOnPreparedListener(this.h);
                this.b.setOnSeekCompleteListener(this.h);
                this.b.setOnVideoSizeChangedListener(this.h);
            }
            a();
        } catch (Exception e) {
            this.d = c.b;
        }
        this.c = new MediaPlayer(context);
        if (this.c != null) {
            this.c.setOnBufferingUpdateListener(this.i);
            this.c.setOnCompletionListener(this.i);
            this.c.setOnErrorListener(this.i);
            this.c.setOnInfoListener(this.i);
            this.c.setOnPreparedListener(this.i);
            this.c.setOnSeekCompleteListener(this.i);
            this.c.setOnVideoSizeChangedListener(this.i);
            this.c.setExternalValueListener(this.i);
            this.c.setOnCachedPositionsListener(this.i);
        }
        this.e = c.a;
        if (MediaPlayer.isInitSuccess()) {
            this.j = PlayerType.NONE;
        } else {
            this.j = PlayerType.SYSTEM_PLAYER;
        }
    }

    public static SmartMediaPlayer create(Context context, String str, SurfaceHolder surfaceHolder) {
        try {
            SmartMediaPlayer smartMediaPlayer = new SmartMediaPlayer(context);
            smartMediaPlayer.setDataSource(str);
            smartMediaPlayer.setDisplay(surfaceHolder);
            smartMediaPlayer.prepare();
            return smartMediaPlayer;
        } catch (Exception e) {
            return null;
        }
    }

    public static SmartMediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder) {
        try {
            SmartMediaPlayer smartMediaPlayer = new SmartMediaPlayer(context);
            smartMediaPlayer.setDataSource(context, uri);
            smartMediaPlayer.setDisplay(surfaceHolder);
            smartMediaPlayer.prepare();
            return smartMediaPlayer;
        } catch (Exception e) {
            return null;
        }
    }

    public void setDataSource(String str) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(str, null);
    }

    public void setDataSource(String str, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        this.l = str;
        this.m = map;
    }

    public void setDataSource(Context context, Uri uri) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(uri.toString());
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException, SecurityException {
        setDataSource(uri.toString(), (Map) map);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.b != null && (this.j == PlayerType.NONE || this.j == PlayerType.SYSTEM_PLAYER)) {
            try {
                this.b.setDisplay(surfaceHolder);
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c == null) {
            return;
        }
        if (this.j == PlayerType.NONE || this.j == PlayerType.R2_PLAYER) {
            this.c.setDisplay(surfaceHolder);
        }
    }

    public void setSurface(Surface surface) {
        if (this.b != null && (this.j == PlayerType.NONE || this.j == PlayerType.SYSTEM_PLAYER)) {
            try {
                this.b.setSurface(surface);
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c == null) {
            return;
        }
        if (this.j == PlayerType.NONE || this.j == PlayerType.R2_PLAYER) {
            this.c.setSurface(surface);
        }
    }

    public void setInitPlaybackTime(int i) {
        if (this.c == null) {
            return;
        }
        if (this.j == PlayerType.NONE || this.j == PlayerType.R2_PLAYER) {
            this.c.setInitPlaybackTime(i);
        }
    }

    public void setPlayerType(PlayerType playerType) {
        if (playerType == PlayerType.R2_PLAYER && !MediaPlayer.isInitSuccess()) {
            this.j = PlayerType.SYSTEM_PLAYER;
        } else if (this.j != playerType) {
            this.j = playerType;
        }
    }

    public void prepare() throws IllegalStateException, IOException {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            this.e = c.b;
            this.c.reset();
            if (this.l != null) {
                try {
                    if (this.m == null) {
                        this.b.setDataSource(this.l);
                    } else {
                        this.b.setDataSource(this.k, Uri.parse(this.l), this.m);
                    }
                } catch (Throwable e) {
                    this.d = c.b;
                    throw new IllegalStateException(e);
                }
            }
            try {
                b();
                this.d = c.c;
            } catch (IllegalStateException e2) {
                this.d = c.b;
                throw e2;
            } catch (IOException e3) {
                this.d = c.b;
                throw e3;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.d = c.b;
            this.b.reset();
            try {
                this.c.setDataSource(this.l, this.m);
                this.c.prepare();
                this.e = c.c;
            } catch (IllegalStateException e22) {
                this.e = c.b;
                throw e22;
            } catch (IOException e32) {
                this.e = c.b;
                throw e32;
            }
        } else {
            if (!(MediaPlayer.isInitSuccess() || this.b == null || this.d == c.b)) {
                this.f = true;
                try {
                    if (this.m == null) {
                        this.b.setDataSource(this.l);
                    } else {
                        this.b.setDataSource(this.k, Uri.parse(this.l), this.m);
                    }
                    b();
                    this.d = c.c;
                    if (this.u != null) {
                        this.u.onPlayerDetermined(PlayerType.SYSTEM_PLAYER);
                    }
                    this.j = PlayerType.SYSTEM_PLAYER;
                } catch (Exception e4) {
                    this.d = c.b;
                }
                this.f = false;
            }
            if (this.d == c.c) {
                this.e = c.b;
            } else if (MediaPlayer.isInitSuccess() && this.d == c.b && this.c != null) {
                try {
                    this.c.setDataSource(this.l, this.m);
                    this.c.prepare();
                    this.e = c.c;
                    this.d = c.b;
                    if (this.u != null) {
                        this.u.onPlayerDetermined(PlayerType.R2_PLAYER);
                    }
                    this.j = PlayerType.R2_PLAYER;
                } catch (IllegalStateException e222) {
                    throw e222;
                } catch (IOException e322) {
                    throw e322;
                }
            } else {
                throw new IOException("No player can handle this video.");
            }
        }
    }

    public void prepareAsync() throws IllegalStateException {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            this.e = c.b;
            this.c.reset();
            this.g = true;
            try {
                if (this.m == null) {
                    this.b.setDataSource(this.l);
                } else {
                    this.b.setDataSource(this.k, Uri.parse(this.l), this.m);
                }
                this.b.prepareAsync();
            } catch (Throwable e) {
                new StringBuilder("prepareAsync()  Exception:").append(e.getMessage());
                new StringBuilder("prepareAsync()  Exception:").append(e.getCause());
                throw new IllegalStateException(e);
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.d = c.b;
            try {
                this.b.reset();
            } catch (Exception e2) {
                this.d = c.b;
            }
            try {
                this.c.setDataSource(this.l, this.m);
                this.c.prepareAsync();
            } catch (Throwable e3) {
                throw new IllegalStateException(e3);
            }
        } else {
            if (!(MediaPlayer.isInitSuccess() || this.b == null || this.d == c.b)) {
                try {
                    if (this.m == null) {
                        this.b.setDataSource(this.l);
                    } else {
                        this.b.setDataSource(this.k, Uri.parse(this.l), this.m);
                    }
                    this.g = true;
                    this.b.prepareAsync();
                    return;
                } catch (Exception e4) {
                    new StringBuilder("Exception in trying system player: ").append(e4.getMessage());
                    this.g = false;
                    this.d = c.b;
                    this.b.reset();
                }
            }
            if (!MediaPlayer.isInitSuccess() || this.c == null) {
                throw new IllegalStateException("No player.");
            }
            try {
                this.c.setDataSource(this.l, this.m);
                this.c.prepareAsync();
            } catch (Throwable e32) {
                throw new IllegalStateException(e32);
            }
        }
    }

    public void reset() {
        if (this.b != null) {
            try {
                this.b.reset();
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c != null) {
            this.c.reset();
        }
        a();
        this.e = c.a;
        this.j = PlayerType.NONE;
    }

    public void start() {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                this.b.start();
            } catch (Exception e) {
                this.d = c.b;
            }
            if (this.c != null) {
                this.c.uploadApolloInitFailStatIfNeed();
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.c.start();
        }
    }

    public void stop() {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                this.b.stop();
            } catch (Exception e) {
                this.d = c.b;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.c.stop();
        }
    }

    public void pause() {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                this.b.pause();
            } catch (Exception e) {
                this.d = c.b;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.c.pause();
        }
    }

    public void seekTo(int i) {
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                this.b.seekTo(i);
            } catch (Exception e) {
                this.d = c.b;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            this.c.seekTo(i);
        }
    }

    public boolean isPlaying() {
        boolean z = false;
        try {
            if (this.j == PlayerType.SYSTEM_PLAYER) {
                try {
                    z = this.b.isPlaying();
                } catch (Exception e) {
                    this.d = c.b;
                }
            } else if (this.j == PlayerType.R2_PLAYER) {
                z = this.c.isPlaying();
            }
        } catch (Exception e2) {
        }
        return z;
    }

    public int getCurrentPosition() {
        int i = 0;
        try {
            if (this.j == PlayerType.SYSTEM_PLAYER) {
                try {
                    i = this.b.getCurrentPosition();
                } catch (Exception e) {
                    this.d = c.b;
                }
            } else if (this.j == PlayerType.R2_PLAYER) {
                i = this.c.getCurrentPosition();
            }
        } catch (Exception e2) {
        }
        return i;
    }

    public int getDuration() {
        int i = 0;
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                return this.b.getDuration();
            } catch (Exception e) {
                this.d = c.b;
                return i;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            return this.c.getDuration();
        } else {
            return i;
        }
    }

    public int getPlayableDuration() {
        if (this.j != PlayerType.R2_PLAYER || this.c == null) {
            return 0;
        }
        return this.c.getPlayableDuration();
    }

    public int getVideoHeight() {
        int i = 0;
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                return this.b.getVideoHeight();
            } catch (Exception e) {
                this.d = c.b;
                return i;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            return this.c.getVideoHeight();
        } else {
            return i;
        }
    }

    public int getVideoWidth() {
        int i = 0;
        if (this.j == PlayerType.SYSTEM_PLAYER) {
            try {
                return this.b.getVideoWidth();
            } catch (Exception e) {
                this.d = c.b;
                return i;
            }
        } else if (this.j == PlayerType.R2_PLAYER) {
            return this.c.getVideoWidth();
        } else {
            return i;
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.b != null) {
            try {
                this.b.setScreenOnWhilePlaying(z);
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c != null) {
            this.c.setScreenOnWhilePlaying(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.b != null) {
            try {
                this.b.setVolume(f, f2);
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c != null) {
            this.c.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        if (this.b != null) {
            try {
                this.b.setWakeMode(context, i);
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c != null) {
            this.c.setWakeMode(context, i);
        }
    }

    public PlayerType getPlayerType() {
        return this.j;
    }

    public String[] getAudioTrackTitles() {
        if (this.j == PlayerType.SYSTEM_PLAYER || this.j != PlayerType.R2_PLAYER || this.c == null) {
            return null;
        }
        return this.c.getAudioTrackTitles();
    }

    public int getCurrentAudioTrackIndex() {
        if (this.j != PlayerType.R2_PLAYER || this.c == null) {
            return -1;
        }
        return this.c.getAudioTrackIndex();
    }

    public void setCurrentAudioTrackIndex(int i) {
        if (this.j == PlayerType.R2_PLAYER && this.c != null) {
            this.c.setAudioTrack(i);
        }
    }

    public Bitmap getCurrentVideoFrame(int i, int i2) {
        if (this.j != PlayerType.R2_PLAYER || this.c == null) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            i = this.c.getVideoWidth();
            i2 = this.c.getVideoHeight();
        }
        return this.c.getCurrentVideoFrame(i, i2);
    }

    public Bitmap getCurrentFrame() {
        return getCurrentVideoFrame(getVideoWidth(), getVideoHeight());
    }

    public float getFPS() {
        if (this.j == PlayerType.R2_PLAYER) {
            return this.c.getFPS();
        }
        return 0.0f;
    }

    public float getAverageFPS() {
        if (this.j == PlayerType.R2_PLAYER) {
            return this.c.getAverageFPS();
        }
        return 0.0f;
    }

    public static int setGlobalOption(String str, String str2) {
        return MediaPlayer.setGlobalOption(str, str2);
    }

    public static String getGlobalOption(String str) {
        return MediaPlayer.getGlobalOption(str);
    }

    public static int setGlobalOptions(Map<String, String> map) {
        return MediaPlayer.setGlobalOptions(map);
    }

    public static Map<String, String> getGlobalOptions() {
        return MediaPlayer.getGlobalOptions();
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
        if (this.c != null) {
            return this.c.setOption(str, str2);
        }
        return -1;
    }

    public String getOption(String str) {
        if (this.c != null) {
            return this.c.getOption(str);
        }
        return "";
    }

    public int setOptions(Map<String, String> map) {
        if (this.c != null) {
            return this.c.setOptions(map);
        }
        return -1;
    }

    public Map<String, String> getOptions() {
        if (this.c != null) {
            return this.c.getOptions();
        }
        return null;
    }

    public Object setGeneralOption(String str, Object obj) {
        if (str.equals("ro.instance.start_subtitle")) {
            this.a = SubtitleHelper.createSubtitle((Map) obj, this.k, new PlayerPositionProvider(this) {
                final /* synthetic */ SmartMediaPlayer a;

                {
                    this.a = r1;
                }

                public final int getCurrentPosition() {
                    return this.a.getCurrentPosition();
                }
            });
            if (this.a != null) {
                return this.a.getSubtitleView();
            }
            return null;
        } else if (str.equals("ro.instance.pause_subtitle")) {
            if (this.a == null) {
                return null;
            }
            this.a.pauseSubtitle((Map) obj);
            return null;
        } else if (str.equals("ro.instance.stop_subtitle")) {
            if (this.a == null) {
                return null;
            }
            this.a.stopSubtitle();
            return null;
        } else if (this.c != null) {
            return this.c.setGeneralOption(str, obj);
        } else {
            return null;
        }
    }

    public Object getGeneralOption(Object obj) {
        if (this.c != null) {
            return this.c.getGeneralOption(obj);
        }
        return null;
    }

    public void setExternalValueListener(IRequestExternalValueListener iRequestExternalValueListener) {
        this.v = iRequestExternalValueListener;
    }

    public void setOnCachedPositionsListener(OnCachedPositionsListener onCachedPositionsListener) {
        this.w = onCachedPositionsListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.n = onInfoListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.o = onErrorListener;
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.p = onBufferingUpdateListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.r = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.s = onVideoSizeChangedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.t = onCompletionListener;
    }

    public void setOnPlayerDeterminedListener(OnPlayerDeterminedListener onPlayerDeterminedListener) {
        this.u = onPlayerDeterminedListener;
    }

    private void a() {
        this.d = c.a;
        this.g = false;
        this.f = false;
    }

    private void b() throws IllegalStateException, IOException {
        c cVar = new c(this.b);
        a aVar = new a(cVar, cVar.a);
        aVar.start();
        while (aVar.isAlive()) {
            try {
                aVar.join();
            } catch (InterruptedException e) {
            }
        }
        if (aVar.a == 0) {
            return;
        }
        if (aVar.a == 2) {
            throw new IllegalStateException(aVar.b);
        }
        throw new IOException(aVar.b);
    }

    public void setStatisticHelper(IVideoStatistic iVideoStatistic) {
        if (this.c != null) {
            this.c.setStatisticHelper(iVideoStatistic);
        }
    }

    public ApolloMetaData getApolloMetaData() {
        if (this.c != null) {
            return this.c.getApolloMetaData();
        }
        return null;
    }

    public void release() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        if (this.b != null) {
            try {
                this.b.release();
            } catch (Exception e) {
                this.d = c.b;
            }
        }
        if (this.c != null) {
            this.c.release();
        }
    }
}
