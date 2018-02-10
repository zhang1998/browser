package com.ucpro.feature.r.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.bumptech.glide.s;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.ui.g.i;
import com.ucpro.ui.g.o;
import com.ucpro.ui.scrollview.ScrollViewWithMaxHeight;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.a.u;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class a extends o implements OnDismissListener {
    private View a;
    private ImageView b;
    private ATTextView v;
    private ATTextView w;
    private ATTextView x;

    public a(Context context) {
        super(context);
        this.a = getLayoutInflater().inflate(com.ucpro.ui.c.a.b() ? R.layout.upgrade_dialog_avatar_night : R.layout.upgrade_dialog_avatar, null);
        ScrollViewWithMaxHeight scrollViewWithMaxHeight = (ScrollViewWithMaxHeight) this.a.findViewById(R.id.upgrade_sv);
        scrollViewWithMaxHeight.setMaxHeight(b.a.g() / 3);
        scrollViewWithMaxHeight.setScrollBarStyle(33554432);
        scrollViewWithMaxHeight.setScrollbarFadingEnabled(false);
        this.b = (ImageView) this.a.findViewById(R.id.upgrade_avatar);
        this.v = (ATTextView) this.a.findViewById(R.id.upgrade_nickname);
        this.w = (ATTextView) this.a.findViewById(R.id.upgrade_jobtitle);
        this.x = (ATTextView) this.a.findViewById(R.id.upgrade_content);
        this.v.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.w.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.x.setTextColor(com.ucpro.ui.c.a.c("dialog_content_color"));
        h().a(this.a);
        h().b();
        setOnDismissListener(this);
    }

    public final void a(u uVar) {
        CharSequence charSequence;
        CharSequence a = uVar.a("avatar");
        CharSequence a2 = uVar.a("nick_name");
        CharSequence a3 = uVar.a("job_title");
        if (TextUtils.isEmpty(a)) {
            Object obj = "";
        } else {
            charSequence = a;
        }
        try {
            ((com.ucpro.base.b.b) c.b(d.a())).b(obj).a(this.b);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(a2)) {
            a = "";
        } else {
            a = a2;
        }
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        this.v.setText(a);
        if (TextUtils.isEmpty(a3)) {
            a = "";
        } else {
            a = a3;
        }
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        this.w.setText(a);
        String str = uVar.g;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.x.setText(Html.fromHtml(str));
        a = uVar.e;
        charSequence = uVar.f;
        if (com.ucweb.common.util.n.a.b(a) && com.ucweb.common.util.n.a.b(charSequence)) {
            i i = i();
            if (i != null) {
                i.setText(charSequence);
                i.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.a);
            }
            i j = j();
            if (j != null) {
                j.setText(a);
                j.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.c);
            }
        }
        show();
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        try {
            ((com.ucpro.base.b.b) c.b(d.a())).a(new s(this.b));
        } catch (Exception e) {
        }
    }
}
