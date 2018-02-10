package com.ucpro.feature.z.b;

import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.a.b.e;
import com.uc.a.d.j;
import com.uc.a.d.l;
import com.ucpro.feature.z.g.b.a;
import com.ucpro.feature.z.g.b.h;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class g implements j {
    public final String a = "微博";
    public final String b = "http://s.weibo.com/weibo/%s";
    public final String c = "search_weibo_icon.svg";
    public final String d = "知乎";
    public final String e = "http://www.zhihu.com/search?type=content&q=%s";
    public final String f = "search_zhihu_icon.svg";
    public final String g = "优酷";
    public final String h = "http://www.soku.com/m/y/video?q=%s&tpa=dW5pb25faWQ9MTAzOTQyXzEwMDAwMV8wMV8wMQ";
    public final String i = "search_youku_icon.png";
    public final String j = "豆瓣";
    public final String k = "https://m.douban.com/search/?query=%s";
    public final String l = "search_douban_icon.svg";
    public final String m = "微信";
    public final String n = "http://weixin.sogou.com/weixinwap?type=2&query=%s";
    public final String o = "search_weixin_icon.svg";
    List<a> p = null;
    m q = null;
    private String[] r;
    private String[] s;
    private String[] t;

    public g(m mVar) {
        c.a((Object) mVar);
        com.ucpro.business.e.a.a.a().a("vertical_search", (j) this);
        c();
        String str = "vertical_search";
        if (!TextUtils.isEmpty(str)) {
            int i = -1;
            switch (str.hashCode()) {
                case 822528657:
                    if (str.equals("vertical_search")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    byte[] a = l.a(str);
                    if (a != null && a.length > 0) {
                        m.a(0, new d(this, a));
                        break;
                    }
            }
        }
        this.q = mVar;
    }

    private String[] a() {
        if (this.r == null) {
            this.r = d.c().getStringArray(com.ucpro.b.a.a.a() ? R.array.hardcode_vertical_search_engine_names : R.array.hardcode_vertical_search_engine_names_cn);
        }
        return this.r;
    }

    private String[] b() {
        if (this.t == null) {
            this.t = d.c().getStringArray(com.ucpro.b.a.a.a() ? R.array.hardcode_vertical_search_engine_iconnames : R.array.hardcode_vertical_search_engine_iconnames_cn);
        }
        return this.t;
    }

    final a a(h hVar) {
        a aVar = new a();
        if (hVar != null) {
            String str;
            Object c = hVar.c();
            aVar.e = hVar.e();
            aVar.b = hVar.c();
            if (hVar.a == null) {
                str = null;
            } else {
                str = hVar.a.toString();
            }
            aVar.c = str;
            if (!TextUtils.isEmpty(c)) {
                int i;
                for (i = 0; i < a().length; i++) {
                    if (c.contains(a()[i])) {
                        aVar.d = b()[i];
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i == 0) {
                    byte[] bArr = hVar.b;
                    String str2 = com.ucpro.c.c.a().getAbsolutePath() + "/search/icon//";
                    str = aVar.e;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (str == null) {
                        str = "null";
                    }
                    String a = com.ucweb.common.util.n.a.a(str2, stringBuilder.append(str.hashCode()).toString());
                    if (!com.ucweb.common.util.k.a.h(a)) {
                        com.ucweb.common.util.k.a.a(str2, str, bArr);
                    }
                    aVar.d = a;
                }
            }
        }
        return aVar;
    }

    private void c() {
        this.p = new ArrayList();
        for (int i = 0; i < a().length; i++) {
            a aVar = new a();
            aVar.b = a()[i];
            if (this.s == null) {
                this.s = d.c().getStringArray(com.ucpro.b.a.a.a() ? R.array.hardcode_vertical_search_engine_urls : R.array.hardcode_vertical_search_engine_urls_cn);
            }
            aVar.c = this.s[i];
            aVar.d = b()[i];
            this.p.add(aVar);
        }
    }

    public final void a(String str, e eVar) {
    }
}
