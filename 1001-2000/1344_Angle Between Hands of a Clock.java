class Solution {
    public double angleClock(int hour, int minutes) {
       hour = hour % 12;
       
       double hoursAngle = (30 * hour) + (minutes * 0.5);
       double minutesAngle = minutes * 6;
       double angle = Math.abs(hoursAngle - minutesAngle);
       return Math.min(angle, 360-angle);
    }
}
