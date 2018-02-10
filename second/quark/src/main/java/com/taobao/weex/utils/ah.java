package com.taobao.weex.utils;

import android.mini.support.annotation.Nullable;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.weex.i;

/* compiled from: ProGuard */
public final class ah {
    public static boolean a() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static float a(Object obj, int i) {
        float f = Float.NaN;
        if (obj != null) {
            String trim = obj.toString().trim();
            if (trim.endsWith("wx")) {
                try {
                    f = b(trim, i);
                } catch (Throwable e) {
                    WXLogUtils.e("Argument format error! value is " + obj, e);
                } catch (Throwable e2) {
                    WXLogUtils.e("Argument error! value is " + obj, e2);
                }
            } else if (trim.endsWith("px")) {
                try {
                    f = Float.parseFloat(trim.substring(0, trim.indexOf("px")));
                } catch (Throwable e22) {
                    WXLogUtils.e("Argument format error! value is " + obj, e22);
                } catch (Throwable e222) {
                    WXLogUtils.e("Argument error! value is " + obj, e222);
                }
            } else {
                try {
                    f = Float.parseFloat(trim);
                } catch (Throwable e2222) {
                    WXLogUtils.e("Argument format error! value is " + obj, e2222);
                } catch (Throwable e22222) {
                    WXLogUtils.e("Argument error! value is " + obj, e22222);
                }
            }
        }
        return f;
    }

    public static float a(Object obj) {
        return a(obj, Float.valueOf(Float.NaN)).floatValue();
    }

