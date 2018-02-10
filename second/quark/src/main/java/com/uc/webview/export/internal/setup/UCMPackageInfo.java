package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Pair;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.Build;
import com.uc.webview.export.Build.Version;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@Api
/* compiled from: ProGuard */
public class UCMPackageInfo {
    public static final String[] ARCHS = new String[]{"armeabi-v7a", "armeabi", "x86"};
    public static final String BROWSER_IF_FOR_EXPORT_FILE_USING_SO_SUFFIX = "libbrowser_if_for_export_jar_kj_uc.so";
    public static final String CORE_CLASS_LOADER_IMPL_CLASS = "com.uc.webkit.sdk.CoreClassPreLoaderImpl";
    public static final String CORE_FACTORY_IMPL_CLASS = "com.uc.webkit.sdk.CoreFactoryImpl";
    public static final String CORE_IMPL_DEX_FILE_USING_SO_SUFFIX = "libcore_jar_kj_uc.so";
    public static final String RES_PAKS_DIR_NAME = "paks";
    public static final String SDK_SHELL_DEX_FILE_USING_SO_SUFFIX = "libsdk_shell_jar_kj_uc.so";
    private static final String[] a = new String[]{"WebCore_UC", "webviewuc", "webviewuc.cr"};
    private static final String[] b = new String[]{"imagehelper"};
    public static final int compareVersion = 10027;
    public static final int deleteTempDecFiles = 10039;
    public static final int deleteUCMSDKDir = 10044;
    public static final int expectCreateDirFile2P = 10035;
    public static final int expectDirFile1F = 10032;
    public static final int expectDirFile1S = 10033;
    public static final int getDataDirHash = 10012;
    public static final int getDecompressRoot = 10003;
    public static final int getDir = 10001;
    public static final int getFlagRoot = 10005;
    public static final int getKernalJarCpyRoot = 10009;
    public static final int getKernalJarLnkRoot = 10007;
    public static final int getKernalResCpyRoot = 10010;
    public static final int getKernalResLnkRoot = 10008;
    public static final int getKernalShareJarCpyRoot = 10047;
    public static final int getKernalShareJarLnkRoot = 10046;
    public static final int getKernelFileIfMultiCoreFromDir = 10028;
    public static final int getKernelFiles = 10022;
    public static final int getKernelResFiles = 10024;
    public static final int getLibFilter = 10023;
    public static final int getOdexRoot = 10004;
    public static final int getRepairApolloRoot = 10045;
    public static final int getRepairRoot = 10006;
    public static final int getUnExistsFilePath = 10021;
    public static final int getUpdateRoot = 10002;
    public static final int getVersion = 10040;
    public static final int hadInstallUCMobile = 10026;
    public static final int initUCMBuildInfo = 10041;
    public static final int isDirShouldBeDeleted = 10043;
    public static final int isThickSDK = 10011;
    public static final int makeDirDeleteFlg = 10042;
    public static final int sortByLastModified = 10025;
    public final Pair<String, String> browserIFModule;
    private Context c;
    public final String coreCode;
    public final Pair<String, String> coreImplModule;
    public final String dataDir;
    public final String disabledFilePath;
    public final boolean isSpecified;
    public ClassLoader mCoreClassLoader = null;
    public ClassLoader mSdkShellClassLoader = null;
    public final String mainLibrary;
    public final String pkgName;
    public final String resDirPath;
    public final Pair<String, String> sdkShellModule;
    public final String soDirPath;

