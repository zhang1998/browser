package com.ucpro.feature.downloadpage.a;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.feature.b.a;
import com.ucpro.services.download.b;
import com.ucpro.ui.g.h;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public class l extends a implements TextWatcher, com.ucpro.ui.g.l {
    private long A = -1;
    private MaterialEditText b;
    private MaterialEditText v;
    private AppCompatSeekBar w;
    private d x;
    private boolean y = false;
    private int z = 0;

    public l(Context context, d dVar, boolean z, int i) {
        super(context);
        this.x = dVar;
        this.y = z;
        this.z = i;
        this.b = new MaterialEditText(getContext());
        this.b.setTextSize(0, com.ucpro.ui.c.a.a((int) R.dimen.bookmark_edittext_text_size));
        this.b.setFloatingLabel(2);
        this.b.setMaxLines(1);
        this.b.setSingleLine();
        this.b.setHint(com.ucpro.ui.c.a.d((int) R.string.download_setting_download_link));
        this.b.setFloatingLabelText(com.ucpro.ui.c.a.d((int) R.string.download_setting_download_link_desc));
        this.b.setShowClearButton(false);
        this.b.addTextChangedListener(this);
        this.b.setFloatingLabelAlwaysShown(true);
        this.a.addView(this.b, new LayoutParams(-1, -2));
        this.v = new MaterialEditText(getContext());
        this.v.setTextSize(0, com.ucpro.ui.c.a.a((int) R.dimen.bookmark_edittext_text_size));
        this.v.setFloatingLabel(2);
        this.v.setMaxLines(1);
        this.v.setSingleLine();
        this.v.setHint(com.ucpro.ui.c.a.d((int) R.string.download_setting_file_name));
        this.v.setFloatingLabelText(com.ucpro.ui.c.a.d((int) R.string.download_setting_file_desc));
        this.v.setShowClearButton(false);
        this.v.setSingleLine();
        this.v.setFloatingLabelAlwaysShown(true);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_margin);
        this.a.addView(this.v, layoutParams);
        if (this.y) {
            String str = com.ucpro.ui.c.a.d((int) R.string.download_setting_thread_num) + "<font color='%s'>（%s）</font>";
            String toHexString = Integer.toHexString(com.ucpro.ui.c.a.c("default_purpleblue"));
            toHexString = String.format(str, new Object[]{"#" + toHexString.substring(2, toHexString.length()), this.z});
            View textView = new TextView(getContext());
            textView.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_title_desc));
            textView.setText(Html.fromHtml(toHexString));
            textView.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
            layoutParams = new LayoutParams(-1, -2);
            layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_margin);
            this.a.addView(textView, layoutParams);
            this.w = (AppCompatSeekBar) LayoutInflater.from(getContext()).inflate(R.layout.download_seekbar, null);
            this.w.setMax(b.e());
            this.w.setThumbOffset(0);
            int f = b.f();
            this.w.setProgress(this.z < f ? f : this.z);
            this.w.setOnSeekBarChangeListener(new h(this, f, textView, str, r5));
            layoutParams = new LayoutParams(-1, -2);
            layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_inner_margin);
            layoutParams.leftMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
            layoutParams.rightMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
            layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_margin);
            this.a.addView(this.w, layoutParams);
        }
        h().b();
        this.b.setMetTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.b.setMetHintTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
        this.b.setPrimaryColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.b.setBaseColor(com.ucpro.ui.c.a.c("bookmark_edittext_base_color"));
        this.b.setFloatingLabelTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.v.setMetTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.v.setMetHintTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
        this.v.setPrimaryColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.v.setBaseColor(com.ucpro.ui.c.a.c("bookmark_edittext_base_color"));
        this.v.setFloatingLabelTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.b.setText(this.x.a());
        a((com.ucpro.ui.g.l) this);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            String obj = editable.toString();
            if (!TextUtils.isEmpty(obj)) {
                this.x.a(obj, new b(this, obj));
            }
        }
    }

    public boolean a(h hVar, int i, Object obj) {
        if (i != c) {
            return false;
        }
        int progress;
        String obj2 = this.v.getText().toString();
        String obj3 = this.b.getText().toString();
        d dVar = this.x;
        long j = this.A;
        if (this.y) {
            progress = this.w.getProgress();
        } else {
            progress = this.z;
        }
        dVar.a(obj3, obj2, j, progress);
        if (com.ucweb.common.util.n.a.a(obj2) || com.ucweb.common.util.n.a.a(obj3)) {
            return true;
        }
        return false;
    }
}
