package com.taobao.weex.b.b;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class c implements OnTimeSetListener {
    final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.a.a(true, (i < 10 ? new StringBuilder(SettingsConst.FALSE).append(i).toString() : String.valueOf(i)) + ":" + (i2 < 10 ? new StringBuilder(SettingsConst.FALSE).append(i2).toString() : String.valueOf(i2)));
    }
}
