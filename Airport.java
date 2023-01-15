import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.ListIterator;
import java.io.*;

public class Airport {
    private Queue<String> takeOff;
    private Queue<String> land;
    private Stack<String> names;//for storing names
    
    public Airport(){
        takeOff = new LinkedList<>();
        land = new LinkedList<>();
        names = new Stack<>();
    }
    public void addTakeOff(String f){
        takeOff.add(f);
        System.out.println(f);
    }
    public void addLanding(String l){
        land.add(l);
        System.out.println(l);

    }
    public String handleNextAction(){
        String temp= " ";
        if(land.size() > 0){
            temp = names.push(land.remove());
            temp = temp + " is landing";
            names.add("Flight "+temp);
        }
        else if( takeOff.size()>0){
            temp =  names.push(takeOff.remove());
            temp = temp + " is taking off";
            names.add("Flight "+temp);

        }
        else{
            return "No plane is waiting to land or take-off. ";
        }
        return temp;
    }
    public String waitingPlanes(){
        if(!(takeOff.isEmpty()) && (!(land.isEmpty())) ){
            String temp =" Planes waiting to take off \n -----------------------\n" ;           
            for (String s : takeOff) {
                temp += s + " \n";
            }
            temp += "Planes waiting to Take-off : \n";
            for (String s2 : land) {
                temp += s2 + "\n";
            }
            
            return temp;
        }
        else{
            return "No plane waiting";
        }
        
    }
    public String log(){
        if(names.isEmpty()) {
            return "No activity Exist";
    }
    String result = "List of the landing/taking-off activities:\n";
    result += "-----------------------------------------\n";
    for (String string : names) {
            result+=string+"\n";
    }
    return result;
    }
    public void log(String name){
        try{
            FileOutputStream fout = new FileOutputStream(name);
            DataOutputStream dout = new DataOutputStream(fout);
        
 
            String byteRead = log();
            dout.writeUTF(byteRead);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
 
        
    }
}