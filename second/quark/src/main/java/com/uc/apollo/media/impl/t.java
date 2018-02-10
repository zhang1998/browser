package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.IVideoStatistic;
import java.util.HashMap;

/* compiled from: ProGuard */
final class t implements IVideoStatistic {
    final /* synthetic */ h a;

    t(h hVar) {
        this.a = hVar;
    }

    public final boolean upload(HashMap<String, String> hashMap) {
        if (this.a.r != null) {
            this.a.r.a(this.a.j, 4, (HashMap) hashMap);
        }
        return true;
    }
}
