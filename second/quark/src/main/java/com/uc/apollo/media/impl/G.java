package com.uc.apollo.media.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.Settings;
import com.uc.apollo.media.b.b;
import com.uc.apollo.media.base.d;
import com.uc.apollo.media.impl.f.a;
import java.io.IOException;
import java.util.Map;
import org.android.spdy.TnetStatusCode;

/* compiled from: ProGuard */
final class G extends u {
    private static boolean F;
    private OnVideoSizeChangedListener A = new J(this);
    private OnCompletionListener B = new K(this);
    private OnErrorListener C = new L(this);
    private OnSeekCompleteListener D = new M(this);
    private OnBufferingUpdateListener E = new N(this);
    private MediaPlayer s;
    private Surface t;
    private int u = 0;
    private b v;
    private boolean w;
    private boolean x;
    private a y = new H(this);
    private OnPreparedListener z = new I(this);

    public final void a(float f, float f2) {
        super.a(f, f2);
        if (this.s != null) {
            this.s.setVolume(I(), J());
        }
    }

    public static G i(int i) {
        return new G(i);
    }

    public final boolean b(String str, String str2) {
        super.b(str, str2);
        if (str.equals("rw.instance.mute")) {
            if ("false".equals(str2)) {
                c(false);
            } else {
                c(true);
            }
            if (this.s != null) {
                this.s.setVolume(I(), J());
            }
        }
        return false;
    }

    public final String a(String str) {
        return null;
    }

    private G(int i) {
        super(i, e.a, "MediaPlayerSystem");
    }

    public final int d() {
        return 2;
    }

    protected final void A() {
        if (this.s != null && this.x && !this.s.isPlaying()) {
            this.s.start();
            super.A();
        }
    }

    protected final int C() {
        if (this.s == null || !this.x) {
            return this.q;
        }
        int currentPosition = this.s.getCurrentPosition();
        if (!O.a(this.k) || this.v == null) {
            return currentPosition;
        }
        return this.v.a(currentPosition);
    }

    public final boolean g(int i) throws IllegalStateException {
        if (!super.g(i)) {
            return false;
        }
        if (i <= this.m) {
            this.q = i;
            if (this.s != null) {
                if (this.x) {
                    this.s.seekTo(i);
                }
                if (O.a(this.k) && this.v != null) {
                    this.v.b(i);
                }
                G();
            }
            return true;
        } else if (i > this.n) {
            return false;
        } else {
            this.r.a(this.j);
            return false;
        }
    }

    public final boolean j() {
        if (!super.j()) {
            return false;
        }
        B();
        return true;
    }

    protected final void B() {
        if (this.s != null && this.s.isPlaying()) {
            this.s.pause();
        }
    }

    public final boolean k() {
        if (!super.k()) {
            return false;
        }
        if (this.s != null) {
            this.s.stop();
        }
        return true;
    }

    protected final boolean D() {
        return this.s != null ? this.s.isPlaying() : false;
    }

    static {
        F = false;
        try {
            MediaPlayer.class.getMethod("setDataSource", new Class[]{Context.class, Uri.class, Map.class});
            F = true;
        } catch (Throwable th) {
            Log.w(e.a + "MediaPlayerSystem", "android.media.MediaPlayer.class.getMethod.setDataSource(Context context, Uri uri) failure");
        }
    }

    public final void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        super.a(context, dataSource);
        if (a() != F.INITIALIZED) {
            M();
        }
        this.w = false;
        this.k = O.UNPARSE;
        this.u = 0;
        L();
    }

    private void L() throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (this.s == null) {
            N();
        }
        this.s.setOnPreparedListener(this.z);
        this.s.setOnVideoSizeChangedListener(this.A);
        this.s.setOnCompletionListener(this.B);
        this.s.setOnErrorListener(this.C);
        this.s.setOnSeekCompleteListener(this.D);
        this.s.setOnBufferingUpdateListener(this.E);
        if (this.f instanceof DataSourceURI) {
            DataSourceURI dataSourceURI = (DataSourceURI) this.f;
            if (dataSourceURI.headers == null || dataSourceURI.headers.size() <= 0 || !F) {
                this.s.setDataSource(this.e, dataSourceURI.uri);
                return;
            } else {
                this.s.setDataSource(this.e, dataSourceURI.uri, dataSourceURI.headers);
                return;
            }
        }
        DataSourceFD dataSourceFD = (DataSourceFD) this.f;
        this.s.setDataSource(dataSourceFD.fd, dataSourceFD.offset, dataSourceFD.length);
    }

    public final void m() throws IllegalStateException {
        super.m();
        if (this.k == O.UNPARSE) {
            if (this.f instanceof DataSourceURI) {
                this.k = O.PARSING;
                DataSourceURI dataSourceURI = (DataSourceURI) this.f;
                this.u = f.a(dataSourceURI.uri.toString(), dataSourceURI.headers, this.y, false);
            } else {
                this.k = O.UNSUPPORT;
            }
        }
        try {
            if (this.s != null) {
                this.s.prepareAsync();
            }
        } catch (IllegalStateException e) {
            this.C.onError(this.s, TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS, 0);
        }
    }

    public final void n() {
        super.n();
        this.w = false;
        if (this.s != null) {
            M();
        }
    }

    public final void a(Surface surface) {
        int i = 0;
        if (this.t == null || !this.t.equals(surface)) {
            super.a(surface);
            new StringBuilder("setSurfaceImpl - type/state/current/new : ").append(this.k).append("/").append(a()).append("/").append(this.t).append("/").append(surface).append("\ndevice - manufacturer: ").append(Build.MANUFACTURER).append(", model: ").append(Build.MODEL).append(", board platform: ").append(d.a);
            if (!(this.s == null || this.t == null || ((!O.a(this.k) && !Settings.shouldResetSystemMediaPlayerBeforeChangeSurface()) || a().l <= F.PREPARING.l))) {
                i = 1;
            }
            this.t = surface;
            if (i != 0) {
                if (this.s != null) {
                    M();
                }
            } else if (this.s != null) {
                this.s.setSurface(this.t);
                if (this.x && surface != null && this.q > 1000 && this.q <= this.m) {
                    this.s.seekTo(this.q);
                }
            }
            if (this.t != null && this.s == null) {
                N();
                if (this.f != null) {
                    try {
                        L();
                        if (a().l > F.INITIALIZED.l) {
                            this.s.prepareAsync();
                        }
                    } catch (Exception e) {
                        this.r.b(this.j, 1, -1);
                    }
                }
            }
            H();
        }
    }

    public final boolean v() {
        if (!super.v()) {
            return false;
        }
        this.w = false;
        this.x = false;
        this.n = SectionHeader.SHT_LOUSER;
        this.v = null;
        if (this.s != null) {
            new StringBuilder("reset(state/surface: ").append(a()).append("/").append(this.t).append(")...");
            this.s.reset();
        }
        return true;
    }

    private void M() {
        if (this.s != null) {
            new StringBuilder("destroy MediaPlayer(state/surface: ").append(a()).append("/").append(this.t).append(")...");
            this.s.release();
            this.s = null;
            this.x = false;
            this.v = null;
        }
    }

    private void N() {
        if (this.s == null) {
            new StringBuilder("create MediaPlayer implement, current surface ").append(this.t);
            this.s = new MediaPlayer();
            if (this.t != null) {
                this.s.setSurface(this.t);
            }
            if (K()) {
                this.s.setVolume(I(), J());
            }
        }
    }
}
