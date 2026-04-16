
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

    // This function is for the greedy with the maximum coverage. Takes as parameters the maximum amount of routers we can have.
    public int[] Aplistos_Megistis_Kalipsis(int Si[][], int N[], int k,int n, int c, int m) {
boolean [] covered = new boolean[n];
int [] Result = new int[k];
int countchoice = 0;
int ElementsCoveredTotal = 0 ;

while(countchoice < k && ElementsCoveredTotal < n){
    int indexSubset = -1;
    int newmaximum = 0;

    for(int i=0; i<m; i++){
        int currently = 0;
        for(int j=0; j<c; j++){
            int elements = Si[i][j];
            if(elements == 0)break;

            for(int u=0; u<n; u++){
                if(N[u] == elements && !covered[u]){
                    currently++;
                    break;
                }
            }
        }
        if(currently > newmaximum){
            newmaximum = currently;
            indexSubset = 1;
        }
    }

    if(indexSubset == -1 || newmaximum == 0) return new int[0];

    Result[countchoice++] = indexSubset;

    for(int j=0; j<c; j++){
        int elements = Si[indexSubset][j];
        for(int u =0; u<n; u++){
            if(N[u] == elements && !covered[u]){
                covered[u] = true;
                ElementsCoveredTotal++;
            }
        }
    }
}
return (ElementsCoveredTotal == n) ? Result : new int[0];
     
    }

    public void Aplistos_Elaxistou_Megethous() {

    }

    // This is the algorithm which is based on the density. It has to calculate the
    // denstity and based on that to find the best way to cover the Universe (U).
    public int[] Aplistos_Basi_Piknotitas(int Si[][], int N[], int k, int c, int n, int m) {
        
        boolean[] coveredElements  = new boolean[n];
        int[] Result = new int[k];
        int new_uncovered_elements = 0;// The uncovered will be a counter.
        int ElementsCoveredTotal = 0;

while(new_uncovered_elements < k && ElementsCoveredTotal < n){
    int indexOfSet = -1;
    double density = 0;// This is going to be a double number.

    for(int i=0; i<m; i++){
        int AnotherCount = 0;
        int TotalSubsets = 0;

        for(int j=0;j <c; j++){
            if(Si[i][j] == 0) break;
            TotalSubsets++;
            for(int u=0; u<n; u++){
                if(N[u] == Si[i][j] && !coveredElements[u]){
                    AnotherCount++;
                    break;
                }
            }
        }
if(TotalSubsets > 0){
    density = (double) AnotherCount / TotalSubsets;
    if(density > maximumdensity && AnotherCount > 0){
        maximumdensity = density;
        indexOfSet = i;
    }
}
    }

    if(indexOfSet == -1)return new int[0];

    Result[new_uncovered_elements++] = indexOfSet;
    for(int j=0; j<c; j++){
        for(int u=0; u<n; u++){
            if(N[u] == Si[indexOfSet][j] && !coveredElements[u]){
                coveredElements[u] = true;
                ElementsCoveredTotal++;
            }
        }
    }
}
return (ElementsCoveredTotal == n) ? Result : new int[0];
        
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