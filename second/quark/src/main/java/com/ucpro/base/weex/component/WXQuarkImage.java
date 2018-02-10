package com.ucpro.base.weex.component;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Keep;
import android.widget.ImageView;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.k;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ap;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.i;

@Keep
@Component(lazyload = false)
/* compiled from: ProGuard */
public class WXQuarkImage extends ap {
    public WXQuarkImage(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    private void setLocalSrc(Uri uri) {
        Drawable a = i.a(getContext(), uri);
        if (a != null) {
            ImageView imageView = (ImageView) getHostView();
            if (imageView != null) {
                imageView.setImageDrawable(a);
            }
        }
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        if (str != null) {
            Uri a = getInstance().a(Uri.parse(str));
            if ("local".equals(a.getScheme())) {
                setLocalSrc(a);
            } else {
                setRemoteSrc(a);
            }
        }
    }

    private void setRemoteSrc(Uri uri) {
        int i = 1;
        k kVar = new k();
        kVar.a = i;
        kVar.b = getDomObject().i().b() == com.taobao.weex.common.i.b ? i : false;
        String a = getDomObject().g().a();
        if (a != null) {
            try {
                i = Integer.valueOf(a).intValue();
            } catch (Exception e) {
            }
        }
        kVar.c = Math.min(10, Math.max(0, i));
        kVar.e = new e(this);
        a = null;
        if (getDomObject().i().containsKey("placeholder")) {
            a = (String) getDomObject().i().get("placeholder");
        } else if (getDomObject().i().containsKey("placeHolder")) {
            a = (String) getDomObject().i().get("placeHolder");
        }
        if (a != null) {
            kVar.d = getInstance().a(Uri.parse(a)).toString();
        }
        getInstance();
        com.taobao.weex.a.k d = ac.d();
        if (d != null) {
            d.a(uri.toString(), (ImageView) getHostView(), getDomObject().i().a(), kVar);
        }
    }
}
