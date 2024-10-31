package seedu.manager.command;

import seedu.manager.event.Event;
import seedu.manager.item.Item;
import seedu.manager.item.Participant;

import java.util.Optional;

//@@author glenn-chew
/**
 * Represents a command to view the list of participants in an event.
 * The view command will search for an event by its name and display all its participants if found.
 */
public class ViewCommand extends Command {
    public static final String COMMAND_WORD = "view";
    private static final String VIEW_PARTICIPANT_MESSAGE = "There are %d participants in %s! " +
            "Here are your participants:";
    private static final String VIEW_ITEM_MESSAGE = "There are %d items in %s! " +
            "Here are your items:";
    private static final String INVALID_EVENT_MESSAGE = "Event not found!";

    protected String eventName;
    private boolean isViewingParticipants;

    /**
     * Constructs an ViewCommand object with the for the specified event.
     *
     * @param eventName The name of the event to be viewed.
     */
    public ViewCommand(String eventName, boolean isViewingParticipants) {
        super(false);
        this.eventName = eventName;
        this.isViewingParticipants = isViewingParticipants;
    }

    /**
     * Executes the command to view the participants for an event.
     */
    public void execute() {
        Optional<Event> eventToView = eventList.getEventByName(eventName);

        if (eventToView.isEmpty()) {
            message = INVALID_EVENT_MESSAGE;
        } else if (isViewingParticipants) {
            message = getParticipants(eventToView.get());
        } else {
            message = getItems(eventToView.get());
        }
    }

    private String getParticipants(Event eventToView) {
        StringBuilder outputMessage = new StringBuilder(
                String.format(VIEW_PARTICIPANT_MESSAGE, eventToView.getParticipantCount(), eventName) + "\n");
        int count = 1;
        for (Participant participant : eventToView.getParticipantList()) {
            outputMessage.append(String.format("%d. %s\n", count, participant.toString()));
            count++;
        }
        return outputMessage.toString();
    }

    //@@author jemehgoh
    private String getItems(Event eventToView) {
        StringBuilder outputMessage = new StringBuilder(
                String.format(VIEW_ITEM_MESSAGE, eventToView.getItemCount(), eventName) + "\n");
        int count = 1;
        for (Item item : eventToView.getItemList()) {
            outputMessage.append(String.format("%d. %s\n", count, item.toString()));
            count++;
        }
        return outputMessage.toString();
    }
}
