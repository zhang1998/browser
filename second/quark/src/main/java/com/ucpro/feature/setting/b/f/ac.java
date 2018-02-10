package com.ucpro.feature.setting.b.f;

import android.support.annotation.NonNull;
import com.ucpro.feature.video.c.d;
import com.ucpro.feature.video.c.d.a;
import com.ucpro.ui.b.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class ac implements d {
    ac() {
    }

    public final void a(@NonNull ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append("\n");
        }
        e.a().a("VPS请求清晰度列表成功:\n" + stringBuilder.toString(), 1);
    }

    public final void a(a aVar) {
        e.a().a("VPS请求清晰度列表失败" + aVar.toString(), 1);
    }
}
