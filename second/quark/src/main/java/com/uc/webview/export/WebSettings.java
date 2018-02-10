package com.uc.webview.export;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.ReflectionUtil;

@Api
/* compiled from: ProGuard */
public abstract class WebSettings {
    public static final int COOKIE_TYPE_SYSTEM = 1;
    public static final int COOKIE_TYPE_UC = 2;
    public static final int COOKIE_TYPE_UC_ENCRYPT = 3;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final int MENU_ITEM_NONE = 0;
    public static final int MENU_ITEM_PROCESS_TEXT = 4;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;
    private String a = "";
    public android.webkit.WebSettings mSettings = null;

    @Api
    /* compiled from: ProGuard */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    @Api
    /* compiled from: ProGuard */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    @Api
    /* compiled from: ProGuard */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    @Api
    /* compiled from: ProGuard */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        public int value;

        private TextSize(int i) {
            this.value = i;
        }
    }

    @Api
    /* compiled from: ProGuard */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int a;

        private ZoomDensity(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    @Deprecated
    public void setNavDump(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setNavDump", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public boolean getNavDump() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getNavDump");
        return bool == null ? false : bool.booleanValue();
    }

    public void setSupportZoom(boolean z) {
        this.mSettings.setSupportZoom(z);
    }

    public boolean supportZoom() {
        return this.mSettings.supportZoom();
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getMediaPlaybackRequiresUserGesture");
        return bool == null ? false : bool.booleanValue();
    }

    public void setBuiltInZoomControls(boolean z) {
        this.mSettings.setBuiltInZoomControls(z);
    }

    public boolean getBuiltInZoomControls() {
        return this.mSettings.getBuiltInZoomControls();
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        if (VERSION.SDK_INT >= 11) {
            this.mSettings.setDisplayZoomControls(z);
        }
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        if (VERSION.SDK_INT >= 11) {
            return this.mSettings.getDisplayZoomControls();
        }
        return false;
    }

    public void setAllowFileAccess(boolean z) {
        this.mSettings.setAllowFileAccess(z);
    }

    public boolean getAllowFileAccess() {
        return this.mSettings.getAllowFileAccess();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        if (VERSION.SDK_INT >= 11) {
            this.mSettings.setAllowContentAccess(z);
        }
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        return VERSION.SDK_INT >= 11 && this.mSettings.getAllowContentAccess();
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.mSettings.setLoadWithOverviewMode(z);
    }

    public boolean getLoadWithOverviewMode() {
        return this.mSettings.getLoadWithOverviewMode();
    }

    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "enableSmoothTransition");
        return bool == null ? false : bool.booleanValue();
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getUseWebViewBackgroundForOverscrollBackground");
        return bool == null ? false : bool.booleanValue();
    }

    public void setSaveFormData(boolean z) {
        this.mSettings.setSaveFormData(z);
    }

    public boolean getSaveFormData() {
        return this.mSettings.getSaveFormData();
    }

    @Deprecated
    public void setSavePassword(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setSavePassword", new Class[]{Boolean.class}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public boolean getSavePassword() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getSavePassword");
        return bool == null ? false : bool.booleanValue();
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        if (VERSION.SDK_INT >= 14) {
            this.mSettings.setTextZoom(i);
        }
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int textZoom;
        if (VERSION.SDK_INT >= 14) {
            textZoom = this.mSettings.getTextZoom();
        } else {
            textZoom = 0;
        }
        return textZoom;
    }

    public synchronized void setTextSize(TextSize textSize) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setTextSize", new Class[]{android.webkit.WebSettings.TextSize.class}, new Object[]{android.webkit.WebSettings.TextSize.valueOf(textSize.name())});
    }

    public synchronized TextSize getTextSize() {
        android.webkit.WebSettings.TextSize textSize;
        textSize = (android.webkit.WebSettings.TextSize) ReflectionUtil.invokeNoThrow(this.mSettings, "getTextSize");
        return textSize == null ? null : TextSize.valueOf(textSize.name());
    }

    @Deprecated
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setDefaultZoom", new Class[]{android.webkit.WebSettings.ZoomDensity.class}, new Object[]{android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name())});
    }

    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings.ZoomDensity zoomDensity = (android.webkit.WebSettings.ZoomDensity) ReflectionUtil.invokeNoThrow(this.mSettings, "getDefaultZoom");
        return zoomDensity == null ? null : ZoomDensity.valueOf(zoomDensity.name());
    }

    @Deprecated
    public void setLightTouchEnabled(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setLightTouchEnabled", new Class[]{Boolean.class}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public boolean getLightTouchEnabled() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getLightTouchEnabled");
        return bool == null ? false : bool.booleanValue();
    }

    @Deprecated
    public synchronized void setUseDoubleTree(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setUseDoubleTree", new Class[]{Boolean.class}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        Boolean bool;
        bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getUseDoubleTree");
        return bool == null ? false : bool.booleanValue();
    }

    @Deprecated
    public synchronized void setUserAgent(int i) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setUserAgent", new Class[]{Integer.class}, new Object[]{Integer.valueOf(i)});
    }

    @Deprecated
    public synchronized int getUserAgent() {
        Integer num;
        num = (Integer) ReflectionUtil.invokeNoThrow(this.mSettings, "getUserAgent");
        return num == null ? 0 : num.intValue();
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.mSettings.setUseWideViewPort(z);
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mSettings.getUseWideViewPort();
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.mSettings.setSupportMultipleWindows(z);
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mSettings.supportMultipleWindows();
    }

    public synchronized void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.mSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        return LayoutAlgorithm.valueOf(this.mSettings.getLayoutAlgorithm().name());
    }

    public synchronized void setStandardFontFamily(String str) {
        this.mSettings.setStandardFontFamily(str);
    }

    public synchronized String getStandardFontFamily() {
        return this.mSettings.getStandardFontFamily();
    }

    public synchronized void setFixedFontFamily(String str) {
        this.mSettings.setFixedFontFamily(str);
    }

    public synchronized String getFixedFontFamily() {
        return this.mSettings.getFixedFontFamily();
    }

    public synchronized void setSansSerifFontFamily(String str) {
        this.mSettings.setSansSerifFontFamily(str);
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mSettings.getSansSerifFontFamily();
    }

    public synchronized void setSerifFontFamily(String str) {
        this.mSettings.setSerifFontFamily(str);
    }

    public synchronized String getSerifFontFamily() {
        return this.mSettings.getSerifFontFamily();
    }

    public synchronized void setCursiveFontFamily(String str) {
        this.mSettings.setCursiveFontFamily(str);
    }

    public synchronized String getCursiveFontFamily() {
        return this.mSettings.getCursiveFontFamily();
    }

    public synchronized void setFantasyFontFamily(String str) {
        this.mSettings.setFantasyFontFamily(str);
    }

    public synchronized String getFantasyFontFamily() {
        return this.mSettings.getFantasyFontFamily();
    }

    public synchronized void setMinimumFontSize(int i) {
        this.mSettings.setMinimumFontSize(i);
    }

    public synchronized int getMinimumFontSize() {
        return this.mSettings.getMinimumFontSize();
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        this.mSettings.setMinimumLogicalFontSize(i);
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mSettings.getMinimumLogicalFontSize();
    }

    public synchronized void setDefaultFontSize(int i) {
        this.mSettings.setDefaultFontSize(i);
    }

    public synchronized int getDefaultFontSize() {
        return this.mSettings.getDefaultFontSize();
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        this.mSettings.setDefaultFixedFontSize(i);
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mSettings.getDefaultFixedFontSize();
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        this.mSettings.setLoadsImagesAutomatically(z);
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mSettings.getLoadsImagesAutomatically();
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        this.mSettings.setBlockNetworkImage(z);
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mSettings.getBlockNetworkImage();
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        this.mSettings.setBlockNetworkLoads(z);
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mSettings.getBlockNetworkLoads();
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        this.mSettings.setJavaScriptEnabled(z);
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public synchronized void setPluginsEnabled(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setPluginsEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setPluginState", new Class[]{android.webkit.WebSettings.PluginState.class}, new Object[]{android.webkit.WebSettings.PluginState.valueOf(pluginState.name())});
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setPluginsPath", new Class[]{String.class}, new Object[]{str});
    }

    public synchronized void setDatabasePath(String str) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setDatabasePath", new Class[]{String.class}, new Object[]{str});
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.mSettings.setGeolocationDatabasePath(str);
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.mSettings.setAppCacheEnabled(z);
    }

    public synchronized void setAppCachePath(String str) {
        this.mSettings.setAppCachePath(str);
    }

    @Deprecated
    public synchronized void setAppCacheMaxSize(long j) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setAppCacheMaxSize", new Class[]{Long.class}, new Object[]{Long.valueOf(j)});
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.mSettings.setDatabaseEnabled(z);
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.mSettings.setDomStorageEnabled(z);
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mSettings.getDomStorageEnabled();
    }

    public synchronized String getDatabasePath() {
        String str;
        str = (String) ReflectionUtil.invokeNoThrow(this.mSettings, "getDatabasePath");
        if (str == null) {
            str = null;
        }
        return str;
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mSettings.getDatabaseEnabled();
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        this.mSettings.setGeolocationEnabled(z);
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mSettings.getJavaScriptEnabled();
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getAllowUniversalAccessFromFileURLs");
        return bool == null ? false : bool.booleanValue();
    }

    public boolean getAllowFileAccessFromFileURLs() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getAllowFileAccessFromFileURLs");
        return bool == null ? false : bool.booleanValue();
    }

    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean z = false;
        synchronized (this) {
            if (VERSION.SDK_INT <= 17) {
                Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getPluginsEnabled");
                if (bool != null) {
                    z = bool.booleanValue();
                }
            } else {
                boolean z2;
                if (VERSION.SDK_INT == 18) {
                    if (android.webkit.WebSettings.PluginState.ON == this.mSettings.getPluginState()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                z = z2;
            }
        }
        return z;
    }

    @Deprecated
    public synchronized PluginState getPluginState() {
        android.webkit.WebSettings.PluginState pluginState;
        pluginState = (android.webkit.WebSettings.PluginState) ReflectionUtil.invokeNoThrow(this.mSettings, "getPluginState");
        return pluginState == null ? null : PluginState.valueOf(pluginState.name());
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String str;
        str = (String) ReflectionUtil.invokeNoThrow(this.mSettings, "getPluginsPath");
        if (str == null) {
            str = null;
        }
        return str;
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.mSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        this.mSettings.setDefaultTextEncodingName(str);
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mSettings.getDefaultTextEncodingName();
    }

    public synchronized void setUserAgentString(String str) {
        this.mSettings.setUserAgentString(str);
    }

    public synchronized String getUserAgentString() {
        return this.mSettings.getUserAgentString();
    }

    public static String getDefaultUserAgent(Context context) {
        return (String) SDKFactory.invoke(10056, new Object[0]);
    }

    public void setNeedInitialFocus(boolean z) {
        this.mSettings.setNeedInitialFocus(z);
    }

    @Deprecated
    public synchronized void setRenderPriority(RenderPriority renderPriority) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setRenderPriority", new Class[]{android.webkit.WebSettings.RenderPriority.class}, new Object[]{android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name())});
    }

    public void setCacheMode(int i) {
        this.mSettings.setCacheMode(i);
    }

    public int getCacheMode() {
        return this.mSettings.getCacheMode();
    }

    public synchronized void setPreCacheScope(String str) {
        this.a = str;
    }

    public synchronized String getPreCacheScope() {
        return this.a;
    }

    public void setMixedContentMode(int i) {
        if (VERSION.SDK_INT >= 21) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setMixedContentMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        }
    }

    public int getMixedContentMode() {
        if (VERSION.SDK_INT < 21) {
            return 0;
        }
        Integer num = (Integer) ReflectionUtil.invokeNoThrow(this.mSettings, "getMixedContentMode");
        return num == null ? 0 : num.intValue();
    }

    @TargetApi(23)
    public void setOffscreenPreRaster(boolean z) {
        if (VERSION.SDK_INT >= 23) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setOffscreenPreRaster", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @TargetApi(23)
    public boolean getOffscreenPreRaster() {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getOffscreenPreRaster");
        return bool == null ? false : bool.booleanValue();
    }

    @TargetApi(24)
    public void setDisabledActionModeMenuItems(int i) {
        if (VERSION.SDK_INT >= 24) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setDisabledActionModeMenuItems", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        }
    }

    @TargetApi(24)
    public int getDisabledActionModeMenuItems() {
        if (VERSION.SDK_INT < 24) {
            return 0;
        }
        Integer num = (Integer) ReflectionUtil.invokeNoThrow(this.mSettings, "getDisabledActionModeMenuItems");
        return num == null ? 0 : num.intValue();
    }
}
