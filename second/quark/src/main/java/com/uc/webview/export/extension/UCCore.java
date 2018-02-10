package com.uc.webview.export.extension;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.INetLogger;
import com.uc.webview.export.internal.interfaces.INetwork;
import com.uc.webview.export.internal.interfaces.INetworkDecider;
import com.uc.webview.export.internal.interfaces.INetworkDelegate;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bu;
import com.uc.webview.export.internal.setup.s;
import com.uc.webview.export.internal.setup.u;
import com.uc.webview.export.internal.uc.b;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.SetupTask;
import com.uc.webview.export.utility.download.UpdateTask;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

@Api
/* compiled from: ProGuard */
public class UCCore {
    public static final String ADAPTER_BUILD_TIMING = "adapter_build_timing";
    public static final String ADAPTER_BUILD_VERSOPM = "adapter_build_version";
    public static final String CD_DISABLE_UCDNS = "disable_ucdns";
    public static final String CD_ENABLE_NET_THREAD_REDUCE = "dec_thread";
    public static final String CD_ENABLE_TRAFFIC_STAT = "traffic_stat";
    public static final int COMPATIBLE_POLICY_ALL = 7;
    public static final int COMPATIBLE_POLICY_ARMV5 = 1;
    public static final int COMPATIBLE_POLICY_ARMV7 = 2;
    public static final int COMPATIBLE_POLICY_X86 = 4;
    public static final int CORE_EVENT_CLEAR_DNS_CACHE = 0;
    public static final int CORE_EVENT_CLEAR_HTTP_CACHE = 3;
    public static final int CORE_EVENT_CONSOLE_CALLBACK = 6;
    public static final int CORE_EVENT_DELETE_SERVICEWORKER_CACHE = 4;
    public static final int CORE_EVENT_DELETE_SERVICEWORKER_CACHE_SYNC = 9;
    public static final int CORE_EVENT_GET_HTTP_CACHE_SIZE = 1;
    public static final int CORE_EVENT_HTTP2_HOST_LIST = 8;
    public static final int CORE_EVENT_MAX_REQUEST_LIMITATION = 7;
    public static final int CORE_EVENT_PUSH_DNS_RESULT = 5;
    public static final int CORE_EVENT_SERVICEWORKER_PUSHMESSAGE = 2;
    public static final int DELETE_CORE_POLICY_ALL = 63;
    public static final int DELETE_CORE_POLICY_FILE_VERIFY_FAILED = 16;
    public static final int DELETE_CORE_POLICY_LOAD_SO_ERROR = 2;
    public static final int DELETE_CORE_POLICY_MULTI_CRASH = 4;
    public static final int DELETE_CORE_POLICY_NONE = 0;
    public static final int DELETE_CORE_POLICY_OTHER = 32;
    public static final int DELETE_CORE_POLICY_SO_MD5_MISMATCH = 8;
    public static final int DELETE_CORE_POLICY_SO_SIZE_MISMATCH = 1;
    public static final String ENABLE_WEBVIEW_LISTENER_STANDARDIZATION_OPTION = "enable_webview_listener_standardization";
    public static final String LOAD_POLICY_SHARE_CORE = "SHARE_CORE";
    public static final String LOAD_POLICY_SPECIFIED_ONLY = "SPECIFIED_ONLY";
    public static final String LOAD_POLICY_SPECIFIED_OR_UCMOBILE = "SPECIFIED_OR_UCMOBILE";
    public static final String LOAD_POLICY_UCMOBILE_ONLY = "UCMOBILE_ONLY";
    public static final String LOAD_POLICY_UCMOBILE_OR_SPECIFIED = "UCMOBILE_OR_SPECIFIED";
    public static final String OPTION_BREAKPAD_CONFIG = "BREAKPAD_CONFIG";
    public static final String OPTION_COMPATIBLE_POLICY = "COMPATIBLE_POLICY";
    public static final String OPTION_CONNECTION_CONNECT_TIMEOUT = "conn_to";
    public static final String OPTION_CONNECTION_READ_TIMEOUT = "read_to";
    public static final String OPTION_CONTEXT = "CONTEXT";
    public static final String OPTION_CORE_VERSION_EXCLUDE = "core_ver_excludes";
    public static final String OPTION_DELETE_CORE_POLICY = "delete_core";
    public static final String OPTION_DEX_FILE_PATH = "dexFilePath";
    public static final String OPTION_DOWNLOAD_CHECKER = "dlChecker";
    public static final String OPTION_DWN_RETRY_MAX_WAIT_MILIS = "dwnRetryMaxWait";
    public static final String OPTION_DWN_RETRY_WAIT_MILIS = "dwnRetryWait";
    public static final String OPTION_EXACT_LAST_MODIFIED_CHECK = "exact_mod";
    public static final String OPTION_EXACT_OLD_KERNEL_CHECK = "exact_old";
    public static final String OPTION_FORBID_GEN_REPAIR_DIR = "forbid_repair";
    public static final String OPTION_GRANT_ALL_BUILDS = "grant_all_builds";
    public static final String OPTION_HARDWARE_ACCELERATED = "AC";
    public static final String OPTION_INIT_IN_SETUP_THREAD = "init_setup_thread";
    public static final String OPTION_LOAD_KERNEL_TYPE = "load";
    public static final String OPTION_LOAD_POLICY = "loadPolicy";
    public static final String OPTION_LOG_CONFIG = "log_conf";
    public static final String OPTION_MULTI_CORE_TYPE = "MULTI_CORE_TYPE";
    public static final String OPTION_MULTI_UNKNOWN_CRASH_DISABLE = "disable_multi_unknown_crash";
    public static final String OPTION_NOT_SWITCH_UCCORE = "oNotSwUCCore";
    public static final String OPTION_NOT_USE_7Z_CORE = "not_use_7z_core";
    public static final String OPTION_PRECREATE_WEBVIEW = "precreate_webview";
    public static final String OPTION_PRECREATE_WEBVIEW_URL = "precreate_webview_url";
    public static final String OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX = "PRIVATE_DATA_DIRECTORY_SUFFIX";
    public static final String OPTION_PROVIDED_KEYS = "provided_keys";
    public static final String OPTION_RES_FILE_PATH = "resFilePath";
    public static final String OPTION_SDK_VERSION_EXCLUDE = "sdk_ver_excludes";
    public static final String OPTION_SETUP_THREAD_PRIORITY = "setup_priority";
    public static final String OPTION_SET_ODEX_ROOT_PATH = "set_odex_path";
    public static final String OPTION_SHARE_CORE = "share_core";
    public static final String OPTION_SHARE_CORE_PKG_NAME = "share_core_pkg_name";
    public static final String OPTION_SHARE_CORE_SYS_PATH = "share_core_sys_path";
    public static final String OPTION_SKIP_OLD_KERNEL = "skip_old_extra_kernel";
    public static final String OPTION_SO_FILE_PATH = "soFilePath";
    public static final String OPTION_SPEEDUP_DEXOPT_POLICY = "speedup_dexopt";
    public static final String OPTION_UCM_CFG_FILE = "ucmCfgFile";
    public static final String OPTION_UCM_KRL_DIR = "ucmKrlDir";
    public static final String OPTION_UCM_LIB_DIR = "ucmLibDir";
    public static final String OPTION_UCM_PATCH_DIR = "ucmPatDir";
    public static final String OPTION_UCM_UPD_URL = "ucmUpdUrl";
    public static final String OPTION_UCM_ZIP_DIR = "ucmZipDir";
    public static final String OPTION_UCM_ZIP_FILE = "ucmZipFile";
    public static final String OPTION_UC_PLAYER_ROOT = "ucPlayerRoot";
    public static final String OPTION_UC_PROXY_ADBLOCK = "proxy_adblock";
    public static final String OPTION_UPD_SETUP_TASK_WAIT_MILIS = "updWait";
    public static final String OPTION_USE_SDK_SETUP = "sdk_setup";
    public static final String OPTION_USE_SYSTEM_WEBVIEW = "SYSTEM_WEBVIEW";
    public static final String OPTION_USE_UC_PLAYER = "ucPlayer";
    public static final String OPTION_VERIFY_POLICY = "VERIFY_POLICY";
    public static final String OPTION_VIDEO_HARDWARE_ACCELERATED = "VIDEO_AC";
    public static final String OPTION_VMSIZE_SAVING = "vmsize_saving";
    public static final String OPTION_WAP_DENY = "wap_deny";
    public static final String OPTION_WEBVIEW_POLICY = "WEBVIEW_POLICY";
    public static final String OPTION_WEBVIEW_POLICY_WAIT_MILLIS = "wait_fallback_sys";
    public static final String PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION = "process_private_data_dir_suffix";
    public static final int SPEEDUP_DEXOPT_POLICY_ALL = 2047;
    public static final int SPEEDUP_DEXOPT_POLICY_ART = 1920;
    public static final int SPEEDUP_DEXOPT_POLICY_DAVIK = 127;
    public static final int SPEEDUP_DEXOPT_POLICY_NONE = 0;
    public static final int VERIFY_POLICY_ALL = 1073741839;
    public static final int VERIFY_POLICY_BROWSER_IF = 2;
    public static final int VERIFY_POLICY_CORE_IMPL = 4;
    public static final int VERIFY_POLICY_NONE = 0;
    public static final int VERIFY_POLICY_QUICK = 1073741824;
    public static final int VERIFY_POLICY_SDK_SHELL = 1;
    public static final int VERIFY_POLICY_SO = 8;
    public static final int VERIFY_POLICY_SO_FULL_HASH = 16;
    public static final int WEBVIEW_POLICY_WAIT_UNTIL_EXCEPTION = 3;
    public static final int WEBVIEW_POLICY_WAIT_UNTIL_FALLBACK_SYSTEM = 2;
    public static final int WEBVIEW_POLICY_WAIT_UNTIL_LOADED = 1;
    private static ae a = null;
    private static u b = null;

