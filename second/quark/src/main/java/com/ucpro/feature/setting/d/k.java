package com.ucpro.feature.setting.d;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.d.h;
import com.ucpro.feature.k.a.b.b;
import com.ucpro.feature.k.a.b.c;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.view.d.a;
import com.ucpro.feature.setting.view.d.aa;
import com.ucpro.feature.setting.view.d.ac;
import com.ucpro.feature.setting.view.d.ad;
import com.ucpro.feature.setting.view.d.i;
import com.ucpro.feature.setting.view.d.n;
import com.ucpro.feature.setting.view.d.p;
import com.ucpro.feature.setting.view.d.q;
import com.ucpro.feature.setting.view.d.r;
import com.ucpro.feature.setting.view.d.t;
import com.ucpro.feature.setting.view.d.w;
import com.ucpro.feature.setting.view.d.y;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.webwindow.j.d;
import com.ucpro.feature.webwindow.j.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class k extends e implements g, i, q {
    private static final String v = "true";
    private static final String w = "false";
    private ad c;
    private aa d;
    private y e;
    private j f;
    private c g;
    private b h;
    private a i;
    private com.ucpro.feature.setting.view.d.k j;
    private d k;
    private r l;
    private t m;
    private w n;
    private y o;
    private n p;
    private m q;
    private boolean r;
    private b s;
    private com.ucpro.feature.webwindow.j.g t;
    private com.ucpro.feature.webwindow.j.r u;

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
        this.s = new b(com.ucpro.model.a.a.a.a.getLong("setting_wipe_cache_user_selected", 0));
    }

    public final void a(int i, Message message) {
        com.ucpro.base.c.b.g gVar = null;
        com.ucpro.base.c.b.g a;
        if (com.ucpro.base.a.e.aW == i) {
            int i2;
            com.ucpro.feature.setting.e.b.a;
            a = s_().a();
            if (!(a instanceof bb)) {
                i2 = -1;
            } else if (((bb) a).G()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            new StringBuilder("statSettingOpen: \nfrom: ").append(String.valueOf(i2));
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(i2));
            m.a("setting", "main_setting_show", hashMap);
            if (this.c == null || this.c.getParent() == null) {
                this.c = new ad(this.b, this);
                this.c.a();
                a = this.c;
            } else {
                a = null;
            }
            a(a);
        } else if (com.ucpro.base.a.e.aX == i) {
            if (this.d == null || this.d.getParent() == null) {
                this.d = new aa(this.b, this);
                gVar = this.d;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.aY == i) {
            if (this.e == null || this.e.getParent() == null) {
                this.e = new y(this.b, this);
                this.f = new j(this.e);
                gVar = this.e;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.aZ == i) {
            if (this.g == null || this.g.getParent() == null) {
                this.g = new c(this.b, this);
                this.h = new b(this.g, this.b, s_());
                gVar = this.g;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.ba == i) {
            if (this.i == null || this.i.getParent() == null) {
                this.i = new a(this.b, this);
                this.i.setWipeCacheWindowPresenter(this);
                this.i.a();
                gVar = this.i;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bb == i) {
            if (this.j == null || this.j.getParent() == null) {
                this.k = new d();
                this.j = new com.ucpro.feature.setting.view.d.k(this.b, this);
                d dVar = this.k;
                r1 = this.j;
                com.ucweb.common.util.c.a(r1);
                dVar.a = r1;
                this.j.a();
                gVar = this.j;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bc == i) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bc, null);
        } else if (com.ucpro.base.a.e.be == i) {
            this.c.a();
        } else if (com.ucpro.base.a.e.bf == i) {
            if (this.l == null || this.l.getParent() == null) {
                this.l = new r(this.b, this);
                gVar = this.l;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bg == i) {
            if (this.m == null || this.m.getParent() == null) {
                this.m = new t(this.b, this);
                gVar = this.m;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bh == i) {
            if (this.n == null || this.n.getParent() == null) {
                this.o = new y();
                this.n = new w(this.b, this);
                y yVar = this.o;
                r1 = this.n;
                com.ucweb.common.util.c.a(r1);
                yVar.a = r1;
                this.n.a();
                gVar = this.n;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bi == i) {
            if (this.p == null || this.p.getParent() == null) {
                this.q = new m();
                this.p = new n(this.b, this);
                m mVar = this.q;
                r1 = this.p;
                com.ucweb.common.util.c.a(r1);
                mVar.a = r1;
                mVar.a.setPresenter(mVar);
                mVar.a.setFontSeekChangedListener(mVar);
                mVar.a.a(mVar.b, mVar.c);
                this.p.a();
                gVar = this.p;
            }
            a(gVar);
        } else if (com.ucpro.base.a.e.bj == i) {
            boolean booleanValue;
            com.ucweb.common.util.c.b(message.obj instanceof Object[]);
            Object[] objArr = (Object[]) message.obj;
            if (objArr.length == 3) {
                booleanValue = ((Boolean) objArr[2]).booleanValue();
            } else {
                booleanValue = false;
            }
            a = new p(this.b, this, (String) objArr[0], (String) objArr[1], booleanValue);
            a.setEnableSwipeGesture(false);
            a(a);
        } else if (com.ucpro.base.a.e.bk == i) {
            a = new com.ucpro.feature.k.a.a.b(this.b);
            a.setWindowCallBacks(this);
            com.ucpro.feature.k.a.a.a aVar = new com.ucpro.feature.k.a.a.a(a);
            a(a);
        }
    }

    public final void b(int i, Message message) {
        if (j.f == i) {
            if (this.c != null) {
                this.c.l();
            }
            if (this.d != null) {
                this.d.l();
            }
            if (this.j != null) {
                this.j.l();
            }
            if (this.i != null) {
                this.i.l();
            }
            if (this.l != null) {
                this.l.l();
            }
            if (this.m != null) {
                this.m.l();
            }
            if (this.n != null) {
                this.n.l();
            }
            if (this.p != null) {
                this.p.l();
            }
        } else if (j.r == i) {
            h.a;
            boolean a = com.ucpro.model.a.a.a.a("setting_status_bar_origin_enable_status", false);
            boolean z = com.ucpro.model.a.a.a.a("setting_status_bar_type", 1) > 0;
            HashMap hashMap = new HashMap();
            hashMap.put("originStatus", String.valueOf(a));
            hashMap.put("nowtStatus", String.valueOf(z));
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(com.ucpro.feature.setting.a.h.w, hashMap);
            z = com.ucpro.model.a.a.a.a("setting_webcore_network_proxy", true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("networkProxy", String.valueOf(z));
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(com.ucpro.feature.setting.a.h.E, hashMap2);
            z = com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false);
            hashMap2 = new HashMap();
            hashMap2.put("no_image", String.valueOf(z));
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(com.ucpro.feature.setting.a.h.G, hashMap2);
            z = com.ucpro.model.a.a.a.a("setting_smart_reader", false);
            hashMap2 = new HashMap();
            hashMap2.put("smart_reader", String.valueOf(z));
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(com.ucpro.feature.setting.a.h.I, hashMap2);
            com.ucpro.feature.setting.c.a.e.e();
        }
    }

    private void a(com.ucpro.base.c.b.g gVar) {
        if (gVar != null && gVar.getParent() == null) {
            this.a.b().a(gVar, true);
        }
    }

    public final void q_() {
        super.q_();
        if (this.c != null && this.c.getVisibility() == 0) {
            this.c.a(a(com.ucpro.feature.setting.a.h.b));
        }
    }

    public final String a(int i) {
        if (com.ucpro.feature.setting.a.h.b == i) {
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.by, new s(this));
            return String.valueOf(this.r);
        } else if (com.ucpro.feature.setting.a.h.h == i) {
            return String.valueOf(this.s.a(i));
        } else {
            if (com.ucpro.feature.setting.a.h.i == i) {
                return String.valueOf(this.s.a(i));
            }
            if (com.ucpro.feature.setting.a.h.j == i) {
                return String.valueOf(this.s.a(i));
            }
            if (com.ucpro.feature.setting.a.h.k == i) {
                return String.valueOf(this.s.a(i));
            }
            if (com.ucpro.feature.setting.a.h.l == i) {
                return String.valueOf(this.s.a(i));
            }
            if (com.ucpro.feature.setting.a.h.w == i) {
                return com.ucpro.model.a.a.a.a("setting_status_bar_type", 1) > 0 ? "true" : "false";
            } else {
                int a;
                if (com.ucpro.feature.setting.a.h.x == i) {
                    a = com.ucpro.model.a.a.a.a("setting_crash_recovery_type", 0);
                    if (a == 0) {
                        return com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_disable_verb);
                    }
                    if (a == 1) {
                        return com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_enable_always_asking_verb);
                    }
                    if (a == 2) {
                        return com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_enable_auto_recovery_verb);
                    }
                    return null;
                } else if (com.ucpro.feature.setting.a.h.z == i) {
                    if (this.k != null) {
                        return com.ucpro.feature.z.g.b.n.b.d().b;
                    }
                    return null;
                } else if (com.ucpro.feature.setting.a.h.A == i) {
                    if (this.k != null) {
                        return d.c();
                    }
                    return null;
                } else if (com.ucpro.feature.setting.a.h.E == i) {
                    return String.valueOf(com.ucpro.model.a.a.a.a("setting_webcore_network_proxy", true));
                } else {
                    if (com.ucpro.feature.setting.a.h.Q == i) {
                        a = com.ucpro.model.a.a.a.a("setting_toolbar_style", 0);
                        if (a == 0) {
                            return com.ucpro.ui.c.a.d((int) R.string.common_toolbar_style_dialog_3btn_text_short);
                        }
                        if (a == 1) {
                            return com.ucpro.ui.c.a.d((int) R.string.common_toolbar_style_dialog_5btn_text_short);
                        }
                        return null;
                    } else if (com.ucpro.feature.setting.a.h.G == i) {
                        return String.valueOf(com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false));
                    } else {
                        if (com.ucpro.feature.setting.a.h.H == i) {
                            com.ucpro.a.c.k.a;
                            return String.valueOf(com.ucpro.a.c.p.a(SettingKeys.PageUcCustomFontSize));
                        } else if (com.ucpro.feature.setting.a.h.I == i) {
                            return String.valueOf(com.ucpro.model.a.a.a.a("setting_smart_reader", false));
                        } else {
                            if (com.ucpro.feature.setting.a.h.J == i) {
                                return String.valueOf(com.ucpro.model.a.a.a.a("setting_enable_adapt_screen", false));
                            }
                            if (com.ucpro.feature.setting.a.h.S == i) {
                                return String.valueOf(com.ucpro.ui.c.a.a());
                            }
                            if (com.ucpro.feature.setting.a.h.T == i) {
                                return String.valueOf(com.ucpro.model.a.a.a.a("setting_enable_logo", false));
                            }
                            if (com.ucpro.feature.setting.a.h.V == i) {
                                return com.ucpro.ui.c.a.d((int) R.string.quark_lab_wallpaper_coming_soon);
                            }
                            return null;
                        }
                    }
                }
            }
        }
    }

    public final boolean b(int i) {
        if (com.ucpro.feature.setting.a.h.A == i || com.ucpro.feature.setting.a.h.z == i || com.ucpro.feature.setting.a.h.L == i) {
            return false;
        }
        return com.ucpro.feature.setting.a.h.f == i ? com.ucpro.services.a.a.a.b("56DB53DAD2D33272456868E88138FD31") : true;
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
        if ((gVar instanceof com.ucpro.feature.webwindow.j.g) && this.u != null) {
            com.ucpro.feature.webwindow.j.r rVar = this.u;
            switch (b) {
                case (byte) 1:
                    com.ucpro.feature.webwindow.j.p a = com.ucpro.feature.webwindow.j.w.a;
                    Context context = rVar.b;
                    ValueCallback dVar = new d(rVar);
                    a.a.clear();
                    com.ucweb.common.util.h.m.a(2, new f(a, context, dVar));
                    rVar.a.a();
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof com.ucpro.base.c.b.g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final void a(int i, Object obj) {
        com.ucpro.base.c.b.g gVar = null;
        if (com.ucpro.feature.setting.a.h.b == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bx, obj);
        } else if (com.ucpro.feature.setting.a.h.c == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.feature.setting.e.b.a;
            m.a("setting", "wipe_cache", new String[0]);
            m.a(com.ucpro.feature.setting.e.a.a);
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.ba);
        } else if (com.ucpro.feature.setting.a.h.d == i) {
            m.a(com.ucpro.feature.setting.e.e.a);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.aX);
        } else if (com.ucpro.feature.setting.a.h.e == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.aY);
        } else if (com.ucpro.feature.setting.a.h.f == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.cs);
        } else if (com.ucpro.feature.setting.a.h.g == i) {
            m.a(com.ucpro.feature.setting.e.e.b);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.S);
        } else if (com.ucpro.feature.setting.a.h.p == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bf);
        } else if (com.ucpro.feature.setting.a.h.q == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bg);
        } else if (com.ucpro.feature.setting.a.h.r == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            r0 = new aj();
            r0.o = "http://bbs.myquark.cn/";
            r0.s = aj.b;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, r0);
            s_().b(true);
        } else if (com.ucpro.feature.setting.a.h.o == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            r0 = new aj();
            r0.o = "https://broccoli.uc.cn/apps/quarkfnintroduce/routes/index?entry=android_gnjs&UC_ACT";
            r0.s = aj.b;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, r0);
            s_().b(true);
        } else if (com.ucpro.feature.setting.a.h.m == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bz, Boolean.valueOf(true));
        } else if (com.ucpro.feature.setting.a.h.h == i) {
            this.s.a(i, Boolean.valueOf((String) obj).booleanValue());
        } else if (com.ucpro.feature.setting.a.h.i == i) {
            this.s.a(i, Boolean.valueOf((String) obj).booleanValue());
        } else if (com.ucpro.feature.setting.a.h.j == i) {
            this.s.a(i, Boolean.valueOf((String) obj).booleanValue());
        } else if (com.ucpro.feature.setting.a.h.k == i) {
            this.s.a(i, Boolean.valueOf((String) obj).booleanValue());
        } else if (com.ucpro.feature.setting.a.h.l == i) {
            this.s.a(i, Boolean.valueOf((String) obj).booleanValue());
        } else if (com.ucpro.feature.setting.a.h.w == i) {
            if (Boolean.valueOf(String.valueOf(obj)).booleanValue()) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            com.ucpro.model.a.a.a.b("setting_status_bar_type", r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.base.a.f.a().a(j.h);
        } else if (com.ucpro.feature.setting.a.h.x == i) {
            if (this.k != null) {
                r0 = com.ucpro.model.a.a.a.a("setting_crash_recovery_type", 0);
                List arrayList = new ArrayList();
                arrayList.add(com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_disable));
                arrayList.add(com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_enable_always_asking));
                arrayList.add(com.ucpro.ui.c.a.d((int) R.string.common_crash_recovery_enable_auto_recovery));
                d dVar = this.k;
                dVar.a.b(arrayList, r0, dVar.b);
            }
        } else if (com.ucpro.feature.setting.a.h.y == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bb);
        } else if (com.ucpro.feature.setting.a.h.z == i) {
            if (this.k != null) {
                this.k.a();
            }
            r0 = new HashMap();
            r0.put("search_eng", com.ucpro.feature.z.g.b.n.b.d().b);
            m.a(com.ucpro.feature.setting.e.a.b, r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.A == i) {
            if (this.k != null) {
                this.k.b();
            }
            r0 = new HashMap();
            com.ucpro.feature.h.b.a;
            r0.put("set_ua", com.ucpro.a.a.c.a(com.ucpro.feature.h.a.d()));
            m.a(com.ucpro.feature.setting.e.a.c, r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.K == i) {
            m.a(com.ucpro.feature.setting.e.a.e);
            com.ucpro.feature.f.n.a;
            if (com.ucpro.feature.f.e.c()) {
                com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bR);
            } else {
                com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bT);
            }
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.L == i) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.ce);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.n == i) {
            r0 = com.ucpro.feature.d.a.b.a(BitmapFactory.decodeResource(this.b.getResources(), R.mipmap.ic_launcher));
            com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
            aVar.a = com.ucpro.ui.c.a.d((int) R.string.quark_url);
            aVar.c = com.ucpro.ui.c.a.d((int) R.string.share_our_content);
            aVar.b = com.ucpro.ui.c.a.d((int) R.string.share_our_title);
            aVar.e = r0;
            aVar.f = r0;
            aVar.d = com.ucweb.c.a.c.c;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bC, aVar.a());
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.B == i) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bc, null);
        } else if (com.ucpro.feature.setting.a.h.s == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.E == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.model.a.a.a.b("setting_webcore_network_proxy", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            com.ucpro.base.a.f.a().a(j.n);
        } else if (com.ucpro.feature.setting.a.h.F == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bh);
        } else if (com.ucpro.feature.setting.a.h.G == i) {
            r0 = new HashMap();
            r0.put("click_status", String.valueOf(obj));
            m.a(com.ucpro.feature.setting.e.a.g, r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.model.a.a.a.b("setting_enable_smart_no_image", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            new StringBuilder("smart no image status set to: ").append(obj);
            com.ucpro.base.a.f.a().a(j.s);
        } else if (com.ucpro.feature.setting.a.h.H == i) {
            m.a(com.ucpro.feature.setting.e.a.d);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bi);
        } else if (com.ucpro.feature.setting.a.h.I == i) {
            r0 = new HashMap();
            r0.put("click_status", String.valueOf(obj));
            m.a(com.ucpro.feature.setting.e.a.j, r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.model.a.a.a.b("setting_smart_reader", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            new StringBuilder("smart reader status set to: ").append(obj);
            com.ucpro.base.a.f.a().a(j.t);
        } else if (com.ucpro.feature.setting.a.h.J == i) {
            r0 = new HashMap();
            r0.put("click_status", String.valueOf(obj));
            m.a(com.ucpro.feature.setting.e.a.i, r0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
            com.ucpro.model.a.a.a.b("setting_enable_adapt_screen", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            com.ucpro.base.a.f.a().a(j.u);
        } else if (com.ucpro.feature.setting.a.h.M == i) {
            if (this.t == null || this.t.getParent() == null) {
                this.t = new com.ucpro.feature.webwindow.j.g(this.b);
                this.u = new com.ucpro.feature.webwindow.j.r(this.t, this.b);
                this.t.setWindowCallBacks(this);
                this.t.setPresenter(this.u);
                gVar = this.t;
            }
            a(gVar);
            m.a(com.ucpro.feature.setting.e.a.f);
        } else if (com.ucpro.feature.setting.a.h.Q == i) {
            m.a(com.ucpro.feature.setting.e.a.h);
            com.ucpro.feature.setting.view.b.a aVar2 = new com.ucpro.feature.setting.view.b.a(this.b);
            aVar2.a = new h(this);
            aVar2.show();
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (com.ucpro.feature.setting.a.h.R == i) {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
            Object ajVar = new aj();
            List d = com.ucpro.feature.setting.c.a.e.e().d();
            if (d == null || d.size() == 0) {
                r0 = "";
            } else {
                r0 = ((com.ucpro.feature.setting.c.a.a) d.get(0)).b;
            }
            ajVar.o = r0;
            ajVar.s = aj.b;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, ajVar);
            s_().b(true);
            com.ucpro.feature.setting.c.a.e e = com.ucpro.feature.setting.c.a.e.e();
            List d2 = e.d();
            if (d2 != null && d2.size() != 0) {
                ((com.ucpro.feature.setting.c.a.a) d2.get(0)).c = true;
                e.b(d2);
            }
        } else {
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        }
    }

    public final void a(ac acVar) {
        if (acVar instanceof a) {
            com.ucpro.model.a.b a = com.ucpro.model.a.a.a;
            long j = this.s.a;
            a.a.edit().putLong("setting_wipe_cache_user_selected", j).apply();
        }
    }

    public final void b() {
        b bVar = this.s;
        Object obj = new int[]{0, 0, 0, 1};
        if (bVar.a(com.ucpro.feature.setting.a.h.h)) {
            com.ucpro.feature.z.f.a.c.a().c();
        }
        if (bVar.a(com.ucpro.feature.setting.a.h.i)) {
            obj[2] = 1;
        }
        if (bVar.a(com.ucpro.feature.setting.a.h.j)) {
            obj[1] = 1;
        }
        if (bVar.a(com.ucpro.feature.setting.a.h.k)) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.aD);
        }
        if (bVar.a(com.ucpro.feature.setting.a.h.l)) {
            obj[0] = 1;
        }
        String toBinaryString = Long.toBinaryString(bVar.a);
        Map hashMap = new HashMap();
        hashMap.put("clear_item_key", toBinaryString);
        m.a(com.ucpro.feature.setting.e.h.a, hashMap);
        com.ucpro.feature.setting.e.b.a;
        CharSequence toBinaryString2 = Long.toBinaryString(bVar.a);
        if (!TextUtils.isEmpty(toBinaryString2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("wipe_cache_selected", toBinaryString2);
            m.a("setting", "wipe_cache", hashMap2);
        }
        com.ucpro.base.a.f.a().a(j.k, 0, obj, true);
    }

    public final boolean c() {
        return this.s.a != 0;
    }

    public final View a(View view) {
        return this.a.b().b(this.a.b().a());
    }
}
