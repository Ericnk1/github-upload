package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.*;
import ee.sdaacademy.petclinic.repositories.PetRepository;
import ee.sdaacademy.petclinic.repositories.PetTypeRepository;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PetUsers {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to PetRepository!");
            System.out.println("Select 0 to exit ");
            System.out.println("Select 1 to add or register a pet ");
            System.out.println("Select 2 to view all pet ");
            System.out.println("Select 3 to view pet by Id ");
            System.out.println("Select 4 to view all alphabetically ");
            System.out.println("Select 5 to update pet ");
            System.out.println("Select 6 to delete pet ");
            System.out.println("Select 7 to delete pet by Id ");


            Pet pet = new Pet();
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 0:
                    System.out.println("Thank you and Good bye!");
                    return;
                case 1:
                    System.out.println("Enter pet name: ");
                    sc.nextLine(); //Read empty line
                    String Name = sc.nextLine();
                    pet.setName(Name);
                    System.out.println("Enter date of birth as yyyy-MM-dd:");
                    String date = sc.nextLine();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateOfBirth=null;
                    try {
                        //Parsing the String
                        dateOfBirth = dateFormat.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    pet.setDateOfBirth(dateOfBirth);
                    System.out.println("Enter petTypeId: ");
                    int petTypeId = sc.nextInt();
                    PetType petType1 = PetTypeRepository.findById(petTypeId);
                    pet.setPetType(petType1);
                    System.out.println("Enter owner Id: ");
                    //sc.nextLine(); //Read empty line
                    int ownerId = sc.nextInt();
                    Owner owner = new Owner();
                    owner.setOwnerId(ownerId);
                    pet.setOwner(owner);
                    System.out.println("Enter 1 if the pet is vaccinated and 0 if not: ");
                    int isVaccinated = sc.nextInt();
                    pet.setIsVaccinated(isVaccinated);
                    System.out.println("Enter the vet Id: ");
                    int vetId = sc.nextInt();
                    Vet vet = new Vet();
                    vet.setVetId(vetId);
                    pet.setVet(vet);
                    System.out.println("Enter the consultant Id: ");
                    int consultantId = sc.nextInt();
                    Consultant consultant = new Consultant();
                    consultant.setConsultantId(consultantId);
                    pet.setConsultant(consultant);
                    PetRepository.save(pet);
                    break;
                case 2:
                    PetRepository.findAll().stream().forEach(pet2 -> {
                        System.out.println(pet2.getName() + " " + pet2.getDateOfBirth() + " " + pet2.getPetType().getPetTypeId()
                                + " " + pet2.getOwner().getOwnerId() + " " + pet2.getIsVaccinated() + " " + pet2.getVet().getVetId() + " " +
                                pet2.getConsultant().getConsultantId());
                    });
                    break;
                case 3:
                    System.out.println("please enter the petId ");
                    int petId = sc.nextInt();
                    PetRepository.findById(petId).getName();
                    System.out.println(PetRepository.findById(petId).getName());
                    break;
                case 4:
                    PetRepository.findAllAlphabetically().stream().forEach(pet4 -> {
                        System.out.println(pet4.getName() + " " + pet4.getDateOfBirth() + " " + pet4.getPetType().getPetTypeId()
                                + " " + pet4.getOwner().getOwnerId() + " " + pet4.getIsVaccinated() + " " + pet4.getVet().getVetId()
                                + " " + pet4.getConsultant().getConsultantId());
                    });
                    break;
                case 5:
                    //PetType petType5 = new PetType();
                    System.out.println("Enter the pet Id: ");
                    int petId5 = sc.nextInt();
                    PetRepository.findById(petId5);
                    System.out.println(PetRepository.findById(petId5).getName());
                    Pet pet5 = PetRepository.findById(petId5);
                    sc.nextLine(); //Read empty line
                    System.out.println("Enter the name: ");
                    sc.nextLine(); //Read empty line
                    String name5 = sc.nextLine();
                    pet5.setName(name5);
                    System.out.println("Enter date of birth as yyyy-MM-dd:");
                    String date5 = sc.nextLine();
                    DateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateOfBirth5=null;
                    try {
                        //Parsing the String
                        dateOfBirth5 = dateFormat5.parse(date5);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    pet.setDateOfBirth(dateOfBirth5);
                    //sc.nextLine(); //Read empty line
                    System.out.println("Enter petTypeId: ");
                    int petTypeId5 = sc.nextInt();
                    //sc.nextLine(); //Read empty line
                    PetType petType5 = PetTypeRepository.findById(petTypeId5);
                    pet.setPetType(petType5);
                    System.out.println("Enter owner Id: ");
                    //sc.nextLine(); //Read empty line
                    int ownerId5 = sc.nextInt();
                    Owner owner5 = new Owner();
                    owner5.setOwnerId(ownerId5);
                    pet.setOwner(owner5);
                    System.out.println("Enter 1 if the pet is vaccinated and 0 if not: ");
                    int isVaccinated5 = sc.nextInt();
                    pet.setIsVaccinated(isVaccinated5);
                    System.out.println("Enter the vet Id: ");
                    int vetId5 = sc.nextInt();
                    Vet vet5 = new Vet();
                    vet5.setVetId(vetId5);
                    pet.setVet(vet5);
                    System.out.println("Enter the consultant Id: ");
                    int consultantId5 = sc.nextInt();
                    Consultant consultant5 = new Consultant();
                    consultant5.setConsultantId(consultantId5);
                    pet.setConsultant(consultant5);
                    PetRepository.update(pet);
                    //sc.nextLine(); //Read empty line
                    break;
                case 6:
                    PetRepository.findAllAlphabetically().forEach(pet6 -> {
                        System.out.println(pet6.getName());
                    });
                    System.out.println("Enter the Id of the pet to delete: ");
                    int petId6 = sc.nextInt();
                    Pet pet4 = PetRepository.findById(petId6);
                    PetRepository.deleteById(pet4);

                    break;
                case 7:
                    System.out.println("Enter the pet Id: ");
                    int petId7 = sc.nextInt();
                    Pet pet7 = PetRepository.findById(petId7);
                    PetRepository.deleteById(pet7);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
    }
}
