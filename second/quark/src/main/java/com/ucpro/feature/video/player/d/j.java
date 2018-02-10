package com.ucpro.feature.video.player.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.n;
import com.ucpro.feature.video.player.b.r;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.q;
import com.ucpro.feature.video.player.view.s;
import java.util.List;

/* compiled from: ProGuard */
public final class j extends q<i> {
    public FrameLayout a;
    ImageView b;
    s c;
    d d = null;
    com.ucpro.feature.video.player.a.j e = null;
    private int f = 0;

    public j(Context context, g gVar, a aVar, int i) {
        super(context, gVar, aVar);
        this.f = i;
        this.a = new FrameLayout(this.q);
        this.a.setId(2);
        this.b = new ImageView(this.q);
        this.b.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_mini_center_play_bg.xml"));
        this.b.setId(5);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.player_mini_center_play_btn_padding);
        this.b.setPadding(c, c, c, c);
        this.b.setOnClickListener(new f(this));
        c = com.ucpro.ui.c.a.c((int) R.dimen.player_mini_center_play_btn_width);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
        layoutParams.gravity = 17;
        this.a.addView(this.b, layoutParams);
        this.c = new s(this.q, this, this.r, this.f);
        this.c.a.setId(10);
        layoutParams = new FrameLayout.LayoutParams(-1, (int) com.ucpro.ui.c.a.a((int) R.dimen.player_topbar_height));
        layoutParams.gravity = 80;
        this.a.addView(this.c.a, layoutParams);
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
        list.add(com.ucpro.feature.video.player.b.s.class);
        list.add(r.class);
        list.add(n.class);
    }

    protected final void a(h<i> hVar) {
        hVar.a(10).b(com.ucpro.feature.video.player.b.s.HoverOff.c, r.f, n.g).a(new i(false, null)).b(com.ucpro.feature.video.player.b.s.HoverOn.c, r.f, n.g).a(new i(true, null)).a(5).b(com.ucpro.feature.video.player.b.s.HoverOff.c, r.f, n.g).a(new i(false, null)).b(com.ucpro.feature.video.player.b.s.HoverOn.c, r.Playing.e, n.g).a(new i(true, "new_video_pause.svg")).b(com.ucpro.feature.video.player.b.s.HoverOn.c, r.Playing.e ^ -1, n.g).a(new i(true, "new_video_play.svg"));
        hVar.a(new k(this));
    }
}
