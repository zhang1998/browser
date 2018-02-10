package com.ucpro.feature.lightapp.b;

import android.text.TextUtils;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.lightapp.d.a.f;
import com.ucpro.feature.lightapp.d.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class d implements c {
    public m a;
    public com.ucpro.feature.lightapp.d.a.c b;

    public static String a(String... strArr) {
        JSONObject jSONObject;
        com.ucweb.common.util.c.a(true, "keyValues should be paired");
        com.ucweb.common.util.c.b(true);
        Map hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            hashMap.put(strArr[0], strArr[1]);
        }
        try {
            jSONObject = new JSONObject(hashMap);
        } catch (Exception e) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    private d() {
        this.a = null;
        this.b = null;
    }

    public final String a(String str, JSONObject jSONObject, t tVar) {
        Object obj = null;
        if (jSONObject == null) {
            tVar.a(new q(i.d, "args is null"));
        } else {
            e aVar = new a(this, tVar);
            e cVar = new c(this, tVar);
            Object optString;
            com.ucpro.feature.lightapp.d.a.c cVar2;
            com.ucpro.feature.lightapp.d.a.d dVar;
            CharSequence a;
            CharSequence a2;
            if ("lightapp.getCachedCategoryInfo".equals(str)) {
                new StringBuilder("onInvoke getCategoryInfo\n").append(jSONObject);
                if (jSONObject != null) {
                    optString = jSONObject.optString("categoryId");
                } else {
                    optString = null;
                }
                if (TextUtils.isEmpty(optString)) {
                    aVar.a(a("error_msg", "category id is empty"));
                } else {
                    cVar2 = this.b;
                    dVar = (com.ucpro.feature.lightapp.d.a.d) cVar2.b().get(optString);
                    if (dVar == null) {
                        dVar = cVar2.a().a(optString);
                        if (dVar == null) {
                            aVar.a(a("error_msg", "no such category"));
                        } else {
                            a = dVar.a();
                            if (TextUtils.isEmpty(a)) {
                                aVar.a(a("error_msg", "category Info is empty"));
                            } else {
                                cVar.a(a);
                            }
                            cVar2.c().put(optString, dVar);
                        }
                    } else {
                        a2 = dVar.a();
                        if (TextUtils.isEmpty(a2)) {
                            aVar.a(a("error_msg", "category Info is empty"));
                        } else {
                            cVar.a(a2);
                        }
                    }
                }
            } else if ("lightapp.updateCachedCategoryInfo".equals(str)) {
                JSONObject optJSONObject;
                new StringBuilder("onInvoke updateCategoryInfo\n").append(jSONObject);
                r1 = jSONObject != null ? jSONObject.optString("categoryId") : null;
                if (jSONObject != null) {
                    optJSONObject = jSONObject.optJSONObject("categoryInfo");
                }
                new StringBuilder("read from param:\nCategory Id is: ").append(r1).append("\nCategory Info is: ").append(optJSONObject.toString());
                if (!(TextUtils.isEmpty(r1) || TextUtils.isEmpty(optJSONObject.toString()))) {
                    cVar2 = this.b;
                    obj = optJSONObject.toString();
                    if (TextUtils.isEmpty(r1)) {
                        aVar.a(a("error_msg", "category id is empty"));
                    }
                    if (TextUtils.isEmpty(obj)) {
                        aVar.a(a("error_msg", "category info is empty"));
                    }
                    r2 = new h();
                    r2.a = r1;
                    r2.b = obj;
                    r2.c = System.currentTimeMillis();
                    if (((com.ucpro.feature.lightapp.d.a.d) cVar2.b().put(r1, r2)) == null) {
                        cVar2.a().b(r1, r2);
                    }
                    cVar.a(a("success_msg", "updateCategoryInfo Success"));
                }
            } else if ("lightapp.updateCachedArticleList".equals(str)) {
                new StringBuilder("onInvoke UpdateArticleList\n").append(jSONObject);
                r1 = jSONObject != null ? jSONObject.optString("categoryId") : null;
                if (jSONObject != null) {
                    obj = jSONObject.optString("articleList");
                }
                new StringBuilder("read from param:\nCategory Id is: ").append(r1).append("\nCategory Info is: ").append(obj);
                if (TextUtils.isEmpty(r1) || TextUtils.isEmpty(obj)) {
                    aVar.a(a("error_msg", "param is empty"));
                } else {
                    cVar2 = this.b;
                    if (TextUtils.isEmpty(r1)) {
                        aVar.a(a("error_msg", "category id is empty"));
                    }
                    if (TextUtils.isEmpty(obj)) {
                        aVar.a(a("error_msg", "article list is empty"));
                    }
                    r2 = new f();
                    r2.a = r1;
                    r2.b = obj;
                    r2.c = System.currentTimeMillis();
                    if (((com.ucpro.feature.lightapp.d.a.d) cVar2.c().put(r1, r2)) == null) {
                        cVar2.a().a(r1, r2);
                    }
                    cVar.a(a("success_msg", "updateArticleList Success"));
                }
            } else if ("lightapp.getCachedArticleList".equals(str)) {
                new StringBuilder("onInvoke GetArticleList\n").append(jSONObject);
                if (jSONObject != null) {
                    optString = jSONObject.optString("categoryId");
                } else {
                    optString = null;
                }
                if (TextUtils.isEmpty(optString)) {
                    aVar.a(a("error_msg", "category id is empty"));
                } else {
                    cVar2 = this.b;
                    dVar = (com.ucpro.feature.lightapp.d.a.d) cVar2.c().get(optString);
                    if (dVar == null) {
                        dVar = cVar2.a().b(optString);
                        if (dVar == null) {
                            aVar.a(a("error_msg", "no such category"));
                        } else {
                            a = dVar.a();
                            if (TextUtils.isEmpty(a)) {
                                aVar.a(a("error_msg", "article list is empty"));
                            } else {
                                cVar.a(a);
                            }
                            cVar2.c().put(optString, dVar);
                        }
                    } else {
                        a2 = dVar.a();
                        if (TextUtils.isEmpty(a2)) {
                            aVar.a(a("error_msg", "article list is empty"));
                        } else {
                            cVar.a(a2);
                        }
                    }
                }
            }
        }
        return "";
    }

    public final boolean a() {
        return true;
    }
}
