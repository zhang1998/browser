package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.Environment;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLoader;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.c;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: ProGuard */
public abstract class UCSetupTask<RETURN_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>> extends UCSubSetupTask<RETURN_TYPE, CALLBACK_TYPE> {
    protected static final String LEGACY_EVENT_INIT = "init";
    protected static final String LEGACY_EVENT_LOAD = "load";
    protected static final String LEGACY_EVENT_SETUP = "setup";
    protected static final String LEGACY_EVENT_SWITCH = "switch";
    private static UCMRunningInfo b;
    private static UCSetupTask c;
    private static UCAsyncTask d;
    private static int e;
    private static boolean f = false;
    protected static final List<UCSetupTask> sTotalSetupTasks = new ArrayList(2);
    private UCMRunningInfo a;
    private String g = "";
    private a h;
    private boolean i;

    /* compiled from: ProGuard */
    public final class a {
        File a;
        File b;
        File c;
        public final ValueCallback<CALLBACK_TYPE> d = new bs(this);
        public final ValueCallback<CALLBACK_TYPE> e = new bt(this);
        final /* synthetic */ UCSetupTask f;

        static /* synthetic */ void a(a aVar) {
            Object obj = 1;
            boolean exists = aVar.a.exists();
            boolean exists2 = aVar.c.exists();
            if (aVar.b.exists()) {
                if (exists && exists2) {
                    if (System.currentTimeMillis() - Math.max(aVar.b.lastModified(), aVar.c.lastModified()) > 86400000) {
                        try {
                            aVar.b.delete();
                        } catch (Throwable th) {
                        }
                        try {
                            aVar.a.delete();
                            obj = null;
                        } catch (Throwable th2) {
                            obj = null;
                        }
                    } else {
                        aVar.f.g = Global.APOLLO_SERIES;
                        Boolean bool = (Boolean) aVar.f.getOption(UCCore.OPTION_MULTI_UNKNOWN_CRASH_DISABLE);
                        if (bool == null || !bool.booleanValue()) {
                            aVar.f.callback("crash_repeat");
                            return;
                        }
                        return;
                    }
                }
            } else if (!(exists && exists2)) {
                obj = null;
            }
            if (exists) {
                Integer num = (Integer) aVar.f.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
                if (num != null) {
                    aVar.f.setup(UCCore.OPTION_VERIFY_POLICY, Integer.valueOf(num.intValue() | 16));
                }
            }
            aVar.f.g = obj != null ? SettingsConst.TRUE : SettingsConst.FALSE;
            aVar.f.callback(obj != null ? "crash_seen" : "crash_none");
        }

        a(UCSetupTask uCSetupTask, String str) {
            this.f = uCSetupTask;
            if (this.a == null) {
                r2 = new Object[2];
                r2[0] = (File) UCMPackageInfo.invoke(10005, (Context) uCSetupTask.mOptions.get(UCCore.OPTION_CONTEXT));
                r2[1] = (String) UCMPackageInfo.invoke(10012, str);
                File file = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r2);
                Log.d("UCSetupTask", "SetupCrashImprover<init> UCSetupt.class: " + uCSetupTask.getClass());
                Log.d("UCSetupTask", "SetupCrashImprover<init> flgDirFile.path: " + file.getAbsolutePath());
                this.a = new File(file, "b36ce8d879e33bc88f717f74617ea05a");
                this.b = new File(file, "bd89426940609c9ae14e5ae90827201b");
                this.c = new File(file, "51bfcd9dd2f1379936c4fbb3558a6e67");
            }
        }

