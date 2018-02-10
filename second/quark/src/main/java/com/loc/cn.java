package com.loc;

import android.content.Context;
import android.os.HandlerThread;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class cn {
    Context a;
    int b = 9;
    ArrayList<ck> c = new ArrayList();
    int d = -113;
    TelephonyManager e = null;
    Object f;
    JSONObject g;
    PhoneStateListener h;
    volatile CellLocation i;
    HandlerThread j = null;
    boolean k = false;
    Object l = new Object();
    volatile boolean m = false;
    PhoneStateListener n = null;
    private long o = 0;

    public cn(Context context, JSONObject jSONObject) {
        this.g = jSONObject;
        this.a = context;
        if (this.e == null) {
            this.e = (TelephonyManager) dm.a(this.a, "phone");
        }
    }

    private static CellLocation a(List<?> list) {
        int i;
        Throwable th;
        CellLocation cellLocation;
        if (list == null || list.isEmpty()) {
            return null;
        }
        CellLocation cellLocation2;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        CellLocation cellLocation3 = null;
        int i2 = 0;
        int i3 = 0;
        CellLocation cellLocation4 = null;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (obj != null) {
                try {
                    Object cast;
                    Class loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    if (loadClass.isInstance(obj)) {
                        i = 1;
                        try {
                            cast = loadClass.cast(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            cellLocation = cellLocation3;
                            i3 = i;
                            cq.a(th, "CgiManager", "getCgi");
                            i2++;
                            cellLocation3 = cellLocation;
                        }
                    } else if (loadClass2.isInstance(obj)) {
                        i = 2;
                        cast = loadClass2.cast(obj);
                    } else if (loadClass3.isInstance(obj)) {
                        i = 3;
                        cast = loadClass3.cast(obj);
                    } else if (loadClass4.isInstance(obj)) {
                        i = 4;
                        cast = loadClass4.cast(obj);
                    } else {
                        i = 0;
                        cast = null;
                    }
                    if (i > 0) {
                        Object a = dg.a(cast, "getCellIdentity", new Object[0]);
                        if (a != null) {
                            if (i != 4) {
                                int b;
                                if (i != 3) {
                                    i3 = dg.b(a, "getLac", new Object[0]);
                                    b = dg.b(a, "getCid", new Object[0]);
                                    cellLocation = new GsmCellLocation();
                                    cellLocation.setLacAndCid(i3, b);
                                    cellLocation2 = cellLocation4;
                                    cellLocation4 = cellLocation;
                                    break;
                                }
                                i3 = dg.b(a, "getTac", new Object[0]);
                                b = dg.b(a, "getCi", new Object[0]);
                                cellLocation = new GsmCellLocation();
                                try {
                                    cellLocation.setLacAndCid(i3, b);
                                    cellLocation2 = cellLocation4;
                                    cellLocation4 = cellLocation;
                                    break;
                                } catch (Throwable th22) {
                                    th = th22;
                                    i3 = i;
                                }
                            } else {
                                cellLocation2 = new CdmaCellLocation();
                                try {
                                    cellLocation2.setCellLocationData(dg.b(a, "getBasestationId", new Object[0]), dg.b(a, "getLatitude", new Object[0]), dg.b(a, "getLongitude", new Object[0]), dg.b(a, "getSystemId", new Object[0]), dg.b(a, "getNetworkId", new Object[0]));
                                    cellLocation4 = cellLocation3;
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cellLocation = cellLocation3;
                                    cellLocation4 = cellLocation2;
                                    i3 = i;
                                }
                            }
                        } else {
                            i3 = i;
                            cellLocation = cellLocation3;
                        }
                    } else {
                        i3 = i;
                        cellLocation = cellLocation3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cellLocation = cellLocation3;
                    cq.a(th, "CgiManager", "getCgi");
                    i2++;
                    cellLocation3 = cellLocation;
                }
            } else {
                cellLocation = cellLocation3;
            }
            i2++;
            cellLocation3 = cellLocation;
        }
        i = i3;
        cellLocation2 = cellLocation4;
        cellLocation4 = cellLocation3;
        return i != 4 ? cellLocation4 : cellLocation2;
    }

    private ck a(NeighboringCellInfo neighboringCellInfo) {
        if (dm.c() < 5) {
            return null;
        }
        try {
            ck ckVar = new ck(1);
            String[] a = dm.a(this.e);
            ckVar.a = a[0];
            ckVar.b = a[1];
            ckVar.c = dg.b(neighboringCellInfo, "getLac", new Object[0]);
            ckVar.d = neighboringCellInfo.getCid();
            ckVar.j = dm.a(neighboringCellInfo.getRssi());
            return ckVar;
        } catch (Throwable th) {
            cq.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void a(CellLocation cellLocation, boolean z) {
        if (cellLocation != null && this.e != null) {
            this.c.clear();
            if (a(cellLocation)) {
                this.b = 1;
                ArrayList arrayList = this.c;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                ck ckVar = new ck(1);
                String[] a = dm.a(this.e);
                ckVar.a = a[0];
                ckVar.b = a[1];
                ckVar.c = gsmCellLocation.getLac();
                ckVar.d = gsmCellLocation.getCid();
                ckVar.j = this.d;
                arrayList.add(ckVar);
                if (!z) {
                    List<NeighboringCellInfo> neighboringCellInfo = this.e.getNeighboringCellInfo();
                    if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                        for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                            if (neighboringCellInfo2 != null && a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid())) {
                                ck a2 = a(neighboringCellInfo2);
                                if (!(a2 == null || this.c.contains(a2))) {
                                    this.c.add(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    static int e() {
        int i = 0;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Throwable th) {
        }
        if (i != 0) {
            return i;
        }
        try {
            Class.forName("android.telephony.TelephonyManager2");
            return 2;
        } catch (Throwable th2) {
            return i;
        }
    }

    private CellLocation f() {
        CellLocation cellLocation = null;
        TelephonyManager telephonyManager = this.e;
        if (telephonyManager == null) {
            return cellLocation;
        }
        CellLocation cellLocation2;
        try {
            cellLocation2 = telephonyManager.getCellLocation();
        } catch (Throwable th) {
            cellLocation2 = cellLocation;
        }
        if (a(cellLocation2)) {
            return cellLocation2;
        }
        try {
            cellLocation2 = a((List) dg.a(telephonyManager, "getAllCellInfo", new Object[0]));
        } catch (Throwable th2) {
        }
        if (a(cellLocation2)) {
            return cellLocation2;
        }
        try {
            Object a = dg.a(telephonyManager, "getCellLocationExt", Integer.valueOf(1));
            cellLocation2 = a != null ? (CellLocation) a : cellLocation2;
        } catch (Throwable th3) {
        }
        if (a(cellLocation2)) {
            return cellLocation2;
        }
        try {
            a = dg.a(telephonyManager, "getCellLocationGemini", Integer.valueOf(1));
            if (a != null) {
                cellLocation = (CellLocation) a;
                return a(cellLocation) ? cellLocation : cellLocation;
            }
        } catch (Throwable th4) {
        }
        cellLocation = cellLocation2;
        if (a(cellLocation)) {
        }
    }

    private CellLocation g() {
        Object obj = this.f;
        if (obj == null) {
            return null;
        }
        CellLocation cellLocation;
        Object a;
        try {
            Class h = h();
            if (h.isInstance(obj)) {
                List list;
                Object cast = h.cast(obj);
                String str = "getCellLocation";
                a = dg.a(cast, str, new Object[0]);
                if (a == null) {
                    try {
                        a = dg.a(cast, str, Integer.valueOf(1));
                    } catch (Throwable th) {
                        cq.a(th, "CgiManager", "getSim2Cgi14");
                    }
                }
                if (a == null) {
                    try {
                        obj = dg.a(cast, "getCellLocationGemini", Integer.valueOf(1));
                    } catch (Throwable th2) {
                        cq.a(th2, "CgiManager", "getSim2Cgi13");
                    }
                    if (obj == null) {
                        try {
                            list = (List) dg.a(cast, "getAllCellInfo", new Object[0]);
                        } catch (Throwable th22) {
                            cq.a(th22, "CgiManager", "getSim2Cgi1");
                            list = null;
                        }
                        obj = a(list);
                    }
                }
                obj = a;
                if (obj == null) {
                    list = (List) dg.a(cast, "getAllCellInfo", new Object[0]);
                    obj = a(list);
                }
            } else {
                obj = null;
            }
        } catch (Throwable th222) {
            cq.a(th222, "CgiManager", "getSim2Cgi");
        }
        if (obj != null) {
            cellLocation = (CellLocation) obj;
            return cellLocation;
        }
        cellLocation = null;
        return cellLocation;
    }

    private static Class<?> h() {
        String str;
        Class<?> cls = null;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (e()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = cls;
                break;
        }
        try {
            cls = systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            cq.a(th, "CgiManager", "getSim2TmClass");
        }
        return cls;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized android.telephony.CellLocation a(boolean r7, boolean r8) {
        /*
        r6 = this;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 1;
        r2 = 0;
        monitor-enter(r6);
        r6.m = r7;	 Catch:{ all -> 0x0045 }
        r0 = r6.m;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0026;
    L_0x000c:
        r0 = r6.e;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0026;
    L_0x0010:
        r0 = r6.f();	 Catch:{ all -> 0x0045 }
        r3 = r6.a(r0);	 Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x001e;
    L_0x001a:
        r0 = r6.g();	 Catch:{ all -> 0x0045 }
    L_0x001e:
        r3 = r6.a(r0);	 Catch:{ all -> 0x0045 }
        if (r3 == 0) goto L_0x0026;
    L_0x0024:
        r6.i = r0;	 Catch:{ all -> 0x0045 }
    L_0x0026:
        r0 = r6.i;	 Catch:{ all -> 0x0045 }
        r0 = r6.a(r0);	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0031;
    L_0x002e:
        r0 = 0;
    L_0x002f:
        monitor-exit(r6);
        return r0;
    L_0x0031:
        r0 = r6.m;	 Catch:{ all -> 0x0045 }
        r3 = r6.i;	 Catch:{ all -> 0x0045 }
        r0 = com.loc.dm.a(r0, r3);	 Catch:{ all -> 0x0045 }
        switch(r0) {
            case 1: goto L_0x003f;
            case 2: goto L_0x0048;
            default: goto L_0x003c;
        };	 Catch:{ all -> 0x0045 }
    L_0x003c:
        r0 = r6.i;	 Catch:{ all -> 0x0045 }
        goto L_0x002f;
    L_0x003f:
        r0 = r6.i;	 Catch:{ all -> 0x0045 }
        r6.a(r0, r8);	 Catch:{ all -> 0x0045 }
        goto L_0x003c;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0048:
        r3 = r6.i;	 Catch:{ all -> 0x0045 }
        if (r3 == 0) goto L_0x003c;
    L_0x004c:
        r0 = r6.c;	 Catch:{ all -> 0x0045 }
        r0.clear();	 Catch:{ all -> 0x0045 }
        r0 = com.loc.dm.c();	 Catch:{ all -> 0x0045 }
        r4 = 5;
        if (r0 < r4) goto L_0x003c;
    L_0x0058:
        r0 = r6.f;	 Catch:{ Throwable -> 0x010d }
        if (r0 == 0) goto L_0x0084;
    L_0x005c:
        r0 = r3.getClass();	 Catch:{ Throwable -> 0x0117 }
        r4 = "mGsmCellLoc";
        r0 = r0.getDeclaredField(r4);	 Catch:{ Throwable -> 0x0117 }
        r4 = r0.isAccessible();	 Catch:{ Throwable -> 0x0117 }
        if (r4 != 0) goto L_0x0070;
    L_0x006c:
        r4 = 1;
        r0.setAccessible(r4);	 Catch:{ Throwable -> 0x0117 }
    L_0x0070:
        r0 = r0.get(r3);	 Catch:{ Throwable -> 0x0117 }
        r0 = (android.telephony.gsm.GsmCellLocation) r0;	 Catch:{ Throwable -> 0x0117 }
        if (r0 == 0) goto L_0x0118;
    L_0x0078:
        r4 = r6.a(r0);	 Catch:{ Throwable -> 0x0117 }
        if (r4 == 0) goto L_0x0118;
    L_0x007e:
        r6.a(r0, r8);	 Catch:{ Throwable -> 0x0117 }
        r0 = r1;
    L_0x0082:
        if (r0 != 0) goto L_0x003c;
    L_0x0084:
        r0 = r6.a(r3);	 Catch:{ Throwable -> 0x010d }
        if (r0 == 0) goto L_0x003c;
    L_0x008a:
        r0 = 2;
        r6.b = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = r6.e;	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dm.a(r0);	 Catch:{ Throwable -> 0x010d }
        r1 = new com.loc.ck;	 Catch:{ Throwable -> 0x010d }
        r2 = 2;
        r1.<init>(r2);	 Catch:{ Throwable -> 0x010d }
        r2 = 0;
        r2 = r0[r2];	 Catch:{ Throwable -> 0x010d }
        r1.a = r2;	 Catch:{ Throwable -> 0x010d }
        r2 = 1;
        r0 = r0[r2];	 Catch:{ Throwable -> 0x010d }
        r1.b = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = "getSystemId";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dg.b(r3, r0, r2);	 Catch:{ Throwable -> 0x010d }
        r1.g = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = "getNetworkId";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dg.b(r3, r0, r2);	 Catch:{ Throwable -> 0x010d }
        r1.h = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = "getBaseStationId";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dg.b(r3, r0, r2);	 Catch:{ Throwable -> 0x010d }
        r1.i = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = r6.d;	 Catch:{ Throwable -> 0x010d }
        r1.j = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = "getBaseStationLatitude";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dg.b(r3, r0, r2);	 Catch:{ Throwable -> 0x010d }
        r1.e = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = "getBaseStationLongitude";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x010d }
        r0 = com.loc.dg.b(r3, r0, r2);	 Catch:{ Throwable -> 0x010d }
        r1.f = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = r1.e;	 Catch:{ Throwable -> 0x010d }
        if (r0 < 0) goto L_0x00f8;
    L_0x00e2:
        r0 = r1.f;	 Catch:{ Throwable -> 0x010d }
        if (r0 < 0) goto L_0x00f8;
    L_0x00e6:
        r0 = r1.e;	 Catch:{ Throwable -> 0x010d }
        if (r0 == r5) goto L_0x00f8;
    L_0x00ea:
        r0 = r1.f;	 Catch:{ Throwable -> 0x010d }
        if (r0 == r5) goto L_0x00f8;
    L_0x00ee:
        r0 = r1.e;	 Catch:{ Throwable -> 0x010d }
        r2 = r1.f;	 Catch:{ Throwable -> 0x010d }
        if (r0 != r2) goto L_0x00fe;
    L_0x00f4:
        r0 = r1.e;	 Catch:{ Throwable -> 0x010d }
        if (r0 <= 0) goto L_0x00fe;
    L_0x00f8:
        r0 = 0;
        r1.e = r0;	 Catch:{ Throwable -> 0x010d }
        r0 = 0;
        r1.f = r0;	 Catch:{ Throwable -> 0x010d }
    L_0x00fe:
        r0 = r6.c;	 Catch:{ Throwable -> 0x010d }
        r0 = r0.contains(r1);	 Catch:{ Throwable -> 0x010d }
        if (r0 != 0) goto L_0x003c;
    L_0x0106:
        r0 = r6.c;	 Catch:{ Throwable -> 0x010d }
        r0.add(r1);	 Catch:{ Throwable -> 0x010d }
        goto L_0x003c;
    L_0x010d:
        r0 = move-exception;
        r1 = "CgiManager";
        r2 = "hdlCdmaLocChange";
        com.loc.cq.a(r0, r1, r2);	 Catch:{ all -> 0x0045 }
        goto L_0x003c;
    L_0x0117:
        r0 = move-exception;
    L_0x0118:
        r0 = r2;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cn.a(boolean, boolean):android.telephony.CellLocation");
    }

    public final ck a() {
        ArrayList arrayList = this.c;
        return arrayList.size() > 0 ? (ck) arrayList.get(0) : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.telephony.CellLocation r5) {
        /*
        r4 = this;
        r1 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r1;
    L_0x0004:
        r0 = 1;
        r2 = r4.m;
        r2 = com.loc.dm.a(r2, r5);
        switch(r2) {
            case 1: goto L_0x0016;
            case 2: goto L_0x0030;
            default: goto L_0x000e;
        };
    L_0x000e:
        r1 = r0;
    L_0x000f:
        if (r1 != 0) goto L_0x0003;
    L_0x0011:
        r0 = 9;
        r4.b = r0;
        goto L_0x0003;
    L_0x0016:
        r5 = (android.telephony.gsm.GsmCellLocation) r5;	 Catch:{ Throwable -> 0x0026 }
        r1 = r5.getLac();	 Catch:{ Throwable -> 0x0026 }
        r2 = r5.getCid();	 Catch:{ Throwable -> 0x0026 }
        r0 = a(r1, r2);	 Catch:{ Throwable -> 0x0026 }
        r1 = r0;
        goto L_0x000f;
    L_0x0026:
        r1 = move-exception;
        r2 = "CgiManager";
        r3 = "cgiUseful Cgi.iGsmT";
        com.loc.cq.a(r1, r2, r3);
        r1 = r0;
        goto L_0x000f;
    L_0x0030:
        r2 = "getSystemId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0054 }
        r2 = com.loc.dg.b(r5, r2, r3);	 Catch:{ Throwable -> 0x0054 }
        if (r2 <= 0) goto L_0x0051;
    L_0x003b:
        r2 = "getNetworkId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0054 }
        r2 = com.loc.dg.b(r5, r2, r3);	 Catch:{ Throwable -> 0x0054 }
        if (r2 < 0) goto L_0x0051;
    L_0x0046:
        r2 = "getBaseStationId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0054 }
        r2 = com.loc.dg.b(r5, r2, r3);	 Catch:{ Throwable -> 0x0054 }
        if (r2 >= 0) goto L_0x0052;
    L_0x0051:
        r0 = r1;
    L_0x0052:
        r1 = r0;
        goto L_0x000f;
    L_0x0054:
        r1 = move-exception;
        r2 = "CgiManager";
        r3 = "cgiUseful Cgi.iCdmaT";
        com.loc.cq.a(r1, r2, r3);
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cn.a(android.telephony.CellLocation):boolean");
    }

    public final boolean a(boolean z) {
        return (z || this.o == 0 || dm.b() - this.o < 30000) ? false : true;
    }

    public final CellLocation b() {
        CellLocation cellLocation = null;
        if (this.e != null) {
            try {
                cellLocation = this.e.getCellLocation();
                if (a(cellLocation)) {
                    this.i = cellLocation;
                }
            } catch (Throwable th) {
                cq.a(th, "CgiManager", "getCellLocation");
            }
        }
        return cellLocation;
    }

    final void c() {
        Object obj = 1;
        JSONObject jSONObject = this.g;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("cellupdate") && jSONObject.getString("cellupdate").equals(SettingsConst.FALSE)) {
                    obj = null;
                }
            } catch (Throwable th) {
                cq.a(th, "CgiManager", "updateCgi1");
            }
        }
        if (obj != null) {
            try {
                CellLocation.requestLocationUpdate();
            } catch (Throwable th2) {
                cq.a(th2, "CgiManager", "updateCgi");
            }
            this.o = dm.b();
        }
    }

    final void d() {
        this.i = null;
        this.b = 9;
        this.c.clear();
    }

    static /* synthetic */ void a(cn cnVar, int i) {
        if (i == -113) {
            cnVar.d = -113;
            return;
        }
        cnVar.d = i;
        switch (cnVar.b) {
            case 1:
            case 2:
                if (!cnVar.c.isEmpty()) {
                    try {
                        ((ck) cnVar.c.get(0)).j = cnVar.d;
                        return;
                    } catch (Throwable th) {
                        cq.a(th, "CgiManager", "hdlCgiSigStrenChange");
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
