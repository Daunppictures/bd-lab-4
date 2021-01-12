package com.solodovnikov.view;

import com.solodovnikov.controller.*;

import com.solodovnikov.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final CountryController countryController = new CountryController();
    private final GuestController guestController = new GuestController();
    private final HotelController hotelController = new HotelController();
    private final PhoneController phoneController = new PhoneController();
    private final ReviewController reviewController = new ReviewController();
    private final RoomController roomController = new RoomController();

    private final Map<String, Printable> menu;
    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public final void show() throws SQLException {
        String keyMenu = "";
        while (!keyMenu.equals("E")) {
            displayMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                menu.get(keyMenu).print();
            } catch (Exception ignored) {

            }
        }
        System.out.println("Exit");
    }

    private void displayMenu() {
        System.out.println(" =========================================================== ");
        System.out.println("||                           MENU                          ||");
        System.out.println(" =========================================================== ");
        System.out.println("||                            ||                           ||");
        System.out.println("||            TABLES          ||           METHODS         ||");
        System.out.println("||                            ||                           ||");
        System.out.println(" =========================================================== ");
        System.out.println("||     1  - Country           ||       1 -  get all        ||");
        System.out.println("||     2  - Guest             ||       2 -  get by id      ||");
        System.out.println("||     3  - Hotel             ||       3 -  create         ||");
        System.out.println("||     4  - Phone             ||       4 -  update         ||");
        System.out.println("||     5  - Review            ||       5 -  delete         ||");
        System.out.println("||     6  - Room              ||                           ||");
        System.out.println(" =========================================================== ");
        System.out.println("||                         E - exit                        ||");
        System.out.println(" =========================================================== ");
    }


    public View() {
        menu = new LinkedHashMap<>();

        // country
        menu.put("11", this::findAllCountry);
        menu.put("12", this::findCountry);
        menu.put("13", this::createCountry);
        menu.put("14", this::updateCountry);
        menu.put("15", this::deleteCountry);


        // guest
        menu.put("21", this::findAllGuest);
        menu.put("22", this::findGuest);
        menu.put("23", this::createGuest);
        menu.put("24", this::updateGuest);
        menu.put("25", this::deleteGuest);

        // hotel
        menu.put("31", this::findAllHotel);
        menu.put("32", this::findHotel);
        menu.put("33", this::createHotel);
        menu.put("34", this::updateHotel);
        menu.put("35", this::deleteHotel);

        // phone
        menu.put("41", this::findAllPhone);
        menu.put("42", this::findPhone);
        menu.put("43", this::createPhone);
        menu.put("44", this::updatePhone);
        menu.put("45", this::deletePhone);

        // review
        menu.put("51", this::findAllReview);
        menu.put("52", this::findReview);
        menu.put("53", this::createReview);
        menu.put("54", this::updateReview);
        menu.put("55", this::deleteReview);

        // room
        menu.put("61", this::findAllRoom);
        menu.put("62", this::findRoom);
        menu.put("63", this::createRoom);
        menu.put("64", this::updateRoom);
        menu.put("65", this::deleteRoom);
    }




    /*  ----- Country -----  */

    private Country getCountryDataByInputs() {
        System.out.println("Enter country's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter country: ");
        String country = input.next();
        return new Country(id, country);
    }

    private void findAllCountry() throws SQLException {
        System.out.println("\nCountry:");
        System.out.println(countryController.findAll());
    }

    private void findCountry() throws SQLException {
        System.out.println("\nEnter the ID for a country to find");
        Integer id = input.nextInt();
        System.out.println(countryController.find(id));
    }

    private void createCountry() throws SQLException {
        System.out.println("[Creating a country] \n");
        Country countryData = getCountryDataByInputs();
        countryController.create(countryData);
        System.out.println("A new country was been inserted into the database!");
    }

    private void updateCountry() throws SQLException {
        System.out.println("[Updating a country] \n");
        Country newCountryData = getCountryDataByInputs();
        countryController.update(newCountryData.getId(), newCountryData);
        System.out.println("The country with id " + newCountryData.getId() + " was been updated!");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("[Deleting the country] \n");
        Integer id = input.nextInt();
        countryController.delete(id);
        System.out.println("Country with id " + id + " was been deleted!");
    }



    /*  ----- Guest -----  */

    private Guest getGuestDataByInputs() {
        System.out.println("Enter guest's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter first name: ");
        String firstname = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter state of account: ");
        Integer stateOfAccount = input.nextInt();
        return new Guest(id, firstname, lastName, stateOfAccount);
    }

    private void findAllGuest() throws SQLException {
        System.out.println("\nGuests:");
        System.out.println(guestController.findAll());
    }

    private void findGuest() throws SQLException {
        System.out.println("\nEnter the ID for a guest to find");
        Integer id = input.nextInt();
        System.out.println(guestController.find(id));
    }

    private void createGuest() throws SQLException {
        System.out.println("[Creating a guest] \n");
        Guest guestData = getGuestDataByInputs();
        guestController.create(guestData);
        System.out.println("A new guest was been inserted into the database!");
    }

    private void updateGuest() throws SQLException {
        System.out.println("[Updating a guest] \n");
        Guest newGuestData = getGuestDataByInputs();
        guestController.update(newGuestData.getId(), newGuestData);
        System.out.println("The guest with id " + newGuestData.getId() + " was been updated!");
    }

    private void deleteGuest() throws SQLException {
        System.out.println("[Deleting the guest] \n");
        Integer id = input.nextInt();
        guestController.delete(id);
        System.out.println("Guest with id " + id + " was been deleted!");
    }

    /*  ----- Hotel -----  */

    private Hotel getHotelDataByInputs() throws SQLException {
        System.out.println("Enter hotel's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter name: ");
        String name = input.next();
        System.out.println("Enter review id: ");
        Integer review_id = input.nextInt();
        Review review = reviewController.find(review_id);
        System.out.println("Enter country id: ");
        Integer country_id = input.nextInt();
        Country country = countryController.find(country_id);
        return new Hotel(id, name, review, country);
    }

    private void findAllHotel() throws SQLException {
        System.out.println("\nHotels:");
        System.out.println(hotelController.findAll());
    }

    private void findHotel() throws SQLException {
        System.out.println("\nEnter the ID for a hotel to find");
        Integer id = input.nextInt();
        System.out.println(hotelController.find(id));
    }

    private void createHotel() throws SQLException {
        System.out.println("[Creating a hotel] \n");
        Hotel hotelData = getHotelDataByInputs();
        hotelController.create(hotelData);
        System.out.println("A new hotel was been inserted into the database!");
    }

    private void updateHotel() throws SQLException {
        System.out.println("[Updating a hotel] \n");
        Hotel newHotelData = getHotelDataByInputs();
        hotelController.update(newHotelData.getId(), newHotelData);
        System.out.println("The hotel with id " + newHotelData.getId() + " was been updated!");
    }

    private void deleteHotel() throws SQLException {
        System.out.println("[Deleting the hotel] \n");
        Integer id = input.nextInt();
        hotelController.delete(id);
        System.out.println("Hotel with id " + id + " was been deleted!");
    }



    /*  ----- Phone -----  */

    private Phone getPhoneDataByInputs() {
        System.out.println("Enter phone's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter number: ");
        String number = input.next();
        return new Phone(id, number);
    }

    private void findAllPhone() throws SQLException {
        System.out.println("\nPhones:");
        System.out.println(phoneController.findAll());
    }

    private void findPhone() throws SQLException {
        System.out.println("\nEnter the ID for a phone to find");
        Integer id = input.nextInt();
        System.out.println(phoneController.find(id));
    }

    private void createPhone() throws SQLException {
        System.out.println("[Creating a phone] \n");
        Phone phoneData = getPhoneDataByInputs();
        phoneController.create(phoneData);
        System.out.println("A new phone was been inserted into the database!");
    }

    private void updatePhone() throws SQLException {
        System.out.println("[Updating a phone] \n");
        Phone newPhoneData = getPhoneDataByInputs();
        phoneController.update(newPhoneData.getId(), newPhoneData);
        System.out.println("The phone with id " + newPhoneData.getId() + " was been updated!");
    }

    private void deletePhone() throws SQLException {
        System.out.println("[Deleting the phone] \n");
        Integer id = input.nextInt();
        phoneController.delete(id);
        System.out.println("Phone with id " + id + " was been deleted!");
    }

    /*  ----- Review -----  */

    private Review getReviewDataByInputs() {
        System.out.println("Enter review's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter text: ");
        String text = input.next();
        System.out.println("Enter date: ");
        String date = input.next();
        return new Review(id, text, date);
    }

    private void findAllReview() throws SQLException {
        System.out.println("\nReviews:");
        System.out.println(reviewController.findAll());
    }

    private void findReview() throws SQLException {
        System.out.println("\nEnter the ID for a review to find");
        Integer id = input.nextInt();
        System.out.println(reviewController.find(id));
    }

    private void createReview() throws SQLException {
        System.out.println("[Creating a review] \n");
        Review reviewData = getReviewDataByInputs();
        reviewController.create(reviewData);
        System.out.println("A new review was been inserted into the database!");
    }

    private void updateReview() throws SQLException {
        System.out.println("[Updating a review] \n");
        Review newReviewData = getReviewDataByInputs();
        reviewController.update(newReviewData.getId(), newReviewData);
        System.out.println("The review with id " + newReviewData.getId() + " was been updated!");
    }

    private void deleteReview() throws SQLException {
        System.out.println("[Deleting the review] \n");
        Integer id = input.nextInt();
        reviewController.delete(id);
        System.out.println("Review with id " + id + " was been deleted!");
    }

    /*  ----- Room -----  */

    private Room getRoomDataByInputs() {
        System.out.println("Enter room's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter max persons: ");
        Integer maxPersons = input.nextInt();
        System.out.println("Enter price per night: ");
        Integer pricePerNight = input.nextInt();
        System.out.println("Enter status: ");
        Integer status = input.nextInt();
        return new Room(id, maxPersons, pricePerNight, status);
    }

    private void findAllRoom() throws SQLException {
        System.out.println("\nRooms:");
        System.out.println(roomController.findAll());
    }

    private void findRoom() throws SQLException {
        System.out.println("\nEnter the ID for a room to find");
        Integer id = input.nextInt();
        System.out.println(roomController.find(id));
    }

    private void createRoom() throws SQLException {
        System.out.println("[Creating a room] \n");
        Room roomData = getRoomDataByInputs();
        roomController.create(roomData);
        System.out.println("A new room was been inserted into the database!");
    }

    private void updateRoom() throws SQLException {
        System.out.println("[Updating a room] \n");
        Room newRoomData = getRoomDataByInputs();
        roomController.update(newRoomData.getId(), newRoomData);
        System.out.println("The room with id " + newRoomData.getId() + " was been updated!");
    }

    private void deleteRoom() throws SQLException {
        System.out.println("[Deleting the room] \n");
        Integer id = input.nextInt();
        roomController.delete(id);
        System.out.println("Room with id " + id + " was been deleted!");
    }
}