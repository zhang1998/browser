package com.uc.apollo.media.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.Settings;
import com.uc.apollo.media.CodecLibUpgrader;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.base.e;
import com.uc.apollo.media.base.g;
import com.uc.apollo.util.f;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class B {
    private static final String a = (e.a + "MediaPlayerHolder");
    private static boolean t = false;
    private String b = a;
    private c c = new c();
    private Handler d;
    private int e;
    private int f;
    private g g;
    private int h = a.a;
    private boolean i;
    private int j;
    private int k;
    private long l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private SparseArray<MediaPlayerClient> q = new SparseArray(3);
    private E r = new C(this);
    private com.uc.apollo.media.a.b s;

    /* compiled from: ProGuard */
    final class a {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = new int[]{a, b};
    }

    /* compiled from: ProGuard */
    final class b extends Handler {
        private WeakReference<B> a;

        b(B b) {
            this.a = new WeakReference(b);
        }

        public final void handleMessage(Message message) {
            int i = 0;
            B b = (B) this.a.get();
            if (b != null) {
                int i2;
                switch (message.what) {
                    case 1:
                        b.J();
                        sendEmptyMessageDelayed(1, 600);
                        return;
                    case 2:
                        int size = b.q.size();
                        for (i2 = 0; i2 < size; i2++) {
                            ((MediaPlayerClient) b.q.valueAt(i2)).onHadAttachedToLittleWindow(false);
                        }
                        return;
                    case 3:
                        if (!Settings.shouldCompatibleWithSystemMediaPlayer()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (b.l <= currentTimeMillis) {
                                i2 = b.q.size();
                                while (i < i2) {
                                    ((MediaPlayerClient) b.q.valueAt(i)).onMessage(54, b.k, null);
                                    i++;
                                }
                            }
                            b.l = currentTimeMillis + 1000;
                            sendEmptyMessageDelayed(3, 1000);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    B(boolean z, int i) {
        this.b = a + f.a(i);
        this.f = i;
        boolean z2 = !this.n && Settings.shouldUseDefaultAudioFocusChangeListener();
        this.o = z2;
        this.d = new b(this);
        this.g = A.a(i);
        this.g.a(z);
        this.g.a(this.r);
        CodecLibUpgrader.upgrade();
    }

    final void a(int i) {
        new StringBuilder("changeDomID, old/new ").append(f.a(this.f)).append("/").append(f.a(i));
        this.f = i;
        this.b = a + f.a(i);
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((MediaPlayerClient) this.q.valueAt(i2)).changeDomID(i);
        }
        if (this.g != null) {
            this.g.a(i);
        }
        if (g.b(i)) {
            this.e = 0;
        }
    }

    final void b(int i) {
        this.e = i;
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.q.size();
    }

    public final MediaPlayerClient c() {
        if (this.q.size() == 0) {
            return null;
        }
        return (MediaPlayerClient) this.q.valueAt(0);
    }

    public final MediaPlayer d() {
        int size = this.q.size();
        for (int i = 0; i != size; i++) {
            MediaPlayerClient mediaPlayerClient = (MediaPlayerClient) this.q.valueAt(i);
            if (mediaPlayerClient instanceof MediaPlayer) {
                return (MediaPlayer) mediaPlayerClient;
            }
        }
        return null;
    }

    public final MediaPlayerController e() {
        int size = this.q.size();
        for (int i = 0; i != size; i++) {
            MediaPlayerClient mediaPlayerClient = (MediaPlayerClient) this.q.valueAt(i);
            if (mediaPlayerClient.getControllerInClient() != null) {
                return mediaPlayerClient.getControllerInClient();
            }
        }
        return null;
    }

    private void I() {
        if (this.g != null) {
            int e = this.g.e();
            this.c.c(e);
            this.c.a(this.g.x(), this.g.y());
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                ((MediaPlayerClient) this.q.valueAt(i)).onMessage(71, e, this.c.e());
            }
        }
    }

    final int a(MediaPlayerClient mediaPlayerClient) {
        int i = 0;
        if (this.g == null) {
            return 0;
        }
        int size;
        int i2;
        this.q.put(mediaPlayerClient.getID(), mediaPlayerClient);
        this.g.b(mediaPlayerClient.getID());
        if (mediaPlayerClient.getID() == 1) {
            size = this.q.size();
            for (i2 = 0; i2 < size; i2++) {
                ((MediaPlayerClient) this.q.valueAt(i2)).onHadAttachedToLittleWindow(true);
            }
        }
        i2 = this.q.size() - 1;
        if (i2 > 0) {
            size = this.q.size();
            while (i < size) {
                ((MediaPlayerClient) this.q.valueAt(i)).onBuddyCountHadChanged(i2);
                i++;
            }
        }
        return this.q.size();
    }

    final int b(MediaPlayerClient mediaPlayerClient) {
        int i = 0;
        mediaPlayerClient.onBuddyCountHadChanged(0);
        boolean equals = mediaPlayerClient.equals(f());
        this.q.remove(mediaPlayerClient.getID());
        if (mediaPlayerClient.getID() == 1) {
            this.d.sendEmptyMessage(2);
        }
        if (this.q.size() > 0) {
            if (equals) {
                ((MediaPlayerClient) this.q.valueAt(0)).setFront();
            }
            int size = this.q.size() - 1;
            int size2 = this.q.size();
            while (i < size2) {
                ((MediaPlayerClient) this.q.valueAt(i)).onBuddyCountHadChanged(size);
                i++;
            }
        }
        if (this.g != null) {
            this.g.c(mediaPlayerClient.getID());
        }
        return this.q.size();
    }

    public final void c(MediaPlayerClient mediaPlayerClient) {
        MediaPlayerClient f = f();
        if (f == null || !f.equals(mediaPlayerClient)) {
            this.g.d(mediaPlayerClient.getID());
            if (f != null && f.getID() == 1) {
                MediaPlayerClient.exitLittleWinAnyway();
            }
        }
    }

    public final MediaPlayerClient f() {
        if (this.g == null) {
            return null;
        }
        return (MediaPlayerClient) this.q.get(this.g.c());
    }

    public final int g() {
        return this.q.size();
    }

    public final Surface d(MediaPlayerClient mediaPlayerClient) {
        return (this.g == null || mediaPlayerClient == null) ? null : this.g.h(mediaPlayerClient.getID());
    }

    public final int h() {
        return this.f;
    }

    public final F i() {
        return this.g != null ? this.g.a() : F.IDLE;
    }

    public final DataSource j() {
        return this.g != null ? this.g.l() : null;
    }

    final g k() {
        return this.g;
    }

    public final Uri l() {
        if (this.g.l() instanceof DataSourceURI) {
            return ((DataSourceURI) this.g.l()).uri;
        }
        return null;
    }

    public final void a(String str, String str2) {
        if (this.g != null) {
            this.g.a(str, str2);
            this.c.a(str2);
        }
    }

    public final void a(MediaPlayerClient mediaPlayerClient, Surface surface) {
        if (this.g != null) {
            this.g.a(mediaPlayerClient.getID(), surface);
        }
        if (surface != null && mediaPlayerClient != null) {
            mediaPlayerClient.onMessage(80, Settings.supportLittleWindow() ? 1 : 0, null);
        }
    }

    public final void a(MediaPlayerClient mediaPlayerClient, boolean z) {
        if (this.g != null) {
            this.g.a(mediaPlayerClient.getID(), z);
        }
    }

    public final void a(MediaPlayerClient mediaPlayerClient, Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (this.g != null) {
            int e;
            DataSource j = j();
            if (j != null && dataSource != null && (j instanceof DataSourceURI) && (dataSource instanceof DataSourceURI)) {
                if (((DataSourceURI) j).uri.equals(((DataSourceURI) dataSource).uri)) {
                    this.p = true;
                }
            }
            e(mediaPlayerClient);
            if (this.g != null) {
                e = this.g.e();
            } else {
                e = 0;
            }
            if (e == 2 && this.g.x() != 1 && ((e.a() == 5 || e.a() == 1) && a.c())) {
                g a = A.a(this.f);
                a.a(this.g);
                this.g.b(this.r);
                this.g.n();
                this.g.o();
                this.g = a;
            }
        }
        new StringBuilder("setDataSource - ").append(dataSource);
        this.c.a();
        this.c.a(dataSource);
        if (this.g != null) {
            this.g.a(context, dataSource);
        }
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            MediaPlayerClient mediaPlayerClient2 = (MediaPlayerClient) this.q.valueAt(i);
            if (dataSource instanceof DataSourceURI) {
                DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
                mediaPlayerClient2.onSetDataSource(dataSourceURI.title, dataSourceURI.pageUri, dataSourceURI.uri, dataSourceURI.headers);
            } else if (dataSource instanceof DataSourceFD) {
                DataSourceFD dataSourceFD = (DataSourceFD) dataSource;
                mediaPlayerClient2.onSetDataSource(dataSourceFD.fd, dataSourceFD.offset, dataSourceFD.length);
            }
        }
        K();
        if (dataSource instanceof DataSourceURI) {
            com.uc.apollo.media.service.g.a().b(((DataSourceURI) dataSource).uri.toString());
        } else if (dataSource instanceof DataSourceFD) {
            com.uc.apollo.media.service.g.a().b(((DataSourceFD) dataSource).toString());
        }
    }

    public final void m() {
        this.c.b();
    }

    public final void n() {
        o();
    }

    public final void o() {
        if (this.g != null) {
            com.uc.apollo.media.service.g.a().a(this.f, true);
            this.c.b();
            if (this.g.a() == F.INITIALIZED) {
                this.h = a.b;
                F();
            } else {
                this.c.c();
                I();
                this.h = a.a;
                if (this.g.h()) {
                    int size = this.q.size();
                    for (int i = 0; i < size; i++) {
                        ((MediaPlayerClient) this.q.valueAt(i)).onStart();
                    }
                }
                if (this.g.e() == 5 && !this.d.hasMessages(3)) {
                    this.l = System.currentTimeMillis() + 1000;
                    this.d.sendEmptyMessageDelayed(3, 1000);
                }
            }
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            Settings.getContext().sendBroadcast(intent);
        }
    }

    public final void p() {
        this.c.b();
    }

    public final void q() {
        if (this.o) {
            t();
        }
    }

    public final void r() {
        s();
    }

    public final void s() {
        this.h = a.a;
        if (this.g != null) {
            if (this.g.j()) {
                int size = this.q.size();
                for (int i = 0; i < size; i++) {
                    ((MediaPlayerClient) this.q.valueAt(i)).onPause();
                }
            }
            L();
        }
    }

    public final void t() {
        if (e() != null) {
            e().pause();
        }
        s();
    }

    public final void u() {
        int i = 0;
        this.h = a.a;
        this.i = false;
        if (this.g != null) {
            int i2;
            this.c.h();
            E e = this.r;
            int g = this.g.g();
            if (this.g.w()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            e.a(g, 53, i2, null);
            if (this.g.k()) {
                int size = this.q.size();
                while (i < size) {
                    ((MediaPlayerClient) this.q.valueAt(i)).onStop();
                    i++;
                }
            }
        }
        L();
    }

    public final boolean v() {
        return this.g != null && this.g.i();
    }

    public final boolean w() {
        return this.g != null ? this.g.w() : false;
    }

    public final int x() {
        return this.g != null ? this.g.u() : SectionHeader.SHT_LOUSER;
    }

    public final int y() {
        return this.g != null ? this.g.t() : 0;
    }

    public final int z() {
        return this.g != null ? this.g.s() : 0;
    }

    public static void A() {
    }

    public final void a(float f, float f2) {
        if (this.g != null) {
            this.g.a(f, f2);
        }
    }

    public final int B() {
        return this.j;
    }

    public final void C() {
        if (this.g != null) {
            this.g.q();
        }
    }

    public final Bitmap D() {
        if (this.g != null) {
            return this.g.r();
        }
        return null;
    }

    public final void a(MediaPlayerClient mediaPlayerClient, int i) {
        if (this.g.a().l >= F.PREPARING.l) {
            this.g.g(i);
            J();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaPlayerClient mediaPlayerClient2 = (MediaPlayerClient) this.q.valueAt(i2);
                if (!mediaPlayerClient2.equals(mediaPlayerClient)) {
                    mediaPlayerClient2.onSeekTo(i);
                }
            }
        }
    }

    public final void E() {
        if (this.g != null) {
            e(null);
            this.g.b(this.r);
            this.g.n();
            this.g.o();
            this.g = null;
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                MediaPlayerClient mediaPlayerClient = (MediaPlayerClient) this.q.valueAt(i);
                if (!mediaPlayerClient.equals(null)) {
                    mediaPlayerClient.onRelease();
                }
            }
        }
    }

    public final void F() {
        this.c.d();
        if (this.d.hasMessages(1)) {
            this.d.removeMessages(1);
        }
        this.d.sendEmptyMessage(1);
        this.i = false;
        this.r.a(this.g.g(), 53, 0, null);
        this.j = 0;
        this.g.m();
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            ((MediaPlayerClient) this.q.valueAt(i)).onPrepareBegin();
        }
    }

    public final void e(MediaPlayerClient mediaPlayerClient) {
        this.h = a.a;
        this.i = false;
        if (this.g != null) {
            this.c.h();
            this.r.a(this.g.g(), 53, 0, null);
            if (this.g.v()) {
                int size = this.q.size();
                for (int i = 0; i < size; i++) {
                    MediaPlayerClient mediaPlayerClient2 = (MediaPlayerClient) this.q.valueAt(i);
                    if (!mediaPlayerClient2.equals(mediaPlayerClient)) {
                        mediaPlayerClient2.onReset();
                    }
                }
            }
        }
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.d.removeMessages(3);
        com.uc.apollo.media.service.g.a().a(this.f, false);
    }

    public final int G() {
        return this.g == null ? 0 : this.g.d();
    }

    private void J() {
        int i = 1;
        if (this.g != null) {
            int p = this.g.p();
            if (this.g.e() == 5) {
                this.j = p;
            } else if (this.j != p) {
                this.c.a(p);
                if (this.i) {
                    this.i = false;
                    E e = this.r;
                    int g = this.g.g();
                    if (!this.g.w()) {
                        i = 0;
                    }
                    e.a(g, 53, i, null);
                }
                this.j = p;
            } else if (!this.i) {
                this.i = true;
                E e2 = this.r;
                int g2 = this.g.g();
                if (!this.g.w()) {
                    i = 0;
                }
                e2.a(g2, 52, i, null);
            }
        }
    }

    public final boolean b(String str, String str2) {
        boolean z = true;
        if (this.g == null) {
            return false;
        }
        if (str.equals("rw.instance.mute")) {
            if (str2.equals("false")) {
                this.m = false;
                if (this.g.a() == F.STARTED || this.g.a() == F.PAUSED) {
                    if (this.n || !Settings.shouldUseDefaultAudioFocusChangeListener()) {
                        z = false;
                    }
                    this.o = z;
                    if (this.o) {
                        com.uc.apollo.media.base.a.a(this);
                    }
                }
            } else if (str2.equals("true")) {
                this.m = true;
            }
        }
        return this.g.b(str, str2);
    }

    public final String a(String str) {
        if (this.g != null) {
            return this.g.a(str);
        }
        return null;
    }

    public final void H() {
        boolean z = true;
        this.n = true;
        if (this.n || !Settings.shouldUseDefaultAudioFocusChangeListener()) {
            z = false;
        }
        this.o = z;
    }

    public static void a(boolean z) {
        t = z;
    }

    private void K() {
        if (t) {
            String str;
            com.uc.apollo.media.a.a a = com.uc.apollo.media.a.a.a();
            if (this.g == null || !(this.g.l() instanceof DataSourceURI)) {
                str = null;
            } else {
                str = ((DataSourceURI) this.g.l()).pageUri;
            }
            this.s = a.a(str, l(), this.g.u());
        }
    }

    private void L() {
        if (t && this.g != null) {
            if (this.s == null) {
                K();
            }
            if (this.s != null) {
                this.s.b(this.g.p());
            }
        }
    }

    static /* synthetic */ void e(B b) {
        if (t && b.g != null) {
            if (b.s == null) {
                b.K();
            }
            if (b.s != null) {
                com.uc.apollo.media.a.a.a();
                b.g.g(com.uc.apollo.media.a.a.a(b.s));
            }
        }
    }
}
