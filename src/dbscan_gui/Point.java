package dbscan_gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Jonathan
 *
 */
public class Point {
    
    private final HashSet<Point> neighbours = new HashSet<Point>();
    int[] points;
    boolean visited = false;
    /**
     * @param ps
     */
    public Point(ArrayList<Integer> ps) {
        points = new int[ps.size()];
        for (int i = 0; i < points.length; i++) {
            points[i] = ps.get(i);
        }
    }
    /**
     * @param is
     */
    public Point(int... is) {
        this.points = is;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return Arrays.toString(points);
    }

    /**
     * @param p
     * @return
     */
    public double squareDistance(Point p) {
        double sum = 0;
        for (int i = 0;i < points.length;i++) {
            sum += Math.pow(points[i] - p.points[i],2);
        }
        return sum;
    }

    /**
     * @param p
     * @return
     */
    public double distance(Point p) {
        return Math.sqrt(squareDistance(p));
    }
    /**
     * @param ps
     */
    public void addNeighbours(Collection<Point> ps) {
        neighbours.addAll(ps);
        neighbours.remove(this);
    }
    /**
     * @param p
     */
    public void addNeighbour(Point p) {
        if (p != this)
            neighbours.add(p);
    }
    public void clearNeighbours() {
        neighbours.clear();
    }
    public HashSet<Point> getNeighbours() {
        return neighbours;
    }
    /**
     * @return
     */
    public int neighbourCount() {
        return neighbours.size();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Point p = new Point(2,2);
        
        Point p1 = new Point(2,2);
        System.out.print(p+"->"+p1+" ");
        System.out.println(p.distance(p1));
    }
    /**
     * 
     */
    public void printNeighbours() {
        System.out.println("Neighbours of "+this+" are: "+neighbours);
    }
}
