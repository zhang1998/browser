package com.uc.apollo.preload;

import com.UCMobile.Apollo.MediaPreload;
import java.util.Map;

/* compiled from: ProGuard */
public final class c {
    public static void a(String str, String str2, Map<String, String> map, a aVar) {
        MediaPreload.Add(str, str2, map, new e(aVar));
    }

    public static void a(b bVar) {
        MediaPreload.SetStatisticUploadListener(new g(bVar));
    }
}
