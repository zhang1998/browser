package com.ucpro.services.location;

import android.location.LocationListener;
import android.os.Message;
import com.uc.webview.export.extension.ILocationManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class f implements ILocationManager {
    public final void requestLocationUpdates(String str, long j, float f, LocationListener locationListener) {
        g gVar = new g(locationListener);
        j a = j.a();
        Message obtain = Message.obtain();
        obtain.what = 0;
        Map hashMap = new HashMap();
        hashMap.put("listener", gVar);
        hashMap.put("isOffset", Boolean.valueOf(true));
        obtain.obj = hashMap;
        a.a(obtain);
    }

    public final void requestLocationUpdatesWithUrl(String str, long j, float f, LocationListener locationListener, String str2) {
        g gVar = new g(locationListener);
        j a = j.a();
        Message obtain = Message.obtain();
        obtain.what = 1;
        Map hashMap = new HashMap();
        hashMap.put("listener", gVar);
        j.b(str2);
        hashMap.put("isOffset", Boolean.valueOf(true));
        obtain.obj = hashMap;
        a.a(obtain);
    }

    public final void removeUpdates(LocationListener locationListener) {
        j a = j.a();
        g gVar = new g(locationListener);
        Message obtain = Message.obtain();
        obtain.what = 2;
        Map hashMap = new HashMap();
        hashMap.put("listener", gVar);
        obtain.obj = hashMap;
        a.a(obtain);
    }
}
