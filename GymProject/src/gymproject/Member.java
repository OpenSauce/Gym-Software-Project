
package gymproject;

import java.io.Serializable;

/**
 * The declaration and assignment of variable for gym members. Get and set methods to be used within classes.
 * @author Harry Clewlow, Leigh Lawley
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 19981011L;
    private String firstName, middleName, thirdName;
    private int age, expiryYearDate, expiryMonthDate, validYearDate, validMonthDate;
    private String addressOne, addressTwo, city, county, postcode;
    private String daytimeNumber, eveningNumber, mobileNumber;
    private String emailAddress;
    private String gpFirstName, gpLastName, gpAddressOne, gpAddressTwo, gpPostcode, gpNumber;
    private String gpCity, gpCounty;
    private String kinName, kinNumber;
    private String cardNumber, cardName, securityNumber, cardType;
    
    /**
     * Method assigning member detail variables.
     * @param firstName the member's first name
     * @param middleName the member's middle name
     * @param thirdName the member's surname name
     * @param age the member's age
     * @param addressOne the member's first address line
     * @param addressTwo the member's second address line
     * @param city the member's city
     * @param county the member's county
     * @param postcode the member's postcode
     * @param daytimeNumber the member's contact number 
     * @param eveningNumber the member's contact number 
     * @param mobileNumber the member's contact number 
     * @param emailAddress the member's email address
     * @param gpFirstName the member's doctor's first name
     * @param gpLastName the member's doctor's last name
     * @param gpAddressOne the member's doctor's address
     * @param gpAddressTwo the member's doctor's address
     * @param gpCity the member's doctor's city
     * @param gpCounty the member's doctor's county
     * @param gpPostcode the member's doctor's postcode
     * @param gpNumber the member's doctor's contact number
     * @param kinName the member's name of relative
     * @param kinNumber the member's relative contact number
     * @param cardName name of card holder
     * @param cardNumber the number of the card
     * @param securityNumber the security number of the card
     * @param cardType the type of card
     * @param validMonthDate the valid month of the card
     * @param validYearDate the valid year of the card
     * @param expiryMonthDate the expiry month of the card
     * @param expiryYearDate the expiry year of the card
     */
    public Member(String firstName, String middleName, String thirdName, int age,
            String addressOne, String addressTwo, String city, String county, String postcode,
            String daytimeNumber, String eveningNumber,
            String mobileNumber, String emailAddress, String gpFirstName, String gpLastName,
            String gpAddressOne, String gpAddressTwo, String gpCity,
            String gpCounty, String gpPostcode,
            String gpNumber, String kinName, String kinNumber, String cardName,
            String cardNumber, String securityNumber, String cardType,
            int validMonthDate, int validYearDate, int expiryMonthDate, int expiryYearDate) {
        
        this.firstName = firstName;
        this.middleName = middleName;
        this.thirdName = thirdName;
        this.age = age;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.daytimeNumber = daytimeNumber; 
        this.eveningNumber = eveningNumber; 
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.gpFirstName = gpFirstName;
        this.gpLastName = gpLastName;
        this.gpAddressOne = gpAddressOne;
        this.gpAddressTwo = gpAddressTwo;
        this.gpCity = gpCity;
        this.gpCounty = gpCounty;
        this.gpPostcode = gpPostcode;
        this.gpNumber = gpNumber;
        this.kinName = kinName;
        this.kinNumber = kinNumber;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.securityNumber = securityNumber;
        this.validMonthDate = validMonthDate;
        this.validYearDate = validYearDate;
        this.expiryMonthDate = expiryMonthDate;
        this.expiryYearDate = expiryYearDate;
    }
    
    private Member() { }

    /**
     * Method to returns the first address line 
     * @return 
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * Method to set address line one
     * @param addressOne 
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * Method to return second address line
     * @return 
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * Method to set second address line
     * @param addressTwo 
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    /**
     * Method to return the age
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * Method to set the age
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method to return the card holder's name
     * @return 
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Method to set the card holder's name
     * @param cardName 
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Method to return the card number
     * @return 
     */
     public String getCardNumber() {
        return cardNumber;
    }

     /**
      * Method to set the card number
      * @param cardNumber 
      */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Method to return the doctor name
     * @return 
     */
    public String getGpFirstName() {
        return gpFirstName;
    }

    /**
     * Method to set the doctor name
     * @param gpFirstName 
     */
    public void setGpFirstName(String gpFirstName) {
        this.gpFirstName = gpFirstName;
    }

    /**
     * Method to return the doctor name
     * @return 
     */
    public String getGpLastName() {
        return gpLastName;
    }
    
    /**
    * Method to set the doctor name
    * @param gpLastName 
    */
    public void setGpLastName(String gpLastName) {
        this.gpLastName = gpLastName;
    }

    /**
     * Method to return the type of card
     * @return 
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Method to set the type of card
     * @param cardType 
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * Method to return the city
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set the city
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to return the county
     * @return 
     */
    public String getCounty() {
        return county;
    }

    /**
     * Method to set the county
     * @param county 
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Method to return the day time number
     * @return 
     */
    public String getDaytimeNumber() {
        return daytimeNumber;
    }

    /**
     * Method to set the day time number
     * @param daytimeNumber 
     */
    public void setDaytimeNumber(String daytimeNumber) {
        this.daytimeNumber = daytimeNumber;
    }

    /**
     * Method to return the email addresss
     * @return 
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
    * Method to set the email address
    * @param emailAddress 
    */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    /**
     * Method to return the evening contact number
     * @return 
     */
    public String getEveningNumber() {
        return eveningNumber;
    }

    /**
     * Method to set the evening contact number
     * @param eveningNumber 
     */
    public void setEveningNumber(String eveningNumber) {
        this.eveningNumber = eveningNumber;
    }

    /**
     * Method to return the card expiry month
     * @return 
     */
    public int getExpiryMonthDate() {
        return expiryMonthDate;
    }

    /**
     * Method to set the card expiry month
     * @param expiryMonthDate 
     */
    public void setExpiryMonthDate(int expiryMonthDate) {
        this.expiryMonthDate = expiryMonthDate;
    }

    /**
     * Method to return the card expiry year
     * @return 
     */
    public int getExpiryYearDate() {
        return expiryYearDate;
    }

    /**
     * Method to set the card expiry year
     * @param expiryYearDate 
     */
    public void setExpiryYearDate(int expiryYearDate) {
        this.expiryYearDate = expiryYearDate;
    }

    /**
     * Method to return the doctor name
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }
    /**
    * Method to set the doctor name
    * @param firstName 
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to return the doctor address line one
     * @return 
     */
    public String getGpAddressOne() {
        return gpAddressOne;
    }

    /**
     * Method to set the doctor address line one
     * @param gpAddressOne 
     */
    public void setGpAddressOne(String gpAddressOne) {
        this.gpAddressOne = gpAddressOne;
    }

    /**
     * Method to return the doctor second address line
     * @return 
     */
    public String getGpAddressTwo() {
        return gpAddressTwo;
    }

    /**
     * Method to set the doctor second address line
     * @param gpAddressTwo 
     */
    public void setGpAddressTwo(String gpAddressTwo) {
        this.gpAddressTwo = gpAddressTwo;
    }

    /**
     * Method to return the doctor's city
     * @return 
     */
    public String getGpCity() {
        return gpCity;
    }

    /**
     * Method to set the doctor's city
     * @param gpCity 
     */
    public void setGpCity(String gpCity) {
        this.gpCity = gpCity;
    }

    /**
     * Method to return the doctor's county
     * @return 
     */
    public String getGpCounty() {
        return gpCounty;
    }

    /**
     * Method to set the doctor's county
     * @param gpCounty 
     */
    public void setGpCounty(String gpCounty) {
        this.gpCounty = gpCounty;
    }

    /**
     * Method to return the doctor's contact number
     * @return 
     */
    public String getGpNumber() {
        return gpNumber;
    }

    /**
     * Method to set the doctor's contact number
     * @param gpNumber 
     */
    public void setGpNumber(String gpNumber) {
        this.gpNumber = gpNumber;
    }

    
    /**
     * Method to return the doctor's postcode
     * @return 
     */
    public String getGpPostcode() {
        return gpPostcode;
    }

    /**
     * Method to set the doctor's postcode
     * @param gpPostcode 
     */
    public void setGpPostcode(String gpPostcode) {
        this.gpPostcode = gpPostcode;
    }

    /**
     * Method to return the relative's name
     * @return 
     */
    public String getKinName() {
        return kinName;
    }

    /**
     * Method to set the relative's name
     * @param kinName 
     */
    public void setKinName(String kinName) {
        this.kinName = kinName;
    }

    /**
     * Method to return the relative's contact number
     * @return 
     */
    public String getKinNumber() {
        return kinNumber;
    }

    /**
     * Method to set the relative's contact number
     * @param kinNumber 
     */
    public void setKinNumber(String kinNumber) {
        this.kinNumber = kinNumber;
    }

    /**
     * Method to return the relative's middle name
     * @return 
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Method to set the relative's middle name
     * @param middleName 
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Method to return the contact number
     * @return 
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Method to set the contact number
     * @param mobileNumber 
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Method to return the postcode
     * @return 
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Method to set the  postcode
     * @param postcode 
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Method to return the card security number
     * @return 
     */
    public String getSecurityNumber() {
        return securityNumber;
    }

    /**
     * Method to set the card security number
     * @param securityNumber 
     */
    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    /**
     * Method to return the surname
     * @return 
     */
    public String getThirdName() {
        return thirdName;
    }

    /**
     * Method to set the surname
     * @param thirdName 
     */
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    /**
     * Method to return valid card month
     * @return 
     */
    public int getValidMonthDate() {
        return validMonthDate;
    }

    /**
     * Method to set the valid card month
     * @param validMonthDate 
     */
    public void setValidMonthDate(int validMonthDate) {
        this.validMonthDate = validMonthDate;
    }

    /**
     * Method to return the valid card year
     * @return 
     */
    public int getValidYearDate() {
        return validYearDate;
    }

    /**
     * Method to set the valid card year
     * @param validYearDate 
     */
    
   
    public void setValidYearDate(int validYearDate) {
        this.validYearDate = validYearDate;
    }
    
    @Override
    /**
     * Method to return the first name and surname with a space
     */
    public String toString() {
        return "    Name: " + firstName + " " + middleName+ " " + thirdName + " - Age: " + age + " - Telephone Number: " + daytimeNumber + "    "; 
    }
}
