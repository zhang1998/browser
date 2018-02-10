package com.taobao.weex.b.b;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class a implements OnDateSetListener {
    final /* synthetic */ e a;

    public a(e eVar) {
        this.a = eVar;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        int i4 = i2 + 1;
        this.a.a(true, i + "-" + (i4 < 10 ? new StringBuilder(SettingsConst.FALSE).append(i4).toString() : String.valueOf(i4)) + "-" + i3);
    }
}
