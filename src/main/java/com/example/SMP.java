package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class SMP {
    public static ArrayList<Dev> developers = new ArrayList<Dev>();
    public static ArrayList<Contract> clients = new ArrayList<Contract>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("../../../resources/dev.txt"));
        Scanner comp = new Scanner(new File("../../../resources/client.txt"));
        try {
            while (scan.hasNext()) {
                int years = 0, time = 0, rate = 0;
                String[] languages;
                String name = "";
                name = scan.next();
                years = scan.nextInt();
                String lang = scan.next();
                lang = lang.substring(1, lang.length() - 1);
                int count = 1;
                String s = lang;
                while (s.contains(",")) {
                    int br = s.indexOf(",");
                    s = s.substring(br + 1);
                    count++;
                }
                languages = lang.split(",", count);
                time = scan.nextInt();
                String startDate = scan.next();
                String endDate = scan.next();
                rate = scan.nextInt();
                Dev dev = new Dev(name, years, languages, time, startDate, endDate, rate);
                // System.out.println(dev.toString());
                developers.add(dev);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(
                    "dev format name, years exp, language array, hours per day, start date, end date, rate/hr");
        }
        try {
            int id = 1;
            while (comp.hasNext()) {
                String requirements = comp.next() + " ";
                requirements = requirements.substring(1);
                while (!requirements.contains("\"")) {
                    requirements += comp.next() + " ";
                }
                requirements = requirements.substring(0, requirements.length() - 2);

                String lang = comp.next();
                lang = lang.substring(1, lang.length() - 1);
                String s = lang;
                int count = 1;
                while (s.contains(",")) {
                    int br = s.indexOf(",");
                    s = s.substring(br + 1);
                    count++;
                }
                String languages[];
                languages = lang.split(",", count);
                String startDate = comp.next();
                String endDate = comp.next();
                int rate = comp.nextInt();
                Contract contract = new Contract(id, requirements, languages, startDate, endDate, rate);
                clients.add(contract);
                id++;
                // System.out.println(contract.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("project details, language array, start date, end date, rate");
        }
        //print evaluated contracts
        //prints in order the contracts are read in with relevant developers
        eval();
    }
    public static double scoreEval(Dev dev, Contract contract){
        double rate = (contract.getMoney() - dev.getRate()) / 100.0;
        double available = 0;
        Date start = dev.start();
        Date end = dev.end();
        if (start.after(contract.start())) {
        } else {
            available += 1;
        }
        if (end.before(contract.end())) {
        } else {
            available += 1;
        }
        available += rate;
        return available;
    }
    public static void eval() {
        Dev pairs[] = new Dev[clients.size()];
        for (Contract contract : clients) {
            double temp = 0;
            for (Dev dev : developers) {
                double available = 0;
                available = scoreEval(dev, contract);
                if (available > temp) {
                    pairs[contract.getId() - 1] = dev;
                    temp = available;
                }
            }
            developers.remove(pairs[contract.getId() - 1]);
        }
        for (int i = 0; i < pairs.length; i++) {
            try{
                System.out.println(i + 1 + ": " + pairs[i].toString());
            } catch (Exception e){
                System.out.println(i + 1 + ": " + pairs[i]);
            }
        }
    }
}
