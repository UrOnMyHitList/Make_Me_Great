package down.take.systematic.make_me_great.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import down.take.systematic.make_me_great.Objects.Alarm;

public class SQLite_DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "scheduled_alarms.db";
    private static final String TABLE_SCHEDULED_ALARMS = "scheduled_alarms";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ALARM_NAME = "name";
    public static final String COLUMN_ALARM_TIME = "time";
    public static final String COLUMN_ALARM_DAY = "day";

    public SQLite_DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_SCHEDULED_ALARMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ALARM_NAME + " TEXT," +
                COLUMN_ALARM_TIME + " TEXT," +
                COLUMN_ALARM_DAY + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULED_ALARMS);
        onCreate(db);
    }

    public void addAlarm(Alarm alarm){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ALARM_NAME, alarm.getAlarmName());
        contentValues.put(COLUMN_ALARM_DAY, alarm.getScheduledTimeDate().toString());
        contentValues.put(COLUMN_ALARM_TIME, alarm.getScheduledTimeDate().getTime().toString());
        SQLiteDatabase database = getWritableDatabase();
        database.insert(TABLE_SCHEDULED_ALARMS, null, contentValues);
        database.close();
    }

    public void deleteAlarm(Alarm alarm){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_SCHEDULED_ALARMS +
                        " WHERE " + COLUMN_ID + "='" + alarm.getAlarmId() + "';");
    }
}
