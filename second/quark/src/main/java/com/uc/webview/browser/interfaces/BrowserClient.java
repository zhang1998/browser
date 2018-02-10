package com.uc.webview.browser.interfaces;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import android.view.View;
import android.webkit.ValueCallback;
import com.uc.media.interfaces.IVideoView;
import com.uc.media.interfaces.IWaitMediaPlayerConfirmCallback;
import com.uc.media.interfaces.VideoViewParams;
import com.uc.webview.browser.NotificationPermissions.Callback;
import com.uc.webview.export.WebChromeClient.CustomViewCallback;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.extension.UCClient;
import com.uc.webview.export.internal.interfaces.IQuotaUpdater;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@Interface
/* compiled from: ProGuard */
public class BrowserClient extends UCClient {
    public static final int FLASH_NOT_PLAYED = -1;
    public static final int FLASH_PLAYED = 0;
    public static final int HAC_STATUS_END = 4;
    public static final int HAC_STATUS_ERROR = 3;
    public static final int HAC_STATUS_PLAY = 1;
    public static final int HAC_STATUS_PREPARE = 2;
    public static final String KEY_ANCHOR_TEXT = "anchortext";
    public static final String KEY_KEYWORDS = "keywords";
    public static final String PLUGIN_ENABLE_STATUS = "ENABLE_STATUS";
    public static final String PLUGIN_MIME_TYPE = "MIME_TYPE";
    public static final String PLUGIN_PROMPT_VERIFY = "PROMPT_VERIFY";
    public static final String PLUGIN_SIGNATURE = "SIGNATURE";
    public static final int PLUGIN_VERIFY_RESULT_OK = 0;
    public static final String PLUGIN_VERIFY_STATUS = "VERIFY_STATUS";
    public static final int READ_MODE_NOTIFICATION_CAN_SPLICE = 1;
    public static final int READ_MODE_NOTIFICATION_FIRST_SPLICE = 2;
    public static final int RI_ATTACH_FLAG_CONNECT = 1;
    public static final int RI_ATTACH_FLAG_DISCONNECT = 0;
    public static final int SAFE_TYPE_CERTIFICATE_EXPIRES = 6;
    public static final int SAFE_TYPE_CERTIFICATE_INVALID = 7;
    public static final int SAFE_TYPE_CERTIFICATE_NONE = 4;
    public static final int SAFE_TYPE_CERTIFICATE_VALID = 5;
    public static final int TIPS_ID_DO_AGAIN_TO_FORCE_USER_SCALABLE = 3;
    public static final int TIPS_ID_NOT_ZOOMABLE = 2;
    public static final int TIPS_ID_SAVED_CURRENT_ZOOM_SCALE = 1;
    public static final String UI_PARAMS_KEY_BROWSER_MODE = "browsermode";
    public static final String UI_PARAMS_KEY_FULL_SCREEN = "full-screen";
    public static final String UI_PARAMS_KEY_GESTURE = "gesture";
    public static final String UI_PARAMS_KEY_LONGPRESS_MENU = "longpressMenu";
    public static final String UI_PARAMS_KEY_SCREEN_ORIENTATION = "screen-orientation";
    public static final int UPLOAD_TYPE_ALBUM = 2;
    public static final int UPLOAD_TYPE_CAMERA = 1;
    public static final int UPLOAD_TYPE_DEFAULT = -1;
    public static final int UPLOAD_TYPE_DOODLE = 3;
    public static final int UPLOAD_TYPE_FILE = 0;
    public static final int WEBVIEW_EVENT_TYPE_BLOCK_WINDOW = 0;
    public static final int WEBVIEW_EVENT_TYPE_HIDE_SOFTKEYBOARD = 1;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_START = 4;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T0 = 5;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T1 = 6;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2 = 7;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2_PAINT = 13;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2_TRACE = 14;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T3 = 8;
    public static final int WEBVIEW_EVENT_TYPE_SHARE_VIDEO = 2;
    public static final int WEBVIEW_EVENT_TYPE_SHOW_VIDEO_GESTURE_GUIDE = 3;
    public static final int WEBVIEW_EVENT_TYPE_VIDEO_ENTER_FULLSCREEN = 101;
    public static final int WEBVIEW_EVENT_TYPE_VIDEO_EXIT_FULLSCREEN = 102;

