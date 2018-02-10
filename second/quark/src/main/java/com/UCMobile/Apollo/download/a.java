package com.UCMobile.Apollo.download;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public abstract class a implements d {
    public static boolean LOGCAT = false;
    private static boolean a = true;
    private static String b = "ApolloMediaDownloader";
    protected Context _context;
    protected d _externallistener = null;
    protected String[] _headerKeys;
    protected String[] _headerValues;
    protected String _url;

    public abstract int deleteFile();

    public abstract int pause();

    protected abstract void release();

    public abstract int reset();

    public abstract void setAlternativeURL(String str);

    public abstract int setSaveFilePath(String str, String str2);

    public abstract int start();

    public abstract int stop();

    public void setExternalDownloadListener(d dVar) {
        this._externallistener = dVar;
    }

    public a(Context context, String str, Map<String, String> map) {
        int i = 0;
        if (a) {
            String.format("BaseDownloader.BaseDownloader() url:%s", new Object[]{str});
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    String.format("BaseDownloader.BaseDownloader() keys:%s, value:%s", new Object[]{str2, str3});
                }
            }
        }
        if (map != null) {
            this._headerKeys = new String[map.size()];
            this._headerValues = new String[map.size()];
            for (Entry entry2 : map.entrySet()) {
                this._headerKeys[i] = (String) entry2.getKey();
                this._headerValues[i] = (String) entry2.getValue();
                i++;
            }
        }
        this._context = context;
        this._url = str;
    }

    public String getUrl() {
        return this._url;
    }

    public boolean compare(String str) {
        if (str.equals(this._url)) {
            return true;
        }
        return false;
    }

    public int setOption(String str, String str2) {
        return -1;
    }

    public String getOption(String str) {
        return "";
    }

    public void onDownloadInfo(int i, long j) {
        if (a) {
            String.format("BaseDownloader.onDownloadInfo(%d %d)", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        }
        if (this._externallistener != null) {
            this._externallistener.onDownloadInfo(i, j);
        }
    }

    public void onStateToggle(int i, int i2) {
        if (a) {
            String.format("BaseDownloader.onStateToggle(%d %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (this._externallistener != null) {
            this._externallistener.onStateToggle(i, i2);
        }
    }

    public void onFileAttribute(int i, String str) {
        if (a) {
            String.format("BaseDownloader.onFileAttribute(%d, %s)", new Object[]{Integer.valueOf(i), str});
        }
        if (this._externallistener != null) {
            this._externallistener.onFileAttribute(i, str);
        }
    }

    public void onPlayableRanges(int[] iArr, int[] iArr2) {
        if (a) {
            int i = 0;
            while (i < iArr.length && i < iArr2.length) {
                String.format("BaseDownloader.onPlayableRanges(%d, %d)", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])});
                i++;
            }
        }
        if (this._externallistener != null) {
            this._externallistener.onPlayableRanges(iArr, iArr2);
        }
    }

    public void onStatistics(HashMap<String, String> hashMap) {
        if (a) {
            String.format("BaseDownloader.onStatistics()  %d", new Object[]{Integer.valueOf(hashMap.size())});
        }
        if (this._externallistener != null) {
            this._externallistener.onStatistics(hashMap);
        }
    }

    public void onSwitchDownloadMode(int i) {
        if (a) {
            String.format("BaseDownloader.onSwitchDownloadMode(%d)", new Object[]{Integer.valueOf(i)});
        }
        if (this._externallistener != null) {
            this._externallistener.onSwitchDownloadMode(i);
        }
    }

    public static String getTruncateUrl(String str) {
        return (str == null || str.length() <= 86) ? str : str.substring(0, 40) + "......" + str.substring(str.length() - 40);
    }

    public static int setGlobalOption(String str, String str2) {
        try {
            return NativeDownloaderImpl.nativeSetGlobalOption(str, str2);
        } catch (UnsatisfiedLinkError e) {
            return -1;
        }
    }

    public static String getGlobalOption(String str) {
        try {
            return NativeDownloaderImpl.nativeGetGlobalOption(str);
        } catch (UnsatisfiedLinkError e) {
            return null;
        }
    }
}
