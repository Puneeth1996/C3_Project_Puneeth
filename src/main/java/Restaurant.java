import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {

        // return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE

        // Firstly lets get the curret time using the getCurrentTime()
        LocalTime current_check_time = getCurrentTime();
        // current_check_time is in between the opening and closing time
        // then we can say that the restaurant is still open else closed
        if( current_check_time.isBefore(this.closingTime)  &&  current_check_time.isAfter(this.openingTime) ){
            // This means that restaurant is still open
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isTestRestaurantOpen(LocalTime current_check_time) {
        // this function is used for TDD purpose of the is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time
        // return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE

        // Firstly lets get the curret time using the getCurrentTime()
        // LocalTime current_check_time = getCurrentTime();
        // current_check_time is in between the opening and closing time
        // then we can say that the restaurant is still open else closed
        if( current_check_time.isBefore(this.closingTime)  &&  current_check_time.isAfter(this.openingTime) ){
            // This means that restaurant is still open
            return true;
        }
        else{
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        // return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        // Puneeth
        // as the missing getMenu() had to be implemented
        // the function is just gooing to return the list of menu at the request time of operation
        // return menu;
        // String allItmes;
        // for(Item item: menu) {
        //    allItmes = allItmes + "" + item.getName() + " - " + item.getPrice() + ", ";
        // }
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
