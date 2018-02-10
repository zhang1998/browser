package com.ucpro.feature.downloadpage.a;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.b.a;
import com.ucpro.feature.downloadpage.e.j;
import com.ucpro.ui.widget.TextCheckBox;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucpro.ui.widget.b;

/* compiled from: ProGuard */
public final class k extends a {
    private ATTextView A;
    private j B;
    private String C;
    private String D;
    private int E = 3;
    private OnSeekBarChangeListener F = new a(this);
    private b G = new j(this);
    private b H = new e(this);
    private ATTextView b;
    private RelativeLayout v;
    private TextCheckBox w;
    private TextCheckBox x;
    private ImageView y;
    private AppCompatSeekBar z;

    public k(Context context, j jVar) {
        super(context);
        this.B = jVar;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.download_setting_dialog, null);
        this.v = (RelativeLayout) inflate.findViewById(R.id.rl_edit);
        this.v.setOnClickListener(new f(this));
        ((ATTextView) inflate.findViewById(R.id.tv_path_desc)).setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        ((ATTextView) inflate.findViewById(R.id.open_thread_set_desc)).setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.b = (ATTextView) inflate.findViewById(R.id.tv_path);
        this.b.setText(this.B.i());
        this.b.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.y = (ImageView) inflate.findViewById(R.id.edit);
        this.w = (TextCheckBox) inflate.findViewById(R.id.wifi);
        this.x = (TextCheckBox) inflate.findViewById(R.id.open_thread_set);
        this.w.setTextDesc(com.ucpro.ui.c.a.d((int) R.string.download_setting_only_wifi));
        this.x.setTextDesc(com.ucpro.ui.c.a.d((int) R.string.download_setting_thread_set));
        this.w.setTextSize$255e752((float) com.ucpro.ui.c.a.c((int) R.dimen.dir_manager_item_text_size));
        this.x.setTextSize$255e752((float) com.ucpro.ui.c.a.c((int) R.dimen.dir_manager_item_text_size));
        this.w.setOnSelectClick(this.G);
        this.x.setOnSelectClick(this.H);
        this.w.setSelected(this.B.e());
        this.x.setSelected(this.B.f());
        this.y.setImageDrawable(com.ucpro.ui.c.a.a("download_rename.svg"));
        this.a.addView(inflate, new LayoutParams(-1, -2));
        this.D = com.ucpro.ui.c.a.d((int) R.string.download_setting_thread_num) + "<font color='%s'>（%s）</font>";
        this.C = Integer.toHexString(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.C = this.C.substring(2, this.C.length());
        this.C = "#" + this.C;
        String str = this.C;
        int g = this.B.g();
        this.E = com.ucpro.services.download.b.f();
        String format = String.format(this.D, new Object[]{str, String.valueOf(g < this.E ? this.E : g)});
        this.A = new ATTextView(getContext());
        this.A.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_title_desc));
        this.A.setText(Html.fromHtml(format));
        this.A.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_margin);
        this.a.addView(this.A, layoutParams);
        this.z = (AppCompatSeekBar) LayoutInflater.from(getContext()).inflate(R.layout.download_seekbar, null);
        this.z.setMax(com.ucpro.services.download.b.e());
        this.z.setProgress(r1);
        this.z.setThumbOffset(0);
        a(this.B.f());
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_item_inner_margin);
        layoutParams.leftMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
        layoutParams.rightMargin = -com.ucpro.ui.c.a.c((int) R.dimen.seek_bar_thumb_size);
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.dialog_common_margin);
        this.a.addView(this.z, layoutParams);
        h().b();
    }

    private void a(boolean z) {
        float f = z ? IPictureView.DEFAULT_MIN_SCALE : 0.5f;
        OnSeekBarChangeListener onSeekBarChangeListener = z ? this.F : null;
        this.A.setAlpha(f);
        this.z.setAlpha(f);
        this.z.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
