package com.loc;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.aps.amapapi.model.AmapLoc;

/* compiled from: ProGuard */
public final class h extends Handler {
    j a = null;

    public h(j jVar) {
        this.a = jVar;
    }

    public h(j jVar, Looper looper) {
        super(looper);
        this.a = jVar;
    }

    public final void handleMessage(Message message) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        AMapLocation aMapLocation = null;
        super.handleMessage(message);
        if (this.a != null) {
            AMapLocation aMapLocation2;
            Message obtain;
            switch (message.what) {
                case 1:
                    try {
                        Bundle data = message.getData();
                        this.a.B = 0;
                        if (data != null) {
                            data.setClassLoader(AmapLoc.class.getClassLoader());
                            AmapLoc amapLoc = (AmapLoc) data.getParcelable("location");
                            this.a.H = data.getInt("originalLocType", 0);
                            AMapLocation a = cq.a(amapLoc);
                            if (a == null) {
                                try {
                                    aMapLocation = new AMapLocation("");
                                } catch (Throwable th22) {
                                    th = th22;
                                    aMapLocation2 = a;
                                    cq.a(th, "AMapLocationManager$MHandler", "handleMessage LBS_LOCATIONSUCCESS");
                                    j.a(this.a, aMapLocation2);
                                    return;
                                }
                                try {
                                    aMapLocation.setErrorCode(8);
                                    aMapLocation2 = aMapLocation;
                                } catch (Throwable th222) {
                                    th3 = th222;
                                    aMapLocation2 = aMapLocation;
                                    th = th3;
                                    cq.a(th, "AMapLocationManager$MHandler", "handleMessage LBS_LOCATIONSUCCESS");
                                    j.a(this.a, aMapLocation2);
                                    return;
                                }
                            }
                            aMapLocation2 = a;
                            try {
                                aMapLocation2.setProvider("lbs");
                            } catch (Throwable th4) {
                                th = th4;
                                cq.a(th, "AMapLocationManager$MHandler", "handleMessage LBS_LOCATIONSUCCESS");
                                j.a(this.a, aMapLocation2);
                                return;
                            }
                        }
                        aMapLocation2 = null;
                    } catch (Throwable th2222) {
                        th3 = th2222;
                        aMapLocation2 = null;
                        th = th3;
                        cq.a(th, "AMapLocationManager$MHandler", "handleMessage LBS_LOCATIONSUCCESS");
                        j.a(this.a, aMapLocation2);
                        return;
                    }
                    j.a(this.a, aMapLocation2);
                    return;
                case 2:
                    try {
                        aMapLocation2 = (AMapLocation) message.obj;
                        try {
                            this.a.H = aMapLocation2.getLocationType();
                            if (aMapLocation2.getErrorCode() == 0) {
                                this.a.B = this.a.B + 1;
                                this.a.n = dm.b();
                                this.a.m = true;
                            }
                            aMapLocation = aMapLocation2;
                        } catch (Throwable th5) {
                            th3 = th5;
                            aMapLocation = aMapLocation2;
                            th2222 = th3;
                            cq.a(th2222, "AMapLocationManager$MHandler", "handleMessage GPS_LOCATIONSUCCESS");
                            if (this.a.i != null) {
                                j.a(this.a, 7);
                            }
                            j.a(this.a, aMapLocation);
                            return;
                        }
                    } catch (Throwable th6) {
                        th2222 = th6;
                        cq.a(th2222, "AMapLocationManager$MHandler", "handleMessage GPS_LOCATIONSUCCESS");
                        if (this.a.i != null) {
                            j.a(this.a, 7);
                        }
                        j.a(this.a, aMapLocation);
                        return;
                    }
                    try {
                        if (this.a.i != null) {
                            j.a(this.a, 7);
                        }
                    } catch (Throwable th22222) {
                        cq.a(th22222, "AMapLocationManager$MHandler", "MHandler:handleMessage GPS_LOCATIONSUCCESS:NGPS");
                    }
                    j.a(this.a, aMapLocation);
                    return;
                case 3:
                    this.a.m = false;
                    return;
                case 5:
                    this.a.n = dm.b();
                    this.a.m = true;
                    return;
                case 100:
                    try {
                        j.g(this.a);
                        return;
                    } catch (Throwable th222222) {
                        cq.a(th222222, "AMapLocationManager$MHandler", "handleMessage FASTSKY");
                        return;
                    }
                case 103:
                    try {
                        j.a(this.a, (Intent) message.obj);
                        return;
                    } catch (Throwable th2222222) {
                        cq.a(th2222222, "AMapLocationManager$MHandler", "handleMessage START_SERVICE");
                        return;
                    }
                case 1002:
                    try {
                        j.a(this.a, (AMapLocationListener) message.obj);
                        return;
                    } catch (Throwable th22222222) {
                        cq.a(th22222222, "AMapLocationManage$MHandlerr", "handleMessage SET_LISTENER");
                        return;
                    }
                case 1003:
                    try {
                        j.h(this.a);
                        return;
                    } catch (Throwable th222222222) {
                        cq.a(th222222222, "AMapLocationManager$MHandler", "handleMessage START_LOCATION");
                        return;
                    }
                case 1004:
                    try {
                        this.a.h();
                        return;
                    } catch (Throwable th2222222222) {
                        cq.a(th2222222222, "AMapLocationManager$MHandler", "handleMessage STOP_LOCATION");
                        return;
                    }
                case 1005:
                    try {
                        j.b(this.a, (AMapLocationListener) message.obj);
                        return;
                    } catch (Throwable th22222222222) {
                        cq.a(th22222222222, "AMapLocationManager$MHandler", "handleMessage REMOVE_LISTENER");
                        return;
                    }
                case 1006:
                    try {
                        j.a(this.a, (Fence) message.obj);
                        return;
                    } catch (Throwable th222222222222) {
                        cq.a(th222222222222, "AMapLocationManager$MHandler", "handleMessage ADD_GEOFENCE");
                        return;
                    }
                case 1007:
                    try {
                        j.a(this.a, (PendingIntent) message.obj);
                        return;
                    } catch (Throwable th2222222222222) {
                        cq.a(th2222222222222, "AMapLocationManager$MHandler", "handleMessage REMOVE_GEOFENCE");
                        return;
                    }
                case 1008:
                    try {
                        obtain = Message.obtain();
                        obtain.what = 2;
                        if (this.a.i != null) {
                            this.a.l = 0;
                            this.a.i.send(obtain);
                            return;
                        }
                        j jVar = this.a;
                        jVar.l++;
                        if (this.a.l < 10) {
                            this.a.b.sendEmptyMessageDelayed(1008, 50);
                            return;
                        }
                        return;
                    } catch (Throwable th22222222222222) {
                        cq.a(th22222222222222, "AMapLocationManager$MHandler", "handleMessage START_SOCKET");
                        return;
                    }
                case 1009:
                    try {
                        obtain = Message.obtain();
                        obtain.what = 3;
                        if (this.a.i != null) {
                            this.a.i.send(obtain);
                            return;
                        }
                        return;
                    } catch (Throwable th222222222222222) {
                        cq.a(th222222222222222, "AMapLocationManager$MHandler", "handleMessage STOP_SOCKET");
                        return;
                    }
                case 1010:
                    try {
                        j.b(this.a, (Fence) message.obj);
                        return;
                    } catch (Throwable th2222222222222222) {
                        cq.a(th2222222222222222, "AMapLocationManager$MHandler", "handleMessage REMOVE_GEOFENCE_ONE");
                        return;
                    }
                case 1011:
                    try {
                        j.j(this.a);
                        this.a = null;
                        return;
                    } catch (Throwable th22222222222222222) {
                        cq.a(th22222222222222222, "AMapLocationManager$MHandler", "handleMessage DESTROY");
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
