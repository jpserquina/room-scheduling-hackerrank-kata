import java.util.ArrayList;

/**
 *
 */
public class CandidateSolution {
    private static final int numberOfRooms = 8;
    private static final int noOpenRoomError = -1;
    private static final int invalidInputError = -2;

    public static ArrayList<Room> rooms = new ArrayList<>(numberOfRooms);

    public static int addSchedule(Long startEpochDateSeconds, Long endEpochDateSeconds) {
        int result = 0;
        Meeting meeting = new Meeting(startEpochDateSeconds, endEpochDateSeconds);

        long meetingLength = endEpochDateSeconds - startEpochDateSeconds;
        boolean isPositiveMeetingLength = (meetingLength > 0);
        boolean isMeetingLengthIn5MinuteIntervals = ((meetingLength % 5) == 0);
        boolean isMeetingLengthAtLeast5Minutes = (meetingLength >= 300);
        boolean isMeetingLengthAtMost7Days = (meetingLength <= 604800);

        // guard check - if meeting has negative length, is not in 5 minute intervals, and not between 5 minutes and 7 days in length
        if (!isPositiveMeetingLength || !isMeetingLengthIn5MinuteIntervals || !isMeetingLengthAtLeast5Minutes || isMeetingLengthAtMost7Days) {
            result = invalidInputError;
        }

        if (result == 0) {
            boolean hasBeenScheduled = false;

            for (int roomIndex = 0; roomIndex < numberOfRooms; roomIndex++) {
                // break out early if scheduling goes through
                if (hasBeenScheduled) {
                    break;
                }

                // initialize room on first iteration
                if (roomIndex >= rooms.size()) {
                    Room newRoom = new Room();
                    rooms.add(newRoom);
                }

                // try adding the meeting to the current room
                Room currentRoom = rooms.get(roomIndex);
                if (currentRoom.addMeeting(meeting)) {
                    result = roomIndex + 1;
                    hasBeenScheduled = true;
                }
            }

            // if we still get a zero result, no more rooms are open for this meeting schedule
            if (!hasBeenScheduled) {
                result = noOpenRoomError;
            }
        }

        return result;
    }
}
