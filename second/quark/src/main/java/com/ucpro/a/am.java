package com.ucpro.a;

import android.os.Message;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.a.d.j;
import com.uc.encrypt.f;
import com.uc.webview.browser.BrowserWebView;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.business.e.d.g;
import com.ucpro.services.networkstate.a;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public class am extends e implements j, com.ucpro.business.e.d.e, a {
    private boolean c = true;
    private boolean d;

    static /* synthetic */ void a(am amVar, String str, ValueCallback valueCallback) {
        Closeable open;
        Object b;
        Throwable th;
        Closeable closeable = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                open = amVar.b.getAssets().open(str);
                if (open != null) {
                    try {
                        b = f.b(com.ucweb.common.util.o.a.b((InputStream) open), com.uc.encrypt.a.a);
                    } catch (IOException e) {
                        com.ucweb.common.util.o.a.a(open);
                        if (b != null) {
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        com.ucweb.common.util.o.a.a(open);
                        throw th;
                    }
                }
                com.ucweb.common.util.o.a.a(open);
            } catch (IOException e2) {
                open = closeable;
                com.ucweb.common.util.o.a.a(open);
                if (b != null) {
                    return;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                open = closeable;
                th = th4;
                com.ucweb.common.util.o.a.a(open);
                throw th;
            }
            if (b != null && b.length > 0) {
                valueCallback.onReceiveValue(b);
            }
        }
    }

    protected final void a(b bVar) {
        super.a(bVar);
        m.a(0, new ao(this));
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = -1;
            switch (str.hashCode()) {
                case -1364243148:
                    if (str.equals(SettingKeys.NetworkAdFilterHostList)) {
                        i = 1;
                        break;
                    }
                    break;
                case -128790353:
                    if (str.equals(SettingKeys.NetworkAdblockUpdateAppRule)) {
                        i = 2;
                        break;
                    }
                    break;
                case 1344568959:
                    if (str.equals("hide_domainlist")) {
                        i = 3;
                        break;
                    }
                    break;
                case 1616107473:
                    if (str.equals(SettingKeys.NetworkAdblockUpdateRule)) {
                        i = 0;
                        break;
                    }
                    break;
                case 1843795505:
                    if (str.equals(SettingKeys.UserAdblockJs)) {
                        i = 4;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    m.a(0, new u(this, str));
                    return;
                case 1:
                    m.a(0, new aq(this, str));
                    return;
                case 2:
                    m.a(0, new aw(this, str));
                    return;
                case 3:
                    m.a(0, new av(this, str));
                    return;
                case 4:
                    m.a(0, new ay(this, str));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, Message message) {
    }

    public final void b(int i, Message message) {
        boolean z = true;
        if (i == com.ucpro.base.a.j.g) {
            z = com.ucpro.model.a.a.a.a("setting_night_mode", false);
            k.a;
            p.a(SettingKeys.UIIsNightMode, z);
        } else if (i == com.ucpro.base.a.j.i) {
            z = com.ucpro.feature.e.b.a.a;
            k.a;
            p.a(SettingKeys.RecordIsNoFootmark, z);
        } else if (com.ucpro.base.a.j.k == i) {
            m.d(new as(this, message));
            m.a(0, new ak(this));
        } else if (com.ucpro.base.a.j.l == i) {
            k.a;
            if (g.a().c()) {
                p.f();
            }
        } else if (com.ucpro.base.a.j.m == i) {
            int i2 = message.arg1;
            if (i2 < 0 || 3 < i2) {
                z = false;
            }
            c.b(z);
            if (i2 >= 0 && 3 >= i2) {
                com.ucpro.model.a.a.a.b("setting_select_ua_type", i2);
                k.a;
                p.a(SettingKeys.NetworkUserAgentType, i2);
            }
        } else if (com.ucpro.base.a.j.n == i) {
            k.a;
            p.a(SettingKeys.NetworkUcproxyWifi, com.ucpro.model.a.a.a.a("setting_webcore_network_proxy", true));
            k.a;
            p.a(SettingKeys.NetworkUcproxyMobileNetwork, com.ucpro.model.a.a.a.a("setting_webcore_network_proxy", true));
        } else if (com.ucpro.base.a.j.o == i) {
            r0 = g.a();
            if (r0.c != null) {
                r0.c.onScreenUnLock();
            }
            e();
        } else if (com.ucpro.base.a.j.p == i) {
            r0 = g.a();
            if (r0.c != null) {
                r0.c.onScreenLock();
            }
            d();
        } else if (com.ucpro.base.a.j.b == i) {
            int i3 = message.arg1;
            g a = g.a();
            if (a.c != null) {
                a.c.onTrimMemory(i3);
            }
        } else if (com.ucpro.base.a.j.s == i) {
            z = com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false);
            k.a;
            com.ucpro.a.c.j.a(z);
            new StringBuilder("onSmartNoImageEnableChanged to ").append(String.valueOf(z));
        } else if (com.ucpro.base.a.j.r == i) {
            m.a(0, new ah(this));
        } else if (com.ucpro.base.a.j.t == i) {
            z = com.ucpro.model.a.a.a.a("setting_smart_reader", false);
            k.a;
            p.a(SettingKeys.PageEnableSmartReader, z);
            new StringBuilder("onSmartReaderEnableChanged to ").append(String.valueOf(z));
        } else if (com.ucpro.base.a.j.u == i) {
            z = com.ucpro.model.a.a.a.a("setting_enable_adapt_screen", false);
            k.a;
            com.ucpro.a.c.j.b(z);
            new StringBuilder("onAdaptScreenEnableChanged to ").append(String.valueOf(z));
        }
    }

    public final void q_() {
        super.q_();
        g a = g.a();
        if (a.c != null) {
            a.c.onResume();
        }
        e();
    }

    public final void v_() {
        super.v_();
        g a = g.a();
        if (a.c != null) {
            a.c.onPause();
        }
        d();
    }

    public final void g() {
        super.g();
        g a = g.a();
        com.ucpro.a.d.f.b();
        if (a.c != null) {
            a.c.onDestroy();
        }
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdblockUpdateRule);
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdFilterHostList);
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdblockUpdateAppRule);
        com.ucpro.business.e.a.a.a().a("hide_domainlist");
        com.ucpro.business.e.a.a.a().a(SettingKeys.UserAdblockJs);
        g.a().d("webcore_net_cut");
        g.a().d("enable_hide_domain");
        g.a().d(SettingKeys.NetworkDNSRequestIp);
    }

    private void d() {
        if (this.c) {
            k.a;
            p.a(SettingKeys.OFFNET_ON, true);
        }
    }

    public final void a(String str, com.uc.a.b.e eVar) {
        m.a(0, new ai(this, new t(this, eVar, str), eVar));
    }

    private void i() {
        m.a(2, new ab(this));
    }

    public final void a(com.ucpro.business.e.d.j jVar, String str, String str2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -90310316:
                if (str.equals("webcore_net_cut")) {
                    obj = null;
                    break;
                }
                break;
            case 989609381:
                if (str.equals("enable_hide_domain")) {
                    obj = 1;
                    break;
                }
                break;
            case 1180036027:
                if (str.equals(SettingKeys.NetworkDNSRequestIp)) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (!TextUtils.isEmpty(str2)) {
                    this.c = Boolean.valueOf(str2).booleanValue();
                    return;
                }
                return;
            case 1:
                if (!TextUtils.isEmpty(str2)) {
                    this.d = Boolean.valueOf(str2).booleanValue();
                    i();
                    return;
                }
                return;
            case 2:
                if (!TextUtils.isEmpty(str2)) {
                    k.a;
                    p.a(SettingKeys.NetworkDNSRequestIp, str2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void p_() {
        g.a();
        g.a(com.ucweb.common.util.i.c.b(this.b));
        new StringBuilder("onNetStateChanged, currentNetworkType is: ").append(com.ucweb.common.util.i.c.b(this.b).toString());
    }

    private static void e() {
        k.a;
        p.a(SettingKeys.OFFNET_ON, false);
    }

    static /* synthetic */ void a(am amVar, int[] iArr) {
        if (4 == iArr.length) {
            int i = ((iArr[0] + (iArr[1] << 1)) + (iArr[2] << 2)) + (iArr[3] << 3);
            new StringBuilder("wipeWebView: ").append(Integer.toBinaryString(i));
            if (i > 0) {
                BrowserWebView browserWebView = new BrowserWebView(amVar.b);
                browserWebView.loadUrl("ext:lp:home");
                k.a;
                String valueOf = String.valueOf(i);
                if (valueOf != null && g.a().c()) {
                    p.c(valueOf);
                }
                browserWebView.destroy();
            }
        }
    }

    static /* synthetic */ void c(am amVar) {
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdblockUpdateRule, (j) amVar);
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdFilterHostList, (j) amVar);
        com.ucpro.business.e.a.a.a().a(SettingKeys.NetworkAdblockUpdateAppRule, (j) amVar);
        com.ucpro.business.e.a.a.a().a("hide_domainlist", (j) amVar);
        com.ucpro.business.e.a.a.a().a(SettingKeys.UserAdblockJs, (j) amVar);
    }

    static /* synthetic */ void d(am amVar) {
        g.a().a("webcore_net_cut", (com.ucpro.business.e.d.e) amVar);
        g.a().a("enable_hide_domain", (com.ucpro.business.e.d.e) amVar);
        g.a().a(SettingKeys.NetworkDNSRequestIp, (com.ucpro.business.e.d.e) amVar);
    }

    static /* synthetic */ void e(am amVar) {
        amVar.b(SettingKeys.NetworkAdblockUpdateRule);
        amVar.b(SettingKeys.NetworkAdFilterHostList);
        amVar.b(SettingKeys.NetworkAdblockUpdateAppRule);
        amVar.b("hide_domainlist");
        amVar.b(SettingKeys.UserAdblockJs);
    }

    static /* synthetic */ void f(am amVar) {
        amVar.c = Boolean.valueOf(g.a().a("webcore_net_cut", "true")).booleanValue();
        amVar.d = g.a().c("enable_hide_domain");
        k.a;
        p.a(SettingKeys.NetworkDNSRequestIp, g.a().a(SettingKeys.NetworkDNSRequestIp, "183.233.224.201|119.147.224.167|163.177.128.250"));
    }

    static /* synthetic */ String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("<body>");
        int indexOf2 = str.indexOf("</body>");
        if (indexOf < 0 || indexOf2 <= 0 || indexOf2 <= indexOf) {
            return null;
        }
        return str.substring(indexOf + 6, indexOf2).trim();
    }
}
