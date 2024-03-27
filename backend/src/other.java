// Now, let's say we want to hash the roomName to determine which worker node it goes to
        int numberOfNodes = 10; // This would be a predefined value in your system
                int nodeId = hashFunction(accommodation.getRoomName()) % numberOfNodes;

                // Now you would send the accommodation details to the worker node identified by nodeId
                // The actual network communication code would go here
                }

// Hypothetical method to hash a room name
private static int hashFunction(String roomName) {
        // This is a simple hash function for demonstration. In practice, you might use a more complex, robust algorithm.
        return roomName.hashCode();
        }

// Hypothetical method to parse JSON into an Accommodation object
private static Accommodation parseJson(String json) {
        // For simplicity in this example, we're just manually parsing the JSON
        // In a real-world scenario, you would use a library like Jackson or Gson
        Map<String, String> map = new HashMap<>();
        String[] pairs = json.replace("{", "").replace("}", "").split(",");
        for (String pair : pairs) {
        String[] keyValue = pair.split(":");
        map.put(keyValue[0].trim().replace("\"", ""), keyValue[1].trim().replace("\"", ""));
        }

        Accommodation accommodation = new Accommodation();
        accommodation.setRoomName(map.get("roomName"));
        accommodation.setNoOfPersons(Integer.parseInt(map.get("noOf