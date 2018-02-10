package com.uc.apollo.preload;

import com.UCMobile.Apollo.MediaPreload.IStatisticUploadListener;
import java.util.HashMap;

/* compiled from: ProGuard */
final class f implements IStatisticUploadListener {
    final /* synthetic */ StatisticUploadListener a;

    f(StatisticUploadListener statisticUploadListener) {
        this.a = statisticUploadListener;
    }

    public final boolean onUpload(HashMap<String, String> hashMap) {
        return this.a.onUpload(hashMap);
    }
}
