package com.uc.weex.component.e;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.taobao.weex.ui.view.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: ProGuard */
public abstract class c extends l {
    protected l b;
    protected q c;
    protected q d;
    protected Stack<q> e = new Stack();
    protected ArrayList<Runnable> f = new ArrayList();
    protected boolean g;
    protected boolean h;
    protected r i = new b();
    protected boolean j = false;
    protected boolean k;

    abstract void a(q qVar, q qVar2, a aVar);

    abstract void a(boolean z);

    public c(Context context, l lVar) {
        super(context);
        this.b = lVar;
    }

    public final void a(q qVar) {
        addView(qVar);
        qVar.setActAsAndroidWindow(false);
        this.e.push(qVar);
        Map hashMap = new HashMap();
        hashMap.put("name", qVar.getName());
        hashMap.put("action", "push");
        this.b.getInstance().a("sceneAction", hashMap);
    }

    public r getSwipeCallback() {
        return this.i;
    }

    public final int a() {
        return this.e.size();
    }

    final boolean b(q qVar) {
        if (!this.e.contains(qVar)) {
            return false;
        }
        int size = this.e.size();
        int indexOf = this.e.indexOf(qVar);
        for (int i = size - 2; i > indexOf; i--) {
            d((q) this.e.remove(i));
        }
        a(true);
        return true;
    }

    private void d(q qVar) {
        if (qVar != null) {
            if (!qVar.b) {
                removeView(qVar);
            } else if (qVar.getParent() != null) {
                x.a(getContext(), (View) qVar);
            }
            qVar.a((byte) 13, false);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.j && getVisibility() == 4) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.j || getVisibility() != 4) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.j = true;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.j = true;
    }

    String[] getStackInfo() {
        if (this.e.size() <= 0) {
            return new String[0];
        }
        List arrayList = new ArrayList(this.e.size());
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(((q) it.next()).getName());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    final void c(q qVar) {
        this.e.remove(qVar);
        d(qVar);
    }

    static void b() {
    }

    final void c() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            d((q) it.next());
        }
        this.e.clear();
    }
}
