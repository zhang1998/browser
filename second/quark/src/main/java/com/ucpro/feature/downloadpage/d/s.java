package com.ucpro.feature.downloadpage.d;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.feature.video.d.a;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
final class s implements ValueCallback {
    final /* synthetic */ l a;

    s(l lVar) {
        this.a = lVar;
    }

    public final void onReceiveValue(Object obj) {
        if (obj instanceof List) {
            obj = (List) obj;
            a.a();
            if (obj == null || obj.size() == 0) {
                if (!this.a.l.b()) {
                    this.a.l.a("lottie/download_empty/data.json", "lottie/download_empty/images", "lottie/download_empty/images_night");
                    this.a.l.setText(com.ucpro.ui.c.a.d((int) R.string.empty_error_anim_page_cache_empty));
                }
                this.a.l.setVisibility(0);
            } else {
                this.a.l.setVisibility(8);
            }
            if (this.a.g != null) {
                t c = this.a.g;
                c.a(obj);
                c.d = obj;
                a.a();
                this.a.g.a.a();
                return;
            }
            a.a();
        }
    }
}
