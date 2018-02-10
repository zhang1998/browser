package com.uc.apollo.media.impl;

import android.net.Uri;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.f;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

@KeepForSdk
/* compiled from: ProGuard */
public class DataSourceURI implements DataSource {
    public Map<String, String> headers;
    public String pageUri;
    public String title;
    public Uri uri;

    public DataSourceURI(String str, String str2, Uri uri, Map<String, String> map) {
        if (f.a(str)) {
            str = "";
        }
        this.title = str;
        if (f.a(str2)) {
            str2 = "";
        }
        this.pageUri = str2;
        this.uri = uri;
        if (uri != null) {
            String str3;
            if (map == null) {
                map = new HashMap();
            }
            Object obj = null;
            Object obj2 = null;
            for (Entry key : map.entrySet()) {
                str3 = (String) key.getKey();
                if (str3 != null) {
                    str3 = str3.toLowerCase(Locale.getDefault());
                    if ("cookie".equals(str3)) {
                        obj2 = 1;
                    } else {
                        Object obj3;
                        if ("user-agent".equals(str3)) {
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                    }
                }
            }
            if (obj2 == null) {
                str3 = Settings.getCookie(uri);
                if (str3 != null && str3.length() > 0) {
                    map.put("Cookie", str3);
                }
            }
            if (obj == null) {
                str3 = Settings.getUserAgent(Uri.parse(this.pageUri));
                if (str3 != null && str3.length() > 0) {
                    map.put("User-Agent", str3);
                }
            }
        }
        this.headers = map;
    }

    public void addReferer() {
        if (this.uri != null && f.b(this.pageUri)) {
            Object obj;
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            for (Entry key : this.headers.entrySet()) {
                String str = (String) key.getKey();
                if (str != null) {
                    if ("referer".equals(str.toLowerCase(Locale.getDefault()))) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                Uri parse = Uri.parse(this.pageUri);
                String scheme = parse.getScheme();
                if (f.b(scheme)) {
                    scheme = scheme.toLowerCase(Locale.getDefault());
                    if ("http".equals(scheme) || "https".equals(scheme)) {
                        this.headers.put("Referer", scheme + ":" + parse.getEncodedSchemeSpecificPart());
                    }
                }
            }
        }
    }

    public DataSourceURI(Uri uri, Map<String, String> map) {
        this(null, null, uri, map);
    }

    public DataSourceURI(Uri uri) {
        this(null, null, uri, null);
    }

    public void reset() {
        this.title = null;
        this.pageUri = null;
        this.uri = null;
        this.headers = null;
    }

    private String toString(String str, int i) {
        if (str.length() >= i) {
            return str;
        }
        return String.format("%" + (i - str.length()) + "s", new Object[]{" "}) + str;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("\n  [       title: ").append(f.a(this.title) ? "" : this.title).append("]\n  [    page uri: ");
        if (f.a(this.pageUri)) {
            str = "";
        } else {
            str = this.pageUri;
        }
        str = append.append(str).append("]\n  [   media uri: ").append(this.uri).append("]\n").toString();
        if (this.headers == null) {
            return str;
        }
        String str2 = str;
        for (Entry entry : this.headers.entrySet()) {
            String str3 = (String) entry.getKey();
            if (!(str3 == null || str3.length() == 0)) {
                str2 = str2 + "  [ " + toString(str3, 11) + ": " + ((String) entry.getValue()) + "]\n";
            }
        }
        return str2;
    }
}
