package com.uc.sync.e;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.impl.SettingsConst;
import com.uc.sync.c.b.a;
import com.uc.sync.f.f;
import com.uc.sync.f.h;
import com.uc.sync.f.j;
import com.uc.sync.f.l;
import com.uc.sync.f.o;
import com.ucweb.common.util.c;
import com.ucweb.common.util.e;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class g extends d {
    ArrayList<l> m = new ArrayList();
    a n;
    private int o = 0;
    private e p;

    public g(int i, a aVar) {
        super(i);
        this.n = aVar;
        c.a(this.n);
        com.uc.sync.c.a.h();
        if (com.uc.sync.c.a.j()) {
            com.uc.sync.d.a.a("GeneralCloudSyncManager构建：业务：" + i);
        }
        h a = h.a();
        int i2 = this.e;
        synchronized (a.c) {
            if (((com.uc.sync.f.a) a.c.get(i2)) == null) {
                a.c.put(i2, new com.uc.sync.f.a(this));
            }
        }
        this.p = new c(this, "SyncBusinessLooper-" + this.e, this.n.a().getLooper());
    }

    private int a(o oVar, ArrayList<l> arrayList) {
        this.m.clear();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (!com.ucweb.common.util.n.a.a(lVar.e)) {
                if (i >= 2048) {
                    this.m.add(lVar);
                } else {
                    i++;
                    lVar.c(0);
                    lVar.b = 2;
                    oVar.a(lVar);
                }
            }
        }
        return i;
    }

    private static void a(o oVar) {
        if (h.a().a(oVar)) {
            h.a().b();
        } else {
            Log.e("hjw-sync", "添加task失败");
        }
    }

    private int b(o oVar, ArrayList<l> arrayList) {
        int i;
        int i2 = 0;
        int i3;
        int i4;
        int i5;
        int i6;
        if (arrayList == null || arrayList.size() <= 0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i = 0;
            com.uc.sync.d.a.a("本同步请求包含 删除任务=" + i6 + ",增加任务" + i5 + ",GET任务=" + i4 + ",移动任务=" + i3 + ",替换任务=" + i2);
        } else {
            l lVar;
            Iterator it = arrayList.iterator();
            int i7 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i = 0;
            while (it.hasNext()) {
                lVar = (l) it.next();
                i++;
                if (i > 2048) {
                    this.l = (int) lVar.j;
                    com.uc.sync.d.a.a("数据超过2048条，到达最大分包大小，本次luid 基数为：" + ((int) lVar.j));
                    com.uc.sync.d.a.a("本同步请求包含 删除任务=" + i6 + ",增加任务" + i5 + ",GET任务=" + i4 + ",移动任务=" + i3 + ",替换任务=" + i7);
                    break;
                }
                oVar.a(lVar);
                com.uc.sync.d.a.a("向task里面增加ClouSyncContent，luid=" + lVar.j + ", 类型是（增0删1Get2替3移4）：" + lVar.b);
                if (lVar.b == 1) {
                    i6++;
                } else if (lVar.b == 0) {
                    i5++;
                } else if (lVar.b == 2) {
                    i4++;
                } else if (lVar.b == 4) {
                    i3++;
                } else {
                    if (lVar.b == 3) {
                        i2 = i7 + 1;
                    } else {
                        i2 = i7;
                    }
                    i7 = i2;
                }
            }
            lVar = (l) arrayList.get(arrayList.size() - 1);
            this.l = (int) lVar.j;
            com.uc.sync.d.a.a("同步请求包含命令" + oVar.b().size() + "个，本次luid 基数为：" + lVar.j);
            i2 = i7;
            com.uc.sync.d.a.a("本同步请求包含 删除任务=" + i6 + ",增加任务" + i5 + ",GET任务=" + i4 + ",移动任务=" + i3 + ",替换任务=" + i2);
        }
        return i;
    }

    private void d(int i) {
        if (this.a) {
            this.n.a(i);
        }
    }

    public final void a(j jVar) {
        com.uc.sync.d.a.a("onCloudSyncResult:" + jVar);
        e();
        com.uc.sync.d.a.a("mIsAccountLogin:" + this.a);
        if (jVar == null || !this.a) {
            b(0);
            return;
        }
        int i = jVar.b;
        com.uc.sync.d.a.a("retCode:" + i);
        if (i == 2320) {
            d();
        } else if (i == 2331) {
            com.uc.sync.d.a.a("强制慢同步开始");
            if (this.a) {
                this.n.a(-1);
            }
            d();
        } else if (i != 2200) {
            if (i == 1 || this.g != 1 || i == SecExceptionCode.SEC_ERROR_SECURITYBODY_INVALID_PARAM) {
                b(i);
            } else {
                d();
            }
        } else if (jVar.j) {
            com.uc.sync.d.a.a("返回: check型，锚 = " + jVar.c);
            r0 = Message.obtain();
            r0.what = 5;
            r0.obj = jVar;
            this.p.sendMessage(r0);
        } else {
            com.uc.sync.d.a.a("返回: 非check的型，锚 = " + jVar.c);
            r0 = Message.obtain();
            r0.what = 6;
            r0.obj = jVar;
            this.p.sendMessage(r0);
        }
    }

    public final Looper f() {
        return this.n.a().getLooper();
    }

    public final void g() {
        this.a = true;
    }

    public final void h() {
        this.a = false;
        this.b = 0;
        this.m.clear();
        this.n.a(-1);
        h.a().a(this.e);
    }

    private int i() {
        return this.n.g();
    }

    public final void b(int i) {
        this.b = 0;
        this.h.a(this.e, this.g, 102, i);
    }

    public final void c(int i) {
        if (b()) {
            com.uc.sync.d.a.a("任务重复，直接退出");
        } else if (!this.a) {
            this.h.a(a(), this.g, 105, 0);
        } else if (this.b == 1) {
            com.uc.sync.d.a.a("正在同步" + this.e + "数据，请稍后再触发");
        } else {
            this.f = i;
            this.b = 1;
            this.d = System.currentTimeMillis();
            this.o = 0;
            this.g = 1;
            if (this.f == 1) {
                com.uc.sync.d.a.a("消息发出。。。");
                this.p.sendEmptyMessageDelayed(1, 0);
            } else {
                c.a("同步类型" + this.f + "暂不支持");
            }
            this.h.a(a(), this.g, 103, 0);
            com.uc.sync.c.a.h();
            if (com.uc.sync.c.a.j()) {
                PrintStream printStream = System.out;
            }
        }
    }

    static /* synthetic */ void a(g gVar) {
        com.uc.sync.d.a.a("<开始云同步----业务：" + gVar.e + "--同步类型：" + gVar.f + "---->");
        int i = gVar.i();
        com.uc.sync.d.a.a("正常双向同步触发，当前anchor为=" + i);
        if (i < 0) {
            o a = gVar.a(-1);
            c.b(a.a());
            com.uc.sync.d.a.a("anchor值小于0，生成慢同步task");
            Object a2 = f.a.a(a.a);
            c.a(a2);
            a2 = a2.a(a2.f());
            c.a(a2);
            f fVar = new f(9);
            fVar.e = a2.l_();
            a.l = fVar;
            a(a);
            return;
        }
        a = gVar.a(i);
        c.c(a.a());
        gVar.l = 0;
        ArrayList a3 = gVar.n.a(0, 512);
        com.uc.sync.d.a.a("客户端增量数据列表size=" + a3.size());
        gVar.b(a, a3);
        a(a);
    }

    static /* synthetic */ void a(g gVar, j jVar) {
        c.a((Object) jVar);
        com.uc.sync.d.a.a("check返回处理：handleRecvCheckCommand");
        ArrayList arrayList = jVar.l;
        ArrayList a = gVar.n.a(arrayList);
        com.uc.sync.d.a.a("check返回处理：服务端Check下来的列表size：" + arrayList.size());
        com.uc.sync.d.a.a("check返回处理：需要发起GET的条目的size是：" + a.size());
        o a2 = gVar.a(jVar.c);
        com.uc.sync.d.a.a("check返回处理：下发anchor值为 : " + jVar.c);
        gVar.l = 0;
        if (a.size() > 0) {
            gVar.a(a2, a);
            if (gVar.a) {
                a2.h = 1;
                a(a2);
                com.uc.sync.d.a.a("check返回处理：生成get列表，发送GET请求...");
                return;
            }
            return;
        }
        com.uc.sync.d.a.a("check返回处理：check发现，无需要进行get的元素，进行上行同步");
        gVar.b(a2, gVar.n.a(0, 2048));
        if (gVar.a) {
            a2.h = 1;
            a(a2);
            com.uc.sync.d.a.a("check返回处理：无需发送GET请求...");
        }
    }

    static /* synthetic */ void b(g gVar, j jVar) {
        c.a((Object) jVar);
        com.uc.sync.d.a.a("===============handleSyncSuccess 开始===================");
        com.uc.sync.d.a.a("同步类型：" + gVar.f);
        gVar.n.b();
        ArrayList arrayList = jVar.l;
        com.uc.sync.d.a.a("非check返回处理：cmd的返回值，列表size：" + arrayList.size());
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            l a;
            l lVar = (l) it.next();
            int i2 = i + 1;
            com.uc.sync.d.a.a("非check返回处理：index=" + i + ",单条回复的返回码：" + lVar.a());
            if (lVar.a() >= 3500) {
                i = i2;
            } else if (gVar.a) {
                g gVar2;
                int d = lVar.d();
                if (d == 2) {
                    gVar.n.b(lVar);
                    a = gVar.n.a(lVar.b());
                    if (a == null) {
                        lVar.c(2);
                        com.uc.sync.d.a.a("处理get指令，addSyncItem()");
                        gVar.n.c(lVar);
                        i = i2;
                    } else {
                        gVar.n.b(a, lVar);
                        a.e = lVar.e;
                        a.b = -1;
                        a.c(2);
                        com.uc.sync.d.a.a("处理get指令，updateSyncItem()");
                        lVar = a;
                        gVar2 = gVar;
                    }
                } else {
                    a = gVar.n.a(lVar.j);
                    if (a != null) {
                        if (d == 0) {
                            com.uc.sync.d.a.a("处理add指令");
                            a.e = lVar.e;
                            if (gVar.n.d(a, lVar)) {
                                com.uc.sync.d.a.a("若用户修改了数据，则只更新guid，同时修改状态为未同步");
                                a.c(0);
                            } else {
                                a.c(2);
                            }
                            gVar.n.d(a);
                            i = i2;
                        } else if (d == 1) {
                            com.uc.sync.d.a.a("处理del指令");
                            arrayList = new ArrayList();
                            arrayList.add(Long.valueOf(a.j));
                            gVar.n.b(arrayList);
                            i = i2;
                        } else if (d == 4 || d == 3) {
                            com.uc.sync.d.a.a("处理move/replace指令");
                            if (gVar.n.d(a, lVar)) {
                                a.c(0);
                                lVar = a;
                                gVar2 = gVar;
                            } else {
                                a.c(2);
                                lVar = a;
                                gVar2 = gVar;
                            }
                        }
                    }
                    i = i2;
                }
                gVar2.n.d(lVar);
                i = i2;
            } else {
                return;
            }
        }
        arrayList = jVar.m;
        com.uc.sync.d.a.a("返回：服务端的同步下发指令，列表size：" + arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            lVar = (l) it2.next();
            if (lVar.a() < 3500) {
                if (gVar.a) {
                    i = lVar.d();
                    if (i == 0) {
                        if (!com.ucweb.common.util.n.a.a(lVar.e)) {
                            a = gVar.n.a(lVar.b());
                            if (a == null) {
                                gVar.n.b(lVar);
                                lVar.c(2);
                                lVar.j = gVar.n.c(lVar);
                            } else {
                                a.e = lVar.e;
                                a.c(0);
                                a.b = 4;
                                gVar.n.d(a);
                            }
                        }
                    } else if (i == 1) {
                        lVar = gVar.n.b(lVar.e);
                        if (lVar != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(Long.valueOf(lVar.j));
                            gVar.n.b(arrayList2);
                        }
                    } else if (i == 4 || i == 3) {
                        l b = gVar.n.b(lVar.e);
                        if (b != null) {
                            if ((b.i() > 0 ? 1 : 0) == 0) {
                                if (lVar.d() == 3) {
                                    gVar.n.b(lVar);
                                    gVar.n.a(b, lVar);
                                } else {
                                    gVar.n.c(b, lVar);
                                }
                                gVar.n.d(b);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
        gVar.n.c();
        if (jVar.f == 1) {
            o a2;
            int i3;
            com.uc.sync.d.a.a("返回处理：已经是最后一个接收包，是否还没有没发完的包？");
            if (gVar.m.size() > 0) {
                a2 = gVar.a(jVar.c);
                a2.h = 1;
                gVar.a(a2, (ArrayList) gVar.m.clone());
                if (gVar.a) {
                    h.a().a(a2);
                    h.a().b();
                    i3 = 1;
                    if (i3 == 0) {
                        com.uc.sync.d.a.a("返回处理：慢同步GET请求未发完，继续发");
                    } else {
                        if (jVar.c >= 0 && gVar.a) {
                            com.uc.sync.d.a.a("返回处理：GET请求发完，更新同步锚>");
                            gVar.d(jVar.c);
                        }
                        gVar.o++;
                        if (gVar.o <= 20) {
                            gVar.o = 0;
                            i3 = 0;
                        } else {
                            arrayList = gVar.n.a(gVar.l, 2048);
                            if (arrayList.size() > 0) {
                                a2 = gVar.a(gVar.i());
                                a2.h = 1;
                                gVar.b(a2, arrayList);
                                if (gVar.a) {
                                    a(a2);
                                    i3 = 1;
                                }
                            }
                            i3 = 0;
                        }
                        if (i3 == 0) {
                            com.uc.sync.d.a.a("返回处理：没发完的快同步上行已发送");
                        } else {
                            gVar.l = 0;
                            gVar.b = 0;
                            gVar.h.a(gVar.e, gVar.g, 101, jVar.b);
                            com.uc.sync.d.a.a("服务端包发送结束," + gVar.e + "状态置为STATE_IDLE");
                        }
                    }
                } else {
                    gVar.m.clear();
                }
            }
            i3 = 0;
            if (i3 == 0) {
                com.uc.sync.d.a.a("返回处理：GET请求发完，更新同步锚>");
                gVar.d(jVar.c);
                gVar.o++;
                if (gVar.o <= 20) {
                    arrayList = gVar.n.a(gVar.l, 2048);
                    if (arrayList.size() > 0) {
                        a2 = gVar.a(gVar.i());
                        a2.h = 1;
                        gVar.b(a2, arrayList);
                        if (gVar.a) {
                            a(a2);
                            i3 = 1;
                        }
                    }
                    i3 = 0;
                } else {
                    gVar.o = 0;
                    i3 = 0;
                }
                if (i3 == 0) {
                    gVar.l = 0;
                    gVar.b = 0;
                    gVar.h.a(gVar.e, gVar.g, 101, jVar.b);
                    com.uc.sync.d.a.a("服务端包发送结束," + gVar.e + "状态置为STATE_IDLE");
                } else {
                    com.uc.sync.d.a.a("返回处理：没发完的快同步上行已发送");
                }
            } else {
                com.uc.sync.d.a.a("返回处理：慢同步GET请求未发完，继续发");
            }
        } else {
            com.uc.sync.d.a.a("服务端还有分包，继续处理分包");
            o a3 = gVar.a(jVar.c);
            a3.j = jVar.d;
            a3.i = jVar.e;
            a3.h = jVar.f;
            if (jVar.e * 2048 > 40960) {
                gVar.b = 0;
                if (jVar.c > 0) {
                    gVar.d(jVar.c);
                }
                gVar.h.a(gVar.a(), gVar.g, 101, SettingsConst.STRING_INFO);
            } else if (gVar.a) {
                a(a3);
            }
        }
        com.uc.sync.d.a.a("handleSyncSuccess lastest : " + jVar.f);
        com.uc.sync.d.a.a("handleSyncSuccess anchor= " + jVar.c);
        com.uc.sync.d.a.a("handleSyncSuccess seq no = " + jVar.e);
        com.uc.sync.d.a.a("handleSyncSuccess session = " + jVar.d);
        com.uc.sync.d.a.a("===============handleSyncSuccess 结束===================");
    }
}
