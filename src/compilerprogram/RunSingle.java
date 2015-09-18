/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerprogram;
//
/**
 *
 * @author Mazayan
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class RunSingle 
{
    String results;
    
    public String getProcessOutput(String fileName)
    {
        
        try
        {
            String folderName = fileName.substring(0, fileName.length()-16);
            
            ProcessBuilder Java = new ProcessBuilder("java", "ArrayLoops");
            Java.directory(new File(folderName));
            Process runJava = Java.start();

            Java.redirectErrorStream(true);

            StringBuilder processOutput = new StringBuilder();
        

        BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(runJava.getInputStream()));
        
        String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                processOutput.append(readLine + System.lineSeparator());
            }

            runJava.waitFor();
            System.out.println(results);
            results = processOutput.toString().trim();
        }
        
        catch (IOException e) 
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } 
        catch (InterruptedException e) 
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }

        return results;
    }
}
