package com.uc.webview.browser.interfaces;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.browser.interfaces.PictureViewer.Listener;
import com.uc.webview.browser.interfaces.PictureViewer.ResourceFetchDelegate;
import com.uc.webview.browser.internal.interfaces.IBrowserExtension;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.extension.UCExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@Interface
/* compiled from: ProGuard */
public class BrowserExtension extends UCExtension {
    public static final String BUNDLE_KEY_BITMAP = "bitmap";
    public static final String BUNDLE_KEY_IMAGE_URL = "image_url";
    public static final String BUNDLE_KEY_SUCCEED = "succeed";
    public static final String WEB_CONTENT_CALLBACK_CONTENT = "webContent";
    public static final String WEB_CONTENT_CALLBACK_SOURCE = "htmlSource";
    public static final int WEB_VIEW_TYPE_EMBEDDED = 1;
    public static final int WEB_VIEW_TYPE_HIDDEN = 5;
    public static final int WEB_VIEW_TYPE_HOME_PAGE = 2;
    public static final int WEB_VIEW_TYPE_NORMAL = 0;
    public static final int WEB_VIEW_TYPE_POPLAYER = 6;
    public static final int WEB_VIEW_TYPE_WEB_WINDOW_PAGE = 4;
    private IBrowserExtension a;

    @Interface
    /* compiled from: ProGuard */
    public class SnapshotRequestResult {
        private boolean a;
        private boolean b;

        public boolean requestCanceled() {
            return this.a;
        }

        public void cancelRequest() {
            this.a = true;
        }

        public boolean requestSucceed() {
            return this.b;
        }

        public void setSucceed(boolean z) {
            this.b = z;
        }
    }

    @Interface
    /* compiled from: ProGuard */
    public class TextSelectionClient extends com.uc.webview.export.extension.UCExtension.TextSelectionClient {
        public boolean needCustomMenu() {
            return false;
        }

        public void showSelectionMenu(boolean z) {
        }

        public void onUpdateMenuPosition(Point point, Point point2, Rect rect, Rect rect2) {
        }
    }

    @Interface
    /* compiled from: ProGuard */
    public interface TopControlsListener {
        @Deprecated
        void coreOnContentViewCoreDestroyed(int i);

        @Deprecated
        void coreOnTopControlsOffsetChanged(float f, int i);

        void coreOnUpdateTitleBarPositionY(int i, int i2);
    }

    public BrowserExtension(IBrowserWebView iBrowserWebView) {
        super(iBrowserWebView);
        this.a = iBrowserWebView.getUCExtension();
    }

    public void setClient(BrowserClient browserClient) {
        this.a.setClient(browserClient);
    }

    public boolean isMobileType() {
        return this.a.isMobileType();
    }

    public SnapshotRequestResult requestSnapshot(int i, boolean z, boolean z2, Rect rect, Bitmap bitmap, ValueCallback<Bundle> valueCallback) {
        return this.a.requestSnapshot(i, z, z2, rect, bitmap, valueCallback);
    }

    public ImageViewer getImageViewer() {
        return this.a.getImageViewer();
    }

    public IWebBackForwardCustomData getWebBackForwardCustomData() {
        return this.a.getWebBackForwardCustomData();
    }

    @Deprecated
    public void savePageToDiskCache() {
        this.a.savePageToDiskCache();
    }

    public void savePagePicture(String str, String str2, String str3, ValueCallback<Bundle> valueCallback) {
        this.a.savePagePicture(str, str2, str3, valueCallback);
    }

    public void savePagePicture(String str, String str2, String str3, boolean z, ValueCallback<Bundle> valueCallback) {
        this.a.invoke(10, new Object[]{str, str2, str3, Boolean.valueOf(z), valueCallback});
    }

    public void startBigBang(ValueCallback<String> valueCallback) {
        this.a.invoke(14, new Object[]{valueCallback});
    }

    public void requestPictureByUrl(String str, ValueCallback<Bundle> valueCallback) {
        this.a.invoke(15, new Object[]{str, valueCallback});
    }

    public void expandSelection() {
        this.a.expandSelection();
    }

    public void selectionDone() {
        this.a.selectionDone();
    }

    public boolean shouldCaptureTouchEvent() {
        return this.a.shouldCaptureTouchEvent();
    }

    public boolean selectText() {
        return this.a.selectText();
    }

    public void selectAll() {
        this.a.selectAll();
    }

    public String getSelection() {
        return this.a.getSelection();
    }

    public int getWebViewType() {
        return this.a.getWebViewType();
    }

    public void setWebViewType(int i) {
        this.a.setWebViewType(i);
    }

    @Deprecated
    public void notifyWindowCovered() {
        this.a.notifyWindowCovered();
    }

    @Deprecated
    public void notifyWindowUncovered() {
        this.a.notifyWindowUncovered();
    }

    public void notifyEnterMultiWindowMode() {
        this.a.notifyEnterMultiWindowMode();
    }

    public void notifyExitMultiWindowMode() {
        this.a.notifyExitMultiWindowMode();
    }

    public boolean canGoPrereadPage() {
        return this.a.canGoPrereadPage();
    }

    public void updateVisitedLink(String str) {
        this.a.updateVisitedLink(str);
    }

    public void loadAndShowPicture(String str) {
        this.a.loadAndShowPicture(str);
    }

    public boolean isVisible() {
        return this.a.isVisible();
    }

    public void notifyForegroundChanged(boolean z) {
        this.a.notifyForegroundChanged(z);
    }