    @Interface
    /* compiled from: ProGuard */
    public class BlockWindowMsg {
        public String host;
        public String title;
        public String url;
    }

    @Deprecated
    @Interface
    /* compiled from: ProGuard */
    public interface CustomViewCallbackEx extends CustomViewCallback {
        void doHideCustomView();
    }

    @Deprecated
    @Interface
    /* compiled from: ProGuard */
    public interface VideoFullscreenCallback extends CustomViewCallbackEx {
        void finishSwitchFullscreen();

        void prepareSwitchFullscreen();
    }

    @Deprecated
    public void handleUCFMessage(String str, String str2) {
    }

    public boolean requestListBox(WebView webView, String[] strArr, int[] iArr, int[] iArr2, ValueCallback<SparseBooleanArray> valueCallback) {
        return false;
    }

    public boolean requestListBox(WebView webView, String[] strArr, int[] iArr, int i, ValueCallback<Integer> valueCallback) {
        return false;
    }

    public void willPlayFlashVideo(WebView webView, String str, String str2, ValueCallback<Integer> valueCallback) {
    }

    public boolean handleExtProtocolMessage(int i, String str, String str2, int i2) {
        return false;
    }

    public void onHostSafeTypeNotify(WebView webView, String str, int i) {
    }

    public String onJsCommand(String str, String str2, String[] strArr) {
        return null;
    }

    @Deprecated
    public void onRemoteInspectorAttached(int i) {
    }

    @Deprecated
    public void onCheckPagePreread(WebView webView, String str, boolean z) {
    }

    @Deprecated
    public boolean onCopyToClipboard(String str) {
        return false;
    }

    public void onWillSendRequest(HashMap<String, String> hashMap) {
    }

    public void onLoadStatistics(int i, int i2, int i3, double d, int i4) {
    }

    @Deprecated
    public void onLoadInfo(String str) {
    }

    public IVideoView getVideoView(VideoViewParams videoViewParams) {
        return null;
    }

    public IVideoView getVideoView() {
        return getVideoView(null);
    }

    public Object createVideoView(int i) {
        return null;
    }

    public void onVideoDataSource(Uri uri, String str, String str2) {
    }

    public void onEnterVideoFullScreen(boolean z) {
        onEnterVideoFullScreen(z, 6);
    }

    public void onEnterVideoFullScreen(boolean z, int i) {
    }

    @Deprecated
    public void onVideoPlay() {
    }

    public void onVideoStat(int i, int i2, String str, Map<String, String> map) {
    }

    @Deprecated
    public void reportMediaTypeNotSupport() {
    }

    @Deprecated
    public void openFileChooser(WebView webView, int i, boolean z, ValueCallback<Uri> valueCallback) {
        valueCallback.onReceiveValue(null);
    }

    public void onLoadFromCachedPage(WebView webView) {
    }

    public void onPageForcedScaled() {
    }

    public void onPageCustomInfo(WebView webView, String str, String str2) {
    }

    public void onSaveFoxyServerParam(Vector<String> vector) {
    }

    public void onLoadMainResourceFrom(ResourceLocation resourceLocation, ResourceType resourceType) {
    }

    public void doUpdateSmartReaderHistory(WebView webView, String str, String str2) {
    }

    public void onSmartReaderNotification(WebView webView, int i) {
    }

    public void onPageUIControlParamsChanged(HashMap<String, String> hashMap) {
    }

    @Deprecated
    public void onReceivedMIMEType(WebView webView, String str) {
    }

