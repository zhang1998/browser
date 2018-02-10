package com.uc.crashsdk;

import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.a.i;
import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
public final class b {
    private static Runnable A = new c();
    private static long B = 0;
    private static Object C = new Object();
    private static long D = 0;
    private static boolean E = false;
    private static boolean F = false;
    private static boolean G = false;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static volatile boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static boolean r = false;
    private static Object s = new Object();
    private static String t = null;
    private static int u = 0;
    private static RandomAccessFile v = null;
    private static boolean w = false;
    private static Object x = new Object();
    private static String y = null;
    private static volatile Object[] z = null;

    /* compiled from: ProGuard */
    public abstract class a {
        protected String a;

        public abstract boolean a();

        public a(String str) {
            this.a = str;
        }
    }

    public static String a() {
        if (t != null) {
            return t;
        }
        String d = f.d();
        if (h.a(d)) {
            t = "LLUN";
        } else {
            int length;
            String substring;
            if (d.length() > 48) {
                length = d.length() - 48;
                substring = d.substring(0, 48);
            } else {
                length = 0;
                substring = d;
            }
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bytes = substring.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b = bytes[length2];
                if (b == (byte) 46) {
                    stringBuilder.append('0');
                } else if (b == (byte) 58) {
                    stringBuilder.append('1');
                } else if (b >= (byte) 97 && b <= (byte) 122) {
                    stringBuilder.append((char) ((b + 65) - 97));
                } else if (b >= (byte) 65 && b <= (byte) 90) {
                    stringBuilder.append((char) b);
                } else if (b < (byte) 48 || b > (byte) 57) {
                    stringBuilder.append('2');
                } else {
                    stringBuilder.append((char) b);
                }
            }
            if (length > 0) {
                stringBuilder.append(String.valueOf(length));
            }
            t = stringBuilder.toString();
        }
        return t;
    }

    private static String a(String str) {
        return p.N() + a() + "." + str;
    }

    private static String z() {
        if (f == null) {
            f = a("ss");
        }
        return f;
    }

    public static String b() {
        if (g == null) {
            g = a("ct");
        }
        return g;
    }

    public static String c() {
        if (h == null) {
            h = a("st");
        }
        return h;
    }

    public static String d() {
        if (i == null) {
            i = a("rt");
        }
        return i;
    }

    public static String e() {
        if (l == null) {
            l = a("lgsuf");
        }
        return l;
    }

    public static String f() {
        if (j == null) {
            j = p.N() + "up";
        }
        return j;
    }

    public static String g() {
        if (k == null) {
            k = p.N() + "ver";
        }
        return k;
    }

    public static String h() {
        return p.N() + "bvu";
    }

    static String i() {
        return com.uc.crashsdk.a.b.a(new File(z()), 8, false);
    }

    private static void A() {
        if (!o && !n) {
            synchronized (s) {
                if (o) {
                    return;
                }
                b(p.N());
                String i = i();
                File file = new File(b());
                p = "f".equals(i);
                q = "b".equals(i);
                r = file.exists();
                try {
                    if (r) {
                        file.delete();
                    }
                    D();
                } catch (Throwable e) {
                    com.uc.crashsdk.a.a.a(e, false);
                }
                o = true;
            }
        }
    }

    public static boolean j() {
        A();
        return p;
    }

    public static boolean k() {
        A();
        return q;
    }

    private static boolean B() {
        A();
        return r;
    }

    public static boolean l() {
        return m;
    }

    public static void a(boolean z) {
        if (!m) {
            b(p.N());
            if (z) {
                n = true;
                p = false;
                q = false;
                r = false;
                String[] strArr = new String[]{".st", ".wa", ".callback", ".threads", ".ct", ".signal", ".ff", ".bb"};
                String[] strArr2 = new String[]{"up"};
                File[] listFiles = new File(p.N()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        boolean z2;
                        String name = file.getName();
                        for (int i = 0; i < 8; i++) {
                            if (name.endsWith(strArr[i])) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            for (int i2 = 0; i2 <= 0; i2++) {
                                if (name.equals(strArr2[0])) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        if (z2) {
                            c.b("delete file: " + file.getPath());
                            com.uc.crashsdk.a.b.a(file);
                        }
                    }
                }
            } else {
                m = true;
                C();
            }
            D();
        }
    }

    private static void C() {
        if (d) {
            JNIBridge.nativeSyncStatus("exit", null, m ? 1 : 0);
        }
    }

    private static void D() {
        Object[] F = F();
        if (F[0].equals(y) || z != null) {
            e = true;
            E();
            return;
        }
        b(F);
    }

    private static void E() {
        if (i.b(A)) {
            Object[] objArr = z;
            if (objArr == null || !F()[0].equals(objArr[0])) {
                i.a(A);
                i.a(1, A);
                return;
            }
            return;
        }
        i.a(1, A);
    }

    private static void b(Object[] objArr) {
        z = objArr;
        synchronized (x) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < B) {
                c.b("crashsdk", String.format("Update state generation %d, last is: %d", new Object[]{Long.valueOf(longValue), Long.valueOf(B)}));
                return;
            }
            B = longValue;
            String z = z();
            if (d) {
                if (v != null) {
                    com.uc.crashsdk.a.b.a(v);
                    v = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(z, str, w);
                w = false;
                if (!nativeChangeState) {
                    c.c("write state failed: " + str);
                }
            } else {
                if (v == null || w) {
                    if (v != null) {
                        com.uc.crashsdk.a.b.a(v);
                        v = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(z, "rw");
                        v = randomAccessFile;
                        randomAccessFile.seek(0);
                        w = false;
                    } catch (Throwable e) {
                        com.uc.crashsdk.a.a.a(e, false);
                    }
                }
                try {
                    v.write(str.getBytes());
                    v.seek(0);
                } catch (Throwable e2) {
                    com.uc.crashsdk.a.a.a(e2, false);
                }
            }
            y = str;
            z = null;
        }
    }

    private static Object[] F() {
        Object[] objArr;
        synchronized (C) {
            D++;
            if (m) {
                objArr = new Object[]{"e", Long.valueOf(D)};
            } else if (E) {
                objArr = new Object[]{"f", Long.valueOf(D)};
            } else {
                objArr = new Object[]{"b", Long.valueOf(D)};
            }
        }
        return objArr;
    }

    public static boolean m() {
        return b(p.N());
    }

    public static boolean n() {
        return b(p.O());
    }

    private static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        c.a("crashsdk", "Crash log directory was placed by a file!!!");
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static void b(boolean z) {
        if (z && m) {
            p.G();
            m = false;
            C();
        }
        if (!m) {
            A();
            E = z;
            if (d) {
                JNIBridge.nativeSetForeground(z);
            }
            D();
            if (z) {
                a.a(false);
            }
            if (!w) {
                E();
            }
        }
    }

    public static boolean o() {
        return E;
    }

    public static void p() {
        F = true;
    }

    public static boolean q() {
        return F;
    }

    public static void r() {
        G = true;
    }

    public static boolean s() {
        return G;
    }

    public static boolean t() {
        return G || (!h.a(a.a) && a.a.equals(f.d()));
    }

    public static int u() {
        boolean B = B();
        if (k()) {
            if (B) {
                return 3;
            }
            return 6;
        } else if (j()) {
            if (B) {
                return 2;
            }
            return 5;
        } else if (B) {
            return 4;
        } else {
            return 1;
        }
    }

    public static void a(int i) {
        u = i;
        v();
    }

    public static void v() {
        if (d) {
            JNIBridge.nativeSyncStatus("logType", "12", u);
        }
    }

    public static boolean b(int i) {
        return (u & i) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.Object r6, java.lang.String r7, com.uc.crashsdk.b.a r8) {
        /*
        r1 = 0;
        r2 = 0;
        monitor-enter(r6);
        r0 = d;	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x0049;
    L_0x0007:
        r1 = com.uc.crashsdk.JNIBridge.nativeOpenFile(r7);	 Catch:{ all -> 0x0039 }
        if (r1 >= 0) goto L_0x0024;
    L_0x000d:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0039 }
        r1 = "Can not open file: ";
        r0.<init>(r1);	 Catch:{ all -> 0x0039 }
        r0 = r0.append(r7);	 Catch:{ all -> 0x0039 }
        r0 = r0.toString();	 Catch:{ all -> 0x0039 }
        r1 = "crashsdk";
        com.uc.crashsdk.a.c.a(r1, r0);	 Catch:{ all -> 0x0039 }
        monitor-exit(r6);	 Catch:{ all -> 0x0039 }
        r0 = r2;
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = 1;
        r0 = com.uc.crashsdk.JNIBridge.nativeLockFile(r1, r0);	 Catch:{ all -> 0x0044 }
        r2 = r8.a();	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0033;
    L_0x002f:
        r0 = 0;
        com.uc.crashsdk.JNIBridge.nativeLockFile(r1, r0);	 Catch:{ all -> 0x0044 }
    L_0x0033:
        com.uc.crashsdk.JNIBridge.nativeCloseFile(r1);	 Catch:{ all -> 0x0039 }
        r0 = r2;
    L_0x0037:
        monitor-exit(r6);	 Catch:{ all -> 0x0039 }
        goto L_0x0023;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0043;
    L_0x003f:
        r0 = 0;
        com.uc.crashsdk.JNIBridge.nativeLockFile(r1, r0);	 Catch:{ all -> 0x0044 }
    L_0x0043:
        throw r2;	 Catch:{ all -> 0x0044 }
    L_0x0044:
        r0 = move-exception;
        com.uc.crashsdk.JNIBridge.nativeCloseFile(r1);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x0049:
        r0 = new java.io.File;	 Catch:{ all -> 0x0039 }
        r0.<init>(r7);	 Catch:{ all -> 0x0039 }
        r3 = r0.exists();	 Catch:{ all -> 0x0039 }
        if (r3 != 0) goto L_0x0057;
    L_0x0054:
        r0.createNewFile();	 Catch:{ Exception -> 0x0078 }
    L_0x0057:
        r3 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x007e }
        r4 = "rw";
        r3.<init>(r0, r4);	 Catch:{ Exception -> 0x007e }
        r0 = r3.getChannel();	 Catch:{ Exception -> 0x007e }
    L_0x0062:
        if (r0 == 0) goto L_0x0068;
    L_0x0064:
        r1 = r0.lock();	 Catch:{ Exception -> 0x0085, all -> 0x00a1 }
    L_0x0068:
        r2 = r8.a();	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.release();	 Catch:{ Exception -> 0x00bd, all -> 0x00a1 }
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();	 Catch:{ Exception -> 0x00c3 }
    L_0x0076:
        r0 = r2;
        goto L_0x0037;
    L_0x0078:
        r3 = move-exception;
        r4 = 0;
        com.uc.crashsdk.a.a.a(r3, r4);	 Catch:{ all -> 0x0039 }
        goto L_0x0057;
    L_0x007e:
        r0 = move-exception;
        r3 = 0;
        com.uc.crashsdk.a.a.a(r0, r3);	 Catch:{ Exception -> 0x00cb }
        r0 = r1;
        goto L_0x0062;
    L_0x0085:
        r3 = move-exception;
        r4 = 0;
        com.uc.crashsdk.a.a.a(r3, r4);	 Catch:{ Exception -> 0x008b, all -> 0x00a1 }
        goto L_0x0068;
    L_0x008b:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x008f:
        r3 = 0;
        com.uc.crashsdk.a.a.a(r0, r3);	 Catch:{ all -> 0x00c9 }
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();	 Catch:{ Exception -> 0x00b1 }
    L_0x0098:
        r0 = r2;
        goto L_0x0037;
    L_0x009a:
        r3 = move-exception;
        if (r1 == 0) goto L_0x00a0;
    L_0x009d:
        r1.release();	 Catch:{ Exception -> 0x00b7, all -> 0x00a1 }
    L_0x00a0:
        throw r3;	 Catch:{ Exception -> 0x008b, all -> 0x00a1 }
    L_0x00a1:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x00a5:
        if (r1 == 0) goto L_0x00aa;
    L_0x00a7:
        r1.close();	 Catch:{ Exception -> 0x00ab }
    L_0x00aa:
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x00ab:
        r1 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r1, r2);	 Catch:{ all -> 0x0039 }
        goto L_0x00aa;
    L_0x00b1:
        r0 = move-exception;
        r1 = 0;
        com.uc.crashsdk.a.a.a(r0, r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0098;
    L_0x00b7:
        r1 = move-exception;
        r4 = 0;
        com.uc.crashsdk.a.a.a(r1, r4);	 Catch:{ Exception -> 0x008b, all -> 0x00a1 }
        goto L_0x00a0;
    L_0x00bd:
        r1 = move-exception;
        r3 = 0;
        com.uc.crashsdk.a.a.a(r1, r3);	 Catch:{ Exception -> 0x008b, all -> 0x00a1 }
        goto L_0x0071;
    L_0x00c3:
        r0 = move-exception;
        r1 = 0;
        com.uc.crashsdk.a.a.a(r0, r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0076;
    L_0x00c9:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x00cb:
        r0 = move-exception;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.a(java.lang.Object, java.lang.String, com.uc.crashsdk.b$a):boolean");
    }
}
