package com.ucpro.feature.setting.b.f;

import android.support.annotation.NonNull;
import android.util.Log;
import com.ucpro.feature.video.c.a;
import com.ucpro.ui.b.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class ck implements a {
    final /* synthetic */ String a;

    ck(String str) {
        this.a = str;
    }

    public final void a(String str, @NonNull ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append("\n");
        }
        Log.e("hjw-video", stringBuilder.toString());
        e.a().a("VPS请求" + this.a + "清晰度视频成功\nmUrl:\n" + stringBuilder.toString(), 0);
    }

    public final void a(String str, com.ucpro.feature.video.c.d.a aVar) {
        e.a().a("VPS请求" + this.a + "清晰度视频失败" + aVar.toString(), 0);
    }
}
