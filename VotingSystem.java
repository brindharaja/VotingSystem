import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class votingsystem {
    public static void main(String[] args) {
        System.out.println("*************************WELCOME TO ONLINE VOTING*************************");
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
        List<String> parties = new ArrayList<>(Arrays.asList(
                "Dravida Munnetra Kazhagam", "Kongunadu Makkal Desia Katchi",
                "Indian National Congress", "Communist Party of India",
                "Communist Party of India (Marxist)", "Viduthalai Chiruthaigal Katchi",
                "Indian Union Muslim League", "Marumalarchi Dravida Munnetra Kazhagam",
                "All India Anna Dravida Munnetra Kazhagam", "Puthiya Tamilagam",
                "Social Democratic Party of India", "Desiya Murpokku Dravida Kazhagam"
        ));
        List<String> candidates = new ArrayList<>(Arrays.asList(
                "M. K. Stalin", "E. R. Eswaran", "K. Selvaperunthagai",
                "R. Mutharasan", "K. Balakrishnan", "Thol. Thirumavalavan", "K. M. Kader Mohideen", "Vaiko",
                "Edappadi K. Palaniswami", "K. Krishnasamy", "V. M. S. Mohamed Mubarak", "Premalatha Vijayakant"
        ));
        List<Voter> voters = new ArrayList<>();
        Set<Long> votedIDs = new HashSet<>();
        boolean h = true;
        while (h) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("STEP 1");
            System.out.println("1.USER\n2.ADMIN\n3.EXIT\nEnter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if(date.equals("07-11-2024")){
                        step2User(sc, arr, parties, candidates, voters, votedIDs);
                    }
                    else{
                        System.out.println("There is no election today..");
                    }
                    break;
                case 2:
                    step2Admin(sc, arr, parties, candidates, voters);
                    break;
                case 3:
                    System.out.println("--------------------------------Thank you---------------------------------");
                    h = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void step2User(Scanner sc, List<Integer> arr, List<String> parties, List<String> candidates, List<Voter> voters, Set<Long> votedIDs) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("STEP 2");
        System.out.println("FULLNAME : ");
        String va = sc.nextLine();
        System.out.println("VOTER ID (Must enter 10 digit): ");
        String vb = sc.nextLine();
        long c = Long.parseLong(vb);
        if (votedIDs.contains(c)) {
            System.out.println("You have already voted. You cannot vote again.");
            return;
        }

        if (vb.length() == 10) {
            Voter voter = new Voter(va, c);
            voters.add(voter);
            votedIDs.add(c);
            voter.display1();
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("STEP 3");
            System.out.println("LIST OF CANDIDATE AND PARTIES");
            for (int i = 0; i < parties.size(); i++) {
                System.out.println((i + 1) + "." + parties.get(i) + ": " + candidates.get(i));
            }
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            if (ch >= 1 && ch <= candidates.size()) {
                arr.set(ch - 1, arr.get(ch - 1) + 1);
                System.out.println("Your vote has been recorded successfully.");
            } else {
                System.out.println("Invalid choice! Please select a candidate within the valid range.");
            }
            System.out.println("Thank you!");
        } else {
            System.out.println("Incorrect credential");
        }

    }

    public static void step2Admin(Scanner sc, List<Integer> arr, List<String> parties, List<String> candidates, List<Voter> voters) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("STEP 2");
        boolean o = true;
        while (o) {
            System.out.println("USERNAME : ");
            String a = sc.nextLine();
            System.out.println("PASSWORD : ");
            String b = sc.nextLine();
            if (a.equals("Admin123") && b.equals("Admin123")) {
                o = false;
                Login2 login2 = new Login2(a, b, arr, parties, candidates);
                boolean g = true;
                while (g) {
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("STEP 3");
                    System.out.println("1.Candidate Details\n2.Voter Details\n3.Exit");
                    int cho = sc.nextInt();
                    switch (cho) {
                        case 1:
                            login2.display2(arr);
                            break;
                        case 2:
                            login2.display3(voters);
                            break;
                        case 3:
                            g = false;
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                }
            } else {
                System.out.println("Invalid credential..");
                System.out.println("Try again..");
            }
        }
    }
}

class Voter {
    String fname;
    long vid;

    Voter(String fname, long vid) {
        this.fname = fname;
        this.vid = vid;
    }

    void display1() {
        System.out.println("Login Successful");
        System.out.println("Welcome, " + fname + "!");
        System.out.println("You are ready to vote with Voter ID: " + vid);
    }
}

class Login2 {
    Scanner sc = new Scanner(System.in);
    String userName;
    String passWord;
    List<Integer> count;
    List<String> parties;
    List<String> candidates;

    Login2(String userName, String passWord, List<Integer> count, List<String> parties, List<String> candidates) {
        this.userName = userName;
        this.passWord = passWord;
        this.count = count;
        this.parties = parties;
        this.candidates = candidates;
    }

    void display2(List<Integer> arr) {
        boolean z = true;
        while (z) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("STEP 4");
            System.out.println("LIST OF CANDIDATE AND PARTIES");
            System.out.println("1.Show list\n2.Add candidate&parties\n3.Remove candidate&parties\n4.Back");
            int choi = 0;
            while (true) {
                System.out.println("Enter your choice:");
                try {
                    choi = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            switch (choi) {
                case 1:
                    for (int i = 0; i < parties.size(); i++) {
                        System.out.println(parties.get(i) + ": " + candidates.get(i) + " - Votes: " + arr.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Enter candidate name:");
                    String n = sc.nextLine();
                    System.out.println("Enter party name:");
                    String m = sc.nextLine();
                    candidates.add(n);
                    parties.add(m);
                    arr.add(0);
                    System.out.println("Candidate and party added successfully.");
                    break;
                case 3:
                    System.out.println("Enter candidate & parties(1-"+arr.size()+"):");
                    int index = 0;
                    while (true) {
                        try {
                            index = Integer.parseInt(sc.nextLine());
                            if (index >= 1 && index <= candidates.size()) {
                                break;
                            } else {
                                System.out.println("Invalid index. Please enter a valid index.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    String removedCandidate = candidates.remove(index - 1);
                    String removedParty = parties.remove(index - 1);
                    arr.remove(index - 1);
                    System.out.println("Candidate '" + removedCandidate + "' from party '" + removedParty + "' removed successfully.");
                    break;
                case 4:
                    z = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    void display3(List<Voter> voters) {
        System.out.println("Voter Details:");
        if(voters.size()==0){
            System.out.println("No one is Voted");
        }
        for (Voter voter : voters) {
            System.out.println("Name: " + voter.fname + ", Voter ID: " + voter.vid);
        }
    }
}