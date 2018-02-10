package com.ucpro.feature.webwindow;

import android.text.TextUtils;
import com.uc.webview.export.extension.UCExtension.InjectJSProvider;
import com.ucpro.feature.webwindow.f.c;
import com.ucweb.common.util.i.f;
import java.util.List;

/* compiled from: ProGuard */
final class s implements InjectJSProvider {
    final /* synthetic */ String a;
    final /* synthetic */ y b;
    private StringBuilder c = new StringBuilder();
    private List<String> d = c.a().a(f.c(this.a), "T0");

    s(y yVar, String str) {
        this.b = yVar;
        this.a = str;
    }

    public final String getJS(int i) {
        if (!(this.d == null || this.d.isEmpty())) {
            for (String str : this.d) {
                if (!TextUtils.isEmpty(str)) {
                    this.c.append(str).append("\r\n");
                }
            }
        }
        Object stringBuilder = this.c.toString();
        if (TextUtils.isEmpty(stringBuilder)) {
            return null;
        }
        return "\r\n<script type=\"text/javascript\" charset=\"utf-8\">\r\n\r\n(function(){\r\n" + stringBuilder + "\r\n})();\r\n\r\n</script>\r\n";
    }
}
