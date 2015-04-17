package us.tryy3.montylove2.gson;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class GsonLoadRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = 1513384937300289127L;

    public GsonLoadRuntimeException(Throwable throwable)
    {
        super(throwable);
    }

    public GsonLoadRuntimeException(String message)
    {
        super(message);
    }
}
