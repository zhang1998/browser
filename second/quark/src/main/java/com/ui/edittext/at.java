package com.ui.edittext;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/* compiled from: ProGuard */
final class at extends aj implements OnItemClickListener {
    boolean a = false;
    final /* synthetic */ TextView g;
    private ar[] h;
    private int i;
    private boolean j;
    private aq k;
    private final Comparator<SuggestionSpan> l;
    private final HashMap<SuggestionSpan, Integer> m;

    public at(TextView textView) {
        this.g = textView;
        super(textView);
        this.j = textView.aI;
        this.l = new as();
        this.m = new HashMap();
    }

    protected final void a() {
        this.b = new ap(this, this.g.mContext);
        this.b.setInputMethodMode(2);
        this.b.setFocusable(true);
        this.b.setClippingEnabled(false);
    }

    protected final void b() {
        ViewGroup listView = new ListView(this.g.getContext());
        this.k = new aq();
        listView.setAdapter(this.k);
        listView.setOnItemClickListener(this);
        this.c = listView;
        this.h = new ar[7];
        for (int i = 0; i < this.h.length; i++) {
            this.h[i] = new ar();
        }
    }

    public final void d() {
        if (this.g.g instanceof Editable) {
            ar arVar;
            Spannable spannable = (Spannable) this.g.g;
            int selectionStart = this.g.getSelectionStart();
            Spannable spannable2 = (Spannable) this.g.g;
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable2.getSpans(selectionStart, selectionStart, SuggestionSpan.class);
            this.m.clear();
            for (Object obj : suggestionSpanArr) {
                this.m.put(obj, Integer.valueOf(spannable2.getSpanEnd(obj) - spannable2.getSpanStart(obj)));
            }
            Arrays.sort(suggestionSpanArr, this.l);
            int length = suggestionSpanArr.length;
            this.i = 0;
            SuggestionSpan suggestionSpan = null;
            int i = 0;
            int i2 = 0;
            int length2 = this.g.g.length();
            int i3 = 0;
            while (i2 < length) {
                SuggestionSpan suggestionSpan2 = suggestionSpanArr[i2];
                int spanStart = spannable.getSpanStart(suggestionSpan2);
                int spanEnd = spannable.getSpanEnd(suggestionSpan2);
                length2 = Math.min(spanStart, length2);
                i3 = Math.max(spanEnd, i3);
                if ((suggestionSpan2.getFlags() & 2) != 0) {
                    suggestionSpan = suggestionSpan2;
                }
                if (i2 == 0) {
                    i = suggestionSpan2.getUnderlineColor();
                }
                String[] suggestions = suggestionSpan2.getSuggestions();
                int length3 = suggestions.length;
                for (spanStart = 0; spanStart < length3; spanStart++) {
                    ar arVar2 = this.h[this.i];
                    arVar2.c = suggestionSpan2;
                    arVar2.d = spanStart;
                    arVar2.e.replace(0, arVar2.e.length(), suggestions[spanStart]);
                    this.i++;
                    if (this.i == 5) {
                        i2 = length;
                        break;
                    }
                }
                i2++;
            }
            for (selectionStart = 0; selectionStart < this.i; selectionStart++) {
                ar arVar3 = this.h[selectionStart];
                spannable2 = (Spannable) this.g.g;
                int spanStart2 = spannable2.getSpanStart(arVar3.c);
                i2 = spannable2.getSpanEnd(arVar3.c);
                arVar3.a = spanStart2 - length2;
                arVar3.b = arVar3.a + arVar3.e.length();
                arVar3.e.setSpan(arVar3.f, 0, arVar3.e.length(), 33);
                arVar3.e.insert(0, this.g.g.toString().substring(length2, spanStart2));
                arVar3.e.append(this.g.g.toString().substring(i2, i3));
            }
            if (suggestionSpan != null) {
                i2 = spannable.getSpanStart(suggestionSpan);
                selectionStart = spannable.getSpanEnd(suggestionSpan);
                if (i2 >= 0 && selectionStart > i2) {
                    arVar = this.h[this.i];
                    arVar.c = suggestionSpan;
                    arVar.d = -1;
                    arVar.e.replace(0, arVar.e.length(), this.g.getContext().getString(17040363));
                    arVar.e.setSpan(arVar.f, 0, 0, 33);
                    this.i++;
                }
            }
            arVar = this.h[this.i];
            arVar.c = null;
            arVar.d = -2;
            arVar.e.replace(0, arVar.e.length(), this.g.getContext().getString(17040364));
            arVar.e.setSpan(arVar.f, 0, 0, 33);
            this.i++;
            if (this.g.P == null) {
                this.g.P = new SuggestionRangeSpan();
            }
            if (i == 0) {
                this.g.P.setBackgroundColor(this.g.aF);
            } else {
                this.g.P.setBackgroundColor((((int) (((float) Color.alpha(i)) * 0.4f)) << 24) + (16777215 & i));
            }
            spannable.setSpan(this.g.P, length2, i3, 33);
            this.k.notifyDataSetChanged();
            this.j = this.g.aI;
            this.g.setCursorVisible(false);
            this.a = true;
            super.d();
        }
    }

