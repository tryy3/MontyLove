package us.tryy3.montylove2.geom.direction;

import us.tryy3.montylove2.geom.Direction;
import us.tryy3.montylove2.geom.Vector;
import us.tryy3.montylove2.geom.Vector2D;

import static com.google.common.base.Preconditions.checkArgument;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateHorizontalRotation;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateYaw;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class Vector2DDirection extends AbstractDirection implements Direction
{
    private final Vector2D vector;
    private float yaw;

    public Vector2DDirection(Vector2D vector)
    {
        checkArgument(!vector.isZero(),  "Cannot create a direction with a null vector.");
        this.vector = vector.normalize();
        this.yaw = Float.NaN;
    }

    @Override
    public float getYaw()
    {
        if (Float.isNaN(yaw))
        {
            yaw = calculateYaw(vector);
        }

        return yaw;
    }

    @Override
    public float getPitch()
    {
        return 0.0f;
    }

    @Override
    public Vector2D getVector2D()
    {
        return vector;
    }

    @Override
    public Vector getVector()
    {
        return vector.to3D();
    }

    @Override
    public Direction rotate(float angle)
    {
        return calculateHorizontalRotation(this, angle);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2DDirection) {
            return vector.equals(((Vector2DDirection) obj).vector);
        }

        return super.equals(obj);
    }
}
