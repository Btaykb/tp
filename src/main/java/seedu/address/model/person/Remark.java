package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public final String value;
    public static final String MESSAGE_CONSTRAINTS = "Tags should be either 'blacklist' or 'favourite'";
    /**
     * Constructor for a remark
     * Represents a remark for a Person.
     *
     * @param remark
     */
    public Remark(String remark) {
        requireNonNull(remark);
        String lowerCaseRemark = remark.toLowerCase();
        checkArgument(isValidRemark(lowerCaseRemark), MESSAGE_CONSTRAINTS);
        // Here, we ensure that remark is in lower case.
        value = lowerCaseRemark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    public static boolean isValidRemark(String test) {
        return (test.equals("blacklist") || test.equals("favourite") || test.equals(""));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
