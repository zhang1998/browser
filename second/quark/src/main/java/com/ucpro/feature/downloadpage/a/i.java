package com.ucpro.feature.downloadpage.a;

import android.text.Html;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
final class i implements OnSeekBarChangeListener {
    final /* synthetic */ int a;
    final /* synthetic */ ATTextView b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ c e;

    i(c cVar, int i, ATTextView aTTextView, String str, String str2) {
        this.e = cVar;
        this.a = i;
        this.b = aTTextView;
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
