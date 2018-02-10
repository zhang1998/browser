package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.framework.resources.q;
import com.uc.framework.resources.r;
import com.uc.framework.resources.z;
import com.ucpro.base.a.j;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.e;
import com.ucpro.ui.contextmenu.f;
import com.ui.edittext.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class EditText extends android.widget.EditText implements b {
    private static Typeface d;
    private static f j;
    int a = 0;
    boolean b = false;
    boolean c = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private e i;
    private aa k = null;
    private b l;
    private boolean m = false;
    private String n = "theme_main_color_avoid_all_black";
    private String o = "theme_main_color_avoid_all_black";
    private OnLongClickListener p = new ag(this);

    public static void setApplicationTypeface(Typeface typeface) {
        d = typeface;
    }

    public EditText(Context context) {
        super(context);
        a();
    }

    public EditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        super.setOnLongClickListener(this.p);
        this.h = false;
        com.uc.framework.resources.f fVar = r.a().a;
        setTextColor(com.uc.framework.resources.f.c("edittext_text_color"));
        z zVar = new z();
        zVar.a = true;
        zVar.b = true;
        zVar.c = false;
        Drawable a = fVar.a("edittext_bg.xml", zVar);
        if (a instanceof q) {
            ((q) a).b = false;
        }
        setBackgroundDrawable(a);
        f();
        setFilters(new InputFilter[]{new LengthFilter(1000)});
        c();
        b();
    }

    private void b() {
        if (!this.f && this.e) {
            com.ucpro.base.a.f.a();
            int i = j.j;
            this.f = true;
        }
    }

    private void c() {
        if (this.e) {
            setTypeface(d);
        } else {
            setTypeface(null);
        }
    }

    public void setEnableApplicationTypeface(boolean z) {
        this.e = z;
        if (this.e) {
            b();
        } else if (this.f) {
            com.ucpro.base.a.f.a();
            int i = j.j;
            this.f = false;
        }
        c();
    }

    protected void onCreateContextMenu(ContextMenu contextMenu) {
        if (this.h) {
            super.onCreateContextMenu(contextMenu);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        throw new RuntimeException("uc's edittext forbid using");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getContextMenuManager() != null) {
            getContextMenuManager().a((int) motionEvent.getRawX(), ((int) motionEvent.getRawY()) - getHeight());
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public void setContextMenuListener(b bVar) {
        this.l = bVar;
    }

    public void setShowCopyAllContextMenu(boolean z) {
        this.b = z;
    }

    private void f() {
        super.setHighlightColor(a.c(this.o));
        Drawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setIntrinsicWidth((int) com.ucweb.common.util.a.a.a(getContext(), 2.0f));
        shapeDrawable.getPaint().setColor(a.c(this.n));
        com.ucweb.common.util.a.a.a((TextView) this, shapeDrawable);
    }

    public e getContextMenuManager() {
        if (this.i != null) {
            return this.i;
        }
        return j;
    }

    public void setContextManager(e eVar) {
        this.i = eVar;
    }

    public void setFocusableOnTouchDown(boolean z) {
        this.g = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.g && motionEvent.getAction() == 0 && !isFocusable()) {
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void d() {
        if (this.l != null) {
            this.l.d();
        }
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
        int i = 0;
        CharSequence text;
        boolean a;
        switch (cVar.a) {
            case 20041:
                CharSequence b = com.ucpro.services.e.e.a.b();
                if (b != null && b.length() > 0) {
                    int max;
                    text = getText();
                    int length = text.length();
                    if (isFocused()) {
                        length = getSelectionStart();
                        int selectionEnd = getSelectionEnd();
                        i = Math.max(0, Math.min(length, selectionEnd));
                        max = Math.max(0, Math.max(length, selectionEnd));
                    } else {
                        max = length;
                    }
                    Selection.setSelection((Spannable) text, max);
                    ((Editable) text).replace(i, max, b);
                    this.m = true;
                    break;
                }
            case 20042:
            case 20084:
                super.setText(com.ucpro.services.e.e.a.b());
                if (this.k != null) {
                    getText().toString();
                    break;
                }
                break;
            case 20043:
                a = a("startTextSelectionMode");
                if (!a) {
                    a = a("startSelectionActionMode");
                }
                if (!a) {
                    b("startSelectionActionMode");
                }
                g();
                break;
            case 20044:
                text = getText();
                Selection.setSelection((Spannable) text, 0, text.length());
                a = a("startTextSelectionMode");
                if (!a) {
                    a = a("startSelectionActionMode");
                }
                if (!a) {
                    b("startSelectionActionMode");
                }
                g();
                break;
            case 20045:
                if (getContextMenuManager() != null) {
                    break;
                }
                break;
            case 20046:
                new com.ucweb.common.util.e(getClass().getName() + 327, Looper.getMainLooper()).postDelayed(new m(this), 80);
                break;
            case 20069:
                String obj2 = getText().toString();
                if (obj2 != null) {
                    com.ucpro.services.e.e.a.a(obj2);
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.free_copy_tip), 0);
                    break;
                }
                break;
        }
        if (this.l != null) {
            this.l.a(cVar, obj);
        }
    }

    private void g() {
        postDelayed(new ak(this), 80);
    }

    public void setSelection(int i) {
        int length = length();
        if (i > length) {
            i = length;
        }
        super.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        int length = length();
        if (i2 <= length) {
            length = i2;
        }
        if (i > length) {
            i = length;
        }
        super.setSelection(i, length);
    }

    private boolean a(String str) {
        try {
            Method declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean b(String str) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setHideContextMenuItemClipBoard(boolean z) {
        this.c = z;
    }

    public void setFillWordByPaste(boolean z) {
        this.m = z;
    }

    public void setCursorColorName(String str) {
        this.n = str;
        f();
    }

    public void setHighlightColorName(String str) {
        this.o = str;
        f();
    }

    public void setHighlightColor(int i) {
        super.setHighlightColor(i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }
}
