package com.ucpro.feature.inputenhance;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.EditText;
import com.ucpro.base.system.b;
import com.ucpro.feature.inputenhance.a.a;
import com.ucpro.ui.edittext.CustomEditText;

/* compiled from: ProGuard */
final class o extends AsyncTask {
    final /* synthetic */ g a;

    o(g gVar) {
        this.a = gVar;
    }

    protected final void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.a.a && g.a(this.a) && ((double) a.a(this.a.f).height()) < ((double) b.a.g()) * 0.8d) {
            if (this.a.e.getCurrentState() == null) {
                this.a.e.a(this.a.e.b, -1);
            }
            g.d(this.a);
            this.a.e.b();
            if (!this.a.isShowing()) {
                if (this.a.g instanceof EditText) {
                    TextUtils.isEmpty(((EditText) this.a.g).getText().toString());
                } else if (this.a.g instanceof CustomEditText) {
                    TextUtils.isEmpty(((CustomEditText) this.a.g).getText().toString());
                }
            }
            this.a.show();
        }
    }

    protected final Object doInBackground(Object... objArr) {
        for (int i = 0; i < 10 && this.a.a() == null; i++) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
