// Kristopher Sewell
// Amrita Barua
// CE2336.002 INCLASS 2

package homework.inclass2;

//import com.sun.corba.se.spi.activation._ActivatorImplBase;

import homework.inclass2.Document;
import java.util.Formatter;

public class EMail extends Document {
  protected String _sender;
  protected String _recipient;
  protected String _title;

  public EMail(String send, String rec, String title, String doc) {
    super(doc);
    this._sender = send;
    this._recipient = rec;
    this._title = title;
  }

  public void putSender(String in) {
    this._sender = in;
  }

  public void putRecipient(String in) {
    this._recipient = in;
  }

  public void putTitle(String in) {
    this._title = in;
  }

  public String getSender() {
    return this._sender;
  }

  public String getRecipient() {
    return this._recipient;
  }

  public String getTitle() {
    return this._title;
  }

  public String toString() {
  
    String temp = "####################################################"
     + "\nSender: " + this._sender 
     + "\nRecipient: " + this._recipient
     + "\nTitle: " + this._title
     + "\n####################################################";

    return temp + super.toString();

  }
}