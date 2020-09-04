package kcn.printy;

import kcn.printy.interfaces.IPresent;

public class Console implements IPresent
{

    private String prefix;
    private String postfix;
    private int lineNumber;
    private String formatString;

    private int screenWidth;

    public Console(String prefix, String postfix, String formatString, int screenWidth)
    {
        this.prefix = prefix;
        this.postfix = postfix;
        lineNumber = 0;
        this.formatString = formatString;

        this.screenWidth = screenWidth;
    }

    public Console()
    {
        setFactorySetting();
    }

    public void setFactorySetting()
    {
        prefix = "<|>";
        postfix = "<||>";
        lineNumber = 0;
        screenWidth = 120; // IDE sized factory standard
        formatString = "%-4s%-4d> %-" + screenWidth + "." + screenWidth + "s%-10s %n";
        // prefix, linenumber, string to present (cut at screenWidth length), postfix
    }

    public String getPrefix(){ return prefix; }

    public void setPrefix(String prefix){ this.prefix = prefix; }

    public String getPostfix(){ return postfix; }

    public void setPostfix(String postfix){ this.postfix = postfix; }

    public String getFormatString(){ return formatString; }

    public void setFormatString(String formatString){ this.formatString = formatString; }

    public int getScreenWidth(){ return screenWidth; }

    public void setScreenWidth(int screenWidth){ this.screenWidth = screenWidth; }

    /**
     * Method formats the supplied message string,
     * and prints it to the standard output stream
     */
    @Override
    public void present(String stringToPresent)
    {
        System.out.printf(formatString, prefix, lineNumber++, stringToPresent, postfix);
    }
}
