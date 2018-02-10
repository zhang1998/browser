package com.UCMobile.Apollo;

import com.UCMobile.Apollo.annotations.Keep;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class Global {
    public static final String APOLLO_SERIES = "2";
    public static final String EXT_KEY_APOLLO_STR = "apollo_str";
    public static final String EXT_KEY_MOV_SEGMENT_DURATION = "mov_seg_dur";
    public static final int EXT_TYPE_CD = 1;
    public static final int ID_BOOL_VALUE_TYPE = 1;
    public static final int ID_DOUBLE_VALUE_TYPE = 5;
    public static final int ID_FLOAT_VALUE_TYPE = 4;
    public static final int ID_INT_VALUE_TYPE = 2;
    public static final int ID_STRING_VALUE_TYPE = 3;
    public static final String[] LIBS_PATHS = new String[]{"apollo1/", "apollo2/"};
    private static List<ExtElement> a;
    public static String gApolloSoPath = "";
    public static boolean gLoadFromAppLibPath = false;

    @Keep
    /* compiled from: ProGuard */
    public class ExtElement {
        public String mDefalutValue;
        public String mKey;
        public int mType;

        public ExtElement(int i, String str, String str2) {
            this.mType = i;
            this.mKey = str;
            this.mDefalutValue = str2;
        }
    }

    static {
        List arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new ExtElement(2, EXT_KEY_MOV_SEGMENT_DURATION, SettingsConst.FALSE));
        a.add(new ExtElement(3, EXT_KEY_APOLLO_STR, ""));
    }

    public static List<ExtElement> getCDKeys() {
        return a;
    }
}
