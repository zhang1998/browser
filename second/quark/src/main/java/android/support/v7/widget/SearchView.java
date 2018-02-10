package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.dn;
import android.support.v4.widget.az;
import android.support.v7.c.f;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.c.l;
import android.support.v7.view.c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
public class SearchView extends LinearLayoutCompat implements c {
    static final ch a = new ch();
    private static final boolean c;
    private az A;
    private boolean B;
    private CharSequence C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private CharSequence H;
    private CharSequence I;
    private boolean J;
    private int K;
    private SearchableInfo L;
    private Bundle M;
    private final fb N;
    private Runnable O;
    private final Runnable P;
    private Runnable Q;
    private final WeakHashMap<String, ConstantState> R;
    private final OnClickListener S;
    private final OnEditorActionListener T;
    private final OnItemClickListener U;
    private final OnItemSelectedListener V;
    private TextWatcher W;
    OnKeyListener b;
    private final SearchAutoComplete d;
    private final View e;
    private final View f;
    private final View g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final ImageView k;
    private final View l;
    private final ImageView m;
    private final Drawable n;
    private final int o;
    private final int p;
    private final Intent q;
    private final Intent r;
    private final CharSequence s;
    private df t;
    private cs u;
    private OnFocusChangeListener v;
    private eh w;
    private OnClickListener x;
    private boolean y;
    private boolean z;

