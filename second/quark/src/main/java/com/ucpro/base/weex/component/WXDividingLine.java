package com.ucpro.base.weex.component;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

@Keep
/* compiled from: ProGuard */
public class WXDividingLine extends ab<ViewGroup> {
    private static final int DEFAULT_LINE_HEIGHT_PX = 1;
    private View mDividingLine;

    public WXDividingLine(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    protected ViewGroup initComponentHostView(@NonNull Context context) {
        ViewGroup frameLayout = new FrameLayout(context);
        this.mDividingLine = new View(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.gravity = 17;
        frameLayout.addView(this.mDividingLine, layoutParams);
        this.mDividingLine.setBackgroundColor(-16777216);
        return frameLayout;
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 1287124693:
                if (str.equals(Style.BACKGROUND_COLOR)) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                obj2 = ah.a(obj, null);
                if (!(this.mDividingLine == null || TextUtils.isEmpty(obj2))) {
                    int a = af.a(obj2);
                    if (a != SectionHeader.SHT_LOUSER) {
                        this.mDividingLine.setBackgroundColor(a);
                    }
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }
}
