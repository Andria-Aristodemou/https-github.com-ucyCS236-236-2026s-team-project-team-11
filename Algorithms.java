
/*
1st line of the input file (integers).
> 20 7 6 7 
    20: U(n) Is the amount of elements which U (universe/ The points of interest) we will have.
    7: m Is the amount of routers we have.
    6: c Is the maximum points of interest a router can cover.
    7: k/Coverage(k) The maximum amount of routers (k) we can have in the set of the Coverage(k).
2nd input line
    There are the elements of U.
The rest of the lines:
    are the points of interests of the m routers. Simply each of the remaining lines 
    are for each independent router the points of interest it has and can cover.
*/
import Scanner.*;
import java.util.*;

public class Algorithms {

    public void Aplistos_Tixaios() {

    }

    // This function is for the greedy with the maximum coverage.
    public float Aplistos_Megistis_Kalipsis(int Si[][], int N[], int k) {
        int i, j;

        int routers[] = new int[k];// This is going to print the answer , which is going to be which routers we
                                   // will use to cover the Universe(U).
        int elements_of_routers[] = new int[Si.length];// This is going to be the sum amount of points each router
                                                       // cover.
        for (i = 0; i < Si.length; i++) {
            for (j = 0; j < Si[i].length; j++) {
                if (Si[i][j] != -1) {
                    elements_of_routers[i]++;
                }
            }
            // sorts the sum of elemetns in order to find the greeatest.
            mergesort(elements_of_routers);

            // this is to sort it in Reverst from the greatest to the smallest.
            for (int t = 0; t < elements_of_routers.length / 2; t++) {
                int temp = elements_of_routers[t];
                elements_of_routers[t] = elements_of_routers[elements_of_routers.length - 1 - i];
                elements_of_routers[elements_of_routers.length - 1 - i] = temp;
            }

            // the for is getting the i from the above for loop (which indicated the router
            // we are in) and the j is going for all the elements of the specific router.
            for (int i2 = 0; i2 < router.length; i2++) {
                for (j = 0; j < Si[i].length; j++) {
                    routers[i2] = Si[i][j];
                    for (int i3 = 0; i3 < N.length; i3++) {
                        if (Si[i][j] == N[i3])// if there is no an element it goes to the next one. The array N[] is
                                              // sorted from the smallest to the greatest.
                            N[i3] = -1;
                    }
                }
            }
        }

    }

    public void Aplistos_Elaxistou_Megethous() {

    }

    // This is the algorithm which is based on the density. It has to calculate the
    // denstity and based on that to find the best way to cover the Universe (U).
    public float Aplistos_Basi_Piknotitas(int Si[][], int N, int k) {
        float density = 0;// This is going to be a float number.

        int new_uncovered_elements = 2, i, j = 0;// The uncovered will be a counter (for now).
        for (i = 0; i < Si.length; i++) { // Initializing the positions of the array. Which is going to be from the
                                          // command line after.
            Si[i][0] = 2;
        }
        // the numbers in everything are just for testing and creating the idea of how
        // the algorithm is going to be working.
        if (Si[0][0] == Si[1][0]) {
            if (i > j) {
                density = (float) new_uncovered_elements / Si[j][0];
            }
        }
        return density;
    }

    public static void main(String[] args) {
        // the array N is going to be the same with the U and i think is going to be
        // easier if it's sorted.
        // array N is the Universe ,the points of interest.
        // array Si[i][j] is the points of interests of router i and each j is a point
        // of interest.
        // the k is the maximum amount of routers we can have in the set of the
        // Coverage(k). Aka the length of router[].

        Algorithms a = new Algorithms();// Call of a non static function.
        Algorithms b = new Algorithms();
        Algorithms c = new Algorithms();
        Algorithms d = new Algorithms();

        // This is where it prints the density just for testing.
        System.out.println("The density algorithm Aplistos_Basi_Piknotitas is: "
                + a.Aplistos_Basi_Piknotitas(new int[2][2], 0, 0));
        System.out.println("The density algorithm Aplistos_Megistis_Kalipsis is: "
                + b.Aplistos_Megistis_Kalipsis(new int[2][2], new int[0], 0));
    }
}