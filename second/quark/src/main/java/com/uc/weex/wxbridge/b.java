package com.uc.weex.wxbridge;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.uc.webview.export.WebChromeClient;

/* compiled from: ProGuard */
final class b extends WebChromeClient {
    final /* synthetic */ UCWebViewEngine a;

    b(UCWebViewEngine uCWebViewEngine) {
        this.a = uCWebViewEngine;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (MessageLevel.ERROR == consoleMessage.messageLevel() && !consoleMessage.message().startsWith("[Vue warn")) {
            Log.e("WeexWebViewEngine", "message: " + consoleMessage.message());
            this.a.reportException(consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
