package com.uc.apollo.media.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.uc.apollo.android.SystemAlertWindowPermission;
import com.uc.apollo.media.LittleWindowConfig;
import com.uc.apollo.media.LittleWindowController;
import com.uc.apollo.media.LittleWindowToolbar;
import com.uc.apollo.media.base.WndPos;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceURI;
import com.uc.apollo.media.impl.E;
import com.uc.apollo.media.impl.F;
import com.uc.apollo.media.service.LittleWindowActionStatistic.Factory;
import com.uc.apollo.media.widget.SurfaceListener;
import com.uc.apollo.media.widget.SurfaceProvider;
import com.uc.apollo.util.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: ProGuard */
final class j extends FrameLayout {
    private static final String a = (t.a + "LittleWindow");
    private static final int b;
    private static j c;
    private com.uc.apollo.util.g.c d;
    private WindowManager e;
    private LayoutParams f;
    private SurfaceProvider g;
    private Surface h;
    private FrameLayout.LayoutParams i;
    private LittleWindowToolbar j;
    private FrameLayout.LayoutParams k;
    private Handler l;
    private n m;
    private r n;
    private boolean o;
    private int[] p;
    private boolean q;
    private int r;
    private int s;
    private LittleWindowController t = new k(this);
    private E u = new l(this);
    private b v = new m(this);

