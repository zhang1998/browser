package com.uc.aerie.updater.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.uc.aerie.updater.d;
import com.uc.aerie.updater.e;
import com.uc.aerie.updater.g;
import com.uc.aerie.updater.h;
import com.uc.aerie.updater.n;
import com.uc.aerie.updater.o;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class AerieUpdaterTestActivity extends Activity implements OnClickListener {
    private Handler a = new a(this, Looper.getMainLooper());

    static /* synthetic */ void b(AerieUpdaterTestActivity aerieUpdaterTestActivity, Message message) {
        aerieUpdaterTestActivity.setContentView(o.update_success_layout);
        aerieUpdaterTestActivity.findViewById(n.success_finish).setOnClickListener(aerieUpdaterTestActivity);
        g gVar = (g) message.obj;
        if (gVar != null) {
            ((TextView) aerieUpdaterTestActivity.findViewById(n.success_result)).setText("成功");
            TextView textView = (TextView) aerieUpdaterTestActivity.findViewById(n.cost);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gVar.a).append("ms\n");
            stringBuilder.append("主包：").append(gVar.b).append("ms\n");
            stringBuilder.append("组件：").append(gVar.c).append("ms\n");
            textView.setText(stringBuilder.toString());
            stringBuilder = new StringBuilder("name\n");
            StringBuilder stringBuilder2 = new StringBuilder("dex\n");
            StringBuilder stringBuilder3 = new StringBuilder("opt\n");
            StringBuilder stringBuilder4 = new StringBuilder("res\n");
            StringBuilder stringBuilder5 = new StringBuilder("so\n");
            if (!gVar.d.isEmpty()) {
                for (Entry entry : gVar.d.entrySet()) {
                    String str = (String) entry.getKey();
                    e eVar = (e) entry.getValue();
                    stringBuilder.append(str).append("\n");
                    stringBuilder2.append(eVar.a).append("\n");
                    stringBuilder3.append(eVar.b).append("\n");
                    stringBuilder4.append(eVar.d).append("\n");
                    stringBuilder5.append(eVar.c).append("\n");
                }
            }
            CharSequence spannableString = new SpannableString(stringBuilder.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 0, 4, 18);
            ((TextView) aerieUpdaterTestActivity.findViewById(n.module_name)).setText(spannableString);
            spannableString = new SpannableString(stringBuilder2.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 0, 3, 18);
            ((TextView) aerieUpdaterTestActivity.findViewById(n.merge_dex)).setText(spannableString);
            spannableString = new SpannableString(stringBuilder3.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 0, 3, 18);
            ((TextView) aerieUpdaterTestActivity.findViewById(n.opt)).setText(spannableString);
            spannableString = new SpannableString(stringBuilder4.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 0, 3, 18);
            ((TextView) aerieUpdaterTestActivity.findViewById(n.merge_res)).setText(spannableString);
            spannableString = new SpannableString(stringBuilder5.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 0, 2, 18);
            ((TextView) aerieUpdaterTestActivity.findViewById(n.merge_so)).setText(spannableString);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(o.aerie_test_layout);
        findViewById(n.cancel_button).setOnClickListener(this);
        this.a.sendMessage(this.a.obtainMessage(0, getIntent().getStringExtra("path")));
    }

    public void onClick(View view) {
        if (view.getId() == n.cancel_button) {
            finish();
            Process.killProcess(Process.myPid());
        } else if (view.getId() == n.success_finish || view.getId() == n.fail_finish) {
            finish();
        }
    }

    static /* synthetic */ void a(AerieUpdaterTestActivity aerieUpdaterTestActivity, Message message) {
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            aerieUpdaterTestActivity.a.sendMessage(aerieUpdaterTestActivity.a.obtainMessage(1, 1, 0, new h("package path is null", 150)));
        } else {
            new Thread(new b(aerieUpdaterTestActivity, str)).start();
        }
    }

    static /* synthetic */ void c(AerieUpdaterTestActivity aerieUpdaterTestActivity, Message message) {
        aerieUpdaterTestActivity.setContentView(o.update_fail_layout);
        aerieUpdaterTestActivity.findViewById(n.fail_finish).setOnClickListener(aerieUpdaterTestActivity);
        Exception exception = (Exception) message.obj;
        ((TextView) aerieUpdaterTestActivity.findViewById(n.fail_result)).setText("失败");
        int i = -999;
        CharSequence charSequence = "unknown";
        if (exception instanceof d) {
            i = ((d) exception).a;
            charSequence = exception.toString();
        } else if (exception instanceof h) {
            i = ((h) exception).a;
            Object exception2 = exception.toString();
        }
        ((TextView) aerieUpdaterTestActivity.findViewById(n.errno)).setText(String.valueOf(i));
        ((TextView) aerieUpdaterTestActivity.findViewById(n.errno_info)).setText(charSequence);
    }
}
