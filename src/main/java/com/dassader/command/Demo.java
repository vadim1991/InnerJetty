package com.dassader.command;

import com.sun.deploy.uitoolkit.ui.ConsoleWindow;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
