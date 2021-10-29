import java.util.ArrayList;

public class Room {
    private final ArrayList<Meeting> room;

    public Room() {
        this.room = new ArrayList<>();
    }

    /**
     *
     * @param newMeeting meeting instance we're adding
     * @return boolean, false if a schedule overlap occurs, true otherwise
     */
    public boolean addMeeting(Meeting newMeeting) {
        boolean result = true;

        // if room has scheduled meetings, check for collisions
        if (room.size() > 0) {
            for (Meeting currentMeeting : this.room) {
                if (!result) {
                    break;
                }

                if (currentMeeting.doesOverlap(newMeeting)) {
                    result = false;
                }
            }
        }

        // if there are no collisions, add meeting schedule to our room
        if (result) {
            room.add(newMeeting);
        }

        return result;
    }
}
