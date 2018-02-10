package com.ucpro.ui.edittext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.quark.browser.R;
import com.ucweb.common.util.a;
import com.ucweb.common.util.i.e;
import com.ui.edittext.EditText;
import com.ui.edittext.ag;
import com.ui.edittext.c;
import com.ui.edittext.d;
import com.ui.edittext.u;

/* compiled from: ProGuard */
public class CustomEditText extends EditText implements ag, d {
    private static e o;
    private boolean k;
    private boolean l;
    private a m;
    private d n;
    private a p = new i(this);

    public CustomEditText(Context context) {
        super(context);
        s();
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        s();
    }

    private void s() {
        t();
        setFilters(new InputFilter[]{new LengthFilter(1000)});
        super.setContextMenuListener(this);
        super.setOnCustomActionListener(this);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("uc's edittext forbid using");
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        throw new RuntimeException("uc's edittext forbid using");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public void setPasteAndGoListener(a aVar) {
        this.m = aVar;
    }

    public void setContextMenuListener(d dVar) {
        this.n = dVar;
    }

    public final void r() {
        t();
    }

    private void t() {
        super.setHighlightColor(com.ucpro.ui.c.a.c("edittext_highlight_color"));
        super.setSelectHandleLeft(com.ucpro.ui.c.a.a("handle_left.svg"));
        super.setSelectHandleRight(com.ucpro.ui.c.a.a("handle_right.svg"));
        super.setSelectHandleCenter(com.ucpro.ui.c.a.a("handle_middle.svg"));
        super.setCustomContextMenuBackground(com.ucpro.ui.c.a.a("custom_menu_background.9.png"));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setIntrinsicWidth((int) com.ucweb.common.util.a.a.a(getContext(), 2.0f));
        shapeDrawable.getPaint().setColor(com.ucpro.ui.c.a.c("edittext_cursor_color"));
        super.setCursorDrawable(new Drawable[]{shapeDrawable, shapeDrawable});
    }

    private static e getClipBoardCallback() {
        return o;
    }

    public static void setClipBoardCallback(e eVar) {
        o = eVar;
    }

    public final void a(u uVar) {
        String str = "";
        if (getClipBoardCallback() != null) {
            str = getClipBoardCallback().a();
        }
        switch (h.a[uVar.ordinal()]) {
            case 1:
                n();
                return;
            case 2:
                if (!TextUtils.isEmpty(str)) {
                    if (this.m != null) {
                        a(uVar, b(str), c(str));
                        return;
                    }
                    a(uVar, b(str));
                    return;
                }
                return;
            case 3:
                n();
                return;
            case 4:
                Selection.selectAll(getText());
                m();
                if (TextUtils.isEmpty(str)) {
                    if (l()) {
                        b(uVar, u(), v());
                        return;
                    }
                    b(uVar, u(), v(), x());
                    return;
                } else if (!l()) {
                    b(uVar, u(), v(), b(str), x());
                    return;
                } else if (this.m != null) {
                    b(uVar, u(), v(), b(str), c(str));
                    return;
                } else {
                    b(uVar, u(), v(), b(str));
                    return;
                }
            case 5:
                if (TextUtils.isEmpty(str)) {
                    b(uVar, w(), x());
                    return;
                }
                b(uVar, w(), x(), b(str));
                return;
            case 6:
            case 7:
                if (TextUtils.isEmpty(str)) {
                    b(uVar, w(), x());
                    return;
                }
                b(uVar, w(), x(), b(str));
                return;
            case 8:
            case 9:
            case 10:
                if (TextUtils.isEmpty(str)) {
                    if (l()) {
                        b(uVar, u(), v());
                        return;
                    }
                    b(uVar, u(), v(), x());
                    return;
                } else if (!l()) {
                    b(uVar, u(), v(), b(str), x());
                    return;
                } else if (this.m != null) {
                    b(uVar, u(), v(), b(str), c(str));
                    return;
                } else {
                    b(uVar, u(), v(), b(str));
                    return;
                }
            default:
                return;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.l && motionEvent.getAction() == 0 && !isFocusable()) {
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void d() {
        if (this.n != null) {
            this.n.d();
        }
    }

    public final void e() {
        if (this.n != null) {
            this.n.e();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ui.edittext.c r7, java.lang.Object r8) {
        /*
        r6 = this;
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = 1;
        r1 = 0;
        r2 = r7.a;
        switch(r2) {
            case 20041: goto L_0x006a;
            case 20042: goto L_0x0082;
            case 20043: goto L_0x0095;
            case 20044: goto L_0x00a2;
            case 20045: goto L_0x00b6;
            case 20084: goto L_0x0073;
            case 20095: goto L_0x001c;
            case 20096: goto L_0x0050;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r6.n();
        if (r0 != 0) goto L_0x0012;
    L_0x000f:
        r6.k();
    L_0x0012:
        r0 = r6.n;
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r6.n;
        r0.a(r7, r8);
    L_0x001b:
        return;
    L_0x001c:
        r2 = r6.getTextSelected();
        r3 = r6.getSelectionStart();
        r4 = r6.getSelectionEnd();
        r3 = java.lang.Math.min(r3, r4);
        r4 = r6.getSelectionStart();
        r5 = r6.getSelectionEnd();
        r4 = java.lang.Math.max(r4, r5);
        if (r4 <= r3) goto L_0x003f;
    L_0x003a:
        r3 = "";
        r6.a(r3);
    L_0x003f:
        r3 = getClipBoardCallback();
        if (r3 == 0) goto L_0x004c;
    L_0x0045:
        r3 = getClipBoardCallback();
        r3.a(r2);
    L_0x004c:
        r6.k = r0;
        r0 = r1;
        goto L_0x000a;
    L_0x0050:
        r0 = r6.getTextSelected();
        r2 = getClipBoardCallback();
        if (r2 == 0) goto L_0x0061;
    L_0x005a:
        r2 = getClipBoardCallback();
        r2.a(r0);
    L_0x0061:
        r0 = r6.getOrderSelectionEnd();
        r6.setSelection(r0);
        r0 = r1;
        goto L_0x000a;
    L_0x006a:
        r0 = r7.e;
        r0 = (java.lang.String) r0;
        r6.a(r0);
        r0 = r1;
        goto L_0x000a;
    L_0x0073:
        r0 = r7.e;
        r0 = (java.lang.String) r0;
        r2 = r6.m;
        if (r2 == 0) goto L_0x0009;
    L_0x007b:
        r2 = r6.m;
        r2.b(r0);
        r0 = r1;
        goto L_0x000a;
    L_0x0082:
        r0 = r7.e;
        r0 = (java.lang.String) r0;
        r6.setText(r0);
        r2 = r6.m;
        if (r2 == 0) goto L_0x0009;
    L_0x008d:
        r2 = r6.m;
        r2.a(r0);
        r0 = r1;
        goto L_0x000a;
    L_0x0095:
        super.j();
        r1 = new com.ucpro.ui.edittext.b;
        r1.<init>(r6);
        r6.postDelayed(r1, r4);
        goto L_0x000a;
    L_0x00a2:
        r1 = r6.getText();
        android.text.Selection.selectAll(r1);
        r6.m();
        r1 = new com.ucpro.ui.edittext.d;
        r1.<init>(r6);
        r6.postDelayed(r1, r4);
        goto L_0x000a;
    L_0x00b6:
        r0 = getClipBoardCallback();
        if (r0 == 0) goto L_0x0009;
    L_0x00bc:
        getClipBoardCallback();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.ui.edittext.CustomEditText.a(com.ui.edittext.c, java.lang.Object):void");
    }

    public void setSelection(int i) {
        int a = a();
        if (i > a) {
            i = a;
        }
        super.setSelection(i);
    }

    public final void a(int i, int i2) {
        int a = a();
        if (i2 <= a) {
            a = i2;
        }
        if (i > a) {
            i = a;
        }
        super.a(i, a);
    }

    public void setFillWordByPaste(boolean z) {
        this.k = z;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    private c u() {
        c cVar = new c();
        cVar.a = 20095;
        cVar.c = getResources().getString(R.string.edittext_cut);
        return cVar;
    }

    private c v() {
        c cVar = new c();
        cVar.a = 20096;
        cVar.c = getResources().getString(R.string.edittext_copy);
        return cVar;
    }

    private c w() {
        c cVar = new c();
        cVar.a = 20043;
        cVar.c = getResources().getString(R.string.edittext_select);
        return cVar;
    }

    private c x() {
        c cVar = new c();
        cVar.a = 20044;
        cVar.c = getResources().getString(R.string.edittext_selectall);
        return cVar;
    }

    private c b(String str) {
        c cVar = new c();
        cVar.a = 20041;
        cVar.c = getResources().getString(R.string.edittext_paste);
        cVar.e = str;
        return cVar;
    }

    private c c(String str) {
        e eVar;
        try {
            eVar = new e(str.replace(" ", ""));
        } catch (Exception e) {
            eVar = null;
        }
        if (eVar == null || !eVar.a()) {
            c cVar = new c();
            cVar.a = 20084;
            cVar.c = getResources().getString(R.string.edittext_paste_search);
            cVar.e = str;
            return cVar;
        }
        cVar = new c();
        cVar.a = 20042;
        cVar.c = getResources().getString(R.string.edittext_paste_go);
        cVar.e = str.replace(" ", "");
        return cVar;
    }
}
