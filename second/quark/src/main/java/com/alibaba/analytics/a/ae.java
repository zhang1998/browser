package com.alibaba.analytics.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.analytics.core.d.e;
import com.alibaba.analytics.core.model.LogField;
import com.e.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ae {
    private static Map<String, String> a = null;

    public static synchronized void a() {
        synchronized (ae.class) {
            if (a != null) {
                try {
                    String[] b = e.b();
                    a.put(LogField.ACCESS.toString(), b[0]);
                    if (b[0].equals("2G/3G")) {
                        a.put(LogField.ACCESS_SUBTYPE.toString(), b[1]);
                    } else {
                        a.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
                    }
                } catch (Exception e) {
                    a.put(LogField.ACCESS.toString(), "Unknown");
                    a.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
                }
            }
        }
    }

    public static synchronized Map<String, String> a(Context context) {
        Map<String, String> map = null;
        boolean z = true;
        synchronized (ae.class) {
            if (a != null) {
                map = a;
            } else if (context != null) {
                Map<String, String> hashMap = new HashMap();
                try {
                    hashMap.put(LogField.UTDID.toString(), a.a(context));
                    try {
                        hashMap.put(LogField.IMEI.toString(), v.a(context));
                        hashMap.put(LogField.IMSI.toString(), v.b(context));
                        hashMap.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
                        hashMap.put(LogField.BRAND.toString(), Build.BRAND);
                        hashMap.put(LogField.OSVERSION.toString(), VERSION.RELEASE);
                        hashMap.put(LogField.OS.toString(), "a");
                        try {
                            hashMap.put(LogField.APPVERSION.toString(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
                        } catch (NameNotFoundException e) {
                            hashMap.put(LogField.APPVERSION.toString(), "Unknown");
                        }
                        if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(y.a("ro.yunos.build.version"))) {
                            z = b();
                        }
                        if (z) {
                            hashMap.put(LogField.OS.toString(), "y");
                            CharSequence a = y.a("ro.aliyun.clouduuid", "false");
                            if ("false".equals(a)) {
                                a = y.a("ro.sys.aliyun.clouduuid", "false");
                            }
                            if (TextUtils.isEmpty(a)) {
                                a = c();
                            }
                            if (!TextUtils.isEmpty(a)) {
                                hashMap.put(com.alibaba.analytics.core.model.a.DEVICE_ID.toString(), a);
                            }
                            a = System.getProperty("ro.yunos.version");
                            if (!TextUtils.isEmpty(a)) {
                                hashMap.put(LogField.OSVERSION.toString(), a);
                            }
                            a = d();
                            if (!TextUtils.isEmpty(a)) {
                                hashMap.put(LogField.OSVERSION.toString(), a);
                            }
                        }
                        if (b()) {
                            hashMap.put(LogField.OS.toString(), "a");
                        }
                        try {
                            Configuration configuration = new Configuration();
                            System.getConfiguration(context.getContentResolver(), configuration);
                            if (configuration.locale != null) {
                                hashMap.put(LogField.LANGUAGE.toString(), configuration.locale.toString());
                            } else {
                                hashMap.put(LogField.LANGUAGE.toString(), "Unknown");
                            }
                            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                            int i = displayMetrics.widthPixels;
                            int i2 = displayMetrics.heightPixels;
                            if (i > i2) {
                                i ^= i2;
                                i2 ^= i;
                                i ^= i2;
                            }
                            hashMap.put(LogField.RESOLUTION.toString(), i2 + "*" + i);
                        } catch (Exception e2) {
                            hashMap.put(LogField.RESOLUTION.toString(), "Unknown");
                        }
                        try {
                            String[] b = e.b();
                            hashMap.put(LogField.ACCESS.toString(), b[0]);
                            if (b[0].equals("2G/3G")) {
                                hashMap.put(LogField.ACCESS_SUBTYPE.toString(), b[1]);
                            } else {
                                hashMap.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
                            }
                        } catch (Exception e3) {
                            hashMap.put(LogField.ACCESS.toString(), "Unknown");
                            hashMap.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
                        }
                        try {
                            Object networkOperatorName;
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            String str = "";
                            if (telephonyManager == null || telephonyManager.getSimState() != 5) {
                                String str2 = str;
                            } else {
                                networkOperatorName = telephonyManager.getNetworkOperatorName();
                            }
                            if (TextUtils.isEmpty(networkOperatorName)) {
                                networkOperatorName = "Unknown";
                            }
                            hashMap.put(LogField.CARRIER.toString(), networkOperatorName);
                        } catch (Exception e4) {
                        }
                        a = hashMap;
                        map = hashMap;
                    } catch (Exception e5) {
                    }
                } catch (Exception e6) {
                    Log.e("UTMCDevice", "utdid4all jar doesn't exist, please copy the libs folder.");
                }
            }
        }
        return map;
    }

    private static boolean b() {
        if (TextUtils.isEmpty(a("ro.yunos.product.chip")) && TextUtils.isEmpty(a("ro.yunos.hardware"))) {
            return false;
        }
        return true;
    }

    private static String a(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls.newInstance(), new Object[]{str});
        } catch (SecurityException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        } catch (IllegalAccessException e3) {
            return null;
        } catch (InstantiationException e4) {
            return null;
        } catch (IllegalArgumentException e5) {
            return null;
        } catch (InvocationTargetException e6) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static String d() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (d(context) || c(context)) {
            return true;
        }
        return false;
    }

    private static boolean c(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean d(Context context) {
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
