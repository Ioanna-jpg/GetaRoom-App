class ParserJSON{
         





         
        public ArrayList<Room> parse(InputStream file) {
            ArrayList<Room> room_list = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(file));
                String line;
                StringBuilder jsonData = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                jsonData.append(line);
                }

                JSONArray jsonArray = new JSONArray(jsonData.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Ανάκτηση των πεδίων από το JSON
                    String roomName = jsonObject.getString("roomName");
                    int noOfPersons = jsonObject.getInt("noOfPersons");
                    String area = jsonObject.getString("area");
                    int stars = jsonObject.getInt("stars");
                    int noOfReviews = jsonObject.getInt("noOfReviews");
                    String roomImage = jsonObject.getString("roomImage");
                // Δημιουργία αντικειμένου Room
                    Room room = new Room(roomName, noOfPersons, area, stars, noOfReviews, roomImage);
                // Προσθήκη του Room στη λίστα
                    roomList.add(room);
                }

              reader.close();
            } 
            catch (IOException | JSONException e) {
            e.printStackTrace();
            }
        return roomList;


        }
    }