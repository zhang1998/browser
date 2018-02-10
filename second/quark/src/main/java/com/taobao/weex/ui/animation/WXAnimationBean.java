package com.taobao.weex.ui.animation;

import android.animation.PropertyValuesHolder;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.b;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.taobao.weex.utils.f;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class WXAnimationBean {
    public static final String CUBIC_BEZIER = "cubic-bezier";
    public static final String EASE_IN = "ease-in";
    public static final String EASE_IN_OUT = "ease-in-out";
    public static final String EASE_OUT = "ease-out";
    public static final String LINEAR = "linear";
    public static final int NUM_CUBIC_PARAM = 4;
    public long delay;
    public long duration;
    public boolean needLayout;
    public Style styles;
    public String timingFunction;

    /* compiled from: ProGuard */
    public class Style {
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String BOTTOM = "bottom";
        public static final String CENTER = "center";
        public static final String HEIGHT = "height";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
        public static final String TOP = "top";
        public static final String WIDTH = "width";
        public static final String WX_ROTATE = "rotate";
        public static final String WX_SCALE = "scale";
        public static final String WX_SCALE_X = "scaleX";
        public static final String WX_SCALE_Y = "scaleY";
        public static final String WX_TRANSLATE = "translate";
        public static final String WX_TRANSLATE_X = "translateX";
        public static final String WX_TRANSLATE_Y = "translateY";
        public static Map<String, List<Property<View, Float>>> wxToAndroidMap;
        private Map<Property<View, Float>, Float> a = new HashMap();
        private Pair<Float, Float> b;
        public String backgroundColor;
        private List<PropertyValuesHolder> c = new LinkedList();
        public String height;
        public String opacity;
        public String transform;
        public String transformOrigin;
        public String width;

        static {
            Map hashMap = new HashMap();
            wxToAndroidMap = hashMap;
            hashMap.put(WX_TRANSLATE, Arrays.asList(new Property[]{View.TRANSLATION_X, View.TRANSLATION_Y}));
            wxToAndroidMap.put(WX_TRANSLATE_X, Collections.singletonList(View.TRANSLATION_X));
            wxToAndroidMap.put(WX_TRANSLATE_Y, Collections.singletonList(View.TRANSLATION_Y));
            wxToAndroidMap.put(WX_ROTATE, Collections.singletonList(View.ROTATION));
            wxToAndroidMap.put("scale", Arrays.asList(new Property[]{View.SCALE_X, View.SCALE_Y}));
            wxToAndroidMap.put(WX_SCALE_X, Collections.singletonList(View.SCALE_X));
            wxToAndroidMap.put(WX_SCALE_Y, Collections.singletonList(View.SCALE_Y));
            wxToAndroidMap = Collections.unmodifiableMap(wxToAndroidMap);
        }

        private static float b(String str, int i, int i2) {
            int lastIndexOf = str.lastIndexOf(37);
            if (lastIndexOf != -1) {
                return (ah.a(str.substring(0, lastIndexOf), 1) / 100.0f) * ((float) i);
            }
            lastIndexOf = str.lastIndexOf("px");
            if (lastIndexOf != -1) {
                return WXViewUtils.a(ah.a(str.substring(0, lastIndexOf), 1), i2);
            }
            return WXViewUtils.a(ah.a(str, 1), i2);
        }

        @Nullable
        public Pair<Float, Float> getPivot() {
            return this.b;
        }

        public void init(@Nullable String str, @Nullable String str2, int i, int i2, int i3) {
            Pair pair;
            Map bVar;
            Map map;
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf(32);
                if (indexOf != -1) {
                    int i4 = indexOf;
                    while (i4 < str.length() && str.charAt(i4) == ' ') {
                        i4++;
                    }
                    if (i4 < str.length() && str.charAt(i4) != ' ') {
                        List arrayList = new ArrayList(2);
                        arrayList.add(str.substring(0, indexOf).trim());
                        arrayList.add(str.substring(i4, str.length()).trim());
                        String str3 = (String) arrayList.get(0);
                        if (LEFT.equals(str3)) {
                            str3 = "0%";
                        } else if (RIGHT.equals(str3)) {
                            str3 = "100%";
                        } else if (CENTER.equals(str3)) {
                            str3 = "50%";
                        }
                        Float valueOf = Float.valueOf(b(str3, i, i3));
                        str3 = (String) arrayList.get(1);
                        if (TOP.equals(str3)) {
                            str3 = "0%";
                        } else if (BOTTOM.equals(str3)) {
                            str3 = "100%";
                        } else if (CENTER.equals(str3)) {
                            str3 = "50%";
                        }
                        pair = new Pair(valueOf, Float.valueOf(b(str3, i2, i3)));
                        this.b = pair;
                        bVar = new b(5);
                        bVar.put(View.TRANSLATION_X, Float.valueOf(0.0f));
                        bVar.put(View.TRANSLATION_Y, Float.valueOf(0.0f));
                        bVar.put(View.SCALE_X, Float.valueOf(IPictureView.DEFAULT_MIN_SCALE));
                        bVar.put(View.SCALE_Y, Float.valueOf(IPictureView.DEFAULT_MIN_SCALE));
                        bVar.put(View.ROTATION, Float.valueOf(0.0f));
                        this.a = bVar;
                        map = this.a;
                        if (TextUtils.isEmpty(str2)) {
                            bVar = new f(str2, new c(i, i2, i3)).a();
                        } else {
                            bVar = new LinkedHashMap();
                        }
                        map.putAll(bVar);
                        a();
                    }
                }
            }
            pair = null;
            this.b = pair;
            bVar = new b(5);
            bVar.put(View.TRANSLATION_X, Float.valueOf(0.0f));
            bVar.put(View.TRANSLATION_Y, Float.valueOf(0.0f));
            bVar.put(View.SCALE_X, Float.valueOf(IPictureView.DEFAULT_MIN_SCALE));
            bVar.put(View.SCALE_Y, Float.valueOf(IPictureView.DEFAULT_MIN_SCALE));
            bVar.put(View.ROTATION, Float.valueOf(0.0f));
            this.a = bVar;
            map = this.a;
            if (TextUtils.isEmpty(str2)) {
                bVar = new LinkedHashMap();
            } else {
                bVar = new f(str2, new c(i, i2, i3)).a();
            }
            map.putAll(bVar);
            a();
        }

        private void a() {
            for (Entry entry : this.a.entrySet()) {
                this.c.add(PropertyValuesHolder.ofFloat((Property) entry.getKey(), new float[]{((Float) entry.getValue()).floatValue()}));
            }
            if (!TextUtils.isEmpty(this.opacity)) {
                this.c.add(PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{ah.a(this.opacity, 3)}));
            }
        }

        public List<PropertyValuesHolder> getHolders() {
            return this.c;
        }
    }
}
