package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.UCMPackageInfo;
import com.uc.webview.export.internal.utility.c;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: ProGuard */
public abstract class p extends UCSubSetupTask<p, p> {
    protected boolean a = false;
    protected boolean b = false;
    private final int c = -1;

    private static String a(String str) {
        File file = new File(str);
        return UCCyclone.getSourceHash(UCCyclone.getDecompressSourceHash(str, file.length(), file.lastModified(), false));
    }

    private static boolean a(String str, Context context) {
        File file = (File) UCMPackageInfo.invoke(10005, context);
        String a = a(str);
        if (new File(file, a + "_n").exists()) {
            if (new File(file, a + "_y").exists()) {
                return false;
            }
            throw new UCSetupException((int) SettingsConst.ENABLE_LITTLE_WIN, String.format("[%s] verifyQuick failed", new Object[]{str}));
        } else if (new File(file, a + "_y").exists()) {
            return true;
        } else {
            return false;
        }
    }

    private static void a(String str, Context context, boolean z) {
        File file = (File) UCMPackageInfo.invoke(10005, context);
        String a = a(str);
        try {
            File file2 = new File(file, a + "_y");
            File file3 = new File(file, a + "_n");
            if (z) {
                file2.createNewFile();
                file3.delete();
                return;
            }
            file2.delete();
            file3.createNewFile();
        } catch (Exception e) {
        }
    }

    protected static UCElapseTime a(Context context, Integer num, String str) {
        UCElapseTime uCElapseTime = new UCElapseTime();
        if ((num.intValue() & UCCore.VERIFY_POLICY_QUICK) == 0 || !a(str, context)) {
            if (c.a(str, context, context, "com.UCMobile", null)) {
                a(str, context, true);
            } else {
                a(str, context, false);
                throw new UCSetupException((int) SettingsConst.ENABLE_LITTLE_WIN, String.format("[%s] verify failed", new Object[]{str}));
            }
        }
        return uCElapseTime;
    }

    protected final void a(UCMPackageInfo uCMPackageInfo) {
        String str = (String) getOption(UCCore.OPTION_LOAD_KERNEL_TYPE);
        if (!d.a(str) && !uCMPackageInfo.coreCode.equals(str)) {
            if ("u3".equals(str) || "u4".equals(str)) {
                throw new UCSetupException((int) SettingsConst.SINFO_SO_VERSION, String.format("UCM with core code [%s] is excluded by param load [%s].", new Object[]{uCMPackageInfo.coreCode, str}));
            } else {
                throw new UCSetupException((int) SettingsConst.PAUSE_PLAY_AFTER_EXIT_FULLSCREEN, String.format("UCM param load value [%s] unknown.", new Object[]{str}));
            }
        }
    }

    protected final void a(UCMPackageInfo uCMPackageInfo, boolean z, boolean z2) {
        if (z) {
            boolean z3 = !z2;
            Boolean a = d.a(this.mOptions, UCCore.OPTION_SKIP_OLD_KERNEL);
            if (a != null) {
                z3 = a.booleanValue();
            }
            if (z3) {
                UCLogger.print(this.c, "checkParamSkipOldKernel:true", new Throwable[0]);
                throw new UCSetupException(4006, String.format("UCM [%s] is excluded by param skip_old_extra_kernel value [%s].", new Object[]{uCMPackageInfo.dataDir, a}));
            }
        }
    }

    protected static void a(String str, ClassLoader classLoader, String str2, String str3) {
        int i = 0;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    String[] split = str.split(",");
                    if (split.length > 0) {
                        String str4 = (String) Class.forName(str2, false, classLoader).getField(str3).get(null);
                        if (str4 != null && str4.length() > 0) {
                            int length = split.length;
                            while (i < length) {
                                String trim = split[i].trim();
                                if (trim.length() <= 0 || !str4.startsWith(trim)) {
                                    i++;
                                } else {
                                    throw new UCSetupException(4013, String.format("UCM version [%s] is excluded by rules [%s].", new Object[]{str4, str}));
                                }
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                throw new UCSetupException(4012, e);
            }
        }
    }

    protected final void a(UCMPackageInfo uCMPackageInfo, Context context, ClassLoader classLoader) {
        int i = 0;
        try {
            Method method;
            Object[] objArr;
            Class loadClass = classLoader.loadClass("com.uc.webview.browser.shell.SdkAuthentication");
            try {
                method = loadClass.getMethod("tryLoadUCCore", new Class[]{Context.class, UCMPackageInfo.class, HashMap.class});
                new HashMap(this.mOptions.size()).putAll(this.mOptions);
                objArr = new Object[]{context, uCMPackageInfo, r5};
            } catch (NoSuchMethodException e) {
                try {
                    method = loadClass.getMethod("tryLoadUCCore", new Class[]{Context.class, UCMPackageInfo.class});
                    objArr = new Object[]{context, uCMPackageInfo};
                } catch (Throwable e2) {
                    throw new UCSetupException(4015, e2);
                }
            }
            try {
                int i2;
                if (d.a((Boolean) ReflectionUtil.invoke(null, loadClass, method, objArr))) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    throw new UCSetupException(4017, "tryLoadUCCore return false.");
                }
            } catch (UCKnownException e3) {
                throw e3;
            } catch (Throwable e22) {
                String message = e22.getMessage();
                if (message != null) {
                    int indexOf = message.indexOf("9");
                    if (indexOf == 0) {
                        try {
                            i = d.b(message.substring(indexOf, indexOf + 4));
                        } catch (Exception e4) {
                        }
                    }
                }
                if (i >= 9000) {
                    UCSetupException uCSetupException = new UCSetupException(i, e22);
                } else {
                    UCSetupException uCSetupException2 = new UCSetupException(4016, e22);
                }
            }
        } catch (Throwable e222) {
            throw new UCSetupException(4014, e222);
        }
    }

