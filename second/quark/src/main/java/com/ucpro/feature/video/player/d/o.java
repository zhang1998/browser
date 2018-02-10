package com.ucpro.feature.video.player.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.n;
import com.ucpro.feature.video.player.b.r;
import com.ucpro.feature.video.player.b.s;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.q;
import com.ucpro.feature.video.player.view.ah;
import com.ucpro.feature.video.player.view.k;
import java.util.List;

/* compiled from: ProGuard */
public final class o extends q<g> {
    public FrameLayout a = new FrameLayout(this.q);
    ImageView b;
    public k c;
    public ah d;
    d e = null;
    j f = null;

    public o(Context context, g gVar, a aVar) {
        super(context, gVar, aVar);
        this.a.setId(2);
        this.b = new ImageView(this.q);
        this.b.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_mini_center_play_bg.xml"));
        this.b.setId(5);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.player_mini_center_play_btn_padding);
        this.b.setPadding(c, c, c, c);
        this.b.setOnClickListener(new n(this));
        c = com.ucpro.ui.c.a.c((int) R.dimen.player_mini_center_play_btn_width);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
        layoutParams.gravity = 17;
        this.a.addView(this.b, layoutParams);
        this.c = new k(this.q, this, this.r);
        this.c.a.setId(10);
        layoutParams = new FrameLayout.LayoutParams(-1, (int) com.ucpro.ui.c.a.a((int) R.dimen.player_topbar_height));
        layoutParams.gravity = 80;
        this.a.addView(this.c.a, layoutParams);
        this.d = new ah(this.q, this.p, this.r, false);
        this.d.a.setId(47);
        this.d.a.setVisibility(4);
        this.a.addView(this.d.a, new FrameLayout.LayoutParams(-1, -1));
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return this.p.a(i, bVar, bVar2);
    }

    public final boolean b(int i, b bVar, b bVar2) {
        switch (i) {
            case 12:
                return true;
            default:
                return false;
        }
    }

    protected final void a(List<Class<?>> list) {
        list.add(s.class);
        list.add(r.class);
        list.add(n.class);
    }

    protected final void a(h<g> hVar) {
        hVar.a(10).b(s.HoverOff.c, r.f, n.g).a(new g(false, null)).b(s.HoverOn.c, r.f, n.g).a(new g(true, null)).a(5).b(s.HoverOff.c, r.f, n.g).a(new g(false, null)).b(s.HoverOn.c, r.Playing.e, n.g).a(new g(true, "new_video_pause.svg")).b(s.HoverOn.c, r.Playing.e ^ -1, n.g).a(new g(true, "new_video_play.svg")).a(47).b(s.d, r.f, n.MoreList.f).a(new g(true, null)).b(s.d, r.f, n.MoreList.f ^ -1).a(new g(false, null));
        hVar.a(new m(this));
    }
}
