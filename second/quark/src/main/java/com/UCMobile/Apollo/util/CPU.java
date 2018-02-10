package com.UCMobile.Apollo.util;

import android.os.Build;
import android.text.TextUtils;
import com.UCMobile.Apollo.annotations.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Keep
/* compiled from: ProGuard */
public class CPU {
    public static final int FEATURE_ARM_NEON = 32;
    public static final int FEATURE_ARM_V5TE = 1;
    public static final int FEATURE_ARM_V6 = 2;
    public static final int FEATURE_ARM_V7A = 8;
    public static final int FEATURE_ARM_VFP = 4;
    public static final int FEATURE_ARM_VFPV3 = 16;
    public static final int FEATURE_MIPS = 128;
    public static final int FEATURE_X86 = 64;
    private static int cachedFeature = -1;
    private static String cachedFeatureString = null;
    private static final Map<String, String> cpuinfo = new HashMap();

    public static String getFeatureString() {
        getFeature();
        return cachedFeatureString;
    }

    @Keep
    public static int getFeature() {
        BufferedReader bufferedReader;
        Throwable th;
        int a;
        int i = 0;
        int i2 = 1;
        if (cachedFeature > 0) {
            return getCachedFeature();
        }
        String str;
        int i3;
        int i4;
        cachedFeature = 1;
        if (cpuinfo.isEmpty()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        } else if (!readLine.trim().equals("")) {
                            String[] split = readLine.split(":");
                            if (split.length > 1) {
                                cpuinfo.put(split[0].trim(), split[1].trim());
                            }
                        }
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        bufferedReader2 = bufferedReader;
                        th = th2;
                    }
                }
                bufferedReader.close();
            } catch (Exception e3) {
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                if (!cpuinfo.isEmpty()) {
                    for (String str2 : cpuinfo.keySet()) {
                        new StringBuilder().append(str2).append(": ").append((String) cpuinfo.get(str2));
                    }
                    str2 = (String) cpuinfo.get("CPU architecture");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = (String) cpuinfo.get("vendor_id");
                        String str3 = (String) cpuinfo.get("cpu model");
                        if (!!TextUtils.isEmpty(str2)) {
                        }
                        cachedFeature |= 128;
                    } else {
                        try {
                            a = d.a(str2);
                            if (a < 7) {
                                if (a < 6) {
                                    a = 0;
                                } else {
                                    a = 1;
                                }
                                i3 = 0;
                                i4 = a;
                            } else {
                                i3 = 1;
                                i4 = 1;
                            }
                        } catch (NumberFormatException e5) {
                            i3 = 0;
                            i4 = 0;
                        }
                        str2 = (String) cpuinfo.get("Processor");
                        i3 = 1;
                        i4 = 1;
                        i = i3;
                        i2 = i4;
                        if (i2 != 0) {
                            cachedFeature |= 2;
                        }
                        if (i != 0) {
                            cachedFeature |= 8;
                        }
                        str2 = (String) cpuinfo.get("Features");
                        if (str2 != null) {
                            if (str2.contains("neon")) {
                                cachedFeature |= 52;
                            } else if (str2.contains("vfpv3")) {
                                cachedFeature |= 20;
                            } else if (str2.contains("vfp")) {
                                cachedFeature |= 4;
                            }
                        }
                    }
                }
                return getCachedFeature();
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        }
        if (cpuinfo.isEmpty()) {
            for (String str22 : cpuinfo.keySet()) {
                new StringBuilder().append(str22).append(": ").append((String) cpuinfo.get(str22));
            }
            str22 = (String) cpuinfo.get("CPU architecture");
            if (TextUtils.isEmpty(str22)) {
                a = d.a(str22);
                if (a < 7) {
                    i3 = 1;
                    i4 = 1;
                } else {
                    if (a < 6) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    i3 = 0;
                    i4 = a;
                }
                str22 = (String) cpuinfo.get("Processor");
                if (str22 != null && (str22.contains("(v7l)") || str22.contains("ARMv7"))) {
                    i3 = 1;
                    i4 = 1;
                }
                if (str22 == null || !(str22.contains("(v6l)") || str22.contains("ARMv6"))) {
                    i = i3;
                    i2 = i4;
                }
                if (i2 != 0) {
                    cachedFeature |= 2;
                }
                if (i != 0) {
                    cachedFeature |= 8;
                }
                str22 = (String) cpuinfo.get("Features");
                if (str22 != null) {
                    if (str22.contains("neon")) {
                        cachedFeature |= 52;
                    } else if (str22.contains("vfpv3")) {
                        cachedFeature |= 20;
                    } else if (str22.contains("vfp")) {
                        cachedFeature |= 4;
                    }
                }
            } else {
                str22 = (String) cpuinfo.get("vendor_id");
                String str32 = (String) cpuinfo.get("cpu model");
                if (!TextUtils.isEmpty(str22) && str22.contains("GenuineIntel")) {
                    cachedFeature |= 64;
                } else if (!TextUtils.isEmpty(str32) && str32.contains("MIPS")) {
                    cachedFeature |= 128;
                }
            }
        }
        return getCachedFeature();
    }

    private static int getCachedFeature() {
        if (cachedFeatureString == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if ((cachedFeature & 1) > 0) {
                stringBuffer.append("V5TE ");
            }
            if ((cachedFeature & 2) > 0) {
                stringBuffer.append("V6 ");
            }
            if ((cachedFeature & 4) > 0) {
                stringBuffer.append("VFP ");
            }
            if ((cachedFeature & 8) > 0) {
                stringBuffer.append("V7A ");
            }
            if ((cachedFeature & 16) > 0) {
                stringBuffer.append("VFPV3 ");
            }
            if ((cachedFeature & 32) > 0) {
                stringBuffer.append("NEON ");
            }
            if ((cachedFeature & 64) > 0) {
                stringBuffer.append("X86 ");
            }
            if ((cachedFeature & 128) > 0) {
                stringBuffer.append("MIPS ");
            }
            cachedFeatureString = stringBuffer.toString();
        }
        new StringBuilder("GET CPU FATURE: ").append(cachedFeatureString);
        return cachedFeature;
    }

    public static boolean isDroidXDroid2() {
        return Build.MODEL.trim().equalsIgnoreCase("DROIDX") || Build.MODEL.trim().equalsIgnoreCase("DROID2") || Build.FINGERPRINT.toLowerCase().contains("shadow") || Build.FINGERPRINT.toLowerCase().contains("droid2");
    }
}
