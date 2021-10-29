import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class Meeting {
    private final long startEpochDateSeconds;
    private final long endEpochDateSeconds;

    public Meeting(Long startEpochDateSeconds, Long endEpochDateSeconds) {
        this.startEpochDateSeconds = startEpochDateSeconds;
        this.endEpochDateSeconds = endEpochDateSeconds;
    }

    /**
     *
     * @param that meeting instance we're comparing to
     * @return boolean, true if date intervals overlap
     */
    public boolean doesOverlap(@NotNull Meeting that) {
        return (this.startEpochDateSeconds < that.endEpochDateSeconds) && (this.endEpochDateSeconds > that.startEpochDateSeconds);
    }
}