    /* compiled from: ProGuard */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new bs();
        boolean a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.a + "}";
        }
    }

    /* compiled from: ProGuard */
    public class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int a;
        private SearchView b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, k.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.a.a(this);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.d();
        }

        public boolean enoughToFilter() {
            return this.a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        this.b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        static /* synthetic */ boolean a(SearchAutoComplete searchAutoComplete) {
            return TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0;
        }
    }

    static /* synthetic */ void a(SearchView searchView, CharSequence charSequence) {
        boolean z = true;
        CharSequence text = searchView.d.getText();
        searchView.I = text;
        boolean z2 = !TextUtils.isEmpty(text);
        searchView.b(z2);
        if (z2) {
            z = false;
        }
        searchView.c(z);
        searchView.g();
        searchView.f();
        if (!(searchView.t == null || TextUtils.equals(charSequence, searchView.H))) {
            charSequence.toString();
        }
        searchView.H = charSequence.toString();
    }

    static /* synthetic */ void l(SearchView searchView) {
        String str = null;
        if (searchView.L != null) {
            SearchableInfo searchableInfo = searchView.L;
            try {
                Intent intent;
                String str2;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    intent = new Intent(searchView.q);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    str2 = "calling_package";
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent.putExtra(str2, str);
                    searchView.getContext().startActivity(intent);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    String string;
                    Intent intent2 = searchView.r;
                    ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                    intent = new Intent("android.intent.action.SEARCH");
                    intent.setComponent(searchActivity2);
                    Parcelable activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, UCCore.VERIFY_POLICY_QUICK);
                    Bundle bundle = new Bundle();
                    if (searchView.M != null) {
                        bundle.putParcelable("app_data", searchView.M);
                    }
                    Intent intent3 = new Intent(intent2);
                    String str3 = "free_form";
                    int i = 1;
                    if (VERSION.SDK_INT >= 8) {
                        Resources resources = searchView.getResources();
                        if (searchableInfo.getVoiceLanguageModeId() != 0) {
                            string = resources.getString(searchableInfo.getVoiceLanguageModeId());
                        } else {
                            string = str3;
                        }
                        if (searchableInfo.getVoicePromptTextId() != 0) {
                            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
                        } else {
                            str2 = null;
                        }
                        if (searchableInfo.getVoiceLanguageId() != 0) {
                            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
                        } else {
                            str3 = null;
                        }
                        if (searchableInfo.getVoiceMaxResults() != 0) {
                            i = searchableInfo.getVoiceMaxResults();
                        }
                    } else {
                        str2 = null;
                        string = str3;
                        str3 = null;
                    }
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                    intent3.putExtra("android.speech.extra.PROMPT", str2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", str3);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                    String str4 = "calling_package";
                    if (searchActivity2 != null) {
                        str = searchActivity2.flattenToShortString();
                    }
                    intent3.putExtra(str4, str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    searchView.getContext().startActivity(intent3);
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        c = z;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = new fy(this);
        this.P = new dw(this);
        this.Q = new dx(this);
        this.R = new WeakHashMap();
        this.S = new cz(this);
        this.b = new fe(this);
        this.T = new fa(this);
        this.U = new ek(this);
        this.V = new fv(this);
        this.W = new fl(this);
        this.N = fb.a();
        dh a = dh.a(context, attributeSet, h.SearchView, i);
        LayoutInflater.from(context).inflate(a.e(h.SearchView_layout, l.abc_search_view), this, true);
        this.d = (SearchAutoComplete) findViewById(j.search_src_text);
        this.d.setSearchView(this);
        this.e = findViewById(j.search_edit_frame);
        this.f = findViewById(j.search_plate);
        this.g = findViewById(j.submit_area);
        this.h = (ImageView) findViewById(j.search_button);
        this.i = (ImageView) findViewById(j.search_go_btn);
        this.j = (ImageView) findViewById(j.search_close_btn);
        this.k = (ImageView) findViewById(j.search_voice_btn);
        this.m = (ImageView) findViewById(j.search_mag_icon);
        this.f.setBackgroundDrawable(a.a(h.SearchView_queryBackground));
        this.g.setBackgroundDrawable(a.a(h.SearchView_submitBackground));
        this.h.setImageDrawable(a.a(h.SearchView_searchIcon));
        this.i.setImageDrawable(a.a(h.SearchView_goIcon));
        this.j.setImageDrawable(a.a(h.SearchView_closeIcon));
        this.k.setImageDrawable(a.a(h.SearchView_voiceIcon));
        this.m.setImageDrawable(a.a(h.SearchView_searchIcon));
        this.n = a.a(h.SearchView_searchHintIcon);
        this.o = a.e(h.SearchView_suggestionRowLayout, l.abc_search_dropdown_item_icons_2line);
        this.p = a.e(h.SearchView_commitIcon, 0);
        this.h.setOnClickListener(this.S);
        this.j.setOnClickListener(this.S);
        this.i.setOnClickListener(this.S);
        this.k.setOnClickListener(this.S);
        this.d.setOnClickListener(this.S);
        this.d.addTextChangedListener(this.W);
        this.d.setOnEditorActionListener(this.T);
        this.d.setOnItemClickListener(this.U);
        this.d.setOnItemSelectedListener(this.V);
        this.d.setOnKeyListener(this.b);
        this.d.setOnFocusChangeListener(new el(this));
        setIconifiedByDefault(a.a(h.SearchView_iconifiedByDefault, true));
        int c = a.c(h.SearchView_android_maxWidth, -1);
        if (c != -1) {
            setMaxWidth(c);
        }
        this.s = a.c(h.SearchView_defaultQueryHint);
        this.C = a.c(h.SearchView_queryHint);
        c = a.a(h.SearchView_android_imeOptions, -1);
        if (c != -1) {
            setImeOptions(c);
        }
        c = a.a(h.SearchView_android_inputType, -1);
        if (c != -1) {
            setInputType(c);
        }
        setFocusable(a.a(h.SearchView_android_focusable, true));
        a.a.recycle();
        this.q = new Intent("android.speech.action.WEB_SEARCH");
        this.q.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
        this.q.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.r = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.r.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
        this.l = findViewById(this.d.getDropDownAnchor());
        if (this.l != null) {
            if (VERSION.SDK_INT >= 11) {
                this.l.addOnLayoutChangeListener(new ey(this));
            } else {
                this.l.getViewTreeObserver().addOnGlobalLayoutListener(new cg(this));
            }
        }
        a(this.y);
        i();
    }

    int getSuggestionRowLayout() {
        return this.o;
    }

    int getSuggestionCommitIconResId() {
        return this.p;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(android.app.SearchableInfo r9) {
        /*
        r8 = this;
        r4 = 0;
        r7 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = 0;
        r2 = 1;
        r8.L = r9;
        r0 = r8.L;
        if (r0 == 0) goto L_0x0079;
    L_0x000b:
        r0 = c;
        if (r0 == 0) goto L_0x0076;
    L_0x000f:
        r0 = r8.d;
        r1 = r8.L;
        r1 = r1.getSuggestThreshold();
        r0.setThreshold(r1);
        r0 = r8.d;
        r1 = r8.L;
        r1 = r1.getImeOptions();
        r0.setImeOptions(r1);
        r0 = r8.L;
        r0 = r0.getInputType();
        r1 = r0 & 15;
        if (r1 != r2) goto L_0x003f;
    L_0x002f:
        r1 = -65537; // 0xfffffffffffeffff float:NaN double:NaN;
        r0 = r0 & r1;
        r1 = r8.L;
        r1 = r1.getSuggestAuthority();
        if (r1 == 0) goto L_0x003f;
    L_0x003b:
        r0 = r0 | r7;
        r1 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r0 = r0 | r1;
    L_0x003f:
        r1 = r8.d;
        r1.setInputType(r0);
        r0 = r8.A;
        if (r0 == 0) goto L_0x004d;
    L_0x0048:
        r0 = r8.A;
        r0.a(r4);
    L_0x004d:
        r0 = r8.L;
        r0 = r0.getSuggestAuthority();
        if (r0 == 0) goto L_0x0076;
    L_0x0055:
        r0 = new android.support.v7.widget.di;
        r1 = r8.getContext();
        r5 = r8.L;
        r6 = r8.R;
        r0.<init>(r1, r8, r5, r6);
        r8.A = r0;
        r0 = r8.d;
        r1 = r8.A;
        r0.setAdapter(r1);
        r0 = r8.A;
        r0 = (android.support.v7.widget.di) r0;
        r1 = r8.D;
        if (r1 == 0) goto L_0x00b9;
    L_0x0073:
        r1 = 2;
    L_0x0074:
        r0.a = r1;
    L_0x0076:
        r8.i();
    L_0x0079:
        r0 = c;
        if (r0 == 0) goto L_0x00ca;
    L_0x007d:
        r0 = r8.L;
        if (r0 == 0) goto L_0x00c8;
    L_0x0081:
        r0 = r8.L;
        r0 = r0.getVoiceSearchEnabled();
        if (r0 == 0) goto L_0x00c8;
    L_0x0089:
        r0 = r8.L;
        r0 = r0.getVoiceSearchLaunchWebSearch();
        if (r0 == 0) goto L_0x00bb;
    L_0x0091:
        r0 = r8.q;
    L_0x0093:
        if (r0 == 0) goto L_0x00c8;
    L_0x0095:
        r1 = r8.getContext();
        r1 = r1.getPackageManager();
        r0 = r1.resolveActivity(r0, r7);
        if (r0 == 0) goto L_0x00c6;
    L_0x00a3:
        r0 = r2;
    L_0x00a4:
        if (r0 == 0) goto L_0x00ca;
    L_0x00a6:
        r8.G = r2;
        r0 = r8.G;
        if (r0 == 0) goto L_0x00b3;
    L_0x00ac:
        r0 = r8.d;
        r1 = "nm";
        r0.setPrivateImeOptions(r1);
    L_0x00b3:
        r0 = r8.z;
        r8.a(r0);
        return;
    L_0x00b9:
        r1 = r2;
        goto L_0x0074;
    L_0x00bb:
        r0 = r8.L;
        r0 = r0.getVoiceSearchLaunchRecognizer();
        if (r0 == 0) goto L_0x00cc;
    L_0x00c3:
        r0 = r8.r;
        goto L_0x0093;
    L_0x00c6:
        r0 = r3;
        goto L_0x00a4;
    L_0x00c8:
        r0 = r3;
        goto L_0x00a4;
    L_0x00ca:
        r2 = r3;
        goto L_0x00a6;
    L_0x00cc:
        r0 = r4;
        goto L_0x0093;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setAppSearchData(Bundle bundle) {
        this.M = bundle;
    }

    public void setImeOptions(int i) {
        this.d.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.d.getImeOptions();
    }

    public void setInputType(int i) {
        this.d.setInputType(i);
    }

    public int getInputType() {
        return this.d.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.E || !isFocusable()) {
            return false;
        }
        if (this.z) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.d.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.E = true;
        setImeVisibility(false);
        super.clearFocus();
        this.d.clearFocus();
        this.E = false;
    }

    public void setOnQueryTextListener(df dfVar) {
        this.t = dfVar;
    }

    public void setOnCloseListener(cs csVar) {
        this.u = csVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.v = onFocusChangeListener;
    }

    public void setOnSuggestionListener(eh ehVar) {
        this.w = ehVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public CharSequence getQuery() {
        return this.d.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.C = charSequence;
        i();
    }

    public CharSequence getQueryHint() {
        if (this.C != null) {
            return this.C;
        }
        if (!c || this.L == null || this.L.getHintId() == 0) {
            return this.s;
        }
        return getContext().getText(this.L.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.y != z) {
            this.y = z;
            a(z);
            i();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            j();
        } else {
            k();
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.B = z;
        a(this.z);
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.D = z;
        if (this.A instanceof di) {
            int i;
            di diVar = (di) this.A;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            diVar.a = i;
        }
    }

    public void setSuggestionsAdapter(az azVar) {
        this.A = azVar;
        this.d.setAdapter(this.A);
    }

    public az getSuggestionsAdapter() {
        return this.A;
    }

    public void setMaxWidth(int i) {
        this.F = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.F;
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(f.abc_search_view_preferred_width);
    }

    private void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.z = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.d.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.h.setVisibility(i2);
        b(z2);
        View view = this.e;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.m.getDrawable() == null || this.y)) {
            i = 0;
        }
        this.m.setVisibility(i);
        g();
        if (z2) {
            z3 = false;
        }
        c(z3);
        f();
    }

    private boolean e() {
        return (this.B || this.G) && !this.z;
    }

    private void b(boolean z) {
        int i = 8;
        if (this.B && e() && hasFocus() && (z || !this.G)) {
            i = 0;
        }
        this.i.setVisibility(i);
    }

    private void f() {
        int i = 8;
        if (e() && (this.i.getVisibility() == 0 || this.k.getVisibility() == 0)) {
            i = 0;
        }
        this.g.setVisibility(i);
    }

    private void g() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.d.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.y || this.J)) {
            i = 0;
        }
        ImageView imageView = this.j;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.j.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void h() {
        post(this.P);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.P);
        post(this.Q);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.O);
            return;
        }
        removeCallbacks(this.O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private boolean a(int i, KeyEvent keyEvent) {
        if (this.L == null || this.A == null || keyEvent.getAction() != 0 || !dn.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return a(this.d.getListSelection());
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.d.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.d.length();
            }
            this.d.setSelection(i2);
            this.d.setListSelection(0);
            this.d.clearListSelection();
            a.a(this.d);
            return true;
        }
    }

    private void i() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.d;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.y && this.n != null) {
            int textSize = (int) (((double) this.d.getTextSize()) * 1.25d);
            this.n.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.n), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    private void c(boolean z) {
        int i;
        if (this.G && !this.z && z) {
            i = 0;
            this.i.setVisibility(8);
        } else {
            i = 8;
        }
        this.k.setVisibility(i);
    }

    private void j() {
        if (!TextUtils.isEmpty(this.d.getText())) {
            this.d.setText("");
            this.d.requestFocus();
            setImeVisibility(true);
        } else if (!this.y) {
        } else {
            if (this.u == null || !this.u.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    private void k() {
        a(false);
        this.d.requestFocus();
        setImeVisibility(true);
        if (this.x != null) {
            this.x.onClick(this);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        h();
    }

    public final void b() {
        CharSequence charSequence = "";
        this.d.setText(charSequence);
        this.d.setSelection(this.d.length());
        this.I = charSequence;
        clearFocus();
        a(true);
        this.d.setImeOptions(this.K);
        this.J = false;
    }

    public final void a() {
        if (!this.J) {
            this.J = true;
            this.K = this.d.getImeOptions();
            this.d.setImeOptions(this.K | 33554432);
            this.d.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            a(savedState.a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean a(int i) {
        if (this.w != null && this.w.b()) {
            return false;
        }
        Cursor cursor = this.A.d;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent a = a(cursor);
            if (a != null) {
                try {
                    getContext().startActivity(a);
                } catch (Throwable e) {
                    Log.e("SearchView", "Failed launch activity: " + a, e);
                }
            }
        }
        setImeVisibility(false);
        this.d.dismissDropDown();
        return true;
    }

    void setQuery(CharSequence charSequence) {
        this.d.setText(charSequence);
        this.d.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(String str) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str, 0, null));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.I);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.M != null) {
            intent.putExtra("app_data", this.M);
        }
        if (c) {
            intent.setComponent(this.L.getSearchActivity());
        }
        return intent;
    }

    private Intent a(Cursor cursor) {
        try {
            String a = di.a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.L.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = di.a(cursor, "suggest_intent_data");
            if (c && a2 == null) {
                a2 = this.L.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = di.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return a(a, a2 == null ? null : Uri.parse(a2), di.a(cursor, "suggest_intent_extra_data"), di.a(cursor, "suggest_intent_query"), 0, null);
        } catch (Throwable e) {
            int position;
            Throwable th = e;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", th);
            return null;
        }
    }

    private void l() {
        ch chVar = a;
        SearchAutoComplete searchAutoComplete = this.d;
        if (chVar.a != null) {
            try {
                chVar.a.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e) {
            }
        }
        chVar = a;
        searchAutoComplete = this.d;
        if (chVar.b != null) {
            try {
                chVar.b.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    protected void onMeasure(int i, int i2) {
        if (this.z) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case SectionHeader.SHT_LOUSER /*-2147483648*/:
                if (this.F <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.F, size);
                    break;
                }
            case 0:
                if (this.F <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.F;
                    break;
                }
            case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                if (this.F > 0) {
                    size = Math.min(this.F, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, UCCore.VERIFY_POLICY_QUICK), i2);
    }

    final void d() {
        a(this.z);
        h();
        if (this.d.hasFocus()) {
            l();
        }
    }

    static /* synthetic */ void a(SearchView searchView) {
        int[] iArr = searchView.d.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = searchView.f.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.g.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    static /* synthetic */ void d(SearchView searchView) {
        if (searchView.l.getWidth() > 1) {
            int dimensionPixelSize;
            int i;
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.f.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = co.a(searchView);
            if (searchView.y) {
                dimensionPixelSize = resources.getDimensionPixelSize(f.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(f.abc_dropdownitem_icon_width);
            } else {
                dimensionPixelSize = 0;
            }
            searchView.d.getDropDownBackground().getPadding(rect);
            if (a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            searchView.d.setDropDownHorizontalOffset(i);
            searchView.d.setDropDownWidth((dimensionPixelSize + ((searchView.l.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    static /* synthetic */ void j(SearchView searchView) {
        CharSequence text = searchView.d.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.t != null) {
                df dfVar = searchView.t;
                text.toString();
                if (dfVar.a()) {
                    return;
                }
            }
            if (searchView.L != null) {
                searchView.a(text.toString());
            }
            searchView.setImeVisibility(false);
            searchView.d.dismissDropDown();
        }
    }

    static /* synthetic */ boolean b(SearchView searchView, int i) {
        if (searchView.w != null && searchView.w.a()) {
            return false;
        }
        CharSequence text = searchView.d.getText();
        Cursor cursor = searchView.A.d;
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence b = searchView.A.b(cursor);
                if (b != null) {
                    searchView.setQuery(b);
                } else {
                    searchView.setQuery(text);
                }
            } else {
                searchView.setQuery(text);
            }
        }
        return true;
    }
}
