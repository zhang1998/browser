package com.ucpro.services.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* compiled from: ProGuard */
final class a implements LocationListener {
    final /* synthetic */ k a;

    a(k kVar) {
        this.a = kVar;
    }

    public final void onLocationChanged(Location location) {
        this.a.a.removeUpdates(this);
        this.a.e.removeMessages(1);
        this.a.c.a(location);
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }
}
