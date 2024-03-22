package DockerTutorial;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Setup_DockerGrid {

    @BeforeTest
    void startDockerGrid() throws IOException, InterruptedException {
        System.out.println("Start docker compose file");
        Runtime.getRuntime ().exec ("cmd /c start start_dockergrid.bat");
        Thread.sleep (20000);

        //Runtime.getRuntime ().exec ("cmd /c start scale_dockergrid.bat");
        //Thread.sleep (15000);
    }

    @AfterTest
    void stopDockerGrid() throws IOException, InterruptedException {
        System.out.println("Stop docker compose file");
        Runtime.getRuntime ().exec ("cmd /c start stop_dockergrid.bat");
        Thread.sleep (15000);

        Runtime.getRuntime ().exec ("taskkill /f /im cmd.exe");
    }
}
