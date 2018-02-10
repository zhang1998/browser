package com.ucpro.feature.webwindow;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebChromeClient.FileChooserParams;

/* compiled from: ProGuard */
public interface at {
    bb a(bo boVar);

    bb a(String str, boolean z, boolean z2, boolean z3, boolean z4);

    boolean a(ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams);

    ba c();
}
