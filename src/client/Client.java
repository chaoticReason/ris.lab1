package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remote.interfaces.Zodiac;

public class Client
{
    private Client()
    {}
    public static void main(String[] args)
    {
        //String host = (args.length < 1) ? null : args[0];
        int port = (args.length < 1) ? 0 : Integer.parseInt(args[0]);
        String date = (args.length < 2) ? "01.01" : args[1];
        try {
            Registry registry = LocateRegistry.getRegistry(port);

            Zodiac stub = (Zodiac) registry.lookup("Zodiac");

            int d = Integer.parseInt(date.split("\\.")[0]);
            int m = Integer.parseInt(date.split("\\.")[1]);

            System.out.println("date: " + date);
            String response = stub.sayZodiac(m,d);
            System.out.println("response zodiac: " + response);

        }
        catch (Exception e)
        {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
