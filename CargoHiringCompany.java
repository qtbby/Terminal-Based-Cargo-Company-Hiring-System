/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class CargoHiringCompany {

    private static String[] position = {};
    private static String[] applicantNames = {};
    private static String[] applicantPositions = {};
    
    // COMPANY INFORMATION
    void Info(){
        System.out.println("Owner Name: Al Albit");
        System.out.println("");
        
        System.out.println("ABOUT ALCAR CARGO COMPANY");
        System.out.println("==================================================");
        System.out.println("ALCAR Cargo Company is a trusted cargo and logistics");
        System.out.println("company committed to providing reliable, efficient,");
        System.out.println("and customer-focused delivery services.");
        System.out.println();
        System.out.println("Established in 2016, our company has been doing");
        System.out.println("business for years, serving customers with dedication");
        System.out.println("and commitment.");
        System.out.println();
        System.out.println("We strive to make cargo transportation easier, safer,");
        System.out.println("and more convenient for our clients. Every shipment");
        System.out.println("is handled with care, responsibility, and professionalism.");
        System.out.println();
        System.out.println("ALCAR Cargo Company continues to provide dependable");
        System.out.println("service and meet the logistics needs of our customers.");
        System.out.println();
        System.out.println("ALCAR Cargo Company");
        System.out.println("Serving Your Cargo Needs Since 2016");
    }
   
    // HOW HIRING WORKS
    public void hiring(){
        Scanner hiringIn = new Scanner(System.in);
        boolean hiring = false;

        System.out.println("<< 1 >> Create a new Position");
        System.out.println("<< 2 >> Hire Somebody");
        int hiringSelect = readInt(hiringIn, "Choose an option: ", 1, 2);
        
        if (hiringSelect == 1){
            
            System.out.println("<< View Current Position >> ");
            if (position.length == 0){
                System.out.println("Please add position: ");
                String addPosition = hiringIn.nextLine();
                position = new String[]{addPosition};
                while(!hiring){
                    System.out.println("Do you want to add another position? (yes/no)");
                    String addAnother = hiringIn.nextLine();
                    if (addAnother.equalsIgnoreCase("yes") || addAnother.equalsIgnoreCase("y")){
                        System.out.println("Please add position: ");
                        String addPosition2 = hiringIn.nextLine();
                        String[] newPosition = new String[position.length + 1];
                        System.arraycopy(position, 0, newPosition, 0, position.length);
                        newPosition[newPosition.length - 1] = addPosition2;
                        position = newPosition;
                    } else if (addAnother.equalsIgnoreCase("no") || addAnother.equalsIgnoreCase("n")){
                        hiring = true;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes/y' or 'no/n'.");
                    }
                }
            } else {
                for (String currentPosition : position){
                    System.out.println("This is the Current Position: " + currentPosition);
                }
            }
            
        } if (hiringSelect ==  2){

            // Admin Hire Applicants
            while(!hiring){
                System.out.println("Do you want to hire an applicant? (yes/no)");
                String hireApplicant = hiringIn.nextLine();
                if (hireApplicant.equalsIgnoreCase("yes") || hireApplicant.equalsIgnoreCase("y")){
                    if (applicantNames.length == 0) {
                        System.out.println("No applicants available to hire.");
                        break;
                    }
                    System.out.println("Applicants:");
                    for (int i = 0; i < applicantNames.length; i++) {
                        System.out.println((i + 1) + ". " + applicantNames[i] + " - " + applicantPositions[i]);
                    }
                    System.out.println("Enter the number of the applicant you want to hire: ");
                    int selectedApplicantIndex = readInt(hiringIn, "Choose an applicant: ", 1, applicantNames.length);
                    String hiredApplicantName = applicantNames[selectedApplicantIndex - 1];
                    String hiredApplicantPosition = applicantPositions[selectedApplicantIndex - 1];
                    System.out.println("You have hired " + hiredApplicantName + " for the position of " + hiredApplicantPosition + ".");
                    
                    // Remove hired applicant from the list
                    String[] newApplicantNames = new String[applicantNames.length - 1];
                    String[] newApplicantPositions = new String[applicantPositions.length - 1];
                    for (int i = 0, j = 0; i < applicantNames.length; i++) {
                        if (i != selectedApplicantIndex - 1) {
                            newApplicantNames[j] = applicantNames[i];
                            newApplicantPositions[j] = applicantPositions[i];
                            j++;
                        }
                    }
                    applicantNames = newApplicantNames;
                    applicantPositions = newApplicantPositions;
                } else if (hireApplicant.equalsIgnoreCase("no") || hireApplicant.equalsIgnoreCase("n")){
                    hiring = true;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }

            System.out.println("Applicants");
            if (applicantNames.length == 0) {
                System.out.println("No applicants yet.");
            } else {
                for (int i = 0; i < applicantNames.length; i++) {
                    System.out.println("Applicant " + (i + 1));
                    System.out.println("Name: " + applicantNames[i]);
                    System.out.println("Position: " + applicantPositions[i]);
                    System.out.println();
                }
            }
        }
        
    }
    
    // THIS IS THE LOGIN PAGE FOR THE OWNER
    private void owner(){
        CargoHiringCompany ownerMethod = new CargoHiringCompany();
        Scanner adminIn = new Scanner(System.in);
        
        String user = "Admin"; // Set your desired username here
        String password = ""; // Set your desired password here

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Username: ");
            String ownerUsername = adminIn.nextLine();
            System.out.println("Enter Password: ");
            String ownerPassword = adminIn.nextLine();

            if (ownerUsername.equals(user) && ownerPassword.equals(password)) {
                loggedIn = true;
                ownerMethod.hiring();
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        
    }

    // APPLICANT PAGE
    public void applicants(){
        
        Scanner aplicantIn = new Scanner(System.in);

        System.out.println("Apply Now!");
        System.out.println("Press Q to quit the application process.");
        if (position.length == 0) {
            System.out.println("No positions are available right now.");
            return;
        }

        System.out.println("Available Positions: " + String.join(", ", position));
        System.out.println("");

        System.out.println("Enter the number of the position you want to apply for: ");
        for (int i = 0; i < position.length; i++) {
            System.out.println("Position " + (i + 1) + ": " + position[i]);
        }
        int selectedPositionIndex = readInt(aplicantIn, "Choose a position: ", 1, position.length);

        System.out.println("Enter your name: ");
        String name = aplicantIn.nextLine();
        String selectedPosition = position[selectedPositionIndex - 1];

        applicantNames = Arrays.copyOf(applicantNames, applicantNames.length + 1);
        applicantPositions = Arrays.copyOf(applicantPositions, applicantPositions.length + 1);

        int newApplicantIndex = applicantNames.length - 1;
        applicantNames[newApplicantIndex] = name;
        applicantPositions[newApplicantIndex] = selectedPosition;

        System.out.println("Thank you, " + name + ". Your application for '"
            + selectedPosition + "' has been submitted.");
    }
    
    
    // MAIN METHOD
    public static void main(String[] args) {
        
        CargoHiringCompany myMethod = new CargoHiringCompany();
        boolean start = false;
        Scanner input = new Scanner(System.in);
        
        while(!start){
            System.out.println("******* ALCAR CARGO COMPANY *******");
            System.err.println("******* Doing Business Since 2016 *******");
            System.out.println("Copy Rights @2016");

            System.out.println("");
            System.out.println("Welcome User!");
            System.out.println("Please Login!");
            System.out.println("<< 1 >> Admin/Owner");
            System.out.println("<< 2 >> Applicant");
            System.out.println("<< 3 >> About Us!");
            int select = readInt(input, "Choose an option: ", 1, 3);


            if (select == 1){
                myMethod.owner();
                start = false;
            }if(select == 2){
                myMethod.applicants();
                start = false;
            }if(select == 3){
                myMethod.Info();
            }
        }
        
         
    }

    private static int readInt(Scanner scanner, String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(value);
                if (number >= minimum && number <= maximum) {
                    return number;
                }
            } catch (NumberFormatException exception) {
                // The message below handles both text and out-of-range numbers.
            }
            System.out.println("Invalid input. Please enter a number from "
                    + minimum + " to " + maximum + ".");
        }
    }
}


// Dear Stranger, if you are reading this code, I want to say that I am sorry for any inconvenience caused by my code
// I hope you can understand that I am just a beginner and still learning.
// Please feel free to reach out to me if you have any questions or suggestions.
// Thank you for your time and understanding.

// I am really thankful that you took the time to read my code. I hope you can see the effort and dedication I put into it,
// even if it may not be perfect. I am always open to feedback and willing to learn from others.

// sincerely,
// @qtbby