        protected final void a() {
            try {
                this.a.delete();
            } catch (Throwable th) {
            }
            try {
                this.c.delete();
            } catch (Throwable th2) {
            }
        }
    }

    protected a getSetupCrashImproverInst(String str) {
        if (this.h == null) {
            this.h = new a(this, str);
        }
        return this.h;
    }

    protected void resetCrashFlag() {
        if (this.h != null) {
            this.h.a();
        }
    }

    protected final String getCrashCode() {
        return this.g;
    }

    public static synchronized UCAsyncTask getRoot() {
        UCAsyncTask uCAsyncTask;
        synchronized (UCSetupTask.class) {
            if (d == null) {
                d = new bq(Integer.valueOf(e)).onEvent("start", new bp()).onEvent("die", new bo());
            }
            uCAsyncTask = d;
        }
        return uCAsyncTask;
    }

    protected final void setTotalLoadedUCM(UCMRunningInfo uCMRunningInfo) {
        b = uCMRunningInfo;
    }

    public static UCMRunningInfo getTotalLoadedUCM() {
        return b;
    }

    @Reflection
    public static Class<?> classForName(String str) throws ClassNotFoundException {
        UCMRunningInfo totalLoadedUCM = getTotalLoadedUCM();
        ClassLoader classLoader = totalLoadedUCM == null ? null : totalLoadedUCM.classLoader;
        if (classLoader == null) {
            return Class.forName(str);
        }
        return Class.forName(str, true, classLoader);
    }

    public static boolean isSetupThread() {
        return ((Boolean) getRoot().invokeO(UCAsyncTask.inThread, new Object[0])).booleanValue();
    }

    public static void resumeAll() {
        synchronized (sTotalSetupTasks) {
            for (int i = 0; i < sTotalSetupTasks.size(); i++) {
                ((UCSetupTask) sTotalSetupTasks.get(i)).resume();
            }
        }
    }

    public UCSetupTask() {
        synchronized (sTotalSetupTasks) {
            sTotalSetupTasks.add(this);
        }
    }

    public synchronized RETURN_TYPE start() {
        RETURN_TYPE return_type;
        if (invokeO(10005, new Object[0]) == null) {
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_SETUP_THREAD_PRIORITY);
            UCLogger create = UCLogger.create("d", "UCSetupTask");
            if (create != null) {
                create.print("start: setup_priority=" + num, new Throwable[0]);
            }
            if (num != null) {
                setRootTaskPriority(num.intValue());
            }
            invoke(10001, getRoot());
            return_type = (UCSetupTask) super.start();
            r1.start();
        } else {
            UCSetupTask uCSetupTask = (UCSetupTask) super.start();
        }
        return return_type;
    }

    private void a(boolean z, boolean z2) {
        Log.d("UCSetupTask", "setPringLogBaseOnConfig overrideConfig: " + z + " enable: " + z2);
        Object[] objArr = (Object[]) this.mOptions.get(UCCore.OPTION_LOG_CONFIG);
        if (objArr != null || z) {
            if (objArr == null) {
                objArr = new Object[]{Boolean.valueOf(z2), Boolean.valueOf(true), null, "[all]", "[all]"};
            }
            if (z) {
                objArr[0] = Boolean.valueOf(z2);
            }
            if (objArr.length == 5) {
                SDKFactory.invoke(10048, objArr[0], objArr);
            }
        }
    }

    protected void setupGlobalOnce() {
        Log.d("UCSetupTask", "setupGlobalOnce");
        if (!f) {
            String str;
            UCLogger create;
            Object[] objArr;
            Integer num;
            Boolean a;
            Object[] objArr2;
            int i;
            boolean z;
            f = true;
            Context applicationContext = ((Context) this.mOptions.get(UCCore.OPTION_CONTEXT)).getApplicationContext();
            setup(UCCore.OPTION_CONTEXT, applicationContext);
            Object obj = (String) getOption(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
            String str2 = UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION;
            if (d.a((String) obj)) {
                obj = SettingsConst.FALSE;
            }
            UCCore.setGlobalOption(str2, obj);
            try {
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "initializeCDPreferences", new Class[]{Context.class}, new Object[]{applicationContext});
            } catch (Exception e) {
            }
            if (!Log.sPrintLog) {
                try {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "uclogconfig.apk");
                    if (file.exists() && file.isFile() && file.length() <= 3000 && c.a(file.getAbsolutePath(), applicationContext, applicationContext, "com.UCMobile", null)) {
                        str = (String) ReflectionUtil.invoke(new UCLoader(file.getAbsolutePath(), applicationContext.getCacheDir().getAbsolutePath(), null, UCSetupTask.class.getClassLoader()).loadClass("com.uc.webview.uclogconfig.UCSDKLogConfig"), "getEnabledDate", null, null);
                        str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date());
                        if (str != null && str.length() >= 8 && str2 != null && str2.length() >= 8 && str.startsWith(str2)) {
                            UCCore.setPrintLog(true);
                            create = UCLogger.create("d", "UCSetupTask");
                            objArr = (Object[]) this.mOptions.get(UCCore.OPTION_LOG_CONFIG);
                            if (create != null) {
                                create.print("setupGlobalOnce: log_conf=" + Arrays.toString(objArr), new Throwable[0]);
                            }
                            Log.d("UCSetupTask", "new_url setupNewUrl　OPTION_UCM_UPD_URL: " + this.mOptions.get(UCCore.OPTION_UCM_UPD_URL));
                            if (this.mOptions.get(UCCore.OPTION_UCM_UPD_URL) != null) {
                                str = (String) this.mOptions.get(UCCore.OPTION_UCM_UPD_URL);
                                try {
                                    ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupBusinessTemplateForUrl", new Class[]{String.class}, new Object[]{str});
                                } catch (Exception e2) {
                                }
                            }
                            ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupSetupTask", new Class[]{UCSetupTask.class}, new Object[]{this});
                            ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupVMSizeSavingSample", new Class[]{UCSetupTask.class, UCLogger.class}, new Object[]{this, create});
                            ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupVMSizeSavingBlackList", new Class[]{UCSetupTask.class, UCLogger.class}, new Object[]{this, create});
                            ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setCDParamLegacy");
                            SDKFactory.invoke(UCMPackageInfo.getKernelFileIfMultiCoreFromDir, applicationContext);
                            num = (Integer) this.mOptions.get(UCCore.OPTION_WEBVIEW_POLICY);
                            if (create != null) {
                                create.print("setupGlobalOnce: WEBVIEW_POLICY=" + num, new Throwable[0]);
                            }
                            if (num != null) {
                                SDKFactory.j = num.intValue();
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_USE_SDK_SETUP);
                            if (create != null) {
                                create.print("setupGlobalOnce: sdk_setup=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                SDKFactory.m = a.booleanValue();
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_MULTI_CORE_TYPE);
                            if (create != null) {
                                create.print("setupGlobalOnce: MULTI_CORE_TYPE=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                SDKFactory.k = a.booleanValue();
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_HARDWARE_ACCELERATED);
                            if (create != null) {
                                create.print("setupGlobalOnce: AC=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                SDKFactory.h = a.booleanValue() ? 1 : 0;
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED);
                            if (create != null) {
                                create.print("setupGlobalOnce: VIDEO_AC=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                objArr2 = new Object[1];
                                if (a.booleanValue()) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                objArr2[0] = Integer.valueOf(i);
                                SDKFactory.invoke(UCMPackageInfo.isDirShouldBeDeleted, objArr2);
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_GRANT_ALL_BUILDS);
                            if (!applicationContext.getPackageName().equals("com.ucsdk.cts") || (a != null && a.booleanValue())) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (create != null) {
                                create.print("setupGlobalOnce: grant_all_builds=" + z, new Throwable[0]);
                            }
                            if (z) {
                                SDKFactory.r = true;
                            }
                            num = (Integer) this.mOptions.get(UCCore.OPTION_CONNECTION_CONNECT_TIMEOUT);
                            if (create != null) {
                                create.print("setupGlobalOnce: conn_to=" + num, new Throwable[0]);
                            }
                            if (num != null) {
                                d.a = num.intValue();
                            }
                            num = (Integer) this.mOptions.get(UCCore.OPTION_CONNECTION_READ_TIMEOUT);
                            if (create != null) {
                                create.print("setupGlobalOnce: read_to=" + num, new Throwable[0]);
                            }
                            if (num != null) {
                                d.b = num.intValue();
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_EXACT_OLD_KERNEL_CHECK);
                            if (create != null) {
                                create.print("setupGlobalOnce: exact_old=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                SDKFactory.l = a.booleanValue();
                            }
                            a = d.a(this.mOptions, UCCore.OPTION_EXACT_LAST_MODIFIED_CHECK);
                            if (create != null) {
                                create.print("setupGlobalOnce: exact_mod=" + a, new Throwable[0]);
                            }
                            if (a != null) {
                                d.c = a.booleanValue();
                            }
                            num = (Integer) this.mOptions.get(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS);
                            if (create != null) {
                                create.print("setupGlobalOnce: wait_fallback_sys=" + num, new Throwable[0]);
                            }
                            if (num != null) {
                                SDKFactory.i = (long) num.intValue();
                            }
                            obj = this.mOptions.get(UCCore.OPTION_UC_PLAYER_ROOT);
                            if (create != null) {
                                create.print("setupGlobalOnce: ucPlayerRoot=" + obj, new Throwable[0]);
                            }
                            if (obj != null) {
                                SDKFactory.t = obj.toString();
                            }
                            obj = this.mOptions.get(UCCore.OPTION_USE_UC_PLAYER);
                            if (create != null) {
                                create.print("setupGlobalOnce: ucPlayer=" + obj, new Throwable[0]);
                            }
                            if (obj != null) {
                                SDKFactory.s = ((Boolean) obj).booleanValue();
                            }
                        }
                    }
                } catch (Throwable th) {
                }
            }
            this.i = false;
            try {
                obj = ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "createBusinessTemplate", new Class[]{String.class, String.class, Object.class, ValueCallback.class}, new Object[]{"print_log", "true", null, new br(this)});
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "addKeyListener", new Class[]{String.class, ValueCallback.class}, new Object[]{"print_log", obj});
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupBusinessMathod", new Class[]{obj.getClass()}, new Object[]{obj});
            } catch (Exception e3) {
            }
            if (!(this.i || Log.sPrintLog)) {
                a(false, true);
            }
            UCCyclone.enableDebugLog = Log.sPrintLog;
            create = UCLogger.create("d", "UCSetupTask");
            objArr = (Object[]) this.mOptions.get(UCCore.OPTION_LOG_CONFIG);
            if (create != null) {
                create.print("setupGlobalOnce: log_conf=" + Arrays.toString(objArr), new Throwable[0]);
            }
            Log.d("UCSetupTask", "new_url setupNewUrl　OPTION_UCM_UPD_URL: " + this.mOptions.get(UCCore.OPTION_UCM_UPD_URL));
            if (this.mOptions.get(UCCore.OPTION_UCM_UPD_URL) != null) {
                str = (String) this.mOptions.get(UCCore.OPTION_UCM_UPD_URL);
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupBusinessTemplateForUrl", new Class[]{String.class}, new Object[]{str});
            }
            try {
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupSetupTask", new Class[]{UCSetupTask.class}, new Object[]{this});
            } catch (Exception e4) {
            }
            try {
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupVMSizeSavingSample", new Class[]{UCSetupTask.class, UCLogger.class}, new Object[]{this, create});
            } catch (Exception e5) {
            }
            try {
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setupVMSizeSavingBlackList", new Class[]{UCSetupTask.class, UCLogger.class}, new Object[]{this, create});
            } catch (Exception e6) {
            }
            try {
                ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "setCDParamLegacy");
            } catch (Exception e7) {
            }
            SDKFactory.invoke(UCMPackageInfo.getKernelFileIfMultiCoreFromDir, applicationContext);
            num = (Integer) this.mOptions.get(UCCore.OPTION_WEBVIEW_POLICY);
            if (create != null) {
                create.print("setupGlobalOnce: WEBVIEW_POLICY=" + num, new Throwable[0]);
            }
            if (num != null) {
                SDKFactory.j = num.intValue();
            }
            a = d.a(this.mOptions, UCCore.OPTION_USE_SDK_SETUP);
            if (create != null) {
                create.print("setupGlobalOnce: sdk_setup=" + a, new Throwable[0]);
            }
            if (a != null) {
                SDKFactory.m = a.booleanValue();
            }
            a = d.a(this.mOptions, UCCore.OPTION_MULTI_CORE_TYPE);
            if (create != null) {
                create.print("setupGlobalOnce: MULTI_CORE_TYPE=" + a, new Throwable[0]);
            }
            if (a != null) {
                SDKFactory.k = a.booleanValue();
            }
            a = d.a(this.mOptions, UCCore.OPTION_HARDWARE_ACCELERATED);
            if (create != null) {
                create.print("setupGlobalOnce: AC=" + a, new Throwable[0]);
            }
            if (a != null) {
                if (a.booleanValue()) {
                }
                SDKFactory.h = a.booleanValue() ? 1 : 0;
            }
            a = d.a(this.mOptions, UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED);
            if (create != null) {
                create.print("setupGlobalOnce: VIDEO_AC=" + a, new Throwable[0]);
            }
            if (a != null) {
                objArr2 = new Object[1];
                if (a.booleanValue()) {
                    i = 0;
                } else {
                    i = 1;
                }
                objArr2[0] = Integer.valueOf(i);
                SDKFactory.invoke(UCMPackageInfo.isDirShouldBeDeleted, objArr2);
            }
            a = d.a(this.mOptions, UCCore.OPTION_GRANT_ALL_BUILDS);
            if (applicationContext.getPackageName().equals("com.ucsdk.cts")) {
            }
            z = true;
            if (create != null) {
                create.print("setupGlobalOnce: grant_all_builds=" + z, new Throwable[0]);
            }
            if (z) {
                SDKFactory.r = true;
            }
            num = (Integer) this.mOptions.get(UCCore.OPTION_CONNECTION_CONNECT_TIMEOUT);
            if (create != null) {
                create.print("setupGlobalOnce: conn_to=" + num, new Throwable[0]);
            }
            if (num != null) {
                d.a = num.intValue();
            }
            num = (Integer) this.mOptions.get(UCCore.OPTION_CONNECTION_READ_TIMEOUT);
            if (create != null) {
                create.print("setupGlobalOnce: read_to=" + num, new Throwable[0]);
            }
            if (num != null) {
                d.b = num.intValue();
            }
            a = d.a(this.mOptions, UCCore.OPTION_EXACT_OLD_KERNEL_CHECK);
            if (create != null) {
                create.print("setupGlobalOnce: exact_old=" + a, new Throwable[0]);
            }
            if (a != null) {
                SDKFactory.l = a.booleanValue();
            }
            a = d.a(this.mOptions, UCCore.OPTION_EXACT_LAST_MODIFIED_CHECK);
            if (create != null) {
                create.print("setupGlobalOnce: exact_mod=" + a, new Throwable[0]);
            }
            if (a != null) {
                d.c = a.booleanValue();
            }
            num = (Integer) this.mOptions.get(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS);
            if (create != null) {
                create.print("setupGlobalOnce: wait_fallback_sys=" + num, new Throwable[0]);
            }
            if (num != null) {
                SDKFactory.i = (long) num.intValue();
            }
            obj = this.mOptions.get(UCCore.OPTION_UC_PLAYER_ROOT);
            if (create != null) {
                create.print("setupGlobalOnce: ucPlayerRoot=" + obj, new Throwable[0]);
            }
            if (obj != null) {
                SDKFactory.t = obj.toString();
            }
            obj = this.mOptions.get(UCCore.OPTION_USE_UC_PLAYER);
            if (create != null) {
                create.print("setupGlobalOnce: ucPlayer=" + obj, new Throwable[0]);
            }
            if (obj != null) {
                SDKFactory.s = ((Boolean) obj).booleanValue();
            }
        }
    }

    protected final void setLoadedUCM(UCMRunningInfo uCMRunningInfo) {
        this.a = uCMRunningInfo;
    }

    @Reflection
    public final UCMRunningInfo getLoadedUCM() {
        return this.a;
    }

    protected static void setRootTaskPriority(int i) {
        e = i;
    }

    public static UCSetupTask getDefault() {
        return c;
    }

    protected void setDefault(UCSetupTask uCSetupTask) {
        c = uCSetupTask;
    }
}
