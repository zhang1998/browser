package com.ucpro.feature.lightapp.channelpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.apollo.android.GuideDialog;
import com.uc.weex.h.g;
import com.uc.weex.h.k;
import com.uc.weex.h.o;
import com.ucpro.base.c.b.m;
import com.ucpro.base.weex.c;
import com.ucpro.base.weex.f;
import com.ucpro.feature.lightapp.c.a;
import com.ucpro.feature.lightapp.e.b;
import com.ucpro.feature.lightapp.e.d;
import com.ucpro.feature.lightapp.e.h;
import com.ucpro.feature.lightapp.n;
import com.ucpro.feature.navigation.b.e;
import com.ucpro.feature.navigation.b.i;

/* compiled from: ProGuard */
public final class ChannelPagePresenter extends l {
    public static boolean b;
    private static final boolean h = false;
    public b a;
    public j c;
    public a d;
    private final Context i;
    private final com.ucpro.feature.lightapp.d.b.b j;
    private RefreshBroadcastReceiver k;
    private com.ucpro.feature.lightapp.d.b l;
    private String m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private boolean s = false;
    private boolean t = false;
    private o u;
    private g v = new d(this);
    private h w = new f(this);

    /* compiled from: ProGuard */
    public class RefreshBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ ChannelPagePresenter a;

        public RefreshBroadcastReceiver(ChannelPagePresenter channelPagePresenter) {
            this.a = channelPagePresenter;
        }

