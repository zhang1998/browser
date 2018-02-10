package com.taobao.weex.bridge;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.common.c;
import com.taobao.weex.common.d;
import com.taobao.weex.common.g;
import com.taobao.weex.common.h;
import com.taobao.weex.common.p;
import com.taobao.weex.common.t;
import com.taobao.weex.common.w;
import com.taobao.weex.i;
import com.taobao.weex.q;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.a.a;
import com.taobao.weex.utils.u;
import com.taobao.weex.utils.v;
import com.uc.apollo.impl.SettingsConst;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: ProGuard */
public class s implements Callback, a {
    static volatile s a;
    private static long g = 120;
    public w b;
    public Handler c;
    public boolean d = false;
    public List<Map<String, Object>> e = new ArrayList(8);
    public List<String> f = new ArrayList();
    private t<String, ArrayList<t<String, Object>>> h = new t();
    private c i;
    private d j;
    private boolean k = false;
    private boolean l;
    private List<Map<String, Object>> m = new ArrayList(8);
    private List<String> n = new ArrayList(8);
    private StringBuilder o = new StringBuilder(50);
    private com.taobao.weex.utils.a.d p;

    private s() {
        a(i.o);
        this.b = new w("WeexJSBridgeThread", this);
        this.c = this.b.a;
    }

