package com.ucpro.feature.downloadpage.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.quark.h;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.video.cache.b.d;
import com.ucpro.feature.video.cache.e.a.c;
import com.ucpro.feature.video.d.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.f;
import com.ucpro.ui.g.m;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class t extends bd<p> implements h, r, c, b {
    Context c;
    List<com.ucpro.feature.video.cache.db.bean.b> d = new ArrayList();
    w e;
    m f;

    public final /* synthetic */ void a(bh bhVar, int i) {
        p pVar = (p) bhVar;
        Object obj = (com.ucpro.feature.video.cache.db.bean.b) this.d.get(i);
        com.ucweb.common.util.c.a(obj);
        new StringBuilder("正在生成第").append(i).append("个item");
        a.a();
        pVar.n = obj.a.longValue();
        pVar.m = i;
        pVar.l.setPosition(i);
        pVar.l.setTag(pVar);
        pVar.l.setTitle(obj.c);
        new StringBuilder("第").append(i).append("个item Status:").append(obj.f).append(", sofarbytes=").append(obj.b()).append(", sofartscount=").append(obj.f()).append(", totaltscount=").append(obj.e());
        a.a();
        String str;
        long b;
        long f;
        if (obj.e == 1) {
            new StringBuilder("第").append(i).append("个item是m3u8类型");
            a.a();
            str = obj.f;
            b = obj.b();
            f = (long) obj.f();
            long e = (long) obj.e();
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("init")) {
                    pVar.l.setProgress(0.0f);
                    pVar.l.setTextProgress("正在连接");
                } else if (str.equals("ts_downloading") || str.equals("ts_paused")) {
                    r1 = (e <= 0 ? 0.0f : ((float) f) / ((float) e)) * 100.0f;
                    pVar.l.setProgress(r1);
                    pVar.l.setTextProgress(f + "/" + e + "  已下载" + com.ucpro.base.system.b.a.a(b) + " " + (((float) Math.round(r1 * 10.0f)) / 10.0f) + "%");
                } else if (str.equals("ts_successed")) {
                    pVar.l.setProgress(100.0f);
                    pVar.l.setTextProgress(f + "/" + e + "  共" + com.ucpro.base.system.b.a.a(b) + " 100.0%");
                } else if (str.equals("meata_data_failed")) {
                    pVar.l.setProgress(0.0f);
                    pVar.l.setTextProgress("连接失败");
                } else if (str.equals("ts_failed")) {
                    if (e <= 0) {
                        r1 = 0.0f;
                    } else {
                        r1 = ((float) f) / ((float) e);
                    }
                    pVar.l.setProgress(r1 * 100.0f);
                    pVar.l.setTextProgress(f + "/" + e + "  已下载" + com.ucpro.base.system.b.a.a(b));
                }
            }
            String str2 = obj.f;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals("init")) {
                    n nVar = pVar.l;
                    nVar.b();
                    if (nVar.a != b.a) {
                        nVar.setProgressDrawable$3cf8fc87(b.a);
                    }
                    nVar.setStatus$437ed75e(d.a);
                } else if (str2.equals("ts_downloading")) {
                    pVar.l.c();
                } else if (str2.equals("ts_successed")) {
                    pVar.l.d();
                } else if (str2.equals("ts_paused")) {
                    pVar.l.e();
                } else if (str2.equals("meata_data_failed")) {
                    pVar.l.a("种子无效");
                } else if (str2.equals("ts_failed")) {
                    pVar.l.a("片段无法下载");
                }
            }
        } else if (obj.e == 0) {
            new StringBuilder("第").append(i).append("个item是普通视频类型");
            a.a();
            str = obj.f;
            b = obj.b();
            f = obj.c();
            int d = obj.d();
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("init")) {
                    pVar.l.a();
                    pVar.l.setStatusText("准备缓存...");
                    pVar.l.setProgress(((f <= 0 ? 0.0f : ((float) b) / ((float) f)) * 100.0f) * 100.0f);
                    pVar.l.setTextProgress(com.ucpro.base.system.b.a.a(b) + "/" + com.ucpro.base.system.b.a.a(f));
                    pVar.l.a();
                } else if (str.equals("ts_downloading")) {
                    pVar.l.c();
                    pVar.l.setProgress((f <= 0 ? 0.0f : ((float) b) / ((float) f)) * 100.0f);
                    pVar.l.setTextProgress(com.ucpro.base.system.b.a.a(b) + "/" + com.ucpro.base.system.b.a.a(f));
                    pVar.l.setStatusText(com.ucpro.base.system.b.a.a((long) (d * 1024)) + "/s");
                } else if (str.equals("ts_paused")) {
                    pVar.l.setProgress((f <= 0 ? 0.0f : ((float) b) / ((float) f)) * 100.0f);
                    pVar.l.setTextProgress(com.ucpro.base.system.b.a.a(b) + "/" + com.ucpro.base.system.b.a.a(f));
                    pVar.l.setStatusText(com.ucpro.ui.c.a.d((int) R.string.download_pause));
                    pVar.l.e();
                } else if (str.equals("ts_successed")) {
                    float f2;
                    if (f <= 0) {
                        f2 = 0.0f;
                    } else {
                        f2 = ((float) b) / ((float) f);
                    }
                    pVar.l.setProgress((f2 * 100.0f) * 100.0f);
                    pVar.l.setTextProgress(com.ucpro.base.system.b.a.a(b) + "/" + com.ucpro.base.system.b.a.a(f));
                    pVar.l.setStatusText("缓存完成");
                    pVar.l.d();
                } else if (str.equals("ts_failed")) {
                    pVar.l.setProgress((f <= 0 ? 0.0f : ((float) b) / ((float) f)) * 100.0f);
                    pVar.l.a("下载失败");
                }
            }
        }
    }

    public t(Context context) {
        this.c = context;
        x.a(d.a());
        com.ucpro.feature.video.cache.db.b.b().a((c) this);
    }

    public final int a() {
        return this.d.size();
    }

    @DebugLog
    public final void c_(int i) {
        com.ucpro.feature.video.cache.db.bean.b bVar = (com.ucpro.feature.video.cache.db.bean.b) this.d.get(i);
        if (this.e != null && bVar != null) {
            new Thread(new k(this, bVar)).start();
        }
    }

    final void a(@NonNull com.ucpro.feature.video.cache.db.bean.b bVar) {
        new Handler(Looper.getMainLooper()).post(new c(this, bVar));
    }

    public final void b(int i) {
        com.ucpro.ui.contextmenu.d a = f.a().a(this.c);
        a.c();
        a.a(com.ucpro.ui.c.a.d((int) R.string.m3u8_delete_record), 110001);
        a.a(com.ucpro.ui.c.a.d((int) R.string.m3u8_delete_record_and_file), 110002);
        a.a(Integer.valueOf(i));
        f.a().a(this.c, (b) this);
    }

    public final void d() {
    }

    public final void e() {
    }

    @DebugLog
    public final void a(com.ui.edittext.c cVar, Object obj) {
        if ((obj instanceof Integer) && cVar != null) {
            com.ucpro.feature.video.cache.db.bean.b bVar;
            int intValue = ((Integer) obj).intValue();
            try {
                bVar = (com.ucpro.feature.video.cache.db.bean.b) this.d.get(intValue);
            } catch (Exception e) {
                bVar = null;
            }
            if (bVar != null) {
                switch (cVar.a) {
                    case 110001:
                        a.a();
                        if (this.e != null) {
                            this.e.a(bVar);
                            this.d.remove(intValue);
                            this.a.a();
                            return;
                        }
                        return;
                    case 110002:
                        a.a();
                        if (this.e != null) {
                            this.e.b(bVar);
                            this.d.remove(intValue);
                            this.a.a();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (sVar.n()) {
            g.a().a(e.A);
        }
    }

    public final void w_() {
        g.a().a(e.A);
        a.a();
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        n nVar = new n(this.c);
        nVar.setLayoutParams(new LayoutParams(-1, -2));
        nVar.setListener(this);
        return new p(nVar, this);
    }
}
