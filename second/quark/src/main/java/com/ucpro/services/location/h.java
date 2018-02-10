package com.ucpro.services.location;

import android.location.Location;
import com.amap.api.location.AMapLocation;

/* compiled from: ProGuard */
final class h implements c {
    final /* synthetic */ LocationDex a;

    h(LocationDex locationDex) {
        this.a = locationDex;
    }

    public final void a() {
        this.a.mIsLocationRequestStarted = false;
    }

    public final void a(AMapLocation aMapLocation) {
        this.a.mIsLocationRequestStarted = false;
        boolean isOffset = aMapLocation.isOffset();
        UcLocation access$300 = this.a.convertLocation(aMapLocation);
        this.a.dispatchResponse(access$300, isOffset);
        this.a.updateSystemInfo(access$300);
        this.a.sendNotification(access$300);
        this.a.doStatisticsWork();
    }

    public final void a(Location location) {
        this.a.mIsLocationRequestStarted = false;
        this.a.dispatchResponse(this.a.convertLocation(location));
    }
}
