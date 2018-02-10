package com.ucweb.login.weibo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.g.b.a.b.a;
import com.g.b.a.b.a.c;
import com.g.b.a.b.d;
import com.ucweb.login.b;

/* compiled from: ProGuard */
public class LoginWeiboHelper extends Activity implements a {
    private c a;
    private d b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new d(this, b.WEIBO.d, "http://www.myquark.cn");
        try {
            this.a = new c(this, this.b);
            this.a.a(this);
        } catch (Exception e) {
            com.ucweb.d.a aVar = com.ucweb.d.b.a;
            if (aVar != null) {
                aVar.b(e.getMessage());
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj = 1;
        super.onActivityResult(i, i2, intent);
        new StringBuilder("onActivityResult\nrequestCode: ").append(i).append("\nresultCode: ").append(i2).append("\ndata is null: ").append(String.valueOf(intent == null));
        if (this.a != null) {
            c cVar = this.a;
            com.g.b.a.d.a.a("requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent);
            if (32973 == i) {
                if (i2 == -1) {
                    Context context = cVar.c;
                    com.g.b.a.a.c a = com.g.b.a.a.d.a(context);
                    if ((a == null || a.b > 10352) && a != null) {
                        String stringExtra = intent.getStringExtra("_weibo_appPackage");
                        if (stringExtra == null || intent.getStringExtra("_weibo_transaction") == null || !com.g.b.a.a.d.a(context, stringExtra)) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        String stringExtra2 = intent.getStringExtra("error");
                        if (stringExtra2 == null) {
                            stringExtra2 = intent.getStringExtra("error_type");
                        }
                        if (stringExtra2 == null) {
                            Bundle extras = intent.getExtras();
                            com.g.b.a.b.b a2 = com.g.b.a.b.b.a(extras);
                            if (a2 == null || !a2.a()) {
                                com.g.b.a.d.a.a("Failed to receive access token by SSO");
                                cVar.a.a(new com.g.b.a.c.a("SSO Auth failed"));
                                return;
                            }
                            com.g.b.a.d.a.a("Login Success! " + a2.toString());
                            cVar.a.a(extras);
                        } else if (stringExtra2.equals("access_denied") || stringExtra2.equals("OAuthAccessDeniedException")) {
                            com.g.b.a.d.a.a("Login canceled by user.");
                            cVar.a.a();
                        } else {
                            String stringExtra3 = intent.getStringExtra("error_description");
                            if (stringExtra3 != null) {
                                stringExtra2 = new StringBuilder(String.valueOf(stringExtra2)).append(":").append(stringExtra3).toString();
                            }
                            com.g.b.a.d.a.a("Login failed: " + stringExtra2);
                            cVar.a.a(new com.g.b.a.c.b(stringExtra2, i2, stringExtra3));
                        }
                    }
                } else if (i2 != 0) {
                } else {
                    if (intent != null) {
                        com.g.b.a.d.a.a("Login failed: " + intent.getStringExtra("error"));
                        cVar.a.a(new com.g.b.a.c.b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                        return;
                    }
                    com.g.b.a.d.a.a("Login canceled by user.");
                    cVar.a.a();
                }
            } else if (32974 == i) {
                cVar.e = intent != null ? intent.getStringExtra("com.sina.weibo.intent.extra.NICK_NAME") : "";
                if (cVar.b != null) {
                    cVar.b.a(cVar.e);
                }
            }
        }
    }

    public final void a(Bundle bundle) {
        new StringBuilder("called onComplete\nbundle is null: ").append(String.valueOf(bundle == null));
        if (bundle == null) {
            com.ucweb.d.a aVar = com.ucweb.d.b.a;
            if (aVar != null) {
                aVar.a("onComplete(), bundle is null");
                return;
            }
            return;
        }
        String str = com.g.b.a.b.b.a(bundle).a;
        if (str != null) {
            com.ucweb.d.a aVar2 = com.ucweb.d.b.a;
            if (aVar2 != null) {
                aVar2.a(b.WEIBO.d, b.WEIBO.e, str);
            }
        }
        finish();
    }

    public final void a(com.g.b.a.c.a aVar) {
        com.ucweb.d.a aVar2 = com.ucweb.d.b.a;
        if (aVar2 != null) {
            aVar2.b(aVar.getMessage());
        }
        finish();
    }

    public final void a() {
        com.ucweb.d.a aVar = com.ucweb.d.b.a;
        if (aVar != null) {
            aVar.a();
        }
        finish();
    }
}
