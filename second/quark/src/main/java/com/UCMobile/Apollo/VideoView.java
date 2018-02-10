package com.UCMobile.Apollo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.UCMobile.Apollo.MediaPlayer.IRequestExternalValueListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnBufferingUpdateListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnCachedPositionsListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnCompletionListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnErrorListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnInfoListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnPlayerDeterminedListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnPreloadListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnPreparedListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnVideoSizeChangedListener;
import com.UCMobile.Apollo.SmartMediaPlayer.PlayerType;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.io.IOException;
import java.util.Map;

/* compiled from: ProGuard */
public class VideoView extends SurfaceView implements MediaPlayerControl {
    private OnErrorListener A;
    private OnInfoListener B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private IVideoStatistic G;
    private OnCachedPositionsListener H;
    private boolean I;
    private VideoViewManager J;
    private OnCompletionListener K;
    private OnErrorListener L;
    private OnCachedPositionsListener M;
    private boolean N;
    private OnBufferingUpdateListener O;
    PlayerType a;
    OnPlayerDeterminedListener b;
    OnVideoSizeChangedListener c;
    OnPreparedListener d;
    Callback e;
    private String f;
    private Uri g;
    private Map<String, String> h;
    private int i;
    private int j;
    private SurfaceHolder k;
    private SmartMediaPlayer l;
    private SmartMediaPlayer m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private MediaController t;
    private OnCompletionListener u;
    private OnPreparedListener v;
    private OnBufferingUpdateListener w;
    private OnPreloadListener x;
    private IRequestExternalValueListener y;
    private int z;

