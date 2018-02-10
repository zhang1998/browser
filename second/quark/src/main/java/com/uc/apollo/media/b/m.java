package com.uc.apollo.media.b;

import java.util.Formatter;
import java.util.Locale;

/* compiled from: ProGuard */
final class m {
    public static String a(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        i2 /= 3600;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        if (i2 != 0) {
            formatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
        } else {
            formatter.format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
        }
        return formatter.toString();
    }

    public static String a(String str, String str2) {
        String trim;
        if (str != null) {
            trim = str.trim();
        } else {
            trim = str;
        }
        if (str2 != null) {
            CharSequence trim2 = str2.trim();
        } else {
            Object obj = str2;
        }
        if (trim2 == null || trim2.length() == 0) {
            return trim;
        }
        if (trim == null || trim.length() == 0) {
            return trim2;
        }
        int indexOf = trim.indexOf("://");
        StringBuilder stringBuilder;
        if (trim2.startsWith("/")) {
            stringBuilder = new StringBuilder(trim.length() + trim2.length());
            if (trim2.startsWith("//")) {
                if (indexOf == -1) {
                    indexOf = trim.indexOf(47);
                } else {
                    indexOf++;
                }
                if (indexOf == -1) {
                    indexOf = trim.length();
                }
            } else if (indexOf != -1) {
                indexOf = trim.indexOf(47, indexOf + 3);
            } else {
                indexOf = trim.indexOf(47);
            }
            if (indexOf == -1) {
                indexOf = trim.length();
            }
            stringBuilder.append(trim, 0, indexOf);
            stringBuilder.append(trim2);
            return stringBuilder.toString();
        } else if (trim2.indexOf("://") != -1) {
            return trim2;
        } else {
            String substring;
            indexOf = trim.indexOf(63);
            if (indexOf != -1) {
                substring = trim.substring(0, indexOf);
            } else {
                substring = trim;
            }
            if (trim2.startsWith("?")) {
                stringBuilder = new StringBuilder(trim.length() + trim2.length());
                stringBuilder.append(substring);
                stringBuilder.append(trim2);
                return stringBuilder.toString();
            }
            int indexOf2;
            int lastIndexOf = substring.lastIndexOf(47);
            if (lastIndexOf != -1) {
                indexOf2 = substring.indexOf("://");
                if (indexOf2 == -1 || indexOf2 + 2 != lastIndexOf) {
                    substring = substring.substring(0, lastIndexOf + 1);
                }
            }
            if (!substring.endsWith("/")) {
                substring = substring + '/';
                lastIndexOf = substring.lastIndexOf(47);
            }
            indexOf2 = 0;
            while (trim2.indexOf("../", indexOf2) == indexOf2 && r1 != -1) {
                trim = substring.substring(0, substring.length() - 1);
                if (trim.length() == 0) {
                    substring = trim;
                    lastIndexOf = -1;
                } else {
                    Object substring2;
                    int lastIndexOf2 = trim.lastIndexOf(47);
                    String str3 = "..";
                    if (lastIndexOf2 != -1) {
                        substring2 = trim.substring(lastIndexOf2 + 1);
                    } else {
                        substring = trim;
                    }
                    if (str3.equals(substring2)) {
                        substring = trim + '/';
                        break;
                    } else if (lastIndexOf2 != -1) {
                        substring = trim.substring(0, lastIndexOf2 + 1);
                        lastIndexOf = lastIndexOf2;
                    } else {
                        substring = new String();
                        lastIndexOf = lastIndexOf2;
                    }
                }
                indexOf2 += 3;
            }
            StringBuilder stringBuilder2 = new StringBuilder(substring.length() + trim2.length());
            stringBuilder2.append(substring).append(trim2, indexOf2, trim2.length());
            return stringBuilder2.toString();
        }
    }
}
