package com.uc.webview.export.internal.interfaces;

import android.util.Pair;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.uc.wa.a;
import com.uc.webview.export.internal.uc.wa.a.b;
import com.uc.webview.export.internal.uc.wa.c;
import com.uc.webview.export.internal.uc.wa.d;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api
/* compiled from: ProGuard */
public interface IWaStat {
    public static final String ACTIVATE_PUSH_PROCESS = "sdk_act_pp";
    public static final String ACTIVATE_PUSH_PROCESS_DEFAUT_CONFIG = "sdk_act_pp_default_cfg";
    public static final String ACTIVATE_PUSH_PROCESS_UCM_CD = "sdk_act_pp_ucm_cd";
    public static final String CD_CP_TYPE_IP = "cd_cp_ip";
    public static final String CD_CP_TYPE_LOCATION = "cd_cp_lo";
    public static final String CD_DISPATCH_REQUEST_TASK = "dis_req_task";
    public static final String CD_INIT_TASK_COUNT = "cd_init_task";
    public static final String CD_INIT_TASK_SUCCESS = "cd_init_suc";
    public static final String CD_SWITCH_STAT = "CD_SWITCH_STAT";
    public static final String CD_UTDID_FAILURE = "cd_utdid_fai";
    public static final String CD_UTDID_SUCCESS = "cd_utdid_suc";
    public static final String CORE_DOWNLOAD = "sdk_cdl";
    public static final String CORE_ERROR_CODE_DOWNLOAD = "sdk_ecdl0";
    public static final String CORE_ERROR_CODE_UNZIP = "sdk_ecuz0";
    public static final String CORE_ERROR_CODE_UPDATE_CHECK_REQUEST = "sdk_ecur0";
    public static final String CORE_ERROR_CODE_VERIFY = "sdk_ecv0";
    public static final String DEC = "sdk_dec";
    public static final String DEC_EXCEPTION = "sdk_dec_e";
    public static final String DEC_SUCCESS = "sdk_dec_s";
    public static final String DEC_ZIP = "sdk_decz";
    public static final String DEC_ZIP_SUCCESS = "sdk_decz_s";
    public static final String DOWNLOAD = "sdk_dl";
    public static final String DOWNLOAD_EXCEPTION = "sdk_dl_e";
    public static final String DOWNLOAD_EXISTS = "sdk_dl_x";
    public static final String DOWNLOAD_FAILED = "sdk_dl_f";
    public static final String DOWNLOAD_RECOVERED = "sdk_dl_r";
    public static final String DOWNLOAD_SUCCESS = "sdk_dl_s";
    public static final String ERROR_CODE_INIT = "sdk_eci";
    public static final String KEY_ART = "art";
    public static final String KEY_CLASS = "cls";
    public static final String KEY_CNT = "cnt";
    public static final String KEY_CODE = "code";
    public static final String KEY_COST = "cost";
    public static final String KEY_COST_CPU = "cost_cpu";
    public static final String KEY_CPU_CNT = "cpu_cnt";
    public static final String KEY_CPU_FREQ = "cpu_freq";
    public static final String KEY_CRASH = "crash";
    public static final String KEY_DATA = "data";
    public static final String KEY_DIR = "dir";
    public static final String KEY_DVM = "dvm";
    public static final String KEY_DVM2 = "dvm2";
    public static final String KEY_ENABLE = "enable";
    public static final String KEY_ERRNO = "err";
    public static final String KEY_FIRST_RUN = "frun";
    public static final String KEY_FREE_DISK_SPACE = "free_disk_space";
    public static final String KEY_FREE_DISK_SPACE_BEFORE = "free_disk_space_before";
    public static final String KEY_HOOK_RUN_AS_EXPECTED = "run_expected";
    public static final String KEY_HOOK_SUCCESS = "hook_succ";
    public static final String KEY_LINK_SO_CODE = "link_so_code";
    public static final String KEY_MESSAGE = "msg";
    public static final String KEY_MULTI_CORE = "multi_core";
    public static final String KEY_OLD = "old";
    public static final String KEY_PRIORITY = "pri";
    public static final String KEY_SDK_INT = "sdk_int";
    public static final String KEY_SUCCESS = "succ";
    public static final String KEY_TASK = "task";
    public static final String KEY_WIFI = "wifi";
    public static final int MERGE_ADD = 0;
    public static final int MERGE_REPLACE = 1;
    public static final String MIDDLEWARE_CD_DISPATCH_REQUEST = "mid_cd_dis_req";
    public static final String MIDDLEWARE_CD_EXCEPTION = "mid_cd_parse_ex";
    public static final String MIDDLEWARE_CD_FAILURE = "mid_cd_parse_fai";
    public static final String MIDDLEWARE_CD_FILE_EXCEPTION = "mid_file_cd_parse_ex";
    public static final String MIDDLEWARE_CD_FILE_FAILURE = "mid_file_cd_parse_fai";
    public static final String MIDDLEWARE_CD_FILE_NOT_EXIST = "mid_file_cd_exi";
    public static final String MIDDLEWARE_CD_FILE_PARSE = "mid_file_cd_parse";
    public static final String MIDDLEWARE_CD_FILE_SUCCESS = "mid_file_cd_parse_suc";
    public static final String MIDDLEWARE_CD_JS_UPDATE = "mid_cd_js_update";
    public static final String MIDDLEWARE_CD_PARSE = "mid_cd_parse";
    public static final String MIDDLEWARE_CD_PARSE_PARAM_ILLEGAL = "mid_cd_parse_ill";
    public static final String MIDDLEWARE_CD_RESPOND_DO_BACKGROUND = "mid_cd_req_do_bac";
    public static final String MIDDLEWARE_CD_RESPOND_FAILURE = "mid_cd_req_fai";
    public static final String MIDDLEWARE_CD_RESPOND_FINISH = "mid_cd_req_fin";
    public static final String MIDDLEWARE_CD_RESPOND_RECEIVE = "mid_cd_req_rec";
    public static final String MIDDLEWARE_CD_RESPOND_STATUS_CODE = "mid_cd_req_st_co";
    public static final String MIDDLEWARE_CD_RESPOND_SUCCESS = "mid_cd_req_suc";
    public static final String MIDDLEWARE_CD_SUCCESS = "mid_cd_parse_suc";
    public static final String SETPARAM_CD_ISSUED_FAILURE = "setparam_cd_parse_failure";
    public static final String SETPARAM_CD_ISSUED_SUCCESS = "setparam_cd_parse_success";
    public static final String SETPARAM_CD_PARSE = "setparam_cd_parse";
    public static final String SETUP_CUR_UCCORE_COST_HOUR = "stp_curuc_hour";
    public static final String SETUP_DEFAULT_EXCEPTION = "sdk_stp_def_exc";
    public static final String SETUP_DELETE_CORE_COUNT = "sdk_stp_dcc";
    public static final String SETUP_EXTRA_EXCEPTION = "sdk_stp_ext_exc";
    public static final String SETUP_REPAIR_EXCEPTION = "sdk_stp_rep_exc";
    public static final String SETUP_START = "sdk_stp";
    public static final String SETUP_START_FINISH = "sdk_stp_fi";
    public static final String SETUP_SUCCESS = "sdk_stp_suc";
    public static final String SETUP_SUCCESS_INITED = "sdk_stp_i";
    public static final String SETUP_SUCCESS_LOADED = "sdk_stp_l";
    public static final String SETUP_SUCCESS_SETUPED = "sdk_stp_s";
    public static final String SETUP_TASK_DEXOPT = "sdk_opt";
    public static final String SETUP_TASK_HOOKDEX = "sdk_hookdex";
    public static final String SETUP_TASK_INIT = "sdk_ini";
    public static final String SETUP_TASK_LIBARY = "sdk_lib";
    public static final String SETUP_TASK_UCDEXOPT = "sdk_ucdexopt";
    public static final String SETUP_TASK_UPDATE = "sdk_upd";
    public static final String SETUP_TASK_VERIFY = "sdk_vrf";
    public static final String SETUP_TOTAL_EXCEPTION = "sdk_stp_exc";
    public static final String SETUP_UCCORE_COST_HOUR = "stp_uc_hour";
    public static final String SEVENZIP = "sdk_7z";
    public static final String SEVENZIP_CLEARHTTPCACHE = "sdk_7z_clear_httpcache";
    public static final String SEVENZIP_EXCEPTION_CRC = "sdk_7z_e3";
    public static final String SEVENZIP_EXCEPTION_FAILED = "sdk_7z_e1";
    public static final String SEVENZIP_EXCEPTION_MEM = "sdk_7z_e2";
    public static final String SEVENZIP_FILE = "sdk_7z_f";
    public static final String SEVENZIP_FILE_SUCCESS = "sdk_7z_fs";
    public static final String SEVENZIP_LIB = "sdk_7z_l";
    public static final String SEVENZIP_LIB_SUCCESS = "sdk_7z_ls";
    public static final String SEVENZIP_SUCCESS = "sdk_7z_s";
    public static final String UCM = "sdk_ucm";
    public static final String UCM_DISK_MB = "sdk_ucm_dm";
    public static final String UCM_DISK_PERCENT = "sdk_ucm_dp";
    public static final String UCM_EXCEPTION_CHECK = "sdk_ucm_en";
    public static final String UCM_EXCEPTION_DOWNLOAD = "sdk_ucm_e1";
    public static final String UCM_EXCEPTION_UPDATE = "sdk_dec7z";
    public static final String UCM_EXISTS = "sdk_ucm_e";
    public static final String UCM_FAILED_DOWNLOAD = "sdk_dec7z_s";
    public static final String UCM_FAILED_VERIFY = "sdk_dec7z_ls";
    public static final String UCM_LAST_EXCEPTION = "sdk_ucm_le";
    public static final String UCM_OLD = "sdk_ucm_old";
    public static final String UCM_PERCENT = "sdk_ucm_p";
    public static final String UCM_RECOVERED = "sdk_ucm_f";
    public static final String UCM_SUCCESS = "sdk_ucm_s";
    public static final String UCM_WIFI = "sdk_ucm_wifi";
    public static final String US_CP_DISPATCH_REQUEST = "us_cp_dis_req";
    public static final String US_CP_RESPOND_FAILURE = "us_cp_req_fai";
    public static final String US_CP_RESPOND_RECEIVE = "us_cp_req_rec";
    public static final String US_CP_RESPOND_STATUS_CODE = "us_cp_req_st_co";
    public static final String US_CP_RESPOND_SUCCESS = "us_cp_req_suc";
    public static final String UTDID_KEY = "ut_k";
    public static final String VIDEO_AC = "sdk_vac";
    public static final String VIDEO_DOWNLOAD = "sdk_vdl";
    public static final String VIDEO_DOWNLOAD_SUCCESS = "sdk_vdls";
    public static final String VIDEO_ERROR_CODE_DOWNLOAD = "sdk_ecdl1";
    public static final String VIDEO_ERROR_CODE_UNZIP = "sdk_ecuz1";
    public static final String VIDEO_ERROR_CODE_UPDATE_CHECK_REQUEST = "sdk_ecur1";
    public static final String VIDEO_ERROR_CODE_VERIFY = "sdk_ecv1";
    public static final String VIDEO_UNZIP = "sdk_vz";
    public static final String VIDEO_UNZIP_SUCCESS = "sdk_vzs";
    public static final String WV_NEW_AFTER = "sdk_wv_a";
    public static final String WV_NEW_BEFORE = "sdk_wv_b";

