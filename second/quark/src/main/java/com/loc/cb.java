package com.loc;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class cb {
    private static int ad = -1;
    private volatile long A = 0;
    private long B = 0;
    private long C = 0;
    private volatile boolean D = false;
    private boolean E = false;
    private long F = 0;
    private volatile long G = 0;
    private int H = 0;
    private volatile String I = "00:00:00:00:00:00";
    private String J = null;
    private dc K = null;
    private volatile Timer L = null;
    private volatile TimerTask M = null;
    private int N = 0;
    private volatile Object O = null;
    private boolean P = false;
    private String Q = null;
    private String R = null;
    private long S = 0;
    private volatile long T = 0;
    private volatile String U = null;
    private ck V = null;
    private cz W = null;
    private StringBuilder X = new StringBuilder();
    private boolean Y = true;
    private boolean Z = true;
    volatile Context a = null;
    private boolean aa = false;
    private boolean ab = false;
    private volatile boolean ac = false;
    private long ae = 0;
    private int af = -1;
    private String ag = null;
    private String ah = null;
    private boolean ai = false;
    JSONObject b = null;
    Object c = null;
    cg d;
    volatile int e = -1;
    boolean f = false;
    volatile boolean g = true;
    Object h = new Object();
    public boolean i = false;
    public String j = "com.data.carrier_v4.CollectorManager";
    public String k = "com.autonavi.aps.amapapi.offline.Off";
    volatile boolean l = false;
    int m = 12;
    TreeMap<Integer, ScanResult> n = null;
    boolean o = true;
    bz p = new bz(this);
    StringBuilder q = null;
    private ConnectivityManager r = null;
    private volatile co s = null;
    private volatile cn t = null;
    private ArrayList<ScanResult> u = new ArrayList();
    private volatile ArrayList<ScanResult> v = new ArrayList();
    private HashMap<String, ArrayList<ScanResult>> w = new HashMap();
    private ca x = null;
    private volatile WifiInfo y = null;
    private volatile AmapLoc z = null;

    private AmapLoc a(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            if (y()) {
                return new AmapLoc(new JSONObject((String) dg.a(this.O, "getPureOfflineLocation", str, str2, jSONObject, str3)));
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private AmapLoc a(boolean z, boolean z2) throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String f;
        int a;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder3;
        int i;
        TelephonyManager telephonyManager;
        String str11;
        NetworkInfo activeNetworkInfo;
        int i2;
        boolean z3;
        db dbVar;
        bq a2;
        int i3;
        byte[] bArr;
        Object obj;
        AmapLoc amapLoc;
        Object obj2;
        AmapLoc amapLoc2 = new AmapLoc();
        if (!z) {
            this.A = dm.b();
            if (this.a == null) {
                this.X.append("context is null");
                amapLoc2 = new AmapLoc();
                amapLoc2.a(1);
                amapLoc2.a(this.X.toString());
                return amapLoc2;
            }
        }
        try {
            if (this.t.a(this.D)) {
                this.t.c();
            }
            str = SettingsConst.FALSE;
            str2 = SettingsConst.FALSE;
            str3 = SettingsConst.FALSE;
            str4 = SettingsConst.FALSE;
            str5 = SettingsConst.FALSE;
            f = dx.f(this.a);
            cq.c = "";
            a = dm.a(-32768, 32767);
            str6 = "";
            String str12 = "";
            String str13 = "";
            str7 = "api_serverSDK_130905";
            str8 = "S128DF1572465B890OE3F7A13167KLEI";
            if (this.Z) {
                str9 = str8;
                str10 = str7;
            } else {
                str9 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
                str10 = "UC_nlp_20131029";
            }
            stringBuilder = new StringBuilder();
            stringBuilder2 = new StringBuilder();
            stringBuilder3 = new StringBuilder();
            cn cnVar = this.t;
            i = cnVar.b;
            telephonyManager = cnVar.e;
            ArrayList arrayList = cnVar.c;
            if (i == 2) {
                str11 = SettingsConst.TRUE;
            } else {
                str11 = str;
            }
            if (telephonyManager != null) {
                if (TextUtils.isEmpty(cq.a)) {
                    cq.a = ei.q(this.a);
                }
                if (TextUtils.isEmpty(cq.a)) {
                    cq.a = "888888888888888";
                }
                if (TextUtils.isEmpty(cq.b)) {
                    try {
                        cq.b = telephonyManager.getSubscriberId();
                    } catch (Throwable th) {
                        cq.a(th, "APS", "getApsReq part2");
                    }
                }
                if (TextUtils.isEmpty(cq.b)) {
                    cq.b = "888888888888888";
                }
            }
        } catch (Throwable th2) {
            this.X.append("get parames error:" + th2.getMessage());
            amapLoc2.a(3);
            amapLoc2.a(this.X.toString());
            return amapLoc2;
        }
        try {
            activeNetworkInfo = this.r.getActiveNetworkInfo();
        } catch (Throwable th22) {
            cq.a(th22, "APS", "getApsReq part");
            activeNetworkInfo = null;
        }
        if (dm.a(activeNetworkInfo) != -1) {
            str12 = dm.b(telephonyManager);
            str = (r() && a(this.y)) ? Global.APOLLO_SERIES : SettingsConst.TRUE;
            if (!r()) {
                p();
                if (this.u != null) {
                    this.u.clear();
                    str8 = str;
                    str7 = str12;
                }
            }
            str8 = str;
            str7 = str12;
        } else {
            this.y = null;
            str8 = str12;
            str7 = str6;
        }
        if (dm.a(this.b, "poiid")) {
            try {
                str = this.b.getString("poiid");
                if (TextUtils.isEmpty(str)) {
                    this.J = null;
                } else if (str.length() > 32) {
                    this.J = null;
                } else {
                    this.J = str;
                }
            } catch (Throwable th222) {
                cq.a(th222, "APS", "setPoiid");
            }
        } else {
            this.J = null;
        }
        if (arrayList.isEmpty()) {
            str6 = str13;
        } else {
            StringBuilder stringBuilder4 = new StringBuilder();
            ck ckVar;
            switch (i) {
                case 1:
                    a("resetCdmaData");
                    ckVar = (ck) arrayList.get(0);
                    stringBuilder4.delete(0, stringBuilder4.length());
                    stringBuilder4.append("<mcc>").append(ckVar.a).append("</mcc>");
                    stringBuilder4.append("<mnc>").append(ckVar.b).append("</mnc>");
                    stringBuilder4.append("<lac>").append(ckVar.c).append("</lac>");
                    stringBuilder4.append("<cellid>").append(ckVar.d);
                    stringBuilder4.append("</cellid>");
                    stringBuilder4.append("<signal>").append(ckVar.j);
                    stringBuilder4.append("</signal>");
                    str13 = stringBuilder4.toString();
                    for (i2 = 1; i2 < arrayList.size(); i2++) {
                        ckVar = (ck) arrayList.get(i2);
                        stringBuilder.append(ckVar.c).append(",");
                        stringBuilder.append(ckVar.d).append(",");
                        stringBuilder.append(ckVar.j);
                        if (i2 < arrayList.size() - 1) {
                            stringBuilder.append("*");
                        }
                    }
                    str = str13;
                    break;
                case 2:
                    ckVar = (ck) arrayList.get(0);
                    stringBuilder4.delete(0, stringBuilder4.length());
                    stringBuilder4.append("<mcc>").append(ckVar.a).append("</mcc>");
                    stringBuilder4.append("<sid>").append(ckVar.g).append("</sid>");
                    stringBuilder4.append("<nid>").append(ckVar.h).append("</nid>");
                    stringBuilder4.append("<bid>").append(ckVar.i).append("</bid>");
                    if (ckVar.f <= 0 || ckVar.e <= 0) {
                        a("resetCdmaData");
                    } else {
                        if (y()) {
                            dg.a(this.O, "setCdmaLatLon", Integer.valueOf(ckVar.e), Integer.valueOf(ckVar.f));
                        }
                        stringBuilder4.append("<lon>").append(ckVar.f).append("</lon>");
                        stringBuilder4.append("<lat>").append(ckVar.e).append("</lat>");
                    }
                    stringBuilder4.append("<signal>").append(ckVar.j).append("</signal>");
                    str = stringBuilder4.toString();
                    break;
                default:
                    a("resetCdmaData");
                    str = str13;
                    break;
            }
            stringBuilder4.delete(0, stringBuilder4.length());
            str6 = str;
        }
        if (r()) {
            if (a(this.y)) {
                stringBuilder3.append(this.y.getBSSID()).append(",");
                int rssi = this.y.getRssi();
                if (rssi < -128) {
                    rssi = 0;
                } else if (rssi > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    rssi = 0;
                }
                stringBuilder3.append(rssi).append(",");
                str13 = this.y.getSSID();
                try {
                    rssi = this.y.getSSID().getBytes("UTF-8").length;
                } catch (Throwable th2222) {
                    cq.a(th2222, "APS", "getApsReq");
                    rssi = 32;
                }
                stringBuilder3.append((rssi >= 32 ? "unkwn" : str13).replace("*", "."));
            }
            i2 = Math.min(this.u.size(), 15);
            for (int i4 = 0; i4 < i2; i4++) {
                ScanResult scanResult = (ScanResult) this.u.get(i4);
                stringBuilder2.append(scanResult.BSSID).append(",");
                stringBuilder2.append(scanResult.level).append(",");
                stringBuilder2.append(scanResult.SSID).append("*");
            }
        } else {
            p();
        }
        if (stringBuilder2.length() == 0) {
            stringBuilder2.append(stringBuilder3);
        } else {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
        }
        if (dm.a(this.b, "reversegeo")) {
            try {
                z3 = this.b.getBoolean("reversegeo");
            } catch (Throwable th22222) {
                cq.a(th22222, "APS", "getApsReq part");
            }
            if (z3) {
                this.K.b = (short) 2;
            } else {
                this.K.b = (short) 0;
            }
            if (dm.a(this.b, "multi")) {
                try {
                    if (this.b.getString("multi").equals(SettingsConst.TRUE)) {
                        this.K.b = (short) 1;
                    }
                } catch (Throwable th222222) {
                    cq.a(th222222, "APS", "getApsReq");
                }
            }
            this.K.c = str10;
            this.K.d = str9;
            this.K.f = dm.d();
            this.K.g = "android" + dm.e();
            this.K.h = dm.b(this.a);
            this.K.i = str11;
            this.K.j = str2;
            this.K.k = this.E ? SettingsConst.TRUE : SettingsConst.FALSE;
            this.K.l = str3;
            this.K.m = str4;
            this.K.n = str5;
            this.K.o = f;
            this.K.p = cq.a;
            this.K.q = cq.b;
            this.K.s = String.valueOf(a);
            this.K.t = this.I;
            this.K.v = "2.8.0";
            this.K.w = w();
            this.K.F = this.J;
            this.K.u = cq.c;
            this.K.x = str7;
            this.K.y = str8;
            this.K.z = String.valueOf(i);
            this.K.A = str6;
            this.K.B = stringBuilder.toString();
            this.K.D = stringBuilder2.toString();
            this.K.E = String.valueOf(dm.b() - this.G);
            this.K.C = stringBuilder3.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder2.delete(0, stringBuilder2.length());
            stringBuilder3.delete(0, stringBuilder3.length());
            dbVar = new db();
            str11 = "";
            a2 = this.W.a(this.a, this.b, this.K, cq.a(), z2);
            i3 = this.W.c;
            if (a2 == null) {
                bArr = a2.a;
                obj = a2.c;
            } else {
                str12 = str11;
                bArr = null;
            }
            amapLoc2.D = (long) i3;
            if (!z) {
                amapLoc = amapLoc2;
            } else if (bArr != null || bArr.length == 0) {
                amapLoc2.a(4);
                this.X.append("please check the network");
                if (!TextUtils.isEmpty(obj)) {
                    this.X.append(" #csid:" + obj);
                }
                amapLoc2.a(this.X.toString());
                return amapLoc2;
            } else {
                str13 = new String(bArr, "UTF-8");
                if (str13.contains("\"status\":\"0\"")) {
                    amapLoc2 = dbVar.a(str13);
                    amapLoc2.D = (long) i3;
                    return amapLoc2;
                }
                bArr = cp.a(bArr);
                if (bArr == null) {
                    amapLoc2.a(6);
                    this.X.append("decrypt response data error");
                    if (!TextUtils.isEmpty(obj)) {
                        this.X.append(" #csid:" + obj);
                    }
                    amapLoc2.a(this.X.toString());
                    return amapLoc2;
                }
                AmapLoc a3 = dbVar.a(bArr);
                a3.D = (long) i3;
                if (a3.g != 0) {
                    if (!TextUtils.isEmpty(obj)) {
                        a3.a(a3.j + " #csid:" + obj);
                    }
                    return a3;
                } else if (dm.a(a3)) {
                    if (a3.E != null) {
                    }
                    if (a3.g == 0 && a3.i == 0) {
                        if ("-5".equals(a3.k) || SettingsConst.TRUE.equals(a3.k) || Global.APOLLO_SERIES.equals(a3.k) || "14".equals(a3.k) || "24".equals(a3.k) || "-1".equals(a3.k)) {
                            a3.i = 5;
                        } else {
                            a3.i = 6;
                        }
                        this.X.append(a3.k);
                        if (!TextUtils.isEmpty(obj)) {
                            this.X.append(" #csid:" + obj);
                        }
                        a3.a(this.X.toString());
                    }
                    a3.B = this.Z;
                    a3.C = this.Y;
                    amapLoc = a3;
                } else {
                    this.Q = a3.l;
                    a3.a(6);
                    this.X.append("location faile retype:" + a3.k + " rdesc:" + (this.Q != null ? this.Q : "null"));
                    if (!TextUtils.isEmpty(obj)) {
                        this.X.append(" #csid:" + obj);
                    }
                    a3.a(this.X.toString());
                    return a3;
                }
            }
            return amapLoc;
        }
        z3 = true;
        if (z3) {
            this.K.b = (short) 0;
        } else {
            this.K.b = (short) 2;
        }
        if (dm.a(this.b, "multi")) {
            if (this.b.getString("multi").equals(SettingsConst.TRUE)) {
                this.K.b = (short) 1;
            }
        }
        this.K.c = str10;
        this.K.d = str9;
        this.K.f = dm.d();
        this.K.g = "android" + dm.e();
        this.K.h = dm.b(this.a);
        this.K.i = str11;
        this.K.j = str2;
        if (this.E) {
        }
        this.K.k = this.E ? SettingsConst.TRUE : SettingsConst.FALSE;
        this.K.l = str3;
        this.K.m = str4;
        this.K.n = str5;
        this.K.o = f;
        this.K.p = cq.a;
        this.K.q = cq.b;
        this.K.s = String.valueOf(a);
        this.K.t = this.I;
        this.K.v = "2.8.0";
        this.K.w = w();
        this.K.F = this.J;
        this.K.u = cq.c;
        this.K.x = str7;
        this.K.y = str8;
        this.K.z = String.valueOf(i);
        this.K.A = str6;
        this.K.B = stringBuilder.toString();
        this.K.D = stringBuilder2.toString();
        this.K.E = String.valueOf(dm.b() - this.G);
        this.K.C = stringBuilder3.toString();
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder3.delete(0, stringBuilder3.length());
        dbVar = new db();
        str11 = "";
        try {
            a2 = this.W.a(this.a, this.b, this.K, cq.a(), z2);
            i3 = this.W.c;
            if (a2 == null) {
                str12 = str11;
                bArr = null;
            } else {
                bArr = a2.a;
                obj = a2.c;
            }
            try {
                amapLoc2.D = (long) i3;
                if (!z) {
                    amapLoc = amapLoc2;
                } else {
                    if (bArr != null) {
                    }
                    amapLoc2.a(4);
                    this.X.append("please check the network");
                    if (TextUtils.isEmpty(obj)) {
                        this.X.append(" #csid:" + obj);
                    }
                    amapLoc2.a(this.X.toString());
                    return amapLoc2;
                }
                return amapLoc;
            } catch (Throwable th3) {
                obj2 = obj;
                amapLoc2.a(4);
                this.X.append("please check the network");
                if (!TextUtils.isEmpty(obj2)) {
                    this.X.append(" #csid:" + obj2);
                }
                amapLoc2.a(this.X.toString());
                return amapLoc2;
            }
        } catch (Throwable th4) {
            obj2 = str11;
            amapLoc2.a(4);
            this.X.append("please check the network");
            if (TextUtils.isEmpty(obj2)) {
                this.X.append(" #csid:" + obj2);
            }
            amapLoc2.a(this.X.toString());
            return amapLoc2;
        }
    }

    static /* synthetic */ void a(cb cbVar, int i) {
        int i2 = 674234367;
        if (cbVar.d() && de.u()) {
            Object[] objArr;
            JSONObject jSONObject;
            Object a;
            String a2;
            switch (i) {
                case 0:
                    i2 = 70254591;
                case 2:
                    if (cbVar.v()) {
                        i2 = 2083520511;
                    }
                case 1:
                    objArr = new Object[1];
                    jSONObject = new JSONObject();
                    jSONObject.put("e", 1);
                    jSONObject.put("d", i2);
                    jSONObject.put("u", 1);
                    objArr[0] = jSONObject.toString();
                    dg.a(cbVar.c, "callBackWrapData", objArr);
                    a = dg.a(cbVar.c, "getReportDate", new Object[0]);
                    if (a != null) {
                        a2 = cbVar.W.a((byte[]) a, cbVar.a, "http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&");
                        if (cbVar.d()) {
                            try {
                                cbVar.N = ((Integer) dg.a(cbVar.c, "setUploadResult", a2, Integer.valueOf(i2))).intValue();
                            } catch (Throwable th) {
                                cbVar.N = 3;
                            }
                        }
                    }
                    cbVar.f();
                    if (!cbVar.d() && cbVar.t() == 0) {
                        cbVar.u();
                        return;
                    } else if (cbVar.N >= 3) {
                        cbVar.u();
                    }
                default:
                    i2 = 70254591;
            }
            try {
                objArr = new Object[1];
                jSONObject = new JSONObject();
                jSONObject.put("e", 1);
                jSONObject.put("d", i2);
                jSONObject.put("u", 1);
                objArr[0] = jSONObject.toString();
                dg.a(cbVar.c, "callBackWrapData", objArr);
            } catch (Throwable th2) {
            }
            try {
                a = dg.a(cbVar.c, "getReportDate", new Object[0]);
            } catch (Throwable th3) {
                cq.a(th3, "APS", "up");
                return;
            }
            if (a != null) {
                a2 = cbVar.W.a((byte[]) a, cbVar.a, "http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&");
                if (cbVar.d()) {
                    cbVar.N = ((Integer) dg.a(cbVar.c, "setUploadResult", a2, Integer.valueOf(i2))).intValue();
                }
            }
            cbVar.f();
            if (!cbVar.d()) {
            }
            if (cbVar.N >= 3) {
                cbVar.u();
            }
        }
    }

    private void a(String str) {
        try {
            if (y()) {
                dg.a(this.O, str, new Object[0]);
            } else if (this.O != null) {
                dg.a(this.O, "stopOff", new Object[0]);
                this.l = false;
            }
        } catch (Throwable th) {
        }
    }

    private static boolean a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (Throwable e) {
            cq.a(e, "APS", "wifiSigFine");
        }
        return i2 > 0;
    }

    private static boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getBSSID()) || TextUtils.isEmpty(wifiInfo.getSSID()) || wifiInfo.getBSSID().equals("00:00:00:00:00:00") || wifiInfo.getBSSID().contains(" :")) ? false : true;
    }

    private synchronized StringBuilder b(boolean z) {
        StringBuilder stringBuilder;
        Object obj = null;
        synchronized (this) {
            cn cnVar = this.t;
            if (this.D) {
                cnVar.d();
            }
            stringBuilder = new StringBuilder(SecExceptionCode.SEC_ERROR_STA_KEY_ENC);
            int i = cnVar.b;
            ArrayList arrayList = cnVar.c;
            switch (i) {
                case 1:
                    for (i = 1; i < arrayList.size(); i++) {
                        stringBuilder.append("#").append(((ck) arrayList.get(i)).b);
                        stringBuilder.append("|").append(((ck) arrayList.get(i)).c);
                        stringBuilder.append("|").append(((ck) arrayList.get(i)).d);
                    }
                    break;
            }
            if (((!z && TextUtils.isEmpty(this.I)) || this.I.equals("00:00:00:00:00:00")) && this.y != null) {
                this.I = this.y.getMacAddress();
                if (!(this.a == null || TextUtils.isEmpty(this.I))) {
                    Object a;
                    SharedPreferences sharedPreferences = this.a.getSharedPreferences("pref", 0);
                    try {
                        a = ej.a(this.I.getBytes("UTF-8"));
                    } catch (Throwable th) {
                        cq.a(th, "APS", "setSmac");
                        a = null;
                    }
                    if (!TextUtils.isEmpty(a)) {
                        sharedPreferences.edit().putString("smac", a).commit();
                    }
                }
                if (TextUtils.isEmpty(this.I)) {
                    this.I = "00:00:00:00:00:00";
                }
            }
            if (r()) {
                Object bssid;
                String str = "";
                if (a(this.y)) {
                    bssid = this.y.getBSSID();
                } else {
                    String str2 = str;
                }
                int size = this.u.size();
                for (i = 0; i < size; i++) {
                    str = "nb";
                    if (bssid.equals(((ScanResult) this.u.get(i)).BSSID)) {
                        str = "access";
                        obj = 1;
                    }
                    stringBuilder.append(String.format(Locale.US, "#%s,%s", new Object[]{((ScanResult) this.u.get(i)).BSSID, str}));
                }
                if (obj == null && !TextUtils.isEmpty(bssid)) {
                    stringBuilder.append("#").append(bssid);
                    stringBuilder.append(",access");
                }
            } else {
                p();
                if (this.u != null) {
                    this.u.clear();
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(0);
            }
        }
        return stringBuilder;
    }

    private void b(JSONObject jSONObject) {
        try {
            if (y()) {
                dg.a(this.O, "setLastLoc", jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    private void e(Context context) {
        try {
            ep a = cq.a("OfflineLocation", "1.0.0");
            if (this.O == null) {
                this.O = ac.a(context, a, this.k, null, new Class[]{Context.class}, new Object[]{context});
            }
        } catch (Throwable th) {
            cq.a(th, "APS", "initOffLocation");
        }
    }

    static /* synthetic */ void g(cb cbVar) {
        if (!cbVar.d()) {
            return;
        }
        if (de.u()) {
            if (cbVar.M == null) {
                cbVar.M = new by(cbVar);
            }
            if (cbVar.L == null) {
                cbVar.L = new Timer("T-U", false);
                cbVar.L.schedule(cbVar.M, 2000, 2000);
                return;
            }
            return;
        }
        cbVar.u();
    }

    private void i() {
        boolean z;
        boolean z2;
        boolean z3;
        try {
            z = dm.a(this.b, "reversegeo") ? this.b.getBoolean("reversegeo") : true;
            try {
                z2 = dm.a(this.b, "isOffset") ? this.b.getBoolean("isOffset") : true;
                try {
                    z3 = dm.a(this.b, "isLocationCacheEnable") ? this.b.getBoolean("isLocationCacheEnable") : true;
                    try {
                        if (!(z2 == this.Z && z == this.Y && z3 == this.g)) {
                            this.U = null;
                            this.z = null;
                            b(null);
                            this.T = 0;
                            this.A = 0;
                            ci.a().b();
                        }
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    z3 = true;
                }
            } catch (Throwable th3) {
                z3 = true;
                z2 = true;
            }
        } catch (Throwable th4) {
            z3 = true;
            z = true;
            z2 = true;
        }
        this.Z = z2;
        this.Y = z;
        this.g = z3;
        this.D = dm.a(this.a);
        this.ac = true;
    }

    private void j() {
        try {
            if (y()) {
                dg.a(this.O, "resetPureOfflineCache", new Object[0]);
            }
        } catch (Throwable th) {
        }
    }

    private void k() {
        try {
            if (this.x == null) {
                this.x = new ca();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.a.registerReceiver(this.x, intentFilter);
            q();
        } catch (Throwable th) {
            cq.a(th, "APS", "initBroadcastListener");
        }
    }

    private synchronized String l() {
        String str;
        Object obj = null;
        synchronized (this) {
            if (!this.D) {
                cn cnVar = this.t;
                switch (cnVar.b) {
                    case 1:
                        if (cnVar.c.isEmpty()) {
                            cnVar.b = 9;
                            break;
                        }
                        break;
                    case 2:
                        if (cnVar.c.isEmpty()) {
                            cnVar.b = 9;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            this.t.d();
            str = "";
            String str2 = "network";
            if (r()) {
                co coVar = this.s;
                this.y = coVar.a != null ? coVar.a.getConnectionInfo() : null;
            } else {
                p();
                if (this.u != null) {
                    this.u.clear();
                }
            }
            int i = this.t.b;
            ArrayList arrayList = this.t.c;
            if ((arrayList == null || arrayList.isEmpty()) && (this.u == null || this.u.isEmpty())) {
                this.X.append("⊗ lstCgi & ⊗ wifis");
                this.m = 12;
            } else {
                ck ckVar;
                StringBuilder stringBuilder;
                switch (i) {
                    case 1:
                        if (!arrayList.isEmpty()) {
                            ckVar = (ck) arrayList.get(0);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(ckVar.a).append("#");
                            stringBuilder.append(ckVar.b).append("#");
                            stringBuilder.append(ckVar.c).append("#");
                            stringBuilder.append(ckVar.d).append("#");
                            stringBuilder.append(str2).append("#");
                            str = (!this.u.isEmpty() || a(this.y)) ? "cgiwifi" : "cgi";
                            stringBuilder.append(str);
                            str = stringBuilder.toString();
                            break;
                        }
                        break;
                    case 2:
                        if (!arrayList.isEmpty()) {
                            ckVar = (ck) arrayList.get(0);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(ckVar.a).append("#");
                            stringBuilder.append(ckVar.b).append("#");
                            stringBuilder.append(ckVar.g).append("#");
                            stringBuilder.append(ckVar.h).append("#");
                            stringBuilder.append(ckVar.i).append("#");
                            stringBuilder.append(str2).append("#");
                            str = (!this.u.isEmpty() || a(this.y)) ? "cgiwifi" : "cgi";
                            stringBuilder.append(str);
                            str = stringBuilder.toString();
                            break;
                        }
                        break;
                    case 9:
                        Object obj2 = (!this.u.isEmpty() || a(this.y)) ? 1 : null;
                        if (a(this.y) && this.u.isEmpty()) {
                            this.m = 2;
                            this.X.append("⊗ around wifi(s) & has access wifi");
                        } else {
                            if (this.u.size() == 1) {
                                this.m = 2;
                                if (a(this.y)) {
                                    if (this.y.getBSSID().equals(((ScanResult) this.u.get(0)).BSSID)) {
                                        this.X.append("same access wifi & around wifi 1");
                                    }
                                } else {
                                    this.X.append("⊗ access wifi & around wifi 1");
                                }
                            }
                            obj = obj2;
                        }
                        str = String.format(Locale.US, "#%s#", new Object[]{str2});
                        if (obj == null) {
                            if (str2.equals("network")) {
                                str = "";
                                this.m = 2;
                                this.X.append("is network & no wifi");
                                break;
                            }
                        }
                        str = str + "wifi";
                        break;
                        break;
                    default:
                        this.m = 11;
                        this.X.append("get cgi failure");
                        break;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                    str = dm.h() + str;
                }
            }
        }
        return str;
    }

    private void m() {
        int i;
        Object obj = 1;
        Object obj2 = null;
        long b = dm.b();
        if (TextUtils.isEmpty(this.J)) {
            if (r()) {
                if (this.F == 0) {
                    i = 1;
                } else if (dm.b() - this.F >= 3000 && dm.b() - this.G >= 1500) {
                    i = 1;
                }
            }
            obj = obj2;
        }
        if (obj != null || dm.b() - this.G > 3000) {
            if (b - this.B >= 10000) {
                synchronized (this.h) {
                    this.v.clear();
                }
            }
            q();
            if (b - this.B >= 10000) {
                for (i = 20; i > 0 && this.v.isEmpty(); i--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable th) {
                    }
                }
            }
            synchronized (this.h) {
            }
        }
        if (this.v.isEmpty() && this.s != null) {
            this.G = dm.b();
            Collection a = this.s.a();
            if (a != null) {
                synchronized (this.h) {
                    this.v.addAll(a);
                }
            }
        }
    }

    private synchronized void n() {
        List list = this.u;
        Collection collection = this.v;
        list.clear();
        synchronized (this.h) {
            if (collection != null) {
                if (collection.size() > 0) {
                    list.addAll(collection);
                }
            }
        }
    }

    private synchronized void o() {
        if (!(this.u == null || this.u.isEmpty())) {
            boolean z;
            int size;
            int i;
            ScanResult scanResult;
            int length;
            if (dm.b() - this.G > 3600000) {
                p();
                this.u.clear();
            }
            boolean f = dm.f();
            if (dm.a(this.b, "nbssid")) {
                try {
                    if (this.b.getString("nbssid").equals(SettingsConst.TRUE)) {
                        z = true;
                    } else {
                        if (this.b.getString("nbssid").equals(SettingsConst.FALSE)) {
                            f = false;
                        }
                        z = f;
                    }
                } catch (Throwable th) {
                    cq.a(th, "APS", "setWifiOrder part");
                }
                if (this.n == null) {
                    this.n = new TreeMap(Collections.reverseOrder());
                }
                this.n.clear();
                size = this.u.size();
                for (i = 0; i < size; i++) {
                    scanResult = (ScanResult) this.u.get(i);
                    if (dm.a(scanResult) && (size <= 20 || a(scanResult.level))) {
                        if (!TextUtils.isEmpty(scanResult.SSID)) {
                            scanResult.SSID = "unkwn";
                        } else if (z) {
                            scanResult.SSID = String.valueOf(i);
                        } else {
                            scanResult.SSID = scanResult.SSID.replace("*", ".");
                            try {
                                length = scanResult.SSID.getBytes("UTF-8").length;
                            } catch (Throwable th2) {
                                cq.a(th2, "APS", "setWifiOrder");
                                length = 32;
                            }
                            if (length >= 32) {
                                scanResult.SSID = String.valueOf(i);
                            }
                        }
                        this.n.put(Integer.valueOf((scanResult.level * 30) + i), scanResult);
                    }
                }
                this.u.clear();
                for (ScanResult scanResult2 : this.n.values()) {
                    this.u.add(scanResult2);
                }
                this.n.clear();
            }
            z = f;
            if (this.n == null) {
                this.n = new TreeMap(Collections.reverseOrder());
            }
            this.n.clear();
            size = this.u.size();
            for (i = 0; i < size; i++) {
                scanResult2 = (ScanResult) this.u.get(i);
                if (!TextUtils.isEmpty(scanResult2.SSID)) {
                    scanResult2.SSID = "unkwn";
                } else if (z) {
                    scanResult2.SSID = String.valueOf(i);
                } else {
                    scanResult2.SSID = scanResult2.SSID.replace("*", ".");
                    length = scanResult2.SSID.getBytes("UTF-8").length;
                    if (length >= 32) {
                        scanResult2.SSID = String.valueOf(i);
                    }
                }
                this.n.put(Integer.valueOf((scanResult2.level * 30) + i), scanResult2);
            }
            this.u.clear();
            while (r1.hasNext()) {
                this.u.add(scanResult2);
            }
            this.n.clear();
        }
    }

    private void p() {
        this.G = 0;
        this.y = null;
        synchronized (this.h) {
            this.v.clear();
            this.w.clear();
        }
    }

    private void q() {
        Throwable th;
        boolean z;
        boolean z2 = false;
        if (r()) {
            boolean equals;
            co coVar;
            if (dm.c() < 18 && dm.c() > 3 && dm.a(this.b, "wifiactivescan")) {
                try {
                    equals = SettingsConst.TRUE.equals(this.b.getString("wifiactivescan"));
                } catch (Throwable th2) {
                    cq.a(th2, "APS", "updateWifi part1");
                }
                if (equals) {
                    z = false;
                } else {
                    try {
                        z = this.s.b();
                        if (z) {
                            try {
                                this.F = dm.b();
                            } catch (Throwable th3) {
                                th2 = th3;
                                cq.a(th2, "APS", "updateWifi part");
                                if (z) {
                                    try {
                                        coVar = this.s;
                                        coVar.d = dm.b();
                                        z2 = coVar.a.startScan();
                                        if (!z2) {
                                            this.F = dm.b();
                                        }
                                    } catch (Throwable th22) {
                                        cq.a(th22, "APS", "updateWifi");
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th22 = th4;
                        z = false;
                        cq.a(th22, "APS", "updateWifi part");
                        if (z) {
                            coVar = this.s;
                            coVar.d = dm.b();
                            z2 = coVar.a.startScan();
                            if (!z2) {
                                this.F = dm.b();
                            }
                        }
                    }
                }
                if (z) {
                    coVar = this.s;
                    if (dm.b() - coVar.d >= 3000 && coVar.a != null) {
                        coVar.d = dm.b();
                        z2 = coVar.a.startScan();
                    }
                    if (!z2) {
                        this.F = dm.b();
                    }
                }
            }
            equals = false;
            if (equals) {
                z = false;
            } else {
                z = this.s.b();
                if (z) {
                    this.F = dm.b();
                }
            }
            if (z) {
                coVar = this.s;
                coVar.d = dm.b();
                z2 = coVar.a.startScan();
                if (!z2) {
                    this.F = dm.b();
                }
            }
        }
    }

    private boolean r() {
        return this.s != null ? this.s.c() : false;
    }

    private boolean s() {
        try {
            return ((Boolean) dg.a(this.c, "isStarted", new Object[0])).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private int t() {
        try {
            return ((Integer) dg.a(this.c, "getLeftUploadNum", new Object[0])).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    private synchronized void u() {
        if (this.M != null) {
            this.M.cancel();
            this.M = null;
        }
        if (this.L != null) {
            this.L.cancel();
            this.L.purge();
            this.L = null;
        }
    }

    private boolean v() {
        return (this.s == null || this.r == null) ? false : this.s.a(this.r);
    }

    private String w() {
        try {
            if (this.c != null) {
                return (String) dg.a(this.c, "getInnerString", "version");
            }
        } catch (Throwable th) {
            cq.a(th, "APS", "getCollVer");
        }
        return null;
    }

    private synchronized void x() {
        if (this.ag != null) {
            this.ag = null;
            this.ah = null;
            this.q = null;
        }
        try {
            if (!this.D) {
                this.t.a(this.D, true);
            }
            this.ab = this.b.optBoolean("isOnceLocationLatest", false);
            if (this.ab) {
                if (!this.aa) {
                    k();
                    this.aa = true;
                }
                m();
            }
            n();
            if (this.u != null && this.u.isEmpty()) {
                this.G = dm.b();
                Collection a = this.s.a();
                if (a != null) {
                    this.u.addAll(a);
                    synchronized (this.h) {
                        if (this.v != null && this.v.isEmpty()) {
                            this.v.addAll(a);
                        }
                    }
                }
            }
            o();
        } catch (Throwable th) {
            cq.a(th, "APS", "initFirstLocateParam");
        }
        this.ag = l();
        if (!TextUtils.isEmpty(this.ag)) {
            this.ah = this.ag + "&" + this.Z + "&" + this.Y;
            this.q = b(true);
        }
        this.ai = true;
    }

    private boolean y() {
        return de.f() && this.O != null && de.v();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.autonavi.aps.amapapi.model.AmapLoc a() throws java.lang.Throwable {
        /*
        r14 = this;
        r8 = 0;
        r3 = 0;
        r11 = 2;
        r1 = 1;
        r2 = 0;
        monitor-enter(r14);
        r0 = r14.X;	 Catch:{ all -> 0x0184 }
        r0 = r0.length();	 Catch:{ all -> 0x0184 }
        if (r0 <= 0) goto L_0x001b;
    L_0x000f:
        r0 = r14.X;	 Catch:{ all -> 0x0184 }
        r4 = 0;
        r5 = r14.X;	 Catch:{ all -> 0x0184 }
        r5 = r5.length();	 Catch:{ all -> 0x0184 }
        r0.delete(r4, r5);	 Catch:{ all -> 0x0184 }
    L_0x001b:
        r0 = r14.a;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x003a;
    L_0x001f:
        r0 = r14.X;	 Catch:{ all -> 0x0184 }
        r1 = "context is null";
        r0.append(r1);	 Catch:{ all -> 0x0184 }
        r0 = new com.autonavi.aps.amapapi.model.AmapLoc;	 Catch:{ all -> 0x0184 }
        r0.<init>();	 Catch:{ all -> 0x0184 }
        r1 = 1;
        r0.a(r1);	 Catch:{ all -> 0x0184 }
        r1 = r14.X;	 Catch:{ all -> 0x0184 }
        r1 = r1.toString();	 Catch:{ all -> 0x0184 }
        r0.a(r1);	 Catch:{ all -> 0x0184 }
    L_0x0038:
        monitor-exit(r14);
        return r0;
    L_0x003a:
        r14.i();	 Catch:{ all -> 0x0184 }
        r0 = r14.H;	 Catch:{ all -> 0x0184 }
        r0 = r0 + 1;
        r14.H = r0;	 Catch:{ all -> 0x0184 }
        r14.f();	 Catch:{ all -> 0x0184 }
        r0 = r14.s;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r14.a;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0052;
    L_0x004e:
        r0 = r14.P;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x00f4;
    L_0x0052:
        r0 = r14.a;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x00ad;
    L_0x0056:
        r0 = r14.d();	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0066;
    L_0x005c:
        r0 = r14.c;	 Catch:{ Throwable -> 0x04c7 }
        r4 = "getColUpHist";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x04c7 }
        com.loc.dg.a(r0, r4, r5);	 Catch:{ Throwable -> 0x04c7 }
    L_0x0066:
        r0 = r14.y();	 Catch:{ Throwable -> 0x01a3 }
        if (r0 == 0) goto L_0x0190;
    L_0x006c:
        r0 = r14.O;	 Catch:{ Throwable -> 0x01a3 }
        r4 = "getOffDlHist";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x01a3 }
        com.loc.dg.a(r0, r4, r5);	 Catch:{ Throwable -> 0x01a3 }
    L_0x0076:
        r0 = r14.a;	 Catch:{ all -> 0x0184 }
        r4 = "pref";
        r5 = 0;
        r4 = r0.getSharedPreferences(r4, r5);	 Catch:{ all -> 0x0184 }
        r0 = r14.a;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x00ad;
    L_0x0083:
        if (r4 == 0) goto L_0x00ad;
    L_0x0085:
        r5 = "smac";
        r0 = r4.contains(r5);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x04d9;
    L_0x008d:
        r0 = 0;
        r6 = r4.getString(r5, r0);	 Catch:{ Throwable -> 0x01a6 }
        r0 = new java.lang.String;	 Catch:{ Throwable -> 0x01a6 }
        r6 = com.loc.ej.b(r6);	 Catch:{ Throwable -> 0x01a6 }
        r7 = "UTF-8";
        r0.<init>(r6, r7);	 Catch:{ Throwable -> 0x01a6 }
    L_0x009d:
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0184 }
        if (r4 != 0) goto L_0x00ad;
    L_0x00a3:
        r4 = "00:00:00:00:00:00";
        r4 = r0.equals(r4);	 Catch:{ all -> 0x0184 }
        if (r4 != 0) goto L_0x00ad;
    L_0x00ab:
        r14.I = r0;	 Catch:{ all -> 0x0184 }
    L_0x00ad:
        r4 = r14.A;	 Catch:{ all -> 0x0184 }
        r6 = com.loc.dm.b();	 Catch:{ all -> 0x0184 }
        r4 = r6 - r4;
        r6 = 800; // 0x320 float:1.121E-42 double:3.953E-321;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x04d3;
    L_0x00bb:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x04d6;
    L_0x00c3:
        r4 = com.loc.dm.a();	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r6 = r0.e;	 Catch:{ all -> 0x0184 }
        r4 = r4 - r6;
    L_0x00cc:
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x04d3;
    L_0x00d2:
        r0 = r1;
    L_0x00d3:
        if (r0 == 0) goto L_0x01bc;
    L_0x00d5:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x01bc;
    L_0x00dd:
        r0 = r14.g;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x00f0;
    L_0x00e1:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = r0.e;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.de.c(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x00f0;
    L_0x00eb:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r1 = 2;
        r0.i = r1;	 Catch:{ all -> 0x0184 }
    L_0x00f0:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        goto L_0x0038;
    L_0x00f4:
        r0 = r14.s;	 Catch:{ all -> 0x0184 }
        r4 = r14.P;	 Catch:{ all -> 0x0184 }
        r5 = r0.c;	 Catch:{ all -> 0x0184 }
        r6 = r0.a;	 Catch:{ all -> 0x0184 }
        if (r6 == 0) goto L_0x0052;
    L_0x00fe:
        if (r5 == 0) goto L_0x0052;
    L_0x0100:
        if (r4 == 0) goto L_0x0052;
    L_0x0102:
        r4 = com.loc.dm.c();	 Catch:{ all -> 0x0184 }
        r6 = 17;
        if (r4 <= r6) goto L_0x0052;
    L_0x010a:
        r4 = "autoenablewifialwaysscan";
        r6 = r0.b;	 Catch:{ all -> 0x0184 }
        r6 = com.loc.dm.a(r6, r4);	 Catch:{ all -> 0x0184 }
        if (r6 == 0) goto L_0x0122;
    L_0x0114:
        r6 = "0";
        r0 = r0.b;	 Catch:{ Throwable -> 0x0187 }
        r0 = r0.getString(r4);	 Catch:{ Throwable -> 0x0187 }
        r0 = r6.equals(r0);	 Catch:{ Throwable -> 0x0187 }
        if (r0 != 0) goto L_0x0052;
    L_0x0122:
        r4 = r5.getContentResolver();	 Catch:{ all -> 0x0184 }
        r5 = "android.provider.Settings$Global";
        r0 = 2;
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0184 }
        r6 = 0;
        r0[r6] = r4;	 Catch:{ all -> 0x0184 }
        r6 = 1;
        r7 = "wifi_scan_always_enabled";
        r0[r6] = r7;	 Catch:{ all -> 0x0184 }
        r6 = 2;
        r6 = new java.lang.Class[r6];	 Catch:{ all -> 0x0184 }
        r7 = 0;
        r10 = android.content.ContentResolver.class;
        r6[r7] = r10;	 Catch:{ all -> 0x0184 }
        r7 = 1;
        r10 = java.lang.String.class;
        r6[r7] = r10;	 Catch:{ all -> 0x0184 }
        r7 = "getInt";
        r0 = com.loc.dg.a(r5, r7, r0, r6);	 Catch:{ Throwable -> 0x017a }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x017a }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x017a }
        if (r0 != 0) goto L_0x0052;
    L_0x014e:
        r0 = 3;
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x017a }
        r6 = 0;
        r0[r6] = r4;	 Catch:{ Throwable -> 0x017a }
        r4 = 1;
        r6 = "wifi_scan_always_enabled";
        r0[r4] = r6;	 Catch:{ Throwable -> 0x017a }
        r4 = 2;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x017a }
        r0[r4] = r6;	 Catch:{ Throwable -> 0x017a }
        r4 = 3;
        r4 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x017a }
        r6 = 0;
        r7 = android.content.ContentResolver.class;
        r4[r6] = r7;	 Catch:{ Throwable -> 0x017a }
        r6 = 1;
        r7 = java.lang.String.class;
        r4[r6] = r7;	 Catch:{ Throwable -> 0x017a }
        r6 = 2;
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x017a }
        r4[r6] = r7;	 Catch:{ Throwable -> 0x017a }
        r6 = "putInt";
        com.loc.dg.a(r5, r6, r0, r4);	 Catch:{ Throwable -> 0x017a }
        goto L_0x0052;
    L_0x017a:
        r0 = move-exception;
        r4 = "WifiManagerWrapper";
        r5 = "enableWifiAlwaysScan";
        com.loc.cq.a(r0, r4, r5);	 Catch:{ all -> 0x0184 }
        goto L_0x0052;
    L_0x0184:
        r0 = move-exception;
        monitor-exit(r14);
        throw r0;
    L_0x0187:
        r0 = move-exception;
        r4 = "WifiManagerWrapper";
        r6 = "enableWifiAlwaysScan1";
        com.loc.cq.a(r0, r4, r6);	 Catch:{ all -> 0x0184 }
        goto L_0x0122;
    L_0x0190:
        r0 = r14.O;	 Catch:{ Throwable -> 0x01a3 }
        if (r0 == 0) goto L_0x0076;
    L_0x0194:
        r0 = r14.O;	 Catch:{ Throwable -> 0x01a3 }
        r4 = "stopOff";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x01a3 }
        com.loc.dg.a(r0, r4, r5);	 Catch:{ Throwable -> 0x01a3 }
        r0 = 0;
        r14.l = r0;	 Catch:{ Throwable -> 0x01a3 }
        goto L_0x0076;
    L_0x01a3:
        r0 = move-exception;
        goto L_0x0076;
    L_0x01a6:
        r0 = move-exception;
        r6 = "APS";
        r7 = "getSmac";
        com.loc.cq.a(r0, r6, r7);	 Catch:{ all -> 0x0184 }
        r0 = r4.edit();	 Catch:{ all -> 0x0184 }
        r0 = r0.remove(r5);	 Catch:{ all -> 0x0184 }
        r0.commit();	 Catch:{ all -> 0x0184 }
        r0 = r3;
        goto L_0x009d;
    L_0x01bc:
        r0 = r14.t;	 Catch:{ all -> 0x0184 }
        r4 = r14.D;	 Catch:{ all -> 0x0184 }
        r5 = 0;
        r0.a(r4, r5);	 Catch:{ all -> 0x0184 }
        r14.m();	 Catch:{ Throwable -> 0x021b }
        r4 = com.loc.dm.b();	 Catch:{ Throwable -> 0x021b }
        r14.B = r4;	 Catch:{ Throwable -> 0x021b }
        r14.n();	 Catch:{ Throwable -> 0x021b }
        r14.o();	 Catch:{ Throwable -> 0x021b }
    L_0x01d3:
        r0 = r14.l();	 Catch:{ all -> 0x0184 }
        r14.ag = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.y();	 Catch:{ Throwable -> 0x0224 }
        if (r0 == 0) goto L_0x01fa;
    L_0x01df:
        r0 = r14.l;	 Catch:{ Throwable -> 0x0224 }
        if (r0 != 0) goto L_0x01fa;
    L_0x01e3:
        r0 = r14.O;	 Catch:{ Throwable -> 0x0224 }
        r4 = "startOff";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0224 }
        r6 = 0;
        r7 = r14.b;	 Catch:{ Throwable -> 0x0224 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x0224 }
        r6 = 1;
        r7 = r14.ag;	 Catch:{ Throwable -> 0x0224 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x0224 }
        com.loc.dg.a(r0, r4, r5);	 Catch:{ Throwable -> 0x0224 }
        r0 = 1;
        r14.l = r0;	 Catch:{ Throwable -> 0x0224 }
    L_0x01fa:
        r0 = r14.ag;	 Catch:{ all -> 0x0184 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0256;
    L_0x0202:
        r0 = r14.f;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x020c;
    L_0x0206:
        r0 = 0;
        r1 = r14.a;	 Catch:{ all -> 0x0184 }
        r14.a(r0, r1);	 Catch:{ all -> 0x0184 }
    L_0x020c:
        r0 = 4;
    L_0x020d:
        if (r0 <= 0) goto L_0x022d;
    L_0x020f:
        r1 = r14.e;	 Catch:{ all -> 0x0184 }
        if (r1 == 0) goto L_0x022d;
    L_0x0213:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        android.os.SystemClock.sleep(r2);	 Catch:{ all -> 0x0184 }
        r0 = r0 + -1;
        goto L_0x020d;
    L_0x021b:
        r0 = move-exception;
        r4 = "APS";
        r5 = "getLocation";
        com.loc.cq.a(r0, r4, r5);	 Catch:{ all -> 0x0184 }
        goto L_0x01d3;
    L_0x0224:
        r0 = move-exception;
        r4 = "APS";
        r5 = "getLocation:isOffLineLoc";
        com.loc.cq.a(r0, r4, r5);	 Catch:{ all -> 0x0184 }
        goto L_0x01fa;
    L_0x022d:
        r0 = r14.e;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x0241;
    L_0x0231:
        r0 = r14.d;	 Catch:{ all -> 0x0184 }
        r0 = r0.c();	 Catch:{ all -> 0x0184 }
        r14.z = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0241;
    L_0x023d:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        goto L_0x0038;
    L_0x0241:
        r0 = new com.autonavi.aps.amapapi.model.AmapLoc;	 Catch:{ all -> 0x0184 }
        r0.<init>();	 Catch:{ all -> 0x0184 }
        r1 = r14.m;	 Catch:{ all -> 0x0184 }
        r0.a(r1);	 Catch:{ all -> 0x0184 }
        r1 = r14.X;	 Catch:{ all -> 0x0184 }
        r1 = r1.toString();	 Catch:{ all -> 0x0184 }
        r0.a(r1);	 Catch:{ all -> 0x0184 }
        goto L_0x0038;
    L_0x0256:
        r0 = 0;
        r0 = r14.b(r0);	 Catch:{ all -> 0x0184 }
        r14.q = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.D;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x04d0;
    L_0x0261:
        r0 = r14.t;	 Catch:{ all -> 0x0184 }
        r0 = r0.a();	 Catch:{ all -> 0x0184 }
        r6 = r0;
    L_0x0268:
        if (r6 != 0) goto L_0x026e;
    L_0x026a:
        r0 = r14.V;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0340;
    L_0x026e:
        r0 = r14.V;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x027e;
    L_0x0272:
        r0 = r14.V;	 Catch:{ all -> 0x0184 }
        if (r6 == 0) goto L_0x027b;
    L_0x0276:
        r4 = r6.k;	 Catch:{ all -> 0x0184 }
        switch(r4) {
            case 1: goto L_0x031c;
            case 2: goto L_0x0300;
            default: goto L_0x027b;
        };	 Catch:{ all -> 0x0184 }
    L_0x027b:
        r0 = r2;
    L_0x027c:
        if (r0 != 0) goto L_0x0340;
    L_0x027e:
        r5 = r1;
    L_0x027f:
        r10 = r14.A;	 Catch:{ all -> 0x0184 }
        r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0343;
    L_0x0285:
        r4 = r1;
    L_0x0286:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x04cd;
    L_0x028a:
        r0 = r14.u;	 Catch:{ all -> 0x0184 }
        r0 = r0.size();	 Catch:{ all -> 0x0184 }
        r7 = r14.z;	 Catch:{ all -> 0x0184 }
        r7 = r7.d;	 Catch:{ all -> 0x0184 }
        r10 = 1133871104; // 0x43958000 float:299.0 double:5.602067593E-315;
        r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x0356;
    L_0x029b:
        r7 = 5;
        if (r0 <= r7) goto L_0x0356;
    L_0x029e:
        r0 = r1;
    L_0x029f:
        r1 = r0;
    L_0x02a0:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0359;
    L_0x02a4:
        r0 = r14.U;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0359;
    L_0x02a8:
        if (r1 != 0) goto L_0x0359;
    L_0x02aa:
        if (r5 != 0) goto L_0x0359;
    L_0x02ac:
        r0 = r14.g;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0359;
    L_0x02b0:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r10 = r0.e;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.de.c(r10);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0359;
    L_0x02ba:
        com.loc.cs.a();	 Catch:{ all -> 0x0184 }
        r0 = r14.U;	 Catch:{ all -> 0x0184 }
        r2 = r14.q;	 Catch:{ all -> 0x0184 }
        r2 = com.loc.cs.a(r0, r2);	 Catch:{ all -> 0x0184 }
        if (r2 != 0) goto L_0x02da;
    L_0x02c7:
        r10 = r14.T;	 Catch:{ all -> 0x0184 }
        r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x0359;
    L_0x02cd:
        r8 = com.loc.dm.b();	 Catch:{ all -> 0x0184 }
        r10 = r14.T;	 Catch:{ all -> 0x0184 }
        r8 = r8 - r10;
        r10 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 >= 0) goto L_0x0359;
    L_0x02da:
        r0 = r14.t;	 Catch:{ all -> 0x0184 }
        r5 = r14.D;	 Catch:{ all -> 0x0184 }
        r0 = r0.a(r5);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x02e9;
    L_0x02e4:
        r0 = r14.t;	 Catch:{ all -> 0x0184 }
        r0.c();	 Catch:{ all -> 0x0184 }
    L_0x02e9:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0359;
    L_0x02f1:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r1 = "mem";
        r0.f = r1;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r1 = 2;
        r0.i = r1;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        goto L_0x0038;
    L_0x0300:
        r4 = r0.k;	 Catch:{ all -> 0x0184 }
        if (r4 != r11) goto L_0x027b;
    L_0x0304:
        r4 = r6.i;	 Catch:{ all -> 0x0184 }
        r5 = r0.i;	 Catch:{ all -> 0x0184 }
        if (r4 != r5) goto L_0x0319;
    L_0x030a:
        r4 = r6.h;	 Catch:{ all -> 0x0184 }
        r5 = r0.h;	 Catch:{ all -> 0x0184 }
        if (r4 != r5) goto L_0x0319;
    L_0x0310:
        r4 = r6.g;	 Catch:{ all -> 0x0184 }
        r0 = r0.g;	 Catch:{ all -> 0x0184 }
        if (r4 != r0) goto L_0x0319;
    L_0x0316:
        r0 = r1;
        goto L_0x027c;
    L_0x0319:
        r0 = r2;
        goto L_0x027c;
    L_0x031c:
        r4 = r0.k;	 Catch:{ all -> 0x0184 }
        if (r4 != r1) goto L_0x027b;
    L_0x0320:
        r4 = r6.c;	 Catch:{ all -> 0x0184 }
        r5 = r0.c;	 Catch:{ all -> 0x0184 }
        if (r4 != r5) goto L_0x033d;
    L_0x0326:
        r4 = r6.d;	 Catch:{ all -> 0x0184 }
        r5 = r0.d;	 Catch:{ all -> 0x0184 }
        if (r4 != r5) goto L_0x033d;
    L_0x032c:
        r4 = r6.b;	 Catch:{ all -> 0x0184 }
        if (r4 == 0) goto L_0x033d;
    L_0x0330:
        r4 = r6.b;	 Catch:{ all -> 0x0184 }
        r0 = r0.b;	 Catch:{ all -> 0x0184 }
        r0 = r4.equals(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x033d;
    L_0x033a:
        r0 = r1;
        goto L_0x027c;
    L_0x033d:
        r0 = r2;
        goto L_0x027c;
    L_0x0340:
        r5 = r2;
        goto L_0x027f;
    L_0x0343:
        r10 = com.loc.dm.b();	 Catch:{ all -> 0x0184 }
        r12 = r14.A;	 Catch:{ all -> 0x0184 }
        r10 = r10 - r12;
        r12 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r0 <= 0) goto L_0x0353;
    L_0x0350:
        r4 = r1;
        goto L_0x0286;
    L_0x0353:
        r4 = r2;
        goto L_0x0286;
    L_0x0356:
        r0 = r2;
        goto L_0x029f;
    L_0x0359:
        if (r2 != 0) goto L_0x0466;
    L_0x035b:
        r8 = com.loc.dm.b();	 Catch:{ all -> 0x0184 }
        r14.T = r8;	 Catch:{ all -> 0x0184 }
    L_0x0361:
        r0 = r14.R;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x0478;
    L_0x0365:
        r0 = r14.ag;	 Catch:{ all -> 0x0184 }
        r2 = r14.R;	 Catch:{ all -> 0x0184 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x0478;
    L_0x036f:
        r8 = com.loc.dm.a();	 Catch:{ all -> 0x0184 }
        r10 = r14.S;	 Catch:{ all -> 0x0184 }
        r8 = r8 - r10;
        r10 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 >= 0) goto L_0x046c;
    L_0x037c:
        r0 = r14.R;	 Catch:{ all -> 0x0184 }
        r14.ag = r0;	 Catch:{ all -> 0x0184 }
    L_0x0380:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0184 }
        r0.<init>();	 Catch:{ all -> 0x0184 }
        r2 = r14.ag;	 Catch:{ all -> 0x0184 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0184 }
        r2 = "&";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0184 }
        r2 = r14.Z;	 Catch:{ all -> 0x0184 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0184 }
        r2 = "&";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0184 }
        r2 = r14.Y;	 Catch:{ all -> 0x0184 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0184 }
        r0 = r0.toString();	 Catch:{ all -> 0x0184 }
        r14.ah = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.g;	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x04ca;
    L_0x03ad:
        if (r1 != 0) goto L_0x04ca;
    L_0x03af:
        if (r4 != 0) goto L_0x04ca;
    L_0x03b1:
        r0 = com.loc.cs.a();	 Catch:{ all -> 0x0184 }
        r2 = r14.ah;	 Catch:{ all -> 0x0184 }
        r3 = r14.q;	 Catch:{ all -> 0x0184 }
        r5 = r14.g;	 Catch:{ all -> 0x0184 }
        r0 = r0.a(r2, r3, r5);	 Catch:{ all -> 0x0184 }
    L_0x03bf:
        if (r4 != 0) goto L_0x03c7;
    L_0x03c1:
        r2 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r2 == 0) goto L_0x03c9;
    L_0x03c7:
        if (r1 == 0) goto L_0x0490;
    L_0x03c9:
        r0 = 0;
        r1 = 1;
        r0 = r14.a(r0, r1);	 Catch:{ all -> 0x0184 }
        r14.z = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x03ec;
    L_0x03d9:
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r1 = "new";
        r0.f = r1;	 Catch:{ all -> 0x0184 }
        r0 = r14.q;	 Catch:{ all -> 0x0184 }
        r0 = r0.toString();	 Catch:{ all -> 0x0184 }
        r14.U = r0;	 Catch:{ all -> 0x0184 }
        r14.V = r6;	 Catch:{ all -> 0x0184 }
        r14.j();	 Catch:{ all -> 0x0184 }
    L_0x03ec:
        r0 = com.loc.cs.a();	 Catch:{ all -> 0x0184 }
        r1 = r14.ah;	 Catch:{ all -> 0x0184 }
        r2 = r14.q;	 Catch:{ all -> 0x0184 }
        r3 = r14.z;	 Catch:{ all -> 0x0184 }
        r4 = r14.a;	 Catch:{ all -> 0x0184 }
        r5 = 1;
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0184 }
        r0 = com.loc.cv.a();	 Catch:{ all -> 0x0184 }
        r1 = r14.a;	 Catch:{ all -> 0x0184 }
        r2 = r14.ag;	 Catch:{ all -> 0x0184 }
        r3 = r14.z;	 Catch:{ all -> 0x0184 }
        r0.a(r1, r2, r3);	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x0453;
    L_0x0411:
        r0 = r14.ag;	 Catch:{ all -> 0x0184 }
        r1 = r14.q;	 Catch:{ all -> 0x0184 }
        r1 = r1.toString();	 Catch:{ all -> 0x0184 }
        r2 = r14.b;	 Catch:{ all -> 0x0184 }
        r3 = r14.a;	 Catch:{ all -> 0x0184 }
        r3 = r14.l();	 Catch:{ all -> 0x0184 }
        r0 = r14.a(r0, r1, r2, r3);	 Catch:{ all -> 0x0184 }
        r1 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r1 == 0) goto L_0x0453;
    L_0x042b:
        r1 = r14.q;	 Catch:{ all -> 0x0184 }
        r1 = r1.toString();	 Catch:{ all -> 0x0184 }
        r14.U = r1;	 Catch:{ all -> 0x0184 }
        r1 = r14.z;	 Catch:{ all -> 0x0184 }
        r14.z = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r2 = 8;
        r0.i = r2;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0184 }
        r3 = "离线定位，在线定位失败原因:";
        r2.<init>(r3);	 Catch:{ all -> 0x0184 }
        r1 = r1.h;	 Catch:{ all -> 0x0184 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0184 }
        r1 = r1.toString();	 Catch:{ all -> 0x0184 }
        r0.a(r1);	 Catch:{ all -> 0x0184 }
    L_0x0453:
        r0 = r14.q;	 Catch:{ all -> 0x0184 }
        r1 = 0;
        r2 = r14.q;	 Catch:{ all -> 0x0184 }
        r2 = r2.length();	 Catch:{ all -> 0x0184 }
        r0.delete(r1, r2);	 Catch:{ all -> 0x0184 }
        r0 = 0;
        r14.q = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        goto L_0x0038;
    L_0x0466:
        r8 = 0;
        r14.T = r8;	 Catch:{ all -> 0x0184 }
        goto L_0x0361;
    L_0x046c:
        r8 = com.loc.dm.a();	 Catch:{ all -> 0x0184 }
        r14.S = r8;	 Catch:{ all -> 0x0184 }
        r0 = r14.ag;	 Catch:{ all -> 0x0184 }
        r14.R = r0;	 Catch:{ all -> 0x0184 }
        goto L_0x0380;
    L_0x0478:
        r0 = r14.R;	 Catch:{ all -> 0x0184 }
        if (r0 != 0) goto L_0x0488;
    L_0x047c:
        r8 = com.loc.dm.a();	 Catch:{ all -> 0x0184 }
        r14.S = r8;	 Catch:{ all -> 0x0184 }
        r0 = r14.ag;	 Catch:{ all -> 0x0184 }
        r14.R = r0;	 Catch:{ all -> 0x0184 }
        goto L_0x0380;
    L_0x0488:
        r8 = com.loc.dm.a();	 Catch:{ all -> 0x0184 }
        r14.S = r8;	 Catch:{ all -> 0x0184 }
        goto L_0x0380;
    L_0x0490:
        if (r4 == 0) goto L_0x04b1;
    L_0x0492:
        r0 = 0;
        r1 = 1;
        r0 = r14.a(r0, r1);	 Catch:{ all -> 0x0184 }
        r14.z = r0;	 Catch:{ all -> 0x0184 }
        r0 = r14.z;	 Catch:{ all -> 0x0184 }
        r0 = com.loc.dm.a(r0);	 Catch:{ all -> 0x0184 }
        if (r0 == 0) goto L_0x03ec;
    L_0x04a2:
        r0 = r14.q;	 Catch:{ all -> 0x0184 }
        r0 = r0.toString();	 Catch:{ all -> 0x0184 }
        r14.U = r0;	 Catch:{ all -> 0x0184 }
        r14.V = r6;	 Catch:{ all -> 0x0184 }
        r14.j();	 Catch:{ all -> 0x0184 }
        goto L_0x03ec;
    L_0x04b1:
        r2 = 0;
        r14.T = r2;	 Catch:{ all -> 0x0184 }
        r1 = 4;
        r0.i = r1;	 Catch:{ all -> 0x0184 }
        r14.z = r0;	 Catch:{ all -> 0x0184 }
        r1 = 1;
        r0 = r0.b(r1);	 Catch:{ all -> 0x0184 }
        r14.b(r0);	 Catch:{ all -> 0x0184 }
        r14.j();	 Catch:{ all -> 0x0184 }
        goto L_0x03ec;
    L_0x04c7:
        r0 = move-exception;
        goto L_0x0066;
    L_0x04ca:
        r0 = r3;
        goto L_0x03bf;
    L_0x04cd:
        r1 = r2;
        goto L_0x02a0;
    L_0x04d0:
        r6 = r3;
        goto L_0x0268;
    L_0x04d3:
        r0 = r2;
        goto L_0x00d3;
    L_0x04d6:
        r4 = r8;
        goto L_0x00cc;
    L_0x04d9:
        r0 = r3;
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cb.a():com.autonavi.aps.amapapi.model.AmapLoc");
    }

    public final synchronized AmapLoc a(boolean z) throws Exception {
        AmapLoc amapLoc;
        if (this.X.length() > 0) {
            this.X.delete(0, this.X.length());
        }
        if (!this.ac) {
            i();
        }
        if (!this.ai) {
            x();
        }
        ck ckVar = null;
        try {
            if (!this.D) {
                ckVar = this.t.a();
            }
            ck ckVar2 = ckVar;
        } catch (Throwable th) {
            cq.a(th, "APS", "doFirstNetLocate");
            ckVar2 = null;
        }
        if (TextUtils.isEmpty(this.ag)) {
            amapLoc = new AmapLoc();
            amapLoc.a(this.m);
            amapLoc.a(this.X.toString());
        } else {
            amapLoc = a(false, z);
            if (dm.a(amapLoc)) {
                amapLoc.f = "new";
                this.U = this.q.toString();
                this.V = ckVar2;
                this.z = amapLoc;
                b(amapLoc.b(1));
                j();
            } else {
                String stringBuilder = this.q.toString();
                e(this.a);
                String str = this.ag;
                JSONObject jSONObject = this.b;
                Context context = this.a;
                AmapLoc a = a(str, stringBuilder, jSONObject, l());
                if (dm.a(a)) {
                    this.U = this.q.toString();
                    a.f = "file";
                    a.i = 8;
                    a.a("离线定位结果，在线定位失败原因:" + amapLoc.h);
                    this.z = a;
                    b(a.b(1));
                    amapLoc = a;
                }
            }
        }
        return amapLoc;
    }

    public final synchronized void a(AmapLoc amapLoc) {
        if (dm.a(amapLoc)) {
            cs.a().a(this.ah, this.q, amapLoc, this.a, true);
        }
    }

    public final void a(JSONObject jSONObject) {
        this.b = jSONObject;
        if (dm.a(jSONObject, "collwifiscan")) {
            try {
                Object string = jSONObject.getString("collwifiscan");
                if (TextUtils.isEmpty(string)) {
                    cq.h = 20;
                } else {
                    cq.h = Integer.parseInt(string) / 1000;
                }
            } catch (Throwable th) {
                cq.a(th, "APS", "setExtra");
            }
        }
        if (this.t != null) {
            this.t.g = jSONObject;
        }
        if (this.s != null) {
            this.s.b = jSONObject;
        }
    }

    public final synchronized void a(boolean z, Context context) {
        if ((this.H > 0 && !this.f) || (z && !this.f)) {
            if (this.d == null) {
                this.d = new cg(context.getApplicationContext());
                cg cgVar = this.d;
                cf cfVar = this.p;
                try {
                    cgVar.j = cfVar;
                    if (cgVar.d == null) {
                        cgVar.d = new cc(cgVar, cfVar);
                    }
                    if (cgVar.e == null) {
                        cgVar.e = new cd(cgVar);
                    }
                    if (cgVar.f == null) {
                        cgVar.f = new ce(cgVar);
                    }
                } catch (Throwable th) {
                    cq.a(th, "ConnectionServiceManager", "init");
                }
            }
            try {
                if (this.d != null) {
                    if (z) {
                        this.d.b();
                    } else {
                        this.d.a();
                    }
                }
                this.f = true;
            } catch (Throwable th2) {
                cq.a(th2, "APS", "bindService");
                this.f = true;
            }
        }
    }

    public final synchronized boolean a(Context context) {
        boolean z;
        if (this.a != null) {
            z = true;
        } else if (context == null) {
            z = false;
        } else {
            this.a = context.getApplicationContext();
            de.b(this.a);
            dm.b(this.a);
            if (this.s == null) {
                this.s = new co(this.a, (WifiManager) dm.a(this.a, "wifi"), this.b);
            }
            if (this.t == null) {
                this.t = new cn(this.a, this.b);
            }
            cs.a().a(this.a);
            z = true;
        }
        return z;
    }

    public final void b() {
        try {
            i();
            x();
            a(a(true, true));
        } catch (Throwable th) {
            cq.a(th, "APS", "doFusionLocation");
        }
    }

    public final synchronized boolean b(Context context) {
        boolean z;
        if (a(context)) {
            Context context2 = this.a;
            this.W = cz.a();
            if (this.r == null) {
                this.r = (ConnectivityManager) dm.a(this.a, "connectivity");
            }
            this.K = new dc();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void c() {
        this.ac = false;
        this.ai = false;
        this.i = false;
        cq.i = false;
        g();
        this.c = null;
        this.U = null;
        j();
        if (this.d != null) {
            cg cgVar = this.d;
            try {
                if (cgVar.g) {
                    cgVar.a.unbindService(cgVar.d);
                }
                if (cgVar.h) {
                    cgVar.a.unbindService(cgVar.e);
                }
                if (cgVar.i) {
                    cgVar.a.unbindService(cgVar.f);
                }
            } catch (Throwable th) {
                cq.a(th, "ConnectionServiceManager", "unbindService");
            }
            cgVar.c = null;
            cgVar.a = null;
            cgVar.c = null;
            cgVar.d = null;
            cgVar.e = null;
            cgVar.f = null;
            if (cgVar.j != null) {
                cgVar.j.a(-1);
            }
            cgVar.b = true;
            cgVar.g = false;
            cgVar.h = false;
            cgVar.i = false;
            this.d = null;
            this.f = false;
            this.e = -1;
        }
        u();
        try {
            cu.a().b(this.a);
        } catch (Throwable th2) {
            cq.a(th2, "APS", "destroy part");
        }
        ci.a().b();
        dm.g();
        try {
            if (!(this.a == null || this.x == null)) {
                this.a.unregisterReceiver(this.x);
            }
            this.x = null;
        } catch (Throwable th3) {
            this.x = null;
        }
        this.aa = false;
        if (this.t != null) {
            cn cnVar = this.t;
            if (!(cnVar.e == null || cnVar.h == null)) {
                try {
                    cnVar.e.listen(cnVar.h, 0);
                } catch (Throwable th22) {
                    cq.a(th22, "CgiManager", "destroy");
                }
            }
            cnVar.h = null;
            synchronized (cnVar.l) {
                cnVar.k = true;
            }
            if (cnVar.j != null) {
                cnVar.j.quit();
                cnVar.j = null;
            }
            cnVar.c.clear();
            cnVar.d = -113;
            cnVar.e = null;
            cnVar.f = null;
        }
        cv a = cv.a();
        cv a2 = cv.a();
        if (!a2.a.isEmpty()) {
            a2.a.clear();
        }
        a.b = false;
        a("stopOff");
        a("destroy");
        this.l = false;
        this.S = 0;
        p();
        if (this.u != null) {
            this.u.clear();
        }
        this.z = null;
        this.a = null;
        if (this.n != null) {
            this.n.clear();
            this.n = null;
        }
        ad = -1;
        this.c = null;
        this.O = null;
    }

    public final synchronized void c(Context context) {
        if (b(context)) {
            cq.i = true;
            e(this.a);
            this.C = dm.b();
            if (!this.aa) {
                k();
                this.aa = true;
            }
            cn cnVar = this.t;
            cnVar.c();
            if (!(cnVar.k || cnVar.e == null)) {
                try {
                    cnVar.b = dm.a(cnVar.m, cnVar.e.getCellLocation());
                } catch (Throwable th) {
                    cq.a(th, "CgiManager", "CgiManager");
                    cnVar.b = 9;
                }
                if (cnVar.j != null) {
                    cnVar.j.quit();
                    cnVar.j = null;
                }
                if (cnVar.j == null) {
                    cnVar.j = new cm(cnVar, "listenerPhoneStateThread");
                    cnVar.j.start();
                }
            }
            this.t.c();
            this.t.b();
            cv.a().a(this.a);
            this.i = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        monitor-enter(r6);
        r1 = ad;	 Catch:{ Throwable -> 0x0046 }
        r2 = -1;
        if (r1 == r2) goto L_0x002b;
    L_0x0007:
        r1 = r6.a;	 Catch:{ Throwable -> 0x0046 }
        if (r1 == 0) goto L_0x0044;
    L_0x000b:
        r2 = com.loc.dm.b();	 Catch:{ Throwable -> 0x0046 }
        r4 = r6.ae;	 Catch:{ Throwable -> 0x0046 }
        r2 = r2 - r4;
        r4 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x0044;
    L_0x0019:
        r2 = com.loc.dm.b();	 Catch:{ Throwable -> 0x0046 }
        r6.ae = r2;	 Catch:{ Throwable -> 0x0046 }
        r1 = r6.a;	 Catch:{ Throwable -> 0x0046 }
        r1 = com.loc.dm.e(r1);	 Catch:{ Throwable -> 0x0046 }
        r2 = r6.af;	 Catch:{ Throwable -> 0x0046 }
        if (r1 <= r2) goto L_0x0044;
    L_0x0029:
        if (r0 == 0) goto L_0x0042;
    L_0x002b:
        r0 = 1;
        ad = r0;	 Catch:{ Throwable -> 0x0046 }
        com.loc.de.a(r7);	 Catch:{ Throwable -> 0x0046 }
        r0 = com.loc.de.t();	 Catch:{ Throwable -> 0x0046 }
        r6.af = r0;	 Catch:{ Throwable -> 0x0046 }
        r0 = r6.af;	 Catch:{ Throwable -> 0x0046 }
        com.loc.dm.a(r7, r0);	 Catch:{ Throwable -> 0x0046 }
        r0 = com.loc.dm.b();	 Catch:{ Throwable -> 0x0046 }
        r6.ae = r0;	 Catch:{ Throwable -> 0x0046 }
    L_0x0042:
        monitor-exit(r6);
        return;
    L_0x0044:
        r0 = 0;
        goto L_0x0029;
    L_0x0046:
        r0 = move-exception;
        r1 = "APS";
        r2 = "initAuth";
        com.loc.cq.a(r0, r1, r2);	 Catch:{ all -> 0x004f }
        goto L_0x0042;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cb.d(android.content.Context):void");
    }

    final boolean d() {
        return this.c != null;
    }

    final boolean e() {
        boolean z = false;
        try {
            if (d()) {
                z = s();
            }
        } catch (Throwable th) {
            cq.a(th, "APS", "collStarted");
        }
        return z;
    }

    final void f() {
        if (!d() || !d() || t() <= 0) {
        }
    }

    final void g() {
        if (d() && e()) {
            cq.h = 20;
            try {
                dg.a(this.c, "destroy", new Object[0]);
            } catch (Throwable th) {
                cq.a(th, "APS", "stop3rdCM");
            }
        }
    }

    public final synchronized AmapLoc h() {
        AmapLoc amapLoc;
        if (this.X.length() > 0) {
            this.X.delete(0, this.X.length());
        }
        if (!this.ac) {
            i();
        }
        x();
        if (TextUtils.isEmpty(this.ag)) {
            amapLoc = new AmapLoc();
            amapLoc.a(this.m);
            amapLoc.a(this.X.toString());
        } else {
            amapLoc = cs.a().a(this.ah, this.q, this.g);
            if (dm.a(amapLoc)) {
                this.T = 0;
                amapLoc.i = 4;
                this.z = amapLoc;
                b(amapLoc.b(1));
                j();
            }
        }
        return amapLoc;
    }
}
