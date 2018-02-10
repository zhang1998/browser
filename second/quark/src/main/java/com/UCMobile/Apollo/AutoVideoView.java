package com.UCMobile.Apollo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.MediaController;
import com.UCMobile.Apollo.SmartMediaPlayer.OnCompletionListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnErrorListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnInfoListener;
import com.UCMobile.Apollo.SmartMediaPlayer.OnPreparedListener;
import com.UCMobile.Apollo.SmartMediaPlayer.PlayerType;
import com.uc.webview.export.extension.UCCore;
import java.util.Map;
import java.util.Random;

/* compiled from: ProGuard */
public class AutoVideoView extends ViewGroup {
    public static final int VIDEO_SCALING_MODE_ASPECT_FILL = 1;
    public static final int VIDEO_SCALING_MODE_ASPECT_FIT = 0;
    public static final int VIDEO_SCALING_MODE_FORCE_16x9 = 4;
    public static final int VIDEO_SCALING_MODE_FORCE_4x3 = 5;
    public static final int VIDEO_SCALING_MODE_MAX = 5;
    public static final int VIDEO_SCALING_MODE_MIN = 0;
    public static final int VIDEO_SCALING_MODE_ORIGINAL = 3;
    public static final int VIDEO_SCALING_MODE_STRETCH_FILL = 2;
    OnCompletionListener a = null;
    OnErrorListener b = null;
    OnInfoListener c = null;
    OnPreparedListener d = null;
    IVideoStatistic e = null;
    private VideoView f = null;
    private VideoView g = null;
    private VideoView h = null;
    private MediaController i = null;
    private PlayerType j = PlayerType.NONE;
    private PlayerType k = PlayerType.NONE;
    private boolean l = false;
    private Uri m = null;
    private Map<String, String> n = null;
    private int o = 0;
    private int p = 0;
    private c q = new c(this);

    /* compiled from: ProGuard */
    interface b {
        void a(SmartMediaPlayer smartMediaPlayer, PlayerType playerType);
    }

    /* compiled from: ProGuard */
    final class a implements OnPreparedListener {
        final /* synthetic */ AutoVideoView a;
        private b b;

        public a(AutoVideoView autoVideoView, b bVar) {
            this.a = autoVideoView;
            this.b = bVar;
        }

        public final void onPrepared(SmartMediaPlayer smartMediaPlayer) {
            this.a.k = smartMediaPlayer.getPlayerType();
            this.a.l = true;
            if (this.b != null) {
                this.b.a(smartMediaPlayer, this.a.k);
            }
        }
    }

    /* compiled from: ProGuard */
    final class c {
        int a;
        int b;
        final /* synthetic */ AutoVideoView c;

        public c(AutoVideoView autoVideoView) {
            this.c = autoVideoView;
            this.a = 0;
            this.b = 0;
            this.a = 0;
            this.b = 0;
        }

        public c(AutoVideoView autoVideoView, int i, int i2) {
            this.c = autoVideoView;
            this.a = 0;
            this.b = 0;
            this.a = i;
            this.b = i2;
        }

        public final void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public AutoVideoView(Context context) {
        super(context);
        b();
    }