    static /* synthetic */ void a(Context context, String str, Callable callable, Map map) throws UCSetupException {
        File uCPlayerRoot = UpdateTask.getUCPlayerRoot(context);
        SDKFactory.invoke(10002, Long.valueOf(1024));
        SDKFactory.invoke(10002, Long.valueOf(2048));
        SDKFactory.invoke(10002, Long.valueOf(4096));
        SDKFactory.invoke(10002, Long.valueOf(8192));
        SDKFactory.invoke(10002, Long.valueOf(16384));
        SDKFactory.invoke(10002, Long.valueOf(32768));
        SDKFactory.invoke(10002, Long.valueOf(65536));
        SDKFactory.z.remove(IWaStat.VIDEO_ERROR_CODE_UPDATE_CHECK_REQUEST);
        SDKFactory.z.remove(IWaStat.VIDEO_ERROR_CODE_DOWNLOAD);
        SDKFactory.z.remove(IWaStat.VIDEO_ERROR_CODE_VERIFY);
        SDKFactory.z.remove(IWaStat.VIDEO_ERROR_CODE_UNZIP);
        Context context2 = context;
        String str2 = str;
        new UpdateTask(context2, str2, uCPlayerRoot.getAbsolutePath(), "libu3player.so", new g(), null, null).onEvent("beginDownload", new e()).onEvent("beginUnZip", new d()).onEvent("unzipSuccess", new n()).onEvent("check", new m(callable)).onEvent("success", new l(context, map)).onEvent("failed", new k()).onEvent("exception", new i(map)).onEvent("exists", new h(map, uCPlayerRoot)).start();
    }

