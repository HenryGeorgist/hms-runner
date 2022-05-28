package usace.wat.plugin.hmsrunner;
import hms.model.Project;
public class hmsrunner  {
    public static final String PluginName = "hmsrunner";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(PluginName + " says hello.");
        //check the args are greater than 1
        if(args.length!=1){
            System.out.println("Did not detect only one argument");
            return;
        }
        //first arg should be a modelpayload check to see it is

        //copy the path to local if not local
        //deseralize to objects (looks like payload format has shifted since the objects were made.)
        ModelPayload payload = ModelPayload.readYaml("/workspaces/hms-runner/example_data/payload.yml")
        //check that the plugin name is correct.
        //compute passing in the event config portion of the model payload
        Project project = Project.open(payload.ModelFilePath());
        project.computeRun(payload.ModelName());
        Hms.shutdownEngine();
    }
}