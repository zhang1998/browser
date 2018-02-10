package com.ucpro.feature.video;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.uc.apollo.media.MediaPlayer.OnBufferingUpdateListener;
import com.uc.apollo.media.MediaPlayer.OnCompletionListener;
import com.uc.apollo.media.MediaPlayer.OnErrorListener;
import com.uc.apollo.media.MediaPlayer.OnPreparedListener;
import com.uc.apollo.widget.VideoView;
import com.uc.apollo.widget.VideoView.OnExtraInfoListener;
import com.uc.apollo.widget.VideoView.OnInfoListener;
import com.uc.media.interfaces.VideoViewParams;
import com.uc.media.interfaces.VideoViewParams.Listener;
import com.uc.webview.export.annotations.Reflection;
import com.ucpro.feature.video.f.a;
import com.ucpro.feature.video.player.c;
import java.util.Map;

/* compiled from: ProGuard */
public final class VideoViewImpl implements an {
    ab a;
    at b;
    v c;
    d d;
    am e;
    as f;
    w g;
    y h;
    a i = a.UNKNOWN;
    private VideoView j;
    private VideoView k;
    private Object l;
    private c m;
    private l n;
    private aj o;
    private af p;
    private ai q;
    private OnExtraInfoListener r = new aw(this);
    private OnBufferingUpdateListener s = new n(this);
    private OnCompletionListener t = new ak(this);
    private OnErrorListener u = new g(this);
    private OnInfoListener v = new ar(this);
    private OnPreparedListener w = new ad(this);

    /* compiled from: ProGuard */
    class VideoViewParamsListener implements Listener {
        final /* synthetic */ VideoViewImpl a;

        public void onHadAttachedToLittleWindow(boolean z, int i) {
        }

        public void onStart() {
            if (this.a.g != null) {
                this.a.g.a();
            }
        }

        public void onPause() {
            if (this.a.g != null) {
                this.a.g.b();
            }
        }

        public void onSetVideoUri(String str, Map<String, String> map) {
        }

        @Reflection
        public void onMessage(int i, int i2) {
            switch (i) {
                case 80:
                    if (this.a.h != null) {
                        this.a.h.a(i2 != 0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public VideoViewImpl(Context context, Object obj, boolean z) {
        this.l = obj != null ? obj : new VideoViewParams();
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (z) {
            this.j = new c(context, intValue, z);
        } else {
            this.j = new c(context, intValue);
        }
    }

    public final void a() {
        if (this.j != null) {
            this.j.start();
            if (this.g != null) {
                this.g.a();
            }
        }
    }

    public final void b() {
        if (this.j != null) {
            this.j.pause();
            if (this.g != null) {
                this.g.b();
            }
        }
    }

    public final int c() {
        if (this.j != null) {
            return this.j.getDuration();
        }
        return 0;
    }

    public final int d() {
        if (this.j != null) {
            return this.j.getCurrentPosition();
        }
        return 0;
    }

    public final void a(int i) {
        if (this.j != null) {
            this.j.seekTo(i);
        }
    }

    public final boolean e() {
        if (this.j != null) {
            return this.j.isPlaying();
        }
        return false;
    }

    public final boolean f() {
        if (this.j != null) {
            return this.j.canSeekBackward();
        }
        return false;
    }

    public final boolean g() {
        if (this.j != null) {
            return this.j.canSeekForward();
        }
        return false;
    }

    public final void a(String str, Map<String, String> map) {
        if (this.j != null) {
            this.j.setVideoURI(Uri.parse(str), (Map) map);
        }
    }

    public final void a(String str, String str2) {
        if (this.j != null) {
            this.j.setTitleAndPageURI(str, str2);
        }
    }

    public final void h() {
        if (this.j != null) {
            this.j.enterFullScreen(true);
            VideoView videoView = this.j;
            if (videoView.isFullScreen()) {
                videoView = com.ucpro.feature.video.b.a.a(videoView);
                if (videoView != null) {
                    videoView.setOnBufferingUpdateListener(this.s);
                    videoView.setOnCompletionListener(this.t);
                    videoView.setOnErrorListener(this.u);
                    videoView.setOnExtraInfoListener(this.r);
                    videoView.setOnInfoListener(this.v);
                    videoView.setOnPreparedListener(this.w);
                    this.k = this.j;
                    this.j = videoView;
                }
            }
        }
    }

    public final void i() {
        if (this.j != null) {
            this.j.enterFullScreen(false);
        }
    }

    public final boolean j() {
        if (this.j != null) {
            this.j.enterLittleWin();
        }
        return true;
    }

    public final void k() {
        l();
    }

    public final boolean l() {
        if (this.j == null) {
            return false;
        }
        this.j.destroy();
        if (this.k != null) {
            this.k.destroy();
        }
        return true;
    }

    public final View m() {
        return this.j;
    }

    public final void a(as asVar) {
        this.f = asVar;
        if (this.j != null) {
            this.j.setOnPreparedListener(this.w);
        }
    }

    public final void a(ab abVar) {
        this.a = abVar;
        if (this.j != null) {
            this.j.setOnErrorListener(this.u);
        }
    }

    public final void a(d dVar) {
        this.d = dVar;
        if (this.j != null) {
            this.j.setOnInfoListener(this.v);
        }
    }

    public final void a(v vVar) {
        this.c = vVar;
        if (this.j != null) {
            this.j.setOnExtraInfoListener(this.r);
        }
    }

    public final void a(at atVar) {
        this.b = atVar;
        if (this.j != null) {
            this.j.setOnBufferingUpdateListener(this.s);
        }
    }

    public final void a(am amVar) {
        this.e = amVar;
        if (this.j != null) {
            this.j.setOnCompletionListener(this.t);
        }
    }

    public final void a(w wVar) {
        this.g = wVar;
    }

    public final void a(c cVar) {
        this.m = cVar;
    }

    public final void a(l lVar) {
        this.n = lVar;
    }

    public final void a(aj ajVar) {
        this.o = ajVar;
    }

    public final void a(af afVar) {
        this.p = afVar;
    }

    public final void a(y yVar) {
        this.h = yVar;
    }

    public final void a(ai aiVar) {
        this.q = aiVar;
        ((c) this.j).setSizeChangedListener(aiVar);
    }
}
