package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.view.Window;
import android.view.Window.Callback;
import com.alibaba.wireless.security.open.SecException;
import java.util.Calendar;

/* compiled from: ProGuard */
class o extends u {
    private static z w;
    boolean g = true;
    private int x = -100;
    private boolean y;

    o(Context context, Window window, ac acVar) {
        super(context, window, acVar);
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.x == -100) {
            this.x = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback a(Callback callback) {
        return new ab(this, callback);
    }

    public final boolean i() {
        int i;
        this.y = true;
        if (this.x == -100) {
            i = AppCompatDelegate.h;
        } else {
            i = this.x;
        }
        i = f(i);
        if (i == -1) {
            return false;
        }
        Resources resources = this.i.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        i = i == 2 ? 32 : 16;
        if (i2 == i) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    int f(int i) {
        Location location = null;
        switch (i) {
            case SecException.ERROR_NULL_CONTEXT /*-100*/:
                return -1;
            case 0:
                boolean z;
                if (w == null) {
                    w = new z(this.i.getApplicationContext());
                }
                z zVar = w;
                c cVar = z.a;
                if (z.a(cVar)) {
                    z = cVar.a;
                } else {
                    Location a;
                    if (PermissionChecker.a(zVar.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        a = zVar.a("network");
                    } else {
                        a = null;
                    }
                    if (PermissionChecker.a(zVar.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location = zVar.a("gps");
                    }
                    if (location == null || a == null) {
                        if (location != null) {
                            a = location;
                        }
                    } else if (location.getTime() > a.getTime()) {
                        a = location;
                    }
                    if (a != null) {
                        z.a(a);
                        z = cVar.a;
                    } else {
                        int i2 = Calendar.getInstance().get(11);
                        z = i2 < 6 || i2 >= 22;
                    }
                }
                if (z) {
                    return 2;
                }
                return 1;
            default:
                return i;
        }
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        if (this.x != -100) {
            bundle.putInt("appcompat:local_night_mode", this.x);
        }
    }
}
