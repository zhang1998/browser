package com.ucpro.feature.video;

import android.support.annotation.NonNull;
import com.quark.browser.R;
import com.ucpro.feature.video.c.a;
import com.ucpro.ui.b.e;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class s implements a {
    final /* synthetic */ f a;

    s(f fVar) {
        this.a = fVar;
    }

    public final void a(String str, @NonNull ArrayList<String> arrayList) {
        if (!arrayList.isEmpty() && this.a.a != null) {
            this.a.h.put(str, arrayList.get(0));
            this.a.a((String) arrayList.get(0), this.a.a.e(), this.a.a.b(), str);
        }
    }

    public final void a(String str, com.ucpro.feature.video.c.d.a aVar) {
        e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_switch_quliaty_but_play_fail), 0);
    }
}
