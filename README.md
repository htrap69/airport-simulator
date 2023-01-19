This is a Java simulation of an airport's landing and takeoff operations. It uses the following data structures:

-   `Queue` for storing incoming planes waiting to land
-   `Queue` for storing planes waiting to take off
-   `Stack` for storing the names of planes that have completed landing or taking off

Class: Airport
--------------

The `Airport` class has the following methods:

-   `addTakeOff(String f)`: adds a plane to the take off queue and prints the name of the added plane
-   `addLanding(String l)`: adds a plane to the landing queue and prints the name of the added plane
-   `handleNextAction()`: handles the next landing or takeoff operation by removing the next plane in the landing queue or takeoff queue and adding it to the names stack. Returns a string containing the name of the plane and the action ("is landing" or "is taking off").
-   `waitingPlanes()`: returns a string containing a list of planes waiting to land and planes waiting to take off.
-   `log()`: returns a string containing a log of all landing and takeoff operations stored in the names stack.
-   `log(String name)`: writes the log returned by the log() method to a file with the given name.

Example Usage
-------------
```
Airport a = new Airport();
a.addTakeOff("Delta Airlines");
a.addLanding("American Airlines");
System.out.println(a.handleNextAction()); // "American Airlines is landing"
System.out.println(a.waitingPlanes()); // "Planes waiting to take off: \nDelta Airlines\nPlanes waiting to land: \n"
System.out.println(a.log()); // "List of the landing/taking-off activities: \nFlight American Airlines is landing"
a.log("flight_log.txt"); // writes the log to a file named "flight_log.txt"
```
