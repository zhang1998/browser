package com.uc.apollo.media.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import com.UCMobile.Apollo.IVideoStatistic;
import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.IRequestExternalValueListener;
import com.UCMobile.Apollo.MediaPlayer.OnBufferingUpdateListener;
import com.UCMobile.Apollo.MediaPlayer.OnCachedPositionsListener;
import com.UCMobile.Apollo.MediaPlayer.OnCompletionListener;
import com.UCMobile.Apollo.MediaPlayer.OnErrorListener;
import com.UCMobile.Apollo.MediaPlayer.OnInfoListener;
import com.UCMobile.Apollo.MediaPlayer.OnPreparedListener;
import com.UCMobile.Apollo.MediaPlayer.OnSeekCompleteListener;
import com.UCMobile.Apollo.MediaPlayer.OnVideoSizeChangedListener;
import com.uc.apollo.Settings;
import com.uc.apollo.impl.SettingsConst;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class h extends u {
    private static IRequestExternalValueListener H = new j();
    private static final String s = (e.a + "MediaPlayerApollo");
    private OnCompletionListener A = new n(this);
    private OnErrorListener B = new o(this);
    private OnSeekCompleteListener C = new p(this);
    private OnBufferingUpdateListener D = new q(this);
    private OnCachedPositionsListener E = new r(this);
    private OnInfoListener F = new s(this);
    private IVideoStatistic G = new t(this);
    private MediaPlayer t;
    private Context u;
    private HashMap<String, String> v;
    private HashMap<String, Object> w;
    private HashMap<String, String> x;
    private OnPreparedListener y = new i(this);
    private OnVideoSizeChangedListener z = new m(this);

    public static u i(int i) {
        try {
            return new h(Settings.getContext(), i);
        } catch (Throwable th) {
            Log.w(s, "new MediaPlayerApollo(ctx) failure: " + th);
            return null;
        }
    }

    public final boolean b(String str, String str2) {
        super.b(str, str2);
        new StringBuilder("setOption - ").append(str).append(" = ").append(str2);
        if (str.equals("rw.instance.mute")) {
            if ("false".equals(str2)) {
                str = "rw.instance.unmute";
                c(false);
            } else {
                c(true);
            }
            if (this.t != null) {
                this.t.setGeneralOption(str, str2);
                return true;
            } else if (this.w != null) {
                this.w.put(str, str2);
            }
        } else if (str.startsWith("rw.global")) {
            if (this.t != null) {
                MediaPlayer.setGlobalOption(str, str2);
                return true;
            } else if (this.x != null) {
                this.x.put(str, str2);
            }
        } else if (this.t != null) {
            if (this.t.setOption(str, str2) == 0) {
                return true;
            }
        } else if (this.v != null) {
            this.v.put(str, str2);
        }
        return false;
    }

    public final String a(String str) {
        if (this.t != null) {
            return this.t.getOption(str);
        }
        return null;
    }

    private h(Context context, int i) {
        super(i, e.a, "MediaPlayerApollo");
        this.u = context;
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = new HashMap();
    }

    public final int d() {
        return 5;
    }

    protected final void A() {
        if (this.t != null) {
            this.t.start();
            super.A();
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
        if (this.t != null) {
            this.t.pause();
        }
    }

    public final boolean k() {
        if (!super.k()) {
            return false;
        }
        if (this.t != null) {
            this.t.stop();
        }
        return true;
    }

    public final void a(String str, String str2) {
        super.a(str, str2);
        if (!(str == null || str.isEmpty())) {
            b("rw.instance.page_title", str);
        }
        if (str2 != null && !str2.isEmpty()) {
            b("rw.instance.page_uri", str2);
        }
    }

    public final void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        super.a(context, dataSource);
        if (a() != F.INITIALIZED) {
            L();
        }
        if (dataSource instanceof DataSourceURI) {
            if (this.t == null) {
                M();
            }
            if (Settings.getUserType() == 2) {
                this.t.setOption("rw.instance.stat_level", SettingsConst.TRUE);
            }
            this.t.setStatisticHelper(this.G);
            this.t.setOnPreparedListener(this.y);
            this.t.setOnVideoSizeChangedListener(this.z);
            this.t.setOnCompletionListener(this.A);
            this.t.setOnErrorListener(this.B);
            this.t.setOnSeekCompleteListener(this.C);
            this.t.setOnBufferingUpdateListener(this.D);
            this.t.setExternalValueListener(H);
            this.t.setOnCachedPositionsListener(this.E);
            this.t.setOnInfoListener(this.F);
            DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
            if (dataSourceURI.headers == null || dataSourceURI.headers.size() <= 0) {
                this.t.setDataSource(context, dataSourceURI.uri);
            } else {
                this.t.setDataSource(context, dataSourceURI.uri, dataSourceURI.headers);
            }
            if (!(dataSourceURI.title == null || dataSourceURI.title.isEmpty())) {
                b("rw.instance.page_title", dataSourceURI.title);
            }
            if (dataSourceURI.pageUri != null && !dataSourceURI.pageUri.isEmpty()) {
                b("rw.instance.page_uri", dataSourceURI.pageUri);
            }
        } else if (dataSource != null) {
            throw new AssertionError("unsupport dataSource " + dataSource);
        }
    }

    public final void m() throws IllegalStateException {
        super.m();
        if (this.t != null) {
            this.t.prepareAsync();
        }
    }

    public final void n() {
        super.n();
        if (this.t != null) {
            L();
        }
    }

    public final boolean g(int i) throws IllegalStateException {
        if (!super.g(i) || this.t == null) {
            return false;
        }
        this.t.seekTo(i);
        G();
        return true;
    }

    protected final int C() {
        return this.t == null ? -1 : this.t.getCurrentPosition();
    }

    public final Bitmap r() {
        return this.t == null ? null : this.t.getCurrentVideoFrame(0, 0);
    }

    public final void q() {
    }

    public final void b(boolean z) {
        if (this.t != null) {
            new StringBuilder("setCacheEnable as ").append(z).append(", current state ").append(a());
            if (c() != 1 || z) {
                this.t.setOption("rw.instance.pause_preload", z ? SettingsConst.FALSE : SettingsConst.TRUE);
            }
        }
    }

    public final void a(Surface surface) {
        super.a(surface);
        new StringBuilder("setSurfaceImpl - ").append(surface);
        if (this.t != null) {
            this.t.setSurface(surface);
        } else if (surface != null) {
            M();
        }
        H();
    }

    public final boolean v() {
        if (!super.v()) {
            return false;
        }
        if (this.t != null) {
            L();
        }
        return true;
    }

    protected final boolean D() {
        return this.t != null ? this.t.isPlaying() : false;
    }

    private void L() {
        if (this.t != null) {
            this.t.setOnPreparedListener(null);
            this.t.setOnVideoSizeChangedListener(null);
            this.t.setOnCompletionListener(null);
            this.t.setOnErrorListener(null);
            this.t.setOnSeekCompleteListener(null);
            this.t.setOnBufferingUpdateListener(null);
            this.t.release();
            this.t = null;
        }
    }

    private void M() {
        if (this.t == null) {
            this.t = new MediaPlayer(this.u);
            Surface F = F();
            if (F != null) {
                try {
                    this.t.setSurface(F);
                } catch (Exception e) {
                    Log.w(this.b, "setSurface failure " + e);
                }
            }
            for (Entry entry : this.v.entrySet()) {
                this.t.setOption((String) entry.getKey(), (String) entry.getValue());
            }
            for (Entry entry2 : this.w.entrySet()) {
                this.t.setGeneralOption((String) entry2.getKey(), entry2.getValue());
            }
            for (Entry entry22 : this.x.entrySet()) {
                MediaPlayer.setGlobalOption((String) entry22.getKey(), (String) entry22.getValue());
            }
            if (K()) {
                this.t.setVolume(I(), J());
            }
        }
    }

    public final void a(float f, float f2) {
        super.a(f, f2);
        if (this.t != null) {
            this.t.setVolume(I(), J());
        }
    }
}
