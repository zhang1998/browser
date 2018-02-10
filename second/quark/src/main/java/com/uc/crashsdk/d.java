package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class d {
    private static ICrashClient a = null;
    private static int b = 3;
    private static volatile List<ValueCallback<Bundle>> c = null;
    private static volatile List<ValueCallback<Bundle>> d = null;
    private static volatile List<ValueCallback<Bundle>> e = null;
    private static Object f = new Object();

    public static void a(ICrashClient iCrashClient) {
        a = iCrashClient;
    }

    public static void a(String str, String str2) {
        if (h.a(str)) {
            c.a("crashsdk", "onLogGenerated file name is null!");
            return;
        }
        if (a != null) {
            try {
                a.onLogGenerated(new File(str), str2);
            } catch (Throwable th) {
                a.a(th, false);
            }
        }
        if (c != null) {
            synchronized (c) {
                for (ValueCallback valueCallback : c) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        bundle.putString("logType", str2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        a.a(th2, false);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        if (a != null) {
            try {
                file = a.onBeforeUploadLog(file);
            } catch (Throwable th) {
                a.a(th, false);
            }
        }
        return file;
    }

    public static void a(boolean z) {
        if (a != null) {
            try {
                a.onCrashRestarting(z);
            } catch (Throwable th) {
                a.a(th, false);
            }
        }
        if (d != null) {
            synchronized (d) {
                for (ValueCallback valueCallback : d) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        a.a(th2, false);
                    }
                }
            }
        }
    }

    public static boolean a(String str, int i, int i2) {
        boolean onAddCrashStats;
        if (a != null) {
            onAddCrashStats = a.onAddCrashStats(str, i, i2);
        } else {
            onAddCrashStats = false;
        }
        if (e != null) {
            synchronized (e) {
                for (ValueCallback valueCallback : e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i);
                        bundle.putInt("count", i2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        a.a(th, false);
                    }
                }
            }
        }
        return onAddCrashStats;
    }

    public static String a(String str) {
        if (a != null) {
            return a.onGetCallbackInfo(str);
        }
        return "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (c == null) {
            synchronized (f) {
                if (c == null) {
                    c = new ArrayList();
                }
            }
        }
        synchronized (c) {
            if (c.size() >= b) {
                return false;
            }
            c.add(valueCallback);
            return true;
        }
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (d == null) {
            synchronized (f) {
                if (d == null) {
                    d = new ArrayList();
                }
            }
        }
        synchronized (d) {
            if (d.size() >= b) {
                return false;
            }
            d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (e == null) {
            synchronized (f) {
                if (e == null) {
                    e = new ArrayList();
                }
            }
        }
        synchronized (e) {
            if (e.size() >= b) {
                return false;
            }
            e.add(valueCallback);
            return true;
        }
    }
}