    @Deprecated
    public void showToastMessage(String str) {
    }

    public boolean openColorChooser(int i, boolean z, ValueCallback<Integer> valueCallback) {
        return false;
    }

    @Deprecated
    public boolean openDateTimePicker(WebView webView, boolean z, DateType dateType, double d) {
        return false;
    }

    public void onShowCustomView(View view, int i, CustomViewCallbackEx customViewCallbackEx) {
    }

    @Deprecated
    public void doCheckPluginUpgrade(WebView webView, String str, String str2) {
    }

    public void onPluginFailed(WebView webView, int i, String str, String str2) {
    }

    @Deprecated
    public void onCreatePluginInstance(WebView webView, String str, String str2) {
    }

    @Deprecated
    public void onInvokePlugin(WebView webView, String str, String str2) {
    }

    @Deprecated
    public void doVerifyPlugin(WebView webView, boolean z, String str, Vector<String> vector, Vector<String> vector2, String str2, String str3, ValueCallback<Bundle> valueCallback) {
    }

    @Deprecated
    public void onEnablePlugin(WebView webView, String str, String str2, ValueCallback<Bundle> valueCallback) {
    }

    public void doDownloadAndInstallPlugin(WebView webView, String str, PluginDownloadNotifier pluginDownloadNotifier) {
    }

    @Deprecated
    public void onSoftKeyboardDisplayed() {
    }

    @Deprecated
    public void onFaviconChanged(String str, String str2) {
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, IQuotaUpdater iQuotaUpdater) {
        iQuotaUpdater.updateQuota(j);
    }

    @Deprecated
    public boolean shouldOverrideUpload(WebView webView, String str, String str2, HashMap<String, String> hashMap, byte[][] bArr, String[] strArr) {
        return false;
    }

    @Deprecated
    public boolean onWaitMediaPlayerConfirm(IWaitMediaPlayerConfirmCallback iWaitMediaPlayerConfirmCallback) {
        if (iWaitMediaPlayerConfirmCallback != null) {
            iWaitMediaPlayerConfirmCallback.onWaitMediaPlayerConfirmCallback(true);
        }
        return false;
    }

    public void showWebCoreTips(int i, int i2) {
    }

    @Deprecated
    public void onPostUploadProgress(WebView webView, int i, int i2, long j, long j2) {
    }

    public int getTitlebarHeight() {
        return 0;
    }

    public void onFirstWebkitDraw() {
    }

    public void onContentSizeChanged(int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public boolean isInputEnhanceEnabled() {
        return false;
    }

    public void showMediaPlayerMobileNetworkWarning(ValueCallback<Boolean> valueCallback) {
    }

    public void enquireInterruptStart(ValueCallback<Boolean> valueCallback) {
        Boolean valueOf = Boolean.valueOf(false);
        if (valueCallback != null) {
            new Handler(Looper.getMainLooper()).post(new a(valueCallback, valueOf));
        }
    }

    public void requestLittleWinPermission(ValueCallback<Boolean> valueCallback) {
    }

    public void notifyAdVideoUrl(boolean z, String str) {
    }

    public boolean playGoBackAnimationAndGoBack() {
        return false;
    }

    public boolean playGoForwardAnimationAndGoForward() {
        return false;
    }

    public void didChangeThemeColor(int i) {
    }

    public String getClipboardData() {
        return null;
    }

    public boolean shouldAdblockEnabled(String str) {
        return true;
    }

    public void didOverscroll(int i, int i2) {
    }

    public void onNotificationPermissionsShowPrompt(String str, Callback callback) {
        callback.invoke(str, false, false);
    }

    public boolean onPwaWebappShowAddToHomeScreenRequest(String str, String str2, String str3, Bitmap bitmap, Bundle bundle, boolean z, ValueCallback<Bundle> valueCallback) {
        return false;
    }
}
