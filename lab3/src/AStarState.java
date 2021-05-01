import java.util.ArrayList;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState {
    public java.util.HashMap<Location, Waypoint> open = new java.util.HashMap<>();
    public java.util.HashMap<Location, Waypoint> closed = new java.util.HashMap<>();


    /**
     * This is a reference to the map that the A* algorithm is navigating.
     **/
    private Map2D map;


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /**
     * Returns the map that the A* pathfinder is navigating.
     **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
//    public Waypoint getMinOpenWaypoint()
//    {
//        float min= Float.POSITIVE_INFINITY;
//        Waypoint value=null;
//        for (Waypoint x : open.values()) {
//            if (x.getTotalCost()<min) {
//                min = x.getTotalCost();
//                value = x;
//            }
//        }
//        return value;
//    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
//    public boolean addOpenWaypoint(Waypoint newWP)
//    {
//       if(open.containsKey(newWP.loc))
//       {
//            if(newWP.getPreviousCost()<open.get(newWP.loc).getPreviousCost()) {
//                open.put(newWP.loc, newWP);
//                return true;
//            }
//       }
//       else {
//           open.put(newWP.loc, newWP);
//           return true;
//            }
//
//        return false;
//    }


    /**
     * Returns the current number of open waypoints.
     **/
    public int numOpenWaypoints() {
        return open.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc) {
        closed.put(loc, open.remove(loc));
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc) {
        return closed.containsKey(loc);
    }


    public Waypoint getMinOpenWaypoint() {
        if (open.size() == 0) return null;

        ArrayList<Waypoint> waypoints = new ArrayList<>(open.values());
        double minCost = waypoints.get(0).getTotalCost();
        Waypoint minWaypoint = waypoints.get(0);
        int length = waypoints.size();

        for (int i = 0; i < length; i++) {
            if (waypoints.get(i).getTotalCost() < minCost) {
                minWaypoint = waypoints.get(i);
                minCost = minWaypoint.getTotalCost();
            }
        }

        return minWaypoint;
    }

    public boolean addOpenWaypoint(Waypoint newWP) {
        if (open.get(newWP.getLocation()) == null) {
            open.put(newWP.getLocation(), newWP);
            return false;
        } else {
            if (open.get(newWP.getLocation()).getPreviousCost() > newWP.getPreviousCost()) {
                open.put(newWP.getLocation(), newWP);
                return true;
            }
        }

        return false;
    }
}