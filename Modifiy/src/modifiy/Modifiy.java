/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modifiy;



import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Modifiy {
 
    /* 
    
    To execute the NMI program, a specific format is required for input file.
    The format is like this: write the labels of the nodes belonging to the same cluster in the same line.
    
    So this method transforms the format of the file that contains the partitions generated by LFR benchmark 
    into a specific format accepted by NMI program.
            
            */
    
    public static void main(String []args){
       try
{
    

 Map<String, Set<String>> com=new HashMap<String, Set<String>>() ;
 
String s="LFRgroundTruth\\LFRpartition1.dat";
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
//nbv=1;
String ligne="";
while ((ligne = br.readLine()) != null)
{
    StringTokenizer val = new StringTokenizer(ligne," \t");
    
    String value=val.nextToken();

    while(val.hasMoreTokens()){
       //i++;
    String key=val.nextToken();
    //int key=Integer.parseInt(cle);
    //System.out.println(key+"**"+value);
    if(!com.containsKey(key)){
        Set se=new HashSet<String>();
    se.add(value);
    com.put(key, se);
   
    }
 else {
        com.get(key).add(value);
        }
    }
    
    }



PrintWriter fichout= new PrintWriter(new FileWriter("groundTruth\\groundtruth1.dat")); 
for(String k:com.keySet())
	{
		Set<String> sss=com.get(k);
		String comm="";
                		for(String ttt:sss)
		{
			//int s=vv.elementAt(ttt);
			comm=comm+ttt+" ";
		}
		fichout.println(comm);
	}
	fichout.close();
br.close();
System.out.println("Community number= "+com.size());
   }
        catch(Exception e){
System.out.println("Error "+e.getMessage());
        }
    }
}
