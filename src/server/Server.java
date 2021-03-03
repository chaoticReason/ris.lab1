
package server;

import remote.interfaces.Zodiac;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Zodiac
{
    public Server()
    {}
    
    public String sayZodiac(int m, int d)
    {
        String z;

        switch(m)
        {
            case 1:
                if(d<=20) z = "Козерог";
                else if(d<=31) z = "Водолей";
                else z = "Австралийский лунго";
                break;
            case 2:
                if(d<=19) z = "Водолей";
                else if(d<=29) z = "Рыбы";
                else z = "Раф";
                break;
            case 3:
                if(d<=20) z = "Рыбы";
                else if(d<=31) z = "Овен";
                else z = "Латте";
                break;
            case 4:
                if(d<=20) z = "Овен";
                else if(d<=30) z = "Телец";
                else z = "Гуру-йог-бог";
                break;
            case 5:
                if(d<=21) z = "Телец";
                else if(d<=31) z = "Близнецы";
                else z = "Мудрый уролог";
                break;
            case 6:
                if(d<=21) z = "Близнецы";
                else if(d<=30) z = "Рак";
                else z = "Персик";
                break;
            case 7:
                if(d<=22) z = "Рак";
                else if(d<=31) z = "Лев";
                else z = "Пикколо";
                break;
            case 8:
                if(d<=21) z = "Лев";
                else if(d<=31) z = "Дева";
                else z = "Доппио";
                break;
            case 9:
                if(d<=23) z = "Дева";
                else if(d<=30) z = "Весы";
                else z = "Батч брю";
                break;
            case 10:
                if(d<=23) z = "Весы";
                else if(d<=31) z = "Скорпион";
                else z = "Кемекс";
                break;
            case 11:
                if(d<=22) z = "Скорпион";
                else if(d<=30) z = "Стрелец";
                else z = "Декафф";
                break;
            case 12:
                if(d<=22) z = "Стрелец";
                else if(d<=31) z = "Козерог";
                else z = "Мокка";
                break;
            default: z = "Парабола";
        }

        return z;
    }

    public static void main(String []args)
    {
        try {
            Server obj = new Server();
            Zodiac stub =(Zodiac) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1097);
            registry.bind("Zodiac", stub);
            System.err.println("Server ready");
        }
        catch (Exception e)
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

