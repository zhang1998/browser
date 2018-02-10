package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCDex;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
public class ae extends SetupTask {
    private static Stack<UCSetupTask> b = new Stack();
    public s a;
    private s c;
    private Context d;
    private UCElapseTime e;
    private UCSetupException f;
    private UCSetupTask g;
    private ValueCallback<s> h;
    private ValueCallback<s> i;
    private boolean j = false;
    private List<at> k;
    private final ValueCallback<s> l = new af(this);
    private final ValueCallback<s> m = new ag(this);
    private final ValueCallback<s> n = new ah(this);

    public final void a(String str, Callable<Boolean> callable) {
        s sVar = (s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) new bu().invoke(10001, UCSetupTask.getRoot())).setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, null)).setup(UCCore.OPTION_USE_SDK_SETUP, Boolean.valueOf(true))).setup("chkMultiCore", Boolean.valueOf(true))).onEvent("stat", this.h != null ? this.h : new a(this))).onEvent("switch", new ak(this))).onEvent("downloadException", new aj(this))).onEvent("updateProgress", new ai(this));
        this.a = sVar;
        this.c = sVar;
        if (callable != null) {
            this.c.setup(UCCore.OPTION_DOWNLOAD_CHECKER, callable);
        }
        if (!d.a(str)) {
            this.c.setup(UCCore.OPTION_UCM_UPD_URL, str);
        }
    }

    private s b() {
        s sVar;
        String str = (String) this.mOptions.get(UCCore.OPTION_DEX_FILE_PATH);
        if (d.a(str)) {
            str = (String) this.mOptions.get(UCCore.OPTION_UCM_ZIP_FILE);
            if (d.a(str)) {
                str = (String) this.mOptions.get(UCCore.OPTION_UCM_LIB_DIR);
                if (d.a(str)) {
                    str = (String) this.mOptions.get(UCCore.OPTION_UCM_KRL_DIR);
                    if (d.a(str)) {
                        str = (String) this.mOptions.get(UCCore.OPTION_UCM_CFG_FILE);
                        if (d.a(str)) {
                            sVar = null;
                        } else {
                            sVar = (s) a(new be(), str).setup(UCCore.OPTION_UCM_CFG_FILE, str);
                        }
                    } else {
                        sVar = (s) a(new be(), str).setup(UCCore.OPTION_UCM_KRL_DIR, str);
                    }
                } else {
                    Boolean bool = (Boolean) this.mOptions.get(UCCore.OPTION_FORBID_GEN_REPAIR_DIR);
                    if (bool == null || !bool.booleanValue()) {
                        b.push(a(new ad(), "RepairSetupTask_" + str).setup(UCCore.OPTION_UCM_LIB_DIR, str));
                    }
                    sVar = (s) a(new be(), str).setup(UCCore.OPTION_UCM_LIB_DIR, str);
                }
            } else {
                sVar = (s) a(new m(), str).setup(UCCore.OPTION_UCM_ZIP_FILE, str);
            }
        } else {
            sVar = (s) ((s) ((s) a(new be(), str).setup(UCCore.OPTION_DEX_FILE_PATH, str)).setup(UCCore.OPTION_SO_FILE_PATH, getOption(UCCore.OPTION_SO_FILE_PATH))).setup(UCCore.OPTION_RES_FILE_PATH, getOption(UCCore.OPTION_RES_FILE_PATH));
        }
        if (!d.a((String) getOption(UCCore.OPTION_UCM_UPD_URL))) {
            a(null, null);
            File file = (File) UCMPackageInfo.invoke(10002, this.d);
            if (file.list().length > 0) {
                if (sVar != null) {
                    b.push(sVar);
                }
                String absolutePath = file.getAbsolutePath();
                return (s) ((s) a(new be(), absolutePath).setup("chkDecFinish", Boolean.valueOf(true))).setup(UCCore.OPTION_UCM_KRL_DIR, absolutePath);
            }
        } else if (sVar == null) {
            throw new UCSetupException(3017, "At least 1 of OPTION_DEX_FILE_PATH|OPTION_UCM_LIB_DIR|OPTION_UCM_KRL_DIR|OPTION_UCM_CFG_FILE|OPTION_UCM_UPD_URL should be given.");
        }
        if (sVar == null) {
            sVar = a(new be(), "");
        }
        return sVar;
    }

    private s a(s sVar) {
        ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) sVar.invoke(10001, this)).setOptions(this.mOptions)).onEvent("setup", this.i)).onEvent(UCCore.OPTION_LOAD_KERNEL_TYPE, this.i)).onEvent("init", this.i)).onEvent("switch", this.i)).onEvent("stat", this.h)).onEvent("success", this.l)).onEvent("exception", this.m);
        return sVar;
    }

    private s a(s sVar, String str) {
        ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) a(sVar).setup(UCCore.OPTION_DEX_FILE_PATH, null)).setup(UCCore.OPTION_SO_FILE_PATH, null)).setup(UCCore.OPTION_RES_FILE_PATH, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, null)).setup(UCCore.OPTION_UCM_LIB_DIR, null)).setup(UCCore.OPTION_UCM_KRL_DIR, null)).setup(UCCore.OPTION_UCM_CFG_FILE, null)).onEvent("start", sVar.getSetupCrashImproverInst(str).d)).onEvent("die", sVar.getSetupCrashImproverInst(str).e)).onEvent("crash_none", null)).onEvent("crash_seen", null)).onEvent("crash_repeat", this.n);
        return sVar;
    }

    public void run() {
        this.e = new UCElapseTime();
        ((SetupTask) setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_USE_SDK_SETUP, Boolean.valueOf(true));
        setupGlobalOnce();
        this.d = (Context) getOption(UCCore.OPTION_CONTEXT);
        this.j = ((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue();
        onEvent("stat", new al(this, (ValueCallback) invokeO(10007, "stat")));
        callbackStat(new Pair(IWaStat.SETUP_START, null));
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
        this.i = new UCAsyncTask.a(this);
        this.h = new a(this);
        UCSetupTask a = a(new ba());
        if (d.a(d.a(this.mOptions, UCCore.OPTION_USE_SYSTEM_WEBVIEW))) {
            b.push(a);
            if (this.j) {
                String str = (String) this.mOptions.get(UCCore.OPTION_SO_FILE_PATH);
                ((s) ((s) a(new bc(), "ThickSetupTask_" + str).setup(UCCore.OPTION_SO_FILE_PATH, str)).setup(UCCore.OPTION_RES_FILE_PATH, (String) this.mOptions.get(UCCore.OPTION_RES_FILE_PATH))).start();
                SDKFactory.a("Thick SDK");
                return;
            }
            Object obj = (String) this.mOptions.get(UCCore.OPTION_LOAD_POLICY);
            if (obj == null) {
                obj = UCCore.LOAD_POLICY_UCMOBILE_OR_SPECIFIED;
            }
            if (UCCore.LOAD_POLICY_SHARE_CORE.equals(obj)) {
                a(new bn(), "UCMobileSetupTask").start();
                return;
            } else if (UCCore.LOAD_POLICY_SPECIFIED_ONLY.equals(obj)) {
                b().start();
                return;
            } else if (UCCore.LOAD_POLICY_SPECIFIED_OR_UCMOBILE.equals(obj)) {
                b.push(a(new bn(), "UCMobileSetupTask"));
                b().start();
                return;
            } else {
                b.push(b());
                a(new bn(), "UCMobileSetupTask").start();
                return;
            }
        }
        a.start();
    }
}
