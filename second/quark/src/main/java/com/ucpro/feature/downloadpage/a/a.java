package com.ucpro.feature.downloadpage.a;

import android.text.Html;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* compiled from: ProGuard */
final class a implements OnSeekBarChangeListener {
    final /* synthetic */ k a;

    a(k kVar) {
        this.a = kVar;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (i < this.a.E) {
            i = this.a.E;
        }
        this.a.A.setText(Html.fromHtml(String.format(this.a.D, new Object[]{this.a.C, String.valueOf(i)})));
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.a.B.b(seekBar.getProgress());
    }
}
