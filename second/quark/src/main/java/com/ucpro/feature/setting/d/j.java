package com.ucpro.feature.setting.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.c.d;
import com.ucpro.feature.setting.a.a.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class j implements OnClickListener, c {
    private f a;
    private List<a> b = new ArrayList();

    public j(f fVar) {
        this.a = fVar;
        fVar.setPresenter(this);
    }

    public final void c() {
        Object obj = new Object[3];
        obj[0] = d.b() ? "quarklab/en-us/laboratory_notice" : "quarklab/zh-cn/laboratory_notice";
        obj[1] = com.ucpro.ui.c.a.d((int) R.string.quark_lab_list_footer_text2);
        obj[2] = Boolean.valueOf(true);
        g.a().b(e.bj, obj);
        m.a("quark_lab", com.ucpro.feature.k.a.d, new String[0]);
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            if (aVar == this.b.get(0)) {
                g.a().b(e.bj, new Object[]{"https://broccoli.uc.cn/apps/H1H9YAIyz/routes/index?entry=a", com.ucpro.ui.c.a.d((int) R.string.quark_lab_doodle_title)});
                m.a("quark_lab", com.ucpro.feature.k.a.b, new String[0]);
            } else if (aVar == this.b.get(1)) {
                g.a().a(e.aZ);
                m.a("quark_lab", com.ucpro.feature.k.a.a, new String[0]);
            } else if (aVar == this.b.get(2)) {
                g.a().b(e.bj, new Object[]{"https://broccoli.uc.cn/apps/quarkfnintroduce/routes/collect", com.ucpro.ui.c.a.d((int) R.string.quark_lab_collect_title)});
                m.a("quark_lab", com.ucpro.feature.k.a.c, new String[0]);
            }
        }
    }

    public final void a() {
        a aVar = new a();
        aVar.d = "lab_doodle.png";
        aVar.b = com.ucpro.ui.c.a.d((int) R.string.quark_lab_doodle_title);
        aVar.c = com.ucpro.ui.c.a.d((int) R.string.quark_lab_doodle_subtitle);
        this.b.add(aVar);
        aVar = new a();
        aVar.d = "lab_wallper.png";
        aVar.b = com.ucpro.ui.c.a.d((int) R.string.quark_lab_wallper_title);
        aVar.c = com.ucpro.ui.c.a.d((int) R.string.quark_lab_wallper_subtitle);
        this.b.add(aVar);
        aVar = new a();
        aVar.d = "lab_collect.png";
        aVar.b = com.ucpro.ui.c.a.d((int) R.string.quark_lab_collect_title);
        aVar.c = com.ucpro.ui.c.a.d((int) R.string.quark_lab_collect_subtitle);
        this.b.add(aVar);
        this.a.getListView().setAdapter(new i());
    }

    public final void b() {
        for (int i = 0; i < this.b.size(); i++) {
            if (((a) this.b.get(i)).a != null) {
                ((a) this.b.get(i)).a.recycle();
            }
        }
        this.b.clear();
    }
}
