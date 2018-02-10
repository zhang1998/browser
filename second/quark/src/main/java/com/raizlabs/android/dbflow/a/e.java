package com.raizlabs.android.dbflow.a;

import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class e<QueryClass extends e> implements f {
    private static final Pattern b = Pattern.compile("`.*`");
    protected StringBuilder a = new StringBuilder();

    public e(Object obj) {
        b(obj);
    }

    public final QueryClass b() {
        return b((Object) " ");
    }

    public final QueryClass b(Object obj) {
        this.a.append(obj);
        return this;
    }

    public final QueryClass a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            b((Object) str);
            a((Object) str2);
        }
        return this;
    }

    public final String a() {
        return this.a.toString();
    }

    public static String a(String str) {
        return (str == null || c(str)) ? str : "`" + str.replace(".", "`.`") + '`';
    }

    private static boolean c(String str) {
        return b.matcher(str).find();
    }

    public static String b(String str) {
        if (str == null || !c(str)) {
            return str;
        }
        return str.replace("`", "");
    }

    public static String a(CharSequence charSequence, Iterable iterable) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object next : iterable) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }

    public final QueryClass a(Object obj) {
        return b((Object) " ").b(obj).b((Object) " ");
    }

    public final String toString() {
        return this.a.toString();
    }
}
