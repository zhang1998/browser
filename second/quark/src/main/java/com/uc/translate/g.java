package com.uc.translate;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ TranslateResponse[] a;
    final /* synthetic */ h b;

    g(h hVar, TranslateResponse[] translateResponseArr) {
        this.b = hVar;
        this.a = translateResponseArr;
    }

    public final void run() {
        if (this.a[0] == null) {
            this.b.e.a("-1", "response is null");
        } else if (this.a[0].mTranslateError == null || this.b.e == null) {
            p pVar = new p();
            pVar.a = this.a[0].mTranslateText.mTranslated;
            this.b.e.a(pVar);
        } else {
            this.b.e.a(this.a[0].mTranslateError.mCode, this.a[0].mTranslateError.mErrorMsg);
        }
    }
}
