import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/* Maven is used to pull in these dependencies. */
import com.google.gson.Gson;
import sun.plugin.viewer.LifeCycleManager;


import static spark.Spark.*;
import java.util.Set;

public class Test {
    /* Define any static variables here. Do not define any instance variables of MapServer. */

    private static Molecule m;
    private static LiF lif;
    private static OCH3 och3;
    private static CH3OH ch3oh;
    private static NaI nai;
    private static Water water;

    /**
     * Place any initialization statements that will be run before the server main loop here.
     * Do not place it in the main function. Do not place initialization code anywhere else.
     * This is for testing purposes, and you may fail tests otherwise.
     **/
    public static void initialize() {
        m = new Molecule();
        lif = new LiF();
        och3 = new OCH3();
        ch3oh = new CH3OH();
        nai = new NaI();
        water = new Water();
    }

    public static void main(String[] args) throws IOException {
        initialize();
        staticFileLocation("/page");
        /* Allow for all origin requests (since this is not an authenticated server, we do not
         * care about CSRF).  */
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "*");
            response.header("Access-Control-Allow-Headers", "*");
        });

//        get("/reaction", (request, response) -> {
//
//                });

        /* Define molecule application redirect */
        get("/", (request, response) -> {
            response.redirect("/molecule.html", 301);
            return true;
        });
    }

//    public  getMoleculeReact() {
//
//    }
}
