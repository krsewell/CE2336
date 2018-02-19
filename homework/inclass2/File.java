// Kristopher Sewell
// Amrita Barua
// CE2336.002 INCLASS 2


package homework.inclass2;

import homework.inclass2.Document;

public class File extends Document{
  protected String _filename;
  protected String _path;

  public File(String fileName, String pathName, String doc) {
    super(doc);
    this._filename = fileName;
    this._path = pathName;
  }

  public void putFileName(String in) {
    this._filename = in;
  }

  public void putPath(String in) {
    this._path = in;
  }

  public String getFileName() {
    return this._filename;
  }

  public String getPath() {
    return this._path;
  }

  public String toString() {
    String temp = this._path + this._filename + "\n";

    return temp + super.toString();

  }
}
