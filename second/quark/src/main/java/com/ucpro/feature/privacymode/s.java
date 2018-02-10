package com.ucpro.feature.privacymode;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.g.a.c;
import com.ucpro.ui.e.a.i;
import com.ucpro.ui.e.b;
import com.ucpro.ui.e.d;
import com.ucpro.ui.e.e;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class s extends d {
    private static final String b = d.a();
    private static final String c = d.a();

    public s(String str) {
        super(str);
    }

    public final void a(e eVar, b bVar) {
        i iVar;
        Drawable gradientDrawable;
        Drawable gradientDrawable2;
        if (a.d(eVar.b(), b)) {
            iVar = (i) bVar;
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) com.ucpro.ui.c.a.c((int) R.dimen.privacymode_content_type_item_radius));
            gradientDrawable.setColor(com.ucpro.ui.c.a.c("privacymode_content_type_item_bg"));
            gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius((float) com.ucpro.ui.c.a.c((int) R.dimen.privacymode_content_type_item_radius));
            gradientDrawable2.setColor(com.ucpro.ui.c.a.c("privacymode_content_type_item_press_bg"));
            iVar.l.setBackgroundDrawable(c.a(gradientDrawable, gradientDrawable2));
            iVar.o.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_bookmark_item_title));
            iVar.o.setTextColor(com.ucpro.ui.c.a.c("privacymode_title_color"));
            int size = com.ucpro.feature.bookmarkhis.bookmark.a.s.a().f().size();
            iVar.p.setText(String.format(com.ucpro.ui.c.a.d((int) R.string.privacymode_bookmark_item_content), new Object[]{String.valueOf(size)}));
            iVar.m.setImageDrawable(com.ucpro.ui.c.a.a("privacy_mode_bookmark_icon.svg"));
            iVar.n.setImageDrawable(com.ucpro.ui.c.a.a("privacy_mode_arrow.svg"));
            iVar.q.setVisibility(4);
        } else if (a.d(eVar.b(), c)) {
            iVar = (i) bVar;
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) com.ucpro.ui.c.a.c((int) R.dimen.privacymode_content_type_item_radius));
            gradientDrawable.setColor(com.ucpro.ui.c.a.c("privacymode_content_type_more_item_bg"));
            gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius((float) com.ucpro.ui.c.a.c((int) R.dimen.privacymode_content_type_item_radius));
            gradientDrawable2.setColor(com.ucpro.ui.c.a.c("privacymode_content_type_more_item_press_bg"));
            iVar.l.setBackgroundDrawable(c.a(gradientDrawable, gradientDrawable2));
            iVar.o.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_more_item_title));
            iVar.o.setTextColor(com.ucpro.ui.c.a.c("privacymode_content_type_text_title_color"));
            iVar.p.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_more_item_content));
            iVar.p.setTextColor(com.ucpro.ui.c.a.c("privacymode_content_type_text_content_color"));
            iVar.m.setImageDrawable(com.ucpro.ui.c.a.a("privacy_mode_more_item_icon.png"));
            iVar.n.setImageDrawable(null);
            iVar.q.setVisibility(0);
            iVar.q.setImageDrawable(com.ucpro.ui.c.a.a("privacy_mode_more_icon.svg"));
        }
    }

    public final void a(e eVar, int i, b bVar) {
        if (a.c(eVar.b(), b)) {
            g.a().a(com.ucpro.base.a.e.cC);
            m.a("privacy_mode", "privacy_box_bookmark", new String[0]);
        } else if (a.d(eVar.b(), c)) {
            com.ucpro.ui.b.e.a().a("", 1);
            m.a("privacy_mode", "privacy_box_more", new String[0]);
        }
    }

    public final com.ucpro.ui.e.a.d c() {
        if (a.d(this.a, b) || a.d(this.a, c)) {
            return com.ucpro.ui.e.a.d.VIEW_TYPE_ITEM_PRIVACYMODE;
        }
        return com.ucpro.ui.e.a.d.VIEW_TYPE_NORMAL;
    }
}