    protected final void a(UCMPackageInfo uCMPackageInfo, Context context, ClassLoader classLoader, int i) {
        Field declaredField;
        Class cls;
        Object obj;
        String[][] strArr;
        String str;
        String str2;
        Object obj2;
        String str3;
        long c;
        String str4;
        File file;
        int i2;
        Locale locale;
        String str5;
        Object[] objArr;
        String str6;
        try {
            String[][] strArr2;
            Class cls2 = Class.forName("com.uc.webview.browser.shell.NativeLibraries", true, classLoader);
            if (cls2 != null) {
                try {
                    declaredField = cls2.getDeclaredField("LIBRARIES");
                    declaredField.setAccessible(true);
                    strArr2 = (String[][]) declaredField.get(null);
                } catch (Throwable th) {
                    cls = cls2;
                    if (((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue()) {
                        obj = 1;
                    } else {
                        try {
                            cls = Class.forName("com.uc.webview.browser.shell.Build$Version", true, classLoader);
                            if (cls != null) {
                                declaredField = cls.getDeclaredField("BUILD_SERIAL");
                                declaredField.setAccessible(true);
                                if (((Integer) declaredField.get(null)).intValue() >= 19) {
                                    obj = 1;
                                }
                            }
                            obj = null;
                        } catch (Throwable th2) {
                            UCSetupException uCSetupException = new UCSetupException(3020, "Version.BUILD_SERIAL not found.");
                        }
                    }
                    if (obj == null) {
                        strArr = null;
                        if (strArr == null) {
                            str = uCMPackageInfo.soDirPath;
                            if (str == null) {
                                str2 = context.getApplicationInfo().nativeLibraryDir;
                            } else {
                                str2 = str;
                            }
                            obj2 = (i & 16) != 0 ? 1 : null;
                            obj = (UCCore.VERIFY_POLICY_QUICK & i) != 0 ? 1 : null;
                            for (String[] strArr3 : strArr) {
                                str3 = strArr3[0];
                                c = d.c(strArr3[1]);
                                str4 = strArr3[2];
                                file = new File(str2, str3);
                                if (file.length() != c) {
                                    throw new UCSetupException(1008, String.format(Locale.CHINA, "So file [%s] with length [%d] mismatch to predefined [%d].", new Object[]{file, Long.valueOf(file.length()), Long.valueOf(c)}));
                                }
                                UCLogger.print(this.c, String.format(Locale.CHINA, "Check file size ok [%s].", new Object[]{file}), new Throwable[0]);
                                if (obj2 == null) {
                                    str3 = UCCyclone.md5FileContents(file);
                                    if (!!d.a(str4)) {
                                    }
                                    if (obj != null) {
                                        a(file.getAbsolutePath(), context, true);
                                    }
                                    UCLogger.print(this.c, String.format(Locale.CHINA, "Check file md5-hash ok [%s].", new Object[]{file}), new Throwable[0]);
                                }
                            }
                        }
                    }
                    i2 = cls != null ? 3019 : 3018;
                    locale = Locale.CHINA;
                    str5 = "%s [%s] missing.";
                    objArr = new Object[2];
                    if (cls != null) {
                        str6 = "Field";
                    } else {
                        str6 = "Class";
                    }
                    objArr[0] = str6;
                    if (cls != null) {
                        str6 = "com.uc.webview.browser.shell.NativeLibraries.LIBRARIES";
                    } else {
                        str6 = "com.uc.webview.browser.shell.NativeLibraries";
                    }
                    objArr[1] = str6;
                    throw new UCSetupException(i2, String.format(locale, str5, objArr));
                }
            }
            strArr2 = null;
            strArr = strArr2;
        } catch (Throwable th3) {
            cls = null;
            if (((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue()) {
                obj = 1;
            } else {
                cls = Class.forName("com.uc.webview.browser.shell.Build$Version", true, classLoader);
                if (cls != null) {
                    declaredField = cls.getDeclaredField("BUILD_SERIAL");
                    declaredField.setAccessible(true);
                    if (((Integer) declaredField.get(null)).intValue() >= 19) {
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                if (cls != null) {
                }
                locale = Locale.CHINA;
                str5 = "%s [%s] missing.";
                objArr = new Object[2];
                if (cls != null) {
                    str6 = "Class";
                } else {
                    str6 = "Field";
                }
                objArr[0] = str6;
                if (cls != null) {
                    str6 = "com.uc.webview.browser.shell.NativeLibraries";
                } else {
                    str6 = "com.uc.webview.browser.shell.NativeLibraries.LIBRARIES";
                }
                objArr[1] = str6;
                throw new UCSetupException(i2, String.format(locale, str5, objArr));
            }
            strArr = null;
            if (strArr == null) {
                str = uCMPackageInfo.soDirPath;
                if (str == null) {
                    str2 = str;
                } else {
                    str2 = context.getApplicationInfo().nativeLibraryDir;
                }
                if ((i & 16) != 0) {
                }
                if ((UCCore.VERIFY_POLICY_QUICK & i) != 0) {
                }
                while (r3 < r7) {
                    str3 = strArr3[0];
                    c = d.c(strArr3[1]);
                    str4 = strArr3[2];
                    file = new File(str2, str3);
                    if (file.length() != c) {
                        UCLogger.print(this.c, String.format(Locale.CHINA, "Check file size ok [%s].", new Object[]{file}), new Throwable[0]);
                        if (obj2 == null) {
                            str3 = UCCyclone.md5FileContents(file);
                            if (!d.a(str4)) {
                            }
                            if (obj != null) {
                                a(file.getAbsolutePath(), context, true);
                            }
                            UCLogger.print(this.c, String.format(Locale.CHINA, "Check file md5-hash ok [%s].", new Object[]{file}), new Throwable[0]);
                        }
                    } else {
                        throw new UCSetupException(1008, String.format(Locale.CHINA, "So file [%s] with length [%d] mismatch to predefined [%d].", new Object[]{file, Long.valueOf(file.length()), Long.valueOf(c)}));
                    }
                }
            }
        }
        if (strArr == null) {
            str = uCMPackageInfo.soDirPath;
            if (str == null) {
                str2 = context.getApplicationInfo().nativeLibraryDir;
            } else {
                str2 = str;
            }
            if ((i & 16) != 0) {
            }
            if ((UCCore.VERIFY_POLICY_QUICK & i) != 0) {
            }
            for (String[] strArr32 : strArr) {
                str3 = strArr32[0];
                c = d.c(strArr32[1]);
                str4 = strArr32[2];
                file = new File(str2, str3);
                if (file.length() != c) {
                    throw new UCSetupException(1008, String.format(Locale.CHINA, "So file [%s] with length [%d] mismatch to predefined [%d].", new Object[]{file, Long.valueOf(file.length()), Long.valueOf(c)}));
                }
                UCLogger.print(this.c, String.format(Locale.CHINA, "Check file size ok [%s].", new Object[]{file}), new Throwable[0]);
                if (obj2 == null) {
                    if (obj == null || !a(file.getAbsolutePath(), context)) {
                        str3 = UCCyclone.md5FileContents(file);
                        if (!d.a(str4) && !str4.equals(str3)) {
                            if (obj != null) {
                                a(file.getAbsolutePath(), context, false);
                            }
                            throw new UCSetupException(1011, String.format("So file [%s] with md5 [%s] mismatch to predefined [%s].", new Object[]{file, str3, str4}));
                        } else if (obj != null) {
                            a(file.getAbsolutePath(), context, true);
                        }
                    }
                    UCLogger.print(this.c, String.format(Locale.CHINA, "Check file md5-hash ok [%s].", new Object[]{file}), new Throwable[0]);
                }
            }
        }
    }

    protected final void a(String str, boolean z, Integer num, String str2, long j, long j2) {
        try {
            callbackStat(new Pair(str, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", String.valueOf(num)).set("frun", z ? "T" : "F").set("data", str2).set("cost", String.valueOf(j)).set("cost_cpu", String.valueOf(j2))));
        } catch (Throwable th) {
        }
    }
}
