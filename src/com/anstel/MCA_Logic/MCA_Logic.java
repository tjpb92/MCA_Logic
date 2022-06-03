package com.anstel.MCA_Logic;

import java.io.*;
import java.net.*;

/*
  Classe Java pour demander une numérotation automatique à InIn
  depuis iET/Eole2/Zephir2 au travers d'une socket vers MCA_Logic_Server_HD.

  En fonction du serveur à adresser via socket, il faut décommenter la ligne
  adéquate pour la constante HOSTNAME.

  Reference : http://www.cs.uic.edu/~troy/spring05/cs450/sockets/socket.html

 * @author Thierry Baribaud
 * @version 3.0.0
*/


public class MCA_Logic{

private static final String HOSTNAME = "10.65.62.111"; // Eole2 (production)
// private static final String HOSTNAME = "172.16.30.162"; // Zephir2 (préproduction)
private static final int PORT = 4000;

private String NoTelephone = null;
private String Login = null;
private String ClientRef = null;

public MCA_Logic(String NoTelephone, String Login, String ClientRef) {
  this.NoTelephone = NoTelephone;
  this.Login = Login;
  this.ClientRef = ClientRef;
  }

public MCA_Logic(String NoTelephone, String Login) {
  this(NoTelephone, Login, "COFELY");
  }
 
public void Run() {
  Socket EchoSocket = null;
  PrintWriter out = null;

  System.out.println("Attemping to connect to host " +
                     HOSTNAME + " on port " + PORT + ".");

  try {
    EchoSocket = new Socket(HOSTNAME, PORT);
    out = new PrintWriter(EchoSocket.getOutputStream(), true);
    out.println(NoTelephone + ";" + Login + ";" + ClientRef);
    out.close();
    EchoSocket.close();
    } catch (UnknownHostException e) {
        System.err.println("Don't know about host: " + HOSTNAME);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for "
                           + "the connection to: " + HOSTNAME);
    }
  }

public static void main(String[] Args) {

  MCA_Logic mca_Logic;

  switch (Args.length) {
	case 2: 
      mca_Logic = new MCA_Logic(Args[0], Args[1]);
      mca_Logic.Run();
	  break;  
	case 3: 
      mca_Logic = new MCA_Logic(Args[0], Args[1], Args[2]);
      mca_Logic.Run();
	  break;  
    default:
      System.out.println("Usage : java MCA_Logic no_tel login client_ref");
	  break;
	}
  }
}
