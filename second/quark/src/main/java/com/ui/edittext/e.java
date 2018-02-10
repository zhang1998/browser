package com.ui.edittext;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Spanned;
import android.text.method.KeyListener;
import android.text.style.SuggestionSpan;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
public final class e extends BaseInputConnection {
    private final TextView a;

    public e(TextView textView) {
        super(textView, true);
        this.a = textView;
    }

    public final Editable getEditable() {
        TextView textView = this.a;
        if (textView != null) {
            return textView.getEditableText();
        }
        return null;
    }

    public final boolean beginBatchEdit() {
        this.a.c();
        return true;
    }

    public final boolean endBatchEdit() {
        this.a.f();
        return true;
    }

    public final boolean clearMetaKeyStates(int i) {
        Editable editable = getEditable();
        if (editable == null) {
            return false;
        }
        KeyListener keyListener = this.a.getKeyListener();
        if (keyListener != null) {
            try {
                keyListener.clearMetaKeyState(this.a, editable, i);
            } catch (AbstractMethodError e) {
            }
        }
        return true;
    }

    public final boolean commitCompletion(CompletionInfo completionInfo) {
        this.a.c();
        TextView.b();
        this.a.f();
        return true;
    }

    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        this.a.c();
        TextView textView = this.a;
        if (textView.j == null) {
            textView.j = new s(textView);
        } else {
            textView.j.a(false);
        }
        s sVar = textView.j;
        sVar.a = correctionInfo.getOffset();
        sVar.b = sVar.a + correctionInfo.getNewText().length();
        sVar.c = SystemClock.uptimeMillis();
        if (sVar.a < 0 || sVar.b < 0) {
            sVar.a();
        }
        this.a.f();
        return true;
    }

    public final boolean performEditorAction(int i) {
        View view = this.a;
        ab abVar = view.e;
        if (abVar != null) {
            if (abVar.f != null) {
                abVar.f.a(i);
            } else if (i == 5) {
                view = view.focusSearch(2);
                if (!(view == null || view.requestFocus(2))) {
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                }
            } else if (i == 7) {
                view = view.focusSearch(1);
                if (!(view == null || view.requestFocus(1))) {
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                }
            } else if (i == 6) {
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null && peekInstance.isActive(view)) {
                    peekInstance.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        }
        return true;
    }

    public final boolean performContextMenuAction(int i) {
        this.a.c();
        this.a.b(i);
        this.a.f();
        return true;
    }

    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        if (this.a != null) {
            ExtractedText extractedText = new ExtractedText();
            if (this.a.a(extractedTextRequest, -1, -1, -1, extractedText)) {
                if ((i & 1) == 0) {
                    return extractedText;
                }
                this.a.setExtracting(extractedTextRequest);
                return extractedText;
            }
        }
        return null;
    }

    public final boolean performPrivateCommand(String str, Bundle bundle) {
        TextView.h();
        return true;
    }

    public final boolean commitText(CharSequence charSequence, int i) {
        if (this.a == null) {
            return super.commitText(charSequence, i);
        }
        if (charSequence instanceof Spanned) {
            this.mIMM.registerSuggestionSpansForNotification((SuggestionSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), SuggestionSpan.class));
        }
        return super.commitText(charSequence, i);
    }
}
