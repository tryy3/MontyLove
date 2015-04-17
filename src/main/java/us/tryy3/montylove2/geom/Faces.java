package us.tryy3.montylove2.geom;

import us.tryy3.montylove2.geom.direction.Face;

/**
 * Created by tryy3 on 2015-04-17.
 */
public final class Faces
{
    public static final Direction UP = new Face(0.0F,180.0F,0,1,0);
    public static final Direction DOWN = new Face(0.0f,-180.0f,0,-1,0);

    public static final Direction NORTH = new Face(90.0f,0.0f,-1,0,0);
    public static final Direction EAST = new Face(180.0f,0.0f,0,0,-1);
    public static final Direction SOUTH = new Face(270.0f,0.0f,1,0,0);
    public static final Direction WEST = new Face(0.0f,0.0f,0,0,1);

    public static final Direction UP_NORTH = new Face(90.0f,90.0f,-1,1,0);
    public static final Direction UP_EAST = new Face(180.0f,90.0f,0,1,-1);
    public static final Direction UP_SOUTH = new Face(270.0f,90.0f,1,1,0);
    public static final Direction UP_WEST = new Face(0.0f,90.0f,0,1,1);

    public static final Direction DOWN_NORTH = new Face(90.0f,-90.0f,-1,-1,0);
    public static final Direction DOWN_EAST = new Face(180.0f,-90.0f,0,-1,-1);
    public static final Direction DOWN_SOUTH =  new Face(270.0f,-90.0f,1,-1,0);
    public static final Direction DOWN_WEST = new Face(0.0f,-90.0f,0,-1,1);

    public static final Direction NORTH_EAST = new Face(135.0f,0.0f,-1,0,-1);
    public static final Direction NORTH_WEST =  new Face( 45.0f,0.0f,-1,0,1);

    public static final Direction SOUTH_EAST = new Face(225.0f,0.0f,1,0,-1);
    public static final Direction SOUTH_WEST =  new Face(315.0f,0.0f,1,0,1);

    static {
        Face.done();
    }
}
