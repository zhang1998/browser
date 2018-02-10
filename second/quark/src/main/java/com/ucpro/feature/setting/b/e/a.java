package com.ucpro.feature.setting.b.e;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.e.e;
import com.ucpro.feature.setting.b.b.a.d;
import com.ucpro.feature.setting.b.d.d.b;
import com.ucpro.feature.setting.b.d.d.c;
import com.ucpro.feature.setting.b.f.ab;
import com.ucpro.feature.setting.b.f.ad;
import com.ucpro.feature.setting.b.f.ag;
import com.ucpro.feature.setting.b.f.ah;
import com.ucpro.feature.setting.b.f.ai;
import com.ucpro.feature.setting.b.f.am;
import com.ucpro.feature.setting.b.f.an;
import com.ucpro.feature.setting.b.f.ao;
import com.ucpro.feature.setting.b.f.at;
import com.ucpro.feature.setting.b.f.au;
import com.ucpro.feature.setting.b.f.aw;
import com.ucpro.feature.setting.b.f.ax;
import com.ucpro.feature.setting.b.f.ay;
import com.ucpro.feature.setting.b.f.az;
import com.ucpro.feature.setting.b.f.bd;
import com.ucpro.feature.setting.b.f.be;
import com.ucpro.feature.setting.b.f.bf;
import com.ucpro.feature.setting.b.f.bg;
import com.ucpro.feature.setting.b.f.bi;
import com.ucpro.feature.setting.b.f.bj;
import com.ucpro.feature.setting.b.f.bo;
import com.ucpro.feature.setting.b.f.bp;
import com.ucpro.feature.setting.b.f.bq;
import com.ucpro.feature.setting.b.f.br;
import com.ucpro.feature.setting.b.f.bt;
import com.ucpro.feature.setting.b.f.bu;
import com.ucpro.feature.setting.b.f.bw;
import com.ucpro.feature.setting.b.f.by;
import com.ucpro.feature.setting.b.f.bz;
import com.ucpro.feature.setting.b.f.ca;
import com.ucpro.feature.setting.b.f.cb;
import com.ucpro.feature.setting.b.f.cc;
import com.ucpro.feature.setting.b.f.cg;
import com.ucpro.feature.setting.b.f.ch;
import com.ucpro.feature.setting.b.f.cj;
import com.ucpro.feature.setting.b.f.cl;
import com.ucpro.feature.setting.b.f.cn;
import com.ucpro.feature.setting.b.f.co;
import com.ucpro.feature.setting.b.f.cp;
import com.ucpro.feature.setting.b.f.cq;
import com.ucpro.feature.setting.b.f.cr;
import com.ucpro.feature.setting.b.f.f;
import com.ucpro.feature.setting.b.f.g;
import com.ucpro.feature.setting.b.f.h;
import com.ucpro.feature.setting.b.f.j;
import com.ucpro.feature.setting.b.f.k;
import com.ucpro.feature.setting.b.f.m;
import com.ucpro.feature.setting.b.f.o;
import com.ucpro.feature.setting.b.f.p;
import com.ucpro.feature.setting.b.f.r;
import com.ucpro.feature.setting.b.f.t;
import com.ucpro.feature.setting.b.f.v;
import com.ucpro.feature.setting.b.f.w;
import com.ucpro.feature.setting.b.f.x;
import com.ucpro.feature.setting.b.f.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class a extends e implements c {
    private com.ucpro.feature.setting.b.d.d.a c;
    private b d;
    private com.ucpro.feature.setting.b.b.a e;
    private HashMap<com.ucpro.feature.setting.b.b.a, com.ucpro.feature.setting.b.d.d.a> f = new HashMap(16);

    public a() {
        String d;
        if (com.ucpro.c.b.b()) {
            d = com.ucpro.ui.c.a.d((int) R.string.developer_option_window_title_debug);
        } else {
            d = com.ucpro.ui.c.a.d((int) R.string.developer_option_window_title_release);
        }
        this.e = new com.ucpro.feature.setting.b.b.a(d, com.ucpro.feature.setting.b.a.a.a);
        this.e.a(new com.ucpro.feature.setting.b.b.c("Show dev mode entry", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.a, new bo()));
        this.e.a(new com.ucpro.feature.setting.b.b.c("Version info", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new j()));
        com.ucpro.feature.setting.b.b.a aVar = this.e;
        d aVar2 = new com.ucpro.feature.setting.b.b.a("US", com.ucpro.feature.setting.b.a.a.a);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Use US Test Server", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new h()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Force update US", com.ucpro.feature.setting.b.a.a.a, new bt()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Force update Dispatcher", com.ucpro.feature.setting.b.a.a.a, new ad()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Aerie Request", com.ucpro.feature.setting.b.a.a.a, new co()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Ad Block Url", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new r()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Cp Params", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new com.ucpro.feature.setting.b.f.a()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Sn", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new cn()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Dn", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new cg()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("MWS", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new am()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("US server(https)", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new cq()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("US server(http)", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new f()));
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("VPS测试", com.ucpro.feature.setting.b.a.a.b);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("VPS服务器地址", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new w()));
        bd bdVar = new bd("http://www.bilibili.com/video/av1477799/", "normal");
        bd bdVar2 = new bd("http://v.youku.com/v_show/id_XMTc1MTQyNjYyNA==_ev_1.html?from=y11.3-idx-uhome-1519-20887.205902.1-1&x=1", "high");
        v.a(aVar2, "Bilibili", bdVar);
        v.a(aVar2, "Youku", bdVar2);
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("内存调试", com.ucpro.feature.setting.b.a.a.b);
        aVar2.a(new com.ucpro.feature.setting.b.b.b("触发GC", com.ucpro.feature.setting.b.a.a.b, new com.ucpro.feature.setting.b.f.e()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("查看当前的类实例个数", com.ucpro.feature.setting.b.a.a.b, new br()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("内存监控悬浮窗开关", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.a, new ch()));
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("内核调试", com.ucpro.feature.setting.b.a.a.b);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("是否开启T2 Route模式提示", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new bq()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("是否开启广告过滤", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.a, new by()));
        d aVar3 = new com.ucpro.feature.setting.b.b.a("Javascript注入调试", com.ucpro.feature.setting.b.a.a.b);
        aVar3.a(cl.a("T0"));
        aVar3.a(cl.a("T1"));
        aVar3.a(cl.a("T2"));
        aVar3.a(cl.a("T3"));
        aVar2.a(aVar3);
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("ApolloSo Test", com.ucpro.feature.setting.b.a.a.a);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Apollo version", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new ca()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Force update ApolloSo", com.ucpro.feature.setting.b.a.a.a, new ag()));
        aVar.a(aVar2);
        this.e.a(ab.a());
        this.e.a(new com.ucpro.feature.setting.b.b.b("扫一扫", com.ucpro.feature.setting.b.a.a.b, new cb()));
        this.e.a(new com.ucpro.feature.setting.b.b.b("进入隐私模式", com.ucpro.feature.setting.b.a.a.b, new bj()));
        aVar = this.e;
        com.ucpro.feature.g.a.a();
        aVar2 = new com.ucpro.feature.setting.b.b.a("Cloud sync test", com.ucpro.feature.setting.b.a.a.a);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("current ticket", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.c, new ah()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Enable cloudsync log", com.ucpro.feature.setting.b.a.a.a, com.ucpro.feature.setting.b.a.c.a, new p()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("是否使用测试服务器开关", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new bi()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("是否使用测试账号开关", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new cp()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("云同步日志展示", com.ucpro.feature.setting.b.a.a.b, new bw()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("进入云同步页面", com.ucpro.feature.setting.b.a.a.b, new aw()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Upload cloudsync logs", com.ucpro.feature.setting.b.a.a.a, new bp()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("set anchor to -1", com.ucpro.feature.setting.b.a.a.a, new o()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("云同步日志清除", com.ucpro.feature.setting.b.a.a.b, new g()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("从UC导入书签数据[单向]", com.ucpro.feature.setting.b.a.a.b, new ao()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("发起UC PRO同步[双向]", com.ucpro.feature.setting.b.a.a.b, new cr()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("数据库清零", com.ucpro.feature.setting.b.a.a.b, new at()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("查看书签数目", com.ucpro.feature.setting.b.a.a.b, new ax()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("随机添加一条书签", com.ucpro.feature.setting.b.a.a.b, new az()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("GET同步测试", com.ucpro.feature.setting.b.a.a.b, new bg()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Add同步测试[2条]", com.ucpro.feature.setting.b.a.a.b, new bz()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Add同步测试[612条分包]", com.ucpro.feature.setting.b.a.a.b, new be()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Del同步测试", com.ucpro.feature.setting.b.a.a.b, new cc()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Del同步测试[大量500]", com.ucpro.feature.setting.b.a.a.b, new t()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Edit同步测试", com.ucpro.feature.setting.b.a.a.b, new bu()));
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("Navigation sync test", com.ucpro.feature.setting.b.a.a.a);
        aVar2.a(new com.ucpro.feature.setting.b.b.b("导航同步[双向]", com.ucpro.feature.setting.b.a.a.b, new com.ucpro.feature.setting.b.f.b()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("数据库清零", com.ucpro.feature.setting.b.a.a.b, new m()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("查看导航数目", com.ucpro.feature.setting.b.a.a.b, new y()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("随机添加一条导航", com.ucpro.feature.setting.b.a.a.b, new ay()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("GET同步测试", com.ucpro.feature.setting.b.a.a.b, new bf()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Add同步测试[2条]", com.ucpro.feature.setting.b.a.a.b, new au()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Del同步测试", com.ucpro.feature.setting.b.a.a.b, new com.ucpro.feature.setting.b.f.d()));
        aVar2.a(new com.ucpro.feature.setting.b.b.b("Edit同步测试", com.ucpro.feature.setting.b.a.a.b, new cj()));
        aVar.a(aVar2);
        aVar = this.e;
        aVar2 = new com.ucpro.feature.setting.b.b.a("Download Setting", com.ucpro.feature.setting.b.a.a.a);
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Single task thread number, up to 64 threads", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new an()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Single thread flush block size, default 512kb", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new x()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("Single thread flush interval, default 2000ms", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new ai()));
        aVar2.a(new com.ucpro.feature.setting.b.b.c("是否使用读写分离", com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.b, new k()));
        aVar.a(aVar2);
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.bc == i) {
            com.ucpro.feature.setting.b.b.a aVar;
            if (message.obj == null) {
                aVar = this.e;
            } else {
                aVar = (com.ucpro.feature.setting.b.b.a) message.obj;
            }
            if (this.f.containsKey(aVar)) {
                this.c = (com.ucpro.feature.setting.b.d.d.a) this.f.get(aVar);
            } else {
                this.c = new com.ucpro.feature.setting.b.d.d.a(this.b, aVar, this);
                this.f.put(aVar, this.c);
            }
            this.c.a();
            a(this.c);
        } else if (com.ucpro.base.a.e.bd == i) {
            String str = (String) message.obj;
            if (this.d == null) {
                this.d = new b(this.b, this);
            }
            b bVar = this.d;
            if (bVar.e != null) {
                bVar.e.a(str, null);
                bVar.e.a();
            }
            a(this.d);
        }
    }

    public final void b(int i, Message message) {
        if (com.ucpro.base.a.j.f == i && this.f != null && !this.f.isEmpty()) {
            Iterator it = this.f.entrySet().iterator();
            do {
                ((com.ucpro.feature.setting.b.d.d.a) ((Entry) it.next()).getValue()).l();
            } while (it.hasNext());
        }
    }

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
    }

    public final void d() {
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void e() {
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof com.ucpro.feature.setting.b.d.d.a) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final String a(int i) {
        return null;
    }

    public final boolean b(int i) {
        return false;
    }

    private void a(com.ucpro.base.c.b.g gVar) {
        this.a.b().a(gVar, true);
    }

    public final View a(View view) {
        return this.a.b().b(this.a.b().a());
    }
}