    public static s a() {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s();
                }
            }
        }
        return a;
    }

    public final void a(boolean z) {
        if (z && i.c()) {
            i.n = true;
        }
        if (i.n && i.c()) {
            if (i.e() != null) {
                try {
                    Class cls = Class.forName("com.taobao.weex.devtools.debug.DebugServerProxy");
                    if (cls != null) {
                        Constructor constructor = cls.getConstructor(new Class[]{Context.class, s.class});
                        if (constructor != null) {
                            this.j = (d) constructor.newInstance(new Object[]{i.e(), this});
                        }
                    }
                } catch (Throwable th) {
                }
                w.a();
            } else {
                WXLogUtils.e("WXBridgeManager", "WXEnvironment.sApplication is null, skip init Inspector");
                WXLogUtils.w("WXBridgeManager", new Throwable("WXEnvironment.sApplication is null when init Inspector"));
            }
        }
        if (z && this.j != null) {
            this.i = this.j.a();
        } else if (i.g == null || i.g.a() == null) {
            this.i = new WXBridge();
        } else {
            this.i = new i(i.g.a());
        }
    }

    public static Object a(String str, String str2, String str3, b bVar) {
        ac b = ad.a().b(str);
        if (b == null) {
            return null;
        }
        if (!b.n || ad.a().o == null) {
            return v.a(str, str2, str3, bVar);
        }
        y a = ad.a().o.a();
        if (a == null) {
            return null;
        }
        if (a.a) {
            return v.a(str, str2, str3, bVar);
        }
        Object obj = a.b;
        WXLogUtils.e("[WXBridgeManager] module validate fail. >>> " + obj.n_());
        return obj;
    }

    public final void a(Runnable runnable) {
        if ((this.p == null || !this.p.a(runnable)) && this.c != null) {
            this.c.post(w.a(runnable));
        }
    }

    public final void a(com.taobao.weex.utils.a.d dVar) {
        this.p = dVar;
    }

    public final void a(Runnable runnable, Object obj) {
        if (this.c != null) {
            Message obtain = Message.obtain(this.c, w.a(runnable));
            obtain.obj = obj;
            obtain.sendToTarget();
        }
    }

    public final void a(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        r rVar = new r();
        rVar.a = str;
        rVar.b = (long) Float.parseFloat(str2);
        obtain.obj = rVar;
        this.c.sendMessageDelayed(obtain, rVar.b);
    }

    public final Object b(String str, String str2, String str3, b bVar) {
        if (i.c()) {
            this.o.append("[WXBridgeManager] callNativeModule >>>> instanceId:").append(str).append(", module:").append(str2).append(", method:").append(str3).append(", arguments:").append(bVar);
            WXLogUtils.d(this.o.substring(0));
            this.o.setLength(0);
        }
        try {
            if ("dom".equals(str2)) {
                return v.g(str).a(str3, bVar);
            }
            return a(str, str2, str3, bVar);
        } catch (Throwable e) {
            WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
            a(str, g.WX_ERR_INVOKE_NATIVE, "[WXBridgeManager] callNativeModule exception " + e.getCause());
            return null;
        }
    }

    public final Object c(String str, String str2, String str3, b bVar) {
        if (i.c()) {
            this.o.append("[WXBridgeManager] callNativeComponent >>>> instanceId:").append(str).append(", componentRef:").append(str2).append(", method:").append(str3).append(", arguments:").append(bVar);
            WXLogUtils.d(this.o.substring(0));
            this.o.setLength(0);
        }
        try {
            v.g(str).a(str2, str3, bVar);
        } catch (Throwable e) {
            WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
            a(str, g.WX_ERR_INVOKE_NATIVE, "[WXBridgeManager] callNativeModule exception " + e.getCause());
        }
        return null;
    }

    public final int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            if (i.c()) {
                WXLogUtils.e("[WXBridgeManager] callNative: call Native tasks is null");
            }
            a(str, g.WX_ERR_INVOKE_NATIVE, "[WXBridgeManager] callNative: call Native tasks is null");
            return 0;
        }
        if (i.c()) {
            this.o.append("[WXBridgeManager] callNative >>>> instanceId:").append(str).append(", tasks:").append(str2).append(", callback:").append(str3);
            WXLogUtils.d(this.o.substring(0));
            this.o.setLength(0);
        }
        if (this.f != null && this.f.contains(str)) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        b c = com.alibaba.fastjson.a.c(str2);
        if (ad.a().b(str) != null) {
            ad.a().b(str).c(System.currentTimeMillis() - currentTimeMillis);
        }
        int size = c.size();
        if (size > 0) {
            int i = 0;
            while (i < size) {
                try {
                    e eVar = (e) c.get(i);
                    if (!(eVar == null || ad.a().b(str) == null)) {
                        Object obj = eVar.get("module");
                        if (obj != null) {
                            if ("dom".equals(obj)) {
                                com.taobao.weex.c.ac g = v.g(str);
                                if (eVar != null) {
                                    g.a((String) eVar.get("method"), (b) eVar.get("args"));
                                }
                            } else {
                                a(str, (String) obj, (String) eVar.get("method"), (b) eVar.get("args"));
                            }
                        } else if (eVar.get("component") != null) {
                            v.g(str).a((String) eVar.get("ref"), (String) eVar.get("method"), (b) eVar.get("args"));
                        } else {
                            throw new IllegalArgumentException("unknown callNative");
                        }
                    }
                    i++;
                } catch (Throwable e) {
                    WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
                    a(str, g.WX_ERR_INVOKE_NATIVE, "[WXBridgeManager] callNative exception " + e.getCause());
                }
            }
        }
        if ("undefined".equals(str3) || "-1".equals(str3)) {
            return 0;
        }
        b(str, str3);
        return 1;
    }

    public final int a(String str, String str2, String str3, String str4, String str5) {
        if (i.c()) {
            this.o.append("[WXBridgeManager] callNative::callAddElement >>>> instanceId:").append(str).append(", ref:").append(str2).append(", dom:").append(str3).append(", callback:").append(str5);
            WXLogUtils.d(this.o.substring(0));
            this.o.setLength(0);
        }
        if (this.f != null && this.f.contains(str)) {
            return -1;
        }
        if (ad.a().b(str) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            e b = com.alibaba.fastjson.a.b(str3);
            if (ad.a().b(str) != null) {
                ad.a().b(str).c(System.currentTimeMillis() - currentTimeMillis);
            }
            v.g(str).a(new com.taobao.weex.c.a.d(b, str2, Integer.parseInt(str4)), false);
        }
        if ("undefined".equals(str5) || "-1".equals(str5)) {
            return 0;
        }
        b(str, str5);
        return 1;
    }

    private void b(String str, String str2) {
        a("callback", str, str2, "{}");
        a(str);
    }

    public final void a(String str, String str2, Object... objArr) {
        a(new j(this, objArr, str, str2));
    }

    public final void a(String str) {
        Message obtain = Message.obtain(this.c);
        obtain.obj = str;
        obtain.what = 6;
        obtain.sendToTarget();
    }

    public final synchronized void b(String str) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 7;
        obtainMessage.setTarget(this.c);
        obtainMessage.sendToTarget();
    }

    @Deprecated
    public final void b(String str, String str2, String str3) {
        a(str, str2, str3, null, null);
    }

    public final void a(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && this.c != null) {
            int i;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                throw new t("fireEvent must be called by main thread");
            }
            a("fireEvent", str, str2, str3, map, map2);
            a(str);
        }
    }

    @Deprecated
    public final void a(String str, String str2, Object obj, boolean z) {
        b(str, str2, obj, z);
    }

    final void b(String str, String str2, Object obj, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.c != null) {
            a("callback", str, str2, obj, Boolean.valueOf(z));
            a(str);
        }
    }

    public static void a(String str, g gVar, String str2) {
        ac b = ad.a().b(str);
        if (b != null && gVar != null && ad.a().d != null) {
            p pVar = new p();
            pVar.J = b.h;
            pVar.H = gVar.z;
            if (gVar != g.WX_SUCCESS) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = gVar.a();
                }
                pVar.a(str2);
                WXLogUtils.e("wx_monitor", pVar.toString());
            }
            i.e();
        }
    }

    private static void b(String str, g gVar, String str2) {
        if (!TextUtils.isEmpty(str) && gVar != null) {
            if (ad.a().l != null) {
                ad.a().l.a(SettingsConst.FALSE, gVar.z, TextUtils.isEmpty(str2) ? gVar.a() : str2);
            }
            if (ad.a().d != null) {
                p pVar = new p();
                pVar.H = gVar.z;
                if (gVar != g.WX_SUCCESS) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = gVar.a();
                    }
                    pVar.a(str2);
                    WXLogUtils.e("wx_monitor", pVar.toString());
                }
                i.e();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1:
                    r rVar = (r) message.obj;
                    if (rVar != null) {
                        WXJSObject wXJSObject = new WXJSObject(2, rVar.a);
                        a("", "setTimeoutCallback", new WXJSObject[]{wXJSObject});
                        break;
                    }
                    break;
                case 6:
                    a(message);
                    break;
                case 7:
                    String str;
                    String str2 = "";
                    if (message.obj != null) {
                        str = (String) message.obj;
                    } else {
                        str = str2;
                    }
                    ActivityManager activityManager = (ActivityManager) i.e().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    WXLogUtils.w("app AvailMemory ---->>>" + (memoryInfo.availMem / 1048576));
                    if (memoryInfo.availMem / 1048576 > g) {
                        c(str);
                        break;
                    }
                    break;
                case 13:
                    if (message.obj != null) {
                        this.i.takeHeapSnapshot((String) message.obj);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    private void a(String str, String str2, WXJSObject[] wXJSObjectArr) {
        a(str, null, str2, wXJSObjectArr, true);
    }

    public final void a(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, boolean z) {
        if (i.c()) {
            this.o.append("callJS >>>> instanceId:").append(str).append("function:").append(str3);
            if (z) {
                this.o.append(" tasks:").append(v.a(wXJSObjectArr, false));
            }
            WXLogUtils.d(this.o.substring(0));
            this.o.setLength(0);
        }
        this.i.execJS(str, null, str3, wXJSObjectArr);
    }

    private void c(String str) {
        String str2;
        if (q.a() && !this.d) {
            if (TextUtils.isEmpty(str)) {
                if (i.c()) {
                    WXLogUtils.d("weex JS framework from assets");
                }
                str2 = "";
                try {
                    str = u.b("main.js", i.e());
                } catch (Exception e) {
                    str2 = str2 + "JS Framework is empty with Application!" + e;
                }
                if (TextUtils.isEmpty(str)) {
                    try {
                        CharSequence a;
                        if (i.c()) {
                            a = u.a("/sdcard/weex/main.js", i.e());
                        } else {
                            Object obj = str;
                        }
                        if (TextUtils.isEmpty(a)) {
                            str2 = u.b("main.js", i.e());
                        } else {
                            CharSequence charSequence = a;
                        }
                        b("jsFramework", g.WX_ERR_JS_FRAMEWORK, "JS Framework is empty with Application and not empty with Context!");
                        str = str2;
                    } catch (Exception e2) {
                        this.d = false;
                        this.l = false;
                        b("jsFramework", g.WX_ERR_JS_FRAMEWORK, str2 + " and JS Framework is empty with Context!" + e2);
                        if (ad.a().q != null) {
                            ad.a().q.a(false);
                            return;
                        }
                        return;
                    }
                }
            }
            this.l = true;
            try {
                com.taobao.weex.g gVar;
                float e3;
                if (ad.a().l != null) {
                    gVar = ad.a().l;
                }
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = this.i;
                Map a2 = i.a();
                WXParams wXParams = new WXParams();
                wXParams.setPlatform((String) a2.get("os"));
                wXParams.setOsVersion((String) a2.get("sysVersion"));
                wXParams.setAppVersion((String) a2.get("appVersion"));
                wXParams.setWeexVersion((String) a2.get("weexVersion"));
                wXParams.setDeviceModel((String) a2.get("sysModel"));
                wXParams.setShouldInfoCollect((String) a2.get("infoCollect"));
                wXParams.setLogLevel((String) a2.get("logLevel"));
                str2 = (String) a2.get("appName");
                if (!TextUtils.isEmpty(str2)) {
                    wXParams.setAppName(str2);
                }
                float b = (float) WXViewUtils.b(i.e);
                float c = (float) WXViewUtils.c(i.e);
                if (WXViewUtils.a) {
                    e3 = WXViewUtils.e(b);
                    b = WXViewUtils.e(c);
                } else {
                    e3 = b;
                    b = c;
                }
                wXParams.setDeviceWidth(TextUtils.isEmpty((CharSequence) a2.get("deviceWidth")) ? String.valueOf(e3) : (String) a2.get("deviceWidth"));
                if (TextUtils.isEmpty((CharSequence) a2.get("deviceHeight"))) {
                    str2 = String.valueOf(b);
                } else {
                    str2 = (String) a2.get("deviceHeight");
                }
                wXParams.setDeviceHeight(str2);
                wXParams.setOptions(i.b());
                wXParams.setNeedInitV8(ad.a().p);
                if (cVar.initFramework(str, wXParams) == 1) {
                    i.q = System.currentTimeMillis() - currentTimeMillis;
                    WXLogUtils.renderPerformanceLog("initFramework", i.q);
                    i.u = System.currentTimeMillis() - i.r;
                    WXLogUtils.renderPerformanceLog("SDKInitTime", i.u);
                    this.d = true;
                    if (ad.a().l != null) {
                        gVar = ad.a().l;
                    }
                    c();
                    i.j = true;
                    b();
                    if (ad.a().q != null) {
                        ad.a().q.a(true);
                        return;
                    }
                    return;
                }
                WXLogUtils.e("[WXBridgeManager] invokeInitFramework  ExecuteJavaScript fail");
                b("jsFramework", g.WX_ERR_JS_FRAMEWORK, "[WXBridgeManager] invokeInitFramework  ExecuteJavaScript fail");
                if (ad.a().q != null) {
                    ad.a().q.a(false);
                }
            } catch (Throwable th) {
                WXLogUtils.e("[WXBridgeManager] invokeInitFramework ", th);
                b("jsFramework", g.WX_ERR_JS_FRAMEWORK, "[WXBridgeManager] invokeInitFramework exception!#" + th.toString());
                if (ad.a().q != null) {
                    ad.a().q.a(false);
                }
            }
        }
    }

    private void a(Message message) {
        if (!this.h.isEmpty() && this.d) {
            try {
                Object obj = message.obj;
                Stack stack = this.h.a;
                int size = stack.size() - 1;
                Object obj2 = null;
                Object obj3 = obj;
                while (size >= 0) {
                    obj = stack.get(size);
                    obj3 = this.h.remove(obj);
                    if (obj3 != null && !((ArrayList) obj3).isEmpty()) {
                        obj2 = obj3;
                        obj3 = obj;
                        break;
                    }
                    size--;
                    obj2 = obj3;
                    obj3 = obj;
                }
                obj2 = ((ArrayList) obj2).toArray();
                a(String.valueOf(obj3), "callJS", new WXJSObject[]{new WXJSObject(2, obj3), new WXJSObject(3, v.a(obj2, false))});
            } catch (Throwable th) {
                WXLogUtils.e("WXBridgeManager", th);
                a(message.obj.toString(), g.WX_ERR_JS_EXECUTE, "invokeCallJSBatch#" + th.toString());
            }
            if (!this.h.isEmpty()) {
                this.c.sendEmptyMessage(6);
            }
        } else if (!this.d) {
            WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized.");
        }
    }

    private void c() {
        if (this.m.size() > 0) {
            List arrayList = new ArrayList();
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                a((Map) this.m.get(i), arrayList);
            }
            this.m.clear();
            if (arrayList.size() > 0) {
                this.m.addAll(arrayList);
            }
        }
        if (this.e.size() > 0) {
            List arrayList2 = new ArrayList();
            a(this.e, arrayList2);
            this.e.clear();
            if (arrayList2.size() > 0) {
                this.e.addAll(arrayList2);
            }
        }
        if (this.n.size() > 0) {
            List arrayList3 = new ArrayList();
            for (String a : this.n) {
                a(a, arrayList3);
            }
            this.n.clear();
            if (arrayList3.size() > 0) {
                this.n.addAll(arrayList3);
            }
        }
    }

    public final void a(Map<String, Object> map) {
        if (map.size() == 0) {
            return;
        }
        if (d()) {
            a((Map) map, this.m);
        } else {
            a(new n(this, map), null);
        }
    }

    public final void a(List<Map<String, Object>> list) {
        if (this.c != null && list.size() != 0) {
            if (d()) {
                a((List) list, this.e);
            } else {
                a(new o(this, list), null);
            }
        }
    }

    private boolean d() {
        return this.b != null && this.b.getId() == Thread.currentThread().getId();
    }

    private void a(Map<String, Object> map, List<Map<String, Object>> list) {
        if (map == null || !this.d) {
            if (!this.d) {
                WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized.");
            }
            list.add(map);
            return;
        }
        try {
            this.i.execJS("", null, "registerModules", new WXJSObject[]{new WXJSObject(3, v.a(map, false))});
        } catch (Throwable th) {
            WXLogUtils.e("[WXBridgeManager] invokeRegisterModules:", th);
            b("jsFramework", g.WX_ERR_JS_EXECUTE, "invokeRegisterModules");
        }
    }

    private void a(List<Map<String, Object>> list, List<Map<String, Object>> list2) {
        if (list == list2) {
            throw new RuntimeException("Fail receiver should not use source.");
        } else if (!this.d) {
            WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized.");
            for (Map add : list) {
                list2.add(add);
            }
        } else if (list != null) {
            try {
                this.i.execJS("", null, "registerComponents", new WXJSObject[]{new WXJSObject(3, v.a(list, false))});
            } catch (Throwable th) {
                WXLogUtils.e("[WXBridgeManager] invokeRegisterComponents ", th);
                b("jsFramework", g.WX_ERR_JS_EXECUTE, "invokeRegisterComponents");
            }
        }
    }

    public final void b() throws h {
        Map hashMap = new HashMap();
        hashMap.put("dom", com.taobao.weex.c.ac.a);
        a(hashMap);
    }

    private void a(String str, List<String> list) {
        try {
            if (this.d) {
                this.i.execJSService(str);
                return;
            }
            WXLogUtils.e("[WXBridgeManager] invoke execJSService: framework.js uninitialized.");
            list.add(str);
        } catch (Throwable th) {
            WXLogUtils.e("[WXBridgeManager] invokeRegisterService:", th);
            b("jsFramework", g.WX_ERR_JS_EXECUTE, "invokeRegisterService");
        }
    }

    static /* synthetic */ void a(s sVar, ac acVar, String str, Map map, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        sVar.c("");
        acVar.s.w = System.currentTimeMillis() - currentTimeMillis;
        WXLogUtils.renderPerformanceLog("jsframeworkLoadTime", acVar.s.w);
        if (!sVar.k) {
            String str3;
            if (sVar.d) {
                try {
                    Object obj;
                    if (i.c()) {
                        WXLogUtils.d("createInstance >>>> instanceId:" + acVar.e + ", options:" + v.a(map, false) + ", data:" + str2);
                    }
                    WXJSObject wXJSObject = new WXJSObject(2, acVar.e);
                    WXJSObject wXJSObject2 = new WXJSObject(2, str);
                    if (map == null) {
                        obj = "{}";
                    } else {
                        obj = v.a(map, false);
                    }
                    WXJSObject wXJSObject3 = new WXJSObject(3, obj);
                    if (str2 == null) {
                        str2 = "{}";
                    }
                    WXJSObject wXJSObject4 = new WXJSObject(3, str2);
                    WXJSObject[] wXJSObjectArr = new WXJSObject[]{wXJSObject, wXJSObject2, wXJSObject3, wXJSObject4};
                    sVar.a(acVar.e, null, "createInstance", wXJSObjectArr, false);
                } catch (Throwable th) {
                    acVar.a("wx_create_instance_error", "createInstance failed!");
                    str3 = "[WXBridgeManager] invokeCreateInstance " + th.getCause();
                    a(acVar.e, g.WX_ERR_INVOKE_NATIVE, str3);
                    WXLogUtils.e(str3);
                }
            } else if (sVar.l && q.a()) {
                acVar.a("wx_create_instance_error", "createInstance fail! framework.js uninitialized.");
                str3 = "[WXBridgeManager] invokeCreateInstance: framework.js uninitialized.";
                a(acVar.e, g.WX_ERR_INVOKE_NATIVE, str3);
                WXLogUtils.e(str3);
            }
        }
    }

    static /* synthetic */ void b(s sVar, String str) {
        try {
            if (i.c()) {
                WXLogUtils.d("destroyInstance >>>> instanceId:" + str);
            }
            sVar.a(str, "destroyInstance", new WXJSObject[]{new WXJSObject(2, str)});
        } catch (Throwable th) {
            String str2 = "[WXBridgeManager] invokeDestroyInstance " + th.getCause();
            a(str, g.WX_ERR_INVOKE_NATIVE, str2);
            WXLogUtils.e(str2);
        }
    }
}
