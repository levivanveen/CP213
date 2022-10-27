package lesson09;

public class Phone {
    private String number;
    private int totalCalls;
    
    public Phone(String number) {
         this.number = number;
         totalCalls = 0;
    }
    
    public Phone(Phone phone) {
         this(phone.number);
    }
    
    public String getNumber() {
         return number;  
    }
    
    public int getTotalCalls() {
         return totalCalls;
    }
    
    public void placeCall() {
         totalCalls++;
    }
}
