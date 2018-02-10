package com.alibaba.wireless.security.framework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.a.c;
import com.alibaba.wireless.security.open.IRouterComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.webview.browser.interfaces.SettingKeys;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b {
    private static b d;
    HashMap<Class, Object> a = new HashMap();
    IRouterComponent b = null;
    com.alibaba.wireless.security.framework.b.b c = null;
    private Context e;
    private final HashMap<String, c> f = new HashMap();
    private int g = 0;
    private File h = null;
    private int i;
    private boolean j = true;
    private String k = null;

    interface a {
        void a(int i, Class<? extends Service> cls);
    }

    private b(Context context) {
        this.e = context.getApplicationContext();
        this.k = null;
        this.h = this.e.getDir("SGLib", 0);
        this.c = new com.alibaba.wireless.security.framework.b.b(this.e, this.h + File.separator + "lock.lock");
    }

    private int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.e.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private c a(String str, String str2, Context context, String str3) throws SecException {
        String str4;
        Throwable th;
        Throwable th2;
        this.g = 1;
        long currentTimeMillis = System.currentTimeMillis();
        c cVar;
        c cVar2;
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            PackageInfo packageArchiveInfo = this.e.getPackageManager().getPackageArchiveInfo(str2, 133);
            if (packageArchiveInfo == null) {
                throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
            }
            com.alibaba.wireless.security.framework.b.a.b("    getPackageArchiveInfo( " + str2 + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis2) + " ms");
            String str5 = packageArchiveInfo.versionName;
            String string = packageArchiveInfo.applicationInfo.metaData.getString(ISecurityGuardPlugin.METADATA_DEPENDENCIES);
            String str6 = str + "(" + str5 + ")";
            if (str3.length() != 0) {
                str6 = str3 + "->" + str6;
            }
            if (a(string, str6, false)) {
                int i = packageArchiveInfo.applicationInfo.metaData.getInt(ISecurityGuardPlugin.METADATA_PLUGINID);
                str4 = "libsg" + str + "so-" + str5 + ".so";
                if (a(str2, this.h.getAbsolutePath(), str4)) {
                    str6 = packageArchiveInfo.applicationInfo.metaData.getString("pluginclass");
                    if (str6 == null) {
                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                    }
                    str6 = str6.trim();
                    ClassLoader d = d(str2);
                    Class a = a(d, str6);
                    if (a == null) {
                        com.alibaba.wireless.security.framework.b.a.b("load " + str6 + " failed from plugin ");
                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                    }
                    ISecurityGuardPlugin iSecurityGuardPlugin = (ISecurityGuardPlugin) a.newInstance();
                    Resources a2 = a(e(str2));
                    long currentTimeMillis3 = System.currentTimeMillis();
                    cVar = new c(d, a2, packageArchiveInfo, iSecurityGuardPlugin);
                    IRouterComponent onPluginLoaded = iSecurityGuardPlugin.onPluginLoaded(context, this.b, packageArchiveInfo, null);
                    if (i == 1) {
                        this.b = onPluginLoaded;
                        iSecurityGuardPlugin.init(context, Boolean.valueOf(this.j));
                    }
                    com.alibaba.wireless.security.framework.b.a.b("    onPluginLoaded( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis3) + " ms");
                    com.alibaba.wireless.security.framework.b.a.b("so full path: " + h.a(d, "sg" + str + "so-" + str5));
                    String[] strArr = new String[]{str, str5, str6};
                    this.b.doCommandNative(10102, new int[]{i}, strArr, null, null);
                    cVar2 = cVar;
                    com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return cVar2;
                }
                throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
            }
            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        } catch (Throwable e) {
            th = e;
            cVar2 = cVar;
            com.alibaba.wireless.security.framework.b.a.a("", th);
            com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return cVar2;
        } catch (Throwable e2) {
            th = e2;
            cVar2 = cVar;
            com.alibaba.wireless.security.framework.b.a.a("", th);
            com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return cVar2;
        } catch (SecException e3) {
            if (e3.getErrorCode() == 103) {
                File file = new File(this.h.getAbsolutePath() + File.separator + str4);
                this.c.a();
                if (file.exists()) {
                    file.delete();
                }
                this.c.b();
            }
            throw e3;
        } catch (Throwable e22) {
            th2 = e22;
            cVar2 = null;
            th = th2;
            com.alibaba.wireless.security.framework.b.a.a("", th);
            com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return cVar2;
        } catch (Throwable e222) {
            th2 = e222;
            cVar2 = null;
            th = th2;
            com.alibaba.wireless.security.framework.b.a.a("", th);
            com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return cVar2;
        } catch (Throwable th3) {
            com.alibaba.wireless.security.framework.b.a.b("loadApk( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
    }

    public static b a(Context context) {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b(context);
                }
            }
        }
        return d;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Class<?> cls = null;
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
        }
        com.alibaba.wireless.security.framework.b.a.b("    loadPluginClass( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return cls;
    }

    private String a(a aVar, c cVar) {
        String b = aVar.b();
        if (b == null) {
            b = cVar.b;
        }
        return b.startsWith(".") ? aVar.a() + b : b;
    }

    private void a(a aVar, a aVar2) {
        String a = aVar.a();
        if (TextUtils.isEmpty(a)) {
            throw new NullPointerException("disallow null packageName.");
        }
        c b = b(a);
        if (b == null) {
            aVar2.a(1, null);
            return;
        }
        String b2 = aVar.b();
        Class a2 = a(b.c, b2);
        if (a2 == null) {
            aVar2.a(2, null);
            return;
        }
        a2 = c(a2);
        if (a2 == null) {
            aVar2.a(3, null);
            return;
        }
        aVar.putExtra("extra.class", b2);
        aVar.putExtra("extra.package", a);
        aVar2.a(0, a2);
    }

    private boolean a(File file) {
        try {
            return !file.getAbsolutePath().equals(file.getCanonicalPath());
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r12, java.io.File r13) {
        /*
        r11 = this;
        r6 = 1;
        r9 = 0;
        r7 = 0;
        if (r12 == 0) goto L_0x0007;
    L_0x0005:
        if (r13 != 0) goto L_0x0008;
    L_0x0007:
        return r7;
    L_0x0008:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r0.<init>();	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r1 = r13.getAbsolutePath();	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r1 = ".tmp";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r8.<init>(r0);	 Catch:{ Exception -> 0x00f7, all -> 0x00bc }
        r0 = r8.exists();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        if (r0 == 0) goto L_0x002d;
    L_0x002a:
        r8.delete();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
    L_0x002d:
        r0 = r13.exists();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        if (r0 == 0) goto L_0x0036;
    L_0x0033:
        r13.delete();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
    L_0x0036:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        r0.<init>(r12);	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        r1 = r0.getChannel();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        r0 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00fb, all -> 0x00e7 }
        r0.<init>(r8);	 Catch:{ Exception -> 0x00fb, all -> 0x00e7 }
        r0 = r0.getChannel();	 Catch:{ Exception -> 0x00fb, all -> 0x00e7 }
        r2 = 0;
        r4 = r1.size();	 Catch:{ Exception -> 0x00ff, all -> 0x00e9 }
        r0.transferFrom(r1, r2, r4);	 Catch:{ Exception -> 0x00ff, all -> 0x00e9 }
        r1.close();	 Catch:{ Exception -> 0x0073, all -> 0x00e9 }
        r1 = r6;
    L_0x0055:
        r0.close();	 Catch:{ Exception -> 0x007b, all -> 0x00ed }
    L_0x0058:
        if (r1 == 0) goto L_0x0083;
    L_0x005a:
        if (r6 == 0) goto L_0x0083;
    L_0x005c:
        r0 = r8.exists();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        if (r0 == 0) goto L_0x0083;
    L_0x0062:
        r0 = r8.length();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        r2 = r12.length();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0083;
    L_0x006e:
        r7 = r8.renameTo(r13);	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        goto L_0x0007;
    L_0x0073:
        r2 = move-exception;
        r3 = "";
        com.alibaba.wireless.security.framework.b.a.a(r3, r2);	 Catch:{ Exception -> 0x00ff, all -> 0x00e9 }
        r1 = r7;
        goto L_0x0055;
    L_0x007b:
        r2 = move-exception;
        r3 = "";
        com.alibaba.wireless.security.framework.b.a.a(r3, r2);	 Catch:{ Exception -> 0x0105, all -> 0x00ed }
        r6 = r7;
        goto L_0x0058;
    L_0x0083:
        r8.delete();	 Catch:{ Exception -> 0x0087, all -> 0x00e4 }
        goto L_0x0007;
    L_0x0087:
        r0 = move-exception;
        r1 = r8;
        r2 = r9;
    L_0x008a:
        r3 = "";
        com.alibaba.wireless.security.framework.b.a.a(r3, r0);	 Catch:{ all -> 0x00f3 }
        r1.delete();	 Catch:{ all -> 0x00f3 }
        r13.delete();	 Catch:{ all -> 0x00f3 }
        if (r2 == 0) goto L_0x009a;
    L_0x0097:
        r2.close();	 Catch:{ Exception -> 0x00af }
    L_0x009a:
        if (r9 == 0) goto L_0x0007;
    L_0x009c:
        r9.close();	 Catch:{ Exception -> 0x00a1 }
        goto L_0x0007;
    L_0x00a1:
        r0 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r0);
        r1.delete();
        r13.delete();
        goto L_0x0007;
    L_0x00af:
        r0 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r0);
        r1.delete();
        r13.delete();
        goto L_0x009a;
    L_0x00bc:
        r0 = move-exception;
        r8 = r9;
        r1 = r9;
    L_0x00bf:
        if (r1 == 0) goto L_0x00c4;
    L_0x00c1:
        r1.close();	 Catch:{ Exception -> 0x00ca }
    L_0x00c4:
        if (r9 == 0) goto L_0x00c9;
    L_0x00c6:
        r9.close();	 Catch:{ Exception -> 0x00d7 }
    L_0x00c9:
        throw r0;
    L_0x00ca:
        r1 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r1);
        r8.delete();
        r13.delete();
        goto L_0x00c4;
    L_0x00d7:
        r1 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r1);
        r8.delete();
        r13.delete();
        goto L_0x00c9;
    L_0x00e4:
        r0 = move-exception;
        r1 = r9;
        goto L_0x00bf;
    L_0x00e7:
        r0 = move-exception;
        goto L_0x00bf;
    L_0x00e9:
        r2 = move-exception;
        r9 = r0;
        r0 = r2;
        goto L_0x00bf;
    L_0x00ed:
        r1 = move-exception;
        r10 = r1;
        r1 = r9;
        r9 = r0;
        r0 = r10;
        goto L_0x00bf;
    L_0x00f3:
        r0 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x00bf;
    L_0x00f7:
        r0 = move-exception;
        r1 = r9;
        r2 = r9;
        goto L_0x008a;
    L_0x00fb:
        r0 = move-exception;
        r2 = r1;
        r1 = r8;
        goto L_0x008a;
    L_0x00ff:
        r2 = move-exception;
        r9 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x008a;
    L_0x0105:
        r1 = move-exception;
        r2 = r9;
        r9 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.io.File, java.io.File):boolean");
    }

    private synchronized boolean a(String str, String str2, String str3) {
        ZipFile zipFile;
        Throwable e;
        boolean z = true;
        synchronized (this) {
            if (!h.a(this.e) || VERSION.SDK_INT <= 19) {
                long currentTimeMillis = System.currentTimeMillis();
                this.c.a();
                try {
                    File file = new File(str2 + File.separator + str3);
                    if (file.exists()) {
                        this.c.b();
                        com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    } else {
                        zipFile = new ZipFile(str);
                        try {
                            String[] strArr = new String[]{"armeabi", "armeabi-v7a", "x86"};
                            for (int i = 0; i < 3; i++) {
                                ZipEntry entry = zipFile.getEntry(new StringBuilder(ShareConstants.SO_PATH).append(File.separator).append(strArr[i]).append(File.separator).append(str3).toString());
                                if (entry != null) {
                                    z = a(zipFile, entry, file);
                                    this.c.b();
                                    try {
                                        zipFile.close();
                                    } catch (IOException e2) {
                                    }
                                    com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                    break;
                                }
                            }
                            this.c.b();
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                            }
                            com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                com.alibaba.wireless.security.framework.b.a.a("", e);
                                this.c.b();
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                z = false;
                                return z;
                            } catch (Throwable th) {
                                e = th;
                                this.c.b();
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                throw e;
                            }
                        }
                        z = false;
                    }
                } catch (IOException e7) {
                    e = e7;
                    zipFile = null;
                    com.alibaba.wireless.security.framework.b.a.a("", e);
                    this.c.b();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    e = th2;
                    zipFile = null;
                    this.c.b();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    com.alibaba.wireless.security.framework.b.a.b("    extractSoInPlugin( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    throw e;
                }
            }
        }
        return z;
    }

    private boolean a(String str, String str2, boolean z) throws SecException {
        if (str.trim().length() != 0) {
            String[] split = str.split(";");
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.length() != 0) {
                    String[] split2 = trim2.split(":");
                    if (split2.length != 2) {
                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                    }
                    int indexOf = str2.indexOf(split2[0]);
                    if (indexOf >= 0) {
                        int indexOf2 = str2.indexOf("(", indexOf);
                        indexOf = str2.indexOf(")", indexOf);
                        if (indexOf2 < 0 || indexOf < 0 || indexOf2 > indexOf) {
                            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                        }
                        trim2 = str2.substring(indexOf2 + 1, indexOf);
                        if (a(trim2, split2[1]) < 0) {
                            trim2 = "version " + trim2 + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                trim2 = trim2 + ", depended by: " + str2;
                            }
                            throw new SecException(trim2, (int) SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET);
                        }
                    } else {
                        c cVar = (c) this.f.get(split2[0]);
                        if (cVar == null) {
                            cVar = c(split2[0], str2, !z);
                            if (cVar == null) {
                                if (!z) {
                                    throw new SecException(str2, (int) SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                                }
                            }
                        }
                        if (a(cVar.g.getVersion(), split2[1]) < 0) {
                            trim2 = "version " + cVar.g.getVersion() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                trim2 = trim2 + ", depended by: " + str2;
                            }
                            throw new SecException(trim2, (int) SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET);
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.zip.ZipFile r9, java.util.zip.ZipEntry r10, java.io.File r11) {
        /*
        r1 = 1;
        r4 = 0;
        r2 = 0;
        if (r9 == 0) goto L_0x0009;
    L_0x0005:
        if (r10 == 0) goto L_0x0009;
    L_0x0007:
        if (r11 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r0.<init>();	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r5 = r11.getAbsolutePath();	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r5 = ".tmp";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x00e5, all -> 0x00b7 }
        r0 = r3.exists();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r3.delete();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
    L_0x002f:
        r0 = r11.exists();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r11.delete();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
    L_0x0038:
        r6 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        r0 = r9.getInputStream(r10);	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        r5 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x00e9, all -> 0x00d8 }
        r0 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00e9, all -> 0x00d8 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x00e9, all -> 0x00d8 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x00e9, all -> 0x00d8 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r7 = new byte[r0];	 Catch:{ Exception -> 0x00ed, all -> 0x00da }
        r0 = r6.read(r7);	 Catch:{ Exception -> 0x00ed, all -> 0x00da }
    L_0x0053:
        r8 = -1;
        if (r0 == r8) goto L_0x005f;
    L_0x0056:
        r8 = 0;
        r5.write(r7, r8, r0);	 Catch:{ Exception -> 0x00ed, all -> 0x00da }
        r0 = r6.read(r7);	 Catch:{ Exception -> 0x00ed, all -> 0x00da }
        goto L_0x0053;
    L_0x005f:
        r6.close();	 Catch:{ Exception -> 0x0081, all -> 0x00da }
        r0 = r1;
    L_0x0063:
        r5.close();	 Catch:{ Exception -> 0x0084, all -> 0x00dd }
    L_0x0066:
        if (r0 == 0) goto L_0x0087;
    L_0x0068:
        if (r1 == 0) goto L_0x0087;
    L_0x006a:
        r0 = r3.exists();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        if (r0 == 0) goto L_0x0087;
    L_0x0070:
        r0 = r3.length();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        r6 = r10.getSize();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x0087;
    L_0x007c:
        r2 = r3.renameTo(r11);	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        goto L_0x0009;
    L_0x0081:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0063;
    L_0x0084:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0066;
    L_0x0087:
        r3.delete();	 Catch:{ Exception -> 0x008c, all -> 0x00d5 }
        goto L_0x0009;
    L_0x008c:
        r0 = move-exception;
        r1 = r3;
        r3 = r4;
    L_0x008f:
        r5 = "";
        com.alibaba.wireless.security.framework.b.a.a(r5, r0);	 Catch:{ all -> 0x00e1 }
        r1.delete();	 Catch:{ all -> 0x00e1 }
        r11.delete();	 Catch:{ all -> 0x00e1 }
        if (r3 == 0) goto L_0x009f;
    L_0x009c:
        r3.close();	 Catch:{ Exception -> 0x00af }
    L_0x009f:
        if (r4 == 0) goto L_0x0009;
    L_0x00a1:
        r4.close();	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0009;
    L_0x00a6:
        r0 = move-exception;
        r1.delete();
        r11.delete();
        goto L_0x0009;
    L_0x00af:
        r0 = move-exception;
        r1.delete();
        r11.delete();
        goto L_0x009f;
    L_0x00b7:
        r0 = move-exception;
        r3 = r4;
        r6 = r4;
    L_0x00ba:
        if (r6 == 0) goto L_0x00bf;
    L_0x00bc:
        r6.close();	 Catch:{ Exception -> 0x00c5 }
    L_0x00bf:
        if (r4 == 0) goto L_0x00c4;
    L_0x00c1:
        r4.close();	 Catch:{ Exception -> 0x00cd }
    L_0x00c4:
        throw r0;
    L_0x00c5:
        r1 = move-exception;
        r3.delete();
        r11.delete();
        goto L_0x00bf;
    L_0x00cd:
        r1 = move-exception;
        r3.delete();
        r11.delete();
        goto L_0x00c4;
    L_0x00d5:
        r0 = move-exception;
        r6 = r4;
        goto L_0x00ba;
    L_0x00d8:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x00da:
        r0 = move-exception;
        r4 = r5;
        goto L_0x00ba;
    L_0x00dd:
        r0 = move-exception;
        r6 = r4;
        r4 = r5;
        goto L_0x00ba;
    L_0x00e1:
        r0 = move-exception;
        r6 = r3;
        r3 = r1;
        goto L_0x00ba;
    L_0x00e5:
        r0 = move-exception;
        r1 = r4;
        r3 = r4;
        goto L_0x008f;
    L_0x00e9:
        r0 = move-exception;
        r1 = r3;
        r3 = r6;
        goto L_0x008f;
    L_0x00ed:
        r0 = move-exception;
        r1 = r3;
        r4 = r5;
        r3 = r6;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    private File b(String str, String str2, boolean z) throws SecException {
        File file = null;
        this.c.a();
        try {
            File f = f(str);
            File g = f == null ? g(str) : f;
            if (g != null) {
                f = new File(this.h, "libsg" + str + "_" + g.lastModified() + ".zip");
                if (f.exists()) {
                    if (!a(f) || c(f, g)) {
                        file = f;
                    } else {
                        f.delete();
                    }
                }
                f.delete();
                com.alibaba.wireless.security.framework.b.a.b("Source plugin " + g.getAbsolutePath() + " existed, try to create symbolic link!");
                if (b(g, f)) {
                    com.alibaba.wireless.security.framework.b.a.b("Symbolic link " + g.getAbsolutePath() + " to " + f.getAbsolutePath() + " create success");
                    file = f;
                } else {
                    com.alibaba.wireless.security.framework.b.a.b("Create symbolic link failed, we need to copy the source to the destination!");
                    if (a(g, f)) {
                        com.alibaba.wireless.security.framework.b.a.b("copy plugin from " + g.getAbsolutePath() + " to " + f.getAbsolutePath() + " success!");
                        file = f;
                    }
                }
            } else if (z) {
                file = h(str);
            }
            this.c.b();
            return file;
        } catch (Throwable th) {
            this.c.b();
        }
    }

    private Class<? extends Activity> b(Class<?> cls) {
        return SGBasePluginActivity.class.isAssignableFrom(cls) ? SGProxyActivity.class : null;
    }

    private void b(Context context, a aVar, int i) {
        com.alibaba.wireless.security.framework.b.a.b("launch " + aVar.b());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(aVar, i);
        } else {
            context.startActivity(aVar);
        }
    }

    private boolean b(File file, File file2) {
        Object obj = null;
        try {
            Method declaredMethod;
            if (VERSION.SDK_INT >= 21) {
                declaredMethod = Class.forName("android.system.Os").getDeclaredMethod("symlink", new Class[]{String.class, String.class});
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                declaredMethod = obj.getClass().getMethod("symlink", new Class[]{String.class, String.class});
            }
            declaredMethod.invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("create symbolic link( " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath() + " ) failed", e);
            return false;
        }
    }

    private synchronized c c(String str, String str2, boolean z) throws SecException {
        c cVar;
        cVar = (c) this.f.get(str);
        if (cVar == null) {
            if (this.h.exists() || this.h.mkdirs()) {
                File b = b(str, str2, z);
                if (b != null && b.exists()) {
                    cVar = a(str, b.getPath(), this.e, str2);
                    if (cVar == null) {
                        throw new SecException(str, 111);
                    }
                    this.f.put(str, cVar);
                    String str3 = str + "(" + cVar.g.getVersion() + ")";
                    String metaData = cVar.g.getMetaData("weakdependencies");
                    String str4 = str2.length() == 0 ? str3 : str2 + "->" + str3;
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        com.alibaba.wireless.security.framework.b.a.a("looper of current thread is null, try to create a new thread with a looper");
                        HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                        handlerThread.start();
                        myLooper = handlerThread.getLooper();
                    }
                    new Handler(myLooper).postDelayed(new g(this, metaData, str4), 2000);
                } else if (z) {
                    String str5 = "plugin " + str + " not existed";
                    if (str2.length() != 0) {
                        str5 = str5 + ", depended by " + str2;
                    }
                    throw new SecException(str5, 110);
                } else {
                    cVar = null;
                }
            } else {
                throw new SecException(SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED);
            }
        }
        return cVar;
    }

    private Class<? extends Service> c(Class<?> cls) {
        return null;
    }

    private boolean c(File file, File file2) {
        boolean z = false;
        try {
            z = file.getCanonicalPath().equals(file2.getAbsolutePath());
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
        }
        return z;
    }

    private DexClassLoader d(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c.a();
        DexClassLoader dexClassLoader = new DexClassLoader(str, this.h.getAbsolutePath(), this.e.getApplicationInfo().nativeLibraryDir + File.pathSeparator + this.h, this.e.getClassLoader());
        this.c.b();
        com.alibaba.wireless.security.framework.b.a.b("    createDexClassLoader( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return dexClassLoader;
    }

    private String d(Class cls) {
        String str = "";
        String[] split = cls.getName().split("\\.");
        if (split.length < 2) {
            return str;
        }
        String str2 = split[split.length - 2];
        r4 = new String[20][];
        r4[0] = new String[]{"securesignature", "main"};
        r4[1] = new String[]{"staticdatastore", "main"};
        r4[2] = new String[]{"staticdataencrypt", "main"};
        r4[3] = new String[]{"atlasencrypt", "main"};
        r4[4] = new String[]{"datacollection", "main"};
        r4[5] = new String[]{"dynamicdataencrypt", "main"};
        r4[6] = new String[]{"dynamicdatastore", "main"};
        r4[7] = new String[]{"opensdk", "main"};
        r4[8] = new String[]{"statickeyencrypt", "main"};
        r4[9] = new String[]{SettingKeys.UserMachineID, "main"};
        r4[10] = new String[]{"safetoken", "main"};
        r4[11] = new String[]{"securitybody", "securitybody"};
        r4[12] = new String[]{"simulatordetect", "securitybody"};
        r4[13] = new String[]{"rootdetect", "securitybody"};
        r4[14] = new String[]{"maldetection", "securitybody"};
        r4[15] = new String[]{"nocaptcha", "nocaptcha"};
        r4[16] = new String[]{"useraction", "uatrace"};
        r4[17] = new String[]{"indiekit", "misc"};
        r4[18] = new String[]{"pkgvaliditycheck", "misc"};
        r4[19] = new String[]{"avmp", "avmp"};
        for (int i = 0; i < 20; i++) {
            com.alibaba.wireless.security.framework.b.a.b(r4[i][0] + " " + r4[i][1]);
            if (str2.equalsIgnoreCase(r4[i][0])) {
                str = r4[i][1];
                break;
            }
        }
        return str.length() == 0 ? str2 : str;
    }

    private AssetManager e(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            return assetManager;
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
            return null;
        }
    }

    private File f(String str) {
        if (this.k != null) {
            return null;
        }
        String a = h.a(b.class.getClassLoader(), "sg" + str);
        return (a == null || a.length() <= 0) ? null : new File(a);
    }

    private File g(String str) {
        String str2 = this.k;
        if (str2 == null) {
            try {
                str2 = this.e.getApplicationInfo().nativeLibraryDir;
            } catch (Exception e) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private File h(String str) {
        String str2;
        ZipFile zipFile;
        Throwable e;
        Throwable th;
        File file = null;
        try {
            str2 = this.e.getApplicationInfo().sourceDir;
        } catch (Exception e2) {
            str2 = null;
        }
        if (str2 != null) {
            String str3 = "libsg" + str + ".so";
            try {
                com.alibaba.wireless.security.framework.b.a.b("Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed");
                String stringBuilder = new StringBuilder(ShareConstants.SO_PATH).append(File.separator).append("armeabi").append(File.separator).append(str3).toString();
                String stringBuilder2 = new StringBuilder(ShareConstants.SO_PATH).append(File.separator).append("armeabi-v7a").append(File.separator).append(str3).toString();
                zipFile = new ZipFile(str2);
                try {
                    ZipEntry entry = zipFile.getEntry(stringBuilder);
                    ZipEntry entry2 = entry == null ? zipFile.getEntry(stringBuilder2) : entry;
                    if (entry2 != null) {
                        com.alibaba.wireless.security.framework.b.a.b("Plugin existed  in " + entry2.getName());
                        File file2 = new File(this.h, "libsg" + str + "_" + entry2.getTime() + ".zip");
                        if (a(file2)) {
                            file2.delete();
                        }
                        if (file2.exists() || a(zipFile, entry2, file2)) {
                            try {
                                com.alibaba.wireless.security.framework.b.a.b("Extract success");
                                file = file2;
                            } catch (Throwable e3) {
                                Throwable th2 = e3;
                                file = file2;
                                th = th2;
                                try {
                                    com.alibaba.wireless.security.framework.b.a.a("getPluginFile throws exception", th);
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    return file;
                                } catch (Throwable th3) {
                                    e3 = th3;
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (Exception e5) {
                                        }
                                    }
                                    throw e3;
                                }
                            }
                        }
                        com.alibaba.wireless.security.framework.b.a.b("Extract failed!!");
                    }
                    try {
                        zipFile.close();
                    } catch (Exception e6) {
                    }
                } catch (IOException e7) {
                    th = e7;
                    com.alibaba.wireless.security.framework.b.a.a("getPluginFile throws exception", th);
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return file;
                }
            } catch (IOException e8) {
                th = e8;
                zipFile = null;
                com.alibaba.wireless.security.framework.b.a.a("getPluginFile throws exception", th);
                if (zipFile != null) {
                    zipFile.close();
                }
                return file;
            } catch (Throwable th4) {
                zipFile = null;
                e3 = th4;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw e3;
            }
        }
        return file;
    }

    public int a(Context context, a aVar) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.startService(aVar);
            return 0;
        }
        a(aVar, new c(this, aVar, context));
        return this.i;
    }

    @TargetApi(14)
    public int a(Context context, a aVar, int i) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            b(context, aVar, i);
            return 0;
        }
        String a = aVar.a();
        if (TextUtils.isEmpty(a)) {
            throw new NullPointerException("disallow null packageName.");
        }
        c b = b(a);
        if (b == null) {
            return 1;
        }
        String a2 = a(aVar, b);
        Class a3 = a(b.c, a2);
        if (a3 == null) {
            return 2;
        }
        a3 = b(a3);
        if (a3 == null) {
            return 3;
        }
        aVar.putExtra("extra.class", a2);
        aVar.putExtra("extra.package", a);
        aVar.setClass(this.e, a3);
        b(context, aVar, i);
        return 0;
    }

    public int a(Context context, a aVar, ServiceConnection serviceConnection) {
        if (this.g == 0) {
            context.unbindService(serviceConnection);
            return 0;
        }
        a(aVar, new f(this, context, serviceConnection));
        return this.i;
    }

    public int a(Context context, a aVar, ServiceConnection serviceConnection, int i) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.bindService(aVar, serviceConnection, i);
            return 0;
        }
        a(aVar, new e(this, aVar, context, serviceConnection, i));
        return this.i;
    }

    public synchronized <T> T a(Class<T> cls) throws SecException {
        T cast;
        Object obj = this.a.get(cls);
        if (obj != null) {
            cast = cls.cast(obj);
        } else {
            String d = d((Class) cls);
            if (d.length() == 0) {
                cast = null;
            } else {
                c c = c(d, "", true);
                if (c == null) {
                    throw new SecException(110);
                }
                obj = c.g.getInterface(cls);
                if (obj == null) {
                    throw new SecException(SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
                }
                this.a.put(cls, obj);
                cast = cls.cast(obj);
            }
        }
        return cast;
    }

    public String a() {
        return "main";
    }

    public void a(String str) {
        if (str != null && !str.isEmpty()) {
            this.k = str;
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public int b(Context context, a aVar) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.stopService(aVar);
            return 0;
        }
        a(aVar, new d(this, aVar, context));
        return this.i;
    }

    public c b(String str) {
        for (Entry value : this.f.entrySet()) {
            c cVar = (c) value.getValue();
            if (cVar.a.equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return null;
    }

    public c c(String str) throws SecException {
        return c(str, "", true);
    }
}
