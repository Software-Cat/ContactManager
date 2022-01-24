package contacts.entry.field;

import com.google.common.base.CaseFormat;

public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name());
    }
}
