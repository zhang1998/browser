package com.uc.apollo.media.impl;

import android.net.Uri;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public interface DataSource {

    /* compiled from: ProGuard */
    public final class a {
        public static String a(DataSource dataSource) {
            if (!(dataSource instanceof DataSourceURI)) {
                return null;
            }
            DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
            if (dataSourceURI.pageUri != null) {
                return Uri.parse(dataSourceURI.pageUri).getHost();
            }
            return null;
        }
    }

    void reset();
}