    /* compiled from: ProGuard */
    public final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public static List<a> a(File file) {
            Closeable byteArrayOutputStream;
            Throwable e;
            Closeable closeable = null;
            List<a> arrayList = new ArrayList();
            if (file == null || !file.exists()) {
                Log.i("Config", "configFile:" + file + " not exist");
                return arrayList;
            }
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    closeable = fileInputStream;
                    try {
                        Log.e("Config", "getConfig", e);
                        UCCyclone.close(closeable);
                        UCCyclone.close(byteArrayOutputStream);
                        return new ArrayList();
                    } catch (Throwable th) {
                        e = th;
                        fileInputStream = closeable;
                        UCCyclone.close(fileInputStream);
                        UCCyclone.close(byteArrayOutputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    byteArrayOutputStream = null;
                    UCCyclone.close(fileInputStream);
                    UCCyclone.close(byteArrayOutputStream);
                    throw e;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    JSONArray jSONArray = new JSONArray(new String(byteArrayOutputStream.toByteArray()));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a = jSONObject.getString("ucmver");
                        aVar.b = jSONObject.getString("sdkMin");
                        if (jSONObject.has(ShareConstants.DEX_PATH)) {
                            aVar.c = jSONObject.getJSONObject(ShareConstants.DEX_PATH).getString("path");
                        }
                        if (jSONObject.has("so")) {
                            aVar.d = jSONObject.getJSONObject("so").getString("path");
                        }
                        if (jSONObject.has(ShareConstants.RES_PATH)) {
                            aVar.e = jSONObject.getJSONObject(ShareConstants.RES_PATH).getString("path");
                        }
                        if (jSONObject.has("archive")) {
                            jSONObject = jSONObject.getJSONObject("archive");
                            aVar.f = jSONObject.getString("path");
                            aVar.g = jSONObject.getString("algorithm");
                        }
                        arrayList.add(aVar);
                    }
                    UCCyclone.close(fileInputStream);
                    UCCyclone.close(byteArrayOutputStream);
                    return arrayList;
                } catch (Exception e3) {
                    e = e3;
                    closeable = fileInputStream;
                    Log.e("Config", "getConfig", e);
                    UCCyclone.close(closeable);
                    UCCyclone.close(byteArrayOutputStream);
                    return new ArrayList();
                } catch (Throwable th3) {
                    e = th3;
                    UCCyclone.close(fileInputStream);
                    UCCyclone.close(byteArrayOutputStream);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream = null;
                Log.e("Config", "getConfig", e);
                UCCyclone.close(closeable);
                UCCyclone.close(byteArrayOutputStream);
                return new ArrayList();
            } catch (Throwable th4) {
                e = th4;
                byteArrayOutputStream = null;
                fileInputStream = null;
                UCCyclone.close(fileInputStream);
                UCCyclone.close(byteArrayOutputStream);
                throw e;
            }
        }

