package com.UCMobile.Apollo.text.a;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.UCMobile.Apollo.util.c;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class b {
    public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern b = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern c = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder d = new StringBuilder();

    /* compiled from: ProGuard */
    final class a {
        public final String a;
        public final int b;

        public a(String str, int i) {
            this.b = i;
            this.a = str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r9, com.UCMobile.Apollo.text.a.a.a r10) {
        /*
        r4 = 2;
        r3 = 1;
        r2 = -1;
        r1 = 0;
        r0 = c;
        r5 = r0.matcher(r9);
    L_0x000a:
        r0 = r5.find();
        if (r0 == 0) goto L_0x011b;
    L_0x0010:
        r6 = r5.group(r3);
        r0 = r5.group(r4);
        r7 = "line";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r7 == 0) goto L_0x006b;
    L_0x0020:
        r6 = 44;
        r6 = r0.indexOf(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r6 == r2) goto L_0x005b;
    L_0x0028:
        r7 = r6 + 1;
        r7 = r0.substring(r7);	 Catch:{ NumberFormatException -> 0x004b }
        r7 = a(r7);	 Catch:{ NumberFormatException -> 0x004b }
        r10.g = r7;	 Catch:{ NumberFormatException -> 0x004b }
        r7 = 0;
        r0 = r0.substring(r7, r6);	 Catch:{ NumberFormatException -> 0x004b }
    L_0x0039:
        r6 = "%";
        r6 = r0.endsWith(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r6 == 0) goto L_0x0060;
    L_0x0041:
        r0 = com.UCMobile.Apollo.text.a.d.b(r0);	 Catch:{ NumberFormatException -> 0x004b }
        r10.e = r0;	 Catch:{ NumberFormatException -> 0x004b }
        r0 = 0;
        r10.f = r0;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x004b:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;
        r6 = "Skipping bad cue setting: ";
        r0.<init>(r6);
        r6 = r5.group();
        r0.append(r6);
        goto L_0x000a;
    L_0x005b:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10.g = r6;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x0039;
    L_0x0060:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x004b }
        r0 = (float) r0;	 Catch:{ NumberFormatException -> 0x004b }
        r10.e = r0;	 Catch:{ NumberFormatException -> 0x004b }
        r0 = 1;
        r10.f = r0;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x006b:
        r7 = "align";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r7 == 0) goto L_0x00c7;
    L_0x0073:
        r6 = r0.hashCode();	 Catch:{ NumberFormatException -> 0x004b }
        switch(r6) {
            case -1364013995: goto L_0x0096;
            case -1074341483: goto L_0x00a0;
            case 100571: goto L_0x00aa;
            case 3317767: goto L_0x008c;
            case 108511772: goto L_0x00b4;
            case 109757538: goto L_0x0082;
            default: goto L_0x007a;
        };	 Catch:{ NumberFormatException -> 0x004b }
    L_0x007a:
        r0 = r2;
    L_0x007b:
        switch(r0) {
            case 0: goto L_0x00be;
            case 1: goto L_0x00be;
            case 2: goto L_0x00c1;
            case 3: goto L_0x00c1;
            case 4: goto L_0x00c4;
            case 5: goto L_0x00c4;
            default: goto L_0x007e;
        };	 Catch:{ NumberFormatException -> 0x004b }
    L_0x007e:
        r0 = 0;
    L_0x007f:
        r10.d = r0;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x0082:
        r6 = "start";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x008a:
        r0 = r1;
        goto L_0x007b;
    L_0x008c:
        r6 = "left";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x0094:
        r0 = r3;
        goto L_0x007b;
    L_0x0096:
        r6 = "center";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x009e:
        r0 = r4;
        goto L_0x007b;
    L_0x00a0:
        r6 = "middle";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x00a8:
        r0 = 3;
        goto L_0x007b;
    L_0x00aa:
        r6 = "end";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x00b2:
        r0 = 4;
        goto L_0x007b;
    L_0x00b4:
        r6 = "right";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r0 == 0) goto L_0x007a;
    L_0x00bc:
        r0 = 5;
        goto L_0x007b;
    L_0x00be:
        r0 = android.text.Layout.Alignment.ALIGN_NORMAL;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x007f;
    L_0x00c1:
        r0 = android.text.Layout.Alignment.ALIGN_CENTER;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x007f;
    L_0x00c4:
        r0 = android.text.Layout.Alignment.ALIGN_OPPOSITE;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x007f;
    L_0x00c7:
        r7 = "position";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r7 == 0) goto L_0x00f5;
    L_0x00cf:
        r6 = 44;
        r6 = r0.indexOf(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r6 == r2) goto L_0x00f0;
    L_0x00d7:
        r7 = r6 + 1;
        r7 = r0.substring(r7);	 Catch:{ NumberFormatException -> 0x004b }
        r7 = a(r7);	 Catch:{ NumberFormatException -> 0x004b }
        r10.i = r7;	 Catch:{ NumberFormatException -> 0x004b }
        r7 = 0;
        r0 = r0.substring(r7, r6);	 Catch:{ NumberFormatException -> 0x004b }
    L_0x00e8:
        r0 = com.UCMobile.Apollo.text.a.d.b(r0);	 Catch:{ NumberFormatException -> 0x004b }
        r10.h = r0;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x00f0:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10.i = r6;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x00e8;
    L_0x00f5:
        r7 = "size";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004b }
        if (r7 == 0) goto L_0x0105;
    L_0x00fd:
        r0 = com.UCMobile.Apollo.text.a.d.b(r0);	 Catch:{ NumberFormatException -> 0x004b }
        r10.j = r0;	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x0105:
        r7 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x004b }
        r8 = "Unknown cue setting ";
        r7.<init>(r8);	 Catch:{ NumberFormatException -> 0x004b }
        r6 = r7.append(r6);	 Catch:{ NumberFormatException -> 0x004b }
        r7 = ":";
        r6 = r6.append(r7);	 Catch:{ NumberFormatException -> 0x004b }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x004b }
        goto L_0x000a;
    L_0x011b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.UCMobile.Apollo.text.a.b.a(java.lang.String, com.UCMobile.Apollo.text.a.a$a):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(java.lang.String r13, com.UCMobile.Apollo.text.a.a.a r14) {
        /*
        r7 = 3;
        r6 = 2;
        r4 = 1;
        r5 = -1;
        r1 = 0;
        r10 = new android.text.SpannableStringBuilder;
        r10.<init>();
        r11 = new java.util.Stack;
        r11.<init>();
        r0 = r1;
    L_0x0010:
        r2 = r13.length();
        if (r0 >= r2) goto L_0x01aa;
    L_0x0016:
        r8 = r13.charAt(r0);
        switch(r8) {
            case 38: goto L_0x011b;
            case 60: goto L_0x0023;
            default: goto L_0x001d;
        };
    L_0x001d:
        r10.append(r8);
        r0 = r0 + 1;
        goto L_0x0010;
    L_0x0023:
        r2 = r0 + 1;
        r3 = r13.length();
        if (r2 < r3) goto L_0x002e;
    L_0x002b:
        r0 = r0 + 1;
        goto L_0x0010;
    L_0x002e:
        r2 = r0 + 1;
        r2 = r13.charAt(r2);
        r3 = 47;
        if (r2 != r3) goto L_0x00a2;
    L_0x0038:
        r3 = r4;
    L_0x0039:
        r2 = r0 + 1;
        r8 = 62;
        r2 = r13.indexOf(r8, r2);
        if (r2 != r5) goto L_0x00a4;
    L_0x0043:
        r2 = r13.length();
    L_0x0047:
        r8 = r2 + -2;
        r8 = r13.charAt(r8);
        r9 = 47;
        if (r8 != r9) goto L_0x00a7;
    L_0x0051:
        r9 = r4;
    L_0x0052:
        if (r3 == 0) goto L_0x00a9;
    L_0x0054:
        r8 = r6;
    L_0x0055:
        r8 = r8 + r0;
        if (r9 == 0) goto L_0x00ab;
    L_0x0058:
        r0 = r2 + -2;
    L_0x005a:
        r0 = r13.substring(r8, r0);
        r8 = "\\s+";
        r12 = " ";
        r0 = r0.replace(r8, r12);
        r0 = r0.trim();
        r8 = r0.length();
        if (r8 != 0) goto L_0x00ae;
    L_0x0070:
        r0 = 0;
        r8 = r0;
    L_0x0072:
        if (r8 == 0) goto L_0x01bd;
    L_0x0074:
        r0 = r8[r1];
        r12 = r0.hashCode();
        switch(r12) {
            case 98: goto L_0x00c8;
            case 99: goto L_0x00d2;
            case 105: goto L_0x00dc;
            case 117: goto L_0x00f0;
            case 118: goto L_0x00fa;
            case 3314158: goto L_0x00e6;
            default: goto L_0x007d;
        };
    L_0x007d:
        r0 = r5;
    L_0x007e:
        switch(r0) {
            case 0: goto L_0x0105;
            case 1: goto L_0x0105;
            case 2: goto L_0x0105;
            case 3: goto L_0x0105;
            case 4: goto L_0x0105;
            case 5: goto L_0x0105;
            default: goto L_0x0081;
        };
    L_0x0081:
        r0 = r1;
    L_0x0082:
        if (r0 == 0) goto L_0x01bd;
    L_0x0084:
        if (r3 == 0) goto L_0x0108;
    L_0x0086:
        r0 = r11.isEmpty();
        if (r0 != 0) goto L_0x009f;
    L_0x008c:
        r0 = r11.pop();
        r0 = (com.UCMobile.Apollo.text.a.b.a) r0;
        a(r0, r10);
        r0 = r0.a;
        r3 = r8[r1];
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0086;
    L_0x009f:
        r0 = r2;
        goto L_0x0010;
    L_0x00a2:
        r3 = r1;
        goto L_0x0039;
    L_0x00a4:
        r2 = r2 + 1;
        goto L_0x0047;
    L_0x00a7:
        r9 = r1;
        goto L_0x0052;
    L_0x00a9:
        r8 = r4;
        goto L_0x0055;
    L_0x00ab:
        r0 = r2 + -1;
        goto L_0x005a;
    L_0x00ae:
        r8 = " ";
        r8 = r0.contains(r8);
        if (r8 == 0) goto L_0x00c0;
    L_0x00b6:
        r8 = " ";
        r8 = r0.indexOf(r8);
        r0 = r0.substring(r1, r8);
    L_0x00c0:
        r8 = "\\.";
        r0 = r0.split(r8);
        r8 = r0;
        goto L_0x0072;
    L_0x00c8:
        r12 = "b";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x00d0:
        r0 = r1;
        goto L_0x007e;
    L_0x00d2:
        r12 = "c";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x00da:
        r0 = r4;
        goto L_0x007e;
    L_0x00dc:
        r12 = "i";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x00e4:
        r0 = r6;
        goto L_0x007e;
    L_0x00e6:
        r12 = "lang";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x00ee:
        r0 = r7;
        goto L_0x007e;
    L_0x00f0:
        r12 = "u";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x00f8:
        r0 = 4;
        goto L_0x007e;
    L_0x00fa:
        r12 = "v";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007d;
    L_0x0102:
        r0 = 5;
        goto L_0x007e;
    L_0x0105:
        r0 = r4;
        goto L_0x0082;
    L_0x0108:
        if (r9 != 0) goto L_0x01bd;
    L_0x010a:
        r0 = new com.UCMobile.Apollo.text.a.b$a;
        r3 = r8[r1];
        r8 = r10.length();
        r0.<init>(r3, r8);
        r11.push(r0);
        r0 = r2;
        goto L_0x0010;
    L_0x011b:
        r2 = 59;
        r3 = r0 + 1;
        r2 = r13.indexOf(r2, r3);
        r3 = 32;
        r9 = r0 + 1;
        r3 = r13.indexOf(r3, r9);
        if (r2 != r5) goto L_0x015c;
    L_0x012d:
        r2 = r3;
    L_0x012e:
        if (r2 == r5) goto L_0x01a3;
    L_0x0130:
        r0 = r0 + 1;
        r8 = r13.substring(r0, r2);
        r0 = r8.hashCode();
        switch(r0) {
            case 3309: goto L_0x016d;
            case 3464: goto L_0x0163;
            case 96708: goto L_0x0181;
            case 3374865: goto L_0x0177;
            default: goto L_0x013d;
        };
    L_0x013d:
        r0 = r5;
    L_0x013e:
        switch(r0) {
            case 0: goto L_0x018b;
            case 1: goto L_0x0191;
            case 2: goto L_0x0197;
            case 3: goto L_0x019d;
            default: goto L_0x0141;
        };
    L_0x0141:
        r0 = new java.lang.StringBuilder;
        r9 = "ignoring unsupported entity: '&";
        r0.<init>(r9);
        r0 = r0.append(r8);
        r8 = ";'";
        r0.append(r8);
    L_0x0151:
        if (r2 != r3) goto L_0x0158;
    L_0x0153:
        r0 = " ";
        r10.append(r0);
    L_0x0158:
        r0 = r2 + 1;
        goto L_0x0010;
    L_0x015c:
        if (r3 == r5) goto L_0x012e;
    L_0x015e:
        r2 = java.lang.Math.min(r2, r3);
        goto L_0x012e;
    L_0x0163:
        r0 = "lt";
        r0 = r8.equals(r0);
        if (r0 == 0) goto L_0x013d;
    L_0x016b:
        r0 = r1;
        goto L_0x013e;
    L_0x016d:
        r0 = "gt";
        r0 = r8.equals(r0);
        if (r0 == 0) goto L_0x013d;
    L_0x0175:
        r0 = r4;
        goto L_0x013e;
    L_0x0177:
        r0 = "nbsp";
        r0 = r8.equals(r0);
        if (r0 == 0) goto L_0x013d;
    L_0x017f:
        r0 = r6;
        goto L_0x013e;
    L_0x0181:
        r0 = "amp";
        r0 = r8.equals(r0);
        if (r0 == 0) goto L_0x013d;
    L_0x0189:
        r0 = r7;
        goto L_0x013e;
    L_0x018b:
        r0 = 60;
        r10.append(r0);
        goto L_0x0151;
    L_0x0191:
        r0 = 62;
        r10.append(r0);
        goto L_0x0151;
    L_0x0197:
        r0 = 32;
        r10.append(r0);
        goto L_0x0151;
    L_0x019d:
        r0 = 38;
        r10.append(r0);
        goto L_0x0151;
    L_0x01a3:
        r10.append(r8);
        r0 = r0 + 1;
        goto L_0x0010;
    L_0x01aa:
        r0 = r11.isEmpty();
        if (r0 != 0) goto L_0x01ba;
    L_0x01b0:
        r0 = r11.pop();
        r0 = (com.UCMobile.Apollo.text.a.b.a) r0;
        a(r0, r10);
        goto L_0x01aa;
    L_0x01ba:
        r14.c = r10;
        return;
    L_0x01bd:
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.UCMobile.Apollo.text.a.b.b(java.lang.String, com.UCMobile.Apollo.text.a.a$a):void");
    }

    private static boolean a(Matcher matcher, c cVar, com.UCMobile.Apollo.text.a.a.a aVar, StringBuilder stringBuilder) {
        try {
            aVar.a = d.a(matcher.group(1));
            aVar.b = d.a(matcher.group(2));
            a(matcher.group(3), aVar);
            stringBuilder.setLength(0);
            while (true) {
                String a = cVar.a();
                if (a == null || a.isEmpty()) {
                    b(stringBuilder.toString(), aVar);
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(a.trim());
                }
            }
            b(stringBuilder.toString(), aVar);
            return true;
        } catch (NumberFormatException e) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            return false;
        }
    }

    private static int a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(Style.CENTER)) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return SectionHeader.SHT_LOUSER;
        }
    }

    private static void a(a aVar, SpannableStringBuilder spannableStringBuilder) {
        String str = aVar.a;
        int i = -1;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    i = 0;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    i = 1;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), aVar.b, spannableStringBuilder.length(), 33);
                return;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), aVar.b, spannableStringBuilder.length(), 33);
                return;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), aVar.b, spannableStringBuilder.length(), 33);
                return;
            default:
                return;
        }
    }

    final boolean a(c cVar, com.UCMobile.Apollo.text.a.a.a aVar) {
        while (true) {
            Matcher matcher;
            CharSequence a = cVar.a();
            if (a == null) {
                matcher = null;
            } else if (b.matcher(a).matches()) {
                while (true) {
                    String a2 = cVar.a();
                    if (a2 == null || a2.isEmpty()) {
                        break;
                    }
                }
            } else {
                matcher = a.matcher(a);
                if (!matcher.matches()) {
                    continue;
                }
            }
            if (matcher == null) {
                return false;
            }
            if (a(matcher, cVar, aVar, this.d)) {
                return true;
            }
        }
    }
}