    @Api
    /* compiled from: ProGuard */
    public class WaStat {
        static ISaveListener a = null;

        @Api
        /* compiled from: ProGuard */
        public interface ISaveListener {
            void onWillSave();
        }

        public static void statPV(String str) {
            if (a.a() != null) {
                a a = a.a();
                if (!a.b()) {
                    return;
                }
                if (com.uc.webview.export.internal.utility.a.a(str)) {
                    a.a("ill_upv");
                    return;
                }
                if (a.a) {
                    a.a = false;
                    IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
                    if (iGlobalSettings != null) {
                        int intValue = iGlobalSettings.getIntValue(SettingKeys.SdkStatFileLimit);
                        if (intValue != 0 && intValue < a.e) {
                            a.d = intValue;
                            a.f = intValue + 1024;
                        }
                    }
                    a.b.postDelayed(new c(a), 1000);
                }
                String toLowerCase = str.toLowerCase();
                if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
                    if (Utils.sWAPrintLog) {
                        Log.d("SDKWaStat", "statPV:" + toLowerCase);
                    }
                    a.a("sum_pv");
                    return;
                }
                a.a("ill_upv");
                return;
            }
            Log.w("SDKWaStat", "statPV>>WaStatImp not inited");
        }

        public static void stat(String str) {
            if (str instanceof String) {
                a(str);
            } else if (str instanceof Pair) {
                statAKV((Pair) str);
            }
        }

