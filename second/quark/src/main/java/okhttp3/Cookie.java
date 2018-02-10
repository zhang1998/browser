package okhttp3;

import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

/* compiled from: ProGuard */
public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    /* compiled from: ProGuard */
    public final class Builder {
        String domain;
        long expiresAt = HttpDate.MAX_DATE;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = "/";
        boolean persistent;
        boolean secure;
        String value;

        public final Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public final Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        public final Builder expiresAt(long j) {
            long j2;
            long j3 = HttpDate.MAX_DATE;
            if (j <= 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = j;
            }
            if (j2 <= HttpDate.MAX_DATE) {
                j3 = j2;
            }
            this.expiresAt = j3;
            this.persistent = true;
            return this;
        }

        public final Builder domain(String str) {
            return domain(str, false);
        }

        public final Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        private Builder domain(String str, boolean z) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String domainToAscii = Util.domainToAscii(str);
            if (domainToAscii == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.domain = domainToAscii;
            this.hostOnly = z;
            return this;
        }

        public final Builder path(String str) {
            if (str.startsWith("/")) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Cookie build() {
            return new Cookie();
        }
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    private Cookie(Builder builder) {
        if (builder.name == null) {
            throw new NullPointerException("builder.name == null");
        } else if (builder.value == null) {
            throw new NullPointerException("builder.value == null");
        } else if (builder.domain == null) {
            throw new NullPointerException("builder.domain == null");
        } else {
            this.name = builder.name;
            this.value = builder.value;
            this.expiresAt = builder.expiresAt;
            this.domain = builder.domain;
            this.path = builder.path;
            this.secure = builder.secure;
            this.httpOnly = builder.httpOnly;
            this.persistent = builder.persistent;
            this.hostOnly = builder.hostOnly;
        }
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean equals;
        if (this.hostOnly) {
            equals = httpUrl.host().equals(this.domain);
        } else {
            equals = domainMatch(httpUrl, this.domain);
        }
        if (!equals || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    private static boolean domainMatch(HttpUrl httpUrl, String str) {
        String host = httpUrl.host();
        if (host.equals(str)) {
            return true;
        }
        if (host.endsWith(str) && host.charAt((host.length() - str.length()) - 1) == '.' && !Util.verifyAsIpAddress(host)) {
            return true;
        }
        return false;
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str) && (str.endsWith("/") || encodedPath.charAt(str.length()) == '/')) {
            return true;
        }
        return false;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    static Cookie parse(long j, HttpUrl httpUrl, String str) {
        int length = str.length();
        int delimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, '=');
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        String trimSubstring = Util.trimSubstring(str, 0, delimiterOffset2);
        if (trimSubstring.isEmpty()) {
            return null;
        }
        String trimSubstring2;
        String trimSubstring3 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
        long j2 = HttpDate.MAX_DATE;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        delimiterOffset++;
        while (delimiterOffset < length) {
            String str4;
            int delimiterOffset3 = Util.delimiterOffset(str, delimiterOffset, length, ';');
            int delimiterOffset4 = Util.delimiterOffset(str, delimiterOffset, delimiterOffset3, '=');
            String trimSubstring4 = Util.trimSubstring(str, delimiterOffset, delimiterOffset4);
            trimSubstring2 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring4.equalsIgnoreCase("expires")) {
                try {
                    j2 = parseExpires(trimSubstring2, 0, trimSubstring2.length());
                    z4 = true;
                    trimSubstring2 = str3;
                    str3 = str2;
                } catch (IllegalArgumentException e) {
                    trimSubstring2 = str3;
                    str3 = str2;
                }
            } else if (trimSubstring4.equalsIgnoreCase("max-age")) {
                try {
                    j3 = parseMaxAge(trimSubstring2);
                    z4 = true;
                    trimSubstring2 = str3;
                    str3 = str2;
                } catch (NumberFormatException e2) {
                    trimSubstring2 = str3;
                    str3 = str2;
                }
            } else if (trimSubstring4.equalsIgnoreCase("domain")) {
                try {
                    z3 = false;
                    str4 = str3;
                    str3 = parseDomain(trimSubstring2);
                    trimSubstring2 = str4;
                } catch (IllegalArgumentException e3) {
                    trimSubstring2 = str3;
                    str3 = str2;
                }
            } else if (trimSubstring4.equalsIgnoreCase("path")) {
                str3 = str2;
            } else {
                if (trimSubstring4.equalsIgnoreCase("secure")) {
                    z = true;
                    trimSubstring2 = str3;
                    str3 = str2;
                } else {
                    if (trimSubstring4.equalsIgnoreCase("httponly")) {
                        z2 = true;
                        trimSubstring2 = str3;
                        str3 = str2;
                    } else {
                        trimSubstring2 = str3;
                        str3 = str2;
                    }
                }
            }
            str4 = trimSubstring2;
            delimiterOffset = delimiterOffset3 + 1;
            str2 = str3;
            str3 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j2 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
            if (j2 < j || j2 > HttpDate.MAX_DATE) {
                j2 = HttpDate.MAX_DATE;
            }
        }
        if (str2 == null) {
            trimSubstring2 = httpUrl.host();
        } else if (!domainMatch(httpUrl, str2)) {
            return null;
        } else {
            trimSubstring2 = str2;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String encodedPath = httpUrl.encodedPath();
            int lastIndexOf = encodedPath.lastIndexOf(47);
            str3 = lastIndexOf != 0 ? encodedPath.substring(0, lastIndexOf) : "/";
        }
        return new Cookie(trimSubstring, trimSubstring3, j2, trimSubstring2, str3, z, z2, z3, z4);
    }

    private static long parseExpires(String str, int i, int i2) {
        int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = TIME_PATTERN.matcher(str);
        while (dateCharacterOffset < i2) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i7 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += SettingsConst.GLOBAL_SETTINGS;
        }
        if (i8 < SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_PARAM) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 <= 0 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        } else {
            Calendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            Object obj;
            char charAt = str.charAt(i3);
            Object obj2 = ((charAt >= ' ' || charAt == '\t') && charAt < '' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (z) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj2 == obj) {
                return i3;
            }
        }
        return i2;
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String domainToAscii = Util.domainToAscii(str);
        if (domainToAscii != null) {
            return domainToAscii;
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List values = headers.values("Set-Cookie");
        List list = null;
        int size = values.size();
        int i = 0;
        while (i < size) {
            List arrayList;
            Cookie parse = parse(httpUrl, (String) values.get(i));
            if (parse != null) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add(parse);
            } else {
                arrayList = list;
            }
            i++;
            list = arrayList;
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            stringBuilder.append("; domain=").append(this.domain);
        }
        stringBuilder.append("; path=").append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = (((((((((this.name.hashCode() + 527) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (this.expiresAt ^ (this.expiresAt >>> 32)))) * 31;
        if (this.secure) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.httpOnly) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.persistent) {
            i = 0;
        } else {
            i = 1;
        }
        i = (i + hashCode) * 31;
        if (!this.hostOnly) {
            i2 = 1;
        }
        return i + i2;
    }
}
