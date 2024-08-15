public interface QueueBehaviour {
    void enqueuePerson(String person);
    void dequeuePerson();
    String nextPerson();
}
