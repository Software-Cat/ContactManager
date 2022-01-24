package contacts.entry.field;

import contacts.util.PhoneNumberUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class PhoneNumber {

    private static final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    @Getter(AccessLevel.PRIVATE)
    @NotNull
    String phoneNumber;

    public PhoneNumber(@NotNull String phoneNumber) throws IllegalArgumentException {
        if (!phoneUtil.isValid(phoneNumber)) {
            throw new IllegalArgumentException("Wrong number format!");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public @NotNull String toString() {
        return phoneNumber;
    }
}
