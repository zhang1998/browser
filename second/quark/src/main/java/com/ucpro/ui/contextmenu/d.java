package com.ucpro.ui.contextmenu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.ui.c.a;
import com.ui.edittext.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class d extends BaseAdapter {
    Point a;
    protected Context b;
    protected List<c> c;
    protected List<ContextMenuItemView> d;
    protected Object e;
    protected int f = 0;
    protected int g = 0;
    protected int h = 0;
    protected int i = 0;

    public d(Context context) {
        this.b = context;
        this.a = new Point(0, 0);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.i = (int) this.b.getResources().getDimension(R.dimen.contextmenu_item_text_padding_left);
        this.f = (int) this.b.getResources().getDimension(R.dimen.contextmenu_icon_width);
        this.g = (int) this.b.getResources().getDimension(R.dimen.contextmenu_icon_height);
        this.h = (int) this.b.getResources().getDimension(R.dimen.contextmenu_icon_padding);
        e();
    }

    private void e() {
        for (ContextMenuItemView contextMenuItemView : this.d) {
            contextMenuItemView.setTextColor(a.c("default_maintext_gray"));
            contextMenuItemView.setBackgroundDrawable(a.c());
            contextMenuItemView.setPadding(this.i, 0, this.i, 0);
        }
    }

    public final void a() {
        e();
    }

    public final float b() {
        float dimension = (float) ((int) this.b.getResources().getDimension(R.dimen.contextmenu_item_width));
        float dimension2 = (float) ((int) this.b.getResources().getDimension(R.dimen.contextmenu_item_textsize));
        if (this.c != null) {
            dimension = 0.0f;
            for (c cVar : this.c) {
                int i = !TextUtils.isEmpty(cVar.d) ? 1 : 0;
                ContextMenuItemView contextMenuItemView = new ContextMenuItemView(this.b);
                contextMenuItemView.setText(cVar.c);
                contextMenuItemView.setTextSize(0, dimension2);
                contextMenuItemView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                float min = (float) (Math.min(contextMenuItemView.getMeasuredWidth(), (int) (((float) b.a.c()) * 0.8f)) + (this.i * 2));
                if (i != 0) {
                    min += (float) (this.f + (this.h * 2));
                }
                dimension = Math.max(dimension, min);
            }
        }
        return dimension;
    }

    public final void a(String str) {
        c cVar = new c();
        cVar.c = str;
        cVar.a = 20100;
        if (this.c.size() > 2) {
            this.c.add(2, cVar);
        } else {
            com.ucweb.common.util.c.a("Error, Menu item position >= item size!!!");
        }
    }

    public final void c() {
        this.c.clear();
        this.d.clear();
        this.e = null;
    }

    public final Object d() {
        return this.e;
    }

    public final void a(Object obj) {
        this.e = obj;
    }

    public final int getCount() {
        return this.c.size();
    }

    public final Object getItem(int i) {
        return this.c.get(i);
    }

    public final long getItemId(int i) {
        if (i >= this.c.size() || i < 0) {
            return 0;
        }
        return (long) ((c) this.c.get(i)).a;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Object obj;
        if (i < this.d.size()) {
            view2 = (ContextMenuItemView) this.d.get(i);
        } else {
            view2 = null;
        }
        if (view2 == null) {
            int dimension = (int) this.b.getResources().getDimension(R.dimen.contextmenu_item_text_padding_left);
            int dimension2 = (int) this.b.getResources().getDimension(R.dimen.contextmenu_item_textsize);
            int dimension3 = (int) this.b.getResources().getDimension(R.dimen.contextmenu_item_height);
            int i2 = 0;
            Drawable drawable = null;
            while (i2 <= 0) {
                ContextMenuItemView contextMenuItemView = new ContextMenuItemView(this.b);
                contextMenuItemView.setGravity(16);
                contextMenuItemView.setTextSize(0, (float) dimension2);
                contextMenuItemView.setSingleLine();
                contextMenuItemView.setEllipsize(TruncateAt.END);
                contextMenuItemView.setTextColor(a.c("default_maintext_gray"));
                contextMenuItemView.setBackgroundDrawable(a.c());
                contextMenuItemView.setPadding(dimension, 0, 0, 0);
                contextMenuItemView.setLayoutParams(new LayoutParams(-1, dimension3));
                this.d.add(contextMenuItemView);
                i2++;
                Object obj2 = contextMenuItemView;
            }
            obj = drawable;
        } else {
            View view3 = view2;
        }
        com.ucweb.common.util.c.a(obj);
        c cVar = (c) getItem(i);
        if (!(cVar == null || obj == null)) {
            obj.setText(cVar.c);
            if (cVar.d != null) {
                Drawable a = a.a(cVar.d);
                if (a != null) {
                    a.setBounds(0, 0, this.f, this.g);
                    obj.setCompoundDrawables(a, null, null, null);
                    obj.setCompoundDrawablePadding(this.h);
                }
            } else {
                obj.setCompoundDrawables(null, null, null, null);
            }
            obj.setEnabled(cVar.b);
        }
        return obj;
    }

    public final int getItemViewType(int i) {
        return -1;
    }

    public final void a(String str, int i) {
        c cVar = new c();
        cVar.c = str;
        cVar.a = i;
        this.c.add(cVar);
    }
}
