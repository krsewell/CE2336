// Kristopher Sewell
// Amrita Barua
// CE2336.002 INCLASS 2

package homework.inclass2;

public class Document {
  protected String _content;



  public Document(String in) {
    this._content = in;
  }

  public String toString() {
    return this._content;
  }

  public void putContent(String in) {
    this._content = in;
  }
}