    public VideoView(Context context) {
        super(context);
        this.f = "com.UCMobile.Apollo.VideoView";
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 0;
        this.I = false;
        this.a = PlayerType.NONE;
        this.J = null;
        this.b = new OnPlayerDeterminedListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onPlayerDetermined(PlayerType playerType) {
                new StringBuilder("Player type determined: ").append(playerType);
            }
        };
        this.c = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onVideoSizeChanged(SmartMediaPlayer smartMediaPlayer, int i, int i2) {
                this.a.o = smartMediaPlayer.getVideoWidth();
                this.a.p = smartMediaPlayer.getVideoHeight();
                if (this.a.o != 0 && this.a.p != 0) {
                    this.a.getHolder().setFixedSize(this.a.o, this.a.p);
                    this.a.requestLayout();
                }
            }
        };
        this.d = new OnPreparedListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onPrepared(SmartMediaPlayer smartMediaPlayer) {
                MediaPlayer.printStackTrace();
                this.a.b();
                synchronized (this) {
                    this.a.i = 2;
                }
                if (!this.a.N) {
                    this.a.D = this.a.E = this.a.F = true;
                    if (this.a.v != null) {
                        this.a.v.onPrepared(this.a.l);
                    }
                    if (this.a.t != null) {
                        this.a.t.setEnabled(true);
                    }
                    this.a.o = smartMediaPlayer.getVideoWidth();
                    this.a.p = smartMediaPlayer.getVideoHeight();
                    int j = this.a.C;
                    if (this.a.l.getPlayerType() == PlayerType.SYSTEM_PLAYER && this.a.s > j) {
                        j = this.a.s;
                        new StringBuilder("system player seek to mInitPlaybackTime ").append(this.a.s);
                    }
                    this.a.s = 0;
                    if (j != 0) {
                        this.a.seekTo(j);
                    }
                    if (this.a.o != 0 && this.a.p != 0) {
                        this.a.getHolder().setFixedSize(this.a.o, this.a.p);
                        if (this.a.q != this.a.o || this.a.r != this.a.p) {
                            return;
                        }
                        if (this.a.j == 3) {
                            this.a.start();
                            if (this.a.t != null) {
                                this.a.t.show();
                            }
                        } else if (!this.a.isPlaying()) {
                            if ((j != 0 || this.a.getCurrentPosition() > 0) && this.a.t != null) {
                                this.a.t.show(0);
                            }
                        }
                    } else if (this.a.j == 3) {
                        this.a.start();
                    }
                } else if (this.a.x != null) {
                    this.a.x.onPreloadFinish(smartMediaPlayer);
                }
            }
        };
        this.K = new OnCompletionListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onCompletion(SmartMediaPlayer smartMediaPlayer) {
                MediaPlayer.printStackTrace();
                synchronized (this) {
                    this.a.i = 5;
                    this.a.j = 5;
                }
                if (this.a.t != null) {
                    this.a.t.hide();
                }
                if (this.a.u != null) {
                    this.a.u.onCompletion(this.a.l);
                }
            }
        };
        this.L = new OnErrorListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final boolean onError(SmartMediaPlayer smartMediaPlayer, int i, int i2) {
                MediaPlayer.printStackTrace();
                new StringBuilder("Error: ").append(i).append(",").append(i2);
                synchronized (this) {
                    this.a.i = -1;
                    this.a.j = -1;
                }
                if (this.a.t != null) {
                    this.a.t.hide();
                }
                return (this.a.A == null || this.a.N || this.a.A.onError(this.a.l, i, i2)) ? true : true;
            }
        };
        this.M = new OnCachedPositionsListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onCachedPositions(SmartMediaPlayer smartMediaPlayer, Map map) {
                MediaPlayer.printStackTrace();
                new StringBuilder("onCachedPositions: ").append(map);
                if (this.a.H != null) {
                    this.a.H.onCachedPositions(smartMediaPlayer, map);
                }
            }
        };
        this.e = new Callback(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                boolean z = false;
                MediaPlayer.printStackTrace();
                this.a.q = i2;
                this.a.r = i3;
                boolean z2 = this.a.j == 3;
                if (this.a.o == i2 && this.a.p == i3) {
                    z = true;
                }
                new StringBuilder("surfaceChanged format ").append(i).append(", w ").append(i2).append(", h ").append(i3).append(", mUri = ").append(this.a.g).append(", mMediaPlayer = ").append(this.a.l).append(", isValidState = ").append(z2).append(", hasValidSize ").append(z).append(", visible ").append(this.a.getVisibility());
                if (this.a.l != null && z2 && z) {
                    if (this.a.C != 0) {
                        this.a.seekTo(this.a.C);
                    }
                    this.a.start();
                }
                if (this.a.I) {
                    this.a.start();
                    this.a.I = false;
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                MediaPlayer.printStackTrace();
                new StringBuilder("surfaceCreated ").append(surfaceHolder);
                this.a.k = surfaceHolder;
                VideoView.v(this.a);
                if (this.a.l != null) {
                    this.a.l.setDisplay(this.a.k);
                } else {
                    this.a.a();
                }
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                MediaPlayer.printStackTrace();
                new StringBuilder("surfaceDestroyed ").append(surfaceHolder);
                this.a.k = null;
                if (this.a.t != null) {
                    this.a.t.hide();
                }
                VideoView.y(this.a);
            }
        };
        this.N = false;
        this.O = new OnBufferingUpdateListener(this) {
            final /* synthetic */ VideoView a;

            {
                this.a = r1;
            }

            public final void onBufferingUpdate(SmartMediaPlayer smartMediaPlayer, int i) {
                this.a.z = i;
                if (this.a.w != null) {
                    this.a.w.onBufferingUpdate(smartMediaPlayer, i);
                }
            }
        };
        a(context);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "com.UCMobile.Apollo.VideoView";
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 0;
        this.I = false;
        this.a = PlayerType.NONE;
        this.J = null;
        this.b = /* anonymous class already generated */;
        this.c = /* anonymous class already generated */;
        this.d = /* anonymous class already generated */;
        this.K = /* anonymous class already generated */;
        this.L = /* anonymous class already generated */;
        this.M = /* anonymous class already generated */;
        this.e = /* anonymous class already generated */;
        this.N = false;
        this.O = /* anonymous class already generated */;
        a(context);
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.o, i);
        int defaultSize2 = getDefaultSize(this.p, i2);
        if (this.o > 0 && this.p > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == UCCore.VERIFY_POLICY_QUICK && mode2 == UCCore.VERIFY_POLICY_QUICK) {
                if (this.o * defaultSize2 < this.p * size) {
                    defaultSize = (this.o * defaultSize2) / this.p;
                } else if (this.o * defaultSize2 > this.p * size) {
                    defaultSize2 = (this.p * size) / this.o;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == UCCore.VERIFY_POLICY_QUICK) {
                defaultSize = (this.p * size) / this.o;
                if (mode2 != SectionHeader.SHT_LOUSER || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == UCCore.VERIFY_POLICY_QUICK) {
                defaultSize = (this.o * defaultSize2) / this.p;
                if (mode == SectionHeader.SHT_LOUSER && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.o;
                defaultSize = this.p;
                if (mode2 != SectionHeader.SHT_LOUSER || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.o * defaultSize2) / this.p;
                }
                if (mode == SectionHeader.SHT_LOUSER && r1 > size) {
                    defaultSize2 = (this.p * size) / this.o;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public int resolveAdjustedSize(int i, int i2) {
        return getDefaultSize(i, i2);
    }

    private void a(Context context) {
        MediaPlayer.printStackTrace();
        this.o = 0;
        this.p = 0;
        this.s = 0;
        getHolder().addCallback(this.e);
        if (VERSION.SDK_INT >= 14) {
            getHolder().setType(3);
        } else if (!MediaPlayer.globalInitialization(context)) {
            getHolder().setType(3);
        }
        getHolder().setFormat(1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        synchronized (this) {
            this.i = 0;
            this.j = 0;
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        MediaPlayer.printStackTrace();
        if (this.g == null || this.g.compareTo(uri) != 0 || !this.N) {
            this.g = uri;
            this.h = map;
            this.C = 0;
            a();
            requestLayout();
            invalidate();
        }
    }

    public void setPlayerType(PlayerType playerType) {
        MediaPlayer.printStackTrace();
        if (this.a != playerType) {
            this.a = playerType;
        }
    }

    public void setInitPlaybackTime(int i) {
        MediaPlayer.printStackTrace();
        this.s = i;
    }

    public void stopPlayback() {
        MediaPlayer.printStackTrace();
        if (this.l != null) {
            try {
                synchronized (this) {
                    this.i = 6;
                    this.l.stop();
                    this.l.release();
                    this.l = null;
                    synchronized (this) {
                        this.i = 0;
                        this.j = 0;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void a() {
        MediaPlayer.printStackTrace();
        new StringBuilder("openVideo called. mUri = ").append(this.g).append(" mSurfaceHolder = ").append(this.k);
        if (this.g != null && this.k != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            release(false);
            try {
                if (this.m != null) {
                    this.l = this.m;
                    this.m = null;
                } else {
                    this.l = new SmartMediaPlayer(getContext());
                }
                if (this.J != null) {
                    this.J.a();
                } else {
                    this.J = new VideoViewManager(getContext());
                }
                if (this.G != null) {
                    this.l.setStatisticHelper(this.G);
                }
                this.l.setOnPreparedListener(this.d);
                this.l.setOnVideoSizeChangedListener(this.c);
                this.l.setOnCompletionListener(this.K);
                this.l.setOnErrorListener(this.L);
                this.l.setOnInfoListener(this.B);
                this.l.setOnBufferingUpdateListener(this.O);
                this.l.setExternalValueListener(this.y);
                this.l.setOnCachedPositionsListener(this.M);
                this.z = 0;
                this.l.setPlayerType(this.a);
                this.l.setDataSource(getContext(), this.g, this.h);
                this.l.setDisplay(this.k);
                this.l.setScreenOnWhilePlaying(true);
                if (this.s > 0) {
                    this.l.setInitPlaybackTime(this.s);
                }
                synchronized (this) {
                    this.i = 1;
                }
                this.l.prepareAsync();
            } catch (IOException e) {
                new StringBuilder("Unable to open content: ").append(this.g);
                synchronized (this) {
                    this.i = -1;
                    this.j = -1;
                    this.L.onError(this.l, 0, MediaPlayer.MEDIA_ERROR_UNKNOWN);
                }
            } catch (IllegalArgumentException e2) {
                new StringBuilder("Unable to open content: ").append(this.g);
                synchronized (this) {
                    this.i = -1;
                    this.j = -1;
                    this.L.onError(this.l, 0, MediaPlayer.MEDIA_ERROR_UNKNOWN);
                }
            } catch (IllegalStateException e3) {
                new StringBuilder("Unable to open content: ").append(this.g);
                synchronized (this) {
                    this.i = -1;
                    this.j = -1;
                    this.L.onError(this.l, 0, MediaPlayer.MEDIA_ERROR_UNKNOWN);
                }
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.t != null) {
            this.t.hide();
        }
        this.t = mediaController;
        b();
    }

    private void b() {
        if (this.l != null && this.t != null) {
            this.t.setMediaPlayer(this);
            this.t.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.t.setEnabled(isInPlaybackState());
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.v = onPreparedListener;
    }

    public void setOnPreloadListener(OnPreloadListener onPreloadListener) {
        this.x = onPreloadListener;
    }

    public void setOnCachedPositionsListener(OnCachedPositionsListener onCachedPositionsListener) {
        this.H = onCachedPositionsListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.u = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.A = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.B = onInfoListener;
    }

    public void release(boolean z) {
        MediaPlayer.printStackTrace();
        if (this.l != null) {
            try {
                synchronized (this) {
                    this.i = 6;
                }
                this.l.reset();
                this.l.release();
                this.l = null;
                synchronized (this) {
                    this.i = 0;
                }
                if (z) {
                    this.j = 0;
                }
            } catch (Exception e) {
                new StringBuilder("mMediaPlayer release exception ").append(e.toString());
            }
        }
        if (this.J != null) {
            BroadcastReceiver broadcastReceiver = this.J;
            synchronized (broadcastReceiver) {
                new StringBuilder("VideoViewManager release context ").append(broadcastReceiver.b);
                if (broadcastReceiver.b != null) {
                    try {
                        broadcastReceiver.b.unregisterReceiver(broadcastReceiver);
                    } catch (Exception e2) {
                    }
                    broadcastReceiver.b = null;
                }
                broadcastReceiver.a();
            }
            this.J = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isInPlaybackState() && this.t != null) {
            c();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isInPlaybackState() && this.t != null) {
            c();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        boolean z2 = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (VERSION.SDK_INT < 11) {
            z = z2;
        } else if (z2 && i != 164) {
            z = true;
        }
        if (isInPlaybackState() && r2 && this.t != null) {
            if (i == 79 || i == 85) {
                if (this.l.isPlaying()) {
                    pause();
                    this.t.show();
                    return true;
                }
                start();
                this.t.hide();
                return true;
            } else if (i == 126) {
                if (this.l.isPlaying()) {
                    return true;
                }
                start();
                this.t.hide();
                return true;
            } else if (i != 86 && i != UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                c();
            } else if (!this.l.isPlaying()) {
                return true;
            } else {
                pause();
                this.t.show();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void c() {
        if (this.t.isShowing()) {
            this.t.hide();
        } else {
            this.t.show();
        }
    }

    public void start() {
        MediaPlayer.printStackTrace();
        if (this.l == null) {
            a();
        }
        new StringBuilder("start() isInPlaybackState() = ").append(isInPlaybackState());
        if (this.N) {
            this.N = false;
            if (this.i == 2) {
                this.d.onPrepared(this.l);
            }
            if (this.i == -1) {
                a();
            }
        }
        if (isInPlaybackState()) {
            this.l.start();
            synchronized (this) {
                this.i = 3;
            }
        }
        this.j = 3;
    }

    public void pause() {
        MediaPlayer.printStackTrace();
        if (isInPlaybackState() && this.l.isPlaying()) {
            this.l.pause();
            synchronized (this) {
                this.i = 4;
            }
        }
        this.j = 4;
    }

    public void suspend() {
        MediaPlayer.printStackTrace();
        release(false);
    }

    public void resume() {
        MediaPlayer.printStackTrace();
        a();
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.l.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.l.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        MediaPlayer.printStackTrace();
        if (isInPlaybackState()) {
            this.l.seekTo(i);
            this.C = 0;
            return;
        }
        this.C = i;
    }

    public boolean isPlaying() {
        if (this.l == null || !isInPlaybackState()) {
            return false;
        }
        boolean isPlaying = this.l.isPlaying();
        if (this.j == 3 && !isPlaying) {
            isPlaying = true;
        }
        if (isInPlaybackState() && r0) {
            return true;
        }
        return false;
    }

    public int getBufferPercentage() {
        if (this.l != null) {
            return this.z;
        }
        return 0;
    }

    protected boolean isInPlaybackState() {
        return d() && !this.N;
    }

    private boolean d() {
        synchronized (this) {
            boolean z = (this.i == -1 || this.i == 0 || this.i == 1 || this.i == 6) ? false : true;
        }
        if (this.l == null || !z) {
            return false;
        }
        return true;
    }

    public boolean canPause() {
        return this.D;
    }

    public boolean canSeekBackward() {
        return this.E;
    }

    public boolean canSeekForward() {
        return this.F;
    }

    public int getAudioSessionId() {
        return this.n;
    }

    public String[] getAudioTrackTitles() {
        return this.l.getAudioTrackTitles();
    }

    public int getCurrentAudioTrackIndex() {
        return this.l.getCurrentAudioTrackIndex();
    }

    public void setCurrentAudioTrackIndex(int i) {
        this.l.setCurrentAudioTrackIndex(i);
    }

    public Bitmap getCurrentVideoFrame(int i, int i2) {
        return this.l.getCurrentVideoFrame(i, i2);
    }

    public float getFPS() {
        if (this.l != null) {
            return this.l.getFPS();
        }
        return 0.0f;
    }

    public static int getApiVersion(Context context) {
        return MediaPlayer.getApiVersion(context);
    }

    public static int getApiVersion() {
        return MediaPlayer.getApiVersion();
    }

    public static String getVersionString(Context context) {
        return MediaPlayer.getVersionString(context);
    }

    public static String getVersionString() {
        return MediaPlayer.getVersionString();
    }

    public float getAverageFPS() {
        if (this.l != null) {
            return this.l.getAverageFPS();
        }
        return 0.0f;
    }

    public void setVolume(float f, float f2) {
        if (this.l != null) {
            this.l.setVolume(f, f2);
        }
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
        if (this.l != null) {
            return this.l.setOption(str, str2);
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.setOption(str, str2);
    }

    public String getOption(String str) {
        if (this.l != null) {
            return this.l.getOption(str);
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.getOption(str);
    }

    public int setOptions(Map<String, String> map) {
        if (this.l != null) {
            return this.l.setOptions(map);
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.setOptions(map);
    }

    public Map<String, String> getOptions() {
        if (this.l != null) {
            return this.l.getOptions();
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.getOptions();
    }

    public Object setGeneralOption(String str, Object obj) {
        if (this.l == null && str.equals("ro.instance.stop_subtitle")) {
            return null;
        }
        if (this.l != null) {
            return this.l.setGeneralOption(str, obj);
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.setGeneralOption(str, obj);
    }

    public Object getGeneralOption(Object obj) {
        if (this.l != null) {
            return this.l.getGeneralOption(obj);
        }
        if (this.m == null) {
            this.m = new SmartMediaPlayer(getContext());
        }
        return this.m.getGeneralOption(obj);
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.w = onBufferingUpdateListener;
    }

    public boolean preload(String str, String str2) {
        if (this.i != 0) {
            return false;
        }
        this.N = true;
        return true;
    }

    public void setExternalValueListener(IRequestExternalValueListener iRequestExternalValueListener) {
        this.y = iRequestExternalValueListener;
    }

    public void setStatisticHelper(IVideoStatistic iVideoStatistic) {
        this.G = iVideoStatistic;
        if (this.l != null) {
            this.l.setStatisticHelper(iVideoStatistic);
        }
    }

    public PlayerType getPlayerType() {
        if (this.l != null) {
            return this.l.getPlayerType();
        }
        return this.a;
    }

    public ApolloMetaData getApolloMetaData() {
        if (this.l != null) {
            return this.l.getApolloMetaData();
        }
        return null;
    }

    static /* synthetic */ void v(VideoView videoView) {
        new StringBuilder("onSurfaceCreated ").append(videoView.l);
        MediaPlayer.printStackTrace();
        if (videoView.l != null && videoView.J != null) {
            videoView.J.a();
        }
    }

    static /* synthetic */ void y(VideoView videoView) {
        new StringBuilder("onSurfaceDestroyed ").append(videoView.l);
        MediaPlayer.printStackTrace();
        if (videoView.J != null) {
            boolean z;
            VideoViewManager videoViewManager = videoView.J;
            new StringBuilder("checkVideoNetwork isWifi :").append(videoViewManager.a);
            if (videoViewManager.a == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                videoView.pause();
                if (videoView.l != null) {
                    videoView.l.setDisplay(null);
                    VideoViewManager videoViewManager2 = videoView.J;
                    new StringBuilder("addBackgroundVideoView ").append(videoView);
                    synchronized (videoViewManager2) {
                        if (videoViewManager2.c == null) {
                            videoViewManager2.c = new a(videoViewManager2, videoView);
                        }
                    }
                    return;
                }
                return;
            }
            videoView.release(true);
        }
    }
}
