package com.uc.weex.component.h;

import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.imagecodec.export.IPictureView;
import java.io.PrintStream;

/* compiled from: ProGuard */
public final class p {
    x a;

    public p(x xVar, String str) {
        this.a = xVar;
        if (str != null) {
            a(str.toLowerCase());
        }
    }

    private void a(String str) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i3 < str.length()) {
            switch (str.charAt(i3)) {
                case '(':
                    i = i3 + 1;
                    i3 = i;
                    continue;
                case ')':
                    if (i2 != -1 && i >= 0) {
                        String substring = str.substring(i, i3);
                        PrintStream printStream = System.out;
                        new StringBuilder("opt:").append(i2).append(":").append(substring);
                        if (!(substring == null || substring.length() == 0)) {
                            String[] split = substring.split(",");
                            float b;
                            switch (i2) {
                                case 1:
                                    b = v.b(split[0]);
                                    this.a.a(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE, b, split.length > 1 ? v.b(split[1]) : b);
                                    break;
                                case 2:
                                    if (split.length >= 3) {
                                        this.a.a(v.b(split[0]), v.b(split[1]), v.b(split[2]));
                                        break;
                                    }
                                    x xVar = this.a;
                                    xVar.a(v.b(split[0]), xVar.g + ((xVar.i < 0.0f ? 0.0f : xVar.i) / 2.0f), ((xVar.j < 0.0f ? 0.0f : xVar.i) / 2.0f) + xVar.h);
                                    break;
                                case 3:
                                    float b2;
                                    b = v.b(split[0]);
                                    if (split.length > 1) {
                                        b2 = v.b(split[1]);
                                    } else {
                                        b2 = b;
                                    }
                                    this.a.a(b, b2);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    i = -1;
                    i2 = -1;
                    break;
                case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                    if (a(Style.WX_ROTATE, str, i3)) {
                        i3 += 6;
                        i2 = 2;
                        break;
                    }
                    continue;
                case 's':
                    if (a("scale", str, i3)) {
                        i3 += 5;
                        i2 = 3;
                        break;
                    }
                    continue;
                case 't':
                    if (a(Style.WX_TRANSLATE, str, i3)) {
                        i3 += 9;
                        i2 = 1;
                        break;
                    }
                    continue;
            }
            i3++;
        }
    }

    private static boolean a(String str, String str2, int i) {
        if (str.length() + i > str2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str2.charAt(i + i2) != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }
}
