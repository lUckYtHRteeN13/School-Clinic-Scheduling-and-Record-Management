/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectUtilities;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author netha
 */
public class Utils {
    public static final DateTimeFormatter DOBFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    public static final DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter secondDefaultDateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public static String getTimeAgo(Date pastDate) {
        if (pastDate == null) {
            return "No activity";
        }
        long durationMillis = new Date().getTime() - pastDate.getTime();

        long minutes = TimeUnit.MILLISECONDS.toMinutes(durationMillis);
        long hours = TimeUnit.MILLISECONDS.toHours(durationMillis);
        long days = TimeUnit.MILLISECONDS.toDays(durationMillis);
        long weeks = days / 7;

        if (minutes < 1) return "Just now";
        if (minutes < 60) return minutes + " m" + " ago";
        if (hours < 24) return hours + " h" + " ago";
        if (days < 7) return days + " d" + " ago";
        return weeks + " w" + " ago";
    }

}
