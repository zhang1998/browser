package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class as {
    private static final Map<String, bf> a;
    private static final v b = new v();

    static /* synthetic */ Pair a(String str, View view) {
        float f = 0.0f;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i = indexOf;
                while (i < str.length() && str.charAt(i) == ' ') {
                    i++;
                }
                if (i < str.length() && str.charAt(i) != ' ') {
                    float f2;
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(i, str.length()).trim();
                    if (Style.LEFT.equals(trim)) {
                        f2 = 0.0f;
                    } else if (Style.RIGHT.equals(trim)) {
                        f2 = (float) view.getWidth();
                    } else {
                        Style.CENTER.equals(trim);
                        f2 = (float) (view.getWidth() / 2);
                    }
                    if (!Style.TOP.equals(trim2)) {
                        if (Style.BOTTOM.equals(trim2)) {
                            f = (float) view.getHeight();
                        } else {
                            Style.CENTER.equals(trim2);
                            f = (float) (view.getHeight() / 2);
                        }
                    }
                    return new Pair(Float.valueOf(f2), Float.valueOf(f));
                }
            }
        }
        return null;
    }

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put("opacity", new x());
        a.put("transform.translate", new al());
        a.put("transform.translateX", new an());
        a.put("transform.translateY", new ap());
        a.put("transform.scale", new af());
        a.put("transform.scaleX", new ah());
        a.put("transform.scaleY", new aj());
        a.put("transform.rotate", new z());
        a.put("transform.rotateZ", new z());
        a.put("transform.rotateX", new ab());
        a.put("transform.rotateY", new ad());
        a.put(Style.WIDTH, new ar());
        a.put(Style.HEIGHT, new u());
        a.put("background-color", new l());
        a.put("scroll.contentOffset", new o());
        a.put("scroll.contentOffsetX", new q());
        a.put("scroll.contentOffsetY", new s());
    }

    @NonNull
    static bf a(@NonNull String str) {
        bf bfVar = (bf) a.get(str);
        if (bfVar != null) {
            return bfVar;
        }
        WXLogUtils.e("ExpressionInvoker", "unknown property [" + str + "]");
        return b;
    }

    static /* synthetic */ View a(ab abVar) {
        if (abVar instanceof be) {
            return ((be) abVar).d();
        }
        if (i.c()) {
            Log.e("ExpressionInvoker", "scroll offset only support on Scroller Component");
        }
        return null;
    }

    static /* synthetic */ double a(double d, ac acVar) {
        int i;
        if (acVar == null) {
            i = i.i;
        } else {
            i = acVar.o;
        }
        return WXViewUtils.a(d, i);
    }

    static /* synthetic */ void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.post(runnable);
        }
    }
}
