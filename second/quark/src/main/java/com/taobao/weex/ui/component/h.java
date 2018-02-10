package com.taobao.weex.ui.component;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class h implements OnEditorActionListener {
    final /* synthetic */ l a;

    h(l lVar) {
        this.a = lVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != this.a.h) {
            return false;
        }
        Map hashMap = new HashMap(2);
        hashMap.put("returnKeyType", this.a.i);
        hashMap.put("value", textView.getText().toString());
        this.a.fireEvent("return", hashMap);
        return true;
    }
}