        public static boolean a(List<a> list, File file) {
            Throwable e;
            if (list.size() == 0) {
                Log.i("Config", "configs:" + list + " is empty or configFile:" + file);
                return false;
            }
            Closeable closeable = null;
            try {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : list) {
                    JSONObject jSONObject;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONArray.put(jSONObject2);
                    jSONObject2.put("ucmver", aVar.a);
                    jSONObject2.put("sdkMin", aVar.b);
                    if (!d.a(aVar.c)) {
                        jSONObject = new JSONObject();
                        jSONObject2.put(ShareConstants.DEX_PATH, jSONObject);
                        jSONObject.put("path", aVar.c);
                    }
                    if (!d.a(aVar.d)) {
                        jSONObject = new JSONObject();
                        jSONObject2.put("so", jSONObject);
                        jSONObject.put("path", aVar.d);
                    }
                    if (!d.a(aVar.e)) {
                        jSONObject = new JSONObject();
                        jSONObject2.put(ShareConstants.RES_PATH, jSONObject);
                        jSONObject.put("path", aVar.e);
                    }
                    if (!d.a(aVar.f)) {
                        jSONObject = new JSONObject();
                        jSONObject2.put("archive", jSONObject);
                        jSONObject.put("path", aVar.f);
                        jSONObject.put("algorithm", d.a(aVar.g) ? "zip" : aVar.g);
                    }
                }
                Closeable fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(jSONArray.toString().getBytes());
                    UCCyclone.close(fileOutputStream);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    closeable = fileOutputStream;
                    try {
                        Log.e("Config", "saveConfig", e);
                        UCCyclone.close(closeable);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        UCCyclone.close(closeable);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    closeable = fileOutputStream;
                    UCCyclone.close(closeable);
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    public UCMPackageInfo(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, boolean z2) throws UCSetupException {
        this.c = context.getApplicationContext();
        this.pkgName = str;
        this.soDirPath = str2;
        String a = z2 ? a(context, str4, str3) : str3;
        if (a == null) {
            a = null;
        } else if (!a.endsWith("/")) {
            a = a + "/";
        }
        this.resDirPath = a;
        this.isSpecified = z;
        if (str4 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str8 == null ? (File) invoke(10004, context) : new File(str8);
            objArr[1] = (String) invoke(10012, str4);
            File file = (File) invoke(expectCreateDirFile2P, objArr);
            this.dataDir = str4;
            this.disabledFilePath = str4 + "/e1df430e25e9dacb26ead508abb3413f";
            if (z2) {
                str5 = b(context, str4, str5);
            }
            this.sdkShellModule = new Pair(str5, file.getAbsolutePath());
            if (z2) {
                str6 = b(context, str4, str6);
            }
            this.browserIFModule = new Pair(str6, file.getAbsolutePath());
            if (z2) {
                str7 = b(context, str4, str7);
            }
            this.coreImplModule = new Pair(str7, file.getAbsolutePath());
        } else {
            this.dataDir = null;
            this.disabledFilePath = (String) invoke(10021, new Object[0]);
            this.sdkShellModule = null;
            this.browserIFModule = null;
            this.coreImplModule = null;
        }
        if (d.a(str2)) {
            a = context.getApplicationInfo().nativeLibraryDir;
        } else {
            a = str2;
        }
        String str9 = null;
        long j = 0;
        String[] strArr = a;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str10 = strArr[i];
            File file2 = new File(a, new StringBuilder(ShareConstants.SO_PATH).append(str10).append(".so").toString());
            if (!file2.exists() || file2.lastModified() <= r4) {
                str10 = str9;
            } else {
                j = file2.lastModified();
            }
            i++;
            str9 = str10;
        }
        if (str9 != null || d.a(str2)) {
            this.mainLibrary = str9;
            str10 = "WebCore_UC".equals(this.mainLibrary) ? "u3" : "webviewuc".equals(this.mainLibrary) ? "u4" : "webviewuc.cr".equals(this.mainLibrary) ? "u4" : this.mainLibrary == null ? "null" : "error";
            this.coreCode = str10;
            if (this.coreCode.equals("u4")) {
                for (String str92 : b) {
                    File file3 = new File(context.getApplicationInfo().nativeLibraryDir, new StringBuilder(ShareConstants.SO_PATH).append(str92).append(".so").toString());
                    File file4 = new File(a, new StringBuilder(ShareConstants.SO_PATH).append(str92).append(".so").toString());
                    if (file3.exists()) {
                        long lastModified = file3.lastModified();
                        if (!file4.exists() || file4.lastModified() < lastModified) {
                            d.a(file3, file4, file4, false);
                        }
                    }
                }
                return;
            }
            return;
        }
        throw new UCSetupException((int) SettingsConst.HARDWARE_ACCELERATE, String.format("Main so file U3 [%s] or U4 [%s|%s] not exists.", new Object[]{"WebCore_UC", "webviewuc", "webviewuc.cr"}));
    }

    public String getDirAlias(Context context) {
        if (!(this.coreImplModule == null || this.coreImplModule.first == null)) {
            String str = (String) this.coreImplModule.first;
            if (str != null) {
                if (str.startsWith(((File) invoke(10003, context)).getAbsolutePath())) {
                    return "dec";
                }
                if (str.startsWith(((File) invoke(10002, context)).getAbsolutePath())) {
                    return "upd";
                }
                if (str.startsWith(((File) invoke(10007, context)).getAbsolutePath())) {
                    return "kjl";
                }
                if (str.startsWith(((File) invoke(10009, context)).getAbsolutePath())) {
                    return "kjc";
                }
                if (str.startsWith(((File) invoke(10006, context)).getAbsolutePath())) {
                    return "rep";
                }
                return "oth";
            }
        }
        return "nul";
    }

    public Map<String, String> getFileHashs() {
        Map<String, String> hashMap = new HashMap(16);
        if (this.coreImplModule == null || this.coreImplModule.first == null) {
            hashMap.put("core", "null");
        } else {
            File file = new File((String) this.coreImplModule.first);
            hashMap.put(file.getName(), UCCyclone.md5FileContents(file));
        }
        if (this.browserIFModule == null || this.browserIFModule.first == null) {
            hashMap.put("browser_if", "null");
        } else {
            file = new File((String) this.browserIFModule.first);
            hashMap.put(file.getName(), UCCyclone.md5FileContents(file));
        }
        if (this.sdkShellModule == null || this.sdkShellModule.first == null) {
            hashMap.put("sdk_shell", "null");
        } else {
            file = new File((String) this.sdkShellModule.first);
            hashMap.put(file.getName(), UCCyclone.md5FileContents(file));
        }
        String str = this.soDirPath;
        if (d.a(str)) {
            str = this.c.getApplicationInfo().nativeLibraryDir;
        }
        if (str != null) {
            file = new File(str);
            if (file.isDirectory()) {
                try {
                    if (this.mSdkShellClassLoader != null) {
                        Class cls = Class.forName("com.uc.webview.browser.shell.NativeLibraries", true, this.mSdkShellClassLoader);
                        if (cls != null) {
                            Field declaredField = cls.getDeclaredField("LIBRARIES");
                            declaredField.setAccessible(true);
                            String[][] strArr = (String[][]) declaredField.get(null);
                            if (strArr != null) {
                                for (String[] strArr2 : strArr) {
                                    String str2 = strArr2[0];
                                    d.c(strArr2[1]);
                                    String str3 = strArr2[2];
                                    String md5FileContents = UCCyclone.md5FileContents(new File(file, str2));
                                    if (d.a(str3) || str3.equals(md5FileContents)) {
                                        hashMap.put(str2, "ok");
                                    } else {
                                        hashMap.put(str2, md5FileContents);
                                    }
                                }
                            } else {
                                hashMap.put("NativeLibraries", "null");
                            }
                        }
                    } else {
                        hashMap.put("sdk_shell_cl", "null");
                    }
                } catch (Throwable th) {
                    hashMap.put("NativeLibraries", "exception");
                }
            } else {
                hashMap.put("so_dir", "null");
            }
        } else {
            hashMap.put("so_path", "null");
        }
        return hashMap;
    }

    static synchronized List<UCMPackageInfo> a(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        List<UCMPackageInfo> list;
        synchronized (UCMPackageInfo.class) {
            String absolutePath;
            List arrayList = new ArrayList();
            String str = (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH);
            if (!d.a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            str = (String) concurrentHashMap.get(UCCore.OPTION_SET_ODEX_ROOT_PATH);
            if (str == null) {
                absolutePath = ((File) invoke(10004, context)).getAbsolutePath();
            } else {
                absolutePath = str;
            }
            if (arrayList.size() == 0) {
                UCMPackageInfo a = a(context, null, (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH), absolutePath);
                if (a != null) {
                    arrayList.add(a);
                }
                if (((Boolean) invoke(10011, new Object[0])).booleanValue()) {
                    list = arrayList;
                }
            }
            str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            if (!d.a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR);
            if (!d.a(str)) {
                arrayList.add(c(context, str, absolutePath));
            }
            list = (List) invoke(sortByLastModified, arrayList);
        }
        return list;
    }

    public static Object invoke(int i, Object... objArr) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable e;
        while (true) {
            Context context;
            String str;
            String str2;
            String str3;
            File file;
            File file2;
            File file3;
            switch (i) {
                case 10001:
                    context = (Context) objArr[0];
                    str = objArr.length >= 2 ? (String) objArr[1] : null;
                    File dir = context.getDir("ucmsdk", 0);
                    if (str != null) {
                        return UCCyclone.expectCreateDirFile(new File(dir, str));
                    }
                    return dir;
                case 10002:
                    objArr = new Object[]{(Context) objArr[0], "updates"};
                    i = 10001;
                    break;
                case 10003:
                    objArr = new Object[]{(Context) objArr[0], "decompresses2"};
                    i = 10001;
                    break;
                case 10004:
                    objArr = new Object[]{(Context) objArr[0], "odexs"};
                    i = 10001;
                    break;
                case 10005:
                    objArr = new Object[]{(Context) objArr[0], "flags"};
                    i = 10001;
                    break;
                case 10006:
                    objArr = new Object[]{(Context) objArr[0], "repairs"};
                    i = 10001;
                    break;
                case 10007:
                    objArr = new Object[]{(Context) objArr[0], "kjlinks"};
                    i = 10001;
                    break;
                case 10008:
                    objArr = new Object[]{(Context) objArr[0], "krlinks"};
                    i = 10001;
                    break;
                case 10009:
                    objArr = new Object[]{(Context) objArr[0], "kjcopies"};
                    i = 10001;
                    break;
                case 10010:
                    objArr = new Object[]{(Context) objArr[0], "krcopies"};
                    i = 10001;
                    break;
                case 10011:
                    try {
                        Class.forName(CORE_FACTORY_IMPL_CLASS);
                        return Boolean.valueOf(true);
                    } catch (Throwable th) {
                        return Boolean.valueOf(false);
                    }
                case 10012:
                    return String.valueOf(((String) objArr[0]).hashCode()).replace('-', '_');
                case 10021:
                    return "/unexists/" + System.currentTimeMillis();
                case 10022:
                    return ((File) objArr[0]).listFiles(new bi());
                case getLibFilter /*10023*/:
                    return new bj();
                case getKernelResFiles /*10024*/:
                    return ((File) objArr[0]).list(new bk());
                case sortByLastModified /*10025*/:
                    List list = (List) objArr[0];
                    if (list != null && list.size() > 1) {
                        Collections.sort(list, new bl());
                    }
                    return list;
                case hadInstallUCMobile /*10026*/:
                    boolean z;
                    for (PackageInfo packageInfo : ((Context) objArr[0]).getPackageManager().getInstalledPackages(64)) {
                        if (packageInfo.packageName.startsWith("com.UCMobile") && packageInfo.applicationInfo.enabled) {
                            z = true;
                            return Boolean.valueOf(z);
                        }
                    }
                    z = false;
                    return Boolean.valueOf(z);
                case compareVersion /*10027*/:
                    str = (String) objArr[1];
                    str2 = (String) objArr[2];
                    String[] split = ((String) objArr[0]).split("\\.");
                    String[] split2 = str.split("\\.");
                    if (d.b(split[0]) >= d.b(split2[0]) && d.b(split[1]) >= d.b(split2[1]) && d.b(split[2]) >= d.b(split2[2])) {
                        return Boolean.valueOf(true);
                    }
                    Log.d("UCMPackageInfo", str2);
                    return Boolean.valueOf(false);
                case getKernelFileIfMultiCoreFromDir /*10028*/:
                    str3 = (String) objArr[0];
                    if (Build.PACK_TYPE != 34 && Build.PACK_TYPE != 43) {
                        return null;
                    }
                    Object[] objArr2 = new Object[]{str3};
                    File[] fileArr = (File[]) invoke(10022, (File) invoke(expectDirFile1S, objArr2));
                    if (fileArr == null || fileArr.length <= 0) {
                        return null;
                    }
                    return fileArr[0];
                case expectDirFile1F /*10032*/:
                    file = (File) objArr[0];
                    if (file.exists()) {
                        return file;
                    }
                    throw new UCSetupException(1002, String.format("Directory [%s] not exists.", new Object[]{file.getAbsolutePath()}));
                case expectDirFile1S /*10033*/:
                    return (File) invoke(expectDirFile1F, new File((String) objArr[0]));
                case expectCreateDirFile2P /*10035*/:
                    return UCCyclone.expectCreateDirFile(new File((File) objArr[0], (String) objArr[1]));
                case deleteTempDecFiles /*10039*/:
                    File[] listFiles = ((Context) objArr[0]).getCacheDir().listFiles(new bm());
                    if (listFiles == null || listFiles.length <= 0) {
                        return null;
                    }
                    for (File file22 : listFiles) {
                        UCCyclone.recursiveDelete(file22, false, null);
                    }
                    return null;
                case getVersion /*10040*/:
                    file3 = new File((String) objArr[0], "curver");
                    if (!file3.exists()) {
                        return null;
                    }
                    try {
                        fileReader = new FileReader(file3);
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = null;
                            try {
                                Log.i("tag_test_log", "getVersion", e);
                                try {
                                    bufferedReader.close();
                                } catch (Exception e3) {
                                }
                                try {
                                    fileReader.close();
                                    return null;
                                } catch (Exception e4) {
                                    return null;
                                }
                            } catch (Throwable th2) {
                                e = th2;
                                try {
                                    bufferedReader.close();
                                } catch (Exception e5) {
                                }
                                try {
                                    fileReader.close();
                                } catch (Exception e6) {
                                }
                                throw e;
                            }
                        } catch (Throwable th3) {
                            e = th3;
                            bufferedReader = null;
                            bufferedReader.close();
                            fileReader.close();
                            throw e;
                        }
                        try {
                            str3 = bufferedReader.readLine();
                            if (str3 != null) {
                                str3 = str3.trim();
                                if (!str3.startsWith("/")) {
                                    str3 = "/" + str3;
                                }
                                if (!str3.endsWith("/")) {
                                    str3 = str3 + "/";
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Exception e7) {
                                }
                                try {
                                    fileReader.close();
                                } catch (Exception e8) {
                                }
                                return str3;
                            }
                            try {
                                bufferedReader.close();
                            } catch (Exception e9) {
                            }
                            try {
                                fileReader.close();
                                return null;
                            } catch (Exception e10) {
                                return null;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            Log.i("tag_test_log", "getVersion", e);
                            bufferedReader.close();
                            fileReader.close();
                            return null;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        bufferedReader = null;
                        fileReader = null;
                        Log.i("tag_test_log", "getVersion", e);
                        bufferedReader.close();
                        fileReader.close();
                        return null;
                    } catch (Throwable th4) {
                        e = th4;
                        bufferedReader = null;
                        fileReader = null;
                        bufferedReader.close();
                        fileReader.close();
                        throw e;
                    }
                case initUCMBuildInfo /*10041*/:
                    Class cls;
                    ClassLoader classLoader = (ClassLoader) objArr[0];
                    if (classLoader == null) {
                        try {
                            cls = Class.forName("com.uc.webview.browser.shell.Build$Version");
                        } catch (Throwable e13) {
                            Log.d("UCMPackageInfo", "exception", e13);
                            Version.API_LEVEL = 1;
                        }
                    } else {
                        cls = Class.forName("com.uc.webview.browser.shell.Build$Version", false, classLoader);
                    }
                    str2 = cls.getField("NAME").get(null).toString();
                    String obj = cls.getField("SUPPORT_SDK_MIN").get(null).toString();
                    Build.UCM_VERSION = str2;
                    Build.UCM_SUPPORT_SDK_MIN = obj;
                    Version.API_LEVEL = cls.getField("API_LEVEL").getInt(null);
                    try {
                        Class cls2 = Class.forName("com.uc.webview.browser.shell.Build", false, classLoader);
                        Build.CORE_VERSION = cls2.getField("CORE_VERSION").get(null).toString();
                        Build.CORE_TIME = cls2.getField("TIME").get(null).toString();
                        return null;
                    } catch (Exception e14) {
                        return null;
                    }
                case makeDirDeleteFlg /*10042*/:
                    try {
                        if (new File((File) objArr[1], String.valueOf(System.currentTimeMillis())).createNewFile()) {
                            return null;
                        }
                        throw new Exception("createNewFile return false");
                    } catch (Throwable e15) {
                        UCKnownException uCKnownException = new UCKnownException(1006, e15);
                    }
                case isDirShouldBeDeleted /*10043*/:
                    context = (Context) objArr[0];
                    file = UCCyclone.expectCreateDirFile(new File(UCCyclone.expectCreateDirFile(new File((File) invoke(10005, context), "setup_delete")), UCCyclone.getSourceHash(((File) objArr[1]).getAbsolutePath())));
                    if (file.list().length < 12) {
                        return file;
                    }
                    return null;
                case deleteUCMSDKDir /*10044*/:
                    boolean z2;
                    context = (Context) objArr[0];
                    file3 = (File) objArr[1];
                    File file4 = (File) objArr[2];
                    if (file3.isFile()) {
                        file22 = null;
                        z2 = true;
                    } else if (file3.isDirectory()) {
                        file22 = (File) invoke(isDirShouldBeDeleted, context, file3);
                        z2 = file22 != null;
                    } else {
                        file22 = null;
                        z2 = false;
                    }
                    if (!z2) {
                        return null;
                    }
                    UCCyclone.recursiveDelete(file3, false, file4);
                    if (file3.exists() || file22 == null) {
                        return null;
                    }
                    invoke(makeDirDeleteFlg, context, file22);
                    return null;
                case getRepairApolloRoot /*10045*/:
                    objArr = new Object[]{(Context) objArr[0], "rep_apollo"};
                    i = 10001;
                    break;
                case getKernalShareJarLnkRoot /*10046*/:
                    objArr = new Object[]{(Context) objArr[0], "share/kjlinks"};
                    i = 10001;
                    break;
                case getKernalShareJarCpyRoot /*10047*/:
                    objArr = new Object[]{(Context) objArr[0], "share/kjcopies"};
                    i = 10001;
                    break;
                default:
                    return null;
            }
        }
    }

    private static String a(Context context, String str, String str2) {
        if (d.a(str2)) {
            return null;
        }
        String[] strArr = (String[]) invoke(getKernelResFiles, (File) invoke(expectDirFile1S, str2));
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        String str3 = (String) invoke(10012, str);
        r9 = new Object[2];
        r9[0] = (File) invoke(10008, context);
        r9[1] = str3;
        File file = (File) invoke(expectCreateDirFile2P, r9);
        r10 = new Object[2];
        r10[0] = (File) invoke(10010, context);
        r10[1] = str3;
        File file2 = (File) invoke(expectCreateDirFile2P, r10);
        File file3 = (File) invoke(expectCreateDirFile2P, file, RES_PAKS_DIR_NAME);
        File file4 = (File) invoke(expectCreateDirFile2P, file2, RES_PAKS_DIR_NAME);
        File[] fileArr = new File[strArr.length];
        File[] fileArr2 = new File[strArr.length];
        File[] fileArr3 = new File[strArr.length];
        UCElapseTime uCElapseTime = new UCElapseTime();
        for (int i = 0; i < strArr.length; i++) {
            File file5;
            String str4 = strArr[i];
            boolean endsWith = str4.endsWith("_pak_kr_uc.so");
            String substring = str4.substring(3, str4.length() - 9);
            int lastIndexOf = substring.lastIndexOf(95);
            substring = substring.substring(0, lastIndexOf) + '.' + substring.substring(lastIndexOf + 1);
            File file6 = new File(r4, str4);
            if (endsWith) {
                file5 = file3;
            } else {
                file5 = file;
            }
            file6 = new File(file5, substring);
            if (endsWith) {
                file5 = file4;
            } else {
                file5 = file2;
            }
            file6 = new File(file5, substring);
            fileArr[i] = file6;
            fileArr2[i] = file6;
            fileArr3[i] = file6;
        }
        File[] a = d.a(fileArr, fileArr2, fileArr3);
        new StringBuilder("getLnkOrCpyResDirFromSO: file count:").append(strArr.length).append(" time:").append(uCElapseTime.getMilis());
        if ((a[0] == fileArr2[0] ? 1 : null) == null) {
            Object obj = null;
        } else {
            int i2 = 1;
        }
        if (obj == null) {
            return file2.getAbsolutePath();
        }
        return file.getAbsolutePath();
    }

    private static String b(Context context, String str, String str2) {
        if (d.a(str2)) {
            return null;
        }
        File file = new File(str2);
        String name = file.getName();
        if (!name.startsWith(ShareConstants.SO_PATH) || !name.endsWith("_jar_kj_uc.so")) {
            return str2;
        }
        String str3 = name.substring(3, name.length() - 13) + ShareConstants.JAR_SUFFIX;
        name = (String) invoke(10012, str);
        r2 = new Object[2];
        r2[0] = (File) invoke(10007, context);
        r2[1] = name;
        File file2 = (File) invoke(expectCreateDirFile2P, r2);
        r5 = new Object[2];
        r5[0] = (File) invoke(10009, context);
        r5[1] = name;
        return d.a(file, new File(file2, str3), new File((File) invoke(expectCreateDirFile2P, r5), str3), false).getAbsolutePath();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.uc.webview.export.internal.setup.UCMPackageInfo c(android.content.Context r12, java.lang.String r13, java.lang.String r14) throws com.uc.webview.export.internal.setup.UCSetupException {
        /*
        r1 = r12;
    L_0x0001:
        r0 = 10033; // 0x2731 float:1.4059E-41 double:4.957E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r13;
        r0 = invoke(r0, r2);
        r5 = r0;
        r5 = (java.io.File) r5;
        r7 = 0;
        r8 = 0;
        r0 = "libcore_jar_kj_uc.so";
        r0 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r5, r0);	 Catch:{ UCKnownException -> 0x0047 }
        r9 = r0.getAbsolutePath();	 Catch:{ UCKnownException -> 0x0047 }
        r0 = "libsdk_shell_jar_kj_uc.so";
        r0 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r5, r0);	 Catch:{ Throwable -> 0x007c }
        r7 = r0.getAbsolutePath();	 Catch:{ Throwable -> 0x007c }
    L_0x0026:
        r0 = "libbrowser_if_jar_kj_uc.so";
        r0 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r5, r0);	 Catch:{ Throwable -> 0x007a }
        r8 = r0.getAbsolutePath();	 Catch:{ Throwable -> 0x007a }
    L_0x0030:
        r0 = new com.uc.webview.export.internal.utility.UCMPackageInfo;
        r2 = "specified";
        r3 = r5.getAbsolutePath();
        r4 = r5.getAbsolutePath();
        r5 = r5.getAbsolutePath();
        r6 = 1;
        r11 = 1;
        r10 = r14;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r0;
    L_0x0047:
        r0 = move-exception;
        r4 = r5.listFiles();
        if (r4 == 0) goto L_0x0079;
    L_0x004e:
        r5 = ARCHS;
        r6 = r5.length;
        r2 = 0;
        r3 = r2;
    L_0x0053:
        if (r3 >= r6) goto L_0x0079;
    L_0x0055:
        r7 = r5[r3];
        r8 = r4.length;
        r2 = 0;
    L_0x0059:
        if (r2 >= r8) goto L_0x0075;
    L_0x005b:
        r9 = r4[r2];
        r10 = r9.getName();
        r10 = r7.equals(r10);
        if (r10 == 0) goto L_0x0072;
    L_0x0067:
        r10 = r9.isDirectory();
        if (r10 == 0) goto L_0x0072;
    L_0x006d:
        r13 = r9.getAbsolutePath();
        goto L_0x0001;
    L_0x0072:
        r2 = r2 + 1;
        goto L_0x0059;
    L_0x0075:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0053;
    L_0x0079:
        throw r0;
    L_0x007a:
        r0 = move-exception;
        goto L_0x0030;
    L_0x007c:
        r0 = move-exception;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.UCMPackageInfo.c(android.content.Context, java.lang.String, java.lang.String):com.uc.webview.export.internal.setup.UCMPackageInfo");
    }

    private static UCMPackageInfo a(Context context, String str, String str2, String str3, String str4, String str5) throws UCSetupException {
        boolean a = d.a(str2);
        boolean a2 = d.a(str3);
        boolean a3 = d.a(str4);
        if (!a || ((Boolean) invoke(10011, new Object[0])).booleanValue()) {
            String str6;
            String str7;
            String str8;
            String str9;
            if (a) {
                str6 = null;
                str7 = null;
                str8 = null;
            } else {
                File file = (File) invoke(expectDirFile1S, str2);
                str8 = UCCyclone.expectFile(file, "core.jar").getAbsolutePath();
                try {
                    str6 = UCCyclone.expectFile(file, "sdk_shell.jar").getAbsolutePath();
                } catch (Throwable th) {
                    str6 = null;
                }
                try {
                    str7 = UCCyclone.expectFile(file, "browser_if.jar").getAbsolutePath();
                } catch (Throwable th2) {
                    str7 = null;
                }
            }
            if (str == null) {
                str9 = "specified";
            } else {
                str9 = str;
            }
            return new com.uc.webview.export.internal.utility.UCMPackageInfo(context, str9, str3, str4, str2, true, str6, str7, str8, str5, false);
        } else if (a2 && a3) {
            return null;
        } else {
            throw new UCSetupException((int) SettingsConst.USE_DEFAULT_CONTROLLER, "No ucm dex file specified.");
        }
    }

    private static List<UCMPackageInfo> a(Context context, File file, List<UCMPackageInfo> list) throws UCSetupException {
        List arrayList;
        int i = 0;
        if (list == null) {
            arrayList = new ArrayList();
        }
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, "sdk_shell.jar");
            File file3 = new File(file, "browser_if.jar");
            File file4 = new File(file, "core.jar");
            File file5 = new File(file, ShareConstants.SO_PATH);
            boolean z = file4.exists() && ((!SDKFactory.m || file2.exists()) && ((!SDKFactory.m || file3.exists()) && file5.isDirectory()));
            if (z) {
                for (String file6 : ARCHS) {
                    File file7 = new File(file5, file6);
                    if (file7.isDirectory()) {
                        file5 = file7;
                        break;
                    }
                }
                File file8 = new File(file, "assets");
                if (z) {
                    arrayList.add(new com.uc.webview.export.internal.utility.UCMPackageInfo(context, "specified", file5.getAbsolutePath(), file8.getAbsolutePath(), file.getAbsolutePath(), true, file2.getAbsolutePath(), file3.getAbsolutePath(), file4.getAbsolutePath(), null, false));
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file9 = listFiles[i];
                    if (file9.isDirectory()) {
                        a(context, file9, arrayList);
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    public static boolean checkNeedDecompress(Context context, String str, String str2) {
        if (!new File(str2).exists()) {
            return false;
        }
        for (UCMPackageInfo uCMPackageInfo : a(context, new File(str), new ArrayList())) {
            if (!bd.a(context, uCMPackageInfo.dataDir, str2)) {
                return false;
            }
        }
        return true;
    }

    public static List<UCMPackageInfo> listFromSharedApps(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        String str = (String) concurrentHashMap.get(UCCore.OPTION_SHARE_CORE_PKG_NAME);
        String str2 = str == null ? null : "/data/data/" + str + "/app_ucmsdk";
        String str3 = (String) concurrentHashMap.get(UCCore.OPTION_SHARE_CORE_SYS_PATH);
        if (str2 == null) {
            str2 = str3;
        }
        List<UCMPackageInfo> arrayList = new ArrayList();
        if (str2 == null) {
            try {
                throw new UCSetupException(2013, "Please set UCCore.OPTION_SHARE_CORE_PKG_NAME or UCCore.OPTION_SHARE_CORE_SYS_PATH");
            } catch (Throwable e) {
                Log.e("UCMPackageInfo", "getAppUCMPackageInfo", e);
            }
        } else {
            if (str != null) {
                if (str.equals(context.getPackageName())) {
                    return arrayList;
                }
            }
            List<a> a = a.a(new File(str2, "config.json"));
            if (a.size() == 0) {
                throw new UCSetupException(2014, "Config.json does not exist in: " + str2);
            }
            for (a aVar : a) {
                if (!d.a(aVar.c)) {
                    File file = new File(aVar.c);
                    File file2 = new File(aVar.d);
                    File file3 = new File(aVar.e);
                    String str4 = aVar.a;
                    String str5 = aVar.b;
                    boolean booleanValue = ((Boolean) invoke(compareVersion, str4, Version.SUPPORT_U4_MIN, "最小u4内核版本不通过")).booleanValue();
                    boolean booleanValue2 = ((Boolean) invoke(compareVersion, Version.NAME, str5, "最小SDK版本不通过")).booleanValue();
                    if (booleanValue && booleanValue2) {
                        Log.d("UCMPackageInfo", "版本校验通过!!!");
                        if (file.exists() && file2.exists() && file3.exists()) {
                            arrayList.add(a(context, str, file.getAbsolutePath(), file2.getAbsolutePath(), file3.getAbsolutePath(), null));
                        } else {
                            Log.i("UCMPackageInfo", file.getAbsolutePath() + " or " + file2.getAbsolutePath() + " or " + file3.getAbsolutePath() + " not exist");
                        }
                    } else {
                        Log.d("UCMPackageInfo", "版本校验不通过>>config ucmVersion:" + str4 + ",SUPPORT_U4_MIN=" + Version.SUPPORT_U4_MIN);
                        Log.d("UCMPackageInfo", "版本校验不通过>>config ucmSuportSDKMin:" + str5 + ",NAME=" + Version.NAME);
                    }
                }
            }
            return arrayList;
        }
    }
}
