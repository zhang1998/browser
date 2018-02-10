package com.ucpro.feature.downloadpage.e;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import java.util.List;

/* compiled from: ProGuard */
final class p implements ValueCallback {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void onReceiveValue(Object obj) {
        if (obj instanceof List) {
            this.a.u = (List) obj;
            if (this.a.u.size() == 0) {
                if (!this.a.q.b()) {
                    this.a.q.a("lottie/download_empty/data.json", "lottie/download_empty/images", "lottie/download_empty/images_night");
                    this.a.q.setText(a.d((int) R.string.empty_error_anim_page_download_empty));
                }
                this.a.q.setVisibility(0);
            } else {
                this.a.q.setVisibility(8);
            }
            if (this.a.v) {
                this.a.m.a(this.a.u);
                this.a.m.a.a();
                this.a.q();
            }
        }
    }
}
