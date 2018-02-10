package io.vov.vitamio;

import android.text.TextUtils;
import com.UCMobile.Apollo.util.CPU;
import com.UCMobile.Apollo.util.b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: ProGuard */
public class Vitamio {
    public static boolean a = false;
    private static final String[] b = new String[]{"libvvo.7.so", "libvvo.8.so", "libffmpeg.so", "libOMX.9.so", "libOMX.11.so", "libOMX.14.so", "libOMX.18.so"};
    private static final String[] c = new String[]{"libffmpeg.so", "libOMX.9.so", "libOMX.14.so", "libOMX.18.so"};
    private static final String[] d = new String[]{"libffmpeg.so", "libOMX.14.so"};
    private static final String[] e = new String[]{"libvplayer.so"};
    private static final String[] f = new String[]{"libvscanner.so"};
    private static final String[] g = new String[]{"libvao.0.so", "libvvo.0.so", "libvvo.9.so", "libvvo.j.so"};
    private static final int h;
    private static boolean i = false;

    private static native boolean native_initializeLibs(String str, String str2, String str3);

    static {
        int feature = CPU.getFeature();
        if ((feature & 32) > 0) {
            h = 71;
        } else if ((feature & 16) > 0 && (feature & 8) > 0) {
            h = 70;
        } else if ((feature & 4) > 0 && (feature & 2) > 0) {
            h = 61;
        } else if ((feature & 2) > 0) {
            h = 60;
        } else if ((feature & 64) > 0) {
            h = 50;
        } else if ((feature & 128) > 0) {
            h = 40;
        } else {
            h = -1;
        }
    }

    public static boolean a(String str, String str2, String str3) {
        Closeable closeable;
        Throwable th;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str2 + ".lock");
        if (file.exists()) {
            file.delete();
        }
        String b = b(str, str2, "libarm.so");
        new StringBuilder("copyCompressedLib time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
        new StringBuilder("extract lib: ").append(h);
        boolean native_initializeLibs = native_initializeLibs(b, str2, String.valueOf(h));
        new File(b).delete();
        Closeable closeable2 = null;
        try {
            file.createNewFile();
            Closeable fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str3);
                new StringBuilder("loadLibs time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
                b.a(fileWriter);
                return native_initializeLibs;
            } catch (IOException e) {
                closeable = fileWriter;
                new StringBuilder("loadLibs time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
                b.a(closeable);
                return false;
            } catch (Throwable th2) {
                th = th2;
                closeable2 = fileWriter;
                new StringBuilder("loadLibs time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
                b.a(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            closeable = null;
            new StringBuilder("loadLibs time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
            b.a(closeable);
            return false;
        } catch (Throwable th3) {
            th = th3;
            new StringBuilder("loadLibs time: ").append(((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d);
            b.a(closeable2);
            throw th;
        }
    }

    private static String b(String str, String str2, String str3) {
        File file;
        String str4;
        String str5;
        Object e;
        Closeable fileInputStream;
        Closeable bufferedInputStream;
        Closeable fileOutputStream;
        Throwable th;
        byte[] bArr = new byte[1024];
        try {
            file = new File(str);
            try {
                if (!file.exists()) {
                    b.a(null);
                    b.a(null);
                    b.a(null);
                    return null;
                } else if (file.isDirectory()) {
                    b.a(null);
                    b.a(null);
                    b.a(null);
                    return null;
                } else {
                    boolean canRead = file.canRead();
                    new StringBuilder("vitamio canRead: ").append(canRead).append("   canWrite: ").append(file.canWrite());
                    str4 = str2 + str3;
                    try {
                        new StringBuilder("copyCompressedLib from ").append(str).append(" to ").append(str4);
                        File file2 = new File(str2);
                        if (file2.exists() && !file2.isDirectory()) {
                            file2.delete();
                        }
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        file2 = new File(str4);
                        if (file2.exists() && !file2.isFile()) {
                            file2.delete();
                        }
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        str5 = str4;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            new StringBuilder("loadLib").append(e);
                            str5 = str4;
                            fileInputStream = new FileInputStream(file);
                            bufferedInputStream = new BufferedInputStream(fileInputStream);
                            fileOutputStream = new FileOutputStream(str5);
                            while (bufferedInputStream.read(bArr) != -1) {
                                try {
                                    fileOutputStream.write(bArr);
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                            b.a(fileOutputStream);
                            b.a(bufferedInputStream);
                            b.a(fileInputStream);
                            return str5;
                        } catch (Exception e4) {
                            e = e4;
                            fileOutputStream = null;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            try {
                                new StringBuilder("loadLib").append(e);
                                b.a(fileOutputStream);
                                b.a(bufferedInputStream);
                                b.a(fileInputStream);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                b.a(fileOutputStream);
                                b.a(bufferedInputStream);
                                b.a(fileInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            fileOutputStream = null;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            th = th3;
                            b.a(fileOutputStream);
                            b.a(bufferedInputStream);
                            b.a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th32) {
                        fileOutputStream = null;
                        bufferedInputStream = null;
                        fileInputStream = null;
                        th = th32;
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        throw th;
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Exception e5) {
                        e = e5;
                        fileOutputStream = null;
                        bufferedInputStream = null;
                        new StringBuilder("loadLib").append(e);
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        return null;
                    } catch (Throwable th322) {
                        fileOutputStream = null;
                        bufferedInputStream = null;
                        th = th322;
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        throw th;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(str5);
                        while (bufferedInputStream.read(bArr) != -1) {
                            fileOutputStream.write(bArr);
                        }
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        return str5;
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                        new StringBuilder("loadLib").append(e);
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        return null;
                    } catch (Throwable th3222) {
                        fileOutputStream = null;
                        th = th3222;
                        b.a(fileOutputStream);
                        b.a(bufferedInputStream);
                        b.a(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                str4 = null;
                new StringBuilder("loadLib").append(e);
                str5 = str4;
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                fileOutputStream = new FileOutputStream(str5);
                while (bufferedInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                b.a(fileOutputStream);
                b.a(bufferedInputStream);
                b.a(fileInputStream);
                return str5;
            } catch (Throwable th32222) {
                fileOutputStream = null;
                bufferedInputStream = null;
                fileInputStream = null;
                th = th32222;
                b.a(fileOutputStream);
                b.a(bufferedInputStream);
                b.a(fileInputStream);
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            file = null;
            str4 = null;
            new StringBuilder("loadLib").append(e);
            str5 = str4;
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(str5);
            while (bufferedInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            b.a(fileOutputStream);
            b.a(bufferedInputStream);
            b.a(fileInputStream);
            return str5;
        } catch (Throwable th322222) {
            fileOutputStream = null;
            bufferedInputStream = null;
            fileInputStream = null;
            th = th322222;
            b.a(fileOutputStream);
            b.a(bufferedInputStream);
            b.a(fileInputStream);
            throw th;
        }
    }
}
