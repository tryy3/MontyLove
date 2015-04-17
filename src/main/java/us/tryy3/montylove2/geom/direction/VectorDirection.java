package us.tryy3.montylove2.geom.direction;

import static com.google.common.base.Preconditions.checkArgument;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculatePitch;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateYaw;

import us.tryy3.montylove2.geom.Direction;
import us.tryy3.montylove2.geom.Vector;
import us.tryy3.montylove2.geom.Vector2D;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class VectorDirection extends AbstractDirection implements Direction
{
    private final Vector vector;
    private float yaw;
    private float pitch;

    public VectorDirection(Vector vector)
    {
        checkArgument(!vector.isZero(), "Cannot create a direction with null vector.");
        this.vector = vector.normalize();
        this.yaw = Float.NaN;
        this.pitch = Float.NaN;
    }

    @Override
    public float getYaw()
    {
        if(Float.isNaN(yaw))
        {
            yaw = calculateYaw(vector.to2D());
        }

        return yaw;
    }

    @Override
    public float getPitch()
    {
        if(Float.isNaN(pitch))
        {
            pitch = calculatePitch(vector);
        }

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

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof VectorDirection)
        {
            return vector.equals(((VectorDirection) obj).vector);
        }

        return super.equals(obj);
    }
}
