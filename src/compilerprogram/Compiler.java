/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerprogram;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author h_laessig
 */
public class Compiler 
{
    int compiled;
    
    public int testCompile(String fileName)
    {
        try 
        {       
            ProcessBuilder compiler = new ProcessBuilder("javac",fileName);
            Process runCompiler = compiler.start();

            Reader reader = new InputStreamReader(runCompiler.getInputStream());
            int ch;
            while((ch = reader.read())!= -1)
                System.out.println((char)ch);
            reader.close();

            runCompiler.waitFor();

            compiled = 1;
        } 
        
        catch (IOException e) 
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        compiled = 0;
        } 
        catch (InterruptedException e) 
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        compiled = 0;
        }
    return compiled;
    }
}
