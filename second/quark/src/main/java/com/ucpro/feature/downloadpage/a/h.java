package com.ucpro.feature.downloadpage.a;

import android.text.Html;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/* compiled from: ProGuard */
final class h implements OnSeekBarChangeListener {
    final /* synthetic */ int a;
    final /* synthetic */ TextView b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ l e;

    h(l lVar, int i, TextView textView, String str, String str2) {
        this.e = lVar;
        this.a = i;
        this.b = textView;
        this.c = str;
        this.d = str2;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (i < this.a) {
            i = this.a;
        }
        this.b.setText(Html.fromHtml(String.format(this.c, new Object[]{this.d, String.valueOf(i)})));
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
