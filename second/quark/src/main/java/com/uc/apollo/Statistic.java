package com.uc.apollo;

import com.uc.apollo.annotation.KeepForSdk;
import java.util.HashMap;

@KeepForSdk
/* compiled from: ProGuard */
public class Statistic {

    @KeepForSdk
    /* compiled from: ProGuard */
    public interface IVideoViewStatistic {
        boolean upload(HashMap<String, String> hashMap);
    }

    public static void setVideoStatistic(IVideoViewStatistic iVideoViewStatistic) {
        c.a().a(iVideoViewStatistic);
    }
}
