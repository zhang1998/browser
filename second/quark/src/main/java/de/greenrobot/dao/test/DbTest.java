package de.greenrobot.dao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import de.greenrobot.dao.DbUtils;
import java.util.Random;

/* compiled from: ProGuard */
public abstract class DbTest extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";
    private Application application;
    protected SQLiteDatabase db;
    protected final boolean inMemory;
    protected final Random random;

    public DbTest() {
        this(true);
    }

    public DbTest(boolean z) {
        this.inMemory = z;
        this.random = new Random();
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.db = createDatabase();
    }

    public <T extends Application> T createApplication(Class<T> cls) {
        assertNull("Application already created", this.application);
        try {
            T newApplication = Instrumentation.newApplication(cls, getContext());
            newApplication.onCreate();
            this.application = newApplication;
            return newApplication;
        } catch (Throwable e) {
            throw new RuntimeException("Could not create application " + cls, e);
        }
    }

    public void terminateApplication() {
        assertNotNull("Application not yet created", this.application);
        this.application.onTerminate();
        this.application = null;
    }

    public <T extends Application> T getApplication() {
        assertNotNull("Application not yet created", this.application);
        return this.application;
    }

    protected SQLiteDatabase createDatabase() {
        if (this.inMemory) {
            return SQLiteDatabase.create(null);
        }
        getContext().deleteDatabase(DB_NAME);
        return getContext().openOrCreateDatabase(DB_NAME, 0, null);
    }

    protected void tearDown() throws Exception {
        if (this.application != null) {
            terminateApplication();
        }
        this.db.close();
        if (!this.inMemory) {
            getContext().deleteDatabase(DB_NAME);
        }
        super.tearDown();
    }

    protected void logTableDump(String str) {
        DbUtils.logTableDump(this.db, str);
    }
}
