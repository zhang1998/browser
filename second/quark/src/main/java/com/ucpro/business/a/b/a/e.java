package com.ucpro.business.a.b.a;

import android.text.TextUtils;
import com.uc.quark.s;
import com.ucweb.common.util.f.a;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ c b;

    e(c cVar, s sVar) {
        this.b = cVar;
        this.a = sVar;
    }

    public final void run() {
        if (this.b.b != null && !this.b.b.isEmpty() && this.b.b.get(0) != null && !TextUtils.isEmpty(((f) this.b.b.get(0)).i)) {
            String h = this.a.h();
            ((f) this.b.b.get(0)).c = h;
            try {
                JSONObject jSONObject = new JSONObject(((f) this.b.b.get(0)).i);
                ((f) this.b.b.get(0)).g = jSONObject.optBoolean("use_hardware");
                ((f) this.b.b.get(0)).h = jSONObject.optInt("in_density");
                ((f) this.b.b.get(0)).j = jSONObject.optInt("play_times");
                ((f) this.b.b.get(0)).k = jSONObject.optInt("loop_times");
                ((f) this.b.b.get(0)).l = jSONObject.optInt("triggr_type");
                ((f) this.b.b.get(0)).m = jSONObject.optInt("size_width");
                ((f) this.b.b.get(0)).n = jSONObject.optInt("size_height");
                ((f) this.b.b.get(0)).o = jSONObject.optInt("inset_bottom");
                List a = a.a(h, true);
                if (!a.isEmpty()) {
                    for (int i = 0; i < a.size(); i++) {
                        File file = (File) a.get(i);
                        if (!file.getPath().contains(File.separator)) {
                            if (file.getName().equals("data.json")) {
                                ((f) this.b.b.get(0)).f = this.b.a() + file.getName();
                            } else if (file.getName().contains("-night")) {
                                ((f) this.b.b.get(0)).e = this.b.a() + file.getName();
                            } else {
                                ((f) this.b.b.get(0)).d = this.b.a() + file.getName();
                            }
                        }
                    }
                    a.a(h, this.b.a());
                    this.b.b(this.b.b);
                }
            } catch (Throwable th) {
            }
        }
    }
}
