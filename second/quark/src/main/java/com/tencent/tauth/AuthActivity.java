package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.a.b.d;
import com.tencent.a.b.p;
import com.tencent.connect.common.AssistActivity;

/* compiled from: ProGuard */
public class AuthActivity extends Activity {
    private static int a = 0;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            Uri uri = null;
            try {
                uri = getIntent().getData();
            } catch (Exception e) {
                new StringBuilder("-->onCreate, getIntent().getData() has exception! ").append(e.getMessage());
            }
            new StringBuilder("-->onCreate, uri: ").append(uri);
            if (uri == null || uri.toString() == null || uri.toString().equals("")) {
                finish();
                return;
            }
            String uri2 = uri.toString();
            Bundle a = p.a(uri2.substring(uri2.indexOf("#") + 1));
            if (a == null) {
                finish();
                return;
            }
            String string = a.getString("action");
            if (string == null) {
                return;
            }
            Intent intent;
            if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("addToQQFavorites") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
                if (string.equals("shareToQzone") && d.a((Context) this, "com.tencent.mobileqq") != null) {
                    if (d.a(d.a((Context) this, "com.tencent.mobileqq"), "5.2.0") < 0) {
                        int i = a + 1;
                        a = i;
                        if (i == 2) {
                            a = 0;
                            finish();
                            return;
                        }
                    }
                }
                intent = new Intent(this, AssistActivity.class);
                intent.putExtras(a);
                intent.setFlags(603979776);
                startActivity(intent);
                finish();
            } else if (string.equals("sharePrize")) {
                intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
                String string2 = a.getString("response");
                Object obj = "";
                try {
                    obj = p.c(string2).getString("activityid");
                } catch (Exception e2) {
                }
                if (!TextUtils.isEmpty(obj)) {
                    intent.putExtra("sharePrize", true);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("activityid", obj);
                    intent.putExtras(bundle2);
                }
                startActivity(intent);
                finish();
            }
        }
    }
}
