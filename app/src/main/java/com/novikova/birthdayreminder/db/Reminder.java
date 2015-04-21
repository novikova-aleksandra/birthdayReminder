package com.novikova.birthdayreminder.db;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by novikova on 21.04.15.
 */
public class Reminder {

    @DatabaseField
    private String contactName;

    @DatabaseField
    private String reminderType;

    @DatabaseField
    private long reminderDate;

    public Reminder() {

    }

    public Reminder(String contactName, long reminderDate, String reminderType) {
        this.contactName = contactName;
        this.reminderDate = reminderDate;
        this.reminderType = reminderType;
    }

    public String getContactName() {
        return contactName;
    }

    public String getReminderType() {
        return reminderType;
    }

    public long getReminderDate() {
        return reminderDate;
    }
}
