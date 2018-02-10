package com.taobao.weex.ui.component;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import com.taobao.weex.aa;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.bridge.v;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.q;
import com.taobao.weex.ui.view.l;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import java.util.Set;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class aj extends ae implements aa, o {
    private static int c = ((int) WXViewUtils.a(270.0f, 750));
    private static int d = ((int) WXViewUtils.a(260.0f, 750));
    private String a;
    private ac b;
    private boolean e;
    private ai f;
    private String h;

    @Deprecated
    public aj(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public aj(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        this.e = true;
        this.f = new ai(this);
        c = (int) WXViewUtils.a(270.0f, acVar.o);
        d = (int) WXViewUtils.a(260.0f, acVar.o);
        if (acVar instanceof ah) {
            Object obj = aeVar.i().get("itemId");
            if (obj != null) {
                obj.toString();
            }
        }
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 114148:
                if (str.equals("src")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                String a = ah.a(obj, null);
                if (a != null) {
                    setSrc(a);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        this.h = str;
        this.a = str;
        if (this.b != null) {
            this.b.m();
            this.b = null;
        }
        if (this.e && !TextUtils.isEmpty(this.a)) {
            b();
        }
    }

    protected final void b() {
        ac acVar = new ac(getInstance().d);
        getInstance().y.add(this);
        acVar.b = this.f;
        Object obj = this.a;
        if (!(this.f == null || this.f.b == null)) {
            obj = this.f.b.a(this.a);
        }
        if (TextUtils.isEmpty(obj)) {
            this.f.b.a(this, "wx_user_intercept_error", "degradeToH5");
        } else {
            LayoutParams layoutParams = ((l) getHostView()).getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            acVar.b("default", obj, null, null, q.APPEND_ASYNC);
        }
        this.b = acVar;
    }

    public void setVisibility(String str) {
        super.setVisibility(str);
        boolean equals = TextUtils.equals(str, "visible");
        if (!TextUtils.isEmpty(this.a) && equals) {
            if (this.b == null) {
                b();
            } else {
                this.b.i();
            }
        }
        if (!(equals || this.b == null)) {
            this.b.h();
        }
        this.e = equals;
    }

    public void destroy() {
        super.destroy();
        if (this.b != null) {
            this.b.m();
            this.b = null;
        }
        this.a = null;
        if (getInstance() != null) {
            getInstance().y.remove(this);
        }
    }

    public final void d() {
        if (this.e && this.b != null) {
            ab abVar = this.b.g;
            if (abVar != null) {
                abVar.fireEvent("viewappear");
            }
        }
    }

    public final void e() {
        if (this.e && this.b != null) {
            ab abVar = this.b.g;
            if (abVar != null) {
                abVar.fireEvent("viewdisappear");
            }
        }
    }

    public void onActivityStart() {
        super.onActivityStart();
        if (this.b != null) {
            ac acVar = this.b;
            v.a(acVar.e);
            if (acVar.g != null) {
                acVar.g.onActivityStart();
            } else {
                WXLogUtils.w("Warning :Component tree has not build completely,onActivityStart can not be call!");
            }
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (this.b != null) {
            ac acVar = this.b;
            v.c(acVar.e);
            if (acVar.g != null) {
                acVar.g.onActivityResume();
            } else {
                WXLogUtils.w("Warning :Component tree has not build completely, onActivityResume can not be call!");
            }
            Intent intent = new Intent("wx_global_action");
            intent.putExtra("eventName", "WXApplicationDidBecomeActiveEvent");
            intent.putExtra("wx_instanceid", acVar.e);
            acVar.d.sendBroadcast(intent);
            acVar.i();
            ac.a(acVar.o);
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
        if (this.b != null) {
            ac acVar = this.b;
            acVar.h();
            if (!acVar.k) {
                Set a = ac.a(acVar.e);
                if (a != null && a.contains("scroller")) {
                    acVar.s.B = 1;
                }
                acVar.s.A = acVar.x;
                acVar.k = true;
            }
            v.b(acVar.e);
            if (acVar.g != null) {
                acVar.g.onActivityPause();
            } else {
                WXLogUtils.w("Warning :Component tree has not build completely,onActivityPause can not be call!");
            }
            Intent intent = new Intent("wx_global_action");
            intent.putExtra("eventName", "WXApplicationWillResignActiveEvent");
            intent.putExtra("wx_instanceid", acVar.e);
            acVar.d.sendBroadcast(intent);
        }
    }

    public void onActivityStop() {
        super.onActivityStop();
        if (this.b != null) {
            ac acVar = this.b;
            v.d(acVar.e);
            if (acVar.g != null) {
                acVar.g.onActivityStop();
            } else {
                WXLogUtils.w("Warning :Component tree has not build completely, onActivityStop can not be call!");
            }
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.b != null) {
            this.b.g();
        }
    }
}
