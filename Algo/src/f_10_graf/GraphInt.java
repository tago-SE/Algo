package f_10_graf;

import java.util.Scanner;

/**
 *
 * @author tiago
 */
public interface GraphInt {
    public int getNumVertices();
    public boolean isDirected();
    public void loadEdgesFromFile(Scanner scan);
}
