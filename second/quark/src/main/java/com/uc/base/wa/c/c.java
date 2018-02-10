package com.uc.base.wa.c;

import android.os.Process;
import android.util.Log;
import com.uc.base.wa.b.a;
import com.uc.base.wa.b.q;
import com.uc.base.wa.component.e;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;
import com.uc.base.wa.k;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class c {
    private static Hashtable<b, Long> a = new Hashtable();
    private static long b = 0;

    public static String a(int i) {
        return b.i() + "/" + i;
    }

    public static byte[] a(String str, Map<String, String>... mapArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] toByteArray;
        byte[] bArr = null;
        BufferedWriter bufferedWriter2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, "utf-8"));
                try {
                    for (Map map : mapArr) {
                        bufferedWriter2.newLine();
                        Set<Entry> entrySet = map.entrySet();
                        String str2 = (String) map.remove("lt");
                        if (str2 == null) {
                            Log.e("gzm_wa_WaCache", "", new Throwable());
                            com.uc.base.wa.a.c.a().b("lt is null !!");
                        }
                        bufferedWriter2.write("lt=" + str2);
                        for (Entry entry : entrySet) {
                            bufferedWriter2.append("`").append((CharSequence) entry.getKey()).append("=").append((CharSequence) entry.getValue());
                        }
                        bufferedWriter2.write(str);
                    }
                    try {
                        bufferedWriter2.close();
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable e2) {
                        Log.e("gzm_wa_WaCache", "", e2);
                        return bArr;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    bufferedWriter = bufferedWriter2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th) {
                    e2 = th;
                }
            } catch (IOException e4) {
                e2 = e4;
                bufferedWriter = bArr;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    Log.e("gzm_wa_WaCache", "", e2);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable e22) {
                            Log.e("gzm_wa_WaCache", "", e22);
                            return bArr;
                        }
                    }
                    if (byteArrayOutputStream2 == null) {
                        toByteArray = byteArrayOutputStream2.toByteArray();
                    } else {
                        toByteArray = bArr;
                    }
                    return toByteArray;
                } catch (Throwable th2) {
                    e22 = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Throwable e5) {
                            Log.e("gzm_wa_WaCache", "", e5);
                            throw e22;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.toByteArray();
                    }
                    throw e22;
                }
            } catch (Throwable th3) {
                e22 = th3;
                bufferedWriter2 = bArr;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.toByteArray();
                }
                throw e22;
            }
        } catch (IOException e6) {
            e22 = e6;
            bufferedWriter = bArr;
            byteArrayOutputStream2 = bArr;
            Log.e("gzm_wa_WaCache", "", e22);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (byteArrayOutputStream2 == null) {
                toByteArray = bArr;
            } else {
                toByteArray = byteArrayOutputStream2.toByteArray();
            }
            return toByteArray;
        } catch (Throwable th4) {
            e22 = th4;
            bufferedWriter2 = bArr;
            byteArrayOutputStream = bArr;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.toByteArray();
            }
            throw e22;
        }
    }

    private static String b(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashMap.entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuffer.append((String) entry.getKey()).append(":").append((String) entry.getValue());
        }
        while (it.hasNext()) {
            stringBuffer.append(", ");
            entry = (Entry) it.next();
            stringBuffer.append((String) entry.getKey()).append(":").append((String) entry.getValue());
        }
        return stringBuffer.toString();
    }

    public static Object a() {
        b bVar = new b();
        a.put(bVar, Long.valueOf(0));
        return bVar;
    }

    public static long a(Object obj, String str, ArrayList<HashMap<String, String>> arrayList, q qVar, String str2) {
        Exception exception;
        long j;
        long j2;
        if (obj == null) {
            return 0;
        }
        if (!a.containsKey(obj)) {
            return 0;
        }
        b bVar = (b) obj;
        long j3 = 0;
        if (arrayList == null && qVar == null) {
            return 0;
        }
        String str3;
        Iterator it;
        String str4;
        if (str2 != null) {
            try {
                if (!str2.startsWith("`")) {
                    str2 = "`" + str2;
                }
            } catch (Exception e) {
                exception = e;
                j = j3;
                com.uc.base.wa.a.c.a().b(exception.toString());
                j2 = j;
                a.put((b) obj, Long.valueOf(((Long) a.get(obj)).longValue() + j2));
                return j2;
            }
        }
        if (str2 == null && com.uc.base.wa.config.c.b() != null) {
            com.uc.base.wa.a.c a = com.uc.base.wa.a.c.a();
            if (("headData is null" + qVar) == null) {
                str3 = "";
            } else {
                str3 = ", tmpBodyData = " + qVar.toString();
            }
            a.b(str3);
        }
        if (bVar.b == null) {
            bVar.b = new BufferedWriter(new OutputStreamWriter(bVar.a, "utf-8"));
        }
        BufferedWriter bufferedWriter = bVar.b;
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                HashMap hashMap = (HashMap) it.next();
                bufferedWriter.newLine();
                str4 = (String) hashMap.remove("lt");
                if (str4 == null) {
                    Log.e("gzm_wa_WaCache", "", new Throwable());
                    com.uc.base.wa.a.c a2 = com.uc.base.wa.a.c.a();
                    String str5 = new StringBuilder("lt is null !!").append(qVar).toString() == null ? "" : new StringBuilder(", tmpBodyData = ").append(qVar.toString()).append(hashMap).toString() == null ? "" : ", body = " + b(hashMap);
                    a2.b(str5);
                }
                bufferedWriter.write("lt=" + str4);
                bufferedWriter.write("`ct=" + str);
                str4 = (String) hashMap.remove("tm");
                for (Entry entry : hashMap.entrySet()) {
                    bufferedWriter.write("`" + ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                }
                bufferedWriter.write(str2);
                if (str4 != null) {
                    bufferedWriter.write("`tm=" + str4);
                }
            }
            j = (long) arrayList.size();
        } else {
            j = 0;
        }
        if (qVar != null) {
            try {
                Set<Entry> entrySet;
                HashMap hashMap2 = new HashMap();
                String valueOf = String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
                bufferedWriter.newLine();
                StringBuilder stringBuilder = new StringBuilder();
                if (!qVar.b() || qVar.g() == null) {
                    j2 = j;
                } else {
                    Set<Entry> entrySet2 = qVar.g().entrySet();
                    j2 = ((long) entrySet2.size()) + j;
                    try {
                        for (Entry entry2 : entrySet2) {
                            if (((String) entry2.getKey()).startsWith("`")) {
                                hashMap2.put(entry2.getKey(), entry2.getValue());
                            } else {
                                stringBuilder.append("`" + ((String) entry2.getKey()) + "=" + ((String) entry2.getValue()));
                            }
                        }
                    } catch (Exception e2) {
                        Exception exception2 = e2;
                        j = j2;
                        exception = exception2;
                        com.uc.base.wa.a.c.a().b(exception.toString());
                        j2 = j;
                        a.put((b) obj, Long.valueOf(((Long) a.get(obj)).longValue() + j2));
                        return j2;
                    }
                }
                if (qVar.c() && qVar.h() != null) {
                    entrySet = qVar.h().entrySet();
                    j2 += (long) entrySet.size();
                    for (Entry entry22 : entrySet) {
                        if (((String) entry22.getKey()).startsWith("`")) {
                            hashMap2.put(entry22.getKey(), String.valueOf(((a) entry22.getValue()).a));
                        } else {
                            stringBuilder.append("`" + ((String) entry22.getKey()) + "=" + ((a) entry22.getValue()).a);
                        }
                    }
                }
                if (qVar.d() && qVar.i() != null) {
                    entrySet = qVar.i().entrySet();
                    j3 = ((long) entrySet.size()) + j2;
                    for (Entry entry222 : entrySet) {
                        str3 = (String) entry222.getKey();
                        com.uc.base.wa.b.b bVar2 = (com.uc.base.wa.b.b) entry222.getValue();
                        if (!str3.startsWith("`")) {
                            stringBuilder.append("`" + ((String) entry222.getKey()) + "=" + bVar2.a);
                        } else if (bVar2.c) {
                            int lastIndexOf = str3.lastIndexOf("`");
                            if (lastIndexOf <= 0) {
                                com.uc.base.wa.a.c.a().b("key is: " + str3);
                            }
                            str4 = str3.substring(lastIndexOf);
                            hashMap2.put(str3.substring(0, str3.length() - str4.length()) + "`ev_an=" + bVar2.b + str4, String.valueOf(bVar2.a));
                        } else {
                            hashMap2.put(str3, String.valueOf(bVar2.a));
                        }
                    }
                    j2 = j3;
                }
                if (qVar.e() && qVar.j() != null) {
                    entrySet = qVar.j().entrySet();
                    j2 += (long) entrySet.size();
                    for (Entry entry2222 : entrySet) {
                        if (((String) entry2222.getKey()).startsWith("`")) {
                            hashMap2.put(entry2222.getKey(), String.valueOf(entry2222.getValue()));
                        } else {
                            stringBuilder.append("`" + ((String) entry2222.getKey()) + "=" + entry2222.getValue());
                        }
                    }
                }
                if (qVar.f() && qVar.k() != null) {
                    entrySet = qVar.k().entrySet();
                    j2 += (long) entrySet.size();
                    for (Entry entry22222 : entrySet) {
                        if (((String) entry22222.getKey()).startsWith("`")) {
                            hashMap2.put(entry22222.getKey(), String.valueOf(entry22222.getValue()));
                        } else {
                            stringBuilder.append("`" + ((String) entry22222.getKey()) + "=" + entry22222.getValue());
                        }
                    }
                }
                for (Entry entry222222 : hashMap2.entrySet()) {
                    str3 = (String) entry222222.getKey();
                    if (str3.startsWith("`")) {
                        str3 = str3.substring(1);
                    }
                    bufferedWriter.write(str3 + "=" + ((String) entry222222.getValue()));
                    if (str2 != null) {
                        bufferedWriter.write(str2);
                    }
                    if (com.uc.base.wa.config.c.d() == k.b) {
                        bufferedWriter.write("`tm=" + valueOf);
                    }
                    bufferedWriter.newLine();
                }
                if (stringBuilder.length() > 0) {
                    bufferedWriter.write("lt=ev");
                    bufferedWriter.write("`ct=" + str);
                    bufferedWriter.write(stringBuilder.toString());
                    if (str2 != null) {
                        bufferedWriter.write(str2);
                    }
                    if (com.uc.base.wa.config.c.d() == k.b) {
                        bufferedWriter.write("`tm=" + valueOf);
                    }
                    bufferedWriter.newLine();
                }
                j = j2;
            } catch (Exception e3) {
                exception = e3;
                com.uc.base.wa.a.c.a().b(exception.toString());
                j2 = j;
                a.put((b) obj, Long.valueOf(((Long) a.get(obj)).longValue() + j2));
                return j2;
            }
        }
        j2 = j;
        a.put((b) obj, Long.valueOf(((Long) a.get(obj)).longValue() + j2));
        return j2;
    }

    public static boolean a(Object obj, long j, String str, String str2) {
        if (obj == null) {
            return false;
        }
        if (!a.containsKey(obj)) {
            return false;
        }
        a.remove(obj);
        if (!(obj == null || ((b) obj).b == null)) {
            try {
                ((b) obj).b.close();
            } catch (Throwable e) {
                Log.e("gzm_wa_WaCache", "", e);
            }
        }
        byte[] toByteArray = ((b) obj).a.toByteArray();
        if (toByteArray == null || toByteArray.length == 0) {
            Log.w("gzm_wa_WaCache", "data is empty", new Throwable());
            return false;
        }
        String str3 = b.f(str2).h + b.c(str2) + "_" + a(j, true) + ".wa";
        File file = new File(b.i() + "/" + str3);
        if (!com.uc.base.wa.a.c.a().a(toByteArray, file)) {
            return false;
        }
        boolean renameTo = file.renameTo(new File(str + "/" + str3));
        if (!renameTo) {
            return renameTo;
        }
        e.a.a("1114AA5B512B55CECADDF881C655BFA4", (long) toByteArray.length);
        return renameTo;
    }

    public static String a(int i, String str, long j) {
        return i + b.c(str) + "_" + a(j, false) + ".wa";
    }

    public static void a(HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        long p = m.p();
        try {
            for (int i : b.d) {
                if (i != 1) {
                    String a = a(i);
                    File file = new File(a);
                    if (file.exists() && file.isDirectory()) {
                        a a2 = a(a, file.list(), currentTimeMillis, p);
                        if (a2 != null && a2.a > 0) {
                            if (i == 2) {
                                hashMap.put("sv_delc_l2", a2.a);
                                hashMap.put("sv_total_l2", a2.b);
                                hashMap.put("sv_delcs_l2", a2.c);
                                hashMap.put("sv_totals_l2", a2.d);
                                hashMap.put("sv_del_ot_l2", a2.e);
                                hashMap.put("sv_del_otc_l2", a2.f);
                            } else if (i == 3) {
                                hashMap.put("sv_delc_l3", a2.a);
                                hashMap.put("sv_total_l3", a2.b);
                                hashMap.put("sv_delcs_l3", a2.c);
                                hashMap.put("sv_totals_l3", a2.d);
                                hashMap.put("sv_del_ot_l3", a2.e);
                                hashMap.put("sv_del_otc_l3", a2.f);
                            } else if (i == 4) {
                                hashMap.put("sv_delc_l4", a2.a);
                                hashMap.put("sv_total_l4", a2.b);
                                hashMap.put("sv_delcs_l4", a2.c);
                                hashMap.put("sv_totals_l4", a2.d);
                                hashMap.put("sv_del_ot_l4", a2.e);
                                hashMap.put("sv_del_otc_l4", a2.f);
                            } else if (i == 5) {
                                hashMap.put("sv_delc_l5", a2.a);
                                hashMap.put("sv_total_l5", a2.b);
                                hashMap.put("sv_delcs_l5", a2.c);
                                hashMap.put("sv_totals_l5", a2.d);
                                hashMap.put("sv_del_ot_l5", a2.e);
                                hashMap.put("sv_del_otc_l5", a2.f);
                            } else if (i == 6) {
                                hashMap.put("sv_delc_l6", a2.a);
                                hashMap.put("sv_total_l6", a2.b);
                                hashMap.put("sv_delcs_l6", a2.c);
                                hashMap.put("sv_totals_l6", a2.d);
                                hashMap.put("sv_del_ot_l6", a2.e);
                                hashMap.put("sv_del_otc_l6", a2.f);
                            }
                        }
                    }
                }
            }
            int a3 = a(b.i(), new File(b.i()).list(), currentTimeMillis);
            if (a3 > 0) {
                hashMap.put("sv_delc_0", String.valueOf(a3));
            }
        } catch (Throwable e) {
            Log.e("gzm_wa_WaModel", "", e);
        }
    }

    private static a a(String str, String[] strArr, long j, long j2) {
        long a;
        File file;
        if (str == null || strArr == null) {
            return null;
        }
        a aVar = new a();
        int length = strArr.length;
        int i = 0;
        long j3 = 0;
        while (i < length) {
            String str2 = strArr[i];
            try {
                a = a(str2.substring(str2.indexOf("_") + 1, str2.indexOf(".")));
                file = new File(str + "/" + str2);
                long length2 = file.length();
                aVar.b = aVar.b + 1;
                a.a(aVar, length2);
                a = j - a;
                if (a > j2 || a < 0) {
                    aVar.a = aVar.a + 1;
                    a.b(aVar, length2);
                    if (a > 0) {
                        j3 += a;
                        aVar.f++;
                    }
                    file.delete();
                    i++;
                } else {
                    i++;
                }
            } catch (Exception e) {
                file = new File(str + "/" + str2);
                a = file.length();
                aVar.b = aVar.b + 1;
                a.a(aVar, a);
                aVar.a = aVar.a + 1;
                a.b(aVar, a);
                file.delete();
            }
        }
        if (aVar.f > 0) {
            j3 /= (long) aVar.f;
        } else {
            j3 = 0;
        }
        aVar.e = j3;
        return aVar;
    }

    private static int a(String str, String[] strArr, long j) {
        int i = 0;
        if (str == null || strArr == null) {
            return -1;
        }
        for (String str2 : strArr) {
            File file = new File(str + "/" + str2);
            if (!file.isDirectory()) {
                try {
                    long a = j - a(str2.substring(str2.indexOf("_") + 1, str2.indexOf(".")));
                    if (a > 86400000 || a < 0) {
                        file.delete();
                        i++;
                    }
                } catch (Exception e) {
                    file.delete();
                    i++;
                }
            }
        }
        return i;
    }

    private static long a(String str) throws Exception {
        if (str == null) {
            Log.e("gzm_wa_WaCache", "", new Throwable());
            return 0;
        }
        if (str.length() > 13) {
            str = str.substring(0, 13);
        }
        return Long.valueOf(str).longValue();
    }

    private static String a(long j, boolean z) {
        String str;
        if (j >= 10000000000000L) {
            j %= 10000000000000L;
        }
        if (j <= b) {
            synchronized (c.class) {
                j = b + 1;
                b = j;
            }
        } else {
            b = j;
        }
        String valueOf = String.valueOf(j);
        int length = 13 - valueOf.length();
        if (length > 0) {
            str = "0000000000000".substring(0, length) + valueOf;
        } else {
            if (length != 0) {
                Log.e("gzm_wa_WaCache", "", new Throwable());
                com.uc.base.wa.a.c.a().b("");
            }
            str = valueOf;
        }
        if (z) {
            int myPid = Process.myPid();
            if (myPid >= 1000000) {
                myPid %= 1000000;
            }
            valueOf = String.valueOf(myPid);
            int length2 = 6 - valueOf.length();
            if (length2 > 0) {
                valueOf = "000000".substring(0, length2) + valueOf;
            } else if (length2 != 0) {
                Log.e("gzm_wa_WaCache", "", new Throwable());
                com.uc.base.wa.a.c.a().b("");
            }
        } else {
            valueOf = "000000";
        }
        return str + valueOf;
    }

    public static void a(File file) {
        if (file != null && !file.delete()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
                if (!file.delete()) {
                    Log.e("gzm_wa_WaModel", "", new Throwable());
                }
            }
        }
    }
}