        public void onReceive(Context context, Intent intent) {
            if ("DEBUG_INSTANCE_REFRESH".equals(intent.getAction())) {
                this.a.a(this.a.l);
            }
        }
    }

    static /* synthetic */ void a(ChannelPagePresenter channelPagePresenter, com.ucpro.feature.lightapp.d.b bVar, boolean z) {
        Object substring;
        CharSequence charSequence;
        k a = com.ucpro.feature.lightapp.a.a.a(channelPagePresenter.m, channelPagePresenter.i);
        if (h) {
            a.g = true;
        }
        a.a(GuideDialog.TITLE, bVar.b);
        a.a("categoryId", bVar.c);
        a.a("url", bVar.e);
        String str = "iconName";
        i.a;
        String str2 = bVar.e;
        if (com.ucpro.feature.navigation.a.a.a(str2)) {
            String str3 = "url=";
            int indexOf = str2.indexOf(str3);
            if (indexOf >= 0) {
                substring = str2.substring(str3.length() + indexOf);
                int indexOf2 = substring.indexOf("^");
                if (indexOf2 > 0) {
                    substring = substring.substring(0, indexOf2);
                }
                if (!TextUtils.isEmpty(substring)) {
                    substring = substring + ".png";
                    a.a(str, substring);
                    a.a("iconColor", String.valueOf(Color.parseColor(e.a().a(bVar.e))));
                    a.a("target", "channelpage");
                    str = "currentTheme";
                    if (com.ucpro.ui.c.a.b()) {
                        substring = "day";
                    } else {
                        substring = "nig";
                    }
                    a.a(str, substring);
                    charSequence = bVar.d;
                    if (!TextUtils.isEmpty(charSequence)) {
                        a.a("userToken", charSequence);
                    }
                    channelPagePresenter.l = bVar;
                    a.a("isInNavigation", String.valueOf(z));
                    a.e = channelPagePresenter.v;
                    channelPagePresenter.u = com.uc.weex.o.a.a(channelPagePresenter.i, a);
                    channelPagePresenter.u.a(new c(channelPagePresenter, channelPagePresenter.g));
                    if (channelPagePresenter.f != null) {
                        channelPagePresenter.f.setContentView(channelPagePresenter.u.g());
                        if (channelPagePresenter.c != null) {
                            channelPagePresenter.c.a();
                            channelPagePresenter.c = null;
                        }
                    }
                    channelPagePresenter.n = System.currentTimeMillis();
                    channelPagePresenter.q = channelPagePresenter.n;
                    channelPagePresenter.b(true);
                }
            }
        }
        substring = null;
        a.a(str, substring);
        a.a("iconColor", String.valueOf(Color.parseColor(e.a().a(bVar.e))));
        a.a("target", "channelpage");
        str = "currentTheme";
        if (com.ucpro.ui.c.a.b()) {
            substring = "day";
        } else {
            substring = "nig";
        }
        a.a(str, substring);
        charSequence = bVar.d;
        if (TextUtils.isEmpty(charSequence)) {
            a.a("userToken", charSequence);
        }
        channelPagePresenter.l = bVar;
        a.a("isInNavigation", String.valueOf(z));
        a.e = channelPagePresenter.v;
        channelPagePresenter.u = com.uc.weex.o.a.a(channelPagePresenter.i, a);
        channelPagePresenter.u.a(new c(channelPagePresenter, channelPagePresenter.g));
        if (channelPagePresenter.f != null) {
            channelPagePresenter.f.setContentView(channelPagePresenter.u.g());
            if (channelPagePresenter.c != null) {
                channelPagePresenter.c.a();
                channelPagePresenter.c = null;
            }
        }
        channelPagePresenter.n = System.currentTimeMillis();
        channelPagePresenter.q = channelPagePresenter.n;
        channelPagePresenter.b(true);
    }

    static {
        com.ucpro.c.b.b();
    }

    public ChannelPagePresenter(Context context, m mVar, com.ucpro.feature.lightapp.d.b.b bVar, c cVar) {
        super(mVar, cVar);
        this.i = context;
        this.j = bVar;
        if (h) {
            this.m = "http://100.84.202.127:2018/dist/index.weex.js";
            com.ucpro.ui.b.e.a().a("轻应用连接远程Bundle", 0);
        } else {
            this.m = "assets://lightapp/lightapp";
        }
        if (com.ucpro.c.b.b() && this.k == null) {
            this.k = new RefreshBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("DEBUG_INSTANCE_REFRESH");
            this.i.registerReceiver(this.k, intentFilter);
        }
        f.a().a(this.i);
    }

    public final void a(int i) {
        b(i == 0);
    }

    private void b(boolean z) {
        if (this.d != null) {
            boolean z2;
            if (this.e.a() == this.f && z) {
                if (!(this.s || TextUtils.isEmpty(c()))) {
                    a(c(), new n(this));
                }
                z2 = this.t;
            } else {
                z2 = false;
            }
            this.d.b(z2);
        }
    }

    public final void a() {
        if (this.f != null) {
            a(null);
            if (System.currentTimeMillis() - this.n > 0 && this.l != null) {
                String[] strArr = new String[]{"category_id", this.l.c, "category_title", this.l.b, "total_readtime", String.valueOf(((float) r0) / 60000.0f), "ch_readtime", String.valueOf(((float) this.o) / 60000.0f), "article_readtime", String.valueOf(((float) this.p) / 60000.0f)};
                com.ucpro.business.stat.m.a("lightapp", "reading_time", strArr);
            }
        }
        if (this.k != null) {
            this.i.unregisterReceiver(this.k);
            this.k = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
    }

    public final void a(com.ucpro.feature.lightapp.d.b bVar) {
        com.ucpro.feature.lightapp.d.b.b bVar2 = this.j;
        ValueCallback kVar = new k(this, bVar);
        if (bVar2.a == null) {
            com.ucweb.common.util.h.m.a(0, new com.ucpro.feature.lightapp.d.b.c(bVar2, kVar));
            return;
        }
        new StringBuilder("UserToken is already init\nUserToken is: ").append(bVar2.a.b);
        kVar.onReceiveValue(bVar2.a.b);
    }

    private static void a(String str, ValueCallback<Boolean> valueCallback) {
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.d, new Object[]{str, valueCallback});
    }

    public final void a(String str, String str2) {
        if (this.a == null || !this.a.h()) {
            this.a = new b(this.i, this.e, this.l, this.m, this.w, this.g);
            n fVar = new com.ucpro.feature.lightapp.e.f(this.i);
            fVar.setPresenter(this.a);
            this.a.a(fVar);
            com.ucpro.feature.lightapp.c cVar = this.a;
            cVar.l = str;
            cVar.k = str2;
            if (!com.ucpro.feature.lightapp.d.a.b(cVar.k)) {
                String str3 = cVar.k;
                String str4 = cVar.l;
                if (!TextUtils.isEmpty(str3)) {
                    str3 = str3 + "^articleId=" + str4;
                }
                cVar.k = str3;
            }
            new StringBuilder("openArticlePage:articleId").append(cVar.l);
            k a = com.ucpro.feature.lightapp.a.a.a(cVar.c, cVar.a);
            a.a("userToken", cVar.b.d);
            a.a("articleId", cVar.l);
            a.a("target", "articlepage");
            a.a("currentTheme", com.ucpro.ui.c.a.b() ? "nig" : "day");
            a.a("iconColor", e.a().a(cVar.k));
            cVar.m = com.uc.weex.o.a.a(cVar.a, a);
            cVar.m.a(new d(cVar, cVar, cVar.g));
            if (cVar.f != null) {
                cVar.f.setContentView(cVar.m.g());
            }
            cVar.g();
            this.r = System.currentTimeMillis();
            this.o += System.currentTimeMillis() - this.q;
        }
    }

    public final String b() {
        if (this.l != null) {
            return this.l.b;
        }
        return "";
    }

    public final String c() {
        if (this.l != null) {
            return this.l.e;
        }
        return "";
    }

    static /* synthetic */ void a(ChannelPagePresenter channelPagePresenter, com.ucpro.feature.lightapp.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            bVar.d = str;
        }
        a(bVar.e, new h(channelPagePresenter, bVar));
    }
}
