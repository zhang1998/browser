package com.taobao.weex.ui.animation;

import android.mini.support.annotation.NonNull;
import android.util.Property;
import android.view.View;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.ah;
import com.taobao.weex.utils.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class c implements com.taobao.weex.utils.c<Property<View, Float>, Float> {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    c(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final Map<Property<View, Float>, Float> a(String str, List<String> list) {
        if (list.isEmpty() || !Style.wxToAndroidMap.containsKey(str)) {
            return new HashMap();
        }
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        List list2 = (List) Style.wxToAndroidMap.get(str);
        Map<Property<View, Float>, Float> a = s.a(list2.size());
        List arrayList = new ArrayList(list2.size());
        if (list2.contains(View.ROTATION)) {
            arrayList.addAll(a(list));
        } else if (list2.contains(View.TRANSLATION_X) || list2.contains(View.TRANSLATION_Y)) {
            List arrayList2 = new ArrayList(2);
            String str2 = (String) list.get(0);
            if (list2.size() != 1) {
                String str3;
                if (list.size() == 1) {
                    str3 = str2;
                } else {
                    str3 = (String) list.get(1);
                }
                arrayList2.add(Float.valueOf(Style.b(str2, i, i3)));
                arrayList2.add(Float.valueOf(Style.b(str3, i2, i3)));
            } else if (list2.contains(View.TRANSLATION_X)) {
                arrayList2.add(Float.valueOf(Style.b(str2, i, i3)));
            } else if (list2.contains(View.TRANSLATION_Y)) {
                arrayList2.add(Float.valueOf(Style.b(str2, i2, i3)));
            }
            arrayList.addAll(arrayList2);
        } else if (list2.contains(View.SCALE_X) || list2.contains(View.SCALE_Y)) {
            arrayList.addAll(a(list2.size(), (List) list));
        }
        if (list2.size() == arrayList.size()) {
            for (int i4 = 0; i4 < list2.size(); i4++) {
                a.put(list2.get(i4), arrayList.get(i4));
            }
        }
        return a;
    }

    private static List<Float> a(int i, @NonNull List<String> list) {
        List<Float> arrayList = new ArrayList(list.size() * 2);
        Collection arrayList2 = new ArrayList(list.size());
        for (String a : list) {
            arrayList2.add(Float.valueOf(ah.a(a)));
        }
        arrayList.addAll(arrayList2);
        if (i != 1 && list.size() == 1) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private static List<Float> a(@NonNull List<String> list) {
        List<Float> arrayList = new ArrayList(1);
        for (String str : list) {
            int lastIndexOf = str.lastIndexOf("deg");
            if (lastIndexOf != -1) {
                arrayList.add(Float.valueOf(ah.a(str.substring(0, lastIndexOf))));
            } else {
                arrayList.add(Float.valueOf((float) Math.toDegrees(Double.parseDouble(str))));
            }
        }
        return arrayList;
    }
}
