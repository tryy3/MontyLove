package us.tryy3.montylove2.geom.direction;

import org.apache.commons.lang.builder.HashCodeBuilder;
import us.tryy3.montylove2.geom.Direction;

import static us.tryy3.montylove2.geom.direction.DirectionUtil.calculateRotation;

/**
 * Created by tryy3 on 2015-04-17.
 */
abstract class AbstractDirection implements Direction
{
    @Override
    public Direction rotate(float angle)
    {
        return calculateRotation(this, angle);
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(41, 19)
                .append(getYaw())
                .append(getPitch())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        if (!(obj instanceof AbstractDirection))
        {
            return false;
        }

        Direction other = (Direction) obj;
        if (getYaw() != other.getYaw())
        {
            return false;
        }
        if (getPitch() != other.getPitch())
        {
            return false;
        }

        return true;
    }

    @Override
    public String toString()
    {
        return "(Direction : " + getYaw() + ", " + getPitch() + ")";
    }
}
