package com.taobao.weex.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.taobao.weex.a.m;
import com.taobao.weex.a.n;
import com.taobao.weex.common.p;
import com.taobao.weex.g;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public final class ag {
    static Context a = null;
    private static m b = null;
    private static g c = null;

    public static void a(Context context, m mVar, g gVar) {
        a = context;
        b = mVar;
        c = gVar;
    }

    private static String a(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private static String a(String str, int i) {
        Context context = a;
        if (context == null) {
            return "";
        }
        String str2 = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getPath();
        }
        return str2 + "/lib" + str + "bk" + i + ".so";
    }

    private static void b(String str, int i) {
        File file = new File(a(str, 1));
        if (file.exists()) {
            file.delete();
        }
    }

    private static boolean c(String str, int i) {
        return new File(a(str, i)).exists();
    }

    private static boolean a(String str, int i, n nVar) {
        try {
            if (!c(str, 1)) {
                return true;
            }
            if (b != null) {
                b.b(a(str, 1));
            } else {
                System.load(a(str, 1));
            }
            a(nVar, "2000", "Load file extract from apk successfully.");
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            a(nVar, com.taobao.weex.common.g.WX_ERR_COPY_FROM_APK.z, com.taobao.weex.common.g.WX_ERR_COPY_FROM_APK.a() + ":" + th2.getMessage());
            WXLogUtils.e("", th2);
            return false;
        }
    }

    private static boolean b(String str, n nVar) throws ZipException, IOException {
        Throwable th;
        ZipFile zipFile = null;
        String str2 = "lib/armeabi/lib" + str + ".so";
        String str3 = "";
        Context context = a;
        if (context == null) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str3 = applicationInfo.sourceDir;
        }
        ZipFile zipFile2 = new ZipFile(str3);
        try {
            Enumeration entries = zipFile2.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith(str2)) {
                    InputStream inputStream;
                    FileOutputStream openFileOutput;
                    FileChannel fileChannel;
                    try {
                        b(str, 1);
                        inputStream = zipFile2.getInputStream(zipEntry);
                        try {
                            openFileOutput = context.openFileOutput(new StringBuilder(ShareConstants.SO_PATH).append(str).append("bk1.so").toString(), 0);
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = null;
                            openFileOutput = null;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e2) {
                                }
                            }
                            if (openFileOutput != null) {
                                try {
                                    openFileOutput.close();
                                } catch (Exception e3) {
                                }
                            }
                            zipFile2.close();
                            throw th;
                        }
                        try {
                            fileChannel = openFileOutput.getChannel();
                            try {
                                byte[] bArr = new byte[1024];
                                int i = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileChannel.write(ByteBuffer.wrap(bArr, 0, read));
                                    i += read;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (openFileOutput != null) {
                                    try {
                                        openFileOutput.close();
                                    } catch (Exception e6) {
                                    }
                                }
                                zipFile2.close();
                                if (i <= 0) {
                                    return false;
                                }
                                try {
                                    return a(str, 1, nVar);
                                } catch (IOException e7) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    zipFile2 = null;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileChannel != null) {
                                    fileChannel.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                zipFile2.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileChannel = null;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            zipFile2.close();
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileChannel = null;
                        openFileOutput = null;
                        inputStream = null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        zipFile2.close();
                        throw th;
                    }
                }
            }
            zipFile2.close();
        } catch (IOException e8) {
            zipFile = zipFile2;
            if (zipFile != null) {
                zipFile.close();
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
        return false;
    }

    private static void a(n nVar, String str, String str2) {
        if (c != null) {
            c.a(SettingsConst.FALSE, str, str2);
        }
        if (nVar != null && str != null && str2 != null) {
            p pVar = new p();
            pVar.H = str;
            pVar.I = str2;
        }
    }

    public static boolean a(String str, n nVar) {
        Throwable e;
        boolean a;
        String a2 = a(new Build(), "CPU_ABI");
        if (a2 == null || a2.length() == 0 || a2.equals("Unknown")) {
            a2 = "armeabi";
        }
        String toLowerCase = a2.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("mips")) {
            return false;
        }
        boolean z;
        try {
            if (b != null) {
                b.a(str);
            } else {
                System.loadLibrary(str);
            }
            a(nVar, null, null);
            z = true;
        } catch (Exception e2) {
            e = e2;
            if (toLowerCase.contains("armeabi") || toLowerCase.contains("x86")) {
                a(nVar, com.taobao.weex.common.g.WX_ERR_LOAD_SO.z, com.taobao.weex.common.g.WX_ERR_LOAD_SO.a() + ":" + e.getMessage());
            }
            z = false;
            if (!z) {
                try {
                    if (c(str, 1)) {
                        a = a(str, 1, nVar);
                        if (!a) {
                            return a;
                        }
                        b(str, 1);
                    }
                    if (!toLowerCase.equalsIgnoreCase("mips")) {
                        return false;
                    }
                    try {
                        z = b(str, nVar);
                    } catch (IOException e3) {
                    }
                } catch (Exception e4) {
                    z = false;
                    return z;
                } catch (Error e5) {
                    z = false;
                    return z;
                }
            }
            return z;
        } catch (Error e6) {
            e = e6;
            a(nVar, com.taobao.weex.common.g.WX_ERR_LOAD_SO.z, com.taobao.weex.common.g.WX_ERR_LOAD_SO.a() + ":" + e.getMessage());
            z = false;
            if (z) {
                if (c(str, 1)) {
                    a = a(str, 1, nVar);
                    if (!a) {
                        return a;
                    }
                    b(str, 1);
                }
                if (!toLowerCase.equalsIgnoreCase("mips")) {
                    return false;
                }
                z = b(str, nVar);
            }
            return z;
        }
        if (z) {
            if (c(str, 1)) {
                a = a(str, 1, nVar);
                if (!a) {
                    return a;
                }
                b(str, 1);
            }
            if (!toLowerCase.equalsIgnoreCase("mips")) {
                return false;
            }
            z = b(str, nVar);
        }
        return z;
    }
}
