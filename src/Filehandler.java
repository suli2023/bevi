import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public ArrayList<Customer> readCustomers(String filename) throws FileNotFoundException {
        ArrayList<Customer> customerList = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            Customer customer = new Customer();
            customer.id = Integer.parseInt(lineArray[0]);
            customer.name = lineArray[1];
            customer.email = lineArray[2];
            customerList.add(customer);
        }
        return customerList;
    }
    public ArrayList<Incoming> readIncomings(String filename) throws FileNotFoundException {
        ArrayList<Incoming> incomingList = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            Incoming incoming = new Incoming();
            incoming.id = Integer.parseInt(lineArray[0]);
            incoming.total = Double.parseDouble(lineArray[1]);
            incoming.date = LocalDate.parse(lineArray[2]);
            incoming.source = lineArray[3];
            incoming.customerId = Integer.parseInt(lineArray[4]);
            incomingList.add(incoming);
        }
        return incomingList;    
    }
}
