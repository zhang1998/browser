package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.p;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.n;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.q;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
public final class af extends q<Boolean> {
    public FrameLayout a;
    LinearLayout b;
    LinearLayout c;
    public ah d;

    static /* synthetic */ void a(af afVar, ViewGroup viewGroup, boolean z) {
        e f = afVar.r.f();
        if (f != null) {
            String str = f.w;
            List list = f.x;
            if (list == null) {
                return;
            }
            String str2;
            if (viewGroup.getChildCount() != list.size()) {
                viewGroup.removeAllViews();
                LayoutParams layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.media_quality_menu_text_width), a.c((int) R.dimen.media_quality_menu_text_height));
                for (int size = list.size() - 1; size >= 0; size--) {
                    str2 = (String) list.get(size);
                    CharSequence a = p.a(str2, true);
                    if (!TextUtils.isEmpty(a)) {
                        View aTTextView = new ATTextView(afVar.q);
                        aTTextView.setGravity(17);
                        aTTextView.setText(a);
                        aTTextView.setTextSize(0, (float) a.c((int) R.dimen.media_quality_menu_text_size));
                        if (z && str2.equals(str)) {
                            aTTextView.setTextColor(a.a("media_quality_menu_selecting_item_text_color", "media_quality_menu_selecting_item_text_color"));
                        } else {
                            aTTextView.setTextColor(a.a("media_quality_menu_selecting_item_text_color", "media_quality_menu_normal_item_text_color"));
                        }
                        aTTextView.setTag(str2);
                        aTTextView.setClickable(true);
                        aTTextView.setOnClickListener(new aa(afVar));
                        viewGroup.addView(aTTextView, layoutParams);
                    }
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z2;
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ATTextView) && childAt.getTag() != null && (childAt.getTag() instanceof String)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c.b(z2);
                str2 = (String) viewGroup.getChildAt(i).getTag();
                ATTextView aTTextView2 = (ATTextView) childAt;
                if (z && str2.equals(str)) {
                    aTTextView2.setTextColor(a.a("media_quality_menu_selecting_item_text_color", "media_quality_menu_selecting_item_text_color"));
                } else {
                    aTTextView2.setTextColor(a.a("media_quality_menu_selecting_item_text_color", "media_quality_menu_normal_item_text_color"));
                }
            }
        }
    }

    public af(Context context, g gVar, com.ucpro.feature.video.player.e.a aVar) {
        super(context, gVar, aVar);
        this.a = null;
        this.a = new FrameLayout(this.q);
        View view = new View(this.q);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.a.addView(view, layoutParams);
        this.c = new LinearLayout(this.q);
        this.c.setId(33);
        this.c.setBackgroundDrawable(a.a("video_quality_menu_bg.9.png"));
        this.c.setOrientation(1);
        this.c.setVisibility(4);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = a.c((int) R.dimen.media_menu_bottom_margin) + a.c((int) R.dimen.player_bottom_bar_inner_height);
        layoutParams2.rightMargin = a.c((int) R.dimen.player_bottom_bar_play_btn_right_margin);
        this.a.addView(this.c, layoutParams2);
        this.b = new LinearLayout(this.q);
        this.b.setId(28);
        this.b.setBackgroundDrawable(a.a("new_video_resolution_bg.xml"));
        this.b.setOrientation(1);
        this.b.setVisibility(4);
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = a.c((int) R.dimen.media_menu_bottom_margin) + a.c((int) R.dimen.player_bottom_bar_inner_height);
        layoutParams2.rightMargin = a.c((int) R.dimen.player_bottom_bar_play_btn_right_margin);
        this.a.addView(this.b, layoutParams2);
        this.d = new ah(this.q, this.p, this.r, true);
        this.d.a.setId(44);
        this.d.a.setVisibility(4);
        this.a.addView(this.d.a, new FrameLayout.LayoutParams(-1, -1));
    }

    protected final void a(List<Class<?>> list) {
        list.add(n.class);
    }

    protected final void a(h<Boolean> hVar) {
        hVar.a(28).b(n.ResolutionList.f).a(Boolean.valueOf(true)).b(n.ResolutionList.f ^ -1).a(Boolean.valueOf(false)).a(33).b(n.CacheResolutionList.f).a(Boolean.valueOf(true)).b(n.CacheResolutionList.f ^ -1).a(Boolean.valueOf(false)).a(44).b(n.MoreList.f).a(Boolean.valueOf(true)).b(n.MoreList.f ^ -1).a(Boolean.valueOf(false));
        hVar.a(new ad(this));
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return false;
    }
}
