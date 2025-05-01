package AMS;

import java.util.Date;

public class Customer {
    int userId;
    String userName;
    String password;
    long phone;
    String email;
    String address1;
    String address2;
    String city;
    String state;
    String country;
    long zipCode;
    Date dob;
    String role = "Customer";
    String userCategory = ""; // to be updated later

    public Customer(int userId, String userName, String password, long phone, String email,
                    String address1, String address2, String city, String state,
                    String country, long zipCode, Date dob) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.dob = dob;
    }

    // Getters (optional if needed elsewhere)
    public int getUserId() { return userId; }
    public String getRole() { return role; }
    public String getUserCategory() { return userCategory; }
    public String getPassword() {return password; }

    // Setters for editable fields
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setPhone(long phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress1(String address1) { this.address1 = address1; }
    public void setAddress2(String address2) { this.address2 = address2; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setCountry(String country) { this.country = country; }
    public void setZipCode(long zipCode) { this.zipCode = zipCode; }
    public void setDob(Date dob) { this.dob = dob; }

    public void displayProfile() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + userName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address1 + ", " + address2);
        System.out.println("City: " + city + ", State: " + state + ", Country: " + country);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("DOB: " + dob);
        System.out.println("Role: " + role);
        System.out.println("User Category: " + userCategory);
//        CustomerService.start();
    }
}

//public class Customer {
//    int userId;
//    String userName;
//    String password;
//    long phone;
//    String email;
//    String address1;
//    String address2;
//    String city;
//    String state;
//    String country;
//    long zipCode;
//    Date dob;
//    String role = "Customer";
//    String userCategory = ""; // to be updated later
//
//    public Customer(int userId, String userName, String password, long phone, String email,
//                    String address1, String address2, String city, String state,
//                    String country, long zipCode, Date dob) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.phone = phone;
//        this.email = email;
//        this.address1 = address1;
//        this.address2 = address2;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.zipCode = zipCode;
//        this.dob = dob;
//    }
//
//    public void displayProfile() {
//        System.out.println("User ID: " + userId);
//        System.out.println("Name: " + userName);
//        System.out.println("Phone: " + phone);
//        System.out.println("Email: " + email);
//        System.out.println("Address: " + address1 + ", " + address2);
//        System.out.println("City: " + city + ", State: " + state + ", Country: " + country);
//        System.out.println("Zip Code: " + zipCode);
//        System.out.println("DOB: " + dob);
//        System.out.println("Role: " + role);
//        System.out.println("User Category: " + userCategory);
//        CustomerService.start();
//    }
//}
