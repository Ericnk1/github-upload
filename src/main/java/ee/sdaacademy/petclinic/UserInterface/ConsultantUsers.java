package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.*;
import ee.sdaacademy.petclinic.repositories.ConsultantRepository;



import java.time.LocalDate;
import java.util.Scanner;

public class ConsultantUsers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the consultant repository!");
        System.out.println("Select 0 to exit ");
        System.out.println("Select 1 to add a consultant ");
        System.out.println("Select 2 to view all consultant ");
        System.out.println("Select 3 to view consultant by Id ");
        System.out.println("Select 4 to view all consultant alphabetically ");
        System.out.println("Select 5 to update consultant ");
        System.out.println("Select 6 to delete consultant ");
        System.out.println("Select 7 to delete consultant by Id ");

            Consultant consultant1 = new Consultant();
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 0:
                    System.out.println("Thank you and Good bye!");
                    return;
                case 1:
                    System.out.println("Enter consultant name: ");
                    sc.nextLine(); //Read empty line
                    String Name1 = sc.nextLine();
                    consultant1.setName(Name1);
                    ConsultantRepository.save(consultant1);
                    break;
                case 2:
                    ConsultantRepository.findAll().stream().forEach(consultant2 -> {
                        System.out.println(consultant2.getConsultantId() + " " + consultant2.getName());
                    });
                    break;
                case 3:
                    System.out.println("please enter the consultant Id ");
                    int consultantId3 = sc.nextInt();
                    ConsultantRepository.findById(consultantId3).getName();
                    System.out.println(ConsultantRepository.findById(consultantId3).getName());
                    break;
                case 4:
                    ConsultantRepository.findAllAlphabetically().stream().forEach(consultant4 -> {
                        System.out.println(consultant4.getConsultantId() + " " + consultant4.getName());
                    });
                    break;
                case 5:
                    System.out.println("Enter the consultant Id: ");
                    int consultantId5 = sc.nextInt();
                    ConsultantRepository.findById(consultantId5);
                    System.out.println(ConsultantRepository.findById(consultantId5).getName());
                    Consultant consultant5 = ConsultantRepository.findById(consultantId5);
                    //sc.nextLine(); //Read empty line
                    System.out.println("Enter the name: ");
                    sc.nextLine(); //Read empty line
                    String name5 = sc.nextLine();
                    sc.nextLine(); //Read empty line
                    consultant5.setName(name5);
                    ConsultantRepository.update(consultant5);
                    break;
                case 6:
                    ConsultantRepository.findAllAlphabetically().forEach(consultant6 -> {
                        System.out.println(consultant6.getConsultantId() + " " +consultant6.getName());
                    });
                    System.out.println("Enter the Id of the consultant to delete: ");
                    int consultantId6 = sc.nextInt();
                    Consultant consultant6 = ConsultantRepository.findById(consultantId6);
                    ConsultantRepository.deleteById(consultant6);
                    break;
                case 7:
                    System.out.println("Enter the consultant Id: ");
                    int consultantId7 = sc.nextInt();
                    Consultant consultant7 = ConsultantRepository.findById(consultantId7);
                    ConsultantRepository.deleteById(consultant7);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

}
