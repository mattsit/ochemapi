
import java.io.IOException;
import java.util.Set;

/* Maven is used to pull in these dependencies. */
import com.google.gson.Gson;
import sun.plugin.viewer.LifeCycleManager;

import javax.swing.*;

import static spark.Spark.*;

public class Server {

    private static Molecule m;
    private static LiF lif;
    private static OCH3 och3;
    private static CH3OH ch3oh;
    private static NaI nai;
    private static Water water;

    private static MoleculePanel waterPanel;

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

        waterPanel = new MoleculePanel(water);
    }

    public static void main(String[] args) throws IOException {
        initialize();
        staticFileLocation("/page");

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "*");
            response.header("Access-Control-Allow-Headers", "*");
        });

        get("/molecule", (request, response) -> {
            Set<String> reqParams = request.queryParams();
            String formula = request.queryParams("formula");
            Gson gson = new Gson();

            int data = 22;
            return gson.toJson(data);
        });

        get("/", (request, response) -> {
            response.redirect("/molecule.html", 301);

            Set<String> reqParams = request.queryParams();
            String formula = request.queryParams("formula");
            Gson gson = new Gson();

            int data = 22;
            return gson.toJson(data);

            //return true;
        });
    }

//    public  getMoleculeReact() {
//
//    }
}
