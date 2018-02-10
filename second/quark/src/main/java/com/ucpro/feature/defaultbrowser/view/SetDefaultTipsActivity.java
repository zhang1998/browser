package com.ucpro.feature.defaultbrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.quark.browser.R;
import com.uc.framework.resources.r;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class SetDefaultTipsActivity extends Activity implements OnClickListener {
    private Intent a;

    protected void onCreate(Bundle bundle) {
        View view;
        View view2 = null;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("mask_view", -1);
            if (intExtra == -1) {
                view = null;
            } else {
                r.a(getApplicationContext());
                switch (intExtra) {
                    case 0:
                        view2 = a("setting_defaul_xiaomi.png", a.d((int) R.string.default_browser_set_mask_view_button));
                        break;
                    case 1:
                        view2 = a("setting_defaul_4.png", a.d((int) R.string.default_browser_set_mask_view_button));
                        break;
                    case 2:
                        view2 = a("setting_defaul_5.0.png", a.d((int) R.string.default_browser_set_mask_view_button));
                        break;
                    case 3:
                        view2 = a("setting_defaul_4.0.png", a.d((int) R.string.default_browser_set_mask_view_button));
                        break;
                    case 4:
                        view2 = a("setting_defaul_reset.png", a.d((int) R.string.default_browser_clear_mask_view_button));
                        break;
                }
                view = view2;
            }
            this.a = (Intent) intent.getParcelableExtra("intent");
        } else {
            view = null;
        }
        if (view != null) {
            setContentView(view);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onClick(View view) {
        if (this.a != null) {
            try {
                startActivity(this.a);
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e.toString()).append("\n");
                stringBuffer.append(e.getMessage()).append("\n");
                stringBuffer.append(e.getCause() == null ? null : e.getCause().toString()).append("\n");
                com.ucpro.business.b.a.a(stringBuffer, "custom");
            }
        }
        finish();
    }

    private a a(String str, String str2) {
        a aVar = new a(this);
        aVar.setTipDrawable(a.b(str));
        aVar.setButtonText(str2);
        aVar.setButtonOnClickListener(this);
        return aVar;
    }
}
