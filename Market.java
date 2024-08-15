import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void enqueuePerson(String person) {
        queue.add(person);
        System.out.println(person + " has been added to the queue.");
    }

    @Override
    public void dequeuePerson() {
        if (!queue.isEmpty()) {
            String person = queue.poll();
            System.out.println(person + " has been removed from the queue.");
        } else {
            System.out.println("The queue is empty.");
        }
    }

    @Override
    public String nextPerson() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return null;
    }

    @Override
    public void addPersonToQueue(String person) {
        enqueuePerson(person);
    }

    @Override
    public void removePersonFromQueue() {
        dequeuePerson();
    }

    public void update() {
        System.out.println("Updating market state...");
        String person = nextPerson();
        if (person != null) {
            System.out.println(person + " is being served.");
            removePersonFromQueue();
        } else {
            System.out.println("No one to serve.");
        }
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.addPersonToQueue("Alice");
        market.addPersonToQueue("Bob");
        market.update();
        market.update();
        market.update();
    }
}

