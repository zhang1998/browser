package com.taobao.weex.utils;

import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public final class af {
    private static final Map<String, Integer> a = new HashMap();
    private static final ArrayList<z> b = new ArrayList();
    private static final n<Integer> c = new x();
    private static final o<Number> d = new y();

    static {
        a.put("aliceblue", Integer.valueOf(-984833));
        a.put("antiquewhite", Integer.valueOf(-332841));
        a.put("aqua", Integer.valueOf(-16711681));
        a.put("aquamarine", Integer.valueOf(-8388652));
        a.put("azure", Integer.valueOf(-983041));
        a.put("beige", Integer.valueOf(-657956));
        a.put("bisque", Integer.valueOf(-6972));
        a.put("black", Integer.valueOf(-16777216));
        a.put("blanchedalmond", Integer.valueOf(-5171));
        a.put("blue", Integer.valueOf(-16776961));
        a.put("blueviolet", Integer.valueOf(-7722014));
        a.put("brown", Integer.valueOf(-5952982));
        a.put("burlywood", Integer.valueOf(-2180985));
        a.put("cadetblue", Integer.valueOf(-10510688));
        a.put("chartreuse", Integer.valueOf(-8388864));
        a.put("chocolate", Integer.valueOf(-2987746));
        a.put("coral", Integer.valueOf(-32944));
        a.put("cornflowerblue", Integer.valueOf(-10185235));
        a.put("cornsilk", Integer.valueOf(-1828));
        a.put("crimson", Integer.valueOf(-2354116));
        a.put("cyan", Integer.valueOf(-16711681));
        a.put("darkblue", Integer.valueOf(-16777077));
        a.put("darkcyan", Integer.valueOf(-16741493));
        a.put("darkgoldenrod", Integer.valueOf(-4684277));
        a.put("darkgray", Integer.valueOf(-5658199));
        a.put("darkgreen", Integer.valueOf(-16751616));
        a.put("darkkhaki", Integer.valueOf(-4343957));
        a.put("darkmagenta", Integer.valueOf(-7667573));
        a.put("darkolivegreen", Integer.valueOf(-11179217));
        a.put("darkorange", Integer.valueOf(-29696));
        a.put("darkorchid", Integer.valueOf(-6737204));
        a.put("darkred", Integer.valueOf(-7667712));
        a.put("darksalmon", Integer.valueOf(-1468806));
        a.put("darkseagreen", Integer.valueOf(-7357297));
        a.put("darkslateblue", Integer.valueOf(-12042869));
        a.put("darkslategray", Integer.valueOf(-13676721));
        a.put("darkslategrey", Integer.valueOf(-13676721));
        a.put("darkturquoise", Integer.valueOf(-16724271));
        a.put("darkviolet", Integer.valueOf(-7077677));
        a.put("deeppink", Integer.valueOf(-60269));
        a.put("deepskyblue", Integer.valueOf(-16728065));
        a.put("dimgray", Integer.valueOf(-9868951));
        a.put("dimgrey", Integer.valueOf(-9868951));
        a.put("dodgerblue", Integer.valueOf(-14774017));
        a.put("firebrick", Integer.valueOf(-5103070));
        a.put("floralwhite", Integer.valueOf(-1296));
        a.put("forestgreen", Integer.valueOf(-14513374));
        a.put("fuchsia", Integer.valueOf(-65281));
        a.put("gainsboro", Integer.valueOf(-2302756));
        a.put("ghostwhite", Integer.valueOf(-460545));
        a.put("gold", Integer.valueOf(-10496));
        a.put("goldenrod", Integer.valueOf(-2448096));
        a.put("gray", Integer.valueOf(-8355712));
        a.put("grey", Integer.valueOf(-8355712));
        a.put("green", Integer.valueOf(-16744448));
        a.put("greenyellow", Integer.valueOf(-5374161));
        a.put("honeydew", Integer.valueOf(-983056));
        a.put("hotpink", Integer.valueOf(-38476));
        a.put("indianred", Integer.valueOf(-3318692));
        a.put("indigo", Integer.valueOf(-11861886));
        a.put("ivory", Integer.valueOf(-16));
        a.put("khaki", Integer.valueOf(-989556));
        a.put("lavender", Integer.valueOf(-1644806));
        a.put("lavenderblush", Integer.valueOf(-3851));
        a.put("lawngreen", Integer.valueOf(-8586240));
        a.put("lemonchiffon", Integer.valueOf(-1331));
        a.put("lightblue", Integer.valueOf(-5383962));
        a.put("lightcoral", Integer.valueOf(-1015680));
        a.put("lightcyan", Integer.valueOf(-2031617));
        a.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        a.put("lightgray", Integer.valueOf(-2894893));
        a.put("lightgrey", Integer.valueOf(-2894893));
        a.put("lightgreen", Integer.valueOf(-7278960));
        a.put("lightpink", Integer.valueOf(-18751));
        a.put("lightsalmon", Integer.valueOf(-24454));
        a.put("lightseagreen", Integer.valueOf(-14634326));
        a.put("lightskyblue", Integer.valueOf(-7876870));
        a.put("lightslategray", Integer.valueOf(-8943463));
        a.put("lightslategrey", Integer.valueOf(-8943463));
        a.put("lightsteelblue", Integer.valueOf(-5192482));
        a.put("lightyellow", Integer.valueOf(-32));
        a.put("lime", Integer.valueOf(-16711936));
        a.put("limegreen", Integer.valueOf(-13447886));
        a.put("linen", Integer.valueOf(-331546));
        a.put("magenta", Integer.valueOf(-65281));
        a.put("maroon", Integer.valueOf(-8388608));
        a.put("mediumaquamarine", Integer.valueOf(-10039894));
        a.put("mediumblue", Integer.valueOf(-16777011));
        a.put("mediumorchid", Integer.valueOf(-4565549));
        a.put("mediumpurple", Integer.valueOf(-7114533));
        a.put("mediumseagreen", Integer.valueOf(-12799119));
        a.put("mediumslateblue", Integer.valueOf(-8689426));
        a.put("mediumspringgreen", Integer.valueOf(-16713062));
        a.put("mediumturquoise", Integer.valueOf(-12004916));
        a.put("mediumvioletred", Integer.valueOf(-3730043));
        a.put("midnightblue", Integer.valueOf(-15132304));
        a.put("mintcream", Integer.valueOf(-655366));
        a.put("mistyrose", Integer.valueOf(-6943));
        a.put("moccasin", Integer.valueOf(-6987));
        a.put("navajowhite", Integer.valueOf(-8531));
        a.put("navy", Integer.valueOf(-16777088));
        a.put("oldlace", Integer.valueOf(-133658));
        a.put("olive", Integer.valueOf(-8355840));
        a.put("olivedrab", Integer.valueOf(-9728477));
        a.put("orange", Integer.valueOf(-23296));
        a.put("orangered", Integer.valueOf(-47872));
        a.put("orchid", Integer.valueOf(-2461482));
        a.put("palegoldenrod", Integer.valueOf(-1120086));
        a.put("palegreen", Integer.valueOf(-6751336));
        a.put("paleturquoise", Integer.valueOf(-5247250));
        a.put("palevioletred", Integer.valueOf(-2396013));
        a.put("papayawhip", Integer.valueOf(-4139));
        a.put("peachpuff", Integer.valueOf(-9543));
        a.put("peru", Integer.valueOf(-3308225));
        a.put("pink", Integer.valueOf(-16181));
        a.put("plum", Integer.valueOf(-2252579));
        a.put("powderblue", Integer.valueOf(-5185306));
        a.put("purple", Integer.valueOf(-8388480));
        a.put("rebeccapurple", Integer.valueOf(-10079335));
        a.put("red", Integer.valueOf(-65536));
        a.put("rosybrown", Integer.valueOf(-4419697));
        a.put("royalblue", Integer.valueOf(-12490271));
        a.put("saddlebrown", Integer.valueOf(-7650029));
        a.put("salmon", Integer.valueOf(-360334));
        a.put("sandybrown", Integer.valueOf(-744352));
        a.put("seagreen", Integer.valueOf(-13726889));
        a.put("seashell", Integer.valueOf(-2578));
        a.put("sienna", Integer.valueOf(-6270419));
        a.put("silver", Integer.valueOf(-4144960));
        a.put("skyblue", Integer.valueOf(-7876885));
        a.put("slateblue", Integer.valueOf(-9807155));
        a.put("slategray", Integer.valueOf(-9404272));
        a.put("slategrey", Integer.valueOf(-9404272));
        a.put("snow", Integer.valueOf(-1286));
        a.put("springgreen", Integer.valueOf(-16711809));
        a.put("steelblue", Integer.valueOf(-12156236));
        a.put("tan", Integer.valueOf(-2968436));
        a.put("teal", Integer.valueOf(-16744320));
        a.put("thistle", Integer.valueOf(-2572328));
        a.put("tomato", Integer.valueOf(-40121));
        a.put("turquoise", Integer.valueOf(-12525360));
        a.put("violet", Integer.valueOf(-1146130));
        a.put("wheat", Integer.valueOf(-663885));
        a.put("white", Integer.valueOf(-1));
        a.put("whitesmoke", Integer.valueOf(-657931));
        a.put("yellow", Integer.valueOf(-256));
        a.put("yellowgreen", Integer.valueOf(-6632142));
        a.put("transparent", Integer.valueOf(0));
        b.add(new ae());
        b.add(new ab());
        b.add(new ac());
        b.add(new ad());
    }

    public static int a(String str) {
        return a(str, SectionHeader.SHT_LOUSER);
    }

    public static int a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            try {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    aa a = ((z) it.next()).a(trim);
                    if (a.a) {
                        i = a.b;
                        break;
                    }
                }
            } catch (Throwable e) {
                WXLogUtils.v("Color_Parser", WXLogUtils.getStackTrace(e));
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Shader a(java.lang.String r10, float r11, float r12) {
        /*
        r1 = 0;
        r4 = 3;
        r6 = 2;
        r5 = 1;
        r2 = 0;
        r0 = android.text.TextUtils.isEmpty(r10);
        if (r0 != 0) goto L_0x00f0;
    L_0x000b:
        r10.trim();
        r0 = "linear-gradient";
        r0 = r10.startsWith(r0);
        if (r0 == 0) goto L_0x00f0;
    L_0x0016:
        r0 = "(";
        r0 = r10.indexOf(r0);
        r0 = r0 + 1;
        r3 = ")";
        r3 = r10.lastIndexOf(r3);
        r0 = r10.substring(r0, r3);
        r7 = new java.util.StringTokenizer;
        r3 = ",";
        r7.<init>(r0, r3);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r1;
    L_0x0035:
        r8 = r7.hasMoreTokens();
        if (r8 == 0) goto L_0x0097;
    L_0x003b:
        r8 = r7.nextToken();
        r9 = "(";
        r9 = r8.contains(r9);
        if (r9 == 0) goto L_0x005b;
    L_0x0047:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r8);
        r8 = ",";
        r0 = r0.append(r8);
        r0 = r0.toString();
        goto L_0x0035;
    L_0x005b:
        r9 = ")";
        r9 = r8.contains(r9);
        if (r9 == 0) goto L_0x0079;
    L_0x0063:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r9.append(r0);
        r0 = r0.append(r8);
        r0 = r0.toString();
        r3.add(r0);
        r0 = r1;
        goto L_0x0035;
    L_0x0079:
        if (r0 == 0) goto L_0x0093;
    L_0x007b:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r9.append(r0);
        r0 = r0.append(r8);
        r8 = ",";
        r0 = r0.append(r8);
        r0 = r0.toString();
        goto L_0x0035;
    L_0x0093:
        r3.add(r8);
        goto L_0x0035;
    L_0x0097:
        r7 = r3;
    L_0x0098:
        if (r7 == 0) goto L_0x0144;
    L_0x009a:
        r0 = r7.size();
        if (r0 != r4) goto L_0x0144;
    L_0x00a0:
        r0 = r7.get(r2);
        r0 = (java.lang.String) r0;
        r1 = 4;
        r8 = new float[r1];
        r8 = {0, 0, 0, 0};
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00be;
    L_0x00b2:
        r1 = "\\s*";
        r3 = "";
        r0 = r0.replaceAll(r1, r3);
        r0 = r0.toLowerCase();
    L_0x00be:
        r1 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1352032154: goto L_0x0106;
            case -1137407871: goto L_0x00f2;
            case -868157182: goto L_0x00fc;
            case -172068863: goto L_0x0124;
            case 110550266: goto L_0x0110;
            case 1176531318: goto L_0x011a;
            default: goto L_0x00c6;
        };
    L_0x00c6:
        r0 = r1;
    L_0x00c7:
        switch(r0) {
            case 0: goto L_0x012e;
            case 1: goto L_0x0131;
            case 2: goto L_0x0134;
            case 3: goto L_0x0137;
            case 4: goto L_0x013a;
            case 5: goto L_0x013f;
            default: goto L_0x00ca;
        };
    L_0x00ca:
        r0 = new android.graphics.LinearGradient;
        r1 = r8[r2];
        r2 = r8[r5];
        r3 = r8[r6];
        r4 = r8[r4];
        r5 = r7.get(r5);
        r5 = (java.lang.String) r5;
        r8 = -1;
        r5 = a(r5, r8);
        r6 = r7.get(r6);
        r6 = (java.lang.String) r6;
        r7 = -1;
        r6 = a(r6, r7);
        r7 = android.graphics.Shader.TileMode.REPEAT;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
    L_0x00ef:
        return r0;
    L_0x00f0:
        r7 = r1;
        goto L_0x0098;
    L_0x00f2:
        r3 = "toright";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x00fa:
        r0 = r2;
        goto L_0x00c7;
    L_0x00fc:
        r3 = "toleft";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x0104:
        r0 = r5;
        goto L_0x00c7;
    L_0x0106:
        r3 = "tobottom";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x010e:
        r0 = r6;
        goto L_0x00c7;
    L_0x0110:
        r3 = "totop";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x0118:
        r0 = r4;
        goto L_0x00c7;
    L_0x011a:
        r3 = "tobottomright";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x0122:
        r0 = 4;
        goto L_0x00c7;
    L_0x0124:
        r3 = "totopleft";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x012c:
        r0 = 5;
        goto L_0x00c7;
    L_0x012e:
        r8[r6] = r11;
        goto L_0x00ca;
    L_0x0131:
        r8[r2] = r11;
        goto L_0x00ca;
    L_0x0134:
        r8[r4] = r12;
        goto L_0x00ca;
    L_0x0137:
        r8[r5] = r12;
        goto L_0x00ca;
    L_0x013a:
        r8[r6] = r11;
        r8[r4] = r12;
        goto L_0x00ca;
    L_0x013f:
        r8[r2] = r11;
        r8[r5] = r12;
        goto L_0x00ca;
    L_0x0144:
        r0 = r1;
        goto L_0x00ef;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.af.a(java.lang.String, float, float):android.graphics.Shader");
    }
}
