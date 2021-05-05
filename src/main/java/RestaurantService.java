import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) {
        // return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        // Puneeth
        // Program Flow
        // as we have the restaurantName to be found in the list of restaurants

        for(Restaurant restaurant: restaurants){
            if(restaurant.getName().equals(restaurantName))
                return restaurant;
        }
        // also we are  throwing error incase of not restaurant could be found
        return null;

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved == null)
            throw new restaurantNotFoundException(restaurantToBeRemoved.getName());
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
