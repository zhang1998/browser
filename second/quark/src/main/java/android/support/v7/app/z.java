package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
final class z {
    static final c a = new c();
    final Context b;
    private final LocationManager c;

    z(Context context) {
        this.b = context;
        this.c = (LocationManager) context.getSystemService("location");
    }

    final Location a(String str) {
        if (this.c != null) {
            try {
                if (this.c.isProviderEnabled(str)) {
                    return this.c.getLastKnownLocation(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean a(c cVar) {
        return cVar != null && cVar.f > System.currentTimeMillis();
    }

    static void a(@NonNull Location location) {
        long j;
        c cVar = a;
        long currentTimeMillis = System.currentTimeMillis();
        if (e.a == null) {
            e.a = new e();
        }
        e eVar = e.a;
        eVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = eVar.b;
        eVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = eVar.d == 1;
        long j3 = eVar.c;
        long j4 = eVar.b;
        eVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = eVar.c;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        cVar.a = z;
        cVar.b = j2;
        cVar.c = j3;
        cVar.d = j4;
        cVar.e = j5;
        cVar.f = j;
    }
}
