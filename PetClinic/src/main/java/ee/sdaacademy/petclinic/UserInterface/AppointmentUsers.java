package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.Appointment;
import ee.sdaacademy.petclinic.models.Consultant;
import ee.sdaacademy.petclinic.models.Pet;
import ee.sdaacademy.petclinic.repositories.AppointmentRepository;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class AppointmentUsers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the appointment Repository!");
        System.out.println("Select 0 to exit ");
        System.out.println("Select 1 to add a new appointment ");
        System.out.println("Select 2 to view all appointment ");
        System.out.println("Select 3 to view appointment by Id ");
        System.out.println("Select 4 to update appointment ");
        System.out.println("Select 5 to delete appointment ");
        System.out.println("Select 6 to delete appointment by Id ");

        Appointment appointment1 = new Appointment();
        int selectedOption = sc.nextInt();
        switch (selectedOption) {
            case 0:
                System.out.println("Thank you and Good bye!");
                return;
            case 1:
                System.out.println("Enter the description: ");
                sc.nextLine(); //Read empty line
                String description1 = sc.nextLine();
                appointment1.setDescription(description1);
                //sc.nextLine(); //Read empty line
                System.out.println("Enter date as yyyy-MM-dd:");
                String date = sc.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date1=null;
                try {
                    //Parsing the String
                    date1 = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                appointment1.setDate(date1);
                System.out.println("Enter the time as hh-mm-ss:");
                String time = sc.nextLine();
                LocalTime setTime = LocalTime.parse(time);
                appointment1.setTime(setTime);
                //sc.nextLine(); //Read empty line
                System.out.println("Enter the consultant Id: ");
                int consultantId1 = sc.nextInt();
                Consultant consultant1 = new Consultant();
                consultant1.setConsultantId(consultantId1);
                appointment1.setConsultant(consultant1);
                System.out.println("Enter pet Id: ");
                //sc.nextLine(); //Read empty line
                int petId1 = sc.nextInt();
                Pet pet1 = new Pet();
                pet1.setPetId(petId1);
                appointment1.setPet(pet1);
                AppointmentRepository.save(appointment1);
                break;
            case 2:
                AppointmentRepository.findAll().stream().forEach(appointment2 -> {
                    System.out.println(appointment2.getAppointmentId() + " " + appointment2.getDescription()
                            + " " + appointment2.getDate()
                            + " " + appointment2.getTime() + " " + appointment2.getPet().getPetId());
                });
                break;
            case 3:
                System.out.println("please enter the appointment Id: ");
                int appointmentId3 = sc.nextInt();
                AppointmentRepository.findById(appointmentId3).getAppointmentId();
                AppointmentRepository.findById(appointmentId3).getDescription();
                System.out.println(AppointmentRepository.findById(appointmentId3).getAppointmentId() + " "
                        + AppointmentRepository.findById(appointmentId3).getDescription() + " " + AppointmentRepository.findById(appointmentId3).getDate()
                        + " " + AppointmentRepository.findById(appointmentId3).getTime() + " "
                        + AppointmentRepository.findById(appointmentId3).getPet().getPetId());
                break;
            case 4:
                System.out.println("Enter the appointment Id: ");
                int appointmentId4 = sc.nextInt();
                AppointmentRepository.findById(appointmentId4);
                System.out.println(AppointmentRepository.findById(appointmentId4).getDescription() +" "
                        + AppointmentRepository.findById(appointmentId4).getDate() + " " + AppointmentRepository.findById(appointmentId4).getTime()
                + " " + AppointmentRepository.findById(appointmentId4).getPet().getPetId());
                Appointment appointment4 = AppointmentRepository.findById(appointmentId4);
                System.out.println("Enter the description: ");
                sc.nextLine(); //Read empty line
                String description5 = sc.nextLine();
                appointment4.setDescription(description5);
                //sc.nextLine(); //Read empty line
                System.out.println("Enter date as yyyy-MM-dd:");
                String date4 = sc.nextLine();
                DateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
                Date date04=null;
                try {
                    //Parsing the String
                    date04= dateFormat4.parse(date4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                appointment4.setDate(date04);
                System.out.println("Enter the time as hh-mm-ss:");
                //sc.next(); //Read empty line
                String time4 = sc.nextLine();
                LocalTime setTime4 = LocalTime.parse(time4);
                appointment1.setTime(setTime4);
                //sc.next(); //Read empty line
                System.out.println("Enter the consultant Id: ");
                int consultantId4 = sc.nextInt();
                Consultant consultant4 = new Consultant();
                consultant4.setConsultantId(consultantId4);
                appointment4.setConsultant(consultant4);
                System.out.println("Enter pet Id: ");
                //sc.nextLine(); //Read empty line
                int petId4 = sc.nextInt();
                Pet pet4 = new Pet();
                pet4.setPetId(petId4);
                appointment4.setPet(pet4);
                AppointmentRepository.update(appointment4);
                break;
            case 5:
                AppointmentRepository.findAll().forEach(appointment5 -> {
                    System.out.println(appointment5.getAppointmentId() + " " + appointment5.getDescription()
                            + " " + appointment5.getDate()
                            + " " + appointment5.getTime() + " " + appointment5.getPet().getPetId());
                });
                System.out.print("Enter the Id of the appointment to delete: ");
                int appointmentId5 = sc.nextInt();
                Appointment appointment5 = AppointmentRepository.findById(appointmentId5);
                AppointmentRepository.delete(appointment5);
                break;
            case 6:
                System.out.println("Enter the appointment Id: ");
                int appointmentId6 = sc.nextInt();
                Appointment appointment6 = AppointmentRepository.findById(appointmentId6);
                AppointmentRepository.delete(appointment6);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

}
