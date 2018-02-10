package com.loc;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class co {
    WifiManager a;
    JSONObject b;
    Context c;
    long d = 0;

    public co(Context context, WifiManager wifiManager, JSONObject jSONObject) {
        this.a = wifiManager;
        this.b = jSONObject;
        this.c = context;
    }

    public final List<ScanResult> a() {
        List<ScanResult> list = null;
        try {
            if (this.a != null) {
                list = this.a.getScanResults();
            }
        } catch (Throwable th) {
            cq.a(th, "WifiManagerWrapper", "getScanResults");
        }
        return list;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.net.ConnectivityManager r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = r5.a;
        if (r2 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r3 = r5.c();
        if (r3 == 0) goto L_0x0006;
    L_0x000d:
        r3 = r6.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x005c }
        r3 = com.loc.cz.a(r3);	 Catch:{ Throwable -> 0x005c }
        if (r3 != r0) goto L_0x0065;
    L_0x0017:
        r2 = r2.getConnectionInfo();	 Catch:{ Throwable -> 0x005c }
        if (r2 == 0) goto L_0x0027;
    L_0x001d:
        r3 = r2.getBSSID();	 Catch:{ Throwable -> 0x005c }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x002c;
    L_0x0027:
        r2 = r1;
    L_0x0028:
        if (r2 == 0) goto L_0x0065;
    L_0x002a:
        r1 = r0;
        goto L_0x0006;
    L_0x002c:
        r3 = r2.getSSID();	 Catch:{ Throwable -> 0x005c }
        if (r3 != 0) goto L_0x0034;
    L_0x0032:
        r2 = r1;
        goto L_0x0028;
    L_0x0034:
        r3 = r2.getBSSID();	 Catch:{ Throwable -> 0x005c }
        r4 = "00:00:00:00:00:00";
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x0042;
    L_0x0040:
        r2 = r1;
        goto L_0x0028;
    L_0x0042:
        r3 = r2.getBSSID();	 Catch:{ Throwable -> 0x005c }
        r4 = " :";
        r3 = r3.contains(r4);	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x0050;
    L_0x004e:
        r2 = r1;
        goto L_0x0028;
    L_0x0050:
        r2 = r2.getSSID();	 Catch:{ Throwable -> 0x005c }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x005c }
        if (r2 == 0) goto L_0x0067;
    L_0x005a:
        r2 = r1;
        goto L_0x0028;
    L_0x005c:
        r0 = move-exception;
        r2 = "WifiManagerWrapper";
        r3 = "wifiAccess";
        com.loc.cq.a(r0, r2, r3);
        goto L_0x0006;
    L_0x0065:
        r0 = r1;
        goto L_0x002a;
    L_0x0067:
        r2 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.co.a(android.net.ConnectivityManager):boolean");
    }

    public final boolean b() {
        try {
            return String.valueOf(dg.a(this.a, "startScanActive", new Object[0])).equals("true");
        } catch (Throwable th) {
            cq.a(th, "WifiManagerWrapper", "startScanActive");
            return false;
        }
    }

    public final boolean c() {
        boolean z = false;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                z = wifiManager.isWifiEnabled();
            } catch (Throwable th) {
                cq.a(th, "WifiManagerWrapper", "wifiEnabled1");
            }
            if (!z && dm.c() > 17) {
                try {
                    z = String.valueOf(dg.a(wifiManager, "isScanAlwaysAvailable", new Object[0])).equals("true");
                } catch (Throwable th2) {
                    cq.a(th2, "WifiManagerWrapper", "wifiEnabled");
                }
            }
        }
        return z;
    }
}
