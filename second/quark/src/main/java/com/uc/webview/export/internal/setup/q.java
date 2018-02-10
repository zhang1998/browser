package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.extension.ILocationManager;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.Utils;

/* compiled from: ProGuard */
public final class q extends UCSubSetupTask<q, q> {
    private static final boolean a = (VERSION.SDK_INT >= 14);
    private boolean b = false;

    /* compiled from: ProGuard */
    final class a implements ILocationManager {
        final /* synthetic */ q a;
        private LocationManager b;

        public a(q qVar, Context context) {
            this.a = qVar;
            this.b = (LocationManager) context.getSystemService("location");
        }

        public final void requestLocationUpdates(String str, long j, float f, LocationListener locationListener) {
            if (this.b != null) {
                this.b.requestLocationUpdates(str, j, f, locationListener);
            }
        }

        public final void requestLocationUpdatesWithUrl(String str, long j, float f, LocationListener locationListener, String str2) {
            if (this.b != null) {
                this.b.requestLocationUpdates(str, j, f, locationListener);
            }
        }

        public final void removeUpdates(LocationListener locationListener) {
            if (this.b != null) {
                this.b.removeUpdates(locationListener);
            }
        }
    }

    protected final void a() {
        boolean z;
        Log.d("InitTask", "runImpl");
        UCElapseTime uCElapseTime = new UCElapseTime();
        Context context = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
        boolean a = d.a((Boolean) this.mOptions.get(UCCore.OPTION_USE_SDK_SETUP));
        if (!a) {
            CoreFactory.a(context);
            try {
                CookieSyncManager.createInstance(context);
            } catch (RuntimeException e) {
            }
        }
        boolean z2 = SDKFactory.h == -1 ? a && Utils.checkSupportSamplerExternalOES() : SDKFactory.h == 1;
        UCMobileWebKit initUCMobileWebKit = CoreFactory.initUCMobileWebKit(context, z2, false);
        if (!a) {
            if (((Integer) SDKFactory.invoke(UCMPackageInfo.makeDirDeleteFlg, new Object[0])).intValue() == -1 || ((Integer) SDKFactory.invoke(UCMPackageInfo.makeDirDeleteFlg, new Object[0])).intValue() != 1) {
                z = false;
            } else {
                z = true;
            }
            if (!z2 && r1) {
                Log.e("InitTask", "UC Core not support Hardware accelerated.");
                z = false;
            }
            if (VERSION.SDK_INT < 14) {
                if (z) {
                    Log.e("InitTask", "Video Hardware accelerated is supported start at api level 14 and now is " + VERSION.SDK_INT);
                }
                CoreFactory.l().setBoolValue(SettingKeys.EnableVideoSurfaceTexture, false);
            } else {
                CoreFactory.l().setBoolValue(SettingKeys.EnableVideoSurfaceTexture, z);
                if (z) {
                    SDKFactory.invoke(10001, Long.valueOf(1048576));
                }
            }
            initUCMobileWebKit.setLocationManagerUC(new a(this, context));
            if (((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue() && !SDKFactory.k && ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
                throw new UCSetupException(3016, String.format("Init success but disallow switch from android to [%d].", new Object[]{CoreFactory.getCoreType()}));
            }
        }
        int i = ((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue() ? 1 : this.mUCM.isSpecified ? 2 : 3;
        SDKFactory.n = i;
        SDKFactory.d = initUCMobileWebKit;
        SDKFactory.invoke(10021, Integer.valueOf(CoreFactory.getCoreType().intValue()));
        if (!a) {
            SDKFactory.invoke(UCMPackageInfo.expectDirFile1S, new Object[0]);
            if (!this.mUCM.isSpecified) {
                if (((Boolean) SDKFactory.invoke(UCMPackageInfo.expectCreateDirFile2P, context, this.mUCM.pkgName)).booleanValue()) {
                    SDKFactory.invoke(10001, Long.valueOf(524288));
                }
            }
            SDKFactory.invoke(UCMPackageInfo.deleteUCMSDKDir, this.mOptions);
            SDKFactory.invoke(10034, context);
            IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
            if (iGlobalSettings != null) {
                if (this.mOptions.containsKey(UCCore.OPTION_WAP_DENY)) {
                    Object obj = this.mOptions.get(UCCore.OPTION_WAP_DENY);
                    iGlobalSettings.setStringValue(SettingKeys.SDK_Wap_Deny, obj == null ? "" : obj.toString());
                    Log.d("InitTask", "initProxySettings: setStringValue: SDKWapDeny = " + obj.toString());
                }
                if (this.mOptions.containsKey(UCCore.OPTION_UC_PROXY_ADBLOCK)) {
                    String str;
                    IGlobalSettings iGlobalSettings2;
                    Object obj2 = this.mOptions.get(UCCore.OPTION_UC_PROXY_ADBLOCK);
                    if (obj2 instanceof String) {
                        str = SettingKeys.Enable_Proxy_Ad_Block;
                        z = Boolean.parseBoolean((String) obj2);
                        iGlobalSettings2 = iGlobalSettings;
                    } else {
                        str = SettingKeys.Enable_Proxy_Ad_Block;
                        if (obj2 == null) {
                            z = false;
                            iGlobalSettings2 = iGlobalSettings;
                        } else {
                            z = ((Boolean) obj2).booleanValue();
                            iGlobalSettings2 = iGlobalSettings;
                        }
                    }
                    iGlobalSettings2.setBoolValue(str, z);
                }
                iGlobalSettings.setStringValue(SettingKeys.UBISiProfileId, Build.SDK_PROFILE_ID);
                iGlobalSettings.setStringValue(SettingKeys.UBISiPrd, Build.SDK_PRD);
            }
        }
        if (((Boolean) SDKFactory.invoke(10052, new Object[0])).booleanValue()) {
            SDKFactory.a(false);
        }
        callbackStat(new Pair(IWaStat.SETUP_TASK_INIT, new UCHashMap().set("cnt", SettingsConst.TRUE).set("data", a ? "ucm" : "sdk").set("cost_cpu", String.valueOf(uCElapseTime.getMilisCpu())).set("cost", String.valueOf(uCElapseTime.getMilis()))));
        callbackStat(new Pair(IWaStat.SETUP_SUCCESS_INITED, null));
    }

    public final void run() {
        Boolean bool = (Boolean) getOption(UCCore.OPTION_INIT_IN_SETUP_THREAD);
        if (bool != null) {
            this.b = !bool.booleanValue();
        }
        if (this.b) {
            Pair a;
            bf bfVar = new bf();
            synchronized (bfVar) {
                SDKFactory.invoke(UCMPackageInfo.compareVersion, new r(this, bfVar));
                a = bfVar.a(60000);
            }
            if (((Integer) a.first).intValue() == 3) {
                setException(a.second instanceof UCSetupException ? (UCSetupException) a.second : new UCSetupException((int) SettingsConst.SINFO_SO_CHILD_VERSION, (Throwable) a.second));
                return;
            } else if (((Integer) a.first).intValue() == 1) {
                setException(new UCSetupException(4024, "Init timeout(60000ms)"));
                return;
            } else {
                return;
            }
        }
        a();
    }
}
