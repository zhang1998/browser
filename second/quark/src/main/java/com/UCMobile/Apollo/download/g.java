package com.UCMobile.Apollo.download;

import android.content.Context;
import android.os.RemoteException;
import com.UCMobile.Apollo.download.service.ParcelableObject;
import com.UCMobile.Apollo.download.service.b;
import com.UCMobile.Apollo.download.service.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class g extends a {
    private static boolean b = a.LOGCAT;
    private static String c = "ApolloMediaDownloader";
    c a = null;
    private b d = null;

    /* compiled from: ProGuard */
    public final class a extends com.UCMobile.Apollo.download.service.c.a {
        final /* synthetic */ g a;

        public a(g gVar) {
            this.a = gVar;
        }

        public final void a(int i, long j) {
            this.a.onDownloadInfo(i, j);
        }

        public final void a(int i, int i2) {
            this.a.onStateToggle(i, i2);
        }

        public final void a(int i, String str) {
            this.a.onFileAttribute(i, str);
        }

        public final void a(int[] iArr, int[] iArr2) {
            this.a.onPlayableRanges(iArr, iArr2);
        }

        public final void a(ParcelableObject parcelableObject) {
            this.a.a(parcelableObject);
        }
    }

    public g(Context context, String str, Map<String, String> map) {
        super(context, str, map);
        if (b) {
            String.format("RemoteDownloader.RemoteDownloader() url:%s", new Object[]{a.getTruncateUrl(str)});
        }
        this.a = new a(this);
        b a = b.a();
        if (b.a) {
            String.format("DownloaderManager.registerRemoteDownloader() url:%s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        synchronized (a) {
            a.c.add(this);
        }
    }

    public final void a(b bVar) {
        if (b) {
            int hashCode;
            String str = "RemoteDownloader.setPlayingDownloader(%d)";
            Object[] objArr = new Object[1];
            if (bVar != null) {
                hashCode = bVar.hashCode();
            } else {
                hashCode = 0;
            }
            objArr[0] = Integer.valueOf(hashCode);
            String.format(str, objArr);
        }
        this.d = bVar;
    }

    public final int start() {
        int i = -1;
        if (b) {
            String.format("RemoteDownloader.start() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        onDownloadInfo(106, 0);
        if (this.d != null) {
            try {
                i = this.d.a();
            } catch (RemoteException e) {
                if (b) {
                    String.format("RemoteDownloader.start() catch RemoteException!", new Object[0]);
                }
            }
        }
        return i;
    }

    public final int reset() {
        int i = -1;
        if (b) {
            String.format("RemoteDownloader.reset() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        try {
            if (this.d != null) {
                i = this.d.b();
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.reset() catch RemoteException!", new Object[0]);
            }
        }
        return i;
    }

    public final int pause() {
        int i = -1;
        if (b) {
            String.format("RemoteDownloader.pause() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        try {
            if (this.d != null) {
                i = this.d.c();
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.pause() catch RemoteException!", new Object[0]);
            }
        }
        return i;
    }

    public final int stop() {
        if (b) {
            String.format("RemoteDownloader.stop() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        int i = -1;
        try {
            if (this.d != null) {
                i = this.d.d();
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.stop() catch RemoteException!", new Object[0]);
            }
        }
        release();
        return i;
    }

    protected final void release() {
        b a = b.a();
        if (b.a) {
            String.format("DownloaderManager.unregisterRemoteDownloader() url:%s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        synchronized (a) {
            a.c.remove(this);
            for (Entry entry : a.d.entrySet()) {
                b bVar = (b) entry.getKey();
                g gVar = (g) entry.getValue();
                if (gVar == this) {
                    gVar.a(null);
                    a.d.put(bVar, null);
                    try {
                        bVar.a(null);
                    } catch (RemoteException e) {
                        if (b.a) {
                            String.format("DownloaderService.unregisterRemoteDownloader() catch RemoteException!", new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public final int deleteFile() {
        int i = -1;
        if (b) {
            String.format("RemoteDownloader.deleteFile() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        try {
            if (this.d != null) {
                i = this.d.e();
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.deleteFile() catch RemoteException!", new Object[0]);
            }
        }
        return i;
    }

    public final int setSaveFilePath(String str, String str2) {
        int i = -1;
        if (b) {
            String.format("RemoteDownloader.setSaveFilePath() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("RemoteDownloader.setSaveFilePath() path:%s file:%s", new Object[]{str, str2});
        }
        try {
            if (this.d != null) {
                i = this.d.a(str, str2);
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.setSaveFilePath() catch RemoteException!", new Object[0]);
            }
        }
        return i;
    }

    public final void setAlternativeURL(String str) {
        if (b) {
            String.format("RemoteDownloader.setAlternativeURL() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("RemoteDownloader.setAlternativeURL() alternativeURL:%s", new Object[]{str});
        }
        try {
            if (this.d != null) {
                this.d.a(str);
            }
        } catch (RemoteException e) {
            if (b) {
                String.format("RemoteDownloader.setAlternativeURL() catch RemoteException!", new Object[0]);
            }
        }
    }

    public final void onDownloadInfo(int i, long j) {
        if (b) {
            String.format("RemoteDownloader.onDownloadInfo(%d %d) %s", new Object[]{Integer.valueOf(i), Long.valueOf(j), a.getTruncateUrl(getUrl())});
        }
        super.onDownloadInfo(i, j);
    }

    public final void onStateToggle(int i, int i2) {
        if (b) {
            String.format("RemoteDownloader.onStateToggle(%d %d) %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), a.getTruncateUrl(this._url)});
        }
        super.onStateToggle(i, i2);
    }

    public final void onFileAttribute(int i, String str) {
        if (b) {
            String.format("RemoteDownloader.onFileAttribute(%d, %s) %s", new Object[]{Integer.valueOf(i), str, a.getTruncateUrl(this._url)});
        }
        super.onFileAttribute(i, str);
    }

    public final void onPlayableRanges(int[] iArr, int[] iArr2) {
        if (b) {
            String.format("RemoteDownloader.onPlayableRanges() %s", new Object[]{a.getTruncateUrl(this._url)});
            int i = 0;
            while (i < iArr.length && i < iArr2.length) {
                String.format("RemoteDownloader.onPlayableRanges(%d, %d)", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])});
                i++;
            }
        }
        super.onPlayableRanges(iArr, iArr2);
    }

    public final void onSwitchDownloadMode(int i) {
        if (b) {
            String.format("RemoteDownloader.onSwitchDownloadMode(%d)", new Object[]{Integer.valueOf(i)});
        }
        super.onSwitchDownloadMode(i);
    }

    public final void a(ParcelableObject parcelableObject) {
        super.onStatistics((HashMap) parcelableObject.a);
    }
}
