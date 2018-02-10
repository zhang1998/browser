package com.ucpro.feature.bookmarkhis.a.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.feature.bookmarkhis.a.a.a;
import com.ucpro.feature.bookmarkhis.a.a.f;
import com.ucpro.feature.navigation.b.i;
import com.ucpro.services.c.d;
import com.ucpro.ui.widget.q;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: ProGuard */
public final class l extends BaseExpandableListAdapter implements q {
    a a;
    private g b;
    private e c;
    private Context d;
    private Drawable e;

    public l(Context context, e eVar, a aVar, g gVar) {
        this.d = context;
        this.a = aVar;
        this.c = eVar;
        this.b = gVar;
    }

    public final Object getChild(int i, int i2) {
        return this.a.a(i).get(i2);
    }

    public final long getChildId(int i, int i2) {
        return (long) i2;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c(this.c.getContext());
        } else {
            View view2 = view;
        }
        cVar = cVar;
        f fVar = (f) this.a.a(i).get(i2);
        d dVar = new d();
        dVar.a = fVar;
        dVar.c = i2;
        dVar.b = i;
        cVar.setTitle(fVar.b);
        cVar.setUrl(fVar.c);
        if (TextUtils.isEmpty(cVar.getUrl())) {
            cVar.b();
            cVar.setIcon(a());
        } else {
            Drawable a = i.a.a(this.d, null, null, com.ucweb.common.util.i.f.c(cVar.getUrl()));
            if (a != null) {
                cVar.a();
                cVar.setIcon(a);
            } else {
                if (cVar.getTag() == null) {
                    cVar.setTag(new k(this));
                }
                com.ucpro.services.c.f.a.a.a(this.d, cVar.getUrl(), (d) cVar.getTag(), cVar);
            }
        }
        g gVar = this.b;
        cVar.setBackgroundDrawable(cVar.a);
        cVar.setLayoutParams(new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.history_item_height)));
        if (dVar.a != null) {
            cVar.setOnClickListener(new h(cVar, gVar, dVar));
            cVar.setLongClickable(true);
            cVar.setOnLongClickListener(new m(cVar, gVar, dVar));
        }
        return cVar;
    }

    public final int getChildrenCount(int i) {
        if (this.a == null || this.a.a(i) == null) {
            return 0;
        }
        return this.a.a(i).size();
    }

    public final Object getGroup(int i) {
        return this.a.b.get(i);
    }

    public final int getGroupCount() {
        return this.a.b.size();
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        return a(this.a, view, i);
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public final View a(View view, int i) {
        return a(this.a, view, i);
    }

    private Drawable a() {
        if (this.e == null) {
            this.e = com.ucpro.ui.c.a.a("discover_bk_item_web_icon.svg");
        }
        return this.e;
    }

    private View a(a aVar, View view, int i) {
        if (aVar == null || aVar.b == null) {
            return null;
        }
        j jVar;
        CharSequence d;
        if (view == null) {
            jVar = new j(this, this.c.getContext());
        } else {
            View view2 = view;
        }
        jVar = jVar;
        int intValue = ((Integer) aVar.b.get(i)).intValue();
        if (intValue == 0) {
            d = com.ucpro.ui.c.a.d((int) R.string.today_group);
        } else {
            Calendar instance = Calendar.getInstance();
            instance.add(5, -intValue);
            d = new SimpleDateFormat(com.ucpro.ui.c.a.d((int) R.string.history_data_format)).format(instance.getTime());
        }
        jVar.setLayoutParams(new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.history_group_height)));
        jVar.a.setText(d);
        jVar.a.setTextSize(0, com.ucpro.ui.c.a.b((int) R.dimen.history_group_title_text_size));
        jVar.a.setTextColor(com.ucpro.ui.c.a.c("history_group_title_text_color"));
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.ucpro.ui.c.a.c((int) R.dimen.history_group_title_left_margin);
        layoutParams.gravity = 19;
        jVar.a.setLayoutParams(layoutParams);
        jVar.setBackgroundColor(com.ucpro.ui.c.a.c("history_group_title_background_color"));
        return jVar;
    }
}
