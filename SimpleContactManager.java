import java.util.ArrayList;
import java.util.Scanner;

public class SimpleContactManager {
    // Store contacts as arrays of strings
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> phones = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display menu
            System.out.println("\n=== Simple Contact Manager ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add a new contact
    static void addContact() {
        System.out.println("\n=== Add New Contact ===");
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        names.add(name);
        phones.add(phone);
        emails.add(email);

        System.out.println("Contact added successfully!");
    }

    // View all contacts
    static void viewContacts() {
        System.out.println("\n=== All Contacts ===");
        
        if (names.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println("\nContact #" + (i + 1));
            System.out.println("Name: " + names.get(i));
            System.out.println("Phone: " + phones.get(i));
            System.out.println("Email: " + emails.get(i));
        }
    }

    // Update an existing contact
    static void updateContact() {
        System.out.println("\n=== Update Contact ===");
        
        if (names.isEmpty()) {
            System.out.println("No contacts to update!");
            return;
        }

        viewContacts();
        System.out.print("Enter contact number to update: ");
        
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (index >= 0 && index < names.size()) {
                System.out.print("Enter new name (or press Enter to skip): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    names.set(index, name);
                }

                System.out.print("Enter new phone (or press Enter to skip): ");
                String phone = scanner.nextLine();
                if (!phone.isEmpty()) {
                    phones.set(index, phone);
                }

                System.out.print("Enter new email (or press Enter to skip): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) {
                    emails.set(index, email);
                }

                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Invalid contact number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    // Delete a contact
    static void deleteContact() {
        System.out.println("\n=== Delete Contact ===");
        
        if (names.isEmpty()) {
            System.out.println("No contacts to delete!");
            return;
        }

        viewContacts();
        System.out.print("Enter contact number to delete: ");
        
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (index >= 0 && index < names.size()) {
                String deletedName = names.remove(index);
                phones.remove(index);
                emails.remove(index);
                System.out.println("Contact '" + deletedName + "' deleted successfully!");
            } else {
                System.out.println("Invalid contact number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }
}
