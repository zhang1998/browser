package com.yunos.faceunlock.facemanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import com.yunos.a.a.a;
import com.yunos.faceunlock.facemanager.model.FaceRecord;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class RegisteredFaceManager {
    public static final String ACTION_NEED_SYNC = "com.yunos.faceunlock.NEDD_SYNC";
    public static String COLUMN_FEATURE = "feature";
    public static String COLUMN_ID = "id";
    public static String COLUMN_LANDMARK = "landmark";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_PATH = "path";
    public static String COLUMN_UPLOADED = "uploaded";
    public static String DB_NAME = "face_db";
    private static final String SYNC_URL = "http://10.189.198.33:7001/syncTest.html";
    public static String TABLE_MODELS = "models";
    private static RegisteredFaceManager sInstance;
    private static String sql_create_model = ("create table if not exists '" + TABLE_MODELS + "' (" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_NAME + " varchar(256), " + COLUMN_PATH + " varchar(512), " + COLUMN_LANDMARK + " varchar(4096), " + COLUMN_FEATURE + " varchar(65535), " + COLUMN_UPLOADED + " integer)");
    private static String sql_drop_tables = ("drop table if exists " + TABLE_MODELS);
    private Context context;
    private SQLiteDatabase db = this.context.openOrCreateDatabase(DB_NAME, 0, null);

    public static synchronized RegisteredFaceManager getInstance(Context context) {
        RegisteredFaceManager registeredFaceManager;
        synchronized (RegisteredFaceManager.class) {
            if (sInstance == null) {
                sInstance = new RegisteredFaceManager(context);
            }
            registeredFaceManager = sInstance;
        }
        return registeredFaceManager;
    }

    private RegisteredFaceManager(Context context) {
        this.context = context;
        createTables(this.context);
    }

    public int getRegisteredCount() {
        Cursor query = this.db.query(TABLE_MODELS, null, null, null, null, null, null);
        int count = query.getCount();
        query.close();
        return count;
    }

    public boolean isRegistered(String str) {
        boolean z;
        Cursor query = this.db.query(TABLE_MODELS, null, COLUMN_NAME + " = ?", new String[]{str}, null, null, null);
        if (query.getCount() != 0) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }

    public Cursor queryAll() {
        return this.db.query(TABLE_MODELS, null, null, null, null, null, null);
    }

    public Cursor query(String str) {
        return this.db.query(TABLE_MODELS, null, COLUMN_ID + " = ?", new String[]{str}, null, null, null);
    }

    public void insert(String str, String str2, String str3, String str4, int i) {
        FaceRecord faceRecord = new FaceRecord();
        faceRecord.name = str;
        faceRecord.path = str2;
        faceRecord.landmark = str3;
        faceRecord.feature = str4;
        faceRecord.uploaded = i;
        insertRecord(faceRecord);
    }

    public void insertRecord(FaceRecord faceRecord) {
        this.db.insert(TABLE_MODELS, null, faceRecord.toContentValues());
    }

    protected Cursor countQuery() {
        return this.db.query(TABLE_MODELS, new String[]{"count(*)"}, null, null, null, null, null);
    }

    public void createTables(Context context) {
        if (this.db == null || !this.db.isOpen()) {
            this.db = context.openOrCreateDatabase(DB_NAME, 0, null);
        }
        try {
            this.db.execSQL(sql_create_model);
        } catch (SQLException e) {
        }
    }

    public ArrayList<String> getAllPictures() {
        Cursor query = this.db.query(TABLE_MODELS, null, null, null, null, null, null);
        int columnIndex = query.getColumnIndex(COLUMN_PATH);
        ArrayList<String> arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(query.getString(columnIndex));
        }
        query.close();
        return arrayList;
    }

    public void deleteModelRecord(String str) {
        Cursor query = this.db.query(TABLE_MODELS, null, COLUMN_NAME + "=?", new String[]{str}, null, null, null);
        while (query.moveToNext()) {
            File file = new File(query.getString(query.getColumnIndex(COLUMN_PATH)));
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        query.close();
        this.db.delete(TABLE_MODELS, COLUMN_NAME + "=?", new String[]{str});
    }

    public void deleteModelRecordById(String str) {
        Cursor query = this.db.query(TABLE_MODELS, null, COLUMN_ID + "=?", new String[]{str}, null, null, null);
        while (query.moveToNext()) {
            File file = new File(query.getString(query.getColumnIndex(COLUMN_PATH)));
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        query.close();
        this.db.delete(TABLE_MODELS, COLUMN_ID + "=?", new String[]{str});
    }

    public void deleteModelRecordByFile(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        this.db.delete(TABLE_MODELS, COLUMN_PATH + "=?", new String[]{str});
    }

    public void open(Context context) {
        if (this.db == null || !this.db.isOpen()) {
            this.db = context.openOrCreateDatabase(DB_NAME, 0, null);
        }
    }

    public void dropTables() {
        this.db.execSQL(sql_drop_tables);
    }

    public void setNeedSync(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putBoolean("needSync", z).apply();
        this.context.sendBroadcast(new Intent(ACTION_NEED_SYNC));
    }

    private boolean getNeedSync() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean("needSync", true);
    }

    public void renameRecord(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, str2);
        this.db.update(TABLE_MODELS, contentValues, COLUMN_ID + " = ?", new String[]{str});
    }

    public String getNewFaceName() {
        return this.context.getString(a.shared_default_face_name, new Object[]{Integer.valueOf(getRegisteredCount() + 1)});
    }

    public void cleanAll() {
        Cursor queryAll = queryAll();
        String[] strArr = new String[queryAll.getCount()];
        int i = 0;
        while (queryAll.moveToNext()) {
            strArr[i] = queryAll.getString(queryAll.getColumnIndex(COLUMN_NAME));
            i++;
        }
        queryAll.close();
        for (String str : strArr) {
            this.db.delete(TABLE_MODELS, COLUMN_NAME + "=?", new String[]{str});
        }
    }

    public void cleanFirstFace() {
        Cursor queryAll = queryAll();
        String[] strArr = new String[queryAll.getCount()];
        int i = 0;
        while (queryAll.moveToNext()) {
            strArr[i] = queryAll.getString(queryAll.getColumnIndex(COLUMN_NAME));
            i++;
        }
        queryAll.close();
        if (strArr.length == facerecognition.b.a.a) {
            this.db.delete(TABLE_MODELS, COLUMN_NAME + "=?", new String[]{strArr[0]});
        }
    }
}
