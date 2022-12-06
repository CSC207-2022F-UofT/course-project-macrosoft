package user_verify_use_case;

import java.util.Date;

public class AddMinutesInteractor {

    /**
     * @param minutes: time to add
     * @param beforeTime: previous time
     * @return afterAddingMins: new time
     */
    public static Date addMinutesToDate(int minutes, Date beforeTime) {
        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs
                + (minutes * 60000));
        return afterAddingMins;
    }
}
