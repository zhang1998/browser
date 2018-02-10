package com.ucpro.feature.inputenhance;

import android.graphics.Rect;
import android.os.Message;
import android.os.SystemClock;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.quark.browser.R;
import com.uc.webview.browser.BrowserWebView;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.uc.webview.export.extension.UCClient.MoveCursorToTextInputResult;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.widget.EditText;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d.d;
import com.ucweb.common.util.f;
import com.ucweb.common.util.h.a;
import com.ucweb.common.util.h.m;
import com.ui.edittext.u;

/* compiled from: ProGuard */
public final class af extends e implements am, d {
    private g c;
    private String d;
    private boolean e;
    private w f;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private p j;
    private a k = new al(this);

    protected final void a(b bVar) {
        super.a(bVar);
        Window window = this.b.getWindow();
        if (window != null) {
            this.f = new w(this);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
    }

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.ad) {
            if (message.obj != null) {
                this.d = message.obj.toString();
                new m(this).execute(new Object[0]);
            }
        } else if (i == com.ucpro.base.a.e.ac) {
            if (message.arg1 != com.ucpro.base.a.e.ad) {
            }
        } else if (i == com.ucpro.base.a.e.ae) {
            if (this.c == null) {
                this.c = new g(this.b, this);
                o();
            }
            this.e = false;
            if (message.obj != null) {
                MoveCursorToTextInputResult moveCursorToTextInputResult = (MoveCursorToTextInputResult) message.obj;
                if (moveCursorToTextInputResult.mSuccess) {
                    g gVar = this.c;
                    boolean z = moveCursorToTextInputResult.mCanMoveToNext;
                    gVar.e.b.a(moveCursorToTextInputResult.mCanMoveToPrevious, z);
                }
            }
        } else if (i == com.ucpro.base.a.e.ag) {
            w wVar = this.f;
            wVar.a = 0;
            af afVar = wVar.b;
            Runnable agVar = new ag(afVar);
            m.a(3, new h(afVar, agVar), agVar);
        } else if (i == com.ucpro.base.a.e.ai) {
            a(true, (int) (((float) com.ucpro.base.system.b.a.g()) * 0.5f));
        }
    }

    public final void b(int i, Message message) {
        if (i == j.f && this.c != null) {
            g gVar = this.c;
            if (gVar.e != null) {
                gVar.e.a();
            }
        }
    }

    private void a(boolean z) {
        if (!this.e) {
            Object obtain = Message.obtain();
            obtain.what = com.ucpro.base.a.e.af;
            obtain.arg1 = z ? 1 : 0;
            this.e = true;
            g.a().b(com.ucpro.base.a.e.af, obtain);
        }
    }

    private void a(boolean z, int i) {
        boolean z2 = ((float) i) < ((float) com.ucpro.base.system.b.a.g()) * 0.8f;
        if (z && com.ucpro.feature.inputenhance.a.a.a() && z2) {
            if (!d.d() && com.ucpro.model.a.a.a.a("EnableInputEnhance", false)) {
                com.ucpro.base.c.b.g a = s_().a();
                if (a == null || !(a.getTag() instanceof Integer) || ((Integer) a.getTag()).intValue() != 1001) {
                    if (this.c == null) {
                        this.c = new g(this.b, this);
                        o();
                    }
                    this.c.a(true);
                    this.e = false;
                }
            }
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public final void b() {
        m.c(this.k);
        if (com.ucweb.common.util.j.a.b("058B6A44EF6A0F81", true)) {
            this.k.f = Integer.valueOf(2);
            m.a(2, this.k, 1000);
        }
    }

    public final void d() {
        int[] iArr = new int[2];
        this.c.a(iArr);
        Object message = new Message();
        message.what = com.ucpro.base.a.e.ab;
        message.arg1 = com.ucpro.base.a.e.ad;
        message.arg2 = com.ucpro.base.system.b.a.g() - iArr[1];
        g.a().a(com.ucpro.base.a.e.ab, message);
    }

    public final void e() {
        View a = this.c.a();
        if (a != null && (a instanceof CustomEditText)) {
            ((CustomEditText) a).n();
        }
        int[] iArr = new int[2];
        this.c.a(iArr);
        com.ucpro.services.e.e.a.d();
        Object message = new Message();
        message.what = com.ucpro.base.a.e.ab;
        message.arg1 = com.ucpro.base.a.e.ad;
        message.arg2 = com.ucpro.base.system.b.a.g() - iArr[1];
        g.a().a(com.ucpro.base.a.e.ab, message);
    }

    public final void i() {
        a(true);
    }

    public final void j() {
        a(false);
    }

    public final void a(View view) {
        BrowserExtension browserExtension = null;
        try {
            if (view.getParent() != null && (view.getParent() instanceof BrowserWebView)) {
                browserExtension = ((BrowserWebView) view.getParent()).getUCExtension();
            }
            if (browserExtension != null) {
                if (s_().a() instanceof com.ucpro.base.c.b.g) {
                    Object a = s_().a();
                    c.a(a);
                    if (a != null) {
                        a.k();
                    }
                }
            } else if (view instanceof EditText) {
                ((EditText) view).getText().toString();
            }
        } catch (Exception e) {
        }
    }

    public final void a(int i) {
        Object obj;
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        View currentFocus = this.b.getCurrentFocus();
        int length;
        int selectionStart;
        int selectionEnd;
        if (currentFocus instanceof EditText) {
            EditText editText = (EditText) currentFocus;
            if (editText.getText() != null) {
                length = editText.getText().length();
                selectionStart = editText.getSelectionStart();
                selectionEnd = editText.getSelectionEnd();
                if (selectionStart >= 0 && selectionEnd > selectionStart) {
                    editText.getEditableText().replace(selectionStart, selectionEnd, "");
                } else if (obj != null) {
                    if (selectionStart > 0) {
                        editText.setSelection(selectionStart - 1);
                    } else {
                        editText.setSelection(selectionStart);
                    }
                } else if (selectionEnd < length) {
                    editText.setSelection(selectionEnd + 1);
                } else if (selectionEnd == length) {
                    editText.setSelection(selectionEnd);
                }
            }
        } else if (currentFocus instanceof CustomEditText) {
            CustomEditText customEditText = (CustomEditText) currentFocus;
            if (customEditText.getText() != null) {
                length = customEditText.getText().length();
                selectionStart = customEditText.getSelectionStart();
                selectionEnd = customEditText.getSelectionEnd();
                if (selectionStart >= 0 && selectionEnd > selectionStart) {
                    customEditText.getEditableText().replace(selectionStart, selectionEnd, "");
                } else if (obj != null) {
                    if (selectionStart > 0) {
                        customEditText.setSelection(selectionStart - 1);
                    } else {
                        customEditText.setSelection(selectionStart);
                    }
                } else if (selectionEnd < length) {
                    customEditText.setSelection(selectionEnd + 1);
                } else if (selectionEnd == length) {
                    customEditText.setSelection(selectionEnd);
                }
            }
        }
    }

    public final void b(int i) {
        View a = this.c.a();
        if (a instanceof android.widget.EditText) {
            android.widget.EditText editText = (android.widget.EditText) a;
            if (i == -1) {
                this.g = editText.getSelectionStart();
                this.h = editText.getSelectionEnd();
                this.i = -1;
                if (editText.getSelectionStart() != editText.getSelectionEnd()) {
                    editText.setSelection(0);
                }
            } else if (i == 1) {
                if (this.i == -1) {
                    this.i = 0;
                }
                a(editText, 1);
            } else if (i == 0) {
                if (this.i == -1) {
                    this.i = 1;
                }
                a(editText, 0);
            }
        } else if (a instanceof CustomEditText) {
            com.ui.edittext.EditText editText2 = (CustomEditText) a;
            if (i == -1) {
                this.g = editText2.getSelectionStart();
                this.h = editText2.getSelectionEnd();
                this.i = -1;
                if (editText2.getSelectionStart() != editText2.getSelectionEnd()) {
                    editText2.setSelection(0);
                }
            } else if (i == 1) {
                if (this.i == -1) {
                    this.i = 0;
                }
                a(editText2, 1);
            } else if (i == 0) {
                if (this.i == -1) {
                    this.i = 1;
                }
                a(editText2, 0);
            }
        }
    }

    public final void k() {
        View a = this.c.a();
        if (a instanceof android.widget.EditText) {
            android.widget.EditText editText = (android.widget.EditText) a;
            int selectionStart = editText.getSelectionStart();
            editText.setCursorVisible(false);
            editText.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, (float) (editText.getHeight() / 2), 0));
            editText.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, (float) (editText.getHeight() / 2), 0));
            editText.setCursorVisible(true);
            editText.setSelection(selectionStart);
        } else if (a instanceof CustomEditText) {
            CustomEditText customEditText = (CustomEditText) a;
            int selectionStart2 = customEditText.getSelectionStart();
            customEditText.k();
            customEditText.n();
            customEditText.setSelection(selectionStart2);
        }
    }

    public final void l() {
        View a = this.c.a();
        if (a instanceof android.widget.EditText) {
            android.widget.EditText editText = (android.widget.EditText) a;
            editText.setSelection(this.g, this.h);
            if (this.i == 0) {
                editText.getViewTreeObserver().addOnPreDrawListener(new aq(this, editText, this.g));
            }
        } else if (a instanceof CustomEditText) {
            CustomEditText customEditText = (CustomEditText) a;
            customEditText.a(this.g, this.h);
            Layout layout = customEditText.getLayout();
            if (layout != null) {
                int i = 0;
                if (this.i == 0) {
                    i = this.g;
                } else if (this.i == 1) {
                    i = this.h;
                }
                layout.getPrimaryHorizontal(i);
                customEditText.getScrollX();
                customEditText.getHeight();
                customEditText.a(u.SELECTION_HANDLE_TAP);
                if (this.i == 0) {
                    customEditText.getViewTreeObserver().addOnPreDrawListener(new f(this, customEditText, this.g));
                }
            } else {
                return;
            }
        }
        this.g = -1;
        this.h = -1;
        this.i = -1;
    }

    public final void c(int i) {
        if (this.j != null) {
            this.j.a(i);
        }
    }

    private void a(android.widget.EditText editText, int i) {
        if (this.i == 0) {
            if (i == 1) {
                if (this.g > 0) {
                    this.g--;
                    if (this.h >= editText.getText().length()) {
                        this.h = editText.getText().length();
                    }
                    editText.setSelection(this.g, this.h);
                    editText.getViewTreeObserver().addOnPreDrawListener(new aa(this, editText));
                }
            } else if (i != 0) {
            } else {
                if (this.g < this.h) {
                    this.g++;
                    editText.setSelection(this.g, this.h);
                    editText.getViewTreeObserver().addOnPreDrawListener(new e(this, editText));
                } else if (this.g >= this.h) {
                    this.i = 1;
                    this.h++;
                    if (this.h >= editText.getText().length()) {
                        this.h = editText.getText().length();
                    }
                    editText.setSelection(this.g, this.h);
                }
            }
        } else if (this.i != 1) {
        } else {
            if (i == 1) {
                if (this.h > this.g) {
                    this.h--;
                    editText.setSelection(this.g, this.h);
                } else if (this.g >= this.h) {
                    this.i = 0;
                    this.g--;
                    if (this.g <= 0) {
                        this.g = 0;
                    }
                    editText.setSelection(this.g, this.h);
                }
            } else if (i == 0 && this.h < editText.getText().toString().length()) {
                this.h++;
                editText.setSelection(this.g, this.h);
            }
        }
    }

    private void a(com.ui.edittext.EditText editText, int i) {
        if (this.i == 0) {
            if (i == 1) {
                if (this.g > 0) {
                    this.g--;
                    editText.a(this.g, this.h);
                    editText.getViewTreeObserver().addOnPreDrawListener(new ah(this, editText));
                }
            } else if (i != 0) {
            } else {
                if (this.g < this.h) {
                    this.g++;
                    editText.a(this.g, this.h);
                    editText.getViewTreeObserver().addOnPreDrawListener(new z(this, editText));
                } else if (this.g >= this.h) {
                    this.i = 1;
                    this.h++;
                    if (this.h >= editText.getText().length()) {
                        this.h = editText.getText().length();
                    }
                    editText.a(this.g, this.h);
                }
            }
        } else if (this.i == 1) {
            if (i == 1) {
                if (this.h > this.g) {
                    this.h--;
                } else if (this.g >= this.h) {
                    this.i = 0;
                    this.g--;
                    if (this.g <= 0) {
                        this.g = 0;
                    }
                    editText.a(this.g, this.h);
                    return;
                } else {
                    return;
                }
            } else if (i == 0 && this.h < editText.getText().toString().length()) {
                this.h++;
                if (this.g <= 0) {
                    this.g = 0;
                }
            } else {
                return;
            }
            editText.a(this.g, this.h);
        }
    }

    public final void a(String str) {
        try {
            Object a = this.c.a();
            String obj;
            int selectionStart;
            int selectionEnd;
            if (a instanceof EditText) {
                EditText editText = (EditText) a;
                obj = editText.getText().toString();
                selectionStart = editText.getSelectionStart();
                selectionEnd = editText.getSelectionEnd();
                if (selectionStart > 0 && selectionEnd > selectionStart) {
                    obj = obj.substring(0, selectionStart);
                }
                if (!TextUtils.isEmpty(obj) && obj.endsWith(".") && str != null && str.startsWith(".") && editText.getSelectionEnd() == obj.length()) {
                    str = str.substring(1);
                }
                editText.getEditableText().replace(selectionStart, selectionEnd, str);
                editText.setSelection(editText.getSelectionEnd(), editText.getSelectionEnd());
            } else if (a instanceof android.widget.EditText) {
                android.widget.EditText editText2 = (android.widget.EditText) a;
                obj = editText2.getText().toString();
                selectionStart = editText2.getSelectionStart();
                selectionEnd = editText2.getSelectionEnd();
                if (selectionStart > 0 && selectionEnd > selectionStart) {
                    obj = obj.substring(0, selectionStart);
                }
                if (!TextUtils.isEmpty(obj) && obj.endsWith(".") && str != null && str.startsWith(".") && editText2.getSelectionEnd() == obj.length()) {
                    str = str.substring(1);
                }
                editText2.getEditableText().replace(selectionStart, selectionEnd, str);
                editText2.setSelection(editText2.getSelectionEnd(), editText2.getSelectionEnd());
            } else if (a instanceof CustomEditText) {
                CustomEditText customEditText = (CustomEditText) a;
                customEditText.n();
                obj = customEditText.getText().toString();
                selectionStart = customEditText.getSelectionStart();
                selectionEnd = customEditText.getSelectionEnd();
                if (selectionStart > 0 && selectionEnd > selectionStart) {
                    obj = obj.substring(0, selectionStart);
                }
                if (!TextUtils.isEmpty(obj) && obj.endsWith(".") && str != null && str.startsWith(".") && customEditText.getSelectionEnd() == obj.length()) {
                    str = str.substring(1);
                }
                customEditText.getEditableText().replace(selectionStart, selectionEnd, str);
                customEditText.a(customEditText.getSelectionEnd(), customEditText.getSelectionEnd());
            } else {
                BrowserExtension browserExtension;
                c.a(a);
                if (a == null || a.getParent() == null || !(a.getParent() instanceof BrowserWebView)) {
                    browserExtension = null;
                } else {
                    browserExtension = ((BrowserWebView) a.getParent()).getUCExtension();
                }
                if (browserExtension != null) {
                    browserExtension.paste(str);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void d(int i) {
        try {
            Object a = this.c.a();
            c.a(a);
            BrowserExtension browserExtension = null;
            if (!(a == null || a.getParent() == null || !(a.getParent() instanceof BrowserWebView))) {
                browserExtension = ((BrowserWebView) a.getParent()).getUCExtension();
            }
            if (browserExtension != null) {
                browserExtension.setInputEnhanceControllerHeight(i);
            }
        } catch (Exception e) {
        }
    }

    private void o() {
        this.c.setOnDismissListener(new ad(this));
    }

    public final int a() {
        Rect a = com.ucpro.feature.inputenhance.a.a.a(this.b);
        int height = a.height();
        g gVar = this.c;
        if (gVar.b == -1) {
            gVar.b = com.ucpro.ui.c.a.c((int) R.dimen.input_enhance_layout_height);
        }
        height -= gVar.b;
        if (a.top <= 0) {
            return height - f.b(this.b);
        }
        return height;
    }

    public final void m() {
        boolean b = com.ucweb.common.util.j.a.b("2d7f5d3b20c720ff15d699ce52c69089", true);
        boolean b2 = com.ucweb.common.util.j.a.b("058B6A44EF6A0F81", true);
        if (!com.ucpro.feature.inputenhance.a.a.a()) {
            return;
        }
        if (b || b2) {
            if (this.j == null) {
                this.j = new p(this.b, b, b2, this);
                this.j.b();
                if (b) {
                    this.k.f = Integer.valueOf(0);
                    m.a(2, this.k, 5000);
                    com.ucweb.common.util.j.a.a("2d7f5d3b20c720ff15d699ce52c69089", false);
                } else if (b2) {
                    this.k.f = Integer.valueOf(1);
                    m.a(2, this.k, 5000);
                    com.ucweb.common.util.j.a.a("058B6A44EF6A0F81", false);
                }
            } else if (b) {
                this.j.b();
                com.ucweb.common.util.j.a.a("2d7f5d3b20c720ff15d699ce52c69089", false);
            } else if (b2) {
                this.j.a();
                com.ucweb.common.util.j.a.a("058B6A44EF6A0F81", false);
            }
            this.c.c = false;
        }
    }
}
