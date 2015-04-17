package us.tryy3.montylove2.geom.direction;

import org.apache.commons.lang.Validate;
import us.tryy3.montylove2.geom.Vector;
import us.tryy3.montylove2.geom.Vector2D;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class Face extends AbstractDirection
{
    private static boolean done = false;

    public static void done()
    {
        done = true;
    }

    private final float yaw;
    private final float pitch;
    private final Vector vector;

    public Face(float yaw, float pitch, int x, int y, int z)
    {
        Validate.isTrue(!done);
        this.yaw = yaw;
        this.pitch = pitch;
        this.vector = new Vector(x, y, z);
    }

    @Override
    public float getYaw()
    {
        return yaw;
    }

    @Override
    public float getPitch()
    {
        return pitch;
    }

    @Override
    public Vector2D getVector2D()
    {
        return vector.to2D();
    }

    @Override
    public Vector getVector()
    {
        return vector;
    }
}
