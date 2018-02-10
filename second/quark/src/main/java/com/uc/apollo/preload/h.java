package com.uc.apollo.preload;

import com.uc.apollo.media.base.Statistic;
import java.util.HashMap;

/* compiled from: ProGuard */
final class h implements StatisticUploadListener {
    h() {
    }

    public final boolean onUpload(HashMap<String, String> hashMap) {
        Statistic.onStatisticUpdate(4, hashMap);
        return true;
    }
}