    protected final void e() {
        int i = 0;
        DisplayMetrics displayMetrics = this.g.mContext.getResources().getDisplayMetrics();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, SectionHeader.SHT_LOUSER);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, SectionHeader.SHT_LOUSER);
        View view = null;
        int i2 = 0;
        while (i < this.i) {
            view = this.k.getView(i, view, this.c);
            view.getLayoutParams().width = -2;
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
            i++;
        }
        this.c.measure(MeasureSpec.makeMeasureSpec(i2, UCCore.VERIFY_POLICY_QUICK), makeMeasureSpec2);
        Drawable background = this.b.getBackground();
        if (background != null) {
            if (this.g.b == null) {
                this.g.b = new Rect();
            }
            background.getPadding(this.g.b);
            i2 += this.g.b.left + this.g.b.right;
        }
        this.b.setWidth(i2);
    }

    protected final int c() {
        return this.g.getSelectionStart();
    }

    protected final int a(int i) {
        return this.g.h.getLineBottom(i);
    }

    protected final int b(int i) {
        return Math.min(i, this.g.mContext.getResources().getDisplayMetrics().heightPixels - this.c.getMeasuredHeight());
    }

    public final void f() {
        super.f();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Editable editable = (Editable) this.g.g;
        ar arVar = this.h[i];
        int spanStart;
        int spanEnd;
        if (arVar.d == -2) {
            spanStart = editable.getSpanStart(this.g.P);
            spanEnd = editable.getSpanEnd(this.g.P);
            if (spanStart >= 0 && spanEnd > spanStart) {
                int i2;
                if (spanEnd < editable.length() && Character.isSpaceChar(editable.charAt(spanEnd)) && (spanStart == 0 || Character.isSpaceChar(editable.charAt(spanStart - 1)))) {
                    i2 = spanEnd + 1;
                } else {
                    i2 = spanEnd;
                }
                this.g.b(spanStart, i2);
            }
            super.f();
            return;
        }
        int spanStart2 = editable.getSpanStart(arVar.c);
        int spanEnd2 = editable.getSpanEnd(arVar.c);
        if (spanStart2 < 0 || spanEnd2 <= spanStart2) {
            super.f();
            return;
        }
        String substring = this.g.g.toString().substring(spanStart2, spanEnd2);
        if (arVar.d == -1) {
            Intent intent = new Intent("com.android.settings.USER_DICTIONARY_INSERT");
            intent.putExtra("word", substring);
            intent.putExtra("locale", this.g.getTextServicesLocale().toString());
            intent.setFlags(intent.getFlags() | MediaPlayer.MEDIA_ERROR_UNKNOWN);
            this.g.getContext().startActivity(intent);
            editable.removeSpan(arVar.c);
            TextView.q();
        } else {
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) editable.getSpans(spanStart2, spanEnd2, SuggestionSpan.class);
            int length = suggestionSpanArr.length;
            int[] iArr = new int[length];
            int[] iArr2 = new int[length];
            int[] iArr3 = new int[length];
            for (spanStart = 0; spanStart < length; spanStart++) {
                SuggestionSpan suggestionSpan = suggestionSpanArr[spanStart];
                iArr[spanStart] = editable.getSpanStart(suggestionSpan);
                iArr2[spanStart] = editable.getSpanEnd(suggestionSpan);
                iArr3[spanStart] = editable.getSpanFlags(suggestionSpan);
                int flags = suggestionSpan.getFlags();
                if ((flags & 2) > 0) {
                    suggestionSpan.setFlags((flags & -3) & -2);
                }
            }
            CharSequence charSequence = arVar.e.subSequence(arVar.a, arVar.b).toString();
            this.g.a(spanStart2, spanEnd2, charSequence);
            if (!TextUtils.isEmpty(arVar.c.getNotificationTargetClassName())) {
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null) {
                    peekInstance.notifySuggestionPicked(arVar.c, substring, arVar.d);
                }
            }
            arVar.c.getSuggestions()[arVar.d] = substring;
            int length2 = charSequence.length() - (spanEnd2 - spanStart2);
            spanStart = 0;
            while (spanStart < length) {
                if (iArr[spanStart] <= spanStart2 && iArr2[spanStart] >= spanEnd2) {
                    TextView textView = this.g;
                    ((Editable) textView.g).setSpan(suggestionSpanArr[spanStart], iArr[spanStart], iArr2[spanStart] + length2, iArr3[spanStart]);
                }
                spanStart++;
            }
            spanEnd = spanEnd2 + length2;
            Selection.setSelection((Editable) this.g.g, spanEnd, spanEnd);
        }
        f();
    }
}
