package com.uc.apollo.media.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.MediaPreload;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.CodecLibUpgrader;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.base.SystemUtil;
import com.uc.apollo.media.impl.A;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceURI;
import com.uc.apollo.media.impl.E;
import com.uc.apollo.media.impl.F;
import com.uc.apollo.media.impl.d;
import com.uc.apollo.media.impl.g;
import com.uc.apollo.util.f;
import com.uc.webview.browser.interfaces.IWebResources;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
class BnMediaPlayerService extends com.uc.apollo.media.service.h.a {
    private static int a = 1;
    private static final String b = (t.a + "BnMediaPlayerService");
    private String c;
    private Context d;
    private c e;
    private SparseArray<g> f = new SparseArray();
    private i g;
    private HandlerThread h;
    private Handler i;
    private volatile Boolean j;
    private b k = new b();

    /* compiled from: ProGuard */
    final class a extends Handler {
        private WeakReference<BnMediaPlayerService> a;

        a(BnMediaPlayerService bnMediaPlayerService, Looper looper) {
            super(looper);
            this.a = new WeakReference(bnMediaPlayerService);
        }

        public final void handleMessage(Message message) {
            BnMediaPlayerService bnMediaPlayerService = (BnMediaPlayerService) this.a.get();
            if (bnMediaPlayerService != null) {
                BnMediaPlayerService.a(bnMediaPlayerService, message);
            }
        }
    }

    /* compiled from: ProGuard */
    final class b implements n {
        final /* synthetic */ BnMediaPlayerService a;
        private int b;
        private String c;

        private b(BnMediaPlayerService bnMediaPlayerService) {
            this.a = bnMediaPlayerService;
            this.b = 0;
        }

        private boolean f() {
            return this.b == 0;
        }

        final void a(int i) {
            this.b = i;
        }

        final void a(String str) {
            synchronized (BnMediaPlayerService.class) {
                this.c = str;
            }
        }

        private String g() {
            String str;
            synchronized (BnMediaPlayerService.class) {
                str = this.c == null ? null : new String(this.c);
            }
            return str;
        }

        final int a() {
            return this.b;
        }

        public final void b() {
            if (!f()) {
                a(1, 0);
            }
        }

        public final void c() {
            if (!f()) {
                a(2, 0);
            }
        }

        public final void b(int i) {
            if (!f()) {
                a(3, i);
            }
        }

        public final void d() {
            if (!f()) {
                a(8, 0);
            }
        }

        public final void e() {
            if (!f()) {
                a(2, 0);
                a(81, 0);
                this.a.i.obtainMessage(29, this.b, 0).sendToTarget();
            }
        }

        public final void a(Surface surface) {
            if (!f()) {
                this.a.a(this.b, 1, surface);
            }
        }

        public final void a(int i, HashMap<String, String> hashMap) {
            if (i == 2) {
                try {
                    String g = g();
                    if (f.b(g)) {
                        hashMap.put("s_h", g);
                    }
                } catch (RemoteException e) {
                    this.a.a(this.b, e);
                    return;
                }
            }
            this.a.g.a(this.b, i, (Map) hashMap);
        }

        public final void c(int i) {
            a(i, 0);
        }

        private void a(int i, int i2) {
            this.a.a(this.b, i, i2, null);
        }
    }

    /* compiled from: ProGuard */
    final class c extends com.uc.apollo.media.impl.E.a {
        final /* synthetic */ BnMediaPlayerService a;

        private c(BnMediaPlayerService bnMediaPlayerService) {
            this.a = bnMediaPlayerService;
        }

