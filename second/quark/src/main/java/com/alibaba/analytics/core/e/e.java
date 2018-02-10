package com.alibaba.analytics.core.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.analytics.a.aj;
import com.alibaba.analytics.a.q;
import com.alibaba.analytics.a.t;
import com.alibaba.analytics.core.b;
import com.e.a.a;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class e {
    private static d a = null;
    private static String b = "/system/bin/setprop";
    private static String c = "/system/bin/monkey";

    private static void a(Context context, String str, String str2) {
        Object obj = null;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a a = c.a(context);
            if (a != null) {
                Object b;
                try {
                    b = q.b(str.getBytes("UTF-8"));
                    try {
                        obj = q.b(str2.getBytes("UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                } catch (UnsupportedEncodingException e2) {
                    b = obj;
                }
                if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(obj)) {
                    a.a("EI", b);
                    a.a("SI", obj);
                    if (a.c != null) {
                        if (VERSION.SDK_INT >= 9) {
                            a.c.apply();
                        } else {
                            a.c.commit();
                        }
                    }
                    if (a.b != null && a.d != null) {
                        a.b = a.d.getSharedPreferences(a.a, 0);
                    }
                }
            }
        }
    }

    private static d b(Context context) {
        String string;
        String str;
        d dVar;
        String str2 = null;
        if (context != null) {
            String string2;
            String string3;
            String string4;
            SharedPreferences sharedPreferences = context.getSharedPreferences("Alvin3", 0);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("UTCommon", 0);
            if (!(sharedPreferences2 == null || sharedPreferences == null)) {
                string2 = sharedPreferences.getString("EI", null);
                string = sharedPreferences.getString("SI", null);
                if (!(TextUtils.isEmpty(string2) || TextUtils.isEmpty(string))) {
                    string3 = sharedPreferences2.getString("EI", null);
                    string4 = sharedPreferences2.getString("SI", null);
                    if (!string2.equals(string3)) {
                        Editor edit = sharedPreferences2.edit();
                        edit.putString("EI", string2);
                        edit.commit();
                    }
                    if (!string.equals(string4)) {
                        Editor edit2 = sharedPreferences2.edit();
                        edit2.putString("SI", string);
                        edit2.commit();
                    }
                }
            }
            a a = c.a(context);
            if (a != null) {
                string3 = a.a("EI");
                Object a2 = a.a("SI");
                if (!(TextUtils.isEmpty(string3) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(string3))) {
                    try {
                        string2 = new String(q.a(string3.getBytes("UTF-8")), "UTF-8");
                        try {
                            str = new String(q.a(a2.getBytes("UTF-8")), "UTF-8");
                            try {
                                a2 = new String(q.a(string3.getBytes("UTF-8")), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                string = str;
                                str = string2;
                                string2 = str;
                                str = string;
                                a2 = null;
                                dVar = new d();
                                dVar.e = a2;
                                dVar.a = r3;
                                dVar.b = r2;
                                return dVar;
                            } catch (IOException e2) {
                                string = str;
                                str = string2;
                                string2 = str;
                                str = string;
                                a2 = null;
                                dVar = new d();
                                dVar.e = a2;
                                dVar.a = r3;
                                dVar.b = r2;
                                return dVar;
                            }
                        } catch (UnsupportedEncodingException e3) {
                            string = null;
                            str = string2;
                            string2 = str;
                            str = string;
                            a2 = null;
                            dVar = new d();
                            dVar.e = a2;
                            dVar.a = r3;
                            dVar.b = r2;
                            return dVar;
                        } catch (IOException e4) {
                            string = null;
                            str = string2;
                            string2 = str;
                            str = string;
                            a2 = null;
                            dVar = new d();
                            dVar.e = a2;
                            dVar.a = r3;
                            dVar.b = r2;
                            return dVar;
                        }
                    } catch (UnsupportedEncodingException e5) {
                        string = null;
                        str = null;
                        string2 = str;
                        str = string;
                        a2 = null;
                        dVar = new d();
                        dVar.e = a2;
                        dVar.a = r3;
                        dVar.b = r2;
                        return dVar;
                    } catch (IOException e6) {
                        string = null;
                        str = null;
                        string2 = str;
                        str = string;
                        a2 = null;
                        dVar = new d();
                        dVar.e = a2;
                        dVar.a = r3;
                        dVar.b = r2;
                        return dVar;
                    }
                    if (!(TextUtils.isEmpty(r3) || TextUtils.isEmpty(r2) || TextUtils.isEmpty(a2))) {
                        dVar = new d();
                        dVar.e = a2;
                        dVar.a = r3;
                        dVar.b = r2;
                        return dVar;
                    }
                }
            }
            if (context != null) {
                str = b.a;
                a = new a(context, "Alvin3");
            } else {
                a = null;
            }
            if (a != null) {
                string2 = a.a("EI");
                string3 = a.a("SI");
                string4 = a.a("DID");
                if (!(TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                    try {
                        str = new String(q.a(string2.getBytes("UTF-8")), "UTF-8");
                        try {
                            str2 = new String(q.a(string3.getBytes("UTF-8")), "UTF-8");
                            string = str;
                        } catch (UnsupportedEncodingException e7) {
                            string = str;
                        } catch (IOException e8) {
                            string = str;
                        }
                    } catch (UnsupportedEncodingException e9) {
                        string = null;
                    } catch (IOException e10) {
                        string = null;
                    }
                    d dVar2 = new d();
                    dVar2.e = string4;
                    dVar2.a = string2;
                    dVar2.b = string3;
                    a(context, string, str2);
                    return dVar2;
                }
            }
        }
        d dVar3 = new d();
        str2 = aj.a(context);
        str = aj.b(context);
        dVar3.a = str2;
        dVar3.b = str;
        dVar3.e = str2;
        a(context, str2, str);
        return dVar3;
    }

    public static synchronized d a(Context context) {
        d dVar;
        Object obj = null;
        synchronized (e.class) {
            if (a != null) {
                dVar = a;
            } else if (context != null) {
                d b;
                if (context != null) {
                    b = b(context);
                    b.t = a.a(context);
                    if (TextUtils.isEmpty(b.a)) {
                        b.a = aj.a(context);
                    }
                    if (TextUtils.isEmpty(b.b)) {
                        b.b = aj.b(context);
                    }
                } else {
                    b = null;
                }
                if (b != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        dVar = null;
                    } else {
                        b.f = Build.MODEL;
                        try {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            String str = packageInfo.versionName;
                            b.o = String.valueOf(packageInfo.versionCode);
                            b.n = str;
                        } catch (Exception e) {
                            b.o = "Unknown";
                            b.n = "Unknown";
                        }
                        try {
                            b.m = Build.BRAND;
                            b.p = "Android";
                            if ((System.getProperty("java.vm.name") != null && System.getProperty("java.vm.name").toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null) {
                                obj = 1;
                            }
                            if (obj != null) {
                                b.p = "aliyunos";
                            }
                            b.q = VERSION.RELEASE;
                            Configuration configuration = new Configuration();
                            System.getConfiguration(context.getContentResolver(), configuration);
                            if (configuration.locale != null) {
                                b.g = configuration.locale.getCountry();
                                b.h = configuration.locale.toString();
                                Calendar instance = Calendar.getInstance(configuration.locale);
                                if (instance != null) {
                                    TimeZone timeZone = instance.getTimeZone();
                                    if (timeZone != null) {
                                        b.i = (timeZone.getRawOffset() / 3600000);
                                    } else {
                                        b.i = "8";
                                    }
                                } else {
                                    b.i = "8";
                                }
                            } else {
                                b.g = "Unknown";
                                b.h = "Unknown";
                                b.i = "8";
                            }
                            try {
                                DisplayMetrics displayMetrics = new DisplayMetrics();
                                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                                int i = displayMetrics.widthPixels;
                                int i2 = displayMetrics.heightPixels;
                                b.r = i;
                                b.s = i2;
                                if (i > i2) {
                                    i ^= i2;
                                    i2 ^= i;
                                    i ^= i2;
                                }
                                b.j = i2 + "*" + i;
                            } catch (Exception e2) {
                                b.j = "Unknown";
                            }
                            Context context2 = b.a().b;
                            b.k = com.alibaba.analytics.core.d.e.c();
                            context2 = b.a().b;
                            b.l = com.alibaba.analytics.core.d.e.c();
                            String networkOperatorName = telephonyManager.getNetworkOperatorName();
                            if (TextUtils.isEmpty(networkOperatorName)) {
                                networkOperatorName = "";
                            }
                            b.d = networkOperatorName;
                            b.c = t.a();
                            b.u = String.valueOf(new File(b).lastModified()).concat("_").concat(String.valueOf(new File(c).lastModified()));
                            if (VERSION.SDK_INT >= 9) {
                                b.v = a();
                            }
                        } catch (Exception e3) {
                            dVar = null;
                        }
                    }
                }
                a = b;
                dVar = b;
            } else {
                dVar = null;
            }
        }
        return dVar;
    }

    @TargetApi(9)
    private static String a() {
        try {
            return Build.SERIAL;
        } catch (Throwable th) {
            return "";
        }
    }
}
