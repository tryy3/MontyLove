package us.tryy3.montylove2.geom.direction;

import us.tryy3.montylove2.geom.Direction;
import us.tryy3.montylove2.geom.Vector;
import us.tryy3.montylove2.geom.Vector2D;

import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateHorizontalRotation;
import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateVector2D;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class HorizontalDirection extends AbstractDirection
{
    protected final float yaw;
    private Vector2D vector;

    public HorizontalDirection(float yaw)
    {
        this.yaw = yaw % 360;
        this.vector = null;
    }

    public float getYaw()
    {
        return yaw;
    }

    @Override
    public float getPitch()
    {
        return 0.0f;
    }

    public Vector2D getVector2D()
    {
        if (vector == null)
        {
            vector = calculateVector2D(yaw);
        }

        return vector;
    }

    @Override
    public Vector getVector()
    {
        return getVector2D().to3D();
    }

    @Override
    public Direction rotate(float angle)
    {
        return calculateHorizontalRotation(this, angle);
    }
}
