package com.ucpro.services.location;

import android.location.Location;
import android.location.LocationListener;

/* compiled from: ProGuard */
public final class g implements e {
    private LocationListener a;

    public g(LocationListener locationListener) {
        this.a = locationListener;
    }

    public final void a(UcLocation ucLocation) {
        this.a.onLocationChanged(new Location(ucLocation));
    }

    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((g) obj).a);
    }
}
