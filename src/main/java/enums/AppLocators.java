package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppLocators {

    ADD_CONTACT_BUTTON("addContactButton"),
    TARGET_ACCOUNT("accountSpinner"),
    CONTACT_NAME("contactNameEditText"),
    CONTACT_PHONE("contactPhoneEditText"),
    CONTACT_PHONE_TYPE("contactPhoneTypeSpinner"),
    CONTACT_EMAIL("contactEmailEditText"),
    CONTACT_EMAIL_TYPE("contactEmailTypeSpinner"),
    CONTACT_SAVE_BUTTON("contactSaveButton");

    final String locator;

}
