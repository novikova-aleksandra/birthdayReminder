package com.novikova.birthdayreminder;

import android.app.Activity;
import android.os.Bundle;

import com.novikova.birthdayreminder.db.Reminder;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //check for new entries every day
    private void setUpDataUpdates() {

    }

    //get list of reminders from contacts database
    private List<Reminder> queryForReminders() {
        return null;
    }
}
