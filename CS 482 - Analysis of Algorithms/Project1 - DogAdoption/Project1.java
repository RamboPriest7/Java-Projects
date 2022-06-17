// Christian Jarmon
// Project 1
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;

//the function should only check if the dog will take the owner over its current one,
//that function wont run the if owner already has dogs

public class Project1 {
    // function to determine if we have to interate through all the owners again
    public static boolean owner_set(int i) {
        if (owner_tentative[i - 1][0] == -1 || owner_tentative[i - 1][1] == -1) {
            return false;
        }
        return true;
    }

    // Do all the owners have dogs?
    public static boolean all_set() {
        for (int i = 1; i <= N; i++) {
            if (!owner_set(i)) {
                return false;
            }
        }
        return true;
    }

    // If a dog has a owner already, use this function to find the position in the
    // Human's array of where this dog is.
    public static int find(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (a == b[i]) {
                return i;
            }
        }
        return -1;
    }

    // Will the dog accept?
    public static boolean dog_accept(int owner, int dog) {
        /*
         * If the owner doesn't have 2 dogs yet, the owner will add that dog.
         * If the owner does have 2 dogs this function should not be called.
         * 
         * 
         * The dog will take the owner if it doesnt already have 1 or if that dog
         * prefers @param owner over its current owner
         * 
         * if (owner_tentative[owner - 1][0] == dog || owner_tentative[owner - 1]
         * [1] ==
         * dog) {return false;}
         */
        int pref_of_poss_owner = -1, pref_of_curr_owner = -1;
        empty_o = false;
        empty_d = false;
        if (dog_tentative[dog - 1] == -1) {
            empty_d = true;
            // return true;
        }
        if (owner_tentative[owner - 1][0] == -1) {
            empty_o = true;
            dtsw = 0;
        } else if (owner_tentative[owner - 1][1] == -1) {
            empty_o = true;
            dtsw = 1;
        }
        if (empty_d) {
            return true;
        }
        int id_curr_owner = dog_tentative[dog - 1];
        for (int i = 0; i < N; i++) {
            if (dogs_desire[dog - 1][i] == id_curr_owner) {
                pref_of_curr_owner = i;
                break;
            }
        }
        // find the owner in dogs preference list
        for (int i = 0; i < N; i++) {
            if (owner == dogs_desire[dog - 1][i]) {
                pref_of_poss_owner = i;
                break;
            }
        }
        return (pref_of_poss_owner < pref_of_curr_owner);

    }

    public static void propose_dispose() {
        while (!all_set()) {
            for (int i = 1; i <= (N); i++) {
                while (!owner_set(i)) {
                    if (dog_accept(i, owners_desire[i - 1][proposal_count[i - 1]])) {

                        if (!empty_d) {

                            int prev_owner = dog_tentative[owners_desire[i - 1][proposal_count[i - 1]] - 1];
                            
                            owner_tentative[prev_owner - 1][find(owners_desire[i - 1][proposal_count[i - 1]],
                                    owner_tentative[prev_owner - 1])] = -1;

                            owner_tentative[i - 1][dtsw] = owners_desire[i - 1][proposal_count[i - 1]];

                            dog_tentative[owners_desire[i - 1][proposal_count[i - 1]] - 1] = i;

                        } else {

                            dog_tentative[owners_desire[i - 1][proposal_count[i - 1]] - 1] = i;
                            owner_tentative[i - 1][dtsw] = owners_desire[i - 1][proposal_count[i - 1]];
                        }
                        proposal_count[i - 1]++;
                        // checkCurrDogs(i);
                         debug_print();

                    } else {
                        proposal_count[i - 1]++;
                    }
                }
            }
        }
    }

    public static void debug_print(){
        for (int[] a : owner_tentative) {
             for (int b : a) {
             System.out.print(b + " ");
             }
             System.out.println();
             // System.out.println();
             }
             // System.out.println();

             for (int a : dog_tentative) {
             System.out.print(a + " ");

             // System.out.println();
             }

             System.out.println();
             System.out.println();

    }



    static int[][] owners_desire, dogs_desire, owner_tentative;
    static int[] dog_tentative, proposal_count;
    static int N, dtsw;
    static boolean empty_o = false, empty_d = false;

    public static void main(String[] args) throws IOException {
      // new StableFile(3);
        N = Integer.parseInt(Files.readAllLines(Paths.get("input.txt")).get(0));
        owners_desire = new int[N][N * 2];
        dogs_desire = new int[N * 2][N];
        owner_tentative = new int[N][2];
        dog_tentative = new int[N * 2];
        proposal_count = new int[N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(owner_tentative[i], -1);
        }

        Arrays.fill(proposal_count, 0);
        Arrays.fill(dog_tentative, -1);

        String[] vals = new String[N + (2 * N)];
        for (int i = 1; i <= (N + (2 * N)); i++) {
            vals[i - 1] = Files.readAllLines(Paths.get("input.txt")).get(i);
        }

        for (int i = 0; i < (N); i++) {
            String[] temp = new String[N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N * 2); j++) {
                owners_desire[i][j] = Integer.parseInt(temp[j]);
            }
        } // for ends

        for (int i = N; i < (N + (N * 2)); i++) {
            String[] temp = new String[N];
            temp = vals[i].split(" ");
            for (int j = 0; j < (N); j++) {
                dogs_desire[i - (N)][j] = Integer.parseInt(temp[j]);
            }
        } // for ends

        propose_dispose();

        for (int i = 0; i < N; i++) {
            System.out.print(i + 1 + ": ");
            for (int b : owner_tentative[i]) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        // for (int b : dog_tentative) {
        // System.out.print(b + " ");
        // }
        // System.out.println();
    }
}
