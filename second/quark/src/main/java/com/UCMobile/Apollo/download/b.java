package com.UCMobile.Apollo.download;

import android.content.Context;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    public static boolean a = a.LOGCAT;
    private static String e = "ApolloMediaDownloader";
    private static b f = null;
    ArrayList<e> b = new ArrayList();
    ArrayList<g> c = new ArrayList();
    HashMap<com.UCMobile.Apollo.download.service.b, g> d = new HashMap();

    public static b a() {
        if (f == null) {
            f = new b();
        }
        return f;
    }

    private b() {
    }

    public final a a(Context context, String str, Map<String, String> map) {
        int i;
        com.UCMobile.Apollo.download.service.b bVar = null;
        synchronized (this) {
            for (com.UCMobile.Apollo.download.service.b bVar2 : this.d.keySet()) {
                try {
                    if (bVar2.f().equals(str)) {
                        bVar = bVar2;
                        i = 1;
                        break;
                    }
                } catch (RemoteException e) {
                    if (a) {
                        String.format("DownloaderManager.createDownloader() catch RemoteException!", new Object[0]);
                    }
                }
            }
            i = 0;
        }
        if (a) {
            int i2;
            String str2 = "DownloaderManager.createDownloader()  remoteDownloading:%d, url:%s";
            Object[] objArr = new Object[2];
            if (i != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = a.getTruncateUrl(str);
            String.format(str2, objArr);
        }
        if (i == 0) {
            return new e(context, str, map);
        }
        a gVar = new g(context, str, map);
        gVar.a(bVar);
        synchronized (this) {
            this.d.put(bVar, gVar);
        }
        try {
            bVar.a(gVar.a);
            return gVar;
        } catch (RemoteException e2) {
            if (a) {
                String.format("DownloaderManager.createDownloader() catch RemoteException!  create LocalDownloader instead.", new Object[0]);
            }
            return new e(context, str, map);
        }
    }

    public final void a(com.UCMobile.Apollo.download.service.b bVar, int i) {
        int i2 = 0;
        synchronized (this) {
            a aVar;
            String str = "";
            try {
                String f = bVar.f();
            } catch (RemoteException e) {
                if (a) {
                    String.format("DownloaderService.stopAndSwitchDownloader() catch RemoteException!", new Object[0]);
                }
                f = str;
            }
            if (a) {
                String.format("DownloaderManager.switchDownloader() %s", new Object[]{a.getTruncateUrl(f)});
            }
            if (i == 1000) {
                for (int i3 = 0; i3 < this.c.size(); i3++) {
                    aVar = (a) this.c.get(i3);
                    if (aVar.getUrl().equals(f)) {
                        aVar.onSwitchDownloadMode(i);
                    }
                }
            }
            if (i == 1001) {
                while (i2 < this.b.size()) {
                    aVar = (a) this.b.get(i2);
                    if (aVar.getUrl().equals(f)) {
                        aVar.onSwitchDownloadMode(i);
                    }
                    i2++;
                }
            }
        }
    }
}
