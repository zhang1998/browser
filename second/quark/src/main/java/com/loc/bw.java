package com.loc;

import android.content.Context;
import android.os.Build;
import com.UCMobile.Apollo.Global;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: ProGuard */
public final class bw {
    private static boolean a = true;

    public static void a(Context context) {
        try {
            if (f(context)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
                stringBuffer.append(" ");
                stringBuffer.append(UUID.randomUUID().toString());
                stringBuffer.append(" ");
                if (stringBuffer.length() == 53) {
                    Object a = eq.a(stringBuffer.toString());
                    Object b = b(context);
                    Object d = d(context);
                    byte[] bArr = new byte[(b.length + d.length)];
                    System.arraycopy(b, 0, bArr, 0, b.length);
                    System.arraycopy(d, 0, bArr, b.length, d.length);
                    b = a(bArr);
                    byte[] bArr2 = new byte[(a.length + b.length)];
                    System.arraycopy(a, 0, bArr2, 0, a.length);
                    System.arraycopy(b, 0, bArr2, a.length, b.length);
                    bp exVar = new ex(eq.c(bArr2), Global.APOLLO_SERIES);
                    bi.a();
                    bi.b(exVar);
                }
            }
        } catch (Throwable th) {
            es.a(th, "StatisticsManager", "updateStaticsData");
        }
    }

    public static synchronized void a(bu buVar, Context context) {
        synchronized (bw.class) {
            fa.b().submit(new bv(buVar, context));
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            return eg.a(bArr);
        } catch (Throwable th) {
            return null;
        }
    }

    private static byte[] b(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            eq.a(byteArrayOutputStream, "1.2.13.6");
            eq.a(byteArrayOutputStream, "Android");
            eq.a(byteArrayOutputStream, ei.q(context));
            eq.a(byteArrayOutputStream, ei.i(context));
            eq.a(byteArrayOutputStream, ei.f(context));
            eq.a(byteArrayOutputStream, Build.MANUFACTURER);
            eq.a(byteArrayOutputStream, Build.MODEL);
            eq.a(byteArrayOutputStream, Build.DEVICE);
            eq.a(byteArrayOutputStream, ei.r(context));
            eq.a(byteArrayOutputStream, dx.c(context));
            eq.a(byteArrayOutputStream, dx.d(context));
            eq.a(byteArrayOutputStream, dx.f(context));
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
        }
        return bArr;
    }

    private static int c(Context context) {
        int i = 0;
        try {
            File file = new File(ew.a(context, ew.e));
            if (file.exists()) {
                i = file.list().length;
            }
        } catch (Throwable th) {
            es.a(th, "StatisticsManager", "getFileNum");
        }
        return i;
    }

    private static byte[] d(Context context) {
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        String a = ew.a(context, ew.e);
        bc bcVar = null;
        try {
            bcVar = bc.a(new File(a), 102400);
            File file = new File(a);
            if (file.exists()) {
                String[] list = file.list();
                int length = list.length;
                while (i < length) {
                    String str = list[i];
                    if (str.contains(".0")) {
                        byteArrayOutputStream.write(bx.a(bcVar, str.split("\\.")[0]));
                    }
                    i++;
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
            if (bcVar != null) {
                bcVar.close();
            }
        } catch (Throwable e2) {
            es.a(e2, "StatisticsManager", "getContent");
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
            }
            if (bcVar != null) {
                bcVar.close();
            }
        } catch (Throwable th) {
        }
        return bArr;
    }

    private static long e(Context context) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable th;
        long j = 0;
        File file = new File(ew.a(context, "c.log"));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    j = Long.parseLong(eq.a(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    try {
                        es.a(e, "StatisticsManager", "getUpdateTime");
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return j;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    es.a(e, "StatisticsManager", "getUpdateTime");
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return j;
                } catch (Throwable th5) {
                    e = th5;
                    es.a(e, "StatisticsManager", "getUpdateTime");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th6) {
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return j;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream = null;
                es.a(e, "StatisticsManager", "getUpdateTime");
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return j;
            } catch (IOException e5) {
                e = e5;
                fileInputStream = null;
                es.a(e, "StatisticsManager", "getUpdateTime");
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return j;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return j;
    }

    private static boolean f(Context context) {
        FileOutputStream fileOutputStream;
        Throwable th;
        try {
            if (ei.m(context) != 1 || !a || c(context) < 100) {
                return false;
            }
            long e = e(context);
            long time = new Date().getTime();
            if (time - e < 3600000) {
                return false;
            }
            File file = new File(ew.a(context, "c.log"));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(eq.a(String.valueOf(time)));
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (FileNotFoundException e2) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    a = false;
                    return true;
                } catch (IOException e3) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    a = false;
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e5) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th4) {
            }
            a = false;
            return true;
        } catch (Throwable th5) {
            es.a(th5, "StatisticsManager", "isUpdate");
            return false;
        }
    }
}
