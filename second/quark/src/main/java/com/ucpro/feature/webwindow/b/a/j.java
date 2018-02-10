package com.ucpro.feature.webwindow.b.a;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class j implements ValueCallback<Bundle> {
    final /* synthetic */ e a;

    j(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("succeed");
        String string = bundle.getString("saved_file_name");
        new StringBuilder("saveCurrentPicture: ").append(String.valueOf(z));
        if (z) {
            e.a().a(String.format(a.d((int) R.string.pic_viewer_download_current_success_toast), new Object[]{string}), 1);
        }
    }
}
