package down.take.systematic.make_me_great.Objects;

import java.util.Calendar;

public class Alarm {

    private String alarmName;
    private Calendar scheduledTimeDate;
    private boolean active;
    private final int alarmId;


    public Alarm(String name, Calendar datetime, int id){
        alarmName = name;
        scheduledTimeDate = datetime;
        active = false;
        alarmId = id;
    }

    public String getAlarmName(){
        return alarmName;
    }

    public Calendar getScheduledTimeDate() {
        return scheduledTimeDate;
    }

    public int getAlarmId(){
        return alarmId;
    }

}
