/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class RunSingle 
{
    String results;
    
    
    public String getProcessOutput(String fileName)
    {
        
        
        try
        {
            String folderName = fileName.substring(0, fileName.length()-16);
            
                //Choose application to run
                ProcessBuilder pb = new ProcessBuilder("java","ArrayLoops");
                
                //Set Directory
                pb.directory(new File(folderName));
                pb.redirectErrorStream(true);
                
                //Run processbuilder
                Process process = pb.start();
                
                OutputStream os = process.getOutputStream();
                InputStream is = process.getInputStream();
                
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                
                String inputLine;
                
                while ((inputLine = in.readLine()) != null) 
                {
                    System.out.println(inputLine);
                    writer.write("5");
                    writer.newLine();
                    writer.flush();
                    results = inputLine;
                }
                
                System.err.println("next one");
            }
        
        
        catch (IOException e) 
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } 

        return results;
    }
}