        private static void a(String str) {
            try {
                if (a.a() != null) {
                    a.a().a(str);
                } else {
                    Log.w("SDKWaStat", "stat>>WaStatImp not inited");
                }
            } catch (Throwable th) {
            }
        }

        public static void statAdd(String str, int i) {
            try {
                if (a.a() != null) {
                    a a = a.a();
                    if (a.b()) {
                        a.a(str, 0, 0, i, null);
                        return;
                    }
                    return;
                }
                Log.w("SDKWaStat", "stat>>WaStatImp not inited");
            } catch (Throwable th) {
            }
        }

        public static void statAverage(String str, int i) {
            try {
                if (a.a() != null) {
                    a a = a.a();
                    if (a.b()) {
                        a.a(str, 2, 0, i, null);
                        return;
                    }
                    return;
                }
                Log.w("SDKWaStat", "stat>>WaStatImp not inited");
            } catch (Throwable th) {
            }
        }

        public static void stat(String str, String str2) {
            try {
                if (a.a() != null) {
                    a a = a.a();
                    if (a.b()) {
                        a.a(str, 1, 1, 0, str2);
                        return;
                    }
                    return;
                }
                Log.w("SDKWaStat", "stat>>WaStatImp not inited");
            } catch (Throwable th) {
            }
        }

