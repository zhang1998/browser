package com.ucpro.feature.video;

import android.support.annotation.NonNull;
import com.quark.browser.R;
import com.ucpro.feature.video.c.a;
import com.ucpro.ui.b.e;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class j implements a {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    public final void a(String str, @NonNull ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            this.a.h.put(str, arrayList.get(0));
            this.a.a(str, (String) arrayList.get(0));
            if (this.a.a != null) {
                com.ucpro.feature.video.g.a.a(this.a.a.b(), str, (String) arrayList.get(0));
            }
        }
    }

    public final void a(String str, com.ucpro.feature.video.c.d.a aVar) {
        e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_switch_quliaty_but_play_fail), 0);
        if (this.a.a != null) {
            com.ucpro.feature.video.g.a.c(this.a.a.b(), str, aVar.p);
        }
    }
}
