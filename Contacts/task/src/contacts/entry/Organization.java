package contacts.entry;

import contacts.entry.field.AddressField;
import contacts.entry.field.OrganizationNameField;
import contacts.entry.field.PhoneNumberField;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Organization extends Contact {

    public Organization() {
        super(List.of(
                new OrganizationNameField(),
                new AddressField(),
                new PhoneNumberField()
        ));
    }
    
    @Override
    public @NotNull String getSimpleName() {
        Object nameObj = getFields().get(0).getValue();

        if (nameObj == null) {
            return "[no data]";
        } else {
            return (String) nameObj;
        }
    }
}
