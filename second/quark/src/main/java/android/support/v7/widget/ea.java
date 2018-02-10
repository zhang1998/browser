package android.support.v7.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ProGuard */
final class ea extends AsyncTask<Object, Void, Void> {
    final /* synthetic */ fs a;

    private ea(fs fsVar) {
        this.a = fsVar;
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a(objArr);
    }

    private Void a(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        String str = (String) objArr[1];
        try {
            OutputStream openFileOutput = this.a.g.openFileOutput(str, 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    fq fqVar = (fq) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", fqVar.a.flattenToString());
                    newSerializer.attribute(null, "time", String.valueOf(fqVar.b));
                    newSerializer.attribute(null, "weight", String.valueOf(fqVar.c));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                this.a.l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                Log.e(fs.c, "Error writing historical recrod file: " + this.a.h, e2);
                this.a.l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(fs.c, "Error writing historical recrod file: " + this.a.h, e22);
                this.a.l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable e222) {
                Log.e(fs.c, "Error writing historical recrod file: " + this.a.h, e222);
                this.a.l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                this.a.l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (Throwable e2222) {
            Log.e(fs.c, "Error writing historical recrod file: " + str, e2222);
        }
        return null;
    }
}
