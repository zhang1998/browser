package com.ucpro.feature.webwindow.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.ValueCallback;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.ucpro.services.f.g;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Request.Builder;

/* compiled from: ProGuard */
public final class k {
    public static void a(@NonNull String str, @Nullable String str2, @Nullable ValueCallback<Bundle> valueCallback) {
        if (!a.a(str)) {
            m.a(new h(str, valueCallback, str2));
        }
    }

    static String a(String str) {
        Request build = new Builder().url(str).build();
        String str2 = "";
        try {
            str2 = g.a().newCall(build).execute().header("content-type", "");
        } catch (IOException e) {
        }
        return str2;
    }

    static /* synthetic */ Bundle a(boolean z, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("succeed", z);
        String str3 = BrowserExtension.BUNDLE_KEY_IMAGE_URL;
        if (str == null) {
            str = "";
        }
        bundle.putString(str3, str);
        str3 = "saved_file_name";
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString(str3, str2);
        return bundle;
    }
}
