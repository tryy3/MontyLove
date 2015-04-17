package us.tryy3.montylove2.geom.direction;

import org.bukkit.Location;
import us.tryy3.montylove2.geom.Vector;
import us.tryy3.montylove2.geom.Vector2D;

import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateVector;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateVector2D;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class LocationDirection extends AbstractDirection
{
    private final float yaw;
    private final float pitch;
    private Vector vector;

    public LocationDirection(float yaw, float pitch)
    {
        this.yaw = yaw % 360;
        if (pitch < -180f || pitch > 180f)
        {
            throw new IllegalArgumentException("Invalid pitch");
        }
        this.pitch = pitch;
        this.vector = null;
    }

    public LocationDirection(Location location)
    {
        this(location.getYaw(), location.getPitch());
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
        return getVector().to2D();
    }

    @Override
    public Vector getVector()
    {
        if (vector == null)
        {
            Vector2D vec2D = calculateVector2D(yaw);
            vector = calculateVector(vec2D, pitch);
        }

        return vector;
    }
}
