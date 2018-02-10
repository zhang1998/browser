package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Deprecated
@Interface
/* compiled from: ProGuard */
public interface PluginDownloadNotifier {
    public static final int PLUGIN_DOWNLOADING = 0;
    public static final int PLUGIN_DOWNLOAD_FAILED = 2;
    public static final int PLUGIN_DOWNLOAD_FINISH = 1;

    void notifyDownloadFailed(String str);

    void notifyDownloadFinished(String str);

    void notifyDownloading(String str);
}
