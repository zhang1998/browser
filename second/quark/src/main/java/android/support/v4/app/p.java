package android.support.v4.app;

import android.os.Bundle;

/* compiled from: ProGuard */
final class p {
    static Bundle[] a(e[] eVarArr) {
        if (eVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[eVarArr.length];
        for (int i = 0; i < eVarArr.length; i++) {
            e eVar = eVarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", eVar.a());
            bundle.putCharSequence("label", eVar.b());
            bundle.putCharSequenceArray("choices", eVar.c());
            bundle.putBoolean("allowFreeFormInput", eVar.d());
            bundle.putBundle("extras", eVar.e());
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }
}
