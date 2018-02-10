package com.uc.weex;

import com.taobao.android.binding.core.eb;
import com.taobao.android.binding.core.ec;
import com.taobao.weex.common.h;
import com.taobao.weex.q;
import com.uc.weex.component.c.b;
import com.uc.weex.component.e.n;
import com.uc.weex.component.e.p;
import com.uc.weex.component.h.c;
import com.uc.weex.component.h.d;
import com.uc.weex.component.h.f;
import com.uc.weex.component.h.g;
import com.uc.weex.component.h.k;
import com.uc.weex.component.h.l;
import com.uc.weex.component.h.m;
import com.uc.weex.component.h.r;
import com.uc.weex.component.h.s;
import com.uc.weex.component.h.w;
import com.uc.weex.component.j;
import com.uc.weex.component.richtext.aa;
import com.uc.weex.g.e;

/* compiled from: ProGuard */
public abstract class a implements d {
    public void a() throws h {
        q.a("uc-surface", r.class, false);
        q.a("uc-group", g.class, false);
        q.a("uc-rectangle", d.class, false);
        q.a("uc-shape", com.uc.weex.component.h.q.class, false);
        q.a("uc-svgtext", w.class, false);
        q.a("uc-circle", c.class, false);
        q.b("uc-surface", s.class);
        q.a("uc-rect", m.class, false);
        q.a("uc-ellipse", f.class, false);
        q.a("uc-line", com.uc.weex.component.h.h.class, false);
        q.a("uc-polygon", k.class, false);
        q.a("uc-polyline", l.class, false);
        q.b("uc-event", e.class, true);
        q.b("uc-modal", com.uc.weex.g.h.class, true);
        q.a("uc-viewpager", com.uc.weex.component.k.d.class, false);
        q.a("uc-pager-item", com.uc.weex.component.k.a.class, false);
        q.b("uc-pager-item", com.uc.weex.component.k.c.class);
        q.a("uc-list", b.class, false);
        q.a("uc-scroller", com.uc.weex.component.g.c.class, false);
        q.a("uc-rich-text", com.uc.weex.component.richtext.w.class, false);
        q.b("uc-rich-text", aa.class);
        q.b("uc-dom", com.uc.weex.g.b.class, true);
        q.a("uc-loading", com.uc.weex.component.d.a.class, false);
        q.a("uc-img", com.uc.weex.component.b.b.class, false);
        q.a("uc-video", com.uc.weex.component.j.c.class, false);
        q.a("uc-pull2refresh", com.uc.weex.component.f.d.class, false);
        q.a("uc-header", com.uc.weex.component.f.a.class, false);
        q.a("parallax", j.class, false);
        q.a("uc-nav", com.uc.weex.component.e.l.class, false);
        q.a("uc-scene", n.class, false);
        q.b("uc-nav", com.uc.weex.component.e.m.class, true);
        q.b("uc-scene", p.class);
        q.a("uc-device", com.uc.weex.g.l.class);
        q.a("expressionBinding", eb.class);
        q.a("binding", ec.class);
    }
}
