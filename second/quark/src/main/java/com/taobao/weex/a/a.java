package com.taobao.weex.a;

import android.mini.support.annotation.NonNull;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.taobao.weex.ac;
import java.util.List;

/* compiled from: ProGuard */
public final class a implements o {
    @NonNull
    public final Uri a(ac acVar, Uri uri) {
        int i = 1;
        int i2 = 0;
        if (TextUtils.isEmpty(acVar.h)) {
            return uri;
        }
        Uri parse = Uri.parse(acVar.h);
        Builder buildUpon = uri.buildUpon();
        if (!uri.isRelative()) {
            return uri;
        }
        Builder scheme;
        if (uri.getAuthority() != null) {
            scheme = buildUpon.scheme(parse.getScheme());
        } else {
            buildUpon.encodedAuthority(parse.getEncodedAuthority()).scheme(parse.getScheme()).path(null);
            if (uri.getPath().startsWith("/")) {
                buildUpon.appendEncodedPath(uri.getEncodedPath().substring(1));
            } else {
                List pathSegments = parse.getPathSegments();
                if (parse.getPath().endsWith("/")) {
                    i = 0;
                }
                int size = pathSegments.size() - i;
                while (i2 < size) {
                    buildUpon.appendEncodedPath((String) pathSegments.get(i2));
                    i2++;
                }
                buildUpon.appendEncodedPath(uri.getEncodedPath());
            }
            scheme = buildUpon;
        }
        return scheme.build();
    }
}
