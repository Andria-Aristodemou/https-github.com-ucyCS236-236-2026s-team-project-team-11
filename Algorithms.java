


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


public class Algorithms {

    public void Aplistos_Tixaios() {

    }

    public void Aplistos_Megistis_Kalipsis() {

    }

    public void Aplistos_Elaxistou_Megethous() {

    }
//This is the algorithm which is based on the density.
    public float Aplistos_Basi_Piknotitas() {
        float density = 0;//this is going to be a float number.
        int[] Si = new int[2]; //I thought about the Si to be an array (to be easier).
        int new_uncovered_elements = 2, i, j = 0;//The uncovered will be a counter (for now).
        for (i = 0; i < Si.length; i++) { //Initializing the positions of the array. Which is going to be from the command line after.
            Si[i] = 2;
        }
//the numbers in everything are just for testing and creating the idea of how the algorithm is going to be working.
        if (Si[0] == Si[1]) {
            if (i > j) {
                density = (float) new_uncovered_elements / Si[j];
            }
        }
        return density;
    }

    public static void main(String[] args) {
        Algorithms a = new Algorithms();//Call of a non static function.
        System.out.println("The density is: " + a.Aplistos_Basi_Piknotitas()); //This is where it prints the density just for testing.

    }
}