    public boolean handleBackKeyPressed() {
        return this.a.handleBackKeyPressed();
    }

    public void notifySettingsChanged(String str) {
        this.a.notifySettingsChanged(str);
    }

    @Deprecated
    public void notifyContextMenuExpanded(boolean z) {
        this.a.notifyContextMenuExpanded(z);
    }

    @Deprecated
    public void saveSessionCookie() {
        this.a.saveSessionCookie();
    }

    @Deprecated
    public void clearXhtmlCache(String str) {
        this.a.clearXhtmlCache(str);
    }

    public void loadRequest(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, byte[] bArr) {
        this.a.loadRequest(str, str2, map, map2, map3, bArr);
    }

    @Deprecated
    public void loadNetErrInfoPage(String str) {
        this.a.loadNetErrInfoPage(str);
    }

    @Deprecated
    public void postDataWithForm(String str, String str2, Vector<String> vector, Vector<String> vector2) {
        this.a.postDataWithForm(str, str2, vector, vector2);
    }

    @Deprecated
    public void cancelMultiTouchEventHandling() {
        this.a.cancelMultiTouchEventHandling();
    }

    public void getWebContent(ValueCallback<Bundle> valueCallback) {
        this.a.getWebContent(valueCallback);
    }

    public boolean pageDown(boolean z, boolean z2) {
        return this.a.pageDown(z, z2);
    }

    public boolean pageUp(boolean z, boolean z2) {
        return this.a.pageUp(z, z2);
    }

    public void setTopControlsStyle(int i) {
        this.a.setTopControlsStyle(i);
    }

    public void setTopControlsHeight(int i) {
        this.a.setTopControlsHeight(i);
    }

    public void forceUpdateTopControlsOffset(int i) {
        this.a.invoke(21, new Object[]{Integer.valueOf(i)});
    }

    public void setToolbarHeight(int i) {
        this.a.invoke(22, new Object[]{Integer.valueOf(i)});
    }

    public void setSmallTopControlsHeight(int i) {
        this.a.setSmallTopControlsHeight(i);
    }

    public void forceUpdateTopControlsOffset(boolean z) {
        this.a.forceUpdateTopControlsOffset(z);
    }

    public void getEditorContent(ValueCallback<String> valueCallback) {
        this.a.getEditorContent(valueCallback);
    }

    public boolean setEditorContent(String str) {
        return this.a.setEditorContent(str);
    }

    @Deprecated
    public boolean setEditorContent(double d) {
        return this.a.setEditorContent(d);
    }

    @Deprecated
    public void requestAllIcons(ValueCallback<HashMap> valueCallback) {
        this.a.requestAllIcons(valueCallback);
    }

    public BrowserSettings getUCSettings() {
        return this.a.getUCSettings();
    }

    public void paste(String str) {
        this.a.paste(str);
    }

    public void setInputEnhanceControllerHeight(int i) {
        this.a.setInputEnhanceControllerHeight(i);
    }

    @Deprecated
    public void setSnapScreenPainting(boolean z) {
        this.a.setSnapScreenPainting(z);
    }

    @Deprecated
    public void notifyBackForwardSlideStart(boolean z) {
        this.a.notifyBackForwardSlideStart(z);
    }

    @Deprecated
    public void notifyBackForwardSlideEnd() {
        this.a.notifyBackForwardSlideEnd();
    }

    public void setTextSelectionClient(TextSelectionClient textSelectionClient) {
        this.a.setTextSelectionClient(textSelectionClient);
    }

    public void setTopControlsListener(TopControlsListener topControlsListener) {
        this.a.setTopControlsListener(topControlsListener);
    }

    public void evaluateJavascriptInIsolateContext(String str, ValueCallback<String> valueCallback) {
        this.a.evaluateJavascriptInIsolateContext(str, valueCallback);
    }

    public void setPictureViewerListener(Listener listener) {
        this.a.setPictureViewerListener(listener);
    }

    public boolean openPictureViewer() {
        return this.a.openPictureViewer();
    }

    public boolean openPictureViewer(String str, ResourceFetchDelegate resourceFetchDelegate) {
        Object invoke = this.a.invoke(12, new Object[]{str, resourceFetchDelegate});
        if (invoke == null) {
            return false;
        }
        return ((Boolean) invoke).booleanValue();
    }

    public boolean closePictureViewer() {
        return this.a.closePictureViewer();
    }

    public void setHCAdAdapterClient(HCAdAdapterClient hCAdAdapterClient) {
        this.a.setHCAdAdapterClient(hCAdAdapterClient);
    }

    public Bitmap getCurrentPageFullSnapshot(Config config) {
        return this.a.getCurrentPageFullSnapshot(config);
    }

    public void removeResourcesFromCache(String[] strArr) {
        this.a.invoke(13, new Object[]{strArr});
    }

    public void loadUrl(String str, boolean z) {
        this.a.invoke(20, new Object[]{str, Boolean.valueOf(z)});
    }

    public boolean setHttpCacheMaxSize(int i) {
        Object invoke = this.a.invoke(17, new Object[]{Integer.valueOf(i)});
        if (invoke == null) {
            return false;
        }
        return ((Boolean) invoke).booleanValue();
    }

    public boolean addShortcutForWebapp(String str, ValueCallback<Bundle> valueCallback) {
        Object invoke = this.a.invoke(23, new Object[]{str, valueCallback});
        if (invoke == null) {
            return false;
        }
        return ((Boolean) invoke).booleanValue();
    }
}
