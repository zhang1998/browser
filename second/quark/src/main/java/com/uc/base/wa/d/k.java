package com.uc.base.wa.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.a.c;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;
import com.uc.base.wa.f.e;
import com.uc.base.wa.g.a;
import com.uc.base.wa.n;
import com.uc.base.wa.p;
import com.uc.base.wa.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class k<T> {
    n<T> a;
    Class b;
    boolean c;
    ByteArrayOutputStream d;
    OutputStream e;
    float f;
    long g;
    long h;
    long i;
    int j;
    boolean k;
    boolean l;
    boolean m;
    String n;
    String o;
    File p;
    private boolean q;
    private String r;
    private long s;

    private k(n<T> nVar) {
        this(c.a().i(), c.a().j(), false, 0, nVar, null);
    }

    private k(boolean z, boolean z2, boolean z3, long j, n<T> nVar, Class<T> cls) {
        this.q = false;
        this.c = false;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.r = null;
        this.k = false;
        this.l = false;
        this.m = false;
        this.s = 0;
        this.n = b.g();
        this.o = b.h();
        p m = b.m();
        if (m != null) {
            this.r = m.a();
        }
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.s = j;
        this.a = nVar;
        this.b = cls;
    }

    public final boolean a(String str, List<String> list, boolean z) {
        if (b.a()) {
            if (this.a != null) {
                this.a.a(-1, 0, 0.0f, null);
            }
            return true;
        } else if (!this.k && !this.l) {
            if (this.a != null) {
                this.a.a(-1, 0, 0.0f, null);
            }
            return false;
        } else if (this.l && b.d()) {
            if (this.a != null) {
                this.a.a(-1, 0, 0.0f, null);
            }
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b = currentTimeMillis - l.a;
            if (z) {
                b += m.o();
            }
            if (b < (this.k ? m.m() : m.n())) {
                if (this.a != null) {
                    this.a.a(-1, 0, 0.0f, null);
                }
                return false;
            }
            l.a = currentTimeMillis - (z ? 20000 : 0);
            if (!b.e()) {
                Class o = c.a().o();
                if (!(o == null || z)) {
                    int i;
                    Context b2 = c.b();
                    Intent intent = new Intent(b2, o);
                    Bundle bundle = new Bundle();
                    bundle.putString("savedDir", c.a().k());
                    bundle.putString("uuid", c.a().l());
                    bundle.putStringArray("urls", c.a().m());
                    bundle.putSerializable("publicHead", c.a().n());
                    intent.putExtras(bundle);
                    try {
                        b2.startService(intent);
                        i = -1;
                    } catch (SecurityException e) {
                        i = 10;
                    }
                    if (this.a != null) {
                        this.a.a(i, 0, 0.0f, null);
                    }
                    return true;
                }
            }
            e.a(3, new b(new j(this, new f(this, str, list), false)));
            return true;
        }
    }

    final boolean a(byte[] bArr) {
        if (bArr != null) {
            try {
                this.e.write(bArr);
                this.e.write(10);
                return true;
            } catch (Throwable e) {
                Log.e("gzm_wa_WaNet", "", e);
            }
        }
        return false;
    }

    public final int a(String str, boolean z) {
        try {
            if (this.e != null) {
                this.e.close();
                this.e = null;
            }
        } catch (Throwable e) {
            this.e = null;
            Log.e("gzm_wa_WaNet", "", e);
        }
        if (this.c) {
            return 8;
        }
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (IOException e2) {
        }
        byte[] toByteArray = this.d == null ? null : this.d.toByteArray();
        if (toByteArray == null) {
            Log.e("gzm_wa_WaNet", "", new Throwable());
            return 6;
        }
        this.d = null;
        if (this.g > 0) {
            this.f = ((float) this.i) / ((float) this.g);
        } else {
            this.f = 0.0f;
        }
        new StringBuilder("upload, afterGzipSize = ").append(this.i).append(",  preGzipSize = ").append(this.g).append(", compRatio = ").append(this.f);
        if (str == null) {
            Throwable th = new Throwable();
            return 5;
        }
        byte[] c = c.a().c(toByteArray);
        if (c == null) {
            Log.e("gzm_wa_WaNet", "", new Throwable());
            return 6;
        }
        String[] a = a(str, c.a().m(), z);
        if (a == null || a.length == 0) {
            Log.e("gzm_wa_WaNet", "requestUrl is empty", new Throwable());
            return 11;
        }
        new StringBuilder("request url count: ").append(a.length);
        int i = 3;
        int i2 = 0;
        while (i > 0) {
            if ((!this.k || c.a().i()) && (!this.l || c.a().j())) {
                i--;
                if (l.b >= a.length) {
                    l.b = 0;
                }
                if (a[l.b] != null && a[l.b].length() != 0) {
                    new StringBuilder("request url: ").append(a[l.b]);
                    com.uc.base.wa.a.b a2 = c.a().a(a[l.b], c);
                    String str2 = this.r != null ? this.r : this.k ? "wifi" : this.l ? "mobile" : "unknow";
                    c.a(str2);
                    if (a2 != null) {
                        a2.d = c.length;
                        this.j = a2.d;
                        if (a2.b == 200) {
                            if (a2.c != null) {
                                str2 = new String(a2.c);
                                Log.e("gzm_wa_WaNet", "response string : " + str2);
                                if (str2.contains("retcode=0")) {
                                    i2 = 0;
                                    break;
                                }
                                Log.e("gzm_wa_WaNet", "retString = " + str2, new Throwable());
                                i2 = 4;
                                l.f();
                            } else {
                                Log.e("gzm_wa_WaNet", "uploadResult.retByteArray is null");
                                l.f();
                                i2 = 3;
                            }
                        } else {
                            Log.e("gzm_wa_WaNet", "statusCode = " + a2.b, new Throwable());
                            l.f();
                            i2 = 3;
                        }
                    } else {
                        Log.e("gzm_wa_WaNet", "response == null", new Throwable());
                        i2 = 7;
                        l.f();
                    }
                } else {
                    Log.e("gzm_wa_WaNet", "requestUrls[id] is empty", new Throwable());
                    l.f();
                    i2 = 1;
                }
            } else {
                return 2;
            }
        }
        q l = b.l();
        if (l == null) {
            return i2;
        }
        l.a(i2, new c(this, toByteArray, c));
        return i2;
    }

    final boolean a(String str, List<String> list) {
        int i;
        long i2 = this.s <= 0 ? m.i() : this.s;
        long j = m.j();
        File[] listFiles = this.p.listFiles();
        if (listFiles != null) {
            for (File a : listFiles) {
                a(a, false);
                if (this.i > i2 || this.g > j) {
                    return true;
                }
            }
        }
        if (str == null) {
            Log.e("gzm_wa_WaNet", "", new Throwable());
        } else {
            listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File a2 : listFiles) {
                    a(a2, true);
                    if (this.i > i2 || this.g > j) {
                        this.q = true;
                        return true;
                    }
                }
            }
        }
        if (this.m) {
            return true;
        }
        if (list == null) {
            Log.e("gzm_wa_WaNet", "", new Throwable());
            return false;
        }
        listFiles = new File((String) list.get(0)).listFiles();
        if (listFiles != null) {
            for (File a22 : listFiles) {
                a(a22, true);
                if (this.i > i2 || this.g > j) {
                    this.q = true;
                    return true;
                }
            }
        }
        i = 0;
        LinkedList linkedList = new LinkedList();
        for (int i3 = 1; i3 < list.size(); i3++) {
            File[] listFiles2 = new File((String) list.get(i3)).listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                LinkedList linkedList2;
                TreeMap treeMap = new TreeMap();
                for (File file : listFiles2) {
                    String name = file.getName();
                    try {
                        String d = b.d(name.substring(1, name.indexOf("_")));
                        if (d != null) {
                            if (this.l) {
                                b g = b.g(d);
                                if (g != null && g.l) {
                                }
                            }
                            linkedList2 = (LinkedList) treeMap.get(d);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList();
                                treeMap.put(d, linkedList2);
                                i++;
                            }
                            linkedList2.add(file);
                        }
                    } catch (Throwable e) {
                        Log.e("gzm_wa_WaNet", "", e);
                    }
                }
                for (LinkedList linkedList22 : treeMap.values()) {
                    Collections.sort(linkedList22, l.c);
                }
                if (treeMap.size() != 0) {
                    linkedList.add(treeMap);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            return a(i, linkedList, i2, j);
        }
        if (this.g - this.h > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r22, java.util.LinkedList<java.util.TreeMap<java.lang.String, java.util.LinkedList<java.io.File>>> r23, long r24, long r26) {
        /*
        r21 = this;
        r5 = 1;
        r3 = 0;
        r0 = r21;
        r6 = r0.s;
        r2 = com.uc.base.wa.config.m.k();
        r8 = (long) r2;
        r6 = r6 * r8;
        r2 = r22 * 2;
        r2 = r2 * 3;
        r8 = (long) r2;
        r6 = r6 / r8;
        r11 = (int) r6;
        r12 = new java.util.LinkedList;
        r12.<init>();
        r8 = r23.size();
        r2 = r8 + 1;
        r4 = "gzm";
        r6 = new java.lang.StringBuilder;
        r7 = "line: mapOfAllLevel size = ";
        r6.<init>(r7);
        r6 = r6.append(r8);
        r7 = r23.toString();
        r6 = r6.append(r7);
        r6 = r6.toString();
        android.util.Log.e(r4, r6);
    L_0x003a:
        r4 = 1;
        if (r2 > r4) goto L_0x003f;
    L_0x003d:
        r2 = r8 + 1;
    L_0x003f:
        r10 = r2 + -1;
        r2 = 0;
        r9 = r2;
    L_0x0043:
        if (r9 >= r10) goto L_0x0153;
    L_0x0045:
        if (r3 != 0) goto L_0x0153;
    L_0x0047:
        r2 = r23.size();
        if (r9 >= r2) goto L_0x0153;
    L_0x004d:
        r0 = r23;
        r2 = r0.get(r9);
        r2 = (java.util.TreeMap) r2;
        r13 = r2.values();
        if (r13 == 0) goto L_0x011b;
    L_0x005b:
        r4 = 0;
        r2 = 0;
        r14 = r13.iterator();
        r6 = r5;
        r5 = r3;
        r3 = r2;
    L_0x0064:
        r2 = r14.hasNext();
        if (r2 == 0) goto L_0x0105;
    L_0x006a:
        r2 = r14.next();
        r2 = (java.util.List) r2;
        if (r5 != 0) goto L_0x0105;
    L_0x0072:
        r15 = r2.iterator();
        r20 = r3;
        r3 = r6;
        r6 = r5;
        r5 = r20;
    L_0x007c:
        r7 = r15.hasNext();
        if (r7 == 0) goto L_0x0151;
    L_0x0082:
        r3 = r15.next();
        r3 = (java.io.File) r3;
        r7 = 1;
        r0 = r21;
        r7 = r0.a(r3, r7);
        r0 = r21;
        r0 = r0.i;
        r16 = r0;
        r16 = (r16 > r24 ? 1 : (r16 == r24 ? 0 : -1));
        if (r16 > 0) goto L_0x00a3;
    L_0x0099:
        r0 = r21;
        r0 = r0.g;
        r16 = r0;
        r16 = (r16 > r26 ? 1 : (r16 == r26 ? 0 : -1));
        if (r16 <= 0) goto L_0x00ac;
    L_0x00a3:
        r6 = 1;
        r16 = 1;
        r0 = r16;
        r1 = r21;
        r1.q = r0;
    L_0x00ac:
        if (r7 != 0) goto L_0x00f0;
    L_0x00ae:
        r16 = r3.length();
        r18 = 0;
        r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r16 > 0) goto L_0x00c9;
    L_0x00b8:
        r3.delete();
        r12.add(r3);
        r3 = "gzm_wa_WaNet";
        r16 = "file length <= 0";
        r0 = r16;
        android.util.Log.e(r3, r0);
        r3 = r7;
        goto L_0x007c;
    L_0x00c9:
        r3 = com.uc.base.wa.a.c.a();
        r5 = "write fail";
        r3.b(r5);
        r6 = 1;
    L_0x00d3:
        r2.removeAll(r12);
        r12.clear();
        r5 = 0;
        r3 = r2.size();
        if (r3 != 0) goto L_0x014f;
    L_0x00e0:
        if (r4 != 0) goto L_0x014d;
    L_0x00e2:
        r3 = new java.util.ArrayList;
        r3.<init>();
    L_0x00e7:
        r3.add(r2);
    L_0x00ea:
        r4 = r3;
        r3 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0064;
    L_0x00f0:
        r12.add(r3);
        r0 = (long) r5;
        r16 = r0;
        r18 = r3.length();
        r16 = r16 + r18;
        r0 = r16;
        r3 = (int) r0;
        if (r3 > r11) goto L_0x00d3;
    L_0x0101:
        r5 = r3;
        r3 = r7;
        goto L_0x007c;
    L_0x0105:
        if (r4 == 0) goto L_0x011d;
    L_0x0107:
        r3 = r4.iterator();
    L_0x010b:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x011d;
    L_0x0111:
        r2 = r3.next();
        r2 = (java.util.List) r2;
        r13.remove(r2);
        goto L_0x010b;
    L_0x011b:
        r6 = r5;
        r5 = r3;
    L_0x011d:
        r2 = r9 + 1;
        r9 = r2;
        r3 = r5;
        r5 = r6;
        goto L_0x0043;
    L_0x0124:
        r4 = r2;
    L_0x0125:
        r2 = r23.getFirst();
        if (r2 == 0) goto L_0x0137;
    L_0x012b:
        r2 = r23.getFirst();
        r2 = (java.util.TreeMap) r2;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x0144;
    L_0x0137:
        r23.removeFirst();	 Catch:{ Exception -> 0x0147 }
    L_0x013a:
        r2 = r4 + -1;
        r4 = r23.isEmpty();
        if (r4 == 0) goto L_0x0124;
    L_0x0142:
        r3 = 1;
        r4 = r2;
    L_0x0144:
        if (r3 == 0) goto L_0x0149;
    L_0x0146:
        return r5;
    L_0x0147:
        r2 = move-exception;
        goto L_0x013a;
    L_0x0149:
        r2 = r10;
        r8 = r4;
        goto L_0x003a;
    L_0x014d:
        r3 = r4;
        goto L_0x00e7;
    L_0x014f:
        r3 = r4;
        goto L_0x00ea;
    L_0x0151:
        r7 = r3;
        goto L_0x00d3;
    L_0x0153:
        r4 = r8;
        goto L_0x0125;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.d.k.a(int, java.util.LinkedList, long, long):boolean");
    }

    private boolean a(File file, boolean z) {
        new StringBuilder("upload file : ").append(file.toString());
        byte[] a = c.a().a(file);
        if ((a == null || a.length == 0) && file.length() != 0) {
            Log.e("gzm_wa_WaNet", "decodedData is null", new Throwable());
            return false;
        }
        boolean a2 = a(a);
        if (!a2 || !z) {
            return a2;
        }
        if (this.k) {
            file.renameTo(new File(this.n + "/" + file.getName()));
            return a2;
        } else if (!this.l) {
            return a2;
        } else {
            file.renameTo(new File(this.o + "/" + file.getName()));
            return a2;
        }
    }

    static byte[] a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lt=uc`sid_flds=seid,sename");
        try {
            HashMap n = c.a().n();
            if (n != null) {
                for (Entry entry : n.entrySet()) {
                    String str = (String) entry.getValue();
                    if (str != null) {
                        stringBuilder.append("`").append((String) entry.getKey()).append("=").append(a.a(str));
                    }
                }
            }
        } catch (Exception e) {
            c.a().b(e.toString());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString().getBytes();
    }

    private String[] a(String str, String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            String str2;
            String str3 = "gzm_wa_WaNet";
            StringBuilder stringBuilder = new StringBuilder("[getRequestUrl] requestUrls = ");
            if (strArr == null) {
                str2 = "null";
            } else {
                str2 = SettingsConst.FALSE;
            }
            Log.e(str3, stringBuilder.append(str2).toString());
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder stringBuilder2 = new StringBuilder(strArr[i]);
            String b = b.b();
            String str4 = "AppChk#2014";
            str3 = c.a().l();
            if (z && b(str3)) {
                str3 = SettingsConst.FALSE;
            }
            if (b(b) || b(str4) || b(str3) || str == null) {
                Log.e("gzm_wa_WaNet", "[getRequestUrl] get request url fail, params invalid, appName = " + b + ", chkStr = " + str4 + ", dn = " + str3 + ", vno = " + str);
                return null;
            }
            stringBuilder2.append("&chk=");
            str4 = c(b + str3 + str + str4);
            stringBuilder2.append(str4.substring(str4.length() - 8, str4.length()));
            if (str != null) {
                stringBuilder2.append("&vno=");
                stringBuilder2.append(str);
            }
            str4 = c.a().h();
            if (str4 != null) {
                stringBuilder2.append("&enc=");
                stringBuilder2.append(str4);
            }
            stringBuilder2.append("&zip=");
            stringBuilder2.append("gzip");
            stringBuilder2.append("&uuid=");
            stringBuilder2.append(a(str3));
            stringBuilder2.append("&app=");
            stringBuilder2.append(b);
            strArr2[i] = stringBuilder2.toString();
        }
        return strArr2;
    }

    private static String a(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return str;
    }

    private static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    private static String c(String str) {
        String str2 = null;
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder stringBuilder = new StringBuilder(length * 2);
            length += 0;
            for (int i = 0; i < length; i++) {
                byte b = digest[i];
                char c = l.d[(b & 240) >> 4];
                char c2 = l.d[b & 15];
                stringBuilder.append(c);
                stringBuilder.append(c2);
            }
            str2 = stringBuilder.toString();
        } catch (Throwable e) {
            Log.e("gzm_WaCache", "", e);
            c.a().b(e.toString());
        } catch (Throwable e2) {
            Log.e("gzm_WaCache", "", e2);
            c.a().b(e2.toString());
        }
        return str2;
    }
}
