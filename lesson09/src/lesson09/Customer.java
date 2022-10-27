package lesson09;

public class Customer {
    private String name;
    private Phone phone;
    private String address;
    
    public Customer(String name, String phoneNumber, String address) {
         this.name = name;
         phone = new Phone(phoneNumber);
         this.address = address;
    }
    
    public String toString(){
         return name + ", " + address;
    }
    
    public void placeCall() {
         phone.placeCall();
    }
    
    public Phone getPhone() { // Does it generate a privacy leak? 
         //return phone;
    	Phone temp = new Phone (phone) ; 
    	return temp ; 
    }
    
    public String getName() {  // Does it generate a privacy leak?
         return name;
    }
}
