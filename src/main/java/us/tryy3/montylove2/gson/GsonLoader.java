package us.tryy3.montylove2.gson;

import com.google.common.base.Charsets;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;

/**
 *
 * @desc Gson class to simplify and handle
 * Json files easier using {@link Gson}
 *
 */
public class GsonLoader
{
    private final Gson gson;
    private final Plugin plugin;

    /**
     *
     * @desc Constructor of GsonLoader
     *
     * @param gson      The Gson instance.
     * @param plugin    The Plugin instance.
     *
     * @return null
     */
    public GsonLoader(Gson gson, Plugin plugin)
    {
        this.gson = gson;
        this.plugin = plugin;
    }

    /**
     *
     * @desc Get the json file.
     *
     * @param filename      The path or the name of the file.
     *
     * @return File         The loaded json file.
     *
     * @throws GsonLoadException
     */

    private File getFile(String filename) throws GsonLoadException
    {
        File file = new File(plugin.getDataFolder(), filename);
        File folder = file.getParentFile();
        if (!file.exists() && !folder.exists() && !folder.mkdirs())
        {
            throw new GsonLoadException("Unable to create directory : " + plugin.getDataFolder().getPath());
        }

        return file;
    }

    /**
     * @desc Load and if file don't exists, create a new json file.
     *
     * @param filename      The path or the name of the file.
     * @param klass
     * @param <T>
     * @return
     * @throws GsonLoadException
     */
    public <T> T loadOrCreate(String filename, Class<T> klass) throws GsonLoadException
    {
        return loadOrCreate(filename, klass, klass);
    }
    public <T> T loadOrCreate(String filename, TypeToken<T> typeToken) throws GsonLoadException
    {
        return (T) loadOrCreate(filename, typeToken.getType(), typeToken.getRawType());
    }
    public <T> T loadOrCreate(String filename, Type type, Class<T> klass) throws GsonLoadException
    {
        try
        {
            File file = getFile(filename);
            T instance;
            if (file.createNewFile())
            {
                instance = klass.newInstance();
            }
            else
            {
                instance = unsafeLoad(file, type);
            }

            write(file, instance);

            return instance;
        }
        catch (IOException exc)
        {
            throw new GsonLoadException(exc);
        }
        catch (InstantiationException exc)
        {
            throw new GsonLoadException(exc);
        }
        catch (IllegalAccessException exc)
        {
            throw new GsonLoadException(exc);
        }
    }

    public <T> T load(File file, Type klass) throws GsonLoadException
    {
        try
        {
            return unsafeLoad(file, klass);
        }
        catch (IOException exc)
        {
            throw new GsonLoadException(exc);
        }
    }
    public <T> T load(File file, TypeToken<T> typeToken) throws GsonLoadException
    {
        try
        {
            return unsafeLoad(file, typeToken.getRawType());
        }
        catch (IOException exc)
        {
            throw new GsonLoadException(exc);
        }
    }

    private <T> T unsafeLoad(File file, Type klass) throws IOException
    {
        InputStreamReader isr = new InputStreamReader( new FileInputStream(file), Charsets.UTF_8);
        JsonReader reader = new JsonReader(isr);

        try
        {
            return gson.fromJson(reader, klass);
        }
        finally
        {
            reader.close();
        }
    }

    public void write(String filename, Object instance) throws GsonLoadException
    {
        try
        {
            write(getFile(filename), instance);
        }
        catch (IOException exc)
        {
            throw new GsonLoadException(exc);
        }
    }
    private void write(File file, Object instance) throws IOException
    {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw);

        try
        {
            writer.write(gson.toJson(instance));
        }
        finally
        {
            writer.close();
        }
    }
}
