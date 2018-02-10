package com.taobao.weex.ui.component;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.c;
import com.taobao.weex.c.b.r;
import com.taobao.weex.c.o;
import com.taobao.weex.common.k;
import com.taobao.weex.common.t;
import com.taobao.weex.ui.view.border.b;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import com.taobao.weex.utils.h;
import com.taobao.weex.utils.i;
import com.taobao.weex.utils.n;
import com.taobao.weex.utils.p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class ap extends ab<ImageView> {
    private static n<Integer> BLUR_RADIUS_MAPPER = new al();
    private static Map<Integer, LightingColorFilter> sColorFilter;
    private int mBlurRadius;
    private String mSrc;

    @Deprecated
    public ap(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public ap(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    public ImageView initComponentHostView(@NonNull Context context) {
        ImageView nVar = new com.taobao.weex.ui.view.n(context);
        nVar.setScaleType(ScaleType.FIT_XY);
        if (VERSION.SDK_INT >= 16) {
            nVar.setCropToPadding(true);
        }
        nVar.a(this);
        return nVar;
    }

    protected boolean setProperty(String str, Object obj) {
        int i = 0;
        int i2 = -1;
        switch (str.hashCode()) {
            case -1274492040:
                if (str.equals("filter")) {
                    i2 = 4;
                    break;
                }
                break;
            case -934437708:
                if (str.equals("resize")) {
                    i2 = 1;
                    break;
                }
                break;
            case -915939637:
                if (str.equals("filterColor")) {
                    i2 = 5;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    i2 = 2;
                    break;
                }
                break;
            case 1249477412:
                if (str.equals("imageQuality")) {
                    i2 = 3;
                    break;
                }
                break;
            case 2049757303:
                if (str.equals("resizeMode")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        String a;
        switch (i2) {
            case 0:
                a = ah.a(obj, null);
                if (a != null) {
                    setResizeMode(a);
                }
                return true;
            case 1:
                a = ah.a(obj, null);
                if (a != null) {
                    setResize(a);
                }
                return true;
            case 2:
                a = ah.a(obj, null);
                if (a != null) {
                    setSrc(a);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (obj != null && (obj instanceof String)) {
                    i = parseBlurRadius((String) obj);
                }
                if (!TextUtils.isEmpty(this.mSrc)) {
                    setBlurRadius(this.mSrc, i);
                }
                return true;
            case 5:
                setFilterColor(ah.a(obj, null));
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    public void refreshData(ab abVar) {
        super.refreshData(abVar);
        if (abVar instanceof ap) {
            String str;
            Object obj = abVar.getDomObject().i().get("src");
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            setSrc(str);
        }
    }

    @WXComponentProp(name = "resizeMode")
    public void setResizeMode(String str) {
        ((ImageView) getHostView()).setScaleType(getResizeMode(str));
    }

    private ScaleType getResizeMode(String str) {
        ScaleType scaleType = ScaleType.FIT_XY;
        if (TextUtils.isEmpty(str)) {
            return scaleType;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    obj = 2;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    obj = null;
                    break;
                }
                break;
            case 951526612:
                if (str.equals("contain")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return ScaleType.CENTER_CROP;
            case 1:
                return ScaleType.FIT_CENTER;
            case 2:
                return ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @WXComponentProp(name = "resize")
    public void setResize(String str) {
        ((ImageView) getHostView()).setScaleType(getResizeMode(str));
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
            ImageView imageView = (ImageView) getHostView();
            if (!"".equals(str) || imageView == null) {
                this.mSrc = str;
                Uri a = getInstance().a(Uri.parse(str));
                if ("local".equals(a.getScheme())) {
                    setLocalSrc(a);
                    return;
                }
                int i = 0;
                if (getDomObject() != null) {
                    i = parseBlurRadius(getDomObject().g().a());
                }
                setRemoteSrc(a, i);
                return;
            }
            imageView.setImageDrawable(null);
        }
    }

    private void setBlurRadius(@NonNull String str, int i) {
        if (getInstance() != null && i != this.mBlurRadius) {
            Uri a = getInstance().a(Uri.parse(str));
            if (!"local".equals(a.getScheme())) {
                setRemoteSrc(a, i);
            }
        }
    }

    private int parseBlurRadius(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        try {
            List a = new p(str, BLUR_RADIUS_MAPPER).a("blur");
            if (a == null || a.isEmpty()) {
                return 0;
            }
            return ((Integer) a.get(0)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public void recycled() {
        super.recycled();
        getInstance();
        if (ac.d() != null) {
            getInstance();
            ac.d().a(null, (ImageView) this.mHost, 0, null);
        } else if (com.taobao.weex.i.c()) {
            throw new t("getImgLoaderAdapter() == null");
        } else {
            WXLogUtils.e("Error getImgLoaderAdapter() == null");
        }
    }

    private void setRemoteSrc(Uri uri, int i) {
        boolean z = true;
        k kVar = new k();
        kVar.a = true;
        if (getDomObject().i().b() != com.taobao.weex.common.i.b) {
            z = false;
        }
        kVar.b = z;
        kVar.c = Math.max(0, i);
        this.mBlurRadius = i;
        kVar.e = new am(this);
        String str = null;
        if (getDomObject().i().containsKey("placeholder")) {
            str = (String) getDomObject().i().get("placeholder");
        } else if (getDomObject().i().containsKey("placeHolder")) {
            str = (String) getDomObject().i().get("placeHolder");
        }
        if (str != null) {
            kVar.d = getInstance().a(Uri.parse(str)).toString();
        }
        getInstance();
        com.taobao.weex.a.k d = ac.d();
        if (d != null) {
            d.a(uri.toString(), (ImageView) getHostView(), getDomObject().i().a(), kVar);
        }
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        o domObject = getDomObject();
        if (domObject != null && (getHostView() instanceof com.taobao.weex.ui.view.n)) {
            float[] fArr;
            com.taobao.weex.ui.view.n nVar = (com.taobao.weex.ui.view.n) getHostView();
            b b = WXViewUtils.b(getHostView());
            if (b != null) {
                float a = com.taobao.weex.utils.t.a(domObject);
                float p = domObject.p();
                r k = domObject.k();
                r l = domObject.l();
                float a2 = k.a(1);
                if (!c.a(a2)) {
                    p -= a2;
                }
                float a3 = k.a(3);
                if (!c.a(a3)) {
                    p -= a3;
                }
                a3 = l.a(1);
                if (!c.a(a3)) {
                    p -= a3;
                }
                float a4 = l.a(3);
                if (!c.a(a4)) {
                    p -= a4;
                }
                b.a(new RectF(0.0f, 0.0f, a, p));
                a4 = b.a(b.b, 0);
                float a5 = b.a(b.b, 1);
                a = b.a(b.b, 2);
                float a6 = b.a(b.b, 3);
                fArr = new float[]{a4, a4, a5, a5, a, a, a6, a6};
            } else {
                fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            nVar.setBorderRadius(fArr);
            if (nVar.getDrawable() instanceof h) {
                h hVar = (h) nVar.getDrawable();
                if (!Arrays.equals(hVar.a, fArr)) {
                    hVar.setCornerRadii(fArr);
                }
            }
            readyToRender();
        }
    }

    private void setFilterColor(String str) {
        if (str == null || str.trim().length() == 0 || "none".equalsIgnoreCase(str) || "null".equalsIgnoreCase(str)) {
            ((ImageView) this.mHost).clearColorFilter();
            return;
        }
        ColorFilter colorFilter;
        if (sColorFilter == null) {
            sColorFilter = new HashMap();
        }
        int a = af.a(str);
        ColorFilter colorFilter2 = (LightingColorFilter) sColorFilter.get(Integer.valueOf(a));
        if (colorFilter2 == null) {
            colorFilter2 = new LightingColorFilter(a, 0);
            sColorFilter.put(Integer.valueOf(a), colorFilter2);
            colorFilter = colorFilter2;
        } else {
            colorFilter = colorFilter2;
        }
        ((ImageView) this.mHost).setColorFilter(colorFilter);
    }
}
