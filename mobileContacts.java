import java.util.Scanner;

abstract class Contact {
    private int number;
    private String name;
    private String email;

    public abstract void displayContactDetails();
    public void setContact(int number, String name, String email) {
        this.number = number;
        this.name = name;
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class PersonalContact extends Contact {
    @Override
    public void displayContactDetails() {
        System.out.println("Personal Contact: " + getName() + ", Number: " + getNumber() + ", Email: " + getEmail());
    }
}

class BusinessContact extends Contact {
    @Override
    public void displayContactDetails() {
        System.out.println("Business Contact: " + getName() + ", Number: " + getNumber() + ", Email: " + getEmail());
    }
}

class Mobile {
    private int maxContactStorage = 100;
    private Contact[] contacts = new Contact[maxContactStorage];
    private int numContacts = 0;

    public void getContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of contacts to add (max 100): ");

    
        int inputNumContacts = scanner.nextInt();
        scanner.nextLine();

        if (inputNumContacts > maxContactStorage) {
            System.out.println("Not enough space to store contcts!");
            inputNumContacts = maxContactStorage;
        }

        for (int i = 0; i < inputNumContacts; i++) {
            System.out.print("Enter Contact Type (1 for Personal, 2 for Business): ");
            int contactType = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Contact Number: ");
            int number = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Contact contact;
            if (contactType == 1) {
                contact = new PersonalContact();
            } else {
                contact = new BusinessContact();
            }

            contact.setContact(number, name, email);
            contacts[numContacts++] = contact; 
        }
    }

    public void display() {
        System.out.println("Your Contacts");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < numContacts; i++) {
            contacts[i].displayContactDetails(); 
        }
        System.out.println("----------------------------------------------------------");
    }
}

public class mobileContacts {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.getContacts();
        mobile.display();
    }
}
