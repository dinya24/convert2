package ru.geekbrains.convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        final URL url;
        int CONNECTION_TIMEOUT = 1000;
        try {

            String target = "btc-usd";
            String API = "https://api.cryptonator.com/api/ticker/";
            url = new URL(API + target);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setReadTimeout(CONNECTION_TIMEOUT);
            try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content.toString());
                System.out.println("\n");
               String Stroka = content.toString();
               String[] Mass = Stroka.split(",");
               for (int i = 0; i < Mass.length; i++){
                   System.out.println("Index: " + i + Mass[i].toString());
               }
                String[] Mass1 = Mass[2].split(":");
                for (int i = 0; i < Mass1.length; i++){
                    System.out.println("Index: " + i + Mass1[i].toString());
                }
                String Stroka1;
                Stroka1 = Mass1[1].substring(1,Mass1[1].length()-1);
                System.out.println(Stroka1);
                double price = Double.parseDouble(Stroka1);
                double amount = 0.01;
                double convert = price * amount;
                System.out.println(convert);
            } catch (final Exception ex) {
                ex.printStackTrace();
                System.out.println("");
            }













        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