    public AutoVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AutoVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.h != null) {
            this.h.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = this.h.getMeasuredWidth();
            int measuredHeight = this.h.getMeasuredHeight();
            if (measuredWidth <= 0 || measuredHeight <= 0) {
                this.h.layout(0, 0, i3 - i, i4 - i2);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            c a = a(measuredWidth, measuredHeight, i5, i6);
            this.h.layout(((i5 - a.a) / 2) + new Random().nextInt(10), (i6 - a.b) / 2, (i5 + a.a) / 2, (a.b + i6) / 2);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.h == null) {
            super.onMeasure(i, i2);
            return;
        }
        this.h.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.h.getMeasuredWidth();
        int measuredHeight = this.h.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 0) {
            if (mode2 == 0) {
                this.q.a(measuredWidth, measuredHeight);
            } else if (mode2 == UCCore.VERIFY_POLICY_QUICK) {
                a(measuredWidth, measuredHeight, size2);
            } else {
                a(measuredWidth, measuredHeight, Math.min(measuredHeight, size2));
            }
        } else if (mode == UCCore.VERIFY_POLICY_QUICK) {
            if (mode2 == 0) {
                b(measuredWidth, measuredHeight, size);
            } else if (mode2 == UCCore.VERIFY_POLICY_QUICK) {
                this.q.a(size, size2);
            } else {
                this.q.a(size, Math.min(a(measuredWidth, measuredHeight, size, size2).b, size2));
            }
        } else if (mode2 == 0) {
            b(measuredWidth, measuredHeight, size);
        } else if (mode2 == UCCore.VERIFY_POLICY_QUICK) {
            this.q.a(size, size2);
        } else {
            this.q.a(size, Math.min(a(measuredWidth, measuredHeight, size, size2).b, size2));
        }
        setMeasuredDimension(this.q.a, this.q.b);
    }

    public void setPlayerType(PlayerType playerType) {
        if (this.j != playerType) {
            this.j = playerType;
            if (this.k != playerType) {
                this.l = false;
            }
        }
    }

    public PlayerType getPlayerType() {
        return this.l ? this.k : this.j;
    }

    public void setVideoPath(String str) {
        if (str == null) {
            setVideoURI(null);
        } else {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setInitPlaybackTime(int i) {
        if (this.h != null) {
            this.h.setInitPlaybackTime(i);
        }
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        if (uri == null) {
            a(null);
        } else if (!uri.equals(this.m)) {
            this.m = uri;
            this.n = map;
            this.l = false;
        }
    }

    public boolean canPause() {
        return this.h == null ? false : this.h.canPause();
    }

    public boolean canSeekBackward() {
        return this.h == null ? false : this.h.canSeekBackward();
    }

    public boolean canSeekForward() {
        return this.h == null ? false : this.h.canSeekForward();
    }

    public int getAudioSessionId() {
        if (this.h == null) {
            return 0;
        }
        return this.h.getAudioSessionId();
    }

    public int getBufferPercentage() {
        return this.h == null ? 0 : this.h.getBufferPercentage();
    }

    public int getCurrentPosition() {
        if (this.h == null) {
            return 0;
        }
        return this.h.getCurrentPosition();
    }

    public int getDuration() {
        return this.h == null ? 0 : this.h.getDuration();
    }

    public boolean isPlaying() {
        return this.h == null ? false : this.h.isPlaying();
    }

    public void start() {
        if (this.l) {
            if (this.h != null) {
                if (this.o > 0) {
                    this.h.seekTo(this.o);
                    new StringBuilder("start(): _seekToTime = ").append(this.o);
                    this.o = 0;
                }
                this.h.start();
            }
        } else if (this.m != null) {
            new StringBuilder("_detrminePlayerType: uri = ").append(this.m).append(", user specified ").append(this.j);
            if (this.j != PlayerType.NONE) {
                this.k = this.j;
                this.l = true;
                a();
            } else if (this.m.toString().startsWith("rtsp://")) {
                this.k = PlayerType.R2_PLAYER;
            } else {
                SmartMediaPlayer smartMediaPlayer = new SmartMediaPlayer(getContext());
                smartMediaPlayer.setPlayerType(PlayerType.NONE);
                try {
                    smartMediaPlayer.setDataSource(getContext(), this.m, this.n);
                    smartMediaPlayer.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ AutoVideoView a;

                        {
                            this.a = r1;
                        }

                        public final boolean onError(SmartMediaPlayer smartMediaPlayer, int i, int i2) {
                            this.a.k = PlayerType.NONE;
                            if (this.a.b != null) {
                                this.a.b.onError(smartMediaPlayer, -2, -1);
                            }
                            smartMediaPlayer.release();
                            return true;
                        }
                    });
                    smartMediaPlayer.setOnPreparedListener(new a(this, new b(this) {
                        final /* synthetic */ AutoVideoView a;

                        {
                            this.a = r1;
                        }

                        public final void a(SmartMediaPlayer smartMediaPlayer, PlayerType playerType) {
                            new StringBuilder("_determinePlayerType: detrmined type ").append(playerType).append(" will call start().");
                            smartMediaPlayer.release();
                            this.a.a();
                        }
                    }));
                    smartMediaPlayer.prepareAsync();
                } catch (Exception e) {
                    this.k = PlayerType.NONE;
                    if (this.b != null) {
                        this.b.onError(smartMediaPlayer, -2, -1);
                    }
                    smartMediaPlayer.release();
                }
            }
            if (!this.l || this.k == PlayerType.NONE) {
                a(null);
            }
        }
    }

    public void pause() {
        if (this.h != null) {
            this.h.pause();
        }
    }

    public void stopPlayback() {
        if (this.h != null) {
            this.h.stopPlayback();
        }
        this.l = false;
    }

    public void suspend() {
        if (this.h != null) {
            this.h.suspend();
        }
    }

    public void resume() {
        if (this.h != null) {
            this.h.resume();
        }
    }

    public void seekTo(int i) {
        if (this.h != null) {
            this.h.seekTo(i);
        } else {
            this.o = i;
        }
    }

    public int resolveAdjustedSize(int i, int i2) {
        return this.h != null ? this.h.resolveAdjustedSize(i, i2) : 0;
    }

    public void setMediaController(MediaController mediaController) {
        this.i = mediaController;
        if (this.h != null) {
            this.h.setMediaController(mediaController);
        }
    }

    public String[] getAudioTrackTitles() {
        if (this.h != null) {
            return this.h.getAudioTrackTitles();
        }
        return null;
    }

    public int getCurrentAudioTrackIndex() {
        if (this.h != null) {
            return this.h.getCurrentAudioTrackIndex();
        }
        return -1;
    }

    public void setCurrentAudioTrackIndex(int i) {
        if (this.h != null) {
            this.h.setCurrentAudioTrackIndex(i);
        }
    }

    public Bitmap getCurrentVideoFrame(int i, int i2) {
        if (this.h != null) {
            return this.h.getCurrentVideoFrame(i, i2);
        }
        return null;
    }

    public float getFPS() {
        if (this.h == this.g) {
            return this.g.getFPS();
        }
        return 0.0f;
    }

    public float getAverageFPS() {
        if (this.h == this.g) {
            return this.g.getAverageFPS();
        }
        return 0.0f;
    }

    public void setStatisticHelper(IVideoStatistic iVideoStatistic) {
        this.e = iVideoStatistic;
        if (this.h != null) {
            this.h.setStatisticHelper(iVideoStatistic);
        }
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.a = onCompletionListener;
        if (this.h != null) {
            this.h.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.b = onErrorListener;
        if (this.h != null) {
            this.h.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.c = onInfoListener;
        if (this.h != null) {
            this.h.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.d = onPreparedListener;
        if (this.h != null) {
            this.h.setOnPreparedListener(onPreparedListener);
        }
    }

    private void b() {
        this.f = new VideoView(getContext());
        this.f.setPlayerType(PlayerType.SYSTEM_PLAYER);
        this.g = new VideoView(getContext());
        this.g.setPlayerType(PlayerType.R2_PLAYER);
    }

    private void a(VideoView videoView) {
        if (this.h != videoView) {
            if (videoView != null) {
                addView(videoView);
            }
            if (this.h != null) {
                removeView(this.h);
            }
            this.h = videoView;
        }
    }

    public void setVideoScalingMode(int i) {
        if (i != this.p && i >= 0 && i <= 5) {
            this.p = i;
            requestLayout();
        }
    }

    public int getVideoScalingMode() {
        return this.p;
    }

    private void a(int i, int i2, int i3) {
        switch (this.p) {
            case 0:
            case 1:
            case 2:
                i = (i * i3) / i2;
                break;
            case 3:
                i3 = i2;
                break;
            case 4:
                i = (i3 * 16) / 9;
                break;
            case 5:
                i = (i3 * 4) / 3;
                break;
            default:
                i = 0;
                break;
        }
        this.q.a(i, i3);
    }

    private void b(int i, int i2, int i3) {
        switch (this.p) {
            case 0:
            case 1:
            case 2:
                i2 = (i2 * i3) / i;
                break;
            case 3:
                i3 = i;
                break;
            case 4:
                i2 = (i3 * 9) / 16;
                break;
            case 5:
                i2 = (i3 * 3) / 4;
                break;
            default:
                i2 = 0;
                break;
        }
        this.q.a(i3, i2);
    }

    private c a(int i, int i2, int i3, int i4) {
        switch (this.p) {
            case 0:
                if (i * i4 >= i3 * i2) {
                    i4 = (i2 * i3) / i;
                    break;
                }
                i3 = (i * i4) / i2;
                break;
            case 1:
                if (i * i4 >= i3 * i2) {
                    i3 = (i * i4) / i2;
                    break;
                }
                i4 = (i2 * i3) / i;
                break;
            case 2:
                break;
            case 3:
                i4 = i2;
                i3 = i;
                break;
            case 4:
                if (i4 * 16 >= i3 * 9) {
                    i4 = (i3 * 9) / 16;
                    break;
                }
                i3 = (i4 * 16) / 9;
                break;
            case 5:
                if (i4 * 4 >= i3 * 3) {
                    i4 = (i3 * 3) / 4;
                    break;
                }
                i3 = (i4 * 4) / 3;
                break;
            default:
                i4 = 0;
                i3 = 0;
                break;
        }
        return new c(this, i3, i4);
    }

    final void a() {
        if (this.k == PlayerType.SYSTEM_PLAYER) {
            a(this.f);
        } else if (this.k == PlayerType.R2_PLAYER) {
            a(this.g);
        }
        if (this.i != null) {
            this.h.setMediaController(this.i);
        }
        if (this.d != null) {
            this.h.setOnPreparedListener(this.d);
        }
        if (this.b != null) {
            this.h.setOnErrorListener(this.b);
        }
        if (this.c != null) {
            this.h.setOnInfoListener(this.c);
        }
        if (this.a != null) {
            this.h.setOnCompletionListener(this.a);
        }
        if (this.e != null) {
            this.h.setStatisticHelper(this.e);
        }
        this.h.setVideoURI(this.m, this.n);
        new StringBuilder("PlayerType is ").append(this.j).append(", _currentVideoView ").append(this.h).append(", h ").append(this.f).append(", s ").append(this.g);
        start();
    }

    public VideoView getCurrentVideoView() {
        return this.h;
    }

    public VideoView getVideoView() {
        return this.g;
    }

    public static int getApiVersion() {
        return VideoView.getApiVersion();
    }

    public static int getApiVersion(Context context) {
        return VideoView.getApiVersion(context);
    }

    public static String getVersionString() {
        return VideoView.getVersionString();
    }

    public static String getVersionString(Context context) {
        return VideoView.getVersionString(context);
    }
}
