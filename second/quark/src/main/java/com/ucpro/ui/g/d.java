package com.ucpro.ui.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.j;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class d extends o implements l {
    private String A;
    public ATTextView a;
    public a b;
    private LinearLayout v = new LinearLayout(getContext());
    private ImageView w;
    private j x;
    private String y;
    private String z;

    public d(Context context, String str) {
        super(context);
        this.A = str;
        this.v.setOrientation(1);
        this.a = new ATTextView(getContext());
        this.a.setTextSize(0, a.a((int) R.dimen.common_dialog_text_size));
        this.a.setSingleLine();
        this.a.setTypeface(null, 1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a.c((int) R.dimen.common_dialog_margin_left), a.c((int) R.dimen.common_dialog_margin_top), a.c((int) R.dimen.common_dialog_margin_left), 0);
        this.v.addView(this.a, layoutParams);
        this.w = new ImageView(getContext());
        this.w.setScaleType(ScaleType.FIT_XY);
        this.w.setOnClickListener(new f(this));
        layoutParams = new LinearLayout.LayoutParams(-2, a.c((int) R.dimen.captcha_dialog_image_view_height));
        layoutParams.setMargins(a.c((int) R.dimen.common_dialog_margin_left), a.c((int) R.dimen.captcha_dialog_image_view_margin_top), a.c((int) R.dimen.common_dialog_margin_left), 0);
        this.v.addView(this.w, layoutParams);
        this.x = new j(getContext());
        this.x.a(0, a.a((int) R.dimen.common_dialog_text_size));
        this.x.setHint((int) R.string.captcha_dialog_edittext_hint);
        this.x.setBackgroundColor(0);
        this.x.requestFocus();
        layoutParams = new LinearLayout.LayoutParams(-1, a.c((int) R.dimen.captcha_dialog_edittext_view_height));
        layoutParams.setMargins(a.c((int) R.dimen.common_dialog_margin_left), a.c((int) R.dimen.captcha_dialog_edittext_view_margin_top), a.c((int) R.dimen.common_dialog_margin_left), 0);
        this.v.addView(this.x, layoutParams);
        h().a(this.v, new LinearLayout.LayoutParams(-1, -1));
        h().b();
        a((l) this);
        a();
        setCanceledOnTouchOutside(false);
    }

    public final void a() {
        super.a();
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.a.getPaint().setFakeBoldText(true);
        this.x.setHintTextColor(a.c("default_commentstext_gray"));
        this.x.setTextColor(a.c("default_maintext_gray"));
        this.x.setBottomLineColor(a.c("default_iconcolor"));
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.y = str;
            this.z = str2;
            byte[] decode = Base64.decode(str2.getBytes(), 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (this.w != null) {
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                this.w.getLayoutParams().width = (width / height) * this.w.getLayoutParams().height;
                this.w.setImageBitmap(decodeByteArray);
            }
        }
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (h.c == i && this.b != null) {
            this.b.a(this.A, this.y, this.x.getText().toString());
        }
        return false;
    }
}
