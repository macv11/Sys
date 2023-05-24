import java.util.Scanner;

class Process {
    int id, priority;
    boolean active;
}

public class BullyRingAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int n = sc.nextInt();
        Process processes[] = new Process[n];
        
        for(int i=0; i<n; i++) {
            System.out.println("Enter the priority : ");
            processes[i].id = sc.nextInt();
            processes[i].active = true;
        }
        int choice = 0;
        int pid;
        do {
            System.out.println("Enter the choice:\n1.Crash a process\n2.Restore a process\n3.Display the coordinator\n-1.Exit\n");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the id of process to crash : ");
                    pid = sc.nextInt();                    
                    break;
                case 2: 
                    System.out.println("Enter the id of process to restore : ");
                    pid = sc.nextInt();
                    break;
                case 3: 
                    for(int i=0; i<n; i++) {
                        if(processes[i].active == true) {
                            System.out.println("Coordinator is : " + processes[i].id);
                        }
                    }
                    break;

                

            }

        }while (choice != -1);


    }
}