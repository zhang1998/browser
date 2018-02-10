package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.framework.resources.r;
import com.ucpro.business.stat.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.q;
import com.ucpro.feature.collectpanel.view.c;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.i.f;
import java.util.List;

/* compiled from: ProGuard */
public class AddFavoriteActivity extends Activity {
    private Handler a = new Handler(Looper.getMainLooper());
    private boolean b = false;
    private Runnable c = new d(this);

    protected void onCreate(@Nullable Bundle bundle) {
        Object obj = null;
        super.onCreate(bundle);
        e.b();
        e.a((Context) this);
        r.a(getApplicationContext());
        Intent intent = getIntent();
        Object action = intent == null ? null : intent.getAction();
        if (intent != null) {
            obj = intent.getType();
        }
        if (!"android.intent.action.SEND".equals(action) || obj == null) {
            b();
        } else if ("text/plain".equals(obj)) {
            List l = f.l(intent.getStringExtra("android.intent.extra.TEXT"));
            if (l.size() > 0) {
                String str = (String) l.get(0);
                m.a("bookmark", "bookmark_thirdparty_toast_show", new String[0]);
                q.a(this, str, new e(this, str));
                return;
            }
            b();
        } else {
            b();
        }
    }

    private void b() {
        e.a().a(a.d((int) R.string.bookmark_add_error), (int) SettingsConst.GLOBAL_SETTINGS);
        a();
    }

    public final void a() {
        this.a.postDelayed(this.c, 2000);
    }

    protected void onDestroy() {
        super.onDestroy();
        e.b();
    }

    static /* synthetic */ void a(AddFavoriteActivity addFavoriteActivity, String str, String str2, long j) {
        e.a().a("collect_toast_icon.svg", a.d((int) R.string.bookmark_add_sucess), a.d((int) R.string.select_classification), new k(addFavoriteActivity, str, str2, j));
        addFavoriteActivity.a();
    }

    static /* synthetic */ void b(AddFavoriteActivity addFavoriteActivity, String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Object cVar = new c(addFavoriteActivity, 2);
            j jVar = new j(cVar, addFavoriteActivity);
            cVar.setPresenter(jVar);
            if (jVar.a != null) {
                jVar.f.setContentView((View) jVar.a);
                jVar.a.a(str, str2, false);
                jVar.b = j;
            }
        }
    }
}
