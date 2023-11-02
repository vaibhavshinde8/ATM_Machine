import java.util.Scanner;

class ATM {
    private BankAccount acc;
    private int pin;

    public ATM(BankAccount ac, int pin) {
        this.acc = ac;
        this.pin = pin;
    }

    public void menu() {
        System.out.println(" ATM Machine Interface ");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public boolean verifyPin(int entered_pin) {
        return this.pin == entered_pin;
    }

    public void bank_process() {
        Scanner st = new Scanner(System.in);
        int entered_pin;

        System.out.print("enter your pin: ");
        entered_pin = st.nextInt();
        if (verifyPin(entered_pin)) {
            int opt = 0;
            while (opt != 4) {
                menu();
                System.out.print("Enter your choice: ");
                opt = st.nextInt();

                switch (opt) {
                    case 1:
                        System.out.println("The remaining Balance is :" + acc.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit in the account: ");
                        double Amount_to_deposit = st.nextDouble();
                        acc.deposit_bal(Amount_to_deposit);
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw from the account: ");
                        double amount_to_withdraw = st.nextDouble();
                        acc.withdraw_bal(amount_to_withdraw);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("You have entered a wrong choice, enter a valid option.");
                }
            }
        } else {
            System.out.println("Incorrect pin ");
        }

        st.close();
    }
}

class BankAccount {
    private double bal;

    public BankAccount(double initial_Bal) {
        this.bal = initial_Bal;
    }

    public double getBalance() {
        return bal;
    }

    public void deposit_bal(double amount) {
        if (amount > 0) {
            bal += amount;
            System.out.println("The amount " + amount + " is deposited successfully.");
        } else {
            System.out.println("You cannot deposit an amount less than 0.");
        }
    }

    public void withdraw_bal(double amount) {
        if (amount > 0 && amount <= bal) {
            bal -= amount;
            System.out.println("The amount " + amount + " is withdrawn successfully.");
        } else {
            System.out.println("You do not have sufficient balance to withdraw.");
        }
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        BankAccount user_account = new BankAccount(1000.0);
        int actual_pin = 1234;
        ATM atm = new ATM(user_account, actual_pin);
        atm.bank_process();
    }
}
