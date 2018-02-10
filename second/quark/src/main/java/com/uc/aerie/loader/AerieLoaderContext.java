package com.uc.aerie.loader;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.uc.aerie.loader.stable.AerieLoaderConfig;
import java.io.File;

/* compiled from: ProGuard */
public class AerieLoaderContext {
    private static final String TAG = "AerieLoaderContext";
    private static String baseDv;
    private static String cpuAbiCfg;
    private static String loadDexPath;
    private static String loadDv;
    private static LoadMasterResult loadMasterResult;
    private static String loadOdexPath;
    private static String loadPatchFileDir;
    private static String loadResPath;
    private static long startMillisTime;

    public static void init(Intent intent) {
        baseDv = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_DEPLOYMENT_BASE_ID);
        loadDv = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_LOADED);
        loadPatchFileDir = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_DEPLOYMENT_VERSION_FILE_DIR);
        cpuAbiCfg = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_DEPLOYMENT_LIB_ABI_CFG);
        startMillisTime = ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_START_TIMESTAMP, 0);
        loadResPath = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_RES_PATH);
        loadDexPath = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_DEX_PATH);
        loadOdexPath = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_ODEX_PATH);
        int intExtra = ShareIntentUtil.getIntExtra(intent, ShareIntentUtil.INTENT_RETURN_CODE, ShareConstants.ERROR_LOAD_UNDEFINE);
        long longExtra = ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_LOAD_TOTAL_COST, 0);
        long longExtra2 = ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_PATCH_INTERNAL_COST, 0);
        long longExtra3 = ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_PATCH_DEX_COST, 0);
        long longExtra4 = ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_PATCH_RES_COST, 0);
        ShareIntentUtil.getLongExtra(intent, ShareIntentUtil.INTENT_PATCH_SO_COST, 0);
        loadMasterResult = new LoadMasterResult(loadDv, intExtra, longExtra, longExtra2, longExtra3, longExtra4, longExtra4, ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_DEPLOYMENT_EXPECT_VERSION), ShareIntentUtil.getIntExtra(intent, ShareIntentUtil.INTENT_ROLLBACK_TYPE, -1), ShareIntentUtil.getIntentPatchException(intent), ShareIntentUtil.getPatchLoadFailRecords(intent));
        Log.e(TAG, "AerieLoaderContext loader:" + AerieLoaderContext.class.getClassLoader().toString());
    }

    public static String getBaseDv() {
        return baseDv;
    }

    public static String getLoadDv() {
        return loadDv;
    }

    public static String getCpuAbiCfg() {
        return cpuAbiCfg;
    }

    public static String getLoadPatchFileDir() {
        return loadPatchFileDir;
    }

    public static long getStartMillisTime() {
        return startMillisTime;
    }

    public static String getLoadResPath() {
        return TextUtils.isEmpty(loadResPath) ? null : loadResPath;
    }

    public static String getLoadDexPath() {
        Log.wtf(TAG, "getLoadDexPath:" + loadDexPath);
        return TextUtils.isEmpty(loadDexPath) ? null : loadDexPath;
    }

    public static String getLoadOdexPath() {
        Log.wtf(TAG, "getLoadOdexPath:" + loadOdexPath);
        return TextUtils.isEmpty(loadOdexPath) ? null : loadOdexPath;
    }

    public static boolean isDeployed() {
        return !TextUtils.equals(baseDv, loadDv);
    }

    public static LoadMasterResult getLoadMasterResult() {
        return loadMasterResult;
    }

    public static boolean loadLibrary(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("libName should not be null.");
        }
        if (isDeployed()) {
            String str2 = getLoadPatchFileDir() + "/lib/" + getCpuAbiCfg() + "/" + System.mapLibraryName(str);
            if (new File(str2).exists()) {
                Log.wtf(TAG, "load " + str);
                System.load(str2);
                return true;
            }
        }
        return false;
    }

    public static String getAerieLibDir() {
        if (isDeployed()) {
            File file = new File(getLoadPatchFileDir() + "/lib/" + getCpuAbiCfg());
            if (file.exists() && file.isDirectory() && file.listFiles().length > 0) {
                return file.getAbsolutePath();
            }
        }
        return "";
    }

    public static boolean hasDeployLibs() {
        return !TextUtils.isEmpty(getAerieLibDir());
    }

    public static boolean hasDeploySpecificLib(String str) {
        Object aerieLibDir = getAerieLibDir();
        if (TextUtils.isEmpty(aerieLibDir) || !new File(aerieLibDir, System.mapLibraryName(str)).exists()) {
            return false;
        }
        return true;
    }

    public static boolean isEnableClassN() {
        return AerieLoaderConfig.isClassesNEnable();
    }
}
