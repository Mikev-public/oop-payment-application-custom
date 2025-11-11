package bank_account;

// snap niet helemaal hoe ik nu eee ENUM MOET

// public class Currency {
// public enum Type {
// USD("Dollar"), JPY("Yen"), GBP("Pound"), PLN("Zloty"), EUR("Euro");

// private final String displayName;

// Type(String displayName) {
// this.displayName = displayName;
// }

// public String getDisplayName() {
// return displayName;
// }
// }
// }
public class Currency {

    private String name;
    private double amount;

    public Currency(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
