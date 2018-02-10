package com.taobao.weex.bridge;

import android.text.TextUtils;
import com.taobao.weex.ad;
import com.taobao.weex.c.ac;
import com.taobao.weex.common.a;
import com.taobao.weex.common.h;
import com.taobao.weex.common.o;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class v {
    private static Map<String, e> a = new HashMap();
    private static Map<String, o> b = new HashMap();
    private static Map<String, ac> c = new HashMap();
    private static String d = "errCode";
    private static String e = "arg";
    private static String f = "errMsg";
    private static Map<String, Map<String, o>> g = new ConcurrentHashMap();

    static java.lang.Object a(java.lang.String r8, java.lang.String r9, java.lang.String r10, com.alibaba.fastjson.b r11) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r0 = a;
        r0 = r0.get(r9);
        r0 = (com.taobao.weex.bridge.e) r0;
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = "[WXModuleManager] module factory not found.";
        com.taobao.weex.utils.WXLogUtils.e(r0);
    L_0x0010:
        return r1;
    L_0x0011:
        r2 = a(r8, r9, r0);
        if (r2 == 0) goto L_0x0010;
    L_0x0017:
        r3 = com.taobao.weex.ad.a();
        r3 = r3.b(r8);
        r2.b = r3;
        r0 = r0.a(r10);
        if (r3 == 0) goto L_0x0090;
    L_0x0027:
        r4 = com.taobao.weex.ad.a();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4 = r4.d;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        if (r4 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
    L_0x002f:
        r4 = new java.util.HashMap;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4.<init>();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r5 = d;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = "101";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r5 = e;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6.<init>();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r7 = ".";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = r6.append(r10);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r5 = f;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r6 = r3.h;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3.b();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
    L_0x0061:
        r4 = r3.v;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        if (r4 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
    L_0x0065:
        r4 = r0.b();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        if (r4 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
    L_0x006b:
        r4 = new com.taobao.weex.c.a.p;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4.<init>(r2, r11, r0);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = com.taobao.weex.ad.a();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = r0.a;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.e;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r5 = 0;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0.a(r3, r4, r5);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = r1;
    L_0x007d:
        r3 = r2 instanceof com.taobao.weex.c.ac;
        if (r3 != 0) goto L_0x0085;
    L_0x0081:
        r3 = r2 instanceof com.taobao.weex.ui.a.k;
        if (r3 == 0) goto L_0x0087;
    L_0x0085:
        r2.b = r1;
    L_0x0087:
        r1 = r0;
        goto L_0x0010;
    L_0x0089:
        r3 = r3.j;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = r3.a(r2, r0, r11);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        goto L_0x007d;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
    L_0x0090:
        r0 = "callModuleMethod >>> instance is null";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        com.taobao.weex.utils.WXLogUtils.e(r0);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = r2 instanceof com.taobao.weex.c.ac;
        if (r0 != 0) goto L_0x009d;
    L_0x0099:
        r0 = r2 instanceof com.taobao.weex.ui.a.k;
        if (r0 == 0) goto L_0x0010;
    L_0x009d:
        r2.b = r1;
        goto L_0x0010;
    L_0x00a1:
        r0 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4 = "callModuleMethod >>> invoke module:";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.append(r9);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4 = ", method:";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.append(r10);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r4 = " failed. ";	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        com.taobao.weex.utils.WXLogUtils.e(r3, r0);	 Catch:{ Exception -> 0x00a1, all -> 0x00d0 }
        r0 = r2 instanceof com.taobao.weex.c.ac;
        if (r0 != 0) goto L_0x00cc;
    L_0x00c8:
        r0 = r2 instanceof com.taobao.weex.ui.a.k;
        if (r0 == 0) goto L_0x0010;
    L_0x00cc:
        r2.b = r1;
        goto L_0x0010;
    L_0x00d0:
        r0 = move-exception;
        r3 = r2 instanceof com.taobao.weex.c.ac;
        if (r3 != 0) goto L_0x00d9;
    L_0x00d5:
        r3 = r2 instanceof com.taobao.weex.ui.a.k;
        if (r3 == 0) goto L_0x00db;
    L_0x00d9:
        r2.b = r1;
    L_0x00db:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.bridge.v.a(java.lang.String, java.lang.String, java.lang.String, com.alibaba.fastjson.b):java.lang.Object");
    }

    public static boolean a(String str, e eVar, boolean z) throws h {
        if (str == null) {
            return false;
        }
        if (TextUtils.equals(str, "dom")) {
            WXLogUtils.e("Cannot registered module with name 'dom'.");
            return false;
        }
        s.a().a(new u(str, z, eVar));
        return true;
    }

    static boolean a(String str, e eVar) throws h {
        if (eVar == null) {
            return false;
        }
        try {
            a.put(str, eVar);
        } catch (ArrayStoreException e) {
        }
        return true;
    }

    static boolean b(String str, e eVar) {
        Map hashMap = new HashMap();
        hashMap.put(str, eVar.a());
        ad.a().b.a(hashMap);
        return true;
    }

    private static o a(String str, String str2, e eVar) {
        o oVar = (o) b.get(str2);
        if (oVar != null) {
            return oVar;
        }
        Map map;
        Map map2 = (Map) g.get(str);
        if (map2 == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            g.put(str, concurrentHashMap);
            map = concurrentHashMap;
        } else {
            map = map2;
        }
        oVar = (o) map.get(str2);
        if (oVar != null) {
            return oVar;
        }
        try {
            oVar = eVar.b();
            oVar.c = str2;
            map.put(str2, oVar);
            return oVar;
        } catch (Throwable e) {
            WXLogUtils.e(str2 + " module build instace failed.", e);
            return null;
        }
    }

    public static void a(String str) {
        Map map = (Map) g.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (((o) map.get(str2)) == null) {
                    WXLogUtils.w("onActivityStart can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void b(String str) {
        Map map = (Map) g.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                o oVar = (o) map.get(str2);
                if (oVar != null) {
                    oVar.b();
                } else {
                    WXLogUtils.w("onActivityPause can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void c(String str) {
        Map map = (Map) g.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                o oVar = (o) map.get(str2);
                if (oVar != null) {
                    oVar.c();
                } else {
                    WXLogUtils.w("onActivityResume can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void d(String str) {
        Map map = (Map) g.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (((o) map.get(str2)) == null) {
                    WXLogUtils.w("onActivityStop can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void e(String str) {
        Map map = (Map) g.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (((o) map.get(str2)) == null) {
                    WXLogUtils.w("onActivityDestroy can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void f(String str) {
        c.remove(str);
        Map map = (Map) g.remove(str);
        if (map != null && map.size() > 0) {
            for (Entry value : map.entrySet()) {
                o oVar = (o) value.getValue();
                if (oVar instanceof a) {
                    ((a) oVar).a();
                }
            }
        }
    }

    public static void a(com.taobao.weex.ac acVar) {
        if (acVar != null) {
            c.put(acVar.e, new ac(acVar));
        }
    }

    public static ac g(String str) {
        return (ac) c.get(str);
    }

    public static void a() {
        if (a != null && a.size() > 0) {
            for (Entry entry : a.entrySet()) {
                b((String) entry.getKey(), (e) entry.getValue());
            }
        }
    }
}
