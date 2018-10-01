package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.Test;

import seedu.address.logic.commands.GroupCommand;

public class GroupCommandParserTest {
    private GroupCommandParser parser = new GroupCommandParser();

    @Test
    public void parseNoParametersFailure() {
        String expectedOutput = String.format(MESSAGE_INVALID_COMMAND_FORMAT, GroupCommand.MESSAGE_USAGE);

        //  without any parameters
        assertParseFailure(parser, GroupCommand.COMMAND_WORD, expectedOutput);
        assertParseFailure(parser, GroupCommand.COMMAND_WORD_2, expectedOutput);
    }
}