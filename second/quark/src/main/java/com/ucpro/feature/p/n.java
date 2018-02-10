package com.ucpro.feature.p;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.IWebResources;
import com.ucpro.base.a.e;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.c.b.w;
import com.ucpro.business.stat.o;
import com.ucpro.c.d;
import com.ucpro.feature.bookmarkhis.bookmark.a.ai;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.webwindow.az;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.model.a.a;
import com.ucpro.model.a.b;
import com.ucpro.ui.g.c;
import com.ucpro.ui.g.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
public final class n implements m {
    s a;
    int b;
    int c = -1;
    boolean d;
    private m e;
    private long f = System.currentTimeMillis();
    private boolean g = false;
    private ValueCallback<Boolean> h = new e(this);

    public n(s sVar, m mVar) {
        this.a = sVar;
        this.e = mVar;
    }

    private String c() {
        g a = this.e.a();
        if (a instanceof bb) {
            return ((bb) a).getUrl();
        }
        if (a instanceof w) {
            return ((w) a).getUrl();
        }
        return null;
    }

    final bb b() {
        g a = this.e.a();
        if (a instanceof bb) {
            return (bb) a;
        }
        return null;
    }

    public final void a(int i) {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= 500) {
            boolean a;
            this.f = currentTimeMillis;
            b a2;
            String str;
            String str2;
            if (this.b == 4) {
                switch (i) {
                    case 24:
                        a = a.a.a("setting_smart_reader", false);
                        a2 = a.a;
                        str = "setting_smart_reader";
                        if (a) {
                            a = false;
                        } else {
                            a = true;
                        }
                        a2.b(str, a);
                        f.a().a(j.t);
                        str2 = "smart_reader";
                        a = false;
                        break;
                    case 25:
                        a = a.a.a("setting_enable_adapt_screen", false);
                        a2 = a.a;
                        str = "setting_enable_adapt_screen";
                        if (a) {
                            a = false;
                        } else {
                            a = true;
                        }
                        a2.b(str, a);
                        f.a().a(j.u);
                        str2 = "adapte_screen";
                        a = false;
                        break;
                    case 32:
                        a = a.a.a("setting_webcore_network_proxy", false);
                        a2 = a.a;
                        str = "setting_webcore_network_proxy";
                        if (a) {
                            a = false;
                        } else {
                            a = true;
                        }
                        a2.b(str, a);
                        f.a().a(j.n);
                        str2 = "cloud_accel";
                        a = false;
                        break;
                    case 33:
                        a = a.a.a("setting_enable_smart_no_image", false);
                        a2 = a.a;
                        str = "setting_enable_smart_no_image";
                        if (a) {
                            a = false;
                        } else {
                            a = true;
                        }
                        a2.b(str, a);
                        f.a().a(j.s);
                        str2 = "no_image";
                        a = false;
                        break;
                    case 35:
                        r rVar;
                        c kVar = new k(this);
                        List a3 = com.ucpro.a.a.c.a();
                        com.ucpro.feature.h.b.a;
                        String a4 = com.ucpro.a.a.c.a(com.ucpro.feature.h.a.d());
                        int i2 = 0;
                        while (i2 < a3.size()) {
                            if (com.ucweb.common.util.n.a.c((String) a3.get(i2), a4)) {
                                if (d.b()) {
                                    a = true;
                                } else {
                                    a = false;
                                }
                                rVar = new r(b().getContext(), a);
                                rVar.a(com.ucpro.ui.c.a.d((int) R.string.common_setting_ua_dialog_title));
                                rVar.a(a3, i2);
                                rVar.a = kVar;
                                rVar.show();
                                str2 = "ua_setting";
                                a = false;
                                break;
                            }
                            i2++;
                        }
                        i2 = 0;
                        if (d.b()) {
                            a = false;
                        } else {
                            a = true;
                        }
                        rVar = new r(b().getContext(), a);
                        rVar.a(com.ucpro.ui.c.a.d((int) R.string.common_setting_ua_dialog_title));
                        rVar.a(a3, i2);
                        rVar.a = kVar;
                        rVar.show();
                        str2 = "ua_setting";
                        a = false;
                    case 36:
                        if (!(b() == null || b().G())) {
                            b().o();
                        }
                        str2 = "search_in_page";
                        a = false;
                        break;
                    case 37:
                        com.ucpro.base.a.g.a().b(e.j);
                        str2 = "toolbox_back";
                        a = true;
                        break;
                    case 38:
                        com.ucpro.base.a.g.a().b(e.dc);
                        str2 = "shortcut_tool_setting";
                        a = false;
                        break;
                    default:
                        str2 = null;
                        a = false;
                        break;
                }
                if (str2 != null) {
                    str = String.valueOf(this.b);
                    com.ucpro.business.stat.m.a("mainmenu", "click", "from", str2, "type", str);
                    com.ucpro.business.stat.m.b("mainmenu_ut", "click", "from", str2, "type", str);
                    this.g = true;
                }
            } else {
                String title;
                switch (i) {
                    case 1:
                        com.ucpro.base.a.g.a().a(e.S);
                        str2 = "fb";
                        a = true;
                        break;
                    case 2:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.g.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.g);
                        } else if (this.b == 1) {
                            o.a(az.h.c);
                            com.ucpro.business.stat.m.a(az.h);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.i.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.i);
                        }
                        com.ucpro.base.a.g.a().a(e.aW);
                        com.ucpro.services.a.a.a.c(com.ucpro.services.a.b.d);
                        str2 = "st";
                        a = true;
                        break;
                    case 3:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.f.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.f);
                        } else if (this.b == 1) {
                            o.a(az.g.c);
                            com.ucpro.business.stat.m.a(az.g);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.h.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.h);
                        }
                        com.ucpro.base.a.g.a().a(e.aw, Integer.valueOf(0));
                        str2 = "dl";
                        a = true;
                        break;
                    case 4:
                        com.ucpro.base.a.g.a().a(e.au, Integer.valueOf(1));
                        str2 = "hs";
                        a = true;
                        break;
                    case 6:
                        if (this.b == 1) {
                            o.a(az.o.c);
                            com.ucpro.business.stat.m.a(az.o);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.q.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.q);
                        }
                        if (this.b == 1) {
                            com.ucpro.base.a.g.a().a(e.t);
                        } else {
                            com.ucpro.base.a.g.a().b(e.bJ);
                        }
                        str2 = IWebResources.TEXT_SHARE;
                        a = false;
                        break;
                    case 7:
                        if (this.b == 0) {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.j);
                        } else if (this.b == 1) {
                            com.ucpro.business.stat.m.a(az.k);
                        } else {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.l);
                        }
                        if (this.b == 1) {
                            bb b = b();
                            if (b != null) {
                                CharSequence url = b.getUrl();
                                title = b.getTitle();
                                com.ucweb.common.util.c.a(url);
                                com.ucpro.business.stat.m.a("bookmark", "bookmark_collect", "collect_bookmark_title", title, "collect_bookmark_url", url);
                                Object bundle = new Bundle();
                                bundle.putString("TITLE", title);
                                bundle.putString("URL", url);
                                com.ucpro.base.a.g.a().a(e.aG, bundle);
                            }
                        } else {
                            com.ucpro.base.a.g.a().b(e.bK);
                        }
                        str2 = "fav";
                        a = false;
                        break;
                    case 8:
                        if (this.b == 0) {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.j);
                        } else if (this.b == 1) {
                            com.ucpro.business.stat.m.a(az.k);
                        } else {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.l);
                        }
                        com.ucpro.business.stat.m.a("bookmark", "bookmark_cancel_collect", new String[0]);
                        CharSequence c = c();
                        com.ucweb.common.util.c.a(c);
                        s a5 = s.a();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        com.raizlabs.android.dbflow.structure.database.transaction.f a6 = a5.b.a(new ai(a5, c, atomicBoolean));
                        a6.d = new com.ucpro.feature.bookmarkhis.bookmark.a.a(a5, atomicBoolean);
                        a6.c = new com.ucpro.feature.bookmarkhis.bookmark.a.g(a5);
                        a6.a().b();
                        com.ucpro.ui.b.e.a().a((int) R.string.uncollected, 0);
                        str2 = "unfav";
                        a = false;
                        break;
                    case 9:
                        if (this.b == 0) {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.k);
                        } else if (this.b == 1) {
                            com.ucpro.business.stat.m.a(az.l);
                        } else {
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.m);
                        }
                        com.ucpro.base.a.g.a().a(e.s);
                        str2 = "rl";
                        a = false;
                        break;
                    case 16:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.e.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.e);
                        } else if (this.b == 1) {
                            o.a(az.f.c);
                            com.ucpro.business.stat.m.a(az.f);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.g.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.g);
                        }
                        com.ucpro.base.a.g.a().a(e.au, Integer.valueOf(0));
                        str2 = "bm";
                        a = true;
                        break;
                    case 17:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.i.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.i);
                        } else if (this.b == 1) {
                            o.a(az.j.c);
                            com.ucpro.business.stat.m.a(az.j);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.k.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.k);
                        }
                        com.ucpro.base.a.g.a().a(e.o);
                        str2 = "forward";
                        a = false;
                        break;
                    case 18:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.l.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.l);
                        } else if (this.b == 1) {
                            o.a(az.m.c);
                            com.ucpro.business.stat.m.a(az.m);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.n.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.n);
                        }
                        com.ucpro.feature.e.a a7;
                        if (com.ucpro.feature.e.b.a.a) {
                            a7 = com.ucpro.feature.e.b.a;
                            if (a7.a) {
                                a.a.b("setting_no_footmark_mode", false);
                                a7.a = false;
                                f.a().a(j.i);
                            }
                            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.disable_incognito_tip), 0);
                        } else {
                            a7 = com.ucpro.feature.e.b.a;
                            if (!a7.a) {
                                a.a.b("setting_no_footmark_mode", true);
                                a7.a = true;
                                f.a().a(j.i);
                            }
                            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.enable_incognito_tip), 0);
                        }
                        str2 = "incognito";
                        a = false;
                        break;
                    case 19:
                        if (this.b == 0) {
                            o.a(com.ucpro.feature.y.o.m.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.m);
                        } else if (this.b == 1) {
                            o.a(az.n.c);
                            com.ucpro.business.stat.m.a(az.n);
                        } else {
                            o.a(com.ucpro.feature.lightapp.f.a.o.c);
                            com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.o);
                        }
                        a = a.a.a("setting_night_mode", false);
                        a2 = a.a;
                        str = "setting_night_mode";
                        if (a) {
                            a = false;
                        } else {
                            a = true;
                        }
                        a2.b(str, a);
                        f.a().a(j.g);
                        str2 = "nm";
                        a = false;
                        break;
                    case 20:
                        o.a(com.ucpro.feature.y.o.m.c);
                        com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.m);
                        title = com.ucpro.feature.d.a.b.a(BitmapFactory.decodeResource(this.e.h().getResources(), R.mipmap.ic_launcher));
                        com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
                        aVar.a = com.ucpro.ui.c.a.d((int) R.string.quark_url);
                        aVar.c = com.ucpro.ui.c.a.d((int) R.string.share_our_content);
                        aVar.b = com.ucpro.ui.c.a.d((int) R.string.share_our_title);
                        aVar.e = title;
                        aVar.f = title;
                        aVar.d = com.ucweb.c.a.c.c;
                        com.ucpro.base.a.g.a().a(e.bC, aVar.a());
                        str2 = "share_app";
                        a = true;
                        break;
                    case 21:
                        o.a(com.ucpro.feature.lightapp.f.a.p.c);
                        com.ucpro.business.stat.m.a(com.ucpro.feature.lightapp.f.a.p);
                        com.ucpro.base.a.g.a().b(e.bI);
                        str2 = "goto_origin";
                        a = false;
                        break;
                    case 22:
                        com.ucpro.base.a.g.a().b(e.i);
                        str2 = "toolbox";
                        a = true;
                        break;
                    case 23:
                        com.ucpro.feature.f.n.a;
                        if (com.ucpro.feature.f.e.c()) {
                            com.ucpro.base.a.g.a().b(e.bR);
                        } else {
                            com.ucpro.base.a.g.a().b(e.de);
                        }
                        str2 = "personal";
                        a = false;
                        break;
                    default:
                        str2 = null;
                        a = false;
                        break;
                }
                if (str2 != null) {
                    str = String.valueOf(this.b);
                    com.ucpro.business.stat.m.a("mainmenu", "click", "from", str2, "type", str);
                    com.ucpro.business.stat.m.b("mainmenu_ut", "click", "from", str2, "type", str);
                    this.g = true;
                }
            }
            if (!a) {
                s sVar = this.a;
                String str3 = "click_item";
                if (a) {
                    z = false;
                }
                sVar.a(str3, z);
            }
        }
    }

    public final void a(ValueCallback<g> valueCallback) {
        int length;
        Iterator it;
        int i;
        int length2;
        b bVar;
        String c = c();
        if (c == null) {
            c = "";
        }
        boolean z = false;
        boolean z2 = com.ucpro.feature.e.b.a.a;
        boolean z3 = false;
        boolean a = a.a.a("setting_night_mode", false);
        if (this.b == 0) {
            z3 = d();
        } else if (this.b == 1) {
            s.a();
            z = s.b(c);
            z3 = d();
        } else if (this.b != 2 && this.b == 3) {
            s.a();
            z = s.b(c);
        }
        int i2 = this.b;
        g a2 = f.a(i2);
        Iterator it2 = a2.c.iterator();
        while (it2.hasNext()) {
            for (b bVar2 : (b[]) it2.next()) {
                if (bVar2.a == 2 && (bVar2.h instanceof String)) {
                    bVar2.g = com.ucpro.services.a.a.a.b((String) bVar2.h);
                    break;
                }
            }
        }
        if (i2 == 0) {
            it = a2.c.iterator();
            while (it.hasNext()) {
                for (b bVar3 : (b[]) it.next()) {
                    if (bVar3 != null) {
                        if (bVar3.a == 7 || bVar3.a == 9 || bVar3.a == 8) {
                            bVar3.f = false;
                        }
                        if (bVar3.a == 7 || bVar3.a == 8) {
                            bVar3.b = R.string.collect;
                            bVar3.e = "menu_collected.svg";
                        }
                    }
                }
            }
        } else if (i2 == 1) {
            it2 = a2.c.iterator();
            while (it2.hasNext()) {
                for (b bVar22 : (b[]) it2.next()) {
                    if (bVar22 != null) {
                        if (bVar22.a == 7 || bVar22.a == 8 || bVar22.a == 9) {
                            bVar22.f = true;
                        }
                        if (bVar22.a == 7 || bVar22.a == 8) {
                            if (z) {
                                bVar22.h = com.ucweb.common.util.p.b.w;
                                bVar22.b = R.string.collected;
                                bVar22.a = 8;
                                bVar22.e = "menu_collected_enabled.svg";
                            } else {
                                bVar22.h = com.ucweb.common.util.p.b.i;
                                bVar22.a = 7;
                                bVar22.b = R.string.collect;
                                bVar22.e = "menu_collected.svg";
                            }
                        }
                    }
                }
            }
        } else if (i2 == 2) {
            it = a2.c.iterator();
            while (it.hasNext()) {
                for (b bVar32 : (b[]) it.next()) {
                    if (bVar32 != null) {
                        if (bVar32.a == 7 || bVar32.a == 21 || bVar32.a == 8 || bVar32.a == 17 || bVar32.a == 9) {
                            bVar32.f = false;
                        }
                        if (bVar32.a == 7 || bVar32.a == 8) {
                            bVar32.b = R.string.collect;
                            bVar32.e = "menu_collected.svg";
                        }
                    }
                }
            }
        } else if (i2 == 3) {
            it2 = a2.c.iterator();
            while (it2.hasNext()) {
                for (b bVar222 : (b[]) it2.next()) {
                    if (bVar222 != null) {
                        if (bVar222.a == 17) {
                            bVar222.f = false;
                        }
                        if (bVar222.a == 7 || bVar222.a == 8 || bVar222.a == 21) {
                            bVar222.f = true;
                        }
                        if (bVar222.a == 7 || bVar222.a == 8) {
                            if (z) {
                                bVar222.h = com.ucweb.common.util.p.b.w;
                                bVar222.b = R.string.collected;
                                bVar222.a = 8;
                                bVar222.e = "menu_collected_enabled.svg";
                            } else {
                                bVar222.h = com.ucweb.common.util.p.b.i;
                                bVar222.a = 7;
                                bVar222.b = R.string.collect;
                                bVar222.e = "menu_collected.svg";
                            }
                        }
                    }
                }
            }
        }
        b bVar4 = a2.a;
        if (bVar4 != null && bVar4.a == 23) {
            com.ucpro.feature.f.n.a;
            if (com.ucpro.feature.f.e.c()) {
                com.ucpro.feature.f.n.a;
                com.uc.base.a.a.a.b bVar5 = com.uc.base.a.a.a.g.a;
                if (com.uc.base.a.a.a.h.b.a == null || TextUtils.isEmpty(com.uc.base.a.a.a.h.b.a.d)) {
                    com.uc.base.a.a.a.h.a aVar = new com.uc.base.a.a.a.h.a();
                    com.uc.base.a.a.a.f.a a3 = com.uc.base.a.a.a.c.a();
                    aVar.a = a3.b("nickname");
                    aVar.b = a3.b("gender");
                    aVar.h = a3.b("unaudited_avatar_uri");
                    aVar.g = a3.b("unaudited_avatar_id");
                    aVar.i = a3.c("avatar_state");
                    aVar.d = a3.b("avatar_url");
                    aVar.c = a3.b("avatar_id");
                    aVar.e = a3.b("thirdPartyAvatar_url");
                    aVar.f = a3.b("thirdPartyNickName");
                    com.uc.base.a.a.a.h.b.a = aVar;
                }
                Object obj = com.uc.base.a.a.a.h.b.a;
                boolean z4 = false;
                if (obj == null) {
                    com.ucweb.common.util.c.a("user info should not null");
                    z4 = true;
                }
                boolean c2 = com.ucpro.feature.f.e.c();
                com.ucpro.business.stat.m.a("account", "get_userinfo", "user_info_is_null", String.valueOf(z4), "is_login", String.valueOf(c2));
                if (obj != null) {
                    bVar4.c = com.ucpro.feature.f.e.a((com.uc.base.a.a.a.h.a) obj);
                    com.ucweb.common.util.c.a(obj, "profile info should not null when get UserAvatarUrl");
                    CharSequence charSequence = "";
                    if (obj != null) {
                        if (!TextUtils.isEmpty(obj.e)) {
                            charSequence = obj.e;
                        } else if (!TextUtils.isEmpty(obj.h)) {
                            charSequence = obj.h;
                        } else if (!TextUtils.isEmpty(obj.d)) {
                            charSequence = obj.d;
                        }
                    }
                    if (TextUtils.isEmpty(charSequence) || !com.ucweb.common.util.i.f.a(charSequence)) {
                        bVar4.e = "personal_default_icon.svg";
                    } else {
                        bVar4.e = charSequence;
                    }
                }
            } else {
                bVar4.c = null;
                bVar4.e = "personal_default_icon.svg";
            }
        }
        it = a2.c.iterator();
        while (it.hasNext()) {
            b[] bVarArr = (b[]) it.next();
            length2 = bVarArr.length;
            i = 0;
            while (i < length2) {
                bVar32 = bVarArr[i];
                if (bVar32 == null || bVar32.a != 18) {
                    i++;
                } else if (z2) {
                    bVar32.e = "menu_incognito_enabled.svg";
                } else {
                    bVar32.e = "menu_incognito.svg";
                }
            }
        }
        it = a2.c.iterator();
        while (it.hasNext()) {
            for (b bVar6 : (b[]) it.next()) {
                if (bVar6 != null && bVar6.a == 17) {
                    bVar6.f = z3;
                    break;
                }
            }
        }
        Iterator it3 = a2.c.iterator();
        while (it3.hasNext()) {
            bVarArr = (b[]) it3.next();
            length = bVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                b bVar7 = bVarArr[i3];
                if (bVar7 == null || bVar7.a != 19) {
                    i3++;
                } else if (a) {
                    bVar7.e = "menu_night_mode_enabled.svg";
                } else {
                    bVar7.e = "menu_night_mode.svg";
                }
            }
        }
        b bVar8 = a2.b;
        if (bVar8 != null && (bVar8.a == 6 || bVar8.a == 20)) {
            bVar8.f = true;
            if (i2 == 0) {
                bVar8.a = 20;
                bVar8.h = com.ucweb.common.util.p.b.v;
                bVar8.b = R.string.share_app;
            } else if (i2 == 1 || i2 == 3) {
                bVar8.a = 6;
                bVar8.h = com.ucweb.common.util.p.b.u;
                bVar8.b = R.string.share;
            } else if (i2 == 2) {
                bVar8.f = false;
                bVar8.b = R.string.share;
            }
        }
        valueCallback.onReceiveValue(a2);
    }

    private boolean d() {
        com.ucpro.base.a.g.a().b(e.p, this.h);
        return this.d;
    }

    public final void a(String str) {
        if (!this.g) {
            String str2;
            if (this.b == 0) {
                str2 = SettingsConst.FALSE;
            } else {
                str2 = SettingsConst.TRUE;
            }
            com.ucpro.business.stat.m.a("mainmenu", "hide", "from", str, "type", str2);
        }
    }

    public final void a() {
        this.g = false;
    }

    final void a(b... bVarArr) {
        for (b bVar : bVarArr) {
            if (bVar != null) {
                if (bVar.a == 24) {
                    if (a.a.a("setting_smart_reader", false)) {
                        bVar.e = "menu_smart_reader_enable.svg";
                    } else {
                        bVar.e = "menu_smart_reader.svg";
                    }
                } else if (bVar.a == 25) {
                    if (a.a.a("setting_enable_adapt_screen", false)) {
                        bVar.e = "menu_adapte_screen_enable.svg";
                    } else {
                        bVar.e = "menu_adapte_screen.svg";
                    }
                } else if (bVar.a == 32) {
                    if (a.a.a("setting_webcore_network_proxy", false)) {
                        bVar.e = "menu_cloud_acceleration_enable.svg";
                    } else {
                        bVar.e = "menu_cloud_acceleration.svg";
                    }
                } else if (bVar.a == 33) {
                    if (a.a.a("setting_enable_smart_no_image", false)) {
                        bVar.e = "menu_nopic_enable.svg";
                    } else {
                        bVar.e = "menu_nopic.svg";
                    }
                } else if (bVar.a == 36) {
                    if (b() == null || b().G()) {
                        bVar.f = false;
                    } else {
                        bVar.f = true;
                    }
                }
            }
        }
    }
}
