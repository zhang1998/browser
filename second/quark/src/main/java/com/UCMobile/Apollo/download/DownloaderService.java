package com.UCMobile.Apollo.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.UCMobile.Apollo.download.service.a.a;
import com.UCMobile.Apollo.download.service.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class DownloaderService extends Service {
    public static DownloaderService a = null;
    private static boolean b = a.LOGCAT;
    private static String c = "ApolloMediaDownloader";
    private final a d = new a(this) {
        final /* synthetic */ DownloaderService a;

        {
            this.a = r1;
        }

        public final void a(b bVar) {
            synchronized (this.a) {
                if (DownloaderService.b) {
                    String.format("IDownloaderService.Stub.onPlayingDownloaderCreate()", new Object[0]);
                }
                b a = b.a();
                if (b.a) {
                    String.format("DownloaderManager.registerPlayingDownloader()", new Object[0]);
                }
                synchronized (a) {
                    a.d.put(bVar, null);
                }
                b.a().a(bVar, 1001);
            }
        }

        public final void b(b bVar) {
            synchronized (this.a) {
                if (DownloaderService.b) {
                    String.format("IDownloaderService.Stub.onPlayingDownloaderDestroy()", new Object[0]);
                }
                b a = b.a();
                if (b.a) {
                    String.format("DownloaderManager.unregisterPlayingDownloader()", new Object[0]);
                }
                String str = "";
                try {
                    String f = bVar.f();
                } catch (RemoteException e) {
                    if (b.a) {
                        String.format("DownloaderService.unregisterPlayingDownloader() catch RemoteException!", new Object[0]);
                    }
                    f = str;
                }
                synchronized (a) {
                    b bVar2;
                    ArrayList arrayList = new ArrayList();
                    for (b bVar22 : a.d.keySet()) {
                        try {
                            if (f.equals(bVar22.f())) {
                                arrayList.add(bVar22);
                            }
                        } catch (RemoteException e2) {
                            arrayList.add(bVar22);
                            if (b.a) {
                                String.format("DownloaderService.unregisterPlayingDownloader() catch RemoteException!  toBeRemove.add(aPlayingDownloader)", new Object[0]);
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        bVar22 = (b) it.next();
                        g gVar = (g) a.d.get(bVar22);
                        if (gVar != null) {
                            gVar.a(null);
                        }
                        a.d.remove(bVar22);
                    }
                    for (int i = 0; i < a.c.size(); i++) {
                        g gVar2 = (g) a.c.get(i);
                        if (f.equals(gVar2.getUrl())) {
                            gVar2.a(null);
                        }
                    }
                }
                b.a().a(bVar, 1000);
            }
        }
    };

    public void finalize() throws Throwable {
        if (b) {
            String.format("DownloaderService.finalize()", new Object[0]);
        }
        super.finalize();
    }

    public IBinder onBind(Intent intent) {
        return this.d;
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        if (b) {
            String.format("DownloaderService.onUnbind()", new Object[0]);
        }
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        if (b) {
            String.format("DownloaderService.onDestroy()", new Object[0]);
        }
        b a = b.a();
        synchronized (a) {
            for (int i = 0; i < a.c.size(); i++) {
                g gVar = (g) a.c.get(i);
                gVar.a(null);
                gVar.onSwitchDownloadMode(1000);
            }
            a.d.clear();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
