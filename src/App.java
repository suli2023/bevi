import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        if(args.length<1) {
            System.err.println("Hiba! Nem adtál paramétgert!");
            System.exit(-1);
        }
        System.out.println("fájlok adatbázisba");
        Filehandler hander = new Filehandler();
        DataService service = new DataService();

        ArrayList<Customer> customerList = hander.readCustomers(args[0]);
        ArrayList<Incoming> incomintList = hander.readIncomings(args[1]);
        
        service.insertCustomers(customerList);
        service.insertIncomings(incomintList);
    }
}
