package com.a.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;

/* compiled from: ProGuard */
public final class fw {
    public static boolean a = false;
    private static String b = "MobclickAgent";
    private static int c = SettingsConst.GLOBAL_SETTINGS;

    public static void a(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                b(b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            b(str, (String) objArr[0], null);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Throwable th) {
        b(b, null, th);
    }

    public static void a(String str, Throwable th) {
        b(b, str, th);
    }

    public static void a(String str) {
        String str2 = b;
        if (a) {
            a(2, str2, str, null);
        }
    }

    public static void b(String str) {
        a(b, str, null);
    }

    public static void c(String str) {
        String str2 = b;
        if (a) {
            a(4, str2, str, null);
        }
    }

    public static void d(String str) {
        b(b, str, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            a(3, str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            a(5, str, str2, th);
        }
    }

    private static void a(int i, String str, String str2, Throwable th) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i3 = c;
            int i4 = 0;
            while (i2 < 100) {
                if (length <= i3) {
                    switch (i) {
                        case 1:
                            str2.substring(i4, length);
                            break;
                        case 2:
                            str2.substring(i4, length);
                            break;
                        case 3:
                            str2.substring(i4, length);
                            break;
                        case 4:
                            Log.w(str, str2.substring(i4, length));
                            break;
                        case 5:
                            Log.e(str, str2.substring(i4, length));
                            break;
                    }
                }
                switch (i) {
                    case 1:
                        str2.substring(i4, i3);
                        break;
                    case 2:
                        str2.substring(i4, i3);
                        break;
                    case 3:
                        str2.substring(i4, i3);
                        break;
                    case 4:
                        Log.w(str, str2.substring(i4, i3));
                        break;
                    case 5:
                        Log.e(str, str2.substring(i4, i3));
                        break;
                    default:
                        break;
                }
                i2++;
                i4 = i3;
                i3 = c + i3;
            }
        }
        if (th != null) {
            String b = b(th);
            if (!TextUtils.isEmpty(b)) {
                switch (i) {
                    case 4:
                        Log.w(str, b);
                        return;
                    case 5:
                        Log.e(str, b);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static String b(Throwable th) {
        PrintWriter printWriter;
        Throwable th2;
        StringWriter stringWriter = null;
        String str = "";
        StringWriter stringWriter2;
        try {
            stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    str = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                    } catch (Throwable th3) {
                    }
                    printWriter.close();
                } catch (Throwable th4) {
                    th2 = th4;
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (Throwable th5) {
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th2;
                }
            } catch (Throwable th6) {
                th2 = th6;
                printWriter = null;
                if (stringWriter2 != null) {
                    stringWriter2.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
        } catch (Throwable th7) {
            th2 = th7;
            printWriter = null;
            stringWriter2 = null;
            if (stringWriter2 != null) {
                stringWriter2.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th2;
        }
        return str;
    }
}
