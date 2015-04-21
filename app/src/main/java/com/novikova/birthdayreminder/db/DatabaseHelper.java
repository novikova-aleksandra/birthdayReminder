package com.novikova.birthdayreminder.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by novikova on 21.04.15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "reminders.db";

    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper helper = null;

    private Dao<Reminder, Integer> reminderDao = null;
    private RuntimeExceptionDao<Reminder, Integer> reminderRuntimeDao = null;

    private DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getDatabaseHelper(Context context) {
        if (helper == null) {
            helper = new DatabaseHelper(context);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Reminder.class);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            if (newVersion > oldVersion) {
                TableUtils.dropTable(connectionSource, Reminder.class, true);
                onCreate(database, connectionSource);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Dao<Reminder, Integer> getReminderDao() throws SQLException {
        if (reminderDao == null) {
            reminderDao = getDao(Reminder.class);
        }
        return reminderDao;
    }

    public RuntimeExceptionDao<Reminder, Integer> getRuntimeReminderDao() {
        if (reminderRuntimeDao == null) {
            reminderRuntimeDao = getRuntimeExceptionDao(Reminder.class);
        }
        return reminderRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        reminderDao = null;
        reminderRuntimeDao = null;
    }
}
