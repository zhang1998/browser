package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

/* compiled from: ProGuard */
final class u {
    static RemoteInput[] a(e[] eVarArr) {
        if (eVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[eVarArr.length];
        for (int i = 0; i < eVarArr.length; i++) {
            e eVar = eVarArr[i];
            remoteInputArr[i] = new Builder(eVar.a()).setLabel(eVar.b()).setChoices(eVar.c()).setAllowFreeFormInput(eVar.d()).addExtras(eVar.e()).build();
        }
        return remoteInputArr;
    }
}
