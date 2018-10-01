package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupLocation;
import seedu.address.model.group.GroupName;
import seedu.address.model.tag.Tag;


/**
 * JAXB-friendly version of the Group.
 */
public class XmlAdaptedGroup {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Group's %s field is missing!";

    @XmlElement(required = true)
    private String groupName;
    @XmlElement(required = true)
    private String groupLocation;

    @XmlElement
    private List<XmlAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs an XmlAdaptedGroup.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedGroup() {
    }

    /**
     * Constructs an {@code XmlAdaptedGroup} with the given group details.
     */
    public XmlAdaptedGroup(String groupName, String groupLocation, List<XmlAdaptedTag> tagged) {
        this.groupName = groupName;
        this.groupLocation = groupLocation;
        if (tagged != null) {
            this.tagged = new ArrayList<>(tagged);
        }
    }

    /**
     * Converts a given group into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedGroup
     */
    public XmlAdaptedGroup(Group source) {
        groupName = source.getGroupName().groupName;
        groupLocation = source.getGroupLocation().groupLocation;
        tagged = source.getTags().stream()
                .map(XmlAdaptedTag::new)
                .collect(Collectors.toList());
    }

    /**
     * Converts this jaxb-friendly adapted group object into the model's Group object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted group
     */
    public Group toModelType() throws IllegalValueException {
        final List<Tag> groupTags = new ArrayList<>();
        for (XmlAdaptedTag tag : tagged) {
            groupTags.add(tag.toModelType());
        }

        if (groupName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Group.class.getSimpleName()));
        }
        if (!GroupName.isValidGroupName(groupName)) {
            throw new IllegalValueException(GroupName.MESSAGE_GROUP_NAME_CONSTRAINTS);
        }
        final GroupName modelGroupName = new GroupName(groupName);

        if (groupLocation == null) {
            String input = String.format(MISSING_FIELD_MESSAGE_FORMAT, GroupLocation.class.getSimpleName());
            throw new IllegalValueException(input);
        }
        if (!GroupLocation.isValidGroupLocation(groupLocation)) {
            throw new IllegalValueException(GroupLocation.MESSAGE_GROUP_LOCATION_CONSTRAINTS);
        }
        final GroupLocation modelGroupLocation = new GroupLocation(groupLocation);

        final Set<Tag> modelTags = new HashSet<>(groupTags);
        return new Group(modelGroupName, modelGroupLocation, modelTags);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof XmlAdaptedGroup)) {
            return false;
        }

        XmlAdaptedGroup otherGroup = (XmlAdaptedGroup) other;
        return Objects.equals(groupName, otherGroup.groupName)
                && Objects.equals(groupLocation, otherGroup.groupLocation)
                && tagged.equals(otherGroup.tagged);
    }
}