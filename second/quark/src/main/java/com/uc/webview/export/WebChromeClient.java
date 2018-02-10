package com.uc.webview.export;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import com.uc.webview.export.GeolocationPermissions.Callback;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class WebChromeClient {

    @Api
    /* compiled from: ProGuard */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    @Api
    /* compiled from: ProGuard */
    public abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();

        public static Uri[] parseResult(int i, Intent intent) {
            int i2 = 0;
            if (i == 0 || i != -1) {
                return null;
            }
            Uri[] uriArr;
            if (intent.getData() == null) {
                if (VERSION.SDK_INT >= 18) {
                    ClipData clipData = intent.getClipData();
                    if (clipData != null) {
                        Uri[] uriArr2 = new Uri[clipData.getItemCount()];
                        while (i2 < clipData.getItemCount()) {
                            uriArr2[i2] = clipData.getItemAt(i2).getUri();
                            i2++;
                        }
                        uriArr = uriArr2;
                    }
                }
                uriArr = null;
            } else {
                uriArr = new Uri[]{intent.getData()};
            }
            return uriArr;
        }
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public void onHideCustomView() {
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        valueCallback.onReceiveValue(null);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }
}
