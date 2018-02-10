package com.ucpro.business.b;

import android.content.Context;
import android.os.Process;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.VersionInfo;
import com.ucpro.c.b;
import com.ucpro.d.e;
import hugo.weaving.DebugLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class a {
    private static CrashApi a;
    private static boolean b = b.a();
    private static String c = "http://up4.ucweb.com:8012/upload";
    private static String d = null;

    @DebugLog
    public static void a(Context context) {
        CustomInfo customInfo = new CustomInfo();
        customInfo.mCrashLogPrefix = "ucpro";
        customInfo.mUnexpDelayMillSeconds = 10000;
        customInfo.mUnexpOnlyKnownReason = !b;
        customInfo.mEnableStatReport = true;
        if (b) {
            customInfo.mDebugCrashSDK = true;
            customInfo.mBackupLogs = true;
            customInfo.mCrashLogsFolderName = "Quark" + File.separator + "crash";
            customInfo.mMaxCrashLogFilesCount = 1000;
            customInfo.mLogMaxBytesLimit = -1;
            customInfo.mLogMaxUploadBytesLimit = -1;
            customInfo.mMaxUploadBytesPerDay = -1;
            customInfo.mMaxUploadCrashLogCountPerDay = -1;
            customInfo.mMaxUploadCustomLogCountPerDay = -1;
            customInfo.mMaxCustomLogCountPerTypePerDay = -1;
            customInfo.mDumpHprofDataForJavaOOM = true;
            customInfo.mOverrideLibcMalloc = true;
        }
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.mVersion = "2.4.1.985";
        versionInfo.mSubVersion = "release";
        versionInfo.mBuildSeq = "180123054500";
        CrashApi createInstance = CrashApi.createInstance(context, customInfo, versionInfo, new b(), c, true, true, true);
        a = createInstance;
        createInstance.setCrashLogUploadUrl(c);
        if (com.ucpro.b.d.a.c()) {
            a.setNewInstall();
        }
        e.a("ic1");
        try {
            System.loadLibrary("crashsdk");
            a.crashSoLoaded();
        } catch (Exception e) {
        }
        e.a("ic2");
        a.registerInfoCallback("All Thread list:", 16);
    }

    public static void a(boolean z) {
        a.setForeground(z);
    }

    public static void a() {
        a.onExit();
    }

    public static void b() {
        if (!b.b()) {
            a.uploadCrashLogs();
        }
    }

    public static boolean a(StringBuffer stringBuffer, String str) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        customLogInfo.mAddHeader = true;
        customLogInfo.mAddFooter = true;
        customLogInfo.mAddLogcat = true;
        customLogInfo.mUploadNow = true;
        return a.generateCustomLog(customLogInfo);
    }

    public static void c() {
        a.setMainProcess();
    }

    public static void a(StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(stringBuffer);
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer2, "log");
        customLogInfo.mAddThreadsDump = true;
        customLogInfo.mDumpTids = new ArrayList();
        customLogInfo.mDumpTids.add(Integer.valueOf(Process.myPid()));
        customLogInfo.mDumpTids.add(Integer.valueOf(Process.myTid()));
        a.generateCustomLog(customLogInfo);
    }

    static /* synthetic */ String d() {
        StringBuilder stringBuilder = new StringBuilder();
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null) {
            Set<Thread> keySet = allStackTraces.keySet();
            stringBuilder.append("[JVM Threads Amount is:" + keySet.size() + "]");
            stringBuilder.append("\n");
            for (Thread thread : keySet) {
                stringBuilder.append(thread.getId());
                stringBuilder.append(":\t");
                stringBuilder.append(thread.getName());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