    static /* synthetic */ void a(String str, Object obj, Map map) {
        if (map == null) {
            return;
        }
        ValueCallback valueCallback;
        if ("downloadException".equals(str)) {
            valueCallback = (ValueCallback) map.get("exception");
            if (valueCallback != null) {
                try {
                    valueCallback.onReceiveValue(((s) obj).getException());
                } catch (Throwable th) {
                }
            }
        } else if ("updateProgress".equals(str)) {
            valueCallback = (ValueCallback) map.get("progress");
            if (valueCallback != null) {
                try {
                    valueCallback.onReceiveValue((Integer) ((s) obj).invokeO(UCAsyncTask.getPercent, null));
                } catch (Throwable th2) {
                }
            }
        }
    }

    public static int init(Context context, boolean z, BreakpadConfig breakpadConfig, Map<String, String> map) throws RuntimeException {
        ((SetupTask) ((SetupTask) a().setup(OPTION_CONTEXT, context)).setup(OPTION_BREAKPAD_CONFIG, breakpadConfig)).setup(OPTION_USE_SYSTEM_WEBVIEW, Boolean.valueOf(z));
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.setup((String) entry.getKey(), entry.getValue());
            }
        }
        SDKFactory.z.remove(IWaStat.ERROR_CODE_INIT);
        a.startSync();
        return 0;
    }

    private static synchronized ae a() {
        ae aeVar;
        synchronized (UCCore.class) {
            if (a == null) {
                a = new ae();
            }
            aeVar = a;
        }
        return aeVar;
    }

    public static synchronized u getCurrentLoadClassTask() {
        u uVar;
        synchronized (UCCore.class) {
            if (b == null) {
                b = new u();
            }
            uVar = b;
        }
        return uVar;
    }

    public static SetupTask setup(String str, Object obj) {
        return (SetupTask) a().setup(str, obj);
    }

    public static void update(Context context, String str, Callable<Boolean> callable) throws UCSetupException {
        a().a(str, (Callable) callable);
    }

    public static void updateUCCore(Context context, String str, Callable<Boolean> callable, Map<String, ValueCallback> map, Map<String, Object> map2) throws UCSetupException {
        new a(context, map, callable, str, map2).start();
    }

    public static void updateUCPlayer(Context context, String str, Callable<Boolean> callable) throws UCSetupException {
        updateUCPlayer(context, str, callable, null);
    }

    public static void updateUCPlayer(Context context, String str, Callable<Boolean> callable, Map<String, ValueCallback> map) throws UCSetupException {
        new f(context, str, callable, map).start();
    }

    public static void setLocationManager(ILocationManager iLocationManager) {
        if (SDKFactory.d != null) {
            SDKFactory.d.setLocationManagerUC(iLocationManager);
        }
    }

    public static void onLowMemory() {
        if (SDKFactory.d != null) {
            try {
                SDKFactory.d.onLowMemory();
            } catch (Throwable th) {
            }
        }
    }

    public static void onTrimMemory(int i) {
        if (SDKFactory.d != null) {
            try {
                SDKFactory.d.onTrimMemory(i);
            } catch (Throwable th) {
            }
        }
    }

    public static void uploadCrashLogs() {
        a.a();
    }

    public static void setNotAvailableUCListener(NotAvailableUCListener notAvailableUCListener) {
        SDKFactory.a = notAvailableUCListener;
    }

    public static String getCoreInfo() throws RuntimeException {
        return (String) SDKFactory.invoke(UCMPackageInfo.getKernalShareJarLnkRoot, new Object[0]);
    }

    public static void setPrintLog(boolean z) {
        Object[] objArr = new Object[]{Boolean.valueOf(z), Boolean.valueOf(true), null, "[all]", "[all]"};
        SDKFactory.invoke(10048, Boolean.valueOf(z), objArr);
    }

    public static void setDrawableResource(String str, Drawable drawable) {
        if (SDKFactory.d != null) {
            SDKFactory.d.getWebResources().setDrawable(str, drawable);
        }
    }

    public static Pair<Long, Long> getTraffic() {
        return (Pair) SDKFactory.invoke(UCMPackageInfo.initUCMBuildInfo, new Object[0]);
    }

    public static WebResourceResponse getResponseByUrl(String str) {
        return (WebResourceResponse) SDKFactory.invoke(10031, str);
    }

    public static void setThirdNetwork(INetwork iNetwork, INetworkDecider iNetworkDecider) {
        if (WebView.getCoreType() != 2 && SDKFactory.d != null) {
            SDKFactory.d.setThirdNetwork(iNetwork, iNetworkDecider);
        }
    }

    public static void setNetworkDelegate(INetworkDelegate iNetworkDelegate) {
        if (WebView.getCoreType() == 1 && SDKFactory.d != null) {
            Log.e("network delegate", "invoke setNetworkDelegate");
            try {
                ReflectionUtil.invoke(SDKFactory.d, "setNetworkDelegate", new Class[]{InvokeObject.class}, new Object[]{new b(iNetworkDelegate)});
            } catch (Throwable e) {
                Log.e("network delegate", "setNetworkDelegate", e);
            }
        } else if (WebView.getCoreType() == 3 && SDKFactory.d != null) {
            Log.e("network delegate", "UCCore U4 setNetworkDelegate");
            try {
                SDKFactory.d.setNetworkDelegate(iNetworkDelegate);
            } catch (Throwable e2) {
                Log.e("network delegate", "setNetworkDelegate", e2);
            }
        }
    }

    public static void setNetLogger(INetLogger iNetLogger) {
        SDKFactory.d.setNetLogger(iNetLogger);
    }

    public static void extractWebCoreLibraryIfNeeded(Context context, String str, String str2, boolean z) throws UCSetupException {
        UCCyclone.decompressIfNeeded(context, true, new File(str), new File(str2), null, z);
    }

    public static void setInitCallback(InitCallback initCallback) {
        SDKFactory.o = initCallback;
    }

    public static void setStatDataCallback(ValueCallback<String> valueCallback) {
        SDKFactory.v = valueCallback;
    }

    public static void setStatDataCheckCallback(ValueCallback<String> valueCallback) {
        SDKFactory.w = valueCallback;
    }

    public static void setSetupExceptionListener(ValueCallback<UCSetupException> valueCallback) {
        SDKFactory.x = valueCallback;
    }

    public static void setParam(String str) {
        SDKFactory.invoke(10004, str);
    }

    public static String getParam(String str) {
        return (String) SDKFactory.invoke(10005, str);
    }

    public static void updateTypefacePath(String str, Runnable runnable) {
        SDKFactory.invoke(UCMPackageInfo.deleteTempDecFiles, str, runnable);
    }

    public static void clearHttpCache() {
        if (WebView.getCoreType() != 2 && SDKFactory.d != null) {
            SDKFactory.d.updateBussinessInfo(3, 0, "SETTING_CLEAR_RECORD", "15");
        }
    }

    public static Object notifyCoreEvent(int i, Object obj) {
        if (WebView.getCoreType() == 1 && SDKFactory.d != null) {
            Log.d("notifyCoreEvent", "notifyCoreEvent");
            try {
                return ReflectionUtil.invoke(SDKFactory.d, "notifyCoreEvent", new Class[]{InvokeObject.class}, new Object[]{new com.uc.webview.export.internal.uc.a(i, obj)});
            } catch (Throwable th) {
                Log.e("notifyCoreEvent", "notifyCoreEvent", th);
            }
        } else if (WebView.getCoreType() == 3 && SDKFactory.d != null) {
            try {
                return SDKFactory.d.notifyCoreEvent(i, obj);
            } catch (Throwable th2) {
                Log.e("notifyCoreEvent", "notifyCoreEvent error=", th2);
            }
        }
        return null;
    }

    public static Object notifyCoreEvent(int i, Object obj, ValueCallback<Object> valueCallback) {
        if (WebView.getCoreType() == 3 && SDKFactory.d != null) {
            try {
                return SDKFactory.d.notifyCoreEvent(i, obj, valueCallback);
            } catch (Throwable e) {
                Log.e("notifyCoreEvent", "notifyCoreEvent error=", e);
            }
        }
        return null;
    }

    public static void setSocketParam(String str, Object obj) {
        if (WebView.getCoreType() != 2 && SDKFactory.d != null) {
            try {
                SDKFactory.d.setSocketParam(str, obj);
            } catch (AbstractMethodError e) {
            }
        }
    }

    public static void preloadResource(String str, int i, int i2, ValueCallback<android.webkit.WebResourceResponse> valueCallback) {
        if (WebView.getCoreType() != 2 && SDKFactory.d != null) {
            try {
                SDKFactory.d.preloadResource(str, i, i2, valueCallback);
            } catch (AbstractMethodError e) {
            }
        }
    }

    public static String utdid(Context context) {
        return d.a.a(context);
    }

    public static void startDownload() {
        ae a = a();
        if (a.a != null && (a.a instanceof bu)) {
            ((bu) a.a).a.startDownload();
        }
    }

    public static void setGlobalOption(String str, Object obj) {
        SDKFactory.invoke(10057, str, obj);
    }

    public static Object getGlobalOption(String str) {
        return SDKFactory.invoke(10058, str);
    }

    public static boolean getGlobalBooleanOption(String str) {
        Boolean bool = (Boolean) SDKFactory.invoke(10058, str);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }
}
