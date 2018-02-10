package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.internal.utility.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class l implements Runnable {
    private ValueCallback<Bundle> a = null;
    private File b;
    private File c;
    private File d;
    private Context e;
    private UCLogger f = UCLogger.create("d", "CreateCoreZipTask");

    public l(Context context, ValueCallback<Bundle> valueCallback) {
        this.e = context;
        this.a = valueCallback;
    }

    public final synchronized void run() {
        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
        if (!(totalLoadedUCM == null || totalLoadedUCM.coreType == 2)) {
            UCMPackageInfo uCMPackageInfo = totalLoadedUCM.ucmPackageInfo;
            try {
                this.b = (File) UCMPackageInfo.invoke(10001, this.e, "cmodule");
                this.d = new File(this.b, "zip");
                this.c = new File(this.b, "uccore_module" + Build.CORE_VERSION + ShareConstants.PATCH_SUFFIX);
                if (a(this.d) && a(uCMPackageInfo) && a(this.d, this.c)) {
                    this.a.onReceiveValue(a(true, this.c.getAbsolutePath()));
                } else {
                    this.a.onReceiveValue(a(false, null));
                }
            } catch (Throwable th) {
                this.f.print("execption: CreateCoreZipTask :" + th.getMessage(), new Throwable[0]);
            }
        }
    }

    private boolean a(UCMPackageInfo uCMPackageInfo) {
        try {
            UCCyclone.expectCreateDirFile(this.d);
            File expectCreateDirFile = UCCyclone.expectCreateDirFile(new File(this.d, ShareConstants.SO_PATH));
            File expectCreateDirFile2 = UCCyclone.expectCreateDirFile(new File(this.d, "assets"));
            if (!a(uCMPackageInfo.coreImplModule)) {
                this.f.print("fail: core.jar is Missing", new Throwable[0]);
                return false;
            } else if (a(uCMPackageInfo.sdkShellModule)) {
                String[] a = d.a(uCMPackageInfo);
                int length = a.length;
                int i = 0;
                while (i < length) {
                    String str = a[i];
                    if (a(uCMPackageInfo.soDirPath, str, expectCreateDirFile)) {
                        i++;
                    } else {
                        this.f.print("fail:" + str + " is Missing", new Throwable[0]);
                        return false;
                    }
                }
                if (a(uCMPackageInfo, expectCreateDirFile2)) {
                    return true;
                }
                this.f.print("fail: copyRes Fail", new Throwable[0]);
                return false;
            } else {
                this.f.print("fail: sdk_shell.jar is Missing", new Throwable[0]);
                return false;
            }
        } catch (Throwable th) {
            this.f.print("execption:" + th.getMessage(), new Throwable[0]);
            return false;
        }
    }

    private boolean a(Pair<String, String> pair) {
        if (pair != null) {
            try {
                if (pair.first != null) {
                    File file = new File(this.d, "tmp");
                    b(new File((String) pair.first), file);
                    File file2 = new File(file, ShareConstants.DEX_IN_JAR);
                    if (file2.exists()) {
                        File file3 = new File(this.d, new File((String) pair.first).getName().replace(ShareConstants.DEXMODE_JAR, ShareConstants.DEX_PATH));
                        d.a(file2, file3, file3, true);
                        a(file);
                        return true;
                    }
                    this.f.print("execption: copyJar:" + file2.getAbsolutePath() + " not exist.", new Throwable[0]);
                }
            } catch (Throwable th) {
                this.f.print("execption: copyJar:" + th.getMessage(), new Throwable[0]);
            }
        }
        return false;
    }

    private boolean a(String str, String str2, File file) {
        try {
            File file2 = new File(str, str2);
            File file3 = new File(file, str2);
            d.a(file2, file3, file3, true);
            return true;
        } catch (Throwable th) {
            this.f.print("fail: copySo:" + th.getMessage(), new Throwable[0]);
            return false;
        }
    }

    private boolean a(UCMPackageInfo uCMPackageInfo, File file) {
        if (uCMPackageInfo.resDirPath == null) {
            return false;
        }
        try {
            c(new File(uCMPackageInfo.resDirPath), file);
        } catch (IOException e) {
            this.f.print("fail: copyRes:" + e.getMessage(), new Throwable[0]);
        }
        return true;
    }

    private boolean a(File file, File file2) throws IOException {
        ZipOutputStream zipOutputStream;
        IOException e;
        Throwable th;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            try {
                if (file.isFile()) {
                    a(zipOutputStream, file, "");
                } else {
                    File[] listFiles = file.listFiles();
                    for (File a : listFiles) {
                        a(zipOutputStream, a, "");
                    }
                }
                try {
                    zipOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    this.f.print("fail: zip in close:" + e2.getMessage(), new Throwable[0]);
                    return false;
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    this.f.print("fail: zip:" + e2.getMessage(), new Throwable[0]);
                    if (zipOutputStream != null) {
                        return false;
                    }
                    try {
                        zipOutputStream.close();
                        return false;
                    } catch (IOException e22) {
                        this.f.print("fail: zip in close:" + e22.getMessage(), new Throwable[0]);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e222) {
                            this.f.print("fail: zip in close:" + e222.getMessage(), new Throwable[0]);
                            return false;
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            zipOutputStream = null;
            this.f.print("fail: zip:" + e222.getMessage(), new Throwable[0]);
            if (zipOutputStream != null) {
                return false;
            }
            zipOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            throw th;
        }
    }

    private void a(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        FileInputStream fileInputStream;
        IOException e;
        Throwable th;
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File a : listFiles) {
                    a(zipOutputStream, a, str + file.getName() + "/");
                }
                fileInputStream = null;
            } else {
                byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException e2) {
                    e = e2;
                    try {
                        this.f.print("fail: zipFileOrDirectory:" + e.getMessage(), new Throwable[0]);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                this.f.print("fail: zipFileOrDirectory in close:" + e3.getMessage(), new Throwable[0]);
                                throw e3;
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e32) {
                    this.f.print("fail: zipFileOrDirectory in close:" + e32.getMessage(), new Throwable[0]);
                    throw e32;
                }
            }
        } catch (IOException e4) {
            e32 = e4;
            fileInputStream = null;
            this.f.print("fail: zipFileOrDirectory:" + e32.getMessage(), new Throwable[0]);
            throw e32;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static void b(File file, File file2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
        FileOutputStream fileOutputStream;
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file3 = new File(file2, nextEntry.getName());
                    File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        throw new FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                    } else if (!nextEntry.isDirectory()) {
                        fileOutputStream = new FileOutputStream(file3);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            zipInputStream.close();
        }
    }

    private void c(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                c(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        d.a(file, file2, file2, true);
    }

    private boolean a(File file) {
        if (!file.exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                a(listFiles[i]);
            } else {
                listFiles[i].delete();
            }
        }
        return file.delete();
    }

    private static Bundle a(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        bundle.putString("zippath", str);
        return bundle;
    }
}
