package com.uc.base.wa.config;

import android.util.Log;
import com.uc.base.wa.a.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* compiled from: ProGuard */
public final class a {
    private static String a = null;

    public static synchronized String a() {
        String path;
        FileOutputStream fileOutputStream;
        Throwable th;
        synchronized (a.class) {
            if (a == null) {
                path = b.k().getPath();
                File file = new File(path);
                if (!(file.exists() && file.isDirectory())) {
                    file.deleteOnExit();
                    file.mkdirs();
                }
                File file2 = new File(path + "/b80bb7740288fda1f201890375a60c8f");
                if (!file2.exists()) {
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            fileOutputStream.write(UUID.randomUUID().toString().getBytes());
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileOutputStream2 = fileOutputStream;
                            th = th3;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                }
                a = a(file2);
            }
            path = a;
        }
        return path;
    }

    private static String a(File file) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        Throwable th;
        Throwable th2;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                bArr = new byte[((int) randomAccessFile.length())];
                try {
                    randomAccessFile.readFully(bArr);
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        Log.e("gzm_wa", "", th);
                        c.a().b("");
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (bArr != null) {
                            return new String(bArr);
                        }
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bArr = null;
                Log.e("gzm_wa", "", th);
                c.a().b("");
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (bArr != null) {
                    return null;
                }
                return new String(bArr);
            }
        } catch (Throwable th6) {
            randomAccessFile = null;
            th2 = th6;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th2;
        }
        if (bArr != null) {
            return null;
        }
        return new String(bArr);
    }
}
