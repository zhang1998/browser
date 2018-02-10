package com.taobao.weex.ui.view.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.alibaba.fastjson.e;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.p;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class b extends SimpleOnGestureListener implements OnTouchListener {
    public boolean a = false;
    public boolean b = false;
    private ab c;
    private GestureDetector d;
    private Rect e;
    private Point f;
    private Point g;
    private PointF h;
    private PointF i;
    private long j = -1;
    private long k = -1;
    private f l = null;
    private int m = -1;

    public b(ab abVar, Context context) {
        this.c = abVar;
        this.e = new Rect();
        this.f = new Point();
        this.g = new Point();
        this.h = new PointF();
        this.i = new PointF();
        this.d = new GestureDetector(context, this, new a());
        p parentScroller = abVar.getParentScroller();
        if (parentScroller != null) {
            this.m = parentScroller.a();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Object obj = 1;
        try {
            boolean onTouchEvent = this.d.onTouchEvent(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    Object obj2;
                    this.b = false;
                    if ((this.m == 0 && this.c.containsGesture(d.HORIZONTALPAN)) || (this.m == 1 && this.c.containsGesture(d.VERTICALPAN))) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        if (this.c != null) {
                            p parentScroller = this.c.getParentScroller();
                            if (!(parentScroller == null || parentScroller.b())) {
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            ViewParent parent = this.c.getRealView().getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    return onTouchEvent | a(e.ACTION_DOWN, motionEvent);
                case 1:
                case 6:
                    a(view);
                    return (onTouchEvent | a(e.ACTION_UP, motionEvent)) | a(motionEvent);
                case 2:
                    return onTouchEvent | a(e.ACTION_MOVE, motionEvent);
                case 3:
                    a(view);
                    return (onTouchEvent | a(e.ACTION_CANCEL, motionEvent)) | a(motionEvent);
                default:
                    return onTouchEvent;
            }
        } catch (Throwable e) {
            WXLogUtils.e("Gesture RunTime Error ", e);
            return false;
        }
    }

    private static void a(View view) {
        if (view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.l == null) {
            return false;
        }
        String str;
        if (this.l == d.HORIZONTALPAN || this.l == d.VERTICALPAN) {
            switch (motionEvent.getAction()) {
                case 0:
                    str = "start";
                    break;
                case 1:
                    str = "end";
                    break;
                case 2:
                    str = "move";
                    break;
                case 3:
                    str = "end";
                    break;
                default:
                    str = "unknown";
                    break;
            }
        }
        str = null;
        if (!this.c.containsGesture(this.l)) {
            return false;
        }
        if (this.a && "move".equals(r0)) {
            return true;
        }
        for (Map fireEvent : a(motionEvent, r0)) {
            this.c.fireEvent(this.l.toString(), fireEvent);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.l = null;
        }
        return true;
    }

    private boolean a(f fVar, MotionEvent motionEvent) {
        if (!this.c.containsGesture(fVar)) {
            return false;
        }
        for (Map fireEvent : a(motionEvent, null)) {
            this.c.fireEvent(fVar.toString(), fireEvent);
        }
        return true;
    }

    private List<Map<String, Object>> a(MotionEvent motionEvent, String str) {
        List<Map<String, Object>> arrayList = new ArrayList(motionEvent.getHistorySize() + 1);
        arrayList.addAll(b(motionEvent));
        arrayList.add(a(motionEvent, -1, str));
        return arrayList;
    }

    private List<Map<String, Object>> b(MotionEvent motionEvent) {
        List<Map<String, Object>> arrayList = new ArrayList(motionEvent.getHistorySize());
        if (motionEvent.getActionMasked() == 2) {
            for (int i = 0; i < motionEvent.getHistorySize(); i++) {
                arrayList.add(a(motionEvent, i, null));
            }
        }
        return arrayList;
    }

    private Map<String, Object> a(MotionEvent motionEvent, int i, String str) {
        int i2 = 0;
        com.alibaba.fastjson.b bVar = new com.alibaba.fastjson.b(motionEvent.getPointerCount());
        if (motionEvent.getActionMasked() == 2) {
            while (i2 < motionEvent.getPointerCount()) {
                bVar.add(a(motionEvent, i, i2));
                i2++;
            }
        } else {
            if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 3) {
                i2 = 1;
            }
            if (i2 != 0) {
                bVar.add(a(motionEvent, -1, motionEvent.getActionIndex()));
            }
        }
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("changedTouches", bVar);
        if (str != null) {
            hashMap.put("state", str);
        }
        return hashMap;
    }

    private e a(MotionEvent motionEvent, int i, int i2) {
        PointF c;
        PointF b;
        if (i == -1) {
            c = c(motionEvent, i2, -1);
            b = b(motionEvent, i2, -1);
        } else {
            c = c(motionEvent, i2, i);
            b = b(motionEvent, i2, i);
        }
        float pointerId = (float) motionEvent.getPointerId(i2);
        e eVar = new e();
        eVar.a("pageX", Float.valueOf(c.x));
        eVar.a("pageY", Float.valueOf(c.y));
        eVar.a("screenX", Float.valueOf(b.x));
        eVar.a("screenY", Float.valueOf(b.y));
        eVar.a("identifier", Float.valueOf(pointerId));
        return eVar;
    }

    private PointF b(MotionEvent motionEvent, int i, int i2) {
        float x;
        float y;
        if (i2 == -1) {
            x = motionEvent.getX(i);
            y = motionEvent.getY(i);
        } else {
            x = motionEvent.getHistoricalX(i, i2);
            y = motionEvent.getHistoricalY(i, i2);
        }
        this.e.set(0, 0, 0, 0);
        this.f.set(0, 0);
        this.g.set((int) x, (int) y);
        this.c.getRealView().getGlobalVisibleRect(this.e, this.f);
        this.g.offset(this.f.x, this.f.y);
        return new PointF(WXViewUtils.c((float) this.g.x, this.c.getInstance().o), WXViewUtils.c((float) this.g.y, this.c.getInstance().o));
    }

    private PointF c(MotionEvent motionEvent, int i, int i2) {
        float x;
        float y;
        if (i2 == -1) {
            x = motionEvent.getX(i);
            y = motionEvent.getY(i);
        } else {
            x = motionEvent.getHistoricalX(i, i2);
            y = motionEvent.getHistoricalY(i, i2);
        }
        this.h.set(x, y);
        this.i.set(0.0f, 0.0f);
        this.c.computeVisiblePointInViewCoordinate(this.i);
        this.h.offset(this.i.x, this.i.y);
        return new PointF(WXViewUtils.c(this.h.x, this.c.getInstance().o), WXViewUtils.c(this.h.y, this.c.getInstance().o));
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.c.containsGesture(d.LONG_PRESS)) {
            List a = a(motionEvent, null);
            this.c.getInstance().a(this.c.getDomObject().b_(), d.LONG_PRESS.toString(), (Map) a.get(a.size() - 1));
            this.b = true;
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z = false;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        f fVar;
        boolean z2;
        if (Math.abs(motionEvent2.getX() - motionEvent.getX()) > Math.abs(motionEvent2.getY() - motionEvent.getY())) {
            fVar = d.HORIZONTALPAN;
        } else {
            fVar = d.VERTICALPAN;
        }
        if (this.l == d.HORIZONTALPAN || this.l == d.VERTICALPAN) {
            a(motionEvent2);
            z2 = true;
        } else if (this.c.containsGesture(fVar)) {
            ViewParent parent = this.c.getRealView().getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (this.l != null) {
                a(this.l, motionEvent2);
            }
            this.l = fVar;
            this.c.fireEvent(fVar.toString(), a(motionEvent2, -1, "start"));
            z2 = true;
        } else {
            if (this.c.containsGesture(d.PAN_START) || this.c.containsGesture(d.PAN_MOVE) || this.c.containsGesture(d.PAN_END)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (this.k != motionEvent.getEventTime()) {
                    this.k = motionEvent.getEventTime();
                    this.l = d.PAN_END;
                    this.c.fireEvent(d.PAN_START.toString(), a(motionEvent, -1, null));
                } else {
                    this.c.fireEvent(d.PAN_MOVE.toString(), a(motionEvent2, -1, null));
                }
                z2 = true;
            } else if (!this.c.containsGesture(d.SWIPE) || this.j == motionEvent.getEventTime()) {
                z2 = false;
            } else {
                this.j = motionEvent.getEventTime();
                List a = a(motionEvent2, null);
                Map map = (Map) a.get(a.size() - 1);
                if (Math.abs(f) > Math.abs(f2)) {
                    map.put("direction", f > 0.0f ? Style.LEFT : Style.RIGHT);
                } else {
                    map.put("direction", f2 > 0.0f ? "up" : "down");
                }
                this.c.getInstance().a(this.c.getDomObject().b_(), d.SWIPE.toString(), map);
                z2 = true;
            }
        }
        if (this.b || z2) {
            z = true;
        }
        this.b = z;
        return z2;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }
}
