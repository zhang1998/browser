package com.taobao.weex.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.taobao.weex.bridge.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class e implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ String b;
    final /* synthetic */ EditText c;
    final /* synthetic */ h d;

    e(h hVar, c cVar, String str, EditText editText) {
        this.d = hVar;
        this.a = cVar;
        this.b = str;
        this.c = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            Map hashMap = new HashMap();
            hashMap.put("result", this.b);
            hashMap.put("data", this.c.getText().toString());
            this.a.a(hashMap);
        }
    }
}
