package com.taobao.weex.ui.component;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.TextView;
import com.taobao.weex.b.b.a;
import com.taobao.weex.b.b.b;
import com.taobao.weex.b.b.c;
import com.taobao.weex.b.b.e;
import com.taobao.weex.b.b.f;
import com.taobao.weex.ui.component.a.g;
import com.taobao.weex.ui.component.a.h;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: ProGuard */
final class d implements z {
    final /* synthetic */ l a;

    d(l lVar) {
        this.a = lVar;
    }

    public final void a() {
        String b = this.a.d;
        int i = -1;
        switch (b.hashCode()) {
            case 3076014:
                if (b.equals("date")) {
                    i = 0;
                    break;
                }
                break;
            case 3560141:
                if (b.equals("time")) {
                    i = 1;
                    break;
                }
                break;
        }
        l lVar;
        TextView textView;
        Context context;
        String charSequence;
        switch (i) {
            case 0:
                this.a.c();
                if (this.a.getParent() != null) {
                    this.a.getParent().i();
                }
                String d = this.a.e;
                String e = this.a.f;
                lVar = this.a;
                textView = (TextView) lVar.getHostView();
                context = textView.getContext();
                charSequence = textView.getText().toString();
                e gVar = new g(textView, lVar);
                Calendar instance = Calendar.getInstance();
                instance.setTime(f.a(charSequence));
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new a(gVar), instance.get(1), instance.get(2), instance.get(5));
                DatePicker datePicker = datePickerDialog.getDatePicker();
                Calendar instance2 = Calendar.getInstance(Locale.getDefault());
                Calendar instance3 = Calendar.getInstance(Locale.getDefault());
                instance2.set(1900, 0, 1);
                instance3.set(2100, 11, 31);
                if (!TextUtils.isEmpty(e)) {
                    if (datePicker.getMaxDate() >= f.a(e).getTime()) {
                        datePicker.setMinDate(f.a(e).getTime());
                    } else {
                        datePicker.setMinDate(instance2.getTimeInMillis());
                        datePicker.setMaxDate(instance3.getTimeInMillis());
                    }
                }
                if (!TextUtils.isEmpty(d)) {
                    if (datePicker.getMinDate() <= f.a(d).getTime()) {
                        datePicker.setMaxDate(f.a(d).getTime());
                    } else {
                        datePicker.setMinDate(instance2.getTimeInMillis());
                        datePicker.setMaxDate(instance3.getTimeInMillis());
                    }
                }
                datePickerDialog.setOnCancelListener(new b(gVar));
                datePickerDialog.show();
                return;
            case 1:
                this.a.c();
                if (this.a.getParent() != null) {
                    this.a.getParent().i();
                }
                lVar = this.a;
                textView = (TextView) lVar.getHostView();
                context = textView.getContext();
                charSequence = textView.getText().toString();
                e hVar = new h(textView, lVar);
                Calendar instance4 = Calendar.getInstance();
                instance4.setTime(f.b(charSequence));
                TimePickerDialog timePickerDialog = new TimePickerDialog(context, new c(hVar), instance4.get(11), instance4.get(12), false);
                timePickerDialog.setOnCancelListener(new com.taobao.weex.b.b.d(hVar));
                timePickerDialog.show();
                return;
            default:
                return;
        }
    }
}
