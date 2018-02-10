package com.uc.apollo.preload;

import com.uc.apollo.preload.b.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class o extends a {
    final /* synthetic */ StatisticUploadListener a;

    o(StatisticUploadListener statisticUploadListener) {
        this.a = statisticUploadListener;
    }

    public final boolean a(Map map) {
        return this.a.onUpload((HashMap) map);
    }
}
