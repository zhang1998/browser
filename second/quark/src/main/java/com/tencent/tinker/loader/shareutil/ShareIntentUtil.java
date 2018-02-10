package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class ShareIntentUtil {
    public static final String INTENT_DEPLOYMENT_BASE_ID = "intent_deployment_base_id";
    public static final String INTENT_DEPLOYMENT_EXPECT_VERSION = "intent_expect_version";
    public static final String INTENT_DEPLOYMENT_LIB_ABI_CFG = "intent_lib_abi_cfg";
    public static final String INTENT_DEPLOYMENT_VERSION_FILE_DIR = "intent_patch_verson_file_dir";
    public static final String INTENT_DEPLOYMENT_VERSION_LOADED = "intent_patch_version_loaded";
    public static final String INTENT_LOAD_TOTAL_COST = "intent_load_total_cost";
    public static final String INTENT_PATCH_DEX_COST = "intent_patch_load_dex_cost";
    public static final String INTENT_PATCH_DEX_PATH = "intent_patch_dex_path";
    public static final String INTENT_PATCH_INTERNAL_COST = "intent_patch_internal_cost";
    public static final String INTENT_PATCH_LOAD_EXCEPTION = "inent_patch_load_exception";
    public static final String INTENT_PATCH_LOAD_FAIL_RECORDS = "intent_patch_load_fail_records";
    public static final String INTENT_PATCH_ODEX_PATH = "intent_patch_odex_path";
    public static final String INTENT_PATCH_RES_COST = "intent_patch_load_res_cost";
    public static final String INTENT_PATCH_RES_PATH = "intent_patch_res_path";
    public static final String INTENT_PATCH_SO_COST = "intent_patch_load_so_cost";
    public static final String INTENT_PATCH_SYSTEM_OTA = "intent_patch_system_ota";
    public static final String INTENT_RETURN_CODE = "intent_return_code";
    public static final String INTENT_ROLLBACK_TYPE = "intent_rollback_type";
    public static final String INTENT_START_TIMESTAMP = "intent_start_timestamp";
    private static final String TAG = "ShareIntentUtil";

    public static void setIntentPatchCostTime(Intent intent, long j) {
        intent.putExtra(INTENT_LOAD_TOTAL_COST, j);
    }

    public static Throwable getIntentPatchException(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_LOAD_EXCEPTION);
        if (serializableExtra != null) {
            return (Throwable) serializableExtra;
        }
        return null;
    }

    public static List<ShareLoadPatchResult> getPatchLoadFailRecords(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_LOAD_FAIL_RECORDS);
        if (serializableExtra != null) {
            return (ArrayList) serializableExtra;
        }
        return new ArrayList();
    }

    public static String getStringExtra(Intent intent, String str) {
        String str2 = null;
        if (intent != null) {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                Log.e(TAG, "getStringExtra exception:" + e.getMessage());
            }
        }
        return str2;
    }

    public static Serializable getSerializableExtra(Intent intent, String str) {
        Serializable serializable = null;
        if (intent != null) {
            try {
                serializable = intent.getSerializableExtra(str);
            } catch (Exception e) {
                Log.e(TAG, "getSerializableExtra exception:" + e.getMessage());
            }
        }
        return serializable;
    }

    public static int getIntExtra(Intent intent, String str, int i) {
        if (intent != null) {
            try {
                i = intent.getIntExtra(str, i);
            } catch (Exception e) {
                Log.e(TAG, "getIntExtra exception:" + e.getMessage());
            }
        }
        return i;
    }

    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        if (intent != null) {
            try {
                z = intent.getBooleanExtra(str, z);
            } catch (Exception e) {
                Log.e(TAG, "getBooleanExtra exception:" + e.getMessage());
            }
        }
        return z;
    }

    public static long getLongExtra(Intent intent, String str, long j) {
        if (intent != null) {
            try {
                j = intent.getLongExtra(str, j);
            } catch (Exception e) {
                Log.e(TAG, "getIntExtra exception:" + e.getMessage());
            }
        }
        return j;
    }
}
