package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import java.util.Map;

@Interface
/* compiled from: ProGuard */
public interface BrowserMobileWebKit extends UCMobileWebKit {
    public static final int ALL_RESOURCES_CHANGED = 31;
    public static final int BITMAP_RESOURCES_CHANGED = 2;
    public static final int COLOR_RESOURCES_CHANGED = 8;
    public static final int DOWNLOAD_TYPE_TTF = 100;
    public static final int DRAWABLE_RESOURCES_CHANGED = 4;
    public static final int RESOURCE_ID_RESOURCES_CHANGED = 16;
    public static final int TEXT_RESOURCES_CHANGED = 1;
    public static final int THEME_RESOURCES_CHANGED = 6;

    void addPreConnection(String str, int i);

    @Deprecated
    void extraLog(String str);

    Map<String, String> getCoreInfo(Map<String, String> map);

    IWebResources getWebResources();

    @Deprecated
    boolean installAmusePlugin(String str);

    @Deprecated
    void onResourcesChanged(int i);

    @Deprecated
    void reportMemory(String str, int i);

    @Deprecated
    void resetRenderThreadPriority();

    @Deprecated
    void setCollectListener(ICollectListener iCollectListener);

    void setFontListener(IFontListener iFontListener);

    @Deprecated
    void setMemoryManagerListener(IMemoryManagerListener iMemoryManagerListener, IMemoryManagerListener iMemoryManagerListener2);

    void setNetworkStateListener(INetworkStateListener iNetworkStateListener);

    void setPermissionManager(IPermissionManagerInterface iPermissionManagerInterface);

    void setProxyInfoGenerator(IProxyInfoGenerator iProxyInfoGenerator);

    void setStatisticListener(IStatisticListener iStatisticListener);

    void setWebCoreThreadCreateListener(IWebCoreThreadCallback iWebCoreThreadCallback);

    void setWebResourcesListener(IWebResourcesListener iWebResourcesListener);

    void setWindowLauncherDelegate(IWindowLauncherDelegate iWindowLauncherDelegate);

    void updateWallpaperBitmap();
}
