package contacts.input.action;

import contacts.input.InputAsker;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class IndexAsker extends InputAsker<Integer> {

    /**
     * The minimum requirement for the index to be valid. (Inclusive)
     */
    @Getter
    @Setter
    private int minIndex;

    /**
     * The maximum requirement for the index to be valid. (Exclusive)
     */
    @Getter
    @Setter
    private int maxIndex;

    /**
     * @param minIndex the minimum requirement for the index to be valid. (Inclusive)
     * @param maxIndex the maximum requirement for the index to be valid. (Exclusive)
     */
    public IndexAsker(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public @NotNull Integer get() {
        return askForIndexPersistent("Select a record");
    }

    public int askForIndex(@NotNull String query) throws IllegalArgumentException {
        int index = askForInt(query);

        if (index < minIndex || index >= maxIndex) {
            throw new IllegalArgumentException("Please enter a valid index!");
        }

        return index;
    }

    public int askForIndexPersistent(@NotNull String query) {
        int result = 0;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForIndex(query);

                // This line won't be reached if the index was not valid.
                succeeded = true;
            } catch (IllegalArgumentException e) {
                logger.error("Please enter a valid index!");
            }
        }

        return result;
    }
}
