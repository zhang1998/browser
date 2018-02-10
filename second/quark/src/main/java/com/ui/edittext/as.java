package com.ui.edittext;

import android.text.style.SuggestionSpan;
import java.util.Comparator;

/* compiled from: ProGuard */
final class as implements Comparator<SuggestionSpan> {
    final /* synthetic */ at a;

    private as(at atVar) {
        this.a = atVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Object obj3 = null;
        SuggestionSpan suggestionSpan = (SuggestionSpan) obj;
        SuggestionSpan suggestionSpan2 = (SuggestionSpan) obj2;
        int flags = suggestionSpan.getFlags();
        int flags2 = suggestionSpan2.getFlags();
        if (flags != flags2) {
            Object obj4;
            Object obj5;
            Object obj6 = (flags & 1) != 0 ? 1 : null;
            if ((flags2 & 1) != 0) {
                obj4 = 1;
            } else {
                obj4 = null;
            }
            if ((flags & 2) != 0) {
                obj5 = 1;
            } else {
                obj5 = null;
            }
            if ((flags2 & 2) != 0) {
                obj3 = 1;
            }
            if (obj6 != null && obj5 == null) {
                return -1;
            }
            if (obj4 != null && obj3 == null) {
                return 1;
            }
            if (obj5 != null) {
                return -1;
            }
            if (obj3 != null) {
                return 1;
            }
        }
        return ((Integer) this.a.m.get(suggestionSpan)).intValue() - ((Integer) this.a.m.get(suggestionSpan2)).intValue();
    }
}
