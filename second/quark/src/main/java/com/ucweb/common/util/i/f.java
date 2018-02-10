package com.ucweb.common.util.i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.ucweb.common.util.n.a;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class f {
    private static final Pattern a = Pattern.compile("[a-zA-Z0-9]{2,}://[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)*(:\\d{1,5})?(/|\\?|$)");
    private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");
    private static final Pattern c = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Set<Character> d;

    static {
        Set hashSet = new HashSet();
        d = hashSet;
        hashSet.add(Character.valueOf(' '));
        d.add(Character.valueOf(','));
        d.add(Character.valueOf('。'));
        d.add(Character.valueOf('，'));
    }

    public static boolean a(String str) {
        return (a.a(str) || !str.startsWith("file://") || str.startsWith("file:///android_asset/") || str.startsWith("file:///cookieless_proxy/")) ? false : true;
    }

    public static boolean b(String str) {
        return !a.a(str) && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase("https://");
    }

    public static String c(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.indexOf("://") < 0) {
            str = "http://" + str;
        }
        try {
            return new URL(str).getHost();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return "";
    }

    public static String e(String str) {
        String c = c(str);
        if (!a.b(c)) {
            return c;
        }
        String[] split = c.split("\\.");
        if (split == null || split.length < 2) {
            return c;
        }
        return a.a(split[split.length - 2], ".", split[split.length - 1]);
    }

    private static String a(String str, boolean z) {
        if (str != null) {
            String trim = str.trim();
            if (z) {
                try {
                    trim = URLDecoder.decode(trim);
                } catch (Exception e) {
                }
            }
            int length = trim.length();
            if (length > 0) {
                int lastIndexOf = trim.lastIndexOf(47);
                if (lastIndexOf != -1 && lastIndexOf < length - 1) {
                    int lastIndexOf2 = trim.lastIndexOf(47, lastIndexOf - 1);
                    if (lastIndexOf2 != -1 && lastIndexOf - lastIndexOf2 > 0) {
                        String str2 = new String(trim.substring(lastIndexOf + 1));
                        lastIndexOf = str2.indexOf(63);
                        if (lastIndexOf == -1) {
                            return str2;
                        }
                        if (lastIndexOf < length - 1) {
                            trim = new String(str2.substring(0, lastIndexOf).trim());
                            if (trim.length() > 0) {
                                return trim;
                            }
                        }
                    }
                }
            }
        }
        return "index.html";
    }

    public static boolean a(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        Matcher matcher = a.matcher(charSequence);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        matcher = b.matcher(charSequence);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        return false;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("ext:")) {
            return str;
        }
        int indexOf = str.indexOf("http://");
        int length = str.length();
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        indexOf = str.indexOf("https://");
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        indexOf = str.indexOf("file://");
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        indexOf = str.indexOf("ftp://");
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        indexOf = str.indexOf("mailto://");
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        indexOf = str.indexOf("www.");
        if (indexOf >= 0 && indexOf < length) {
            return str.substring(indexOf);
        }
        if (indexOf >= 0 && indexOf < length) {
            return str;
        }
        indexOf = str.lastIndexOf(":");
        if (indexOf < 0 || indexOf >= length) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        int indexOf = stringBuilder.indexOf(".");
        int i = indexOf;
        indexOf = stringBuilder.length();
        while (i >= 0 && i < r1 - 1) {
            if (i >= 0 && stringBuilder.charAt(i) == '.' && stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                stringBuilder.deleteCharAt(i);
            } else {
                i++;
            }
            indexOf = stringBuilder.indexOf(".", i);
            i = indexOf;
            indexOf = stringBuilder.length();
        }
        return stringBuilder.toString().trim();
    }

    public static boolean i(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z;
            if (str == null || !str.startsWith("ext:")) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str == null || !str.startsWith("file:///data/data/")) {
                    z = false;
                } else {
                    z = true;
                }
                if (!(z || str.startsWith("file:///android_asset/"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int j(String str) {
        int i = g.b;
        if (a.a(str) || str.contains(" ")) {
            return i;
        }
        e eVar;
        try {
            eVar = new e(m(str));
        } catch (Exception e) {
            i = g.b;
            eVar = null;
        }
        if (eVar == null || !eVar.a()) {
            return i;
        }
        return g.a;
    }

    private static String m(String str) {
        if (a.a(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (!d.contains(Character.valueOf(c))) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static String k(String str) {
        if (a.a(str)) {
            return str;
        }
        e eVar;
        try {
            eVar = new e(m(str));
        } catch (Exception e) {
            eVar = null;
        }
        if (eVar != null) {
            return eVar.toString();
        }
        return str;
    }

    public static String a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return "";
        }
        String str = "";
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return str;
        }
        String string;
        if (query.moveToFirst()) {
            string = query.getString(query.getColumnIndex("mime_type"));
        } else {
            string = str;
        }
        query.close();
        return string;
    }

    public static List<String> l(String str) {
        List<String> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\\s+")) {
                if (j(str2) == g.a) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static String f(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        } else {
            int indexOf = str.indexOf(63);
            if (indexOf >= 0) {
                if (indexOf == 0) {
                    str = null;
                } else {
                    str = str.substring(0, indexOf);
                }
            }
        }
        String a = a(str, true);
        if ("index.html".equals(a)) {
            return a(str, false);
        }
        return a;
    }
}
