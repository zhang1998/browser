package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCMPackageInfo.a;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.download.UpdateTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class ar extends UCSubSetupTask<ar, ar> {
    private static final HashMap<String, String> a = new as();

    public final void run() {
        Throwable e;
        File file;
        a aVar = null;
        Boolean bool = (Boolean) getOption(UCCore.OPTION_SHARE_CORE);
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
        if (!((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue()) {
            UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
            if (totalLoadedUCM != null && totalLoadedUCM.coreType != 2) {
                UCMPackageInfo uCMPackageInfo = totalLoadedUCM.ucmPackageInfo;
                try {
                    File updateRoot = UpdateTask.getUpdateRoot(context);
                    File file2 = new File(updateRoot.getParent(), "config.json");
                    try {
                        Log.d("ShareCoreTask", "处理共享内核:" + booleanValue);
                        if (booleanValue) {
                            List arrayList = new ArrayList();
                            if (uCMPackageInfo != null) {
                                String str = (String) UCMPackageInfo.invoke(10012, (String) this.mOptions.get(UCCore.OPTION_UCM_LIB_DIR));
                                Context context2 = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
                                aVar = new a();
                                aVar.a = Build.UCM_VERSION;
                                aVar.b = Build.UCM_SUPPORT_SDK_MIN;
                                r9 = new Object[2];
                                r9[0] = (File) UCMPackageInfo.invoke(UCMPackageInfo.getKernalShareJarLnkRoot, context2);
                                r9[1] = str;
                                aVar.c = ((File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r9)).getAbsolutePath();
                                aVar.d = uCMPackageInfo.soDirPath;
                                r8 = new Object[2];
                                r8[0] = (File) UCMPackageInfo.invoke(10008, context2);
                                r8[1] = str;
                                aVar.e = ((File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r8)).getAbsolutePath();
                            }
                            if (aVar != null) {
                                arrayList.add(aVar);
                            }
                            if (!a(arrayList, file2)) {
                                Log.d("ShareCoreTask", "处理共享内核:内核信息无变化");
                            } else if (d.c(updateRoot)) {
                                if (!a()) {
                                    Log.e("ShareCoreTask", "createShareJarFromSo() fail.");
                                    arrayList.remove(aVar);
                                }
                                if (!(aVar == null || a(uCMPackageInfo, aVar))) {
                                    Log.e("ShareCoreTask", "modifyFilePermissions(config) fail.");
                                    arrayList.remove(aVar);
                                }
                                if (a.a(arrayList, file2) && d.a(file2)) {
                                    Log.i("ShareCoreTask", "成功修改共享内核配置文件");
                                } else {
                                    Log.i("ShareCoreTask", "修改共享内核配置文件失败");
                                }
                            } else {
                                Log.e("ShareCoreTask", "setExecutable(ucmRoot) fail.");
                            }
                        } else if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        file = file2;
                        Log.e("ShareCoreTask", "FilePermissions.run", e);
                        if (file != null) {
                            file.delete();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    file = null;
                    Log.e("ShareCoreTask", "FilePermissions.run", e);
                    if (file != null) {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r11) {
        /*
        r2 = 0;
    L_0x0001:
        r0 = 10033; // 0x2731 float:1.4059E-41 double:4.957E-320;
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r1[r2] = r11;
        r0 = com.uc.webview.export.internal.setup.UCMPackageInfo.invoke(r0, r1);
        r0 = (java.io.File) r0;
        r1 = "libcore_jar_kj_uc.so";
        r1 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r0, r1);	 Catch:{ UCKnownException -> 0x0022 }
        r0 = r1.getAbsolutePath();	 Catch:{ UCKnownException -> 0x0022 }
        r1 = new java.io.File;
        r1.<init>(r0);
        r0 = r1.getParent();
        return r0;
    L_0x0022:
        r1 = move-exception;
        r4 = r0.listFiles();
        if (r4 == 0) goto L_0x0053;
    L_0x0029:
        r5 = com.uc.webview.export.internal.setup.UCMPackageInfo.ARCHS;
        r6 = r5.length;
        r3 = r2;
    L_0x002d:
        if (r3 >= r6) goto L_0x0053;
    L_0x002f:
        r7 = r5[r3];
        r8 = r4.length;
        r0 = r2;
    L_0x0033:
        if (r0 >= r8) goto L_0x004f;
    L_0x0035:
        r9 = r4[r0];
        r10 = r9.getName();
        r10 = r7.equals(r10);
        if (r10 == 0) goto L_0x004c;
    L_0x0041:
        r10 = r9.isDirectory();
        if (r10 == 0) goto L_0x004c;
    L_0x0047:
        r11 = r9.getAbsolutePath();
        goto L_0x0001;
    L_0x004c:
        r0 = r0 + 1;
        goto L_0x0033;
    L_0x004f:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x002d;
    L_0x0053:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.ar.a(java.lang.String):java.lang.String");
    }

    private static String a(Context context, String str, String str2) {
        if (d.a(str2)) {
            return null;
        }
        File file = new File(str2);
        String str3 = (String) a.get(file.getName());
        String str4 = (String) UCMPackageInfo.invoke(10012, str);
        r3 = new Object[2];
        r3[0] = (File) UCMPackageInfo.invoke(UCMPackageInfo.getKernalShareJarLnkRoot, context);
        r3[1] = str4;
        File file2 = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r3);
        r5 = new Object[2];
        r5[0] = (File) UCMPackageInfo.invoke(UCMPackageInfo.getKernalShareJarCpyRoot, context);
        r5[1] = str4;
        return d.a(file, new File(file2, str3), new File((File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r5), str3), false).getAbsolutePath();
    }

    private boolean a() {
        String str = (String) this.mOptions.get(UCCore.OPTION_UCM_LIB_DIR);
        File file = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectDirFile1S, a(str));
        Context context = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
        try {
            String absolutePath = UCCyclone.expectFile(file, UCMPackageInfo.CORE_IMPL_DEX_FILE_USING_SO_SUFFIX).getAbsolutePath();
            String absolutePath2 = UCCyclone.expectFile(file, UCMPackageInfo.SDK_SHELL_DEX_FILE_USING_SO_SUFFIX).getAbsolutePath();
            String absolutePath3 = UCCyclone.expectFile(file, UCMPackageInfo.BROWSER_IF_FOR_EXPORT_FILE_USING_SO_SUFFIX).getAbsolutePath();
            a(context, str, absolutePath);
            a(context, str, absolutePath2);
            a(context, str, absolutePath3);
            return true;
        } catch (Throwable th) {
            Log.e("ShareCoreTask", "ShareCoreTask::createShareJarFromSo fail! " + th.toString());
            return false;
        }
    }

    private static boolean a(UCMPackageInfo uCMPackageInfo, a aVar) {
        File file = new File(aVar.c);
        if (d.c(file.getParentFile()) && d.c(file.getParentFile().getParentFile()) && d.c(file)) {
            File file2 = new File(aVar.e);
            File file3 = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, file2, UCMPackageInfo.RES_PAKS_DIR_NAME);
            if (d.c(file2.getParentFile()) && d.c(file2) && d.c(file3)) {
                file2 = new File(aVar.d);
                if (d.d(file2) || d.c(file2)) {
                    String[] a = d.a(uCMPackageInfo);
                    int length = a.length;
                    int i = 0;
                    while (i < length) {
                        File file4 = new File(file2, a[i]);
                        if (!file4.exists() || ((d.d(file4) || d.c(file4)) && (d.b(file4) || d.a(file4)))) {
                            i++;
                        } else {
                            Log.e("ShareCoreTask", "setExecutable(soFile) or setReadable(soFile) fail." + file4);
                            return false;
                        }
                    }
                    for (String file5 : a.values()) {
                        File file6 = new File(file, file5);
                        if (!d.b(file6) && !d.a(file6)) {
                            Log.e("ShareCoreTask", "setReadable(new File(dexDir, dex)) fail." + file6);
                            return false;
                        }
                    }
                    return true;
                }
                Log.e("ShareCoreTask", "setExecutable soDir fail." + file2);
                return false;
            }
            Log.e("ShareCoreTask", "setExecutable resDir fail." + file);
            return false;
        }
        Log.e("ShareCoreTask", "setExecutable dexDir and parent's dir fail." + file);
        return false;
    }

    private static boolean a(List<a> list, File file) {
        if (!file.exists()) {
            return true;
        }
        List a = a.a(file);
        if (a.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            boolean z;
            a aVar = (a) a.get(i);
            a aVar2 = (a) list.get(i);
            if (a(aVar.a, aVar2.a) && a(aVar.b, aVar2.b) && a(aVar.c, aVar2.c) && a(aVar.d, aVar2.d) && a(aVar.f, aVar2.f) && a(aVar.g, aVar2.g) && a(aVar.e, aVar2.e)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }
}
