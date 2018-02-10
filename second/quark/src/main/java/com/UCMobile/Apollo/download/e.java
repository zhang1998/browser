package com.UCMobile.Apollo.download;

import android.content.Context;
import java.util.Map;

/* compiled from: ProGuard */
public final class e extends a {
    private static boolean a = a.LOGCAT;
    private static String b = "ApolloMediaDownloader";
    private NativeDownloaderImpl c;

    public e(Context context, String str, Map<String, String> map) {
        super(context, str, map);
        this.c = new NativeDownloaderImpl(context, str, map);
        this.c.setExternalDownloadListener(this);
        if (a) {
            String.format("LocalDownloader.LocalDownloader() url:%s", new Object[]{a.getTruncateUrl(str)});
        }
        b a = b.a();
        if (b.a) {
            String.format("DownloaderManager.registerLocalDownloader() url:%s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        synchronized (a) {
            a.b.add(this);
        }
    }

    public final int stop() {
        if (a) {
            String.format("LocalDownloader.stop()", new Object[0]);
        }
        b a = b.a();
        if (b.a) {
            String.format("DownloaderManager.unregisterLocalDownloader() url:%s", new Object[]{a.getTruncateUrl(getUrl())});
        }
        synchronized (a) {
            a.b.remove(this);
        }
        return this.c.stop();
    }

    public final int start() {
        if (a) {
            String.format("LocalDownloader.start() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        return this.c.start();
    }

    public final int reset() {
        if (a) {
            String.format("LocalDownloader.reset() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        return this.c.reset();
    }

    public final int pause() {
        if (a) {
            String.format("LocalDownloader.pause() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        return this.c.pause();
    }

    public final int deleteFile() {
        if (a) {
            String.format("LocalDownloader.deleteFile() url:%s", new Object[]{a.getTruncateUrl(this._url)});
        }
        return this.c.deleteFile();
    }

    public final int setSaveFilePath(String str, String str2) {
        if (a) {
            String.format("LocalDownloader.setSaveFilePath() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("LocalDownloader.setSaveFilePath() path:%s file:%s", new Object[]{str, str2});
        }
        return this.c.setSaveFilePath(str, str2);
    }

    public final void setAlternativeURL(String str) {
        if (a) {
            String.format("LocalDownloader.setAlternativeURL() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("LocalDownloader.setAlternativeURL() alternativeURL:%s", new Object[]{str});
        }
        this.c.setAlternativeURL(str);
    }

    public final int setOption(String str, String str2) {
        if (a) {
            String.format("LocalDownloader.setOption() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("LocalDownloader.setOption() key:%s value:%s", new Object[]{str, str2});
        }
        return this.c.setOption(str, str2);
    }

    public final String getOption(String str) {
        if (a) {
            String.format("LocalDownloader.getOption() url:%s", new Object[]{a.getTruncateUrl(this._url)});
            String.format("LocalDownloader.getOption() key:%s", new Object[]{str});
        }
        return this.c.getOption(str);
    }

    protected final void release() {
    }

    public final void onDownloadInfo(int i, long j) {
        if (a) {
            String.format("LocalDownloader.onDownloadInfo(%d %d) %s", new Object[]{Integer.valueOf(i), Long.valueOf(j), a.getTruncateUrl(this._url)});
        }
        super.onDownloadInfo(i, j);
    }

    public final void onStateToggle(int i, int i2) {
        if (a) {
            String.format("LocalDownloader.onStateToggle(%d %d) %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), a.getTruncateUrl(this._url)});
        }
        super.onStateToggle(i, i2);
    }

    public final void onFileAttribute(int i, String str) {
        if (a) {
            String.format("LocalDownloader.onFileAttribute(%d, %s) %s", new Object[]{Integer.valueOf(i), str, a.getTruncateUrl(this._url)});
        }
        super.onFileAttribute(i, str);
    }

    public final void onPlayableRanges(int[] iArr, int[] iArr2) {
        if (a) {
            String.format("LocalDownloader.onPlayableRanges() %s", new Object[]{a.getTruncateUrl(this._url)});
            int i = 0;
            while (i < iArr.length && i < iArr2.length) {
                String.format("LocalDownloader.onPlayableRanges(%d, %d)", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])});
                i++;
            }
        }
        super.onPlayableRanges(iArr, iArr2);
    }

    public final void onSwitchDownloadMode(int i) {
        if (a) {
            String.format("LocalDownloader.onSwitchDownloadMode(%d) %s", new Object[]{Integer.valueOf(i), a.getTruncateUrl(this._url)});
        }
        super.onSwitchDownloadMode(i);
    }
}
