package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.UCMobile.Apollo.Global;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.extension.BreakpadConfig;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class t extends UCSubSetupTask<t, t> {
    private String a = null;

    public final void run() {
        String str;
        String str2;
        Object obj;
        Object obj2;
        Object obj3;
        String str3;
        String str4;
        String str5;
        UCElapseTime uCElapseTime;
        HashMap hashMap;
        File file;
        UCSetupException uCSetupException;
        File file2;
        String str6;
        Object obj4;
        UCSetupException e;
        Object obj5 = null;
        SDKFactory.c = this.mCL;
        CoreFactory.updateLazy();
        Context context = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
        String str7 = this.mUCM.soDirPath;
        BreakpadConfig breakpadConfig = (BreakpadConfig) this.mOptions.get(UCCore.OPTION_BREAKPAD_CONFIG);
        if (breakpadConfig != null) {
            a.a(context, str7, breakpadConfig);
        }
        if (this.a == null) {
            this.a = this.mUCM.mainLibrary;
        }
        try {
            str = (String) this.mUCM.coreImplModule.first;
            try {
                str2 = (String) this.mUCM.coreImplModule.second;
                try {
                    obj = str;
                    String str8 = str2;
                    obj2 = this.mUCM.resDirPath;
                    obj3 = str8;
                } catch (Throwable th) {
                    str3 = str2;
                    str4 = str;
                    obj2 = null;
                    str5 = "4";
                    uCElapseTime = new UCElapseTime();
                    str = (String) getOption(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
                    hashMap = new HashMap();
                    hashMap.put("ucm_dex_path", obj);
                    hashMap.put("ucm_odex_path", obj3);
                    hashMap.put("ucm_private_data_dir_suffix", str);
                    hashMap.put("ucm_paks_resource_dir", obj2);
                    if (d.a(str7)) {
                        str = str5;
                        obj2 = null;
                    } else {
                        file = new File(str7);
                        if (file.isDirectory()) {
                            hashMap.put("ucm_corelib_path", file.getAbsolutePath());
                            CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                            str = SettingsConst.TRUE;
                            obj2 = 1;
                        } else {
                            throw new UCSetupException((int) SettingsConst.ENABLE_MEDIA_SERVICE, String.format("Directory expected for LibraryTask but [%s] given.", new Object[]{str7}));
                        }
                    }
                    obj5 = obj2;
                    uCSetupException = null;
                    if (obj5 == null) {
                        try {
                            file2 = new File(context.getApplicationInfo().nativeLibraryDir);
                            if (new File(file2, new StringBuilder(ShareConstants.SO_PATH).append(this.a).append(".so").toString()).exists()) {
                                hashMap.put("ucm_corelib_path", file2.getAbsolutePath());
                                CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                                str6 = Global.APOLLO_SERIES;
                            } else {
                                str6 = str;
                            }
                            obj4 = str6;
                        } catch (UCSetupException e2) {
                            e = e2;
                            if (uCSetupException != null) {
                                e = uCSetupException;
                            }
                            uCSetupException = e;
                        } catch (Throwable th2) {
                            if (uCSetupException == null) {
                                uCSetupException = new UCSetupException((int) SettingsConst.PRELOAD_CD_PARAMS, th2);
                            }
                        }
                    }
                    callbackStat(new Pair(IWaStat.SETUP_TASK_LIBARY, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj4).set("cost_cpu", String.valueOf(uCElapseTime.getMilisCpu())).set("cost", String.valueOf(uCElapseTime.getMilis())).set("data", uCSetupException == null ? "" : String.valueOf(uCSetupException.errCode()))));
                    if (uCSetupException == null) {
                        callbackStat(new Pair(IWaStat.SETUP_SUCCESS_LOADED, null));
                    }
                    throw uCSetupException;
                }
            } catch (Throwable th3) {
                str2 = null;
                str3 = str2;
                str4 = str;
                obj2 = null;
                str5 = "4";
                uCElapseTime = new UCElapseTime();
                str = (String) getOption(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
                hashMap = new HashMap();
                hashMap.put("ucm_dex_path", obj);
                hashMap.put("ucm_odex_path", obj3);
                hashMap.put("ucm_private_data_dir_suffix", str);
                hashMap.put("ucm_paks_resource_dir", obj2);
                if (d.a(str7)) {
                    file = new File(str7);
                    if (file.isDirectory()) {
                        throw new UCSetupException((int) SettingsConst.ENABLE_MEDIA_SERVICE, String.format("Directory expected for LibraryTask but [%s] given.", new Object[]{str7}));
                    }
                    hashMap.put("ucm_corelib_path", file.getAbsolutePath());
                    CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                    str = SettingsConst.TRUE;
                    obj2 = 1;
                } else {
                    str = str5;
                    obj2 = null;
                }
                obj5 = obj2;
                uCSetupException = null;
                if (obj5 == null) {
                    file2 = new File(context.getApplicationInfo().nativeLibraryDir);
                    if (new File(file2, new StringBuilder(ShareConstants.SO_PATH).append(this.a).append(".so").toString()).exists()) {
                        hashMap.put("ucm_corelib_path", file2.getAbsolutePath());
                        CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                        str6 = Global.APOLLO_SERIES;
                    } else {
                        str6 = str;
                    }
                    obj4 = str6;
                }
                if (uCSetupException == null) {
                }
                callbackStat(new Pair(IWaStat.SETUP_TASK_LIBARY, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj4).set("cost_cpu", String.valueOf(uCElapseTime.getMilisCpu())).set("cost", String.valueOf(uCElapseTime.getMilis())).set("data", uCSetupException == null ? "" : String.valueOf(uCSetupException.errCode()))));
                if (uCSetupException == null) {
                    throw uCSetupException;
                }
                callbackStat(new Pair(IWaStat.SETUP_SUCCESS_LOADED, null));
            }
        } catch (Throwable th4) {
            str2 = null;
            str = null;
            str3 = str2;
            str4 = str;
            obj2 = null;
            str5 = "4";
            uCElapseTime = new UCElapseTime();
            str = (String) getOption(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
            hashMap = new HashMap();
            hashMap.put("ucm_dex_path", obj);
            hashMap.put("ucm_odex_path", obj3);
            hashMap.put("ucm_private_data_dir_suffix", str);
            hashMap.put("ucm_paks_resource_dir", obj2);
            if (d.a(str7)) {
                str = str5;
                obj2 = null;
            } else {
                file = new File(str7);
                if (file.isDirectory()) {
                    hashMap.put("ucm_corelib_path", file.getAbsolutePath());
                    CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                    str = SettingsConst.TRUE;
                    obj2 = 1;
                } else {
                    throw new UCSetupException((int) SettingsConst.ENABLE_MEDIA_SERVICE, String.format("Directory expected for LibraryTask but [%s] given.", new Object[]{str7}));
                }
            }
            obj5 = obj2;
            uCSetupException = null;
            if (obj5 == null) {
                file2 = new File(context.getApplicationInfo().nativeLibraryDir);
                if (new File(file2, new StringBuilder(ShareConstants.SO_PATH).append(this.a).append(".so").toString()).exists()) {
                    str6 = str;
                } else {
                    hashMap.put("ucm_corelib_path", file2.getAbsolutePath());
                    CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                    str6 = Global.APOLLO_SERIES;
                }
                obj4 = str6;
            }
            if (uCSetupException == null) {
            }
            callbackStat(new Pair(IWaStat.SETUP_TASK_LIBARY, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj4).set("cost_cpu", String.valueOf(uCElapseTime.getMilisCpu())).set("cost", String.valueOf(uCElapseTime.getMilis())).set("data", uCSetupException == null ? "" : String.valueOf(uCSetupException.errCode()))));
            if (uCSetupException == null) {
                callbackStat(new Pair(IWaStat.SETUP_SUCCESS_LOADED, null));
            }
            throw uCSetupException;
        }
        str5 = "4";
        uCElapseTime = new UCElapseTime();
        str = (String) getOption(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
        hashMap = new HashMap();
        hashMap.put("ucm_dex_path", obj);
        hashMap.put("ucm_odex_path", obj3);
        hashMap.put("ucm_private_data_dir_suffix", str);
        hashMap.put("ucm_paks_resource_dir", obj2);
        try {
            if (d.a(str7)) {
                file = new File(str7);
                if (file.isDirectory()) {
                    throw new UCSetupException((int) SettingsConst.ENABLE_MEDIA_SERVICE, String.format("Directory expected for LibraryTask but [%s] given.", new Object[]{str7}));
                }
                hashMap.put("ucm_corelib_path", file.getAbsolutePath());
                CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                str = SettingsConst.TRUE;
                obj2 = 1;
            } else {
                str = str5;
                obj2 = null;
            }
            obj5 = obj2;
            uCSetupException = null;
        } catch (UCSetupException e3) {
            uCSetupException = e3;
            str = str5;
        } catch (Throwable th5) {
            uCSetupException = new UCSetupException((int) SettingsConst.PRELOAD_CD_PARAMS, th5);
            str = str5;
        }
        if (obj5 == null) {
            file2 = new File(context.getApplicationInfo().nativeLibraryDir);
            if (new File(file2, new StringBuilder(ShareConstants.SO_PATH).append(this.a).append(".so").toString()).exists()) {
                hashMap.put("ucm_corelib_path", file2.getAbsolutePath());
                CoreFactory.initUCMobileWebkitCoreSoEnv(context, hashMap);
                str6 = Global.APOLLO_SERIES;
            } else {
                str6 = str;
            }
            obj4 = str6;
        }
        try {
            if (uCSetupException == null) {
            }
            callbackStat(new Pair(IWaStat.SETUP_TASK_LIBARY, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj4).set("cost_cpu", String.valueOf(uCElapseTime.getMilisCpu())).set("cost", String.valueOf(uCElapseTime.getMilis())).set("data", uCSetupException == null ? "" : String.valueOf(uCSetupException.errCode()))));
        } catch (Throwable th6) {
        }
        if (uCSetupException == null) {
            throw uCSetupException;
        }
        callbackStat(new Pair(IWaStat.SETUP_SUCCESS_LOADED, null));
    }
}
