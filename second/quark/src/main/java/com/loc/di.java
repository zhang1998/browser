package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AmapLoc;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class di {
    public static synchronized void a(Context context, int i, AMapLocation aMapLocation) {
        Object obj = null;
        Object obj2 = 1;
        synchronized (di.class) {
            if (!(context == null || aMapLocation == null)) {
                try {
                    if (de.o()) {
                        Object obj3 = "net";
                        int i2 = aMapLocation.getErrorCode() == 0 ? 1 : 0;
                        int i3;
                        switch (i) {
                            case 2:
                            case 4:
                            case 7:
                            case 8:
                                obj3 = "cache";
                                i3 = 1;
                                break;
                            case 5:
                            case 6:
                                obj3 = "net";
                                i3 = 1;
                                break;
                        }
                        if (aMapLocation.getErrorCode() != 0) {
                            switch (aMapLocation.getErrorCode()) {
                                case 4:
                                case 5:
                                case 6:
                                case 11:
                                    obj3 = "net";
                                    break;
                            }
                        }
                        obj2 = obj;
                        if (obj2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_int_first", i2);
                            jSONObject.put("param_string_first", obj3);
                            a(context, "O005", jSONObject);
                        }
                    }
                } catch (Throwable th) {
                    cq.a(th, "ReportUtil", "reportBatting");
                }
            }
        }
    }

    public static synchronized void a(Context context, dh dhVar) {
        Object obj = 1;
        Object obj2 = null;
        synchronized (di.class) {
            if (context != null) {
                try {
                    if (de.o()) {
                        int intValue;
                        AmapLoc amapLoc = dhVar.c;
                        int intValue2 = Long.valueOf(dhVar.b - dhVar.a).intValue();
                        Object obj3 = "net";
                        if (amapLoc != null) {
                            intValue = Long.valueOf(amapLoc.D).intValue();
                            switch (amapLoc.i) {
                                case 1:
                                    obj = null;
                                    break;
                                case 2:
                                case 4:
                                    obj3 = "cache";
                                    int i = 1;
                                    break;
                                case 5:
                                case 6:
                                    obj3 = "net";
                                    break;
                            }
                        }
                        intValue = 0;
                        if (obj != null) {
                            JSONObject jSONObject;
                            if (obj2 == null) {
                                jSONObject = new JSONObject();
                                jSONObject.put("param_int_first", intValue);
                                jSONObject.put("param_int_second", intValue2);
                                a(context, "O003", jSONObject);
                            }
                            jSONObject = new JSONObject();
                            jSONObject.put("param_int_first", intValue2);
                            jSONObject.put("param_string_first", obj3);
                            a(context, "O002", jSONObject);
                        }
                    }
                } catch (Throwable th) {
                    cq.a(th, "ReportUtil", "reportLBSLocUseTime");
                }
            }
        }
    }

    private static synchronized void a(Context context, String str, JSONObject jSONObject) {
        synchronized (di.class) {
            try {
                bu buVar = new bu(context, "loc", "2.8.0", str);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2) || jSONObject2.length() > 65536) {
                    throw new dw("无效的参数 - IllegalArgumentException");
                }
                buVar.a = jSONObject2;
                bw.a(buVar, context);
            } catch (Throwable th) {
                cq.a(th, "ReportUtil", "applyStatistics");
            }
        }
        return;
    }

    public static synchronized void a(String str, String str2) {
        synchronized (di.class) {
            try {
                fa.b(cq.a("loc", "2.8.0"), str2, str);
            } catch (Throwable th) {
                cq.a(th, "ReportUtil", "reportLog");
            }
        }
    }

    public static synchronized void b(Context context, dh dhVar) {
        synchronized (di.class) {
            if (context != null) {
                try {
                    if (de.o()) {
                        int intValue = Long.valueOf(dhVar.b - dhVar.a).intValue();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("param_int_first", intValue);
                        a(context, "O004", jSONObject);
                    }
                } catch (Throwable th) {
                    cq.a(th, "ReportUtil", "reportGPSLocUseTime");
                }
            }
        }
    }
}
