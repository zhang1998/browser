package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.Build;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCDex;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Interface
/* compiled from: ProGuard */
public class BrowserSetupTask extends SetupTask {
    private static BrowserSetupTask a;
    private static final int[] k = new int[]{1008, 2008, SettingsConst.ENABLE_FULL_SCREEN, SettingsConst.PRELOAD_CD_PARAMS, 4007};
    private static final int[] l = new int[]{1003, 1006, 2001};
    private s b;
    private s c = null;
    private s d;
    private Context e;
    private File f = null;
    private UCElapseTime g;
    private long h;
    private ValueCallback<s> i;
    private ValueCallback<s> j;
    private final ValueCallback<s> m = new a(this);
    private final ValueCallback<s> n = new c(this);

    static /* synthetic */ void a(String str, s sVar) {
        Object obj = null;
        if (sVar != null && sVar.getException() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append("action:").append(str).append("\n");
                stringBuffer.append("error code: ").append(sVar.getException().errCode()).append("\n");
                stringBuffer.append("class name: ").append(sVar.getException().getRootCause().getClass().getName()).append("\n");
                stringBuffer.append("message: ").append(sVar.getException().getRootCause().getMessage()).append("\n");
                stringBuffer.append("kernel file hash: ").append(SetupTask.sFirstUCM).append("\n");
                stringBuffer.append("root stack trace").append(Log.getStackTraceString(sVar.getException().getRootCause())).append("\n");
            } catch (Exception e) {
            }
            String str2 = "kernel";
            try {
                Class cls = Class.forName("com.uc.crashsdk.export.CrashApi");
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                    Method method = cls.getMethod("generateCustomLog", new Class[]{StringBuffer.class, String.class, Bundle.class});
                    try {
                        obj = declaredMethod.invoke(null, null);
                    } catch (IllegalAccessException e2) {
                    } catch (IllegalArgumentException e3) {
                    } catch (InvocationTargetException e4) {
                    }
                    if (obj != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("mAddHeader", true);
                        bundle.putBoolean("mAddFooter", true);
                        bundle.putBoolean("mAddLogcat", true);
                        bundle.putBoolean("mUploadNow", true);
                        bundle.putBoolean("mAddThreadsDump", false);
                        try {
                            method.invoke(obj, new Object[]{stringBuffer, str2, bundle});
                        } catch (IllegalAccessException e5) {
                        } catch (IllegalArgumentException e6) {
                        } catch (InvocationTargetException e7) {
                        }
                    }
                } catch (Exception e8) {
                }
            } catch (Exception e9) {
            }
        }
    }

    static /* synthetic */ void i(BrowserSetupTask browserSetupTask) {
        Context context = (Context) browserSetupTask.getOption(UCCore.OPTION_CONTEXT);
        Boolean valueOf = Boolean.valueOf(true);
        try {
            File file = (File) UCMPackageInfo.invoke(10003, context);
            File file2 = new File(file.getAbsolutePath() + String.format("_bad_%s", new Object[]{Long.valueOf(SystemClock.uptimeMillis())}));
            file.renameTo(file2);
            File[] listFiles = file2.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                if (valueOf.booleanValue() || listFiles.length >= 2) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        for (File recursiveDelete : listFiles2) {
                            UCCyclone.recursiveDelete(recursiveDelete, false, null);
                        }
                    }
                    file2.delete();
                }
            }
        } catch (Throwable th) {
        }
    }

    public boolean isNeedRestartError(int i) {
        for (int i2 : k) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isNoDiskSpaceError(int i) {
        for (int i2 : l) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static synchronized BrowserSetupTask getInstance() {
        BrowserSetupTask browserSetupTask;
        synchronized (BrowserSetupTask.class) {
            if (a == null) {
                a = new BrowserSetupTask();
            }
            browserSetupTask = a;
        }
        return browserSetupTask;
    }

    public void run() {
        this.g = new UCElapseTime();
        this.h = SystemClock.currentThreadTimeMillis();
        setupGlobalOnce();
        this.e = (Context) getOption(UCCore.OPTION_CONTEXT);
        onEvent("stat", new d(this, (ValueCallback) invokeO(10007, "stat")));
        try {
            ValueCallback yVar = new y();
            UCCyclone.statCallback = yVar;
            ((y) ((y) ((y) yVar).invoke(10001, UCSetupTask.getRoot())).onEvent("stat", new a(this))).start();
        } catch (Throwable th) {
        }
        try {
            new UCAsyncTask(new UCDex()).invoke(10001, UCSetupTask.getRoot()).start(5000);
        } catch (Throwable th2) {
        }
        this.j = new UCAsyncTask.a(this);
        this.i = new a(this);
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) setup(UCCore.OPTION_DEX_FILE_PATH, null)).setup(UCCore.OPTION_SO_FILE_PATH, null)).setup(UCCore.OPTION_RES_FILE_PATH, null)).setup(UCCore.OPTION_UCM_UPD_URL, null)).setup(UCCore.OPTION_UCM_CFG_FILE, null)).setup(UCCore.OPTION_UCM_KRL_DIR, null);
        if (getOption(UCCore.OPTION_SHARE_CORE) == null) {
            setup(UCCore.OPTION_SHARE_CORE, Boolean.valueOf(true));
        }
        String str = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
        if (!d.a(str)) {
            this.f = new File(str);
        }
        callbackStat(new Pair(IWaStat.SETUP_START, new UCHashMap().set("cnt", SettingsConst.TRUE).set("data", (d.a((String) getOption(UCCore.OPTION_UCM_LIB_DIR)) ? "LIB:N" : "LIB:Y") + "," + (d.a((String) getOption(UCCore.OPTION_UCM_ZIP_DIR)) ? "ZIP:N" : "ZIP:Y") + "," + (d.a((Boolean) getOption(UCCore.OPTION_INIT_IN_SETUP_THREAD)) ? "IIST:F" : "IIST:T") + "," + (d.a((Boolean) getOption(UCCore.OPTION_HARDWARE_ACCELERATED)) ? "HA:F" : "HA:T") + ",VP:" + String.valueOf((Integer) getOption(UCCore.OPTION_VERIFY_POLICY)) + ",WP:" + String.valueOf((Integer) getOption(UCCore.OPTION_WEBVIEW_POLICY)) + ",CD_LD:" + String.valueOf(SDKFactory.invoke(10005, UCCore.OPTION_LOAD_KERNEL_TYPE)) + ",CD_SOEK:" + String.valueOf(SDKFactory.invoke(10005, UCCore.OPTION_SKIP_OLD_KERNEL)) + ",PT:" + String.valueOf(Build.PACK_TYPE) + ",KF:" + (this.f == null ? "N" : "Y")).set("cpu_cnt", d.a()).set("cpu_freq", d.b())));
        boolean booleanValue = ((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue();
        if (d.a((String) getOption(UCCore.OPTION_UCM_LIB_DIR)) && !booleanValue) {
            throw new UCSetupException((int) SettingsConst.SHOW_DEFAULT_CONTROLLER_GESTURE_GUIDE, String.format("Option [%s] expected.", new Object[]{UCCore.OPTION_UCM_LIB_DIR}));
        } else if (booleanValue) {
            r1 = new bc();
            ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) r1.invoke(10001, this)).setOptions(this.mOptions)).onEvent("setup", this.j)).onEvent(UCCore.OPTION_LOAD_KERNEL_TYPE, this.j)).onEvent("init", this.j)).onEvent("switch", this.j)).onEvent("stat", this.i)).onEvent("success", this.m)).onEvent("exception", this.n);
            r1.start();
            SDKFactory.a("Thick SDK");
        } else {
            s sVar;
            if (Boolean.valueOf(false).booleanValue()) {
                sVar = (s) ((s) ((s) ((s) ((s) ((s) am.a(this.mOptions).invoke(10001, this)).setup(UCCore.OPTION_UCM_ZIP_FILE, this.f.getAbsolutePath())).onEvent("success", this.m)).onEvent("exception", new j(this))).onEvent("stat", new a(this))).onEvent("setup", new i(this));
            } else {
                ValueCallback aVar = new UCAsyncTask.a(this);
                sVar = (s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) new be().invoke(10001, this)).setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).onEvent("stat", new a(this))).onEvent("success", this.m)).onEvent("setup", aVar)).onEvent(UCCore.OPTION_LOAD_KERNEL_TYPE, aVar)).onEvent("init", aVar)).onEvent("switch", aVar)).onEvent("exception", new h(this));
            }
            this.b = sVar;
            if (!(this.f == null || Boolean.valueOf(false).booleanValue())) {
                this.c = (s) ((s) ((s) ((s) ((s) ((s) new m().setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_LIB_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, this.f.getAbsolutePath())).onEvent("stat", new a(this))).onEvent("setup", new e(this));
                File file = (File) UCMPackageInfo.invoke(10003, this.e);
                if (file.list().length > 0) {
                    r1 = new be();
                    this.d = r1;
                    ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) r1.invoke(10001, this)).setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_ZIP_FILE, this.f.getAbsolutePath())).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_UCM_LIB_DIR, null)).setup(UCCore.OPTION_UCM_KRL_DIR, file.getAbsolutePath())).setup("chkDecFinish", Boolean.valueOf(true))).onEvent("stat", new a(this))).onEvent("success", this.m)).onEvent("start", this.d.getSetupCrashImproverInst(file.getAbsolutePath()).d)).onEvent("die", this.d.getSetupCrashImproverInst(file.getAbsolutePath()).e)).onEvent("crash_none", null)).onEvent("crash_seen", null)).onEvent("crash_repeat", new g(this, file))).onEvent("exception", new f(this))).start();
                    return;
                }
            }
            if (Boolean.valueOf(false).booleanValue() && k.a(this.e)) {
                setException(new UCSetupException(1012, String.format("Setup Failure No Disk space [%s].", new Object[]{Float.valueOf(k.a)})), false);
                callStatException(IWaStat.SETUP_DEFAULT_EXCEPTION, getException());
                callback("exception");
                return;
            }
            this.b.start();
        }
    }

    public void startDecompressSetupTask(Context context, String str, ValueCallback<Pair<String, HashMap<String, String>>> valueCallback) {
        ((am) ((am) ((am) new am().setup(UCCore.OPTION_CONTEXT, context)).setup(UCCore.OPTION_UCM_ZIP_FILE, str)).setup("stat", valueCallback)).start();
    }
}
