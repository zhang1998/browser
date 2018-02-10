package com.uc.weex.wxbridge;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebChromeClient;

/* compiled from: ProGuard */
final class h extends WebChromeClient {
    final /* synthetic */ WebViewJSEngine a;

    h(WebViewJSEngine webViewJSEngine) {
        this.a = webViewJSEngine;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (MessageLevel.ERROR == consoleMessage.messageLevel() && !consoleMessage.message().startsWith("[Vue warn")) {
            Log.e("WeexWebViewEngine", "message: " + consoleMessage.message());
            this.a.reportException(consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