        public static void stat(String str, String str2, int i) {
            try {
                if (a.a() != null) {
                    a a = a.a();
                    if (a.b()) {
                        a.a(str, 1, i, 0, str2);
                        return;
                    }
                    return;
                }
                Log.w("SDKWaStat", "stat>>WaStatImp not inited");
            } catch (Throwable th) {
            }
        }

        public static void stat(Pair<String, HashMap<String, String>> pair) {
            if (pair instanceof Pair) {
                statAKV(pair);
            } else if (pair instanceof String) {
                a((String) pair);
            }
        }

        public static void statAKV(Pair<String, HashMap<String, String>> pair) {
            try {
                if (a.a() != null) {
                    a a = a.a();
                    a.a((Pair) pair);
                    if (a.b()) {
                        if (100 < ((HashMap) pair.second).toString().length() && Utils.sWAPrintLog) {
                            Log.d("SDKWaStat", "second length(" + ((HashMap) pair.second).toString().length() + ") more then 100");
                        }
                        synchronized (a.h) {
                            if (a.c == null) {
                                a.c = new ArrayList();
                            }
                            ((HashMap) pair.second).put("tm", a.g.format(new Date(System.currentTimeMillis())));
                            a.c.add(new b(a, (String) pair.first, (Map) pair.second));
                        }
                        return;
                    }
                    return;
                }
                Log.w("SDKWaStat", "stat>>WaStatImp not inited");
            } catch (Throwable th) {
            }
        }

        public static void saveData() {
            if (a != null) {
                a.onWillSave();
            }
            if (a.a() != null) {
                a.a().a(false);
            }
        }

        public static void saveData(boolean z) {
            if (a != null) {
                a.onWillSave();
            }
            if (a.a() != null) {
                a.a().a(z);
            }
        }

        public static void setSaveListener(ISaveListener iSaveListener) {
            a = iSaveListener;
        }

        public static void upload() {
            if (a.a() != null) {
                a a = a.a();
                if (a.b() && !com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                    a.b.postDelayed(new d(a), 15000);
                }
            }
        }
    }
}
