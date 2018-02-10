package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class ShareTinkerInternals {
    private static final String TAG = "Tinker.TinkerInternals";
    private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
    private static final boolean VM_IS_JIT = isVmJitInternal();
    private static String currentInstructionSet = null;
    private static Boolean isPatchProcess = null;
    private static String processName = null;

    public static boolean isVmArt() {
        return VM_IS_ART || VERSION.SDK_INT >= 21;
    }

    public static boolean isVmJit() {
        return VM_IS_JIT && VERSION.SDK_INT < 24;
    }

    public static boolean isAfterAndroidO() {
        return VERSION.SDK_INT > 25;
    }

    public static String getCurrentInstructionSet() throws Exception {
        if (currentInstructionSet != null) {
            return currentInstructionSet;
        }
        currentInstructionSet = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(currentInstructionSet);
        return currentInstructionSet;
    }

    public static boolean isSystemOTA(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
            return null;
        }
        String str;
        if (i != 1) {
            str = "classes" + i + ShareConstants.DEX_SUFFIX;
        } else {
            str = ShareConstants.DEX_IN_JAR;
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.destMd5InDvm, shareDexDiffPatchInfo.destMd5InArt, shareDexDiffPatchInfo.dexDiffMd5, shareDexDiffPatchInfo.oldDexCrC, shareDexDiffPatchInfo.newDexCrC, shareDexDiffPatchInfo.dexMode);
    }

    public static boolean isNullOrNil(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).edit().putBoolean(getTinkerSharedPreferencesName(), false).commit();
    }

    public static boolean isTinkerEnableWithSharedPreferences(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).getBoolean(getTinkerSharedPreferencesName(), true);
    }

    private static String getTinkerSharedPreferencesName() {
        return "tinker_enable_1.7.7";
    }

    public static boolean isInMainProcess(Context context) {
        String packageName = context.getPackageName();
        Object processName = getProcessName(context);
        if (processName == null || processName.length() == 0) {
            processName = "";
        }
        return packageName.equals(processName);
    }

    public static void killAllOtherProcess(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String getProcessName(Context context) {
        if (processName != null) {
            return processName;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    private static String getProcessNameInternal(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                RunningAppProcessInfo runningAppProcessInfo;
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                        if (runningAppProcessInfo2.pid == myPid) {
                            break;
                        }
                    }
                    runningAppProcessInfo2 = null;
                } catch (Exception e) {
                    Exception e2;
                    Log.e(TAG, "getProcessNameInternal exception:" + e2.getMessage());
                    runningAppProcessInfo2 = null;
                }
                if (runningAppProcessInfo2 != null) {
                    return runningAppProcessInfo2.processName;
                }
            }
        }
        byte[] bArr = new byte[128];
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if (bArr[i] > Byte.MIN_VALUE || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    Log.e(TAG, "getProcessNameInternal exception:" + e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            Log.e(TAG, "getProcessNameInternal exception:" + e2.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static boolean isVmArt(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isVmJitInternal() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!isNullOrNil(str) && isNullOrNil(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            Log.e(TAG, "isVmJitInternal ex:" + th);
        }
        return false;
    }

    public static String getExceptionCauseString(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String toVisualString = toVisualString(byteArrayOutputStream.toString());
        return toVisualString;
    }

    public static String toVisualString(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
