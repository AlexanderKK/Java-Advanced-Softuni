package _06DefiningClasses._01Lab._03BankAccount;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        BiConsumer<BankAccount, String> depositConsumer = (bankAcc, input) -> {
            double amount = Double.parseDouble(input);
            //Deposit amount
            bankAcc.deposit(amount);

            System.out.printf("Deposited %.0f to ID%d%n", amount, bankAcc.ID());
        };

        BiConsumer<BankAccount, String> getInterestConsumer = (bankAcc, input) -> {
            int years = Integer.parseInt(input);
            //Get Interest
            bankAcc.getInterest(years);

            System.out.printf("%.2f%n", bankAcc.getInterest(years));
        };

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] data = command.split("\\s+");

            if(command.equals("Create")) {
                BankAccount account = new BankAccount();

                bankAccounts.put(account.ID(), account);

                System.out.printf("Account ID%d created%n", account.ID());
            } else if(command.startsWith("SetInterest")) {
                double interest = Double.parseDouble(data[1]);

                BankAccount.setInterestRate(interest);
            } else if(command.startsWith("Deposit")) {
                //Deposit
                executeOnBankAccount(data, bankAccounts, depositConsumer);
            } else if(command.startsWith("GetInterest")) {
                //Get interest
                executeOnBankAccount(data, bankAccounts, getInterestConsumer);
            }
        }
    }

    private static void executeOnBankAccount(String[] data, Map<Integer, BankAccount> bankAccounts, BiConsumer<BankAccount, String> function) {
        int id = Integer.parseInt(data[1]);
        BankAccount currentBankAccount = bankAccounts.get(id);

        if(currentBankAccount == null) {
            System.out.println("Account does not exist");
        } else {
            function.accept(currentBankAccount, data[2]);
        }
    }
}
