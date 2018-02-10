package com.UCMobile.Apollo.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.UCMobile.Apollo.MediaDownloader;
import com.UCMobile.Apollo.download.service.ParcelableObject;
import com.UCMobile.Apollo.download.service.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class f extends a {
    private static boolean c = a.LOGCAT;
    private static String d = "ApolloMediaDownloader";
    int a;
    int b;
    private c e;
    private b f;
    private a g;
    private NativeDownloaderImpl h;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, String> i = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Long> j = new HashMap();
    private int[] k = null;
    private int[] l = null;
    private boolean m = false;
    private boolean n = false;

    /* compiled from: ProGuard */
    final class a extends Handler {
        final /* synthetic */ f a;

        private a(f fVar) {
            this.a = fVar;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    f.b(this.a);
                    this.a.start();
                    return;
                case 1:
                    f.c(this.a);
                    this.a.reset();
                    return;
                case 2:
                    this.a.pause();
                    return;
                case 3:
                    this.a.a();
                    if (this.a.n) {
                        synchronized (this.a) {
                            this.a.n = false;
                            this.a.notify();
                        }
                        return;
                    }
                    return;
                case 4:
                    this.a.setSaveFilePath(message.getData().getString("path"), message.getData().getString("filename"));
                    return;
                case 5:
                    this.a.deleteFile();
                    return;
                case 6:
                    this.a.setAlternativeURL(message.getData().getString("alternativeURL"));
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends com.UCMobile.Apollo.download.service.b.a {
        boolean a;
        final /* synthetic */ f b;

        private b(f fVar) {
            this.b = fVar;
            this.a = false;
        }

        public final int a() {
            if (f.c) {
                String.format("PlayingDownloaderStub.start()", new Object[0]);
            }
            this.b.g.sendMessage(this.b.g.obtainMessage(0));
            return 0;
        }

        public final int b() {
            if (f.c) {
                String.format("PlayingDownloaderStub.reset()", new Object[0]);
            }
            this.b.g.sendMessage(this.b.g.obtainMessage(1));
            return 0;
        }

        public final int c() {
            if (f.c) {
                String.format("PlayingDownloaderStub.pause()", new Object[0]);
            }
            this.b.g.sendMessage(this.b.g.obtainMessage(2));
            return 0;
        }

        public final int d() {
            if (f.c) {
                String.format("PlayingDownloaderStub.stop()", new Object[0]);
            }
            this.b.g.sendMessage(this.b.g.obtainMessage(3));
            synchronized (this.b) {
                try {
                    this.b.n = true;
                    this.b.wait();
                } catch (Throwable e) {
                    Log.getStackTraceString(e);
                }
            }
            return 0;
        }

        public final int e() {
            if (f.c) {
                String.format("PlayingDownloaderStub.deleteFile()", new Object[0]);
            }
            this.b.g.sendMessage(this.b.g.obtainMessage(5));
            return 0;
        }

        public final int a(String str, String str2) {
            if (f.c) {
                String.format("PlayingDownloaderStub.setSaveFilePath() %s,%s", new Object[]{str, str2});
            }
            Message obtainMessage = this.b.g.obtainMessage(4);
            Bundle bundle = new Bundle();
            bundle.putString("path", str);
            bundle.putString("filename", str2);
            obtainMessage.setData(bundle);
            this.b.g.sendMessage(obtainMessage);
            return 0;
        }

        public final void a(String str) {
            if (f.c) {
                String.format("PlayingDownloaderStub.setAlternativeURL() %s", new Object[]{str});
            }
            Message obtainMessage = this.b.g.obtainMessage(6);
            Bundle bundle = new Bundle();
            bundle.putString("alternativeURL", str);
            obtainMessage.setData(bundle);
            this.b.g.sendMessage(obtainMessage);
        }

        public final String f() {
            return this.b.getUrl();
        }

        public final void a(c cVar) {
            this.b.a(cVar);
        }
    }

    static /* synthetic */ void c(f fVar) {
        fVar.a = 0;
        fVar.b = 0;
        fVar.i.clear();
        fVar.j.clear();
        fVar.k = null;
        fVar.l = null;
    }

    public static f a(Context context, String str, Map<String, String> map) {
        if (!MediaDownloader.isSupportDownload()) {
            return null;
        }
        if (c) {
            String.format("PlayingDownloader.create()", new Object[0]);
        }
        return new f(context, str, map);
    }

    private f(Context context, String str, Map<String, String> map) {
        super(context, str, map);
        this.h = new NativeDownloaderImpl(context, str, map);
        this.h.setExternalDownloadListener(this);
        this.f = new b();
        c a = c.a();
        com.UCMobile.Apollo.download.service.b bVar = this.f;
        if (c.a) {
            String.format("DownloaderServiceClient.registerPlayingDownloader() url:%s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        synchronized (a) {
            a.i.put(this, bVar);
        }
        a.d.removeCallbacks(a.e);
        if (a.h == b.b || a.h == b.e) {
            if (context != null) {
                a.g = context.getApplicationContext();
                Class cls = DownloaderService.class;
                String name = cls.getName();
                try {
                    ServiceConnection aVar = new a();
                    if (c.a) {
                        new StringBuilder("DownloaderServiceClient.bindService()  to bind ").append(name).append(" service...");
                    }
                    if (context.bindService(new Intent(context, cls), aVar, 1)) {
                        a.f = aVar;
                        if (c.a) {
                            new StringBuilder("DownloaderServiceClient.bindService() bindService for ").append(name).append(" done.");
                        }
                    } else if (c.a) {
                        new StringBuilder("DownloaderServiceClient.bindService() try to bind ").append(name).append(" failure.");
                    }
                } catch (Throwable th) {
                    if (c.a) {
                        new StringBuilder("DownloaderServiceClient.bindService() try to bind ").append(name).append(" failure: ").append(th);
                    }
                }
            }
            a.h = b.a;
        }
        if (a.c != null) {
            try {
                a.c.a(bVar);
            } catch (RemoteException e) {
                if (c.a) {
                    String.format("DownloaderServiceClient.registerPlayingDownloader()   catch RemoteException!", new Object[0]);
                }
            }
        }
        this.g = new a();
    }

    public final int start() {
        if (c) {
            String.format("PlayingDownloader.start()", new Object[0]);
        }
        return this.h.start();
    }

    public final int reset() {
        if (c) {
            String.format("PlayingDownloader.reset()", new Object[0]);
        }
        return this.h.reset();
    }

    public final int pause() {
        if (c) {
            String.format("PlayingDownloader.pause()", new Object[0]);
        }
        return this.h.pause();
    }

    public final int stop() {
        if (c) {
            String.format("PlayingDownloader.stop()", new Object[0]);
        }
        if (this.m) {
            return -1;
        }
        this.m = true;
        this.h.stop();
        release();
        return 0;
    }

    public final int a() {
        if (c) {
            String.format("PlayingDownloader.stopByRemote()", new Object[0]);
        }
        this.h.stop();
        this.h.release();
        return 0;
    }

    protected final void release() {
        this.h.release();
        a(null);
        c a = c.a();
        com.UCMobile.Apollo.download.service.b bVar = this.f;
        if (c.a) {
            String.format("DownloaderServiceClient.unregisterPlayingDownloader() %s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        try {
            if (a.c != null) {
                a.c.b(bVar);
            } else {
                String.format("DownloaderServiceClient.unregisterPlayingDownloader()   _iDownloaderService == null!", new Object[0]);
            }
        } catch (RemoteException e) {
            if (c.a) {
                String.format("DownloaderServiceClient.unregisterPlayingDownloader()   catch RemoteException!", new Object[0]);
            }
        }
        synchronized (a) {
            a.i.remove(this);
        }
        if (a.i.size() == 0) {
            a.d.postDelayed(a.e, 30000);
        }
    }

    public final int deleteFile() {
        if (c) {
            String.format("PlayingDownloader.deleteFile()", new Object[0]);
        }
        return this.h.deleteFile();
    }

    public final int setSaveFilePath(String str, String str2) {
        if (c) {
            String.format("PlayingDownloader.setSaveFilePath() %s,%s", new Object[]{str, str2});
        }
        return this.h.setSaveFilePath(str, str2);
    }

    public final void setAlternativeURL(String str) {
        if (c) {
            String.format("PlayingDownloader.setAlternativeURL() %s", new Object[]{str});
        }
        this.h.setAlternativeURL(str);
    }

    public final void a(c cVar) {
        if (c) {
            int hashCode;
            String str = "PlayingDownloader.setRemoteDownloaderListener(%d)";
            Object[] objArr = new Object[1];
            if (cVar != null) {
                hashCode = cVar.hashCode();
            } else {
                hashCode = 0;
            }
            objArr[0] = Integer.valueOf(hashCode);
            String.format(str, objArr);
        }
        this.e = cVar;
    }

    public final void onDownloadInfo(int i, long j) {
        if (c) {
            String.format("PlayingDownloader.onDownloadInfo(%d %d)", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        }
        this.j.put(Integer.valueOf(i), Long.valueOf(j));
        super.onDownloadInfo(i, j);
        if (this.e != null) {
            try {
                this.e.a(i, j);
            } catch (RemoteException e) {
            }
        }
    }

    public final void onStateToggle(int i, int i2) {
        if (c) {
            String.format("PlayingDownloader.onStateToggle(%d %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.a = i;
        this.b = i2;
        super.onStateToggle(i, i2);
        if (this.e != null) {
            try {
                this.e.a(i, i2);
            } catch (RemoteException e) {
            }
        }
    }

    public final void onFileAttribute(int i, String str) {
        if (c) {
            String.format("PlayingDownloader.onFileAttribute(%d, %s)", new Object[]{Integer.valueOf(i), str});
        }
        this.i.put(Integer.valueOf(i), str);
        super.onFileAttribute(i, str);
        if (this.e != null) {
            try {
                this.e.a(i, str);
            } catch (RemoteException e) {
            }
        }
    }

    public final void onPlayableRanges(int[] iArr, int[] iArr2) {
        int i;
        int i2 = 0;
        if (c) {
            i = 0;
            while (i < iArr.length && i < iArr2.length) {
                String.format("PlayingDownloader.onPlayableRanges(%d, %d)", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])});
                i++;
            }
        }
        this.k = new int[iArr.length];
        for (i = 0; i < iArr.length; i++) {
            this.k[i] = iArr[i];
        }
        this.l = new int[iArr2.length];
        while (i2 < iArr2.length) {
            this.l[i2] = iArr2[i2];
            i2++;
        }
        super.onPlayableRanges(iArr, iArr2);
        if (this.e != null) {
            try {
                this.e.a(iArr, iArr2);
            } catch (RemoteException e) {
            }
        }
    }

    public final void onSwitchDownloadMode(int i) {
        if (c) {
            String.format("PlayingDownloader.onSwitchDownloadMode(%d)", new Object[]{Integer.valueOf(i)});
        }
        super.onSwitchDownloadMode(i);
    }

    public final void onStatistics(HashMap<String, String> hashMap) {
        ParcelableObject parcelableObject = new ParcelableObject(hashMap);
        if (this.e != null) {
            try {
                String.format("PlayingDownloader.onStat in", new Object[0]);
                this.e.a(parcelableObject);
            } catch (RemoteException e) {
            }
        }
    }

    static /* synthetic */ void b(f fVar) {
        try {
            fVar.e.a(fVar.a, fVar.b);
            for (Entry entry : fVar.j.entrySet()) {
                fVar.e.a(((Integer) entry.getKey()).intValue(), ((Long) entry.getValue()).longValue());
            }
            for (Entry entry2 : fVar.i.entrySet()) {
                fVar.e.a(((Integer) entry2.getKey()).intValue(), (String) entry2.getValue());
            }
            fVar.e.a(fVar.k, fVar.l);
        } catch (Exception e) {
        }
    }
}
