package us.tryy3.montylove2.gson;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class GsonLoadException extends Exception
{
    private static final long serialVersionUID = 8788570984149985804L;

    public GsonLoadException(Throwable throwable)
    {
        super(throwable);
    }

    public GsonLoadException(String message)
    {
        super(message);
    }
}
