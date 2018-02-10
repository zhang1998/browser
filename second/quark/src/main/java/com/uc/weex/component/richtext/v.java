package com.uc.weex.component.richtext;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.alibaba.fastjson.b;
import com.taobao.weex.ad;
import com.taobao.weex.bridge.s;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class v implements OnTouchListener {
    final /* synthetic */ w a;

    private v(w wVar) {
        this.a = wVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        aa aaVar = (aa) this.a.getDomObject();
        if (aaVar.l == null || aaVar.y == null || this.a.getHostView() == null) {
            return false;
        }
        Spannable newSpannable = Factory.getInstance().newSpannable(aaVar.l);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = (((int) motionEvent.getX()) - ((ac) this.a.getHostView()).getPaddingLeft()) + ((ac) this.a.getHostView()).getScrollX();
            int scrollY = ((ac) this.a.getHostView()).getScrollY() + (((int) motionEvent.getY()) - ((ac) this.a.getHostView()).getPaddingTop());
            Layout layout = aaVar.y;
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) x);
            URLSpan[] uRLSpanArr = (URLSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
            if (uRLSpanArr.length != 0) {
                if (action == 1) {
                    Object obj;
                    b bVar = new b();
                    bVar.add(uRLSpanArr[0].getURL());
                    s sVar = ad.a().b;
                    s.a(this.a.getInstanceId(), "event", "openURL", bVar);
                    String url = uRLSpanArr[0].getURL();
                    String str = "";
                    if (uRLSpanArr[0] instanceof MyURLSpan) {
                        obj = ((MyURLSpan) uRLSpanArr[0]).a;
                    } else {
                        String str2 = str;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("href", url);
                    hashMap.put("id", obj);
                    if (this.a.getDomObject().c_().contains("linkclick")) {
                        this.a.getInstance().a(this.a.getRef(), "linkclick", hashMap);
                    } else if (this.a.getDomObject().c_().contains("linkClick")) {
                        this.a.getInstance().a(this.a.getRef(), "linkClick", hashMap);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
