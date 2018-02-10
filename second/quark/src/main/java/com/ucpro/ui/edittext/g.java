package com.ucpro.ui.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class g extends RelativeLayout implements TextWatcher, OnClickListener, OnFocusChangeListener {
    private j a = new j(getContext());
    private ImageView b;
    private c c;
    private OnFocusChangeListener d;
    private TextWatcher e;
    private boolean f;

    public g(Context context, boolean z) {
        super(context);
        this.f = z;
        int c = a.c((int) R.dimen.dialog_edit_text_text_size);
        int c2 = a.c((int) R.dimen.dialog_edit_text_height);
        this.a.setBottomLineColor(a.c("user_feedback_contact_input_box_bottom_line_color"));
        this.a.a(0, (float) c);
        this.a.setPadding(0, 0, 0, 0);
        this.a.setSingleLine(true);
        this.a.setGravity(16);
        this.a.setBackgroundColor(0);
        this.a.setHint(a.d((int) R.string.user_feedback_contact_inputbox_hint_text));
        this.a.setOnFocusChangeListener(this);
        this.a.a((TextWatcher) this);
        addView(this.a, new LayoutParams(-1, c2));
        if (this.f) {
            this.b = new ImageView(getContext());
            this.b.setOnClickListener(this);
            this.b.setPadding(a.c((int) R.dimen.dialog_edit_text_clear_padding_left), a.c((int) R.dimen.dialog_edit_text_clear_padding_top), 0, a.c((int) R.dimen.dialog_edit_text_clear_padding_bottom));
            setImageVisible(false);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.alignWithParent = true;
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.b, layoutParams);
        }
        c = a.c("default_maintext_gray");
        c2 = a.c("user_feedback_hint_text_color");
        if (this.a != null) {
            this.a.setTextColor(c);
            this.a.setHintTextColor(c2);
        }
        if (this.b != null) {
            this.b.setImageDrawable(a.a("searchpage_search_bar_delete.svg"));
        }
    }

    public void setClearListener(c cVar) {
        this.c = cVar;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.d = onFocusChangeListener;
    }

    public void setHint(CharSequence charSequence) {
        if (this.a != null && !TextUtils.isEmpty(charSequence)) {
            this.a.setHint(charSequence);
        }
    }

    public String getText() {
        if (this.a != null) {
            return this.a.getText().toString();
        }
        return null;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.e != null) {
            this.e.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setImageVisible(!TextUtils.isEmpty(charSequence.toString()));
        if (this.e != null) {
            this.e.onTextChanged(charSequence, i, i2, i3);
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.e != null) {
            this.e.afterTextChanged(editable);
        }
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2 = false;
        if (z) {
            if (!TextUtils.isEmpty(getText())) {
                z2 = true;
            }
            setImageVisible(z2);
        } else {
            setImageVisible(false);
        }
        if (this.d != null) {
            this.d.onFocusChange(view, z);
        }
    }

    public void onClick(View view) {
        if (this.a != null) {
            this.a.getText().toString();
            this.a.setText(null);
        }
    }

    private void setImageVisible(boolean z) {
        if (this.b != null) {
            this.b.setVisibility(z ? 0 : 4);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.setSingleLine(true);
        }
    }

    public void setInputType(int i) {
        if (this.a != null) {
            this.a.setInputType(i);
        }
    }

    public void setTransformationMethod(TransformationMethod transformationMethod) {
        if (this.a != null) {
            this.a.setTransformationMethod(transformationMethod);
        }
    }
}
