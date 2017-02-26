package cisc235_assignment2;

/**
 * @author Michael Alarcon Student ID - 10172841 I confirm that this submission
 * is my own work and is consistent with the Queen's regulations on Academic
 * Integrity.
 */
public class Cisc235_assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
        int[] array = new int[1000];
//        int range = (1000 -1 ) + 1;
        int index = 0;
        for (int x = 0; x < 1000; x++) {
            array[x] = x;
        }
        for (int x = 0; x < 1000; x++) {
            index = (int) (Math.random() * 1000);
            rbTree.insert(array[index]);
        }
    }

}
