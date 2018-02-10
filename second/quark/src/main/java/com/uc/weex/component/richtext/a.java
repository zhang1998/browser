package com.uc.weex.component.richtext;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.weex.component.i.b;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class a {
    private Pattern a = Pattern.compile("\\[([^\\]]+)\\]");
    private List<String> b = Arrays.asList(new String[]{"grin", "scream", "triumph", "kissing_face", "smirk", "satisfied", "sunglasses", "sleepy", "praise", "trample", "doge1", "doge2", "heart_eyes", "big_eyes", "thiking", "slap", "blush", "smile", "byebye", "throwup", "begging", "sob", "sleeping", "awkward", "screaming", "tittering", "despise", "nose", "candle", "plane", "dlam", "xjj_mengbi"});

    public final String a(String str, FontMetrics fontMetrics) {
        if (b.a(str)) {
            return null;
        }
        int e = (int) WXViewUtils.e((float) (((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent))) + 1));
        Matcher matcher = this.a.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            Object group = matcher.group(1);
            if (!TextUtils.isEmpty(group) && this.b.contains(group)) {
                StringBuilder stringBuilder = new StringBuilder(100);
                stringBuilder.append("<img src='res://").append(group).append(".png' width='").append(e).append("' height='").append(e).append("' />");
                matcher.appendReplacement(stringBuffer, stringBuilder.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
