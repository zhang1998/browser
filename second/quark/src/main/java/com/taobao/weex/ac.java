package com.taobao.weex;

import android.content.Context;
import android.mini.support.annotation.Nullable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;
import com.taobao.weex.a.i;
import com.taobao.weex.a.j;
import com.taobao.weex.a.k;
import com.taobao.weex.b.d.b;
import com.taobao.weex.bridge.g;
import com.taobao.weex.bridge.l;
import com.taobao.weex.bridge.s;
import com.taobao.weex.bridge.v;
import com.taobao.weex.c.aa;
import com.taobao.weex.c.n;
import com.taobao.weex.common.a;
import com.taobao.weex.common.e;
import com.taobao.weex.common.p;
import com.taobao.weex.common.q;
import com.taobao.weex.common.r;
import com.taobao.weex.common.t;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.d;
import com.taobao.weex.ui.m;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.taobao.weex.utils.u;
import com.taobao.weex.utils.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public class ac implements OnLayoutChangeListener, n {
    private static volatile int E = 750;
    private com.taobao.weex.a.n A;
    private boolean B;
    private z C;
    private WXGlobalEventReceiver D = null;
    private List<e> F;
    private boolean G = true;
    public boolean a = false;
    public e b;
    public g c;
    public Context d;
    public final String e;
    public RenderContainer f;
    public ab g;
    public String h = "";
    public boolean i = false;
    public g j;
    public boolean k = false;
    public boolean l;
    public boolean m = true;
    public boolean n = false;
    public int o = 750;
    public q p = q.APPEND_ASYNC;
    public long q;
    public long r;
    public p s;
    public ScrollView t;
    public com.taobao.weex.ui.view.q u;
    public volatile boolean v;
    public h w;
    public int x;
    public List<aa> y = new ArrayList();
    public HashMap<String, List<String>> z = new HashMap();

    @Deprecated
    public static void a(int i) {
        E = i;
    }

    public ac(Context context) {
        ad.a();
        this.e = ad.b();
        this.d = context;
        this.j = new g(this.e);
        this.s = new p();
        this.s.E = i.d;
        this.s.g = i.q;
        this.A = ad.a().d;
    }

    public final void a(String str, String str2, Map<String, Object> map, String str3, q qVar) {
        if (i.c() && "default".equals(str)) {
            WXLogUtils.e("Please set your pageName or your js bundle url !!!!!!!");
        } else if (!this.B && !TextUtils.isEmpty(str2)) {
            Map hashMap;
            o();
            if (map == null) {
                hashMap = new HashMap();
            } else {
                Map<String, Object> map2 = map;
            }
            if (i.y && !TextUtils.isEmpty(i.z) && hashMap.get("dynamicMode") == null) {
                hashMap.put("dynamicMode", "true");
                b(str, i.z, hashMap, str3, qVar);
                return;
            }
            this.s.e = str;
            this.s.h = (double) (str2.length() / 1024);
            this.q = System.currentTimeMillis();
            this.p = qVar;
            ad.a();
            ad a = ad.a();
            a.c.a.put(this.e, new d(this));
            s sVar = a.b;
            Object obj = this.e;
            ac b = ad.a().b(obj);
            if (b == null) {
                WXLogUtils.e("WXBridgeManager", "createInstance failed, SDKInstance is not exist");
            } else if (TextUtils.isEmpty(obj)) {
                b.a("wx_create_instance_error", "createInstance fail! instanceId is null.");
            } else if (TextUtils.isEmpty(str2)) {
                b.a("wx_create_instance_error", "createInstance fail! template is null.");
            } else if (sVar.c == null) {
                b.a("wx_create_instance_error", "createInstance fail! mJSHandler is null.");
            } else {
                v.a(b);
                sVar.a(new l(sVar, b, str2, hashMap, str3), obj);
            }
            this.B = true;
            if (TextUtils.isEmpty(this.h)) {
                this.h = str;
            }
        }
    }

    private void o() {
        if (this.f == null) {
            this.f = new RenderContainer(b());
            this.f.setLayoutParams(new LayoutParams(-1, -1));
            this.f.setBackgroundColor(0);
            this.f.setSDKInstance(this);
            this.f.addOnLayoutChangeListener(this);
        }
    }

    private static String d(String str, String str2) {
        if (!TextUtils.equals(str, "default")) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse == null) {
                return str2;
            }
            Builder builder = new Builder();
            builder.scheme(parse.getScheme());
            builder.authority(parse.getAuthority());
            builder.path(parse.getPath());
            return builder.toString();
        } catch (Exception e) {
            return str2;
        }
    }

    private static String b(Uri uri) {
        if (uri == null || uri.getPath() == null) {
            return "";
        }
        return uri.getPath().replaceFirst("/", "");
    }

    public final Context a() {
        return this.d;
    }

    public final Context b() {
        if (this.d == null) {
            WXLogUtils.e("WXSdkInstance mContext == null");
        }
        return this.d;
    }

    public final int c() {
        return this.f == null ? 0 : this.f.getHeight();
    }

    public static k d() {
        return ad.a().e;
    }

    public static j e() {
        return ad.a().c();
    }

    @Nullable
    public static b f() {
        ad a = ad.a();
        if (a.n != null) {
            return a.n.a();
        }
        return null;
    }

    public final void j() {
        if (this.d != null) {
            a(new r(this));
        }
    }

    public static void k() {
        WXLogUtils.d("Instance onUpdateSuccess");
    }

    public static void a(Runnable runnable) {
        ad.a().a(runnable, 0);
    }

    public final void a(String str, String str2) {
        if (this.b != null && this.d != null) {
            a(new u(this, str, str2));
        }
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public final void a(long j) {
        if (this.G) {
            this.s.n = j - this.q;
            this.G = false;
        }
    }

    public final void b(long j) {
        p pVar = this.s;
        pVar.m += j;
    }

    public final void c(long j) {
        p pVar = this.s;
        pVar.p += j;
    }

    public final void l() {
        if (!this.a) {
            this.a = true;
            if (!(this.c == null || this.d == null)) {
                a(new w(this));
            }
            this.s.l = System.currentTimeMillis() - this.q;
            WXLogUtils.renderPerformanceLog("firstScreenRenderFinished", this.s.l);
            WXLogUtils.renderPerformanceLog("   firstScreenJSFExecuteTime", this.s.n);
            WXLogUtils.renderPerformanceLog("   firstScreenCallNativeTime", this.s.m);
            WXLogUtils.renderPerformanceLog("       firstScreenJsonParseTime", this.s.p);
            WXLogUtils.renderPerformanceLog("   firstScreenBatchTime", this.s.o);
            WXLogUtils.renderPerformanceLog("       firstScreenCssLayoutTime", this.s.s);
            WXLogUtils.renderPerformanceLog("       firstScreenApplyUpdateTime", this.s.r);
            WXLogUtils.renderPerformanceLog("       firstScreenUpdateDomObjTime", this.s.q);
        }
    }

    public final void a(String str, com.taobao.weex.common.g gVar, String str2) {
        if (!TextUtils.isEmpty(str) && gVar != null) {
            if (str2 != null) {
                a(new x(this, gVar, str2));
            } else {
                a(str, gVar);
            }
        }
    }

    public final void a(String str, com.taobao.weex.common.g gVar) {
        if (!TextUtils.isEmpty(str) && gVar != null) {
            a(new y(this, gVar, str));
        }
    }

    private void b(View view) {
        try {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    b(viewGroup.getChildAt(i));
                }
                viewGroup.removeViews(0, ((ViewGroup) view).getChildCount());
                w.a(view, "mChildrenCount", Integer.valueOf(0));
            }
            if (view instanceof a) {
                ((a) view).a();
            }
        } catch (Throwable e) {
            WXLogUtils.e("WXSDKInstance destroyView Exception: ", e);
        }
    }

    public final synchronized void m() {
        ad a = ad.a();
        Object obj = this.e;
        if (!TextUtils.isEmpty(obj)) {
            if (ah.a()) {
                m mVar = a.c;
                if (ah.a()) {
                    d dVar = (d) mVar.a.remove(obj);
                    if (dVar != null) {
                        dVar.b = null;
                        dVar.a.clear();
                    }
                    com.taobao.weex.c.ab abVar = a.a;
                    if (ah.a()) {
                        com.taobao.weex.c.m mVar2 = (com.taobao.weex.c.m) abVar.c.remove(obj);
                        if (mVar2 != null) {
                            Runnable aaVar = new aa(abVar, mVar2);
                            if (!(abVar.b == null || abVar.a == null || !abVar.a.a() || abVar.a.getLooper() == null)) {
                                abVar.b.post(com.taobao.weex.common.w.a(aaVar));
                            }
                        }
                        s sVar = a.b;
                        if (!(sVar.c == null || TextUtils.isEmpty(obj))) {
                            if (sVar.f != null) {
                                sVar.f.add(obj);
                            }
                            sVar.c.removeCallbacksAndMessages(obj);
                            sVar.a(new com.taobao.weex.bridge.m(sVar, obj), obj);
                        }
                        v.f(obj);
                    } else {
                        throw new t("[WXDomManager] removeDomStatement");
                    }
                }
                throw new t("[WXRenderManager] removeRenderStatement can only be called in main thread");
            }
            throw new t("[WXSDKManager] destroyInstance error");
        }
        com.taobao.weex.ui.component.ac.b(this.e);
        if (this.D != null) {
            b().unregisterReceiver(this.D);
            this.D = null;
        }
        if (this.g != null) {
            this.g.destroy();
            b(this.f);
            this.f = null;
            this.g = null;
        }
        if (this.z != null) {
            this.z.clear();
        }
        this.C = null;
        this.A = null;
        this.t = null;
        this.d = null;
        this.b = null;
        this.i = true;
        this.c = null;
    }

    public final void a(View view) {
        if (this.f != null) {
            this.f.removeView(view);
        }
    }

    public final synchronized List<e> n() {
        return this.F;
    }

    public final synchronized void a(e eVar) {
        if (this.F == null) {
            this.F = new CopyOnWriteArrayList();
        }
        this.F.add(eVar);
    }

    public final void a(int i, int i2) {
        if (i >= 0 && i2 >= 0 && !this.i && this.B) {
            float c = WXViewUtils.c((float) i, this.o);
            float c2 = WXViewUtils.c((float) i2, this.o);
            View view = this.f;
            if (view != null) {
                LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    if (!(view.getWidth() == i && view.getHeight() == i2)) {
                        layoutParams.width = i;
                        layoutParams.height = i2;
                        view.setLayoutParams(layoutParams);
                    }
                    com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e();
                    if (this.g != null) {
                        eVar.a("defaultWidth", Float.valueOf(c));
                        eVar.a("defaultHeight", Float.valueOf(c2));
                        Message obtain = Message.obtain();
                        com.taobao.weex.c.ah ahVar = new com.taobao.weex.c.ah();
                        ahVar.a = this.e;
                        if (ahVar.b == null) {
                            ahVar.b = new ArrayList();
                        }
                        ahVar.b.add("_root");
                        ahVar.b.add(eVar);
                        obtain.obj = ahVar;
                        obtain.what = 2;
                        ad.a().a.a(obtain, 0);
                    }
                }
            }
        }
    }

    public final void a(String str, Map<String, Object> map) {
        List<String> list = (List) this.z.get(str);
        if (list != null) {
            for (String str2 : list) {
                ad a = ad.a();
                a.b.a(this.e, str2, (Object) map, true);
            }
        }
    }

    public final void a(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        s.a().a(this.e, str, str2, (Map) map, (Map) map2);
    }

    public final void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, map, null);
    }

    public final void b(String str, String str2) {
        a(str, str2, new HashMap());
    }

    public final void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List list = (List) this.z.get(str);
            if (list == null) {
                list = new ArrayList();
                this.z.put(str, list);
            }
            list.add(str2);
        }
    }

    public final void b(String str, String str2, Map<String, Object> map, String str3, q qVar) {
        o();
        String d = d(str, str2);
        this.h = str2;
        if (ad.a().o != null) {
            this.n = ad.a().o.c();
        }
        if (map == null) {
            Map hashMap = new HashMap();
        } else {
            Map<String, Object> map2 = map;
        }
        if (!hashMap.containsKey("bundleUrl")) {
            hashMap.put("bundleUrl", str2);
        }
        Uri parse = Uri.parse(str2);
        if (parse == null || !TextUtils.equals(parse.getScheme(), "file")) {
            j c = ad.a().c();
            r rVar = new r();
            rVar.b = a(Uri.parse(str2)).toString();
            if (rVar.a == null) {
                rVar.a = new HashMap();
            }
            rVar.a.put("user-agent", com.taobao.weex.d.e.a(this.d, i.a()));
            i abVar = new ab(this, d, hashMap, str3, qVar, System.currentTimeMillis());
            abVar.a = this;
            c.a(rVar, abVar);
            return;
        }
        try {
            a(d, u.a(b(parse), this.d), hashMap, str3, qVar);
        } catch (Exception e) {
            a(com.taobao.weex.common.g.WX_ERR_JSBUNDLE_EMPTY.z, "js render  error:" + e.getMessage() + ",path:" + b(parse));
        }
    }

    public final Uri a(Uri uri) {
        ad a = ad.a();
        if (a.m == null) {
            a.m = new com.taobao.weex.a.a();
        }
        return a.m.a(this, uri);
    }

    public final void g() {
        v.e(this.e);
        if (this.g != null) {
            this.g.onActivityDestroy();
        } else {
            WXLogUtils.w("Warning :Component tree has not build completely, onActivityDestroy can not be call!");
        }
        m();
    }

    public final void h() {
        ab abVar = this.g;
        if (abVar != null) {
            s.a().b(this.e, abVar.getRef(), "viewdisappear");
            for (aa e : this.y) {
                e.e();
            }
        }
    }

    public final void i() {
        ab abVar = this.g;
        if (abVar != null) {
            s.a().b(this.e, abVar.getRef(), "viewappear");
            for (aa d : this.y) {
                d.d();
            }
        }
    }
}
