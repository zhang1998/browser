package com.uc.apollo.android;

import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.e;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class SystemPropertyMatcher {
    @KeepForRuntime
    public static String findPropertiesMatchDevice(String... strArr) {
        String str = null;
        if (!(strArr == null || strArr.length == 0)) {
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int a;
                String str2;
                String str3 = strArr[i];
                if (!e.a(str3)) {
                    a = a(str3);
                    if (a > i2) {
                        str2 = str3;
                        i++;
                        str = str2;
                        i2 = a;
                    }
                }
                a = i2;
                str2 = str;
                i++;
                str = str2;
                i2 = a;
            }
        }
        return str;
    }

    private static int a(String str) {
        int i = 1;
        int i2 = 0;
        try {
            int lastIndexOf = str.lastIndexOf("##");
            if (lastIndexOf >= 0) {
                str = str.substring(0, lastIndexOf).trim();
                if (str.length() == 0) {
                    return -1;
                }
            }
            if (str.equals("*")) {
                return 1;
            }
            String[] split = str.split("&&");
            if (split != null && split.length != 0) {
                int length = split.length;
                for (lastIndexOf = 0; lastIndexOf != length; lastIndexOf++) {
                    if (split[lastIndexOf] == null) {
                        break;
                    }
                    split[lastIndexOf] = split[lastIndexOf].trim();
                    if (split[lastIndexOf].length() == 0) {
                        break;
                    }
                }
                i = 0;
            }
            if (i != 0) {
                return -1;
            }
            lastIndexOf = split.length;
            i = 0;
            while (i2 < lastIndexOf) {
                String str2 = split[i2];
                if (str2 != null) {
                    CharSequence trim = str2.trim();
                    if (trim.length() != 0) {
                        Matcher matcher = Pattern.compile("(.*)\\s*(<=|>=|==|!=|reg|>|<)\\s*(.*)").matcher(trim);
                        if (!matcher.find()) {
                            return -1;
                        }
                        String trim2 = matcher.group(1).trim();
                        String trim3 = matcher.group(2).trim();
                        str2 = matcher.group(3).trim();
                        if (f.a(trim2) || f.a(trim3) || f.a(str2)) {
                            return -1;
                        }
                        trim2 = SystemProperties.get(trim2, null);
                        if (e.a(trim2)) {
                            return -1;
                        }
                        trim2 = trim2.toLowerCase(Locale.getDefault());
                        if (trim3.equals("<")) {
                            if (Float.valueOf(trim2).floatValue() >= Float.valueOf(str2).floatValue()) {
                                return -1;
                            }
                        } else if (trim3.equals("<=")) {
                            if (Float.valueOf(trim2).floatValue() > Float.valueOf(str2).floatValue()) {
                                return -1;
                            }
                        } else if (trim3.equals(">")) {
                            if (Float.valueOf(trim2).floatValue() <= Float.valueOf(str2).floatValue()) {
                                return -1;
                            }
                        } else if (trim3.equals(">=")) {
                            if (Float.valueOf(trim2).floatValue() < Float.valueOf(str2).floatValue()) {
                                return -1;
                            }
                        } else if (trim3.equals("==")) {
                            if (!trim2.equals(str2.toLowerCase(Locale.getDefault()))) {
                                return -1;
                            }
                        } else if (trim3.equals("!=")) {
                            if (trim2.equals(str2.toLowerCase(Locale.getDefault()))) {
                                return -1;
                            }
                        } else if (!trim3.equals("reg")) {
                            return -1;
                        } else {
                            if (!trim2.matches(str2)) {
                                return -1;
                            }
                        }
                        i++;
                    } else {
                        continue;
                    }
                }
                i2++;
            }
            return i;
        } catch (Throwable th) {
            return -1;
        }
    }
}
