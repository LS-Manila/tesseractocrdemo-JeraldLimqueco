package com.example.jerald.huffpuff;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", false);
        intent.putExtra("rrule", "FREQ=DAILY");
        intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000);
        intent.putExtra("title", "The Day I Stopped Smoking");
        startActivity(intent);

        Uri EVENTS_URI = Uri.parse(getCalendarUriBase(this) + "events");
        ContentResolver cr = getContentResolver();

// event insert
        ContentValues values = new ContentValues();
        values.put("calendar_id", 1);
        values.put("title", "Reminder Title");
        values.put("allDay", 0);
        values.put("dtstart", cal.getTimeInMillis() + 11 * 60 * 1000); // event starts at 11 minutes from now
        values.put("dtend", cal.getTimeInMillis() + 60 * 60 * 1000); // ends 60 minutes from now
        values.put("description", "Reminder description");
        values.put("visibility", 0);
        values.put("hasAlarm", 1);
        Uri event = cr.insert(EVENTS_URI, values);

// reminder insert
        Uri REMINDERS_URI = Uri.parse(getCalendarUriBase(this) + "reminders");
        values = new ContentValues();
        values.put("event_id", Long.parseLong(event.getLastPathSegment()));
        values.put("method", 1);
        values.put("minutes", 10);
        cr.insert(REMINDERS_URI, values);
    }

    private String getCalendarUriBase(Activity act) {
        String calendarUriBase = null;
        Uri calendars = Uri.parse("content://calendar/calendars");
        Cursor managedCursor = null;
        try {
            managedCursor = act.managedQuery(calendars, null, null, null, null);
        } catch (Exception e) {
        }
        if (managedCursor != null) {
            calendarUriBase = "content://calendar/";
        } else {
            calendars = Uri.parse("content://com.android.calendar/calendars");
            try {
                managedCursor = act.managedQuery(calendars, null, null, null, null);
            } catch (Exception e) {
            }
            if (managedCursor != null) {
                calendarUriBase = "content://com.android.calendar/";
            }
        }
        return calendarUriBase;
    }
}
