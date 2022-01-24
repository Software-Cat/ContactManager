package contacts.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneNumberUtil {

    private static final Pattern GROUP_ONE = Pattern.compile("\\+?\\(?[a-zA-Z0-9]+\\)?");

    private static final Pattern GROUP_TWO_PLUS = Pattern.compile("\\(?[a-zA-Z0-9][a-zA-Z0-9]+\\)?");

    private static final Pattern HAS_PARENTHESIS = Pattern.compile("\\([a-zA-Z0-9]+\\)");

    private static final PhoneNumberUtil INSTANCE = new PhoneNumberUtil();

    private PhoneNumberUtil() {
    }

    public static PhoneNumberUtil getInstance() {
        return INSTANCE;
    }

    public boolean isValid(@Nullable String phoneNumber) {
        // Null check.
        if (phoneNumber == null) {
            return false;
        }

        // The phone number should be split into groups using a space or dash.
        List<String> groups = splitGroups(phoneNumber);

        switch (groups.size()) {
            case 0 -> {
                // Phone number cannot be empty.
                return false;
            }
            case 1 -> {
                // Before the first group, there may or may not be a plus symbol.
                // The first group may be only one symbol in length.
                if (!GROUP_ONE.matcher(phoneNumber).matches()) {
                    return false;
                }
            }
            default -> {
                // Two or more groups.
                // Before the first group, there may or may not be a plus symbol.
                // The first group may be only one symbol in length.
                if (!GROUP_ONE.matcher(groups.get(0)).matches()) {
                    return false;
                }

                // The first group, or the second group can be wrapped in parentheses,
                // but there should be no more than one group that is wrapped in parentheses.
                // There may also be no groups wrapped in parentheses.
                int parenthesizedGroups = 0;
                for (String group : groups) {
                    if (HAS_PARENTHESIS.matcher(group).find()) {
                        parenthesizedGroups++;
                    }
                }

                if (parenthesizedGroups > 1) {
                    return false;
                }

                for (String group : groups) {
                    if (!areParenthesesPaired(group)) {
                        return false;
                    }
                }

                // A group can contain numbers, uppercase and lowercase English letters.
                // A group should be at least 2 symbols in length.
                for (String group : groups.subList(1, groups.size())) {
                    if (!GROUP_TWO_PLUS.matcher(group).matches()) {
                        return false;
                    }
                }
            }
        }

        // If all tests passed, return true.
        return true;
    }

    private @NotNull List<String> splitGroups(@NotNull String phoneNumber) {
        return Arrays.asList(phoneNumber.split("[ \\-]"));
    }

    private boolean areParenthesesPaired(String group) {
        char c = group.toCharArray()[group.length() - 1];
        if (group.toCharArray()[0] == '(') {
            // If the group starts with a parenthesis, it must also end with one.
            return c == ')';
        } else {
            // if the group does not start with a parenthesis, it should not end with one.
            return c != ')';
        }
    }
}
