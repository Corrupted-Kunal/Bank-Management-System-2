import java.util.Scanner;

class BankAccountManagement {
    double amount = 0.0;
    long bank_number;

    void create_account() {
        bank_number = (long) (Math.random() * 9000000000L) + 1000000000L;
        System.out.println("\nYou have successfully created a new account!");
        System.out.println("Your generated bank number is: " + bank_number + "\n");
    }

    void deposit_money(double addmoney) {
        System.out.println("\nMoney worth Rs." + addmoney + " credited to your bank account!\n");
        amount += addmoney;
    }

    void withdraw_money(double removemoney) {
        if (amount == 0.0) {
            System.out.println("\nEmpty Account. Withdrawal Failed!!\n");
            return;
        } else if (removemoney > amount) {
            System.out.println("\nInsufficient funds. Withdrawal Failed!!\n");
            return;
        }

        System.out.println("\nMoney worth Rs." + removemoney + " debited from your bank account!\n");
        amount -= removemoney;
    }

    void check_account(String name, String email, long phone_no) {
        System.out.println("\nAccount Details :-\n--------------------------------\n");
        System.out.println("Name - " + name);
        System.out.println("Email - " + email);
        System.out.println("Phone number - " + phone_no);
        System.out.println("Bank number - " + bank_number);
        System.out.println("Your bank account " + bank_number + " has Rs." + amount + " amount of money.");
        System.out.println("\n--------------------------------\n");
    }

    public static void main(String[] args) {
        BankAccountManagement obj = new BankAccountManagement();
        Scanner in = new Scanner(System.in);

        String name = "", email = "";
        long phone_no = 0;
        double addmoney, removemoney;
        int choice;

        do {
            System.out.println("\n1. Create account \n2. Deposit money \n3. Withdraw money \n4. Display account \n5. Exit");
            System.out.println("\nEnter your choice between the number (1-5):");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nPlease enter your name: ");
                    name = in.nextLine();

                    System.out.println("Please enter your email id: ");
                    email = in.nextLine();

                    System.out.println("Please enter your phone number: ");
                    phone_no = in.nextLong();
                    in.nextLine();

                    obj.create_account();
                    break;

                case 2:
                    System.out.println("\nPlease enter the amount of money you want to deposit: ");
                    addmoney = in.nextDouble();
                    obj.deposit_money(addmoney);
                    break;

                case 3:
                    System.out.println("\nPlease enter the amount of money you want to withdraw: ");
                    removemoney = in.nextDouble();
                    obj.withdraw_money(removemoney);
                    break;

                case 4:
                    obj.check_account(name, email, phone_no);
                    break;

                case 5:
                    System.out.println("\nExiting...Thanks for using our Bank Management System\n");
                    break;

                default:
                    System.out.println("\nInvalid Choice!\n");
                    break;
            }
        } while (choice != 5);

        in.close();
    }
}
