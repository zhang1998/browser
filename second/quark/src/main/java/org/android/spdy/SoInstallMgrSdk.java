package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext = null;

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i) {
        return initSo(str, i, null);
    }

    public static boolean initSo(String str, int i, ClassLoader classLoader) {
        boolean z = true;
        if (classLoader == null) {
            try {
                System.loadLibrary(str);
            } catch (Exception e) {
                z = false;
            } catch (UnsatisfiedLinkError e2) {
                z = false;
            } catch (Error e3) {
                z = false;
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, new Object[]{str, classLoader});
        }
        if (z) {
            return z;
        }
        try {
            if (isExist(str, i)) {
                boolean _loadUnzipSo = _loadUnzipSo(str, i, classLoader);
                if (_loadUnzipSo) {
                    return _loadUnzipSo;
                }
                removeSoIfExit(str, i);
            }
            String _cpuType = _cpuType();
            if (_cpuType.equalsIgnoreCase(MIPS) || _cpuType.equalsIgnoreCase(X86)) {
                return z;
            }
            try {
                return unZipSelectedFiles(str, i, classLoader);
            } catch (ZipException e4) {
                return z;
            } catch (IOException e5) {
                return z;
            }
        } catch (Exception e6) {
            return false;
        } catch (UnsatisfiedLinkError e7) {
            return false;
        } catch (Error e8) {
            return false;
        }
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private static String _cpuType() {
        String _getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (_getFieldReflectively == null || _getFieldReflectively.length() == 0 || _getFieldReflectively.equals("Unknown")) {
            _getFieldReflectively = ARMEABI;
        }
        return _getFieldReflectively.toLowerCase();
    }

    static String _targetSoFile(String str, int i) {
        Context context = mContext;
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

    static void removeSoIfExit(String str, int i) {
        File file = new File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    static boolean _loadUnzipSo(String str, int i, ClassLoader classLoader) {
        try {
            if (!isExist(str, i)) {
                return true;
            }
            if (classLoader == null) {
                System.load(_targetSoFile(str, i));
                return true;
            }
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = Runtime.class.getDeclaredMethod(UCCore.OPTION_LOAD_KERNEL_TYPE, new Class[]{String.class, ClassLoader.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, new Object[]{_targetSoFile(str, i), classLoader});
            return true;
        } catch (Exception e) {
            return false;
        } catch (UnsatisfiedLinkError e2) {
            return false;
        } catch (Error e3) {
            return false;
        }
    }

    static boolean unZipSelectedFiles(String str, int i, ClassLoader classLoader) throws ZipException, IOException {
        FileOutputStream openFileOutput;
        Throwable th;
        FileChannel fileChannel = null;
        String str2 = "lib/armeabi/lib" + str + ".so";
        try {
            String str3 = "";
            Context context = mContext;
            if (context == null) {
                return false;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                str3 = applicationInfo.sourceDir;
            }
            ZipFile zipFile = new ZipFile(str3);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith(str2)) {
                    InputStream inputStream;
                    try {
                        removeSoIfExit(str, i);
                        inputStream = zipFile.getInputStream(zipEntry);
                        try {
                            openFileOutput = context.openFileOutput(new StringBuilder(ShareConstants.SO_PATH).append(str).append("bk").append(i).append(".so").toString(), 0);
                        } catch (Throwable th2) {
                            th = th2;
                            Object obj = fileChannel;
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
                            zipFile.close();
                            throw th;
                        }
                        try {
                            fileChannel = openFileOutput.getChannel();
                            byte[] bArr = new byte[1024];
                            int i2 = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileChannel.write(ByteBuffer.wrap(bArr, 0, read));
                                i2 += read;
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
                            zipFile.close();
                            if (i2 > 0) {
                                return _loadUnzipSo(str, i, classLoader);
                            }
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            zipFile.close();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        openFileOutput = fileChannel;
                        inputStream = fileChannel;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        zipFile.close();
                        throw th;
                    }
                }
            }
            return false;
        } catch (IOException e7) {
        }
    }
}
