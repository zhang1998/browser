package com.ucpro.feature.z.e;

import android.content.Context;
import android.text.TextUtils;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import com.uc.apollo.android.GuideDialog;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.o;
import com.ucpro.feature.z.e.a.d;
import com.ucpro.feature.z.f.b.k;
import com.ucpro.feature.z.f.b.m;
import com.ucpro.feature.z.f.b.q;
import com.ucpro.feature.z.f.b.s;
import com.ucpro.feature.z.h.a;
import com.ucweb.common.util.i.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class n implements i, j {
    public List<m> a = null;
    public s b = null;
    public String c = "";
    public boolean d = false;
    public Map<String, d> e = new HashMap();
    public d f = null;
    public h g = null;
    Context h = null;
    public q i = new l(this);
    private BaseAdapter j = null;
    private OnScrollListener k = new f(this);

    public n(Context context, h hVar) {
        this.h = context;
        this.b = new k();
        this.g = hVar;
        this.g.setPresenter(this);
        this.g.setListAdapter(c());
        this.g.setOnScrollListener(this.k);
        com.ucweb.common.util.h.m.a(0, new o(this));
    }

    public final BaseAdapter c() {
        if (this.j == null) {
            this.j = new d(this);
        }
        return this.j;
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence2)) {
            g.a().b(e.ap, charSequence.toString());
        } else {
            g.a().b(e.ap, charSequence2.toString());
        }
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Object charSequence3 = charSequence.toString();
        if (z) {
            g.a().b(e.an, charSequence3);
        } else {
            g.a().b(e.ao, f.k(charSequence2.toString()));
        }
        o.a(a.g.c);
        Map hashMap = new HashMap();
        hashMap.put("content", charSequence3);
        com.ucpro.business.stat.m.a(a.g, hashMap);
    }

    public final void a() {
        com.ucpro.business.stat.m.a("searchpage", "cli_sea_bla", new String[0]);
        g.a().b(e.al);
    }

    public final void b() {
        if (this.f != null) {
            if (!TextUtils.isEmpty(this.f.f)) {
                g.a().b(e.an, this.f.f);
            } else if (!TextUtils.isEmpty(this.f.e)) {
                g.a().b(e.ao, f.k(this.f.e));
            }
            com.ucpro.business.stat.m.a("searchpage", "qusou_click", "key", this.c);
        }
    }

    static /* synthetic */ void a(n nVar, String str) {
        if (com.ucweb.common.util.k.a.h(str)) {
            nVar.e.clear();
            try {
                JSONArray optJSONArray = new JSONObject(com.ucweb.common.util.k.a.g(new File(str))).optJSONArray("root");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                        d dVar = new d();
                        dVar.a = jSONObject.optInt("type", 0);
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("keys");
                        List arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            arrayList.add((String) optJSONArray2.get(i2));
                        }
                        dVar.b = arrayList;
                        dVar.c = jSONObject.optString(GuideDialog.TITLE, "");
                        dVar.d = jSONObject.optString("content", "");
                        dVar.e = jSONObject.optString("link", "");
                        dVar.f = jSONObject.optString("search_keyword", "");
                        dVar.g = jSONObject.optString("icon", "");
                        dVar.h = jSONObject.optString("image", "");
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            nVar.e.put((String) optJSONArray2.get(i3), dVar);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
