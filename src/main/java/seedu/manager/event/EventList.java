package seedu.manager.event;

import java.util.ArrayList;


/**
 * The EventList class manages a list of Event objects.
 * It provides methods to manage an event list.
 */
public class EventList  {
    private final ArrayList<Event> eventList;

    /**
     * Constructor that initializes EventList with a given list of event.
     *
     * @param eventList The initial list of tasks.
     */
    public EventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     * Default constructor that initializes an empty event list.
     */
    public EventList(){
        eventList = new ArrayList<>();
    }

    /**
     * @return The size of the event list.
     */
    public int getListSize() {
        return eventList.size();
    }

    /**
     * Adds a new event to the event list.
     *
     * @param eventName The name of the event to be added.
     */
    public void addEvent(String eventName) {
        Event newEvent = new Event(eventName);
        eventList.add(newEvent);
    }

    /**
     * @param index The index of event in the list
     * @return The specific event in the event list.
     */
    public Event getEvent(int index) {
        return eventList.get(index - 1);
    }

    /**
     * Removes an event from the event list by its name.
     *
     * @param eventName the name of the event to be removed.
     * @return {@code true} if the event was successfully removed;
     *         {@code false} if no event with the specified name was found.
     */
    public boolean removeEvent(String eventName) {
        for (Event event : eventList) {
            if (event.getEventName().equals(eventName)) {
                eventList.remove(event);
                return true; // Event found and removed
            }
        }
        return false; // Event not found
    }

    /**
     * Adds a participant to an existing event.
     *
     * @param participantName the name of the participant to be added.
     * @param eventName the name of the event to which the participant will be added.
     */
    public void addParticipantToEvent(String participantName, String eventName) {
        for (Event event : eventList) {
            if (event.getEventName().equals(eventName)) {
                event.addParticipant(participantName);
                break;
            }
        }
    }
}
