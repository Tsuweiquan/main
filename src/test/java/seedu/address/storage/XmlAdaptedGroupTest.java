package seedu.address.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.storage.XmlAdaptedGroup.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.TypicalGroups.TUT_1;
import static seedu.address.testutil.TypicalGroups.getTypicalGroupsWithPersons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.GroupLocation;
import seedu.address.model.group.GroupName;
import seedu.address.testutil.Assert;

/**
 * Contains unit tests for {@code XmlAdaptedGroup}.
 */
public class XmlAdaptedGroupTest {
    private static final String INVALID_GROUP_NAME = "M@ths";
    private static final String INVALID_GROUP_LOCATION = " ";
    private static final String INVALID_GROUP_TAG = "&";

    private static final String VALID_GROUP_NAME = TUT_1.getGroupName().toString();
    private static final String VALID_GROUP_LOCATION = TUT_1.getGroupLocation().toString();
    private static final List<XmlAdaptedTag> VALID_GROUP_TAGS = TUT_1.getTags().stream()
            .map(XmlAdaptedTag::new)
            .collect(Collectors.toList());

    private static final List<XmlAdaptedPerson> VALID_GROUP_PERSONS =
            getTypicalGroupsWithPersons().getPersons().stream()
            .map(XmlAdaptedPerson::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validGroupDetails_returnsGroup() throws Exception {
        XmlAdaptedGroup group = new XmlAdaptedGroup(TUT_1);
        assertEquals(TUT_1, group.toModelType());
    }

    @Test
    public void toModelType_invalidGroupName_throwsIllegalValueException() {
        XmlAdaptedGroup group =
                new XmlAdaptedGroup(INVALID_GROUP_NAME, VALID_GROUP_LOCATION, VALID_GROUP_TAGS, VALID_GROUP_PERSONS);
        String expectedMessage = GroupName.MESSAGE_GROUP_NAME_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, group::toModelType);
    }

    @Test
    public void toModelType_nullGroupName_throwsIllegalValueException() {
        XmlAdaptedGroup group = new XmlAdaptedGroup(null, VALID_GROUP_LOCATION, VALID_GROUP_TAGS, VALID_GROUP_PERSONS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, GroupName.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, group::toModelType);
    }

    @Test
    public void toModelType_invalidGroupLocation_throwsIllegalValueException() {
        XmlAdaptedGroup group =
                new XmlAdaptedGroup(VALID_GROUP_NAME, INVALID_GROUP_LOCATION, VALID_GROUP_TAGS, VALID_GROUP_PERSONS);
        String expectedMessage = GroupLocation.MESSAGE_GROUP_LOCATION_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, group::toModelType);
    }

    @Test
    public void toModelType_nullGroupLocation_throwsIllegalValueException() {
        XmlAdaptedGroup group = new XmlAdaptedGroup(VALID_GROUP_NAME, null, VALID_GROUP_TAGS, VALID_GROUP_PERSONS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, GroupLocation.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, group::toModelType);
    }

    @Test
    public void toModelType_invalidGroupTags_throwsIllegalValueException() {
        List<XmlAdaptedTag> invalidGroupTags = new ArrayList<>(VALID_GROUP_TAGS);
        invalidGroupTags.add(new XmlAdaptedTag(INVALID_GROUP_TAG));
        XmlAdaptedGroup group =
                new XmlAdaptedGroup(VALID_GROUP_NAME, VALID_GROUP_LOCATION, invalidGroupTags, VALID_GROUP_PERSONS);
        Assert.assertThrows(IllegalValueException.class, group::toModelType);
    }

    @Test public void equals() {
        XmlAdaptedGroup group = new XmlAdaptedGroup(TUT_1);
        XmlAdaptedGroup groupCopy = new XmlAdaptedGroup(TUT_1);

        // same object -> return true
        assertTrue(group.equals(group));

        // different type -> return false
        assertFalse(group.equals(0));

        // different object same values -> returns true
        assertTrue(group.equals(groupCopy));
    }

}
