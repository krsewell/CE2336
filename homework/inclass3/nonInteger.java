// Kristopher Sewell
// Spencer Rasor
// Inclass Assignment 3

package homework.inclass3;

public class nonInteger extends Exception {
    private String _msg;

    public void nonInteger(String msg) {
        this._msg = msg;
    }

    @Override
    public String getMessage() {
        return this._msg;
    }


}