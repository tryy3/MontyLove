package us.tryy3.montylove2.gson.typeadapter;

/**
 * Created by tryy3 on 2015-04-17.
 */

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import us.tryy3.montylove2.gson.GsonLoadRuntimeException;

public class WorldTypeAdapterFactory implements TypeAdapterFactory
{
    private final boolean throwsException;

    public WorldTypeAdapterFactory()
    {
        this(true);
    }
    public WorldTypeAdapterFactory(boolean throwsException)
    {
        this.throwsException = throwsException;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, TypeToken<T> token)
    {
        if(!World.class.isAssignableFrom(token.getRawType()))
        {
            return null;
        }

        return new TypeAdapter<T>()
        {
            @Override
            public T read (JsonReader reader) throws IOException
            {
                UUID uuid = gson.fromJson(reader, UUID.class);
                World world = Bukkit.getWorld(uuid);
                if (world == null && throwsException)
                {
                    throw new GsonLoadRuntimeException("Unable to load world for uuid : " + uuid);
                }

                return (T) world;
            }

            @Override
            public void write (JsonWriter writer, T obj) throws IOException
            {
                World world = (World) obj;
                gson.toJson(world.getUID(), UUID.class, writer);
            }
        };
    }
}
