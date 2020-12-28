package com.solodovnikov.view;

import com.solodovnikov.controller.*;

import com.solodovnikov.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final BookingController bookingController = new BookingController();
    private final CountryController countryController = new CountryController();
    private final EmailController emailController = new EmailController();
    private final GuestController guestController = new GuestController();
    private final HotelController hotelController = new HotelController();
    private final HotelChainController hotelChainController = new HotelChainController();
    private final PassportController passportController = new PassportController();
    private final PhoneController phoneController = new PhoneController();
    private final ReviewController reviewController = new ReviewController();
    private final RoomController roomController = new RoomController();

    private final Map<String, Printable> menu;
    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public final void show() throws SQLException {
        String keyMenu = "";
        while (!keyMenu.equals("Q")) {
            displayMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                menu.get(keyMenu).print();
            } catch (Exception ignored) {

            }
        }
    }

    private void displayMenu() {
        System.out.println(" ------------------------------------------ ");
        System.out.println("|                     |                    |");
        System.out.println("|       TABLES        |       METHODS      |");
        System.out.println("|                     |                    |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("|  1 - Booking        |  1 - get all       |");
        System.out.println("|  2 - Country        |  2 - get by id     |");
        System.out.println("|  3 - Email          |  3 - create        |");
        System.out.println("|  4 - Guest          |  4 - update        |");
        System.out.println("|  5 - HotelChain     |  5 - delete        |");
        System.out.println("|  6 - Hotel          |                    |");
        System.out.println("|  7 - Passport       |                    |");
        System.out.println("|  8 - Phone          |                    |");
        System.out.println("|  9 - Review         |                    |");
        System.out.println("|  10 - Room          |                    |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("|                  Q - exit                |");
        System.out.println(" ------------------------------------------ ");
    }


    public View() {
        menu = new LinkedHashMap<>();

        // booking
        menu.put("11", this::findAllBooking);
        menu.put("12", this::findBooking);
        menu.put("13", this::createBooking);
        menu.put("14", this::updateBooking);
        menu.put("15", this::deleteBooking);

        // country
        menu.put("21", this::findAllCountry);
        menu.put("22", this::findCountry);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        // email
        menu.put("31", this::findAllEmail);
        menu.put("32", this::findEmail);
        menu.put("33", this::createEmail);
        menu.put("34", this::updateEmail);
        menu.put("35", this::deleteEmail);

        // guest
        menu.put("41", this::findAllGuest);
        menu.put("42", this::findGuest);
        menu.put("43", this::createGuest);
        menu.put("44", this::updateGuest);
        menu.put("45", this::deleteGuest);

        // hotel
        menu.put("51", this::findAllHotel);
        menu.put("52", this::findHotel);
        menu.put("53", this::createHotel);
        menu.put("54", this::updateHotel);
        menu.put("55", this::deleteHotel);

        // hotelChain
        menu.put("61", this::findAllHotelChain);
        menu.put("62", this::findHotelChain);
        menu.put("63", this::createHotelChain);
        menu.put("64", this::updateHotelChain);
        menu.put("65", this::deleteHotelChain);

        // passport
        menu.put("71", this::findAllPassport);
        menu.put("72", this::findPassport);
        menu.put("73", this::createPassport);
        menu.put("74", this::updatePassport);
        menu.put("75", this::deletePassport);

        // phone
        menu.put("81", this::findAllPhone);
        menu.put("82", this::findPhone);
        menu.put("83", this::createPhone);
        menu.put("84", this::updatePhone);
        menu.put("85", this::deletePhone);

        // review
        menu.put("91", this::findAllReview);
        menu.put("92", this::findReview);
        menu.put("93", this::createReview);
        menu.put("94", this::updateReview);
        menu.put("95", this::deleteReview);

        // room
        menu.put("101", this::findAllRoom);
        menu.put("102", this::findRoom);
        menu.put("103", this::createRoom);
        menu.put("104", this::updateRoom);
        menu.put("105", this::deleteRoom);
    }


    /*  ----- Booking -----  */

    private Booking getBookingDataByInputs() {
        System.out.println("Enter booking's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter start date: ");
        String startDate = input.next();
        System.out.println("Enter end date: ");
        String endDate = input.next();
        System.out.println("Enter end guest id: ");
        Integer guestId = input.nextInt();
        System.out.println("Enter end room id: ");
        Integer roomId = input.nextInt();
        return new Booking(id, startDate, endDate, guestId, roomId);
    }

    private void findAllBooking() throws SQLException {
        System.out.println("\nBookings:");
        System.out.println(bookingController.findAll());
    }

    private void findBooking() throws SQLException {
        System.out.println("\nEnter the ID for a booking to find");
        Integer id = input.nextInt();
        System.out.println(bookingController.find(id));
    }

    private void createBooking() throws SQLException {
        System.out.println("[Creating a booking] \n");
        Booking coachData = getBookingDataByInputs();
        bookingController.create(coachData);
        System.out.println("A new booking was been inserted into the database!");
    }

    private void updateBooking() throws SQLException {
        System.out.println("[Updating a booking] \n");
        Booking newBookingData = getBookingDataByInputs();
        bookingController.update(newBookingData.getId(), newBookingData);
        System.out.println("The booking with id " + newBookingData.getId() + " was been updated!");
    }

    private void deleteBooking() throws SQLException {
        System.out.println("[Deleting the booking] \n");
        Integer id = input.nextInt();
        bookingController.delete(id);
        System.out.println("Booking with id " + id + " was been deleted!");
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

    /*  ----- Email -----  */

    private Email getEmailDataByInputs() {
        System.out.println("Enter email's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("Enter email guest id: ");
        Integer guestId = input.nextInt();
        return new Email(id, email, guestId);
    }

    private void findAllEmail() throws SQLException {
        System.out.println("\nEmails:");
        System.out.println(emailController.findAll());
    }

    private void findEmail() throws SQLException {
        System.out.println("\nEnter the ID for a email to find");
        Integer id = input.nextInt();
        System.out.println(emailController.find(id));
    }

    private void createEmail() throws SQLException {
        System.out.println("[Creating a email] \n");
        Email emailData = getEmailDataByInputs();
        emailController.create(emailData);
        System.out.println("A new email was been inserted into the database!");
    }

    private void updateEmail() throws SQLException {
        System.out.println("[Updating a email] \n");
        Email newEmailData = getEmailDataByInputs();
        emailController.update(newEmailData.getId(), newEmailData);
        System.out.println("The email with id " + newEmailData.getId() + " was been updated!");
    }

    private void deleteEmail() throws SQLException {
        System.out.println("[Deleting the email] \n");
        Integer id = input.nextInt();
        emailController.delete(id);
        System.out.println("Email with id " + id + " was been deleted!");
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

    private Hotel getHotelDataByInputs() {
        System.out.println("Enter hotel's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter hotel chain's id: ");
        Integer hotelChainId = input.nextInt();
        System.out.println("Enter country id: ");
        Integer countryId = input.nextInt();
        System.out.println("Enter name: ");
        String name = input.next();
        return new Hotel(id, hotelChainId, countryId, name);
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

    /*  ----- HotelChain -----  */

    private HotelChain getHotelChainDataByInputs() {
        System.out.println("Enter hotel chain's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter name: ");
        String name = input.next();
        return new HotelChain(id, name);
    }

    private void findAllHotelChain() throws SQLException {
        System.out.println("\nHotel Chains:");
        System.out.println(hotelController.findAll());
    }

    private void findHotelChain() throws SQLException {
        System.out.println("\nEnter the ID for a hotel chain to find");
        Integer id = input.nextInt();
        System.out.println(hotelChainController.find(id));
    }

    private void createHotelChain() throws SQLException {
        System.out.println("[Creating a hotel chain] \n");
        HotelChain hotelChainData = getHotelChainDataByInputs();
        hotelChainController.create(hotelChainData);
        System.out.println("A new hotel was been inserted into the database!");
    }

    private void updateHotelChain() throws SQLException {
        System.out.println("[Updating a hotel chain] \n");
        HotelChain newHotelChainData = getHotelChainDataByInputs();
        hotelChainController.update(newHotelChainData.getId(), newHotelChainData);
        System.out.println("The hotel chain with id " + newHotelChainData.getId() + " was been updated!");
    }

    private void deleteHotelChain() throws SQLException {
        System.out.println("[Deleting the hotel chain] \n");
        Integer id = input.nextInt();
        hotelChainController.delete(id);
        System.out.println("Hotel chain with id " + id + " was been deleted!");
    }

    /*  ----- Passport -----  */

    private Passport getPassportDataByInputs() {
        System.out.println("Enter passport's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter code: ");
        Integer code = input.nextInt();
        System.out.println("Enter guest id: ");
        Integer guestId = input.nextInt();
        return new Passport(id, code, guestId);
    }

    private void findAllPassport() throws SQLException {
        System.out.println("\nPassports:");
        System.out.println(passportController.findAll());
    }

    private void findPassport() throws SQLException {
        System.out.println("\nEnter the ID for a passport to find");
        Integer id = input.nextInt();
        System.out.println(passportController.find(id));
    }

    private void createPassport() throws SQLException {
        System.out.println("[Creating a passport] \n");
        Passport passportData = getPassportDataByInputs();
        passportController.create(passportData);
        System.out.println("A new passport was been inserted into the database!");
    }

    private void updatePassport() throws SQLException {
        System.out.println("[Updating a passport] \n");
        Passport newPassportData = getPassportDataByInputs();
        passportController.update(newPassportData.getId(), newPassportData);
        System.out.println("The passport with id " + newPassportData.getId() + " was been updated!");
    }

    private void deletePassport() throws SQLException {
        System.out.println("[Deleting the passport] \n");
        Integer id = input.nextInt();
        passportController.delete(id);
        System.out.println("Passport with id " + id + " was been deleted!");
    }

    /*  ----- Phone -----  */

    private Phone getPhoneDataByInputs() {
        System.out.println("Enter phone's id: ");
        Integer id = input.nextInt();
        System.out.println("Enter number: ");
        String number = input.next();
        System.out.println("Enter guest id: ");
        Integer guestId = input.nextInt();
        return new Phone(id, number, guestId);
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
        System.out.println("Enter hotel id: ");
        Integer hotelId = input.nextInt();
        return new Review(id, text, date, hotelId);
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
        System.out.println("Enter hotel id: ");
        Integer hotelId = input.nextInt();
        return new Room(id, maxPersons, pricePerNight, status, hotelId);
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
