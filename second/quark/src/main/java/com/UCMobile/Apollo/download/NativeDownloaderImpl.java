package com.UCMobile.Apollo.download;

import android.content.Context;
import com.UCMobile.Apollo.annotations.Keep;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class NativeDownloaderImpl extends a {
    private static boolean a = false;
    private static String b = "ApolloMediaDownloader";
    private long c;

    private native long nativeCreateNativeDownloaderImpl(String str, String[] strArr, String[] strArr2);

    private native int nativeDeleteFile(long j);

    private native void nativeDestroyNativeDownloaderImpl(long j);

    public static native String nativeGetGlobalOption(String str);

    private native String nativeGetOption(long j, String str);

    private native int nativePause(long j);

    private native int nativeReset(long j);

    private native void nativeSetAlternativeURL(long j, String str);

    public static native int nativeSetGlobalOption(String str, String str2);

    private native int nativeSetOption(long j, String str, String str2);

    private native int nativeSetSaveFilePath(long j, String str, String str2);

    private native int nativeStart(long j);

    private native int nativeStop(long j);

    public NativeDownloaderImpl(Context context, String str, Map<String, String> map) {
        super(context, str, map);
        if (a) {
            String.format("%d NativeDownloaderImpl.NativeDownloaderImpl()", new Object[]{Integer.valueOf(hashCode())});
        }
    }

    protected void finalize() {
        if (this.c != 0) {
            nativeDestroyNativeDownloaderImpl(this.c);
        }
        try {
            super.finalize();
        } catch (Throwable th) {
        }
    }

    private void a() {
        if (this.c == 0) {
            this.c = nativeCreateNativeDownloaderImpl(this._url, this._headerKeys, this._headerValues);
        }
    }

    public int start() {
        if (a) {
            String.format("%d NativeDownloaderImpl.start()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeStart(this.c);
    }

    public int reset() {
        if (a) {
            String.format("%d NativeDownloaderImpl.reset()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeReset(this.c);
    }

    public int pause() {
        if (a) {
            String.format("%d NativeDownloaderImpl.pause()", new Object[]{Integer.valueOf(hashCode())});
        }
        if (this.c == 0) {
            return 0;
        }
        return nativePause(this.c);
    }

    public int stop() {
        if (a) {
            String.format("%d NativeDownloaderImpl.stop()", new Object[]{Integer.valueOf(hashCode())});
        }
        if (this.c != 0) {
            nativeStop(this.c);
            release();
        }
        return 0;
    }

    protected void release() {
        if (this.c != 0) {
            nativeDestroyNativeDownloaderImpl(this.c);
            this.c = 0;
        }
    }

    public int deleteFile() {
        if (a) {
            String.format("%d NativeDownloaderImpl.deleteFile()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeDeleteFile(this.c);
    }

    public int setSaveFilePath(String str, String str2) {
        if (a) {
            String.format("%d NativeDownloaderImpl.setSaveFilePath()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeSetSaveFilePath(this.c, str, str2);
    }

    public void setAlternativeURL(String str) {
        if (a) {
            String.format("%d NativeDownloaderImpl.setAlternativeURL()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        nativeSetAlternativeURL(this.c, str);
    }

    public int setOption(String str, String str2) {
        if (a) {
            String.format("%d NativeDownloaderImpl.setOption()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeSetOption(this.c, str, str2);
    }

    public String getOption(String str) {
        if (a) {
            String.format("%d NativeDownloaderImpl.getOption()", new Object[]{Integer.valueOf(hashCode())});
        }
        a();
        return nativeGetOption(this.c, str);
    }

    @Keep
    public void onPlayableRanges(int[] iArr, int[] iArr2) {
        super.onPlayableRanges(iArr, iArr2);
    }

    @Keep
    public void onDownloadInfo(int i, long j) {
        super.onDownloadInfo(i, j);
    }

    @Keep
    public void onStateToggle(int i, int i2) {
        if (a) {
            String.format("%d NativeDownloaderImpl.onStateToggle(%d) _nativeDownloader:%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Long.valueOf(this.c)});
        }
        super.onStateToggle(i, i2);
    }

    @Keep
    public void onFileAttribute(int i, String str) {
        super.onFileAttribute(i, str);
    }

    @Keep
    public void onStatistics(HashMap<String, String> hashMap) {
        super.onStatistics(hashMap);
    }

    @Keep
    public void onSwitchDownloadMode(int i) {
        super.onSwitchDownloadMode(i);
    }
}
