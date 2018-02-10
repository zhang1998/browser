package com.UCMobile.Apollo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.UCMobile.Apollo.annotations.Keep;
import com.UCMobile.Apollo.download.b;
import com.UCMobile.Apollo.download.d;
import com.UCMobile.Apollo.download.e;
import com.UCMobile.Apollo.download.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Keep
/* compiled from: ProGuard */
public class MediaDownloader {
    private static boolean DEBUG = com.UCMobile.Apollo.download.a.LOGCAT;
    public static final int DLINFO_AVGSPEED = 104;
    public static final int DLINFO_CURRENTSIZE = 102;
    public static final int DLINFO_HTTPSEEK = 105;
    public static final int DLINFO_MOVERESULT = 107;
    public static final int DLINFO_PLAY_WHEN_DOWNLOAD = 106;
    public static final int DLINFO_PROGRESS = 101;
    public static final int DLINFO_SPEED = 100;
    public static final int DLINFO_TOTALSIZE = 103;
    public static final int DOWNLOADMODE_ONLY_DOWNLOAD = 1000;
    public static final int DOWNLOADMODE_PLAYING_DOWNLOAD = 1001;
    public static final int DOWNLOADSTATE_DOWNLOAD_COMPLETE = 5;
    public static final int DOWNLOADSTATE_ERROR = 3;
    public static final int DOWNLOADSTATE_FFMPEGCLOSE = 9;
    public static final int DOWNLOADSTATE_FFMPEGOPEN = 8;
    public static final int DOWNLOADSTATE_INIT = 0;
    public static final int DOWNLOADSTATE_PAUSED = 2;
    public static final int DOWNLOADSTATE_SAVE_COMPLETE = 7;
    public static final int DOWNLOADSTATE_STARTED = 1;
    public static final int DOWNLOADSTATE_STOPPED = 4;
    private static final int EVENT_ON_DOWNLOAD_INFO = 0;
    private static final int EVENT_ON_FILEATTRIBUTE = 2;
    private static final int EVENT_ON_PLAYABLERANGES = 3;
    private static final int EVENT_ON_STATETOGGLE = 1;
    private static final int EVENT_ON_STATISTICS = 4;
    private static final int EVENT_ON_SWITCH_MODE = 10;
    public static final int FILEATTRIBUTE_MEDIA_TYPE = 202;
    public static final int FILEATTRIBUTE_SAVE_TIME = 201;
    private static String LOGTAG = "ApolloMediaDownloader";
    private static final int NETWORK_NO_CONNECTION = -1;
    private static final String NETWORK_SUBTYPE = "rw.global.connectivity_network_subtype";
    private static final String NETWORK_TYPE = "rw.global.connectivity_network_type";
    private d _IDownloaderListener;
    private IMediaDownloadListener _IMediaDownloadListener;
    private com.UCMobile.Apollo.download.a _baseMediaDownloader = null;
    private Context _context = null;
    private int _downloadMode = 1000;
    private int _downloadState = 0;
    private a _eventHandler;
    private Map<Integer, String> _fileAttributes = null;
    private Map<String, String> _headers = null;
    private int _previousSpeed;
    private int _progress;
    private String _url = null;
    private boolean _userStarted = false;
    private boolean _userStopped = false;
    private IVideoStatistic _videoStatistic;
    private ConnectivityManager connectivityManager;
    private NetworkInfo info;
    private BroadcastReceiver mReceiver = new BroadcastReceiver(this) {
        final /* synthetic */ MediaDownloader a;

        {
            this.a = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    MediaDownloader.setGlobalOption(MediaDownloader.NETWORK_TYPE, "-1");
                    return;
                }
                this.a.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                this.a.info = this.a.connectivityManager.getActiveNetworkInfo();
                if (this.a.info != null) {
                    MediaDownloader.setGlobalOption(MediaDownloader.NETWORK_TYPE, String.valueOf(this.a.info.getType()));
                    MediaDownloader.setGlobalOption(MediaDownloader.NETWORK_SUBTYPE, String.valueOf(this.a.info.getSubtype()));
                }
            }
        }
    };
    Context mcontext = null;

    @Keep
    /* compiled from: ProGuard */
    public interface IMediaDownloadListener {
        void onDownloadInfo(int i, long j);

        void onFileAttribute(int i, String str);

        void onPlayableRanges(int[] iArr, int[] iArr2);

        void onStateToggle(int i, int i2);
    }

    /* compiled from: ProGuard */
    final class a extends Handler {
        final /* synthetic */ MediaDownloader a;

        public a(MediaDownloader mediaDownloader, Looper looper) {
            this.a = mediaDownloader;
            super(looper);
        }

        @SuppressLint({"UseSparseArrays"})
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    long parseLong = Long.parseLong(String.valueOf(message.obj));
                    if (this.a._IMediaDownloadListener != null) {
                        this.a._IMediaDownloadListener.onDownloadInfo(message.arg1, parseLong);
                    }
                    if (message.arg1 == 100) {
                        this.a._previousSpeed = (int) parseLong;
                        return;
                    } else if (message.arg1 == 101) {
                        this.a._progress = (int) parseLong;
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.a._downloadState = message.arg1;
                    if (this.a._IMediaDownloadListener != null) {
                        if (MediaDownloader.DEBUG) {
                            MediaDownloader.LOGTAG;
                            String.format("MediaDownloader.IMediaDownloadListener().onStateToggle(%d,%d)", new Object[]{Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
                        }
                        this.a._IMediaDownloadListener.onStateToggle(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 2:
                    if (this.a._IMediaDownloadListener != null) {
                        this.a._IMediaDownloadListener.onFileAttribute(message.arg1, (String) message.obj);
                    }
                    if (this.a._fileAttributes == null) {
                        this.a._fileAttributes = new HashMap();
                    }
                    this.a._fileAttributes.put(Integer.valueOf(message.arg1), (String) message.obj);
                    return;
                case 3:
                    if (this.a._IMediaDownloadListener != null) {
                        this.a._IMediaDownloadListener.onPlayableRanges(message.getData().getIntArray("starts"), message.getData().getIntArray("ends"));
                        return;
                    }
                    return;
                case 4:
                    if (MediaDownloader.DEBUG) {
                        MediaDownloader.LOGTAG;
                        String.format("MediaDownloader.EventHandler.handleMessage()  MediaDownloader.EVENT_ON_STATISTICS", new Object[0]);
                    }
                    HashMap hashMap = (HashMap) message.obj;
                    if (this.a._videoStatistic != null) {
                        this.a._videoStatistic.upload(hashMap);
                        return;
                    }
                    return;
                case 10:
                    this.a.setDownloadMode(message.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    public static MediaDownloader create(Context context, String str, Map<String, String> map) {
        if (MediaPlayer.globalInitialization(context) && isSupportDownload()) {
            return new MediaDownloader(context, str, map);
        }
        return null;
    }

    private MediaDownloader(Context context, String str, Map<String, String> map) {
        if (DEBUG) {
            String.format("MediaDownloader.MediaDownloader()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(str)});
        }
        this._context = context;
        this._url = str;
        this._headers = map;
        this._headers = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!(entry.getValue() == null || entry.getKey() == null)) {
                    this._headers.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this._eventHandler = new a(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this._eventHandler = new a(this, myLooper);
            } else {
                this._eventHandler = null;
            }
        }
        NetworkInfo activeNetworkInfo = MediaPlayer.getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            setGlobalOption(NETWORK_TYPE, String.valueOf(activeNetworkInfo.getType()));
            setGlobalOption(NETWORK_SUBTYPE, String.valueOf(activeNetworkInfo.getSubtype()));
        } else {
            setGlobalOption(NETWORK_TYPE, "-1");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mcontext = context;
        context.registerReceiver(this.mReceiver, intentFilter);
        this._baseMediaDownloader = b.a().a(context, str, this._headers);
        if (this._baseMediaDownloader != null) {
            this._IDownloaderListener = new d(this) {
                final /* synthetic */ MediaDownloader a;

                {
                    this.a = r1;
                }

                public final void onDownloadInfo(int i, long j) {
                    if (!this.a._userStopped) {
                        Message obtainMessage = this.a._eventHandler.obtainMessage(0, Long.valueOf(j));
                        obtainMessage.arg1 = i;
                        this.a._eventHandler.sendMessage(obtainMessage);
                    }
                }

                public final void onStateToggle(int i, int i2) {
                    if (!this.a._userStopped) {
                        this.a._eventHandler.sendMessage(this.a._eventHandler.obtainMessage(1, i, i2));
                    }
                }

                public final void onFileAttribute(int i, String str) {
                    if (!this.a._userStopped) {
                        this.a._eventHandler.sendMessage(this.a._eventHandler.obtainMessage(2, i, 0, str));
                    }
                }

                public final void onPlayableRanges(int[] iArr, int[] iArr2) {
                    if (!this.a._userStopped) {
                        Message obtainMessage = this.a._eventHandler.obtainMessage(3);
                        Bundle bundle = new Bundle();
                        bundle.putIntArray("starts", iArr);
                        bundle.putIntArray("ends", iArr2);
                        obtainMessage.setData(bundle);
                        this.a._eventHandler.sendMessage(obtainMessage);
                    }
                }

                public final void onStatistics(HashMap<String, String> hashMap) {
                    if (MediaDownloader.DEBUG) {
                        MediaDownloader.LOGTAG;
                        String.format("MediaDownloader.IDownloaderListener.onStatistics()", new Object[0]);
                    }
                    Message obtainMessage = this.a._eventHandler.obtainMessage(4);
                    obtainMessage.obj = hashMap;
                    this.a._eventHandler.sendMessage(obtainMessage);
                }

                public final void onSwitchDownloadMode(int i) {
                    if (MediaDownloader.DEBUG) {
                        MediaDownloader.LOGTAG;
                        String.format("MediaDownloader.IDownloaderListener.onSwitchDownloadMode(%d)", new Object[]{Integer.valueOf(i)});
                    }
                    this.a._eventHandler.sendMessage(this.a._eventHandler.obtainMessage(10, i, 0));
                }
            };
            this._baseMediaDownloader.setExternalDownloadListener(this._IDownloaderListener);
        }
        if (this._baseMediaDownloader != null && (this._baseMediaDownloader instanceof e)) {
            this._downloadMode = 1000;
        } else if (this._baseMediaDownloader != null && (this._baseMediaDownloader instanceof g)) {
            this._downloadMode = 1001;
        }
    }

    public boolean start() {
        if (DEBUG) {
            String.format("MediaDownloader.start()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(this._url)});
        }
        this._userStarted = true;
        if (this._baseMediaDownloader == null) {
            return false;
        }
        if (this._baseMediaDownloader.start() == 0) {
            return true;
        }
        return false;
    }

    public boolean reset() {
        if (DEBUG) {
            String.format("MediaDownloader.reset()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(this._url)});
        }
        if (this._baseMediaDownloader == null) {
            return false;
        }
        if (this._baseMediaDownloader.reset() == 0) {
            return true;
        }
        return false;
    }

    public boolean pause() {
        if (DEBUG) {
            String.format("MediaDownloader.pause()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(this._url)});
        }
        if (this._baseMediaDownloader == null) {
            return false;
        }
        if (this._baseMediaDownloader.pause() == 0) {
            return true;
        }
        return false;
    }

    public boolean stop() {
        if (DEBUG) {
            String.format("MediaDownloader.stop()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(this._url)});
        }
        if (this._userStopped) {
            return false;
        }
        this._userStopped = true;
        boolean z = this._baseMediaDownloader != null ? this._baseMediaDownloader.stop() == 0 : false;
        this._eventHandler.sendMessage(this._eventHandler.obtainMessage(1, 4, 0));
        if (this.mcontext != null) {
            this.mcontext.unregisterReceiver(this.mReceiver);
            this.mcontext = null;
        }
        return z;
    }

    public boolean deleteFile() {
        if (DEBUG) {
            String.format("MediaDownloader.deleteFile()  %s", new Object[]{com.UCMobile.Apollo.download.a.getTruncateUrl(this._url)});
        }
        if (this._baseMediaDownloader == null) {
            return false;
        }
        if (this._baseMediaDownloader.deleteFile() == 0) {
            return true;
        }
        return false;
    }

    public boolean setSaveFilePath(String str, String str2) {
        if (DEBUG) {
            String.format("MediaDownloader.setSaveFilePath()  %s,%s", new Object[]{str, str2});
        }
        if (this._baseMediaDownloader == null) {
            return false;
        }
        if (this._baseMediaDownloader.setSaveFilePath(str, str2) == 0) {
            return true;
        }
        return false;
    }

    public void setDownloadMode(int i) {
        com.UCMobile.Apollo.download.a aVar = null;
        if (DEBUG) {
            String.format("MediaDownloader.setDownloadMode() old:%d new:%d, state:%d", new Object[]{Integer.valueOf(this._downloadMode), Integer.valueOf(i), Integer.valueOf(this._downloadState)});
        }
        if (this._downloadMode != i) {
            this._downloadMode = i;
            if (this._baseMediaDownloader != null) {
                this._baseMediaDownloader.setExternalDownloadListener(null);
                this._baseMediaDownloader.stop();
                this._baseMediaDownloader = null;
            }
            b a = b.a();
            Context context = this._context;
            String str = this._url;
            Map map = this._headers;
            int i2 = this._downloadMode;
            if (b.a) {
                String.format("DownloaderManager.createDownloaderByDownloadMode() downLoadMode:%d, url:%s", new Object[]{Integer.valueOf(i2), com.UCMobile.Apollo.download.a.getTruncateUrl(str)});
            }
            if (1000 == i2) {
                aVar = new e(context, str, map);
            } else if (1001 == i2) {
                aVar = a.a(context, str, map);
            }
            this._baseMediaDownloader = aVar;
            if (this._downloadState == 1) {
                this._baseMediaDownloader.start();
            } else if (this._userStarted && this._downloadState == 0) {
                this._baseMediaDownloader.setExternalDownloadListener(this._IDownloaderListener);
                this._baseMediaDownloader.start();
                return;
            }
            this._baseMediaDownloader.setExternalDownloadListener(this._IDownloaderListener);
        }
    }

    public int getDownloadMode() {
        return this._downloadMode;
    }

    public int getDownloadState() {
        return this._downloadState;
    }

    public String getDownloadUrl() {
        return this._url;
    }

    public Map<String, String> getDownloadRequestHeaders() {
        return this._headers;
    }

    public int getPreviousDownloadSpeed() {
        return this._previousSpeed;
    }

    public int getDownloadProgress() {
        return this._progress;
    }

    public Map<Integer, String> getDownloadFileAttributes() {
        return this._fileAttributes;
    }

    protected void finalize() {
        if (this._baseMediaDownloader != null && (this._downloadState == 1 || this._downloadState == 1)) {
            this._baseMediaDownloader.stop();
        }
        if (DEBUG) {
            new StringBuilder().append(hashCode()).append(" MediaDownloader.finalize()");
        }
        try {
            super.finalize();
        } catch (Throwable th) {
        }
    }

    public void setDownloadListener(IMediaDownloadListener iMediaDownloadListener) {
        this._IMediaDownloadListener = iMediaDownloadListener;
    }

    public void setStatisticHelper(IVideoStatistic iVideoStatistic) {
        this._videoStatistic = iVideoStatistic;
    }

    private static int verToNum(String str) {
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return 0;
        }
        return (((Integer.parseInt(split[0]) & 7) << 28) | ((Integer.parseInt(split[1]) & 1023) << 18)) | (Integer.parseInt(split[2]) & 262143);
    }

    public static boolean isSupportDownload() {
        if (verToNum(MediaPlayer.getVersionString()) >= verToNum("2.9.5")) {
            return true;
        }
        return false;
    }

    public static int setGlobalOption(Context context, String str, String str2) {
        if (!MediaPlayer.isInitSuccess()) {
            MediaPlayer.globalInitialization(context);
        }
        return setGlobalOption(str, str2);
    }

    public static int setGlobalOption(String str, String str2) {
        try {
            return com.UCMobile.Apollo.download.a.setGlobalOption(str, str2);
        } catch (UnsatisfiedLinkError e) {
            return -1;
        }
    }

    public static String getGlobalOption(Context context, String str) {
        if (!MediaPlayer.isInitSuccess()) {
            MediaPlayer.globalInitialization(context);
        }
        return getGlobalOption(str);
    }

    public static String getGlobalOption(String str) {
        try {
            return com.UCMobile.Apollo.download.a.getGlobalOption(str);
        } catch (UnsatisfiedLinkError e) {
            return null;
        }
    }

    public void setAlternativeURL(String str) {
        if (this._baseMediaDownloader != null) {
            try {
                this._baseMediaDownloader.setAlternativeURL(str);
            } catch (UnsatisfiedLinkError e) {
            }
        }
    }

    public int setOption(String str, String str2) {
        int i = -1;
        if (this._baseMediaDownloader != null) {
            try {
                i = this._baseMediaDownloader.setOption(str, str2);
            } catch (UnsatisfiedLinkError e) {
            }
        }
        return i;
    }

    public String getOption(String str) {
        String str2 = null;
        if (this._baseMediaDownloader != null) {
            try {
                str2 = this._baseMediaDownloader.getOption(str);
            } catch (UnsatisfiedLinkError e) {
            }
        }
        return str2;
    }
}