    /* compiled from: ProGuard */
    final class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                j.a;
                if (j.c != null && j.c.m != null) {
                    j.c.m.c();
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends Handler {
        private WeakReference<j> a;

        b(j jVar) {
            this.a = new WeakReference(jVar);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 13) {
                j.a;
                new StringBuilder("handleMessage - ").append(j.c(message.what)).append(" ").append(message);
            }
            j jVar = (j) this.a.get();
            if (jVar != null) {
                int[] iArr;
                switch (message.what) {
                    case 1:
                        j.h(jVar);
                        return;
                    case 2:
                        j.i(jVar);
                        g.a().d();
                        return;
                    case 3:
                        jVar.f();
                        g.a().e();
                        return;
                    case 4:
                        iArr = (int[]) message.obj;
                        if (message.arg1 != 1) {
                            z = false;
                        }
                        j.a(jVar, iArr, z);
                        return;
                    case 5:
                        int[] iArr2 = (int[]) message.obj;
                        o.a(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
                        return;
                    case 6:
                        j.j(jVar);
                        return;
                    case 10:
                        if (jVar.j != null) {
                            switch (F.a(((int[]) message.obj)[2])) {
                                case PREPARING:
                                    j.l(jVar);
                                    jVar.j.onPreparing();
                                    return;
                                case STARTED:
                                    j.l(jVar);
                                    jVar.j.onPlay();
                                    return;
                                default:
                                    jVar.k();
                                    jVar.j.onPause();
                                    return;
                            }
                        }
                        return;
                    case 11:
                        iArr = (int[]) message.obj;
                        if (jVar.r != iArr[1] || jVar.s != iArr[2]) {
                            jVar.n.a(4, iArr[1]);
                            jVar.n.a(5, iArr[2]);
                            jVar.r = iArr[1];
                            jVar.s = iArr[2];
                            o.d();
                            o.a(false, jVar.r, jVar.s);
                            if (jVar.j != null) {
                                jVar.j.onVideoSizeChanged(jVar.r, jVar.s);
                                return;
                            }
                            return;
                        }
                        return;
                    case 12:
                        iArr = (int[]) message.obj;
                        jVar.n.a(6, iArr[1]);
                        jVar.n.a(4, iArr[2]);
                        jVar.n.a(5, iArr[3]);
                        if (!(jVar.r == iArr[2] && jVar.s == iArr[3])) {
                            jVar.r = iArr[2];
                            jVar.s = iArr[3];
                            o.d();
                            o.a(false, jVar.r, jVar.s);
                        }
                        if (jVar.j != null) {
                            jVar.j.onPrepared(iArr[1], jVar.r, jVar.s);
                            return;
                        }
                        return;
                    case 13:
                        jVar.n.a(message.arg1);
                        if (jVar.j != null) {
                            jVar.j.onPositionChanged(message.arg1);
                            return;
                        }
                        return;
                    case 14:
                        if (jVar.j != null) {
                            jVar.j.onCompletion();
                            return;
                        }
                        return;
                    case 15:
                        if (jVar.n.d()) {
                            jVar.n.c();
                            jVar.n();
                            jVar.n.c();
                        }
                        if (message.obj instanceof DataSourceURI) {
                            DataSourceURI dataSourceURI = (DataSourceURI) message.obj;
                            if (jVar.j != null) {
                                jVar.j.onSourceChanged(dataSourceURI.pageUri, dataSourceURI.uri, dataSourceURI.title);
                                return;
                            }
                            return;
                        }
                        return;
                    case 16:
                        iArr = (int[]) message.obj;
                        j.a(jVar, iArr[1], iArr[2]);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class c implements SurfaceListener {
        final /* synthetic */ j a;
        private Object b;

        private c(j jVar) {
            this.a = jVar;
        }

        public final void surfaceCreated(Surface surface) {
            j.a;
            new StringBuilder("onSurfaceCreated - ").append(surface);
            this.a.h = surface;
            this.a.l();
        }

        public final void surfaceDestroyed(Surface surface) {
            j.a;
            this.a.h = null;
            if (this.a.m != null) {
                this.a.l();
            }
        }

        public final void surfaceChanged(Surface surface, int i, int i2, int i3) {
        }

        public final Object getSibling() {
            return this.b;
        }

        public final void setSibling(Object obj) {
            this.b = obj;
        }
    }

    static /* synthetic */ void a(j jVar, int[] iArr, boolean z) {
        if (jVar.o) {
            jVar.p = null;
            jVar.q = false;
            o.f();
            o.b();
            new StringBuilder("user want to moveToScreen x/y/w/h ").append(iArr[0]).append("/").append(iArr[1]).append("/").append(iArr[2]).append("/").append(iArr[3]);
            WndPos winPosition = jVar.t.getWinPosition();
            int i = iArr[0] - o.a;
            int i2 = iArr[2] + (o.a * 2);
            int i3 = iArr[3] + (o.a * 2);
            int statusBarHeight = (iArr[1] - o.a) - winPosition.getStatusBarHeight();
            if (z) {
                i -= winPosition.x;
                statusBarHeight -= winPosition.y;
                i2 -= winPosition.w;
                int i4 = i3 - winPosition.h;
                jVar.d(4);
                jVar.l.obtainMessage(5, new int[]{i, statusBarHeight, i2, i4}).sendToTarget();
            } else {
                jVar.t.moveTo(i, statusBarHeight, i2, i3);
            }
            if (iArr[4] == 1) {
                jVar.j.onFloating();
                return;
            } else {
                jVar.j.onNormal();
                return;
            }
        }
        jVar.p = iArr;
        jVar.q = z;
    }

    static /* synthetic */ void h(j jVar) {
        if (jVar.g == null) {
            jVar.g = new com.uc.apollo.media.widget.SurfaceProvider.c(jVar.getContext());
            jVar.g.addListener(new c());
            jVar.i = new FrameLayout.LayoutParams(-1, -1, 17);
            jVar.i.leftMargin = o.a;
            jVar.i.topMargin = o.a;
            jVar.i.rightMargin = o.a;
            jVar.i.bottomMargin = o.a;
            jVar.addView(jVar.g.asView(), jVar.i);
            o.a(jVar.v);
            o.a(jVar.t);
            o.c();
            jVar.e = (WindowManager) jVar.getContext().getSystemService("window");
            if (jVar.e != null) {
                jVar.n = com.uc.apollo.media.service.r.b.a();
                jVar.f = new LayoutParams(b, 262696, -3);
                LayoutParams layoutParams = jVar.f;
                layoutParams.flags |= 16777216;
                jVar.f.gravity = 8388659;
                jVar.f.x = 0;
                jVar.f.y = 0;
                jVar.f.width = 2;
                jVar.f.height = 2;
                try {
                    if (com.uc.apollo.media.base.j.a && com.uc.apollo.media.base.j.a(jVar, jVar.f)) {
                        jVar.d = new com.uc.apollo.util.g.b();
                        if (jVar.d == null) {
                            jVar.d = new com.uc.apollo.util.g.a();
                        }
                        jVar.k = new FrameLayout.LayoutParams(-1, -1, 17);
                        if (LittleWindowConfig.getLittleWindowToolbarFactory() != null) {
                            jVar.j = LittleWindowConfig.getLittleWindowToolbarFactory().create(jVar.getContext(), jVar.t);
                        }
                        if (jVar.j == null) {
                            jVar.j = new s(jVar.getContext(), jVar.t);
                        }
                        jVar.addView(jVar.j.asView(), jVar.k);
                    }
                    jVar.e.addView(jVar, jVar.f);
                    if (jVar.d == null) {
                        jVar.d = new com.uc.apollo.util.g.a();
                    }
                    jVar.k = new FrameLayout.LayoutParams(-1, -1, 17);
                    if (LittleWindowConfig.getLittleWindowToolbarFactory() != null) {
                        jVar.j = LittleWindowConfig.getLittleWindowToolbarFactory().create(jVar.getContext(), jVar.t);
                    }
                    if (jVar.j == null) {
                        jVar.j = new s(jVar.getContext(), jVar.t);
                    }
                    jVar.addView(jVar.j.asView(), jVar.k);
                } catch (Throwable th) {
                    jVar.e.addView(jVar, jVar.f);
                }
            }
        }
    }

    static {
        if (SystemAlertWindowPermission.a()) {
            b = 2005;
        } else {
            b = 2003;
        }
    }

    static void a(Context context) {
        if (c == null) {
            c = new j(context);
            context.registerReceiver(new a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
        }
    }

    static j a() {
        return c;
    }

    static int a(int i) {
        if (i < 5000) {
            return 0;
        }
        if (i >= 50000) {
            return 10000;
        }
        return i / 3;
    }

    final void b() {
        f.b();
        o.a();
        if (this.j != null) {
            this.j.reset();
        }
    }

    final void a(n nVar) {
        f.b();
        this.m = nVar;
    }

    final void c() {
        this.l.sendEmptyMessage(1);
        this.l.sendEmptyMessage(2);
    }

    final void d() {
        this.l.sendEmptyMessage(6);
    }

    final void e() {
        this.l.sendEmptyMessage(3);
    }

    final void a(int[] iArr, boolean z) {
        int i;
        Handler handler = this.l;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(4, i, 0, iArr).sendToTarget();
    }

    private j(Context context) {
        super(context);
        setVisibility(8);
        this.l = new b(this);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void k() {
        LayoutParams layoutParams = this.f;
        layoutParams.flags &= -129;
        this.d.a(this.e, this, this.f, b);
    }

    private void l() {
        if (this.m != null) {
            this.m.a(this.h);
        }
    }

    private void m() {
        if (this.n != null) {
            this.n.b();
        }
        Factory.getInstance().reset();
    }

    private void n() {
        if (this.m != null && this.n.d()) {
            this.n.a(0, this.f.x);
            this.n.a(1, this.f.y);
            this.n.a(2, this.f.width);
            this.n.a(3, this.f.height);
            HashMap a = this.n.a();
            if (a.size() > 0) {
                this.m.a(2, a);
            }
        }
        this.n.b();
    }

    final void f() {
        if (this.g != null) {
            f.b();
            n();
            LittleWindowActionStatistic instance = Factory.getInstance();
            if (this.m != null && instance.valid()) {
                HashMap toMap = instance.toMap();
                if (toMap != null && toMap.size() > 0) {
                    this.m.a(3, toMap);
                }
            }
            instance.reset();
            setVisibility(4);
            if (this.j != null) {
                this.j.onPause();
            }
            k();
            if (this.m != null) {
                this.m.c(74);
            }
            this.j.onNormal();
        }
    }

    final void b(int i) {
        this.l.obtainMessage(13, i, 0).sendToTarget();
    }

    final void a(DataSource dataSource) {
        this.l.obtainMessage(15, dataSource).sendToTarget();
    }

    final E g() {
        return this.u;
    }

    protected final void onAttachedToWindow() {
        int i = 1;
        super.onAttachedToWindow();
        this.o = true;
        if (this.p != null) {
            Handler handler = this.l;
            if (!this.q) {
                i = 0;
            }
            handler.obtainMessage(4, i, 0, this.p).sendToTarget();
        }
    }

    private void d(int i) {
        this.j.setVisibility(i);
        if (i == 0) {
            o.d();
            if (this.r == 0 && this.s == 0) {
                o.a(true, o.d, o.e);
            }
        }
    }

    static /* synthetic */ String c(int i) {
        switch (i) {
            case 1:
                return "init";
            case 2:
                return "show";
            case 3:
                return "hide";
            case 4:
                return "moveToScreen";
            case 5:
                return "rebound";
            case 6:
                return "shownext";
            case 10:
                return "onMediaPlayerStateChange";
            case 11:
                return "onVideoSizeChanged";
            case 12:
                return "onPrepared";
            case 13:
                return "updatePosition";
            case 14:
                return "onCompletion";
            case 15:
                return "MSG_onSetDataSource";
            case 16:
                return "onMessage";
            default:
                return "unknown msg " + i;
        }
    }

    static /* synthetic */ void i(j jVar) {
        jVar.j.onNormal();
        jVar.setVisibility(0);
        if (jVar.h != null) {
            jVar.l();
        }
        jVar.m();
        if (jVar.m != null) {
            jVar.m.c(73);
        }
        o.e();
    }

    static /* synthetic */ void j(j jVar) {
        if (jVar.h != null) {
            jVar.l();
        }
        jVar.m();
    }

    static /* synthetic */ void l(j jVar) {
        LayoutParams layoutParams = jVar.f;
        layoutParams.flags |= 128;
        jVar.d.a(jVar.e, jVar, jVar.f, b);
    }

    static /* synthetic */ void a(j jVar, int i, int i2) {
        switch (i) {
            case 71:
                jVar.n.a(8, i2);
                return;
            case 72:
                jVar.n.a(7, i2);
                return;
            default:
                return;
        }
    }
}
