package com.uc.crashsdk;

import android.util.SparseArray;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* compiled from: ProGuard */
public final class k {
    private static Object a = new Object();
    private static SparseArray<String> b = new SparseArray();
    private static boolean c = false;
    private static volatile Object d = new Object();

    public static void a(int i) {
        a(i, 1);
    }

    public static void a(int i, int i2) {
        if (i2 == 0) {
            c.c("Add stat for type " + i + " with count 0!");
            return;
        }
        String c = b.c();
        a(c, new l(c, i, i2));
    }

    private static boolean c(int i, int i2) {
        try {
            b.m();
        } catch (Throwable th) {
            a.a(th, false);
        }
        try {
            String b = b(i);
            if (b == null) {
                c.a("crashsdk", "Stat type not exists: " + i);
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                a.a(th2, false);
            }
            StringBuffer a = a(file);
            if (h.a(a)) {
                if (a == null) {
                    a = new StringBuffer();
                }
                a.append("[" + f.d() + "]\n");
            }
            a(a, b, a(a, b) + i2);
            return a(file, a);
        } catch (Throwable th22) {
            a.a(th22, false);
            return false;
        }
    }

    private static StringBuffer a(File file) {
        FileReader fileReader;
        Throwable e;
        if (!file.exists()) {
            return null;
        }
        char[] d = d();
        if (d == null) {
            c.a("crashsdk", "readCrashStatData alloc buffer failed!");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileReader = new FileReader(file);
            try {
                int read = fileReader.read(d);
                if (read > 0) {
                    stringBuffer.append(d, 0, read);
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        e = e2;
                        a.a(e, false);
                        return stringBuffer;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    a.a(e, false);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            e = e4;
                            a.a(e, false);
                            return stringBuffer;
                        }
                    }
                    return stringBuffer;
                } catch (Throwable th) {
                    e = th;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e5) {
                            a.a(e5, false);
                        }
                    }
                    throw e;
                }
            }
        } catch (Throwable e6) {
            Throwable th2 = e6;
            fileReader = null;
            e = th2;
            a.a(e, false);
            if (fileReader != null) {
                fileReader.close();
            }
            return stringBuffer;
        } catch (Throwable e52) {
            fileReader = null;
            e = e52;
            if (fileReader != null) {
                fileReader.close();
            }
            throw e;
        }
        return stringBuffer;
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        indexOf = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf < 0) {
            c.c(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf + 1;
        indexOf = stringBuffer.indexOf("\n", i);
        if (indexOf < 0) {
            indexOf = stringBuffer.length();
        }
        try {
            indexOf = Integer.parseInt(stringBuffer.substring(i, indexOf));
            if (indexOf < 0) {
                indexOf = 0;
            }
        } catch (Throwable e) {
            a.a(e, false);
            indexOf = 0;
        }
        return indexOf;
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf >= 0) {
            int indexOf2 = stringBuffer.indexOf("\n", indexOf);
            if (indexOf2 < 0) {
                indexOf2 = stringBuffer.length();
            }
            stringBuffer.replace(indexOf, indexOf2, str + "=" + String.valueOf(i));
        } else if (i > 0) {
            stringBuffer.append(str).append("=").append(i).append("\n");
        }
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        Throwable e;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            try {
                String stringBuffer2 = stringBuffer.toString();
                fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
                if (fileWriter == null) {
                    return true;
                }
                try {
                    fileWriter.close();
                    return true;
                } catch (Throwable e2) {
                    a.a(e2, false);
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    a.a(e, false);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable e4) {
                            a.a(e4, false);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable e22) {
                            a.a(e22, false);
                        }
                    }
                    throw e4;
                }
            }
        } catch (Exception e5) {
            e4 = e5;
            fileWriter = null;
            a.a(e4, false);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return false;
        } catch (Throwable th2) {
            e4 = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e4;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(java.lang.String r11) {
        /*
        r2 = 1;
        r0 = 0;
        e();
        r4 = b;
        monitor-enter(r4);
        r5 = new java.io.File;	 Catch:{ all -> 0x0094 }
        r5.<init>(r11);	 Catch:{ all -> 0x0094 }
        r6 = a(r5);	 Catch:{ all -> 0x0094 }
        r1 = com.uc.crashsdk.a.h.a(r6);	 Catch:{ all -> 0x0094 }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        r2 = r0;
    L_0x0019:
        return r2;
    L_0x001a:
        r1 = "[";
        r1 = r6.indexOf(r1);	 Catch:{ all -> 0x0094 }
        if (r1 >= 0) goto L_0x002c;
    L_0x0022:
        r1 = "Can not found process name start!";
        r2 = "crashsdk";
        com.uc.crashsdk.a.c.a(r2, r1);	 Catch:{ all -> 0x0094 }
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        r2 = r0;
        goto L_0x0019;
    L_0x002c:
        r1 = r1 + 1;
        r3 = "]";
        r3 = r6.indexOf(r3, r1);	 Catch:{ all -> 0x0094 }
        if (r3 >= 0) goto L_0x0040;
    L_0x0036:
        r1 = "Can not found process name end!";
        r2 = "crashsdk";
        com.uc.crashsdk.a.c.a(r2, r1);	 Catch:{ all -> 0x0094 }
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        r2 = r0;
        goto L_0x0019;
    L_0x0040:
        r7 = r6.substring(r1, r3);	 Catch:{ all -> 0x0094 }
        r3 = r0;
        r1 = r0;
    L_0x0046:
        r0 = b;	 Catch:{ all -> 0x008d }
        r0 = r0.size();	 Catch:{ all -> 0x008d }
        if (r3 >= r0) goto L_0x0097;
    L_0x004e:
        r0 = b;	 Catch:{ all -> 0x008d }
        r8 = r0.keyAt(r3);	 Catch:{ all -> 0x008d }
        r0 = b;	 Catch:{ all -> 0x008d }
        r0 = r0.get(r8);	 Catch:{ all -> 0x008d }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x008d }
        r9 = a(r6, r0);	 Catch:{ all -> 0x008d }
        if (r9 <= 0) goto L_0x00a2;
    L_0x0062:
        r10 = com.uc.crashsdk.d.a(r7, r8, r9);	 Catch:{ all -> 0x008d }
        com.uc.crashsdk.a.k.a(r7, r8, r9);	 Catch:{ all -> 0x008d }
        if (r10 != 0) goto L_0x0071;
    L_0x006b:
        r9 = com.uc.crashsdk.p.I();	 Catch:{ all -> 0x008d }
        if (r9 == 0) goto L_0x00a2;
    L_0x0071:
        r1 = 0;
        a(r6, r0, r1);	 Catch:{ all -> 0x009f }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r1 = "Clear stat item: ";
        r0.<init>(r1);	 Catch:{ all -> 0x009f }
        r0 = r0.append(r8);	 Catch:{ all -> 0x009f }
        r0 = r0.toString();	 Catch:{ all -> 0x009f }
        com.uc.crashsdk.a.c.b(r0);	 Catch:{ all -> 0x009f }
        r0 = r2;
    L_0x0088:
        r1 = r3 + 1;
        r3 = r1;
        r1 = r0;
        goto L_0x0046;
    L_0x008d:
        r0 = move-exception;
    L_0x008e:
        if (r1 == 0) goto L_0x0093;
    L_0x0090:
        a(r5, r6);	 Catch:{ all -> 0x0094 }
    L_0x0093:
        throw r0;	 Catch:{ all -> 0x0094 }
    L_0x0094:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        throw r0;
    L_0x0097:
        if (r1 == 0) goto L_0x009c;
    L_0x0099:
        a(r5, r6);	 Catch:{ all -> 0x0094 }
    L_0x009c:
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        goto L_0x0019;
    L_0x009f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x008e;
    L_0x00a2:
        r0 = r1;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.k.d(java.lang.String):boolean");
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable th) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static boolean a(String str, b.a aVar) {
        return b.a(a, str, aVar);
    }

    public static boolean a(String str) {
        return a(str, new m(str));
    }

    private static String b(int i) {
        String str;
        e();
        synchronized (b) {
            str = (String) b.get(i);
        }
        return str;
    }

    private static void e() {
        synchronized (b) {
            if (b.size() != 0) {
                return;
            }
            b.put(100, "start_pv");
            b.put(1, "all_all");
            b.put(2, "all_fg");
            b.put(3, "java_fg");
            b.put(4, "java_bg");
            b.put(7, "native_fg");
            b.put(8, "native_bg");
            b.put(27, "native_anr_fg");
            b.put(28, "native_anr_bg");
            b.put(9, "native_ok");
            b.put(10, "unexp_anr");
            b.put(29, "unexp_lowmem");
            b.put(30, "unexp_killed");
            b.put(31, "unexp_exit");
            b.put(11, "unexp_fg");
            b.put(12, "unexp_bg");
            b.put(13, "log_up_succ");
            b.put(14, "log_up_fail");
            b.put(15, "log_empty");
            b.put(16, "log_abd_all");
            b.put(22, "log_abd_crash");
            b.put(23, "log_abd_custom");
            b.put(17, "log_large");
            b.put(18, "log_up_all");
            b.put(19, "log_up_bytes");
            b.put(20, "log_up_crash");
            b.put(21, "log_up_custom");
            b.put(24, "log_zipped");
            b.put(25, "log_renamed");
            b.put(26, "log_safe_skip");
        }
    }

    private static File[] f() {
        return new File(p.N()).listFiles(new n());
    }

    public static int a() {
        int i = 0;
        File[] f = f();
        if (f != null) {
            for (File absolutePath : f) {
                if (a(absolutePath.getAbsolutePath())) {
                    i++;
                }
            }
        }
        return i;
    }

    public static boolean b(String str) {
        return a(str, new o(str));
    }

    public static int b() {
        int i = 0;
        File[] f = f();
        if (f != null) {
            for (File absolutePath : f) {
                if (b(absolutePath.getAbsolutePath())) {
                    i++;
                }
            }
        }
        return i;
    }

    public static void c() {
        if (!c) {
            synchronized (d) {
                if (c) {
                    return;
                }
                c = true;
                if (b.j() || b.k()) {
                    a(1, 1);
                    if (b.j()) {
                        a(2, 1);
                    }
                }
                a(100, 1);
            }
        }
    }
}
