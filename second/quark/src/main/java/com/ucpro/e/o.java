package com.ucpro.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.uc.apollo.android.GuideDialog;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.c.b;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class o {
    Intent a;
    private k b;

    public o(k kVar) {
        this.b = kVar;
    }

    public final void a() {
        Object obj = null;
        if (this.a != null) {
            if ("enter_download_interface".equals(this.a.getStringExtra("open_type"))) {
                g.a().a(e.u, Integer.valueOf(2));
                return;
            }
            Uri data = this.a.getData();
            String action = this.a.getAction();
            CharSequence uri = data == null ? null : data.toString();
            Object ajVar;
            if ("android.intent.action.VIEW".equalsIgnoreCase(action)) {
                action = this.a.getType();
                if (TextUtils.isEmpty(action)) {
                    action = f.a(this.b.a, data);
                }
                if (!a.a(action) && ((action.contains("video/") || action.contains("audio/")) && data != null)) {
                    String stringExtra = this.a.getStringExtra("page_uri");
                    action = this.a.getStringExtra(GuideDialog.TITLE);
                    String stringExtra2 = this.a.getStringExtra("mediaplayer_id");
                    g.a().b(e.bs, 0, 0, new String[]{data.toString(), stringExtra, action, stringExtra2});
                } else if (!TextUtils.isEmpty(uri)) {
                    m.a("thirdparty", j.a, "url", uri);
                    c.a(uri);
                    ajVar = new aj();
                    ajVar.o = uri;
                    ajVar.q = true;
                    ajVar.r = true;
                    ajVar.s = aj.j;
                    g.a().a(e.k, ajVar);
                }
            } else if ("android.intent.action.SEARCH".equalsIgnoreCase(action) || "android.intent.action.WEB_SEARCH".equalsIgnoreCase(action)) {
                Object stringExtra3 = this.a.getStringExtra("query");
                if (stringExtra3 == null || stringExtra3.length() <= 0) {
                    stringExtra3 = this.a.getStringExtra("websearch");
                }
                if (!TextUtils.isEmpty(stringExtra3)) {
                    ajVar = new aj();
                    ajVar.p = stringExtra3;
                    ajVar.q = true;
                    ajVar.r = true;
                    ajVar.s = aj.k;
                    g.a().a(e.k, ajVar);
                }
            } else if ("android.intent.action.SEND".equalsIgnoreCase(action)) {
                boolean booleanExtra = this.a.getBooleanExtra("from-myfiles", true);
                Uri uri2 = (Uri) this.a.getParcelableExtra("android.intent.extra.STREAM");
                String type = this.a.getType();
                if (b.b() && ("intentType=" + type + ", isFromMyFile=" + booleanExtra + ", image path=" + uri2) != null) {
                    uri2.getPath();
                }
                if (type == null && !type.startsWith("image/")) {
                    Log.e("hjw-pic", "bad process:not image intent..");
                    com.ucpro.feature.c.e.a.b("bad process:not image intent");
                } else if (uri2 == null) {
                    Log.e("hjw-pic", "bad process:imageUri == null..");
                    com.ucpro.feature.c.e.a.b("bad process:imageUri == null");
                } else if (booleanExtra) {
                    Context a = d.a();
                    if (uri2 != null) {
                        type = uri2.getScheme();
                        if (type == null) {
                            obj = uri2.getPath();
                        } else if ("file".equals(type)) {
                            obj = uri2.getPath();
                        } else if ("content".equals(type)) {
                            Cursor query = a.getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    int columnIndex = query.getColumnIndex("_data");
                                    if (columnIndex >= 0) {
                                        obj = query.getString(columnIndex);
                                    }
                                }
                                query.close();
                            }
                        }
                    }
                    if (TextUtils.isEmpty(obj)) {
                        Log.e("hjw-pic", "bad process:local Picture Path is totally empty...");
                        com.ucpro.feature.c.e.a.b("bad process:local Picture Path is totally empty");
                        return;
                    }
                    com.ucpro.feature.c.e.a.b();
                    com.ucpro.feature.c.d.e.a(obj, new g(this));
                } else {
                    Log.e("hjw-pic", "bad process:not from local file..");
                    com.ucpro.feature.c.e.a.b("bad process:not from local file");
                }
            }
        }
    }

    public static boolean a(Intent intent) {
        if (intent != null) {
            try {
                intent.getStringExtra("any_key");
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}
