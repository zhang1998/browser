package com.uc.weex.component.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ap;
import com.taobao.weex.ui.component.bv;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class b extends ap {
    private ac a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private String f;

    public b(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
        this.a = acVar;
        com.uc.weex.component.b.a();
    }

    @WXComponentProp(name = "play")
    public void setPlay(boolean z) {
        this.c = z;
        a((ImageView) getHostView());
    }

    public void setSrc(String str) {
        if (getDomObject().c_().contains("gifPlayStateChange")) {
            Map hashMap = new HashMap();
            hashMap.put("state", "loading");
            hashMap.put("src", str);
            getInstance().a(getRef(), "gifPlayStateChange", hashMap);
        }
        super.setSrc(str);
        this.f = str;
        if (str != null) {
            this.b = com.uc.weex.component.i.b.b(str);
        }
    }

    protected ImageView initComponentHostView(Context context) {
        ImageView cVar = new c(context, this);
        cVar.setScaleType(ScaleType.FIT_XY);
        if (VERSION.SDK_INT >= 16) {
            cVar.setCropToPadding(true);
        }
        cVar.a((ap) this);
        return cVar;
    }

    final void a(ImageView imageView) {
        if (this.b && imageView != null && imageView.getDrawable() != null) {
            if (this.c) {
                this.e = 0;
                com.uc.weex.component.b.a().b().a(imageView.getDrawable(), new a(this, imageView));
                return;
            }
            com.uc.weex.component.b.a().b().a(imageView.getDrawable());
        }
    }

    @WXComponentProp(name = "loopCount")
    public void setLoopCount(int i) {
        this.d = i;
    }

    @WXComponentProp(name = "placeHolder")
    public void setPlaceHolder(String str) {
        com.uc.weex.component.b.a().a(str, (ImageView) getHostView());
    }

    static /* synthetic */ void d(b bVar) {
        if (bVar.getDomObject().c_().contains("gifPlayStateChange")) {
            Map hashMap = new HashMap();
            hashMap.put("state", "loopOver");
            hashMap.put("src", bVar.f);
            bVar.getInstance().a(bVar.getRef(), "gifPlayStateChange", hashMap);
        }
    }
}
