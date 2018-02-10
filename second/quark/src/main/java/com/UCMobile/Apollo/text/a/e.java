package com.UCMobile.Apollo.text.a;

import android.text.SpannableStringBuilder;
import com.UCMobile.Apollo.text.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements com.UCMobile.Apollo.text.e {
    private final List<a> a;
    private final int b;
    private final long[] c = new long[(this.b * 2)];
    private final long[] d;

    public e(List<a> list) {
        this.a = list;
        this.b = list.size();
        for (int i = 0; i < this.b; i++) {
            a aVar = (a) list.get(i);
            int i2 = i * 2;
            this.c[i2] = aVar.i;
            this.c[i2 + 1] = aVar.j;
        }
        this.d = Arrays.copyOf(this.c, this.c.length);
        Arrays.sort(this.d);
    }

    public final List<b> a(long j) {
        CharSequence charSequence = null;
        int i = 0;
        a aVar = null;
        ArrayList arrayList = null;
        while (i < this.b) {
            CharSequence charSequence2;
            a aVar2;
            ArrayList arrayList2;
            CharSequence charSequence3;
            if (this.c[i * 2] > j || j >= this.c[(i * 2) + 1]) {
                charSequence2 = charSequence;
                aVar2 = aVar;
                arrayList2 = arrayList;
                charSequence3 = charSequence2;
            } else {
                ArrayList arrayList3;
                Object obj;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                } else {
                    arrayList3 = arrayList;
                }
                a aVar3 = (a) this.a.get(i);
                if (aVar3.c == Float.MIN_VALUE && aVar3.f == Float.MIN_VALUE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    arrayList3.add(aVar3);
                    charSequence3 = charSequence;
                    aVar2 = aVar;
                    arrayList2 = arrayList3;
                } else if (aVar == null) {
                    arrayList2 = arrayList3;
                    a aVar4 = aVar3;
                    charSequence3 = charSequence;
                    aVar2 = aVar4;
                } else if (charSequence == null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(aVar.a).append("\n").append(aVar3.a);
                    Object obj2 = spannableStringBuilder;
                    aVar2 = aVar;
                    arrayList2 = arrayList3;
                } else {
                    charSequence.append("\n").append(aVar3.a);
                    charSequence3 = charSequence;
                    aVar2 = aVar;
                    arrayList2 = arrayList3;
                }
            }
            i++;
            charSequence2 = charSequence3;
            arrayList = arrayList2;
            aVar = aVar2;
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            arrayList.add(new a(charSequence));
        } else if (aVar != null) {
            arrayList.add(aVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
