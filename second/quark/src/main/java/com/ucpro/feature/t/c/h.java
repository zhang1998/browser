package com.ucpro.feature.t.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.quark.browser.R;
import com.ucpro.feature.webwindow.ar;
import com.ucpro.ui.widget.a;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class h extends a implements OnClickListener, OnLongClickListener {
    e a = null;
    private j b = null;

    public h(Context context) {
        super(context);
        setMaxItemCount(3);
        View arVar = new ar(getContext(), "multiwindow_back.svg");
        arVar.setItemId(30090);
        arVar.setTag(R.id.ui_auto, b.C);
        arVar.setOnClickListener(this);
        arVar.setOnLongClickListener(this);
        a(arVar, 0);
        arVar = new ar(getContext(), "multiwindow_add.svg");
        arVar.setItemId(30089);
        arVar.setTag(R.id.ui_auto, b.D);
        arVar.setOnClickListener(this);
        arVar.setOnLongClickListener(this);
        a(arVar, 1);
        this.a = new e(getContext());
        this.a.setItemId(30091);
        this.a.setTag(R.id.ui_auto, b.E);
        this.a.setOnClickListener(this);
        this.a.setOnLongClickListener(this);
        a(this.a, 2);
        a();
    }

    public final void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ar) {
                ((ar) childAt).a();
            }
        }
    }

    public final void onClick(View view) {
        if (view instanceof ar) {
            ar arVar = (ar) view;
            if (this.b != null) {
                this.b.a(arVar.getItemID());
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (view instanceof ar) {
            ar arVar = (ar) view;
            if (this.b != null) {
                j jVar = this.b;
                arVar.getItemID();
                jVar.a();
            }
        }
        return false;
    }

    public final void setListener(j jVar) {
        this.b = jVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
