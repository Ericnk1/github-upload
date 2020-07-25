package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.PetType;
import ee.sdaacademy.petclinic.repositories.PetTypeRepository;

import java.util.Scanner;

public class PetTypeUsers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to PetTypeRepository!");
        System.out.println("Select 0 to exit ");
        System.out.println("Select 1 to add a petType ");
        System.out.println("Select 2 to view all petType ");
        System.out.println("Select 3 to update petType ");
        System.out.println("Select 4 to delete petType ");
        System.out.println("Select 5 to delete petType by Id ");


        PetType petType = new PetType();
        int selectedOption = sc.nextInt();
        switch (selectedOption) {
            case 0:
                System.out.println("Thank you and Good bye!");
                return;
            case 1:
                System.out.println("Enter petType name: ");
                String Name = sc.nextLine();
                petType.setName(Name);
                PetTypeRepository.save(petType);
                break;
            case 2:
                PetTypeRepository.findAll().stream().forEach(pet2 -> {
                    System.out.println(pet2.getPetTypeId() + " " + pet2.getName());
                });
                break;
            case 3:
                System.out.println("please enter the petId ");
                int petTypeId3 = sc.nextInt();
                PetTypeRepository.findById(petTypeId3).getName();
                System.out.println(PetTypeRepository.findById(petTypeId3).getName());
                System.out.printf("Enter the new type name: ");
                sc.nextLine(); //Read empty line
                String petTypeName3 = sc.nextLine();
                PetType petType3 = PetTypeRepository.findById(petTypeId3);
                petType3.setName(petTypeName3);
                PetTypeRepository.update(petType3);
                break;
            case 4:
                PetTypeRepository.findAll().forEach(petType4 -> {
                    System.out.println(petType4.getPetTypeId() + " " + petType4.getName());
                });
                System.out.println("Enter the Id petType to delete: ");
                int petTypeId4 = sc.nextInt();
                PetType petType4 = PetTypeRepository.findById(petTypeId4);
                PetTypeRepository.deleteById(petType4);
                break;
            case 5:
                System.out.println("Enter the Id petType to delete: ");
                int petTypeId5 = sc.nextInt();
                PetType petType5 = PetTypeRepository.findById(petTypeId5);
                PetTypeRepository.deleteById(petType5);
                break;
            default:
                System.out.println("Invalid option.");
        }



    }
}
