package com.taobao.weex.ui.component;

import android.app.Activity;
import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.s;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ao;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.a.a;
import com.taobao.weex.ui.component.a.b;
import com.taobao.weex.ui.component.a.c;
import com.taobao.weex.ui.component.a.d;
import com.taobao.weex.ui.component.a.e;
import com.taobao.weex.ui.view.k;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.browser.interfaces.IWebResources;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class l extends ab<k> {
    private final InputMethodManager a = ((InputMethodManager) getContext().getSystemService("input_method"));
    private String b = "";
    private boolean c;
    private String d = "text";
    private String e = null;
    private String f = null;
    private String g = "";
    private int h = 6;
    private String i = null;
    private List<OnEditorActionListener> j;
    private boolean k = false;
    private d l;
    private boolean m = false;

    protected /* synthetic */ void onHostViewInitialized(View view) {
        k kVar = (k) view;
        super.onHostViewInitialized(kVar);
        addFocusChangeListener(new a(this));
        if (kVar != null) {
            Context context = kVar.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                c cVar = new c(this);
                if (activity == null) {
                    WXLogUtils.e("Activity or listener is null!");
                    return;
                }
                if (activity.getWindow() != null) {
                    LayoutParams attributes = activity.getWindow().getAttributes();
                    if (attributes != null) {
                        int i = attributes.softInputMode;
                        if (i == 48 || i == 32) {
                            WXLogUtils.e("SoftKeyboard detector can't work with softInputMode is SOFT_INPUT_ADJUST_NOTHING or SOFT_INPUT_ADJUST_PAN");
                            return;
                        }
                    }
                }
                View a = e.a(activity);
                if (a == null) {
                    WXLogUtils.e("Activity root is null!");
                    return;
                }
                OnGlobalLayoutListener aVar = new a(a, cVar);
                a.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                b bVar = new b(activity, aVar);
            }
        }
    }

    public l(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected boolean isConsumeTouch() {
        return !isDisabled();
    }

    protected int a() {
        return 16;
    }

    protected void a(k kVar) {
        boolean z;
        int b = b((String) getDomObject().g().get("textAlign"));
        if (b <= 0) {
            b = 8388611;
        }
        kVar.setGravity(b | a());
        b = af.a("#999999");
        if (b != SectionHeader.SHT_LOUSER) {
            kVar.setHintTextColor(b);
        }
        kVar.setTextSize(0, (float) ao.a(getDomObject().g(), getInstance().o));
        CharSequence a = getDomObject().i().a("value");
        kVar.setText(a);
        if (this.b.equals(a)) {
            z = false;
        } else {
            z = true;
        }
        this.m = z;
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if (getHostView() != null && !TextUtils.isEmpty(str)) {
            TextView textView = (TextView) getHostView();
            if (str.equals("change")) {
                addFocusChangeListener(new e(this, textView));
                a(new f(this, textView));
            } else if (str.equals("input")) {
                textView.addTextChangedListener(new g(this));
            }
            if ("return".equals(str)) {
                a(new h(this));
            }
            if ("keyboard".equals(str)) {
                this.k = true;
            }
        }
    }

    private void a(String str, String str2) {
        if (str != null) {
            Map hashMap = new HashMap(2);
            hashMap.put("value", str2);
            hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
            Map hashMap2 = new HashMap();
            Map hashMap3 = new HashMap();
            hashMap3.put("value", str2);
            hashMap2.put("attrs", hashMap3);
            ad.a().a(getInstanceId(), getDomObject().b_(), str, hashMap, hashMap2);
        }
    }

    public final void a(String str) {
        a(getDomObject().c_().contains("change") ? "change" : null, str);
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1576785488:
                if (str.equals("placeholderColor")) {
                    z = true;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    z = true;
                    break;
                }
                break;
            case -791400086:
                if (str.equals("maxLength")) {
                    z = true;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    z = true;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    z = true;
                    break;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
                    z = true;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    z = true;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    z = true;
                    break;
                }
                break;
            case 124732746:
                if (str.equals("maxlength")) {
                    z = true;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    z = true;
                    break;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    z = false;
                    break;
                }
                break;
            case 914346044:
                if (str.equals("singleline")) {
                    z = true;
                    break;
                }
                break;
            case 947486441:
                if (str.equals("returnKeyType")) {
                    z = true;
                    break;
                }
                break;
            case 1667607689:
                if (str.equals("autofocus")) {
                    z = true;
                    break;
                }
                break;
        }
        String a;
        Boolean a2;
        Integer a3;
        switch (z) {
            case false:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setPlaceholder(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setPlaceholderColor(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setType(a);
                return true;
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setAutofocus(a2.booleanValue());
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setColor(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setFontSize(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setTextAlign(a);
                return true;
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setSingleLine(a2.booleanValue());
                return true;
            case true:
                a3 = ah.a(obj, null);
                if (a3 == null) {
                    return true;
                }
                setLines(a3.intValue());
                return true;
            case true:
                a3 = ah.a(obj, null);
                if (a3 == null) {
                    return true;
                }
                setMaxLength(a3.intValue());
                return true;
            case true:
                a3 = ah.a(obj, null);
                if (a3 == null) {
                    return true;
                }
                setMaxLength(a3.intValue());
                return true;
            case true:
                setMax(String.valueOf(obj));
                return true;
            case true:
                setMin(String.valueOf(obj));
                return true;
            case true:
                setReturnKeyType(String.valueOf(obj));
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "returnKeyType")
    public void setReturnKeyType(String str) {
        if (getHostView() != null) {
            this.i = str;
            int i = -1;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals(IWebResources.TEXT_SEARCH)) {
                        i = 3;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        i = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        i = 4;
                        break;
                    }
                    break;
                case 1544803905:
                    if (str.equals("default")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    this.h = 0;
                    break;
                case 1:
                    this.h = 2;
                    break;
                case 2:
                    this.h = 5;
                    break;
                case 3:
                    this.h = 3;
                    break;
                case 4:
                    this.h = 4;
                    break;
                case 5:
                    this.h = 6;
                    break;
            }
            blur();
            ((k) getHostView()).setImeOptions(this.h);
        }
    }

    @WXComponentProp(name = "placeholder")
    public void setPlaceholder(String str) {
        if (str != null && getHostView() != null) {
            ((k) getHostView()).setHint(str);
        }
    }

    @WXComponentProp(name = "placeholderColor")
    public void setPlaceholderColor(String str) {
        if (getHostView() != null && !TextUtils.isEmpty(str)) {
            int a = af.a(str);
            if (a != SectionHeader.SHT_LOUSER) {
                ((k) getHostView()).setHintTextColor(a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.taobao.weex.ui.component.WXComponentProp(name = "type")
    public void setType(java.lang.String r9) {
        /*
        r8 = this;
        r1 = 3;
        r4 = 2;
        r5 = -1;
        r2 = 1;
        r3 = 0;
        if (r9 == 0) goto L_0x000d;
    L_0x0007:
        r0 = r8.getHostView();
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r8.d = r9;
        r0 = r8.getHostView();
        r0 = (android.widget.EditText) r0;
        r6 = r8.d;
        r7 = r6.hashCode();
        switch(r7) {
            case -1034364087: goto L_0x008e;
            case 114715: goto L_0x0070;
            case 116079: goto L_0x0084;
            case 3076014: goto L_0x0048;
            case 3556653: goto L_0x003e;
            case 3560141: goto L_0x007a;
            case 96619420: goto L_0x005c;
            case 1216985755: goto L_0x0066;
            case 1793702779: goto L_0x0052;
            default: goto L_0x001f;
        };
    L_0x001f:
        r6 = r5;
    L_0x0020:
        switch(r6) {
            case 0: goto L_0x0099;
            case 1: goto L_0x009b;
            case 2: goto L_0x00a7;
            case 3: goto L_0x00aa;
            case 4: goto L_0x00ae;
            case 5: goto L_0x0024;
            case 6: goto L_0x00c0;
            case 7: goto L_0x00cc;
            case 8: goto L_0x00d0;
            default: goto L_0x0023;
        };
    L_0x0023:
        r1 = r2;
    L_0x0024:
        r0.setRawInputType(r1);
        r0 = r8.d;
        r1 = r0.hashCode();
        switch(r1) {
            case 3076014: goto L_0x00d3;
            case 3560141: goto L_0x00dd;
            default: goto L_0x0030;
        };
    L_0x0030:
        r3 = r5;
    L_0x0031:
        switch(r3) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0035;
            default: goto L_0x0034;
        };
    L_0x0034:
        goto L_0x000d;
    L_0x0035:
        r0 = new com.taobao.weex.ui.component.d;
        r0.<init>(r8);
        r8.addClickListener(r0);
        goto L_0x000d;
    L_0x003e:
        r7 = "text";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0046:
        r6 = r3;
        goto L_0x0020;
    L_0x0048:
        r7 = "date";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0050:
        r6 = r2;
        goto L_0x0020;
    L_0x0052:
        r7 = "datetime";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x005a:
        r6 = r4;
        goto L_0x0020;
    L_0x005c:
        r7 = "email";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0064:
        r6 = r1;
        goto L_0x0020;
    L_0x0066:
        r7 = "password";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x006e:
        r6 = 4;
        goto L_0x0020;
    L_0x0070:
        r7 = "tel";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0078:
        r6 = 5;
        goto L_0x0020;
    L_0x007a:
        r7 = "time";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0082:
        r6 = 6;
        goto L_0x0020;
    L_0x0084:
        r7 = "url";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x008c:
        r6 = 7;
        goto L_0x0020;
    L_0x008e:
        r7 = "number";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x001f;
    L_0x0096:
        r6 = 8;
        goto L_0x0020;
    L_0x0099:
        r1 = r2;
        goto L_0x0024;
    L_0x009b:
        r1 = r8.getHostView();
        r1 = (com.taobao.weex.ui.view.k) r1;
        r1.setFocusable(r3);
        r1 = r3;
        goto L_0x0024;
    L_0x00a7:
        r1 = 4;
        goto L_0x0024;
    L_0x00aa:
        r1 = 33;
        goto L_0x0024;
    L_0x00ae:
        r4 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        r1 = r8.getHostView();
        r1 = (com.taobao.weex.ui.view.k) r1;
        r6 = android.text.method.PasswordTransformationMethod.getInstance();
        r1.setTransformationMethod(r6);
        r1 = r4;
        goto L_0x0024;
    L_0x00c0:
        r1 = r8.getHostView();
        r1 = (com.taobao.weex.ui.view.k) r1;
        r1.setFocusable(r3);
        r1 = r3;
        goto L_0x0024;
    L_0x00cc:
        r1 = 17;
        goto L_0x0024;
    L_0x00d0:
        r1 = r4;
        goto L_0x0024;
    L_0x00d3:
        r1 = "date";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0030;
    L_0x00db:
        goto L_0x0031;
    L_0x00dd:
        r1 = "time";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0030;
    L_0x00e5:
        r3 = r2;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.l.setType(java.lang.String):void");
    }

    @WXComponentProp(name = "autofocus")
    public void setAutofocus(boolean z) {
        if (getHostView() != null) {
            this.c = z;
            EditText editText = (EditText) getHostView();
            if (this.c) {
                editText.setFocusable(true);
                editText.requestFocus();
                editText.setFocusableInTouchMode(true);
                b();
                return;
            }
            c();
        }
    }

    @WXComponentProp(name = "value")
    public void setValue(String str) {
        boolean z = false;
        k kVar = (k) getHostView();
        if (kVar != null) {
            kVar.setText(str);
            kVar.setSelection(str == null ? 0 : str.length());
            if (!this.b.equals(str)) {
                z = true;
            }
            this.m = z;
        }
    }

    @WXComponentProp(name = "color")
    public void setColor(String str) {
        if (getHostView() != null && !TextUtils.isEmpty(str)) {
            int a = af.a(str);
            if (a != SectionHeader.SHT_LOUSER) {
                ((k) getHostView()).setTextColor(a);
            }
        }
    }

    @WXComponentProp(name = "fontSize")
    public void setFontSize(String str) {
        if (getHostView() != null && str != null) {
            ((k) getHostView()).setTextSize(0, (float) ao.a(getDomObject().g(), getInstance().o));
        }
    }

    @WXComponentProp(name = "textAlign")
    public void setTextAlign(String str) {
        int b = b(str);
        if (b > 0) {
            ((k) getHostView()).setGravity(b | a());
        }
    }

    @WXComponentProp(name = "singleline")
    public void setSingleLine(boolean z) {
        if (getHostView() != null) {
            ((k) getHostView()).setSingleLine(z);
        }
    }

    @WXComponentProp(name = "lines")
    public void setLines(int i) {
        if (getHostView() != null) {
            ((k) getHostView()).setLines(i);
        }
    }

    @WXComponentProp(name = "maxLength")
    public void setMaxLength(int i) {
        if (getHostView() != null) {
            ((k) getHostView()).setFilters(new InputFilter[]{new LengthFilter(i)});
        }
    }

    @WXComponentProp(name = "maxlength")
    @Deprecated
    public void setMaxlength(int i) {
        setMaxLength(i);
    }

    @WXComponentProp(name = "max")
    public void setMax(String str) {
        this.e = str;
    }

    @WXComponentProp(name = "min")
    public void setMin(String str) {
        this.f = str;
    }

    private boolean b() {
        if (getHostView() == null) {
            return false;
        }
        ((k) getHostView()).postDelayed(new i(this), 16);
        return true;
    }

    private void c() {
        if (getHostView() != null) {
            ((k) getHostView()).postDelayed(new j(this), 16);
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str) || str.equals(Style.LEFT)) {
            return 8388611;
        }
        if (str.equals(Style.CENTER)) {
            return 17;
        }
        if (str.equals(Style.RIGHT)) {
            return 8388613;
        }
        return 8388611;
    }

    @JSMethod
    public void blur() {
        k kVar = (k) getHostView();
        if (kVar != null && kVar.hasFocus()) {
            if (getParent() != null) {
                getParent().i();
            }
            kVar.clearFocus();
            c();
        }
    }

    @JSMethod
    public void focus() {
        k kVar = (k) getHostView();
        if (kVar != null && !kVar.hasFocus()) {
            if (getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) getParent().getHostView();
                if (viewGroup != null) {
                    viewGroup.setFocusable(false);
                    viewGroup.setFocusableInTouchMode(false);
                    viewGroup.clearFocus();
                }
            }
            kVar.requestFocus();
            kVar.setFocusable(true);
            kVar.setFocusableInTouchMode(true);
            b();
        }
    }

    protected Object convertEmptyProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 94842723:
                if (str.equals("color")) {
                    obj2 = 1;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                return Integer.valueOf(32);
            case 1:
                return "black";
            default:
                return super.convertEmptyProperty(str, obj);
        }
    }

    @JSMethod
    public void setSelectionRange(int i, int i2) {
        EditText editText = (EditText) getHostView();
        if (editText != null) {
            int length = ((k) getHostView()).length();
            if (i <= length && i2 <= length) {
                focus();
                editText.setSelection(i, i2);
            }
        }
    }

    @JSMethod
    public void getSelectionRange(String str) {
        Object hashMap = new HashMap(2);
        EditText editText = (EditText) getHostView();
        if (editText != null) {
            int i;
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (editText.hasFocus()) {
                i = selectionEnd;
                selectionEnd = selectionStart;
            } else {
                i = 0;
                selectionEnd = 0;
            }
            hashMap.put("selectionStart", Integer.valueOf(selectionEnd));
            hashMap.put("selectionEnd", Integer.valueOf(i));
        }
        s.a().a(getInstanceId(), str, hashMap, false);
    }

    private void a(OnEditorActionListener onEditorActionListener) {
        TextView textView = (TextView) getHostView();
        if (textView != null) {
            if (this.j == null) {
                this.j = new ArrayList();
                textView.setOnEditorActionListener(new b(this));
            }
            this.j.add(onEditorActionListener);
        }
    }

    public void destroy() {
        super.destroy();
        if (this.l != null) {
            try {
                this.l.a();
                this.l = null;
            } catch (Throwable th) {
                WXLogUtils.w("Unregister throw ", th);
            }
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        k kVar = new k(context);
        a(kVar);
        return kVar;
    }

    static /* synthetic */ void a(l lVar) {
        View hostView = lVar.getHostView();
        if (hostView != null) {
            Context context = lVar.getContext();
            if (context != null && (context instanceof Activity)) {
                hostView.postDelayed(new k(lVar, context), 16);
            }
        }
    }
}
