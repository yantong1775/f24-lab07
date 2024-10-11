package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    // Implement your fake database here
    private Map<String, Integer> database;

    public InMemoryDatabase() {
        this.database = new HashMap<>();
    }

    // Method to save data to the database
    public void savePassword(String key, int value) {
        database.put(key, value);
    }

    // Method to find data from the database
    @Override
    public int getPassword(String key) {
        return database.get(key);
    }
}
