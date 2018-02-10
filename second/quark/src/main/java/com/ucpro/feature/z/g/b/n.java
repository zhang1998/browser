package com.ucpro.feature.z.g.b;

import android.content.SharedPreferences;
import android.util.Log;
import com.uc.webview.browser.interfaces.IWebResources;
import com.ucweb.common.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a;
import kotlin.a.b;
import kotlin.a.g;
import kotlin.a.i;
import kotlin.a.l;
import kotlin.e;
import kotlin.jvm.a.f;
import kotlin.jvm.b.c;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0&H\u0007J\u0016\u0010'\u001a\n )*\u0004\u0018\u00010(0(H\b¢\u0006\u0002\b*J\u0010\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\tJ\b\u00100\u001a\u00020\u0004H\u0007J\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u0002032\u0006\u0010,\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004J%\u00106\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u00107\u001a\u00020\u0004H\u0000¢\u0006\u0002\b8J\r\u00109\u001a\u000203H\u0000¢\u0006\u0002\b:J8\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010<\u001a\u00020\u00042\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J<\u0010>\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\"\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004`\u0013H\u0002J\u0010\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020\u0004H\u0002J\u001e\u0010C\u001a\u0002032\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0&2\u0006\u0010<\u001a\u00020\u0004H\u0002J\u001c\u0010E\u001a\u00020\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0&H\b¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020\u001aH\u0000¢\u0006\u0002\bIJ\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004`\u0013X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004`\u0013X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!X\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ucpro/feature/searchpage/data/searchengine/SearchEngineManager;", "", "()V", "CURRENT_CN", "", "CURRENT_EN", "CURRENT_RU", "DEFAULT_CN", "Ljava/util/ArrayList;", "Lcom/ucpro/feature/searchpage/data/searchengine/SearchEngine;", "Lkotlin/collections/ArrayList;", "DEFAULT_EN", "DEFAULT_RU", "DEFAULT_SEARCH_ENGINE_CN", "DEFAULT_SEARCH_ENGINE_EN", "DEFAULT_SEARCH_ENGINE_RU", "OLD_MAP_CN", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "OLD_MAP_EN", "OLD_MAP_RU", "PREF_KEY_CN", "PREF_KEY_EN", "PREF_KEY_RU", "PREF_MAP", "Lcom/ucpro/feature/searchpage/data/searchengine/CountryType;", "TAG", "mAllSearchEngine", "mCmsUpdater", "Lcom/ucpro/feature/searchpage/data/searchengine/SearchEngineCmsUpdater;", "mCurrentId", "whichCountry", "Lkotlin/Function0;", "_whichCountry", "decideSelectedEngine", "getAllEngineOfAllCountry", "getAllSearchEngine", "", "getPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPref$browser_standardRelease", "getSearchEngineById", "id", "getSearchUrl", "keyword", "getSelectedSearchEngine", "getSelectedSearchEngineId", "getSelectedSearchEngineIndex", "listenToCms", "", "onSearchEngineChanged", "url", "parseSearchEngines", "json", "parseSearchEngines$browser_standardRelease", "reset", "reset$browser_standardRelease", "resolveAllSearchEngine", "prefKey", "defs", "resolveSelected", "defaultId", "oldMap", "saveSelected", "value", "saveToSp", "group", "serializeToJSON", "serializeToJSON$browser_standardRelease", "setCountry", "country", "setCountry$browser_standardRelease", "setSelected", "", "index", "browser_standardRelease"}, k = 1, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class n {
    public static String a = null;
    public static final n b = null;
    private static final String c = "SEM";
    private static c<? extends g> d;
    private static final HashMap<g, String> e = null;
    private static final ArrayList<i> f = null;
    private static final ArrayList<i> g = null;
    private static final ArrayList<i> h = null;
    private static final HashMap<Integer, String> i = null;
    private static final HashMap<Integer, String> j = null;
    private static final HashMap<Integer, String> k = null;
    private static j l;
    private static ArrayList<i> m;

    static {
        n nVar = new n();
    }

    private n() {
        b = this;
        c = c;
        d = new k(this);
        e = b.a(a.a(g.a, "ccn"), a.a(g.b, "cen"), a.a(g.c, "cru"));
        f = l.a(new i("baidu_cn", "百度", "https://m.baidu.com/s?from=1019023i&wd=%s"), new i("bing_cn", "必应", "https://cn.bing.com/search?q=%s"), new i("google_cn", "谷歌", "https://www.google.com/search?q=%s"), new i("sogou_cn", "搜狗", "https://m.sogou.com/web/searchList?keyword=%s"), new i("shenma_cn", "神马", "https://yz.m.sm.cn/s?q=%s&from=kkframe"));
        g = l.a(new i("google_en", "Google", "https://www.google.com/search?q=%s"), new i("bing_en", "Bing", "https://global.bing.com/search?q=%s"), new i("yahoo_en", "Yahoo", "https://search.yahoo.com/search?p=%s"), new i("baidu_en", "Baidu", "https://m.baidu.com/s?from=1019023i&wd=%s"));
        h = l.a(new i("yandex_ru", "Яндекс", "https://www.yandex.com/search/touch/?text=%s"), new i("google_ru", "Google", "https://www.google.ru/search?q=%s"), new i("bing_ru", "Bing", "http://m.bing.com/search?q=%s"), new i("ddgo_ru", "Duckduckgo", "https://duckduckgo.com/?q=%s&t=ucbrowser"), new i("ask_ru", "Ask", "http://www.search.ask.com/web?o=APN11808&q=%s"));
        i = b.a(a.a(Integer.valueOf(0), "baidu_cn"), a.a(Integer.valueOf(1), "bing_cn"), a.a(Integer.valueOf(2), "google_cn"), a.a(Integer.valueOf(3), "sogou_cn"), a.a(Integer.valueOf(4), "shenma_cn"));
        j = b.a(a.a(Integer.valueOf(16), "google_en"), a.a(Integer.valueOf(17), "bing_en"), a.a(Integer.valueOf(18), "yahoo_en"));
        k = b.a(a.a(Integer.valueOf(19), "yandex_ru"), a.a(Integer.valueOf(20), "google_ru"), a.a(Integer.valueOf(21), "bing_ru"), a.a(Integer.valueOf(22), "ddgo_ru"), a.a(Integer.valueOf(23), "ask_ru"));
    }

    public static void a() {
        l = new j();
    }

    @NotNull
    public final synchronized List<i> b() {
        ArrayList a;
        if (m == null) {
            switch (f.b[((g) d.a()).ordinal()]) {
                case 1:
                    a = a("gcn", f);
                    break;
                case 2:
                    a = a("gen", g);
                    break;
                case 3:
                    a = a("gru", h);
                    break;
                default:
                    throw new e();
            }
            m = a;
        }
        a = m;
        if (a == null) {
            f.a();
        }
        return a;
    }

    private static ArrayList<i> a(String str, ArrayList<i> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList();
        String string = d.a().getSharedPreferences("__se", 0).getString(str, null);
        if (string != null) {
            arrayList2.addAll(b(string));
        }
        if (arrayList2.size() == 0) {
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    @NotNull
    public final synchronized String c() {
        String a;
        if (a == null) {
            switch (f.a[((g) d.a()).ordinal()]) {
                case 1:
                    a = a("ccn", "shenma_cn", i);
                    break;
                case 2:
                    a = a("cen", "google_en", j);
                    break;
                case 3:
                    a = a("cru", "yandex_ru", k);
                    break;
                default:
                    throw new e();
            }
            a = a;
        }
        a = a;
        if (a == null) {
            f.a();
        }
        return a;
    }

    @NotNull
    public final i d() {
        Object obj;
        for (Object next : b()) {
            if (f.a(((i) next).a, b.c())) {
                obj = next;
                break;
            }
        }
        obj = null;
        i iVar = (i) obj;
        if (iVar == null) {
            f.a();
        }
        return iVar;
    }

    public static void a(@NotNull String str, @NotNull String str2) {
        int i;
        f.b(str, "id");
        f.b(str2, "url");
        CharSequence charSequence = str2;
        CharSequence charSequence2 = "%s";
        f.b(charSequence, "$receiver");
        f.b(charSequence2, IWebResources.TEXT_OTHER);
        boolean z;
        if (charSequence2 instanceof String) {
            if (kotlin.b.a.a(charSequence, (String) charSequence2, 0, 2) >= 0) {
                i = 1;
            } else {
                z = false;
            }
        } else if (kotlin.b.a.b(charSequence, charSequence2, 0, charSequence.length(), false) >= 0) {
            i = 1;
        } else {
            z = false;
        }
        if (i == 0) {
            Log.w(c, "url: " + str2 + " is not valid,which id is " + str);
            return;
        }
        for (Entry entry : b.a(a.a("gcn", f), a.a("gen", g), a.a("gru", h)).entrySet()) {
            i iVar;
            String str3 = (String) entry.getKey();
            ArrayList<i> a = a(str3, (ArrayList) entry.getValue());
            int i2 = 0;
            for (i iVar2 : a) {
                if (f.a(iVar2.a, (Object) str)) {
                    continue;
                    break;
                }
                i2++;
            }
            i2 = -1;
            continue;
            if (i2 >= 0) {
                iVar2 = (i) a.get(i2);
                a.set(i2, new i(iVar2.a, iVar2.b, str2));
                a((List) a, str3);
                m = null;
                return;
            }
        }
    }

    public static void a(String str) {
        Object obj = e.get(d.a());
        if (obj == null) {
            f.a();
        }
        d.a().getSharedPreferences("__se", 0).edit().putString((String) obj, str).apply();
    }

    @NotNull
    private static ArrayList<i> b(@NotNull String str) {
        f.b(str, "json");
        JSONArray jSONArray = new JSONArray(str);
        ArrayList<i> arrayList = new ArrayList();
        int length = jSONArray.length() - 1;
        int i = 0;
        if (length >= 0) {
            while (true) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Object string = jSONObject.getString("id");
                Object string2 = jSONObject.getString("label");
                Object string3 = jSONObject.getString("url");
                f.a(string, "id");
                f.a(string2, "label");
                f.a(string3, "url");
                arrayList.add(new i(string, string2, string3));
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private static String a(String str, String str2, HashMap<Integer, String> hashMap) {
        SharedPreferences sharedPreferences = d.a().getSharedPreferences("__se", 0);
        if (sharedPreferences.contains(str)) {
            Object string = sharedPreferences.getString(str, str2);
            f.a(string, "sp.getString(prefKey, defaultId)");
            return string;
        }
        int a = com.ucpro.model.a.b.a().a("setting_search_engine", -1);
        if (a < 0) {
            return str2;
        }
        String str3 = (String) hashMap.get(Integer.valueOf(a));
        if (str3 == null) {
            return str2;
        }
        a(str3);
        return str3;
    }

    private static void a(List<i> list, String str) {
        JSONArray jSONArray = new JSONArray();
        Iterable iterable = list;
        f.b(iterable, "$receiver");
        for (kotlin.a.e eVar : new i(new g(iterable))) {
            int i = eVar.a;
            i iVar = (i) eVar.b;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", iVar.a);
            jSONObject.put("label", iVar.b);
            jSONObject.put("url", iVar.c);
            jSONArray.put(i, jSONObject);
        }
        Object jSONArray2 = jSONArray.toString();
        f.a(jSONArray2, "jsonArray.toString()");
        if (jSONArray2 != null) {
            d.a().getSharedPreferences("__se", 0).edit().putString(str, jSONArray2).apply();
        }
    }

    @NotNull
    public static final /* synthetic */ g e() {
        g gVar = g.a;
        if (!com.ucpro.b.a.a.b()) {
            return gVar;
        }
        if (com.ucpro.c.d.a()) {
            return g.c;
        }
        return g.b;
    }
}
