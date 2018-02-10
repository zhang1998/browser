package com.ucpro.feature.video.cache.e.b;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class l {
    static final Pattern a = Pattern.compile(a("#EXTINF") + "\\s*(-1|[0-9\\.]*)\\s*(?:,((.*)))?");
    static final Pattern b = Pattern.compile(a("#EXT-X-KEY") + "METHOD=([0-9A-Za-z\\-]*)(,URI=\"(([^\\\\\"]*.*))\")?");
    static final Pattern c = Pattern.compile(a("#EXT-X-TARGETDURATION") + "([0-9]*)");
    static final Pattern d = Pattern.compile(a("#EXT-X-MEDIA-SEQUENCE") + "([0-9]*)");
    static final Pattern e = Pattern.compile(a("#EXT-X-PROGRAM-DATE-TIME") + "(.*)");

    private static String a(String str) {
        return "\\s*" + str + "\\s*:\\s*";
    }

    static long a(String str, int i) throws c {
        Matcher matcher = e.matcher(str);
        if (matcher.find() && matcher.matches() && matcher.groupCount() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            PrintStream printStream = System.out;
            simpleDateFormat.format(new Date());
            try {
                return simpleDateFormat.parse(matcher.group(1)).getTime();
            } catch (Throwable e) {
                throw new c(str, i, e);
            }
        }
        throw new c(str, i, " must specify date-time");
    }
}
