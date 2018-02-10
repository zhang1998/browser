package com.loc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import com.UCMobile.Apollo.MediaPlayer;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class j implements LocationManagerBase {
    public static boolean r = false;
    boolean A = false;
    private int B = 0;
    private boolean C = false;
    private Context D;
    private boolean E = false;
    private boolean F = true;
    private JSONArray G = null;
    private int H = 0;
    private ServiceConnection I = new b(this);
    private LinkedList<f> J = new LinkedList();
    private LinkedList<f> K = new LinkedList();
    private int L = 0;
    private AMapLocation M = null;
    private JSONObject N = new JSONObject();
    AMapLocationClientOption a;
    public h b;
    dq c = null;
    ArrayList<AMapLocationListener> d = new ArrayList();
    do e;
    boolean f = false;
    public boolean g = true;
    ds h;
    Messenger i = null;
    Messenger j = null;
    Intent k = null;
    int l = 0;
    boolean m = false;
    long n = 0;
    AMapLocation o = null;
    long p = 0;
    long q = 0;
    ScheduledExecutorService s = Executors.newScheduledThreadPool(3);
    i t = null;
    g u = null;
    ScheduledFuture<Messenger> v = null;
    ScheduledFuture<?> w = null;
    Future<?> x = null;
    Callable<Messenger> y = new a(this);
    boolean z = false;

    public j(Context context, Intent intent) {
        this.D = context;
        this.k = intent;
        if (cq.b()) {
            try {
                dj.a(this.D, cq.a("loc", "2.8.0"));
            } catch (Throwable th) {
            }
        }
        if (Looper.myLooper() == null) {
            this.b = new h(this, this.D.getMainLooper());
        } else {
            this.b = new h(this);
        }
        Message obtain = Message.obtain();
        obtain.what = 103;
        obtain.obj = this.k;
        this.b.sendMessage(obtain);
        try {
            if (this.v == null || this.v.isCancelled()) {
                this.v = this.s.schedule(this.y, 0, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th2) {
            cq.a(th2, "AMapLocationManager", "doGetServiceMessengerFuture");
        }
        this.h = new ds(this.D);
        this.j = new Messenger(this.b);
        this.c = new dq(this.D, this.b);
        try {
            this.e = new do(this.D);
        } catch (Throwable th22) {
            cq.a(th22, "AMapLocationManager", "init");
        }
        this.t = new i(this);
        this.u = new g(this);
    }

    private static f a(AMapLocation aMapLocation, int i) {
        return new f(aMapLocation, i);
    }

    private void a(long j) {
        try {
            if (this.w == null || this.w.isCancelled()) {
                this.w = this.s.scheduleAtFixedRate(this.t, j, this.a.getInterval(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "startNetLocationTask");
        }
    }

    private void a(AMapLocation aMapLocation) {
        try {
            if ("gps".equals(aMapLocation.getProvider()) || e()) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        ((AMapLocationListener) it.next()).onLocationChanged(aMapLocation);
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void a(cb cbVar, boolean z) {
        try {
            if (!this.A) {
                try {
                    Object apikey = AMapLocationClientOption.getAPIKEY();
                    if (!TextUtils.isEmpty(apikey)) {
                        ee.a(apikey);
                    }
                    this.N.put("netloc", SettingsConst.FALSE);
                    this.N.put("gpsstatus", SettingsConst.FALSE);
                    this.N.put("nbssid", SettingsConst.FALSE);
                    this.N.put("wait1stwifi", SettingsConst.FALSE);
                    this.N.put("autoup", SettingsConst.FALSE);
                    this.N.put("upcolmobile", 1);
                    this.N.put("enablegetreq", 1);
                    this.N.put("reversegeo", this.a.isNeedAddress());
                    this.N.put("isOffset", this.a.isOffset());
                    this.N.put("wifiactivescan", this.a.isWifiActiveScan() ? SettingsConst.TRUE : SettingsConst.FALSE);
                    this.N.put("httptimeout", this.a.getHttpTimeOut());
                    this.N.put("isLocationCacheEnable", this.a.isLocationCacheEnable());
                    this.N.put("isOnceLocationLatest", this.a.isOnceLocationLatest());
                } catch (Throwable th) {
                    cq.a(th, "AMapLocationManager", "initAPSBase 2");
                }
                this.A = true;
            }
            if (!z) {
                this.N.put("key", dx.f(this.D));
                this.N.put("User-Agent", "AMAP_Location_SDK_Android 2.8.0");
            }
        } catch (Throwable th2) {
            cq.a(th2, "AMapLocationManager", "initAPS part3");
            return;
        }
        cbVar.a(this.N);
        if (z) {
            cbVar.a(this.D);
        } else {
            cbVar.b(this.D);
        }
    }

    private boolean a() {
        try {
            if (!(this.v == null || this.v.isDone() || this.v.isCancelled())) {
                this.i = (Messenger) this.v.get(5000, TimeUnit.MILLISECONDS);
            }
            if (this.v != null) {
                this.v.cancel(true);
                this.v = null;
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "checkAPSManager");
            return false;
        }
        if (this.i != null) {
            return true;
        }
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        Parcelable amapLoc = new AmapLoc();
        amapLoc.a(10);
        amapLoc.a("请检查配置文件是否配置服务");
        bundle.putParcelable("location", amapLoc);
        obtain.setData(bundle);
        obtain.what = 1;
        if (this.b != null) {
            this.b.sendMessage(obtain);
        }
        return false;
    }

    private void b() {
        try {
            if (!this.a.getLocationMode().equals(AMapLocationMode.Hight_Accuracy)) {
                d();
            }
            if (this.x == null || this.x.isCancelled()) {
                this.x = this.s.submit(this.u);
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "deviceSensorsLocation");
        }
    }

    private void c() {
        try {
            if (this.x != null) {
                this.x.cancel(false);
                this.x = null;
            }
            dq dqVar = this.c;
            if (dqVar.c != null) {
                if (dqVar.k != null) {
                    dqVar.c.removeUpdates(dqVar.k);
                }
                dqVar.h = 0;
                dqVar.i = false;
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "stopGPSLocationTask");
        }
    }

    private void d() {
        try {
            if (this.w != null) {
                this.w.cancel(false);
                this.w = null;
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "stopNetLocationTask");
        }
    }

    private boolean e() {
        return dm.b() - this.n > 10000;
    }

    private synchronized void f() {
        try {
            if (de.o()) {
                if (this.G != null && this.G.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("detail", this.G);
                    bt.a(new br(this.D, cq.a("loc", "2.8.0"), jSONObject.toString()), this.D);
                    this.G = null;
                }
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "writeOfflineLog");
        }
    }

    private void g() {
        Intent intent;
        try {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", de.l()));
            intent.setFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
            intent.setData(Uri.parse(de.j()));
            this.D.startActivity(intent);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "callAMap part2");
        }
    }

    private void h() {
        try {
            c();
            d();
            this.J.clear();
            this.K.clear();
            f();
            this.m = false;
            this.F = true;
            this.n = 0;
            this.l = 0;
            this.o = null;
            this.p = 0;
            this.C = false;
            this.L = 0;
            this.B = 0;
            this.M = null;
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "stopLocation");
        }
    }

    static /* synthetic */ void j(j jVar) {
        jVar.g = true;
        jVar.E = false;
        jVar.h();
        jVar.h.b();
        jVar.h = null;
        if (jVar.e != null) {
            jVar.e.b.clear();
        }
        if (jVar.I != null) {
            jVar.D.unbindService(jVar.I);
        }
        if (jVar.d != null) {
            jVar.d.clear();
            jVar.d = null;
        }
        if (jVar.v != null) {
            jVar.v.cancel(true);
            jVar.v = null;
        }
        jVar.s.shutdownNow();
        jVar.I = null;
        if (jVar.b != null) {
            jVar.b.removeCallbacksAndMessages(null);
        }
    }

    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.b = str;
            fence.d = d;
            fence.c = d2;
            fence.e = f;
            fence.a = pendingIntent;
            fence.a(j);
            obtain.obj = fence;
            obtain.what = 1006;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "addGeoFenceAlert");
        }
    }

    public AMapLocation getLastKnownLocation() {
        AMapLocation aMapLocation = null;
        try {
            aMapLocation = this.h.a();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public boolean isStarted() {
        return this.E;
    }

    public void onDestroy() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1011;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "onDestroy");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            obtain.obj = pendingIntent;
            obtain.what = 1007;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "removeGeoFenceAlert 2");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.b = str;
            fence.a = pendingIntent;
            obtain.obj = fence;
            obtain.what = 1010;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "removeGeoFenceAlert 1");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                cq.a(th, "AMapLocationManager", "setLocationListener");
                return;
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 1002;
        obtain.obj = aMapLocationListener;
        this.b.sendMessage(obtain);
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (!(this.F || this.a == null || this.a.getInterval() == aMapLocationClientOption.getInterval())) {
                this.a = aMapLocationClientOption.clone();
                d();
                c();
                a(0);
                if (!this.a.getLocationMode().equals(AMapLocationMode.Battery_Saving)) {
                    b();
                }
            }
            this.a = aMapLocationClientOption.clone();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "setLocationOption");
        }
    }

    public void startAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1008;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "startAssistantLocation");
        }
    }

    public void startLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1003;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1009;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1004;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1005;
            obtain.obj = aMapLocationListener;
            this.b.sendMessage(obtain);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "unRegisterLocationListener");
        }
    }

    static /* synthetic */ void b(j jVar) {
        boolean z;
        Message obtain;
        Bundle bundle;
        dh dhVar = new dh();
        AmapLoc amapLoc = null;
        dhVar.a = dm.b();
        cb cbVar = new cb();
        if (jVar.a.isLocationCacheEnable()) {
            jVar.a(cbVar, true);
            try {
                amapLoc = cbVar.h();
            } catch (Throwable th) {
                cq.a(th, "AMapLocationManager", "doAPSLocation:doFirstCacheLocate");
            }
        }
        if (amapLoc == null || !dm.a(amapLoc)) {
            jVar.a(cbVar, false);
            try {
                amapLoc = cbVar.a(false);
                z = true;
            } catch (Throwable th2) {
                cq.a(th2, "AMapLocationManager", "doAPSLocation:doFirstNetLocate");
            }
            dhVar.b = dm.b();
            dhVar.c = amapLoc;
            obtain = Message.obtain();
            bundle = new Bundle();
            bundle.putParcelable("location", amapLoc);
            if (amapLoc == null) {
                bundle.putInt("originalLocType", amapLoc.i);
            } else {
                bundle.putInt("originalLocType", 0);
            }
            obtain.setData(bundle);
            obtain.what = 1;
            if (jVar.b != null) {
                jVar.b.sendMessage(obtain);
            }
            di.a(jVar.D, dhVar);
            if (z) {
                try {
                    jVar.a(cbVar, false);
                    amapLoc = cbVar.a(true);
                } catch (Throwable th22) {
                    cq.a(th22, "AMapLocationManager", "doAPSLocation:doFirstNetLocate 2");
                }
                if (amapLoc.g == 0) {
                    try {
                        cbVar.a(amapLoc);
                    } catch (Throwable th3) {
                        cq.a(th3, "AMapLocationManager", "doAPSLocation:doFirstAddCache");
                    }
                }
            }
            cbVar.c();
        }
        z = false;
        dhVar.b = dm.b();
        dhVar.c = amapLoc;
        obtain = Message.obtain();
        bundle = new Bundle();
        bundle.putParcelable("location", amapLoc);
        if (amapLoc == null) {
            bundle.putInt("originalLocType", 0);
        } else {
            bundle.putInt("originalLocType", amapLoc.i);
        }
        obtain.setData(bundle);
        obtain.what = 1;
        if (jVar.b != null) {
            jVar.b.sendMessage(obtain);
        }
        try {
            di.a(jVar.D, dhVar);
        } catch (Throwable th4) {
        }
        if (z) {
            jVar.a(cbVar, false);
            amapLoc = cbVar.a(true);
            if (amapLoc.g == 0) {
                cbVar.a(amapLoc);
            }
        }
        cbVar.c();
    }

    static /* synthetic */ void a(j jVar, int i) {
        try {
            Message obtain = Message.obtain();
            obtain.what = i;
            Bundle bundle = new Bundle();
            bundle.putBoolean("wifiactivescan", jVar.a.isWifiActiveScan());
            bundle.putBoolean("isNeedAddress", jVar.a.isNeedAddress());
            bundle.putBoolean("isKillProcess", jVar.a.isKillProcess());
            bundle.putBoolean("isOffset", jVar.a.isOffset());
            bundle.putLong("httptimeout", jVar.a.getHttpTimeOut());
            bundle.putBoolean("isLocationCacheEnable", jVar.a.isLocationCacheEnable());
            obtain.setData(bundle);
            obtain.replyTo = jVar.j;
            if (jVar.i != null) {
                jVar.i.send(obtain);
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "sendLocMessage");
        }
    }

    static /* synthetic */ void a(j jVar, AMapLocation aMapLocation) {
        try {
            if (jVar.e != null) {
                do doVar = jVar.e;
                if (!doVar.b.isEmpty()) {
                    Iterator it = doVar.b.entrySet().iterator();
                    while (it != null && it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        Iterator it2 = ((ArrayList) entry.getValue()).iterator();
                        while (it2.hasNext()) {
                            Fence fence = (Fence) it2.next();
                            if (!do.a(fence)) {
                                float a = dm.a(new double[]{fence.d, fence.c, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                                float accuracy = aMapLocation.getAccuracy();
                                if (accuracy >= 500.0f) {
                                    accuracy = a - (fence.e + 500.0f);
                                } else {
                                    accuracy = a - (accuracy + fence.e);
                                }
                                Object obj = null;
                                if (accuracy > 0.0f) {
                                    if (fence.f != 0) {
                                        obj = 1;
                                    }
                                    fence.f = 0;
                                } else {
                                    if (fence.f != 1) {
                                        obj = 1;
                                    }
                                    fence.f = 1;
                                }
                                if (obj != null) {
                                    switch (fence.f) {
                                        case 0:
                                            fence.g = -1;
                                            if ((fence.a() & 2) != 2) {
                                                break;
                                            }
                                            doVar.a((PendingIntent) entry.getKey(), fence, 2);
                                            break;
                                        case 1:
                                            fence.g = dm.b();
                                            if ((fence.a() & 1) != 1) {
                                                break;
                                            }
                                            doVar.a((PendingIntent) entry.getKey(), fence, 1);
                                            break;
                                        default:
                                            break;
                                    }
                                } else if ((fence.a() & 4) == 4 && fence.g > 0 && dm.b() - fence.g > fence.c()) {
                                    fence.g = dm.b();
                                    doVar.a((PendingIntent) entry.getKey(), fence, 4);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager", "handlerLocation part3");
            return;
        }
        try {
            if (!jVar.F) {
                Object obj2;
                long time = aMapLocation.getTime();
                if (aMapLocation.getErrorCode() == 0) {
                    AMapLocation aMapLocation2;
                    AMapLocation aMapLocation3 = jVar.o;
                    jVar.M = aMapLocation;
                    long b = dm.b();
                    obj2 = null;
                    if (aMapLocation3 == null || aMapLocation3.getLocationType() != 1 || jVar.B <= 3 || aMapLocation.getAccuracy() < 0.0f || aMapLocation.getSpeed() < 0.0f) {
                        if (aMapLocation.getAccuracy() < 0.0f) {
                            aMapLocation.setAccuracy(0.0f);
                        }
                        if (aMapLocation.getSpeed() < 0.0f) {
                            aMapLocation.setSpeed(0.0f);
                        }
                        jVar.q = 0;
                        jVar.L = 0;
                        aMapLocation2 = aMapLocation;
                    } else {
                        if (aMapLocation.getLocationType() == 1) {
                            if (b - jVar.p < 5000) {
                                if (dm.a(new double[]{aMapLocation3.getLatitude(), aMapLocation3.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) > ((((aMapLocation3.getSpeed() + aMapLocation.getSpeed()) * ((float) (aMapLocation.getTime() - aMapLocation3.getTime()))) / 2000.0f) + (2.0f * (aMapLocation3.getAccuracy() + aMapLocation.getAccuracy()))) + 3000.0f) {
                                    obj2 = 1;
                                }
                            } else {
                                jVar.B = 0;
                            }
                        } else if (jVar.K != null && jVar.K.isEmpty()) {
                            jVar.J.clear();
                        }
                        if (obj2 != null) {
                            if (jVar.q == 0) {
                                jVar.q = dm.b();
                            }
                            if (b - jVar.q < 30000) {
                                jVar.C = true;
                                jVar.L = 1;
                                aMapLocation2 = aMapLocation3;
                            }
                        }
                        jVar.q = 0;
                        jVar.L = 0;
                        aMapLocation2 = aMapLocation;
                    }
                    f a2 = a(aMapLocation2, jVar.L);
                    f a3 = a(jVar.M, jVar.L);
                    if (jVar.C) {
                        if (jVar.L == 0) {
                            if (!(jVar.J.contains(a2) || jVar.K.contains(a2))) {
                                jVar.K.add(a2);
                            }
                        } else if (!jVar.K.contains(a3)) {
                            jVar.K.add(a3);
                        }
                    } else if (!jVar.J.contains(a2)) {
                        if (jVar.J.size() >= 5) {
                            jVar.J.removeFirst();
                        }
                        jVar.J.add(a2);
                    }
                    if (jVar.J.size() + jVar.K.size() >= 10) {
                        jVar.J.addAll(jVar.K);
                        StringBuffer stringBuffer = new StringBuffer();
                        Iterator it3 = jVar.J.iterator();
                        while (it3.hasNext()) {
                            stringBuffer.append(((f) it3.next()).toString());
                            stringBuffer.append("#");
                        }
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        di.a("gpsstatistics", stringBuffer.toString());
                        jVar.J.clear();
                        jVar.K.clear();
                        jVar.C = false;
                    }
                }
                jVar.p = dm.b();
                jVar.o = aMapLocation;
                aMapLocation.setTime(time);
                jVar.a(aMapLocation);
                jVar.h.a(aMapLocation);
                try {
                    if (de.o()) {
                        int i = 0;
                        switch (jVar.H) {
                            case 1:
                                obj2 = 1;
                                i = 0;
                                break;
                            case 2:
                            case 4:
                            case 8:
                                obj2 = 1;
                                i = 1;
                                break;
                            default:
                                obj2 = null;
                                break;
                        }
                        if (obj2 != null) {
                            if (jVar.G == null) {
                                jVar.G = new JSONArray();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("lon", aMapLocation.getLongitude());
                            jSONObject.put("lat", aMapLocation.getLatitude());
                            jSONObject.put("type", i);
                            jSONObject.put("timestamp", dm.a());
                            jVar.G = jVar.G.put(jSONObject);
                            if (jVar.G.length() >= 10) {
                                jVar.f();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    cq.a(th2, "AMapLocationManager", "handlerOfflineLog");
                }
                di.a(jVar.D, jVar.H, aMapLocation);
            }
        } catch (Throwable th22) {
            cq.a(th22, "AMapLocationManager", "handlerLocation part2");
        }
        dj.b(jVar.D);
        if (cq.b() && aMapLocation == null) {
            dj.a(jVar.D, "loc", "amaplocation is null");
        } else if (jVar.a.isOnceLocation()) {
            jVar.stopLocation();
        }
    }

    static /* synthetic */ void g(j jVar) {
        Object obj = 1;
        Object obj2 = null;
        try {
            if (jVar.D.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                obj2 = 1;
            } else if (jVar.D instanceof Activity) {
                int i = 1;
                obj = null;
            } else {
                obj = null;
            }
            if (obj2 != null) {
                Builder builder = new Builder(jVar.D);
                builder.setMessage(de.g());
                if (!("".equals(de.h()) || de.h() == null)) {
                    builder.setPositiveButton(de.h(), new c(jVar));
                }
                builder.setNegativeButton(de.i(), new d(jVar));
                AlertDialog create = builder.create();
                if (obj != null) {
                    create.getWindow().setType(2003);
                }
                create.setCanceledOnTouchOutside(false);
                create.show();
                return;
            }
            jVar.g();
        } catch (Throwable th) {
            jVar.g();
            cq.a(th, "AMapLocationManager", "showDialog");
        }
    }

    static /* synthetic */ void a(j jVar, Intent intent) {
        String str;
        if (intent == null) {
            try {
                intent = new Intent(jVar.D, APSService.class);
            } catch (Throwable th) {
                cq.a(th, "AMapLocationManager", "startServiceImpl");
                return;
            }
        }
        String str2 = "";
        str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : dx.f(jVar.D);
        intent.putExtra("apiKey", str);
        str = dx.e(jVar.D);
        intent.putExtra("packageName", jVar.D.getPackageName());
        intent.putExtra("sha1AndPackage", str);
        jVar.D.bindService(intent, jVar.I, 1);
    }

    static /* synthetic */ void a(j jVar, AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (jVar.d == null) {
            jVar.d = new ArrayList();
        }
        if (!jVar.d.contains(aMapLocationListener)) {
            jVar.d.add(aMapLocationListener);
        }
    }

    static /* synthetic */ void b(j jVar, AMapLocationListener aMapLocationListener) {
        if (!jVar.d.isEmpty() && jVar.d.contains(aMapLocationListener)) {
            jVar.d.remove(aMapLocationListener);
        }
        if (jVar.d.isEmpty()) {
            jVar.stopLocation();
        }
    }

    static /* synthetic */ void h(j jVar) {
        long j = 0;
        if (jVar.a == null) {
            jVar.a = new AMapLocationClientOption();
        }
        jVar.F = false;
        switch (e.a[jVar.a.getLocationMode().ordinal()]) {
            case 1:
                try {
                    jVar.c();
                    jVar.a(0);
                    return;
                } catch (Throwable th) {
                    cq.a(th, "AMapLocationManager", "batterySavingLocaiton");
                    return;
                }
            case 2:
                jVar.b();
                return;
            case 3:
                try {
                    jVar.b();
                    if (jVar.a.isGpsFirst()) {
                        j = 30000;
                    }
                    jVar.a(j);
                    return;
                } catch (Throwable th2) {
                    cq.a(th2, "AMapLocationManager", "hightAccuracyLocation");
                    return;
                }
            default:
                return;
        }
    }

    static /* synthetic */ void a(j jVar, Fence fence) {
        if (fence != null && jVar.e != null) {
            do doVar = jVar.e;
            PendingIntent pendingIntent = fence.a;
            if (pendingIntent != null && fence != null && !TextUtils.isEmpty(fence.b) && fence.e >= 100.0f && fence.e <= 1000.0f) {
                if ((doVar.b.isEmpty() || doVar.b.containsKey(pendingIntent)) && fence.a() != 0 && fence.a() <= 7) {
                    Iterator it = doVar.b.entrySet().iterator();
                    int i = 0;
                    while (it != null && it.hasNext()) {
                        i = ((ArrayList) ((Entry) it.next()).getValue()).size() + i;
                    }
                    if (i <= 20) {
                        fence.f = -1;
                        ArrayList arrayList;
                        if (doVar.b.isEmpty()) {
                            arrayList = new ArrayList();
                            arrayList.add(fence);
                            doVar.b.put(pendingIntent, arrayList);
                            return;
                        }
                        arrayList = (ArrayList) doVar.b.get(pendingIntent);
                        Fence fence2 = null;
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Fence fence3 = (Fence) it2.next();
                            if (!fence3.b.equals(fence.b)) {
                                fence3 = fence2;
                            }
                            fence2 = fence3;
                        }
                        if (fence2 != null) {
                            arrayList.remove(fence2);
                        }
                        arrayList.add(fence);
                        doVar.b.put(pendingIntent, arrayList);
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(j jVar, PendingIntent pendingIntent) {
        if (pendingIntent != null && jVar.e != null) {
            do doVar = jVar.e;
            if (pendingIntent != null && doVar.b.containsKey(pendingIntent)) {
                doVar.b.remove(pendingIntent);
            }
        }
    }

    static /* synthetic */ void b(j jVar, Fence fence) {
        if (fence != null && jVar.e != null) {
            do doVar = jVar.e;
            PendingIntent pendingIntent = fence.a;
            CharSequence charSequence = fence.b;
            if (pendingIntent != null && doVar.b.containsKey(pendingIntent) && !TextUtils.isEmpty(charSequence)) {
                List arrayList = new ArrayList();
                arrayList.add(charSequence);
                doVar.a(pendingIntent, arrayList);
            }
        }
    }
}
