package remote.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Zodiac extends Remote
{
    String sayZodiac(int month, int day) throws RemoteException;
}