        public final void a(int i, int i2, int i3) {
            this.a.c;
            new StringBuilder("onVideoSizeChanged - ID/width/height ").append(i).append("/").append(i2).append("/").append(i3);
            try {
                this.a.g.a(i, i2, i3);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void a(int i, int i2, int i3, int i4) {
            this.a.c;
            new StringBuilder("onPrepared - ID ").append(i).append(" - duration/width/height ").append(f.b(i2)).append("/").append(i3).append("/").append(i4);
            try {
                this.a.g.a(i, i2, i3, i4);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void a(int i, int i2) {
            this.a.c;
            new StringBuilder("onDurationChanged - ID ").append(i).append(" - duration ").append(f.b(i2));
            try {
                this.a.g.a(i, i2);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void a(int i) {
            this.a.c;
            try {
                this.a.g.b(i);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void b(int i) {
            this.a.c;
            try {
                this.a.g.a(i);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void a(int i, int i2, int i3, Object obj) {
            try {
                this.a.g.a(i, i2, i3, new w(obj));
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final void c(int i, int i2, int i3) {
            try {
                this.a.g.c(i, i2, i3);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }

        public final boolean b(int i, int i2, int i3) {
            this.a.c;
            new StringBuilder("onError - ID ").append(i).append(" - ").append(d.a(i2, i3));
            try {
                this.a.g.b(i, i2, i3);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
            this.a.i.obtainMessage(20, i, 0).sendToTarget();
            return true;
        }

        public final void a(int i, int i2, HashMap<String, String> hashMap) {
            try {
                this.a.g.a(i, i2, (Map) hashMap);
            } catch (RemoteException e) {
                this.a.a(i, e);
            }
        }
    }

    static {
        Settings.setIsSvcProcess();
    }

    @KeepForRuntime
    public static void init(Context context) {
        new StringBuilder("init - context: ").append(context);
        Settings.init(context);
        j.a(context);
    }

    public BnMediaPlayerService() {
        StringBuilder append = new StringBuilder().append(b);
        int i = a;
        a = i + 1;
        this.c = append.append(i).toString();
        this.d = Settings.getContext();
        this.e = new c();
        this.h = new HandlerThread(this.c);
        this.h.start();
        this.i = new a(this, this.h.getLooper());
        j.a().b();
        j.a().a(this.k);
        c();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @KeepForRuntime
    public void onUnbind() {
        int i = 3;
        j.a().f();
        this.j = Boolean.valueOf(true);
        int size = this.f.size() + 1;
        if (size <= 3) {
            i = size;
        }
        new Thread(new b(this, i * 1000)).start();
        this.i.sendEmptyMessage(1);
    }

    private static void a(Message message) {
        synchronized (BnMediaPlayerService.class) {
            message.sendToTarget();
            try {
                BnMediaPlayerService.class.wait(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    public final void a(String str) {
        CodecLibUpgrader.setApolloSoPath(str);
    }

    public final void a(String str, String str2) {
        this.i.obtainMessage(39, new String[]{str, str2}).sendToTarget();
    }

    public final void a(int i) {
        Settings.setUserType(i);
    }

    public final void a(i iVar) throws RemoteException {
        new StringBuilder("setListener - ").append(iVar);
        this.g = iVar;
        Settings.setProvider(new c(this));
    }

    public final void a(int i, int i2, int i3) throws RemoteException {
        this.i.obtainMessage(11, i, 0, new int[]{i2, i3}).sendToTarget();
    }

    public final void b(int i) throws RemoteException {
        this.i.obtainMessage(12, i, 0).sendToTarget();
    }

    public final void a(int i, int i2) throws RemoteException {
        this.i.obtainMessage(37, i, i2).sendToTarget();
    }

    public final void c(int i) throws RemoteException {
        this.i.obtainMessage(13, i, 0).sendToTarget();
    }

    public final void d(int i) throws RemoteException {
        this.i.obtainMessage(14, i, 0).sendToTarget();
    }

    public final void e(int i) throws RemoteException {
        this.i.obtainMessage(15, i, 0).sendToTarget();
    }

    public final void a(int i, u uVar) throws RemoteException {
        this.i.obtainMessage(16, i, 0, uVar.a()).sendToTarget();
    }

    public final void f(int i) throws RemoteException {
        this.i.obtainMessage(17, i, 0).sendToTarget();
    }

    public final void g(int i) throws RemoteException {
        this.i.obtainMessage(18, i, 0).sendToTarget();
    }

    public final void b(int i, int i2) throws RemoteException {
        this.i.obtainMessage(19, i, i2).sendToTarget();
    }

    public final void h(int i) throws RemoteException {
        this.i.obtainMessage(20, i, 0).sendToTarget();
    }

    public final int i(int i) throws RemoteException {
        Object obj = new int[]{-1};
        a(this.i.obtainMessage(21, i, 0, obj));
        return obj[0];
    }

    public final void j(int i) throws RemoteException {
        this.i.obtainMessage(26, i, 0).sendToTarget();
    }

    public final Bitmap k(int i) throws RemoteException {
        Object obj = new Object[]{null};
        a(this.i.obtainMessage(34, i, 0, obj));
        return (Bitmap) obj[0];
    }

    public final void a(int i, float f, float f2) throws RemoteException {
        this.i.obtainMessage(36, i, 0, new Float[]{Float.valueOf(f), Float.valueOf(f2)}).sendToTarget();
    }

    public final void c(int i, int i2) throws RemoteException {
        this.i.obtainMessage(22, i, i2).sendToTarget();
    }

    public final void d(int i, int i2) throws RemoteException {
        a(this.i.obtainMessage(23, i, i2));
    }

    public final void e(int i, int i2) throws RemoteException {
        this.i.obtainMessage(24, i, i2).sendToTarget();
    }

    public final void a(int i, int i2, boolean z) {
        this.i.obtainMessage(35, i, i2, Boolean.valueOf(z)).sendToTarget();
    }

    private void a(int i, int i2, Surface surface) {
        a(this.i.obtainMessage(25, i, i2, surface));
    }

    public final y a(int i, int i2, y yVar) throws RemoteException {
        a(i, i2, yVar.a());
        return yVar;
    }

    public final void a(int i, int i2, int i3, int i4) throws RemoteException {
        a(this.i.obtainMessage(31, i, i2, new int[]{i3, i4}));
    }

    public final void a(int i, boolean z) {
        this.i.obtainMessage(27, i, z ? 1 : 0).sendToTarget();
    }

    public final void a(int i, String str, String str2) throws RemoteException {
        this.i.obtainMessage(28, i, 0, new String[]{str, str2}).sendToTarget();
    }

    public final void a(int i, int i2, int i3, int i4, boolean z, int i5) {
        int i6;
        Handler handler = this.i;
        if (z) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        handler.obtainMessage(30, 0, i6, new int[]{i, i2, i3, i4, i5}).sendToTarget();
    }

    public final void a() {
        this.i.obtainMessage(38).sendToTarget();
    }

    public final String a(int i, String str) throws RemoteException {
        Bundle bundle = new Bundle(3);
        bundle.putString("ret", null);
        bundle.putString("key", str);
        a(this.i.obtainMessage(33, i, 0, bundle));
        return bundle.getString("ret");
    }

    public final boolean b(int i, String str, String str2) throws RemoteException {
        Bundle bundle = new Bundle(4);
        bundle.putBoolean("ret", false);
        bundle.putString("key", str);
        bundle.putString("value", str2);
        a(this.i.obtainMessage(32, i, 0, bundle));
        return bundle.getBoolean("ret");
    }

    private static String l(int i) {
        switch (i) {
            case 1:
                return "reset service";
            case 2:
                return "activity status change";
            case 11:
                return "create";
            case 12:
                return "delete";
            case 13:
                return "start";
            case 14:
                return "pause";
            case 15:
                return "stop";
            case 16:
                return "setDataSource";
            case 17:
                return "prepareAsync";
            case 18:
                return "release";
            case 19:
                return "seekTo";
            case 20:
                return IWebResources.TEXT_BTN_DEFAULT_RESET;
            case 21:
                return "getCurrentPosition";
            case 22:
                return "addClient";
            case 23:
                return "removeClient";
            case 24:
                return "setFrontClient";
            case 25:
                return "setSurface";
            case 26:
                return "getCurrentVideoFrameAsync";
            case 27:
                return "setIsVideo";
            case 28:
                return "setTitleAndPageUri";
            case 29:
                return "enterFullScreen";
            case 30:
                return "littleWindowMoveToScreen";
            case 31:
                return "moveSurfaceTo";
            case 32:
                return "setOption";
            case 33:
                return "getOption";
            case 34:
                return "getCurrentVideoFrame";
            case 35:
                return "setVisibility";
            case 36:
                return "setVolume";
            case 37:
                return "changedDomID";
            case 38:
                return "littleWindowHide";
            case 39:
                return "setGlobalOption";
            default:
                return Integer.toString(i);
        }
    }

    private static void m(int i) {
        switch (i) {
            case 21:
            case 23:
            case 25:
            case 31:
            case 32:
            case 33:
                synchronized (BnMediaPlayerService.class) {
                    BnMediaPlayerService.class.notify();
                }
                return;
            default:
                return;
        }
    }

    private void d() {
        for (int i = 0; i < this.f.size(); i++) {
            g gVar = (g) this.f.get(this.f.keyAt(i));
            gVar.b(null);
            gVar.n();
            g.a().a(gVar.f(), false);
        }
        this.f.clear();
        synchronized (BnMediaPlayerService.class) {
            this.j = Boolean.valueOf(false);
            BnMediaPlayerService.class.notifyAll();
        }
    }

    private void a(int i, RemoteException remoteException) {
        this.i.obtainMessage(12, i, 0).sendToTarget();
    }

    private void a(int i, int i2, int i3, Object obj) {
        this.e.a(i, i2, i3, obj);
    }

    public final void b() {
        this.i.obtainMessage(2, 0, 1).sendToTarget();
        g.a().b();
    }

    public final void c() {
        this.i.obtainMessage(2, 0, 2).sendToTarget();
        g.a().c();
    }

    public final void a(String str, String str2, Map map, com.uc.apollo.preload.a aVar) {
        this.i.obtainMessage(51, new Object[]{str, str2, map, aVar}).sendToTarget();
    }

    public final void b(String str) {
        this.i.obtainMessage(52, str).sendToTarget();
    }

    public final void b(String str, String str2) {
        Bundle bundle = new Bundle(2);
        bundle.putString("key", str);
        bundle.putString("value", str2);
        this.i.obtainMessage(53, bundle).sendToTarget();
    }

    public final String c(String str) {
        Bundle bundle = new Bundle(2);
        bundle.putString("key", str);
        a(this.i.obtainMessage(54, bundle));
        return bundle.getString("value");
    }

    public final void a(String str, int i) {
        this.i.obtainMessage(55, i, 0, str).sendToTarget();
    }

    public final void a(com.uc.apollo.preload.b bVar) {
        this.i.obtainMessage(56, bVar).sendToTarget();
    }

    static /* synthetic */ void a(BnMediaPlayerService bnMediaPlayerService, Message message) {
        int i = 1;
        int i2 = 0;
        if (message.what < 10) {
            new StringBuilder("try to handleMessage - ").append(l(message.what)).append("/").append(message);
            switch (message.what) {
                case 1:
                    new StringBuilder("reset, MediaPlayer remain count ").append(bnMediaPlayerService.f.size());
                    bnMediaPlayerService.d();
                    break;
                case 2:
                    boolean z;
                    if (message.arg2 == 1) {
                        z = false;
                    } else if (message.arg2 == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    while (i2 < bnMediaPlayerService.f.size()) {
                        ((g) bnMediaPlayerService.f.get(bnMediaPlayerService.f.keyAt(i2))).b(z);
                        i2++;
                    }
                    break;
            }
            new StringBuilder("handleMessage done - ").append(l(message.what)).append("/").append(message);
        } else if (message.what == 30) {
            j a = j.a();
            int[] iArr = (int[]) message.obj;
            if (message.arg2 != 1) {
                r3 = false;
            }
            a.a(iArr, r3);
        } else if (message.what == 38) {
            j.a().e();
        } else if (message.what == 39) {
            if (message.obj instanceof String[]) {
                String[] strArr = (String[]) message.obj;
                Settings.setGlobalOption(strArr[0], strArr[1]);
            }
        } else if (message.what < 51 || message.what > 56) {
            int i3;
            int i4 = message.arg1;
            g gVar = (g) bnMediaPlayerService.f.get(i4);
            String str = gVar == null ? "" : "[" + gVar + "] ";
            if (message.what == 21) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                new StringBuilder().append(str).append("try to handleMessage - ").append(l(message.what)).append("/").append(message);
            }
            if (gVar != null || message.what == 11) {
                g a2;
                Object th;
                try {
                    int[] iArr2;
                    Bundle bundle;
                    switch (message.what) {
                        case 11:
                            iArr2 = (int[]) message.obj;
                            if (gVar != null) {
                                r3 = false;
                            }
                            f.a(r3, "MediaPlayer with key " + i4 + " was existed!");
                            a2 = A.a(iArr2[0], iArr2[1]);
                            try {
                                a2.f(i4);
                                a2.a(bnMediaPlayerService.e);
                                bnMediaPlayerService.f.append(i4, a2);
                                new StringBuilder("createMediaPlayer ").append(a2).append(", MediaPlayer instance count ").append(bnMediaPlayerService.f.size());
                                i2 = a2.e();
                                Object z2 = a2.z();
                                if (i2 == 5) {
                                    g.a().d((String) z2.get("version"));
                                    g.a().c(Apollo.getBuildSeq());
                                }
                                bnMediaPlayerService.a(i4, 71, i2, z2);
                                g.a().a(com.uc.apollo.media.d.b(i2));
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                break;
                            }
                        case 12:
                            gVar.b(bnMediaPlayerService.e);
                            gVar.n();
                            bnMediaPlayerService.f.remove(i4);
                            new StringBuilder("deleteMediaPlayer ").append(gVar).append(", MediaPlayer instance remain ").append(bnMediaPlayerService.f.size());
                            break;
                        case 13:
                            g.a().a(gVar.f(), true);
                            gVar.h();
                            break;
                        case 14:
                            gVar.j();
                            break;
                        case 15:
                            gVar.k();
                            break;
                        case 16:
                            DataSource dataSource = (DataSource) message.obj;
                            gVar.a(bnMediaPlayerService.d, dataSource);
                            if (bnMediaPlayerService.k.a() == message.arg1) {
                                j.a().a(dataSource);
                                bnMediaPlayerService.k.a(com.uc.apollo.media.impl.DataSource.a.a(dataSource));
                            }
                            if (dataSource instanceof DataSourceURI) {
                                g.a().b(((DataSourceURI) dataSource).uri.toString());
                                break;
                            }
                            break;
                        case 17:
                            gVar.m();
                            break;
                        case 18:
                            gVar.n();
                            break;
                        case 19:
                            if (gVar.g(message.arg2) && bnMediaPlayerService.k.a() == message.arg1) {
                                j.a().b(message.arg2);
                                break;
                            }
                        case 20:
                            gVar.v();
                            g.a().a(gVar.f(), false);
                            break;
                        case 21:
                            iArr2 = (int[]) message.obj;
                            iArr2[0] = gVar.p();
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            if (bnMediaPlayerService.k.a() == message.arg1) {
                                j.a().b(iArr2[0]);
                                break;
                            }
                            break;
                        case 22:
                            gVar.b(message.arg2);
                            break;
                        case 23:
                            gVar.c(message.arg2);
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            if (message.arg2 == 1) {
                                gVar.b(j.a().g());
                                bnMediaPlayerService.k.a(0);
                                break;
                            }
                            break;
                        case 24:
                            gVar.d(message.arg2);
                            if (message.arg2 == 1) {
                                if (bnMediaPlayerService.k.a() != 0) {
                                    i = 0;
                                }
                                bnMediaPlayerService.k.a(gVar.g());
                                if (i != 0) {
                                    j.a().c();
                                } else {
                                    j.a().d();
                                }
                                E g = j.a().g();
                                if (gVar.a() != F.IDLE) {
                                    if (gVar.l() != null) {
                                        j.a().a(gVar.l());
                                    }
                                    if (gVar.w()) {
                                        g.a(gVar.g(), gVar.u(), gVar.s(), gVar.t());
                                        g.a(gVar.g(), 72, gVar.b().i, null);
                                        g.a(gVar.g(), 71, gVar.e(), gVar.z());
                                        j.a().b(gVar.p() + 1);
                                    }
                                    g.a(gVar.g(), F.IDLE, gVar.a());
                                    bnMediaPlayerService.k.a(com.uc.apollo.media.impl.DataSource.a.a(gVar.l()));
                                }
                                gVar.a(g);
                                break;
                            }
                            break;
                        case 25:
                            try {
                                gVar.a(message.arg2, (Surface) message.obj);
                            } catch (Exception e) {
                                Log.e(bnMediaPlayerService.c, "setSurface failure: " + e);
                            }
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            break;
                        case 26:
                            bnMediaPlayerService.e.a(gVar.g(), 64, 0, gVar.r());
                            break;
                        case 27:
                            if (message.arg2 == 0) {
                                r3 = false;
                            }
                            gVar.a(r3);
                            break;
                        case 28:
                            String[] strArr2 = (String[]) message.obj;
                            gVar.a(strArr2[0], strArr2[1]);
                            break;
                        case 29:
                            SystemUtil.openVideoInFullscreen(gVar.f(), gVar.l());
                            break;
                        case 31:
                            try {
                                iArr2 = (int[]) message.obj;
                                gVar.a(message.arg2, (g) bnMediaPlayerService.f.get(iArr2[0]), iArr2[1]);
                            } catch (Exception e2) {
                                Log.e(bnMediaPlayerService.c, "moveSurfaceTo failure: " + e2);
                            }
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            break;
                        case 32:
                            bundle = (Bundle) message.obj;
                            if (!(bundle == null || gVar == null)) {
                                bundle.putBoolean("ret", gVar.b(bundle.getString("key"), bundle.getString("value")));
                            }
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            break;
                        case 33:
                            bundle = (Bundle) message.obj;
                            if (!(bundle == null || gVar == null)) {
                                bundle.putString("ret", gVar.a(bundle.getString("key")));
                            }
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            break;
                        case 34:
                            ((Object[]) message.obj)[0] = gVar.r();
                            synchronized (BnMediaPlayerService.class) {
                                BnMediaPlayerService.class.notify();
                            }
                            break;
                        case 35:
                            gVar.a(message.arg2, ((Boolean) message.obj).booleanValue());
                            break;
                        case 36:
                            Float[] fArr = (Float[]) message.obj;
                            if (!(fArr == null || gVar == null)) {
                                gVar.a(fArr[0].floatValue(), fArr[1].floatValue());
                                break;
                            }
                        case 37:
                            gVar.a(message.arg2);
                            break;
                        default:
                            Log.w(bnMediaPlayerService.c, str + "handleMessage - unsupport message - " + l(message.what));
                            break;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    a2 = gVar;
                    r0 = th4;
                }
                Log.w(bnMediaPlayerService.c, str + "handleMessage " + l(message.what) + " failure: " + th);
                m(message.what);
                if (a2 != null) {
                    try {
                        bnMediaPlayerService.g.b(a2.g(), 200, MediaPlayer.MEDIA_ERROR_UNSUPPORTED);
                        bnMediaPlayerService.b(a2.g());
                    } catch (RemoteException e3) {
                        bnMediaPlayerService.a(a2.g(), e3);
                    }
                }
                if (i3 == 0) {
                    new StringBuilder().append(str).append("handleMessage done - ").append(l(message.what)).append("/").append(message);
                    return;
                }
                return;
            }
            Log.w(bnMediaPlayerService.c, "want to handleMessage - " + l(message.what) + " but MediaPlayer does not exists(id: " + i4 + ")!");
            m(message.what);
        } else if (com.uc.apollo.media.impl.a.c()) {
            try {
                Bundle bundle2;
                switch (message.what) {
                    case 51:
                        Object[] objArr = (Object[]) message.obj;
                        com.uc.apollo.preload.c.a((String) objArr[0], (String) objArr[1], (HashMap) objArr[2], (com.uc.apollo.preload.a) objArr[3]);
                        return;
                    case 52:
                        MediaPreload.Remove((String) message.obj);
                        return;
                    case 53:
                        bundle2 = (Bundle) message.obj;
                        MediaPreload.SetOption(bundle2.getString("key"), bundle2.getString("value"));
                        return;
                    case 54:
                        bundle2 = (Bundle) message.obj;
                        bundle2.putString("value", MediaPreload.GetOption(bundle2.getString("key")));
                        synchronized (BnMediaPlayerService.class) {
                            BnMediaPlayerService.class.notify();
                        }
                        return;
                    case 55:
                        MediaPreload.SetPriority((String) message.obj, message.arg1);
                        return;
                    case 56:
                        com.uc.apollo.preload.c.a((com.uc.apollo.preload.b) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th5) {
                Log.w(bnMediaPlayerService.c, "handlePreloaderMessage " + l(message.what) + " failure: " + th5);
            }
            Log.w(bnMediaPlayerService.c, "handlePreloaderMessage " + l(message.what) + " failure: " + th5);
        }
    }
}