    public static Float a(Object obj, @Nullable Float f) {
        if (obj != null) {
            String trim = obj.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (trim.endsWith("wx")) {
                    try {
                        f = Float.valueOf(b(trim, 750));
                    } catch (Throwable e) {
                        WXLogUtils.e("Argument format error! value is " + obj, e);
                    } catch (Throwable e2) {
                        WXLogUtils.e("Argument error! value is " + obj, e2);
                    }
                } else if (trim.endsWith("px")) {
                    try {
                        f = Float.valueOf(Float.parseFloat(trim.substring(0, trim.indexOf("px"))));
                    } catch (Throwable e22) {
                        WXLogUtils.e("Argument format error! value is " + obj, e22);
                    } catch (Throwable e222) {
                        WXLogUtils.e("Argument error! value is " + obj, e222);
                    }
                } else {
                    try {
                        f = Float.valueOf(Float.parseFloat(trim));
                    } catch (Throwable e2222) {
                        WXLogUtils.e("Argument format error! value is " + obj, e2222);
                    } catch (Throwable e22222) {
                        WXLogUtils.e("Argument error! value is " + obj, e22222);
                    }
                }
            }
        }
        return f;
    }

    private static float b(String str, int i) {
        if (str == null) {
            return 0.0f;
        }
        if (str.endsWith("wx")) {
            str = str.substring(0, str.indexOf("wx"));
        }
        return ((Float.parseFloat((String) i.a().get("scale")) * Float.valueOf(Float.parseFloat(str)).floatValue()) * ((float) i)) / ((float) WXViewUtils.b());
    }

    public static float a(String str, int i) {
        int i2 = 1;
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            throw new NumberFormatException("NullNumber");
        }
        int i4;
        if (str.charAt(0) == '-') {
            i4 = 0;
        } else if (str.charAt(0) == '+') {
            i4 = 1;
        } else {
            i4 = 1;
            i2 = 0;
        }
        int i5 = i2;
        float f = 0.0f;
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            f = ((f * 10.0f) + ((float) charAt)) - 48.0f;
            i5++;
        }
        if (i5 < str.length()) {
            if (str.charAt(i5) == '.') {
                int i6 = i5 + 1;
                float f2 = f;
                i2 = 10;
                while (i6 < str.length() && i3 < i) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    f2 += ((float) (charAt2 - 48)) / ((float) i2);
                    i2 *= 10;
                    i6++;
                    i3++;
                }
                f = f2;
            } else {
                throw new NumberFormatException("Illegal separator");
            }
        }
        if (i4 == 0) {
            return f * -1.0f;
        }
        return f;
    }

    public static float a(String str) {
        return a(str, Integer.MAX_VALUE);
    }

    public static int b(Object obj) {
        return a(obj, Integer.valueOf(0)).intValue();
    }

    public static Integer a(@Nullable Object obj, @Nullable Integer num) {
        if (obj == null) {
            return num;
        }
        try {
            return (Integer) obj;
        } catch (ClassCastException e) {
            String trim = obj.toString().trim();
            if (trim.endsWith("wx")) {
                if (i.c()) {
                    WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
                }
                try {
                    return Integer.valueOf((int) b(trim, 750));
                } catch (Throwable e2) {
                    WXLogUtils.e("Argument format error! value is " + obj, e2);
                    return num;
                } catch (Throwable e22) {
                    WXLogUtils.e("Argument error! value is " + obj, e22);
                    return num;
                }
            } else if (trim.endsWith("px")) {
                try {
                    return Integer.valueOf(Integer.parseInt(trim.substring(0, trim.indexOf("px"))));
                } catch (Throwable e222) {
                    WXLogUtils.e("Argument format error! value is " + obj, e222);
                    return num;
                } catch (Throwable e2222) {
                    WXLogUtils.e("Argument error! value is " + obj, e2222);
                    return num;
                }
            } else {
                try {
                    return Integer.valueOf(Integer.parseInt(trim));
                } catch (Throwable e22222) {
                    WXLogUtils.e("Argument format error! value is " + obj, e22222);
                    return num;
                } catch (Throwable e222222) {
                    WXLogUtils.e("Argument error! value is " + obj, e222222);
                    return num;
                }
            }
        }
    }

    @Deprecated
    public static long c(Object obj) {
        long j = 0;
        if (obj == null) {
            return j;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith("wx")) {
            if (i.c()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return (long) b(trim, 750);
            } catch (Throwable e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return j;
            } catch (Throwable e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return j;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Long.parseLong(trim.substring(0, trim.indexOf("px")));
            } catch (Throwable e22) {
                WXLogUtils.e("Argument format error! value is " + obj, e22);
                return j;
            } catch (Throwable e222) {
                WXLogUtils.e("Argument error! value is " + obj, e222);
                return j;
            }
        } else {
            try {
                return Long.parseLong(trim);
            } catch (Throwable e2222) {
                WXLogUtils.e("Argument format error! value is " + obj, e2222);
                return j;
            } catch (Throwable e22222) {
                WXLogUtils.e("Argument error! value is " + obj, e22222);
                return j;
            }
        }
    }

    @Deprecated
    public static double d(Object obj) {
        double d = 0.0d;
        if (obj == null) {
            return d;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith("wx")) {
            if (i.c()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return (double) b(trim, 750);
            } catch (Throwable e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return d;
            } catch (Throwable e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return d;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Double.parseDouble(trim.substring(0, trim.indexOf("px")));
            } catch (Throwable e22) {
                WXLogUtils.e("Argument format error! value is " + obj, e22);
                return d;
            } catch (Throwable e222) {
                WXLogUtils.e("Argument error! value is " + obj, e222);
                return d;
            }
        } else {
            try {
                return Double.parseDouble(trim);
            } catch (Throwable e2222) {
                WXLogUtils.e("Argument format error! value is " + obj, e2222);
                return d;
            } catch (Throwable e22222) {
                WXLogUtils.e("Argument error! value is " + obj, e22222);
                return d;
            }
        }
    }

    public static Boolean a(@Nullable Object obj, @Nullable Boolean bool) {
        if (obj == null) {
            return bool;
        }
        if (TextUtils.equals("false", obj.toString())) {
            return Boolean.valueOf(false);
        }
        if (TextUtils.equals("true", obj.toString())) {
            return Boolean.valueOf(true);
        }
        return bool;
    }

    public static String a(@Nullable Object obj, @Nullable String str) {
        if (obj == null) {
            return str;
        }
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            str2 = obj.toString();
        }
        return str2;
    }

    public static int b(String str) {
        int lastIndexOf = str.lastIndexOf(37);
        return lastIndexOf != -1 ? (int) ((Float.parseFloat(str.substring(0, lastIndexOf)) / 100.0f) * 255.0f) : Integer.parseInt(str);
    }
}
