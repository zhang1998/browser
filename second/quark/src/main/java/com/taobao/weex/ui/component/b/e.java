package com.taobao.weex.ui.component.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v7.widget.GridLayoutManager;
import android.mini.support.v7.widget.LinearLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.StaggeredGridLayoutManager;
import android.mini.support.v7.widget.am;
import android.mini.support.v7.widget.bf;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.o;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.a.f;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.at;
import com.taobao.weex.ui.component.av;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.component.m;
import com.taobao.weex.ui.component.p;
import com.taobao.weex.ui.component.t;
import com.taobao.weex.ui.component.y;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.a.a;
import com.taobao.weex.ui.view.listview.a.b;
import com.taobao.weex.ui.view.listview.a.c;
import com.taobao.weex.ui.view.listview.a.d;
import com.taobao.weex.ui.view.listview.a.g;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public abstract class e<T extends ViewGroup & g> extends bv<T> implements p, a, b<c> {
    private static final Pattern j = Pattern.compile("([a-z]+)\\(([0-9\\.]+),?([0-9\\.]+)?\\)");
    private static boolean p = true;
    private static boolean q = false;
    public int a = 1;
    public int b = 1;
    public float c = 0.0f;
    protected float d = 0.0f;
    private String e = "BasicListComponent";
    private int f = 0;
    private boolean h = false;
    private ArrayList<c> i = new ArrayList();
    private Map<String, m> k = new HashMap();
    private boolean l = true;
    private android.mini.support.v4.d.b<String, Long> m;
    private SparseArray<ArrayList<ab>> n;
    private g o = new g(this);
    private int r = 10;
    private Point s = new Point(-1, -1);
    private ItemAnimator t;
    private Map<String, Map<String, ab>> u = new HashMap();
    private f v = new f(this);

    abstract T a(Context context, int i);

    static /* synthetic */ boolean a(e eVar, int i, int i2) {
        if (eVar.s.x == -1 && eVar.s.y == -1) {
            eVar.s.x = i;
            eVar.s.y = i2;
            return true;
        } else if (Math.abs(eVar.s.x - i) < eVar.r && Math.abs(eVar.s.y - i2) < eVar.r) {
            return false;
        } else {
            eVar.s.x = i;
            eVar.s.y = i2;
            return true;
        }
    }

    public final /* synthetic */ void a(bf bfVar, int i) {
        c cVar = (c) bfVar;
        if (cVar != null) {
            cVar.b(true);
            ab h = h(i);
            if (h == null || (h instanceof av) || (h instanceof at) || (h.getDomObject() != null && h.getDomObject().f())) {
                if (i.c()) {
                    WXLogUtils.d(this.e, "Bind WXRefresh & WXLoading " + cVar);
                }
            } else if (cVar.t() != null && (cVar.t() instanceof m) && cVar.l && cVar.m != null && cVar.m.get() != null) {
                ((ab) cVar.m.get()).bindData(h);
                cVar.l = false;
            }
        }
    }

    public final /* synthetic */ boolean a(bf bfVar) {
        c cVar = (c) bfVar;
        if (i.c()) {
            WXLogUtils.d(this.e, "Failed to recycle " + cVar);
        }
        return false;
    }

    public final /* synthetic */ void b(bf bfVar) {
        boolean z;
        c cVar = (c) bfVar;
        long currentTimeMillis = System.currentTimeMillis();
        cVar.b(false);
        if (cVar.m == null || cVar.m.get() == null) {
            z = true;
        } else {
            z = ((ab) cVar.m.get()).canRecycled();
        }
        if (z) {
            this.i.add(cVar);
        } else {
            WXLogUtils.w(this.e, "this holder can not be allowed to  recycled");
        }
        if (i.c()) {
            WXLogUtils.d(this.e, "Recycle holder " + (System.currentTimeMillis() - currentTimeMillis) + "  Thread:" + Thread.currentThread().getName());
        }
    }

    public final /* synthetic */ bf f(int i) {
        return i(i);
    }

    public /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    public e(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    public y measure(int i, int i2) {
        int c = WXViewUtils.c(i.e);
        int a = WXViewUtils.a(getInstanceId());
        if (a < c) {
            c = a;
        }
        if (i2 > c) {
            i2 = a - getAbsoluteY();
        }
        return super.measure((int) (((float) i) + this.c), i2);
    }

    public int a() {
        return 1;
    }

    public void destroy() {
        super.destroy();
        if (this.u != null) {
            this.u.clear();
        }
        if (this.n != null) {
            this.n.clear();
        }
        if (this.m != null) {
            this.m.clear();
        }
    }

    public final LayoutParams a(ab abVar, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        if ((abVar instanceof t) && marginLayoutParams == null) {
            return new LinearLayout.LayoutParams(i, i2);
        }
        if (marginLayoutParams == null) {
            return new RecyclerView.LayoutParams(i, i2);
        }
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        marginLayoutParams.setMargins(i3, 0, i4, 0);
        return marginLayoutParams;
    }

    private android.mini.support.v7.widget.at a(String str) {
        if (str == null) {
            return null;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        float f3 = 0.0f;
        int i3 = 0;
        Matcher matcher = j.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group(1);
            Object obj = -1;
            try {
                switch (group2.hashCode()) {
                    case -1267206133:
                        if (group2.equals("opacity")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case -925180581:
                        if (group2.equals(Style.WX_ROTATE)) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 109250890:
                        if (group2.equals("scale")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (group2.equals(Style.WX_TRANSLATE)) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        f = Float.parseFloat(matcher.group(2));
                        f2 = Float.parseFloat(matcher.group(3));
                        break;
                    case 1:
                        i = Integer.parseInt(matcher.group(2));
                        i2 = Integer.parseInt(matcher.group(3));
                        break;
                    case 2:
                        f3 = Float.parseFloat(matcher.group(2));
                        break;
                    case 3:
                        i3 = Integer.parseInt(matcher.group(2));
                        break;
                    default:
                        WXLogUtils.e(this.e, "Invaild transform expression:" + group);
                        break;
                }
            } catch (Throwable e) {
                WXLogUtils.e("", e);
                WXLogUtils.e(this.e, "Invaild transform expression:" + group);
            }
        }
        return new com.taobao.weex.ui.view.listview.a.e(a() == 1, f3, i, i2, i3, f, f2);
    }

    public T a(@NonNull Context context) {
        T a = a(context, a());
        String str = (String) getDomObject().i().get("transform");
        if (str != null) {
            RecyclerView innerView = ((g) a).getInnerView();
            android.mini.support.v7.widget.at a2 = a(str);
            if (innerView.f != null) {
                innerView.f.a("Cannot add item decoration during a scroll  or layout");
            }
            if (innerView.g.isEmpty()) {
                innerView.setWillNotDraw(false);
            }
            innerView.g.add(a2);
            innerView.g();
            innerView.requestLayout();
        }
        this.t = ((g) a).getInnerView().getItemAnimator();
        am dVar = new d(this);
        if (dVar.a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        dVar.b = true;
        ((g) a).setRecyclerViewBaseAdapter(dVar);
        a.setOverScrollMode(2);
        RecyclerView innerView2 = ((g) a).getInnerView();
        if (innerView2.q != null) {
            innerView2.q.clear();
        }
        ((g) a).getInnerView().a(this.o);
        ((g) a).getInnerView().a(new a(this));
        a.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        return a;
    }

    public final void a(ab abVar) {
        f.a(abVar, this.u);
    }

    public final void b(ab abVar) {
        f.b(abVar, this.u);
    }

    @Nullable
    private static ab h(ab abVar) {
        ab abVar2 = abVar;
        while (abVar2 != null) {
            abVar = abVar2.getParent();
            if (abVar == null) {
                break;
            } else if (abVar instanceof e) {
                return abVar2;
            } else {
                abVar2 = abVar;
            }
        }
        return null;
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -112563826:
                if (str.equals("loadmoreoffset")) {
                    z = false;
                    break;
                }
                break;
            case -5620052:
                if (str.equals("offsetAccuracy")) {
                    z = true;
                    break;
                }
                break;
            case 66669991:
                if (str.equals("scrollable")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return true;
            case true:
                setScrollable(ah.a(obj, Boolean.valueOf(true)).booleanValue());
                return true;
            case true:
                setOffsetAccuracy(ah.a(obj, Integer.valueOf(10)).intValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "scrollable")
    public void setScrollable(boolean z) {
        this.l = z;
        WXRecyclerView innerView = ((g) ((ViewGroup) getHostView())).getInnerView();
        if (innerView != null) {
            innerView.setScrollable(z);
        }
    }

    @WXComponentProp(name = "offsetAccuracy")
    public void setOffsetAccuracy(int i) {
        this.r = (int) WXViewUtils.a((float) i, getInstance().o);
    }

    public final boolean b() {
        return this.l;
    }

    private void a(ab abVar, int i, boolean z) {
        m mVar = (m) this.k.get(abVar.getRef());
        if (mVar != null) {
            mVar.b[i] = z;
        } else if (z) {
            int indexOf = this.g.indexOf(h(abVar));
            if (indexOf != -1) {
                m mVar2 = new m(abVar, indexOf);
                mVar2.b[i] = true;
                this.k.put(abVar.getRef(), mVar2);
            }
        }
    }

    public final void c(ab abVar) {
        a(abVar, 0, true);
    }

    public final void d(ab abVar) {
        a(abVar, 1, true);
    }

    public final void e(ab abVar) {
        a(abVar, 0, false);
    }

    public final void f(ab abVar) {
        a(abVar, 1, false);
    }

    public void a(ab abVar, Map<String, Object> map) {
        float a;
        boolean z;
        if (map != null) {
            String obj = map.get("offset") == null ? SettingsConst.FALSE : map.get("offset").toString();
            boolean booleanValue = ah.a(map.get("animated"), Boolean.valueOf(true)).booleanValue();
            if (obj != null) {
                try {
                    a = WXViewUtils.a(Float.parseFloat(obj), getInstance().o);
                    z = booleanValue;
                } catch (Exception e) {
                    WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
            a = 0.0f;
            z = booleanValue;
        } else {
            a = 0.0f;
            z = true;
        }
        int i = (int) a;
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            Object obj2;
            for (ab abVar2 = abVar; abVar2 != null; abVar2 = abVar2.getParent()) {
                if (abVar2 instanceof m) {
                    obj2 = (m) abVar2;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                int indexOf = this.g.indexOf(obj2);
                RecyclerView innerView = ((g) viewGroup).getInnerView();
                if (z) {
                    if (!innerView.i) {
                        if (innerView.f == null) {
                            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                        } else {
                            innerView.f.a(innerView, indexOf);
                        }
                    }
                    if (i != 0) {
                        innerView.a(new c(this, i));
                        return;
                    }
                    return;
                }
                LayoutManager layoutManager = innerView.getLayoutManager();
                int i2;
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    i2 = -i;
                    linearLayoutManager.l = indexOf;
                    linearLayoutManager.m = i2;
                    if (linearLayoutManager.n != null) {
                        linearLayoutManager.n.a = -1;
                    }
                    linearLayoutManager.l();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    i2 = -i;
                    if (staggeredGridLayoutManager.j != null) {
                        staggeredGridLayoutManager.j.a();
                    }
                    staggeredGridLayoutManager.g = indexOf;
                    staggeredGridLayoutManager.h = i2;
                    staggeredGridLayoutManager.l();
                }
            }
        }
    }

    public final void a(int i) {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (this.u != null && viewGroup != null) {
            Map map = (Map) this.u.get(getRef());
            if (map != null) {
                int i2 = -1;
                for (Entry value : map.entrySet()) {
                    ab abVar = (ab) value.getValue();
                    if (!(abVar == null || abVar.getDomObject() == null || !(abVar instanceof m))) {
                        m mVar = (m) abVar;
                        if (mVar.getHostView() != null) {
                            int j;
                            int indexOf;
                            int i3;
                            LayoutManager layoutManager = ((g) ((ViewGroup) getHostView())).getInnerView().getLayoutManager();
                            if ((layoutManager instanceof LinearLayoutManager) || (layoutManager instanceof GridLayoutManager)) {
                                j = ((LinearLayoutManager) layoutManager).j();
                                indexOf = this.g.indexOf(mVar);
                                mVar.f = indexOf;
                                if (indexOf > j) {
                                    indexOf = 0;
                                } else if (indexOf > i2) {
                                    i2 = indexOf;
                                    indexOf = 1;
                                } else {
                                    indexOf = 1;
                                }
                                int i4 = indexOf;
                                indexOf = i2;
                                i2 = i4;
                            } else {
                                if (layoutManager instanceof StaggeredGridLayoutManager) {
                                    if (this.g.indexOf(mVar) <= ((StaggeredGridLayoutManager) layoutManager).a(new int[3])[0]) {
                                        indexOf = i2;
                                        i2 = 1;
                                    }
                                }
                                indexOf = i2;
                                i2 = 0;
                            }
                            int[] iArr = new int[2];
                            abVar.getHostView().getLocationOnScreen(iArr);
                            int[] iArr2 = new int[2];
                            abVar.getParentScroller().f().getLocationOnScreen(iArr2);
                            j = iArr[1] - iArr2[1];
                            if (i2 == 0 || mVar.a < 0 || j > 0 || i < 0) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            if (mVar.a > 0 || j <= 0 || i > 0) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            if (i3 != 0) {
                                ((g) viewGroup).a(mVar);
                            } else if (i2 != 0) {
                                ((g) viewGroup).b(mVar);
                            }
                            mVar.a = j;
                            i2 = indexOf;
                        } else {
                            return;
                        }
                    }
                }
                if (i2 >= 0) {
                    ((g) viewGroup).a_(i2);
                }
            }
        }
    }

    public final void g(ab abVar) {
        a(abVar, -1);
    }

    protected final int c() {
        return 0;
    }

    public void a(ab abVar, int i) {
        super.a(abVar, i);
        if (abVar != null && i >= -1) {
            if (i >= this.g.size()) {
                i = -1;
            }
            int i2 = i(abVar);
            if (this.n == null) {
                this.n = new SparseArray();
            }
            ArrayList arrayList = (ArrayList) this.n.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.n.put(i2, arrayList);
            }
            arrayList.add(abVar);
            i2 = i == -1 ? this.g.size() - 1 : i;
            ViewGroup viewGroup = (ViewGroup) getHostView();
            if (viewGroup != null) {
                boolean z;
                o domObject = abVar.getDomObject();
                if (domObject != null) {
                    if ("default".equals(domObject.i().get("insertAnimation"))) {
                        z = true;
                        if (z) {
                            ((g) viewGroup).getInnerView().setItemAnimator(null);
                        } else {
                            ((g) viewGroup).getInnerView().setItemAnimator(this.t);
                        }
                        domObject = abVar.getDomObject();
                        if (domObject != null || !ah.a(domObject.i().get("keepScrollPosition"), Boolean.valueOf(false)).booleanValue() || i > this.g.size() || i < 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            ((g) viewGroup).getRecyclerViewBaseAdapter().a.a(i2);
                        } else {
                            ((g) viewGroup).getInnerView().getLayoutManager().c(((LinearLayoutManager) ((g) viewGroup).getInnerView().getLayoutManager()).k());
                            ((g) viewGroup).getRecyclerViewBaseAdapter().a.b(i2);
                        }
                    }
                }
                z = false;
                if (z) {
                    ((g) viewGroup).getInnerView().setItemAnimator(null);
                } else {
                    ((g) viewGroup).getInnerView().setItemAnimator(this.t);
                }
                domObject = abVar.getDomObject();
                if (domObject != null) {
                }
                z = false;
                if (z) {
                    ((g) viewGroup).getRecyclerViewBaseAdapter().a.a(i2);
                } else {
                    ((g) viewGroup).getInnerView().getLayoutManager().c(((LinearLayoutManager) ((g) viewGroup).getInnerView().getLayoutManager()).k());
                    ((g) viewGroup).getRecyclerViewBaseAdapter().a.b(i2);
                }
            }
            g();
        }
    }

    private void g() {
        for (Entry value : this.k.entrySet()) {
            m mVar = (m) value.getValue();
            mVar.c = this.g.indexOf(h(mVar.a));
        }
    }

    protected final void a(View view, int i) {
    }

    public void a(ab abVar, boolean z) {
        int indexOf = this.g.indexOf(abVar);
        if (z) {
            abVar.detachViewAndClearPreInfo();
        }
        int i = i(abVar);
        if (this.n != null) {
            ArrayList arrayList = (ArrayList) this.n.get(i);
            if (arrayList != null) {
                arrayList.remove(abVar);
            }
        }
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            Object obj;
            o domObject = abVar.getDomObject();
            if (domObject != null) {
                if ("default".equals(domObject.i().get("deleteAnimation"))) {
                    obj = 1;
                    if (obj == null) {
                        ((g) viewGroup).getInnerView().setItemAnimator(this.t);
                    } else {
                        ((g) viewGroup).getInnerView().setItemAnimator(null);
                    }
                    ((g) viewGroup).getRecyclerViewBaseAdapter().a.c(indexOf);
                    if (i.c()) {
                        WXLogUtils.d(this.e, "removeChild child at " + indexOf);
                    }
                    super.a(abVar, z);
                }
            }
            obj = null;
            if (obj == null) {
                ((g) viewGroup).getInnerView().setItemAnimator(null);
            } else {
                ((g) viewGroup).getInnerView().setItemAnimator(this.t);
            }
            ((g) viewGroup).getRecyclerViewBaseAdapter().a.c(indexOf);
            if (i.c()) {
                WXLogUtils.d(this.e, "removeChild child at " + indexOf);
            }
            super.a(abVar, z);
        }
    }

    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        RecyclerView innerView = ((g) ((ViewGroup) getHostView())).getInnerView();
        pointF.set((float) innerView.computeHorizontalScrollOffset(), (float) innerView.computeVerticalScrollOffset());
    }

    protected final void d() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).setUsing(false);
        }
    }

    private c i(int i) {
        if (this.g != null) {
            if (this.n == null) {
                return j(i);
            }
            int i2;
            ArrayList arrayList = (ArrayList) this.n.get(i);
            try {
                if (this.n.size() > 9) {
                    p = false;
                }
                if (!(!q || getHostView() == null || ((g) ((ViewGroup) getHostView())).getInnerView() == null)) {
                    ((g) ((ViewGroup) getHostView())).getInnerView().getRecycledViewPool().a(i);
                }
                if (!(q || p || getHostView() == null || ((g) ((ViewGroup) getHostView())).getInnerView() == null)) {
                    for (i2 = 0; i2 < this.n.size(); i2++) {
                        ((g) ((ViewGroup) getHostView())).getInnerView().getRecycledViewPool().a(this.n.keyAt(i2));
                    }
                    q = true;
                }
            } catch (Exception e) {
                WXLogUtils.e(this.e, "Clear recycledViewPool error!");
            }
            if (arrayList == null) {
                return j(i);
            }
            i2 = 0;
            while (i2 < arrayList.size()) {
                ab abVar = (ab) arrayList.get(i2);
                if (abVar == null || abVar.isUsing()) {
                    i2++;
                } else if (abVar.getDomObject() != null && abVar.getDomObject().f()) {
                    return j(i);
                } else {
                    if (abVar instanceof m) {
                        if (abVar.getRealView() != null) {
                            return new c(abVar, i);
                        }
                        ((m) abVar).e = false;
                        abVar.createView();
                        abVar.applyLayoutAndEvent(abVar);
                        return new c(abVar, i);
                    } else if (abVar instanceof t) {
                        View frameLayout = new FrameLayout(getContext());
                        frameLayout.setBackgroundColor(-1);
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        frameLayout.setVisibility(8);
                        return new c(frameLayout, i);
                    } else {
                        WXLogUtils.e(this.e, "List cannot include element except cell、header、fixed、refresh and loading");
                        return j(i);
                    }
                }
            }
        }
        if (i.c()) {
            WXLogUtils.e(this.e, "Cannot find request viewType: " + i);
        }
        return j(i);
    }

    public final int b(int i) {
        return i(h(i));
    }

    private int i(ab abVar) {
        long parseInt;
        try {
            CharSequence charSequence;
            parseInt = (long) Integer.parseInt(abVar.getDomObject().b_());
            Object obj = abVar.getDomObject().i().get("scope");
            if (obj == null) {
                charSequence = null;
            } else {
                charSequence = obj.toString();
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (this.m == null) {
                    this.m = new android.mini.support.v4.d.b();
                }
                if (!this.m.containsKey(charSequence)) {
                    this.m.put(charSequence, Long.valueOf(parseInt));
                }
                parseInt = ((Long) this.m.get(charSequence)).longValue();
            }
        } catch (Throwable e) {
            WXLogUtils.eTag(this.e, e);
            parseInt = -1;
            WXLogUtils.e(this.e, "getItemViewType: NO ID, this will crash the whole render system of WXListRecyclerView");
        }
        return (int) parseInt;
    }

    public final long c(int i) {
        try {
            return Long.parseLong(h(i).getDomObject().b_());
        } catch (Throwable e) {
            WXLogUtils.e(this.e, WXLogUtils.getStackTrace(e));
            return -1;
        }
    }

    public final void d(int i) {
        try {
            String d = getDomObject().i().d();
            if (TextUtils.isEmpty(d)) {
                d = SettingsConst.FALSE;
            }
            if (((float) i) >= WXViewUtils.a((float) Integer.parseInt(d), getInstance().o)) {
                return;
            }
            if (this.f != this.g.size() || this.h) {
                fireEvent("loadmore");
                this.f = this.g.size();
                this.h = false;
            }
        } catch (Throwable e) {
            WXLogUtils.d(this.e + "onLoadMore :", e);
        }
    }

    public final void e(int i) {
        if (i == 0 || i == 1) {
            Map hashMap = new HashMap();
            hashMap.put("state", Integer.valueOf(i));
            fireEvent("scrollStateChanged", hashMap);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        String str;
        String str2 = i4 > 0 ? "up" : i4 < 0 ? "down" : null;
        if (a() != 0 || i3 == 0) {
            str = str2;
        } else {
            str = i3 > 0 ? Style.LEFT : Style.RIGHT;
        }
        for (m mVar : this.k.values()) {
            ab abVar = mVar.a;
            if (mVar.a()) {
                Object obj = (mVar.c < i || mVar.c > i2) ? 1 : null;
                if (abVar.getHostView() != null) {
                    boolean z;
                    if (obj == null && mVar.b()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int a = mVar.a(z);
                    if (a != 0) {
                        abVar.notifyAppearStateChange(a == 1 ? "appear" : "disappear", str);
                    }
                    a = mVar.b(mVar.c());
                    if (a != 0) {
                        abVar = mVar.a;
                        if (a == 1) {
                            str2 = "customAppear";
                        } else {
                            str2 = "customDisappear";
                        }
                        abVar.notifyCustomAppearStateChange(str2, str);
                    }
                }
            }
        }
    }

    @NonNull
    private c j(int i) {
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        return new c(frameLayout, i);
    }

    @JSMethod
    public void resetLoadmore() {
        this.h = true;
        this.f = 0;
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if ("scroll".equals(str) && getHostView() != null && ((g) ((ViewGroup) getHostView())).getInnerView() != null) {
            ((g) ((ViewGroup) getHostView())).getInnerView().a(new d(this));
        }
    }

    public final int e() {
        return this.g.size();
    }
}
