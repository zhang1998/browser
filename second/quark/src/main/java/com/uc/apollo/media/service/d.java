package com.uc.apollo.media.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.Settings;
import com.uc.apollo.media.CodecLibUpgrader;
import com.uc.apollo.media.base.Statistic;
import com.uc.apollo.preload.i;
import com.uc.apollo.util.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class d {
    private static final String a = (t.a + "BpMediaPlayerService");
    private static int b = 0;
    private static Context c;
    private static Handler d;
    private static ServiceConnection e;
    private static h f;
    private static boolean g;
    private static b h;
    private static SparseArray<a> i = new SparseArray();

    /* compiled from: ProGuard */
    final class a implements Runnable {
        Context a;

        a(Context context) {
            this.a = context;
        }

        public final void run() {
            d.a(this.a);
        }
    }

    /* compiled from: ProGuard */
    final class b extends com.uc.apollo.media.service.i.a {
        b() {
        }

        public final void a(int i) throws RemoteException {
            d.d.obtainMessage(5, i, 0).sendToTarget();
        }

        public final void a(int i, int i2, int i3) throws RemoteException {
            d.d.obtainMessage(1, i, 0, new int[]{i2, i3}).sendToTarget();
        }

        public final void a(int i, int i2, int i3, int i4) throws RemoteException {
            d.d.obtainMessage(3, i, 0, new int[]{i2, i3, i4}).sendToTarget();
        }

        public final void a(int i, int i2) throws RemoteException {
            d.d.obtainMessage(10, i, i2).sendToTarget();
        }

        public final void b(int i, int i2, int i3) throws RemoteException {
            d.d.obtainMessage(4, i, 0, new int[]{i2, i3}).sendToTarget();
        }

        public final void a(int i, int i2, int i3, w wVar) throws RemoteException {
            d.d.obtainMessage(6, i, 0, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), wVar.a()}).sendToTarget();
        }

        public final void b(int i) throws RemoteException {
            d.d.obtainMessage(2, i, 0).sendToTarget();
        }

        public final void a(int i, int i2, Map map) throws RemoteException {
            d.d.obtainMessage(9, i, i2, map).sendToTarget();
        }

        public final void c(int i, int i2, int i3) throws RemoteException {
            d.d.obtainMessage(11, i, 0, new int[]{i2, i3}).sendToTarget();
        }

        public final String a(String str) throws RemoteException {
            return Settings.getStringValue(str);
        }

        public final int b(String str) throws RemoteException {
            return Settings.getIntValue(str);
        }

        public final float c(String str) throws RemoteException {
            return Settings.getFloatValue(str);
        }

        public final boolean d(String str) throws RemoteException {
            return Settings.getBoolValue(str);
        }

        public final String e(String str) throws RemoteException {
            return Settings.getCookie(str != null ? Uri.parse(str) : null);
        }

        public final String f(String str) throws RemoteException {
            return Settings.getUserAgent(str != null ? Uri.parse(str) : null);
        }
    }

    /* compiled from: ProGuard */
    final class c implements ServiceConnection {
        private c() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a;
            new StringBuilder("onServiceConnected, name/binder ").append(componentName).append("/").append(iBinder);
            if (Looper.getMainLooper() != Looper.myLooper()) {
                new Handler(Looper.getMainLooper()).post(new e(this, iBinder));
            } else {
                b(iBinder);
            }
        }

        private static void b(IBinder iBinder) {
            try {
                d.f = com.uc.apollo.media.service.h.a.a(iBinder);
                d.f.a(Settings.getUserType());
                com.uc.apollo.a.a(d.f);
                if (d.h == null) {
                    d.h = new b();
                }
                d.f.a(d.h);
                d.b = 2;
            } catch (RemoteException e) {
                d.f = null;
                d.b = -1;
            }
            d.o();
            if (d.f != null) {
                for (int i = 0; i < d.i.size(); i++) {
                    ((a) d.i.get(d.i.keyAt(i))).a(d.f);
                }
            }
            if (d.f != null) {
                i.a(d.f);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            d.a;
            new StringBuilder("onServiceDisconnected, name ").append(componentName);
            if (Looper.getMainLooper() != Looper.myLooper()) {
                new Handler(Looper.getMainLooper()).post(new f(this));
            } else {
                b();
            }
        }

        private static void b() {
            d.b = 3;
            d.g = false;
            d.f = null;
            for (int i = 0; i < d.i.size(); i++) {
                ((a) d.i.get(d.i.keyAt(i))).L();
            }
            i.a();
            d.n();
            d.d.sendMessageDelayed(d.d.obtainMessage(50), 200);
        }

        protected final void finalize() throws Throwable {
            d.a;
            Context context = Settings.getContext();
            if (context != null) {
                d.a;
                try {
                    context.unbindService(this);
                } catch (Throwable th) {
                }
                d.a;
            }
            super.finalize();
        }
    }

    /* compiled from: ProGuard */
    final class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 50) {
                d.a(Settings.getContext());
            } else if (message.what == 60) {
                Settings.uninit();
            } else {
                a aVar = (a) d.i.get(message.arg1);
                if (aVar != null) {
                    int[] iArr;
                    switch (message.what) {
                        case 1:
                            iArr = (int[]) message.obj;
                            aVar.a(iArr[0], iArr[1]);
                            return;
                        case 2:
                            aVar.N();
                            return;
                        case 3:
                            iArr = (int[]) message.obj;
                            aVar.a(iArr[0], iArr[1], iArr[2]);
                            return;
                        case 4:
                            iArr = (int[]) message.obj;
                            aVar.b(iArr[0], iArr[1]);
                            return;
                        case 5:
                            aVar.M();
                            return;
                        case 6:
                            Object[] objArr = (Object[]) message.obj;
                            aVar.a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), objArr[2]);
                            return;
                        case 7:
                            aVar.b(100, -1);
                            return;
                        case 9:
                            aVar.a(message.arg2, (HashMap) message.obj);
                            return;
                        case 10:
                            aVar.i(message.arg2);
                            return;
                        case 11:
                            iArr = (int[]) message.obj;
                            aVar.c(iArr[0], iArr[1]);
                            return;
                        default:
                            return;
                    }
                } else if (message.what == 9) {
                    Statistic.onStatisticUpdate(message.arg2, (HashMap) message.obj);
                }
            }
        }
    }

    public static void a() {
        if (b == 0) {
            try {
                b = 1;
                new Thread(new a(Settings.getContext().getApplicationContext())).start();
            } catch (Throwable th) {
                b = -1;
            }
        }
    }

    public static void b() {
        n();
        i.clear();
    }

    private static void n() {
        if (e != null) {
            try {
                c.unbindService(e);
            } catch (Throwable th) {
            }
            e = null;
            c = null;
            f = null;
            g = false;
            b = 0;
        }
    }

    public static void a(String str, String str2) {
        if (f != null) {
            try {
                f.a(str, str2);
            } catch (Exception e) {
            }
        }
    }

    private static void o() {
        if (!g) {
            String str = null;
            try {
                if (f.b(CodecLibUpgrader.getApolloSoPath())) {
                    str = CodecLibUpgrader.getApolloSoPath();
                } else if (f.b(Global.gApolloSoPath)) {
                    str = Global.gApolloSoPath;
                }
                if (f.b(str)) {
                    f.a(str);
                    g = true;
                }
            } catch (Exception e) {
                g = false;
            }
        }
    }

    public static a a(int i) {
        f.b();
        if (Settings.shouldAutoCloseMediaPlayerSerivce() && i.size() == 0 && d != null) {
            d.removeMessages(60);
        }
        a aVar = new a(i);
        i.append(aVar.g(), aVar);
        new StringBuilder("createMediaPlayer ").append(aVar).append(", MediaPlayer instance count ").append(i.size());
        if (f != null) {
            o();
            aVar.a(f);
        }
        return aVar;
    }

    static void a(a aVar) {
        f.b();
        i.remove(aVar.g());
        new StringBuilder("deleteMediaPlayer ").append(aVar).append(", MediaPlayer instance remain ").append(i.size());
        if (Settings.shouldAutoCloseMediaPlayerSerivce() && i.size() == 0 && d != null) {
            d.sendEmptyMessageDelayed(60, 120000);
        }
    }

    public static void a(int i, int i2, int i3, int i4, boolean z, int i5) {
        if (f != null) {
            try {
                f.a(i, i2, i3, i4, z, i5);
            } catch (RemoteException e) {
            }
        }
    }

    public static void c() {
        if (f != null) {
            try {
                f.a();
            } catch (RemoteException e) {
            }
        }
    }

    static void b(a aVar) {
        d.obtainMessage(7, aVar.g(), 0).sendToTarget();
    }

    public static void d() {
        if (f != null) {
            try {
                f.b();
            } catch (RemoteException e) {
            }
        }
    }

    public static void e() {
        if (f != null) {
            try {
                f.c();
            } catch (RemoteException e) {
            }
        }
    }

    static /* synthetic */ void a(Context context) {
        if (context != null) {
            String name;
            try {
                Class cls = Class.forName(Settings.getMediaPlayerServiceClassName());
                name = cls.getName();
                ServiceConnection cVar = new c();
                new StringBuilder("try to bind ").append(name).append(" service...");
                Intent intent = new Intent(context, cls);
                com.uc.apollo.Settings.a dexInfo = Settings.getDexInfo();
                if (f.b(dexInfo.a)) {
                    intent.putExtra("dex.path", dexInfo.a);
                    if (f.b(dexInfo.b)) {
                        intent.putExtra("odex.path", dexInfo.b);
                    }
                    if (f.b(dexInfo.c)) {
                        intent.putExtra("lib.path", dexInfo.c);
                    }
                }
                if (context.bindService(intent, cVar, 1)) {
                    e = cVar;
                    c = context;
                    if (d == null) {
                        d = new d(Looper.getMainLooper());
                    }
                    new StringBuilder("exec bindService for ").append(name).append(" done.");
                    return;
                }
                Log.w(a, "try to bind " + name + " failure.");
            } catch (Exception e) {
                return;
            } catch (Throwable th) {
                Log.w(a, "try to bind " + name + " failure: " + th);
            }
        } else {
            Log.w(a, "Cann't bind MediaPlayerService, Context is null!");
        }
        b = -1;
    }
}
