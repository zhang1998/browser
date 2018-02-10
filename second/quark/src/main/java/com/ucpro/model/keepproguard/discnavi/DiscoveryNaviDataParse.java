package com.ucpro.model.keepproguard.discnavi;

import android.net.Uri;
import android.support.annotation.Keep;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.e;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class DiscoveryNaviDataParse {
    public boolean a = false;
    @Keep
    public ArrayList<SiteItem> dataList = new ArrayList();
    @Keep
    public String tabTitle;

    /* compiled from: ProGuard */
    public class SiteItem {
        public Uri a;
        @Keep
        public String description;
        @Keep
        public String iconName;
        @Keep
        public String iconUrl;
        @Keep
        public String title;
        @Keep
        public String url;
    }

    public static ArrayList<DiscoveryNaviDataParse> a(String str) {
        DiscoveryNavigationData discoveryNavigationData = (DiscoveryNavigationData) a.a(str, new a().a(), new e[0]);
        return discoveryNavigationData != null ? discoveryNavigationData.array : new DiscoveryNavigationData().array;
    }
}
